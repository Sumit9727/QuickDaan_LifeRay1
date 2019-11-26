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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.ProjectFeesRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.ProjectFeesRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class ProjectFeesRegistrationSoap implements Serializable {
	public static ProjectFeesRegistrationSoap toSoapModel(
		ProjectFeesRegistration model) {
		ProjectFeesRegistrationSoap soapModel = new ProjectFeesRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_FEES_ID(model.getPROJECT_FEES_ID());
		soapModel.setCATEGORY_ID(model.getCATEGORY_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setSTART_AMOUNT(model.getSTART_AMOUNT());
		soapModel.setEND_AMOUNT(model.getEND_AMOUNT());
		soapModel.setWITHDRAW_STATUS(model.getWITHDRAW_STATUS());
		soapModel.setDATE(model.getDATE());

		return soapModel;
	}

	public static ProjectFeesRegistrationSoap[] toSoapModels(
		ProjectFeesRegistration[] models) {
		ProjectFeesRegistrationSoap[] soapModels = new ProjectFeesRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectFeesRegistrationSoap[][] toSoapModels(
		ProjectFeesRegistration[][] models) {
		ProjectFeesRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectFeesRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectFeesRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectFeesRegistrationSoap[] toSoapModels(
		List<ProjectFeesRegistration> models) {
		List<ProjectFeesRegistrationSoap> soapModels = new ArrayList<ProjectFeesRegistrationSoap>(models.size());

		for (ProjectFeesRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectFeesRegistrationSoap[soapModels.size()]);
	}

	public ProjectFeesRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_FEES_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_FEES_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_FEES_ID() {
		return _PROJECT_FEES_ID;
	}

	public void setPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		_PROJECT_FEES_ID = PROJECT_FEES_ID;
	}

	public long getCATEGORY_ID() {
		return _CATEGORY_ID;
	}

	public void setCATEGORY_ID(long CATEGORY_ID) {
		_CATEGORY_ID = CATEGORY_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public float getSTART_AMOUNT() {
		return _START_AMOUNT;
	}

	public void setSTART_AMOUNT(float START_AMOUNT) {
		_START_AMOUNT = START_AMOUNT;
	}

	public float getEND_AMOUNT() {
		return _END_AMOUNT;
	}

	public void setEND_AMOUNT(float END_AMOUNT) {
		_END_AMOUNT = END_AMOUNT;
	}

	public int getWITHDRAW_STATUS() {
		return _WITHDRAW_STATUS;
	}

	public void setWITHDRAW_STATUS(int WITHDRAW_STATUS) {
		_WITHDRAW_STATUS = WITHDRAW_STATUS;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	private String _uuid;
	private long _PROJECT_FEES_ID;
	private long _CATEGORY_ID;
	private long _PROJECT_ID;
	private float _START_AMOUNT;
	private float _END_AMOUNT;
	private int _WITHDRAW_STATUS;
	private Date _DATE;
}