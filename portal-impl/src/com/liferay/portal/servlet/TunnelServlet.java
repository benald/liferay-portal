/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlThreadLocal;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProtectedClassLoaderObjectInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michael Weisser
 * @author Brian Wing Shun Chan
 */
public class TunnelServlet extends HttpServlet {

	@Override
	public void doPost(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if ((permissionChecker == null) || !permissionChecker.isSignedIn()) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unauthenticated access is forbidden");
			}

			httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);

			return;
		}

		ObjectInputStream ois = null;

		Thread thread = Thread.currentThread();

		try {
			ois = new ProtectedClassLoaderObjectInputStream(
				httpServletRequest.getInputStream(),
				thread.getContextClassLoader());
		}
		catch (IOException ioException) {
			if (_log.isWarnEnabled()) {
				_log.warn(ioException, ioException);
			}

			return;
		}

		Object returnObject = null;

		boolean remoteAccess = AccessControlThreadLocal.isRemoteAccess();

		try {
			AccessControlThreadLocal.setRemoteAccess(true);

			ObjectValuePair<HttpPrincipal, MethodHandler> ovp =
				(ObjectValuePair<HttpPrincipal, MethodHandler>)ois.readObject();

			MethodHandler methodHandler = ovp.getValue();

			if (methodHandler != null) {
				MethodKey methodKey = methodHandler.getMethodKey();

				if (!isValidRequest(methodKey.getDeclaringClass())) {
					return;
				}

				returnObject = methodHandler.invoke();
			}
		}
		catch (InvocationTargetException invocationTargetException) {
			returnObject = invocationTargetException.getCause();

			if (!(returnObject instanceof PortalException)) {
				_log.error(
					invocationTargetException, invocationTargetException);

				if (returnObject != null) {
					Throwable throwable = (Throwable)returnObject;

					returnObject = new SystemException(throwable.getMessage());
				}
				else {
					returnObject = new SystemException();
				}
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}
		finally {
			AccessControlThreadLocal.setRemoteAccess(remoteAccess);
		}

		if (returnObject != null) {
			try (ObjectOutputStream oos = new ObjectOutputStream(
					httpServletResponse.getOutputStream())) {

				oos.writeObject(returnObject);
			}
			catch (IOException ioException) {
				_log.error(ioException, ioException);

				throw ioException;
			}
		}
	}

	@Override
	protected void doGet(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		PortalUtil.sendError(
			HttpServletResponse.SC_NOT_FOUND,
			new IllegalArgumentException("The GET method is not supported"),
			httpServletRequest, httpServletResponse);
	}

	protected boolean isValidRequest(Class<?> clazz) {
		String className = clazz.getName();

		if (className.contains(".service.") &&
			className.endsWith("ServiceUtil") &&
			!className.endsWith("LocalServiceUtil")) {

			return true;
		}

		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(TunnelServlet.class);

}