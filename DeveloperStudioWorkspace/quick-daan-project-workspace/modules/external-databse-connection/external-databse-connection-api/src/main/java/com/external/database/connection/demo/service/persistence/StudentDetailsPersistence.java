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

package com.external.database.connection.demo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.external.database.connection.demo.exception.NoSuchStudentDetailsException;
import com.external.database.connection.demo.model.StudentDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the student details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.external.database.connection.demo.service.persistence.impl.StudentDetailsPersistenceImpl
 * @see StudentDetailsUtil
 * @generated
 */
@ProviderType
public interface StudentDetailsPersistence extends BasePersistence<StudentDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentDetailsUtil} to access the student details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the student details in the entity cache if it is enabled.
	*
	* @param studentDetails the student details
	*/
	public void cacheResult(StudentDetails studentDetails);

	/**
	* Caches the student detailses in the entity cache if it is enabled.
	*
	* @param studentDetailses the student detailses
	*/
	public void cacheResult(java.util.List<StudentDetails> studentDetailses);

	/**
	* Creates a new student details with the primary key. Does not add the student details to the database.
	*
	* @param studentId the primary key for the new student details
	* @return the new student details
	*/
	public StudentDetails create(long studentId);

	/**
	* Removes the student details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student details
	* @return the student details that was removed
	* @throws NoSuchStudentDetailsException if a student details with the primary key could not be found
	*/
	public StudentDetails remove(long studentId)
		throws NoSuchStudentDetailsException;

	public StudentDetails updateImpl(StudentDetails studentDetails);

	/**
	* Returns the student details with the primary key or throws a {@link NoSuchStudentDetailsException} if it could not be found.
	*
	* @param studentId the primary key of the student details
	* @return the student details
	* @throws NoSuchStudentDetailsException if a student details with the primary key could not be found
	*/
	public StudentDetails findByPrimaryKey(long studentId)
		throws NoSuchStudentDetailsException;

	/**
	* Returns the student details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student details
	* @return the student details, or <code>null</code> if a student details with the primary key could not be found
	*/
	public StudentDetails fetchByPrimaryKey(long studentId);

	@Override
	public java.util.Map<java.io.Serializable, StudentDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the student detailses.
	*
	* @return the student detailses
	*/
	public java.util.List<StudentDetails> findAll();

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
	public java.util.List<StudentDetails> findAll(int start, int end);

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
	public java.util.List<StudentDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentDetails> orderByComparator);

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
	public java.util.List<StudentDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StudentDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the student detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of student detailses.
	*
	* @return the number of student detailses
	*/
	public int countAll();
}