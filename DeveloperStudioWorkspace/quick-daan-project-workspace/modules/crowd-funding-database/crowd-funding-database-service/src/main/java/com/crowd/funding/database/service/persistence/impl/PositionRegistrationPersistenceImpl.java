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

import com.crowd.funding.database.exception.NoSuchPositionRegistrationException;
import com.crowd.funding.database.model.PositionRegistration;
import com.crowd.funding.database.model.impl.PositionRegistrationImpl;
import com.crowd.funding.database.model.impl.PositionRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.PositionRegistrationPersistence;

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
 * The persistence implementation for the position registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PositionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.PositionRegistrationUtil
 * @generated
 */
@ProviderType
public class PositionRegistrationPersistenceImpl extends BasePersistenceImpl<PositionRegistration>
	implements PositionRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PositionRegistrationUtil} to access the position registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PositionRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PositionRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the position registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching position registrations
	 */
	@Override
	public List<PositionRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PositionRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<PositionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<PositionRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PositionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<PositionRegistration> orderByComparator,
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

		List<PositionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<PositionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PositionRegistration positionRegistration : list) {
					if (!Objects.equals(uuid, positionRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_POSITIONREGISTRATION_WHERE);

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
				query.append(PositionRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<PositionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PositionRegistration>)QueryUtil.list(q,
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
	 * Returns the first position registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position registration
	 * @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration findByUuid_First(String uuid,
		OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (positionRegistration != null) {
			return positionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPositionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first position registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position registration, or <code>null</code> if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<PositionRegistration> orderByComparator) {
		List<PositionRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position registration
	 * @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration findByUuid_Last(String uuid,
		OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (positionRegistration != null) {
			return positionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPositionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last position registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position registration, or <code>null</code> if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<PositionRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PositionRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the position registrations before and after the current position registration in the ordered set where uuid = &#63;.
	 *
	 * @param POSITION_ID the primary key of the current position registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position registration
	 * @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration[] findByUuid_PrevAndNext(long POSITION_ID,
		String uuid, OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = findByPrimaryKey(POSITION_ID);

		Session session = null;

		try {
			session = openSession();

			PositionRegistration[] array = new PositionRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, positionRegistration,
					uuid, orderByComparator, true);

			array[1] = positionRegistration;

			array[2] = getByUuid_PrevAndNext(session, positionRegistration,
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

	protected PositionRegistration getByUuid_PrevAndNext(Session session,
		PositionRegistration positionRegistration, String uuid,
		OrderByComparator<PositionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_POSITIONREGISTRATION_WHERE);

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
			query.append(PositionRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(positionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PositionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the position registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PositionRegistration positionRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(positionRegistration);
		}
	}

	/**
	 * Returns the number of position registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching position registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSITIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "positionRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "positionRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(positionRegistration.uuid IS NULL OR positionRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITION_ID = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPOSITION_ID", new String[] { Long.class.getName() },
			PositionRegistrationModelImpl.POSITION_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITION_ID = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPOSITION_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the position registration where POSITION_ID = &#63; or throws a {@link NoSuchPositionRegistrationException} if it could not be found.
	 *
	 * @param POSITION_ID the position_id
	 * @return the matching position registration
	 * @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration findByPOSITION_ID(long POSITION_ID)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = fetchByPOSITION_ID(POSITION_ID);

		if (positionRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("POSITION_ID=");
			msg.append(POSITION_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPositionRegistrationException(msg.toString());
		}

		return positionRegistration;
	}

	/**
	 * Returns the position registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param POSITION_ID the position_id
	 * @return the matching position registration, or <code>null</code> if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration fetchByPOSITION_ID(long POSITION_ID) {
		return fetchByPOSITION_ID(POSITION_ID, true);
	}

	/**
	 * Returns the position registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param POSITION_ID the position_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching position registration, or <code>null</code> if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration fetchByPOSITION_ID(long POSITION_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { POSITION_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_POSITION_ID,
					finderArgs, this);
		}

		if (result instanceof PositionRegistration) {
			PositionRegistration positionRegistration = (PositionRegistration)result;

			if ((POSITION_ID != positionRegistration.getPOSITION_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_POSITIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_POSITION_ID_POSITION_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(POSITION_ID);

				List<PositionRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PositionRegistrationPersistenceImpl.fetchByPOSITION_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PositionRegistration positionRegistration = list.get(0);

					result = positionRegistration;

					cacheResult(positionRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION_ID,
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
			return (PositionRegistration)result;
		}
	}

	/**
	 * Removes the position registration where POSITION_ID = &#63; from the database.
	 *
	 * @param POSITION_ID the position_id
	 * @return the position registration that was removed
	 */
	@Override
	public PositionRegistration removeByPOSITION_ID(long POSITION_ID)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = findByPOSITION_ID(POSITION_ID);

		return remove(positionRegistration);
	}

	/**
	 * Returns the number of position registrations where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @return the number of matching position registrations
	 */
	@Override
	public int countByPOSITION_ID(long POSITION_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITION_ID;

		Object[] finderArgs = new Object[] { POSITION_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSITIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_POSITION_ID_POSITION_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(POSITION_ID);

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

	private static final String _FINDER_COLUMN_POSITION_ID_POSITION_ID_2 = "positionRegistration.POSITION_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			PositionRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the position registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching position registrations
	 */
	@Override
	public List<PositionRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PositionRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

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
	@Override
	public List<PositionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<PositionRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PositionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<PositionRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { STATUS };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { STATUS, start, end, orderByComparator };
		}

		List<PositionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<PositionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PositionRegistration positionRegistration : list) {
					if ((STATUS != positionRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_POSITIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PositionRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<PositionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PositionRegistration>)QueryUtil.list(q,
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
	 * Returns the first position registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position registration
	 * @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (positionRegistration != null) {
			return positionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchPositionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first position registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position registration, or <code>null</code> if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<PositionRegistration> orderByComparator) {
		List<PositionRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last position registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position registration
	 * @throws NoSuchPositionRegistrationException if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (positionRegistration != null) {
			return positionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchPositionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last position registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position registration, or <code>null</code> if a matching position registration could not be found
	 */
	@Override
	public PositionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<PositionRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<PositionRegistration> list = findBySTATUS(STATUS, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the position registrations before and after the current position registration in the ordered set where STATUS = &#63;.
	 *
	 * @param POSITION_ID the primary key of the current position registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position registration
	 * @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration[] findBySTATUS_PrevAndNext(long POSITION_ID,
		int STATUS, OrderByComparator<PositionRegistration> orderByComparator)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = findByPrimaryKey(POSITION_ID);

		Session session = null;

		try {
			session = openSession();

			PositionRegistration[] array = new PositionRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session, positionRegistration,
					STATUS, orderByComparator, true);

			array[1] = positionRegistration;

			array[2] = getBySTATUS_PrevAndNext(session, positionRegistration,
					STATUS, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PositionRegistration getBySTATUS_PrevAndNext(Session session,
		PositionRegistration positionRegistration, int STATUS,
		OrderByComparator<PositionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_POSITIONREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(PositionRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(positionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PositionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the position registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (PositionRegistration positionRegistration : findBySTATUS(STATUS,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(positionRegistration);
		}
	}

	/**
	 * Returns the number of position registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching position registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSITIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "positionRegistration.STATUS = ?";

	public PositionRegistrationPersistenceImpl() {
		setModelClass(PositionRegistration.class);

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
	 * Caches the position registration in the entity cache if it is enabled.
	 *
	 * @param positionRegistration the position registration
	 */
	@Override
	public void cacheResult(PositionRegistration positionRegistration) {
		entityCache.putResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			positionRegistration.getPrimaryKey(), positionRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION_ID,
			new Object[] { positionRegistration.getPOSITION_ID() },
			positionRegistration);

		positionRegistration.resetOriginalValues();
	}

	/**
	 * Caches the position registrations in the entity cache if it is enabled.
	 *
	 * @param positionRegistrations the position registrations
	 */
	@Override
	public void cacheResult(List<PositionRegistration> positionRegistrations) {
		for (PositionRegistration positionRegistration : positionRegistrations) {
			if (entityCache.getResult(
						PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PositionRegistrationImpl.class,
						positionRegistration.getPrimaryKey()) == null) {
				cacheResult(positionRegistration);
			}
			else {
				positionRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all position registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PositionRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the position registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PositionRegistration positionRegistration) {
		entityCache.removeResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationImpl.class, positionRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PositionRegistrationModelImpl)positionRegistration,
			true);
	}

	@Override
	public void clearCache(List<PositionRegistration> positionRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PositionRegistration positionRegistration : positionRegistrations) {
			entityCache.removeResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PositionRegistrationImpl.class,
				positionRegistration.getPrimaryKey());

			clearUniqueFindersCache((PositionRegistrationModelImpl)positionRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		PositionRegistrationModelImpl positionRegistrationModelImpl) {
		Object[] args = new Object[] {
				positionRegistrationModelImpl.getPOSITION_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_POSITION_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION_ID, args,
			positionRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PositionRegistrationModelImpl positionRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					positionRegistrationModelImpl.getPOSITION_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION_ID, args);
		}

		if ((positionRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITION_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					positionRegistrationModelImpl.getOriginalPOSITION_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION_ID, args);
		}
	}

	/**
	 * Creates a new position registration with the primary key. Does not add the position registration to the database.
	 *
	 * @param POSITION_ID the primary key for the new position registration
	 * @return the new position registration
	 */
	@Override
	public PositionRegistration create(long POSITION_ID) {
		PositionRegistration positionRegistration = new PositionRegistrationImpl();

		positionRegistration.setNew(true);
		positionRegistration.setPrimaryKey(POSITION_ID);

		String uuid = PortalUUIDUtil.generate();

		positionRegistration.setUuid(uuid);

		return positionRegistration;
	}

	/**
	 * Removes the position registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param POSITION_ID the primary key of the position registration
	 * @return the position registration that was removed
	 * @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration remove(long POSITION_ID)
		throws NoSuchPositionRegistrationException {
		return remove((Serializable)POSITION_ID);
	}

	/**
	 * Removes the position registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the position registration
	 * @return the position registration that was removed
	 * @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration remove(Serializable primaryKey)
		throws NoSuchPositionRegistrationException {
		Session session = null;

		try {
			session = openSession();

			PositionRegistration positionRegistration = (PositionRegistration)session.get(PositionRegistrationImpl.class,
					primaryKey);

			if (positionRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPositionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(positionRegistration);
		}
		catch (NoSuchPositionRegistrationException nsee) {
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
	protected PositionRegistration removeImpl(
		PositionRegistration positionRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(positionRegistration)) {
				positionRegistration = (PositionRegistration)session.get(PositionRegistrationImpl.class,
						positionRegistration.getPrimaryKeyObj());
			}

			if (positionRegistration != null) {
				session.delete(positionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (positionRegistration != null) {
			clearCache(positionRegistration);
		}

		return positionRegistration;
	}

	@Override
	public PositionRegistration updateImpl(
		PositionRegistration positionRegistration) {
		boolean isNew = positionRegistration.isNew();

		if (!(positionRegistration instanceof PositionRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(positionRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(positionRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in positionRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PositionRegistration implementation " +
				positionRegistration.getClass());
		}

		PositionRegistrationModelImpl positionRegistrationModelImpl = (PositionRegistrationModelImpl)positionRegistration;

		if (Validator.isNull(positionRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			positionRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (positionRegistration.isNew()) {
				session.save(positionRegistration);

				positionRegistration.setNew(false);
			}
			else {
				positionRegistration = (PositionRegistration)session.merge(positionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PositionRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { positionRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { positionRegistrationModelImpl.getSTATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((positionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { positionRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((positionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						positionRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { positionRegistrationModelImpl.getSTATUS() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PositionRegistrationImpl.class,
			positionRegistration.getPrimaryKey(), positionRegistration, false);

		clearUniqueFindersCache(positionRegistrationModelImpl, false);
		cacheUniqueFindersCache(positionRegistrationModelImpl);

		positionRegistration.resetOriginalValues();

		return positionRegistration;
	}

	/**
	 * Returns the position registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the position registration
	 * @return the position registration
	 * @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPositionRegistrationException {
		PositionRegistration positionRegistration = fetchByPrimaryKey(primaryKey);

		if (positionRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPositionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return positionRegistration;
	}

	/**
	 * Returns the position registration with the primary key or throws a {@link NoSuchPositionRegistrationException} if it could not be found.
	 *
	 * @param POSITION_ID the primary key of the position registration
	 * @return the position registration
	 * @throws NoSuchPositionRegistrationException if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration findByPrimaryKey(long POSITION_ID)
		throws NoSuchPositionRegistrationException {
		return findByPrimaryKey((Serializable)POSITION_ID);
	}

	/**
	 * Returns the position registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the position registration
	 * @return the position registration, or <code>null</code> if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PositionRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PositionRegistration positionRegistration = (PositionRegistration)serializable;

		if (positionRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				positionRegistration = (PositionRegistration)session.get(PositionRegistrationImpl.class,
						primaryKey);

				if (positionRegistration != null) {
					cacheResult(positionRegistration);
				}
				else {
					entityCache.putResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PositionRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PositionRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return positionRegistration;
	}

	/**
	 * Returns the position registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param POSITION_ID the primary key of the position registration
	 * @return the position registration, or <code>null</code> if a position registration with the primary key could not be found
	 */
	@Override
	public PositionRegistration fetchByPrimaryKey(long POSITION_ID) {
		return fetchByPrimaryKey((Serializable)POSITION_ID);
	}

	@Override
	public Map<Serializable, PositionRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PositionRegistration> map = new HashMap<Serializable, PositionRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PositionRegistration positionRegistration = fetchByPrimaryKey(primaryKey);

			if (positionRegistration != null) {
				map.put(primaryKey, positionRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PositionRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PositionRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_POSITIONREGISTRATION_WHERE_PKS_IN);

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

			for (PositionRegistration positionRegistration : (List<PositionRegistration>)q.list()) {
				map.put(positionRegistration.getPrimaryKeyObj(),
					positionRegistration);

				cacheResult(positionRegistration);

				uncachedPrimaryKeys.remove(positionRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PositionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PositionRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the position registrations.
	 *
	 * @return the position registrations
	 */
	@Override
	public List<PositionRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PositionRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PositionRegistration> findAll(int start, int end,
		OrderByComparator<PositionRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<PositionRegistration> findAll(int start, int end,
		OrderByComparator<PositionRegistration> orderByComparator,
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

		List<PositionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<PositionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_POSITIONREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POSITIONREGISTRATION;

				if (pagination) {
					sql = sql.concat(PositionRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PositionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PositionRegistration>)QueryUtil.list(q,
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
	 * Removes all the position registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PositionRegistration positionRegistration : findAll()) {
			remove(positionRegistration);
		}
	}

	/**
	 * Returns the number of position registrations.
	 *
	 * @return the number of position registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_POSITIONREGISTRATION);

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
		return PositionRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the position registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PositionRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_POSITIONREGISTRATION = "SELECT positionRegistration FROM PositionRegistration positionRegistration";
	private static final String _SQL_SELECT_POSITIONREGISTRATION_WHERE_PKS_IN = "SELECT positionRegistration FROM PositionRegistration positionRegistration WHERE POSITION_ID IN (";
	private static final String _SQL_SELECT_POSITIONREGISTRATION_WHERE = "SELECT positionRegistration FROM PositionRegistration positionRegistration WHERE ";
	private static final String _SQL_COUNT_POSITIONREGISTRATION = "SELECT COUNT(positionRegistration) FROM PositionRegistration positionRegistration";
	private static final String _SQL_COUNT_POSITIONREGISTRATION_WHERE = "SELECT COUNT(positionRegistration) FROM PositionRegistration positionRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "positionRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PositionRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PositionRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PositionRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}