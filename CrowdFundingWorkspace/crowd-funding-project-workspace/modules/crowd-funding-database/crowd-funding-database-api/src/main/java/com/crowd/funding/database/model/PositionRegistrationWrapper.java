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
 * This class is a wrapper for {@link PositionRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PositionRegistration
 * @generated
 */
@ProviderType
public class PositionRegistrationWrapper implements PositionRegistration,
	ModelWrapper<PositionRegistration> {
	public PositionRegistrationWrapper(
		PositionRegistration positionRegistration) {
		_positionRegistration = positionRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return PositionRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return PositionRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("POSITION_ID", getPOSITION_ID());
		attributes.put("ADVERTISMENT_NUM", getADVERTISMENT_NUM());
		attributes.put("POSITION_NAME", getPOSITION_NAME());
		attributes.put("DESCRIPTION", getDESCRIPTION());
		attributes.put("EXPERIENCE_LEVEL", getEXPERIENCE_LEVEL());
		attributes.put("SALARY", getSALARY());
		attributes.put("INDUSTRY_TYPE", getINDUSTRY_TYPE());
		attributes.put("FUNCTIONAL_AREA", getFUNCTIONAL_AREA());
		attributes.put("ROLE_CATEGORY", getROLE_CATEGORY());
		attributes.put("EMPLOYMENT_TYPE", getEMPLOYMENT_TYPE());
		attributes.put("LOCATION", getLOCATION());
		attributes.put("DATE", getDATE());
		attributes.put("STATUS", getSTATUS());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long POSITION_ID = (Long)attributes.get("POSITION_ID");

		if (POSITION_ID != null) {
			setPOSITION_ID(POSITION_ID);
		}

		String ADVERTISMENT_NUM = (String)attributes.get("ADVERTISMENT_NUM");

		if (ADVERTISMENT_NUM != null) {
			setADVERTISMENT_NUM(ADVERTISMENT_NUM);
		}

		String POSITION_NAME = (String)attributes.get("POSITION_NAME");

		if (POSITION_NAME != null) {
			setPOSITION_NAME(POSITION_NAME);
		}

		String DESCRIPTION = (String)attributes.get("DESCRIPTION");

		if (DESCRIPTION != null) {
			setDESCRIPTION(DESCRIPTION);
		}

		String EXPERIENCE_LEVEL = (String)attributes.get("EXPERIENCE_LEVEL");

		if (EXPERIENCE_LEVEL != null) {
			setEXPERIENCE_LEVEL(EXPERIENCE_LEVEL);
		}

		String SALARY = (String)attributes.get("SALARY");

		if (SALARY != null) {
			setSALARY(SALARY);
		}

		String INDUSTRY_TYPE = (String)attributes.get("INDUSTRY_TYPE");

		if (INDUSTRY_TYPE != null) {
			setINDUSTRY_TYPE(INDUSTRY_TYPE);
		}

		String FUNCTIONAL_AREA = (String)attributes.get("FUNCTIONAL_AREA");

		if (FUNCTIONAL_AREA != null) {
			setFUNCTIONAL_AREA(FUNCTIONAL_AREA);
		}

		String ROLE_CATEGORY = (String)attributes.get("ROLE_CATEGORY");

		if (ROLE_CATEGORY != null) {
			setROLE_CATEGORY(ROLE_CATEGORY);
		}

		String EMPLOYMENT_TYPE = (String)attributes.get("EMPLOYMENT_TYPE");

		if (EMPLOYMENT_TYPE != null) {
			setEMPLOYMENT_TYPE(EMPLOYMENT_TYPE);
		}

		String LOCATION = (String)attributes.get("LOCATION");

		if (LOCATION != null) {
			setLOCATION(LOCATION);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
		}
	}

	@Override
	public Object clone() {
		return new PositionRegistrationWrapper((PositionRegistration)_positionRegistration.clone());
	}

	@Override
	public int compareTo(PositionRegistration positionRegistration) {
		return _positionRegistration.compareTo(positionRegistration);
	}

	/**
	* Returns the advertisment_num of this position registration.
	*
	* @return the advertisment_num of this position registration
	*/
	@Override
	public String getADVERTISMENT_NUM() {
		return _positionRegistration.getADVERTISMENT_NUM();
	}

	/**
	* Returns the date of this position registration.
	*
	* @return the date of this position registration
	*/
	@Override
	public Date getDATE() {
		return _positionRegistration.getDATE();
	}

	/**
	* Returns the description of this position registration.
	*
	* @return the description of this position registration
	*/
	@Override
	public String getDESCRIPTION() {
		return _positionRegistration.getDESCRIPTION();
	}

	/**
	* Returns the employment_type of this position registration.
	*
	* @return the employment_type of this position registration
	*/
	@Override
	public String getEMPLOYMENT_TYPE() {
		return _positionRegistration.getEMPLOYMENT_TYPE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _positionRegistration.getExpandoBridge();
	}

	/**
	* Returns the experience_level of this position registration.
	*
	* @return the experience_level of this position registration
	*/
	@Override
	public String getEXPERIENCE_LEVEL() {
		return _positionRegistration.getEXPERIENCE_LEVEL();
	}

	/**
	* Returns the functional_area of this position registration.
	*
	* @return the functional_area of this position registration
	*/
	@Override
	public String getFUNCTIONAL_AREA() {
		return _positionRegistration.getFUNCTIONAL_AREA();
	}

	/**
	* Returns the industry_type of this position registration.
	*
	* @return the industry_type of this position registration
	*/
	@Override
	public String getINDUSTRY_TYPE() {
		return _positionRegistration.getINDUSTRY_TYPE();
	}

	/**
	* Returns the location of this position registration.
	*
	* @return the location of this position registration
	*/
	@Override
	public String getLOCATION() {
		return _positionRegistration.getLOCATION();
	}

	/**
	* Returns the position_id of this position registration.
	*
	* @return the position_id of this position registration
	*/
	@Override
	public long getPOSITION_ID() {
		return _positionRegistration.getPOSITION_ID();
	}

	/**
	* Returns the position_name of this position registration.
	*
	* @return the position_name of this position registration
	*/
	@Override
	public String getPOSITION_NAME() {
		return _positionRegistration.getPOSITION_NAME();
	}

	/**
	* Returns the primary key of this position registration.
	*
	* @return the primary key of this position registration
	*/
	@Override
	public long getPrimaryKey() {
		return _positionRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _positionRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the role_category of this position registration.
	*
	* @return the role_category of this position registration
	*/
	@Override
	public String getROLE_CATEGORY() {
		return _positionRegistration.getROLE_CATEGORY();
	}

	/**
	* Returns the salary of this position registration.
	*
	* @return the salary of this position registration
	*/
	@Override
	public String getSALARY() {
		return _positionRegistration.getSALARY();
	}

	/**
	* Returns the status of this position registration.
	*
	* @return the status of this position registration
	*/
	@Override
	public int getSTATUS() {
		return _positionRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this position registration.
	*
	* @return the uuid of this position registration
	*/
	@Override
	public String getUuid() {
		return _positionRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _positionRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _positionRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _positionRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _positionRegistration.isNew();
	}

	@Override
	public void persist() {
		_positionRegistration.persist();
	}

	/**
	* Sets the advertisment_num of this position registration.
	*
	* @param ADVERTISMENT_NUM the advertisment_num of this position registration
	*/
	@Override
	public void setADVERTISMENT_NUM(String ADVERTISMENT_NUM) {
		_positionRegistration.setADVERTISMENT_NUM(ADVERTISMENT_NUM);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_positionRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this position registration.
	*
	* @param DATE the date of this position registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_positionRegistration.setDATE(DATE);
	}

	/**
	* Sets the description of this position registration.
	*
	* @param DESCRIPTION the description of this position registration
	*/
	@Override
	public void setDESCRIPTION(String DESCRIPTION) {
		_positionRegistration.setDESCRIPTION(DESCRIPTION);
	}

	/**
	* Sets the employment_type of this position registration.
	*
	* @param EMPLOYMENT_TYPE the employment_type of this position registration
	*/
	@Override
	public void setEMPLOYMENT_TYPE(String EMPLOYMENT_TYPE) {
		_positionRegistration.setEMPLOYMENT_TYPE(EMPLOYMENT_TYPE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_positionRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_positionRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_positionRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the experience_level of this position registration.
	*
	* @param EXPERIENCE_LEVEL the experience_level of this position registration
	*/
	@Override
	public void setEXPERIENCE_LEVEL(String EXPERIENCE_LEVEL) {
		_positionRegistration.setEXPERIENCE_LEVEL(EXPERIENCE_LEVEL);
	}

	/**
	* Sets the functional_area of this position registration.
	*
	* @param FUNCTIONAL_AREA the functional_area of this position registration
	*/
	@Override
	public void setFUNCTIONAL_AREA(String FUNCTIONAL_AREA) {
		_positionRegistration.setFUNCTIONAL_AREA(FUNCTIONAL_AREA);
	}

	/**
	* Sets the industry_type of this position registration.
	*
	* @param INDUSTRY_TYPE the industry_type of this position registration
	*/
	@Override
	public void setINDUSTRY_TYPE(String INDUSTRY_TYPE) {
		_positionRegistration.setINDUSTRY_TYPE(INDUSTRY_TYPE);
	}

	/**
	* Sets the location of this position registration.
	*
	* @param LOCATION the location of this position registration
	*/
	@Override
	public void setLOCATION(String LOCATION) {
		_positionRegistration.setLOCATION(LOCATION);
	}

	@Override
	public void setNew(boolean n) {
		_positionRegistration.setNew(n);
	}

	/**
	* Sets the position_id of this position registration.
	*
	* @param POSITION_ID the position_id of this position registration
	*/
	@Override
	public void setPOSITION_ID(long POSITION_ID) {
		_positionRegistration.setPOSITION_ID(POSITION_ID);
	}

	/**
	* Sets the position_name of this position registration.
	*
	* @param POSITION_NAME the position_name of this position registration
	*/
	@Override
	public void setPOSITION_NAME(String POSITION_NAME) {
		_positionRegistration.setPOSITION_NAME(POSITION_NAME);
	}

	/**
	* Sets the primary key of this position registration.
	*
	* @param primaryKey the primary key of this position registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_positionRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_positionRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role_category of this position registration.
	*
	* @param ROLE_CATEGORY the role_category of this position registration
	*/
	@Override
	public void setROLE_CATEGORY(String ROLE_CATEGORY) {
		_positionRegistration.setROLE_CATEGORY(ROLE_CATEGORY);
	}

	/**
	* Sets the salary of this position registration.
	*
	* @param SALARY the salary of this position registration
	*/
	@Override
	public void setSALARY(String SALARY) {
		_positionRegistration.setSALARY(SALARY);
	}

	/**
	* Sets the status of this position registration.
	*
	* @param STATUS the status of this position registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_positionRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this position registration.
	*
	* @param uuid the uuid of this position registration
	*/
	@Override
	public void setUuid(String uuid) {
		_positionRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PositionRegistration> toCacheModel() {
		return _positionRegistration.toCacheModel();
	}

	@Override
	public PositionRegistration toEscapedModel() {
		return new PositionRegistrationWrapper(_positionRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _positionRegistration.toString();
	}

	@Override
	public PositionRegistration toUnescapedModel() {
		return new PositionRegistrationWrapper(_positionRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _positionRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PositionRegistrationWrapper)) {
			return false;
		}

		PositionRegistrationWrapper positionRegistrationWrapper = (PositionRegistrationWrapper)obj;

		if (Objects.equals(_positionRegistration,
					positionRegistrationWrapper._positionRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public PositionRegistration getWrappedModel() {
		return _positionRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _positionRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _positionRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_positionRegistration.resetOriginalValues();
	}

	private final PositionRegistration _positionRegistration;
}