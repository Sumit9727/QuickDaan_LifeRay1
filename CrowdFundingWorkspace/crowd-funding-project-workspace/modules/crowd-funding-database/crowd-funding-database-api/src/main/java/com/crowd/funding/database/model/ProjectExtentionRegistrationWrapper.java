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

package com.crowd.funding.database.model;

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
 * This class is a wrapper for {@link ProjectExtentionRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectExtentionRegistration
 * @generated
 */
@ProviderType
public class ProjectExtentionRegistrationWrapper
	implements ProjectExtentionRegistration,
		ModelWrapper<ProjectExtentionRegistration> {
	public ProjectExtentionRegistrationWrapper(
		ProjectExtentionRegistration projectExtentionRegistration) {
		_projectExtentionRegistration = projectExtentionRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectExtentionRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectExtentionRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_EXTENTION_ID", getPROJECT_EXTENTION_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("EXTENTION_DATE", getEXTENTION_DATE());
		attributes.put("COMMENT", getCOMMENT());
		attributes.put("STATUS", getSTATUS());
		attributes.put("DATE", getDATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_EXTENTION_ID = (Long)attributes.get("PROJECT_EXTENTION_ID");

		if (PROJECT_EXTENTION_ID != null) {
			setPROJECT_EXTENTION_ID(PROJECT_EXTENTION_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Date EXTENTION_DATE = (Date)attributes.get("EXTENTION_DATE");

		if (EXTENTION_DATE != null) {
			setEXTENTION_DATE(EXTENTION_DATE);
		}

		String COMMENT = (String)attributes.get("COMMENT");

		if (COMMENT != null) {
			setCOMMENT(COMMENT);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	@Override
	public Object clone() {
		return new ProjectExtentionRegistrationWrapper((ProjectExtentionRegistration)_projectExtentionRegistration.clone());
	}

	@Override
	public int compareTo(
		ProjectExtentionRegistration projectExtentionRegistration) {
		return _projectExtentionRegistration.compareTo(projectExtentionRegistration);
	}

	/**
	* Returns the comment of this project extention registration.
	*
	* @return the comment of this project extention registration
	*/
	@Override
	public String getCOMMENT() {
		return _projectExtentionRegistration.getCOMMENT();
	}

	/**
	* Returns the date of this project extention registration.
	*
	* @return the date of this project extention registration
	*/
	@Override
	public Date getDATE() {
		return _projectExtentionRegistration.getDATE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectExtentionRegistration.getExpandoBridge();
	}

	/**
	* Returns the extention_date of this project extention registration.
	*
	* @return the extention_date of this project extention registration
	*/
	@Override
	public Date getEXTENTION_DATE() {
		return _projectExtentionRegistration.getEXTENTION_DATE();
	}

	/**
	* Returns the primary key of this project extention registration.
	*
	* @return the primary key of this project extention registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectExtentionRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectExtentionRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_extention_id of this project extention registration.
	*
	* @return the project_extention_id of this project extention registration
	*/
	@Override
	public long getPROJECT_EXTENTION_ID() {
		return _projectExtentionRegistration.getPROJECT_EXTENTION_ID();
	}

	/**
	* Returns the project_id of this project extention registration.
	*
	* @return the project_id of this project extention registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectExtentionRegistration.getPROJECT_ID();
	}

	/**
	* Returns the status of this project extention registration.
	*
	* @return the status of this project extention registration
	*/
	@Override
	public int getSTATUS() {
		return _projectExtentionRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this project extention registration.
	*
	* @return the uuid of this project extention registration
	*/
	@Override
	public String getUuid() {
		return _projectExtentionRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _projectExtentionRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectExtentionRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectExtentionRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectExtentionRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectExtentionRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectExtentionRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the comment of this project extention registration.
	*
	* @param COMMENT the comment of this project extention registration
	*/
	@Override
	public void setCOMMENT(String COMMENT) {
		_projectExtentionRegistration.setCOMMENT(COMMENT);
	}

	/**
	* Sets the date of this project extention registration.
	*
	* @param DATE the date of this project extention registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_projectExtentionRegistration.setDATE(DATE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectExtentionRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectExtentionRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectExtentionRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the extention_date of this project extention registration.
	*
	* @param EXTENTION_DATE the extention_date of this project extention registration
	*/
	@Override
	public void setEXTENTION_DATE(Date EXTENTION_DATE) {
		_projectExtentionRegistration.setEXTENTION_DATE(EXTENTION_DATE);
	}

	@Override
	public void setNew(boolean n) {
		_projectExtentionRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project extention registration.
	*
	* @param primaryKey the primary key of this project extention registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectExtentionRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectExtentionRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_extention_id of this project extention registration.
	*
	* @param PROJECT_EXTENTION_ID the project_extention_id of this project extention registration
	*/
	@Override
	public void setPROJECT_EXTENTION_ID(long PROJECT_EXTENTION_ID) {
		_projectExtentionRegistration.setPROJECT_EXTENTION_ID(PROJECT_EXTENTION_ID);
	}

	/**
	* Sets the project_id of this project extention registration.
	*
	* @param PROJECT_ID the project_id of this project extention registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectExtentionRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the status of this project extention registration.
	*
	* @param STATUS the status of this project extention registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_projectExtentionRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this project extention registration.
	*
	* @param uuid the uuid of this project extention registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectExtentionRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectExtentionRegistration> toCacheModel() {
		return _projectExtentionRegistration.toCacheModel();
	}

	@Override
	public ProjectExtentionRegistration toEscapedModel() {
		return new ProjectExtentionRegistrationWrapper(_projectExtentionRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectExtentionRegistration.toString();
	}

	@Override
	public ProjectExtentionRegistration toUnescapedModel() {
		return new ProjectExtentionRegistrationWrapper(_projectExtentionRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectExtentionRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectExtentionRegistrationWrapper)) {
			return false;
		}

		ProjectExtentionRegistrationWrapper projectExtentionRegistrationWrapper = (ProjectExtentionRegistrationWrapper)obj;

		if (Objects.equals(_projectExtentionRegistration,
					projectExtentionRegistrationWrapper._projectExtentionRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectExtentionRegistration getWrappedModel() {
		return _projectExtentionRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectExtentionRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectExtentionRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectExtentionRegistration.resetOriginalValues();
	}

	private final ProjectExtentionRegistration _projectExtentionRegistration;
}