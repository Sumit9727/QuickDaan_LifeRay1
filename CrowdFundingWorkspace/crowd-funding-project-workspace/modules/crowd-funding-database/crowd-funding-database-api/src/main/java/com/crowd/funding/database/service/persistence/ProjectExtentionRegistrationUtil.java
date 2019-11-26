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

import com.crowd.funding.database.model.ProjectExtentionRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project extention registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectExtentionRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectExtentionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectExtentionRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectExtentionRegistrationUtil {
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
	public static void clearCache(
		ProjectExtentionRegistration projectExtentionRegistration) {
		getPersistence().clearCache(projectExtentionRegistration);
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
	public static List<ProjectExtentionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectExtentionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectExtentionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectExtentionRegistration update(
		ProjectExtentionRegistration projectExtentionRegistration) {
		return getPersistence().update(projectExtentionRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectExtentionRegistration update(
		ProjectExtentionRegistration projectExtentionRegistration,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(projectExtentionRegistration, serviceContext);
	}

	/**
	* Returns all the project extention registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project extention registrations
	*/
	public static List<ProjectExtentionRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProjectExtentionRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProjectExtentionRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ProjectExtentionRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project extention registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project extention registrations before and after the current project extention registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public static ProjectExtentionRegistration[] findByUuid_PrevAndNext(
		long PROJECT_EXTENTION_ID, String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_EXTENTION_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project extention registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project extention registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project extention registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the project extention registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project extention registrations
	*/
	public static List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

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
	public static List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

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
	public static List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

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
	public static List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the project extention registrations before and after the current project extention registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public static ProjectExtentionRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_EXTENTION_ID, long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_EXTENTION_ID,
			PROJECT_ID, orderByComparator);
	}

	/**
	* Removes all the project extention registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project extention registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project extention registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns all the project extention registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching project extention registrations
	*/
	public static List<ProjectExtentionRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

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
	public static List<ProjectExtentionRegistration> findBySTATUS(int STATUS,
		int start, int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

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
	public static List<ProjectExtentionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

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
	public static List<ProjectExtentionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	*/
	public static ProjectExtentionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the project extention registrations before and after the current project extention registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public static ProjectExtentionRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_EXTENTION_ID, int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(PROJECT_EXTENTION_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the project extention registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of project extention registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching project extention registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Caches the project extention registration in the entity cache if it is enabled.
	*
	* @param projectExtentionRegistration the project extention registration
	*/
	public static void cacheResult(
		ProjectExtentionRegistration projectExtentionRegistration) {
		getPersistence().cacheResult(projectExtentionRegistration);
	}

	/**
	* Caches the project extention registrations in the entity cache if it is enabled.
	*
	* @param projectExtentionRegistrations the project extention registrations
	*/
	public static void cacheResult(
		List<ProjectExtentionRegistration> projectExtentionRegistrations) {
		getPersistence().cacheResult(projectExtentionRegistrations);
	}

	/**
	* Creates a new project extention registration with the primary key. Does not add the project extention registration to the database.
	*
	* @param PROJECT_EXTENTION_ID the primary key for the new project extention registration
	* @return the new project extention registration
	*/
	public static ProjectExtentionRegistration create(long PROJECT_EXTENTION_ID) {
		return getPersistence().create(PROJECT_EXTENTION_ID);
	}

	/**
	* Removes the project extention registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration that was removed
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public static ProjectExtentionRegistration remove(long PROJECT_EXTENTION_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence().remove(PROJECT_EXTENTION_ID);
	}

	public static ProjectExtentionRegistration updateImpl(
		ProjectExtentionRegistration projectExtentionRegistration) {
		return getPersistence().updateImpl(projectExtentionRegistration);
	}

	/**
	* Returns the project extention registration with the primary key or throws a {@link NoSuchProjectExtentionRegistrationException} if it could not be found.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration
	* @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	*/
	public static ProjectExtentionRegistration findByPrimaryKey(
		long PROJECT_EXTENTION_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_EXTENTION_ID);
	}

	/**
	* Returns the project extention registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	* @return the project extention registration, or <code>null</code> if a project extention registration with the primary key could not be found
	*/
	public static ProjectExtentionRegistration fetchByPrimaryKey(
		long PROJECT_EXTENTION_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_EXTENTION_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectExtentionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project extention registrations.
	*
	* @return the project extention registrations
	*/
	public static List<ProjectExtentionRegistration> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectExtentionRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectExtentionRegistration> findAll(int start,
		int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectExtentionRegistration> findAll(int start,
		int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project extention registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project extention registrations.
	*
	* @return the number of project extention registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectExtentionRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectExtentionRegistrationPersistence, ProjectExtentionRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectExtentionRegistrationPersistence.class);

		ServiceTracker<ProjectExtentionRegistrationPersistence, ProjectExtentionRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectExtentionRegistrationPersistence, ProjectExtentionRegistrationPersistence>(bundle.getBundleContext(),
				ProjectExtentionRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}