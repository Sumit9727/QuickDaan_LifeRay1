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
 * The Blob model class for lazy loading the VIDEO column in ProjectRegistration.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistration
 * @generated
 */
@ProviderType
public class ProjectRegistrationVIDEOBlobModel {
	public ProjectRegistrationVIDEOBlobModel() {
	}

	public ProjectRegistrationVIDEOBlobModel(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public ProjectRegistrationVIDEOBlobModel(long PROJECT_ID, Blob VIDEOBlob) {
		_PROJECT_ID = PROJECT_ID;
		_VIDEOBlob = VIDEOBlob;
	}

	public long getPROJECT_ID() {
		return _PROJECT_ID;
	}

	public void setPROJECT_ID(long PROJECT_ID) {
		_PROJECT_ID = PROJECT_ID;
	}

	public Blob getVIDEOBlob() {
		return _VIDEOBlob;
	}

	public void setVIDEOBlob(Blob VIDEOBlob) {
		_VIDEOBlob = VIDEOBlob;
	}

	private long _PROJECT_ID;
	private Blob _VIDEOBlob;
}