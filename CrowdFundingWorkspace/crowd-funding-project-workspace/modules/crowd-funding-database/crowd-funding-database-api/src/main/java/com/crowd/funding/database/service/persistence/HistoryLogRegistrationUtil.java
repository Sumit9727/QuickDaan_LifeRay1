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

import com.crowd.funding.database.model.HistoryLogRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the history log registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.HistoryLogRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HistoryLogRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.HistoryLogRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationUtil {
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
	public static void clearCache(HistoryLogRegistration historyLogRegistration) {
		getPersistence().clearCache(historyLogRegistration);
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
	public static List<HistoryLogRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HistoryLogRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HistoryLogRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HistoryLogRegistration update(
		HistoryLogRegistration historyLogRegistration) {
		return getPersistence().update(historyLogRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HistoryLogRegistration update(
		HistoryLogRegistration historyLogRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(historyLogRegistration, serviceContext);
	}

	/**
	* Returns all the history log registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the history log registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @return the range of matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the history log registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the history log registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration findByUuid_First(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration fetchByUuid_First(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration findByUuid_Last(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the history log registrations before and after the current history log registration in the ordered set where uuid = &#63;.
	*
	* @param HISTORY_ID the primary key of the current history log registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next history log registration
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public static HistoryLogRegistration[] findByUuid_PrevAndNext(
		long HISTORY_ID, String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(HISTORY_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the history log registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of history log registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching history log registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the history log registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUSER_ID(long USER_ID) {
		return getPersistence().findByUSER_ID(USER_ID);
	}

	/**
	* Returns a range of all the history log registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @return the range of matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUSER_ID(long USER_ID,
		int start, int end) {
		return getPersistence().findByUSER_ID(USER_ID, start, end);
	}

	/**
	* Returns an ordered range of all the history log registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the history log registrations where USER_ID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param USER_ID the user_id
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching history log registrations
	*/
	public static List<HistoryLogRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUSER_ID(USER_ID, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence().findByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the first history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_First(USER_ID, orderByComparator);
	}

	/**
	* Returns the last history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence().findByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the last history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public static HistoryLogRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence().fetchByUSER_ID_Last(USER_ID, orderByComparator);
	}

	/**
	* Returns the history log registrations before and after the current history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param HISTORY_ID the primary key of the current history log registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next history log registration
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public static HistoryLogRegistration[] findByUSER_ID_PrevAndNext(
		long HISTORY_ID, long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence()
				   .findByUSER_ID_PrevAndNext(HISTORY_ID, USER_ID,
			orderByComparator);
	}

	/**
	* Removes all the history log registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public static void removeByUSER_ID(long USER_ID) {
		getPersistence().removeByUSER_ID(USER_ID);
	}

	/**
	* Returns the number of history log registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching history log registrations
	*/
	public static int countByUSER_ID(long USER_ID) {
		return getPersistence().countByUSER_ID(USER_ID);
	}

	/**
	* Caches the history log registration in the entity cache if it is enabled.
	*
	* @param historyLogRegistration the history log registration
	*/
	public static void cacheResult(
		HistoryLogRegistration historyLogRegistration) {
		getPersistence().cacheResult(historyLogRegistration);
	}

	/**
	* Caches the history log registrations in the entity cache if it is enabled.
	*
	* @param historyLogRegistrations the history log registrations
	*/
	public static void cacheResult(
		List<HistoryLogRegistration> historyLogRegistrations) {
		getPersistence().cacheResult(historyLogRegistrations);
	}

	/**
	* Creates a new history log registration with the primary key. Does not add the history log registration to the database.
	*
	* @param HISTORY_ID the primary key for the new history log registration
	* @return the new history log registration
	*/
	public static HistoryLogRegistration create(long HISTORY_ID) {
		return getPersistence().create(HISTORY_ID);
	}

	/**
	* Removes the history log registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration that was removed
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public static HistoryLogRegistration remove(long HISTORY_ID)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence().remove(HISTORY_ID);
	}

	public static HistoryLogRegistration updateImpl(
		HistoryLogRegistration historyLogRegistration) {
		return getPersistence().updateImpl(historyLogRegistration);
	}

	/**
	* Returns the history log registration with the primary key or throws a {@link NoSuchHistoryLogRegistrationException} if it could not be found.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public static HistoryLogRegistration findByPrimaryKey(long HISTORY_ID)
		throws com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException {
		return getPersistence().findByPrimaryKey(HISTORY_ID);
	}

	/**
	* Returns the history log registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration, or <code>null</code> if a history log registration with the primary key could not be found
	*/
	public static HistoryLogRegistration fetchByPrimaryKey(long HISTORY_ID) {
		return getPersistence().fetchByPrimaryKey(HISTORY_ID);
	}

	public static java.util.Map<java.io.Serializable, HistoryLogRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the history log registrations.
	*
	* @return the history log registrations
	*/
	public static List<HistoryLogRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the history log registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @return the range of history log registrations
	*/
	public static List<HistoryLogRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the history log registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of history log registrations
	*/
	public static List<HistoryLogRegistration> findAll(int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the history log registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HistoryLogRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history log registrations
	* @param end the upper bound of the range of history log registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of history log registrations
	*/
	public static List<HistoryLogRegistration> findAll(int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the history log registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of history log registrations.
	*
	* @return the number of history log registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static HistoryLogRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<HistoryLogRegistrationPersistence, HistoryLogRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(HistoryLogRegistrationPersistence.class);

		ServiceTracker<HistoryLogRegistrationPersistence, HistoryLogRegistrationPersistence> serviceTracker =
			new ServiceTracker<HistoryLogRegistrationPersistence, HistoryLogRegistrationPersistence>(bundle.getBundleContext(),
				HistoryLogRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}