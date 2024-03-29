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

/**
 * The base model interface for the UserFollowRegistration service. Represents a row in the &quot;cf_user_follow_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.crowd.funding.database.model.impl.UserFollowRegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.crowd.funding.database.model.impl.UserFollowRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFollowRegistration
 * @see com.crowd.funding.database.model.impl.UserFollowRegistrationImpl
 * @see com.crowd.funding.database.model.impl.UserFollowRegistrationModelImpl
 * @generated
 */
@ProviderType
public interface UserFollowRegistrationModel extends BaseModel<UserFollowRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user follow registration model instance should use the {@link UserFollowRegistration} interface instead.
	 */

	/**
	 * Returns the primary key of this user follow registration.
	 *
	 * @return the primary key of this user follow registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user follow registration.
	 *
	 * @param primaryKey the primary key of this user follow registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this user follow registration.
	 *
	 * @return the uuid of this user follow registration
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this user follow registration.
	 *
	 * @param uuid the uuid of this user follow registration
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the user_follow_id of this user follow registration.
	 *
	 * @return the user_follow_id of this user follow registration
	 */
	public long getUSER_FOLLOW_ID();

	/**
	 * Sets the user_follow_id of this user follow registration.
	 *
	 * @param USER_FOLLOW_ID the user_follow_id of this user follow registration
	 */
	public void setUSER_FOLLOW_ID(long USER_FOLLOW_ID);

	/**
	 * Returns the user_id of this user follow registration.
	 *
	 * @return the user_id of this user follow registration
	 */
	public long getUSER_ID();

	/**
	 * Sets the user_id of this user follow registration.
	 *
	 * @param USER_ID the user_id of this user follow registration
	 */
	public void setUSER_ID(long USER_ID);

	/**
	 * Returns the follower_user_id of this user follow registration.
	 *
	 * @return the follower_user_id of this user follow registration
	 */
	public long getFOLLOWER_USER_ID();

	/**
	 * Sets the follower_user_id of this user follow registration.
	 *
	 * @param FOLLOWER_USER_ID the follower_user_id of this user follow registration
	 */
	public void setFOLLOWER_USER_ID(long FOLLOWER_USER_ID);

	/**
	 * Returns the status of this user follow registration.
	 *
	 * @return the status of this user follow registration
	 */
	public int getSTATUS();

	/**
	 * Sets the status of this user follow registration.
	 *
	 * @param STATUS the status of this user follow registration
	 */
	public void setSTATUS(int STATUS);

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
	public int compareTo(UserFollowRegistration userFollowRegistration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UserFollowRegistration> toCacheModel();

	@Override
	public UserFollowRegistration toEscapedModel();

	@Override
	public UserFollowRegistration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}