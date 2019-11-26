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

package com.crowd.funding.database.service.persistence.impl;

import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.persistence.ProjectRegistrationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.lang.reflect.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectRegistrationFinderBaseImpl extends BasePersistenceImpl<ProjectRegistration> {
	public ProjectRegistrationFinderBaseImpl() {
		setModelClass(ProjectRegistration.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getProjectRegistrationPersistence().getBadColumnNames();
	}

	/**
	 * Returns the project registration persistence.
	 *
	 * @return the project registration persistence
	 */
	public ProjectRegistrationPersistence getProjectRegistrationPersistence() {
		return projectRegistrationPersistence;
	}

	/**
	 * Sets the project registration persistence.
	 *
	 * @param projectRegistrationPersistence the project registration persistence
	 */
	public void setProjectRegistrationPersistence(
		ProjectRegistrationPersistence projectRegistrationPersistence) {
		this.projectRegistrationPersistence = projectRegistrationPersistence;
	}

	@BeanReference(type = ProjectRegistrationPersistence.class)
	protected ProjectRegistrationPersistence projectRegistrationPersistence;
	private static final Log _log = LogFactoryUtil.getLog(ProjectRegistrationFinderBaseImpl.class);
}