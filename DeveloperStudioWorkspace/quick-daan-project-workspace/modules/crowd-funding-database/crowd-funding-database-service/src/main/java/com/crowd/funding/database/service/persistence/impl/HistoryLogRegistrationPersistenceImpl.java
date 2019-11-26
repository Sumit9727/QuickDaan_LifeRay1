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

import com.crowd.funding.database.exception.NoSuchHistoryLogRegistrationException;
import com.crowd.funding.database.model.HistoryLogRegistration;
import com.crowd.funding.database.model.impl.HistoryLogRegistrationImpl;
import com.crowd.funding.database.model.impl.HistoryLogRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.HistoryLogRegistrationPersistence;

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
 * The persistence implementation for the history log registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HistoryLogRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.HistoryLogRegistrationUtil
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationPersistenceImpl extends BasePersistenceImpl<HistoryLogRegistration>
	implements HistoryLogRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistoryLogRegistrationUtil} to access the history log registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistoryLogRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			HistoryLogRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the history log registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching history log registrations
	 */
	@Override
	public List<HistoryLogRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<HistoryLogRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<HistoryLogRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<HistoryLogRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<HistoryLogRegistration> orderByComparator,
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

		List<HistoryLogRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<HistoryLogRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HistoryLogRegistration historyLogRegistration : list) {
					if (!Objects.equals(uuid, historyLogRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_HISTORYLOGREGISTRATION_WHERE);

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
				query.append(HistoryLogRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<HistoryLogRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HistoryLogRegistration>)QueryUtil.list(q,
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
	 * Returns the first history log registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching history log registration
	 * @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration findByUuid_First(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (historyLogRegistration != null) {
			return historyLogRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchHistoryLogRegistrationException(msg.toString());
	}

	/**
	 * Returns the first history log registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching history log registration, or <code>null</code> if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration fetchByUuid_First(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		List<HistoryLogRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last history log registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching history log registration
	 * @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration findByUuid_Last(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (historyLogRegistration != null) {
			return historyLogRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchHistoryLogRegistrationException(msg.toString());
	}

	/**
	 * Returns the last history log registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching history log registration, or <code>null</code> if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<HistoryLogRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public HistoryLogRegistration[] findByUuid_PrevAndNext(long HISTORY_ID,
		String uuid, OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = findByPrimaryKey(HISTORY_ID);

		Session session = null;

		try {
			session = openSession();

			HistoryLogRegistration[] array = new HistoryLogRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, historyLogRegistration,
					uuid, orderByComparator, true);

			array[1] = historyLogRegistration;

			array[2] = getByUuid_PrevAndNext(session, historyLogRegistration,
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

	protected HistoryLogRegistration getByUuid_PrevAndNext(Session session,
		HistoryLogRegistration historyLogRegistration, String uuid,
		OrderByComparator<HistoryLogRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_HISTORYLOGREGISTRATION_WHERE);

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
			query.append(HistoryLogRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(historyLogRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HistoryLogRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the history log registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (HistoryLogRegistration historyLogRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(historyLogRegistration);
		}
	}

	/**
	 * Returns the number of history log registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching history log registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HISTORYLOGREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "historyLogRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "historyLogRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(historyLogRegistration.uuid IS NULL OR historyLogRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUSER_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID =
		new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUSER_ID",
			new String[] { Long.class.getName() },
			HistoryLogRegistrationModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_ID = new FinderPath(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSER_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the history log registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the matching history log registrations
	 */
	@Override
	public List<HistoryLogRegistration> findByUSER_ID(long USER_ID) {
		return findByUSER_ID(USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<HistoryLogRegistration> findByUSER_ID(long USER_ID, int start,
		int end) {
		return findByUSER_ID(USER_ID, start, end, null);
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
	@Override
	public List<HistoryLogRegistration> findByUSER_ID(long USER_ID, int start,
		int end, OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return findByUSER_ID(USER_ID, start, end, orderByComparator, true);
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
	@Override
	public List<HistoryLogRegistration> findByUSER_ID(long USER_ID, int start,
		int end, OrderByComparator<HistoryLogRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { USER_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID;
			finderArgs = new Object[] { USER_ID, start, end, orderByComparator };
		}

		List<HistoryLogRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<HistoryLogRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HistoryLogRegistration historyLogRegistration : list) {
					if ((USER_ID != historyLogRegistration.getUSER_ID())) {
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

			query.append(_SQL_SELECT_HISTORYLOGREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HistoryLogRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

				if (!pagination) {
					list = (List<HistoryLogRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HistoryLogRegistration>)QueryUtil.list(q,
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
	 * Returns the first history log registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching history log registration
	 * @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = fetchByUSER_ID_First(USER_ID,
				orderByComparator);

		if (historyLogRegistration != null) {
			return historyLogRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchHistoryLogRegistrationException(msg.toString());
	}

	/**
	 * Returns the first history log registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching history log registration, or <code>null</code> if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		List<HistoryLogRegistration> list = findByUSER_ID(USER_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last history log registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching history log registration
	 * @throws NoSuchHistoryLogRegistrationException if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = fetchByUSER_ID_Last(USER_ID,
				orderByComparator);

		if (historyLogRegistration != null) {
			return historyLogRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchHistoryLogRegistrationException(msg.toString());
	}

	/**
	 * Returns the last history log registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching history log registration, or <code>null</code> if a matching history log registration could not be found
	 */
	@Override
	public HistoryLogRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		int count = countByUSER_ID(USER_ID);

		if (count == 0) {
			return null;
		}

		List<HistoryLogRegistration> list = findByUSER_ID(USER_ID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public HistoryLogRegistration[] findByUSER_ID_PrevAndNext(long HISTORY_ID,
		long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = findByPrimaryKey(HISTORY_ID);

		Session session = null;

		try {
			session = openSession();

			HistoryLogRegistration[] array = new HistoryLogRegistrationImpl[3];

			array[0] = getByUSER_ID_PrevAndNext(session,
					historyLogRegistration, USER_ID, orderByComparator, true);

			array[1] = historyLogRegistration;

			array[2] = getByUSER_ID_PrevAndNext(session,
					historyLogRegistration, USER_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HistoryLogRegistration getByUSER_ID_PrevAndNext(Session session,
		HistoryLogRegistration historyLogRegistration, long USER_ID,
		OrderByComparator<HistoryLogRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_HISTORYLOGREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

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
			query.append(HistoryLogRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(historyLogRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HistoryLogRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the history log registrations where USER_ID = &#63; from the database.
	 *
	 * @param USER_ID the user_id
	 */
	@Override
	public void removeByUSER_ID(long USER_ID) {
		for (HistoryLogRegistration historyLogRegistration : findByUSER_ID(
				USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(historyLogRegistration);
		}
	}

	/**
	 * Returns the number of history log registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the number of matching history log registrations
	 */
	@Override
	public int countByUSER_ID(long USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_ID;

		Object[] finderArgs = new Object[] { USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HISTORYLOGREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

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

	private static final String _FINDER_COLUMN_USER_ID_USER_ID_2 = "historyLogRegistration.USER_ID = ?";

	public HistoryLogRegistrationPersistenceImpl() {
		setModelClass(HistoryLogRegistration.class);

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
	 * Caches the history log registration in the entity cache if it is enabled.
	 *
	 * @param historyLogRegistration the history log registration
	 */
	@Override
	public void cacheResult(HistoryLogRegistration historyLogRegistration) {
		entityCache.putResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			historyLogRegistration.getPrimaryKey(), historyLogRegistration);

		historyLogRegistration.resetOriginalValues();
	}

	/**
	 * Caches the history log registrations in the entity cache if it is enabled.
	 *
	 * @param historyLogRegistrations the history log registrations
	 */
	@Override
	public void cacheResult(
		List<HistoryLogRegistration> historyLogRegistrations) {
		for (HistoryLogRegistration historyLogRegistration : historyLogRegistrations) {
			if (entityCache.getResult(
						HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						HistoryLogRegistrationImpl.class,
						historyLogRegistration.getPrimaryKey()) == null) {
				cacheResult(historyLogRegistration);
			}
			else {
				historyLogRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all history log registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HistoryLogRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the history log registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistoryLogRegistration historyLogRegistration) {
		entityCache.removeResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			historyLogRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistoryLogRegistration> historyLogRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistoryLogRegistration historyLogRegistration : historyLogRegistrations) {
			entityCache.removeResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				HistoryLogRegistrationImpl.class,
				historyLogRegistration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new history log registration with the primary key. Does not add the history log registration to the database.
	 *
	 * @param HISTORY_ID the primary key for the new history log registration
	 * @return the new history log registration
	 */
	@Override
	public HistoryLogRegistration create(long HISTORY_ID) {
		HistoryLogRegistration historyLogRegistration = new HistoryLogRegistrationImpl();

		historyLogRegistration.setNew(true);
		historyLogRegistration.setPrimaryKey(HISTORY_ID);

		String uuid = PortalUUIDUtil.generate();

		historyLogRegistration.setUuid(uuid);

		return historyLogRegistration;
	}

	/**
	 * Removes the history log registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param HISTORY_ID the primary key of the history log registration
	 * @return the history log registration that was removed
	 * @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	 */
	@Override
	public HistoryLogRegistration remove(long HISTORY_ID)
		throws NoSuchHistoryLogRegistrationException {
		return remove((Serializable)HISTORY_ID);
	}

	/**
	 * Removes the history log registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the history log registration
	 * @return the history log registration that was removed
	 * @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	 */
	@Override
	public HistoryLogRegistration remove(Serializable primaryKey)
		throws NoSuchHistoryLogRegistrationException {
		Session session = null;

		try {
			session = openSession();

			HistoryLogRegistration historyLogRegistration = (HistoryLogRegistration)session.get(HistoryLogRegistrationImpl.class,
					primaryKey);

			if (historyLogRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoryLogRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(historyLogRegistration);
		}
		catch (NoSuchHistoryLogRegistrationException nsee) {
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
	protected HistoryLogRegistration removeImpl(
		HistoryLogRegistration historyLogRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(historyLogRegistration)) {
				historyLogRegistration = (HistoryLogRegistration)session.get(HistoryLogRegistrationImpl.class,
						historyLogRegistration.getPrimaryKeyObj());
			}

			if (historyLogRegistration != null) {
				session.delete(historyLogRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (historyLogRegistration != null) {
			clearCache(historyLogRegistration);
		}

		return historyLogRegistration;
	}

	@Override
	public HistoryLogRegistration updateImpl(
		HistoryLogRegistration historyLogRegistration) {
		boolean isNew = historyLogRegistration.isNew();

		if (!(historyLogRegistration instanceof HistoryLogRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(historyLogRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(historyLogRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in historyLogRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HistoryLogRegistration implementation " +
				historyLogRegistration.getClass());
		}

		HistoryLogRegistrationModelImpl historyLogRegistrationModelImpl = (HistoryLogRegistrationModelImpl)historyLogRegistration;

		if (Validator.isNull(historyLogRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			historyLogRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (historyLogRegistration.isNew()) {
				session.save(historyLogRegistration);

				historyLogRegistration.setNew(false);
			}
			else {
				historyLogRegistration = (HistoryLogRegistration)session.merge(historyLogRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!HistoryLogRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					historyLogRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { historyLogRegistrationModelImpl.getUSER_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((historyLogRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						historyLogRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { historyLogRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((historyLogRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						historyLogRegistrationModelImpl.getOriginalUSER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);

				args = new Object[] { historyLogRegistrationModelImpl.getUSER_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);
			}
		}

		entityCache.putResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryLogRegistrationImpl.class,
			historyLogRegistration.getPrimaryKey(), historyLogRegistration,
			false);

		historyLogRegistration.resetOriginalValues();

		return historyLogRegistration;
	}

	/**
	 * Returns the history log registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the history log registration
	 * @return the history log registration
	 * @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	 */
	@Override
	public HistoryLogRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistoryLogRegistrationException {
		HistoryLogRegistration historyLogRegistration = fetchByPrimaryKey(primaryKey);

		if (historyLogRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistoryLogRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return historyLogRegistration;
	}

	/**
	 * Returns the history log registration with the primary key or throws a {@link NoSuchHistoryLogRegistrationException} if it could not be found.
	 *
	 * @param HISTORY_ID the primary key of the history log registration
	 * @return the history log registration
	 * @throws NoSuchHistoryLogRegistrationException if a history log registration with the primary key could not be found
	 */
	@Override
	public HistoryLogRegistration findByPrimaryKey(long HISTORY_ID)
		throws NoSuchHistoryLogRegistrationException {
		return findByPrimaryKey((Serializable)HISTORY_ID);
	}

	/**
	 * Returns the history log registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the history log registration
	 * @return the history log registration, or <code>null</code> if a history log registration with the primary key could not be found
	 */
	@Override
	public HistoryLogRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				HistoryLogRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		HistoryLogRegistration historyLogRegistration = (HistoryLogRegistration)serializable;

		if (historyLogRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				historyLogRegistration = (HistoryLogRegistration)session.get(HistoryLogRegistrationImpl.class,
						primaryKey);

				if (historyLogRegistration != null) {
					cacheResult(historyLogRegistration);
				}
				else {
					entityCache.putResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						HistoryLogRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					HistoryLogRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return historyLogRegistration;
	}

	/**
	 * Returns the history log registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param HISTORY_ID the primary key of the history log registration
	 * @return the history log registration, or <code>null</code> if a history log registration with the primary key could not be found
	 */
	@Override
	public HistoryLogRegistration fetchByPrimaryKey(long HISTORY_ID) {
		return fetchByPrimaryKey((Serializable)HISTORY_ID);
	}

	@Override
	public Map<Serializable, HistoryLogRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, HistoryLogRegistration> map = new HashMap<Serializable, HistoryLogRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			HistoryLogRegistration historyLogRegistration = fetchByPrimaryKey(primaryKey);

			if (historyLogRegistration != null) {
				map.put(primaryKey, historyLogRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					HistoryLogRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (HistoryLogRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_HISTORYLOGREGISTRATION_WHERE_PKS_IN);

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

			for (HistoryLogRegistration historyLogRegistration : (List<HistoryLogRegistration>)q.list()) {
				map.put(historyLogRegistration.getPrimaryKeyObj(),
					historyLogRegistration);

				cacheResult(historyLogRegistration);

				uncachedPrimaryKeys.remove(historyLogRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(HistoryLogRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					HistoryLogRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the history log registrations.
	 *
	 * @return the history log registrations
	 */
	@Override
	public List<HistoryLogRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<HistoryLogRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<HistoryLogRegistration> findAll(int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<HistoryLogRegistration> findAll(int start, int end,
		OrderByComparator<HistoryLogRegistration> orderByComparator,
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

		List<HistoryLogRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<HistoryLogRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HISTORYLOGREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTORYLOGREGISTRATION;

				if (pagination) {
					sql = sql.concat(HistoryLogRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistoryLogRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<HistoryLogRegistration>)QueryUtil.list(q,
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
	 * Removes all the history log registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HistoryLogRegistration historyLogRegistration : findAll()) {
			remove(historyLogRegistration);
		}
	}

	/**
	 * Returns the number of history log registrations.
	 *
	 * @return the number of history log registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HISTORYLOGREGISTRATION);

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
		return HistoryLogRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the history log registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(HistoryLogRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_HISTORYLOGREGISTRATION = "SELECT historyLogRegistration FROM HistoryLogRegistration historyLogRegistration";
	private static final String _SQL_SELECT_HISTORYLOGREGISTRATION_WHERE_PKS_IN = "SELECT historyLogRegistration FROM HistoryLogRegistration historyLogRegistration WHERE HISTORY_ID IN (";
	private static final String _SQL_SELECT_HISTORYLOGREGISTRATION_WHERE = "SELECT historyLogRegistration FROM HistoryLogRegistration historyLogRegistration WHERE ";
	private static final String _SQL_COUNT_HISTORYLOGREGISTRATION = "SELECT COUNT(historyLogRegistration) FROM HistoryLogRegistration historyLogRegistration";
	private static final String _SQL_COUNT_HISTORYLOGREGISTRATION_WHERE = "SELECT COUNT(historyLogRegistration) FROM HistoryLogRegistration historyLogRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "historyLogRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistoryLogRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HistoryLogRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(HistoryLogRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}