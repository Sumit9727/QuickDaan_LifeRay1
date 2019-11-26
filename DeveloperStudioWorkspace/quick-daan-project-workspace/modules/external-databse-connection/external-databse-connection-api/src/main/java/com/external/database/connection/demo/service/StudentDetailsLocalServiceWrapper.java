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

package com.external.database.connection.demo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetailsLocalService
 * @generated
 */
@ProviderType
public class StudentDetailsLocalServiceWrapper
	implements StudentDetailsLocalService,
		ServiceWrapper<StudentDetailsLocalService> {
	public StudentDetailsLocalServiceWrapper(
		StudentDetailsLocalService studentDetailsLocalService) {
		_studentDetailsLocalService = studentDetailsLocalService;
	}

	@Override
	public com.external.database.connection.demo.model.StudentDetails addStudentDetails(
		String name, String email, String contactNo,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _studentDetailsLocalService.addStudentDetails(name, email,
			contactNo, serviceContext);
	}

	/**
	* Adds the student details to the database. Also notifies the appropriate model listeners.
	*
	* @param studentDetails the student details
	* @return the student details that was added
	*/
	@Override
	public com.external.database.connection.demo.model.StudentDetails addStudentDetails(
		com.external.database.connection.demo.model.StudentDetails studentDetails) {
		return _studentDetailsLocalService.addStudentDetails(studentDetails);
	}

	/**
	* Creates a new student details with the primary key. Does not add the student details to the database.
	*
	* @param studentId the primary key for the new student details
	* @return the new student details
	*/
	@Override
	public com.external.database.connection.demo.model.StudentDetails createStudentDetails(
		long studentId) {
		return _studentDetailsLocalService.createStudentDetails(studentId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentDetailsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the student details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student details
	* @return the student details that was removed
	* @throws PortalException if a student details with the primary key could not be found
	*/
	@Override
	public com.external.database.connection.demo.model.StudentDetails deleteStudentDetails(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentDetailsLocalService.deleteStudentDetails(studentId);
	}

	/**
	* Deletes the student details from the database. Also notifies the appropriate model listeners.
	*
	* @param studentDetails the student details
	* @return the student details that was removed
	*/
	@Override
	public com.external.database.connection.demo.model.StudentDetails deleteStudentDetails(
		com.external.database.connection.demo.model.StudentDetails studentDetails) {
		return _studentDetailsLocalService.deleteStudentDetails(studentDetails);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentDetailsLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _studentDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.external.database.connection.demo.model.impl.StudentDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _studentDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.external.database.connection.demo.model.impl.StudentDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _studentDetailsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _studentDetailsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _studentDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.external.database.connection.demo.model.StudentDetails fetchStudentDetails(
		long studentId) {
		return _studentDetailsLocalService.fetchStudentDetails(studentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _studentDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _studentDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the student details with the primary key.
	*
	* @param studentId the primary key of the student details
	* @return the student details
	* @throws PortalException if a student details with the primary key could not be found
	*/
	@Override
	public com.external.database.connection.demo.model.StudentDetails getStudentDetails(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _studentDetailsLocalService.getStudentDetails(studentId);
	}

	/**
	* Returns a range of all the student detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.external.database.connection.demo.model.impl.StudentDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student detailses
	* @param end the upper bound of the range of student detailses (not inclusive)
	* @return the range of student detailses
	*/
	@Override
	public java.util.List<com.external.database.connection.demo.model.StudentDetails> getStudentDetailses(
		int start, int end) {
		return _studentDetailsLocalService.getStudentDetailses(start, end);
	}

	/**
	* Returns the number of student detailses.
	*
	* @return the number of student detailses
	*/
	@Override
	public int getStudentDetailsesCount() {
		return _studentDetailsLocalService.getStudentDetailsesCount();
	}

	/**
	* Updates the student details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentDetails the student details
	* @return the student details that was updated
	*/
	@Override
	public com.external.database.connection.demo.model.StudentDetails updateStudentDetails(
		com.external.database.connection.demo.model.StudentDetails studentDetails) {
		return _studentDetailsLocalService.updateStudentDetails(studentDetails);
	}

	@Override
	public StudentDetailsLocalService getWrappedService() {
		return _studentDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		StudentDetailsLocalService studentDetailsLocalService) {
		_studentDetailsLocalService = studentDetailsLocalService;
	}

	private StudentDetailsLocalService _studentDetailsLocalService;
}