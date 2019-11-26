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

import com.crowd.funding.database.exception.NoSuchPostionRegistrationException;
import com.crowd.funding.database.model.PostionRegistration;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the postion registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.persistence.impl.PostionRegistrationPersistenceImpl
 * @see PostionRegistrationUtil
 * @generated
 */
@ProviderType
public interface PostionRegistrationPersistence extends BasePersistence<PostionRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PostionRegistrationUtil} to access the postion registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the postion registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching postion registrations
	*/
	public java.util.List<PostionRegistration> findByUuid(String uuid);

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
	public java.util.List<PostionRegistration> findByUuid(String uuid,
		int start, int end);

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
	public java.util.List<PostionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

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
	public java.util.List<PostionRegistration> findByUuid(String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public PostionRegistration findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the first postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public PostionRegistration fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

	/**
	* Returns the last postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public PostionRegistration findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the last postion registration in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public PostionRegistration fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

	/**
	* Returns the postion registrations before and after the current postion registration in the ordered set where uuid = &#63;.
	*
	* @param POSITION_ID the primary key of the current postion registration
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next postion registration
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public PostionRegistration[] findByUuid_PrevAndNext(long POSITION_ID,
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException;

	/**
	* Removes all the postion registrations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of postion registrations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching postion registrations
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the postion registration where POSITION_ID = &#63; or throws a {@link NoSuchPostionRegistrationException} if it could not be found.
	*
	* @param POSITION_ID the position_id
	* @return the matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public PostionRegistration findByPOSITION_ID(long POSITION_ID)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the postion registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param POSITION_ID the position_id
	* @return the matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public PostionRegistration fetchByPOSITION_ID(long POSITION_ID);

	/**
	* Returns the postion registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param POSITION_ID the position_id
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public PostionRegistration fetchByPOSITION_ID(long POSITION_ID,
		boolean retrieveFromCache);

	/**
	* Removes the postion registration where POSITION_ID = &#63; from the database.
	*
	* @param POSITION_ID the position_id
	* @return the postion registration that was removed
	*/
	public PostionRegistration removeByPOSITION_ID(long POSITION_ID)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the number of postion registrations where POSITION_ID = &#63;.
	*
	* @param POSITION_ID the position_id
	* @return the number of matching postion registrations
	*/
	public int countByPOSITION_ID(long POSITION_ID);

	/**
	* Returns all the postion registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the matching postion registrations
	*/
	public java.util.List<PostionRegistration> findBySTATUS(int STATUS);

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
	public java.util.List<PostionRegistration> findBySTATUS(int STATUS,
		int start, int end);

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
	public java.util.List<PostionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

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
	public java.util.List<PostionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public PostionRegistration findBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the first postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public PostionRegistration fetchBySTATUS_First(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

	/**
	* Returns the last postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration
	* @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	*/
	public PostionRegistration findBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the last postion registration in the ordered set where STATUS = &#63;.
	*
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching postion registration, or <code>null</code> if a matching postion registration could not be found
	*/
	public PostionRegistration fetchBySTATUS_Last(int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

	/**
	* Returns the postion registrations before and after the current postion registration in the ordered set where STATUS = &#63;.
	*
	* @param POSITION_ID the primary key of the current postion registration
	* @param STATUS the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next postion registration
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public PostionRegistration[] findBySTATUS_PrevAndNext(long POSITION_ID,
		int STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException;

	/**
	* Removes all the postion registrations where STATUS = &#63; from the database.
	*
	* @param STATUS the status
	*/
	public void removeBySTATUS(int STATUS);

	/**
	* Returns the number of postion registrations where STATUS = &#63;.
	*
	* @param STATUS the status
	* @return the number of matching postion registrations
	*/
	public int countBySTATUS(int STATUS);

	/**
	* Caches the postion registration in the entity cache if it is enabled.
	*
	* @param postionRegistration the postion registration
	*/
	public void cacheResult(PostionRegistration postionRegistration);

	/**
	* Caches the postion registrations in the entity cache if it is enabled.
	*
	* @param postionRegistrations the postion registrations
	*/
	public void cacheResult(
		java.util.List<PostionRegistration> postionRegistrations);

	/**
	* Creates a new postion registration with the primary key. Does not add the postion registration to the database.
	*
	* @param POSITION_ID the primary key for the new postion registration
	* @return the new postion registration
	*/
	public PostionRegistration create(long POSITION_ID);

	/**
	* Removes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration that was removed
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public PostionRegistration remove(long POSITION_ID)
		throws NoSuchPostionRegistrationException;

	public PostionRegistration updateImpl(
		PostionRegistration postionRegistration);

	/**
	* Returns the postion registration with the primary key or throws a {@link NoSuchPostionRegistrationException} if it could not be found.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration
	* @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	*/
	public PostionRegistration findByPrimaryKey(long POSITION_ID)
		throws NoSuchPostionRegistrationException;

	/**
	* Returns the postion registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration, or <code>null</code> if a postion registration with the primary key could not be found
	*/
	public PostionRegistration fetchByPrimaryKey(long POSITION_ID);

	@Override
	public java.util.Map<java.io.Serializable, PostionRegistration> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the postion registrations.
	*
	* @return the postion registrations
	*/
	public java.util.List<PostionRegistration> findAll();

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
	public java.util.List<PostionRegistration> findAll(int start, int end);

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
	public java.util.List<PostionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator);

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
	public java.util.List<PostionRegistration> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PostionRegistration> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the postion registrations from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of postion registrations.
	*
	* @return the number of postion registrations
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}