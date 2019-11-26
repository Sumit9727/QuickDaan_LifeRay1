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

import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.service.base.UserOTPRegistrationLocalServiceBaseImpl;

/**
 * The implementation of the user otp registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.UserOTPRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserOTPRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil
 */
public class UserOTPRegistrationLocalServiceImpl
	extends UserOTPRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil} to access the user otp registration local service.
	 */
	public  UserOTPRegistration findByMOBILE_NO(long MOBILE_NO)
			throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
			return userOTPRegistrationPersistence.findByMOBILE_NO(MOBILE_NO);
		}
	public  UserOTPRegistration findByUSER_OTP_ID(long USER_OTP_ID)
			throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
			return userOTPRegistrationPersistence.findByUSER_OTP_ID(USER_OTP_ID);
		}
	public  UserOTPRegistration findByMAIL_OTP_STATUS(String MAIL,
			int OTP_VERIFICATION_STATUS)
			throws com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException {
			return userOTPRegistrationPersistence
					   .findByMAIL_OTP_STATUS(MAIL, OTP_VERIFICATION_STATUS);
		}
}