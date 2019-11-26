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
 * This class is a wrapper for {@link ProjectFeesRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistration
 * @generated
 */
@ProviderType
public class ProjectFeesRegistrationWrapper implements ProjectFeesRegistration,
	ModelWrapper<ProjectFeesRegistration> {
	public ProjectFeesRegistrationWrapper(
		ProjectFeesRegistration projectFeesRegistration) {
		_projectFeesRegistration = projectFeesRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectFeesRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectFeesRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("PROJECT_FEES_ID", getPROJECT_FEES_ID());
		attributes.put("CATEGORY_ID", getCATEGORY_ID());
		attributes.put("PROJECT_ID", getPROJECT_ID());
		attributes.put("START_AMOUNT", getSTART_AMOUNT());
		attributes.put("END_AMOUNT", getEND_AMOUNT());
		attributes.put("WITHDRAW_STATUS", getWITHDRAW_STATUS());
		attributes.put("DATE", getDATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long PROJECT_FEES_ID = (Long)attributes.get("PROJECT_FEES_ID");

		if (PROJECT_FEES_ID != null) {
			setPROJECT_FEES_ID(PROJECT_FEES_ID);
		}

		Long CATEGORY_ID = (Long)attributes.get("CATEGORY_ID");

		if (CATEGORY_ID != null) {
			setCATEGORY_ID(CATEGORY_ID);
		}

		Long PROJECT_ID = (Long)attributes.get("PROJECT_ID");

		if (PROJECT_ID != null) {
			setPROJECT_ID(PROJECT_ID);
		}

		Float START_AMOUNT = (Float)attributes.get("START_AMOUNT");

		if (START_AMOUNT != null) {
			setSTART_AMOUNT(START_AMOUNT);
		}

		Float END_AMOUNT = (Float)attributes.get("END_AMOUNT");

		if (END_AMOUNT != null) {
			setEND_AMOUNT(END_AMOUNT);
		}

		Integer WITHDRAW_STATUS = (Integer)attributes.get("WITHDRAW_STATUS");

		if (WITHDRAW_STATUS != null) {
			setWITHDRAW_STATUS(WITHDRAW_STATUS);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	@Override
	public Object clone() {
		return new ProjectFeesRegistrationWrapper((ProjectFeesRegistration)_projectFeesRegistration.clone());
	}

	@Override
	public int compareTo(ProjectFeesRegistration projectFeesRegistration) {
		return _projectFeesRegistration.compareTo(projectFeesRegistration);
	}

	/**
	* Returns the category_id of this project fees registration.
	*
	* @return the category_id of this project fees registration
	*/
	@Override
	public long getCATEGORY_ID() {
		return _projectFeesRegistration.getCATEGORY_ID();
	}

	/**
	* Returns the date of this project fees registration.
	*
	* @return the date of this project fees registration
	*/
	@Override
	public Date getDATE() {
		return _projectFeesRegistration.getDATE();
	}

	/**
	* Returns the end_amount of this project fees registration.
	*
	* @return the end_amount of this project fees registration
	*/
	@Override
	public float getEND_AMOUNT() {
		return _projectFeesRegistration.getEND_AMOUNT();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _projectFeesRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this project fees registration.
	*
	* @return the primary key of this project fees registration
	*/
	@Override
	public long getPrimaryKey() {
		return _projectFeesRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectFeesRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the project_fees_id of this project fees registration.
	*
	* @return the project_fees_id of this project fees registration
	*/
	@Override
	public long getPROJECT_FEES_ID() {
		return _projectFeesRegistration.getPROJECT_FEES_ID();
	}

	/**
	* Returns the project_id of this project fees registration.
	*
	* @return the project_id of this project fees registration
	*/
	@Override
	public long getPROJECT_ID() {
		return _projectFeesRegistration.getPROJECT_ID();
	}

	/**
	* Returns the start_amount of this project fees registration.
	*
	* @return the start_amount of this project fees registration
	*/
	@Override
	public float getSTART_AMOUNT() {
		return _projectFeesRegistration.getSTART_AMOUNT();
	}

	/**
	* Returns the uuid of this project fees registration.
	*
	* @return the uuid of this project fees registration
	*/
	@Override
	public String getUuid() {
		return _projectFeesRegistration.getUuid();
	}

	/**
	* Returns the withdraw_status of this project fees registration.
	*
	* @return the withdraw_status of this project fees registration
	*/
	@Override
	public int getWITHDRAW_STATUS() {
		return _projectFeesRegistration.getWITHDRAW_STATUS();
	}

	@Override
	public int hashCode() {
		return _projectFeesRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _projectFeesRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _projectFeesRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _projectFeesRegistration.isNew();
	}

	@Override
	public void persist() {
		_projectFeesRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectFeesRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the category_id of this project fees registration.
	*
	* @param CATEGORY_ID the category_id of this project fees registration
	*/
	@Override
	public void setCATEGORY_ID(long CATEGORY_ID) {
		_projectFeesRegistration.setCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Sets the date of this project fees registration.
	*
	* @param DATE the date of this project fees registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_projectFeesRegistration.setDATE(DATE);
	}

	/**
	* Sets the end_amount of this project fees registration.
	*
	* @param END_AMOUNT the end_amount of this project fees registration
	*/
	@Override
	public void setEND_AMOUNT(float END_AMOUNT) {
		_projectFeesRegistration.setEND_AMOUNT(END_AMOUNT);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_projectFeesRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_projectFeesRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_projectFeesRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_projectFeesRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this project fees registration.
	*
	* @param primaryKey the primary key of this project fees registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectFeesRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_projectFeesRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project_fees_id of this project fees registration.
	*
	* @param PROJECT_FEES_ID the project_fees_id of this project fees registration
	*/
	@Override
	public void setPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		_projectFeesRegistration.setPROJECT_FEES_ID(PROJECT_FEES_ID);
	}

	/**
	* Sets the project_id of this project fees registration.
	*
	* @param PROJECT_ID the project_id of this project fees registration
	*/
	@Override
	public void setPROJECT_ID(long PROJECT_ID) {
		_projectFeesRegistration.setPROJECT_ID(PROJECT_ID);
	}

	/**
	* Sets the start_amount of this project fees registration.
	*
	* @param START_AMOUNT the start_amount of this project fees registration
	*/
	@Override
	public void setSTART_AMOUNT(float START_AMOUNT) {
		_projectFeesRegistration.setSTART_AMOUNT(START_AMOUNT);
	}

	/**
	* Sets the uuid of this project fees registration.
	*
	* @param uuid the uuid of this project fees registration
	*/
	@Override
	public void setUuid(String uuid) {
		_projectFeesRegistration.setUuid(uuid);
	}

	/**
	* Sets the withdraw_status of this project fees registration.
	*
	* @param WITHDRAW_STATUS the withdraw_status of this project fees registration
	*/
	@Override
	public void setWITHDRAW_STATUS(int WITHDRAW_STATUS) {
		_projectFeesRegistration.setWITHDRAW_STATUS(WITHDRAW_STATUS);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ProjectFeesRegistration> toCacheModel() {
		return _projectFeesRegistration.toCacheModel();
	}

	@Override
	public ProjectFeesRegistration toEscapedModel() {
		return new ProjectFeesRegistrationWrapper(_projectFeesRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _projectFeesRegistration.toString();
	}

	@Override
	public ProjectFeesRegistration toUnescapedModel() {
		return new ProjectFeesRegistrationWrapper(_projectFeesRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _projectFeesRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectFeesRegistrationWrapper)) {
			return false;
		}

		ProjectFeesRegistrationWrapper projectFeesRegistrationWrapper = (ProjectFeesRegistrationWrapper)obj;

		if (Objects.equals(_projectFeesRegistration,
					projectFeesRegistrationWrapper._projectFeesRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public ProjectFeesRegistration getWrappedModel() {
		return _projectFeesRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _projectFeesRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _projectFeesRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_projectFeesRegistration.resetOriginalValues();
	}

	private final ProjectFeesRegistration _projectFeesRegistration;
}