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
 * Provides the local service utility for BenificiaryRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.BenificiaryRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistrationLocalService
 * @see com.crowd.funding.database.service.base.BenificiaryRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.BenificiaryRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class BenificiaryRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.BenificiaryRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the benificiary registration to the database. Also notifies the appropriate model listeners.
	*
	* @param benificiaryRegistration the benificiary registration
	* @return the benificiary registration that was added
	*/
	public static com.crowd.funding.database.model.BenificiaryRegistration addBenificiaryRegistration(
		com.crowd.funding.database.model.BenificiaryRegistration benificiaryRegistration) {
		return getService().addBenificiaryRegistration(benificiaryRegistration);
	}

	/**
	* Creates a new benificiary registration with the primary key. Does not add the benificiary registration to the database.
	*
	* @param BENIFICIARY_ID the primary key for the new benificiary registration
	* @return the new benificiary registration
	*/
	public static com.crowd.funding.database.model.BenificiaryRegistration createBenificiaryRegistration(
		long BENIFICIARY_ID) {
		return getService().createBenificiaryRegistration(BENIFICIARY_ID);
	}

	/**
	* Deletes the benificiary registration from the database. Also notifies the appropriate model listeners.
	*
	* @param benificiaryRegistration the benificiary registration
	* @return the benificiary registration that was removed
	*/
	public static com.crowd.funding.database.model.BenificiaryRegistration deleteBenificiaryRegistration(
		com.crowd.funding.database.model.BenificiaryRegistration benificiaryRegistration) {
		return getService()
				   .deleteBenificiaryRegistration(benificiaryRegistration);
	}

	/**
	* Deletes the benificiary registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration that was removed
	* @throws PortalException if a benificiary registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.BenificiaryRegistration deleteBenificiaryRegistration(
		long BENIFICIARY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteBenificiaryRegistration(BENIFICIARY_ID);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.BenificiaryRegistration fetchBenificiaryRegistration(
		long BENIFICIARY_ID) {
		return getService().fetchBenificiaryRegistration(BENIFICIARY_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.BenificiaryRegistration> findByBENIFICIARY_CATEGORY(
		String BENIFICIARY_CATEGORY) {
		return getService().findByBENIFICIARY_CATEGORY(BENIFICIARY_CATEGORY);
	}

	public static com.crowd.funding.database.model.BenificiaryRegistration findByBENIFICIARY_ID(
		long BENIFICIARY_ID)
		throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
		return getService().findByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.BenificiaryRegistration> findByCAUSE_BENIFICIARY_CATEGORY(
		String CAUSE_DETAILS, String BENIFICIARY_CATEGORY) {
		return getService()
				   .findByCAUSE_BENIFICIARY_CATEGORY(CAUSE_DETAILS,
			BENIFICIARY_CATEGORY);
	}

	public static java.util.List<com.crowd.funding.database.model.BenificiaryRegistration> findByCAUSE_DETAILS(
		String CAUSE_DETAILS) {
		return getService().findByCAUSE_DETAILS(CAUSE_DETAILS);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the benificiary registration with the primary key.
	*
	* @param BENIFICIARY_ID the primary key of the benificiary registration
	* @return the benificiary registration
	* @throws PortalException if a benificiary registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.BenificiaryRegistration getBenificiaryRegistration(
		long BENIFICIARY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getBenificiaryRegistration(BENIFICIARY_ID);
	}

	/**
	* Returns a range of all the benificiary registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.BenificiaryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of benificiary registrations
	* @param end the upper bound of the range of benificiary registrations (not inclusive)
	* @return the range of benificiary registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.BenificiaryRegistration> getBenificiaryRegistrations(
		int start, int end) {
		return getService().getBenificiaryRegistrations(start, end);
	}

	/**
	* Returns the number of benificiary registrations.
	*
	* @return the number of benificiary registrations
	*/
	public static int getBenificiaryRegistrationsCount() {
		return getService().getBenificiaryRegistrationsCount();
	}

	public static com.crowd.funding.database.model.BenificiaryRegistrationIMAGEBlobModel getIMAGEBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getIMAGEBlobModel(primaryKey);
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
	* Updates the benificiary registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param benificiaryRegistration the benificiary registration
	* @return the benificiary registration that was updated
	*/
	public static com.crowd.funding.database.model.BenificiaryRegistration updateBenificiaryRegistration(
		com.crowd.funding.database.model.BenificiaryRegistration benificiaryRegistration) {
		return getService()
				   .updateBenificiaryRegistration(benificiaryRegistration);
	}

	public static BenificiaryRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BenificiaryRegistrationLocalService, BenificiaryRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BenificiaryRegistrationLocalService.class);

		ServiceTracker<BenificiaryRegistrationLocalService, BenificiaryRegistrationLocalService> serviceTracker =
			new ServiceTracker<BenificiaryRegistrationLocalService, BenificiaryRegistrationLocalService>(bundle.getBundleContext(),
				BenificiaryRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}