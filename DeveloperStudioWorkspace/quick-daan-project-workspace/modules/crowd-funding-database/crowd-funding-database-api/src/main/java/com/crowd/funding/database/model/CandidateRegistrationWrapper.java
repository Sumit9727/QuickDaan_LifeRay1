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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CandidateRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistration
 * @generated
 */
@ProviderType
public class CandidateRegistrationWrapper implements CandidateRegistration,
	ModelWrapper<CandidateRegistration> {
	public CandidateRegistrationWrapper(
		CandidateRegistration candidateRegistration) {
		_candidateRegistration = candidateRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CANDIDATE_ID", getCANDIDATE_ID());
		attributes.put("POSITION_ID", getPOSITION_ID());
		attributes.put("NAME", getNAME());
		attributes.put("EMAIL", getEMAIL());
		attributes.put("MOBILE_NO", getMOBILE_NO());
		attributes.put("CURRENT_LOCATION", getCURRENT_LOCATION());
		attributes.put("EXPERIENCE", getEXPERIENCE());
		attributes.put("RESUME_TYPE", getRESUME_TYPE());
		attributes.put("RESUME", getRESUME());
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

		Long CANDIDATE_ID = (Long)attributes.get("CANDIDATE_ID");

		if (CANDIDATE_ID != null) {
			setCANDIDATE_ID(CANDIDATE_ID);
		}

		Long POSITION_ID = (Long)attributes.get("POSITION_ID");

		if (POSITION_ID != null) {
			setPOSITION_ID(POSITION_ID);
		}

		String NAME = (String)attributes.get("NAME");

		if (NAME != null) {
			setNAME(NAME);
		}

		String EMAIL = (String)attributes.get("EMAIL");

		if (EMAIL != null) {
			setEMAIL(EMAIL);
		}

		Long MOBILE_NO = (Long)attributes.get("MOBILE_NO");

		if (MOBILE_NO != null) {
			setMOBILE_NO(MOBILE_NO);
		}

		String CURRENT_LOCATION = (String)attributes.get("CURRENT_LOCATION");

		if (CURRENT_LOCATION != null) {
			setCURRENT_LOCATION(CURRENT_LOCATION);
		}

		String EXPERIENCE = (String)attributes.get("EXPERIENCE");

		if (EXPERIENCE != null) {
			setEXPERIENCE(EXPERIENCE);
		}

		String RESUME_TYPE = (String)attributes.get("RESUME_TYPE");

		if (RESUME_TYPE != null) {
			setRESUME_TYPE(RESUME_TYPE);
		}

		Blob RESUME = (Blob)attributes.get("RESUME");

		if (RESUME != null) {
			setRESUME(RESUME);
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
		return new CandidateRegistrationWrapper((CandidateRegistration)_candidateRegistration.clone());
	}

	@Override
	public int compareTo(CandidateRegistration candidateRegistration) {
		return _candidateRegistration.compareTo(candidateRegistration);
	}

	/**
	* Returns the candidate_id of this candidate registration.
	*
	* @return the candidate_id of this candidate registration
	*/
	@Override
	public long getCANDIDATE_ID() {
		return _candidateRegistration.getCANDIDATE_ID();
	}

	/**
	* Returns the current_location of this candidate registration.
	*
	* @return the current_location of this candidate registration
	*/
	@Override
	public String getCURRENT_LOCATION() {
		return _candidateRegistration.getCURRENT_LOCATION();
	}

	/**
	* Returns the date of this candidate registration.
	*
	* @return the date of this candidate registration
	*/
	@Override
	public Date getDATE() {
		return _candidateRegistration.getDATE();
	}

	/**
	* Returns the email of this candidate registration.
	*
	* @return the email of this candidate registration
	*/
	@Override
	public String getEMAIL() {
		return _candidateRegistration.getEMAIL();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _candidateRegistration.getExpandoBridge();
	}

	/**
	* Returns the experience of this candidate registration.
	*
	* @return the experience of this candidate registration
	*/
	@Override
	public String getEXPERIENCE() {
		return _candidateRegistration.getEXPERIENCE();
	}

	/**
	* Returns the mobile_no of this candidate registration.
	*
	* @return the mobile_no of this candidate registration
	*/
	@Override
	public long getMOBILE_NO() {
		return _candidateRegistration.getMOBILE_NO();
	}

	/**
	* Returns the name of this candidate registration.
	*
	* @return the name of this candidate registration
	*/
	@Override
	public String getNAME() {
		return _candidateRegistration.getNAME();
	}

	/**
	* Returns the position_id of this candidate registration.
	*
	* @return the position_id of this candidate registration
	*/
	@Override
	public long getPOSITION_ID() {
		return _candidateRegistration.getPOSITION_ID();
	}

	/**
	* Returns the primary key of this candidate registration.
	*
	* @return the primary key of this candidate registration
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the resume of this candidate registration.
	*
	* @return the resume of this candidate registration
	*/
	@Override
	public Blob getRESUME() {
		return _candidateRegistration.getRESUME();
	}

	/**
	* Returns the resume_type of this candidate registration.
	*
	* @return the resume_type of this candidate registration
	*/
	@Override
	public String getRESUME_TYPE() {
		return _candidateRegistration.getRESUME_TYPE();
	}

	/**
	* Returns the status of this candidate registration.
	*
	* @return the status of this candidate registration
	*/
	@Override
	public int getSTATUS() {
		return _candidateRegistration.getSTATUS();
	}

	/**
	* Returns the uuid of this candidate registration.
	*
	* @return the uuid of this candidate registration
	*/
	@Override
	public String getUuid() {
		return _candidateRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _candidateRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _candidateRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _candidateRegistration.isNew();
	}

	@Override
	public void persist() {
		_candidateRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the candidate_id of this candidate registration.
	*
	* @param CANDIDATE_ID the candidate_id of this candidate registration
	*/
	@Override
	public void setCANDIDATE_ID(long CANDIDATE_ID) {
		_candidateRegistration.setCANDIDATE_ID(CANDIDATE_ID);
	}

	/**
	* Sets the current_location of this candidate registration.
	*
	* @param CURRENT_LOCATION the current_location of this candidate registration
	*/
	@Override
	public void setCURRENT_LOCATION(String CURRENT_LOCATION) {
		_candidateRegistration.setCURRENT_LOCATION(CURRENT_LOCATION);
	}

	/**
	* Sets the date of this candidate registration.
	*
	* @param DATE the date of this candidate registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_candidateRegistration.setDATE(DATE);
	}

	/**
	* Sets the email of this candidate registration.
	*
	* @param EMAIL the email of this candidate registration
	*/
	@Override
	public void setEMAIL(String EMAIL) {
		_candidateRegistration.setEMAIL(EMAIL);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_candidateRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_candidateRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_candidateRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the experience of this candidate registration.
	*
	* @param EXPERIENCE the experience of this candidate registration
	*/
	@Override
	public void setEXPERIENCE(String EXPERIENCE) {
		_candidateRegistration.setEXPERIENCE(EXPERIENCE);
	}

	/**
	* Sets the mobile_no of this candidate registration.
	*
	* @param MOBILE_NO the mobile_no of this candidate registration
	*/
	@Override
	public void setMOBILE_NO(long MOBILE_NO) {
		_candidateRegistration.setMOBILE_NO(MOBILE_NO);
	}

	/**
	* Sets the name of this candidate registration.
	*
	* @param NAME the name of this candidate registration
	*/
	@Override
	public void setNAME(String NAME) {
		_candidateRegistration.setNAME(NAME);
	}

	@Override
	public void setNew(boolean n) {
		_candidateRegistration.setNew(n);
	}

	/**
	* Sets the position_id of this candidate registration.
	*
	* @param POSITION_ID the position_id of this candidate registration
	*/
	@Override
	public void setPOSITION_ID(long POSITION_ID) {
		_candidateRegistration.setPOSITION_ID(POSITION_ID);
	}

	/**
	* Sets the primary key of this candidate registration.
	*
	* @param primaryKey the primary key of this candidate registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_candidateRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the resume of this candidate registration.
	*
	* @param RESUME the resume of this candidate registration
	*/
	@Override
	public void setRESUME(Blob RESUME) {
		_candidateRegistration.setRESUME(RESUME);
	}

	/**
	* Sets the resume_type of this candidate registration.
	*
	* @param RESUME_TYPE the resume_type of this candidate registration
	*/
	@Override
	public void setRESUME_TYPE(String RESUME_TYPE) {
		_candidateRegistration.setRESUME_TYPE(RESUME_TYPE);
	}

	/**
	* Sets the status of this candidate registration.
	*
	* @param STATUS the status of this candidate registration
	*/
	@Override
	public void setSTATUS(int STATUS) {
		_candidateRegistration.setSTATUS(STATUS);
	}

	/**
	* Sets the uuid of this candidate registration.
	*
	* @param uuid the uuid of this candidate registration
	*/
	@Override
	public void setUuid(String uuid) {
		_candidateRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CandidateRegistration> toCacheModel() {
		return _candidateRegistration.toCacheModel();
	}

	@Override
	public CandidateRegistration toEscapedModel() {
		return new CandidateRegistrationWrapper(_candidateRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _candidateRegistration.toString();
	}

	@Override
	public CandidateRegistration toUnescapedModel() {
		return new CandidateRegistrationWrapper(_candidateRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _candidateRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateRegistrationWrapper)) {
			return false;
		}

		CandidateRegistrationWrapper candidateRegistrationWrapper = (CandidateRegistrationWrapper)obj;

		if (Objects.equals(_candidateRegistration,
					candidateRegistrationWrapper._candidateRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public CandidateRegistration getWrappedModel() {
		return _candidateRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _candidateRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _candidateRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_candidateRegistration.resetOriginalValues();
	}

	private final CandidateRegistration _candidateRegistration;
}