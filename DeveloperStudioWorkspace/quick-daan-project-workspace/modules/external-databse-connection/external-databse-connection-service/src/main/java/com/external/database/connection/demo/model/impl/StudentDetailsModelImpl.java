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

package com.external.database.connection.demo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.external.database.connection.demo.model.StudentDetails;
import com.external.database.connection.demo.model.StudentDetailsModel;
import com.external.database.connection.demo.model.StudentDetailsSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the StudentDetails service. Represents a row in the &quot;ext_student_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StudentDetailsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentDetailsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetailsImpl
 * @see StudentDetails
 * @see StudentDetailsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class StudentDetailsModelImpl extends BaseModelImpl<StudentDetails>
	implements StudentDetailsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student details model instance should use the {@link StudentDetails} interface instead.
	 */
	public static final String TABLE_NAME = "ext_student_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "studentId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "contactno", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("studentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactno", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table ext_student_details (companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,studentId LONG not null primary key,name VARCHAR(75) null,email VARCHAR(75) null,contactno VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table ext_student_details";
	public static final String ORDER_BY_JPQL = " ORDER BY studentDetails.studentId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ext_student_details.studentId ASC";
	public static final String DATA_SOURCE = "extDataSource";
	public static final String SESSION_FACTORY = "extDataSourceSessionFactory";
	public static final String TX_MANAGER = "extDataSourceTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.external.database.connection.demo.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.external.database.connection.demo.model.StudentDetails"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.external.database.connection.demo.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.external.database.connection.demo.model.StudentDetails"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static StudentDetails toModel(StudentDetailsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		StudentDetails model = new StudentDetailsImpl();

		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStudentId(soapModel.getStudentId());
		model.setName(soapModel.getName());
		model.setEmail(soapModel.getEmail());
		model.setContactno(soapModel.getContactno());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<StudentDetails> toModels(StudentDetailsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<StudentDetails> models = new ArrayList<StudentDetails>(soapModels.length);

		for (StudentDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.external.database.connection.demo.service.util.ServiceProps.get(
				"lock.expiration.time.com.external.database.connection.demo.model.StudentDetails"));

	public StudentDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _studentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getContactno() {
		if (_contactno == null) {
			return "";
		}
		else {
			return _contactno;
		}
	}

	@Override
	public void setContactno(String contactno) {
		_contactno = contactno;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			StudentDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StudentDetails toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StudentDetails)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StudentDetailsImpl studentDetailsImpl = new StudentDetailsImpl();

		studentDetailsImpl.setCompanyId(getCompanyId());
		studentDetailsImpl.setGroupId(getGroupId());
		studentDetailsImpl.setUserId(getUserId());
		studentDetailsImpl.setUserName(getUserName());
		studentDetailsImpl.setCreateDate(getCreateDate());
		studentDetailsImpl.setModifiedDate(getModifiedDate());
		studentDetailsImpl.setStudentId(getStudentId());
		studentDetailsImpl.setName(getName());
		studentDetailsImpl.setEmail(getEmail());
		studentDetailsImpl.setContactno(getContactno());

		studentDetailsImpl.resetOriginalValues();

		return studentDetailsImpl;
	}

	@Override
	public int compareTo(StudentDetails studentDetails) {
		long primaryKey = studentDetails.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentDetails)) {
			return false;
		}

		StudentDetails studentDetails = (StudentDetails)obj;

		long primaryKey = studentDetails.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		StudentDetailsModelImpl studentDetailsModelImpl = this;

		studentDetailsModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<StudentDetails> toCacheModel() {
		StudentDetailsCacheModel studentDetailsCacheModel = new StudentDetailsCacheModel();

		studentDetailsCacheModel.companyId = getCompanyId();

		studentDetailsCacheModel.groupId = getGroupId();

		studentDetailsCacheModel.userId = getUserId();

		studentDetailsCacheModel.userName = getUserName();

		String userName = studentDetailsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			studentDetailsCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			studentDetailsCacheModel.createDate = createDate.getTime();
		}
		else {
			studentDetailsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			studentDetailsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			studentDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		studentDetailsCacheModel.studentId = getStudentId();

		studentDetailsCacheModel.name = getName();

		String name = studentDetailsCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			studentDetailsCacheModel.name = null;
		}

		studentDetailsCacheModel.email = getEmail();

		String email = studentDetailsCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			studentDetailsCacheModel.email = null;
		}

		studentDetailsCacheModel.contactno = getContactno();

		String contactno = studentDetailsCacheModel.contactno;

		if ((contactno != null) && (contactno.length() == 0)) {
			studentDetailsCacheModel.contactno = null;
		}

		return studentDetailsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", studentId=");
		sb.append(getStudentId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", contactno=");
		sb.append(getContactno());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.external.database.connection.demo.model.StudentDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactno</column-name><column-value><![CDATA[");
		sb.append(getContactno());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = StudentDetails.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			StudentDetails.class, ModelWrapper.class
		};
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _studentId;
	private String _name;
	private String _email;
	private String _contactno;
	private StudentDetails _escapedModel;
}