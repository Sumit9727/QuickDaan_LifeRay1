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

import com.crowd.funding.database.exception.NoSuchPostionRegistrationException;
import com.crowd.funding.database.model.PostionRegistration;
import com.crowd.funding.database.model.impl.PostionRegistrationImpl;
import com.crowd.funding.database.model.impl.PostionRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.PostionRegistrationPersistence;

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
 * The persistence implementation for the postion registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.PostionRegistrationUtil
 * @generated
 */
@ProviderType
public class PostionRegistrationPersistenceImpl extends BasePersistenceImpl<PostionRegistration>
	implements PostionRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PostionRegistrationUtil} to access the postion registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PostionRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PostionRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the postion registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching postion registrations
	 */
	@Override
	public List<PostionRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PostionRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<PostionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PostionRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator,
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

		List<PostionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<PostionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PostionRegistration postionRegistration : list) {
					if (!Objects.equals(uuid, postionRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_POSTIONREGISTRATION_WHERE);

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
				query.append(PostionRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<PostionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PostionRegistration>)QueryUtil.list(q,
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
	 * Returns the first postion registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching postion registration
	 * @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration findByUuid_First(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (postionRegistration != null) {
			return postionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPostionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first postion registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching postion registration, or <code>null</code> if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator) {
		List<PostionRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last postion registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching postion registration
	 * @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration findByUuid_Last(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (postionRegistration != null) {
			return postionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPostionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last postion registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching postion registration, or <code>null</code> if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<PostionRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PostionRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the postion registrations before and after the current postion registration in the ordered set where uuid = &#63;.
	 *
	 * @param POSITION_ID the primary key of the current postion registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next postion registration
	 * @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration[] findByUuid_PrevAndNext(long POSITION_ID,
		String uuid, OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = findByPrimaryKey(POSITION_ID);

		Session session = null;

		try {
			session = openSession();

			PostionRegistration[] array = new PostionRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, postionRegistration,
					uuid, orderByComparator, true);

			array[1] = postionRegistration;

			array[2] = getByUuid_PrevAndNext(session, postionRegistration,
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

	protected PostionRegistration getByUuid_PrevAndNext(Session session,
		PostionRegistration postionRegistration, String uuid,
		OrderByComparator<PostionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_POSTIONREGISTRATION_WHERE);

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
			query.append(PostionRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(postionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PostionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the postion registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PostionRegistration postionRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(postionRegistration);
		}
	}

	/**
	 * Returns the number of postion registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching postion registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "postionRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "postionRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(postionRegistration.uuid IS NULL OR postionRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_POSITION_ID = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPOSITION_ID", new String[] { Long.class.getName() },
			PostionRegistrationModelImpl.POSITION_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITION_ID = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPOSITION_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the postion registration where POSITION_ID = &#63; or throws a {@link NoSuchPostionRegistrationException} if it could not be found.
	 *
	 * @param POSITION_ID the position_id
	 * @return the matching postion registration
	 * @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration findByPOSITION_ID(long POSITION_ID)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = fetchByPOSITION_ID(POSITION_ID);

		if (postionRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("POSITION_ID=");
			msg.append(POSITION_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPostionRegistrationException(msg.toString());
		}

		return postionRegistration;
	}

	/**
	 * Returns the postion registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param POSITION_ID the position_id
	 * @return the matching postion registration, or <code>null</code> if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration fetchByPOSITION_ID(long POSITION_ID) {
		return fetchByPOSITION_ID(POSITION_ID, true);
	}

	/**
	 * Returns the postion registration where POSITION_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param POSITION_ID the position_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching postion registration, or <code>null</code> if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration fetchByPOSITION_ID(long POSITION_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { POSITION_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_POSITION_ID,
					finderArgs, this);
		}

		if (result instanceof PostionRegistration) {
			PostionRegistration postionRegistration = (PostionRegistration)result;

			if ((POSITION_ID != postionRegistration.getPOSITION_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_POSTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_POSITION_ID_POSITION_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(POSITION_ID);

				List<PostionRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"PostionRegistrationPersistenceImpl.fetchByPOSITION_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PostionRegistration postionRegistration = list.get(0);

					result = postionRegistration;

					cacheResult(postionRegistration);
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
			return (PostionRegistration)result;
		}
	}

	/**
	 * Removes the postion registration where POSITION_ID = &#63; from the database.
	 *
	 * @param POSITION_ID the position_id
	 * @return the postion registration that was removed
	 */
	@Override
	public PostionRegistration removeByPOSITION_ID(long POSITION_ID)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = findByPOSITION_ID(POSITION_ID);

		return remove(postionRegistration);
	}

	/**
	 * Returns the number of postion registrations where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @return the number of matching postion registrations
	 */
	@Override
	public int countByPOSITION_ID(long POSITION_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITION_ID;

		Object[] finderArgs = new Object[] { POSITION_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_POSITION_ID_POSITION_ID_2 = "postionRegistration.POSITION_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			PostionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			PostionRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the postion registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching postion registrations
	 */
	@Override
	public List<PostionRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PostionRegistration> findBySTATUS(int STATUS, int start, int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

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
	@Override
	public List<PostionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

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
	@Override
	public List<PostionRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<PostionRegistration> orderByComparator,
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

		List<PostionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<PostionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PostionRegistration postionRegistration : list) {
					if ((STATUS != postionRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_POSTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PostionRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<PostionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PostionRegistration>)QueryUtil.list(q,
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
	 * Returns the first postion registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching postion registration
	 * @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (postionRegistration != null) {
			return postionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchPostionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first postion registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching postion registration, or <code>null</code> if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator) {
		List<PostionRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last postion registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching postion registration
	 * @throws NoSuchPostionRegistrationException if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (postionRegistration != null) {
			return postionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchPostionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last postion registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching postion registration, or <code>null</code> if a matching postion registration could not be found
	 */
	@Override
	public PostionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<PostionRegistration> list = findBySTATUS(STATUS, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the postion registrations before and after the current postion registration in the ordered set where STATUS = &#63;.
	 *
	 * @param POSITION_ID the primary key of the current postion registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next postion registration
	 * @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration[] findBySTATUS_PrevAndNext(long POSITION_ID,
		int STATUS, OrderByComparator<PostionRegistration> orderByComparator)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = findByPrimaryKey(POSITION_ID);

		Session session = null;

		try {
			session = openSession();

			PostionRegistration[] array = new PostionRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session, postionRegistration,
					STATUS, orderByComparator, true);

			array[1] = postionRegistration;

			array[2] = getBySTATUS_PrevAndNext(session, postionRegistration,
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

	protected PostionRegistration getBySTATUS_PrevAndNext(Session session,
		PostionRegistration postionRegistration, int STATUS,
		OrderByComparator<PostionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_POSTIONREGISTRATION_WHERE);

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
			query.append(PostionRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(postionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PostionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the postion registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (PostionRegistration postionRegistration : findBySTATUS(STATUS,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(postionRegistration);
		}
	}

	/**
	 * Returns the number of postion registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching postion registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_POSTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "postionRegistration.STATUS = ?";

	public PostionRegistrationPersistenceImpl() {
		setModelClass(PostionRegistration.class);

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
	 * Caches the postion registration in the entity cache if it is enabled.
	 *
	 * @param postionRegistration the postion registration
	 */
	@Override
	public void cacheResult(PostionRegistration postionRegistration) {
		entityCache.putResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationImpl.class, postionRegistration.getPrimaryKey(),
			postionRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION_ID,
			new Object[] { postionRegistration.getPOSITION_ID() },
			postionRegistration);

		postionRegistration.resetOriginalValues();
	}

	/**
	 * Caches the postion registrations in the entity cache if it is enabled.
	 *
	 * @param postionRegistrations the postion registrations
	 */
	@Override
	public void cacheResult(List<PostionRegistration> postionRegistrations) {
		for (PostionRegistration postionRegistration : postionRegistrations) {
			if (entityCache.getResult(
						PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PostionRegistrationImpl.class,
						postionRegistration.getPrimaryKey()) == null) {
				cacheResult(postionRegistration);
			}
			else {
				postionRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all postion registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PostionRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the postion registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PostionRegistration postionRegistration) {
		entityCache.removeResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationImpl.class, postionRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PostionRegistrationModelImpl)postionRegistration,
			true);
	}

	@Override
	public void clearCache(List<PostionRegistration> postionRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PostionRegistration postionRegistration : postionRegistrations) {
			entityCache.removeResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PostionRegistrationImpl.class,
				postionRegistration.getPrimaryKey());

			clearUniqueFindersCache((PostionRegistrationModelImpl)postionRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		PostionRegistrationModelImpl postionRegistrationModelImpl) {
		Object[] args = new Object[] {
				postionRegistrationModelImpl.getPOSITION_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_POSITION_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_POSITION_ID, args,
			postionRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PostionRegistrationModelImpl postionRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					postionRegistrationModelImpl.getPOSITION_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION_ID, args);
		}

		if ((postionRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_POSITION_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					postionRegistrationModelImpl.getOriginalPOSITION_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_POSITION_ID, args);
		}
	}

	/**
	 * Creates a new postion registration with the primary key. Does not add the postion registration to the database.
	 *
	 * @param POSITION_ID the primary key for the new postion registration
	 * @return the new postion registration
	 */
	@Override
	public PostionRegistration create(long POSITION_ID) {
		PostionRegistration postionRegistration = new PostionRegistrationImpl();

		postionRegistration.setNew(true);
		postionRegistration.setPrimaryKey(POSITION_ID);

		String uuid = PortalUUIDUtil.generate();

		postionRegistration.setUuid(uuid);

		return postionRegistration;
	}

	/**
	 * Removes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param POSITION_ID the primary key of the postion registration
	 * @return the postion registration that was removed
	 * @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration remove(long POSITION_ID)
		throws NoSuchPostionRegistrationException {
		return remove((Serializable)POSITION_ID);
	}

	/**
	 * Removes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the postion registration
	 * @return the postion registration that was removed
	 * @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration remove(Serializable primaryKey)
		throws NoSuchPostionRegistrationException {
		Session session = null;

		try {
			session = openSession();

			PostionRegistration postionRegistration = (PostionRegistration)session.get(PostionRegistrationImpl.class,
					primaryKey);

			if (postionRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPostionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(postionRegistration);
		}
		catch (NoSuchPostionRegistrationException nsee) {
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
	protected PostionRegistration removeImpl(
		PostionRegistration postionRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(postionRegistration)) {
				postionRegistration = (PostionRegistration)session.get(PostionRegistrationImpl.class,
						postionRegistration.getPrimaryKeyObj());
			}

			if (postionRegistration != null) {
				session.delete(postionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (postionRegistration != null) {
			clearCache(postionRegistration);
		}

		return postionRegistration;
	}

	@Override
	public PostionRegistration updateImpl(
		PostionRegistration postionRegistration) {
		boolean isNew = postionRegistration.isNew();

		if (!(postionRegistration instanceof PostionRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(postionRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(postionRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in postionRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PostionRegistration implementation " +
				postionRegistration.getClass());
		}

		PostionRegistrationModelImpl postionRegistrationModelImpl = (PostionRegistrationModelImpl)postionRegistration;

		if (Validator.isNull(postionRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			postionRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (postionRegistration.isNew()) {
				session.save(postionRegistration);

				postionRegistration.setNew(false);
			}
			else {
				postionRegistration = (PostionRegistration)session.merge(postionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!PostionRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { postionRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { postionRegistrationModelImpl.getSTATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((postionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						postionRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { postionRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((postionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						postionRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { postionRegistrationModelImpl.getSTATUS() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			PostionRegistrationImpl.class, postionRegistration.getPrimaryKey(),
			postionRegistration, false);

		clearUniqueFindersCache(postionRegistrationModelImpl, false);
		cacheUniqueFindersCache(postionRegistrationModelImpl);

		postionRegistration.resetOriginalValues();

		return postionRegistration;
	}

	/**
	 * Returns the postion registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the postion registration
	 * @return the postion registration
	 * @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPostionRegistrationException {
		PostionRegistration postionRegistration = fetchByPrimaryKey(primaryKey);

		if (postionRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPostionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return postionRegistration;
	}

	/**
	 * Returns the postion registration with the primary key or throws a {@link NoSuchPostionRegistrationException} if it could not be found.
	 *
	 * @param POSITION_ID the primary key of the postion registration
	 * @return the postion registration
	 * @throws NoSuchPostionRegistrationException if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration findByPrimaryKey(long POSITION_ID)
		throws NoSuchPostionRegistrationException {
		return findByPrimaryKey((Serializable)POSITION_ID);
	}

	/**
	 * Returns the postion registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the postion registration
	 * @return the postion registration, or <code>null</code> if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				PostionRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		PostionRegistration postionRegistration = (PostionRegistration)serializable;

		if (postionRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				postionRegistration = (PostionRegistration)session.get(PostionRegistrationImpl.class,
						primaryKey);

				if (postionRegistration != null) {
					cacheResult(postionRegistration);
				}
				else {
					entityCache.putResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						PostionRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PostionRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return postionRegistration;
	}

	/**
	 * Returns the postion registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param POSITION_ID the primary key of the postion registration
	 * @return the postion registration, or <code>null</code> if a postion registration with the primary key could not be found
	 */
	@Override
	public PostionRegistration fetchByPrimaryKey(long POSITION_ID) {
		return fetchByPrimaryKey((Serializable)POSITION_ID);
	}

	@Override
	public Map<Serializable, PostionRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, PostionRegistration> map = new HashMap<Serializable, PostionRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			PostionRegistration postionRegistration = fetchByPrimaryKey(primaryKey);

			if (postionRegistration != null) {
				map.put(primaryKey, postionRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PostionRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (PostionRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_POSTIONREGISTRATION_WHERE_PKS_IN);

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

			for (PostionRegistration postionRegistration : (List<PostionRegistration>)q.list()) {
				map.put(postionRegistration.getPrimaryKeyObj(),
					postionRegistration);

				cacheResult(postionRegistration);

				uncachedPrimaryKeys.remove(postionRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PostionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					PostionRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the postion registrations.
	 *
	 * @return the postion registrations
	 */
	@Override
	public List<PostionRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<PostionRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<PostionRegistration> findAll(int start, int end,
		OrderByComparator<PostionRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<PostionRegistration> findAll(int start, int end,
		OrderByComparator<PostionRegistration> orderByComparator,
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

		List<PostionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<PostionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_POSTIONREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_POSTIONREGISTRATION;

				if (pagination) {
					sql = sql.concat(PostionRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PostionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PostionRegistration>)QueryUtil.list(q,
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
	 * Removes all the postion registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PostionRegistration postionRegistration : findAll()) {
			remove(postionRegistration);
		}
	}

	/**
	 * Returns the number of postion registrations.
	 *
	 * @return the number of postion registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_POSTIONREGISTRATION);

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
		return PostionRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the postion registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PostionRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_POSTIONREGISTRATION = "SELECT postionRegistration FROM PostionRegistration postionRegistration";
	private static final String _SQL_SELECT_POSTIONREGISTRATION_WHERE_PKS_IN = "SELECT postionRegistration FROM PostionRegistration postionRegistration WHERE POSITION_ID IN (";
	private static final String _SQL_SELECT_POSTIONREGISTRATION_WHERE = "SELECT postionRegistration FROM PostionRegistration postionRegistration WHERE ";
	private static final String _SQL_COUNT_POSTIONREGISTRATION = "SELECT COUNT(postionRegistration) FROM PostionRegistration postionRegistration";
	private static final String _SQL_COUNT_POSTIONREGISTRATION_WHERE = "SELECT COUNT(postionRegistration) FROM PostionRegistration postionRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "postionRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PostionRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PostionRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PostionRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}