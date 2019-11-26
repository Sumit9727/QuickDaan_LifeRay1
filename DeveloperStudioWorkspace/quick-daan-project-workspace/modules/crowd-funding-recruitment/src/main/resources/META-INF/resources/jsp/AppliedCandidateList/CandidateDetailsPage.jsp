<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.CandidateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CandidateRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/jsp/AppliedCandidateList/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:renderURL var="cancelUrl" windowState="normal">
 	<portlet:param name="jspPage" value="/jsp/AppliedCandidateList/AppliedCandidateListPage.jsp"/>
</portlet:renderURL>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
long CandidateId = ParamUtil.getLong(renderRequest,"CandidateId");
CandidateRegistration candidateDetailObj = CandidateRegistrationLocalServiceUtil.findByCANDIDATE_ID(CandidateId);
PositionRegistration positionObj = PositionRegistrationLocalServiceUtil.findByPOSITION_ID(candidateDetailObj.getPOSITION_ID());
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:resourceURL  var="CandidateResourceURL">
	<portlet:param name="CandidateId" value="<%= String.valueOf(CandidateId)  %>"/>
</portlet:resourceURL>
<table style="width:100%" border="1" >
		<thead>
			<tr>
				<th style="width:25%">Candidate ID</th>
				<td><%= candidateDetailObj.getCANDIDATE_ID() %></td>
			</tr>
			<tr>
				<th>Position Name</th>
				<td><%= positionObj.getPOSITION_NAME() %></td>
			</tr>
			<tr>
				<th>Candidate Name</th>
				<td><%= candidateDetailObj.getNAME() %></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><%= candidateDetailObj.getEMAIL() %></td>
			</tr>
			<tr>
				<th>Contact Number</th>
				<td><%= candidateDetailObj.getMOBILE_NO() %></td>
			</tr>
			<tr>
				<th>Candidate Location</th>
				<td><%= candidateDetailObj.getCURRENT_LOCATION() %></td>
			</tr>
			<tr>
				<th>Position Location</th>
				<td><%= positionObj.getLOCATION() %></td>
			</tr>
			<tr>
				<th>Experience</th>
				<td><%= candidateDetailObj.getEXPERIENCE() %></td>
			</tr>
			<tr>
				<th>Date Of Applied</th>
				<td><%= formatter.format(candidateDetailObj.getDATE()) %></td>
			</tr>
			<tr>
				<th>Status</th>
				<td><%= candidateDetailObj.getSTATUS() %></td>
			</tr>
			<tr>
				<th>Resume</th>
				<td><a href="${CandidateResourceURL}" alt="Document" target="_blank" download/>Download Resume</a></td>
			</tr>
		</thead>
</table>

<aui:button name="cancel" onClick="${cancelUrl}" value="Cancel" />