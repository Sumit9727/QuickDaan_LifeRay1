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

import com.crowd.funding.database.exception.NoSuchProjectExtentionRegistrationException;
import com.crowd.funding.database.model.ProjectExtentionRegistration;
import com.crowd.funding.database.model.impl.ProjectExtentionRegistrationImpl;
import com.crowd.funding.database.model.impl.ProjectExtentionRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.ProjectExtentionRegistrationPersistence;

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
 * The persistence implementation for the project extention registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectExtentionRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.ProjectExtentionRegistrationUtil
 * @generated
 */
@ProviderType
public class ProjectExtentionRegistrationPersistenceImpl
	extends BasePersistenceImpl<ProjectExtentionRegistration>
	implements ProjectExtentionRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectExtentionRegistrationUtil} to access the project extention registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectExtentionRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ProjectExtentionRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] { String.class.getName() });

	/**
	 * Returns all the project extention registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project extention registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @return the range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByUuid(String uuid,
		int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project extention registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project extention registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByUuid(String uuid,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		List<ProjectExtentionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectExtentionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectExtentionRegistration projectExtentionRegistration : list) {
					if (!Objects.equals(uuid,
								projectExtentionRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE);

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
				query.append(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
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
	 * Returns the first project extention registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration findByUuid_First(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (projectExtentionRegistration != null) {
			return projectExtentionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectExtentionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project extention registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchByUuid_First(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		List<ProjectExtentionRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project extention registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration findByUuid_Last(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (projectExtentionRegistration != null) {
			return projectExtentionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchProjectExtentionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project extention registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectExtentionRegistration> list = findByUuid(uuid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project extention registrations before and after the current project extention registration in the ordered set where uuid = &#63;.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration[] findByUuid_PrevAndNext(
		long PROJECT_EXTENTION_ID, String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = findByPrimaryKey(PROJECT_EXTENTION_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectExtentionRegistration[] array = new ProjectExtentionRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session,
					projectExtentionRegistration, uuid, orderByComparator, true);

			array[1] = projectExtentionRegistration;

			array[2] = getByUuid_PrevAndNext(session,
					projectExtentionRegistration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectExtentionRegistration getByUuid_PrevAndNext(
		Session session,
		ProjectExtentionRegistration projectExtentionRegistration, String uuid,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE);

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
			query.append(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(projectExtentionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectExtentionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project extention registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectExtentionRegistration projectExtentionRegistration : findByUuid(
				uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectExtentionRegistration);
		}
	}

	/**
	 * Returns the number of project extention registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project extention registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTEXTENTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "projectExtentionRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "projectExtentionRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(projectExtentionRegistration.uuid IS NULL OR projectExtentionRegistration.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPROJECT_ID",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID =
		new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPROJECT_ID",
			new String[] { Long.class.getName() },
			ProjectExtentionRegistrationModelImpl.PROJECT_ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECT_ID = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPROJECT_ID", new String[] { Long.class.getName() });

	/**
	 * Returns all the project extention registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByPROJECT_ID(long PROJECT_ID) {
		return findByPROJECT_ID(PROJECT_ID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project extention registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @return the range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end) {
		return findByPROJECT_ID(PROJECT_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project extention registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return findByPROJECT_ID(PROJECT_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project extention registrations where PROJECT_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param PROJECT_ID the project_id
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findByPROJECT_ID(
		long PROJECT_ID, int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		List<ProjectExtentionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectExtentionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectExtentionRegistration projectExtentionRegistration : list) {
					if ((PROJECT_ID != projectExtentionRegistration.getPROJECT_ID())) {
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

			query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(PROJECT_ID);

				if (!pagination) {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
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
	 * Returns the first project extention registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration findByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchByPROJECT_ID_First(PROJECT_ID,
				orderByComparator);

		if (projectExtentionRegistration != null) {
			return projectExtentionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectExtentionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project extention registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchByPROJECT_ID_First(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		List<ProjectExtentionRegistration> list = findByPROJECT_ID(PROJECT_ID,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project extention registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration findByPROJECT_ID_Last(long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchByPROJECT_ID_Last(PROJECT_ID,
				orderByComparator);

		if (projectExtentionRegistration != null) {
			return projectExtentionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("PROJECT_ID=");
		msg.append(PROJECT_ID);

		msg.append("}");

		throw new NoSuchProjectExtentionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project extention registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchByPROJECT_ID_Last(
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		int count = countByPROJECT_ID(PROJECT_ID);

		if (count == 0) {
			return null;
		}

		List<ProjectExtentionRegistration> list = findByPROJECT_ID(PROJECT_ID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project extention registrations before and after the current project extention registration in the ordered set where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	 * @param PROJECT_ID the project_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration[] findByPROJECT_ID_PrevAndNext(
		long PROJECT_EXTENTION_ID, long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = findByPrimaryKey(PROJECT_EXTENTION_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectExtentionRegistration[] array = new ProjectExtentionRegistrationImpl[3];

			array[0] = getByPROJECT_ID_PrevAndNext(session,
					projectExtentionRegistration, PROJECT_ID,
					orderByComparator, true);

			array[1] = projectExtentionRegistration;

			array[2] = getByPROJECT_ID_PrevAndNext(session,
					projectExtentionRegistration, PROJECT_ID,
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

	protected ProjectExtentionRegistration getByPROJECT_ID_PrevAndNext(
		Session session,
		ProjectExtentionRegistration projectExtentionRegistration,
		long PROJECT_ID,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE);

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
			query.append(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(PROJECT_ID);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectExtentionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectExtentionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project extention registrations where PROJECT_ID = &#63; from the database.
	 *
	 * @param PROJECT_ID the project_id
	 */
	@Override
	public void removeByPROJECT_ID(long PROJECT_ID) {
		for (ProjectExtentionRegistration projectExtentionRegistration : findByPROJECT_ID(
				PROJECT_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectExtentionRegistration);
		}
	}

	/**
	 * Returns the number of project extention registrations where PROJECT_ID = &#63;.
	 *
	 * @param PROJECT_ID the project_id
	 * @return the number of matching project extention registrations
	 */
	@Override
	public int countByPROJECT_ID(long PROJECT_ID) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECT_ID;

		Object[] finderArgs = new Object[] { PROJECT_ID };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTEXTENTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_PROJECT_ID_PROJECT_ID_2 = "projectExtentionRegistration.PROJECT_ID = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySTATUS",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySTATUS",
			new String[] { Integer.class.getName() },
			ProjectExtentionRegistrationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySTATUS", new String[] { Integer.class.getName() });

	/**
	 * Returns all the project extention registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findBySTATUS(int STATUS) {
		return findBySTATUS(STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project extention registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @return the range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findBySTATUS(int STATUS,
		int start, int end) {
		return findBySTATUS(STATUS, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project extention registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return findBySTATUS(STATUS, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project extention registrations where STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param STATUS the status
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findBySTATUS(int STATUS,
		int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		List<ProjectExtentionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectExtentionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectExtentionRegistration projectExtentionRegistration : list) {
					if ((STATUS != projectExtentionRegistration.getSTATUS())) {
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

			query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(STATUS);

				if (!pagination) {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
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
	 * Returns the first project extention registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration findBySTATUS_First(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchBySTATUS_First(STATUS,
				orderByComparator);

		if (projectExtentionRegistration != null) {
			return projectExtentionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchProjectExtentionRegistrationException(msg.toString());
	}

	/**
	 * Returns the first project extention registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchBySTATUS_First(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		List<ProjectExtentionRegistration> list = findBySTATUS(STATUS, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project extention registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration findBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchBySTATUS_Last(STATUS,
				orderByComparator);

		if (projectExtentionRegistration != null) {
			return projectExtentionRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("STATUS=");
		msg.append(STATUS);

		msg.append("}");

		throw new NoSuchProjectExtentionRegistrationException(msg.toString());
	}

	/**
	 * Returns the last project extention registration in the ordered set where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project extention registration, or <code>null</code> if a matching project extention registration could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchBySTATUS_Last(int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		int count = countBySTATUS(STATUS);

		if (count == 0) {
			return null;
		}

		List<ProjectExtentionRegistration> list = findBySTATUS(STATUS,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project extention registrations before and after the current project extention registration in the ordered set where STATUS = &#63;.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key of the current project extention registration
	 * @param STATUS the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration[] findBySTATUS_PrevAndNext(
		long PROJECT_EXTENTION_ID, int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = findByPrimaryKey(PROJECT_EXTENTION_ID);

		Session session = null;

		try {
			session = openSession();

			ProjectExtentionRegistration[] array = new ProjectExtentionRegistrationImpl[3];

			array[0] = getBySTATUS_PrevAndNext(session,
					projectExtentionRegistration, STATUS, orderByComparator,
					true);

			array[1] = projectExtentionRegistration;

			array[2] = getBySTATUS_PrevAndNext(session,
					projectExtentionRegistration, STATUS, orderByComparator,
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

	protected ProjectExtentionRegistration getBySTATUS_PrevAndNext(
		Session session,
		ProjectExtentionRegistration projectExtentionRegistration, int STATUS,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE);

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
			query.append(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(STATUS);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(projectExtentionRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ProjectExtentionRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project extention registrations where STATUS = &#63; from the database.
	 *
	 * @param STATUS the status
	 */
	@Override
	public void removeBySTATUS(int STATUS) {
		for (ProjectExtentionRegistration projectExtentionRegistration : findBySTATUS(
				STATUS, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(projectExtentionRegistration);
		}
	}

	/**
	 * Returns the number of project extention registrations where STATUS = &#63;.
	 *
	 * @param STATUS the status
	 * @return the number of matching project extention registrations
	 */
	@Override
	public int countBySTATUS(int STATUS) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { STATUS };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROJECTEXTENTIONREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "projectExtentionRegistration.STATUS = ?";

	public ProjectExtentionRegistrationPersistenceImpl() {
		setModelClass(ProjectExtentionRegistration.class);

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
	 * Caches the project extention registration in the entity cache if it is enabled.
	 *
	 * @param projectExtentionRegistration the project extention registration
	 */
	@Override
	public void cacheResult(
		ProjectExtentionRegistration projectExtentionRegistration) {
		entityCache.putResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			projectExtentionRegistration.getPrimaryKey(),
			projectExtentionRegistration);

		projectExtentionRegistration.resetOriginalValues();
	}

	/**
	 * Caches the project extention registrations in the entity cache if it is enabled.
	 *
	 * @param projectExtentionRegistrations the project extention registrations
	 */
	@Override
	public void cacheResult(
		List<ProjectExtentionRegistration> projectExtentionRegistrations) {
		for (ProjectExtentionRegistration projectExtentionRegistration : projectExtentionRegistrations) {
			if (entityCache.getResult(
						ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectExtentionRegistrationImpl.class,
						projectExtentionRegistration.getPrimaryKey()) == null) {
				cacheResult(projectExtentionRegistration);
			}
			else {
				projectExtentionRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project extention registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectExtentionRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project extention registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProjectExtentionRegistration projectExtentionRegistration) {
		entityCache.removeResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			projectExtentionRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ProjectExtentionRegistration> projectExtentionRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectExtentionRegistration projectExtentionRegistration : projectExtentionRegistrations) {
			entityCache.removeResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectExtentionRegistrationImpl.class,
				projectExtentionRegistration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project extention registration with the primary key. Does not add the project extention registration to the database.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key for the new project extention registration
	 * @return the new project extention registration
	 */
	@Override
	public ProjectExtentionRegistration create(long PROJECT_EXTENTION_ID) {
		ProjectExtentionRegistration projectExtentionRegistration = new ProjectExtentionRegistrationImpl();

		projectExtentionRegistration.setNew(true);
		projectExtentionRegistration.setPrimaryKey(PROJECT_EXTENTION_ID);

		String uuid = PortalUUIDUtil.generate();

		projectExtentionRegistration.setUuid(uuid);

		return projectExtentionRegistration;
	}

	/**
	 * Removes the project extention registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	 * @return the project extention registration that was removed
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration remove(long PROJECT_EXTENTION_ID)
		throws NoSuchProjectExtentionRegistrationException {
		return remove((Serializable)PROJECT_EXTENTION_ID);
	}

	/**
	 * Removes the project extention registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project extention registration
	 * @return the project extention registration that was removed
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration remove(Serializable primaryKey)
		throws NoSuchProjectExtentionRegistrationException {
		Session session = null;

		try {
			session = openSession();

			ProjectExtentionRegistration projectExtentionRegistration = (ProjectExtentionRegistration)session.get(ProjectExtentionRegistrationImpl.class,
					primaryKey);

			if (projectExtentionRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectExtentionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectExtentionRegistration);
		}
		catch (NoSuchProjectExtentionRegistrationException nsee) {
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
	protected ProjectExtentionRegistration removeImpl(
		ProjectExtentionRegistration projectExtentionRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectExtentionRegistration)) {
				projectExtentionRegistration = (ProjectExtentionRegistration)session.get(ProjectExtentionRegistrationImpl.class,
						projectExtentionRegistration.getPrimaryKeyObj());
			}

			if (projectExtentionRegistration != null) {
				session.delete(projectExtentionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectExtentionRegistration != null) {
			clearCache(projectExtentionRegistration);
		}

		return projectExtentionRegistration;
	}

	@Override
	public ProjectExtentionRegistration updateImpl(
		ProjectExtentionRegistration projectExtentionRegistration) {
		boolean isNew = projectExtentionRegistration.isNew();

		if (!(projectExtentionRegistration instanceof ProjectExtentionRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectExtentionRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(projectExtentionRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectExtentionRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectExtentionRegistration implementation " +
				projectExtentionRegistration.getClass());
		}

		ProjectExtentionRegistrationModelImpl projectExtentionRegistrationModelImpl =
			(ProjectExtentionRegistrationModelImpl)projectExtentionRegistration;

		if (Validator.isNull(projectExtentionRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectExtentionRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (projectExtentionRegistration.isNew()) {
				session.save(projectExtentionRegistration);

				projectExtentionRegistration.setNew(false);
			}
			else {
				projectExtentionRegistration = (ProjectExtentionRegistration)session.merge(projectExtentionRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ProjectExtentionRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					projectExtentionRegistrationModelImpl.getUuid()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					projectExtentionRegistrationModelImpl.getPROJECT_ID()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
				args);

			args = new Object[] {
					projectExtentionRegistrationModelImpl.getSTATUS()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((projectExtentionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectExtentionRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] {
						projectExtentionRegistrationModelImpl.getUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((projectExtentionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectExtentionRegistrationModelImpl.getOriginalPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);

				args = new Object[] {
						projectExtentionRegistrationModelImpl.getPROJECT_ID()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PROJECT_ID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECT_ID,
					args);
			}

			if ((projectExtentionRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						projectExtentionRegistrationModelImpl.getOriginalSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						projectExtentionRegistrationModelImpl.getSTATUS()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			ProjectExtentionRegistrationImpl.class,
			projectExtentionRegistration.getPrimaryKey(),
			projectExtentionRegistration, false);

		projectExtentionRegistration.resetOriginalValues();

		return projectExtentionRegistration;
	}

	/**
	 * Returns the project extention registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project extention registration
	 * @return the project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchProjectExtentionRegistrationException {
		ProjectExtentionRegistration projectExtentionRegistration = fetchByPrimaryKey(primaryKey);

		if (projectExtentionRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectExtentionRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectExtentionRegistration;
	}

	/**
	 * Returns the project extention registration with the primary key or throws a {@link NoSuchProjectExtentionRegistrationException} if it could not be found.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	 * @return the project extention registration
	 * @throws NoSuchProjectExtentionRegistrationException if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration findByPrimaryKey(
		long PROJECT_EXTENTION_ID)
		throws NoSuchProjectExtentionRegistrationException {
		return findByPrimaryKey((Serializable)PROJECT_EXTENTION_ID);
	}

	/**
	 * Returns the project extention registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project extention registration
	 * @return the project extention registration, or <code>null</code> if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				ProjectExtentionRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ProjectExtentionRegistration projectExtentionRegistration = (ProjectExtentionRegistration)serializable;

		if (projectExtentionRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				projectExtentionRegistration = (ProjectExtentionRegistration)session.get(ProjectExtentionRegistrationImpl.class,
						primaryKey);

				if (projectExtentionRegistration != null) {
					cacheResult(projectExtentionRegistration);
				}
				else {
					entityCache.putResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						ProjectExtentionRegistrationImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectExtentionRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectExtentionRegistration;
	}

	/**
	 * Returns the project extention registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PROJECT_EXTENTION_ID the primary key of the project extention registration
	 * @return the project extention registration, or <code>null</code> if a project extention registration with the primary key could not be found
	 */
	@Override
	public ProjectExtentionRegistration fetchByPrimaryKey(
		long PROJECT_EXTENTION_ID) {
		return fetchByPrimaryKey((Serializable)PROJECT_EXTENTION_ID);
	}

	@Override
	public Map<Serializable, ProjectExtentionRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ProjectExtentionRegistration> map = new HashMap<Serializable, ProjectExtentionRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ProjectExtentionRegistration projectExtentionRegistration = fetchByPrimaryKey(primaryKey);

			if (projectExtentionRegistration != null) {
				map.put(primaryKey, projectExtentionRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectExtentionRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(ProjectExtentionRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE_PKS_IN);

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

			for (ProjectExtentionRegistration projectExtentionRegistration : (List<ProjectExtentionRegistration>)q.list()) {
				map.put(projectExtentionRegistration.getPrimaryKeyObj(),
					projectExtentionRegistration);

				cacheResult(projectExtentionRegistration);

				uncachedPrimaryKeys.remove(projectExtentionRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ProjectExtentionRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					ProjectExtentionRegistrationImpl.class, primaryKey,
					nullModel);
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
	 * Returns all the project extention registrations.
	 *
	 * @return the project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project extention registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @return the range of project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project extention registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findAll(int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project extention registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ProjectExtentionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project extention registrations
	 * @param end the upper bound of the range of project extention registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of project extention registrations
	 */
	@Override
	public List<ProjectExtentionRegistration> findAll(int start, int end,
		OrderByComparator<ProjectExtentionRegistration> orderByComparator,
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

		List<ProjectExtentionRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<ProjectExtentionRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PROJECTEXTENTIONREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTEXTENTIONREGISTRATION;

				if (pagination) {
					sql = sql.concat(ProjectExtentionRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ProjectExtentionRegistration>)QueryUtil.list(q,
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
	 * Removes all the project extention registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectExtentionRegistration projectExtentionRegistration : findAll()) {
			remove(projectExtentionRegistration);
		}
	}

	/**
	 * Returns the number of project extention registrations.
	 *
	 * @return the number of project extention registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PROJECTEXTENTIONREGISTRATION);

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
		return ProjectExtentionRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project extention registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ProjectExtentionRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PROJECTEXTENTIONREGISTRATION = "SELECT projectExtentionRegistration FROM ProjectExtentionRegistration projectExtentionRegistration";
	private static final String _SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE_PKS_IN =
		"SELECT projectExtentionRegistration FROM ProjectExtentionRegistration projectExtentionRegistration WHERE PROJECT_EXTENTION_ID IN (";
	private static final String _SQL_SELECT_PROJECTEXTENTIONREGISTRATION_WHERE = "SELECT projectExtentionRegistration FROM ProjectExtentionRegistration projectExtentionRegistration WHERE ";
	private static final String _SQL_COUNT_PROJECTEXTENTIONREGISTRATION = "SELECT COUNT(projectExtentionRegistration) FROM ProjectExtentionRegistration projectExtentionRegistration";
	private static final String _SQL_COUNT_PROJECTEXTENTIONREGISTRATION_WHERE = "SELECT COUNT(projectExtentionRegistration) FROM ProjectExtentionRegistration projectExtentionRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectExtentionRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectExtentionRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ProjectExtentionRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ProjectExtentionRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}