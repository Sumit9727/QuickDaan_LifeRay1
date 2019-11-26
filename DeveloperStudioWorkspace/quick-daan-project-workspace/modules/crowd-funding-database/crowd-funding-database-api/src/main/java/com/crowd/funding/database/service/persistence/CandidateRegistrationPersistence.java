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

import com.crowd.funding.database.exception.NoSuchCandidateRegistrationException;
import com.crowd.funding.database.model.CandidateRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the candidate registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.CandidateRegistrationPersistenceImpl
 * @see CandidateRegistrationUtil
 * @generated
 */
@ProviderType
public interface CandidateRegistrationPersistence extends BasePersistence<CandidateRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateRegistrationUtil} to access the candidate registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the candidate registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching candidate registrations
	*/
	public java.util.List<CandidateRegistration> findByUuid(String uuid);

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
	public java.util.List<CandidateRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<CandidateRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

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
	public java.util.List<CandidateRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the first candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

	/**
	* Returns the last candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the last candidate registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

	/**
	* Returns the candidate registrations before and after the current candidate registration in the ordered set where uuid = &#63;.
	*
	* @param CANDIDATE_ID the primary key of the current candidate registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public CandidateRegistration[] findByUuid_PrevAndNext(long CANDIDATE_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Removes all the candidate registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of candidate registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching candidate registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the candidate registration where CANDIDATE_ID = &#63; or throws a {@link NoSuchCandidateRegistrationException} if it could not be found.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findByCANDIDATE_ID(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the candidate registration where CANDIDATE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchByCANDIDATE_ID(long CANDIDATE_ID);

	/**
	* Returns the candidate registration where CANDIDATE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param CANDIDATE_ID the candidate_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchByCANDIDATE_ID(long CANDIDATE_ID,
		boolean retrieveFromCache);

	/**
	* Removes the candidate registration where CANDIDATE_ID = &#63; from the database.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the candidate registration that was removed
	*/
	public CandidateRegistration removeByCANDIDATE_ID(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the number of candidate registrations where CANDIDATE_ID = &#63;.
	*
	* @param CANDIDATE_ID the candidate_id
	* @return the number of matching candidate registrations
	*/
	public int countByCANDIDATE_ID(long CANDIDATE_ID);

	/**
	* Returns all the candidate registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the matching candidate registrations
	*/
	public java.util.List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID);

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
	public java.util.List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID, int start, int end);

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
	public java.util.List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

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
	public java.util.List<CandidateRegistration> findByPOSITION_ID(
		long POSITION_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findByPOSITION_ID_First(long POSITION_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the first candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchByPOSITION_ID_First(long POSITION_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

	/**
	* Returns the last candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findByPOSITION_ID_Last(long POSITION_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the last candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchByPOSITION_ID_Last(long POSITION_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

	/**
	* Returns the candidate registrations before and after the current candidate registration in the ordered set where POSITION_ID = &#63;.
	*
	* @param CANDIDATE_ID the primary key of the current candidate registration
	* @param POSITION_ID the position_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public CandidateRegistration[] findByPOSITION_ID_PrevAndNext(
		long CANDIDATE_ID, long POSITION_ID,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Removes all the candidate registrations where POSITION_ID = &#63; from the database.
	*
	* @param POSITION_ID the position_id
	*/
	public void removeByPOSITION_ID(long POSITION_ID);

	/**
	* Returns the number of candidate registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the number of matching candidate registrations
	*/
	public int countByPOSITION_ID(long POSITION_ID);

	/**
	* Returns all the candidate registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching candidate registrations
	*/
	public java.util.List<CandidateRegistration> findBySTATUS(int STATUS);

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
	public java.util.List<CandidateRegistration> findBySTATUS(int STATUS,
		int start, int end);

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
	public java.util.List<CandidateRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

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
	public java.util.List<CandidateRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the first candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

	/**
	* Returns the last candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration
	* @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	*/
	public CandidateRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the last candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	*/
	public CandidateRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

	/**
	* Returns the candidate registrations before and after the current candidate registration in the ordered set where STATUS = &#63;.
	*
	* @param CANDIDATE_ID the primary key of the current candidate registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public CandidateRegistration[] findBySTATUS_PrevAndNext(long CANDIDATE_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException;

	/**
	* Removes all the candidate registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of candidate registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching candidate registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Caches the candidate registration in the entity cache if it is enabled.
	*
	* @param candidateRegistration the candidate registration
	*/
	public void cacheResult(CandidateRegistration candidateRegistration);

	/**
	* Caches the candidate registrations in the entity cache if it is enabled.
	*
	* @param candidateRegistrations the candidate registrations
	*/
	public void cacheResult(
		java.util.List<CandidateRegistration> candidateRegistrations);

	/**
	* Creates a new candidate registration with the primary key. Does not add the candidate registration to the database.
	*
	* @param CANDIDATE_ID the primary key for the new candidate registration
	* @return the new candidate registration
	*/
	public CandidateRegistration create(long CANDIDATE_ID);

	/**
	* Removes the candidate registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration that was removed
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public CandidateRegistration remove(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException;

	public CandidateRegistration updateImpl(
		CandidateRegistration candidateRegistration);

	/**
	* Returns the candidate registration with the primary key or throws a {@link NoSuchCandidateRegistrationException} if it could not be found.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration
	* @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	*/
	public CandidateRegistration findByPrimaryKey(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException;

	/**
	* Returns the candidate registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CANDIDATE_ID the primary key of the candidate registration
	* @return the candidate registration, or <code>null</code> if a candidate registration with the primary key could not be found
	*/
	public CandidateRegistration fetchByPrimaryKey(long CANDIDATE_ID);

	@Override
	public java.util.Map<java.io.Serializable, CandidateRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the candidate registrations.
	*
	* @return the candidate registrations
	*/
	public java.util.List<CandidateRegistration> findAll();

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
	public java.util.List<CandidateRegistration> findAll(int start, int end);

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
	public java.util.List<CandidateRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator);

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
	public java.util.List<CandidateRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the candidate registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of candidate registrations.
	*
	* @return the number of candidate registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}