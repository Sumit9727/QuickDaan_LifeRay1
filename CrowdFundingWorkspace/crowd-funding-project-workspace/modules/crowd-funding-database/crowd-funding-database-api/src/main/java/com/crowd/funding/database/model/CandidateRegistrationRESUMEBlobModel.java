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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the RESUME column in CandidateRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistration
 * @generated
 */
@ProviderType
public class CandidateRegistrationRESUMEBlobModel {
	public CandidateRegistrationRESUMEBlobModel() {
	}

	public CandidateRegistrationRESUMEBlobModel(long CANDIDATE_ID) {
		_CANDIDATE_ID = CANDIDATE_ID;
	}

	public CandidateRegistrationRESUMEBlobModel(long CANDIDATE_ID,
		Blob RESUMEBlob) {
		_CANDIDATE_ID = CANDIDATE_ID;
		_RESUMEBlob = RESUMEBlob;
	}

	public long getCANDIDATE_ID() {
		return _CANDIDATE_ID;
	}

	public void setCANDIDATE_ID(long CANDIDATE_ID) {
		_CANDIDATE_ID = CANDIDATE_ID;
	}

	public Blob getRESUMEBlob() {
		return _RESUMEBlob;
	}

	public void setRESUMEBlob(Blob RESUMEBlob) {
		_RESUMEBlob = RESUMEBlob;
	}

	private long _CANDIDATE_ID;
	private Blob _RESUMEBlob;
}