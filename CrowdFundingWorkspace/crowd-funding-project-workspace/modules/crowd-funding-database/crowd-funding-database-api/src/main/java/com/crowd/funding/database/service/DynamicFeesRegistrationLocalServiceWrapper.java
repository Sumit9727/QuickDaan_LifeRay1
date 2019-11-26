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
 * Provides a wrapper for {@link DynamicFeesRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistrationLocalService
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationLocalServiceWrapper
	implements DynamicFeesRegistrationLocalService,
		ServiceWrapper<DynamicFeesRegistrationLocalService> {
	public DynamicFeesRegistrationLocalServiceWrapper(
		DynamicFeesRegistrationLocalService dynamicFeesRegistrationLocalService) {
		_dynamicFeesRegistrationLocalService = dynamicFeesRegistrationLocalService;
	}

	/**
	* Adds the dynamic fees registration to the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	* @return the dynamic fees registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration addDynamicFeesRegistration(
		com.crowd.funding.database.model.DynamicFeesRegistration dynamicFeesRegistration) {
		return _dynamicFeesRegistrationLocalService.addDynamicFeesRegistration(dynamicFeesRegistration);
	}

	/**
	* Creates a new dynamic fees registration with the primary key. Does not add the dynamic fees registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new dynamic fees registration
	* @return the new dynamic fees registration
	*/
	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration createDynamicFeesRegistration(
		long CATEGORY_ID) {
		return _dynamicFeesRegistrationLocalService.createDynamicFeesRegistration(CATEGORY_ID);
	}

	/**
	* Deletes the dynamic fees registration from the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	* @return the dynamic fees registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration deleteDynamicFeesRegistration(
		com.crowd.funding.database.model.DynamicFeesRegistration dynamicFeesRegistration) {
		return _dynamicFeesRegistrationLocalService.deleteDynamicFeesRegistration(dynamicFeesRegistration);
	}

	/**
	* Deletes the dynamic fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration that was removed
	* @throws PortalException if a dynamic fees registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration deleteDynamicFeesRegistration(
		long CATEGORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dynamicFeesRegistrationLocalService.deleteDynamicFeesRegistration(CATEGORY_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dynamicFeesRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dynamicFeesRegistrationLocalService.dynamicQuery();
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
		return _dynamicFeesRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dynamicFeesRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dynamicFeesRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _dynamicFeesRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dynamicFeesRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration fetchDynamicFeesRegistration(
		long CATEGORY_ID) {
		return _dynamicFeesRegistrationLocalService.fetchDynamicFeesRegistration(CATEGORY_ID);
	}

	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration findByCATEGORY_ID(
		long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return _dynamicFeesRegistrationLocalService.findByCATEGORY_ID(CATEGORY_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dynamicFeesRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the dynamic fees registration with the primary key.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration
	* @throws PortalException if a dynamic fees registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration getDynamicFeesRegistration(
		long CATEGORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dynamicFeesRegistrationLocalService.getDynamicFeesRegistration(CATEGORY_ID);
	}

	/**
	* Returns a range of all the dynamic fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @return the range of dynamic fees registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.DynamicFeesRegistration> getDynamicFeesRegistrations(
		int start, int end) {
		return _dynamicFeesRegistrationLocalService.getDynamicFeesRegistrations(start,
			end);
	}

	/**
	* Returns the number of dynamic fees registrations.
	*
	* @return the number of dynamic fees registrations
	*/
	@Override
	public int getDynamicFeesRegistrationsCount() {
		return _dynamicFeesRegistrationLocalService.getDynamicFeesRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dynamicFeesRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _dynamicFeesRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dynamicFeesRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the dynamic fees registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	* @return the dynamic fees registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.DynamicFeesRegistration updateDynamicFeesRegistration(
		com.crowd.funding.database.model.DynamicFeesRegistration dynamicFeesRegistration) {
		return _dynamicFeesRegistrationLocalService.updateDynamicFeesRegistration(dynamicFeesRegistration);
	}

	@Override
	public DynamicFeesRegistrationLocalService getWrappedService() {
		return _dynamicFeesRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		DynamicFeesRegistrationLocalService dynamicFeesRegistrationLocalService) {
		_dynamicFeesRegistrationLocalService = dynamicFeesRegistrationLocalService;
	}

	private DynamicFeesRegistrationLocalService _dynamicFeesRegistrationLocalService;
}