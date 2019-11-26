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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PostionRegistration. This utility wraps
 * {@link com.crowd.funding.database.service.impl.PostionRegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PostionRegistrationLocalService
 * @see com.crowd.funding.database.service.base.PostionRegistrationLocalServiceBaseImpl
 * @see com.crowd.funding.database.service.impl.PostionRegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class PostionRegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.crowd.funding.database.service.impl.PostionRegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the postion registration to the database. Also notifies the appropriate model listeners.
	*
	* @param postionRegistration the postion registration
	* @return the postion registration that was added
	*/
	public static com.crowd.funding.database.model.PostionRegistration addPostionRegistration(
		com.crowd.funding.database.model.PostionRegistration postionRegistration) {
		return getService().addPostionRegistration(postionRegistration);
	}

	/**
	* Creates a new postion registration with the primary key. Does not add the postion registration to the database.
	*
	* @param POSITION_ID the primary key for the new postion registration
	* @return the new postion registration
	*/
	public static com.crowd.funding.database.model.PostionRegistration createPostionRegistration(
		long POSITION_ID) {
		return getService().createPostionRegistration(POSITION_ID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the postion registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration that was removed
	* @throws PortalException if a postion registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.PostionRegistration deletePostionRegistration(
		long POSITION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePostionRegistration(POSITION_ID);
	}

	/**
	* Deletes the postion registration from the database. Also notifies the appropriate model listeners.
	*
	* @param postionRegistration the postion registration
	* @return the postion registration that was removed
	*/
	public static com.crowd.funding.database.model.PostionRegistration deletePostionRegistration(
		com.crowd.funding.database.model.PostionRegistration postionRegistration) {
		return getService().deletePostionRegistration(postionRegistration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.crowd.funding.database.model.PostionRegistration fetchPostionRegistration(
		long POSITION_ID) {
		return getService().fetchPostionRegistration(POSITION_ID);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the postion registration with the primary key.
	*
	* @param POSITION_ID the primary key of the postion registration
	* @return the postion registration
	* @throws PortalException if a postion registration with the primary key could not be found
	*/
	public static com.crowd.funding.database.model.PostionRegistration getPostionRegistration(
		long POSITION_ID)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPostionRegistration(POSITION_ID);
	}

	/**
	* Returns a range of all the postion registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.crowd.funding.database.model.impl.PostionRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of postion registrations
	* @param end the upper bound of the range of postion registrations (not inclusive)
	* @return the range of postion registrations
	*/
	public static java.util.List<com.crowd.funding.database.model.PostionRegistration> getPostionRegistrations(
		int start, int end) {
		return getService().getPostionRegistrations(start, end);
	}

	/**
	* Returns the number of postion registrations.
	*
	* @return the number of postion registrations
	*/
	public static int getPostionRegistrationsCount() {
		return getService().getPostionRegistrationsCount();
	}

	/**
	* Updates the postion registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param postionRegistration the postion registration
	* @return the postion registration that was updated
	*/
	public static com.crowd.funding.database.model.PostionRegistration updatePostionRegistration(
		com.crowd.funding.database.model.PostionRegistration postionRegistration) {
		return getService().updatePostionRegistration(postionRegistration);
	}

	public static PostionRegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PostionRegistrationLocalService, PostionRegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PostionRegistrationLocalService.class);

		ServiceTracker<PostionRegistrationLocalService, PostionRegistrationLocalService> serviceTracker =
			new ServiceTracker<PostionRegistrationLocalService, PostionRegistrationLocalService>(bundle.getBundleContext(),
				PostionRegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}