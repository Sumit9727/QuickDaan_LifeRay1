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

import com.crowd.funding.database.model.UserFollowRegistration;
import com.crowd.funding.database.model.UserFollowRegistrationModel;
import com.crowd.funding.database.model.UserFollowRegistrationSoap;

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

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserFollowRegistration service. Represents a row in the &quot;cf_user_follow_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link UserFollowRegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserFollowRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistrationImpl
 * @see UserFollowRegistration
 * @see UserFollowRegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class UserFollowRegistrationModelImpl extends BaseModelImpl<UserFollowRegistration>
	implements UserFollowRegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user follow registration model instance should use the {@link UserFollowRegistration} interface instead.
	 */
	public static final String TABLE_NAME = "cf_user_follow_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "USER_FOLLOW_ID", Types.BIGINT },
			{ "USER_ID", Types.BIGINT },
			{ "FOLLOWER_USER_ID", Types.BIGINT },
			{ "STATUS", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("USER_FOLLOW_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("USER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("FOLLOWER_USER_ID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("STATUS", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table cf_user_follow_details (uuid_ VARCHAR(75) null,USER_FOLLOW_ID LONG not null primary key,USER_ID LONG,FOLLOWER_USER_ID LONG,STATUS INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table cf_user_follow_details";
	public static final String ORDER_BY_JPQL = " ORDER BY userFollowRegistration.USER_FOLLOW_ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cf_user_follow_details.USER_FOLLOW_ID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.crowd.funding.database.model.UserFollowRegistration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.crowd.funding.database.model.UserFollowRegistration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.crowd.funding.database.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.crowd.funding.database.model.UserFollowRegistration"),
			true);
	public static final long FOLLOWER_USER_ID_COLUMN_BITMASK = 1L;
	public static final long USER_FOLLOW_ID_COLUMN_BITMASK = 2L;
	public static final long USER_ID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserFollowRegistration toModel(
		UserFollowRegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserFollowRegistration model = new UserFollowRegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setUSER_FOLLOW_ID(soapModel.getUSER_FOLLOW_ID());
		model.setUSER_ID(soapModel.getUSER_ID());
		model.setFOLLOWER_USER_ID(soapModel.getFOLLOWER_USER_ID());
		model.setSTATUS(soapModel.getSTATUS());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserFollowRegistration> toModels(
		UserFollowRegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserFollowRegistration> models = new ArrayList<UserFollowRegistration>(soapModels.length);

		for (UserFollowRegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.crowd.funding.database.service.util.ServiceProps.get(
				"lock.expiration.time.com.crowd.funding.database.model.UserFollowRegistration"));

	public UserFollowRegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _USER_FOLLOW_ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUSER_FOLLOW_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _USER_FOLLOW_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserFollowRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return UserFollowRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("USER_FOLLOW_ID", getUSER_FOLLOW_ID());
		attributes.put("USER_ID", getUSER_ID());
		attributes.put("FOLLOWER_USER_ID", getFOLLOWER_USER_ID());
		attributes.put("STATUS", getSTATUS());

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

		Long USER_FOLLOW_ID = (Long)attributes.get("USER_FOLLOW_ID");

		if (USER_FOLLOW_ID != null) {
			setUSER_FOLLOW_ID(USER_FOLLOW_ID);
		}

		Long USER_ID = (Long)attributes.get("USER_ID");

		if (USER_ID != null) {
			setUSER_ID(USER_ID);
		}

		Long FOLLOWER_USER_ID = (Long)attributes.get("FOLLOWER_USER_ID");

		if (FOLLOWER_USER_ID != null) {
			setFOLLOWER_USER_ID(FOLLOWER_USER_ID);
		}

		Integer STATUS = (Integer)attributes.get("STATUS");

		if (STATUS != null) {
			setSTATUS(STATUS);
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
	public long getUSER_FOLLOW_ID() {
		return _USER_FOLLOW_ID;
	}

	@Override
	public void setUSER_FOLLOW_ID(long USER_FOLLOW_ID) {
		_columnBitmask |= USER_FOLLOW_ID_COLUMN_BITMASK;

		if (!_setOriginalUSER_FOLLOW_ID) {
			_setOriginalUSER_FOLLOW_ID = true;

			_originalUSER_FOLLOW_ID = _USER_FOLLOW_ID;
		}

		_USER_FOLLOW_ID = USER_FOLLOW_ID;
	}

	public long getOriginalUSER_FOLLOW_ID() {
		return _originalUSER_FOLLOW_ID;
	}

	@JSON
	@Override
	public long getUSER_ID() {
		return _USER_ID;
	}

	@Override
	public void setUSER_ID(long USER_ID) {
		_columnBitmask |= USER_ID_COLUMN_BITMASK;

		if (!_setOriginalUSER_ID) {
			_setOriginalUSER_ID = true;

			_originalUSER_ID = _USER_ID;
		}

		_USER_ID = USER_ID;
	}

	public long getOriginalUSER_ID() {
		return _originalUSER_ID;
	}

	@JSON
	@Override
	public long getFOLLOWER_USER_ID() {
		return _FOLLOWER_USER_ID;
	}

	@Override
	public void setFOLLOWER_USER_ID(long FOLLOWER_USER_ID) {
		_columnBitmask |= FOLLOWER_USER_ID_COLUMN_BITMASK;

		if (!_setOriginalFOLLOWER_USER_ID) {
			_setOriginalFOLLOWER_USER_ID = true;

			_originalFOLLOWER_USER_ID = _FOLLOWER_USER_ID;
		}

		_FOLLOWER_USER_ID = FOLLOWER_USER_ID;
	}

	public long getOriginalFOLLOWER_USER_ID() {
		return _originalFOLLOWER_USER_ID;
	}

	@JSON
	@Override
	public int getSTATUS() {
		return _STATUS;
	}

	@Override
	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserFollowRegistration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserFollowRegistration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserFollowRegistration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserFollowRegistrationImpl userFollowRegistrationImpl = new UserFollowRegistrationImpl();

		userFollowRegistrationImpl.setUuid(getUuid());
		userFollowRegistrationImpl.setUSER_FOLLOW_ID(getUSER_FOLLOW_ID());
		userFollowRegistrationImpl.setUSER_ID(getUSER_ID());
		userFollowRegistrationImpl.setFOLLOWER_USER_ID(getFOLLOWER_USER_ID());
		userFollowRegistrationImpl.setSTATUS(getSTATUS());

		userFollowRegistrationImpl.resetOriginalValues();

		return userFollowRegistrationImpl;
	}

	@Override
	public int compareTo(UserFollowRegistration userFollowRegistration) {
		long primaryKey = userFollowRegistration.getPrimaryKey();

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

		if (!(obj instanceof UserFollowRegistration)) {
			return false;
		}

		UserFollowRegistration userFollowRegistration = (UserFollowRegistration)obj;

		long primaryKey = userFollowRegistration.getPrimaryKey();

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
		UserFollowRegistrationModelImpl userFollowRegistrationModelImpl = this;

		userFollowRegistrationModelImpl._originalUuid = userFollowRegistrationModelImpl._uuid;

		userFollowRegistrationModelImpl._originalUSER_FOLLOW_ID = userFollowRegistrationModelImpl._USER_FOLLOW_ID;

		userFollowRegistrationModelImpl._setOriginalUSER_FOLLOW_ID = false;

		userFollowRegistrationModelImpl._originalUSER_ID = userFollowRegistrationModelImpl._USER_ID;

		userFollowRegistrationModelImpl._setOriginalUSER_ID = false;

		userFollowRegistrationModelImpl._originalFOLLOWER_USER_ID = userFollowRegistrationModelImpl._FOLLOWER_USER_ID;

		userFollowRegistrationModelImpl._setOriginalFOLLOWER_USER_ID = false;

		userFollowRegistrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserFollowRegistration> toCacheModel() {
		UserFollowRegistrationCacheModel userFollowRegistrationCacheModel = new UserFollowRegistrationCacheModel();

		userFollowRegistrationCacheModel.uuid = getUuid();

		String uuid = userFollowRegistrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			userFollowRegistrationCacheModel.uuid = null;
		}

		userFollowRegistrationCacheModel.USER_FOLLOW_ID = getUSER_FOLLOW_ID();

		userFollowRegistrationCacheModel.USER_ID = getUSER_ID();

		userFollowRegistrationCacheModel.FOLLOWER_USER_ID = getFOLLOWER_USER_ID();

		userFollowRegistrationCacheModel.STATUS = getSTATUS();

		return userFollowRegistrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", USER_FOLLOW_ID=");
		sb.append(getUSER_FOLLOW_ID());
		sb.append(", USER_ID=");
		sb.append(getUSER_ID());
		sb.append(", FOLLOWER_USER_ID=");
		sb.append(getFOLLOWER_USER_ID());
		sb.append(", STATUS=");
		sb.append(getSTATUS());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.crowd.funding.database.model.UserFollowRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>USER_FOLLOW_ID</column-name><column-value><![CDATA[");
		sb.append(getUSER_FOLLOW_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>USER_ID</column-name><column-value><![CDATA[");
		sb.append(getUSER_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>FOLLOWER_USER_ID</column-name><column-value><![CDATA[");
		sb.append(getFOLLOWER_USER_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>STATUS</column-name><column-value><![CDATA[");
		sb.append(getSTATUS());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = UserFollowRegistration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			UserFollowRegistration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _USER_FOLLOW_ID;
	private long _originalUSER_FOLLOW_ID;
	private boolean _setOriginalUSER_FOLLOW_ID;
	private long _USER_ID;
	private long _originalUSER_ID;
	private boolean _setOriginalUSER_ID;
	private long _FOLLOWER_USER_ID;
	private long _originalFOLLOWER_USER_ID;
	private boolean _setOriginalFOLLOWER_USER_ID;
	private int _STATUS;
	private long _columnBitmask;
	private UserFollowRegistration _escapedModel;
}