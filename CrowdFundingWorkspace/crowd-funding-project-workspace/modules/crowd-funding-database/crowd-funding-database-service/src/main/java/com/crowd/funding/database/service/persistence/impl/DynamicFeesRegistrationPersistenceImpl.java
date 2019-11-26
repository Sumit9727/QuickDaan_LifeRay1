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

package com.crowd.funding.database.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.exception.NoSuchDynamicFeesRegistrationException;
import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.model.impl.DynamicFeesRegistrationImpl;
import com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.DynamicFeesRegistrationPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the dynamic fees registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.DynamicFeesRegistrationUtil
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationPersistenceImpl extends BasePersistenceImpl<DynamicFeesRegistration>
	implements DynamicFeesRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DynamicFeesRegistrationUtil} to access the dynamic fees registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DynamicFeesRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			DynamicFeesRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dynamic fees registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching dynamic fees registrations
	 */
	@Override
	public List<DynamicFeesRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DynamicFeesRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<DynamicFeesRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<DynamicFeesRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<DynamicFeesRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DynamicFeesRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DynamicFeesRegistration dynamicFeesRegistration : list) {
					if (!Objects.equals(uuid, dynamicFeesRegistration.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DYNAMICFEESREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DynamicFeesRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<DynamicFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DynamicFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dynamic fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic fees registration
	 * @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration findByUuid_First(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws NoSuchDynamicFeesRegistrationException {
		DynamicFeesRegistration dynamicFeesRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (dynamicFeesRegistration != null) {
			return dynamicFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDynamicFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the first dynamic fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration fetchByUuid_First(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		List<DynamicFeesRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dynamic fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic fees registration
	 * @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration findByUuid_Last(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws NoSuchDynamicFeesRegistrationException {
		DynamicFeesRegistration dynamicFeesRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (dynamicFeesRegistration != null) {
			return dynamicFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchDynamicFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the last dynamic fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DynamicFeesRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DynamicFeesRegistration[] findByUuid_PrevAndNext(long CATEGORY_ID,
		String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator)
		throws NoSuchDynamicFeesRegistrationException {
		DynamicFeesRegistration dynamicFeesRegistration = findByPrimaryKey(CATEGORY_ID);

		Session session = null;

		try {
			session = openSession();

			DynamicFeesRegistration[] array = new DynamicFeesRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, dynamicFeesRegistration,
					uuid, orderByComparator, true);

			array[1] = dynamicFeesRegistration;

			array[2] = getByUuid_PrevAndNext(session, dynamicFeesRegistration,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DynamicFeesRegistration getByUuid_PrevAndNext(Session session,
		DynamicFeesRegistration dynamicFeesRegistration, String uuid,
		OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DYNAMICFEESREGISTRATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DynamicFeesRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dynamicFeesRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DynamicFeesRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dynamic fees registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DynamicFeesRegistration dynamicFeesRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dynamicFeesRegistration);
		}
	}

	/**
	 * Returns the number of dynamic fees registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching dynamic fees registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DYNAMICFEESREGISTRATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "dynamicFeesRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "dynamicFeesRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(dynamicFeesRegistration.uuid IS NULL OR dynamicFeesRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORY_ID = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCATEGORY_ID", new String[] { Long.class.getName() },
			DynamicFeesRegistrationModelImpl.CATEGORY_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY_ID = new FinderPath(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCATEGORY_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the dynamic fees registration where CATEGORY_ID = &#63; or throws a {@link NoSuchDynamicFeesRegistrationException} if it could not be found.
	 *
	 * @param CATEGORY_ID the category_id
	 * @return the matching dynamic fees registration
	 * @throws NoSuchDynamicFeesRegistrationException if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration findByCATEGORY_ID(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException {
		DynamicFeesRegistration dynamicFeesRegistration = fetchByCATEGORY_ID(CATEGORY_ID);

		if (dynamicFeesRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("CATEGORY_ID=");
			msg.append(CATEGORY_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDynamicFeesRegistrationException(msg.toString());
		}

		return dynamicFeesRegistration;
	}

	/**
	 * Returns the dynamic fees registration where CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param CATEGORY_ID the category_id
	 * @return the matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration fetchByCATEGORY_ID(long CATEGORY_ID) {
		return fetchByCATEGORY_ID(CATEGORY_ID, true);
	}

	/**
	 * Returns the dynamic fees registration where CATEGORY_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param CATEGORY_ID the category_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching dynamic fees registration, or <code>null</code> if a matching dynamic fees registration could not be found
	 */
	@Override
	public DynamicFeesRegistration fetchByCATEGORY_ID(long CATEGORY_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { CATEGORY_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CATEGORY_ID,
					finderArgs, this);
		}

		if (result instanceof DynamicFeesRegistration) {
			DynamicFeesRegistration dynamicFeesRegistration = (DynamicFeesRegistration)result;

			if ((CATEGORY_ID != dynamicFeesRegistration.getCATEGORY_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DYNAMICFEESREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_ID_CATEGORY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CATEGORY_ID);

				List<DynamicFeesRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"DynamicFeesRegistrationPersistenceImpl.fetchByCATEGORY_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DynamicFeesRegistration dynamicFeesRegistration = list.get(0);

					result = dynamicFeesRegistration;

					cacheResult(dynamicFeesRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORY_ID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DynamicFeesRegistration)result;
		}
	}

	/**
	 * Removes the dynamic fees registration where CATEGORY_ID = &#63; from the database.
	 *
	 * @param CATEGORY_ID the category_id
	 * @return the dynamic fees registration that was removed
	 */
	@Override
	public DynamicFeesRegistration removeByCATEGORY_ID(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException {
		DynamicFeesRegistration dynamicFeesRegistration = findByCATEGORY_ID(CATEGORY_ID);

		return remove(dynamicFeesRegistration);
	}

	/**
	 * Returns the number of dynamic fees registrations where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @return the number of matching dynamic fees registrations
	 */
	@Override
	public int countByCATEGORY_ID(long CATEGORY_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY_ID;

		Object[] finderArgs = new Object[] { CATEGORY_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DYNAMICFEESREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_ID_CATEGORY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CATEGORY_ID);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORY_ID_CATEGORY_ID_2 = "dynamicFeesRegistration.CATEGORY_ID = ?";

	public DynamicFeesRegistrationPersistenceImpl() {
		setModelClass(DynamicFeesRegistration.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the dynamic fees registration in the entity cache if it is enabled.
	 *
	 * @param dynamicFeesRegistration the dynamic fees registration
	 */
	@Override
	public void cacheResult(DynamicFeesRegistration dynamicFeesRegistration) {
		entityCache.putResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			dynamicFeesRegistration.getPrimaryKey(), dynamicFeesRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY_ID,
			new Object[] { dynamicFeesRegistration.getCATEGORY_ID() },
			dynamicFeesRegistration);

		dynamicFeesRegistration.resetOriginalValues();
	}

	/**
	 * Caches the dynamic fees registrations in the entity cache if it is enabled.
	 *
	 * @param dynamicFeesRegistrations the dynamic fees registrations
	 */
	@Override
	public void cacheResult(
		List<DynamicFeesRegistration> dynamicFeesRegistrations) {
		for (DynamicFeesRegistration dynamicFeesRegistration : dynamicFeesRegistrations) {
			if (entityCache.getResult(
						DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						DynamicFeesRegistrationImpl.class,
						dynamicFeesRegistration.getPrimaryKey()) == null) {
				cacheResult(dynamicFeesRegistration);
			}
			else {
				dynamicFeesRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dynamic fees registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DynamicFeesRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dynamic fees registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DynamicFeesRegistration dynamicFeesRegistration) {
		entityCache.removeResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			dynamicFeesRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DynamicFeesRegistrationModelImpl)dynamicFeesRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<DynamicFeesRegistration> dynamicFeesRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DynamicFeesRegistration dynamicFeesRegistration : dynamicFeesRegistrations) {
			entityCache.removeResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				DynamicFeesRegistrationImpl.class,
				dynamicFeesRegistration.getPrimaryKey());

			clearUniqueFindersCache((DynamicFeesRegistrationModelImpl)dynamicFeesRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		DynamicFeesRegistrationModelImpl dynamicFeesRegistrationModelImpl) {
		Object[] args = new Object[] {
				dynamicFeesRegistrationModelImpl.getCATEGORY_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_CATEGORY_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY_ID, args,
			dynamicFeesRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		DynamicFeesRegistrationModelImpl dynamicFeesRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					dynamicFeesRegistrationModelImpl.getCATEGORY_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORY_ID, args);
		}

		if ((dynamicFeesRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATEGORY_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					dynamicFeesRegistrationModelImpl.getOriginalCATEGORY_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORY_ID, args);
		}
	}

	/**
	 * Creates a new dynamic fees registration with the primary key. Does not add the dynamic fees registration to the database.
	 *
	 * @param CATEGORY_ID the primary key for the new dynamic fees registration
	 * @return the new dynamic fees registration
	 */
	@Override
	public DynamicFeesRegistration create(long CATEGORY_ID) {
		DynamicFeesRegistration dynamicFeesRegistration = new DynamicFeesRegistrationImpl();

		dynamicFeesRegistration.setNew(true);
		dynamicFeesRegistration.setPrimaryKey(CATEGORY_ID);

		String uuid = PortalUUIDUtil.generate();

		dynamicFeesRegistration.setUuid(uuid);

		return dynamicFeesRegistration;
	}

	/**
	 * Removes the dynamic fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CATEGORY_ID the primary key of the dynamic fees registration
	 * @return the dynamic fees registration that was removed
	 * @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	 */
	@Override
	public DynamicFeesRegistration remove(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException {
		return remove((Serializable)CATEGORY_ID);
	}

	/**
	 * Removes the dynamic fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dynamic fees registration
	 * @return the dynamic fees registration that was removed
	 * @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	 */
	@Override
	public DynamicFeesRegistration remove(Serializable primaryKey)
		throws NoSuchDynamicFeesRegistrationException {
		Session session = null;

		try {
			session = openSession();

			DynamicFeesRegistration dynamicFeesRegistration = (DynamicFeesRegistration)session.get(DynamicFeesRegistrationImpl.class,
					primaryKey);

			if (dynamicFeesRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDynamicFeesRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dynamicFeesRegistration);
		}
		catch (NoSuchDynamicFeesRegistrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DynamicFeesRegistration removeImpl(
		DynamicFeesRegistration dynamicFeesRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dynamicFeesRegistration)) {
				dynamicFeesRegistration = (DynamicFeesRegistration)session.get(DynamicFeesRegistrationImpl.class,
						dynamicFeesRegistration.getPrimaryKeyObj());
			}

			if (dynamicFeesRegistration != null) {
				session.delete(dynamicFeesRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dynamicFeesRegistration != null) {
			clearCache(dynamicFeesRegistration);
		}

		return dynamicFeesRegistration;
	}

	@Override
	public DynamicFeesRegistration updateImpl(
		DynamicFeesRegistration dynamicFeesRegistration) {
		boolean isNew = dynamicFeesRegistration.isNew();

		if (!(dynamicFeesRegistration instanceof DynamicFeesRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dynamicFeesRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dynamicFeesRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dynamicFeesRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DynamicFeesRegistration implementation " +
				dynamicFeesRegistration.getClass());
		}

		DynamicFeesRegistrationModelImpl dynamicFeesRegistrationModelImpl = (DynamicFeesRegistrationModelImpl)dynamicFeesRegistration;

		if (Validator.isNull(dynamicFeesRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			dynamicFeesRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (dynamicFeesRegistration.isNew()) {
				session.save(dynamicFeesRegistration);

				dynamicFeesRegistration.setNew(false);
			}
			else {
				dynamicFeesRegistration = (DynamicFeesRegistration)session.merge(dynamicFeesRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DynamicFeesRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					dynamicFeesRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((dynamicFeesRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dynamicFeesRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { dynamicFeesRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			DynamicFeesRegistrationImpl.class,
			dynamicFeesRegistration.getPrimaryKey(), dynamicFeesRegistration,
			false);

		clearUniqueFindersCache(dynamicFeesRegistrationModelImpl, false);
		cacheUniqueFindersCache(dynamicFeesRegistrationModelImpl);

		dynamicFeesRegistration.resetOriginalValues();

		return dynamicFeesRegistration;
	}

	/**
	 * Returns the dynamic fees registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dynamic fees registration
	 * @return the dynamic fees registration
	 * @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	 */
	@Override
	public DynamicFeesRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDynamicFeesRegistrationException {
		DynamicFeesRegistration dynamicFeesRegistration = fetchByPrimaryKey(primaryKey);

		if (dynamicFeesRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDynamicFeesRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dynamicFeesRegistration;
	}

	/**
	 * Returns the dynamic fees registration with the primary key or throws a {@link NoSuchDynamicFeesRegistrationException} if it could not be found.
	 *
	 * @param CATEGORY_ID the primary key of the dynamic fees registration
	 * @return the dynamic fees registration
	 * @throws NoSuchDynamicFeesRegistrationException if a dynamic fees registration with the primary key could not be found
	 */
	@Override
	public DynamicFeesRegistration findByPrimaryKey(long CATEGORY_ID)
		throws NoSuchDynamicFeesRegistrationException {
		return findByPrimaryKey((Serializable)CATEGORY_ID);
	}

	/**
	 * Returns the dynamic fees registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dynamic fees registration
	 * @return the dynamic fees registration, or <code>null</code> if a dynamic fees registration with the primary key could not be found
	 */
	@Override
	public DynamicFeesRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				DynamicFeesRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DynamicFeesRegistration dynamicFeesRegistration = (DynamicFeesRegistration)serializable;

		if (dynamicFeesRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				dynamicFeesRegistration = (DynamicFeesRegistration)session.get(DynamicFeesRegistrationImpl.class,
						primaryKey);

				if (dynamicFeesRegistration != null) {
					cacheResult(dynamicFeesRegistration);
				}
				else {
					entityCache.putResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						DynamicFeesRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DynamicFeesRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dynamicFeesRegistration;
	}

	/**
	 * Returns the dynamic fees registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CATEGORY_ID the primary key of the dynamic fees registration
	 * @return the dynamic fees registration, or <code>null</code> if a dynamic fees registration with the primary key could not be found
	 */
	@Override
	public DynamicFeesRegistration fetchByPrimaryKey(long CATEGORY_ID) {
		return fetchByPrimaryKey((Serializable)CATEGORY_ID);
	}

	@Override
	public Map<Serializable, DynamicFeesRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DynamicFeesRegistration> map = new HashMap<Serializable, DynamicFeesRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DynamicFeesRegistration dynamicFeesRegistration = fetchByPrimaryKey(primaryKey);

			if (dynamicFeesRegistration != null) {
				map.put(primaryKey, dynamicFeesRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DynamicFeesRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DynamicFeesRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DYNAMICFEESREGISTRATION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DynamicFeesRegistration dynamicFeesRegistration : (List<DynamicFeesRegistration>)q.list()) {
				map.put(dynamicFeesRegistration.getPrimaryKeyObj(),
					dynamicFeesRegistration);

				cacheResult(dynamicFeesRegistration);

				uncachedPrimaryKeys.remove(dynamicFeesRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DynamicFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					DynamicFeesRegistrationImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the dynamic fees registrations.
	 *
	 * @return the dynamic fees registrations
	 */
	@Override
	public List<DynamicFeesRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DynamicFeesRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<DynamicFeesRegistration> findAll(int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<DynamicFeesRegistration> findAll(int start, int end,
		OrderByComparator<DynamicFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DynamicFeesRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<DynamicFeesRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DYNAMICFEESREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DYNAMICFEESREGISTRATION;

				if (pagination) {
					sql = sql.concat(DynamicFeesRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DynamicFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DynamicFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dynamic fees registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DynamicFeesRegistration dynamicFeesRegistration : findAll()) {
			remove(dynamicFeesRegistration);
		}
	}

	/**
	 * Returns the number of dynamic fees registrations.
	 *
	 * @return the number of dynamic fees registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DYNAMICFEESREGISTRATION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DynamicFeesRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dynamic fees registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DynamicFeesRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_DYNAMICFEESREGISTRATION = "SELECT dynamicFeesRegistration FROM DynamicFeesRegistration dynamicFeesRegistration";
	private static final String _SQL_SELECT_DYNAMICFEESREGISTRATION_WHERE_PKS_IN =
		"SELECT dynamicFeesRegistration FROM DynamicFeesRegistration dynamicFeesRegistration WHERE CATEGORY_ID IN (";
	private static final String _SQL_SELECT_DYNAMICFEESREGISTRATION_WHERE = "SELECT dynamicFeesRegistration FROM DynamicFeesRegistration dynamicFeesRegistration WHERE ";
	private static final String _SQL_COUNT_DYNAMICFEESREGISTRATION = "SELECT COUNT(dynamicFeesRegistration) FROM DynamicFeesRegistration dynamicFeesRegistration";
	private static final String _SQL_COUNT_DYNAMICFEESREGISTRATION_WHERE = "SELECT COUNT(dynamicFeesRegistration) FROM DynamicFeesRegistration dynamicFeesRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dynamicFeesRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DynamicFeesRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DynamicFeesRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DynamicFeesRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}