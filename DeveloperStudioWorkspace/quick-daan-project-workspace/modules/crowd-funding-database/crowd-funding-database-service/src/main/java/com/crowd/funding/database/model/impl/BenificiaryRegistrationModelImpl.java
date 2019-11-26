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

package com.crowd.funding.database.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.BenificiaryRegistrationIMAGEBlobModel;
import com.crowd.funding.database.model.BenificiaryRegistrationModel;
import com.crowd.funding.database.model.BenificiaryRegistrationSoap;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the BenificiaryRegistration service. Represents a row in the &quot;cf_project_benificiary_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link BenificiaryRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BenificiaryRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BenificiaryRegistrationImpl
 * @see BenificiaryRegistration
 * @see BenificiaryRegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class BenificiaryRegistrationModelImpl extends BaseModelImpl<BenificiaryRegistration>
	implements BenificiaryRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a benificiary registration model instance should use the {@link BenificiaryRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "cf_project_benificiary_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "BENIFICIARY_ID", Types.BIGINT },
			{ "BENIFICIARY_CATEGORY", Types.VARCHAR },
			{ "BENIFICIARY_TYPE", Types.VARCHAR },
			{ "BENIFICIARY_NAME", Types.VARCHAR },
			{ "AGE", Types.VARCHAR },
			{ "GENDER", Types.VARCHAR },
			{ "LOCATION", Types.VARCHAR },
			{ "RELATIONSHIP", Types.VARCHAR },
			{ "RELATIONSHIP_DETAILS", Types.VARCHAR },
			{ "MEMBERS_NO", Types.INTEGER },
			{ "CAUSE_DETAILS", Types.VARCHAR },
			{ "ADDRESS_LINE1", Types.VARCHAR },
			{ "ADDRESS_LINE2", Types.VARCHAR },
			{ "CITY", Types.VARCHAR },
			{ "STATE", Types.VARCHAR },
			{ "PINCODE", Types.INTEGER },
			{ "COUNTRY", Types.VARCHAR },
			{ "CONTACT_NAME", Types.VARCHAR },
			{ "CONTACT_NO", Types.BIGINT },
			{ "ALTERNATE_CONTACT_NO", Types.BIGINT },
			{ "EMERGENCY_CONTACT_DETAILS", Types.VARCHAR },
			{ "IMAGE_TYPE", Types.VARCHAR },
			{ "IMAGE", Types.BLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("BENIFICIARY_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("BENIFICIARY_CATEGORY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("BENIFICIARY_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("BENIFICIARY_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("AGE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("GENDER", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("LOCATION", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("RELATIONSHIP", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("RELATIONSHIP_DETAILS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("MEMBERS_NO", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("CAUSE_DETAILS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ADDRESS_LINE1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ADDRESS_LINE2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CITY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("STATE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("PINCODE", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("COUNTRY", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CONTACT_NAME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CONTACT_NO", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ALTERNATE_CONTACT_NO", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("EMERGENCY_CONTACT_DETAILS", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("IMAGE_TYPE", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("IMAGE", Types.BLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table cf_project_benificiary_details (uuid_ VARCHAR(75) null,BENIFICIARY_ID LONG not null primary key,BENIFICIARY_CATEGORY VARCHAR(75) null,BENIFICIARY_TYPE VARCHAR(75) null,BENIFICIARY_NAME VARCHAR(500) null,AGE VARCHAR(75) null,GENDER VARCHAR(75) null,LOCATION VARCHAR(75) null,RELATIONSHIP VARCHAR(500) null,RELATIONSHIP_DETAILS VARCHAR(75) null,MEMBERS_NO INTEGER,CAUSE_DETAILS VARCHAR(75) null,ADDRESS_LINE1 VARCHAR(1000) null,ADDRESS_LINE2 VARCHAR(1000) null,CITY VARCHAR(75) null,STATE VARCHAR(75) null,PINCODE INTEGER,COUNTRY VARCHAR(75) null,CONTACT_NAME VARCHAR(75) null,CONTACT_NO LONG,ALTERNATE_CONTACT_NO LONG,EMERGENCY_CONTACT_DETAILS TEXT null,IMAGE_TYPE VARCHAR(75) null,IMAGE BLOB)";
	public static final String TABLE_SQL_DROP = "drop table cf_project_benificiary_details";
	public static final String ORDER_BY_JPQL = " ORDER BY benificiaryRegistration.BENIFICIARY_ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cf_project_benificiary_details.BENIFICIARY_ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.crowd.funding.database.model.BenificiaryRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.crowd.funding.database.model.BenificiaryRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.crowd.funding.database.model.BenificiaryRegistration"),
			true);
	public static final long BENIFICIARY_CATEGORY_COLUMN_BITMASK = 1L;
	public static final long BENIFICIARY_ID_COLUMN_BITMASK = 2L;
	public static final long CAUSE_DETAILS_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static BenificiaryRegistration toModel(
		BenificiaryRegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		BenificiaryRegistration model = new BenificiaryRegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setBENIFICIARY_ID(soapModel.getBENIFICIARY_ID());
		model.setBENIFICIARY_CATEGORY(soapModel.getBENIFICIARY_CATEGORY());
		model.setBENIFICIARY_TYPE(soapModel.getBENIFICIARY_TYPE());
		model.setBENIFICIARY_NAME(soapModel.getBENIFICIARY_NAME());
		model.setAGE(soapModel.getAGE());
		model.setGENDER(soapModel.getGENDER());
		model.setLOCATION(soapModel.getLOCATION());
		model.setRELATIONSHIP(soapModel.getRELATIONSHIP());
		model.setRELATIONSHIP_DETAILS(soapModel.getRELATIONSHIP_DETAILS());
		model.setMEMBERS_NO(soapModel.getMEMBERS_NO());
		model.setCAUSE_DETAILS(soapModel.getCAUSE_DETAILS());
		model.setADDRESS_LINE1(soapModel.getADDRESS_LINE1());
		model.setADDRESS_LINE2(soapModel.getADDRESS_LINE2());
		model.setCITY(soapModel.getCITY());
		model.setSTATE(soapModel.getSTATE());
		model.setPINCODE(soapModel.getPINCODE());
		model.setCOUNTRY(soapModel.getCOUNTRY());
		model.setCONTACT_NAME(soapModel.getCONTACT_NAME());
		model.setCONTACT_NO(soapModel.getCONTACT_NO());
		model.setALTERNATE_CONTACT_NO(soapModel.getALTERNATE_CONTACT_NO());
		model.setEMERGENCY_CONTACT_DETAILS(soapModel.getEMERGENCY_CONTACT_DETAILS());
		model.setIMAGE_TYPE(soapModel.getIMAGE_TYPE());
		model.setIMAGE(soapModel.getIMAGE());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<BenificiaryRegistration> toModels(
		BenificiaryRegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<BenificiaryRegistration> models = new ArrayList<BenificiaryRegistration>(soapModels.length);

		for (BenificiaryRegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.crowd.funding.database.service.util.ServiceProps.get(
				"lock.expiration.time.com.crowd.funding.database.model.BenificiaryRegistration"));

	public BenificiaryRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _BENIFICIARY_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBENIFICIARY_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _BENIFICIARY_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BenificiaryRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return BenificiaryRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("BENIFICIARY_ID", getBENIFICIARY_ID());
		attributes.put("BENIFICIARY_CATEGORY", getBENIFICIARY_CATEGORY());
		attributes.put("BENIFICIARY_TYPE", getBENIFICIARY_TYPE());
		attributes.put("BENIFICIARY_NAME", getBENIFICIARY_NAME());
		attributes.put("AGE", getAGE());
		attributes.put("GENDER", getGENDER());
		attributes.put("LOCATION", getLOCATION());
		attributes.put("RELATIONSHIP", getRELATIONSHIP());
		attributes.put("RELATIONSHIP_DETAILS", getRELATIONSHIP_DETAILS());
		attributes.put("MEMBERS_NO", getMEMBERS_NO());
		attributes.put("CAUSE_DETAILS", getCAUSE_DETAILS());
		attributes.put("ADDRESS_LINE1", getADDRESS_LINE1());
		attributes.put("ADDRESS_LINE2", getADDRESS_LINE2());
		attributes.put("CITY", getCITY());
		attributes.put("STATE", getSTATE());
		attributes.put("PINCODE", getPINCODE());
		attributes.put("COUNTRY", getCOUNTRY());
		attributes.put("CONTACT_NAME", getCONTACT_NAME());
		attributes.put("CONTACT_NO", getCONTACT_NO());
		attributes.put("ALTERNATE_CONTACT_NO", getALTERNATE_CONTACT_NO());
		attributes.put("EMERGENCY_CONTACT_DETAILS",
			getEMERGENCY_CONTACT_DETAILS());
		attributes.put("IMAGE_TYPE", getIMAGE_TYPE());
		attributes.put("IMAGE", getIMAGE());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long BENIFICIARY_ID = (Long)attributes.get("BENIFICIARY_ID");

		if (BENIFICIARY_ID != null) {
			setBENIFICIARY_ID(BENIFICIARY_ID);
		}

		String BENIFICIARY_CATEGORY = (String)attributes.get(
				"BENIFICIARY_CATEGORY");

		if (BENIFICIARY_CATEGORY != null) {
			setBENIFICIARY_CATEGORY(BENIFICIARY_CATEGORY);
		}

		String BENIFICIARY_TYPE = (String)attributes.get("BENIFICIARY_TYPE");

		if (BENIFICIARY_TYPE != null) {
			setBENIFICIARY_TYPE(BENIFICIARY_TYPE);
		}

		String BENIFICIARY_NAME = (String)attributes.get("BENIFICIARY_NAME");

		if (BENIFICIARY_NAME != null) {
			setBENIFICIARY_NAME(BENIFICIARY_NAME);
		}

		String AGE = (String)attributes.get("AGE");

		if (AGE != null) {
			setAGE(AGE);
		}

		String GENDER = (String)attributes.get("GENDER");

		if (GENDER != null) {
			setGENDER(GENDER);
		}

		String LOCATION = (String)attributes.get("LOCATION");

		if (LOCATION != null) {
			setLOCATION(LOCATION);
		}

		String RELATIONSHIP = (String)attributes.get("RELATIONSHIP");

		if (RELATIONSHIP != null) {
			setRELATIONSHIP(RELATIONSHIP);
		}

		String RELATIONSHIP_DETAILS = (String)attributes.get(
				"RELATIONSHIP_DETAILS");

		if (RELATIONSHIP_DETAILS != null) {
			setRELATIONSHIP_DETAILS(RELATIONSHIP_DETAILS);
		}

		Integer MEMBERS_NO = (Integer)attributes.get("MEMBERS_NO");

		if (MEMBERS_NO != null) {
			setMEMBERS_NO(MEMBERS_NO);
		}

		String CAUSE_DETAILS = (String)attributes.get("CAUSE_DETAILS");

		if (CAUSE_DETAILS != null) {
			setCAUSE_DETAILS(CAUSE_DETAILS);
		}

		String ADDRESS_LINE1 = (String)attributes.get("ADDRESS_LINE1");

		if (ADDRESS_LINE1 != null) {
			setADDRESS_LINE1(ADDRESS_LINE1);
		}

		String ADDRESS_LINE2 = (String)attributes.get("ADDRESS_LINE2");

		if (ADDRESS_LINE2 != null) {
			setADDRESS_LINE2(ADDRESS_LINE2);
		}

		String CITY = (String)attributes.get("CITY");

		if (CITY != null) {
			setCITY(CITY);
		}

		String STATE = (String)attributes.get("STATE");

		if (STATE != null) {
			setSTATE(STATE);
		}

		Integer PINCODE = (Integer)attributes.get("PINCODE");

		if (PINCODE != null) {
			setPINCODE(PINCODE);
		}

		String COUNTRY = (String)attributes.get("COUNTRY");

		if (COUNTRY != null) {
			setCOUNTRY(COUNTRY);
		}

		String CONTACT_NAME = (String)attributes.get("CONTACT_NAME");

		if (CONTACT_NAME != null) {
			setCONTACT_NAME(CONTACT_NAME);
		}

		Long CONTACT_NO = (Long)attributes.get("CONTACT_NO");

		if (CONTACT_NO != null) {
			setCONTACT_NO(CONTACT_NO);
		}

		Long ALTERNATE_CONTACT_NO = (Long)attributes.get("ALTERNATE_CONTACT_NO");

		if (ALTERNATE_CONTACT_NO != null) {
			setALTERNATE_CONTACT_NO(ALTERNATE_CONTACT_NO);
		}

		String EMERGENCY_CONTACT_DETAILS = (String)attributes.get(
				"EMERGENCY_CONTACT_DETAILS");

		if (EMERGENCY_CONTACT_DETAILS != null) {
			setEMERGENCY_CONTACT_DETAILS(EMERGENCY_CONTACT_DETAILS);
		}

		String IMAGE_TYPE = (String)attributes.get("IMAGE_TYPE");

		if (IMAGE_TYPE != null) {
			setIMAGE_TYPE(IMAGE_TYPE);
		}

		Blob IMAGE = (Blob)attributes.get("IMAGE");

		if (IMAGE != null) {
			setIMAGE(IMAGE);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getBENIFICIARY_ID() {
		return _BENIFICIARY_ID;
	}

	@Override
	public void setBENIFICIARY_ID(long BENIFICIARY_ID) {
		_columnBitmask |= BENIFICIARY_ID_COLUMN_BITMASK;

		if (!_setOriginalBENIFICIARY_ID) {
			_setOriginalBENIFICIARY_ID = true;

			_originalBENIFICIARY_ID = _BENIFICIARY_ID;
		}

		_BENIFICIARY_ID = BENIFICIARY_ID;
	}

	public long getOriginalBENIFICIARY_ID() {
		return _originalBENIFICIARY_ID;
	}

	@JSON
	@Override
	public String getBENIFICIARY_CATEGORY() {
		if (_BENIFICIARY_CATEGORY == null) {
			return "";
		}
		else {
			return _BENIFICIARY_CATEGORY;
		}
	}

	@Override
	public void setBENIFICIARY_CATEGORY(String BENIFICIARY_CATEGORY) {
		_columnBitmask |= BENIFICIARY_CATEGORY_COLUMN_BITMASK;

		if (_originalBENIFICIARY_CATEGORY == null) {
			_originalBENIFICIARY_CATEGORY = _BENIFICIARY_CATEGORY;
		}

		_BENIFICIARY_CATEGORY = BENIFICIARY_CATEGORY;
	}

	public String getOriginalBENIFICIARY_CATEGORY() {
		return GetterUtil.getString(_originalBENIFICIARY_CATEGORY);
	}

	@JSON
	@Override
	public String getBENIFICIARY_TYPE() {
		if (_BENIFICIARY_TYPE == null) {
			return "";
		}
		else {
			return _BENIFICIARY_TYPE;
		}
	}

	@Override
	public void setBENIFICIARY_TYPE(String BENIFICIARY_TYPE) {
		_BENIFICIARY_TYPE = BENIFICIARY_TYPE;
	}

	@JSON
	@Override
	public String getBENIFICIARY_NAME() {
		if (_BENIFICIARY_NAME == null) {
			return "";
		}
		else {
			return _BENIFICIARY_NAME;
		}
	}

	@Override
	public void setBENIFICIARY_NAME(String BENIFICIARY_NAME) {
		_BENIFICIARY_NAME = BENIFICIARY_NAME;
	}

	@JSON
	@Override
	public String getAGE() {
		if (_AGE == null) {
			return "";
		}
		else {
			return _AGE;
		}
	}

	@Override
	public void setAGE(String AGE) {
		_AGE = AGE;
	}

	@JSON
	@Override
	public String getGENDER() {
		if (_GENDER == null) {
			return "";
		}
		else {
			return _GENDER;
		}
	}

	@Override
	public void setGENDER(String GENDER) {
		_GENDER = GENDER;
	}

	@JSON
	@Override
	public String getLOCATION() {
		if (_LOCATION == null) {
			return "";
		}
		else {
			return _LOCATION;
		}
	}

	@Override
	public void setLOCATION(String LOCATION) {
		_LOCATION = LOCATION;
	}

	@JSON
	@Override
	public String getRELATIONSHIP() {
		if (_RELATIONSHIP == null) {
			return "";
		}
		else {
			return _RELATIONSHIP;
		}
	}

	@Override
	public void setRELATIONSHIP(String RELATIONSHIP) {
		_RELATIONSHIP = RELATIONSHIP;
	}

	@JSON
	@Override
	public String getRELATIONSHIP_DETAILS() {
		if (_RELATIONSHIP_DETAILS == null) {
			return "";
		}
		else {
			return _RELATIONSHIP_DETAILS;
		}
	}

	@Override
	public void setRELATIONSHIP_DETAILS(String RELATIONSHIP_DETAILS) {
		_RELATIONSHIP_DETAILS = RELATIONSHIP_DETAILS;
	}

	@JSON
	@Override
	public int getMEMBERS_NO() {
		return _MEMBERS_NO;
	}

	@Override
	public void setMEMBERS_NO(int MEMBERS_NO) {
		_MEMBERS_NO = MEMBERS_NO;
	}

	@JSON
	@Override
	public String getCAUSE_DETAILS() {
		if (_CAUSE_DETAILS == null) {
			return "";
		}
		else {
			return _CAUSE_DETAILS;
		}
	}

	@Override
	public void setCAUSE_DETAILS(String CAUSE_DETAILS) {
		_columnBitmask |= CAUSE_DETAILS_COLUMN_BITMASK;

		if (_originalCAUSE_DETAILS == null) {
			_originalCAUSE_DETAILS = _CAUSE_DETAILS;
		}

		_CAUSE_DETAILS = CAUSE_DETAILS;
	}

	public String getOriginalCAUSE_DETAILS() {
		return GetterUtil.getString(_originalCAUSE_DETAILS);
	}

	@JSON
	@Override
	public String getADDRESS_LINE1() {
		if (_ADDRESS_LINE1 == null) {
			return "";
		}
		else {
			return _ADDRESS_LINE1;
		}
	}

	@Override
	public void setADDRESS_LINE1(String ADDRESS_LINE1) {
		_ADDRESS_LINE1 = ADDRESS_LINE1;
	}

	@JSON
	@Override
	public String getADDRESS_LINE2() {
		if (_ADDRESS_LINE2 == null) {
			return "";
		}
		else {
			return _ADDRESS_LINE2;
		}
	}

	@Override
	public void setADDRESS_LINE2(String ADDRESS_LINE2) {
		_ADDRESS_LINE2 = ADDRESS_LINE2;
	}

	@JSON
	@Override
	public String getCITY() {
		if (_CITY == null) {
			return "";
		}
		else {
			return _CITY;
		}
	}

	@Override
	public void setCITY(String CITY) {
		_CITY = CITY;
	}

	@JSON
	@Override
	public String getSTATE() {
		if (_STATE == null) {
			return "";
		}
		else {
			return _STATE;
		}
	}

	@Override
	public void setSTATE(String STATE) {
		_STATE = STATE;
	}

	@JSON
	@Override
	public int getPINCODE() {
		return _PINCODE;
	}

	@Override
	public void setPINCODE(int PINCODE) {
		_PINCODE = PINCODE;
	}

	@JSON
	@Override
	public String getCOUNTRY() {
		if (_COUNTRY == null) {
			return "";
		}
		else {
			return _COUNTRY;
		}
	}

	@Override
	public void setCOUNTRY(String COUNTRY) {
		_COUNTRY = COUNTRY;
	}

	@JSON
	@Override
	public String getCONTACT_NAME() {
		if (_CONTACT_NAME == null) {
			return "";
		}
		else {
			return _CONTACT_NAME;
		}
	}

	@Override
	public void setCONTACT_NAME(String CONTACT_NAME) {
		_CONTACT_NAME = CONTACT_NAME;
	}

	@JSON
	@Override
	public long getCONTACT_NO() {
		return _CONTACT_NO;
	}

	@Override
	public void setCONTACT_NO(long CONTACT_NO) {
		_CONTACT_NO = CONTACT_NO;
	}

	@JSON
	@Override
	public long getALTERNATE_CONTACT_NO() {
		return _ALTERNATE_CONTACT_NO;
	}

	@Override
	public void setALTERNATE_CONTACT_NO(long ALTERNATE_CONTACT_NO) {
		_ALTERNATE_CONTACT_NO = ALTERNATE_CONTACT_NO;
	}

	@JSON
	@Override
	public String getEMERGENCY_CONTACT_DETAILS() {
		if (_EMERGENCY_CONTACT_DETAILS == null) {
			return "";
		}
		else {
			return _EMERGENCY_CONTACT_DETAILS;
		}
	}

	@Override
	public void setEMERGENCY_CONTACT_DETAILS(String EMERGENCY_CONTACT_DETAILS) {
		_EMERGENCY_CONTACT_DETAILS = EMERGENCY_CONTACT_DETAILS;
	}

	@JSON
	@Override
	public String getIMAGE_TYPE() {
		if (_IMAGE_TYPE == null) {
			return "";
		}
		else {
			return _IMAGE_TYPE;
		}
	}

	@Override
	public void setIMAGE_TYPE(String IMAGE_TYPE) {
		_IMAGE_TYPE = IMAGE_TYPE;
	}

	@JSON
	@Override
	public Blob getIMAGE() {
		if (_IMAGEBlobModel == null) {
			try {
				_IMAGEBlobModel = BenificiaryRegistrationLocalServiceUtil.getIMAGEBlobModel(getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_IMAGEBlobModel != null) {
			blob = _IMAGEBlobModel.getIMAGEBlob();
		}

		return blob;
	}

	@Override
	public void setIMAGE(Blob IMAGE) {
		if (_IMAGEBlobModel == null) {
			_IMAGEBlobModel = new BenificiaryRegistrationIMAGEBlobModel(getPrimaryKey(),
					IMAGE);
		}
		else {
			_IMAGEBlobModel.setIMAGEBlob(IMAGE);
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BenificiaryRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BenificiaryRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BenificiaryRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BenificiaryRegistrationImpl benificiaryRegistrationImpl = new BenificiaryRegistrationImpl();

		benificiaryRegistrationImpl.setUuid(getUuid());
		benificiaryRegistrationImpl.setBENIFICIARY_ID(getBENIFICIARY_ID());
		benificiaryRegistrationImpl.setBENIFICIARY_CATEGORY(getBENIFICIARY_CATEGORY());
		benificiaryRegistrationImpl.setBENIFICIARY_TYPE(getBENIFICIARY_TYPE());
		benificiaryRegistrationImpl.setBENIFICIARY_NAME(getBENIFICIARY_NAME());
		benificiaryRegistrationImpl.setAGE(getAGE());
		benificiaryRegistrationImpl.setGENDER(getGENDER());
		benificiaryRegistrationImpl.setLOCATION(getLOCATION());
		benificiaryRegistrationImpl.setRELATIONSHIP(getRELATIONSHIP());
		benificiaryRegistrationImpl.setRELATIONSHIP_DETAILS(getRELATIONSHIP_DETAILS());
		benificiaryRegistrationImpl.setMEMBERS_NO(getMEMBERS_NO());
		benificiaryRegistrationImpl.setCAUSE_DETAILS(getCAUSE_DETAILS());
		benificiaryRegistrationImpl.setADDRESS_LINE1(getADDRESS_LINE1());
		benificiaryRegistrationImpl.setADDRESS_LINE2(getADDRESS_LINE2());
		benificiaryRegistrationImpl.setCITY(getCITY());
		benificiaryRegistrationImpl.setSTATE(getSTATE());
		benificiaryRegistrationImpl.setPINCODE(getPINCODE());
		benificiaryRegistrationImpl.setCOUNTRY(getCOUNTRY());
		benificiaryRegistrationImpl.setCONTACT_NAME(getCONTACT_NAME());
		benificiaryRegistrationImpl.setCONTACT_NO(getCONTACT_NO());
		benificiaryRegistrationImpl.setALTERNATE_CONTACT_NO(getALTERNATE_CONTACT_NO());
		benificiaryRegistrationImpl.setEMERGENCY_CONTACT_DETAILS(getEMERGENCY_CONTACT_DETAILS());
		benificiaryRegistrationImpl.setIMAGE_TYPE(getIMAGE_TYPE());

		benificiaryRegistrationImpl.resetOriginalValues();

		return benificiaryRegistrationImpl;
	}

	@Override
	public int compareTo(BenificiaryRegistration benificiaryRegistration) {
		long primaryKey = benificiaryRegistration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BenificiaryRegistration)) {
			return false;
		}

		BenificiaryRegistration benificiaryRegistration = (BenificiaryRegistration)obj;

		long primaryKey = benificiaryRegistration.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		BenificiaryRegistrationModelImpl benificiaryRegistrationModelImpl = this;

		benificiaryRegistrationModelImpl._originalUuid = benificiaryRegistrationModelImpl._uuid;

		benificiaryRegistrationModelImpl._originalBENIFICIARY_ID = benificiaryRegistrationModelImpl._BENIFICIARY_ID;

		benificiaryRegistrationModelImpl._setOriginalBENIFICIARY_ID = false;

		benificiaryRegistrationModelImpl._originalBENIFICIARY_CATEGORY = benificiaryRegistrationModelImpl._BENIFICIARY_CATEGORY;

		benificiaryRegistrationModelImpl._originalCAUSE_DETAILS = benificiaryRegistrationModelImpl._CAUSE_DETAILS;

		benificiaryRegistrationModelImpl._IMAGEBlobModel = null;

		benificiaryRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BenificiaryRegistration> toCacheModel() {
		BenificiaryRegistrationCacheModel benificiaryRegistrationCacheModel = new BenificiaryRegistrationCacheModel();

		benificiaryRegistrationCacheModel.uuid = getUuid();

		String uuid = benificiaryRegistrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			benificiaryRegistrationCacheModel.uuid = null;
		}

		benificiaryRegistrationCacheModel.BENIFICIARY_ID = getBENIFICIARY_ID();

		benificiaryRegistrationCacheModel.BENIFICIARY_CATEGORY = getBENIFICIARY_CATEGORY();

		String BENIFICIARY_CATEGORY = benificiaryRegistrationCacheModel.BENIFICIARY_CATEGORY;

		if ((BENIFICIARY_CATEGORY != null) &&
				(BENIFICIARY_CATEGORY.length() == 0)) {
			benificiaryRegistrationCacheModel.BENIFICIARY_CATEGORY = null;
		}

		benificiaryRegistrationCacheModel.BENIFICIARY_TYPE = getBENIFICIARY_TYPE();

		String BENIFICIARY_TYPE = benificiaryRegistrationCacheModel.BENIFICIARY_TYPE;

		if ((BENIFICIARY_TYPE != null) && (BENIFICIARY_TYPE.length() == 0)) {
			benificiaryRegistrationCacheModel.BENIFICIARY_TYPE = null;
		}

		benificiaryRegistrationCacheModel.BENIFICIARY_NAME = getBENIFICIARY_NAME();

		String BENIFICIARY_NAME = benificiaryRegistrationCacheModel.BENIFICIARY_NAME;

		if ((BENIFICIARY_NAME != null) && (BENIFICIARY_NAME.length() == 0)) {
			benificiaryRegistrationCacheModel.BENIFICIARY_NAME = null;
		}

		benificiaryRegistrationCacheModel.AGE = getAGE();

		String AGE = benificiaryRegistrationCacheModel.AGE;

		if ((AGE != null) && (AGE.length() == 0)) {
			benificiaryRegistrationCacheModel.AGE = null;
		}

		benificiaryRegistrationCacheModel.GENDER = getGENDER();

		String GENDER = benificiaryRegistrationCacheModel.GENDER;

		if ((GENDER != null) && (GENDER.length() == 0)) {
			benificiaryRegistrationCacheModel.GENDER = null;
		}

		benificiaryRegistrationCacheModel.LOCATION = getLOCATION();

		String LOCATION = benificiaryRegistrationCacheModel.LOCATION;

		if ((LOCATION != null) && (LOCATION.length() == 0)) {
			benificiaryRegistrationCacheModel.LOCATION = null;
		}

		benificiaryRegistrationCacheModel.RELATIONSHIP = getRELATIONSHIP();

		String RELATIONSHIP = benificiaryRegistrationCacheModel.RELATIONSHIP;

		if ((RELATIONSHIP != null) && (RELATIONSHIP.length() == 0)) {
			benificiaryRegistrationCacheModel.RELATIONSHIP = null;
		}

		benificiaryRegistrationCacheModel.RELATIONSHIP_DETAILS = getRELATIONSHIP_DETAILS();

		String RELATIONSHIP_DETAILS = benificiaryRegistrationCacheModel.RELATIONSHIP_DETAILS;

		if ((RELATIONSHIP_DETAILS != null) &&
				(RELATIONSHIP_DETAILS.length() == 0)) {
			benificiaryRegistrationCacheModel.RELATIONSHIP_DETAILS = null;
		}

		benificiaryRegistrationCacheModel.MEMBERS_NO = getMEMBERS_NO();

		benificiaryRegistrationCacheModel.CAUSE_DETAILS = getCAUSE_DETAILS();

		String CAUSE_DETAILS = benificiaryRegistrationCacheModel.CAUSE_DETAILS;

		if ((CAUSE_DETAILS != null) && (CAUSE_DETAILS.length() == 0)) {
			benificiaryRegistrationCacheModel.CAUSE_DETAILS = null;
		}

		benificiaryRegistrationCacheModel.ADDRESS_LINE1 = getADDRESS_LINE1();

		String ADDRESS_LINE1 = benificiaryRegistrationCacheModel.ADDRESS_LINE1;

		if ((ADDRESS_LINE1 != null) && (ADDRESS_LINE1.length() == 0)) {
			benificiaryRegistrationCacheModel.ADDRESS_LINE1 = null;
		}

		benificiaryRegistrationCacheModel.ADDRESS_LINE2 = getADDRESS_LINE2();

		String ADDRESS_LINE2 = benificiaryRegistrationCacheModel.ADDRESS_LINE2;

		if ((ADDRESS_LINE2 != null) && (ADDRESS_LINE2.length() == 0)) {
			benificiaryRegistrationCacheModel.ADDRESS_LINE2 = null;
		}

		benificiaryRegistrationCacheModel.CITY = getCITY();

		String CITY = benificiaryRegistrationCacheModel.CITY;

		if ((CITY != null) && (CITY.length() == 0)) {
			benificiaryRegistrationCacheModel.CITY = null;
		}

		benificiaryRegistrationCacheModel.STATE = getSTATE();

		String STATE = benificiaryRegistrationCacheModel.STATE;

		if ((STATE != null) && (STATE.length() == 0)) {
			benificiaryRegistrationCacheModel.STATE = null;
		}

		benificiaryRegistrationCacheModel.PINCODE = getPINCODE();

		benificiaryRegistrationCacheModel.COUNTRY = getCOUNTRY();

		String COUNTRY = benificiaryRegistrationCacheModel.COUNTRY;

		if ((COUNTRY != null) && (COUNTRY.length() == 0)) {
			benificiaryRegistrationCacheModel.COUNTRY = null;
		}

		benificiaryRegistrationCacheModel.CONTACT_NAME = getCONTACT_NAME();

		String CONTACT_NAME = benificiaryRegistrationCacheModel.CONTACT_NAME;

		if ((CONTACT_NAME != null) && (CONTACT_NAME.length() == 0)) {
			benificiaryRegistrationCacheModel.CONTACT_NAME = null;
		}

		benificiaryRegistrationCacheModel.CONTACT_NO = getCONTACT_NO();

		benificiaryRegistrationCacheModel.ALTERNATE_CONTACT_NO = getALTERNATE_CONTACT_NO();

		benificiaryRegistrationCacheModel.EMERGENCY_CONTACT_DETAILS = getEMERGENCY_CONTACT_DETAILS();

		String EMERGENCY_CONTACT_DETAILS = benificiaryRegistrationCacheModel.EMERGENCY_CONTACT_DETAILS;

		if ((EMERGENCY_CONTACT_DETAILS != null) &&
				(EMERGENCY_CONTACT_DETAILS.length() == 0)) {
			benificiaryRegistrationCacheModel.EMERGENCY_CONTACT_DETAILS = null;
		}

		benificiaryRegistrationCacheModel.IMAGE_TYPE = getIMAGE_TYPE();

		String IMAGE_TYPE = benificiaryRegistrationCacheModel.IMAGE_TYPE;

		if ((IMAGE_TYPE != null) && (IMAGE_TYPE.length() == 0)) {
			benificiaryRegistrationCacheModel.IMAGE_TYPE = null;
		}

		return benificiaryRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", BENIFICIARY_ID=");
		sb.append(getBENIFICIARY_ID());
		sb.append(", BENIFICIARY_CATEGORY=");
		sb.append(getBENIFICIARY_CATEGORY());
		sb.append(", BENIFICIARY_TYPE=");
		sb.append(getBENIFICIARY_TYPE());
		sb.append(", BENIFICIARY_NAME=");
		sb.append(getBENIFICIARY_NAME());
		sb.append(", AGE=");
		sb.append(getAGE());
		sb.append(", GENDER=");
		sb.append(getGENDER());
		sb.append(", LOCATION=");
		sb.append(getLOCATION());
		sb.append(", RELATIONSHIP=");
		sb.append(getRELATIONSHIP());
		sb.append(", RELATIONSHIP_DETAILS=");
		sb.append(getRELATIONSHIP_DETAILS());
		sb.append(", MEMBERS_NO=");
		sb.append(getMEMBERS_NO());
		sb.append(", CAUSE_DETAILS=");
		sb.append(getCAUSE_DETAILS());
		sb.append(", ADDRESS_LINE1=");
		sb.append(getADDRESS_LINE1());
		sb.append(", ADDRESS_LINE2=");
		sb.append(getADDRESS_LINE2());
		sb.append(", CITY=");
		sb.append(getCITY());
		sb.append(", STATE=");
		sb.append(getSTATE());
		sb.append(", PINCODE=");
		sb.append(getPINCODE());
		sb.append(", COUNTRY=");
		sb.append(getCOUNTRY());
		sb.append(", CONTACT_NAME=");
		sb.append(getCONTACT_NAME());
		sb.append(", CONTACT_NO=");
		sb.append(getCONTACT_NO());
		sb.append(", ALTERNATE_CONTACT_NO=");
		sb.append(getALTERNATE_CONTACT_NO());
		sb.append(", EMERGENCY_CONTACT_DETAILS=");
		sb.append(getEMERGENCY_CONTACT_DETAILS());
		sb.append(", IMAGE_TYPE=");
		sb.append(getIMAGE_TYPE());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("com.crowd.funding.database.model.BenificiaryRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>BENIFICIARY_ID</column-name><column-value><![CDATA[");
		sb.append(getBENIFICIARY_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>BENIFICIARY_CATEGORY</column-name><column-value><![CDATA[");
		sb.append(getBENIFICIARY_CATEGORY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>BENIFICIARY_TYPE</column-name><column-value><![CDATA[");
		sb.append(getBENIFICIARY_TYPE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>BENIFICIARY_NAME</column-name><column-value><![CDATA[");
		sb.append(getBENIFICIARY_NAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AGE</column-name><column-value><![CDATA[");
		sb.append(getAGE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>GENDER</column-name><column-value><![CDATA[");
		sb.append(getGENDER());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LOCATION</column-name><column-value><![CDATA[");
		sb.append(getLOCATION());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RELATIONSHIP</column-name><column-value><![CDATA[");
		sb.append(getRELATIONSHIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RELATIONSHIP_DETAILS</column-name><column-value><![CDATA[");
		sb.append(getRELATIONSHIP_DETAILS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>MEMBERS_NO</column-name><column-value><![CDATA[");
		sb.append(getMEMBERS_NO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CAUSE_DETAILS</column-name><column-value><![CDATA[");
		sb.append(getCAUSE_DETAILS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ADDRESS_LINE1</column-name><column-value><![CDATA[");
		sb.append(getADDRESS_LINE1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ADDRESS_LINE2</column-name><column-value><![CDATA[");
		sb.append(getADDRESS_LINE2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CITY</column-name><column-value><![CDATA[");
		sb.append(getCITY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>STATE</column-name><column-value><![CDATA[");
		sb.append(getSTATE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PINCODE</column-name><column-value><![CDATA[");
		sb.append(getPINCODE());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>COUNTRY</column-name><column-value><![CDATA[");
		sb.append(getCOUNTRY());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CONTACT_NAME</column-name><column-value><![CDATA[");
		sb.append(getCONTACT_NAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CONTACT_NO</column-name><column-value><![CDATA[");
		sb.append(getCONTACT_NO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ALTERNATE_CONTACT_NO</column-name><column-value><![CDATA[");
		sb.append(getALTERNATE_CONTACT_NO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EMERGENCY_CONTACT_DETAILS</column-name><column-value><![CDATA[");
		sb.append(getEMERGENCY_CONTACT_DETAILS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IMAGE_TYPE</column-name><column-value><![CDATA[");
		sb.append(getIMAGE_TYPE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = BenificiaryRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			BenificiaryRegistration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _BENIFICIARY_ID;
	private long _originalBENIFICIARY_ID;
	private boolean _setOriginalBENIFICIARY_ID;
	private String _BENIFICIARY_CATEGORY;
	private String _originalBENIFICIARY_CATEGORY;
	private String _BENIFICIARY_TYPE;
	private String _BENIFICIARY_NAME;
	private String _AGE;
	private String _GENDER;
	private String _LOCATION;
	private String _RELATIONSHIP;
	private String _RELATIONSHIP_DETAILS;
	private int _MEMBERS_NO;
	private String _CAUSE_DETAILS;
	private String _originalCAUSE_DETAILS;
	private String _ADDRESS_LINE1;
	private String _ADDRESS_LINE2;
	private String _CITY;
	private String _STATE;
	private int _PINCODE;
	private String _COUNTRY;
	private String _CONTACT_NAME;
	private long _CONTACT_NO;
	private long _ALTERNATE_CONTACT_NO;
	private String _EMERGENCY_CONTACT_DETAILS;
	private String _IMAGE_TYPE;
	private BenificiaryRegistrationIMAGEBlobModel _IMAGEBlobModel;
	private long _columnBitmask;
	private BenificiaryRegistration _escapedModel;
}