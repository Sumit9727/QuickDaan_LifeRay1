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

import com.crowd.funding.database.model.PostionRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PostionRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see PostionRegistration
 * @generated
 */
@ProviderType
public class PostionRegistrationCacheModel implements CacheModel<PostionRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PostionRegistrationCacheModel)) {
			return false;
		}

		PostionRegistrationCacheModel postionRegistrationCacheModel = (PostionRegistrationCacheModel)obj;

		if (POSITION_ID == postionRegistrationCacheModel.POSITION_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, POSITION_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", POSITION_ID=");
		sb.append(POSITION_ID);
		sb.append(", ADVERTISMENT_NUM=");
		sb.append(ADVERTISMENT_NUM);
		sb.append(", POSITION_NAME=");
		sb.append(POSITION_NAME);
		sb.append(", DESCRIPTION=");
		sb.append(DESCRIPTION);
		sb.append(", EXPERIENCE_LEVEL=");
		sb.append(EXPERIENCE_LEVEL);
		sb.append(", SALARY=");
		sb.append(SALARY);
		sb.append(", INDUSTRY_TYPE=");
		sb.append(INDUSTRY_TYPE);
		sb.append(", FUNCTIONAL_AREA=");
		sb.append(FUNCTIONAL_AREA);
		sb.append(", ROLE_CATEGORY=");
		sb.append(ROLE_CATEGORY);
		sb.append(", EMPLOYMENT_TYPE=");
		sb.append(EMPLOYMENT_TYPE);
		sb.append(", LOCATION=");
		sb.append(LOCATION);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PostionRegistration toEntityModel() {
		PostionRegistrationImpl postionRegistrationImpl = new PostionRegistrationImpl();

		if (uuid == null) {
			postionRegistrationImpl.setUuid("");
		}
		else {
			postionRegistrationImpl.setUuid(uuid);
		}

		postionRegistrationImpl.setPOSITION_ID(POSITION_ID);

		if (ADVERTISMENT_NUM == null) {
			postionRegistrationImpl.setADVERTISMENT_NUM("");
		}
		else {
			postionRegistrationImpl.setADVERTISMENT_NUM(ADVERTISMENT_NUM);
		}

		if (POSITION_NAME == null) {
			postionRegistrationImpl.setPOSITION_NAME("");
		}
		else {
			postionRegistrationImpl.setPOSITION_NAME(POSITION_NAME);
		}

		if (DESCRIPTION == null) {
			postionRegistrationImpl.setDESCRIPTION("");
		}
		else {
			postionRegistrationImpl.setDESCRIPTION(DESCRIPTION);
		}

		if (EXPERIENCE_LEVEL == null) {
			postionRegistrationImpl.setEXPERIENCE_LEVEL("");
		}
		else {
			postionRegistrationImpl.setEXPERIENCE_LEVEL(EXPERIENCE_LEVEL);
		}

		if (SALARY == null) {
			postionRegistrationImpl.setSALARY("");
		}
		else {
			postionRegistrationImpl.setSALARY(SALARY);
		}

		if (INDUSTRY_TYPE == null) {
			postionRegistrationImpl.setINDUSTRY_TYPE("");
		}
		else {
			postionRegistrationImpl.setINDUSTRY_TYPE(INDUSTRY_TYPE);
		}

		if (FUNCTIONAL_AREA == null) {
			postionRegistrationImpl.setFUNCTIONAL_AREA("");
		}
		else {
			postionRegistrationImpl.setFUNCTIONAL_AREA(FUNCTIONAL_AREA);
		}

		if (ROLE_CATEGORY == null) {
			postionRegistrationImpl.setROLE_CATEGORY("");
		}
		else {
			postionRegistrationImpl.setROLE_CATEGORY(ROLE_CATEGORY);
		}

		if (EMPLOYMENT_TYPE == null) {
			postionRegistrationImpl.setEMPLOYMENT_TYPE("");
		}
		else {
			postionRegistrationImpl.setEMPLOYMENT_TYPE(EMPLOYMENT_TYPE);
		}

		if (LOCATION == null) {
			postionRegistrationImpl.setLOCATION("");
		}
		else {
			postionRegistrationImpl.setLOCATION(LOCATION);
		}

		if (DATE == Long.MIN_VALUE) {
			postionRegistrationImpl.setDATE(null);
		}
		else {
			postionRegistrationImpl.setDATE(new Date(DATE));
		}

		postionRegistrationImpl.setSTATUS(STATUS);

		postionRegistrationImpl.resetOriginalValues();

		return postionRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		POSITION_ID = objectInput.readLong();
		ADVERTISMENT_NUM = objectInput.readUTF();
		POSITION_NAME = objectInput.readUTF();
		DESCRIPTION = objectInput.readUTF();
		EXPERIENCE_LEVEL = objectInput.readUTF();
		SALARY = objectInput.readUTF();
		INDUSTRY_TYPE = objectInput.readUTF();
		FUNCTIONAL_AREA = objectInput.readUTF();
		ROLE_CATEGORY = objectInput.readUTF();
		EMPLOYMENT_TYPE = objectInput.readUTF();
		LOCATION = objectInput.readUTF();
		DATE = objectInput.readLong();

		STATUS = objectInput.readInt();
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

		objectOutput.writeLong(POSITION_ID);

		if (ADVERTISMENT_NUM == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ADVERTISMENT_NUM);
		}

		if (POSITION_NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(POSITION_NAME);
		}

		if (DESCRIPTION == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DESCRIPTION);
		}

		if (EXPERIENCE_LEVEL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EXPERIENCE_LEVEL);
		}

		if (SALARY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SALARY);
		}

		if (INDUSTRY_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(INDUSTRY_TYPE);
		}

		if (FUNCTIONAL_AREA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FUNCTIONAL_AREA);
		}

		if (ROLE_CATEGORY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ROLE_CATEGORY);
		}

		if (EMPLOYMENT_TYPE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EMPLOYMENT_TYPE);
		}

		if (LOCATION == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LOCATION);
		}

		objectOutput.writeLong(DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long POSITION_ID;
	public String ADVERTISMENT_NUM;
	public String POSITION_NAME;
	public String DESCRIPTION;
	public String EXPERIENCE_LEVEL;
	public String SALARY;
	public String INDUSTRY_TYPE;
	public String FUNCTIONAL_AREA;
	public String ROLE_CATEGORY;
	public String EMPLOYMENT_TYPE;
	public String LOCATION;
	public long DATE;
	public int STATUS;
}