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

import com.crowd.funding.database.model.ProjectRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the project registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.ProjectRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.ProjectRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class ProjectRegistrationUtil {
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
	public static void clearCache(ProjectRegistration projectRegistration) {
		getPersistence().clearCache(projectRegistration);
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
	public static List<ProjectRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectRegistration update(
		ProjectRegistration projectRegistration) {
		return getPersistence().update(projectRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectRegistration update(
		ProjectRegistration projectRegistration, ServiceContext serviceContext) {
		return getPersistence().update(projectRegistration, serviceContext);
	}

	/**
	* Returns all the project registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the project registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where uuid = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByUuid_PrevAndNext(
		long PROJECT_ID, String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(PROJECT_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the project registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of project registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching project registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the project registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByPROJECT_ID(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param PROJECT_ID the project_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID,
		boolean retrieveFromCache) {
		return getPersistence().fetchByPROJECT_ID(PROJECT_ID, retrieveFromCache);
	}

	/**
	* Removes the project registration where PROJECT_ID = &#63; from the database.
	*
	* @param PROJECT_ID the project_id
	* @return the project registration that was removed
	*/
	public static ProjectRegistration removeByPROJECT_ID(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().removeByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns the number of project registrations where PROJECT_ID = &#63;.
	*
	* @param PROJECT_ID the project_id
	* @return the number of matching project registrations
	*/
	public static int countByPROJECT_ID(long PROJECT_ID) {
		return getPersistence().countByPROJECT_ID(PROJECT_ID);
	}

	/**
	* Returns all the project registrations where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID(
		long BENIFICIARY_ID) {
		return getPersistence().findByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Returns a range of all the project registrations where BENIFICIARY_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID(
		long BENIFICIARY_ID, int start, int end) {
		return getPersistence().findByBENIFICIARY_ID(BENIFICIARY_ID, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID(
		long BENIFICIARY_ID, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByBENIFICIARY_ID(BENIFICIARY_ID, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID(
		long BENIFICIARY_ID, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByBENIFICIARY_ID(BENIFICIARY_ID, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByBENIFICIARY_ID_First(
		long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByBENIFICIARY_ID_First(BENIFICIARY_ID, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByBENIFICIARY_ID_First(
		long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByBENIFICIARY_ID_First(BENIFICIARY_ID,
			orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByBENIFICIARY_ID_Last(
		long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByBENIFICIARY_ID_Last(BENIFICIARY_ID, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByBENIFICIARY_ID_Last(
		long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByBENIFICIARY_ID_Last(BENIFICIARY_ID, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where BENIFICIARY_ID = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param BENIFICIARY_ID the benificiary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByBENIFICIARY_ID_PrevAndNext(
		long PROJECT_ID, long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByBENIFICIARY_ID_PrevAndNext(PROJECT_ID,
			BENIFICIARY_ID, orderByComparator);
	}

	/**
	* Removes all the project registrations where BENIFICIARY_ID = &#63; from the database.
	*
	* @param BENIFICIARY_ID the benificiary_id
	*/
	public static void removeByBENIFICIARY_ID(long BENIFICIARY_ID) {
		getPersistence().removeByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Returns the number of project registrations where BENIFICIARY_ID = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @return the number of matching project registrations
	*/
	public static int countByBENIFICIARY_ID(long BENIFICIARY_ID) {
		return getPersistence().countByBENIFICIARY_ID(BENIFICIARY_ID);
	}

	/**
	* Returns all the project registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID) {
		return getPersistence().findByUSER_ID(USER_ID);
	}

	/**
	* Returns a range of all the project registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end) {
		return getPersistence().findByUSER_ID(USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where USER_ID = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByUSER_ID_PrevAndNext(
		long PROJECT_ID, long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByUSER_ID_PrevAndNext(PROJECT_ID, USER_ID,
			orderByComparator);
	}

	/**
	* Removes all the project registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public static void removeByUSER_ID(long USER_ID) {
		getPersistence().removeByUSER_ID(USER_ID);
	}

	/**
	* Returns the number of project registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching project registrations
	*/
	public static int countByUSER_ID(long USER_ID) {
		return getPersistence().countByUSER_ID(USER_ID);
	}

	/**
	* Returns all the project registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

	/**
	* Returns a range of all the project registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where STATUS = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(PROJECT_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the project registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of project registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching project registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Returns all the project registrations where CREATION_DATE = &#63;.
	*
	* @param CREATION_DATE the creation_date
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByCREATION_DATE(
		Date CREATION_DATE) {
		return getPersistence().findByCREATION_DATE(CREATION_DATE);
	}

	/**
	* Returns a range of all the project registrations where CREATION_DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CREATION_DATE the creation_date
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByCREATION_DATE(
		Date CREATION_DATE, int start, int end) {
		return getPersistence().findByCREATION_DATE(CREATION_DATE, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where CREATION_DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CREATION_DATE the creation_date
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByCREATION_DATE(
		Date CREATION_DATE, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByCREATION_DATE(CREATION_DATE, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where CREATION_DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param CREATION_DATE the creation_date
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByCREATION_DATE(
		Date CREATION_DATE, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCREATION_DATE(CREATION_DATE, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where CREATION_DATE = &#63;.
	*
	* @param CREATION_DATE the creation_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByCREATION_DATE_First(
		Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByCREATION_DATE_First(CREATION_DATE, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where CREATION_DATE = &#63;.
	*
	* @param CREATION_DATE the creation_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByCREATION_DATE_First(
		Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByCREATION_DATE_First(CREATION_DATE, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where CREATION_DATE = &#63;.
	*
	* @param CREATION_DATE the creation_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByCREATION_DATE_Last(
		Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByCREATION_DATE_Last(CREATION_DATE, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where CREATION_DATE = &#63;.
	*
	* @param CREATION_DATE the creation_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByCREATION_DATE_Last(
		Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByCREATION_DATE_Last(CREATION_DATE, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where CREATION_DATE = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param CREATION_DATE the creation_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByCREATION_DATE_PrevAndNext(
		long PROJECT_ID, Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByCREATION_DATE_PrevAndNext(PROJECT_ID, CREATION_DATE,
			orderByComparator);
	}

	/**
	* Removes all the project registrations where CREATION_DATE = &#63; from the database.
	*
	* @param CREATION_DATE the creation_date
	*/
	public static void removeByCREATION_DATE(Date CREATION_DATE) {
		getPersistence().removeByCREATION_DATE(CREATION_DATE);
	}

	/**
	* Returns the number of project registrations where CREATION_DATE = &#63;.
	*
	* @param CREATION_DATE the creation_date
	* @return the number of matching project registrations
	*/
	public static int countByCREATION_DATE(Date CREATION_DATE) {
		return getPersistence().countByCREATION_DATE(CREATION_DATE);
	}

	/**
	* Returns all the project registrations where END_DATE = &#63;.
	*
	* @param END_DATE the end_date
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByEND_DATE(Date END_DATE) {
		return getPersistence().findByEND_DATE(END_DATE);
	}

	/**
	* Returns a range of all the project registrations where END_DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param END_DATE the end_date
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByEND_DATE(Date END_DATE,
		int start, int end) {
		return getPersistence().findByEND_DATE(END_DATE, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where END_DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param END_DATE the end_date
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByEND_DATE(Date END_DATE,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByEND_DATE(END_DATE, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where END_DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param END_DATE the end_date
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByEND_DATE(Date END_DATE,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEND_DATE(END_DATE, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where END_DATE = &#63;.
	*
	* @param END_DATE the end_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByEND_DATE_First(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByEND_DATE_First(END_DATE, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where END_DATE = &#63;.
	*
	* @param END_DATE the end_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByEND_DATE_First(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByEND_DATE_First(END_DATE, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where END_DATE = &#63;.
	*
	* @param END_DATE the end_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByEND_DATE_Last(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByEND_DATE_Last(END_DATE, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where END_DATE = &#63;.
	*
	* @param END_DATE the end_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByEND_DATE_Last(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().fetchByEND_DATE_Last(END_DATE, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where END_DATE = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param END_DATE the end_date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByEND_DATE_PrevAndNext(
		long PROJECT_ID, Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByEND_DATE_PrevAndNext(PROJECT_ID, END_DATE,
			orderByComparator);
	}

	/**
	* Removes all the project registrations where END_DATE = &#63; from the database.
	*
	* @param END_DATE the end_date
	*/
	public static void removeByEND_DATE(Date END_DATE) {
		getPersistence().removeByEND_DATE(END_DATE);
	}

	/**
	* Returns the number of project registrations where END_DATE = &#63;.
	*
	* @param END_DATE the end_date
	* @return the number of matching project registrations
	*/
	public static int countByEND_DATE(Date END_DATE) {
		return getPersistence().countByEND_DATE(END_DATE);
	}

	/**
	* Returns all the project registrations where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByREQUEST_STATUS(
		int REQUEST_STATUS) {
		return getPersistence().findByREQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	* Returns a range of all the project registrations where REQUEST_STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByREQUEST_STATUS(
		int REQUEST_STATUS, int start, int end) {
		return getPersistence().findByREQUEST_STATUS(REQUEST_STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByREQUEST_STATUS(
		int REQUEST_STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByREQUEST_STATUS(REQUEST_STATUS, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByREQUEST_STATUS(
		int REQUEST_STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByREQUEST_STATUS(REQUEST_STATUS, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByREQUEST_STATUS_First(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByREQUEST_STATUS_First(REQUEST_STATUS, orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByREQUEST_STATUS_First(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByREQUEST_STATUS_First(REQUEST_STATUS,
			orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByREQUEST_STATUS_Last(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByREQUEST_STATUS_Last(REQUEST_STATUS, orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByREQUEST_STATUS_Last(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByREQUEST_STATUS_Last(REQUEST_STATUS, orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByREQUEST_STATUS_PrevAndNext(
		long PROJECT_ID, int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByREQUEST_STATUS_PrevAndNext(PROJECT_ID,
			REQUEST_STATUS, orderByComparator);
	}

	/**
	* Removes all the project registrations where REQUEST_STATUS = &#63; from the database.
	*
	* @param REQUEST_STATUS the request_status
	*/
	public static void removeByREQUEST_STATUS(int REQUEST_STATUS) {
		getPersistence().removeByREQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	* Returns the number of project registrations where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @return the number of matching project registrations
	*/
	public static int countByREQUEST_STATUS(int REQUEST_STATUS) {
		return getPersistence().countByREQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	* Returns all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS) {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS);
	}

	/**
	* Returns a range of all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS, int start, int end) {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS, start,
			end);
	}

	/**
	* Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByBENIFICIARY_ID_STATUS_First(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS_First(BENIFICIARY_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByBENIFICIARY_ID_STATUS_First(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByBENIFICIARY_ID_STATUS_First(BENIFICIARY_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByBENIFICIARY_ID_STATUS_Last(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS_Last(BENIFICIARY_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByBENIFICIARY_ID_STATUS_Last(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByBENIFICIARY_ID_STATUS_Last(BENIFICIARY_ID, STATUS,
			orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByBENIFICIARY_ID_STATUS_PrevAndNext(
		long PROJECT_ID, long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByBENIFICIARY_ID_STATUS_PrevAndNext(PROJECT_ID,
			BENIFICIARY_ID, STATUS, orderByComparator);
	}

	/**
	* Removes all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63; from the database.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	*/
	public static void removeByBENIFICIARY_ID_STATUS(long BENIFICIARY_ID,
		int STATUS) {
		getPersistence().removeByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS);
	}

	/**
	* Returns the number of project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	*
	* @param BENIFICIARY_ID the benificiary_id
	* @param STATUS the status
	* @return the number of matching project registrations
	*/
	public static int countByBENIFICIARY_ID_STATUS(long BENIFICIARY_ID,
		int STATUS) {
		return getPersistence()
				   .countByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS);
	}

	/**
	* Returns all the project registrations where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS) {
		return getPersistence().findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	* Returns a range of all the project registrations where REQUEST_STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS, int start, int end) {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByMULTIPLE_REQUEST_STATUS_First(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS_First(REQUEST_STATUS,
			orderByComparator);
	}

	/**
	* Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByMULTIPLE_REQUEST_STATUS_First(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByMULTIPLE_REQUEST_STATUS_First(REQUEST_STATUS,
			orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration
	* @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	*/
	public static ProjectRegistration findByMULTIPLE_REQUEST_STATUS_Last(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS_Last(REQUEST_STATUS,
			orderByComparator);
	}

	/**
	* Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	*/
	public static ProjectRegistration fetchByMULTIPLE_REQUEST_STATUS_Last(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .fetchByMULTIPLE_REQUEST_STATUS_Last(REQUEST_STATUS,
			orderByComparator);
	}

	/**
	* Returns the project registrations before and after the current project registration in the ordered set where REQUEST_STATUS = &#63;.
	*
	* @param PROJECT_ID the primary key of the current project registration
	* @param REQUEST_STATUS the request_status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration[] findByMULTIPLE_REQUEST_STATUS_PrevAndNext(
		long PROJECT_ID, int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS_PrevAndNext(PROJECT_ID,
			REQUEST_STATUS, orderByComparator);
	}

	/**
	* Returns all the project registrations where REQUEST_STATUS = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUSs the request_statuses
	* @return the matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs) {
		return getPersistence().findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs);
	}

	/**
	* Returns a range of all the project registrations where REQUEST_STATUS = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUSs the request_statuses
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs, int start, int end) {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs, start, end);
	}

	/**
	* Returns an ordered range of all the project registrations where REQUEST_STATUS = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUSs the request_statuses
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param REQUEST_STATUS the request_status
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching project registrations
	*/
	public static List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project registrations where REQUEST_STATUS = &#63; from the database.
	*
	* @param REQUEST_STATUS the request_status
	*/
	public static void removeByMULTIPLE_REQUEST_STATUS(int REQUEST_STATUS) {
		getPersistence().removeByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	* Returns the number of project registrations where REQUEST_STATUS = &#63;.
	*
	* @param REQUEST_STATUS the request_status
	* @return the number of matching project registrations
	*/
	public static int countByMULTIPLE_REQUEST_STATUS(int REQUEST_STATUS) {
		return getPersistence().countByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	* Returns the number of project registrations where REQUEST_STATUS = any &#63;.
	*
	* @param REQUEST_STATUSs the request_statuses
	* @return the number of matching project registrations
	*/
	public static int countByMULTIPLE_REQUEST_STATUS(int[] REQUEST_STATUSs) {
		return getPersistence().countByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs);
	}

	/**
	* Caches the project registration in the entity cache if it is enabled.
	*
	* @param projectRegistration the project registration
	*/
	public static void cacheResult(ProjectRegistration projectRegistration) {
		getPersistence().cacheResult(projectRegistration);
	}

	/**
	* Caches the project registrations in the entity cache if it is enabled.
	*
	* @param projectRegistrations the project registrations
	*/
	public static void cacheResult(
		List<ProjectRegistration> projectRegistrations) {
		getPersistence().cacheResult(projectRegistrations);
	}

	/**
	* Creates a new project registration with the primary key. Does not add the project registration to the database.
	*
	* @param PROJECT_ID the primary key for the new project registration
	* @return the new project registration
	*/
	public static ProjectRegistration create(long PROJECT_ID) {
		return getPersistence().create(PROJECT_ID);
	}

	/**
	* Removes the project registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration that was removed
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration remove(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().remove(PROJECT_ID);
	}

	public static ProjectRegistration updateImpl(
		ProjectRegistration projectRegistration) {
		return getPersistence().updateImpl(projectRegistration);
	}

	/**
	* Returns the project registration with the primary key or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration
	* @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration findByPrimaryKey(long PROJECT_ID)
		throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
		return getPersistence().findByPrimaryKey(PROJECT_ID);
	}

	/**
	* Returns the project registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PROJECT_ID the primary key of the project registration
	* @return the project registration, or <code>null</code> if a project registration with the primary key could not be found
	*/
	public static ProjectRegistration fetchByPrimaryKey(long PROJECT_ID) {
		return getPersistence().fetchByPrimaryKey(PROJECT_ID);
	}

	public static java.util.Map<java.io.Serializable, ProjectRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the project registrations.
	*
	* @return the project registrations
	*/
	public static List<ProjectRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @return the range of project registrations
	*/
	public static List<ProjectRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project registrations
	*/
	public static List<ProjectRegistration> findAll(int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the project registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project registrations
	* @param end the upper bound of the range of project registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of project registrations
	*/
	public static List<ProjectRegistration> findAll(int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the project registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project registrations.
	*
	* @return the number of project registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ProjectRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProjectRegistrationPersistence, ProjectRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProjectRegistrationPersistence.class);

		ServiceTracker<ProjectRegistrationPersistence, ProjectRegistrationPersistence> serviceTracker =
			new ServiceTracker<ProjectRegistrationPersistence, ProjectRegistrationPersistence>(bundle.getBundleContext(),
				ProjectRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}