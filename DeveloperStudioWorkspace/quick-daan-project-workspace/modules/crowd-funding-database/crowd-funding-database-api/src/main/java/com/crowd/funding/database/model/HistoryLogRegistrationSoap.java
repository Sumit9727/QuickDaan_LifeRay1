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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.HistoryLogRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.HistoryLogRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationSoap implements Serializable {
	public static HistoryLogRegistrationSoap toSoapModel(
		HistoryLogRegistration model) {
		HistoryLogRegistrationSoap soapModel = new HistoryLogRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setHISTORY_ID(model.getHISTORY_ID());
		soapModel.setUSER_ID(model.getUSER_ID());
		soapModel.setURL(model.getURL());
		soapModel.setDATE(model.getDATE());

		return soapModel;
	}

	public static HistoryLogRegistrationSoap[] toSoapModels(
		HistoryLogRegistration[] models) {
		HistoryLogRegistrationSoap[] soapModels = new HistoryLogRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistoryLogRegistrationSoap[][] toSoapModels(
		HistoryLogRegistration[][] models) {
		HistoryLogRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistoryLogRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistoryLogRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistoryLogRegistrationSoap[] toSoapModels(
		List<HistoryLogRegistration> models) {
		List<HistoryLogRegistrationSoap> soapModels = new ArrayList<HistoryLogRegistrationSoap>(models.size());

		for (HistoryLogRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistoryLogRegistrationSoap[soapModels.size()]);
	}

	public HistoryLogRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _HISTORY_ID;
	}

	public void setPrimaryKey(long pk) {
		setHISTORY_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getHISTORY_ID() {
		return _HISTORY_ID;
	}

	public void setHISTORY_ID(long HISTORY_ID) {
		_HISTORY_ID = HISTORY_ID;
	}

	public long getUSER_ID() {
		return _USER_ID;
	}

	public void setUSER_ID(long USER_ID) {
		_USER_ID = USER_ID;
	}

	public String getURL() {
		return _URL;
	}

	public void setURL(String URL) {
		_URL = URL;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
	}

	private String _uuid;
	private long _HISTORY_ID;
	private long _USER_ID;
	private String _URL;
	private Date _DATE;
}