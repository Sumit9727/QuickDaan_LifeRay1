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

import com.crowd.funding.database.model.PostionRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the postion registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.PostionRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.PostionRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class PostionRegistrationUtil {
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
	public static void clearCache(PostionRegistration postionRegistration) {
		getPersistence().clearCache(postionRegistration);
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
	public static List<PostionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PostionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PostionRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PostionRegistration update(
		PostionRegistration postionRegistration) {
		return getPersistence().update(postionRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PostionRegistration update(
		PostionRegistration postionRegistration, ServiceContext serviceContext) {
		return getPersistence().update(postionRegistration, serviceContext);
	}

	/**
	* Returns all the postion registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching postion registrations
	*/
	public static List<PostionRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the postion registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @return the range of matching postion registrations
	*/
	public static List<PostionRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the postion registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching postion registrations
	*/
	public static List<PostionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the postion registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching postion registrations
	*/
	public static List<PostionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public static PostionRegistration findByUuid_First(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public static PostionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public static PostionRegistration findByUuid_Last(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public static PostionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the postion registrations before and after the current postion registration in the ordered set where uuid = &#63;.
	*
	* @param POSITION_ID the primary key of the current postion registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next postion registration
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public static PostionRegistration[] findByUuid_PrevAndNext(
		long POSITION_ID, String uuid,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(POSITION_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the postion registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of postion registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching postion registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the postion registration where POSITION_ID = &#63; or throws a {@link NoSuchPostionRegistrationException} if it could not be found.
	*
	* @param POSITION_ID the position_id
	* @return the matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public static PostionRegistration findByPOSITION_ID(long POSITION_ID)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().findByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns the postion registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param POSITION_ID the position_id
	* @return the matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public static PostionRegistration fetchByPOSITION_ID(long POSITION_ID) {
		return getPersistence().fetchByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns the postion registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param POSITION_ID the position_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public static PostionRegistration fetchByPOSITION_ID(long POSITION_ID,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByPOSITION_ID(POSITION_ID, retrieveFromCache);
	}

	/**
	* Removes the postion registration where POSITION_ID = &#63; from the database.
	*
	* @param POSITION_ID the position_id
	* @return the postion registration that was removed
	*/
	public static PostionRegistration removeByPOSITION_ID(long POSITION_ID)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().removeByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns the number of postion registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the number of matching postion registrations
	*/
	public static int countByPOSITION_ID(long POSITION_ID) {
		return getPersistence().countByPOSITION_ID(POSITION_ID);
	}

	/**
	* Returns all the postion registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching postion registrations
	*/
	public static List<PostionRegistration> findBySTATUS(int STATUS) {
		return getPersistence().findBySTATUS(STATUS);
	}

	/**
	* Returns a range of all the postion registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @return the range of matching postion registrations
	*/
	public static List<PostionRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return getPersistence().findBySTATUS(STATUS, start, end);
	}

	/**
	* Returns an ordered range of all the postion registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching postion registrations
	*/
	public static List<PostionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the postion registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching postion registrations
	*/
	public static List<PostionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBySTATUS(STATUS, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public static PostionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().findBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the first postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public static PostionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_First(STATUS, orderByComparator);
	}

	/**
	* Returns the last postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public static PostionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().findBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the last postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public static PostionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence().fetchBySTATUS_Last(STATUS, orderByComparator);
	}

	/**
	* Returns the postion registrations before and after the current postion registration in the ordered set where STATUS = &#63;.
	*
	* @param POSITION_ID the primary key of the current postion registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next postion registration
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public static PostionRegistration[] findBySTATUS_PrevAndNext(
		long POSITION_ID, int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence()
				   .findBySTATUS_PrevAndNext(POSITION_ID, STATUS,
			orderByComparator);
	}

	/**
	* Removes all the postion registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public static void removeBySTATUS(int STATUS) {
		getPersistence().removeBySTATUS(STATUS);
	}

	/**
	* Returns the number of postion registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching postion registrations
	*/
	public static int countBySTATUS(int STATUS) {
		return getPersistence().countBySTATUS(STATUS);
	}

	/**
	* Caches the postion registration in the entity cache if it is enabled.
	*
	* @param postionRegistration the postion registration
	*/
	public static void cacheResult(PostionRegistration postionRegistration) {
		getPersistence().cacheResult(postionRegistration);
	}

	/**
	* Caches the postion registrations in the entity cache if it is enabled.
	*
	* @param postionRegistrations the postion registrations
	*/
	public static void cacheResult(
		List<PostionRegistration> postionRegistrations) {
		getPersistence().cacheResult(postionRegistrations);
	}

	/**
	* Creates a new postion registration with the primary key. Does not add the postion registration to the database.
	*
	* @param POSITION_ID the primary key for the new postion registration
	* @return the new postion registration
	*/
	public static PostionRegistration create(long POSITION_ID) {
		return getPersistence().create(POSITION_ID);
	}

	/**
	* Removes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration that was removed
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public static PostionRegistration remove(long POSITION_ID)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().remove(POSITION_ID);
	}

	public static PostionRegistration updateImpl(
		PostionRegistration postionRegistration) {
		return getPersistence().updateImpl(postionRegistration);
	}

	/**
	* Returns the postion registration with the primary key or throws a {@link NoSuchPostionRegistrationException} if it could not be found.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public static PostionRegistration findByPrimaryKey(long POSITION_ID)
		throws com.crowd.funding.database.exception.NoSuchPostionRegistrationException {
		return getPersistence().findByPrimaryKey(POSITION_ID);
	}

	/**
	* Returns the postion registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration, or <code>null</code> if a postion registration with the primary key could not be found
	*/
	public static PostionRegistration fetchByPrimaryKey(long POSITION_ID) {
		return getPersistence().fetchByPrimaryKey(POSITION_ID);
	}

	public static java.util.Map<java.io.Serializable, PostionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the postion registrations.
	*
	* @return the postion registrations
	*/
	public static List<PostionRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the postion registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @return the range of postion registrations
	*/
	public static List<PostionRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the postion registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of postion registrations
	*/
	public static List<PostionRegistration> findAll(int start, int end,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the postion registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of postion registrations
	*/
	public static List<PostionRegistration> findAll(int start, int end,
		OrderByComparator<PostionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the postion registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of postion registrations.
	*
	* @return the number of postion registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PostionRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PostionRegistrationPersistence, PostionRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PostionRegistrationPersistence.class);

		ServiceTracker<PostionRegistrationPersistence, PostionRegistrationPersistence> serviceTracker =
			new ServiceTracker<PostionRegistrationPersistence, PostionRegistrationPersistence>(bundle.getBundleContext(),
				PostionRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}