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

package com.crowd.funding.database.service.base;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.PostionRegistration;
import com.crowd.funding.database.service.PostionRegistrationLocalService;
import com.crowd.funding.database.service.persistence.BenificiaryRegistrationPersistence;
import com.crowd.funding.database.service.persistence.CandidateRegistrationPersistence;
import com.crowd.funding.database.service.persistence.CommentRegistrationPersistence;
import com.crowd.funding.database.service.persistence.DocumentRegistrationPersistence;
import com.crowd.funding.database.service.persistence.DonorRegistrationPersistence;
import com.crowd.funding.database.service.persistence.DynamicFeesRegistrationPersistence;
import com.crowd.funding.database.service.persistence.FeedbackRegistrationPersistence;
import com.crowd.funding.database.service.persistence.FundAccountRegistrationPersistence;
import com.crowd.funding.database.service.persistence.FundRegistrationPersistence;
import com.crowd.funding.database.service.persistence.FundReleaseRegistrationPersistence;
import com.crowd.funding.database.service.persistence.HistoryLogRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ImageRegistrationPersistence;
import com.crowd.funding.database.service.persistence.NewsLetterRegistrationPersistence;
import com.crowd.funding.database.service.persistence.PostionRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectAcknowledgementRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectExtentionRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectFeesRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectFollowerRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectPriorityRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectRegistrationFinder;
import com.crowd.funding.database.service.persistence.ProjectRegistrationPersistence;
import com.crowd.funding.database.service.persistence.ProjectUpdateRegistrationPersistence;
import com.crowd.funding.database.service.persistence.QuestionRegistrationPersistence;
import com.crowd.funding.database.service.persistence.SubscriptionRegistrationPersistence;
import com.crowd.funding.database.service.persistence.UpdateRequesterRegistrationPersistence;
import com.crowd.funding.database.service.persistence.UserFollowRegistrationPersistence;
import com.crowd.funding.database.service.persistence.UserOTPRegistrationPersistence;
import com.crowd.funding.database.service.persistence.UserRegistrationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the postion registration local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.crowd.funding.database.service.impl.PostionRegistrationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.impl.PostionRegistrationLocalServiceImpl
 * @see com.crowd.funding.database.service.PostionRegistrationLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class PostionRegistrationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements PostionRegistrationLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.crowd.funding.database.service.PostionRegistrationLocalServiceUtil} to access the postion registration local service.
	 */

	/**
	 * Adds the postion registration to the database. Also notifies the appropriate model listeners.
	 *
	 * @param postionRegistration the postion registration
	 * @return the postion registration that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PostionRegistration addPostionRegistration(
		PostionRegistration postionRegistration) {
		postionRegistration.setNew(true);

		return postionRegistrationPersistence.update(postionRegistration);
	}

	/**
	 * Creates a new postion registration with the primary key. Does not add the postion registration to the database.
	 *
	 * @param POSITION_ID the primary key for the new postion registration
	 * @return the new postion registration
	 */
	@Override
	@Transactional(enabled = false)
	public PostionRegistration createPostionRegistration(long POSITION_ID) {
		return postionRegistrationPersistence.create(POSITION_ID);
	}

	/**
	 * Deletes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param POSITION_ID the primary key of the postion registration
	 * @return the postion registration that was removed
	 * @throws PortalException if a postion registration with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PostionRegistration deletePostionRegistration(long POSITION_ID)
		throws PortalException {
		return postionRegistrationPersistence.remove(POSITION_ID);
	}

	/**
	 * Deletes the postion registration from the database. Also notifies the appropriate model listeners.
	 *
	 * @param postionRegistration the postion registration
	 * @return the postion registration that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PostionRegistration deletePostionRegistration(
		PostionRegistration postionRegistration) {
		return postionRegistrationPersistence.remove(postionRegistration);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(PostionRegistration.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return postionRegistrationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return postionRegistrationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return postionRegistrationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return postionRegistrationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return postionRegistrationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public PostionRegistration fetchPostionRegistration(long POSITION_ID) {
		return postionRegistrationPersistence.fetchByPrimaryKey(POSITION_ID);
	}

	/**
	 * Returns the postion registration with the primary key.
	 *
	 * @param POSITION_ID the primary key of the postion registration
	 * @return the postion registration
	 * @throws PortalException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration getPostionRegistration(long POSITION_ID)
		throws PortalException {
		return postionRegistrationPersistence.findByPrimaryKey(POSITION_ID);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(postionRegistrationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PostionRegistration.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("POSITION_ID");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(postionRegistrationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(PostionRegistration.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("POSITION_ID");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(postionRegistrationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PostionRegistration.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("POSITION_ID");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return postionRegistrationLocalService.deletePostionRegistration((PostionRegistration)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return postionRegistrationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the postion registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of postion registrations
	 * @param end the upper bound of the range of postion registrations (not inclusive)
	 * @return the range of postion registrations
	 */
	@Override
	public List<PostionRegistration> getPostionRegistrations(int start, int end) {
		return postionRegistrationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of postion registrations.
	 *
	 * @return the number of postion registrations
	 */
	@Override
	public int getPostionRegistrationsCount() {
		return postionRegistrationPersistence.countAll();
	}

	/**
	 * Updates the postion registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param postionRegistration the postion registration
	 * @return the postion registration that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PostionRegistration updatePostionRegistration(
		PostionRegistration postionRegistration) {
		return postionRegistrationPersistence.update(postionRegistration);
	}

	/**
	 * Returns the benificiary registration local service.
	 *
	 * @return the benificiary registration local service
	 */
	public com.crowd.funding.database.service.BenificiaryRegistrationLocalService getBenificiaryRegistrationLocalService() {
		return benificiaryRegistrationLocalService;
	}

	/**
	 * Sets the benificiary registration local service.
	 *
	 * @param benificiaryRegistrationLocalService the benificiary registration local service
	 */
	public void setBenificiaryRegistrationLocalService(
		com.crowd.funding.database.service.BenificiaryRegistrationLocalService benificiaryRegistrationLocalService) {
		this.benificiaryRegistrationLocalService = benificiaryRegistrationLocalService;
	}

	/**
	 * Returns the benificiary registration persistence.
	 *
	 * @return the benificiary registration persistence
	 */
	public BenificiaryRegistrationPersistence getBenificiaryRegistrationPersistence() {
		return benificiaryRegistrationPersistence;
	}

	/**
	 * Sets the benificiary registration persistence.
	 *
	 * @param benificiaryRegistrationPersistence the benificiary registration persistence
	 */
	public void setBenificiaryRegistrationPersistence(
		BenificiaryRegistrationPersistence benificiaryRegistrationPersistence) {
		this.benificiaryRegistrationPersistence = benificiaryRegistrationPersistence;
	}

	/**
	 * Returns the candidate registration local service.
	 *
	 * @return the candidate registration local service
	 */
	public com.crowd.funding.database.service.CandidateRegistrationLocalService getCandidateRegistrationLocalService() {
		return candidateRegistrationLocalService;
	}

	/**
	 * Sets the candidate registration local service.
	 *
	 * @param candidateRegistrationLocalService the candidate registration local service
	 */
	public void setCandidateRegistrationLocalService(
		com.crowd.funding.database.service.CandidateRegistrationLocalService candidateRegistrationLocalService) {
		this.candidateRegistrationLocalService = candidateRegistrationLocalService;
	}

	/**
	 * Returns the candidate registration persistence.
	 *
	 * @return the candidate registration persistence
	 */
	public CandidateRegistrationPersistence getCandidateRegistrationPersistence() {
		return candidateRegistrationPersistence;
	}

	/**
	 * Sets the candidate registration persistence.
	 *
	 * @param candidateRegistrationPersistence the candidate registration persistence
	 */
	public void setCandidateRegistrationPersistence(
		CandidateRegistrationPersistence candidateRegistrationPersistence) {
		this.candidateRegistrationPersistence = candidateRegistrationPersistence;
	}

	/**
	 * Returns the comment registration local service.
	 *
	 * @return the comment registration local service
	 */
	public com.crowd.funding.database.service.CommentRegistrationLocalService getCommentRegistrationLocalService() {
		return commentRegistrationLocalService;
	}

	/**
	 * Sets the comment registration local service.
	 *
	 * @param commentRegistrationLocalService the comment registration local service
	 */
	public void setCommentRegistrationLocalService(
		com.crowd.funding.database.service.CommentRegistrationLocalService commentRegistrationLocalService) {
		this.commentRegistrationLocalService = commentRegistrationLocalService;
	}

	/**
	 * Returns the comment registration persistence.
	 *
	 * @return the comment registration persistence
	 */
	public CommentRegistrationPersistence getCommentRegistrationPersistence() {
		return commentRegistrationPersistence;
	}

	/**
	 * Sets the comment registration persistence.
	 *
	 * @param commentRegistrationPersistence the comment registration persistence
	 */
	public void setCommentRegistrationPersistence(
		CommentRegistrationPersistence commentRegistrationPersistence) {
		this.commentRegistrationPersistence = commentRegistrationPersistence;
	}

	/**
	 * Returns the document registration local service.
	 *
	 * @return the document registration local service
	 */
	public com.crowd.funding.database.service.DocumentRegistrationLocalService getDocumentRegistrationLocalService() {
		return documentRegistrationLocalService;
	}

	/**
	 * Sets the document registration local service.
	 *
	 * @param documentRegistrationLocalService the document registration local service
	 */
	public void setDocumentRegistrationLocalService(
		com.crowd.funding.database.service.DocumentRegistrationLocalService documentRegistrationLocalService) {
		this.documentRegistrationLocalService = documentRegistrationLocalService;
	}

	/**
	 * Returns the document registration persistence.
	 *
	 * @return the document registration persistence
	 */
	public DocumentRegistrationPersistence getDocumentRegistrationPersistence() {
		return documentRegistrationPersistence;
	}

	/**
	 * Sets the document registration persistence.
	 *
	 * @param documentRegistrationPersistence the document registration persistence
	 */
	public void setDocumentRegistrationPersistence(
		DocumentRegistrationPersistence documentRegistrationPersistence) {
		this.documentRegistrationPersistence = documentRegistrationPersistence;
	}

	/**
	 * Returns the donor registration local service.
	 *
	 * @return the donor registration local service
	 */
	public com.crowd.funding.database.service.DonorRegistrationLocalService getDonorRegistrationLocalService() {
		return donorRegistrationLocalService;
	}

	/**
	 * Sets the donor registration local service.
	 *
	 * @param donorRegistrationLocalService the donor registration local service
	 */
	public void setDonorRegistrationLocalService(
		com.crowd.funding.database.service.DonorRegistrationLocalService donorRegistrationLocalService) {
		this.donorRegistrationLocalService = donorRegistrationLocalService;
	}

	/**
	 * Returns the donor registration persistence.
	 *
	 * @return the donor registration persistence
	 */
	public DonorRegistrationPersistence getDonorRegistrationPersistence() {
		return donorRegistrationPersistence;
	}

	/**
	 * Sets the donor registration persistence.
	 *
	 * @param donorRegistrationPersistence the donor registration persistence
	 */
	public void setDonorRegistrationPersistence(
		DonorRegistrationPersistence donorRegistrationPersistence) {
		this.donorRegistrationPersistence = donorRegistrationPersistence;
	}

	/**
	 * Returns the dynamic fees registration local service.
	 *
	 * @return the dynamic fees registration local service
	 */
	public com.crowd.funding.database.service.DynamicFeesRegistrationLocalService getDynamicFeesRegistrationLocalService() {
		return dynamicFeesRegistrationLocalService;
	}

	/**
	 * Sets the dynamic fees registration local service.
	 *
	 * @param dynamicFeesRegistrationLocalService the dynamic fees registration local service
	 */
	public void setDynamicFeesRegistrationLocalService(
		com.crowd.funding.database.service.DynamicFeesRegistrationLocalService dynamicFeesRegistrationLocalService) {
		this.dynamicFeesRegistrationLocalService = dynamicFeesRegistrationLocalService;
	}

	/**
	 * Returns the dynamic fees registration persistence.
	 *
	 * @return the dynamic fees registration persistence
	 */
	public DynamicFeesRegistrationPersistence getDynamicFeesRegistrationPersistence() {
		return dynamicFeesRegistrationPersistence;
	}

	/**
	 * Sets the dynamic fees registration persistence.
	 *
	 * @param dynamicFeesRegistrationPersistence the dynamic fees registration persistence
	 */
	public void setDynamicFeesRegistrationPersistence(
		DynamicFeesRegistrationPersistence dynamicFeesRegistrationPersistence) {
		this.dynamicFeesRegistrationPersistence = dynamicFeesRegistrationPersistence;
	}

	/**
	 * Returns the feedback registration local service.
	 *
	 * @return the feedback registration local service
	 */
	public com.crowd.funding.database.service.FeedbackRegistrationLocalService getFeedbackRegistrationLocalService() {
		return feedbackRegistrationLocalService;
	}

	/**
	 * Sets the feedback registration local service.
	 *
	 * @param feedbackRegistrationLocalService the feedback registration local service
	 */
	public void setFeedbackRegistrationLocalService(
		com.crowd.funding.database.service.FeedbackRegistrationLocalService feedbackRegistrationLocalService) {
		this.feedbackRegistrationLocalService = feedbackRegistrationLocalService;
	}

	/**
	 * Returns the feedback registration persistence.
	 *
	 * @return the feedback registration persistence
	 */
	public FeedbackRegistrationPersistence getFeedbackRegistrationPersistence() {
		return feedbackRegistrationPersistence;
	}

	/**
	 * Sets the feedback registration persistence.
	 *
	 * @param feedbackRegistrationPersistence the feedback registration persistence
	 */
	public void setFeedbackRegistrationPersistence(
		FeedbackRegistrationPersistence feedbackRegistrationPersistence) {
		this.feedbackRegistrationPersistence = feedbackRegistrationPersistence;
	}

	/**
	 * Returns the fund account registration local service.
	 *
	 * @return the fund account registration local service
	 */
	public com.crowd.funding.database.service.FundAccountRegistrationLocalService getFundAccountRegistrationLocalService() {
		return fundAccountRegistrationLocalService;
	}

	/**
	 * Sets the fund account registration local service.
	 *
	 * @param fundAccountRegistrationLocalService the fund account registration local service
	 */
	public void setFundAccountRegistrationLocalService(
		com.crowd.funding.database.service.FundAccountRegistrationLocalService fundAccountRegistrationLocalService) {
		this.fundAccountRegistrationLocalService = fundAccountRegistrationLocalService;
	}

	/**
	 * Returns the fund account registration persistence.
	 *
	 * @return the fund account registration persistence
	 */
	public FundAccountRegistrationPersistence getFundAccountRegistrationPersistence() {
		return fundAccountRegistrationPersistence;
	}

	/**
	 * Sets the fund account registration persistence.
	 *
	 * @param fundAccountRegistrationPersistence the fund account registration persistence
	 */
	public void setFundAccountRegistrationPersistence(
		FundAccountRegistrationPersistence fundAccountRegistrationPersistence) {
		this.fundAccountRegistrationPersistence = fundAccountRegistrationPersistence;
	}

	/**
	 * Returns the fund registration local service.
	 *
	 * @return the fund registration local service
	 */
	public com.crowd.funding.database.service.FundRegistrationLocalService getFundRegistrationLocalService() {
		return fundRegistrationLocalService;
	}

	/**
	 * Sets the fund registration local service.
	 *
	 * @param fundRegistrationLocalService the fund registration local service
	 */
	public void setFundRegistrationLocalService(
		com.crowd.funding.database.service.FundRegistrationLocalService fundRegistrationLocalService) {
		this.fundRegistrationLocalService = fundRegistrationLocalService;
	}

	/**
	 * Returns the fund registration persistence.
	 *
	 * @return the fund registration persistence
	 */
	public FundRegistrationPersistence getFundRegistrationPersistence() {
		return fundRegistrationPersistence;
	}

	/**
	 * Sets the fund registration persistence.
	 *
	 * @param fundRegistrationPersistence the fund registration persistence
	 */
	public void setFundRegistrationPersistence(
		FundRegistrationPersistence fundRegistrationPersistence) {
		this.fundRegistrationPersistence = fundRegistrationPersistence;
	}

	/**
	 * Returns the fund release registration local service.
	 *
	 * @return the fund release registration local service
	 */
	public com.crowd.funding.database.service.FundReleaseRegistrationLocalService getFundReleaseRegistrationLocalService() {
		return fundReleaseRegistrationLocalService;
	}

	/**
	 * Sets the fund release registration local service.
	 *
	 * @param fundReleaseRegistrationLocalService the fund release registration local service
	 */
	public void setFundReleaseRegistrationLocalService(
		com.crowd.funding.database.service.FundReleaseRegistrationLocalService fundReleaseRegistrationLocalService) {
		this.fundReleaseRegistrationLocalService = fundReleaseRegistrationLocalService;
	}

	/**
	 * Returns the fund release registration persistence.
	 *
	 * @return the fund release registration persistence
	 */
	public FundReleaseRegistrationPersistence getFundReleaseRegistrationPersistence() {
		return fundReleaseRegistrationPersistence;
	}

	/**
	 * Sets the fund release registration persistence.
	 *
	 * @param fundReleaseRegistrationPersistence the fund release registration persistence
	 */
	public void setFundReleaseRegistrationPersistence(
		FundReleaseRegistrationPersistence fundReleaseRegistrationPersistence) {
		this.fundReleaseRegistrationPersistence = fundReleaseRegistrationPersistence;
	}

	/**
	 * Returns the history log registration local service.
	 *
	 * @return the history log registration local service
	 */
	public com.crowd.funding.database.service.HistoryLogRegistrationLocalService getHistoryLogRegistrationLocalService() {
		return historyLogRegistrationLocalService;
	}

	/**
	 * Sets the history log registration local service.
	 *
	 * @param historyLogRegistrationLocalService the history log registration local service
	 */
	public void setHistoryLogRegistrationLocalService(
		com.crowd.funding.database.service.HistoryLogRegistrationLocalService historyLogRegistrationLocalService) {
		this.historyLogRegistrationLocalService = historyLogRegistrationLocalService;
	}

	/**
	 * Returns the history log registration persistence.
	 *
	 * @return the history log registration persistence
	 */
	public HistoryLogRegistrationPersistence getHistoryLogRegistrationPersistence() {
		return historyLogRegistrationPersistence;
	}

	/**
	 * Sets the history log registration persistence.
	 *
	 * @param historyLogRegistrationPersistence the history log registration persistence
	 */
	public void setHistoryLogRegistrationPersistence(
		HistoryLogRegistrationPersistence historyLogRegistrationPersistence) {
		this.historyLogRegistrationPersistence = historyLogRegistrationPersistence;
	}

	/**
	 * Returns the image registration local service.
	 *
	 * @return the image registration local service
	 */
	public com.crowd.funding.database.service.ImageRegistrationLocalService getImageRegistrationLocalService() {
		return imageRegistrationLocalService;
	}

	/**
	 * Sets the image registration local service.
	 *
	 * @param imageRegistrationLocalService the image registration local service
	 */
	public void setImageRegistrationLocalService(
		com.crowd.funding.database.service.ImageRegistrationLocalService imageRegistrationLocalService) {
		this.imageRegistrationLocalService = imageRegistrationLocalService;
	}

	/**
	 * Returns the image registration persistence.
	 *
	 * @return the image registration persistence
	 */
	public ImageRegistrationPersistence getImageRegistrationPersistence() {
		return imageRegistrationPersistence;
	}

	/**
	 * Sets the image registration persistence.
	 *
	 * @param imageRegistrationPersistence the image registration persistence
	 */
	public void setImageRegistrationPersistence(
		ImageRegistrationPersistence imageRegistrationPersistence) {
		this.imageRegistrationPersistence = imageRegistrationPersistence;
	}

	/**
	 * Returns the news letter registration local service.
	 *
	 * @return the news letter registration local service
	 */
	public com.crowd.funding.database.service.NewsLetterRegistrationLocalService getNewsLetterRegistrationLocalService() {
		return newsLetterRegistrationLocalService;
	}

	/**
	 * Sets the news letter registration local service.
	 *
	 * @param newsLetterRegistrationLocalService the news letter registration local service
	 */
	public void setNewsLetterRegistrationLocalService(
		com.crowd.funding.database.service.NewsLetterRegistrationLocalService newsLetterRegistrationLocalService) {
		this.newsLetterRegistrationLocalService = newsLetterRegistrationLocalService;
	}

	/**
	 * Returns the news letter registration persistence.
	 *
	 * @return the news letter registration persistence
	 */
	public NewsLetterRegistrationPersistence getNewsLetterRegistrationPersistence() {
		return newsLetterRegistrationPersistence;
	}

	/**
	 * Sets the news letter registration persistence.
	 *
	 * @param newsLetterRegistrationPersistence the news letter registration persistence
	 */
	public void setNewsLetterRegistrationPersistence(
		NewsLetterRegistrationPersistence newsLetterRegistrationPersistence) {
		this.newsLetterRegistrationPersistence = newsLetterRegistrationPersistence;
	}

	/**
	 * Returns the postion registration local service.
	 *
	 * @return the postion registration local service
	 */
	public PostionRegistrationLocalService getPostionRegistrationLocalService() {
		return postionRegistrationLocalService;
	}

	/**
	 * Sets the postion registration local service.
	 *
	 * @param postionRegistrationLocalService the postion registration local service
	 */
	public void setPostionRegistrationLocalService(
		PostionRegistrationLocalService postionRegistrationLocalService) {
		this.postionRegistrationLocalService = postionRegistrationLocalService;
	}

	/**
	 * Returns the postion registration persistence.
	 *
	 * @return the postion registration persistence
	 */
	public PostionRegistrationPersistence getPostionRegistrationPersistence() {
		return postionRegistrationPersistence;
	}

	/**
	 * Sets the postion registration persistence.
	 *
	 * @param postionRegistrationPersistence the postion registration persistence
	 */
	public void setPostionRegistrationPersistence(
		PostionRegistrationPersistence postionRegistrationPersistence) {
		this.postionRegistrationPersistence = postionRegistrationPersistence;
	}

	/**
	 * Returns the project acknowledgement registration local service.
	 *
	 * @return the project acknowledgement registration local service
	 */
	public com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalService getProjectAcknowledgementRegistrationLocalService() {
		return projectAcknowledgementRegistrationLocalService;
	}

	/**
	 * Sets the project acknowledgement registration local service.
	 *
	 * @param projectAcknowledgementRegistrationLocalService the project acknowledgement registration local service
	 */
	public void setProjectAcknowledgementRegistrationLocalService(
		com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalService projectAcknowledgementRegistrationLocalService) {
		this.projectAcknowledgementRegistrationLocalService = projectAcknowledgementRegistrationLocalService;
	}

	/**
	 * Returns the project acknowledgement registration persistence.
	 *
	 * @return the project acknowledgement registration persistence
	 */
	public ProjectAcknowledgementRegistrationPersistence getProjectAcknowledgementRegistrationPersistence() {
		return projectAcknowledgementRegistrationPersistence;
	}

	/**
	 * Sets the project acknowledgement registration persistence.
	 *
	 * @param projectAcknowledgementRegistrationPersistence the project acknowledgement registration persistence
	 */
	public void setProjectAcknowledgementRegistrationPersistence(
		ProjectAcknowledgementRegistrationPersistence projectAcknowledgementRegistrationPersistence) {
		this.projectAcknowledgementRegistrationPersistence = projectAcknowledgementRegistrationPersistence;
	}

	/**
	 * Returns the project extention registration local service.
	 *
	 * @return the project extention registration local service
	 */
	public com.crowd.funding.database.service.ProjectExtentionRegistrationLocalService getProjectExtentionRegistrationLocalService() {
		return projectExtentionRegistrationLocalService;
	}

	/**
	 * Sets the project extention registration local service.
	 *
	 * @param projectExtentionRegistrationLocalService the project extention registration local service
	 */
	public void setProjectExtentionRegistrationLocalService(
		com.crowd.funding.database.service.ProjectExtentionRegistrationLocalService projectExtentionRegistrationLocalService) {
		this.projectExtentionRegistrationLocalService = projectExtentionRegistrationLocalService;
	}

	/**
	 * Returns the project extention registration persistence.
	 *
	 * @return the project extention registration persistence
	 */
	public ProjectExtentionRegistrationPersistence getProjectExtentionRegistrationPersistence() {
		return projectExtentionRegistrationPersistence;
	}

	/**
	 * Sets the project extention registration persistence.
	 *
	 * @param projectExtentionRegistrationPersistence the project extention registration persistence
	 */
	public void setProjectExtentionRegistrationPersistence(
		ProjectExtentionRegistrationPersistence projectExtentionRegistrationPersistence) {
		this.projectExtentionRegistrationPersistence = projectExtentionRegistrationPersistence;
	}

	/**
	 * Returns the project fees registration local service.
	 *
	 * @return the project fees registration local service
	 */
	public com.crowd.funding.database.service.ProjectFeesRegistrationLocalService getProjectFeesRegistrationLocalService() {
		return projectFeesRegistrationLocalService;
	}

	/**
	 * Sets the project fees registration local service.
	 *
	 * @param projectFeesRegistrationLocalService the project fees registration local service
	 */
	public void setProjectFeesRegistrationLocalService(
		com.crowd.funding.database.service.ProjectFeesRegistrationLocalService projectFeesRegistrationLocalService) {
		this.projectFeesRegistrationLocalService = projectFeesRegistrationLocalService;
	}

	/**
	 * Returns the project fees registration persistence.
	 *
	 * @return the project fees registration persistence
	 */
	public ProjectFeesRegistrationPersistence getProjectFeesRegistrationPersistence() {
		return projectFeesRegistrationPersistence;
	}

	/**
	 * Sets the project fees registration persistence.
	 *
	 * @param projectFeesRegistrationPersistence the project fees registration persistence
	 */
	public void setProjectFeesRegistrationPersistence(
		ProjectFeesRegistrationPersistence projectFeesRegistrationPersistence) {
		this.projectFeesRegistrationPersistence = projectFeesRegistrationPersistence;
	}

	/**
	 * Returns the project follower registration local service.
	 *
	 * @return the project follower registration local service
	 */
	public com.crowd.funding.database.service.ProjectFollowerRegistrationLocalService getProjectFollowerRegistrationLocalService() {
		return projectFollowerRegistrationLocalService;
	}

	/**
	 * Sets the project follower registration local service.
	 *
	 * @param projectFollowerRegistrationLocalService the project follower registration local service
	 */
	public void setProjectFollowerRegistrationLocalService(
		com.crowd.funding.database.service.ProjectFollowerRegistrationLocalService projectFollowerRegistrationLocalService) {
		this.projectFollowerRegistrationLocalService = projectFollowerRegistrationLocalService;
	}

	/**
	 * Returns the project follower registration persistence.
	 *
	 * @return the project follower registration persistence
	 */
	public ProjectFollowerRegistrationPersistence getProjectFollowerRegistrationPersistence() {
		return projectFollowerRegistrationPersistence;
	}

	/**
	 * Sets the project follower registration persistence.
	 *
	 * @param projectFollowerRegistrationPersistence the project follower registration persistence
	 */
	public void setProjectFollowerRegistrationPersistence(
		ProjectFollowerRegistrationPersistence projectFollowerRegistrationPersistence) {
		this.projectFollowerRegistrationPersistence = projectFollowerRegistrationPersistence;
	}

	/**
	 * Returns the project priority registration local service.
	 *
	 * @return the project priority registration local service
	 */
	public com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService getProjectPriorityRegistrationLocalService() {
		return projectPriorityRegistrationLocalService;
	}

	/**
	 * Sets the project priority registration local service.
	 *
	 * @param projectPriorityRegistrationLocalService the project priority registration local service
	 */
	public void setProjectPriorityRegistrationLocalService(
		com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService projectPriorityRegistrationLocalService) {
		this.projectPriorityRegistrationLocalService = projectPriorityRegistrationLocalService;
	}

	/**
	 * Returns the project priority registration persistence.
	 *
	 * @return the project priority registration persistence
	 */
	public ProjectPriorityRegistrationPersistence getProjectPriorityRegistrationPersistence() {
		return projectPriorityRegistrationPersistence;
	}

	/**
	 * Sets the project priority registration persistence.
	 *
	 * @param projectPriorityRegistrationPersistence the project priority registration persistence
	 */
	public void setProjectPriorityRegistrationPersistence(
		ProjectPriorityRegistrationPersistence projectPriorityRegistrationPersistence) {
		this.projectPriorityRegistrationPersistence = projectPriorityRegistrationPersistence;
	}

	/**
	 * Returns the project registration local service.
	 *
	 * @return the project registration local service
	 */
	public com.crowd.funding.database.service.ProjectRegistrationLocalService getProjectRegistrationLocalService() {
		return projectRegistrationLocalService;
	}

	/**
	 * Sets the project registration local service.
	 *
	 * @param projectRegistrationLocalService the project registration local service
	 */
	public void setProjectRegistrationLocalService(
		com.crowd.funding.database.service.ProjectRegistrationLocalService projectRegistrationLocalService) {
		this.projectRegistrationLocalService = projectRegistrationLocalService;
	}

	/**
	 * Returns the project registration persistence.
	 *
	 * @return the project registration persistence
	 */
	public ProjectRegistrationPersistence getProjectRegistrationPersistence() {
		return projectRegistrationPersistence;
	}

	/**
	 * Sets the project registration persistence.
	 *
	 * @param projectRegistrationPersistence the project registration persistence
	 */
	public void setProjectRegistrationPersistence(
		ProjectRegistrationPersistence projectRegistrationPersistence) {
		this.projectRegistrationPersistence = projectRegistrationPersistence;
	}

	/**
	 * Returns the project registration finder.
	 *
	 * @return the project registration finder
	 */
	public ProjectRegistrationFinder getProjectRegistrationFinder() {
		return projectRegistrationFinder;
	}

	/**
	 * Sets the project registration finder.
	 *
	 * @param projectRegistrationFinder the project registration finder
	 */
	public void setProjectRegistrationFinder(
		ProjectRegistrationFinder projectRegistrationFinder) {
		this.projectRegistrationFinder = projectRegistrationFinder;
	}

	/**
	 * Returns the project update registration local service.
	 *
	 * @return the project update registration local service
	 */
	public com.crowd.funding.database.service.ProjectUpdateRegistrationLocalService getProjectUpdateRegistrationLocalService() {
		return projectUpdateRegistrationLocalService;
	}

	/**
	 * Sets the project update registration local service.
	 *
	 * @param projectUpdateRegistrationLocalService the project update registration local service
	 */
	public void setProjectUpdateRegistrationLocalService(
		com.crowd.funding.database.service.ProjectUpdateRegistrationLocalService projectUpdateRegistrationLocalService) {
		this.projectUpdateRegistrationLocalService = projectUpdateRegistrationLocalService;
	}

	/**
	 * Returns the project update registration persistence.
	 *
	 * @return the project update registration persistence
	 */
	public ProjectUpdateRegistrationPersistence getProjectUpdateRegistrationPersistence() {
		return projectUpdateRegistrationPersistence;
	}

	/**
	 * Sets the project update registration persistence.
	 *
	 * @param projectUpdateRegistrationPersistence the project update registration persistence
	 */
	public void setProjectUpdateRegistrationPersistence(
		ProjectUpdateRegistrationPersistence projectUpdateRegistrationPersistence) {
		this.projectUpdateRegistrationPersistence = projectUpdateRegistrationPersistence;
	}

	/**
	 * Returns the question registration local service.
	 *
	 * @return the question registration local service
	 */
	public com.crowd.funding.database.service.QuestionRegistrationLocalService getQuestionRegistrationLocalService() {
		return questionRegistrationLocalService;
	}

	/**
	 * Sets the question registration local service.
	 *
	 * @param questionRegistrationLocalService the question registration local service
	 */
	public void setQuestionRegistrationLocalService(
		com.crowd.funding.database.service.QuestionRegistrationLocalService questionRegistrationLocalService) {
		this.questionRegistrationLocalService = questionRegistrationLocalService;
	}

	/**
	 * Returns the question registration persistence.
	 *
	 * @return the question registration persistence
	 */
	public QuestionRegistrationPersistence getQuestionRegistrationPersistence() {
		return questionRegistrationPersistence;
	}

	/**
	 * Sets the question registration persistence.
	 *
	 * @param questionRegistrationPersistence the question registration persistence
	 */
	public void setQuestionRegistrationPersistence(
		QuestionRegistrationPersistence questionRegistrationPersistence) {
		this.questionRegistrationPersistence = questionRegistrationPersistence;
	}

	/**
	 * Returns the subscription registration local service.
	 *
	 * @return the subscription registration local service
	 */
	public com.crowd.funding.database.service.SubscriptionRegistrationLocalService getSubscriptionRegistrationLocalService() {
		return subscriptionRegistrationLocalService;
	}

	/**
	 * Sets the subscription registration local service.
	 *
	 * @param subscriptionRegistrationLocalService the subscription registration local service
	 */
	public void setSubscriptionRegistrationLocalService(
		com.crowd.funding.database.service.SubscriptionRegistrationLocalService subscriptionRegistrationLocalService) {
		this.subscriptionRegistrationLocalService = subscriptionRegistrationLocalService;
	}

	/**
	 * Returns the subscription registration persistence.
	 *
	 * @return the subscription registration persistence
	 */
	public SubscriptionRegistrationPersistence getSubscriptionRegistrationPersistence() {
		return subscriptionRegistrationPersistence;
	}

	/**
	 * Sets the subscription registration persistence.
	 *
	 * @param subscriptionRegistrationPersistence the subscription registration persistence
	 */
	public void setSubscriptionRegistrationPersistence(
		SubscriptionRegistrationPersistence subscriptionRegistrationPersistence) {
		this.subscriptionRegistrationPersistence = subscriptionRegistrationPersistence;
	}

	/**
	 * Returns the update requester registration local service.
	 *
	 * @return the update requester registration local service
	 */
	public com.crowd.funding.database.service.UpdateRequesterRegistrationLocalService getUpdateRequesterRegistrationLocalService() {
		return updateRequesterRegistrationLocalService;
	}

	/**
	 * Sets the update requester registration local service.
	 *
	 * @param updateRequesterRegistrationLocalService the update requester registration local service
	 */
	public void setUpdateRequesterRegistrationLocalService(
		com.crowd.funding.database.service.UpdateRequesterRegistrationLocalService updateRequesterRegistrationLocalService) {
		this.updateRequesterRegistrationLocalService = updateRequesterRegistrationLocalService;
	}

	/**
	 * Returns the update requester registration persistence.
	 *
	 * @return the update requester registration persistence
	 */
	public UpdateRequesterRegistrationPersistence getUpdateRequesterRegistrationPersistence() {
		return updateRequesterRegistrationPersistence;
	}

	/**
	 * Sets the update requester registration persistence.
	 *
	 * @param updateRequesterRegistrationPersistence the update requester registration persistence
	 */
	public void setUpdateRequesterRegistrationPersistence(
		UpdateRequesterRegistrationPersistence updateRequesterRegistrationPersistence) {
		this.updateRequesterRegistrationPersistence = updateRequesterRegistrationPersistence;
	}

	/**
	 * Returns the user follow registration local service.
	 *
	 * @return the user follow registration local service
	 */
	public com.crowd.funding.database.service.UserFollowRegistrationLocalService getUserFollowRegistrationLocalService() {
		return userFollowRegistrationLocalService;
	}

	/**
	 * Sets the user follow registration local service.
	 *
	 * @param userFollowRegistrationLocalService the user follow registration local service
	 */
	public void setUserFollowRegistrationLocalService(
		com.crowd.funding.database.service.UserFollowRegistrationLocalService userFollowRegistrationLocalService) {
		this.userFollowRegistrationLocalService = userFollowRegistrationLocalService;
	}

	/**
	 * Returns the user follow registration persistence.
	 *
	 * @return the user follow registration persistence
	 */
	public UserFollowRegistrationPersistence getUserFollowRegistrationPersistence() {
		return userFollowRegistrationPersistence;
	}

	/**
	 * Sets the user follow registration persistence.
	 *
	 * @param userFollowRegistrationPersistence the user follow registration persistence
	 */
	public void setUserFollowRegistrationPersistence(
		UserFollowRegistrationPersistence userFollowRegistrationPersistence) {
		this.userFollowRegistrationPersistence = userFollowRegistrationPersistence;
	}

	/**
	 * Returns the user otp registration local service.
	 *
	 * @return the user otp registration local service
	 */
	public com.crowd.funding.database.service.UserOTPRegistrationLocalService getUserOTPRegistrationLocalService() {
		return userOTPRegistrationLocalService;
	}

	/**
	 * Sets the user otp registration local service.
	 *
	 * @param userOTPRegistrationLocalService the user otp registration local service
	 */
	public void setUserOTPRegistrationLocalService(
		com.crowd.funding.database.service.UserOTPRegistrationLocalService userOTPRegistrationLocalService) {
		this.userOTPRegistrationLocalService = userOTPRegistrationLocalService;
	}

	/**
	 * Returns the user otp registration persistence.
	 *
	 * @return the user otp registration persistence
	 */
	public UserOTPRegistrationPersistence getUserOTPRegistrationPersistence() {
		return userOTPRegistrationPersistence;
	}

	/**
	 * Sets the user otp registration persistence.
	 *
	 * @param userOTPRegistrationPersistence the user otp registration persistence
	 */
	public void setUserOTPRegistrationPersistence(
		UserOTPRegistrationPersistence userOTPRegistrationPersistence) {
		this.userOTPRegistrationPersistence = userOTPRegistrationPersistence;
	}

	/**
	 * Returns the user registration local service.
	 *
	 * @return the user registration local service
	 */
	public com.crowd.funding.database.service.UserRegistrationLocalService getUserRegistrationLocalService() {
		return userRegistrationLocalService;
	}

	/**
	 * Sets the user registration local service.
	 *
	 * @param userRegistrationLocalService the user registration local service
	 */
	public void setUserRegistrationLocalService(
		com.crowd.funding.database.service.UserRegistrationLocalService userRegistrationLocalService) {
		this.userRegistrationLocalService = userRegistrationLocalService;
	}

	/**
	 * Returns the user registration persistence.
	 *
	 * @return the user registration persistence
	 */
	public UserRegistrationPersistence getUserRegistrationPersistence() {
		return userRegistrationPersistence;
	}

	/**
	 * Sets the user registration persistence.
	 *
	 * @param userRegistrationPersistence the user registration persistence
	 */
	public void setUserRegistrationPersistence(
		UserRegistrationPersistence userRegistrationPersistence) {
		this.userRegistrationPersistence = userRegistrationPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.crowd.funding.database.model.PostionRegistration",
			postionRegistrationLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.crowd.funding.database.model.PostionRegistration");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PostionRegistrationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return PostionRegistration.class;
	}

	protected String getModelClassName() {
		return PostionRegistration.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = postionRegistrationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.crowd.funding.database.service.BenificiaryRegistrationLocalService.class)
	protected com.crowd.funding.database.service.BenificiaryRegistrationLocalService benificiaryRegistrationLocalService;
	@BeanReference(type = BenificiaryRegistrationPersistence.class)
	protected BenificiaryRegistrationPersistence benificiaryRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.CandidateRegistrationLocalService.class)
	protected com.crowd.funding.database.service.CandidateRegistrationLocalService candidateRegistrationLocalService;
	@BeanReference(type = CandidateRegistrationPersistence.class)
	protected CandidateRegistrationPersistence candidateRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.CommentRegistrationLocalService.class)
	protected com.crowd.funding.database.service.CommentRegistrationLocalService commentRegistrationLocalService;
	@BeanReference(type = CommentRegistrationPersistence.class)
	protected CommentRegistrationPersistence commentRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.DocumentRegistrationLocalService.class)
	protected com.crowd.funding.database.service.DocumentRegistrationLocalService documentRegistrationLocalService;
	@BeanReference(type = DocumentRegistrationPersistence.class)
	protected DocumentRegistrationPersistence documentRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.DonorRegistrationLocalService.class)
	protected com.crowd.funding.database.service.DonorRegistrationLocalService donorRegistrationLocalService;
	@BeanReference(type = DonorRegistrationPersistence.class)
	protected DonorRegistrationPersistence donorRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.DynamicFeesRegistrationLocalService.class)
	protected com.crowd.funding.database.service.DynamicFeesRegistrationLocalService dynamicFeesRegistrationLocalService;
	@BeanReference(type = DynamicFeesRegistrationPersistence.class)
	protected DynamicFeesRegistrationPersistence dynamicFeesRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.FeedbackRegistrationLocalService.class)
	protected com.crowd.funding.database.service.FeedbackRegistrationLocalService feedbackRegistrationLocalService;
	@BeanReference(type = FeedbackRegistrationPersistence.class)
	protected FeedbackRegistrationPersistence feedbackRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.FundAccountRegistrationLocalService.class)
	protected com.crowd.funding.database.service.FundAccountRegistrationLocalService fundAccountRegistrationLocalService;
	@BeanReference(type = FundAccountRegistrationPersistence.class)
	protected FundAccountRegistrationPersistence fundAccountRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.FundRegistrationLocalService.class)
	protected com.crowd.funding.database.service.FundRegistrationLocalService fundRegistrationLocalService;
	@BeanReference(type = FundRegistrationPersistence.class)
	protected FundRegistrationPersistence fundRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.FundReleaseRegistrationLocalService.class)
	protected com.crowd.funding.database.service.FundReleaseRegistrationLocalService fundReleaseRegistrationLocalService;
	@BeanReference(type = FundReleaseRegistrationPersistence.class)
	protected FundReleaseRegistrationPersistence fundReleaseRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.HistoryLogRegistrationLocalService.class)
	protected com.crowd.funding.database.service.HistoryLogRegistrationLocalService historyLogRegistrationLocalService;
	@BeanReference(type = HistoryLogRegistrationPersistence.class)
	protected HistoryLogRegistrationPersistence historyLogRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ImageRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ImageRegistrationLocalService imageRegistrationLocalService;
	@BeanReference(type = ImageRegistrationPersistence.class)
	protected ImageRegistrationPersistence imageRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.NewsLetterRegistrationLocalService.class)
	protected com.crowd.funding.database.service.NewsLetterRegistrationLocalService newsLetterRegistrationLocalService;
	@BeanReference(type = NewsLetterRegistrationPersistence.class)
	protected NewsLetterRegistrationPersistence newsLetterRegistrationPersistence;
	@BeanReference(type = PostionRegistrationLocalService.class)
	protected PostionRegistrationLocalService postionRegistrationLocalService;
	@BeanReference(type = PostionRegistrationPersistence.class)
	protected PostionRegistrationPersistence postionRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalService projectAcknowledgementRegistrationLocalService;
	@BeanReference(type = ProjectAcknowledgementRegistrationPersistence.class)
	protected ProjectAcknowledgementRegistrationPersistence projectAcknowledgementRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ProjectExtentionRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectExtentionRegistrationLocalService projectExtentionRegistrationLocalService;
	@BeanReference(type = ProjectExtentionRegistrationPersistence.class)
	protected ProjectExtentionRegistrationPersistence projectExtentionRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ProjectFeesRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectFeesRegistrationLocalService projectFeesRegistrationLocalService;
	@BeanReference(type = ProjectFeesRegistrationPersistence.class)
	protected ProjectFeesRegistrationPersistence projectFeesRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ProjectFollowerRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectFollowerRegistrationLocalService projectFollowerRegistrationLocalService;
	@BeanReference(type = ProjectFollowerRegistrationPersistence.class)
	protected ProjectFollowerRegistrationPersistence projectFollowerRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService projectPriorityRegistrationLocalService;
	@BeanReference(type = ProjectPriorityRegistrationPersistence.class)
	protected ProjectPriorityRegistrationPersistence projectPriorityRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.ProjectRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectRegistrationLocalService projectRegistrationLocalService;
	@BeanReference(type = ProjectRegistrationPersistence.class)
	protected ProjectRegistrationPersistence projectRegistrationPersistence;
	@BeanReference(type = ProjectRegistrationFinder.class)
	protected ProjectRegistrationFinder projectRegistrationFinder;
	@BeanReference(type = com.crowd.funding.database.service.ProjectUpdateRegistrationLocalService.class)
	protected com.crowd.funding.database.service.ProjectUpdateRegistrationLocalService projectUpdateRegistrationLocalService;
	@BeanReference(type = ProjectUpdateRegistrationPersistence.class)
	protected ProjectUpdateRegistrationPersistence projectUpdateRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.QuestionRegistrationLocalService.class)
	protected com.crowd.funding.database.service.QuestionRegistrationLocalService questionRegistrationLocalService;
	@BeanReference(type = QuestionRegistrationPersistence.class)
	protected QuestionRegistrationPersistence questionRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.SubscriptionRegistrationLocalService.class)
	protected com.crowd.funding.database.service.SubscriptionRegistrationLocalService subscriptionRegistrationLocalService;
	@BeanReference(type = SubscriptionRegistrationPersistence.class)
	protected SubscriptionRegistrationPersistence subscriptionRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.UpdateRequesterRegistrationLocalService.class)
	protected com.crowd.funding.database.service.UpdateRequesterRegistrationLocalService updateRequesterRegistrationLocalService;
	@BeanReference(type = UpdateRequesterRegistrationPersistence.class)
	protected UpdateRequesterRegistrationPersistence updateRequesterRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.UserFollowRegistrationLocalService.class)
	protected com.crowd.funding.database.service.UserFollowRegistrationLocalService userFollowRegistrationLocalService;
	@BeanReference(type = UserFollowRegistrationPersistence.class)
	protected UserFollowRegistrationPersistence userFollowRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.UserOTPRegistrationLocalService.class)
	protected com.crowd.funding.database.service.UserOTPRegistrationLocalService userOTPRegistrationLocalService;
	@BeanReference(type = UserOTPRegistrationPersistence.class)
	protected UserOTPRegistrationPersistence userOTPRegistrationPersistence;
	@BeanReference(type = com.crowd.funding.database.service.UserRegistrationLocalService.class)
	protected com.crowd.funding.database.service.UserRegistrationLocalService userRegistrationLocalService;
	@BeanReference(type = UserRegistrationPersistence.class)
	protected UserRegistrationPersistence userRegistrationPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}