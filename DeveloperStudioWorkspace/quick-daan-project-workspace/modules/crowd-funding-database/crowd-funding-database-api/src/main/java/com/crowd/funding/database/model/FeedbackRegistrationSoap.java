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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.FeedbackRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.FeedbackRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class FeedbackRegistrationSoap implements Serializable {
	public static FeedbackRegistrationSoap toSoapModel(
		FeedbackRegistration model) {
		FeedbackRegistrationSoap soapModel = new FeedbackRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPROJECT_FEEDBACK_ID(model.getPROJECT_FEEDBACK_ID());
		soapModel.setPROJECT_ID(model.getPROJECT_ID());
		soapModel.setFEEDBACK(model.getFEEDBACK());
		soapModel.setDONOR_USER_ID(model.getDONOR_USER_ID());
		soapModel.setFEEDBACK_DATE(model.getFEEDBACK_DATE());
		soapModel.setSTATUS(model.getSTATUS());

		return soapModel;
	}

	public static FeedbackRegistrationSoap[] toSoapModels(
		FeedbackRegistration[] models) {
		FeedbackRegistrationSoap[] soapModels = new FeedbackRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedbackRegistrationSoap[][] toSoapModels(
		FeedbackRegistration[][] models) {
		FeedbackRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedbackRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedbackRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedbackRegistrationSoap[] toSoapModels(
		List<FeedbackRegistration> models) {
		List<FeedbackRegistrationSoap> soapModels = new ArrayList<FeedbackRegistrationSoap>(models.size());

		for (FeedbackRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedbackRegistrationSoap[soapModels.size()]);
	}

	public FeedbackRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _PROJECT_FEEDBACK_ID;
	}

	public void setPrimaryKey(long pk) {
		setPROJECT_FEEDBACK_ID(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPROJECT_FEEDBACK_ID() {
		return _PROJECT_FEEDBACK_ID;
	}

	public void setPROJECT_FEEDBACK_ID(long PROJECT_FEEDBACK_ID) {
		_PROJECT_FEEDBACK_ID = PROJECT_FEEDBACK_ID;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public String getFEEDBACK() {
		return _FEEDBACK;
	}

	public void setFEEDBACK(String FEEDBACK) {
		_FEEDBACK = FEEDBACK;
	}

	public long getDONOR_USER_ID() {
		return _DONOR_USER_ID;
	}

	public void setDONOR_USER_ID(long DONOR_USER_ID) {
		_DONOR_USER_ID = DONOR_USER_ID;
	}

	public Date getFEEDBACK_DATE() {
		return _FEEDBACK_DATE;
	}

	public void setFEEDBACK_DATE(Date FEEDBACK_DATE) {
		_FEEDBACK_DATE = FEEDBACK_DATE;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	private String _uuid;
	private long _PROJECT_FEEDBACK_ID;
	private long _PROJECT_ID;
	private String _FEEDBACK;
	private long _DONOR_USER_ID;
	private Date _FEEDBACK_DATE;
	private int _STATUS;
}