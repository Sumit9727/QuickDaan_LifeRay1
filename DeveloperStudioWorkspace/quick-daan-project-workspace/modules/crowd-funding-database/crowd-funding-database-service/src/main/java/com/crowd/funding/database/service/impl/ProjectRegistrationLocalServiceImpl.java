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

import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.base.ProjectRegistrationLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the project registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.crowd.funding.database.service.ProjectRegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil
 */
public class ProjectRegistrationLocalServiceImpl
	extends ProjectRegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil} to access the project registration local service.
	 */
	public  ProjectRegistration findByPROJECT_ID(long PROJECT_ID)
			throws com.crowd.funding.database.exception.NoSuchProjectRegistrationException {
			return projectRegistrationPersistence.findByPROJECT_ID(PROJECT_ID);
	}
	public  List<ProjectRegistration> findByUSER_ID(long USER_ID) {
		return projectRegistrationPersistence.findByUSER_ID(USER_ID);
	}
	public  List<ProjectRegistration> findBySTATUS(int STATUS) {
		return projectRegistrationPersistence.findBySTATUS(STATUS);
	}
	public  List<ProjectRegistration> findByCREATION_DATE(
			Date CREATION_DATE) {
			return projectRegistrationPersistence.findByCREATION_DATE(CREATION_DATE);
	}
	public  List<ProjectRegistration> findByEND_DATE(Date END_DATE) {
		return projectRegistrationPersistence.findByEND_DATE(END_DATE);
	}
	public  List<ProjectRegistration> findByBENIFICIARY_ID(
			long BENIFICIARY_ID) {
			return projectRegistrationPersistence.findByBENIFICIARY_ID(BENIFICIARY_ID);
	}
	public  List<ProjectRegistration> findByREQUEST_STATUS(
			int REQUEST_STATUS) {
			return projectRegistrationPersistence.findByREQUEST_STATUS(REQUEST_STATUS);
	}
	public  List<ProjectRegistration> findByBENIFICIARY_ID_STATUS(
			long BENIFICIARY_ID, int STATUS) {
			return projectRegistrationPersistence
					   .findByBENIFICIARY_ID_STATUS(BENIFICIARY_ID, STATUS);
	}
	public  List<ProjectRegistration> findByMULTIPLE_REQUEST_STATUS(
			int[] REQUEST_STATUSs) {
			return projectRegistrationPersistence.findByMULTIPLE_REQUEST_STATUS(REQUEST_STATUSs);
		}
	
							/*CUSTOM SQL*/
	
	public List<ProjectRegistration> findByProjectCreationDate(
			String creationDate) {
		return projectRegistrationFinder.findByProjectCreationDate(creationDate);
	}
	public List<ProjectRegistration> findProjectBetweenCreationDateQuery(
			String startCreationDate, String endCreationDate) {
		return projectRegistrationFinder.findProjectBetweenCreationDateQuery(startCreationDate,endCreationDate);
	}
	public List<ProjectRegistration> findprojectByBenificiaryIdCreationDate(
			long benificiaryId, String creationDate) {
		return projectRegistrationFinder.findprojectByBenificiaryIdCreationDate(benificiaryId,creationDate);
	}
	public List<ProjectRegistration> findprojectByBenificiaryIdStatusCreationDate(
			long benificiaryId, int status, String creationDate) {
		return projectRegistrationFinder.findprojectByBenificiaryIdStatusCreationDate(benificiaryId, status, creationDate);
	}
	public List<ProjectRegistration> findprojectByStatusCreationDate(
			int status, String creationDate) {
		return projectRegistrationFinder.findprojectByStatusCreationDate(status, creationDate);
	}


}