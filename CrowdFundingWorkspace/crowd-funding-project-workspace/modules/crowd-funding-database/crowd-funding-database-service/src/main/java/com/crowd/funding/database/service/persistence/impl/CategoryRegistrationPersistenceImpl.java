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

import com.crowd.funding.database.exception.NoSuchCategoryRegistrationException;
import com.crowd.funding.database.model.CategoryRegistration;
import com.crowd.funding.database.model.impl.CategoryRegistrationImpl;
import com.crowd.funding.database.model.impl.CategoryRegistrationModelImpl;
import com.crowd.funding.database.service.persistence.CategoryRegistrationPersistence;

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
 * The persistence implementation for the category registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryRegistrationPersistence
 * @see com.crowd.funding.database.service.persistence.CategoryRegistrationUtil
 * @generated
 */
@ProviderType
public class CategoryRegistrationPersistenceImpl extends BasePersistenceImpl<CategoryRegistration>
	implements CategoryRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryRegistrationUtil} to access the category registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CategoryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CategoryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CategoryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationModelImpl.FINDER_CACHE_ENABLED,
			CategoryRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			CategoryRegistrationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the category registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching category registrations
	 */
	@Override
	public List<CategoryRegistration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of category registrations
	 * @param end the upper bound of the range of category registrations (not inclusive)
	 * @return the range of matching category registrations
	 */
	@Override
	public List<CategoryRegistration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of category registrations
	 * @param end the upper bound of the range of category registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category registrations
	 */
	@Override
	public List<CategoryRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CategoryRegistration> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the category registrations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of category registrations
	 * @param end the upper bound of the range of category registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching category registrations
	 */
	@Override
	public List<CategoryRegistration> findByUuid(String uuid, int start,
		int end, OrderByComparator<CategoryRegistration> orderByComparator,
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

		List<CategoryRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CategoryRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CategoryRegistration categoryRegistration : list) {
					if (!Objects.equals(uuid, categoryRegistration.getUuid())) {
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

			query.append(_SQL_SELECT_CATEGORYREGISTRATION_WHERE);

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
				query.append(CategoryRegistrationModelImpl.ORDER_BY_JPQL);
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
					list = (List<CategoryRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CategoryRegistration>)QueryUtil.list(q,
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
	 * Returns the first category registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category registration
	 * @throws NoSuchCategoryRegistrationException if a matching category registration could not be found
	 */
	@Override
	public CategoryRegistration findByUuid_First(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator)
		throws NoSuchCategoryRegistrationException {
		CategoryRegistration categoryRegistration = fetchByUuid_First(uuid,
				orderByComparator);

		if (categoryRegistration != null) {
			return categoryRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCategoryRegistrationException(msg.toString());
	}

	/**
	 * Returns the first category registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category registration, or <code>null</code> if a matching category registration could not be found
	 */
	@Override
	public CategoryRegistration fetchByUuid_First(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		List<CategoryRegistration> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last category registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category registration
	 * @throws NoSuchCategoryRegistrationException if a matching category registration could not be found
	 */
	@Override
	public CategoryRegistration findByUuid_Last(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator)
		throws NoSuchCategoryRegistrationException {
		CategoryRegistration categoryRegistration = fetchByUuid_Last(uuid,
				orderByComparator);

		if (categoryRegistration != null) {
			return categoryRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCategoryRegistrationException(msg.toString());
	}

	/**
	 * Returns the last category registration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category registration, or <code>null</code> if a matching category registration could not be found
	 */
	@Override
	public CategoryRegistration fetchByUuid_Last(String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CategoryRegistration> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the category registrations before and after the current category registration in the ordered set where uuid = &#63;.
	 *
	 * @param CATEGORY_ID the primary key of the current category registration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category registration
	 * @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration[] findByUuid_PrevAndNext(long CATEGORY_ID,
		String uuid, OrderByComparator<CategoryRegistration> orderByComparator)
		throws NoSuchCategoryRegistrationException {
		CategoryRegistration categoryRegistration = findByPrimaryKey(CATEGORY_ID);

		Session session = null;

		try {
			session = openSession();

			CategoryRegistration[] array = new CategoryRegistrationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, categoryRegistration,
					uuid, orderByComparator, true);

			array[1] = categoryRegistration;

			array[2] = getByUuid_PrevAndNext(session, categoryRegistration,
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

	protected CategoryRegistration getByUuid_PrevAndNext(Session session,
		CategoryRegistration categoryRegistration, String uuid,
		OrderByComparator<CategoryRegistration> orderByComparator,
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

		query.append(_SQL_SELECT_CATEGORYREGISTRATION_WHERE);

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
			query.append(CategoryRegistrationModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(categoryRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the category registrations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CategoryRegistration categoryRegistration : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(categoryRegistration);
		}
	}

	/**
	 * Returns the number of category registrations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching category registrations
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYREGISTRATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "categoryRegistration.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "categoryRegistration.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(categoryRegistration.uuid IS NULL OR categoryRegistration.uuid = '')";

	public CategoryRegistrationPersistenceImpl() {
		setModelClass(CategoryRegistration.class);

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
	 * Caches the category registration in the entity cache if it is enabled.
	 *
	 * @param categoryRegistration the category registration
	 */
	@Override
	public void cacheResult(CategoryRegistration categoryRegistration) {
		entityCache.putResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationImpl.class,
			categoryRegistration.getPrimaryKey(), categoryRegistration);

		categoryRegistration.resetOriginalValues();
	}

	/**
	 * Caches the category registrations in the entity cache if it is enabled.
	 *
	 * @param categoryRegistrations the category registrations
	 */
	@Override
	public void cacheResult(List<CategoryRegistration> categoryRegistrations) {
		for (CategoryRegistration categoryRegistration : categoryRegistrations) {
			if (entityCache.getResult(
						CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CategoryRegistrationImpl.class,
						categoryRegistration.getPrimaryKey()) == null) {
				cacheResult(categoryRegistration);
			}
			else {
				categoryRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all category registrations.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoryRegistrationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category registration.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryRegistration categoryRegistration) {
		entityCache.removeResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationImpl.class, categoryRegistration.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CategoryRegistration> categoryRegistrations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoryRegistration categoryRegistration : categoryRegistrations) {
			entityCache.removeResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CategoryRegistrationImpl.class,
				categoryRegistration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new category registration with the primary key. Does not add the category registration to the database.
	 *
	 * @param CATEGORY_ID the primary key for the new category registration
	 * @return the new category registration
	 */
	@Override
	public CategoryRegistration create(long CATEGORY_ID) {
		CategoryRegistration categoryRegistration = new CategoryRegistrationImpl();

		categoryRegistration.setNew(true);
		categoryRegistration.setPrimaryKey(CATEGORY_ID);

		String uuid = PortalUUIDUtil.generate();

		categoryRegistration.setUuid(uuid);

		return categoryRegistration;
	}

	/**
	 * Removes the category registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CATEGORY_ID the primary key of the category registration
	 * @return the category registration that was removed
	 * @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration remove(long CATEGORY_ID)
		throws NoSuchCategoryRegistrationException {
		return remove((Serializable)CATEGORY_ID);
	}

	/**
	 * Removes the category registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category registration
	 * @return the category registration that was removed
	 * @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration remove(Serializable primaryKey)
		throws NoSuchCategoryRegistrationException {
		Session session = null;

		try {
			session = openSession();

			CategoryRegistration categoryRegistration = (CategoryRegistration)session.get(CategoryRegistrationImpl.class,
					primaryKey);

			if (categoryRegistration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoryRegistration);
		}
		catch (NoSuchCategoryRegistrationException nsee) {
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
	protected CategoryRegistration removeImpl(
		CategoryRegistration categoryRegistration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(categoryRegistration)) {
				categoryRegistration = (CategoryRegistration)session.get(CategoryRegistrationImpl.class,
						categoryRegistration.getPrimaryKeyObj());
			}

			if (categoryRegistration != null) {
				session.delete(categoryRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (categoryRegistration != null) {
			clearCache(categoryRegistration);
		}

		return categoryRegistration;
	}

	@Override
	public CategoryRegistration updateImpl(
		CategoryRegistration categoryRegistration) {
		boolean isNew = categoryRegistration.isNew();

		if (!(categoryRegistration instanceof CategoryRegistrationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(categoryRegistration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(categoryRegistration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in categoryRegistration proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CategoryRegistration implementation " +
				categoryRegistration.getClass());
		}

		CategoryRegistrationModelImpl categoryRegistrationModelImpl = (CategoryRegistrationModelImpl)categoryRegistration;

		if (Validator.isNull(categoryRegistration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			categoryRegistration.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (categoryRegistration.isNew()) {
				session.save(categoryRegistration);

				categoryRegistration.setNew(false);
			}
			else {
				categoryRegistration = (CategoryRegistration)session.merge(categoryRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CategoryRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { categoryRegistrationModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((categoryRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						categoryRegistrationModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { categoryRegistrationModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			CategoryRegistrationImpl.class,
			categoryRegistration.getPrimaryKey(), categoryRegistration, false);

		categoryRegistration.resetOriginalValues();

		return categoryRegistration;
	}

	/**
	 * Returns the category registration with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category registration
	 * @return the category registration
	 * @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryRegistrationException {
		CategoryRegistration categoryRegistration = fetchByPrimaryKey(primaryKey);

		if (categoryRegistration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return categoryRegistration;
	}

	/**
	 * Returns the category registration with the primary key or throws a {@link NoSuchCategoryRegistrationException} if it could not be found.
	 *
	 * @param CATEGORY_ID the primary key of the category registration
	 * @return the category registration
	 * @throws NoSuchCategoryRegistrationException if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration findByPrimaryKey(long CATEGORY_ID)
		throws NoSuchCategoryRegistrationException {
		return findByPrimaryKey((Serializable)CATEGORY_ID);
	}

	/**
	 * Returns the category registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category registration
	 * @return the category registration, or <code>null</code> if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				CategoryRegistrationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CategoryRegistration categoryRegistration = (CategoryRegistration)serializable;

		if (categoryRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				categoryRegistration = (CategoryRegistration)session.get(CategoryRegistrationImpl.class,
						primaryKey);

				if (categoryRegistration != null) {
					cacheResult(categoryRegistration);
				}
				else {
					entityCache.putResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						CategoryRegistrationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CategoryRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return categoryRegistration;
	}

	/**
	 * Returns the category registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param CATEGORY_ID the primary key of the category registration
	 * @return the category registration, or <code>null</code> if a category registration with the primary key could not be found
	 */
	@Override
	public CategoryRegistration fetchByPrimaryKey(long CATEGORY_ID) {
		return fetchByPrimaryKey((Serializable)CATEGORY_ID);
	}

	@Override
	public Map<Serializable, CategoryRegistration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CategoryRegistration> map = new HashMap<Serializable, CategoryRegistration>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CategoryRegistration categoryRegistration = fetchByPrimaryKey(primaryKey);

			if (categoryRegistration != null) {
				map.put(primaryKey, categoryRegistration);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CategoryRegistrationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CategoryRegistration)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CATEGORYREGISTRATION_WHERE_PKS_IN);

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

			for (CategoryRegistration categoryRegistration : (List<CategoryRegistration>)q.list()) {
				map.put(categoryRegistration.getPrimaryKeyObj(),
					categoryRegistration);

				cacheResult(categoryRegistration);

				uncachedPrimaryKeys.remove(categoryRegistration.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CategoryRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					CategoryRegistrationImpl.class, primaryKey, nullModel);
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
	 * Returns all the category registrations.
	 *
	 * @return the category registrations
	 */
	@Override
	public List<CategoryRegistration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of category registrations
	 * @param end the upper bound of the range of category registrations (not inclusive)
	 * @return the range of category registrations
	 */
	@Override
	public List<CategoryRegistration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the category registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of category registrations
	 * @param end the upper bound of the range of category registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category registrations
	 */
	@Override
	public List<CategoryRegistration> findAll(int start, int end,
		OrderByComparator<CategoryRegistration> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the category registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of category registrations
	 * @param end the upper bound of the range of category registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of category registrations
	 */
	@Override
	public List<CategoryRegistration> findAll(int start, int end,
		OrderByComparator<CategoryRegistration> orderByComparator,
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

		List<CategoryRegistration> list = null;

		if (retrieveFromCache) {
			list = (List<CategoryRegistration>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CATEGORYREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYREGISTRATION;

				if (pagination) {
					sql = sql.concat(CategoryRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CategoryRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CategoryRegistration>)QueryUtil.list(q,
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
	 * Removes all the category registrations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CategoryRegistration categoryRegistration : findAll()) {
			remove(categoryRegistration);
		}
	}

	/**
	 * Returns the number of category registrations.
	 *
	 * @return the number of category registrations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORYREGISTRATION);

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
		return CategoryRegistrationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category registration persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CategoryRegistrationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_CATEGORYREGISTRATION = "SELECT categoryRegistration FROM CategoryRegistration categoryRegistration";
	private static final String _SQL_SELECT_CATEGORYREGISTRATION_WHERE_PKS_IN = "SELECT categoryRegistration FROM CategoryRegistration categoryRegistration WHERE CATEGORY_ID IN (";
	private static final String _SQL_SELECT_CATEGORYREGISTRATION_WHERE = "SELECT categoryRegistration FROM CategoryRegistration categoryRegistration WHERE ";
	private static final String _SQL_COUNT_CATEGORYREGISTRATION = "SELECT COUNT(categoryRegistration) FROM CategoryRegistration categoryRegistration";
	private static final String _SQL_COUNT_CATEGORYREGISTRATION_WHERE = "SELECT COUNT(categoryRegistration) FROM CategoryRegistration categoryRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoryRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CategoryRegistration exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CategoryRegistrationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}