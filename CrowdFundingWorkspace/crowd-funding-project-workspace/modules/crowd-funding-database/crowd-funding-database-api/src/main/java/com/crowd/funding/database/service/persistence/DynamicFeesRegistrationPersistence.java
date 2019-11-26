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

import com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException;
import com.crowd.funding.database.model.DynamicFeesRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the dynamic fees registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.DynamicFeesRegistrationPersistenceImpl
 * @see DynamicFeesRegistrationUtil
 * @generated
 */
@ProviderType
public interface DynamicFeesRegistrationPersistence extends BasePersistence<DynamicFeesRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DynamicFeesRegistrationUtil} to access the dynamic fees registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dynamic fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching dynamic fees registrations
	*/
	public java.util.List<DynamicFeesRegistration> findByUuid(String uuid);

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
	public java.util.List<DynamicFeesRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<DynamicFeesRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator);

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
	public java.util.List<DynamicFeesRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws NoSuchDynamicFeesRegistrationException;

	/**
	* Returns the first dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator);

	/**
	* Returns the last dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws NoSuchDynamicFeesRegistrationException;

	/**
	* Returns the last dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator);

	/**
	* Returns the dynamic fees registrations before and after the current dynamic fees registration in the ordered set where uuid = &#63;.
	*
	* @param CATEGORY_ID the primary key of the current dynamic fees registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	*/
	public DynamicFeesRegistration[] findByUuid_PrevAndNext(long CATEGORY_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws NoSuchDynamicFeesRegistrationException;

	/**
	* Removes all the dynamic fees registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of dynamic fees registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching dynamic fees registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the dynamic fees registration where CATEGORY_ID = &#63; or throws a {@link NoSuchDynamicFeesRegistrationException} if it could not be found.
	*
	* @param CATEGORY_ID the category_id
	* @return the matching dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration findByCATEGORY_ID(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException;

	/**
	* Returns the dynamic fees registration where CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param CATEGORY_ID the category_id
	* @return the matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration fetchByCATEGORY_ID(long CATEGORY_ID);

	/**
	* Returns the dynamic fees registration where CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param CATEGORY_ID the category_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	*/
	public DynamicFeesRegistration fetchByCATEGORY_ID(long CATEGORY_ID,
		boolean retrieveFromCache);

	/**
	* Removes the dynamic fees registration where CATEGORY_ID = &#63; from the database.
	*
	* @param CATEGORY_ID the category_id
	* @return the dynamic fees registration that was removed
	*/
	public DynamicFeesRegistration removeByCATEGORY_ID(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException;

	/**
	* Returns the number of dynamic fees registrations where CATEGORY_ID = &#63;.
	*
	* @param CATEGORY_ID the category_id
	* @return the number of matching dynamic fees registrations
	*/
	public int countByCATEGORY_ID(long CATEGORY_ID);

	/**
	* Caches the dynamic fees registration in the entity cache if it is enabled.
	*
	* @param dynamicFeesRegistration the dynamic fees registration
	*/
	public void cacheResult(DynamicFeesRegistration dynamicFeesRegistration);

	/**
	* Caches the dynamic fees registrations in the entity cache if it is enabled.
	*
	* @param dynamicFeesRegistrations the dynamic fees registrations
	*/
	public void cacheResult(
		java.util.List<DynamicFeesRegistration> dynamicFeesRegistrations);

	/**
	* Creates a new dynamic fees registration with the primary key. Does not add the dynamic fees registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new dynamic fees registration
	* @return the new dynamic fees registration
	*/
	public DynamicFeesRegistration create(long CATEGORY_ID);

	/**
	* Removes the dynamic fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration that was removed
	* @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	*/
	public DynamicFeesRegistration remove(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException;

	public DynamicFeesRegistration updateImpl(
		DynamicFeesRegistration dynamicFeesRegistration);

	/**
	* Returns the dynamic fees registration with the primary key or throws a {@link NoSuchDynamicFeesRegistrationException} if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration
	* @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	*/
	public DynamicFeesRegistration findByPrimaryKey(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException;

	/**
	* Returns the dynamic fees registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the dynamic fees registration
	* @return the dynamic fees registration, or <code>null</code> if a dynamic fees registration with the primary key could not be found
	*/
	public DynamicFeesRegistration fetchByPrimaryKey(long CATEGORY_ID);

	@Override
	public java.util.Map<java.io.Serializable, DynamicFeesRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dynamic fees registrations.
	*
	* @return the dynamic fees registrations
	*/
	public java.util.List<DynamicFeesRegistration> findAll();

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
	public java.util.List<DynamicFeesRegistration> findAll(int start, int end);

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
	public java.util.List<DynamicFeesRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator);

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
	public java.util.List<DynamicFeesRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dynamic fees registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dynamic fees registrations.
	*
	* @return the number of dynamic fees registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}