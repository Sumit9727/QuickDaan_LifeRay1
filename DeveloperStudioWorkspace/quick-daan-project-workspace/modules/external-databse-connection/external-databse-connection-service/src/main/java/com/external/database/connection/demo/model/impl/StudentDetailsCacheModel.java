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

package com.external.database.connection.demo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.external.database.connection.demo.model.StudentDetails;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StudentDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetails
 * @generated
 */
@ProviderType
public class StudentDetailsCacheModel implements CacheModel<StudentDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentDetailsCacheModel)) {
			return false;
		}

		StudentDetailsCacheModel studentDetailsCacheModel = (StudentDetailsCacheModel)obj;

		if (studentId == studentDetailsCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", contactno=");
		sb.append(contactno);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentDetails toEntityModel() {
		StudentDetailsImpl studentDetailsImpl = new StudentDetailsImpl();

		studentDetailsImpl.setCompanyId(companyId);
		studentDetailsImpl.setGroupId(groupId);
		studentDetailsImpl.setUserId(userId);

		if (userName == null) {
			studentDetailsImpl.setUserName("");
		}
		else {
			studentDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studentDetailsImpl.setCreateDate(null);
		}
		else {
			studentDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentDetailsImpl.setModifiedDate(null);
		}
		else {
			studentDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentDetailsImpl.setStudentId(studentId);

		if (name == null) {
			studentDetailsImpl.setName("");
		}
		else {
			studentDetailsImpl.setName(name);
		}

		if (email == null) {
			studentDetailsImpl.setEmail("");
		}
		else {
			studentDetailsImpl.setEmail(email);
		}

		if (contactno == null) {
			studentDetailsImpl.setContactno("");
		}
		else {
			studentDetailsImpl.setContactno(contactno);
		}

		studentDetailsImpl.resetOriginalValues();

		return studentDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		studentId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		contactno = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(studentId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (contactno == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactno);
		}
	}

	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long studentId;
	public String name;
	public String email;
	public String contactno;
}