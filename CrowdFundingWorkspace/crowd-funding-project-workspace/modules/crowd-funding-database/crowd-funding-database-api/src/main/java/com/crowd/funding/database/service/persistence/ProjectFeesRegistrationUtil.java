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

import com.crowd.funding.database.model.ProjectFeesRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the project fees registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectFeesRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectFeesRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectFeesRegistrationUtil {
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
		ProjectFeesRegistration projectFeesRegistration) {
		getPersistence().clearCache(projectFeesRegistration);
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
	public static List<ProjectFeesRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectFeesRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectFeesRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectFeesRegistration update(
		ProjectFeesRegistration projectFeesRegistration) {
		return getPersistence().update(projectFeesRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectFeesRegistration update(
		ProjectFeesRegistration projectFeesRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(projectFeesRegistration, serviceContext);
	}

	/**
	* Returns all the project fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project fees registrations
	*/
	public static List<ProjectFeesRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProjectFeesRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProjectFeesRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ProjectFeesRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project fees registrations before and after the current project fees registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_FEES_ID the primary key of the current project fees registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public static ProjectFeesRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FEES_ID, String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_FEES_ID, uuid,
			orderByComparator);
	}

	/**
	* Removes all the project fees registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project fees registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project fees registration where PROJECT_FEES_ID = &#63; or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByPROJECT_FEES_ID(
		long PROJECT_FEES_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence().findByPROJECT_FEES_ID(PROJECT_FEES_ID);
	}

	/**
	* Returns the project fees registration where PROJECT_FEES_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByPROJECT_FEES_ID(
		long PROJECT_FEES_ID) {
		return getPersistence().fetchByPROJECT_FEES_ID(PROJECT_FEES_ID);
	}

	/**
	* Returns the project fees registration where PROJECT_FEES_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByPROJECT_FEES_ID(
		long PROJECT_FEES_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_FEES_ID(PROJECT_FEES_ID, retrieveFromCache);
	}

	/**
	* Removes the project fees registration where PROJECT_FEES_ID = &#63; from the database.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the project fees registration that was removed
	*/
	public static ProjectFeesRegistration removeByPROJECT_FEES_ID(
		long PROJECT_FEES_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence().removeByPROJECT_FEES_ID(PROJECT_FEES_ID);
	}

	/**
	* Returns the number of project fees registrations where PROJECT_FEES_ID = &#63;.
	*
	* @param PROJECT_FEES_ID the project_fees_id
	* @return the number of matching project fees registrations
	*/
	public static int countByPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		return getPersistence().countByPROJECT_FEES_ID(PROJECT_FEES_ID);
	}

	/**
	* Returns all the project fees registrations where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @return the matching project fees registrations
	*/
	public static List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID) {
		return getPersistence().findByCATEGORY_ID(CATEGORY_ID);
	}

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
	public static List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID, int start, int end) {
		return getPersistence().findByCATEGORY_ID(CATEGORY_ID, start, end);
	}

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
	public static List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID, int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .findByCATEGORY_ID(CATEGORY_ID, start, end, orderByComparator);
	}

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
	public static List<ProjectFeesRegistration> findByCATEGORY_ID(
		long CATEGORY_ID, int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCATEGORY_ID(CATEGORY_ID, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByCATEGORY_ID_First(
		long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByCATEGORY_ID_First(CATEGORY_ID, orderByComparator);
	}

	/**
	* Returns the first project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByCATEGORY_ID_First(
		long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByCATEGORY_ID_First(CATEGORY_ID, orderByComparator);
	}

	/**
	* Returns the last project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByCATEGORY_ID_Last(
		long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByCATEGORY_ID_Last(CATEGORY_ID, orderByComparator);
	}

	/**
	* Returns the last project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByCATEGORY_ID_Last(
		long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByCATEGORY_ID_Last(CATEGORY_ID, orderByComparator);
	}

	/**
	* Returns the project fees registrations before and after the current project fees registration in the ordered set where CATEGORY_ID = &#63;.
	*
	* @param PROJECT_FEES_ID the primary key of the current project fees registration
	* @param CATEGORY_ID the category_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public static ProjectFeesRegistration[] findByCATEGORY_ID_PrevAndNext(
		long PROJECT_FEES_ID, long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByCATEGORY_ID_PrevAndNext(PROJECT_FEES_ID, CATEGORY_ID,
			orderByComparator);
	}

	/**
	* Removes all the project fees registrations where CATEGORY_ID = &#63; from the database.
	*
	* @param CATEGORY_ID the category_id
	*/
	public static void removeByCATEGORY_ID(long CATEGORY_ID) {
		getPersistence().removeByCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Returns the number of project fees registrations where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @return the number of matching project fees registrations
	*/
	public static int countByCATEGORY_ID(long CATEGORY_ID) {
		return getPersistence().countByCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Returns all the project fees registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project fees registrations
	*/
	public static List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

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
	public static List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return getPersistence().findByPROJECT_ID(PROJECT_ID, start, end);
	}

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
	public static List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator);
	}

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
	public static List<ProjectFeesRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the first project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_First(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the last project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByPROJECT_ID_Last(PROJECT_ID, orderByComparator);
	}

	/**
	* Returns the project fees registrations before and after the current project fees registration in the ordered set where PROJECT_ID = &#63;.
	*
	* @param PROJECT_FEES_ID the primary key of the current project fees registration
	* @param PROJECT_ID the project_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public static ProjectFeesRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FEES_ID, long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByPROJECT_ID_PrevAndNext(PROJECT_FEES_ID, PROJECT_ID,
			orderByComparator);
	}

	/**
	* Removes all the project fees registrations where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	*/
	public static void removeByPROJECT_ID(long PROJECT_ID) {
		getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project fees registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project fees registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the matching project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration findByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .findByPROJECT_FUND_Category_ID(PROJECT_ID, CATEGORY_ID);
	}

	/**
	* Returns the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID) {
		return getPersistence()
				   .fetchByPROJECT_FUND_Category_ID(PROJECT_ID, CATEGORY_ID);
	}

	/**
	* Returns the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	*/
	public static ProjectFeesRegistration fetchByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPROJECT_FUND_Category_ID(PROJECT_ID, CATEGORY_ID,
			retrieveFromCache);
	}

	/**
	* Removes the project fees registration where PROJECT_ID = &#63; and CATEGORY_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the project fees registration that was removed
	*/
	public static ProjectFeesRegistration removeByPROJECT_FUND_Category_ID(
		long PROJECT_ID, long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence()
				   .removeByPROJECT_FUND_Category_ID(PROJECT_ID, CATEGORY_ID);
	}

	/**
	* Returns the number of project fees registrations where PROJECT_ID = &#63; and CATEGORY_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @param CATEGORY_ID the category_id
	* @return the number of matching project fees registrations
	*/
	public static int countByPROJECT_FUND_Category_ID(long PROJECT_ID,
		long CATEGORY_ID) {
		return getPersistence()
				   .countByPROJECT_FUND_Category_ID(PROJECT_ID, CATEGORY_ID);
	}

	/**
	* Caches the project fees registration in the entity cache if it is enabled.
	*
	* @param projectFeesRegistration the project fees registration
	*/
	public static void cacheResult(
		ProjectFeesRegistration projectFeesRegistration) {
		getPersistence().cacheResult(projectFeesRegistration);
	}

	/**
	* Caches the project fees registrations in the entity cache if it is enabled.
	*
	* @param projectFeesRegistrations the project fees registrations
	*/
	public static void cacheResult(
		List<ProjectFeesRegistration> projectFeesRegistrations) {
		getPersistence().cacheResult(projectFeesRegistrations);
	}

	/**
	* Creates a new project fees registration with the primary key. Does not add the project fees registration to the database.
	*
	* @param PROJECT_FEES_ID the primary key for the new project fees registration
	* @return the new project fees registration
	*/
	public static ProjectFeesRegistration create(long PROJECT_FEES_ID) {
		return getPersistence().create(PROJECT_FEES_ID);
	}

	/**
	* Removes the project fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration that was removed
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public static ProjectFeesRegistration remove(long PROJECT_FEES_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence().remove(PROJECT_FEES_ID);
	}

	public static ProjectFeesRegistration updateImpl(
		ProjectFeesRegistration projectFeesRegistration) {
		return getPersistence().updateImpl(projectFeesRegistration);
	}

	/**
	* Returns the project fees registration with the primary key or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration
	* @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	*/
	public static ProjectFeesRegistration findByPrimaryKey(long PROJECT_FEES_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_FEES_ID);
	}

	/**
	* Returns the project fees registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_FEES_ID the primary key of the project fees registration
	* @return the project fees registration, or <code>null</code> if a project fees registration with the primary key could not be found
	*/
	public static ProjectFeesRegistration fetchByPrimaryKey(
		long PROJECT_FEES_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_FEES_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectFeesRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project fees registrations.
	*
	* @return the project fees registrations
	*/
	public static List<ProjectFeesRegistration> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectFeesRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectFeesRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectFeesRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project fees registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project fees registrations.
	*
	* @return the number of project fees registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectFeesRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectFeesRegistrationPersistence, ProjectFeesRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectFeesRegistrationPersistence.class);

		ServiceTracker<ProjectFeesRegistrationPersistence, ProjectFeesRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectFeesRegistrationPersistence, ProjectFeesRegistrationPersistence>(bundle.getBundleContext(),
				ProjectFeesRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}