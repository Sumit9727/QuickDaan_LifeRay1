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

import com.crowd.funding.database.model.HistoryLogRegistration;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistoryLogRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see HistoryLogRegistration
 * @generated
 */
@ProviderType
public class HistoryLogRegistrationCacheModel implements CacheModel<HistoryLogRegistration>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryLogRegistrationCacheModel)) {
			return false;
		}

		HistoryLogRegistrationCacheModel historyLogRegistrationCacheModel = (HistoryLogRegistrationCacheModel)obj;

		if (HISTORY_ID == historyLogRegistrationCacheModel.HISTORY_ID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, HISTORY_ID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", HISTORY_ID=");
		sb.append(HISTORY_ID);
		sb.append(", USER_ID=");
		sb.append(USER_ID);
		sb.append(", URL=");
		sb.append(URL);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HistoryLogRegistration toEntityModel() {
		HistoryLogRegistrationImpl historyLogRegistrationImpl = new HistoryLogRegistrationImpl();

		if (uuid == null) {
			historyLogRegistrationImpl.setUuid("");
		}
		else {
			historyLogRegistrationImpl.setUuid(uuid);
		}

		historyLogRegistrationImpl.setHISTORY_ID(HISTORY_ID);
		historyLogRegistrationImpl.setUSER_ID(USER_ID);

		if (URL == null) {
			historyLogRegistrationImpl.setURL("");
		}
		else {
			historyLogRegistrationImpl.setURL(URL);
		}

		if (DATE == Long.MIN_VALUE) {
			historyLogRegistrationImpl.setDATE(null);
		}
		else {
			historyLogRegistrationImpl.setDATE(new Date(DATE));
		}

		historyLogRegistrationImpl.resetOriginalValues();

		return historyLogRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		HISTORY_ID = objectInput.readLong();

		USER_ID = objectInput.readLong();
		URL = objectInput.readUTF();
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

		objectOutput.writeLong(HISTORY_ID);

		objectOutput.writeLong(USER_ID);

		if (URL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(URL);
		}

		objectOutput.writeLong(DATE);
	}

	public String uuid;
	public long HISTORY_ID;
	public long USER_ID;
	public String URL;
	public long DATE;
}