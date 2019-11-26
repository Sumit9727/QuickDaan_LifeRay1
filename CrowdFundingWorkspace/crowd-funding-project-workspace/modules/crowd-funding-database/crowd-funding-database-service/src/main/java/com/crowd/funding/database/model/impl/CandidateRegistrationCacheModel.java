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

import com.crowd.funding.database.model.CandidateRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CandidateRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistration
 * @generated
 */
@ProviderType
public class CandidateRegistrationCacheModel implements CacheModel<CandidateRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateRegistrationCacheModel)) {
			return false;
		}

		CandidateRegistrationCacheModel candidateRegistrationCacheModel = (CandidateRegistrationCacheModel)obj;

		if (CANDIDATE_ID == candidateRegistrationCacheModel.CANDIDATE_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, CANDIDATE_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", CANDIDATE_ID=");
		sb.append(CANDIDATE_ID);
		sb.append(", POSITION_ID=");
		sb.append(POSITION_ID);
		sb.append(", NAME=");
		sb.append(NAME);
		sb.append(", EMAIL=");
		sb.append(EMAIL);
		sb.append(", MOBILE_NO=");
		sb.append(MOBILE_NO);
		sb.append(", CURRENT_LOCATION=");
		sb.append(CURRENT_LOCATION);
		sb.append(", EXPERIENCE=");
		sb.append(EXPERIENCE);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append(", STATUS=");
		sb.append(STATUS);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateRegistration toEntityModel() {
		CandidateRegistrationImpl candidateRegistrationImpl = new CandidateRegistrationImpl();

		if (uuid == null) {
			candidateRegistrationImpl.setUuid("");
		}
		else {
			candidateRegistrationImpl.setUuid(uuid);
		}

		candidateRegistrationImpl.setCANDIDATE_ID(CANDIDATE_ID);
		candidateRegistrationImpl.setPOSITION_ID(POSITION_ID);

		if (NAME == null) {
			candidateRegistrationImpl.setNAME("");
		}
		else {
			candidateRegistrationImpl.setNAME(NAME);
		}

		if (EMAIL == null) {
			candidateRegistrationImpl.setEMAIL("");
		}
		else {
			candidateRegistrationImpl.setEMAIL(EMAIL);
		}

		candidateRegistrationImpl.setMOBILE_NO(MOBILE_NO);

		if (CURRENT_LOCATION == null) {
			candidateRegistrationImpl.setCURRENT_LOCATION("");
		}
		else {
			candidateRegistrationImpl.setCURRENT_LOCATION(CURRENT_LOCATION);
		}

		if (EXPERIENCE == null) {
			candidateRegistrationImpl.setEXPERIENCE("");
		}
		else {
			candidateRegistrationImpl.setEXPERIENCE(EXPERIENCE);
		}

		if (DATE == Long.MIN_VALUE) {
			candidateRegistrationImpl.setDATE(null);
		}
		else {
			candidateRegistrationImpl.setDATE(new Date(DATE));
		}

		candidateRegistrationImpl.setSTATUS(STATUS);

		candidateRegistrationImpl.resetOriginalValues();

		return candidateRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		CANDIDATE_ID = objectInput.readLong();

		POSITION_ID = objectInput.readLong();
		NAME = objectInput.readUTF();
		EMAIL = objectInput.readUTF();

		MOBILE_NO = objectInput.readLong();
		CURRENT_LOCATION = objectInput.readUTF();
		EXPERIENCE = objectInput.readUTF();
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

		objectOutput.writeLong(CANDIDATE_ID);

		objectOutput.writeLong(POSITION_ID);

		if (NAME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(NAME);
		}

		if (EMAIL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EMAIL);
		}

		objectOutput.writeLong(MOBILE_NO);

		if (CURRENT_LOCATION == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CURRENT_LOCATION);
		}

		if (EXPERIENCE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(EXPERIENCE);
		}

		objectOutput.writeLong(DATE);

		objectOutput.writeInt(STATUS);
	}

	public String uuid;
	public long CANDIDATE_ID;
	public long POSITION_ID;
	public String NAME;
	public String EMAIL;
	public long MOBILE_NO;
	public String CURRENT_LOCATION;
	public String EXPERIENCE;
	public long DATE;
	public int STATUS;
}