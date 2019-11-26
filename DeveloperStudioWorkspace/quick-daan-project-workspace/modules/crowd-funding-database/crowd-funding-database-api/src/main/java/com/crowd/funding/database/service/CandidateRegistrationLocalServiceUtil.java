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
 * Provides the local service utility for CandidateRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.CandidateRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistrationLocalService
 * @see com.crowd.funding.database.service.base.CandidateRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.CandidateRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class CandidateRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.CandidateRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the candidate registration to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateRegistration the candidate registration
	* @return the candidate registration that was added
	*/
	public static com.crowd.funding.database.model.CandidateRegistration addCandidateRegistration(
		com.crowd.funding.database.model.CandidateRegistration candidateRegistration) {
		return getService().addCandidateRegistration(candidateRegistration);
	}

	/**
	* Creates a new candidate registration with the primary key. Does not add the candidate registration to the database.
	*
	* @param CANDIDATE_ID the primary key for the new candidate registration
	* @return the new candidate registration
	*/
	public static com.crowd.funding.database.model.CandidateRegistration createCandidateRegistration(
		long CANDIDATE_ID) {
		return getService().createCandidateRegistration(CANDIDATE_ID);
	}

	/**
	* Deletes the candidate registration from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateRegistration the candidate registration
	* @return the candidate registration that was removed
	*/
	public static com.crowd.funding.database.model.CandidateRegistration deleteCandidateRegistration(
		com.crowd.funding.database.model.CandidateRegistration candidateRegistration) {
		return getService().deleteCandidateRegistration(candidateRegistration);
	}

	/**
	* Deletes the candidate registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration that was removed
	* @throws PortalException if a candidate registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.CandidateRegistration deleteCandidateRegistration(
		long CANDIDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCandidateRegistration(CANDIDATE_ID);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.crowd.funding.database.model.CandidateRegistration fetchCandidateRegistration(
		long CANDIDATE_ID) {
		return getService().fetchCandidateRegistration(CANDIDATE_ID);
	}

	public static com.crowd.funding.database.model.CandidateRegistration findByCANDIDATE_ID(
		long CANDIDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getService().findByCANDIDATE_ID(CANDIDATE_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID) {
		return getService().findByPOSITION_ID(POSITION_ID);
	}

	public static java.util.List<com.crowd.funding.database.model.CandidateRegistration> findBySTATUS(
		int STATUS) {
		return getService().findBySTATUS(STATUS);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the candidate registration with the primary key.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration
	* @throws PortalException if a candidate registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.CandidateRegistration getCandidateRegistration(
		long CANDIDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCandidateRegistration(CANDIDATE_ID);
	}

	/**
	* Returns a range of all the candidate registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @return the range of candidate registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.CandidateRegistration> getCandidateRegistrations(
		int start, int end) {
		return getService().getCandidateRegistrations(start, end);
	}

	/**
	* Returns the number of candidate registrations.
	*
	* @return the number of candidate registrations
	*/
	public static int getCandidateRegistrationsCount() {
		return getService().getCandidateRegistrationsCount();
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

	public static com.crowd.funding.database.model.CandidateRegistrationRESUMEBlobModel getRESUMEBlobModel(
		java.io.Serializable primaryKey) {
		return getService().getRESUMEBlobModel(primaryKey);
	}

	/**
	* Updates the candidate registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateRegistration the candidate registration
	* @return the candidate registration that was updated
	*/
	public static com.crowd.funding.database.model.CandidateRegistration updateCandidateRegistration(
		com.crowd.funding.database.model.CandidateRegistration candidateRegistration) {
		return getService().updateCandidateRegistration(candidateRegistration);
	}

	public static CandidateRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateRegistrationLocalService, CandidateRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CandidateRegistrationLocalService.class);

		ServiceTracker<CandidateRegistrationLocalService, CandidateRegistrationLocalService> serviceTracker =
			new ServiceTracker<CandidateRegistrationLocalService, CandidateRegistrationLocalService>(bundle.getBundleContext(),
				CandidateRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}