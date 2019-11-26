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
 * Provides the local service utility for DynamicFeesRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.DynamicFeesRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistrationLocalService
 * @see com.crowd.funding.database.service.base.DynamicFeesRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.DynamicFeesRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.DynamicFeesRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dynamic fees registration to the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	* @return the dynamic fees registration that was added
	*/
	public static com.crowd.funding.database.model.DynamicFeesRegistration addDynamicFeesRegistration(
		com.crowd.funding.database.model.DynamicFeesRegistration dynamicFeesRegistration) {
		return getService().addDynamicFeesRegistration(dynamicFeesRegistration);
	}

	/**
	* Creates a new dynamic fees registration with the primary key. Does not add the dynamic fees registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new dynamic fees registration
	* @return the new dynamic fees registration
	*/
	public static com.crowd.funding.database.model.DynamicFeesRegistration createDynamicFeesRegistration(
		long CATEGORY_ID) {
		return getService().createDynamicFeesRegistration(CATEGORY_ID);
	}

	/**
	* Deletes the dynamic fees registration from the database. Also notifies the appropriate model listeners.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	* @return the dynamic fees registration that was removed
	*/
	public static com.crowd.funding.database.model.DynamicFeesRegistration deleteDynamicFeesRegistration(
		com.crowd.funding.database.model.DynamicFeesRegistration dynamicFeesRegistration) {
		return getService()
				   .deleteDynamicFeesRegistration(dynamicFeesRegistration);
	}

	/**
	* Deletes the dynamic fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration that was removed
	* @throws PortalException if a dynamic fees registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.DynamicFeesRegistration deleteDynamicFeesRegistration(
		long CATEGORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDynamicFeesRegistration(CATEGORY_ID);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.DynamicFeesRegistration fetchDynamicFeesRegistration(
		long CATEGORY_ID) {
		return getService().fetchDynamicFeesRegistration(CATEGORY_ID);
	}

	public static com.crowd.funding.database.model.DynamicFeesRegistration findByCATEGORY_ID(
		long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getService().findByCATEGORY_ID(CATEGORY_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the dynamic fees registration with the primary key.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration
	* @throws PortalException if a dynamic fees registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.DynamicFeesRegistration getDynamicFeesRegistration(
		long CATEGORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDynamicFeesRegistration(CATEGORY_ID);
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
	public static java.util.List<com.crowd.funding.database.model.DynamicFeesRegistration> getDynamicFeesRegistrations(
		int start, int end) {
		return getService().getDynamicFeesRegistrations(start, end);
	}

	/**
	* Returns the number of dynamic fees registrations.
	*
	* @return the number of dynamic fees registrations
	*/
	public static int getDynamicFeesRegistrationsCount() {
		return getService().getDynamicFeesRegistrationsCount();
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
	* Updates the dynamic fees registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	* @return the dynamic fees registration that was updated
	*/
	public static com.crowd.funding.database.model.DynamicFeesRegistration updateDynamicFeesRegistration(
		com.crowd.funding.database.model.DynamicFeesRegistration dynamicFeesRegistration) {
		return getService()
				   .updateDynamicFeesRegistration(dynamicFeesRegistration);
	}

	public static DynamicFeesRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DynamicFeesRegistrationLocalService, DynamicFeesRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DynamicFeesRegistrationLocalService.class);

		ServiceTracker<DynamicFeesRegistrationLocalService, DynamicFeesRegistrationLocalService> serviceTracker =
			new ServiceTracker<DynamicFeesRegistrationLocalService, DynamicFeesRegistrationLocalService>(bundle.getBundleContext(),
				DynamicFeesRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}