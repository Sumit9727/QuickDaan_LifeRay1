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

import com.crowd.funding.database.model.DynamicFeesRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the dynamic fees registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.DynamicFeesRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.DynamicFeesRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationUtil {
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
		DynamicFeesRegistration dynamicFeesRegistration) {
		getPersistence().clearCache(dynamicFeesRegistration);
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
	public static List<DynamicFeesRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DynamicFeesRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DynamicFeesRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DynamicFeesRegistration update(
		DynamicFeesRegistration dynamicFeesRegistration) {
		return getPersistence().update(dynamicFeesRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DynamicFeesRegistration update(
		DynamicFeesRegistration dynamicFeesRegistration,
		ServiceContext serviceContext) {
		return getPersistence().update(dynamicFeesRegistration, serviceContext);
	}

	/**
	* Returns all the dynamic fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the dynamic fees registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @return the range of matching dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findByUuid(String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the dynamic fees registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dynamic fees registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration findByUuid_First(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration fetchByUuid_First(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration findByUuid_Last(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the dynamic fees registrations before and after the current dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param CATEGORY_ID the primary key of the current dynamic fees registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	*/
	public static DynamicFeesRegistration[] findByUuid_PrevAndNext(
		long CATEGORY_ID, String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(CATEGORY_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the dynamic fees registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of dynamic fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dynamic fees registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the dynamic fees registration where CATEGORY_ID = &#63; or throws a {@link NoSuchDynamicFeesRegistrationException} if it could not be found.
	*
	* @param CATEGORY_ID the category_id
	* @return the matching dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration findByCATEGORY_ID(long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence().findByCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Returns the dynamic fees registration where CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param CATEGORY_ID the category_id
	* @return the matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration fetchByCATEGORY_ID(long CATEGORY_ID) {
		return getPersistence().fetchByCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Returns the dynamic fees registration where CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param CATEGORY_ID the category_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public static DynamicFeesRegistration fetchByCATEGORY_ID(long CATEGORY_ID,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByCATEGORY_ID(CATEGORY_ID, retrieveFromCache);
	}

	/**
	* Removes the dynamic fees registration where CATEGORY_ID = &#63; from the database.
	*
	* @param CATEGORY_ID the category_id
	* @return the dynamic fees registration that was removed
	*/
	public static DynamicFeesRegistration removeByCATEGORY_ID(long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence().removeByCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Returns the number of dynamic fees registrations where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @return the number of matching dynamic fees registrations
	*/
	public static int countByCATEGORY_ID(long CATEGORY_ID) {
		return getPersistence().countByCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Caches the dynamic fees registration in the entity cache if it is enabled.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	*/
	public static void cacheResult(
		DynamicFeesRegistration dynamicFeesRegistration) {
		getPersistence().cacheResult(dynamicFeesRegistration);
	}

	/**
	* Caches the dynamic fees registrations in the entity cache if it is enabled.
	*
	* @param dynamicFeesRegistrations the dynamic fees registrations
	*/
	public static void cacheResult(
		List<DynamicFeesRegistration> dynamicFeesRegistrations) {
		getPersistence().cacheResult(dynamicFeesRegistrations);
	}

	/**
	* Creates a new dynamic fees registration with the primary key. Does not add the dynamic fees registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new dynamic fees registration
	* @return the new dynamic fees registration
	*/
	public static DynamicFeesRegistration create(long CATEGORY_ID) {
		return getPersistence().create(CATEGORY_ID);
	}

	/**
	* Removes the dynamic fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration that was removed
	* @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	*/
	public static DynamicFeesRegistration remove(long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence().remove(CATEGORY_ID);
	}

	public static DynamicFeesRegistration updateImpl(
		DynamicFeesRegistration dynamicFeesRegistration) {
		return getPersistence().updateImpl(dynamicFeesRegistration);
	}

	/**
	* Returns the dynamic fees registration with the primary key or throws a {@link NoSuchDynamicFeesRegistrationException} if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	*/
	public static DynamicFeesRegistration findByPrimaryKey(long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException {
		return getPersistence().findByPrimaryKey(CATEGORY_ID);
	}

	/**
	* Returns the dynamic fees registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration, or <code>null</code> if a dynamic fees registration with the primary key could not be found
	*/
	public static DynamicFeesRegistration fetchByPrimaryKey(long CATEGORY_ID) {
		return getPersistence().fetchByPrimaryKey(CATEGORY_ID);
	}

	public static java.util.Map<java.io.Serializable, DynamicFeesRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dynamic fees registrations.
	*
	* @return the dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dynamic fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @return the range of dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dynamic fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findAll(int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dynamic fees registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DynamicFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dynamic fees registrations
	* @param end the upper bound of the range of dynamic fees registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dynamic fees registrations
	*/
	public static List<DynamicFeesRegistration> findAll(int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dynamic fees registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dynamic fees registrations.
	*
	* @return the number of dynamic fees registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static DynamicFeesRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DynamicFeesRegistrationPersistence, DynamicFeesRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DynamicFeesRegistrationPersistence.class);

		ServiceTracker<DynamicFeesRegistrationPersistence, DynamicFeesRegistrationPersistence> serviceTracker =
			new ServiceTracker<DynamicFeesRegistrationPersistence, DynamicFeesRegistrationPersistence>(bundle.getBundleContext(),
				DynamicFeesRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}