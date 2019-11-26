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

import com.crowd.funding.database.exception.NoSuchPositionRegistrationException;
import com.crowd.funding.database.model.PositionRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the position registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.PositionRegistrationPersistenceImpl
 * @see PositionRegistrationUtil
 * @generated
 */
@ProviderType
public interface PositionRegistrationPersistence extends BasePersistence<PositionRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PositionRegistrationUtil} to access the position registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the position registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching position registrations
	*/
	public java.util.List<PositionRegistration> findByUuid(String uuid);

	/**
	* Returns a range of all the position registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @return the range of matching position registrations
	*/
	public java.util.List<PositionRegistration> findByUuid(String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the position registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching position registrations
	*/
	public java.util.List<PositionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the position registrations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching position registrations
	*/
	public java.util.List<PositionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first position registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position registration
	* @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	*/
	public PositionRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the first position registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position registration, or <code>null</code> if a matching position registration could not be found
	*/
	public PositionRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns the last position registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position registration
	* @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	*/
	public PositionRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the last position registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position registration, or <code>null</code> if a matching position registration could not be found
	*/
	public PositionRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns the position registrations before and after the current position registration in the ordered set where uuid = &#63;.
	*
	* @param POSITION_ID the primary key of the current position registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position registration
	* @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	*/
	public PositionRegistration[] findByUuid_PrevAndNext(long POSITION_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException;

	/**
	* Removes all the position registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of position registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching position registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the position registration where POSITION_ID = &#63; or throws a {@link NoSuchPositionRegistrationException} if it could not be found.
	*
	* @param POSITION_ID the position_id
	* @return the matching position registration
	* @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	*/
	public PositionRegistration findByPOSITION_ID(long POSITION_ID)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the position registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param POSITION_ID the position_id
	* @return the matching position registration, or <code>null</code> if a matching position registration could not be found
	*/
	public PositionRegistration fetchByPOSITION_ID(long POSITION_ID);

	/**
	* Returns the position registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param POSITION_ID the position_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching position registration, or <code>null</code> if a matching position registration could not be found
	*/
	public PositionRegistration fetchByPOSITION_ID(long POSITION_ID,
		boolean retrieveFromCache);

	/**
	* Removes the position registration where POSITION_ID = &#63; from the database.
	*
	* @param POSITION_ID the position_id
	* @return the position registration that was removed
	*/
	public PositionRegistration removeByPOSITION_ID(long POSITION_ID)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the number of position registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the number of matching position registrations
	*/
	public int countByPOSITION_ID(long POSITION_ID);

	/**
	* Returns all the position registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching position registrations
	*/
	public java.util.List<PositionRegistration> findBySTATUS(int STATUS);

	/**
	* Returns a range of all the position registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @return the range of matching position registrations
	*/
	public java.util.List<PositionRegistration> findBySTATUS(int STATUS,
		int start, int end);

	/**
	* Returns an ordered range of all the position registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching position registrations
	*/
	public java.util.List<PositionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the position registrations where STATUS = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param STATUS the status
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching position registrations
	*/
	public java.util.List<PositionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first position registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position registration
	* @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	*/
	public PositionRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the first position registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching position registration, or <code>null</code> if a matching position registration could not be found
	*/
	public PositionRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns the last position registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position registration
	* @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	*/
	public PositionRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the last position registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching position registration, or <code>null</code> if a matching position registration could not be found
	*/
	public PositionRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns the position registrations before and after the current position registration in the ordered set where STATUS = &#63;.
	*
	* @param POSITION_ID the primary key of the current position registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next position registration
	* @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	*/
	public PositionRegistration[] findBySTATUS_PrevAndNext(long POSITION_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException;

	/**
	* Removes all the position registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of position registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching position registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Caches the position registration in the entity cache if it is enabled.
	*
	* @param positionRegistration the position registration
	*/
	public void cacheResult(PositionRegistration positionRegistration);

	/**
	* Caches the position registrations in the entity cache if it is enabled.
	*
	* @param positionRegistrations the position registrations
	*/
	public void cacheResult(
		java.util.List<PositionRegistration> positionRegistrations);

	/**
	* Creates a new position registration with the primary key. Does not add the position registration to the database.
	*
	* @param POSITION_ID the primary key for the new position registration
	* @return the new position registration
	*/
	public PositionRegistration create(long POSITION_ID);

	/**
	* Removes the position registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param POSITION_ID the primary key of the position registration
	* @return the position registration that was removed
	* @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	*/
	public PositionRegistration remove(long POSITION_ID)
		throws NoSuchPositionRegistrationException;

	public PositionRegistration updateImpl(
		PositionRegistration positionRegistration);

	/**
	* Returns the position registration with the primary key or throws a {@link NoSuchPositionRegistrationException} if it could not be found.
	*
	* @param POSITION_ID the primary key of the position registration
	* @return the position registration
	* @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	*/
	public PositionRegistration findByPrimaryKey(long POSITION_ID)
		throws NoSuchPositionRegistrationException;

	/**
	* Returns the position registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param POSITION_ID the primary key of the position registration
	* @return the position registration, or <code>null</code> if a position registration with the primary key could not be found
	*/
	public PositionRegistration fetchByPrimaryKey(long POSITION_ID);

	@Override
	public java.util.Map<java.io.Serializable, PositionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the position registrations.
	*
	* @return the position registrations
	*/
	public java.util.List<PositionRegistration> findAll();

	/**
	* Returns a range of all the position registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @return the range of position registrations
	*/
	public java.util.List<PositionRegistration> findAll(int start, int end);

	/**
	* Returns an ordered range of all the position registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of position registrations
	*/
	public java.util.List<PositionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator);

	/**
	* Returns an ordered range of all the position registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PositionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of position registrations
	* @param end the upper bound of the range of position registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of position registrations
	*/
	public java.util.List<PositionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PositionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the position registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of position registrations.
	*
	* @return the number of position registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}