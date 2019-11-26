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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectExtentionRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectExtentionRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectExtentionRegistrationSoap implements Serializable {
	public static ProjectExtentionRegistrationSoap toSoapModel(
		ProjectExtentionRegistration model) {
		ProjectExtentionRegistrationSoap soapModel = new ProjectExtentionRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_EXTENTION_ID(model.getPROJECT_EXTENTION_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setEXTENTION_DATE(model.getEXTENTION_DATE());
		soapModel.setCOMMENT(model.getCOMMENT());
		soapModel.setSTATUS(model.getSTATUS());
		soapModel.setDATE(model.getDATE());

		return soapModel;
	}

	public static ProjectExtentionRegistrationSoap[] toSoapModels(
		ProjectExtentionRegistration[] models) {
		ProjectExtentionRegistrationSoap[] soapModels = new ProjectExtentionRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectExtentionRegistrationSoap[][] toSoapModels(
		ProjectExtentionRegistration[][] models) {
		ProjectExtentionRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectExtentionRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectExtentionRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectExtentionRegistrationSoap[] toSoapModels(
		List<ProjectExtentionRegistration> models) {
		List<ProjectExtentionRegistrationSoap> soapModels = new ArrayList<ProjectExtentionRegistrationSoap>(models.size());

		for (ProjectExtentionRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectExtentionRegistrationSoap[soapModels.size()]);
	}

	public ProjectExtentionRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_EXTENTION_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_EXTENTION_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_EXTENTION_ID() {
		return _PROJECT_EXTENTION_ID;
	}

	public void setPROJECT_EXTENTION_ID(long PROJECT_EXTENTION_ID) {
		_PROJECT_EXTENTION_ID = PROJECT_EXTENTION_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public Date getEXTENTION_DATE() {
		return _EXTENTION_DATE;
	}

	public void setEXTENTION_DATE(Date EXTENTION_DATE) {
		_EXTENTION_DATE = EXTENTION_DATE;
	}

	public String getCOMMENT() {
		return _COMMENT;
	}

	public void setCOMMENT(String COMMENT) {
		_COMMENT = COMMENT;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	private String _uuid;
	private long _PROJECT_EXTENTION_ID;
	private long _PROJECT_ID;
	private Date _EXTENTION_DATE;
	private String _COMMENT;
	private int _STATUS;
	private Date _DATE;
}