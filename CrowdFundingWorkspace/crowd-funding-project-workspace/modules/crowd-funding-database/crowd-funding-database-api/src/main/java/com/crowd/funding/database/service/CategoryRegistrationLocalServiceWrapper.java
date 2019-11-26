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

package com.crowd.funding.database.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CategoryRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CategoryRegistrationLocalService
 * @generated
 */
@ProviderType
public class CategoryRegistrationLocalServiceWrapper
	implements CategoryRegistrationLocalService,
		ServiceWrapper<CategoryRegistrationLocalService> {
	public CategoryRegistrationLocalServiceWrapper(
		CategoryRegistrationLocalService categoryRegistrationLocalService) {
		_categoryRegistrationLocalService = categoryRegistrationLocalService;
	}

	/**
	* Adds the category registration to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryRegistration the category registration
	* @return the category registration that was added
	*/
	@Override
	public com.crowd.funding.database.model.CategoryRegistration addCategoryRegistration(
		com.crowd.funding.database.model.CategoryRegistration categoryRegistration) {
		return _categoryRegistrationLocalService.addCategoryRegistration(categoryRegistration);
	}

	/**
	* Creates a new category registration with the primary key. Does not add the category registration to the database.
	*
	* @param CATEGORY_ID the primary key for the new category registration
	* @return the new category registration
	*/
	@Override
	public com.crowd.funding.database.model.CategoryRegistration createCategoryRegistration(
		long CATEGORY_ID) {
		return _categoryRegistrationLocalService.createCategoryRegistration(CATEGORY_ID);
	}

	/**
	* Deletes the category registration from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryRegistration the category registration
	* @return the category registration that was removed
	*/
	@Override
	public com.crowd.funding.database.model.CategoryRegistration deleteCategoryRegistration(
		com.crowd.funding.database.model.CategoryRegistration categoryRegistration) {
		return _categoryRegistrationLocalService.deleteCategoryRegistration(categoryRegistration);
	}

	/**
	* Deletes the category registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration that was removed
	* @throws PortalException if a category registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.CategoryRegistration deleteCategoryRegistration(
		long CATEGORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryRegistrationLocalService.deleteCategoryRegistration(CATEGORY_ID);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryRegistrationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoryRegistrationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _categoryRegistrationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _categoryRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _categoryRegistrationLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _categoryRegistrationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _categoryRegistrationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.crowd.funding.database.model.CategoryRegistration fetchCategoryRegistration(
		long CATEGORY_ID) {
		return _categoryRegistrationLocalService.fetchCategoryRegistration(CATEGORY_ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _categoryRegistrationLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the category registration with the primary key.
	*
	* @param CATEGORY_ID the primary key of the category registration
	* @return the category registration
	* @throws PortalException if a category registration with the primary key could not be found
	*/
	@Override
	public com.crowd.funding.database.model.CategoryRegistration getCategoryRegistration(
		long CATEGORY_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryRegistrationLocalService.getCategoryRegistration(CATEGORY_ID);
	}

	/**
	* Returns a range of all the category registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.CategoryRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of category registrations
	* @param end the upper bound of the range of category registrations (not inclusive)
	* @return the range of category registrations
	*/
	@Override
	public java.util.List<com.crowd.funding.database.model.CategoryRegistration> getCategoryRegistrations(
		int start, int end) {
		return _categoryRegistrationLocalService.getCategoryRegistrations(start,
			end);
	}

	/**
	* Returns the number of category registrations.
	*
	* @return the number of category registrations
	*/
	@Override
	public int getCategoryRegistrationsCount() {
		return _categoryRegistrationLocalService.getCategoryRegistrationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _categoryRegistrationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _categoryRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _categoryRegistrationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the category registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryRegistration the category registration
	* @return the category registration that was updated
	*/
	@Override
	public com.crowd.funding.database.model.CategoryRegistration updateCategoryRegistration(
		com.crowd.funding.database.model.CategoryRegistration categoryRegistration) {
		return _categoryRegistrationLocalService.updateCategoryRegistration(categoryRegistration);
	}

	@Override
	public CategoryRegistrationLocalService getWrappedService() {
		return _categoryRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		CategoryRegistrationLocalService categoryRegistrationLocalService) {
		_categoryRegistrationLocalService = categoryRegistrationLocalService;
	}

	private CategoryRegistrationLocalService _categoryRegistrationLocalService;
}