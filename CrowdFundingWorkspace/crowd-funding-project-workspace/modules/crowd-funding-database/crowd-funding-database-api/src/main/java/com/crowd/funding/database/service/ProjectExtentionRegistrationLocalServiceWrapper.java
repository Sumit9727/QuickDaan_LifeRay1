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
 * Provides a wrapper for {@link ProjectExtentionRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectExtentionRegistrationLocalService
 * @generated
 */
@ProviderType
public class ProjectExtentionRegistrationLocalServiceWrapper
	implements ProjectExtentionRegistrationLocalService,
		ServiceWrapper<ProjectExtentionRegistrationLocalService> {
	public ProjectExtentionRegistrationLocalServiceWrapper(
		ProjectExtentionRegistrationLocalService projectExtentionRegistrationLocalService) {
		_projectExtentionRegistrationLocalService = projectExtentionRegistrationLocalService;
	}

	/**
	* Adds the project extention registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectExtentionRegistration the project extention registration
	* @return the project extention registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration addProjectExtentionRegistration(
		com.crowd.funding.database.model.ProjectExtentionRegistration projectExtentionRegistration) {
		return _projectExtentionRegistrationLocalService.addProjectExtentionRegistration(projectExtentionRegistration);
	}

	/**
	* Creates a new project extention registration with the primary key. Does not add the project extention registration to the database.
	*
	* @param PROJECT_EXTENTION_ID the primary key for the new project extention registration
	* @return the new project extention registration
	*/
	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration createProjectExtentionRegistration(
		long PROJECT_EXTENTION_ID) {
		return _projectExtentionRegistrationLocalService.createProjectExtentionRegistration(PROJECT_EXTENTION_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectExtentionRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project extention registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration that was removed
	* @throws PortalException if a project extention registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration deleteProjectExtentionRegistration(
		long PROJECT_EXTENTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectExtentionRegistrationLocalService.deleteProjectExtentionRegistration(PROJECT_EXTENTION_ID);
	}

	/**
	* Deletes the project extention registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectExtentionRegistration the project extention registration
	* @return the project extention registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration deleteProjectExtentionRegistration(
		com.crowd.funding.database.model.ProjectExtentionRegistration projectExtentionRegistration) {
		return _projectExtentionRegistrationLocalService.deleteProjectExtentionRegistration(projectExtentionRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectExtentionRegistrationLocalService.dynamicQuery();
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
		return _projectExtentionRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectExtentionRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectExtentionRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _projectExtentionRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectExtentionRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration fetchProjectExtentionRegistration(
		long PROJECT_EXTENTION_ID) {
		return _projectExtentionRegistrationLocalService.fetchProjectExtentionRegistration(PROJECT_EXTENTION_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _projectExtentionRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectExtentionRegistration> findBySTATUS(
		int STATUS) {
		return _projectExtentionRegistrationLocalService.findBySTATUS(STATUS);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectExtentionRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectExtentionRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectExtentionRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectExtentionRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project extention registration with the primary key.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration
	* @throws PortalException if a project extention registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration getProjectExtentionRegistration(
		long PROJECT_EXTENTION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectExtentionRegistrationLocalService.getProjectExtentionRegistration(PROJECT_EXTENTION_ID);
	}

	/**
	* Returns a range of all the project extention registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @return the range of project extention registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectExtentionRegistration> getProjectExtentionRegistrations(
		int start, int end) {
		return _projectExtentionRegistrationLocalService.getProjectExtentionRegistrations(start,
			end);
	}

	/**
	* Returns the number of project extention registrations.
	*
	* @return the number of project extention registrations
	*/
	@Override
	public int getProjectExtentionRegistrationsCount() {
		return _projectExtentionRegistrationLocalService.getProjectExtentionRegistrationsCount();
	}

	/**
	* Updates the project extention registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectExtentionRegistration the project extention registration
	* @return the project extention registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.ProjectExtentionRegistration updateProjectExtentionRegistration(
		com.crowd.funding.database.model.ProjectExtentionRegistration projectExtentionRegistration) {
		return _projectExtentionRegistrationLocalService.updateProjectExtentionRegistration(projectExtentionRegistration);
	}

	@Override
	public ProjectExtentionRegistrationLocalService getWrappedService() {
		return _projectExtentionRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectExtentionRegistrationLocalService projectExtentionRegistrationLocalService) {
		_projectExtentionRegistrationLocalService = projectExtentionRegistrationLocalService;
	}

	private ProjectExtentionRegistrationLocalService _projectExtentionRegistrationLocalService;
}