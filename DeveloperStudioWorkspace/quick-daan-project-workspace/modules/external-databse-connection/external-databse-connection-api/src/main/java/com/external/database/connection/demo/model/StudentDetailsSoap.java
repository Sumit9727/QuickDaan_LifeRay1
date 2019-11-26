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

package com.external.database.connection.demo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.external.database.connection.demo.service.http.StudentDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.external.database.connection.demo.service.http.StudentDetailsServiceSoap
 * @generated
 */
@ProviderType
public class StudentDetailsSoap implements Serializable {
	public static StudentDetailsSoap toSoapModel(StudentDetails model) {
		StudentDetailsSoap soapModel = new StudentDetailsSoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setContactno(model.getContactno());

		return soapModel;
	}

	public static StudentDetailsSoap[] toSoapModels(StudentDetails[] models) {
		StudentDetailsSoap[] soapModels = new StudentDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentDetailsSoap[][] toSoapModels(StudentDetails[][] models) {
		StudentDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentDetailsSoap[] toSoapModels(List<StudentDetails> models) {
		List<StudentDetailsSoap> soapModels = new ArrayList<StudentDetailsSoap>(models.size());

		for (StudentDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentDetailsSoap[soapModels.size()]);
	}

	public StudentDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getContactno() {
		return _contactno;
	}

	public void setContactno(String contactno) {
		_contactno = contactno;
	}

	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _studentId;
	private String _name;
	private String _email;
	private String _contactno;
}