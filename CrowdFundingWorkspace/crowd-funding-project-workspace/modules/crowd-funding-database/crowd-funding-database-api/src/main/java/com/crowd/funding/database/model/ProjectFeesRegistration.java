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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ProjectFeesRegistration service. Represents a row in the &quot;cf_project_fees_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectFeesRegistrationModel
 * @see com.crowd.funding.database.model.impl.ProjectFeesRegistrationImpl
 * @see com.crowd.funding.database.model.impl.ProjectFeesRegistrationModelImpl
 * @generated
 */
@ImplementationClassName("com.crowd.funding.database.model.impl.ProjectFeesRegistrationImpl")
@ProviderType
public interface ProjectFeesRegistration extends ProjectFeesRegistrationModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.crowd.funding.database.model.impl.ProjectFeesRegistrationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectFeesRegistration, Long> PROJECT_FEES_ID_ACCESSOR =
		new Accessor<ProjectFeesRegistration, Long>() {
			@Override
			public Long get(ProjectFeesRegistration projectFeesRegistration) {
				return projectFeesRegistration.getPROJECT_FEES_ID();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProjectFeesRegistration> getTypeClass() {
				return ProjectFeesRegistration.class;
			}
		};
}