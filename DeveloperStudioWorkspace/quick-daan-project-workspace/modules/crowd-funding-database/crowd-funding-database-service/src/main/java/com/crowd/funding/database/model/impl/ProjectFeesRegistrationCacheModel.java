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

import com.crowd.funding.database.model.ProjectFeesRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectFeesRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistration
 * @generated
 */
@ProviderType
public class ProjectFeesRegistrationCacheModel implements CacheModel<ProjectFeesRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectFeesRegistrationCacheModel)) {
			return false;
		}

		ProjectFeesRegistrationCacheModel projectFeesRegistrationCacheModel = (ProjectFeesRegistrationCacheModel)obj;

		if (PROJECT_FEES_ID == projectFeesRegistrationCacheModel.PROJECT_FEES_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_FEES_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_FEES_ID=");
		sb.append(PROJECT_FEES_ID);
		sb.append(", CATEGORY_ID=");
		sb.append(CATEGORY_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", START_AMOUNT=");
		sb.append(START_AMOUNT);
		sb.append(", END_AMOUNT=");
		sb.append(END_AMOUNT);
		sb.append(", WITHDRAW_STATUS=");
		sb.append(WITHDRAW_STATUS);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectFeesRegistration toEntityModel() {
		ProjectFeesRegistrationImpl projectFeesRegistrationImpl = new ProjectFeesRegistrationImpl();

		if (uuid == null) {
			projectFeesRegistrationImpl.setUuid("");
		}
		else {
			projectFeesRegistrationImpl.setUuid(uuid);
		}

		projectFeesRegistrationImpl.setPROJECT_FEES_ID(PROJECT_FEES_ID);
		projectFeesRegistrationImpl.setCATEGORY_ID(CATEGORY_ID);
		projectFeesRegistrationImpl.setPROJECT_ID(PROJECT_ID);
		projectFeesRegistrationImpl.setSTART_AMOUNT(START_AMOUNT);
		projectFeesRegistrationImpl.setEND_AMOUNT(END_AMOUNT);
		projectFeesRegistrationImpl.setWITHDRAW_STATUS(WITHDRAW_STATUS);

		if (DATE == Long.MIN_VALUE) {
			projectFeesRegistrationImpl.setDATE(null);
		}
		else {
			projectFeesRegistrationImpl.setDATE(new Date(DATE));
		}

		projectFeesRegistrationImpl.resetOriginalValues();

		return projectFeesRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_FEES_ID = objectInput.readLong();

		CATEGORY_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();

		START_AMOUNT = objectInput.readFloat();

		END_AMOUNT = objectInput.readFloat();

		WITHDRAW_STATUS = objectInput.readInt();
		DATE = objectInput.readLong();
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

		objectOutput.writeLong(PROJECT_FEES_ID);

		objectOutput.writeLong(CATEGORY_ID);

		objectOutput.writeLong(PROJECT_ID);

		objectOutput.writeFloat(START_AMOUNT);

		objectOutput.writeFloat(END_AMOUNT);

		objectOutput.writeInt(WITHDRAW_STATUS);
		objectOutput.writeLong(DATE);
	}

	public String uuid;
	public long PROJECT_FEES_ID;
	public long CATEGORY_ID;
	public long PROJECT_ID;
	public float START_AMOUNT;
	public float END_AMOUNT;
	public int WITHDRAW_STATUS;
	public long DATE;
}