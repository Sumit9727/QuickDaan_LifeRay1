<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/jsp/candidate/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:renderURL var="cancelUrl" windowState="normal">
 	<portlet:param name="jspPage" value="/jsp/candidate/CurrentOpeningPage.jsp"/>
</portlet:renderURL>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
long PositionId = ParamUtil.getLong(renderRequest,"PositionId");
PositionRegistration positionDetailObj = PositionRegistrationLocalServiceUtil.findByPOSITION_ID(PositionId);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:renderURL var="applyUrl" windowState="normal">
<portlet:param name="PositionId" value="<%= String.valueOf(positionDetailObj.getPOSITION_ID()) %>" />
 	<portlet:param name="jspPage" value="/jsp/candidate/CandidateApplicationFormPage.jsp"/>
</portlet:renderURL>
<table style="width:100%" border="1" >
		<thead>
			<tr>
				<th style="width:25%">POSITION ID</th>
				<td><%= positionDetailObj.getPOSITION_ID() %></td>
			</tr>
			<tr>
				<th>POSITION NAME</th>
				<td><%= positionDetailObj.getPOSITION_NAME() %></td>
			</tr>
			<tr>
				<th>DESCRIPTION</th>
				<td><%= positionDetailObj.getDESCRIPTION() %></td>
			</tr>
			<tr>
				<th>EXPERIENCE_LEVEL</th>
				<td><%= positionDetailObj.getEXPERIENCE_LEVEL() %></td>
			</tr>
			<tr>
				<th>SALARY</th>
				<td><%= positionDetailObj.getSALARY() %></td>
			</tr>
			<tr>
				<th>INDUSTRY_TYPE</th>
				<td><%= positionDetailObj.getINDUSTRY_TYPE() %></td>
			</tr>
			<tr>
				<th>FUNCTIONAL_AREA</th>
				<td><%= positionDetailObj.getFUNCTIONAL_AREA() %></td>
			</tr>
			<tr>
				<th>ROLE_CATEGORY</th>
				<td><%= positionDetailObj.getROLE_CATEGORY() %></td>
			</tr>
			<tr>
				<th>EMPLOYMENT_TYPE</th>
				<td><%= positionDetailObj.getEMPLOYMENT_TYPE() %></td>
			</tr>
			<tr>
				<th>LOCATION</th>
				<td><%= positionDetailObj.getLOCATION() %></td>
			</tr>
			<tr>
				<th>DATE</th>
				<td><%= formatter.format(positionDetailObj.getDATE()) %></td>
			</tr>
		</thead>
</table>
<aui:button name="apply" onClick="${applyUrl}" value="Apply" />
<aui:button name="cancel" onClick="${cancelUrl}" value="Cancel" />