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

package com.crowd.funding.database.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PostionRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PostionRegistrationLocalService
 * @generated
 */
@ProviderType
public class PostionRegistrationLocalServiceWrapper
	implements PostionRegistrationLocalService,
		ServiceWrapper<PostionRegistrationLocalService> {
	public PostionRegistrationLocalServiceWrapper(
		PostionRegistrationLocalService postionRegistrationLocalService) {
		_postionRegistrationLocalService = postionRegistrationLocalService;
	}

	/**
	* Adds the postion registration to the database. Also notifies the appropriate model listeners.
	*
	* @param postionRegistration the postion registration
	* @return the postion registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.PostionRegistration addPostionRegistration(
		com.crowd.funding.database.model.PostionRegistration postionRegistration) {
		return _postionRegistrationLocalService.addPostionRegistration(postionRegistration);
	}

	/**
	* Creates a new postion registration with the primary key. Does not add the postion registration to the database.
	*
	* @param POSITION_ID the primary key for the new postion registration
	* @return the new postion registration
	*/
	@Override
	public com.crowd.funding.database.model.PostionRegistration createPostionRegistration(
		long POSITION_ID) {
		return _postionRegistrationLocalService.createPostionRegistration(POSITION_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _postionRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration that was removed
	* @throws PortalException if a postion registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.PostionRegistration deletePostionRegistration(
		long POSITION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _postionRegistrationLocalService.deletePostionRegistration(POSITION_ID);
	}

	/**
	* Deletes the postion registration from the database. Also notifies the appropriate model listeners.
	*
	* @param postionRegistration the postion registration
	* @return the postion registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.PostionRegistration deletePostionRegistration(
		com.crowd.funding.database.model.PostionRegistration postionRegistration) {
		return _postionRegistrationLocalService.deletePostionRegistration(postionRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _postionRegistrationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _postionRegistrationLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _postionRegistrationLocalService.dynamicQuery(dynamicQuery,
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _postionRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _postionRegistrationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _postionRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.PostionRegistration fetchPostionRegistration(
		long POSITION_ID) {
		return _postionRegistrationLocalService.fetchPostionRegistration(POSITION_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _postionRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _postionRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _postionRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _postionRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the postion registration with the primary key.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration
	* @throws PortalException if a postion registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.PostionRegistration getPostionRegistration(
		long POSITION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _postionRegistrationLocalService.getPostionRegistration(POSITION_ID);
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
	public java.util.List<com.crowd.funding.database.model.PostionRegistration> getPostionRegistrations(
		int start, int end) {
		return _postionRegistrationLocalService.getPostionRegistrations(start,
			end);
	}

	/**
	* Returns the number of postion registrations.
	*
	* @return the number of postion registrations
	*/
	@Override
	public int getPostionRegistrationsCount() {
		return _postionRegistrationLocalService.getPostionRegistrationsCount();
	}

	/**
	* Updates the postion registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param postionRegistration the postion registration
	* @return the postion registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.PostionRegistration updatePostionRegistration(
		com.crowd.funding.database.model.PostionRegistration postionRegistration) {
		return _postionRegistrationLocalService.updatePostionRegistration(postionRegistration);
	}

	@Override
	public PostionRegistrationLocalService getWrappedService() {
		return _postionRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		PostionRegistrationLocalService postionRegistrationLocalService) {
		_postionRegistrationLocalService = postionRegistrationLocalService;
	}

	private PostionRegistrationLocalService _postionRegistrationLocalService;
}