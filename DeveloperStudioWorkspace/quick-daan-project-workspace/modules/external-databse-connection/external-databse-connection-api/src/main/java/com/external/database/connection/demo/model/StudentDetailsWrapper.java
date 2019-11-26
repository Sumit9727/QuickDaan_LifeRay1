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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link StudentDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetails
 * @generated
 */
@ProviderType
public class StudentDetailsWrapper implements StudentDetails,
	ModelWrapper<StudentDetails> {
	public StudentDetailsWrapper(StudentDetails studentDetails) {
		_studentDetails = studentDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return StudentDetails.class;
	}

	@Override
	public String getModelClassName() {
		return StudentDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("studentId", getStudentId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("contactno", getContactno());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String contactno = (String)attributes.get("contactno");

		if (contactno != null) {
			setContactno(contactno);
		}
	}

	@Override
	public Object clone() {
		return new StudentDetailsWrapper((StudentDetails)_studentDetails.clone());
	}

	@Override
	public int compareTo(StudentDetails studentDetails) {
		return _studentDetails.compareTo(studentDetails);
	}

	/**
	* Returns the company ID of this student details.
	*
	* @return the company ID of this student details
	*/
	@Override
	public long getCompanyId() {
		return _studentDetails.getCompanyId();
	}

	/**
	* Returns the contactno of this student details.
	*
	* @return the contactno of this student details
	*/
	@Override
	public String getContactno() {
		return _studentDetails.getContactno();
	}

	/**
	* Returns the create date of this student details.
	*
	* @return the create date of this student details
	*/
	@Override
	public Date getCreateDate() {
		return _studentDetails.getCreateDate();
	}

	/**
	* Returns the email of this student details.
	*
	* @return the email of this student details
	*/
	@Override
	public String getEmail() {
		return _studentDetails.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _studentDetails.getExpandoBridge();
	}

	/**
	* Returns the group ID of this student details.
	*
	* @return the group ID of this student details
	*/
	@Override
	public long getGroupId() {
		return _studentDetails.getGroupId();
	}

	/**
	* Returns the modified date of this student details.
	*
	* @return the modified date of this student details
	*/
	@Override
	public Date getModifiedDate() {
		return _studentDetails.getModifiedDate();
	}

	/**
	* Returns the name of this student details.
	*
	* @return the name of this student details
	*/
	@Override
	public String getName() {
		return _studentDetails.getName();
	}

	/**
	* Returns the primary key of this student details.
	*
	* @return the primary key of this student details
	*/
	@Override
	public long getPrimaryKey() {
		return _studentDetails.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentDetails.getPrimaryKeyObj();
	}

	/**
	* Returns the student ID of this student details.
	*
	* @return the student ID of this student details
	*/
	@Override
	public long getStudentId() {
		return _studentDetails.getStudentId();
	}

	/**
	* Returns the user ID of this student details.
	*
	* @return the user ID of this student details
	*/
	@Override
	public long getUserId() {
		return _studentDetails.getUserId();
	}

	/**
	* Returns the user name of this student details.
	*
	* @return the user name of this student details
	*/
	@Override
	public String getUserName() {
		return _studentDetails.getUserName();
	}

	/**
	* Returns the user uuid of this student details.
	*
	* @return the user uuid of this student details
	*/
	@Override
	public String getUserUuid() {
		return _studentDetails.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _studentDetails.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _studentDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _studentDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _studentDetails.isNew();
	}

	@Override
	public void persist() {
		_studentDetails.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studentDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this student details.
	*
	* @param companyId the company ID of this student details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_studentDetails.setCompanyId(companyId);
	}

	/**
	* Sets the contactno of this student details.
	*
	* @param contactno the contactno of this student details
	*/
	@Override
	public void setContactno(String contactno) {
		_studentDetails.setContactno(contactno);
	}

	/**
	* Sets the create date of this student details.
	*
	* @param createDate the create date of this student details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_studentDetails.setCreateDate(createDate);
	}

	/**
	* Sets the email of this student details.
	*
	* @param email the email of this student details
	*/
	@Override
	public void setEmail(String email) {
		_studentDetails.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_studentDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_studentDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_studentDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this student details.
	*
	* @param groupId the group ID of this student details
	*/
	@Override
	public void setGroupId(long groupId) {
		_studentDetails.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this student details.
	*
	* @param modifiedDate the modified date of this student details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_studentDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this student details.
	*
	* @param name the name of this student details
	*/
	@Override
	public void setName(String name) {
		_studentDetails.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_studentDetails.setNew(n);
	}

	/**
	* Sets the primary key of this student details.
	*
	* @param primaryKey the primary key of this student details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_studentDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_studentDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the student ID of this student details.
	*
	* @param studentId the student ID of this student details
	*/
	@Override
	public void setStudentId(long studentId) {
		_studentDetails.setStudentId(studentId);
	}

	/**
	* Sets the user ID of this student details.
	*
	* @param userId the user ID of this student details
	*/
	@Override
	public void setUserId(long userId) {
		_studentDetails.setUserId(userId);
	}

	/**
	* Sets the user name of this student details.
	*
	* @param userName the user name of this student details
	*/
	@Override
	public void setUserName(String userName) {
		_studentDetails.setUserName(userName);
	}

	/**
	* Sets the user uuid of this student details.
	*
	* @param userUuid the user uuid of this student details
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_studentDetails.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<StudentDetails> toCacheModel() {
		return _studentDetails.toCacheModel();
	}

	@Override
	public StudentDetails toEscapedModel() {
		return new StudentDetailsWrapper(_studentDetails.toEscapedModel());
	}

	@Override
	public String toString() {
		return _studentDetails.toString();
	}

	@Override
	public StudentDetails toUnescapedModel() {
		return new StudentDetailsWrapper(_studentDetails.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _studentDetails.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentDetailsWrapper)) {
			return false;
		}

		StudentDetailsWrapper studentDetailsWrapper = (StudentDetailsWrapper)obj;

		if (Objects.equals(_studentDetails,
					studentDetailsWrapper._studentDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public StudentDetails getWrappedModel() {
		return _studentDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _studentDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _studentDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_studentDetails.resetOriginalValues();
	}

	private final StudentDetails _studentDetails;
}