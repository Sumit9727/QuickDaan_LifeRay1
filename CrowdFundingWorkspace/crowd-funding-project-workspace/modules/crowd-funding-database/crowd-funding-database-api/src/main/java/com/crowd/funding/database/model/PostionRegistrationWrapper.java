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
 * This class is a wrapper for {@link PostionRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PostionRegistration
 * @generated
 */
@ProviderType
public class PostionRegistrationWrapper implements PostionRegistration,
	ModelWrapper<PostionRegistration> {
	public PostionRegistrationWrapper(PostionRegistration postionRegistration) {
		_postionRegistration = postionRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return PostionRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return PostionRegistration.class.getName();
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
		return new PostionRegistrationWrapper((PostionRegistration)_postionRegistration.clone());
	}

	@Override
	public int compareTo(PostionRegistration postionRegistration) {
		return _postionRegistration.compareTo(postionRegistration);
	}

	/**
	* Returns the advertisment_num of this postion registration.
	*
	* @return the advertisment_num of this postion registration
	*/
	@Override
	public String getADVERTISMENT_NUM() {
		return _postionRegistration.getADVERTISMENT_NUM();
	}

	/**
	* Returns the date of this postion registration.
	*
	* @return the date of this postion registration
	*/
	@Override
	public Date getDATE() {
		return _postionRegistration.getDATE();
	}

	/**
	* Returns the description of this postion registration.
	*
	* @return the description of this postion registration
	*/
	@Override
	public String getDESCRIPTION() {
		return _postionRegistration.getDESCRIPTION();
	}

	/**
	* Returns the employment_type of this postion registration.
	*
	* @return the employment_type of this postion registration
	*/
	@Override
	public String getEMPLOYMENT_TYPE() {
		return _postionRegistration.getEMPLOYMENT_TYPE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _postionRegistration.getExpandoBridge();
	}

	/**
	* Returns the experience_level of this postion registration.
	*
	* @return the experience_level of this postion registration
	*/
	@Override
	public String getEXPERIENCE_LEVEL() {
		return _postionRegistration.getEXPERIENCE_LEVEL();
	}

	/**
	* Returns the functional_area of this postion registration.
	*
	* @return the functional_area of this postion registration
	*/
	@Override
	public String getFUNCTIONAL_AREA() {
		return _postionRegistration.getFUNCTIONAL_AREA();
	}

	/**
	* Returns the industry_type of this postion registration.
	*
	* @return the industry_type of this postion registration
	*/
	@Override
	public String getINDUSTRY_TYPE() {
		return _postionRegistration.getINDUSTRY_TYPE();
	}

	/**
	* Returns the location of this postion registration.
	*
	* @return the location of this postion registration
	*/
	@Override
	public String getLOCATION() {
		return _postionRegistration.getLOCATION();
	}

	/**
	* Returns the position_id of this postion registration.
	*
	* @return the position_id of this postion registration
	*/
	@Override
	public long getPOSITION_ID() {
		return _postionRegistration.getPOSITION_ID();
	}

	/**
	* Returns the position_name of this postion registration.
	*
	* @return the position_name of this postion registration
	*/
	@Override
	public String getPOSITION_NAME() {
		return _postionRegistration.getPOSITION_NAME();
	}

	/**
	* Returns the primary key of this postion registration.
	*
	* @return the primary key of this postion registration
	*/
	@Override
	public long getPrimaryKey() {
		return _postionRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _postionRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the role_category of this postion registration.
	*
	* @return the role_category of this postion registration
	*/
	@Override
	public String getROLE_CATEGORY() {
		return _postionRegistration.getROLE_CATEGORY();
	}

	/**
	* Returns the salary of this postion registration.
	*
	* @return the salary of this postion registration
	*/
	@Override
	public String getSALARY() {
		return _postionRegistration.getSALARY();
	}

	/**
	* Returns the status of this postion registration.
	*
	* @return the status of this postion registration
	*/
	@Override
	public int getSTATUS() {
		return _postionRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this postion registration.
	*
	* @return the uuid of this postion registration
	*/
	@Override
	public String getUuid() {
		return _postionRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _postionRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _postionRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _postionRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _postionRegistration.isNew();
	}

	@Override
	public void persist() {
		_postionRegistration.persist();
	}

	/**
	* Sets the advertisment_num of this postion registration.
	*
	* @param ADVERTISMENT_NUM the advertisment_num of this postion registration
	*/
	@Override
	public void setADVERTISMENT_NUM(String ADVERTISMENT_NUM) {
		_postionRegistration.setADVERTISMENT_NUM(ADVERTISMENT_NUM);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_postionRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this postion registration.
	*
	* @param DATE the date of this postion registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_postionRegistration.setDATE(DATE);
	}

	/**
	* Sets the description of this postion registration.
	*
	* @param DESCRIPTION the description of this postion registration
	*/
	@Override
	public void setDESCRIPTION(String DESCRIPTION) {
		_postionRegistration.setDESCRIPTION(DESCRIPTION);
	}

	/**
	* Sets the employment_type of this postion registration.
	*
	* @param EMPLOYMENT_TYPE the employment_type of this postion registration
	*/
	@Override
	public void setEMPLOYMENT_TYPE(String EMPLOYMENT_TYPE) {
		_postionRegistration.setEMPLOYMENT_TYPE(EMPLOYMENT_TYPE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_postionRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_postionRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_postionRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the experience_level of this postion registration.
	*
	* @param EXPERIENCE_LEVEL the experience_level of this postion registration
	*/
	@Override
	public void setEXPERIENCE_LEVEL(String EXPERIENCE_LEVEL) {
		_postionRegistration.setEXPERIENCE_LEVEL(EXPERIENCE_LEVEL);
	}

	/**
	* Sets the functional_area of this postion registration.
	*
	* @param FUNCTIONAL_AREA the functional_area of this postion registration
	*/
	@Override
	public void setFUNCTIONAL_AREA(String FUNCTIONAL_AREA) {
		_postionRegistration.setFUNCTIONAL_AREA(FUNCTIONAL_AREA);
	}

	/**
	* Sets the industry_type of this postion registration.
	*
	* @param INDUSTRY_TYPE the industry_type of this postion registration
	*/
	@Override
	public void setINDUSTRY_TYPE(String INDUSTRY_TYPE) {
		_postionRegistration.setINDUSTRY_TYPE(INDUSTRY_TYPE);
	}

	/**
	* Sets the location of this postion registration.
	*
	* @param LOCATION the location of this postion registration
	*/
	@Override
	public void setLOCATION(String LOCATION) {
		_postionRegistration.setLOCATION(LOCATION);
	}

	@Override
	public void setNew(boolean n) {
		_postionRegistration.setNew(n);
	}

	/**
	* Sets the position_id of this postion registration.
	*
	* @param POSITION_ID the position_id of this postion registration
	*/
	@Override
	public void setPOSITION_ID(long POSITION_ID) {
		_postionRegistration.setPOSITION_ID(POSITION_ID);
	}

	/**
	* Sets the position_name of this postion registration.
	*
	* @param POSITION_NAME the position_name of this postion registration
	*/
	@Override
	public void setPOSITION_NAME(String POSITION_NAME) {
		_postionRegistration.setPOSITION_NAME(POSITION_NAME);
	}

	/**
	* Sets the primary key of this postion registration.
	*
	* @param primaryKey the primary key of this postion registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_postionRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_postionRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role_category of this postion registration.
	*
	* @param ROLE_CATEGORY the role_category of this postion registration
	*/
	@Override
	public void setROLE_CATEGORY(String ROLE_CATEGORY) {
		_postionRegistration.setROLE_CATEGORY(ROLE_CATEGORY);
	}

	/**
	* Sets the salary of this postion registration.
	*
	* @param SALARY the salary of this postion registration
	*/
	@Override
	public void setSALARY(String SALARY) {
		_postionRegistration.setSALARY(SALARY);
	}

	/**
	* Sets the status of this postion registration.
	*
	* @param STATUS the status of this postion registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_postionRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this postion registration.
	*
	* @param uuid the uuid of this postion registration
	*/
	@Override
	public void setUuid(String uuid) {
		_postionRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<PostionRegistration> toCacheModel() {
		return _postionRegistration.toCacheModel();
	}

	@Override
	public PostionRegistration toEscapedModel() {
		return new PostionRegistrationWrapper(_postionRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _postionRegistration.toString();
	}

	@Override
	public PostionRegistration toUnescapedModel() {
		return new PostionRegistrationWrapper(_postionRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _postionRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PostionRegistrationWrapper)) {
			return false;
		}

		PostionRegistrationWrapper postionRegistrationWrapper = (PostionRegistrationWrapper)obj;

		if (Objects.equals(_postionRegistration,
					postionRegistrationWrapper._postionRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public PostionRegistration getWrappedModel() {
		return _postionRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _postionRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _postionRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_postionRegistration.resetOriginalValues();
	}

	private final PostionRegistration _postionRegistration;
}