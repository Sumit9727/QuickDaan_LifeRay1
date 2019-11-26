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

package com.external.database.connection.demo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the StudentDetails service. Represents a row in the &quot;ext_student_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StudentDetailsModel
 * @see com.external.database.connection.demo.model.impl.StudentDetailsImpl
 * @see com.external.database.connection.demo.model.impl.StudentDetailsModelImpl
 * @generated
 */
@ImplementationClassName("com.external.database.connection.demo.model.impl.StudentDetailsImpl")
@ProviderType
public interface StudentDetails extends StudentDetailsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.external.database.connection.demo.model.impl.StudentDetailsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StudentDetails, Long> STUDENT_ID_ACCESSOR = new Accessor<StudentDetails, Long>() {
			@Override
			public Long get(StudentDetails studentDetails) {
				return studentDetails.getStudentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StudentDetails> getTypeClass() {
				return StudentDetails.class;
			}
		};
}