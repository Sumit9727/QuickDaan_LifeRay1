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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StudentDetails. This utility wraps
 * {@link com.external.database.connection.demo.service.impl.StudentDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetailsLocalService
 * @see com.external.database.connection.demo.service.base.StudentDetailsLocalServiceBaseImpl
 * @see com.external.database.connection.demo.service.impl.StudentDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class StudentDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.external.database.connection.demo.service.impl.StudentDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.external.database.connection.demo.model.StudentDetails addStudentDetails(
		String name, String email, String contactNo,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return getService()
				   .addStudentDetails(name, email, contactNo, serviceContext);
	}

	/**
	* Adds the student details to the database. Also notifies the appropriate model listeners.
	*
	* @param studentDetails the student details
	* @return the student details that was added
	*/
	public static com.external.database.connection.demo.model.StudentDetails addStudentDetails(
		com.external.database.connection.demo.model.StudentDetails studentDetails) {
		return getService().addStudentDetails(studentDetails);
	}

	/**
	* Creates a new student details with the primary key. Does not add the student details to the database.
	*
	* @param studentId the primary key for the new student details
	* @return the new student details
	*/
	public static com.external.database.connection.demo.model.StudentDetails createStudentDetails(
		long studentId) {
		return getService().createStudentDetails(studentId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the student details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student details
	* @return the student details that was removed
	* @throws PortalException if a student details with the primary key could not be found
	*/
	public static com.external.database.connection.demo.model.StudentDetails deleteStudentDetails(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStudentDetails(studentId);
	}

	/**
	* Deletes the student details from the database. Also notifies the appropriate model listeners.
	*
	* @param studentDetails the student details
	* @return the student details that was removed
	*/
	public static com.external.database.connection.demo.model.StudentDetails deleteStudentDetails(
		com.external.database.connection.demo.model.StudentDetails studentDetails) {
		return getService().deleteStudentDetails(studentDetails);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.external.database.connection.demo.model.StudentDetails fetchStudentDetails(
		long studentId) {
		return getService().fetchStudentDetails(studentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the student details with the primary key.
	*
	* @param studentId the primary key of the student details
	* @return the student details
	* @throws PortalException if a student details with the primary key could not be found
	*/
	public static com.external.database.connection.demo.model.StudentDetails getStudentDetails(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStudentDetails(studentId);
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
	public static java.util.List<com.external.database.connection.demo.model.StudentDetails> getStudentDetailses(
		int start, int end) {
		return getService().getStudentDetailses(start, end);
	}

	/**
	* Returns the number of student detailses.
	*
	* @return the number of student detailses
	*/
	public static int getStudentDetailsesCount() {
		return getService().getStudentDetailsesCount();
	}

	/**
	* Updates the student details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentDetails the student details
	* @return the student details that was updated
	*/
	public static com.external.database.connection.demo.model.StudentDetails updateStudentDetails(
		com.external.database.connection.demo.model.StudentDetails studentDetails) {
		return getService().updateStudentDetails(studentDetails);
	}

	public static StudentDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StudentDetailsLocalService, StudentDetailsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StudentDetailsLocalService.class);

		ServiceTracker<StudentDetailsLocalService, StudentDetailsLocalService> serviceTracker =
			new ServiceTracker<StudentDetailsLocalService, StudentDetailsLocalService>(bundle.getBundleContext(),
				StudentDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}