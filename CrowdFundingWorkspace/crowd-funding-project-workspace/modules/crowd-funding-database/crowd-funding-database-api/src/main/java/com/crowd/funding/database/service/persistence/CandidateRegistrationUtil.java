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

package com.crowd.funding.database.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.CandidateRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the candidate registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.CandidateRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.CandidateRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class CandidateRegistrationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CandidateRegistration candidateRegistration) {
		getPersistence().clearCache(candidateRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CandidateRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateRegistration update(
		CandidateRegistration candidateRegistration) {
		return getPersistence().update(candidateRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateRegistration update(
		CandidateRegistration candidateRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(candidateRegistration, serviceContext);
	}

	/**
	* Returns all the candidate registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching candidate registrations
	*/
	public static List<CandidateRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the candidate registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @return the range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the candidate registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findByUuid_First(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchByUuid_First(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findByUuid_Last(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the candidate registrations before and after the current candidate registration in the ordered set where uuid = &#63;.
	*
	* @param CANDIDATE_ID the primary key of the current candidate registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public static CandidateRegistration[] findByUuid_PrevAndNext(
		long CANDIDATE_ID, String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(CANDIDATE_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the candidate registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of candidate registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching candidate registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the candidate registration where CANDIDATE_ID = &#63; or throws a {@link NoSuchCandidateRegistrationException} if it could not be found.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findByCANDIDATE_ID(long CANDIDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().findByCANDIDATE_ID(CANDIDATE_ID);
	}

	/**
	* Returns the candidate registration where CANDIDATE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchByCANDIDATE_ID(long CANDIDATE_ID) {
		return getPersistence().fetchByCANDIDATE_ID(CANDIDATE_ID);
	}

	/**
	* Returns the candidate registration where CANDIDATE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param CANDIDATE_ID the candidate_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchByCANDIDATE_ID(long CANDIDATE_ID,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByCANDIDATE_ID(CANDIDATE_ID, retrieveFromCache);
	}

	/**
	* Removes the candidate registration where CANDIDATE_ID = &#63; from the database.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the candidate registration that was removed
	*/
	public static CandidateRegistration removeByCANDIDATE_ID(long CANDIDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().removeByCANDIDATE_ID(CANDIDATE_ID);
	}

	/**
	* Returns the number of candidate registrations where CANDIDATE_ID = &#63;.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the number of matching candidate registrations
	*/
	public static int countByCANDIDATE_ID(long CANDIDATE_ID) {
		return getPersistence().countByCANDIDATE_ID(CANDIDATE_ID);
	}

	/**
	* Returns all the candidate registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the matching candidate registrations
	*/
	public static List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID) {
		return getPersistence().findByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns a range of all the candidate registrations where POSITION_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param POSITION_ID the position_id
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @return the range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID, int start, int end) {
		return getPersistence().findByPOSITION_ID(POSITION_ID, start, end);
	}

	/**
	* Returns an ordered range of all the candidate registrations where POSITION_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param POSITION_ID the position_id
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID, int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence()
				   .findByPOSITION_ID(POSITION_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate registrations where POSITION_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param POSITION_ID the position_id
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID, int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPOSITION_ID(POSITION_ID, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findByPOSITION_ID_First(
		long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence()
				   .findByPOSITION_ID_First(POSITION_ID, orderByComparator);
	}

	/**
	* Returns the first candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchByPOSITION_ID_First(
		long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPOSITION_ID_First(POSITION_ID, orderByComparator);
	}

	/**
	* Returns the last candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findByPOSITION_ID_Last(
		long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence()
				   .findByPOSITION_ID_Last(POSITION_ID, orderByComparator);
	}

	/**
	* Returns the last candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchByPOSITION_ID_Last(
		long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPOSITION_ID_Last(POSITION_ID, orderByComparator);
	}

	/**
	* Returns the candidate registrations before and after the current candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param CANDIDATE_ID the primary key of the current candidate registration
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public static CandidateRegistration[] findByPOSITION_ID_PrevAndNext(
		long CANDIDATE_ID, long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence()
				   .findByPOSITION_ID_PrevAndNext(CANDIDATE_ID, POSITION_ID,
			orderByComparator);
	}

	/**
	* Removes all the candidate registrations where POSITION_ID = &#63; from the database.
	*
	* @param POSITION_ID the position_id
	*/
	public static void removeByPOSITION_ID(long POSITION_ID) {
		getPersistence().removeByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns the number of candidate registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the number of matching candidate registrations
	*/
	public static int countByPOSITION_ID(long POSITION_ID) {
		return getPersistence().countByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns all the candidate registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching candidate registrations
	*/
	public static List<CandidateRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

	/**
	* Returns a range of all the candidate registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @return the range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findBySTATUS(int STATUS,
		int start, int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the candidate registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching candidate registrations
	*/
	public static List<CandidateRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public static CandidateRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public static CandidateRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the candidate registrations before and after the current candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param CANDIDATE_ID the primary key of the current candidate registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public static CandidateRegistration[] findBySTATUS_PrevAndNext(
		long CANDIDATE_ID, int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(CANDIDATE_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the candidate registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of candidate registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching candidate registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Caches the candidate registration in the entity cache if it is enabled.
	*
	* @param candidateRegistration the candidate registration
	*/
	public static void cacheResult(CandidateRegistration candidateRegistration) {
		getPersistence().cacheResult(candidateRegistration);
	}

	/**
	* Caches the candidate registrations in the entity cache if it is enabled.
	*
	* @param candidateRegistrations the candidate registrations
	*/
	public static void cacheResult(
		List<CandidateRegistration> candidateRegistrations) {
		getPersistence().cacheResult(candidateRegistrations);
	}

	/**
	* Creates a new candidate registration with the primary key. Does not add the candidate registration to the database.
	*
	* @param CANDIDATE_ID the primary key for the new candidate registration
	* @return the new candidate registration
	*/
	public static CandidateRegistration create(long CANDIDATE_ID) {
		return getPersistence().create(CANDIDATE_ID);
	}

	/**
	* Removes the candidate registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration that was removed
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public static CandidateRegistration remove(long CANDIDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().remove(CANDIDATE_ID);
	}

	public static CandidateRegistration updateImpl(
		CandidateRegistration candidateRegistration) {
		return getPersistence().updateImpl(candidateRegistration);
	}

	/**
	* Returns the candidate registration with the primary key or throws a {@link NoSuchCandidateRegistrationException} if it could not be found.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public static CandidateRegistration findByPrimaryKey(long CANDIDATE_ID)
		throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
		return getPersistence().findByPrimaryKey(CANDIDATE_ID);
	}

	/**
	* Returns the candidate registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration, or <code>null</code> if a candidate registration with the primary key could not be found
	*/
	public static CandidateRegistration fetchByPrimaryKey(long CANDIDATE_ID) {
		return getPersistence().fetchByPrimaryKey(CANDIDATE_ID);
	}

	public static java.util.Map<java.io.Serializable, CandidateRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the candidate registrations.
	*
	* @return the candidate registrations
	*/
	public static List<CandidateRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the candidate registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @return the range of candidate registrations
	*/
	public static List<CandidateRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the candidate registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of candidate registrations
	*/
	public static List<CandidateRegistration> findAll(int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the candidate registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate registrations
	* @param end the upper bound of the range of candidate registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of candidate registrations
	*/
	public static List<CandidateRegistration> findAll(int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the candidate registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of candidate registrations.
	*
	* @return the number of candidate registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CandidateRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CandidateRegistrationPersistence, CandidateRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CandidateRegistrationPersistence.class);

		ServiceTracker<CandidateRegistrationPersistence, CandidateRegistrationPersistence> serviceTracker =
			new ServiceTracker<CandidateRegistrationPersistence, CandidateRegistrationPersistence>(bundle.getBundleContext(),
				CandidateRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}