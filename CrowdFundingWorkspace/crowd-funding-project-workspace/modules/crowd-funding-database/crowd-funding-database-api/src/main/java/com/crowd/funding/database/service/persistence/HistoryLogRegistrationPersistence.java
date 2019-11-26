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

import com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException;
import com.crowd.funding.database.model.HistoryLogRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the history log registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.HistoryLogRegistrationPersistenceImpl
 * @see HistoryLogRegistrationUtil
 * @generated
 */
@ProviderType
public interface HistoryLogRegistrationPersistence extends BasePersistence<HistoryLogRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistoryLogRegistrationUtil} to access the history log registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the history log registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching history log registrations
	*/
	public java.util.List<HistoryLogRegistration> findByUuid(String uuid);

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
	public java.util.List<HistoryLogRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<HistoryLogRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

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
	public java.util.List<HistoryLogRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public HistoryLogRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Returns the first history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public HistoryLogRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

	/**
	* Returns the last history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public HistoryLogRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Returns the last history log registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public HistoryLogRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

	/**
	* Returns the history log registrations before and after the current history log registration in the ordered set where uuid = &#63;.
	*
	* @param HISTORY_ID the primary key of the current history log registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next history log registration
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public HistoryLogRegistration[] findByUuid_PrevAndNext(long HISTORY_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Removes all the history log registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of history log registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching history log registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns all the history log registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the matching history log registrations
	*/
	public java.util.List<HistoryLogRegistration> findByUSER_ID(long USER_ID);

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
	public java.util.List<HistoryLogRegistration> findByUSER_ID(long USER_ID,
		int start, int end);

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
	public java.util.List<HistoryLogRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

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
	public java.util.List<HistoryLogRegistration> findByUSER_ID(long USER_ID,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public HistoryLogRegistration findByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Returns the first history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public HistoryLogRegistration fetchByUSER_ID_First(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

	/**
	* Returns the last history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration
	* @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	*/
	public HistoryLogRegistration findByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Returns the last history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching history log registration, or <code>null</code> if a matching history log registration could not be found
	*/
	public HistoryLogRegistration fetchByUSER_ID_Last(long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

	/**
	* Returns the history log registrations before and after the current history log registration in the ordered set where USER_ID = &#63;.
	*
	* @param HISTORY_ID the primary key of the current history log registration
	* @param USER_ID the user_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next history log registration
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public HistoryLogRegistration[] findByUSER_ID_PrevAndNext(long HISTORY_ID,
		long USER_ID,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Removes all the history log registrations where USER_ID = &#63; from the database.
	*
	* @param USER_ID the user_id
	*/
	public void removeByUSER_ID(long USER_ID);

	/**
	* Returns the number of history log registrations where USER_ID = &#63;.
	*
	* @param USER_ID the user_id
	* @return the number of matching history log registrations
	*/
	public int countByUSER_ID(long USER_ID);

	/**
	* Caches the history log registration in the entity cache if it is enabled.
	*
	* @param historyLogRegistration the history log registration
	*/
	public void cacheResult(HistoryLogRegistration historyLogRegistration);

	/**
	* Caches the history log registrations in the entity cache if it is enabled.
	*
	* @param historyLogRegistrations the history log registrations
	*/
	public void cacheResult(
		java.util.List<HistoryLogRegistration> historyLogRegistrations);

	/**
	* Creates a new history log registration with the primary key. Does not add the history log registration to the database.
	*
	* @param HISTORY_ID the primary key for the new history log registration
	* @return the new history log registration
	*/
	public HistoryLogRegistration create(long HISTORY_ID);

	/**
	* Removes the history log registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration that was removed
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public HistoryLogRegistration remove(long HISTORY_ID)
		throws NoSuchHistoryLogRegistrationException;

	public HistoryLogRegistration updateImpl(
		HistoryLogRegistration historyLogRegistration);

	/**
	* Returns the history log registration with the primary key or throws a {@link NoSuchHistoryLogRegistrationException} if it could not be found.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration
	* @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	*/
	public HistoryLogRegistration findByPrimaryKey(long HISTORY_ID)
		throws NoSuchHistoryLogRegistrationException;

	/**
	* Returns the history log registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param HISTORY_ID the primary key of the history log registration
	* @return the history log registration, or <code>null</code> if a history log registration with the primary key could not be found
	*/
	public HistoryLogRegistration fetchByPrimaryKey(long HISTORY_ID);

	@Override
	public java.util.Map<java.io.Serializable, HistoryLogRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the history log registrations.
	*
	* @return the history log registrations
	*/
	public java.util.List<HistoryLogRegistration> findAll();

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
	public java.util.List<HistoryLogRegistration> findAll(int start, int end);

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
	public java.util.List<HistoryLogRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator);

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
	public java.util.List<HistoryLogRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the history log registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of history log registrations.
	*
	* @return the number of history log registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}