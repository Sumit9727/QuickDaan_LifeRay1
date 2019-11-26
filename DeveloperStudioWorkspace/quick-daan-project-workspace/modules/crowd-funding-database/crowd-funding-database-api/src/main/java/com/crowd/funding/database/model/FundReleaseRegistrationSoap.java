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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.FundReleaseRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.FundReleaseRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class FundReleaseRegistrationSoap implements Serializable {
	public static FundReleaseRegistrationSoap toSoapModel(
		FundReleaseRegistration model) {
		FundReleaseRegistrationSoap soapModel = new FundReleaseRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFUND_RELEASE_ID(model.getFUND_RELEASE_ID());
		soapModel.setPROJECT_FEES_ID(model.getPROJECT_FEES_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setCURRENCY(model.getCURRENCY());
		soapModel.setPROCESSING_FEES(model.getPROCESSING_FEES());
		soapModel.setPROJECT_FEES(model.getPROJECT_FEES());
		soapModel.setPAYMENT_GATEWAY_CHARGES(model.getPAYMENT_GATEWAY_CHARGES());
		soapModel.setOTHER_CHARGES(model.getOTHER_CHARGES());
		soapModel.setTOTAL_WITHDRAW_AMOUNT(model.getTOTAL_WITHDRAW_AMOUNT());
		soapModel.setSTATUS(model.getSTATUS());
		soapModel.setRELEASE_DATE(model.getRELEASE_DATE());
		soapModel.setREQUEST_DATE(model.getREQUEST_DATE());

		return soapModel;
	}

	public static FundReleaseRegistrationSoap[] toSoapModels(
		FundReleaseRegistration[] models) {
		FundReleaseRegistrationSoap[] soapModels = new FundReleaseRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundReleaseRegistrationSoap[][] toSoapModels(
		FundReleaseRegistration[][] models) {
		FundReleaseRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundReleaseRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundReleaseRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundReleaseRegistrationSoap[] toSoapModels(
		List<FundReleaseRegistration> models) {
		List<FundReleaseRegistrationSoap> soapModels = new ArrayList<FundReleaseRegistrationSoap>(models.size());

		for (FundReleaseRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundReleaseRegistrationSoap[soapModels.size()]);
	}

	public FundReleaseRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _FUND_RELEASE_ID;
	}

	public void setPrimaryKey(long pk) {
		setFUND_RELEASE_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFUND_RELEASE_ID() {
		return _FUND_RELEASE_ID;
	}

	public void setFUND_RELEASE_ID(long FUND_RELEASE_ID) {
		_FUND_RELEASE_ID = FUND_RELEASE_ID;
	}

	public long getPROJECT_FEES_ID() {
		return _PROJECT_FEES_ID;
	}

	public void setPROJECT_FEES_ID(long PROJECT_FEES_ID) {
		_PROJECT_FEES_ID = PROJECT_FEES_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getCURRENCY() {
		return _CURRENCY;
	}

	public void setCURRENCY(String CURRENCY) {
		_CURRENCY = CURRENCY;
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

	public float getTOTAL_WITHDRAW_AMOUNT() {
		return _TOTAL_WITHDRAW_AMOUNT;
	}

	public void setTOTAL_WITHDRAW_AMOUNT(float TOTAL_WITHDRAW_AMOUNT) {
		_TOTAL_WITHDRAW_AMOUNT = TOTAL_WITHDRAW_AMOUNT;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	public Date getRELEASE_DATE() {
		return _RELEASE_DATE;
	}

	public void setRELEASE_DATE(Date RELEASE_DATE) {
		_RELEASE_DATE = RELEASE_DATE;
	}

	public Date getREQUEST_DATE() {
		return _REQUEST_DATE;
	}

	public void setREQUEST_DATE(Date REQUEST_DATE) {
		_REQUEST_DATE = REQUEST_DATE;
	}

	private String _uuid;
	private long _FUND_RELEASE_ID;
	private long _PROJECT_FEES_ID;
	private long _PROJECT_ID;
	private String _CURRENCY;
	private float _PROCESSING_FEES;
	private float _PROJECT_FEES;
	private float _PAYMENT_GATEWAY_CHARGES;
	private float _OTHER_CHARGES;
	private float _TOTAL_WITHDRAW_AMOUNT;
	private int _STATUS;
	private Date _RELEASE_DATE;
	private Date _REQUEST_DATE;
}