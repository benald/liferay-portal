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

import {useMutation, useQuery} from '@apollo/client';
import {ClayButtonWithIcon} from '@clayui/button';
import {ClayDropDownWithItems} from '@clayui/drop-down';
import ClayEmptyState from '@clayui/empty-state';
import React, {useEffect, useState} from 'react';
import {withRouter} from 'react-router-dom';

import Alert from '../../components/Alert.es';
import DeleteThread from '../../components/DeleteThread.es';
import QuestionRow from '../../components/QuestionRow.es';
import {
	client,
	getSubscriptionsQuery,
	unsubscribeMyUserAccountQuery,
} from '../../utils/client.es';
import {historyPushWithSlug} from '../../utils/utils.es';
import NavigationBar from '../NavigationBar.es';

export default withRouter(({history}) => {
	const [entity, setEntity] = useState({});
	const [info, setInfo] = useState({});

	const {data: threads, refetch: refetchThreads} = useQuery(
		getSubscriptionsQuery,
		{
			fetchPolicy: 'network-only',
			variables: {
				contentType: 'MessageBoardThread',
			},
		}
	);

	const {data: topics, refetch: refetchTopics} = useQuery(
		getSubscriptionsQuery,
		{
			fetchPolicy: 'network-only',
			variables: {
				contentType: 'MessageBoardSection',
			},
		}
	);

	const [unsubscribe] = useMutation(unsubscribeMyUserAccountQuery, {
		onCompleted() {
			refetchThreads();
			refetchTopics();
			setInfo({
				title: 'You have unsubscribed from this asset successfully.',
			});
		},
	});

	useEffect(() => {
		if (entity.title) {
			client.cache.evict(`MessageBoardSection:${entity.id}`);
		}
		else {
			client.cache.evict(`MessageBoardThread:${entity.id}`);
		}
		client.cache.gc();
	}, [entity]);

	const [showDeleteModalPanel, setShowDeleteModalPanel] = useState(false);

	const historyPushParser = historyPushWithSlug(history.push);

	const navigate = (data) => {
		historyPushParser(`/questions/${data.graphQLNode.title}`);
	};

	const actions = (data) => {
		const question = data.graphQLNode;

		const actions = [
			{
				label: 'Unsubscribe',
				onClick: () => {
					setEntity({...data.graphQLNode});
					unsubscribe({
						variables: {
							subscriptionId: data.id,
						},
					});
				},
			},
		];

		if (question.actions && question.actions.delete) {
			actions.push({
				label: 'Delete',
				onClick: () => {
					setShowDeleteModalPanel(true);
				},
			});
		}

		if (question.actions && question.actions.replace) {
			actions.push({
				label: 'Edit',
				onClick: () => {
					historyPushParser(
						`/questions/${question.messageBoardSection.title}/${data.graphQLNode.friendlyUrlPath}/edit`
					);
				},
			});
		}

		if (question.headline) {
			actions.push({
				label: 'Reply',
				onClick: () => {
					historyPushParser(
						`/questions/${question.messageBoardSection.title}/${question.friendlyUrlPath}`
					);
				},
			});
		}

		return actions;
	};

	return (
		<>
			<NavigationBar />
			<section className="questions-section questions-section-list">
				<div className="c-p-5 questions-container row">
					<div className="col-xl-8 offset-xl-2">
						<h2 className="sheet-subtitle">Topics</h2>
						<Topics />
						<h2 className="mt-5 sheet-subtitle">Questions</h2>
						<Questions />
					</div>
				</div>
				<Alert displayType={'success'} info={info} />
			</section>
		</>
	);

	function Topics() {
		return (
			<>
				{topics &&
					topics.myUserAccountSubscriptions.items &&
					!topics.myUserAccountSubscriptions.items.length && (
						<ClayEmptyState
							title={Liferay.Language.get('there-are-no-results')}
						/>
					)}
				<div className="row">
					{topics &&
						topics.myUserAccountSubscriptions.items &&
						topics.myUserAccountSubscriptions.items.map((data) => (
							<div
								className="col-md-4 question-tags"
								key={data.graphQLNode.id}
							>
								<div className="card card-interactive card-interactive-primary card-type-template template-card-horizontal">
									<div className="card-body">
										<div className="card-row">
											<div
												className="autofit-col autofit-col-expand"
												onClick={() => navigate(data)}
											>
												<div className="autofit-section">
													<div className="card-title">
														<span className="text-truncate">
															{
																data.graphQLNode
																	.title
															}
														</span>
													</div>
												</div>
											</div>
											<div className="autofit-col">
												<ClayDropDownWithItems
													items={actions(data)}
													trigger={
														<ClayButtonWithIcon
															displayType="unstyled"
															small
															symbol="ellipsis-v"
														/>
													}
												/>
											</div>
										</div>
									</div>
								</div>
							</div>
						))}
				</div>
			</>
		);
	}

	function Questions() {
		return (
			<div>
				{threads &&
					threads.myUserAccountSubscriptions.items &&
					!threads.myUserAccountSubscriptions.items.length && (
						<ClayEmptyState
							title={Liferay.Language.get('there-are-no-results')}
						/>
					)}
				{threads &&
					threads.myUserAccountSubscriptions.items &&
					threads.myUserAccountSubscriptions.items.map((data) => (
						<>
							<QuestionRow
								items={actions(data)}
								key={data.id}
								question={data.graphQLNode}
								showSectionLabel={true}
							/>
							<DeleteThread
								question={data.graphQLNode}
								showDeleteModalPanel={showDeleteModalPanel}
							/>
						</>
					))}
			</div>
		);
	}
});
