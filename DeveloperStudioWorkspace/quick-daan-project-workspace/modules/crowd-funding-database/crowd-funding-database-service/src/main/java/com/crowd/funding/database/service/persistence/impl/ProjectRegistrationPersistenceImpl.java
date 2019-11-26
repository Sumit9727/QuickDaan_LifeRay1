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

import com.crowd.funding.database.exception.NoSuchProjectRegistrationException;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.impl.ProjectRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectRegistrationPersistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
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

import java.sql.Timestamp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the project registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectRegistrationPersistenceImpl extends BasePersistenceImpl<ProjectRegistration>
	implements ProjectRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectRegistrationUtil} to access the project registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the project registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
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

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if (!Objects.equals(uuid, projectRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

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
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByUuid_PrevAndNext(long PROJECT_ID,
		String uuid, OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, projectRegistration,
					uuid, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByUuid_PrevAndNext(session, projectRegistration,
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

	protected ProjectRegistration getByUuid_PrevAndNext(Session session,
		ProjectRegistration projectRegistration, String uuid,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectRegistration projectRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectRegistration.uuid IS NULL OR projectRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_ID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_ID", new String[] { Long.class.getName() },
			ProjectRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns the project registration where PROJECT_ID = &#63; or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByPROJECT_ID(PROJECT_ID);

		if (projectRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_ID=");
			msg.append(PROJECT_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectRegistrationException(msg.toString());
		}

		return projectRegistration;
	}

	/**
	 * Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID) {
		return fetchByPROJECT_ID(PROJECT_ID, true);
	}

	/**
	 * Returns the project registration where PROJECT_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_ID the project_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByPROJECT_ID(long PROJECT_ID,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectRegistration) {
			ProjectRegistration projectRegistration = (ProjectRegistration)result;

			if ((PROJECT_ID != projectRegistration.getPROJECT_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				List<ProjectRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectRegistrationPersistenceImpl.fetchByPROJECT_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectRegistration projectRegistration = list.get(0);

					result = projectRegistration;

					cacheResult(projectRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
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
			return (ProjectRegistration)result;
		}
	}

	/**
	 * Removes the project registration where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the project registration that was removed
	 */
	@Override
	public ProjectRegistration removeByPROJECT_ID(long PROJECT_ID)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPROJECT_ID(PROJECT_ID);

		return remove(projectRegistration);
	}

	/**
	 * Returns the number of project registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectRegistration.PROJECT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BENIFICIARY_ID =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBENIFICIARY_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBENIFICIARY_ID",
			new String[] { Long.class.getName() },
			ProjectRegistrationModelImpl.BENIFICIARY_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BENIFICIARY_ID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBENIFICIARY_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project registrations where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID(long BENIFICIARY_ID) {
		return findByBENIFICIARY_ID(BENIFICIARY_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where BENIFICIARY_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID(long BENIFICIARY_ID,
		int start, int end) {
		return findByBENIFICIARY_ID(BENIFICIARY_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID(long BENIFICIARY_ID,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByBENIFICIARY_ID(BENIFICIARY_ID, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID(long BENIFICIARY_ID,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID;
			finderArgs = new Object[] { BENIFICIARY_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BENIFICIARY_ID;
			finderArgs = new Object[] {
					BENIFICIARY_ID,
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if ((BENIFICIARY_ID != projectRegistration.getBENIFICIARY_ID())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(BENIFICIARY_ID);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByBENIFICIARY_ID_First(long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByBENIFICIARY_ID_First(BENIFICIARY_ID,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("BENIFICIARY_ID=");
		msg.append(BENIFICIARY_ID);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByBENIFICIARY_ID_First(
		long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByBENIFICIARY_ID(BENIFICIARY_ID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByBENIFICIARY_ID_Last(long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByBENIFICIARY_ID_Last(BENIFICIARY_ID,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("BENIFICIARY_ID=");
		msg.append(BENIFICIARY_ID);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByBENIFICIARY_ID_Last(long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByBENIFICIARY_ID(BENIFICIARY_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByBENIFICIARY_ID(BENIFICIARY_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where BENIFICIARY_ID = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByBENIFICIARY_ID_PrevAndNext(
		long PROJECT_ID, long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByBENIFICIARY_ID_PrevAndNext(session,
					projectRegistration, BENIFICIARY_ID, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByBENIFICIARY_ID_PrevAndNext(session,
					projectRegistration, BENIFICIARY_ID, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByBENIFICIARY_ID_PrevAndNext(
		Session session, ProjectRegistration projectRegistration,
		long BENIFICIARY_ID,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(BENIFICIARY_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where BENIFICIARY_ID = &#63; from the database.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 */
	@Override
	public void removeByBENIFICIARY_ID(long BENIFICIARY_ID) {
		for (ProjectRegistration projectRegistration : findByBENIFICIARY_ID(
				BENIFICIARY_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where BENIFICIARY_ID = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByBENIFICIARY_ID(long BENIFICIARY_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BENIFICIARY_ID;

		Object[] finderArgs = new Object[] { BENIFICIARY_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(BENIFICIARY_ID);

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

	private static final String _FINDER_COLUMN_BENIFICIARY_ID_BENIFICIARY_ID_2 = "projectRegistration.BENIFICIARY_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER_ID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUSER_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUSER_ID",
			new String[] { Long.class.getName() },
			ProjectRegistrationModelImpl.USER_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_ID = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUSER_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUSER_ID(long USER_ID) {
		return findByUSER_ID(USER_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUSER_ID(long USER_ID, int start,
		int end) {
		return findByUSER_ID(USER_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUSER_ID(long USER_ID, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByUSER_ID(USER_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where USER_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param USER_ID the user_id
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByUSER_ID(long USER_ID, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
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

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if ((USER_ID != projectRegistration.getUSER_ID())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USER_ID_USER_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(USER_ID);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByUSER_ID_First(USER_ID,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByUSER_ID_First(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByUSER_ID(USER_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByUSER_ID_Last(USER_ID,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("USER_ID=");
		msg.append(USER_ID);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByUSER_ID_Last(long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByUSER_ID(USER_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByUSER_ID(USER_ID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where USER_ID = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param USER_ID the user_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByUSER_ID_PrevAndNext(long PROJECT_ID,
		long USER_ID, OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByUSER_ID_PrevAndNext(session, projectRegistration,
					USER_ID, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByUSER_ID_PrevAndNext(session, projectRegistration,
					USER_ID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByUSER_ID_PrevAndNext(Session session,
		ProjectRegistration projectRegistration, long USER_ID,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(USER_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where USER_ID = &#63; from the database.
	 *
	 * @param USER_ID the user_id
	 */
	@Override
	public void removeByUSER_ID(long USER_ID) {
		for (ProjectRegistration projectRegistration : findByUSER_ID(USER_ID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where USER_ID = &#63;.
	 *
	 * @param USER_ID the user_id
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByUSER_ID(long USER_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER_ID;

		Object[] finderArgs = new Object[] { USER_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_USER_ID_USER_ID_2 = "projectRegistration.USER_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			ProjectRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySTATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the project registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findBySTATUS(int STATUS, int start, int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findBySTATUS(int STATUS, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
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

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if ((STATUS != projectRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findBySTATUS(STATUS, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where STATUS = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findBySTATUS_PrevAndNext(long PROJECT_ID,
		int STATUS, OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session, projectRegistration,
					STATUS, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getBySTATUS_PrevAndNext(session, projectRegistration,
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

	protected ProjectRegistration getBySTATUS_PrevAndNext(Session session,
		ProjectRegistration projectRegistration, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (ProjectRegistration projectRegistration : findBySTATUS(STATUS,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching project registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "projectRegistration.STATUS = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATION_DATE =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCREATION_DATE",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATION_DATE =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCREATION_DATE",
			new String[] { Date.class.getName() },
			ProjectRegistrationModelImpl.CREATION_DATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATION_DATE = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCREATION_DATE",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the project registrations where CREATION_DATE = &#63;.
	 *
	 * @param CREATION_DATE the creation_date
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByCREATION_DATE(Date CREATION_DATE) {
		return findByCREATION_DATE(CREATION_DATE, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where CREATION_DATE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CREATION_DATE the creation_date
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByCREATION_DATE(Date CREATION_DATE,
		int start, int end) {
		return findByCREATION_DATE(CREATION_DATE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where CREATION_DATE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CREATION_DATE the creation_date
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByCREATION_DATE(Date CREATION_DATE,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByCREATION_DATE(CREATION_DATE, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where CREATION_DATE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CREATION_DATE the creation_date
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByCREATION_DATE(Date CREATION_DATE,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATION_DATE;
			finderArgs = new Object[] { _getTime(CREATION_DATE) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATION_DATE;
			finderArgs = new Object[] {
					_getTime(CREATION_DATE),
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if (!Objects.equals(CREATION_DATE,
								projectRegistration.getCREATION_DATE())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			boolean bindCREATION_DATE = false;

			if (CREATION_DATE == null) {
				query.append(_FINDER_COLUMN_CREATION_DATE_CREATION_DATE_1);
			}
			else {
				bindCREATION_DATE = true;

				query.append(_FINDER_COLUMN_CREATION_DATE_CREATION_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCREATION_DATE) {
					qPos.add(new Timestamp(CREATION_DATE.getTime()));
				}

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where CREATION_DATE = &#63;.
	 *
	 * @param CREATION_DATE the creation_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByCREATION_DATE_First(Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByCREATION_DATE_First(CREATION_DATE,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CREATION_DATE=");
		msg.append(CREATION_DATE);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where CREATION_DATE = &#63;.
	 *
	 * @param CREATION_DATE the creation_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByCREATION_DATE_First(Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByCREATION_DATE(CREATION_DATE, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where CREATION_DATE = &#63;.
	 *
	 * @param CREATION_DATE the creation_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByCREATION_DATE_Last(Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByCREATION_DATE_Last(CREATION_DATE,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CREATION_DATE=");
		msg.append(CREATION_DATE);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where CREATION_DATE = &#63;.
	 *
	 * @param CREATION_DATE the creation_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByCREATION_DATE_Last(Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByCREATION_DATE(CREATION_DATE);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByCREATION_DATE(CREATION_DATE,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where CREATION_DATE = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param CREATION_DATE the creation_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByCREATION_DATE_PrevAndNext(
		long PROJECT_ID, Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByCREATION_DATE_PrevAndNext(session,
					projectRegistration, CREATION_DATE, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByCREATION_DATE_PrevAndNext(session,
					projectRegistration, CREATION_DATE, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByCREATION_DATE_PrevAndNext(
		Session session, ProjectRegistration projectRegistration,
		Date CREATION_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

		boolean bindCREATION_DATE = false;

		if (CREATION_DATE == null) {
			query.append(_FINDER_COLUMN_CREATION_DATE_CREATION_DATE_1);
		}
		else {
			bindCREATION_DATE = true;

			query.append(_FINDER_COLUMN_CREATION_DATE_CREATION_DATE_2);
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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCREATION_DATE) {
			qPos.add(new Timestamp(CREATION_DATE.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where CREATION_DATE = &#63; from the database.
	 *
	 * @param CREATION_DATE the creation_date
	 */
	@Override
	public void removeByCREATION_DATE(Date CREATION_DATE) {
		for (ProjectRegistration projectRegistration : findByCREATION_DATE(
				CREATION_DATE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where CREATION_DATE = &#63;.
	 *
	 * @param CREATION_DATE the creation_date
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByCREATION_DATE(Date CREATION_DATE) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATION_DATE;

		Object[] finderArgs = new Object[] { _getTime(CREATION_DATE) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			boolean bindCREATION_DATE = false;

			if (CREATION_DATE == null) {
				query.append(_FINDER_COLUMN_CREATION_DATE_CREATION_DATE_1);
			}
			else {
				bindCREATION_DATE = true;

				query.append(_FINDER_COLUMN_CREATION_DATE_CREATION_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCREATION_DATE) {
					qPos.add(new Timestamp(CREATION_DATE.getTime()));
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

	private static final String _FINDER_COLUMN_CREATION_DATE_CREATION_DATE_1 = "projectRegistration.CREATION_DATE IS NULL";
	private static final String _FINDER_COLUMN_CREATION_DATE_CREATION_DATE_2 = "projectRegistration.CREATION_DATE = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_END_DATE = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEND_DATE",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_END_DATE =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEND_DATE",
			new String[] { Date.class.getName() },
			ProjectRegistrationModelImpl.END_DATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_END_DATE = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEND_DATE",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the project registrations where END_DATE = &#63;.
	 *
	 * @param END_DATE the end_date
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByEND_DATE(Date END_DATE) {
		return findByEND_DATE(END_DATE, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the project registrations where END_DATE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param END_DATE the end_date
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByEND_DATE(Date END_DATE, int start,
		int end) {
		return findByEND_DATE(END_DATE, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where END_DATE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param END_DATE the end_date
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByEND_DATE(Date END_DATE, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByEND_DATE(END_DATE, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where END_DATE = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param END_DATE the end_date
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByEND_DATE(Date END_DATE, int start,
		int end, OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_END_DATE;
			finderArgs = new Object[] { _getTime(END_DATE) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_END_DATE;
			finderArgs = new Object[] {
					_getTime(END_DATE),
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if (!Objects.equals(END_DATE,
								projectRegistration.getEND_DATE())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			boolean bindEND_DATE = false;

			if (END_DATE == null) {
				query.append(_FINDER_COLUMN_END_DATE_END_DATE_1);
			}
			else {
				bindEND_DATE = true;

				query.append(_FINDER_COLUMN_END_DATE_END_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEND_DATE) {
					qPos.add(new Timestamp(END_DATE.getTime()));
				}

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where END_DATE = &#63;.
	 *
	 * @param END_DATE the end_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByEND_DATE_First(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByEND_DATE_First(END_DATE,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("END_DATE=");
		msg.append(END_DATE);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where END_DATE = &#63;.
	 *
	 * @param END_DATE the end_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByEND_DATE_First(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByEND_DATE(END_DATE, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where END_DATE = &#63;.
	 *
	 * @param END_DATE the end_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByEND_DATE_Last(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByEND_DATE_Last(END_DATE,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("END_DATE=");
		msg.append(END_DATE);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where END_DATE = &#63;.
	 *
	 * @param END_DATE the end_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByEND_DATE_Last(Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByEND_DATE(END_DATE);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByEND_DATE(END_DATE, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where END_DATE = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param END_DATE the end_date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByEND_DATE_PrevAndNext(long PROJECT_ID,
		Date END_DATE, OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByEND_DATE_PrevAndNext(session, projectRegistration,
					END_DATE, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByEND_DATE_PrevAndNext(session, projectRegistration,
					END_DATE, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByEND_DATE_PrevAndNext(Session session,
		ProjectRegistration projectRegistration, Date END_DATE,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

		boolean bindEND_DATE = false;

		if (END_DATE == null) {
			query.append(_FINDER_COLUMN_END_DATE_END_DATE_1);
		}
		else {
			bindEND_DATE = true;

			query.append(_FINDER_COLUMN_END_DATE_END_DATE_2);
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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEND_DATE) {
			qPos.add(new Timestamp(END_DATE.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where END_DATE = &#63; from the database.
	 *
	 * @param END_DATE the end_date
	 */
	@Override
	public void removeByEND_DATE(Date END_DATE) {
		for (ProjectRegistration projectRegistration : findByEND_DATE(
				END_DATE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where END_DATE = &#63;.
	 *
	 * @param END_DATE the end_date
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByEND_DATE(Date END_DATE) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_END_DATE;

		Object[] finderArgs = new Object[] { _getTime(END_DATE) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			boolean bindEND_DATE = false;

			if (END_DATE == null) {
				query.append(_FINDER_COLUMN_END_DATE_END_DATE_1);
			}
			else {
				bindEND_DATE = true;

				query.append(_FINDER_COLUMN_END_DATE_END_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEND_DATE) {
					qPos.add(new Timestamp(END_DATE.getTime()));
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

	private static final String _FINDER_COLUMN_END_DATE_END_DATE_1 = "projectRegistration.END_DATE IS NULL";
	private static final String _FINDER_COLUMN_END_DATE_END_DATE_2 = "projectRegistration.END_DATE = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUEST_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByREQUEST_STATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUEST_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByREQUEST_STATUS",
			new String[] { Integer.class.getName() },
			ProjectRegistrationModelImpl.REQUEST_STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REQUEST_STATUS = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByREQUEST_STATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByREQUEST_STATUS(int REQUEST_STATUS) {
		return findByREQUEST_STATUS(REQUEST_STATUS, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByREQUEST_STATUS(int REQUEST_STATUS,
		int start, int end) {
		return findByREQUEST_STATUS(REQUEST_STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByREQUEST_STATUS(int REQUEST_STATUS,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByREQUEST_STATUS(REQUEST_STATUS, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByREQUEST_STATUS(int REQUEST_STATUS,
		int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUEST_STATUS;
			finderArgs = new Object[] { REQUEST_STATUS };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REQUEST_STATUS;
			finderArgs = new Object[] {
					REQUEST_STATUS,
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if ((REQUEST_STATUS != projectRegistration.getREQUEST_STATUS())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_REQUEST_STATUS_REQUEST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(REQUEST_STATUS);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByREQUEST_STATUS_First(int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByREQUEST_STATUS_First(REQUEST_STATUS,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("REQUEST_STATUS=");
		msg.append(REQUEST_STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByREQUEST_STATUS_First(int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByREQUEST_STATUS(REQUEST_STATUS,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByREQUEST_STATUS_Last(int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByREQUEST_STATUS_Last(REQUEST_STATUS,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("REQUEST_STATUS=");
		msg.append(REQUEST_STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByREQUEST_STATUS_Last(int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByREQUEST_STATUS(REQUEST_STATUS);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByREQUEST_STATUS(REQUEST_STATUS,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByREQUEST_STATUS_PrevAndNext(
		long PROJECT_ID, int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByREQUEST_STATUS_PrevAndNext(session,
					projectRegistration, REQUEST_STATUS, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByREQUEST_STATUS_PrevAndNext(session,
					projectRegistration, REQUEST_STATUS, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByREQUEST_STATUS_PrevAndNext(
		Session session, ProjectRegistration projectRegistration,
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_REQUEST_STATUS_REQUEST_STATUS_2);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(REQUEST_STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where REQUEST_STATUS = &#63; from the database.
	 *
	 * @param REQUEST_STATUS the request_status
	 */
	@Override
	public void removeByREQUEST_STATUS(int REQUEST_STATUS) {
		for (ProjectRegistration projectRegistration : findByREQUEST_STATUS(
				REQUEST_STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByREQUEST_STATUS(int REQUEST_STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REQUEST_STATUS;

		Object[] finderArgs = new Object[] { REQUEST_STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_REQUEST_STATUS_REQUEST_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(REQUEST_STATUS);

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

	private static final String _FINDER_COLUMN_REQUEST_STATUS_REQUEST_STATUS_2 = "projectRegistration.REQUEST_STATUS = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBENIFICIARY_ID_STATUS",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBENIFICIARY_ID_STATUS",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ProjectRegistrationModelImpl.BENIFICIARY_ID_COLUMN_BITMASK |
			ProjectRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BENIFICIARY_ID_STATUS = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBENIFICIARY_ID_STATUS",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS) {
		return findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS, int start, int end) {
		return findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
		long BENIFICIARY_ID, int STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS;
			finderArgs = new Object[] { BENIFICIARY_ID, STATUS };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS;
			finderArgs = new Object[] {
					BENIFICIARY_ID, STATUS,
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if ((BENIFICIARY_ID != projectRegistration.getBENIFICIARY_ID()) ||
							(STATUS != projectRegistration.getSTATUS())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_STATUS_BENIFICIARY_ID_2);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(BENIFICIARY_ID);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByBENIFICIARY_ID_STATUS_First(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByBENIFICIARY_ID_STATUS_First(BENIFICIARY_ID,
				STATUS, orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("BENIFICIARY_ID=");
		msg.append(BENIFICIARY_ID);

		msg.append(", STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByBENIFICIARY_ID_STATUS_First(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID,
				STATUS, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByBENIFICIARY_ID_STATUS_Last(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByBENIFICIARY_ID_STATUS_Last(BENIFICIARY_ID,
				STATUS, orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("BENIFICIARY_ID=");
		msg.append(BENIFICIARY_ID);

		msg.append(", STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByBENIFICIARY_ID_STATUS_Last(
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID,
				STATUS, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByBENIFICIARY_ID_STATUS_PrevAndNext(
		long PROJECT_ID, long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByBENIFICIARY_ID_STATUS_PrevAndNext(session,
					projectRegistration, BENIFICIARY_ID, STATUS,
					orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByBENIFICIARY_ID_STATUS_PrevAndNext(session,
					projectRegistration, BENIFICIARY_ID, STATUS,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByBENIFICIARY_ID_STATUS_PrevAndNext(
		Session session, ProjectRegistration projectRegistration,
		long BENIFICIARY_ID, int STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_BENIFICIARY_ID_STATUS_BENIFICIARY_ID_2);

		query.append(_FINDER_COLUMN_BENIFICIARY_ID_STATUS_STATUS_2);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(BENIFICIARY_ID);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63; from the database.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 */
	@Override
	public void removeByBENIFICIARY_ID_STATUS(long BENIFICIARY_ID, int STATUS) {
		for (ProjectRegistration projectRegistration : findByBENIFICIARY_ID_STATUS(
				BENIFICIARY_ID, STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where BENIFICIARY_ID = &#63; and STATUS = &#63;.
	 *
	 * @param BENIFICIARY_ID the benificiary_id
	 * @param STATUS the status
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByBENIFICIARY_ID_STATUS(long BENIFICIARY_ID, int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BENIFICIARY_ID_STATUS;

		Object[] finderArgs = new Object[] { BENIFICIARY_ID, STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_STATUS_BENIFICIARY_ID_2);

			query.append(_FINDER_COLUMN_BENIFICIARY_ID_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(BENIFICIARY_ID);

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

	private static final String _FINDER_COLUMN_BENIFICIARY_ID_STATUS_BENIFICIARY_ID_2 =
		"projectRegistration.BENIFICIARY_ID = ? AND ";
	private static final String _FINDER_COLUMN_BENIFICIARY_ID_STATUS_STATUS_2 = "projectRegistration.STATUS = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMULTIPLE_REQUEST_STATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByMULTIPLE_REQUEST_STATUS",
			new String[] { Integer.class.getName() },
			ProjectRegistrationModelImpl.REQUEST_STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MULTIPLE_REQUEST_STATUS = new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByMULTIPLE_REQUEST_STATUS",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULTIPLE_REQUEST_STATUS =
		new FinderPath(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByMULTIPLE_REQUEST_STATUS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS) {
		return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS, int start, int end) {
		return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int REQUEST_STATUS, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS;
			finderArgs = new Object[] { REQUEST_STATUS };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS;
			finderArgs = new Object[] {
					REQUEST_STATUS,
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if ((REQUEST_STATUS != projectRegistration.getREQUEST_STATUS())) {
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

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(REQUEST_STATUS);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByMULTIPLE_REQUEST_STATUS_First(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByMULTIPLE_REQUEST_STATUS_First(REQUEST_STATUS,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("REQUEST_STATUS=");
		msg.append(REQUEST_STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByMULTIPLE_REQUEST_STATUS_First(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		List<ProjectRegistration> list = findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration
	 * @throws NoSuchProjectRegistrationException if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration findByMULTIPLE_REQUEST_STATUS_Last(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByMULTIPLE_REQUEST_STATUS_Last(REQUEST_STATUS,
				orderByComparator);

		if (projectRegistration != null) {
			return projectRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("REQUEST_STATUS=");
		msg.append(REQUEST_STATUS);

		msg.append("}");

		throw new NoSuchProjectRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project registration, or <code>null</code> if a matching project registration could not be found
	 */
	@Override
	public ProjectRegistration fetchByMULTIPLE_REQUEST_STATUS_Last(
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		int count = countByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS);

		if (count == 0) {
			return null;
		}

		List<ProjectRegistration> list = findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUS,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project registrations before and after the current project registration in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param PROJECT_ID the primary key of the current project registration
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration[] findByMULTIPLE_REQUEST_STATUS_PrevAndNext(
		long PROJECT_ID, int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = findByPrimaryKey(PROJECT_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectRegistration[] array = new ProjectRegistrationImpl[3];

			array[0] = getByMULTIPLE_REQUEST_STATUS_PrevAndNext(session,
					projectRegistration, REQUEST_STATUS, orderByComparator, true);

			array[1] = projectRegistration;

			array[2] = getByMULTIPLE_REQUEST_STATUS_PrevAndNext(session,
					projectRegistration, REQUEST_STATUS, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectRegistration getByMULTIPLE_REQUEST_STATUS_PrevAndNext(
		Session session, ProjectRegistration projectRegistration,
		int REQUEST_STATUS,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_2);

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
			query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(REQUEST_STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the project registrations where REQUEST_STATUS = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUSs the request_statuses
	 * @return the matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs) {
		return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations where REQUEST_STATUS = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUSs the request_statuses
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs, int start, int end) {
		return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations where REQUEST_STATUS = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUSs the request_statuses
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations where REQUEST_STATUS = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project registrations
	 */
	@Override
	public List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
		int[] REQUEST_STATUSs, int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
		boolean retrieveFromCache) {
		if (REQUEST_STATUSs == null) {
			REQUEST_STATUSs = new int[0];
		}
		else if (REQUEST_STATUSs.length > 1) {
			REQUEST_STATUSs = ArrayUtil.unique(REQUEST_STATUSs);

			Arrays.sort(REQUEST_STATUSs);
		}

		if (REQUEST_STATUSs.length == 1) {
			return findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs[0], start,
				end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(REQUEST_STATUSs) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(REQUEST_STATUSs),
					
					start, end, orderByComparator
				};
		}

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectRegistration projectRegistration : list) {
					if (!ArrayUtil.contains(REQUEST_STATUSs,
								projectRegistration.getREQUEST_STATUS())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE);

			if (REQUEST_STATUSs.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_7);

				query.append(StringUtil.merge(REQUEST_STATUSs));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS,
					finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the project registrations where REQUEST_STATUS = &#63; from the database.
	 *
	 * @param REQUEST_STATUS the request_status
	 */
	@Override
	public void removeByMULTIPLE_REQUEST_STATUS(int REQUEST_STATUS) {
		for (ProjectRegistration projectRegistration : findByMULTIPLE_REQUEST_STATUS(
				REQUEST_STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByMULTIPLE_REQUEST_STATUS(int REQUEST_STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MULTIPLE_REQUEST_STATUS;

		Object[] finderArgs = new Object[] { REQUEST_STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(REQUEST_STATUS);

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

	/**
	 * Returns the number of project registrations where REQUEST_STATUS = any &#63;.
	 *
	 * @param REQUEST_STATUSs the request_statuses
	 * @return the number of matching project registrations
	 */
	@Override
	public int countByMULTIPLE_REQUEST_STATUS(int[] REQUEST_STATUSs) {
		if (REQUEST_STATUSs == null) {
			REQUEST_STATUSs = new int[0];
		}
		else if (REQUEST_STATUSs.length > 1) {
			REQUEST_STATUSs = ArrayUtil.unique(REQUEST_STATUSs);

			Arrays.sort(REQUEST_STATUSs);
		}

		Object[] finderArgs = new Object[] { StringUtil.merge(REQUEST_STATUSs) };

		Long count = (Long)finderCache.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULTIPLE_REQUEST_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_PROJECTREGISTRATION_WHERE);

			if (REQUEST_STATUSs.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_7);

				query.append(StringUtil.merge(REQUEST_STATUSs));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(removeConjunction(query.stringAt(query.index() -
						1)), query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULTIPLE_REQUEST_STATUS,
					finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULTIPLE_REQUEST_STATUS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_2 =
		"projectRegistration.REQUEST_STATUS = ?";
	private static final String _FINDER_COLUMN_MULTIPLE_REQUEST_STATUS_REQUEST_STATUS_7 =
		"projectRegistration.REQUEST_STATUS IN (";

	public ProjectRegistrationPersistenceImpl() {
		setModelClass(ProjectRegistration.class);

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
	 * Caches the project registration in the entity cache if it is enabled.
	 *
	 * @param projectRegistration the project registration
	 */
	@Override
	public void cacheResult(ProjectRegistration projectRegistration) {
		entityCache.putResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationImpl.class, projectRegistration.getPrimaryKey(),
			projectRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID,
			new Object[] { projectRegistration.getPROJECT_ID() },
			projectRegistration);

		projectRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project registrations in the entity cache if it is enabled.
	 *
	 * @param projectRegistrations the project registrations
	 */
	@Override
	public void cacheResult(List<ProjectRegistration> projectRegistrations) {
		for (ProjectRegistration projectRegistration : projectRegistrations) {
			if (entityCache.getResult(
						ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectRegistrationImpl.class,
						projectRegistration.getPrimaryKey()) == null) {
				cacheResult(projectRegistration);
			}
			else {
				projectRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectRegistration projectRegistration) {
		entityCache.removeResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationImpl.class, projectRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectRegistrationModelImpl)projectRegistration,
			true);
	}

	@Override
	public void clearCache(List<ProjectRegistration> projectRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectRegistration projectRegistration : projectRegistrations) {
			entityCache.removeResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectRegistrationImpl.class,
				projectRegistration.getPrimaryKey());

			clearUniqueFindersCache((ProjectRegistrationModelImpl)projectRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectRegistrationModelImpl projectRegistrationModelImpl) {
		Object[] args = new Object[] {
				projectRegistrationModelImpl.getPROJECT_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args,
			projectRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectRegistrationModelImpl projectRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					projectRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args);
		}

		if ((projectRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectRegistrationModelImpl.getOriginalPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_ID, args);
		}
	}

	/**
	 * Creates a new project registration with the primary key. Does not add the project registration to the database.
	 *
	 * @param PROJECT_ID the primary key for the new project registration
	 * @return the new project registration
	 */
	@Override
	public ProjectRegistration create(long PROJECT_ID) {
		ProjectRegistration projectRegistration = new ProjectRegistrationImpl();

		projectRegistration.setNew(true);
		projectRegistration.setPrimaryKey(PROJECT_ID);

		String uuid = PortalUUIDUtil.generate();

		projectRegistration.setUuid(uuid);

		return projectRegistration;
	}

	/**
	 * Removes the project registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_ID the primary key of the project registration
	 * @return the project registration that was removed
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration remove(long PROJECT_ID)
		throws NoSuchProjectRegistrationException {
		return remove((Serializable)PROJECT_ID);
	}

	/**
	 * Removes the project registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project registration
	 * @return the project registration that was removed
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration remove(Serializable primaryKey)
		throws NoSuchProjectRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectRegistration projectRegistration = (ProjectRegistration)session.get(ProjectRegistrationImpl.class,
					primaryKey);

			if (projectRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectRegistration);
		}
		catch (NoSuchProjectRegistrationException nsee) {
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
	protected ProjectRegistration removeImpl(
		ProjectRegistration projectRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectRegistration)) {
				projectRegistration = (ProjectRegistration)session.get(ProjectRegistrationImpl.class,
						projectRegistration.getPrimaryKeyObj());
			}

			if (projectRegistration != null) {
				session.delete(projectRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectRegistration != null) {
			clearCache(projectRegistration);
		}

		return projectRegistration;
	}

	@Override
	public ProjectRegistration updateImpl(
		ProjectRegistration projectRegistration) {
		boolean isNew = projectRegistration.isNew();

		if (!(projectRegistration instanceof ProjectRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectRegistration implementation " +
				projectRegistration.getClass());
		}

		ProjectRegistrationModelImpl projectRegistrationModelImpl = (ProjectRegistrationModelImpl)projectRegistration;

		if (Validator.isNull(projectRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectRegistration.isNew()) {
				session.save(projectRegistration);

				projectRegistration.setNew(false);
			}
			else {
				session.evict(projectRegistration);
				session.saveOrUpdate(projectRegistration);
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

		if (!ProjectRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { projectRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] { projectRegistrationModelImpl.getBENIFICIARY_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID,
				args);

			args = new Object[] { projectRegistrationModelImpl.getUSER_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
				args);

			args = new Object[] { projectRegistrationModelImpl.getSTATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			args = new Object[] { projectRegistrationModelImpl.getCREATION_DATE() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATION_DATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATION_DATE,
				args);

			args = new Object[] { projectRegistrationModelImpl.getEND_DATE() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_END_DATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_END_DATE,
				args);

			args = new Object[] { projectRegistrationModelImpl.getREQUEST_STATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUEST_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUEST_STATUS,
				args);

			args = new Object[] {
					projectRegistrationModelImpl.getBENIFICIARY_ID(),
					projectRegistrationModelImpl.getSTATUS()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID_STATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS,
				args);

			args = new Object[] { projectRegistrationModelImpl.getREQUEST_STATUS() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_MULTIPLE_REQUEST_STATUS,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { projectRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalBENIFICIARY_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID,
					args);

				args = new Object[] {
						projectRegistrationModelImpl.getBENIFICIARY_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalUSER_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);

				args = new Object[] { projectRegistrationModelImpl.getUSER_ID() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER_ID,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { projectRegistrationModelImpl.getSTATUS() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATION_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalCREATION_DATE()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATION_DATE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATION_DATE,
					args);

				args = new Object[] {
						projectRegistrationModelImpl.getCREATION_DATE()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATION_DATE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATION_DATE,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_END_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalEND_DATE()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_END_DATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_END_DATE,
					args);

				args = new Object[] { projectRegistrationModelImpl.getEND_DATE() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_END_DATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_END_DATE,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUEST_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalREQUEST_STATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUEST_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUEST_STATUS,
					args);

				args = new Object[] {
						projectRegistrationModelImpl.getREQUEST_STATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_REQUEST_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REQUEST_STATUS,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalBENIFICIARY_ID(),
						projectRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS,
					args);

				args = new Object[] {
						projectRegistrationModelImpl.getBENIFICIARY_ID(),
						projectRegistrationModelImpl.getSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_BENIFICIARY_ID_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BENIFICIARY_ID_STATUS,
					args);
			}

			if ((projectRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectRegistrationModelImpl.getOriginalREQUEST_STATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MULTIPLE_REQUEST_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS,
					args);

				args = new Object[] {
						projectRegistrationModelImpl.getREQUEST_STATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_MULTIPLE_REQUEST_STATUS,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLE_REQUEST_STATUS,
					args);
			}
		}

		entityCache.putResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectRegistrationImpl.class, projectRegistration.getPrimaryKey(),
			projectRegistration, false);

		clearUniqueFindersCache(projectRegistrationModelImpl, false);
		cacheUniqueFindersCache(projectRegistrationModelImpl);

		projectRegistration.resetOriginalValues();

		return projectRegistration;
	}

	/**
	 * Returns the project registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project registration
	 * @return the project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectRegistrationException {
		ProjectRegistration projectRegistration = fetchByPrimaryKey(primaryKey);

		if (projectRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectRegistration;
	}

	/**
	 * Returns the project registration with the primary key or throws a {@link NoSuchProjectRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_ID the primary key of the project registration
	 * @return the project registration
	 * @throws NoSuchProjectRegistrationException if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration findByPrimaryKey(long PROJECT_ID)
		throws NoSuchProjectRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_ID);
	}

	/**
	 * Returns the project registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project registration
	 * @return the project registration, or <code>null</code> if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectRegistration projectRegistration = (ProjectRegistration)serializable;

		if (projectRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectRegistration = (ProjectRegistration)session.get(ProjectRegistrationImpl.class,
						primaryKey);

				if (projectRegistration != null) {
					cacheResult(projectRegistration);
				}
				else {
					entityCache.putResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectRegistration;
	}

	/**
	 * Returns the project registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_ID the primary key of the project registration
	 * @return the project registration, or <code>null</code> if a project registration with the primary key could not be found
	 */
	@Override
	public ProjectRegistration fetchByPrimaryKey(long PROJECT_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_ID);
	}

	@Override
	public Map<Serializable, ProjectRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectRegistration> map = new HashMap<Serializable, ProjectRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectRegistration projectRegistration = fetchByPrimaryKey(primaryKey);

			if (projectRegistration != null) {
				map.put(primaryKey, projectRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectRegistration projectRegistration : (List<ProjectRegistration>)q.list()) {
				map.put(projectRegistration.getPrimaryKeyObj(),
					projectRegistration);

				cacheResult(projectRegistration);

				uncachedPrimaryKeys.remove(projectRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the project registrations.
	 *
	 * @return the project registrations
	 */
	@Override
	public List<ProjectRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @return the range of project registrations
	 */
	@Override
	public List<ProjectRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project registrations
	 */
	@Override
	public List<ProjectRegistration> findAll(int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project registrations
	 * @param end the upper bound of the range of project registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project registrations
	 */
	@Override
	public List<ProjectRegistration> findAll(int start, int end,
		OrderByComparator<ProjectRegistration> orderByComparator,
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

		List<ProjectRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectRegistration>)QueryUtil.list(q,
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
	 * Removes all the project registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectRegistration projectRegistration : findAll()) {
			remove(projectRegistration);
		}
	}

	/**
	 * Returns the number of project registrations.
	 *
	 * @return the number of project registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTREGISTRATION);

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
		return ProjectRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_PROJECTREGISTRATION = "SELECT projectRegistration FROM ProjectRegistration projectRegistration";
	private static final String _SQL_SELECT_PROJECTREGISTRATION_WHERE_PKS_IN = "SELECT projectRegistration FROM ProjectRegistration projectRegistration WHERE PROJECT_ID IN (";
	private static final String _SQL_SELECT_PROJECTREGISTRATION_WHERE = "SELECT projectRegistration FROM ProjectRegistration projectRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTREGISTRATION = "SELECT COUNT(projectRegistration) FROM ProjectRegistration projectRegistration";
	private static final String _SQL_COUNT_PROJECTREGISTRATION_WHERE = "SELECT COUNT(projectRegistration) FROM ProjectRegistration projectRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}