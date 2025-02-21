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

package com.liferay.message.boards.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MBCategory. This utility wraps
 * <code>com.liferay.message.boards.service.impl.MBCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MBCategoryLocalService
 * @generated
 */
public class MBCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.message.boards.service.impl.MBCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.message.boards.model.MBCategory addCategory(
			long userId, long parentCategoryId, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCategory(
			userId, parentCategoryId, name, description, serviceContext);
	}

	public static com.liferay.message.boards.model.MBCategory addCategory(
			long userId, long parentCategoryId, String name, String description,
			String displayStyle, String emailAddress, String inProtocol,
			String inServerName, int inServerPort, boolean inUseSSL,
			String inUserName, String inPassword, int inReadInterval,
			String outEmailAddress, boolean outCustom, String outServerName,
			int outServerPort, boolean outUseSSL, String outUserName,
			String outPassword, boolean allowAnonymous,
			boolean mailingListActive,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCategory(
			userId, parentCategoryId, name, description, displayStyle,
			emailAddress, inProtocol, inServerName, inServerPort, inUseSSL,
			inUserName, inPassword, inReadInterval, outEmailAddress, outCustom,
			outServerName, outServerPort, outUseSSL, outUserName, outPassword,
			allowAnonymous, mailingListActive, serviceContext);
	}

	public static void addCategoryResources(
			long categoryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addCategoryResources(
			categoryId, addGroupPermissions, addGuestPermissions);
	}

	public static void addCategoryResources(
			long categoryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addCategoryResources(categoryId, modelPermissions);
	}

	public static void addCategoryResources(
			com.liferay.message.boards.model.MBCategory category,
			boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addCategoryResources(
			category, addGroupPermissions, addGuestPermissions);
	}

	public static void addCategoryResources(
			com.liferay.message.boards.model.MBCategory category,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addCategoryResources(category, modelPermissions);
	}

	/**
	 * Adds the message boards category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mbCategory the message boards category
	 * @return the message boards category that was added
	 */
	public static com.liferay.message.boards.model.MBCategory addMBCategory(
		com.liferay.message.boards.model.MBCategory mbCategory) {

		return getService().addMBCategory(mbCategory);
	}

	/**
	 * Creates a new message boards category with the primary key. Does not add the message boards category to the database.
	 *
	 * @param categoryId the primary key for the new message boards category
	 * @return the new message boards category
	 */
	public static com.liferay.message.boards.model.MBCategory createMBCategory(
		long categoryId) {

		return getService().createMBCategory(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteCategories(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCategories(groupId);
	}

	public static void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCategory(categoryId);
	}

	public static void deleteCategory(
			com.liferay.message.boards.model.MBCategory category)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCategory(category);
	}

	public static void deleteCategory(
			com.liferay.message.boards.model.MBCategory category,
			boolean includeTrashedEntries)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteCategory(category, includeTrashedEntries);
	}

	/**
	 * Deletes the message boards category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the message boards category
	 * @return the message boards category that was removed
	 * @throws PortalException if a message boards category with the primary key could not be found
	 */
	public static com.liferay.message.boards.model.MBCategory deleteMBCategory(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMBCategory(categoryId);
	}

	/**
	 * Deletes the message boards category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mbCategory the message boards category
	 * @return the message boards category that was removed
	 */
	public static com.liferay.message.boards.model.MBCategory deleteMBCategory(
		com.liferay.message.boards.model.MBCategory mbCategory) {

		return getService().deleteMBCategory(mbCategory);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return getService().dslQuery(dslQuery);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.message.boards.model.impl.MBCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.message.boards.model.impl.MBCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.message.boards.model.MBCategory fetchMBCategory(
		long categoryId) {

		return getService().fetchMBCategory(categoryId);
	}

	/**
	 * Returns the message boards category matching the UUID and group.
	 *
	 * @param uuid the message boards category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching message boards category, or <code>null</code> if a matching message boards category could not be found
	 */
	public static com.liferay.message.boards.model.MBCategory
		fetchMBCategoryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchMBCategoryByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(long groupId) {

		return getService().getCategories(groupId);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(long groupId, int status) {

		return getService().getCategories(groupId, status);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(long groupId, long parentCategoryId, int start, int end) {

		return getService().getCategories(
			groupId, parentCategoryId, start, end);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(
			long groupId, long parentCategoryId, int status, int start,
			int end) {

		return getService().getCategories(
			groupId, parentCategoryId, status, start, end);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(
			long groupId, long excludedCategoryId, long parentCategoryId,
			int status, int start, int end) {

		return getService().getCategories(
			groupId, excludedCategoryId, parentCategoryId, status, start, end);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(
			long groupId, long[] parentCategoryIds, int start, int end) {

		return getService().getCategories(
			groupId, parentCategoryIds, start, end);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(
			long groupId, long[] parentCategoryIds, int status, int start,
			int end) {

		return getService().getCategories(
			groupId, parentCategoryIds, status, start, end);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCategories(
			long groupId, long[] excludedCategoryIds, long[] parentCategoryIds,
			int status, int start, int end) {

		return getService().getCategories(
			groupId, excludedCategoryIds, parentCategoryIds, status, start,
			end);
	}

	public static java.util.List<Object> getCategoriesAndThreads(
		long groupId, long categoryId) {

		return getService().getCategoriesAndThreads(groupId, categoryId);
	}

	public static java.util.List<Object> getCategoriesAndThreads(
		long groupId, long categoryId, int status) {

		return getService().getCategoriesAndThreads(
			groupId, categoryId, status);
	}

	public static java.util.List<Object> getCategoriesAndThreads(
		long groupId, long categoryId, int status, int start, int end) {

		return getService().getCategoriesAndThreads(
			groupId, categoryId, status, start, end);
	}

	public static int getCategoriesAndThreadsCount(
		long groupId, long categoryId) {

		return getService().getCategoriesAndThreadsCount(groupId, categoryId);
	}

	public static int getCategoriesAndThreadsCount(
		long groupId, long categoryId, int status) {

		return getService().getCategoriesAndThreadsCount(
			groupId, categoryId, status);
	}

	public static int getCategoriesCount(long groupId) {
		return getService().getCategoriesCount(groupId);
	}

	public static int getCategoriesCount(long groupId, int status) {
		return getService().getCategoriesCount(groupId, status);
	}

	public static int getCategoriesCount(long groupId, long parentCategoryId) {
		return getService().getCategoriesCount(groupId, parentCategoryId);
	}

	public static int getCategoriesCount(
		long groupId, long parentCategoryId, int status) {

		return getService().getCategoriesCount(
			groupId, parentCategoryId, status);
	}

	public static int getCategoriesCount(
		long groupId, long excludedCategoryId, long parentCategoryId,
		int status) {

		return getService().getCategoriesCount(
			groupId, excludedCategoryId, parentCategoryId, status);
	}

	public static int getCategoriesCount(
		long groupId, long[] parentCategoryIds) {

		return getService().getCategoriesCount(groupId, parentCategoryIds);
	}

	public static int getCategoriesCount(
		long groupId, long[] parentCategoryIds, int status) {

		return getService().getCategoriesCount(
			groupId, parentCategoryIds, status);
	}

	public static int getCategoriesCount(
		long groupId, long[] excludedCategoryIds, long[] parentCategoryIds,
		int status) {

		return getService().getCategoriesCount(
			groupId, excludedCategoryIds, parentCategoryIds, status);
	}

	public static com.liferay.message.boards.model.MBCategory getCategory(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCategory(categoryId);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getCompanyCategories(long companyId, int start, int end) {

		return getService().getCompanyCategories(companyId, start, end);
	}

	public static int getCompanyCategoriesCount(long companyId) {
		return getService().getCompanyCategoriesCount(companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the message boards categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.message.boards.model.impl.MBCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of message boards categories
	 * @param end the upper bound of the range of message boards categories (not inclusive)
	 * @return the range of message boards categories
	 */
	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getMBCategories(int start, int end) {

		return getService().getMBCategories(start, end);
	}

	/**
	 * Returns all the message boards categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the message boards categories
	 * @param companyId the primary key of the company
	 * @return the matching message boards categories, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getMBCategoriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getMBCategoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of message boards categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the message boards categories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of message boards categories
	 * @param end the upper bound of the range of message boards categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching message boards categories, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getMBCategoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.message.boards.model.MBCategory>
					orderByComparator) {

		return getService().getMBCategoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of message boards categories.
	 *
	 * @return the number of message boards categories
	 */
	public static int getMBCategoriesCount() {
		return getService().getMBCategoriesCount();
	}

	/**
	 * Returns the message boards category with the primary key.
	 *
	 * @param categoryId the primary key of the message boards category
	 * @return the message boards category
	 * @throws PortalException if a message boards category with the primary key could not be found
	 */
	public static com.liferay.message.boards.model.MBCategory getMBCategory(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMBCategory(categoryId);
	}

	/**
	 * Returns the message boards category matching the UUID and group.
	 *
	 * @param uuid the message boards category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching message boards category
	 * @throws PortalException if a matching message boards category could not be found
	 */
	public static com.liferay.message.boards.model.MBCategory
			getMBCategoryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMBCategoryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<Long> getSubcategoryIds(
		java.util.List<Long> categoryIds, long groupId, long categoryId) {

		return getService().getSubcategoryIds(categoryIds, groupId, categoryId);
	}

	public static java.util.List<com.liferay.message.boards.model.MBCategory>
		getSubscribedCategories(long groupId, long userId, int start, int end) {

		return getService().getSubscribedCategories(
			groupId, userId, start, end);
	}

	public static int getSubscribedCategoriesCount(long groupId, long userId) {
		return getService().getSubscribedCategoriesCount(groupId, userId);
	}

	public static void moveCategoriesToTrash(long groupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().moveCategoriesToTrash(groupId, userId);
	}

	public static com.liferay.message.boards.model.MBCategory moveCategory(
			long categoryId, long parentCategoryId,
			boolean mergeWithParentCategory)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveCategory(
			categoryId, parentCategoryId, mergeWithParentCategory);
	}

	public static com.liferay.message.boards.model.MBCategory
			moveCategoryFromTrash(
				long userId, long categoryId, long newCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveCategoryFromTrash(
			userId, categoryId, newCategoryId);
	}

	public static com.liferay.message.boards.model.MBCategory
			moveCategoryToTrash(long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveCategoryToTrash(userId, categoryId);
	}

	public static void restoreCategoryFromTrash(long userId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().restoreCategoryFromTrash(userId, categoryId);
	}

	public static void subscribeCategory(
			long userId, long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().subscribeCategory(userId, groupId, categoryId);
	}

	public static void unsubscribeCategory(
			long userId, long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().unsubscribeCategory(userId, groupId, categoryId);
	}

	public static com.liferay.message.boards.model.MBCategory updateCategory(
			long categoryId, long parentCategoryId, String name,
			String description, String displayStyle, String emailAddress,
			String inProtocol, String inServerName, int inServerPort,
			boolean inUseSSL, String inUserName, String inPassword,
			int inReadInterval, String outEmailAddress, boolean outCustom,
			String outServerName, int outServerPort, boolean outUseSSL,
			String outUserName, String outPassword, boolean allowAnonymous,
			boolean mailingListActive, boolean mergeWithParentCategory,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCategory(
			categoryId, parentCategoryId, name, description, displayStyle,
			emailAddress, inProtocol, inServerName, inServerPort, inUseSSL,
			inUserName, inPassword, inReadInterval, outEmailAddress, outCustom,
			outServerName, outServerPort, outUseSSL, outUserName, outPassword,
			allowAnonymous, mailingListActive, mergeWithParentCategory,
			serviceContext);
	}

	/**
	 * Updates the message boards category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mbCategory the message boards category
	 * @return the message boards category that was updated
	 */
	public static com.liferay.message.boards.model.MBCategory updateMBCategory(
		com.liferay.message.boards.model.MBCategory mbCategory) {

		return getService().updateMBCategory(mbCategory);
	}

	public static com.liferay.message.boards.model.MBCategory updateStatus(
			long userId, long categoryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(userId, categoryId, status);
	}

	public static MBCategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MBCategoryLocalService, MBCategoryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MBCategoryLocalService.class);

		ServiceTracker<MBCategoryLocalService, MBCategoryLocalService>
			serviceTracker =
				new ServiceTracker
					<MBCategoryLocalService, MBCategoryLocalService>(
						bundle.getBundleContext(), MBCategoryLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}