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

import com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException;
import com.crowd.funding.database.model.ProjectFeesRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project fees registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectFeesRegistrationPersistenceImpl
 * @see ProjectFeesRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectFeesRegistrationPersistence extends BasePersistence<ProjectFeesRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectFeesRegistrationUtil} to access the project fees registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the project fees registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @return the range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the project fees registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project fees registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the first project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns the last project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the last project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns the project fees registrations before and after the current project fees registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FEES_ID the primary key of the current project fees registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public ProjectFeesRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FEES_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Removes all the project fees registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project fees registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the project fees registration where PROJECT_FEES_ID = &#63; or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByPROJECT_FEES_ID(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the project fees registration where PROJECT_FEES_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByPROJECT_FEES_ID(long PROJECT_FEES_ID);

	/**
	* Returns the project fees registration where PROJECT_FEES_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByPROJECT_FEES_ID(
		long PROJECT_FEES_ID, boolean retrieveFromCache);

	/**
	* Removes the project fees registration where PROJECT_FEES_ID = &#63; from the database.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the project fees registration that was removed
	*/
	public ProjectFeesRegistration removeByPROJECT_FEES_ID(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the number of project fees registrations where PROJECT_FEES_ID = &#63;.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the number of matching project fees registrations
	*/
	public int countByPROJECT_FEES_ID(long PROJECT_FEES_ID);

	/**
	* Returns all the project fees registrations where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @return the matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID);

	/**
	* Returns a range of all the project fees registrations where CATEGORY_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CATEGORY_ID the category_id
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @return the range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID, int start, int end);

	/**
	* Returns an ordered range of all the project fees registrations where CATEGORY_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CATEGORY_ID the category_id
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project fees registrations where CATEGORY_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CATEGORY_ID the category_id
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByCATEGORY_ID_First(long CATEGORY_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the first project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByCATEGORY_ID_First(long CATEGORY_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns the last project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByCATEGORY_ID_Last(long CATEGORY_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the last project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByCATEGORY_ID_Last(long CATEGORY_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns the project fees registrations before and after the current project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param PROJECT_FEES_ID the primary key of the current project fees registration
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public ProjectFeesRegistration[] findByCATEGORY_ID_PrevAndNext(
		long PROJECT_FEES_ID, long CATEGORY_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Removes all the project fees registrations where CATEGORY_ID = &#63; from the database.
	*
	* @param CATEGORY_ID the category_id
	*/
	public void removeByCATEGORY_ID(long CATEGORY_ID);

	/**
	* Returns the number of project fees registrations where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @return the number of matching project fees registrations
	*/
	public int countByCATEGORY_ID(long CATEGORY_ID);

	/**
	* Returns all the project fees registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the project fees registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @return the range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the project fees registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project fees registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the first project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns the last project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the last project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns the project fees registrations before and after the current project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FEES_ID the primary key of the current project fees registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public ProjectFeesRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FEES_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Removes all the project fees registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of project fees registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project fees registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration findByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID);

	/**
	* Returns the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public ProjectFeesRegistration fetchByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID, boolean retrieveFromCache);

	/**
	* Removes the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the project fees registration that was removed
	*/
	public ProjectFeesRegistration removeByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the number of project fees registrations where PROJECT_ID = &#63; and CATEGORY_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the number of matching project fees registrations
	*/
	public int countByPROJECT_FUND_Category_ID(long PROJECT_ID, long CATEGORY_ID);

	/**
	* Caches the project fees registration in the entity cache if it is enabled.
	*
	* @param projectFeesRegistration the project fees registration
	*/
	public void cacheResult(ProjectFeesRegistration projectFeesRegistration);

	/**
	* Caches the project fees registrations in the entity cache if it is enabled.
	*
	* @param projectFeesRegistrations the project fees registrations
	*/
	public void cacheResult(
		java.util.List<ProjectFeesRegistration> projectFeesRegistrations);

	/**
	* Creates a new project fees registration with the primary key. Does not add the project fees registration to the database.
	*
	* @param PROJECT_FEES_ID the primary key for the new project fees registration
	* @return the new project fees registration
	*/
	public ProjectFeesRegistration create(long PROJECT_FEES_ID);

	/**
	* Removes the project fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration that was removed
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public ProjectFeesRegistration remove(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException;

	public ProjectFeesRegistration updateImpl(
		ProjectFeesRegistration projectFeesRegistration);

	/**
	* Returns the project fees registration with the primary key or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public ProjectFeesRegistration findByPrimaryKey(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException;

	/**
	* Returns the project fees registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration, or <code>null</code> if a project fees registration with the primary key could not be found
	*/
	public ProjectFeesRegistration fetchByPrimaryKey(long PROJECT_FEES_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectFeesRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project fees registrations.
	*
	* @return the project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findAll();

	/**
	* Returns a range of all the project fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @return the range of project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the project fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project fees registrations
	* @param end the upper bound of the range of project fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project fees registrations
	*/
	public java.util.List<ProjectFeesRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project fees registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project fees registrations.
	*
	* @return the number of project fees registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}