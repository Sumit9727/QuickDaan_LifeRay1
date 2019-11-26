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

import com.crowd.funding.database.model.ProjectExtentionRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectExtentionRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectExtentionRegistration
 * @generated
 */
@ProviderType
public class ProjectExtentionRegistrationCacheModel implements CacheModel<ProjectExtentionRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectExtentionRegistrationCacheModel)) {
			return false;
		}

		ProjectExtentionRegistrationCacheModel projectExtentionRegistrationCacheModel =
			(ProjectExtentionRegistrationCacheModel)obj;

		if (PROJECT_EXTENTION_ID == projectExtentionRegistrationCacheModel.PROJECT_EXTENTION_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, PROJECT_EXTENTION_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", PROJECT_EXTENTION_ID=");
		sb.append(PROJECT_EXTENTION_ID);
		sb.append(", PROJECT_ID=");
		sb.append(PROJECT_ID);
		sb.append(", EXTENTION_DATE=");
		sb.append(EXTENTION_DATE);
		sb.append(", COMMENT=");
		sb.append(COMMENT);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectExtentionRegistration toEntityModel() {
		ProjectExtentionRegistrationImpl projectExtentionRegistrationImpl = new ProjectExtentionRegistrationImpl();

		if (uuid == null) {
			projectExtentionRegistrationImpl.setUuid("");
		}
		else {
			projectExtentionRegistrationImpl.setUuid(uuid);
		}

		projectExtentionRegistrationImpl.setPROJECT_EXTENTION_ID(PROJECT_EXTENTION_ID);
		projectExtentionRegistrationImpl.setPROJECT_ID(PROJECT_ID);

		if (EXTENTION_DATE == Long.MIN_VALUE) {
			projectExtentionRegistrationImpl.setEXTENTION_DATE(null);
		}
		else {
			projectExtentionRegistrationImpl.setEXTENTION_DATE(new Date(
					EXTENTION_DATE));
		}

		if (COMMENT == null) {
			projectExtentionRegistrationImpl.setCOMMENT("");
		}
		else {
			projectExtentionRegistrationImpl.setCOMMENT(COMMENT);
		}

		projectExtentionRegistrationImpl.setSTATUS(STATUS);

		if (DATE == Long.MIN_VALUE) {
			projectExtentionRegistrationImpl.setDATE(null);
		}
		else {
			projectExtentionRegistrationImpl.setDATE(new Date(DATE));
		}

		projectExtentionRegistrationImpl.resetOriginalValues();

		return projectExtentionRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		PROJECT_EXTENTION_ID = objectInput.readLong();

		PROJECT_ID = objectInput.readLong();
		EXTENTION_DATE = objectInput.readLong();
		COMMENT = objectInput.readUTF();

		STATUS = objectInput.readInt();
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

		objectOutput.writeLong(PROJECT_EXTENTION_ID);

		objectOutput.writeLong(PROJECT_ID);
		objectOutput.writeLong(EXTENTION_DATE);

		if (COMMENT == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COMMENT);
		}

		objectOutput.writeInt(STATUS);
		objectOutput.writeLong(DATE);
	}

	public String uuid;
	public long PROJECT_EXTENTION_ID;
	public long PROJECT_ID;
	public long EXTENTION_DATE;
	public String COMMENT;
	public int STATUS;
	public long DATE;
}