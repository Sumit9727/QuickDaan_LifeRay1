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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DynamicFeesRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistration
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationWrapper implements DynamicFeesRegistration,
	ModelWrapper<DynamicFeesRegistration> {
	public DynamicFeesRegistrationWrapper(
		DynamicFeesRegistration dynamicFeesRegistration) {
		_dynamicFeesRegistration = dynamicFeesRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return DynamicFeesRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return DynamicFeesRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CATEGORY_ID", getCATEGORY_ID());
		attributes.put("CATEGORY_NAME", getCATEGORY_NAME());
		attributes.put("PROCESSING_FEES", getPROCESSING_FEES());
		attributes.put("PROJECT_FEES", getPROJECT_FEES());
		attributes.put("PAYMENT_GATEWAY_CHARGES", getPAYMENT_GATEWAY_CHARGES());
		attributes.put("OTHER_CHARGES", getOTHER_CHARGES());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long CATEGORY_ID = (Long)attributes.get("CATEGORY_ID");

		if (CATEGORY_ID != null) {
			setCATEGORY_ID(CATEGORY_ID);
		}

		String CATEGORY_NAME = (String)attributes.get("CATEGORY_NAME");

		if (CATEGORY_NAME != null) {
			setCATEGORY_NAME(CATEGORY_NAME);
		}

		Float PROCESSING_FEES = (Float)attributes.get("PROCESSING_FEES");

		if (PROCESSING_FEES != null) {
			setPROCESSING_FEES(PROCESSING_FEES);
		}

		Float PROJECT_FEES = (Float)attributes.get("PROJECT_FEES");

		if (PROJECT_FEES != null) {
			setPROJECT_FEES(PROJECT_FEES);
		}

		Float PAYMENT_GATEWAY_CHARGES = (Float)attributes.get(
				"PAYMENT_GATEWAY_CHARGES");

		if (PAYMENT_GATEWAY_CHARGES != null) {
			setPAYMENT_GATEWAY_CHARGES(PAYMENT_GATEWAY_CHARGES);
		}

		Float OTHER_CHARGES = (Float)attributes.get("OTHER_CHARGES");

		if (OTHER_CHARGES != null) {
			setOTHER_CHARGES(OTHER_CHARGES);
		}
	}

	@Override
	public Object clone() {
		return new DynamicFeesRegistrationWrapper((DynamicFeesRegistration)_dynamicFeesRegistration.clone());
	}

	@Override
	public int compareTo(DynamicFeesRegistration dynamicFeesRegistration) {
		return _dynamicFeesRegistration.compareTo(dynamicFeesRegistration);
	}

	/**
	* Returns the category_id of this dynamic fees registration.
	*
	* @return the category_id of this dynamic fees registration
	*/
	@Override
	public long getCATEGORY_ID() {
		return _dynamicFeesRegistration.getCATEGORY_ID();
	}

	/**
	* Returns the category_name of this dynamic fees registration.
	*
	* @return the category_name of this dynamic fees registration
	*/
	@Override
	public String getCATEGORY_NAME() {
		return _dynamicFeesRegistration.getCATEGORY_NAME();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dynamicFeesRegistration.getExpandoBridge();
	}

	/**
	* Returns the other_charges of this dynamic fees registration.
	*
	* @return the other_charges of this dynamic fees registration
	*/
	@Override
	public float getOTHER_CHARGES() {
		return _dynamicFeesRegistration.getOTHER_CHARGES();
	}

	/**
	* Returns the payment_gateway_charges of this dynamic fees registration.
	*
	* @return the payment_gateway_charges of this dynamic fees registration
	*/
	@Override
	public float getPAYMENT_GATEWAY_CHARGES() {
		return _dynamicFeesRegistration.getPAYMENT_GATEWAY_CHARGES();
	}

	/**
	* Returns the primary key of this dynamic fees registration.
	*
	* @return the primary key of this dynamic fees registration
	*/
	@Override
	public long getPrimaryKey() {
		return _dynamicFeesRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dynamicFeesRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the processing_fees of this dynamic fees registration.
	*
	* @return the processing_fees of this dynamic fees registration
	*/
	@Override
	public float getPROCESSING_FEES() {
		return _dynamicFeesRegistration.getPROCESSING_FEES();
	}

	/**
	* Returns the project_fees of this dynamic fees registration.
	*
	* @return the project_fees of this dynamic fees registration
	*/
	@Override
	public float getPROJECT_FEES() {
		return _dynamicFeesRegistration.getPROJECT_FEES();
	}

	/**
	* Returns the uuid of this dynamic fees registration.
	*
	* @return the uuid of this dynamic fees registration
	*/
	@Override
	public String getUuid() {
		return _dynamicFeesRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _dynamicFeesRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dynamicFeesRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dynamicFeesRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dynamicFeesRegistration.isNew();
	}

	@Override
	public void persist() {
		_dynamicFeesRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dynamicFeesRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the category_id of this dynamic fees registration.
	*
	* @param CATEGORY_ID the category_id of this dynamic fees registration
	*/
	@Override
	public void setCATEGORY_ID(long CATEGORY_ID) {
		_dynamicFeesRegistration.setCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Sets the category_name of this dynamic fees registration.
	*
	* @param CATEGORY_NAME the category_name of this dynamic fees registration
	*/
	@Override
	public void setCATEGORY_NAME(String CATEGORY_NAME) {
		_dynamicFeesRegistration.setCATEGORY_NAME(CATEGORY_NAME);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dynamicFeesRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dynamicFeesRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dynamicFeesRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_dynamicFeesRegistration.setNew(n);
	}

	/**
	* Sets the other_charges of this dynamic fees registration.
	*
	* @param OTHER_CHARGES the other_charges of this dynamic fees registration
	*/
	@Override
	public void setOTHER_CHARGES(float OTHER_CHARGES) {
		_dynamicFeesRegistration.setOTHER_CHARGES(OTHER_CHARGES);
	}

	/**
	* Sets the payment_gateway_charges of this dynamic fees registration.
	*
	* @param PAYMENT_GATEWAY_CHARGES the payment_gateway_charges of this dynamic fees registration
	*/
	@Override
	public void setPAYMENT_GATEWAY_CHARGES(float PAYMENT_GATEWAY_CHARGES) {
		_dynamicFeesRegistration.setPAYMENT_GATEWAY_CHARGES(PAYMENT_GATEWAY_CHARGES);
	}

	/**
	* Sets the primary key of this dynamic fees registration.
	*
	* @param primaryKey the primary key of this dynamic fees registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dynamicFeesRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dynamicFeesRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the processing_fees of this dynamic fees registration.
	*
	* @param PROCESSING_FEES the processing_fees of this dynamic fees registration
	*/
	@Override
	public void setPROCESSING_FEES(float PROCESSING_FEES) {
		_dynamicFeesRegistration.setPROCESSING_FEES(PROCESSING_FEES);
	}

	/**
	* Sets the project_fees of this dynamic fees registration.
	*
	* @param PROJECT_FEES the project_fees of this dynamic fees registration
	*/
	@Override
	public void setPROJECT_FEES(float PROJECT_FEES) {
		_dynamicFeesRegistration.setPROJECT_FEES(PROJECT_FEES);
	}

	/**
	* Sets the uuid of this dynamic fees registration.
	*
	* @param uuid the uuid of this dynamic fees registration
	*/
	@Override
	public void setUuid(String uuid) {
		_dynamicFeesRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DynamicFeesRegistration> toCacheModel() {
		return _dynamicFeesRegistration.toCacheModel();
	}

	@Override
	public DynamicFeesRegistration toEscapedModel() {
		return new DynamicFeesRegistrationWrapper(_dynamicFeesRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dynamicFeesRegistration.toString();
	}

	@Override
	public DynamicFeesRegistration toUnescapedModel() {
		return new DynamicFeesRegistrationWrapper(_dynamicFeesRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _dynamicFeesRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DynamicFeesRegistrationWrapper)) {
			return false;
		}

		DynamicFeesRegistrationWrapper dynamicFeesRegistrationWrapper = (DynamicFeesRegistrationWrapper)obj;

		if (Objects.equals(_dynamicFeesRegistration,
					dynamicFeesRegistrationWrapper._dynamicFeesRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public DynamicFeesRegistration getWrappedModel() {
		return _dynamicFeesRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dynamicFeesRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dynamicFeesRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dynamicFeesRegistration.resetOriginalValues();
	}

	private final DynamicFeesRegistration _dynamicFeesRegistration;
}