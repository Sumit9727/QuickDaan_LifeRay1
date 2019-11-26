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

import com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException;
import com.crowd.funding.database.model.ProjectExtentionRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the project extention registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.ProjectExtentionRegistrationPersistenceImpl
 * @see ProjectExtentionRegistrationUtil
 * @generated
 */
@ProviderType
public interface ProjectExtentionRegistrationPersistence extends BasePersistence<ProjectExtentionRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectExtentionRegistrationUtil} to access the project extention registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the project extention registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the project extention registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @return the range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByUuid(
		String uuid, int start, int end);

	/**
	* Returns an ordered range of all the project extention registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project extention registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the first project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns the last project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the last project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns the project extention registrations before and after the current project extention registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public ProjectExtentionRegistration[] findByUuid_PrevAndNext(
		long PROJECT_EXTENTION_ID, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Removes all the project extention registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of project extention registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project extention registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns all the project extention registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID);

	/**
	* Returns a range of all the project extention registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @return the range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end);

	/**
	* Returns an ordered range of all the project extention registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project extention registrations where PROJECT_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param PROJECT_ID the project_id
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the first project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns the last project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the last project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns the project extention registrations before and after the current project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public ProjectExtentionRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_EXTENTION_ID, long PROJECT_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Removes all the project extention registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public void removeByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns the number of project extention registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project extention registrations
	*/
	public int countByPROJECT_ID(long PROJECT_ID);

	/**
	* Returns all the project extention registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findBySTATUS(int STATUS);

	/**
	* Returns a range of all the project extention registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @return the range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findBySTATUS(
		int STATUS, int start, int end);

	/**
	* Returns an ordered range of all the project extention registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findBySTATUS(
		int STATUS, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project extention registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findBySTATUS(
		int STATUS, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the first project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns the last project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the last project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public ProjectExtentionRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns the project extention registrations before and after the current project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public ProjectExtentionRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_EXTENTION_ID, int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Removes all the project extention registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of project extention registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching project extention registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Caches the project extention registration in the entity cache if it is enabled.
	*
	* @param projectExtentionRegistration the project extention registration
	*/
	public void cacheResult(
		ProjectExtentionRegistration projectExtentionRegistration);

	/**
	* Caches the project extention registrations in the entity cache if it is enabled.
	*
	* @param projectExtentionRegistrations the project extention registrations
	*/
	public void cacheResult(
		java.util.List<ProjectExtentionRegistration> projectExtentionRegistrations);

	/**
	* Creates a new project extention registration with the primary key. Does not add the project extention registration to the database.
	*
	* @param PROJECT_EXTENTION_ID the primary key for the new project extention registration
	* @return the new project extention registration
	*/
	public ProjectExtentionRegistration create(long PROJECT_EXTENTION_ID);

	/**
	* Removes the project extention registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration that was removed
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public ProjectExtentionRegistration remove(long PROJECT_EXTENTION_ID)
		throws NoSuchProjectExtentionRegistrationException;

	public ProjectExtentionRegistration updateImpl(
		ProjectExtentionRegistration projectExtentionRegistration);

	/**
	* Returns the project extention registration with the primary key or throws a {@link NoSuchProjectExtentionRegistrationException} if it could not be found.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public ProjectExtentionRegistration findByPrimaryKey(
		long PROJECT_EXTENTION_ID)
		throws NoSuchProjectExtentionRegistrationException;

	/**
	* Returns the project extention registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration, or <code>null</code> if a project extention registration with the primary key could not be found
	*/
	public ProjectExtentionRegistration fetchByPrimaryKey(
		long PROJECT_EXTENTION_ID);

	@Override
	public java.util.Map<java.io.Serializable, ProjectExtentionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the project extention registrations.
	*
	* @return the project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findAll();

	/**
	* Returns a range of all the project extention registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @return the range of project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findAll(int start,
		int end);

	/**
	* Returns an ordered range of all the project extention registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the project extention registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project extention registrations
	* @param end the upper bound of the range of project extention registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project extention registrations
	*/
	public java.util.List<ProjectExtentionRegistration> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the project extention registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of project extention registrations.
	*
	* @return the number of project extention registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}