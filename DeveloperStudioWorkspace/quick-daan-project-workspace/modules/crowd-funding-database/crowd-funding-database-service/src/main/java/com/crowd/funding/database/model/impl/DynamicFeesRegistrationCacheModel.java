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

import com.crowd.funding.database.model.DynamicFeesRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DynamicFeesRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistration
 * @generated
 */
@ProviderType
public class DynamicFeesRegistrationCacheModel implements CacheModel<DynamicFeesRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DynamicFeesRegistrationCacheModel)) {
			return false;
		}

		DynamicFeesRegistrationCacheModel dynamicFeesRegistrationCacheModel = (DynamicFeesRegistrationCacheModel)obj;

		if (CATEGORY_ID == dynamicFeesRegistrationCacheModel.CATEGORY_ID) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", CATEGORY_ID=");
		sb.append(CATEGORY_ID);
		sb.append(", CATEGORY_NAME=");
		sb.append(CATEGORY_NAME);
		sb.append(", PROCESSING_FEES=");
		sb.append(PROCESSING_FEES);
		sb.append(", PROJECT_FEES=");
		sb.append(PROJECT_FEES);
		sb.append(", PAYMENT_GATEWAY_CHARGES=");
		sb.append(PAYMENT_GATEWAY_CHARGES);
		sb.append(", OTHER_CHARGES=");
		sb.append(OTHER_CHARGES);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DynamicFeesRegistration toEntityModel() {
		DynamicFeesRegistrationImpl dynamicFeesRegistrationImpl = new DynamicFeesRegistrationImpl();

		if (uuid == null) {
			dynamicFeesRegistrationImpl.setUuid("");
		}
		else {
			dynamicFeesRegistrationImpl.setUuid(uuid);
		}

		dynamicFeesRegistrationImpl.setCATEGORY_ID(CATEGORY_ID);

		if (CATEGORY_NAME == null) {
			dynamicFeesRegistrationImpl.setCATEGORY_NAME("");
		}
		else {
			dynamicFeesRegistrationImpl.setCATEGORY_NAME(CATEGORY_NAME);
		}

		dynamicFeesRegistrationImpl.setPROCESSING_FEES(PROCESSING_FEES);
		dynamicFeesRegistrationImpl.setPROJECT_FEES(PROJECT_FEES);
		dynamicFeesRegistrationImpl.setPAYMENT_GATEWAY_CHARGES(PAYMENT_GATEWAY_CHARGES);
		dynamicFeesRegistrationImpl.setOTHER_CHARGES(OTHER_CHARGES);

		dynamicFeesRegistrationImpl.resetOriginalValues();

		return dynamicFeesRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		CATEGORY_ID = objectInput.readLong();
		CATEGORY_NAME = objectInput.readUTF();

		PROCESSING_FEES = objectInput.readFloat();

		PROJECT_FEES = objectInput.readFloat();

		PAYMENT_GATEWAY_CHARGES = objectInput.readFloat();

		OTHER_CHARGES = objectInput.readFloat();
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

		objectOutput.writeFloat(PROCESSING_FEES);

		objectOutput.writeFloat(PROJECT_FEES);

		objectOutput.writeFloat(PAYMENT_GATEWAY_CHARGES);

		objectOutput.writeFloat(OTHER_CHARGES);
	}

	public String uuid;
	public long CATEGORY_ID;
	public String CATEGORY_NAME;
	public float PROCESSING_FEES;
	public float PROJECT_FEES;
	public float PAYMENT_GATEWAY_CHARGES;
	public float OTHER_CHARGES;
}