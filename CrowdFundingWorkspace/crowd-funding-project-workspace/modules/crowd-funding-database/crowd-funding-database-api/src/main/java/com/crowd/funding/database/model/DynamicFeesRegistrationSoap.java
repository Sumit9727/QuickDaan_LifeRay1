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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.DynamicFeesRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.DynamicFeesRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationSoap implements Serializable {
	public static DynamicFeesRegistrationSoap toSoapModel(
		DynamicFeesRegistration model) {
		DynamicFeesRegistrationSoap soapModel = new DynamicFeesRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCATEGORY_ID(model.getCATEGORY_ID());
		soapModel.setCATEGORY_NAME(model.getCATEGORY_NAME());
		soapModel.setPROCESSING_FEES(model.getPROCESSING_FEES());
		soapModel.setPROJECT_FEES(model.getPROJECT_FEES());
		soapModel.setPAYMENT_GATEWAY_CHARGES(model.getPAYMENT_GATEWAY_CHARGES());
		soapModel.setOTHER_CHARGES(model.getOTHER_CHARGES());

		return soapModel;
	}

	public static DynamicFeesRegistrationSoap[] toSoapModels(
		DynamicFeesRegistration[] models) {
		DynamicFeesRegistrationSoap[] soapModels = new DynamicFeesRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DynamicFeesRegistrationSoap[][] toSoapModels(
		DynamicFeesRegistration[][] models) {
		DynamicFeesRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DynamicFeesRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DynamicFeesRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DynamicFeesRegistrationSoap[] toSoapModels(
		List<DynamicFeesRegistration> models) {
		List<DynamicFeesRegistrationSoap> soapModels = new ArrayList<DynamicFeesRegistrationSoap>(models.size());

		for (DynamicFeesRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DynamicFeesRegistrationSoap[soapModels.size()]);
	}

	public DynamicFeesRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _CATEGORY_ID;
	}

	public void setPrimaryKey(long pk) {
		setCATEGORY_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCATEGORY_ID() {
		return _CATEGORY_ID;
	}

	public void setCATEGORY_ID(long CATEGORY_ID) {
		_CATEGORY_ID = CATEGORY_ID;
	}

	public String getCATEGORY_NAME() {
		return _CATEGORY_NAME;
	}

	public void setCATEGORY_NAME(String CATEGORY_NAME) {
		_CATEGORY_NAME = CATEGORY_NAME;
	}

	public float getPROCESSING_FEES() {
		return _PROCESSING_FEES;
	}

	public void setPROCESSING_FEES(float PROCESSING_FEES) {
		_PROCESSING_FEES = PROCESSING_FEES;
	}

	public float getPROJECT_FEES() {
		return _PROJECT_FEES;
	}

	public void setPROJECT_FEES(float PROJECT_FEES) {
		_PROJECT_FEES = PROJECT_FEES;
	}

	public float getPAYMENT_GATEWAY_CHARGES() {
		return _PAYMENT_GATEWAY_CHARGES;
	}

	public void setPAYMENT_GATEWAY_CHARGES(float PAYMENT_GATEWAY_CHARGES) {
		_PAYMENT_GATEWAY_CHARGES = PAYMENT_GATEWAY_CHARGES;
	}

	public float getOTHER_CHARGES() {
		return _OTHER_CHARGES;
	}

	public void setOTHER_CHARGES(float OTHER_CHARGES) {
		_OTHER_CHARGES = OTHER_CHARGES;
	}

	private String _uuid;
	private long _CATEGORY_ID;
	private String _CATEGORY_NAME;
	private float _PROCESSING_FEES;
	private float _PROJECT_FEES;
	private float _PAYMENT_GATEWAY_CHARGES;
	private float _OTHER_CHARGES;
}