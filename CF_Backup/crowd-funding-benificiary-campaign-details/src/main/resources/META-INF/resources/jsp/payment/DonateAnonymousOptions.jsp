<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/jsp/post_donations/init.jsp" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />


			<portlet:renderURL var="DonateUsingEmailMobileURL" windowState="normal">
				<portlet:param name="jspPage" value="/jsp/payment/OTPAuthenticationForm.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${DonateUsingEmailMobileURL}"  value="Donate Using Email/Mobile"/>
			
			 <portlet:renderURL var="DonateAnonymouslyURL" windowState="normal">
				<portlet:param name="jspPage" value="/jsp/payment/DonateAmount.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${DonateAnonymouslyURL}"  value="Donate Anonymously"/>



			

