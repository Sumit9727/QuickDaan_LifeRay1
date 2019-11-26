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

import com.crowd.funding.database.exception.NoSuchCandidateRegistrationException;
import com.crowd.funding.database.model.CandidateRegistration;
import com.crowd.funding.database.model.impl.CandidateRegistrationImpl;
import com.crowd.funding.database.model.impl.CandidateRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.CandidateRegistrationPersistence;

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
 * The persistence implementation for the candidate registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.CandidateRegistrationUtil
 * @generated
 */
@ProviderType
public class CandidateRegistrationPersistenceImpl extends BasePersistenceImpl<CandidateRegistration>
	implements CandidateRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateRegistrationUtil} to access the candidate registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CandidateRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the candidate registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @return the range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CandidateRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CandidateRegistration> orderByComparator,
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

		List<CandidateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateRegistration candidateRegistration : list) {
					if (!Objects.equals(uuid, candidateRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

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
				query.append(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<CandidateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
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
	 * Returns the first candidate registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findByUuid_First(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (candidateRegistration != null) {
			return candidateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCandidateRegistrationException(msg.toString());
	}

	/**
	 * Returns the first candidate registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchByUuid_First(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		List<CandidateRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findByUuid_Last(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (candidateRegistration != null) {
			return candidateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCandidateRegistrationException(msg.toString());
	}

	/**
	 * Returns the last candidate registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CandidateRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate registrations before and after the current candidate registration in the ordered set where uuid = &#63;.
	 *
	 * @param CANDIDATE_ID the primary key of the current candidate registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate registration
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration[] findByUuid_PrevAndNext(long CANDIDATE_ID,
		String uuid, OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = findByPrimaryKey(CANDIDATE_ID);

		Session session = null;

		try {
			session = openSession();

			CandidateRegistration[] array = new CandidateRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, candidateRegistration,
					uuid, orderByComparator, true);

			array[1] = candidateRegistration;

			array[2] = getByUuid_PrevAndNext(session, candidateRegistration,
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

	protected CandidateRegistration getByUuid_PrevAndNext(Session session,
		CandidateRegistration candidateRegistration, String uuid,
		OrderByComparator<CandidateRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

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
			query.append(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(candidateRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CandidateRegistration candidateRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateRegistration);
		}
	}

	/**
	 * Returns the number of candidate registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "candidateRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "candidateRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(candidateRegistration.uuid IS NULL OR candidateRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CANDIDATE_ID = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCANDIDATE_ID", new String[] { Long.class.getName() },
			CandidateRegistrationModelImpl.CANDIDATE_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATE_ID = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCANDIDATE_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the candidate registration where CANDIDATE_ID = &#63; or throws a {@link NoSuchCandidateRegistrationException} if it could not be found.
	 *
	 * @param CANDIDATE_ID the candidate_id
	 * @return the matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findByCANDIDATE_ID(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchByCANDIDATE_ID(CANDIDATE_ID);

		if (candidateRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("CANDIDATE_ID=");
			msg.append(CANDIDATE_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCandidateRegistrationException(msg.toString());
		}

		return candidateRegistration;
	}

	/**
	 * Returns the candidate registration where CANDIDATE_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param CANDIDATE_ID the candidate_id
	 * @return the matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchByCANDIDATE_ID(long CANDIDATE_ID) {
		return fetchByCANDIDATE_ID(CANDIDATE_ID, true);
	}

	/**
	 * Returns the candidate registration where CANDIDATE_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param CANDIDATE_ID the candidate_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchByCANDIDATE_ID(long CANDIDATE_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { CANDIDATE_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID,
					finderArgs, this);
		}

		if (result instanceof CandidateRegistration) {
			CandidateRegistration candidateRegistration = (CandidateRegistration)result;

			if ((CANDIDATE_ID != candidateRegistration.getCANDIDATE_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATE_ID_CANDIDATE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CANDIDATE_ID);

				List<CandidateRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"CandidateRegistrationPersistenceImpl.fetchByCANDIDATE_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CandidateRegistration candidateRegistration = list.get(0);

					result = candidateRegistration;

					cacheResult(candidateRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID,
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
			return (CandidateRegistration)result;
		}
	}

	/**
	 * Removes the candidate registration where CANDIDATE_ID = &#63; from the database.
	 *
	 * @param CANDIDATE_ID the candidate_id
	 * @return the candidate registration that was removed
	 */
	@Override
	public CandidateRegistration removeByCANDIDATE_ID(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = findByCANDIDATE_ID(CANDIDATE_ID);

		return remove(candidateRegistration);
	}

	/**
	 * Returns the number of candidate registrations where CANDIDATE_ID = &#63;.
	 *
	 * @param CANDIDATE_ID the candidate_id
	 * @return the number of matching candidate registrations
	 */
	@Override
	public int countByCANDIDATE_ID(long CANDIDATE_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATE_ID;

		Object[] finderArgs = new Object[] { CANDIDATE_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATE_ID_CANDIDATE_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CANDIDATE_ID);

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

	private static final String _FINDER_COLUMN_CANDIDATE_ID_CANDIDATE_ID_2 = "candidateRegistration.CANDIDATE_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITION_ID =
		new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPOSITION_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITION_ID =
		new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPOSITION_ID",
			new String[] { Long.class.getName() },
			CandidateRegistrationModelImpl.POSITION_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POSITION_ID = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPOSITION_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the candidate registrations where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @return the matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByPOSITION_ID(long POSITION_ID) {
		return findByPOSITION_ID(POSITION_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate registrations where POSITION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param POSITION_ID the position_id
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @return the range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByPOSITION_ID(long POSITION_ID,
		int start, int end) {
		return findByPOSITION_ID(POSITION_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate registrations where POSITION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param POSITION_ID the position_id
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByPOSITION_ID(long POSITION_ID,
		int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return findByPOSITION_ID(POSITION_ID, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the candidate registrations where POSITION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param POSITION_ID the position_id
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findByPOSITION_ID(long POSITION_ID,
		int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITION_ID;
			finderArgs = new Object[] { POSITION_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POSITION_ID;
			finderArgs = new Object[] { POSITION_ID, start, end, orderByComparator };
		}

		List<CandidateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateRegistration candidateRegistration : list) {
					if ((POSITION_ID != candidateRegistration.getPOSITION_ID())) {
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

			query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_POSITION_ID_POSITION_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(POSITION_ID);

				if (!pagination) {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
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
	 * Returns the first candidate registration in the ordered set where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findByPOSITION_ID_First(long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchByPOSITION_ID_First(POSITION_ID,
				orderByComparator);

		if (candidateRegistration != null) {
			return candidateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("POSITION_ID=");
		msg.append(POSITION_ID);

		msg.append("}");

		throw new NoSuchCandidateRegistrationException(msg.toString());
	}

	/**
	 * Returns the first candidate registration in the ordered set where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchByPOSITION_ID_First(long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		List<CandidateRegistration> list = findByPOSITION_ID(POSITION_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate registration in the ordered set where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findByPOSITION_ID_Last(long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchByPOSITION_ID_Last(POSITION_ID,
				orderByComparator);

		if (candidateRegistration != null) {
			return candidateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("POSITION_ID=");
		msg.append(POSITION_ID);

		msg.append("}");

		throw new NoSuchCandidateRegistrationException(msg.toString());
	}

	/**
	 * Returns the last candidate registration in the ordered set where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchByPOSITION_ID_Last(long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		int count = countByPOSITION_ID(POSITION_ID);

		if (count == 0) {
			return null;
		}

		List<CandidateRegistration> list = findByPOSITION_ID(POSITION_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate registrations before and after the current candidate registration in the ordered set where POSITION_ID = &#63;.
	 *
	 * @param CANDIDATE_ID the primary key of the current candidate registration
	 * @param POSITION_ID the position_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate registration
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration[] findByPOSITION_ID_PrevAndNext(
		long CANDIDATE_ID, long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = findByPrimaryKey(CANDIDATE_ID);

		Session session = null;

		try {
			session = openSession();

			CandidateRegistration[] array = new CandidateRegistrationImpl[3];

			array[0] = getByPOSITION_ID_PrevAndNext(session,
					candidateRegistration, POSITION_ID, orderByComparator, true);

			array[1] = candidateRegistration;

			array[2] = getByPOSITION_ID_PrevAndNext(session,
					candidateRegistration, POSITION_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateRegistration getByPOSITION_ID_PrevAndNext(
		Session session, CandidateRegistration candidateRegistration,
		long POSITION_ID,
		OrderByComparator<CandidateRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_POSITION_ID_POSITION_ID_2);

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
			query.append(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(POSITION_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate registrations where POSITION_ID = &#63; from the database.
	 *
	 * @param POSITION_ID the position_id
	 */
	@Override
	public void removeByPOSITION_ID(long POSITION_ID) {
		for (CandidateRegistration candidateRegistration : findByPOSITION_ID(
				POSITION_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateRegistration);
		}
	}

	/**
	 * Returns the number of candidate registrations where POSITION_ID = &#63;.
	 *
	 * @param POSITION_ID the position_id
	 * @return the number of matching candidate registrations
	 */
	@Override
	public int countByPOSITION_ID(long POSITION_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POSITION_ID;

		Object[] finderArgs = new Object[] { POSITION_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_POSITION_ID_POSITION_ID_2 = "candidateRegistration.POSITION_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			CandidateRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the candidate registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @return the range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findBySTATUS(int STATUS, int start,
		int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<CandidateRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<CandidateRegistration> orderByComparator,
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

		List<CandidateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateRegistration candidateRegistration : list) {
					if ((STATUS != candidateRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
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
	 * Returns the first candidate registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (candidateRegistration != null) {
			return candidateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchCandidateRegistrationException(msg.toString());
	}

	/**
	 * Returns the first candidate registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		List<CandidateRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate registration
	 * @throws NoSuchCandidateRegistrationException if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (candidateRegistration != null) {
			return candidateRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchCandidateRegistrationException(msg.toString());
	}

	/**
	 * Returns the last candidate registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate registration, or <code>null</code> if a matching candidate registration could not be found
	 */
	@Override
	public CandidateRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<CandidateRegistration> list = findBySTATUS(STATUS, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate registrations before and after the current candidate registration in the ordered set where STATUS = &#63;.
	 *
	 * @param CANDIDATE_ID the primary key of the current candidate registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate registration
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration[] findBySTATUS_PrevAndNext(long CANDIDATE_ID,
		int STATUS, OrderByComparator<CandidateRegistration> orderByComparator)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = findByPrimaryKey(CANDIDATE_ID);

		Session session = null;

		try {
			session = openSession();

			CandidateRegistration[] array = new CandidateRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session, candidateRegistration,
					STATUS, orderByComparator, true);

			array[1] = candidateRegistration;

			array[2] = getBySTATUS_PrevAndNext(session, candidateRegistration,
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

	protected CandidateRegistration getBySTATUS_PrevAndNext(Session session,
		CandidateRegistration candidateRegistration, int STATUS,
		OrderByComparator<CandidateRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE);

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
			query.append(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (CandidateRegistration candidateRegistration : findBySTATUS(
				STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateRegistration);
		}
	}

	/**
	 * Returns the number of candidate registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching candidate registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "candidateRegistration.STATUS = ?";

	public CandidateRegistrationPersistenceImpl() {
		setModelClass(CandidateRegistration.class);

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
	 * Caches the candidate registration in the entity cache if it is enabled.
	 *
	 * @param candidateRegistration the candidate registration
	 */
	@Override
	public void cacheResult(CandidateRegistration candidateRegistration) {
		entityCache.putResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			candidateRegistration.getPrimaryKey(), candidateRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID,
			new Object[] { candidateRegistration.getCANDIDATE_ID() },
			candidateRegistration);

		candidateRegistration.resetOriginalValues();
	}

	/**
	 * Caches the candidate registrations in the entity cache if it is enabled.
	 *
	 * @param candidateRegistrations the candidate registrations
	 */
	@Override
	public void cacheResult(List<CandidateRegistration> candidateRegistrations) {
		for (CandidateRegistration candidateRegistration : candidateRegistrations) {
			if (entityCache.getResult(
						CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CandidateRegistrationImpl.class,
						candidateRegistration.getPrimaryKey()) == null) {
				cacheResult(candidateRegistration);
			}
			else {
				candidateRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateRegistration candidateRegistration) {
		entityCache.removeResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			candidateRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CandidateRegistrationModelImpl)candidateRegistration,
			true);
	}

	@Override
	public void clearCache(List<CandidateRegistration> candidateRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateRegistration candidateRegistration : candidateRegistrations) {
			entityCache.removeResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CandidateRegistrationImpl.class,
				candidateRegistration.getPrimaryKey());

			clearUniqueFindersCache((CandidateRegistrationModelImpl)candidateRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		CandidateRegistrationModelImpl candidateRegistrationModelImpl) {
		Object[] args = new Object[] {
				candidateRegistrationModelImpl.getCANDIDATE_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_CANDIDATE_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID, args,
			candidateRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		CandidateRegistrationModelImpl candidateRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					candidateRegistrationModelImpl.getCANDIDATE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID, args);
		}

		if ((candidateRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CANDIDATE_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					candidateRegistrationModelImpl.getOriginalCANDIDATE_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CANDIDATE_ID, args);
		}
	}

	/**
	 * Creates a new candidate registration with the primary key. Does not add the candidate registration to the database.
	 *
	 * @param CANDIDATE_ID the primary key for the new candidate registration
	 * @return the new candidate registration
	 */
	@Override
	public CandidateRegistration create(long CANDIDATE_ID) {
		CandidateRegistration candidateRegistration = new CandidateRegistrationImpl();

		candidateRegistration.setNew(true);
		candidateRegistration.setPrimaryKey(CANDIDATE_ID);

		String uuid = PortalUUIDUtil.generate();

		candidateRegistration.setUuid(uuid);

		return candidateRegistration;
	}

	/**
	 * Removes the candidate registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CANDIDATE_ID the primary key of the candidate registration
	 * @return the candidate registration that was removed
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration remove(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException {
		return remove((Serializable)CANDIDATE_ID);
	}

	/**
	 * Removes the candidate registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate registration
	 * @return the candidate registration that was removed
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration remove(Serializable primaryKey)
		throws NoSuchCandidateRegistrationException {
		Session session = null;

		try {
			session = openSession();

			CandidateRegistration candidateRegistration = (CandidateRegistration)session.get(CandidateRegistrationImpl.class,
					primaryKey);

			if (candidateRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateRegistration);
		}
		catch (NoSuchCandidateRegistrationException nsee) {
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
	protected CandidateRegistration removeImpl(
		CandidateRegistration candidateRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateRegistration)) {
				candidateRegistration = (CandidateRegistration)session.get(CandidateRegistrationImpl.class,
						candidateRegistration.getPrimaryKeyObj());
			}

			if (candidateRegistration != null) {
				session.delete(candidateRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateRegistration != null) {
			clearCache(candidateRegistration);
		}

		return candidateRegistration;
	}

	@Override
	public CandidateRegistration updateImpl(
		CandidateRegistration candidateRegistration) {
		boolean isNew = candidateRegistration.isNew();

		if (!(candidateRegistration instanceof CandidateRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(candidateRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(candidateRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in candidateRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CandidateRegistration implementation " +
				candidateRegistration.getClass());
		}

		CandidateRegistrationModelImpl candidateRegistrationModelImpl = (CandidateRegistrationModelImpl)candidateRegistration;

		if (Validator.isNull(candidateRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			candidateRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (candidateRegistration.isNew()) {
				session.save(candidateRegistration);

				candidateRegistration.setNew(false);
			}
			else {
				session.evict(candidateRegistration);
				session.saveOrUpdate(candidateRegistration);
			}

			session.flush();
			session.clear();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CandidateRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					candidateRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { candidateRegistrationModelImpl.getPOSITION_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITION_ID,
				args);

			args = new Object[] { candidateRegistrationModelImpl.getSTATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((candidateRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { candidateRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((candidateRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITION_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateRegistrationModelImpl.getOriginalPOSITION_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITION_ID,
					args);

				args = new Object[] {
						candidateRegistrationModelImpl.getPOSITION_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_POSITION_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POSITION_ID,
					args);
			}

			if ((candidateRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { candidateRegistrationModelImpl.getSTATUS() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateRegistrationImpl.class,
			candidateRegistration.getPrimaryKey(), candidateRegistration, false);

		clearUniqueFindersCache(candidateRegistrationModelImpl, false);
		cacheUniqueFindersCache(candidateRegistrationModelImpl);

		candidateRegistration.resetOriginalValues();

		return candidateRegistration;
	}

	/**
	 * Returns the candidate registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate registration
	 * @return the candidate registration
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateRegistrationException {
		CandidateRegistration candidateRegistration = fetchByPrimaryKey(primaryKey);

		if (candidateRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateRegistration;
	}

	/**
	 * Returns the candidate registration with the primary key or throws a {@link NoSuchCandidateRegistrationException} if it could not be found.
	 *
	 * @param CANDIDATE_ID the primary key of the candidate registration
	 * @return the candidate registration
	 * @throws NoSuchCandidateRegistrationException if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration findByPrimaryKey(long CANDIDATE_ID)
		throws NoSuchCandidateRegistrationException {
		return findByPrimaryKey((Serializable)CANDIDATE_ID);
	}

	/**
	 * Returns the candidate registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate registration
	 * @return the candidate registration, or <code>null</code> if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CandidateRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CandidateRegistration candidateRegistration = (CandidateRegistration)serializable;

		if (candidateRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				candidateRegistration = (CandidateRegistration)session.get(CandidateRegistrationImpl.class,
						primaryKey);

				if (candidateRegistration != null) {
					cacheResult(candidateRegistration);
				}
				else {
					entityCache.putResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CandidateRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateRegistration;
	}

	/**
	 * Returns the candidate registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CANDIDATE_ID the primary key of the candidate registration
	 * @return the candidate registration, or <code>null</code> if a candidate registration with the primary key could not be found
	 */
	@Override
	public CandidateRegistration fetchByPrimaryKey(long CANDIDATE_ID) {
		return fetchByPrimaryKey((Serializable)CANDIDATE_ID);
	}

	@Override
	public Map<Serializable, CandidateRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CandidateRegistration> map = new HashMap<Serializable, CandidateRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CandidateRegistration candidateRegistration = fetchByPrimaryKey(primaryKey);

			if (candidateRegistration != null) {
				map.put(primaryKey, candidateRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CandidateRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CANDIDATEREGISTRATION_WHERE_PKS_IN);

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

			for (CandidateRegistration candidateRegistration : (List<CandidateRegistration>)q.list()) {
				map.put(candidateRegistration.getPrimaryKeyObj(),
					candidateRegistration);

				cacheResult(candidateRegistration);

				uncachedPrimaryKeys.remove(candidateRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CandidateRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the candidate registrations.
	 *
	 * @return the candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @return the range of candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findAll(int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CandidateRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate registrations
	 * @param end the upper bound of the range of candidate registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of candidate registrations
	 */
	@Override
	public List<CandidateRegistration> findAll(int start, int end,
		OrderByComparator<CandidateRegistration> orderByComparator,
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

		List<CandidateRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CandidateRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CANDIDATEREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEREGISTRATION;

				if (pagination) {
					sql = sql.concat(CandidateRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CandidateRegistration>)QueryUtil.list(q,
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
	 * Removes all the candidate registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateRegistration candidateRegistration : findAll()) {
			remove(candidateRegistration);
		}
	}

	/**
	 * Returns the number of candidate registrations.
	 *
	 * @return the number of candidate registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEREGISTRATION);

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
		return CandidateRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CandidateRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CANDIDATEREGISTRATION = "SELECT candidateRegistration FROM CandidateRegistration candidateRegistration";
	private static final String _SQL_SELECT_CANDIDATEREGISTRATION_WHERE_PKS_IN = "SELECT candidateRegistration FROM CandidateRegistration candidateRegistration WHERE CANDIDATE_ID IN (";
	private static final String _SQL_SELECT_CANDIDATEREGISTRATION_WHERE = "SELECT candidateRegistration FROM CandidateRegistration candidateRegistration WHERE ";
	private static final String _SQL_COUNT_CANDIDATEREGISTRATION = "SELECT COUNT(candidateRegistration) FROM CandidateRegistration candidateRegistration";
	private static final String _SQL_COUNT_CANDIDATEREGISTRATION_WHERE = "SELECT COUNT(candidateRegistration) FROM CandidateRegistration candidateRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CandidateRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CandidateRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}