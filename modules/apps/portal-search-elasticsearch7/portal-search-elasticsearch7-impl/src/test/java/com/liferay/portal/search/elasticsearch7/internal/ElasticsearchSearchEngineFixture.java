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

package com.liferay.portal.search.elasticsearch7.internal;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.search.SearchEngine;
import com.liferay.portal.search.elasticsearch7.configuration.ElasticsearchConfiguration;
import com.liferay.portal.search.elasticsearch7.internal.configuration.ElasticsearchConfigurationWrapper;
import com.liferay.portal.search.elasticsearch7.internal.configuration.OperationModeResolver;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchConnectionFixture;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchConnectionManager;
import com.liferay.portal.search.elasticsearch7.internal.index.CompanyIdIndexNameBuilder;
import com.liferay.portal.search.elasticsearch7.internal.index.CompanyIndexCreator;
import com.liferay.portal.search.elasticsearch7.internal.index.CompanyIndexFactory;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.ElasticsearchEngineAdapterFixture;
import com.liferay.portal.search.engine.adapter.SearchEngineAdapter;
import com.liferay.portal.search.index.IndexNameBuilder;
import com.liferay.portal.search.test.util.search.engine.SearchEngineFixture;

import java.util.Map;
import java.util.Objects;

/**
 * @author Adam Brandizzi
 */
public class ElasticsearchSearchEngineFixture implements SearchEngineFixture {

	public ElasticsearchSearchEngineFixture(
		ElasticsearchConnectionFixture elasticsearchConnectionFixture) {

		_elasticsearchConnectionFixture = elasticsearchConnectionFixture;
	}

	public ElasticsearchConnectionManager getElasticsearchConnectionManager() {
		return _elasticsearchConnectionManager;
	}

	public ElasticsearchSearchEngine getElasticsearchSearchEngine() {
		return _elasticsearchSearchEngine;
	}

	@Override
	public IndexNameBuilder getIndexNameBuilder() {
		return _indexNameBuilder;
	}

	@Override
	public SearchEngine getSearchEngine() {
		return getElasticsearchSearchEngine();
	}

	@Override
	public void setUp() throws Exception {
		ElasticsearchConnectionFixture elasticsearchConnectionFixture =
			Objects.requireNonNull(_elasticsearchConnectionFixture);

		CompanyIdIndexNameBuilder indexNameBuilder = createIndexNameBuilder();

		ElasticsearchConnectionManager elasticsearchConnectionManager =
			createElasticsearchConnectionManager(
				elasticsearchConnectionFixture);

		_elasticsearchConnectionManager = elasticsearchConnectionManager;
		_elasticsearchSearchEngine = createElasticsearchSearchEngine(
			elasticsearchConnectionFixture, elasticsearchConnectionManager,
			indexNameBuilder,
			elasticsearchConnectionFixture.
				getElasticsearchConfigurationProperties());

		_indexNameBuilder = indexNameBuilder;
	}

	@Override
	public void tearDown() throws Exception {
		_elasticsearchConnectionFixture.destroyNode();
	}

	protected static CompanyIndexCreator createCompanyIndexCreator(
		ElasticsearchConnectionManager elasticsearchConnectionManager1,
		IndexNameBuilder indexNameBuilder, Map<String, Object> properites) {

		return new CompanyIndexCreator() {
			{
				elasticsearchConnectionManager =
					elasticsearchConnectionManager1;
				indexFactory = createCompanyIndexFactory(
					indexNameBuilder, properites);
			}
		};
	}

	protected static CompanyIndexFactory createCompanyIndexFactory(
		IndexNameBuilder indexNameBuilder, Map<String, Object> properites) {

		return new CompanyIndexFactory() {
			{
				setElasticsearchConfigurationWrapper(
					createElasticsearchConfigurationWrapper(properites));
				setIndexNameBuilder(indexNameBuilder);
				setJsonFactory(new JSONFactoryImpl());
			}
		};
	}

	protected static ElasticsearchConfigurationWrapper
		createElasticsearchConfigurationWrapper(
			Map<String, Object> properites) {

		return new ElasticsearchConfigurationWrapper() {
			{
				elasticsearchConfiguration =
					ConfigurableUtil.createConfigurable(
						ElasticsearchConfiguration.class, properites);
			}
		};
	}

	protected static ElasticsearchConnectionManager
		createElasticsearchConnectionManager(
			ElasticsearchConnectionFixture elasticsearchConnectionFixture) {

		return new ElasticsearchConnectionManager() {
			{
				elasticsearchConfigurationWrapper =
					createElasticsearchConfigurationWrapper(
						elasticsearchConnectionFixture.
							getElasticsearchConfigurationProperties());

				operationModeResolver = createOperationModeResolver(
					elasticsearchConfigurationWrapper);

				addElasticsearchConnection(
					elasticsearchConnectionFixture.
						createElasticsearchConnection());
			}
		};
	}

	protected static ElasticsearchSearchEngine createElasticsearchSearchEngine(
		ElasticsearchClientResolver elasticsearchClientResolver,
		ElasticsearchConnectionManager elasticsearchConnectionManager,
		IndexNameBuilder indexNameBuilder, Map<String, Object> properites) {

		return new ElasticsearchSearchEngine() {
			{
				setCompanyIndexCreator(
					createCompanyIndexCreator(
						elasticsearchConnectionManager, indexNameBuilder,
						properites));
				setElasticsearchConnectionManager(
					elasticsearchConnectionManager);
				setIndexFactory(
					createCompanyIndexFactory(indexNameBuilder, properites));
				setIndexNameBuilder(String::valueOf);
				setSearchEngineAdapter(
					createSearchEngineAdapter(elasticsearchClientResolver));
			}
		};
	}

	protected static CompanyIdIndexNameBuilder createIndexNameBuilder() {
		return new CompanyIdIndexNameBuilder() {
			{
				setIndexNamePrefix(null);
			}
		};
	}

	protected static OperationModeResolver createOperationModeResolver(
		ElasticsearchConfigurationWrapper elasticsearchConfigurationWrapper1) {

		return new OperationModeResolver() {
			{
				elasticsearchConfigurationWrapper =
					elasticsearchConfigurationWrapper1;
			}
		};
	}

	protected static SearchEngineAdapter createSearchEngineAdapter(
		ElasticsearchClientResolver elasticsearchClientResolver) {

		ElasticsearchEngineAdapterFixture elasticsearchEngineAdapterFixture =
			new ElasticsearchEngineAdapterFixture() {
				{
					setElasticsearchClientResolver(elasticsearchClientResolver);
				}
			};

		elasticsearchEngineAdapterFixture.setUp();

		return elasticsearchEngineAdapterFixture.getSearchEngineAdapter();
	}

	private final ElasticsearchConnectionFixture
		_elasticsearchConnectionFixture;
	private ElasticsearchConnectionManager _elasticsearchConnectionManager;
	private ElasticsearchSearchEngine _elasticsearchSearchEngine;
	private IndexNameBuilder _indexNameBuilder;

}