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
 * Provides a wrapper for {@link HistoryLogRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HistoryLogRegistrationLocalService
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationLocalServiceWrapper
	implements HistoryLogRegistrationLocalService,
		ServiceWrapper<HistoryLogRegistrationLocalService> {
	public HistoryLogRegistrationLocalServiceWrapper(
		HistoryLogRegistrationLocalService historyLogRegistrationLocalService) {
		_historyLogRegistrationLocalService = historyLogRegistrationLocalService;
	}

	/**
	* Adds the history log registration to the database. Also notifies the appropriate model listeners.
	*
	* @param historyLogRegistration the history log registration
	* @return the history log registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration addHistoryLogRegistration(
		com.crowd.funding.database.model.HistoryLogRegistration historyLogRegistration) {
		return _historyLogRegistrationLocalService.addHistoryLogRegistration(historyLogRegistration);
	}

	/**
	* Creates a new history log registration with the primary key. Does not add the history log registration to the database.
	*
	* @param HISTORY_ID the primary key for the new history log registration
	* @return the new history log registration
	*/
	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration createHistoryLogRegistration(
		long HISTORY_ID) {
		return _historyLogRegistrationLocalService.createHistoryLogRegistration(HISTORY_ID);
	}

	/**
	* Deletes the history log registration from the database. Also notifies the appropriate model listeners.
	*
	* @param historyLogRegistration the history log registration
	* @return the history log registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration deleteHistoryLogRegistration(
		com.crowd.funding.database.model.HistoryLogRegistration historyLogRegistration) {
		return _historyLogRegistrationLocalService.deleteHistoryLogRegistration(historyLogRegistration);
	}

	/**
	* Deletes the history log registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration that was removed
	* @throws PortalException if a history log registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration deleteHistoryLogRegistration(
		long HISTORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _historyLogRegistrationLocalService.deleteHistoryLogRegistration(HISTORY_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _historyLogRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _historyLogRegistrationLocalService.dynamicQuery();
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
		return _historyLogRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _historyLogRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _historyLogRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _historyLogRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _historyLogRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration fetchHistoryLogRegistration(
		long HISTORY_ID) {
		return _historyLogRegistrationLocalService.fetchHistoryLogRegistration(HISTORY_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.HistoryLogRegistration> findByUSER_ID(
		long USER_ID) {
		return _historyLogRegistrationLocalService.findByUSER_ID(USER_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _historyLogRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the history log registration with the primary key.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration
	* @throws PortalException if a history log registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration getHistoryLogRegistration(
		long HISTORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _historyLogRegistrationLocalService.getHistoryLogRegistration(HISTORY_ID);
	}

	/**
	* Returns a range of all the history log registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @return the range of history log registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.HistoryLogRegistration> getHistoryLogRegistrations(
		int start, int end) {
		return _historyLogRegistrationLocalService.getHistoryLogRegistrations(start,
			end);
	}

	/**
	* Returns the number of history log registrations.
	*
	* @return the number of history log registrations
	*/
	@Override
	public int getHistoryLogRegistrationsCount() {
		return _historyLogRegistrationLocalService.getHistoryLogRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _historyLogRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _historyLogRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _historyLogRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the history log registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param historyLogRegistration the history log registration
	* @return the history log registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.HistoryLogRegistration updateHistoryLogRegistration(
		com.crowd.funding.database.model.HistoryLogRegistration historyLogRegistration) {
		return _historyLogRegistrationLocalService.updateHistoryLogRegistration(historyLogRegistration);
	}

	@Override
	public HistoryLogRegistrationLocalService getWrappedService() {
		return _historyLogRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		HistoryLogRegistrationLocalService historyLogRegistrationLocalService) {
		_historyLogRegistrationLocalService = historyLogRegistrationLocalService;
	}

	private HistoryLogRegistrationLocalService _historyLogRegistrationLocalService;
}