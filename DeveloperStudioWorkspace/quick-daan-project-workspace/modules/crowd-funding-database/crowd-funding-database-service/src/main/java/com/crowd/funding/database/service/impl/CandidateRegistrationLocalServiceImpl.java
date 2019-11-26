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

import com.crowd.funding.database.model.CandidateRegistration;
import com.crowd.funding.database.service.base.CandidateRegistrationLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the candidate registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.CandidateRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.CandidateRegistrationLocalServiceUtil
 */
public class CandidateRegistrationLocalServiceImpl
	extends CandidateRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.CandidateRegistrationLocalServiceUtil} to access the candidate registration local service.
	 */
	public CandidateRegistration findByCANDIDATE_ID(long CANDIDATE_ID)
			throws com.crowd.funding.database.exception.NoSuchCandidateRegistrationException {
			return candidateRegistrationPersistence.findByCANDIDATE_ID(CANDIDATE_ID);
		}
	public List<CandidateRegistration> findByPOSITION_ID(
			long POSITION_ID) {
			return candidateRegistrationPersistence.findByPOSITION_ID(POSITION_ID);
		}
	public List<CandidateRegistration> findBySTATUS(int STATUS) {
		return candidateRegistrationPersistence.findBySTATUS(STATUS);
	}
}