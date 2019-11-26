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

package com.crowd.funding.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.CategoryRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CategoryRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryRegistration
 * @generated
 */
@ProviderType
public class CategoryRegistrationCacheModel implements CacheModel<CategoryRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryRegistrationCacheModel)) {
			return false;
		}

		CategoryRegistrationCacheModel categoryRegistrationCacheModel = (CategoryRegistrationCacheModel)obj;

		if (CATEGORY_ID == categoryRegistrationCacheModel.CATEGORY_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, CATEGORY_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", CATEGORY_ID=");
		sb.append(CATEGORY_ID);
		sb.append(", CATEGORY_NAME=");
		sb.append(CATEGORY_NAME);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CategoryRegistration toEntityModel() {
		CategoryRegistrationImpl categoryRegistrationImpl = new CategoryRegistrationImpl();

		if (uuid == null) {
			categoryRegistrationImpl.setUuid("");
		}
		else {
			categoryRegistrationImpl.setUuid(uuid);
		}

		categoryRegistrationImpl.setCATEGORY_ID(CATEGORY_ID);

		if (CATEGORY_NAME == null) {
			categoryRegistrationImpl.setCATEGORY_NAME("");
		}
		else {
			categoryRegistrationImpl.setCATEGORY_NAME(CATEGORY_NAME);
		}

		categoryRegistrationImpl.resetOriginalValues();

		return categoryRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		CATEGORY_ID = objectInput.readLong();
		CATEGORY_NAME = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(CATEGORY_ID);

		if (CATEGORY_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CATEGORY_NAME);
		}
	}

	public String uuid;
	public long CATEGORY_ID;
	public String CATEGORY_NAME;
}