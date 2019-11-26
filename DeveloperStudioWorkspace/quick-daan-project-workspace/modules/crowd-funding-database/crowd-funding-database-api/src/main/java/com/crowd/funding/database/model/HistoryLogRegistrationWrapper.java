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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link HistoryLogRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HistoryLogRegistration
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationWrapper implements HistoryLogRegistration,
	ModelWrapper<HistoryLogRegistration> {
	public HistoryLogRegistrationWrapper(
		HistoryLogRegistration historyLogRegistration) {
		_historyLogRegistration = historyLogRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return HistoryLogRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return HistoryLogRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("HISTORY_ID", getHISTORY_ID());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("URL", getURL());
		attributes.put("DATE", getDATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long HISTORY_ID = (Long)attributes.get("HISTORY_ID");

		if (HISTORY_ID != null) {
			setHISTORY_ID(HISTORY_ID);
		}

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	@Override
	public Object clone() {
		return new HistoryLogRegistrationWrapper((HistoryLogRegistration)_historyLogRegistration.clone());
	}

	@Override
	public int compareTo(HistoryLogRegistration historyLogRegistration) {
		return _historyLogRegistration.compareTo(historyLogRegistration);
	}

	/**
	* Returns the date of this history log registration.
	*
	* @return the date of this history log registration
	*/
	@Override
	public Date getDATE() {
		return _historyLogRegistration.getDATE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _historyLogRegistration.getExpandoBridge();
	}

	/**
	* Returns the history_id of this history log registration.
	*
	* @return the history_id of this history log registration
	*/
	@Override
	public long getHISTORY_ID() {
		return _historyLogRegistration.getHISTORY_ID();
	}

	/**
	* Returns the primary key of this history log registration.
	*
	* @return the primary key of this history log registration
	*/
	@Override
	public long getPrimaryKey() {
		return _historyLogRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _historyLogRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the url of this history log registration.
	*
	* @return the url of this history log registration
	*/
	@Override
	public String getURL() {
		return _historyLogRegistration.getURL();
	}

	/**
	* Returns the user_id of this history log registration.
	*
	* @return the user_id of this history log registration
	*/
	@Override
	public long getUSER_ID() {
		return _historyLogRegistration.getUSER_ID();
	}

	/**
	* Returns the uuid of this history log registration.
	*
	* @return the uuid of this history log registration
	*/
	@Override
	public String getUuid() {
		return _historyLogRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _historyLogRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _historyLogRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _historyLogRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _historyLogRegistration.isNew();
	}

	@Override
	public void persist() {
		_historyLogRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_historyLogRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the date of this history log registration.
	*
	* @param DATE the date of this history log registration
	*/
	@Override
	public void setDATE(Date DATE) {
		_historyLogRegistration.setDATE(DATE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_historyLogRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_historyLogRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_historyLogRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the history_id of this history log registration.
	*
	* @param HISTORY_ID the history_id of this history log registration
	*/
	@Override
	public void setHISTORY_ID(long HISTORY_ID) {
		_historyLogRegistration.setHISTORY_ID(HISTORY_ID);
	}

	@Override
	public void setNew(boolean n) {
		_historyLogRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this history log registration.
	*
	* @param primaryKey the primary key of this history log registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_historyLogRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_historyLogRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url of this history log registration.
	*
	* @param URL the url of this history log registration
	*/
	@Override
	public void setURL(String URL) {
		_historyLogRegistration.setURL(URL);
	}

	/**
	* Sets the user_id of this history log registration.
	*
	* @param USER_ID the user_id of this history log registration
	*/
	@Override
	public void setUSER_ID(long USER_ID) {
		_historyLogRegistration.setUSER_ID(USER_ID);
	}

	/**
	* Sets the uuid of this history log registration.
	*
	* @param uuid the uuid of this history log registration
	*/
	@Override
	public void setUuid(String uuid) {
		_historyLogRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<HistoryLogRegistration> toCacheModel() {
		return _historyLogRegistration.toCacheModel();
	}

	@Override
	public HistoryLogRegistration toEscapedModel() {
		return new HistoryLogRegistrationWrapper(_historyLogRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _historyLogRegistration.toString();
	}

	@Override
	public HistoryLogRegistration toUnescapedModel() {
		return new HistoryLogRegistrationWrapper(_historyLogRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _historyLogRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryLogRegistrationWrapper)) {
			return false;
		}

		HistoryLogRegistrationWrapper historyLogRegistrationWrapper = (HistoryLogRegistrationWrapper)obj;

		if (Objects.equals(_historyLogRegistration,
					historyLogRegistrationWrapper._historyLogRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public HistoryLogRegistration getWrappedModel() {
		return _historyLogRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _historyLogRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _historyLogRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_historyLogRegistration.resetOriginalValues();
	}

	private final HistoryLogRegistration _historyLogRegistration;
}