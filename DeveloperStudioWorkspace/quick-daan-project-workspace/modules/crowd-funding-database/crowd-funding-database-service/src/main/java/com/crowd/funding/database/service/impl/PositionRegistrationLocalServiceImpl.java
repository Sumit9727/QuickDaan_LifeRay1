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

package com.crowd.funding.database.service.impl;

import com.crowd.funding.database.model.PositionRegistration;
import com.crowd.funding.database.service.base.PositionRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the position registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.PositionRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PositionRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil
 */
public class PositionRegistrationLocalServiceImpl
	extends PositionRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil} to access the position registration local service.
	 */
	public PositionRegistration findByPOSITION_ID(long POSITION_ID)
			throws com.crowd.funding.database.exception.NoSuchPositionRegistrationException {
			return positionRegistrationPersistence.findByPOSITION_ID(POSITION_ID);
		}
	public List<PositionRegistration> findBySTATUS(int STATUS) {
		return positionRegistrationPersistence.findBySTATUS(STATUS);
	}
}