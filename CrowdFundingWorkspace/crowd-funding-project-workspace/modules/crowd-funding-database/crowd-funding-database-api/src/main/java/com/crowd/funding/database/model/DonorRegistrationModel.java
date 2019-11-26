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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the DonorRegistration service. Represents a row in the &quot;cf_donor_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.crowd.funding.database.model.impl.DonorRegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.crowd.funding.database.model.impl.DonorRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DonorRegistration
 * @see com.crowd.funding.database.model.impl.DonorRegistrationImpl
 * @see com.crowd.funding.database.model.impl.DonorRegistrationModelImpl
 * @generated
 */
@ProviderType
public interface DonorRegistrationModel extends BaseModel<DonorRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a donor registration model instance should use the {@link DonorRegistration} interface instead.
	 */

	/**
	 * Returns the primary key of this donor registration.
	 *
	 * @return the primary key of this donor registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this donor registration.
	 *
	 * @param primaryKey the primary key of this donor registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this donor registration.
	 *
	 * @return the uuid of this donor registration
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this donor registration.
	 *
	 * @param uuid the uuid of this donor registration
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the donor_id of this donor registration.
	 *
	 * @return the donor_id of this donor registration
	 */
	public long getDONOR_ID();

	/**
	 * Sets the donor_id of this donor registration.
	 *
	 * @param DONOR_ID the donor_id of this donor registration
	 */
	public void setDONOR_ID(long DONOR_ID);

	/**
	 * Returns the name of this donor registration.
	 *
	 * @return the name of this donor registration
	 */
	@AutoEscape
	public String getNAME();

	/**
	 * Sets the name of this donor registration.
	 *
	 * @param NAME the name of this donor registration
	 */
	public void setNAME(String NAME);

	/**
	 * Returns the address of this donor registration.
	 *
	 * @return the address of this donor registration
	 */
	@AutoEscape
	public String getADDRESS();

	/**
	 * Sets the address of this donor registration.
	 *
	 * @param ADDRESS the address of this donor registration
	 */
	public void setADDRESS(String ADDRESS);

	/**
	 * Returns the city of this donor registration.
	 *
	 * @return the city of this donor registration
	 */
	@AutoEscape
	public String getCITY();

	/**
	 * Sets the city of this donor registration.
	 *
	 * @param CITY the city of this donor registration
	 */
	public void setCITY(String CITY);

	/**
	 * Returns the state of this donor registration.
	 *
	 * @return the state of this donor registration
	 */
	@AutoEscape
	public String getSTATE();

	/**
	 * Sets the state of this donor registration.
	 *
	 * @param STATE the state of this donor registration
	 */
	public void setSTATE(String STATE);

	/**
	 * Returns the country of this donor registration.
	 *
	 * @return the country of this donor registration
	 */
	@AutoEscape
	public String getCOUNTRY();

	/**
	 * Sets the country of this donor registration.
	 *
	 * @param COUNTRY the country of this donor registration
	 */
	public void setCOUNTRY(String COUNTRY);

	/**
	 * Returns the pincode of this donor registration.
	 *
	 * @return the pincode of this donor registration
	 */
	@AutoEscape
	public String getPINCODE();

	/**
	 * Sets the pincode of this donor registration.
	 *
	 * @param PINCODE the pincode of this donor registration
	 */
	public void setPINCODE(String PINCODE);

	/**
	 * Returns the mail_address of this donor registration.
	 *
	 * @return the mail_address of this donor registration
	 */
	@AutoEscape
	public String getMAIL_ADDRESS();

	/**
	 * Sets the mail_address of this donor registration.
	 *
	 * @param MAIL_ADDRESS the mail_address of this donor registration
	 */
	public void setMAIL_ADDRESS(String MAIL_ADDRESS);

	/**
	 * Returns the mobile_no of this donor registration.
	 *
	 * @return the mobile_no of this donor registration
	 */
	public long getMOBILE_NO();

	/**
	 * Sets the mobile_no of this donor registration.
	 *
	 * @param MOBILE_NO the mobile_no of this donor registration
	 */
	public void setMOBILE_NO(long MOBILE_NO);

	/**
	 * Returns the otp of this donor registration.
	 *
	 * @return the otp of this donor registration
	 */
	public int getOTP();

	/**
	 * Sets the otp of this donor registration.
	 *
	 * @param OTP the otp of this donor registration
	 */
	public void setOTP(int OTP);

	/**
	 * Returns the mail_verification of this donor registration.
	 *
	 * @return the mail_verification of this donor registration
	 */
	public int getMAIL_VERIFICATION();

	/**
	 * Sets the mail_verification of this donor registration.
	 *
	 * @param MAIL_VERIFICATION the mail_verification of this donor registration
	 */
	public void setMAIL_VERIFICATION(int MAIL_VERIFICATION);

	/**
	 * Returns the sms_verification of this donor registration.
	 *
	 * @return the sms_verification of this donor registration
	 */
	public int getSMS_VERIFICATION();

	/**
	 * Sets the sms_verification of this donor registration.
	 *
	 * @param SMS_VERIFICATION the sms_verification of this donor registration
	 */
	public void setSMS_VERIFICATION(int SMS_VERIFICATION);

	/**
	 * Returns the creation_date_time of this donor registration.
	 *
	 * @return the creation_date_time of this donor registration
	 */
	public Date getCREATION_DATE_TIME();

	/**
	 * Sets the creation_date_time of this donor registration.
	 *
	 * @param CREATION_DATE_TIME the creation_date_time of this donor registration
	 */
	public void setCREATION_DATE_TIME(Date CREATION_DATE_TIME);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(DonorRegistration donorRegistration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DonorRegistration> toCacheModel();

	@Override
	public DonorRegistration toEscapedModel();

	@Override
	public DonorRegistration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}