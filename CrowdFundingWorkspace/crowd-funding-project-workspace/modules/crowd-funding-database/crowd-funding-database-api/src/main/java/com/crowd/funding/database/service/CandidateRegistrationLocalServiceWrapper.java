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
 * Provides a wrapper for {@link CandidateRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistrationLocalService
 * @generated
 */
@ProviderType
public class CandidateRegistrationLocalServiceWrapper
	implements CandidateRegistrationLocalService,
		ServiceWrapper<CandidateRegistrationLocalService> {
	public CandidateRegistrationLocalServiceWrapper(
		CandidateRegistrationLocalService candidateRegistrationLocalService) {
		_candidateRegistrationLocalService = candidateRegistrationLocalService;
	}

	/**
	* Adds the candidate registration to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateRegistration the candidate registration
	* @return the candidate registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.CandidateRegistration addCandidateRegistration(
		com.crowd.funding.database.model.CandidateRegistration candidateRegistration) {
		return _candidateRegistrationLocalService.addCandidateRegistration(candidateRegistration);
	}

	/**
	* Creates a new candidate registration with the primary key. Does not add the candidate registration to the database.
	*
	* @param CANDIDATE_ID the primary key for the new candidate registration
	* @return the new candidate registration
	*/
	@Override
	public com.crowd.funding.database.model.CandidateRegistration createCandidateRegistration(
		long CANDIDATE_ID) {
		return _candidateRegistrationLocalService.createCandidateRegistration(CANDIDATE_ID);
	}

	/**
	* Deletes the candidate registration from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateRegistration the candidate registration
	* @return the candidate registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.CandidateRegistration deleteCandidateRegistration(
		com.crowd.funding.database.model.CandidateRegistration candidateRegistration) {
		return _candidateRegistrationLocalService.deleteCandidateRegistration(candidateRegistration);
	}

	/**
	* Deletes the candidate registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration that was removed
	* @throws PortalException if a candidate registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.CandidateRegistration deleteCandidateRegistration(
		long CANDIDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateRegistrationLocalService.deleteCandidateRegistration(CANDIDATE_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateRegistrationLocalService.dynamicQuery();
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
		return _candidateRegistrationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _candidateRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _candidateRegistrationLocalService.dynamicQuery(dynamicQuery,
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
		return _candidateRegistrationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.CandidateRegistration fetchCandidateRegistration(
		long CANDIDATE_ID) {
		return _candidateRegistrationLocalService.fetchCandidateRegistration(CANDIDATE_ID);
	}

	@Override
	public com.crowd.funding.database.model.CandidateRegistration findByCANDIDATE_ID(
		long CANDIDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return _candidateRegistrationLocalService.findByCANDIDATE_ID(CANDIDATE_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID) {
		return _candidateRegistrationLocalService.findByPOSITION_ID(POSITION_ID);
	}

	@Override
	public java.util.List<com.crowd.funding.database.model.CandidateRegistration> findBySTATUS(
		int STATUS) {
		return _candidateRegistrationLocalService.findBySTATUS(STATUS);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _candidateRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the candidate registration with the primary key.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration
	* @throws PortalException if a candidate registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.CandidateRegistration getCandidateRegistration(
		long CANDIDATE_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateRegistrationLocalService.getCandidateRegistration(CANDIDATE_ID);
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
	@Override
	public java.util.List<com.crowd.funding.database.model.CandidateRegistration> getCandidateRegistrations(
		int start, int end) {
		return _candidateRegistrationLocalService.getCandidateRegistrations(start,
			end);
	}

	/**
	* Returns the number of candidate registrations.
	*
	* @return the number of candidate registrations
	*/
	@Override
	public int getCandidateRegistrationsCount() {
		return _candidateRegistrationLocalService.getCandidateRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _candidateRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidateRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _candidateRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.crowd.funding.database.model.CandidateRegistrationRESUMEBlobModel getRESUMEBlobModel(
		java.io.Serializable primaryKey) {
		return _candidateRegistrationLocalService.getRESUMEBlobModel(primaryKey);
	}

	/**
	* Updates the candidate registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateRegistration the candidate registration
	* @return the candidate registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.CandidateRegistration updateCandidateRegistration(
		com.crowd.funding.database.model.CandidateRegistration candidateRegistration) {
		return _candidateRegistrationLocalService.updateCandidateRegistration(candidateRegistration);
	}

	@Override
	public CandidateRegistrationLocalService getWrappedService() {
		return _candidateRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateRegistrationLocalService candidateRegistrationLocalService) {
		_candidateRegistrationLocalService = candidateRegistrationLocalService;
	}

	private CandidateRegistrationLocalService _candidateRegistrationLocalService;
}