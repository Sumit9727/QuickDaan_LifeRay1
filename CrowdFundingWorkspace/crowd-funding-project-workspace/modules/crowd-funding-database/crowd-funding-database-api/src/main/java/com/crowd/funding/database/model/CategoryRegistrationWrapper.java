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
 * This class is a wrapper for {@link CategoryRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryRegistration
 * @generated
 */
@ProviderType
public class CategoryRegistrationWrapper implements CategoryRegistration,
	ModelWrapper<CategoryRegistration> {
	public CategoryRegistrationWrapper(
		CategoryRegistration categoryRegistration) {
		_categoryRegistration = categoryRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return CategoryRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return CategoryRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CATEGORY_ID", getCATEGORY_ID());
		attributes.put("CATEGORY_NAME", getCATEGORY_NAME());

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
	}

	@Override
	public Object clone() {
		return new CategoryRegistrationWrapper((CategoryRegistration)_categoryRegistration.clone());
	}

	@Override
	public int compareTo(CategoryRegistration categoryRegistration) {
		return _categoryRegistration.compareTo(categoryRegistration);
	}

	/**
	* Returns the category_id of this category registration.
	*
	* @return the category_id of this category registration
	*/
	@Override
	public long getCATEGORY_ID() {
		return _categoryRegistration.getCATEGORY_ID();
	}

	/**
	* Returns the category_name of this category registration.
	*
	* @return the category_name of this category registration
	*/
	@Override
	public String getCATEGORY_NAME() {
		return _categoryRegistration.getCATEGORY_NAME();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _categoryRegistration.getExpandoBridge();
	}

	/**
	* Returns the primary key of this category registration.
	*
	* @return the primary key of this category registration
	*/
	@Override
	public long getPrimaryKey() {
		return _categoryRegistration.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryRegistration.getPrimaryKeyObj();
	}

	/**
	* Returns the uuid of this category registration.
	*
	* @return the uuid of this category registration
	*/
	@Override
	public String getUuid() {
		return _categoryRegistration.getUuid();
	}

	@Override
	public int hashCode() {
		return _categoryRegistration.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _categoryRegistration.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _categoryRegistration.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _categoryRegistration.isNew();
	}

	@Override
	public void persist() {
		_categoryRegistration.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_categoryRegistration.setCachedModel(cachedModel);
	}

	/**
	* Sets the category_id of this category registration.
	*
	* @param CATEGORY_ID the category_id of this category registration
	*/
	@Override
	public void setCATEGORY_ID(long CATEGORY_ID) {
		_categoryRegistration.setCATEGORY_ID(CATEGORY_ID);
	}

	/**
	* Sets the category_name of this category registration.
	*
	* @param CATEGORY_NAME the category_name of this category registration
	*/
	@Override
	public void setCATEGORY_NAME(String CATEGORY_NAME) {
		_categoryRegistration.setCATEGORY_NAME(CATEGORY_NAME);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_categoryRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_categoryRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_categoryRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_categoryRegistration.setNew(n);
	}

	/**
	* Sets the primary key of this category registration.
	*
	* @param primaryKey the primary key of this category registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_categoryRegistration.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_categoryRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the uuid of this category registration.
	*
	* @param uuid the uuid of this category registration
	*/
	@Override
	public void setUuid(String uuid) {
		_categoryRegistration.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CategoryRegistration> toCacheModel() {
		return _categoryRegistration.toCacheModel();
	}

	@Override
	public CategoryRegistration toEscapedModel() {
		return new CategoryRegistrationWrapper(_categoryRegistration.toEscapedModel());
	}

	@Override
	public String toString() {
		return _categoryRegistration.toString();
	}

	@Override
	public CategoryRegistration toUnescapedModel() {
		return new CategoryRegistrationWrapper(_categoryRegistration.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _categoryRegistration.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryRegistrationWrapper)) {
			return false;
		}

		CategoryRegistrationWrapper categoryRegistrationWrapper = (CategoryRegistrationWrapper)obj;

		if (Objects.equals(_categoryRegistration,
					categoryRegistrationWrapper._categoryRegistration)) {
			return true;
		}

		return false;
	}

	@Override
	public CategoryRegistration getWrappedModel() {
		return _categoryRegistration;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _categoryRegistration.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _categoryRegistration.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_categoryRegistration.resetOriginalValues();
	}

	private final CategoryRegistration _categoryRegistration;
}