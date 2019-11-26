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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for HistoryLogRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.HistoryLogRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see HistoryLogRegistrationLocalService
 * @see com.crowd.funding.database.service.base.HistoryLogRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.HistoryLogRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.HistoryLogRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the history log registration to the database. Also notifies the appropriate model listeners.
	*
	* @param historyLogRegistration the history log registration
	* @return the history log registration that was added
	*/
	public static com.crowd.funding.database.model.HistoryLogRegistration addHistoryLogRegistration(
		com.crowd.funding.database.model.HistoryLogRegistration historyLogRegistration) {
		return getService().addHistoryLogRegistration(historyLogRegistration);
	}

	/**
	* Creates a new history log registration with the primary key. Does not add the history log registration to the database.
	*
	* @param HISTORY_ID the primary key for the new history log registration
	* @return the new history log registration
	*/
	public static com.crowd.funding.database.model.HistoryLogRegistration createHistoryLogRegistration(
		long HISTORY_ID) {
		return getService().createHistoryLogRegistration(HISTORY_ID);
	}

	/**
	* Deletes the history log registration from the database. Also notifies the appropriate model listeners.
	*
	* @param historyLogRegistration the history log registration
	* @return the history log registration that was removed
	*/
	public static com.crowd.funding.database.model.HistoryLogRegistration deleteHistoryLogRegistration(
		com.crowd.funding.database.model.HistoryLogRegistration historyLogRegistration) {
		return getService().deleteHistoryLogRegistration(historyLogRegistration);
	}

	/**
	* Deletes the history log registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration that was removed
	* @throws PortalException if a history log registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.HistoryLogRegistration deleteHistoryLogRegistration(
		long HISTORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteHistoryLogRegistration(HISTORY_ID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
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

	public static com.crowd.funding.database.model.HistoryLogRegistration fetchHistoryLogRegistration(
		long HISTORY_ID) {
		return getService().fetchHistoryLogRegistration(HISTORY_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.HistoryLogRegistration> findByUSER_ID(
		long USER_ID) {
		return getService().findByUSER_ID(USER_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the history log registration with the primary key.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration
	* @throws PortalException if a history log registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.HistoryLogRegistration getHistoryLogRegistration(
		long HISTORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getHistoryLogRegistration(HISTORY_ID);
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
	public static java.util.List<com.crowd.funding.database.model.HistoryLogRegistration> getHistoryLogRegistrations(
		int start, int end) {
		return getService().getHistoryLogRegistrations(start, end);
	}

	/**
	* Returns the number of history log registrations.
	*
	* @return the number of history log registrations
	*/
	public static int getHistoryLogRegistrationsCount() {
		return getService().getHistoryLogRegistrationsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the history log registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param historyLogRegistration the history log registration
	* @return the history log registration that was updated
	*/
	public static com.crowd.funding.database.model.HistoryLogRegistration updateHistoryLogRegistration(
		com.crowd.funding.database.model.HistoryLogRegistration historyLogRegistration) {
		return getService().updateHistoryLogRegistration(historyLogRegistration);
	}

	public static HistoryLogRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HistoryLogRegistrationLocalService, HistoryLogRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HistoryLogRegistrationLocalService.class);

		ServiceTracker<HistoryLogRegistrationLocalService, HistoryLogRegistrationLocalService> serviceTracker =
			new ServiceTracker<HistoryLogRegistrationLocalService, HistoryLogRegistrationLocalService>(bundle.getBundleContext(),
				HistoryLogRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}