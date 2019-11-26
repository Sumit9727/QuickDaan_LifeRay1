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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.CandidateRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.CandidateRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class CandidateRegistrationSoap implements Serializable {
	public static CandidateRegistrationSoap toSoapModel(
		CandidateRegistration model) {
		CandidateRegistrationSoap soapModel = new CandidateRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCANDIDATE_ID(model.getCANDIDATE_ID());
		soapModel.setPOSITION_ID(model.getPOSITION_ID());
		soapModel.setNAME(model.getNAME());
		soapModel.setEMAIL(model.getEMAIL());
		soapModel.setMOBILE_NO(model.getMOBILE_NO());
		soapModel.setCURRENT_LOCATION(model.getCURRENT_LOCATION());
		soapModel.setEXPERIENCE(model.getEXPERIENCE());
		soapModel.setRESUME_TYPE(model.getRESUME_TYPE());
		soapModel.setRESUME(model.getRESUME());
		soapModel.setDATE(model.getDATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static CandidateRegistrationSoap[] toSoapModels(
		CandidateRegistration[] models) {
		CandidateRegistrationSoap[] soapModels = new CandidateRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateRegistrationSoap[][] toSoapModels(
		CandidateRegistration[][] models) {
		CandidateRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateRegistrationSoap[] toSoapModels(
		List<CandidateRegistration> models) {
		List<CandidateRegistrationSoap> soapModels = new ArrayList<CandidateRegistrationSoap>(models.size());

		for (CandidateRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateRegistrationSoap[soapModels.size()]);
	}

	public CandidateRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _CANDIDATE_ID;
	}

	public void setPrimaryKey(long pk) {
		setCANDIDATE_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCANDIDATE_ID() {
		return _CANDIDATE_ID;
	}

	public void setCANDIDATE_ID(long CANDIDATE_ID) {
		_CANDIDATE_ID = CANDIDATE_ID;
	}

	public long getPOSITION_ID() {
		return _POSITION_ID;
	}

	public void setPOSITION_ID(long POSITION_ID) {
		_POSITION_ID = POSITION_ID;
	}

	public String getNAME() {
		return _NAME;
	}

	public void setNAME(String NAME) {
		_NAME = NAME;
	}

	public String getEMAIL() {
		return _EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		_EMAIL = EMAIL;
	}

	public long getMOBILE_NO() {
		return _MOBILE_NO;
	}

	public void setMOBILE_NO(long MOBILE_NO) {
		_MOBILE_NO = MOBILE_NO;
	}

	public String getCURRENT_LOCATION() {
		return _CURRENT_LOCATION;
	}

	public void setCURRENT_LOCATION(String CURRENT_LOCATION) {
		_CURRENT_LOCATION = CURRENT_LOCATION;
	}

	public String getEXPERIENCE() {
		return _EXPERIENCE;
	}

	public void setEXPERIENCE(String EXPERIENCE) {
		_EXPERIENCE = EXPERIENCE;
	}

	public String getRESUME_TYPE() {
		return _RESUME_TYPE;
	}

	public void setRESUME_TYPE(String RESUME_TYPE) {
		_RESUME_TYPE = RESUME_TYPE;
	}

	public Blob getRESUME() {
		return _RESUME;
	}

	public void setRESUME(Blob RESUME) {
		_RESUME = RESUME;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _CANDIDATE_ID;
	private long _POSITION_ID;
	private String _NAME;
	private String _EMAIL;
	private long _MOBILE_NO;
	private String _CURRENT_LOCATION;
	private String _EXPERIENCE;
	private String _RESUME_TYPE;
	private Blob _RESUME;
	private Date _DATE;
	private int _STATUS;
}