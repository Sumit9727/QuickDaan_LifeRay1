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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.UserOTPRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.UserOTPRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class UserOTPRegistrationSoap implements Serializable {
	public static UserOTPRegistrationSoap toSoapModel(UserOTPRegistration model) {
		UserOTPRegistrationSoap soapModel = new UserOTPRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUSER_OTP_ID(model.getUSER_OTP_ID());
		soapModel.setMOBILE_NO(model.getMOBILE_NO());
		soapModel.setMAIL(model.getMAIL());
		soapModel.setOTP(model.getOTP());
		soapModel.setOTP_DEVICE(model.getOTP_DEVICE());
		soapModel.setOTP_VERIFICATION_STATUS(model.getOTP_VERIFICATION_STATUS());
		soapModel.setCREATION_DATE_TIME(model.getCREATION_DATE_TIME());

		return soapModel;
	}

	public static UserOTPRegistrationSoap[] toSoapModels(
		UserOTPRegistration[] models) {
		UserOTPRegistrationSoap[] soapModels = new UserOTPRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserOTPRegistrationSoap[][] toSoapModels(
		UserOTPRegistration[][] models) {
		UserOTPRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserOTPRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserOTPRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserOTPRegistrationSoap[] toSoapModels(
		List<UserOTPRegistration> models) {
		List<UserOTPRegistrationSoap> soapModels = new ArrayList<UserOTPRegistrationSoap>(models.size());

		for (UserOTPRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserOTPRegistrationSoap[soapModels.size()]);
	}

	public UserOTPRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _USER_OTP_ID;
	}

	public void setPrimaryKey(long pk) {
		setUSER_OTP_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUSER_OTP_ID() {
		return _USER_OTP_ID;
	}

	public void setUSER_OTP_ID(long USER_OTP_ID) {
		_USER_OTP_ID = USER_OTP_ID;
	}

	public long getMOBILE_NO() {
		return _MOBILE_NO;
	}

	public void setMOBILE_NO(long MOBILE_NO) {
		_MOBILE_NO = MOBILE_NO;
	}

	public String getMAIL() {
		return _MAIL;
	}

	public void setMAIL(String MAIL) {
		_MAIL = MAIL;
	}

	public int getOTP() {
		return _OTP;
	}

	public void setOTP(int OTP) {
		_OTP = OTP;
	}

	public int getOTP_DEVICE() {
		return _OTP_DEVICE;
	}

	public void setOTP_DEVICE(int OTP_DEVICE) {
		_OTP_DEVICE = OTP_DEVICE;
	}

	public int getOTP_VERIFICATION_STATUS() {
		return _OTP_VERIFICATION_STATUS;
	}

	public void setOTP_VERIFICATION_STATUS(int OTP_VERIFICATION_STATUS) {
		_OTP_VERIFICATION_STATUS = OTP_VERIFICATION_STATUS;
	}

	public Date getCREATION_DATE_TIME() {
		return _CREATION_DATE_TIME;
	}

	public void setCREATION_DATE_TIME(Date CREATION_DATE_TIME) {
		_CREATION_DATE_TIME = CREATION_DATE_TIME;
	}

	private String _uuid;
	private long _USER_OTP_ID;
	private long _MOBILE_NO;
	private String _MAIL;
	private int _OTP;
	private int _OTP_DEVICE;
	private int _OTP_VERIFICATION_STATUS;
	private Date _CREATION_DATE_TIME;
}