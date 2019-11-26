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

package com.external.database.connection.demo.service.impl;

import com.external.database.connection.demo.model.StudentDetails;
import com.external.database.connection.demo.service.StudentDetailsLocalService;
import com.external.database.connection.demo.service.base.StudentDetailsLocalServiceBaseImpl;
import com.external.database.connection.demo.service.persistence.StudentDetailsPersistence;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the student details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.external.database.connection.demo.service.StudentDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetailsLocalServiceBaseImpl
 * @see com.external.database.connection.demo.service.StudentDetailsLocalServiceUtil
 */
public class StudentDetailsLocalServiceImpl
	extends StudentDetailsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.external.database.connection.demo.service.StudentDetailsLocalServiceUtil} to access the student details local service.
	 */
	
	public StudentDetails addStudentDetails(String name, String email, String contactNo, ServiceContext serviceContext) {
		
		StudentDetails details = studentDetailsPersistence.create(counterLocalService.increment(StudentDetails.class.getName()));
		details.setGroupId(serviceContext.getScopeGroupId());
		details.setCompanyId(serviceContext.getCompanyId());
		details.setUserId(serviceContext.getUserId());
		
		
		details.setUserName(userLocalService.fetchUser(serviceContext.getUserId()).getFullName());
		details.setCreateDate(new Date());
		details.setModifiedDate(new Date());
		details.setName(name);
		details.setEmail(email);
		details.setContactno(contactNo);
		studentDetailsLocalService.addStudentDetails(details);
		
		
		return details;
		
	}
}