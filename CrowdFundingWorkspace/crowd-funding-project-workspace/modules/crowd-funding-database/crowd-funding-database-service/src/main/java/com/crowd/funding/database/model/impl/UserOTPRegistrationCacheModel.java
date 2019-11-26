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

import com.crowd.funding.database.model.UserOTPRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserOTPRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserOTPRegistration
 * @generated
 */
@ProviderType
public class UserOTPRegistrationCacheModel implements CacheModel<UserOTPRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserOTPRegistrationCacheModel)) {
			return false;
		}

		UserOTPRegistrationCacheModel userOTPRegistrationCacheModel = (UserOTPRegistrationCacheModel)obj;

		if (USER_OTP_ID == userOTPRegistrationCacheModel.USER_OTP_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, USER_OTP_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", USER_OTP_ID=");
		sb.append(USER_OTP_ID);
		sb.append(", MOBILE_NO=");
		sb.append(MOBILE_NO);
		sb.append(", MAIL=");
		sb.append(MAIL);
		sb.append(", OTP=");
		sb.append(OTP);
		sb.append(", OTP_DEVICE=");
		sb.append(OTP_DEVICE);
		sb.append(", OTP_VERIFICATION_STATUS=");
		sb.append(OTP_VERIFICATION_STATUS);
		sb.append(", CREATION_DATE_TIME=");
		sb.append(CREATION_DATE_TIME);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserOTPRegistration toEntityModel() {
		UserOTPRegistrationImpl userOTPRegistrationImpl = new UserOTPRegistrationImpl();

		if (uuid == null) {
			userOTPRegistrationImpl.setUuid("");
		}
		else {
			userOTPRegistrationImpl.setUuid(uuid);
		}

		userOTPRegistrationImpl.setUSER_OTP_ID(USER_OTP_ID);
		userOTPRegistrationImpl.setMOBILE_NO(MOBILE_NO);

		if (MAIL == null) {
			userOTPRegistrationImpl.setMAIL("");
		}
		else {
			userOTPRegistrationImpl.setMAIL(MAIL);
		}

		userOTPRegistrationImpl.setOTP(OTP);
		userOTPRegistrationImpl.setOTP_DEVICE(OTP_DEVICE);
		userOTPRegistrationImpl.setOTP_VERIFICATION_STATUS(OTP_VERIFICATION_STATUS);

		if (CREATION_DATE_TIME == Long.MIN_VALUE) {
			userOTPRegistrationImpl.setCREATION_DATE_TIME(null);
		}
		else {
			userOTPRegistrationImpl.setCREATION_DATE_TIME(new Date(
					CREATION_DATE_TIME));
		}

		userOTPRegistrationImpl.resetOriginalValues();

		return userOTPRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		USER_OTP_ID = objectInput.readLong();

		MOBILE_NO = objectInput.readLong();
		MAIL = objectInput.readUTF();

		OTP = objectInput.readInt();

		OTP_DEVICE = objectInput.readInt();

		OTP_VERIFICATION_STATUS = objectInput.readInt();
		CREATION_DATE_TIME = objectInput.readLong();
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

		objectOutput.writeLong(USER_OTP_ID);

		objectOutput.writeLong(MOBILE_NO);

		if (MAIL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MAIL);
		}

		objectOutput.writeInt(OTP);

		objectOutput.writeInt(OTP_DEVICE);

		objectOutput.writeInt(OTP_VERIFICATION_STATUS);
		objectOutput.writeLong(CREATION_DATE_TIME);
	}

	public String uuid;
	public long USER_OTP_ID;
	public long MOBILE_NO;
	public String MAIL;
	public int OTP;
	public int OTP_DEVICE;
	public int OTP_VERIFICATION_STATUS;
	public long CREATION_DATE_TIME;
}