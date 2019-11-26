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
 * Provides a wrapper for {@link ProjectFeesRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistrationLocalService
 * @generated
 */
@ProviderType
public class ProjectFeesRegistrationLocalServiceWrapper
	implements ProjectFeesRegistrationLocalService,
		ServiceWrapper<ProjectFeesRegistrationLocalService> {
	public ProjectFeesRegistrationLocalServiceWrapper(
		ProjectFeesRegistrationLocalService projectFeesRegistrationLocalService) {
		_projectFeesRegistrationLocalService = projectFeesRegistrationLocalService;
	}

	/**
	* Adds the project fees registration to the database. Also notifies the appropriate model listeners.
	*
	* @param projectFeesRegistration the project fees registration
	* @return the project fees registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration addProjectFeesRegistration(
		com.crowd.funding.database.model.ProjectFeesRegistration projectFeesRegistration) {
		return _projectFeesRegistrationLocalService.addProjectFeesRegistration(projectFeesRegistration);
	}

	/**
	* Creates a new project fees registration with the primary key. Does not add the project fees registration to the database.
	*
	* @param PROJECT_FEES_ID the primary key for the new project fees registration
	* @return the new project fees registration
	*/
	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration createProjectFeesRegistration(
		long PROJECT_FEES_ID) {
		return _projectFeesRegistrationLocalService.createProjectFeesRegistration(PROJECT_FEES_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectFeesRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the project fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration that was removed
	* @throws PortalException if a project fees registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration deleteProjectFeesRegistration(
		long PROJECT_FEES_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectFeesRegistrationLocalService.deleteProjectFeesRegistration(PROJECT_FEES_ID);
	}

	/**
	* Deletes the project fees registration from the database. Also notifies the appropriate model listeners.
	*
	* @param projectFeesRegistration the project fees registration
	* @return the project fees registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration deleteProjectFeesRegistration(
		com.crowd.funding.database.model.ProjectFeesRegistration projectFeesRegistration) {
		return _projectFeesRegistrationLocalService.deleteProjectFeesRegistration(projectFeesRegistration);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectFeesRegistrationLocalService.dynamicQuery();
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
		return _projectFeesRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectFeesRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectFeesRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _projectFeesRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectFeesRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration fetchProjectFeesRegistration(
		long PROJECT_FEES_ID) {
		return _projectFeesRegistrationLocalService.fetchProjectFeesRegistration(PROJECT_FEES_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID) {
		return _projectFeesRegistrationLocalService.findByCATEGORY_ID(CATEGORY_ID);
	}

	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration findByPROJECT_FEES_ID(
		long PROJECT_FEES_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return _projectFeesRegistrationLocalService.findByPROJECT_FEES_ID(PROJECT_FEES_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return _projectFeesRegistrationLocalService.findByPROJECT_ID(PROJECT_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _projectFeesRegistrationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _projectFeesRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectFeesRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectFeesRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the project fees registration with the primary key.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration
	* @throws PortalException if a project fees registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration getProjectFeesRegistration(
		long PROJECT_FEES_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _projectFeesRegistrationLocalService.getProjectFeesRegistration(PROJECT_FEES_ID);
	}

	/**
	* Returns a range of all the project fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @return the range of project fees registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.ProjectFeesRegistration> getProjectFeesRegistrations(
		int start, int end) {
		return _projectFeesRegistrationLocalService.getProjectFeesRegistrations(start,
			end);
	}

	/**
	* Returns the number of project fees registrations.
	*
	* @return the number of project fees registrations
	*/
	@Override
	public int getProjectFeesRegistrationsCount() {
		return _projectFeesRegistrationLocalService.getProjectFeesRegistrationsCount();
	}

	/**
	* Updates the project fees registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectFeesRegistration the project fees registration
	* @return the project fees registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.ProjectFeesRegistration updateProjectFeesRegistration(
		com.crowd.funding.database.model.ProjectFeesRegistration projectFeesRegistration) {
		return _projectFeesRegistrationLocalService.updateProjectFeesRegistration(projectFeesRegistration);
	}

	@Override
	public ProjectFeesRegistrationLocalService getWrappedService() {
		return _projectFeesRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectFeesRegistrationLocalService projectFeesRegistrationLocalService) {
		_projectFeesRegistrationLocalService = projectFeesRegistrationLocalService;
	}

	private ProjectFeesRegistrationLocalService _projectFeesRegistrationLocalService;
}