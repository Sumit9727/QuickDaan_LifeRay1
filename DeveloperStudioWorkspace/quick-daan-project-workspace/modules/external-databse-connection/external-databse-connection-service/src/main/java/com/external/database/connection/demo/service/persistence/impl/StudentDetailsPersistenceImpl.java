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

package com.external.database.connection.demo.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.external.database.connection.demo.exception.NoSuchStudentDetailsException;
import com.external.database.connection.demo.model.StudentDetails;
import com.external.database.connection.demo.model.impl.StudentDetailsImpl;
import com.external.database.connection.demo.model.impl.StudentDetailsModelImpl;
import com.external.database.connection.demo.service.persistence.StudentDetailsPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the student details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetailsPersistence
 * @see com.external.database.connection.demo.service.persistence.StudentDetailsUtil
 * @generated
 */
@ProviderType
public class StudentDetailsPersistenceImpl extends BasePersistenceImpl<StudentDetails>
	implements StudentDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentDetailsUtil} to access the student details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
			StudentDetailsModelImpl.FINDER_CACHE_ENABLED,
			StudentDetailsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
			StudentDetailsModelImpl.FINDER_CACHE_ENABLED,
			StudentDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
			StudentDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StudentDetailsPersistenceImpl() {
		setModelClass(StudentDetails.class);
	}

	/**
	 * Caches the student details in the entity cache if it is enabled.
	 *
	 * @param studentDetails the student details
	 */
	@Override
	public void cacheResult(StudentDetails studentDetails) {
		entityCache.putResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
			StudentDetailsImpl.class, studentDetails.getPrimaryKey(),
			studentDetails);

		studentDetails.resetOriginalValues();
	}

	/**
	 * Caches the student detailses in the entity cache if it is enabled.
	 *
	 * @param studentDetailses the student detailses
	 */
	@Override
	public void cacheResult(List<StudentDetails> studentDetailses) {
		for (StudentDetails studentDetails : studentDetailses) {
			if (entityCache.getResult(
						StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
						StudentDetailsImpl.class, studentDetails.getPrimaryKey()) == null) {
				cacheResult(studentDetails);
			}
			else {
				studentDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all student detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudentDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StudentDetails studentDetails) {
		entityCache.removeResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
			StudentDetailsImpl.class, studentDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StudentDetails> studentDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StudentDetails studentDetails : studentDetailses) {
			entityCache.removeResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
				StudentDetailsImpl.class, studentDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student details with the primary key. Does not add the student details to the database.
	 *
	 * @param studentId the primary key for the new student details
	 * @return the new student details
	 */
	@Override
	public StudentDetails create(long studentId) {
		StudentDetails studentDetails = new StudentDetailsImpl();

		studentDetails.setNew(true);
		studentDetails.setPrimaryKey(studentId);

		studentDetails.setCompanyId(companyProvider.getCompanyId());

		return studentDetails;
	}

	/**
	 * Removes the student details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student details
	 * @return the student details that was removed
	 * @throws NoSuchStudentDetailsException if a student details with the primary key could not be found
	 */
	@Override
	public StudentDetails remove(long studentId)
		throws NoSuchStudentDetailsException {
		return remove((Serializable)studentId);
	}

	/**
	 * Removes the student details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student details
	 * @return the student details that was removed
	 * @throws NoSuchStudentDetailsException if a student details with the primary key could not be found
	 */
	@Override
	public StudentDetails remove(Serializable primaryKey)
		throws NoSuchStudentDetailsException {
		Session session = null;

		try {
			session = openSession();

			StudentDetails studentDetails = (StudentDetails)session.get(StudentDetailsImpl.class,
					primaryKey);

			if (studentDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(studentDetails);
		}
		catch (NoSuchStudentDetailsException nsee) {
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
	protected StudentDetails removeImpl(StudentDetails studentDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studentDetails)) {
				studentDetails = (StudentDetails)session.get(StudentDetailsImpl.class,
						studentDetails.getPrimaryKeyObj());
			}

			if (studentDetails != null) {
				session.delete(studentDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (studentDetails != null) {
			clearCache(studentDetails);
		}

		return studentDetails;
	}

	@Override
	public StudentDetails updateImpl(StudentDetails studentDetails) {
		boolean isNew = studentDetails.isNew();

		if (!(studentDetails instanceof StudentDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(studentDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(studentDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in studentDetails proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StudentDetails implementation " +
				studentDetails.getClass());
		}

		StudentDetailsModelImpl studentDetailsModelImpl = (StudentDetailsModelImpl)studentDetails;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (studentDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				studentDetails.setCreateDate(now);
			}
			else {
				studentDetails.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!studentDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				studentDetails.setModifiedDate(now);
			}
			else {
				studentDetails.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (studentDetails.isNew()) {
				session.save(studentDetails);

				studentDetails.setNew(false);
			}
			else {
				studentDetails = (StudentDetails)session.merge(studentDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
			StudentDetailsImpl.class, studentDetails.getPrimaryKey(),
			studentDetails, false);

		studentDetails.resetOriginalValues();

		return studentDetails;
	}

	/**
	 * Returns the student details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student details
	 * @return the student details
	 * @throws NoSuchStudentDetailsException if a student details with the primary key could not be found
	 */
	@Override
	public StudentDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentDetailsException {
		StudentDetails studentDetails = fetchByPrimaryKey(primaryKey);

		if (studentDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return studentDetails;
	}

	/**
	 * Returns the student details with the primary key or throws a {@link NoSuchStudentDetailsException} if it could not be found.
	 *
	 * @param studentId the primary key of the student details
	 * @return the student details
	 * @throws NoSuchStudentDetailsException if a student details with the primary key could not be found
	 */
	@Override
	public StudentDetails findByPrimaryKey(long studentId)
		throws NoSuchStudentDetailsException {
		return findByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns the student details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student details
	 * @return the student details, or <code>null</code> if a student details with the primary key could not be found
	 */
	@Override
	public StudentDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
				StudentDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StudentDetails studentDetails = (StudentDetails)serializable;

		if (studentDetails == null) {
			Session session = null;

			try {
				session = openSession();

				studentDetails = (StudentDetails)session.get(StudentDetailsImpl.class,
						primaryKey);

				if (studentDetails != null) {
					cacheResult(studentDetails);
				}
				else {
					entityCache.putResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
						StudentDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
					StudentDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return studentDetails;
	}

	/**
	 * Returns the student details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student details
	 * @return the student details, or <code>null</code> if a student details with the primary key could not be found
	 */
	@Override
	public StudentDetails fetchByPrimaryKey(long studentId) {
		return fetchByPrimaryKey((Serializable)studentId);
	}

	@Override
	public Map<Serializable, StudentDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StudentDetails> map = new HashMap<Serializable, StudentDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StudentDetails studentDetails = fetchByPrimaryKey(primaryKey);

			if (studentDetails != null) {
				map.put(primaryKey, studentDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
					StudentDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StudentDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STUDENTDETAILS_WHERE_PKS_IN);

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

			for (StudentDetails studentDetails : (List<StudentDetails>)q.list()) {
				map.put(studentDetails.getPrimaryKeyObj(), studentDetails);

				cacheResult(studentDetails);

				uncachedPrimaryKeys.remove(studentDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StudentDetailsModelImpl.ENTITY_CACHE_ENABLED,
					StudentDetailsImpl.class, primaryKey, nullModel);
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
	 * Returns all the student detailses.
	 *
	 * @return the student detailses
	 */
	@Override
	public List<StudentDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the student detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student detailses
	 * @param end the upper bound of the range of student detailses (not inclusive)
	 * @return the range of student detailses
	 */
	@Override
	public List<StudentDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the student detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student detailses
	 * @param end the upper bound of the range of student detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of student detailses
	 */
	@Override
	public List<StudentDetails> findAll(int start, int end,
		OrderByComparator<StudentDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the student detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StudentDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of student detailses
	 * @param end the upper bound of the range of student detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of student detailses
	 */
	@Override
	public List<StudentDetails> findAll(int start, int end,
		OrderByComparator<StudentDetails> orderByComparator,
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

		List<StudentDetails> list = null;

		if (retrieveFromCache) {
			list = (List<StudentDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STUDENTDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENTDETAILS;

				if (pagination) {
					sql = sql.concat(StudentDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StudentDetails>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StudentDetails>)QueryUtil.list(q,
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
	 * Removes all the student detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StudentDetails studentDetails : findAll()) {
			remove(studentDetails);
		}
	}

	/**
	 * Returns the number of student detailses.
	 *
	 * @return the number of student detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENTDETAILS);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return StudentDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the student details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StudentDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STUDENTDETAILS = "SELECT studentDetails FROM StudentDetails studentDetails";
	private static final String _SQL_SELECT_STUDENTDETAILS_WHERE_PKS_IN = "SELECT studentDetails FROM StudentDetails studentDetails WHERE studentId IN (";
	private static final String _SQL_COUNT_STUDENTDETAILS = "SELECT COUNT(studentDetails) FROM StudentDetails studentDetails";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studentDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudentDetails exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(StudentDetailsPersistenceImpl.class);
}