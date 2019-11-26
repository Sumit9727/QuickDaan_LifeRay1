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

import com.crowd.funding.database.model.CategoryRegistration;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the category registration service. This utility wraps {@link com.crowd.funding.database.service.persistence.impl.CategoryRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.impl.CategoryRegistrationPersistenceImpl
 * @generated
 */
@ProviderType
public class CategoryRegistrationUtil {
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
	public static void clearCache(CategoryRegistration categoryRegistration) {
		getPersistence().clearCache(categoryRegistration);
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
	public static List<CategoryRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CategoryRegistration update(
		CategoryRegistration categoryRegistration) {
		return getPersistence().update(categoryRegistration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CategoryRegistration update(
		CategoryRegistration categoryRegistration, ServiceContext serviceContext) {
		return getPersistence().update(categoryRegistration, serviceContext);
	}

	/**
	* Returns all the category registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching category registrations
	*/
	public static List<CategoryRegistration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the category registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @return the range of matching category registrations
	*/
	public static List<CategoryRegistration> findByUuid(String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the category registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category registrations
	*/
	public static List<CategoryRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CategoryRegistration> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the category registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching category registrations
	*/
	public static List<CategoryRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CategoryRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category registration
	* @throws NoSuchCategoryRegistrationException if a matching category registration could not be found
	*/
	public static CategoryRegistration findByUuid_First(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCategoryRegistrationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category registration, or <code>null</code> if a matching category registration could not be found
	*/
	public static CategoryRegistration fetchByUuid_First(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category registration
	* @throws NoSuchCategoryRegistrationException if a matching category registration could not be found
	*/
	public static CategoryRegistration findByUuid_Last(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCategoryRegistrationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category registration, or <code>null</code> if a matching category registration could not be found
	*/
	public static CategoryRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the category registrations before and after the current category registration in the ordered set where uuid = &#63;.
	*
	* @param CATEGORY_ID the primary key of the current category registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category registration
	* @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	*/
	public static CategoryRegistration[] findByUuid_PrevAndNext(
		long CATEGORY_ID, String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator)
		throws com.crowd.funding.database.exception.NoSuchCategoryRegistrationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(CATEGORY_ID, uuid, orderByComparator);
	}

	/**
	* Removes all the category registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of category registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching category registrations
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Caches the category registration in the entity cache if it is enabled.
	*
	* @param categoryRegistration the category registration
	*/
	public static void cacheResult(CategoryRegistration categoryRegistration) {
		getPersistence().cacheResult(categoryRegistration);
	}

	/**
	* Caches the category registrations in the entity cache if it is enabled.
	*
	* @param categoryRegistrations the category registrations
	*/
	public static void cacheResult(
		List<CategoryRegistration> categoryRegistrations) {
		getPersistence().cacheResult(categoryRegistrations);
	}

	/**
	* Creates a new category registration with the primary key. Does not add the category registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new category registration
	* @return the new category registration
	*/
	public static CategoryRegistration create(long CATEGORY_ID) {
		return getPersistence().create(CATEGORY_ID);
	}

	/**
	* Removes the category registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration that was removed
	* @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	*/
	public static CategoryRegistration remove(long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchCategoryRegistrationException {
		return getPersistence().remove(CATEGORY_ID);
	}

	public static CategoryRegistration updateImpl(
		CategoryRegistration categoryRegistration) {
		return getPersistence().updateImpl(categoryRegistration);
	}

	/**
	* Returns the category registration with the primary key or throws a {@link NoSuchCategoryRegistrationException} if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration
	* @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	*/
	public static CategoryRegistration findByPrimaryKey(long CATEGORY_ID)
		throws com.crowd.funding.database.exception.NoSuchCategoryRegistrationException {
		return getPersistence().findByPrimaryKey(CATEGORY_ID);
	}

	/**
	* Returns the category registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration, or <code>null</code> if a category registration with the primary key could not be found
	*/
	public static CategoryRegistration fetchByPrimaryKey(long CATEGORY_ID) {
		return getPersistence().fetchByPrimaryKey(CATEGORY_ID);
	}

	public static java.util.Map<java.io.Serializable, CategoryRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the category registrations.
	*
	* @return the category registrations
	*/
	public static List<CategoryRegistration> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the category registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @return the range of category registrations
	*/
	public static List<CategoryRegistration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the category registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of category registrations
	*/
	public static List<CategoryRegistration> findAll(int start, int end,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the category registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of category registrations
	*/
	public static List<CategoryRegistration> findAll(int start, int end,
		OrderByComparator<CategoryRegistration> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the category registrations from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of category registrations.
	*
	* @return the number of category registrations
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CategoryRegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CategoryRegistrationPersistence, CategoryRegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CategoryRegistrationPersistence.class);

		ServiceTracker<CategoryRegistrationPersistence, CategoryRegistrationPersistence> serviceTracker =
			new ServiceTracker<CategoryRegistrationPersistence, CategoryRegistrationPersistence>(bundle.getBundleContext(),
				CategoryRegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}