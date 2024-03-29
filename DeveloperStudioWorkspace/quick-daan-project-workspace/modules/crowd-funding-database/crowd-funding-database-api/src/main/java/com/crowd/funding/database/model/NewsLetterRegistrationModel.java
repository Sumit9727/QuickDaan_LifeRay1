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

import java.sql.Blob;

import java.util.Date;

/**
 * The base model interface for the NewsLetterRegistration service. Represents a row in the &quot;cf_news_letter_details&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.crowd.funding.database.model.impl.NewsLetterRegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterRegistration
 * @see com.crowd.funding.database.model.impl.NewsLetterRegistrationImpl
 * @see com.crowd.funding.database.model.impl.NewsLetterRegistrationModelImpl
 * @generated
 */
@ProviderType
public interface NewsLetterRegistrationModel extends BaseModel<NewsLetterRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a news letter registration model instance should use the {@link NewsLetterRegistration} interface instead.
	 */

	/**
	 * Returns the primary key of this news letter registration.
	 *
	 * @return the primary key of this news letter registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this news letter registration.
	 *
	 * @param primaryKey the primary key of this news letter registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this news letter registration.
	 *
	 * @return the uuid of this news letter registration
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this news letter registration.
	 *
	 * @param uuid the uuid of this news letter registration
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the news_letter_id of this news letter registration.
	 *
	 * @return the news_letter_id of this news letter registration
	 */
	public long getNEWS_LETTER_ID();

	/**
	 * Sets the news_letter_id of this news letter registration.
	 *
	 * @param NEWS_LETTER_ID the news_letter_id of this news letter registration
	 */
	public void setNEWS_LETTER_ID(long NEWS_LETTER_ID);

	/**
	 * Returns the title of this news letter registration.
	 *
	 * @return the title of this news letter registration
	 */
	@AutoEscape
	public String getTITLE();

	/**
	 * Sets the title of this news letter registration.
	 *
	 * @param TITLE the title of this news letter registration
	 */
	public void setTITLE(String TITLE);

	/**
	 * Returns the details of this news letter registration.
	 *
	 * @return the details of this news letter registration
	 */
	@AutoEscape
	public String getDETAILS();

	/**
	 * Sets the details of this news letter registration.
	 *
	 * @param DETAILS the details of this news letter registration
	 */
	public void setDETAILS(String DETAILS);

	/**
	 * Returns the document_type of this news letter registration.
	 *
	 * @return the document_type of this news letter registration
	 */
	@AutoEscape
	public String getDOCUMENT_TYPE();

	/**
	 * Sets the document_type of this news letter registration.
	 *
	 * @param DOCUMENT_TYPE the document_type of this news letter registration
	 */
	public void setDOCUMENT_TYPE(String DOCUMENT_TYPE);

	/**
	 * Returns the document of this news letter registration.
	 *
	 * @return the document of this news letter registration
	 */
	public Blob getDOCUMENT();

	/**
	 * Sets the document of this news letter registration.
	 *
	 * @param DOCUMENT the document of this news letter registration
	 */
	public void setDOCUMENT(Blob DOCUMENT);

	/**
	 * Returns the date of this news letter registration.
	 *
	 * @return the date of this news letter registration
	 */
	public Date getDATE();

	/**
	 * Sets the date of this news letter registration.
	 *
	 * @param DATE the date of this news letter registration
	 */
	public void setDATE(Date DATE);

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
	public int compareTo(NewsLetterRegistration newsLetterRegistration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<NewsLetterRegistration> toCacheModel();

	@Override
	public NewsLetterRegistration toEscapedModel();

	@Override
	public NewsLetterRegistration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}