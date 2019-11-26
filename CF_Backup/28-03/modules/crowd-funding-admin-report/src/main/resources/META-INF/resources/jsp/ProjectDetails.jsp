%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/jsp/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="cancelUrl" windowState="normal">
 	<portlet:param name="jspPage" value="/jsp/Report.jsp"/>
</portlet:renderURL>
<%
long ProjectId = ParamUtil.getLong(renderRequest, "ProjectId");
ProjectRegistration projectDetailObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>
<table style="width:100%" border="1" >
		<thead>
			<tr>
				<th style="width:25%">PROJECT ID</th>
				<td><%= projectDetailObj.getPROJECT_ID() %></td>
			</tr>
			<tr>
				<th>PROJECT TITLE</th>
				<td><%= projectDetailObj.getTITLE() %></td>
			</tr>
			<tr>
				<th>PROJECT DESCRIPTION</th>
				<td><%= projectDetailObj.getDESCRIPTION() %></td>
			</tr>
			<tr>
				<th>PROJECT REQUIRED FUND AMOUNT</th>
				<td><%= projectDetailObj.getREQUIRED_FUND_AMOUNT() %></td>
			</tr>
			<tr>
				<th>PROJECT CREATION DATE</th>
				<td><%= formatter.format(projectDetailObj.getCREATION_DATE()) %></td>
			</tr>
			<tr>
				<th>PROJECT END DATE</th>
				<td><%= formatter.format(projectDetailObj.getEND_DATE()) %></td>
			</tr>
		</thead>
</table>
<aui:button name="cancel" onClick="${cancelUrl}" value="Cancel" />