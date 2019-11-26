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

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.service.base.BenificiaryRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the benificiary registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.BenificiaryRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil
 */
public class BenificiaryRegistrationLocalServiceImpl
	extends BenificiaryRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil} to access the benificiary registration local service.
	 */
	public  BenificiaryRegistration findByBENIFICIARY_ID(
			long BENIFICIARY_ID)
			throws com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException {
			return benificiaryRegistrationPersistence.findByBENIFICIARY_ID(BENIFICIARY_ID);
		}
	public  List<BenificiaryRegistration> findByBENIFICIARY_CATEGORY(
			String BENIFICIARY_CATEGORY) {
			return benificiaryRegistrationPersistence.findByBENIFICIARY_CATEGORY(BENIFICIARY_CATEGORY);
		}
	public  List<BenificiaryRegistration> findByCAUSE_DETAILS(
			String CAUSE_DETAILS) {
			return benificiaryRegistrationPersistence.findByCAUSE_DETAILS(CAUSE_DETAILS);
		}
	public  List<BenificiaryRegistration> findByCAUSE_BENIFICIARY_CATEGORY(
			String CAUSE_DETAILS, String BENIFICIARY_CATEGORY) {
			return benificiaryRegistrationPersistence
					   .findByCAUSE_BENIFICIARY_CATEGORY(CAUSE_DETAILS,
				BENIFICIARY_CATEGORY);
		}
	

}