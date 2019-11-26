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
 * The extended model interface for the DynamicFeesRegistration service. Represents a row in the &quot;cf_dynamic_fees_details&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DynamicFeesRegistrationModel
 * @see com.crowd.funding.database.model.impl.DynamicFeesRegistrationImpl
 * @see com.crowd.funding.database.model.impl.DynamicFeesRegistrationModelImpl
 * @generated
 */
@ImplementationClassName("com.crowd.funding.database.model.impl.DynamicFeesRegistrationImpl")
@ProviderType
public interface DynamicFeesRegistration extends DynamicFeesRegistrationModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.crowd.funding.database.model.impl.DynamicFeesRegistrationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DynamicFeesRegistration, Long> CATEGORY_ID_ACCESSOR =
		new Accessor<DynamicFeesRegistration, Long>() {
			@Override
			public Long get(DynamicFeesRegistration dynamicFeesRegistration) {
				return dynamicFeesRegistration.getCATEGORY_ID();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DynamicFeesRegistration> getTypeClass() {
				return DynamicFeesRegistration.class;
			}
		};
}