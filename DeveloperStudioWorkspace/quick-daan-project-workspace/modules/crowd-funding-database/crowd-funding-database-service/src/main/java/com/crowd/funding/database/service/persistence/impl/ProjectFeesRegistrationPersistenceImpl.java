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

import com.crowd.funding.database.exception.NoSuchProjectFeesRegistrationException;
import com.crowd.funding.database.model.ProjectFeesRegistration;
import com.crowd.funding.database.model.impl.ProjectFeesRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectFeesRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectFeesRegistrationPersistence;

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
 * The persistence implementation for the project fees registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectFeesRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectFeesRegistrationPersistenceImpl extends BasePersistenceImpl<ProjectFeesRegistration>
	implements ProjectFeesRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectFeesRegistrationUtil} to access the project fees registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectFeesRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectFeesRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the project fees registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project fees registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @return the range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByUuid(String uuid, int start,
		int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project fees registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project fees registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<ProjectFeesRegistration> orderByComparator,
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

		List<ProjectFeesRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFeesRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectFeesRegistration projectFeesRegistration : list) {
					if (!Objects.equals(uuid, projectFeesRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

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
				query.append(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
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
	 * Returns the first project fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectFeesRegistration != null) {
			return projectFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		List<ProjectFeesRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectFeesRegistration != null) {
			return projectFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectFeesRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project fees registrations before and after the current project fees registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_FEES_ID the primary key of the current project fees registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration[] findByUuid_PrevAndNext(
		long PROJECT_FEES_ID, String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = findByPrimaryKey(PROJECT_FEES_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectFeesRegistration[] array = new ProjectFeesRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, projectFeesRegistration,
					uuid, orderByComparator, true);

			array[1] = projectFeesRegistration;

			array[2] = getByUuid_PrevAndNext(session, projectFeesRegistration,
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

	protected ProjectFeesRegistration getByUuid_PrevAndNext(Session session,
		ProjectFeesRegistration projectFeesRegistration, String uuid,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

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
			query.append(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectFeesRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectFeesRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project fees registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectFeesRegistration projectFeesRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectFeesRegistration);
		}
	}

	/**
	 * Returns the number of project fees registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project fees registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFEESREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectFeesRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectFeesRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectFeesRegistration.uuid IS NULL OR projectFeesRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PROJECT_FEES_ID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPROJECT_FEES_ID", new String[] { Long.class.getName() },
			ProjectFeesRegistrationModelImpl.PROJECT_FEES_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_FEES_ID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_FEES_ID", new String[] { Long.class.getName() });

	/**
	 * Returns the project fees registration where PROJECT_FEES_ID = &#63; or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FEES_ID the project_fees_id
	 * @return the matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByPROJECT_FEES_ID(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByPROJECT_FEES_ID(PROJECT_FEES_ID);

		if (projectFeesRegistration == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("PROJECT_FEES_ID=");
			msg.append(PROJECT_FEES_ID);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchProjectFeesRegistrationException(msg.toString());
		}

		return projectFeesRegistration;
	}

	/**
	 * Returns the project fees registration where PROJECT_FEES_ID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param PROJECT_FEES_ID the project_fees_id
	 * @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		return fetchByPROJECT_FEES_ID(PROJECT_FEES_ID, true);
	}

	/**
	 * Returns the project fees registration where PROJECT_FEES_ID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param PROJECT_FEES_ID the project_fees_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByPROJECT_FEES_ID(
		long PROJECT_FEES_ID, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { PROJECT_FEES_ID };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID,
					finderArgs, this);
		}

		if (result instanceof ProjectFeesRegistration) {
			ProjectFeesRegistration projectFeesRegistration = (ProjectFeesRegistration)result;

			if ((PROJECT_FEES_ID != projectFeesRegistration.getPROJECT_FEES_ID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FEES_ID_PROJECT_FEES_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FEES_ID);

				List<ProjectFeesRegistration> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ProjectFeesRegistrationPersistenceImpl.fetchByPROJECT_FEES_ID(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProjectFeesRegistration projectFeesRegistration = list.get(0);

					result = projectFeesRegistration;

					cacheResult(projectFeesRegistration);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID,
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
			return (ProjectFeesRegistration)result;
		}
	}

	/**
	 * Removes the project fees registration where PROJECT_FEES_ID = &#63; from the database.
	 *
	 * @param PROJECT_FEES_ID the project_fees_id
	 * @return the project fees registration that was removed
	 */
	@Override
	public ProjectFeesRegistration removeByPROJECT_FEES_ID(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = findByPROJECT_FEES_ID(PROJECT_FEES_ID);

		return remove(projectFeesRegistration);
	}

	/**
	 * Returns the number of project fees registrations where PROJECT_FEES_ID = &#63;.
	 *
	 * @param PROJECT_FEES_ID the project_fees_id
	 * @return the number of matching project fees registrations
	 */
	@Override
	public int countByPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_FEES_ID;

		Object[] finderArgs = new Object[] { PROJECT_FEES_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFEESREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_FEES_ID_PROJECT_FEES_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_FEES_ID);

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

	private static final String _FINDER_COLUMN_PROJECT_FEES_ID_PROJECT_FEES_ID_2 =
		"projectFeesRegistration.PROJECT_FEES_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY_ID =
		new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCATEGORY_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY_ID =
		new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCATEGORY_ID",
			new String[] { Long.class.getName() },
			ProjectFeesRegistrationModelImpl.CATEGORY_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY_ID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCATEGORY_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project fees registrations where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @return the matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByCATEGORY_ID(long CATEGORY_ID) {
		return findByCATEGORY_ID(CATEGORY_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project fees registrations where CATEGORY_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CATEGORY_ID the category_id
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @return the range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByCATEGORY_ID(long CATEGORY_ID,
		int start, int end) {
		return findByCATEGORY_ID(CATEGORY_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project fees registrations where CATEGORY_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CATEGORY_ID the category_id
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByCATEGORY_ID(long CATEGORY_ID,
		int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return findByCATEGORY_ID(CATEGORY_ID, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the project fees registrations where CATEGORY_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param CATEGORY_ID the category_id
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByCATEGORY_ID(long CATEGORY_ID,
		int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY_ID;
			finderArgs = new Object[] { CATEGORY_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY_ID;
			finderArgs = new Object[] { CATEGORY_ID, start, end, orderByComparator };
		}

		List<ProjectFeesRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFeesRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectFeesRegistration projectFeesRegistration : list) {
					if ((CATEGORY_ID != projectFeesRegistration.getCATEGORY_ID())) {
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

			query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_ID_CATEGORY_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(CATEGORY_ID);

				if (!pagination) {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
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
	 * Returns the first project fees registration in the ordered set where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByCATEGORY_ID_First(long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByCATEGORY_ID_First(CATEGORY_ID,
				orderByComparator);

		if (projectFeesRegistration != null) {
			return projectFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CATEGORY_ID=");
		msg.append(CATEGORY_ID);

		msg.append("}");

		throw new NoSuchProjectFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project fees registration in the ordered set where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByCATEGORY_ID_First(long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		List<ProjectFeesRegistration> list = findByCATEGORY_ID(CATEGORY_ID, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project fees registration in the ordered set where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByCATEGORY_ID_Last(long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByCATEGORY_ID_Last(CATEGORY_ID,
				orderByComparator);

		if (projectFeesRegistration != null) {
			return projectFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("CATEGORY_ID=");
		msg.append(CATEGORY_ID);

		msg.append("}");

		throw new NoSuchProjectFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project fees registration in the ordered set where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByCATEGORY_ID_Last(long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		int count = countByCATEGORY_ID(CATEGORY_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectFeesRegistration> list = findByCATEGORY_ID(CATEGORY_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project fees registrations before and after the current project fees registration in the ordered set where CATEGORY_ID = &#63;.
	 *
	 * @param PROJECT_FEES_ID the primary key of the current project fees registration
	 * @param CATEGORY_ID the category_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration[] findByCATEGORY_ID_PrevAndNext(
		long PROJECT_FEES_ID, long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = findByPrimaryKey(PROJECT_FEES_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectFeesRegistration[] array = new ProjectFeesRegistrationImpl[3];

			array[0] = getByCATEGORY_ID_PrevAndNext(session,
					projectFeesRegistration, CATEGORY_ID, orderByComparator,
					true);

			array[1] = projectFeesRegistration;

			array[2] = getByCATEGORY_ID_PrevAndNext(session,
					projectFeesRegistration, CATEGORY_ID, orderByComparator,
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

	protected ProjectFeesRegistration getByCATEGORY_ID_PrevAndNext(
		Session session, ProjectFeesRegistration projectFeesRegistration,
		long CATEGORY_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_ID_CATEGORY_ID_2);

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
			query.append(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(CATEGORY_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectFeesRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectFeesRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project fees registrations where CATEGORY_ID = &#63; from the database.
	 *
	 * @param CATEGORY_ID the category_id
	 */
	@Override
	public void removeByCATEGORY_ID(long CATEGORY_ID) {
		for (ProjectFeesRegistration projectFeesRegistration : findByCATEGORY_ID(
				CATEGORY_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectFeesRegistration);
		}
	}

	/**
	 * Returns the number of project fees registrations where CATEGORY_ID = &#63;.
	 *
	 * @param CATEGORY_ID the category_id
	 * @return the number of matching project fees registrations
	 */
	@Override
	public int countByCATEGORY_ID(long CATEGORY_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY_ID;

		Object[] finderArgs = new Object[] { CATEGORY_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFEESREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_CATEGORY_ID_CATEGORY_ID_2 = "projectFeesRegistration.CATEGORY_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			ProjectFeesRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPROJECT_ID",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the project fees registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project fees registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @return the range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project fees registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project fees registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findByPROJECT_ID(long PROJECT_ID,
		int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID;
			finderArgs = new Object[] { PROJECT_ID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID;
			finderArgs = new Object[] { PROJECT_ID, start, end, orderByComparator };
		}

		List<ProjectFeesRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFeesRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectFeesRegistration projectFeesRegistration : list) {
					if ((PROJECT_ID != projectFeesRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
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
	 * Returns the first project fees registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (projectFeesRegistration != null) {
			return projectFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project fees registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByPROJECT_ID_First(long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		List<ProjectFeesRegistration> list = findByPROJECT_ID(PROJECT_ID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project fees registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (projectFeesRegistration != null) {
			return projectFeesRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectFeesRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project fees registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project fees registration, or <code>null</code> if a matching project fees registration could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectFeesRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project fees registrations before and after the current project fees registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_FEES_ID the primary key of the current project fees registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_FEES_ID, long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = findByPrimaryKey(PROJECT_FEES_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectFeesRegistration[] array = new ProjectFeesRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					projectFeesRegistration, PROJECT_ID, orderByComparator, true);

			array[1] = projectFeesRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					projectFeesRegistration, PROJECT_ID, orderByComparator,
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

	protected ProjectFeesRegistration getByPROJECT_ID_PrevAndNext(
		Session session, ProjectFeesRegistration projectFeesRegistration,
		long PROJECT_ID,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

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
			query.append(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectFeesRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectFeesRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project fees registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (ProjectFeesRegistration projectFeesRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectFeesRegistration);
		}
	}

	/**
	 * Returns the number of project fees registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project fees registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTFEESREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectFeesRegistration.PROJECT_ID = ?";

	public ProjectFeesRegistrationPersistenceImpl() {
		setModelClass(ProjectFeesRegistration.class);

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
	 * Caches the project fees registration in the entity cache if it is enabled.
	 *
	 * @param projectFeesRegistration the project fees registration
	 */
	@Override
	public void cacheResult(ProjectFeesRegistration projectFeesRegistration) {
		entityCache.putResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			projectFeesRegistration.getPrimaryKey(), projectFeesRegistration);

		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID,
			new Object[] { projectFeesRegistration.getPROJECT_FEES_ID() },
			projectFeesRegistration);

		projectFeesRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project fees registrations in the entity cache if it is enabled.
	 *
	 * @param projectFeesRegistrations the project fees registrations
	 */
	@Override
	public void cacheResult(
		List<ProjectFeesRegistration> projectFeesRegistrations) {
		for (ProjectFeesRegistration projectFeesRegistration : projectFeesRegistrations) {
			if (entityCache.getResult(
						ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectFeesRegistrationImpl.class,
						projectFeesRegistration.getPrimaryKey()) == null) {
				cacheResult(projectFeesRegistration);
			}
			else {
				projectFeesRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project fees registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectFeesRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project fees registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectFeesRegistration projectFeesRegistration) {
		entityCache.removeResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			projectFeesRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ProjectFeesRegistrationModelImpl)projectFeesRegistration,
			true);
	}

	@Override
	public void clearCache(
		List<ProjectFeesRegistration> projectFeesRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectFeesRegistration projectFeesRegistration : projectFeesRegistrations) {
			entityCache.removeResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectFeesRegistrationImpl.class,
				projectFeesRegistration.getPrimaryKey());

			clearUniqueFindersCache((ProjectFeesRegistrationModelImpl)projectFeesRegistration,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectFeesRegistrationModelImpl projectFeesRegistrationModelImpl) {
		Object[] args = new Object[] {
				projectFeesRegistrationModelImpl.getPROJECT_FEES_ID()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_PROJECT_FEES_ID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID, args,
			projectFeesRegistrationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectFeesRegistrationModelImpl projectFeesRegistrationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					projectFeesRegistrationModelImpl.getPROJECT_FEES_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FEES_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID, args);
		}

		if ((projectFeesRegistrationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROJECT_FEES_ID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					projectFeesRegistrationModelImpl.getOriginalPROJECT_FEES_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_FEES_ID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_PROJECT_FEES_ID, args);
		}
	}

	/**
	 * Creates a new project fees registration with the primary key. Does not add the project fees registration to the database.
	 *
	 * @param PROJECT_FEES_ID the primary key for the new project fees registration
	 * @return the new project fees registration
	 */
	@Override
	public ProjectFeesRegistration create(long PROJECT_FEES_ID) {
		ProjectFeesRegistration projectFeesRegistration = new ProjectFeesRegistrationImpl();

		projectFeesRegistration.setNew(true);
		projectFeesRegistration.setPrimaryKey(PROJECT_FEES_ID);

		String uuid = PortalUUIDUtil.generate();

		projectFeesRegistration.setUuid(uuid);

		return projectFeesRegistration;
	}

	/**
	 * Removes the project fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_FEES_ID the primary key of the project fees registration
	 * @return the project fees registration that was removed
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration remove(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException {
		return remove((Serializable)PROJECT_FEES_ID);
	}

	/**
	 * Removes the project fees registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project fees registration
	 * @return the project fees registration that was removed
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration remove(Serializable primaryKey)
		throws NoSuchProjectFeesRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectFeesRegistration projectFeesRegistration = (ProjectFeesRegistration)session.get(ProjectFeesRegistrationImpl.class,
					primaryKey);

			if (projectFeesRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectFeesRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectFeesRegistration);
		}
		catch (NoSuchProjectFeesRegistrationException nsee) {
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
	protected ProjectFeesRegistration removeImpl(
		ProjectFeesRegistration projectFeesRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectFeesRegistration)) {
				projectFeesRegistration = (ProjectFeesRegistration)session.get(ProjectFeesRegistrationImpl.class,
						projectFeesRegistration.getPrimaryKeyObj());
			}

			if (projectFeesRegistration != null) {
				session.delete(projectFeesRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectFeesRegistration != null) {
			clearCache(projectFeesRegistration);
		}

		return projectFeesRegistration;
	}

	@Override
	public ProjectFeesRegistration updateImpl(
		ProjectFeesRegistration projectFeesRegistration) {
		boolean isNew = projectFeesRegistration.isNew();

		if (!(projectFeesRegistration instanceof ProjectFeesRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectFeesRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectFeesRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectFeesRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectFeesRegistration implementation " +
				projectFeesRegistration.getClass());
		}

		ProjectFeesRegistrationModelImpl projectFeesRegistrationModelImpl = (ProjectFeesRegistrationModelImpl)projectFeesRegistration;

		if (Validator.isNull(projectFeesRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectFeesRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectFeesRegistration.isNew()) {
				session.save(projectFeesRegistration);

				projectFeesRegistration.setNew(false);
			}
			else {
				projectFeesRegistration = (ProjectFeesRegistration)session.merge(projectFeesRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProjectFeesRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectFeesRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					projectFeesRegistrationModelImpl.getCATEGORY_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY_ID,
				args);

			args = new Object[] { projectFeesRegistrationModelImpl.getPROJECT_ID() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectFeesRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectFeesRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { projectFeesRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectFeesRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectFeesRegistrationModelImpl.getOriginalCATEGORY_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY_ID,
					args);

				args = new Object[] {
						projectFeesRegistrationModelImpl.getCATEGORY_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY_ID,
					args);
			}

			if ((projectFeesRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectFeesRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						projectFeesRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}
		}

		entityCache.putResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectFeesRegistrationImpl.class,
			projectFeesRegistration.getPrimaryKey(), projectFeesRegistration,
			false);

		clearUniqueFindersCache(projectFeesRegistrationModelImpl, false);
		cacheUniqueFindersCache(projectFeesRegistrationModelImpl);

		projectFeesRegistration.resetOriginalValues();

		return projectFeesRegistration;
	}

	/**
	 * Returns the project fees registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project fees registration
	 * @return the project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectFeesRegistrationException {
		ProjectFeesRegistration projectFeesRegistration = fetchByPrimaryKey(primaryKey);

		if (projectFeesRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectFeesRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectFeesRegistration;
	}

	/**
	 * Returns the project fees registration with the primary key or throws a {@link NoSuchProjectFeesRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_FEES_ID the primary key of the project fees registration
	 * @return the project fees registration
	 * @throws NoSuchProjectFeesRegistrationException if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration findByPrimaryKey(long PROJECT_FEES_ID)
		throws NoSuchProjectFeesRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_FEES_ID);
	}

	/**
	 * Returns the project fees registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project fees registration
	 * @return the project fees registration, or <code>null</code> if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectFeesRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectFeesRegistration projectFeesRegistration = (ProjectFeesRegistration)serializable;

		if (projectFeesRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectFeesRegistration = (ProjectFeesRegistration)session.get(ProjectFeesRegistrationImpl.class,
						primaryKey);

				if (projectFeesRegistration != null) {
					cacheResult(projectFeesRegistration);
				}
				else {
					entityCache.putResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectFeesRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectFeesRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectFeesRegistration;
	}

	/**
	 * Returns the project fees registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_FEES_ID the primary key of the project fees registration
	 * @return the project fees registration, or <code>null</code> if a project fees registration with the primary key could not be found
	 */
	@Override
	public ProjectFeesRegistration fetchByPrimaryKey(long PROJECT_FEES_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_FEES_ID);
	}

	@Override
	public Map<Serializable, ProjectFeesRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectFeesRegistration> map = new HashMap<Serializable, ProjectFeesRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectFeesRegistration projectFeesRegistration = fetchByPrimaryKey(primaryKey);

			if (projectFeesRegistration != null) {
				map.put(primaryKey, projectFeesRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectFeesRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ProjectFeesRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTFEESREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectFeesRegistration projectFeesRegistration : (List<ProjectFeesRegistration>)q.list()) {
				map.put(projectFeesRegistration.getPrimaryKeyObj(),
					projectFeesRegistration);

				cacheResult(projectFeesRegistration);

				uncachedPrimaryKeys.remove(projectFeesRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectFeesRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectFeesRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the project fees registrations.
	 *
	 * @return the project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project fees registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @return the range of project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project fees registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project fees registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectFeesRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project fees registrations
	 * @param end the upper bound of the range of project fees registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project fees registrations
	 */
	@Override
	public List<ProjectFeesRegistration> findAll(int start, int end,
		OrderByComparator<ProjectFeesRegistration> orderByComparator,
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

		List<ProjectFeesRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectFeesRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTFEESREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTFEESREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectFeesRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectFeesRegistration>)QueryUtil.list(q,
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
	 * Removes all the project fees registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectFeesRegistration projectFeesRegistration : findAll()) {
			remove(projectFeesRegistration);
		}
	}

	/**
	 * Returns the number of project fees registrations.
	 *
	 * @return the number of project fees registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTFEESREGISTRATION);

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
		return ProjectFeesRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project fees registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectFeesRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTFEESREGISTRATION = "SELECT projectFeesRegistration FROM ProjectFeesRegistration projectFeesRegistration";
	private static final String _SQL_SELECT_PROJECTFEESREGISTRATION_WHERE_PKS_IN =
		"SELECT projectFeesRegistration FROM ProjectFeesRegistration projectFeesRegistration WHERE PROJECT_FEES_ID IN (";
	private static final String _SQL_SELECT_PROJECTFEESREGISTRATION_WHERE = "SELECT projectFeesRegistration FROM ProjectFeesRegistration projectFeesRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTFEESREGISTRATION = "SELECT COUNT(projectFeesRegistration) FROM ProjectFeesRegistration projectFeesRegistration";
	private static final String _SQL_COUNT_PROJECTFEESREGISTRATION_WHERE = "SELECT COUNT(projectFeesRegistration) FROM ProjectFeesRegistration projectFeesRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectFeesRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectFeesRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectFeesRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectFeesRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}