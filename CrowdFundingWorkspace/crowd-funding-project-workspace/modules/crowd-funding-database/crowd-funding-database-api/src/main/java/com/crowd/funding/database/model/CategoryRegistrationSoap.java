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
 * This class is used by SOAP remote services, specifically {@link com.crowd.funding.database.service.http.CategoryRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.crowd.funding.database.service.http.CategoryRegistrationServiceSoap
 * @generated
 */
@ProviderType
public class CategoryRegistrationSoap implements Serializable {
	public static CategoryRegistrationSoap toSoapModel(
		CategoryRegistration model) {
		CategoryRegistrationSoap soapModel = new CategoryRegistrationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCATEGORY_ID(model.getCATEGORY_ID());
		soapModel.setCATEGORY_NAME(model.getCATEGORY_NAME());

		return soapModel;
	}

	public static CategoryRegistrationSoap[] toSoapModels(
		CategoryRegistration[] models) {
		CategoryRegistrationSoap[] soapModels = new CategoryRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoryRegistrationSoap[][] toSoapModels(
		CategoryRegistration[][] models) {
		CategoryRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategoryRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoryRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoryRegistrationSoap[] toSoapModels(
		List<CategoryRegistration> models) {
		List<CategoryRegistrationSoap> soapModels = new ArrayList<CategoryRegistrationSoap>(models.size());

		for (CategoryRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoryRegistrationSoap[soapModels.size()]);
	}

	public CategoryRegistrationSoap() {
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

	private String _uuid;
	private long _CATEGORY_ID;
	private String _CATEGORY_NAME;
}