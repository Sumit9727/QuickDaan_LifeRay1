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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.PostionRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.PostionRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class PostionRegistrationSoap implements Serializable {
	public static PostionRegistrationSoap toSoapModel(PostionRegistration model) {
		PostionRegistrationSoap soapModel = new PostionRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPOSITION_ID(model.getPOSITION_ID());
		soapModel.setADVERTISMENT_NUM(model.getADVERTISMENT_NUM());
		soapModel.setPOSITION_NAME(model.getPOSITION_NAME());
		soapModel.setDESCRIPTION(model.getDESCRIPTION());
		soapModel.setEXPERIENCE_LEVEL(model.getEXPERIENCE_LEVEL());
		soapModel.setSALARY(model.getSALARY());
		soapModel.setINDUSTRY_TYPE(model.getINDUSTRY_TYPE());
		soapModel.setFUNCTIONAL_AREA(model.getFUNCTIONAL_AREA());
		soapModel.setROLE_CATEGORY(model.getROLE_CATEGORY());
		soapModel.setEMPLOYMENT_TYPE(model.getEMPLOYMENT_TYPE());
		soapModel.setLOCATION(model.getLOCATION());
		soapModel.setDATE(model.getDATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static PostionRegistrationSoap[] toSoapModels(
		PostionRegistration[] models) {
		PostionRegistrationSoap[] soapModels = new PostionRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PostionRegistrationSoap[][] toSoapModels(
		PostionRegistration[][] models) {
		PostionRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PostionRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PostionRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PostionRegistrationSoap[] toSoapModels(
		List<PostionRegistration> models) {
		List<PostionRegistrationSoap> soapModels = new ArrayList<PostionRegistrationSoap>(models.size());

		for (PostionRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PostionRegistrationSoap[soapModels.size()]);
	}

	public PostionRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _POSITION_ID;
	}

	public void setPrimaryKey(long pk) {
		setPOSITION_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPOSITION_ID() {
		return _POSITION_ID;
	}

	public void setPOSITION_ID(long POSITION_ID) {
		_POSITION_ID = POSITION_ID;
	}

	public String getADVERTISMENT_NUM() {
		return _ADVERTISMENT_NUM;
	}

	public void setADVERTISMENT_NUM(String ADVERTISMENT_NUM) {
		_ADVERTISMENT_NUM = ADVERTISMENT_NUM;
	}

	public String getPOSITION_NAME() {
		return _POSITION_NAME;
	}

	public void setPOSITION_NAME(String POSITION_NAME) {
		_POSITION_NAME = POSITION_NAME;
	}

	public String getDESCRIPTION() {
		return _DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		_DESCRIPTION = DESCRIPTION;
	}

	public String getEXPERIENCE_LEVEL() {
		return _EXPERIENCE_LEVEL;
	}

	public void setEXPERIENCE_LEVEL(String EXPERIENCE_LEVEL) {
		_EXPERIENCE_LEVEL = EXPERIENCE_LEVEL;
	}

	public String getSALARY() {
		return _SALARY;
	}

	public void setSALARY(String SALARY) {
		_SALARY = SALARY;
	}

	public String getINDUSTRY_TYPE() {
		return _INDUSTRY_TYPE;
	}

	public void setINDUSTRY_TYPE(String INDUSTRY_TYPE) {
		_INDUSTRY_TYPE = INDUSTRY_TYPE;
	}

	public String getFUNCTIONAL_AREA() {
		return _FUNCTIONAL_AREA;
	}

	public void setFUNCTIONAL_AREA(String FUNCTIONAL_AREA) {
		_FUNCTIONAL_AREA = FUNCTIONAL_AREA;
	}

	public String getROLE_CATEGORY() {
		return _ROLE_CATEGORY;
	}

	public void setROLE_CATEGORY(String ROLE_CATEGORY) {
		_ROLE_CATEGORY = ROLE_CATEGORY;
	}

	public String getEMPLOYMENT_TYPE() {
		return _EMPLOYMENT_TYPE;
	}

	public void setEMPLOYMENT_TYPE(String EMPLOYMENT_TYPE) {
		_EMPLOYMENT_TYPE = EMPLOYMENT_TYPE;
	}

	public String getLOCATION() {
		return _LOCATION;
	}

	public void setLOCATION(String LOCATION) {
		_LOCATION = LOCATION;
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
	private long _POSITION_ID;
	private String _ADVERTISMENT_NUM;
	private String _POSITION_NAME;
	private String _DESCRIPTION;
	private String _EXPERIENCE_LEVEL;
	private String _SALARY;
	private String _INDUSTRY_TYPE;
	private String _FUNCTIONAL_AREA;
	private String _ROLE_CATEGORY;
	private String _EMPLOYMENT_TYPE;
	private String _LOCATION;
	private Date _DATE;
	private int _STATUS;
}