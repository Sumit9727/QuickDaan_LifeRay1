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

import com.crowd.funding.database.exception.NoSuchCategoryRegistrationException;
import com.crowd.funding.database.model.CategoryRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the category registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.CategoryRegistrationPersistenceImpl
 * @see CategoryRegistrationUtil
 * @generated
 */
@ProviderType
public interface CategoryRegistrationPersistence extends BasePersistence<CategoryRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryRegistrationUtil} to access the category registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the category registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching category registrations
	*/
	public java.util.List<CategoryRegistration> findByUuid(String uuid);

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
	public java.util.List<CategoryRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<CategoryRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator);

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
	public java.util.List<CategoryRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category registration
	* @throws NoSuchCategoryRegistrationException if a matching category registration could not be found
	*/
	public CategoryRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator)
		throws NoSuchCategoryRegistrationException;

	/**
	* Returns the first category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category registration, or <code>null</code> if a matching category registration could not be found
	*/
	public CategoryRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator);

	/**
	* Returns the last category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category registration
	* @throws NoSuchCategoryRegistrationException if a matching category registration could not be found
	*/
	public CategoryRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator)
		throws NoSuchCategoryRegistrationException;

	/**
	* Returns the last category registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category registration, or <code>null</code> if a matching category registration could not be found
	*/
	public CategoryRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator);

	/**
	* Returns the category registrations before and after the current category registration in the ordered set where uuid = &#63;.
	*
	* @param CATEGORY_ID the primary key of the current category registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category registration
	* @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	*/
	public CategoryRegistration[] findByUuid_PrevAndNext(long CATEGORY_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator)
		throws NoSuchCategoryRegistrationException;

	/**
	* Removes all the category registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of category registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching category registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Caches the category registration in the entity cache if it is enabled.
	*
	* @param categoryRegistration the category registration
	*/
	public void cacheResult(CategoryRegistration categoryRegistration);

	/**
	* Caches the category registrations in the entity cache if it is enabled.
	*
	* @param categoryRegistrations the category registrations
	*/
	public void cacheResult(
		java.util.List<CategoryRegistration> categoryRegistrations);

	/**
	* Creates a new category registration with the primary key. Does not add the category registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new category registration
	* @return the new category registration
	*/
	public CategoryRegistration create(long CATEGORY_ID);

	/**
	* Removes the category registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration that was removed
	* @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	*/
	public CategoryRegistration remove(long CATEGORY_ID)
		throws NoSuchCategoryRegistrationException;

	public CategoryRegistration updateImpl(
		CategoryRegistration categoryRegistration);

	/**
	* Returns the category registration with the primary key or throws a {@link NoSuchCategoryRegistrationException} if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration
	* @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	*/
	public CategoryRegistration findByPrimaryKey(long CATEGORY_ID)
		throws NoSuchCategoryRegistrationException;

	/**
	* Returns the category registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration, or <code>null</code> if a category registration with the primary key could not be found
	*/
	public CategoryRegistration fetchByPrimaryKey(long CATEGORY_ID);

	@Override
	public java.util.Map<java.io.Serializable, CategoryRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the category registrations.
	*
	* @return the category registrations
	*/
	public java.util.List<CategoryRegistration> findAll();

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
	public java.util.List<CategoryRegistration> findAll(int start, int end);

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
	public java.util.List<CategoryRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator);

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
	public java.util.List<CategoryRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CategoryRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the category registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of category registrations.
	*
	* @return the number of category registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}