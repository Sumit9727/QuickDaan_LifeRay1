<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<% 
long ProjectId = Long.parseLong(renderRequest.getParameter("ProjectId"));
ProjectRegistration editProjectDetails = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId); 
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<portlet:actionURL name="editProjectData" var="editProjectDataURL" />
<aui:form action="${editProjectDataURL}" method="post">
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<strong>Date : </strong><%= formatter.format(editProjectDetails.getCREATION_DATE()) %>
	<strong>Title : </strong><%= editProjectDetails.getTITLE() %>
	<strong>User Story: </strong>
	<br>
	<liferay-ui:input-editor name="description" contents="<%= editProjectDetails.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400"   resizable="true" ></liferay-ui:input-editor>
	<strong>Required Amount :</strong> <%= editProjectDetails.getREQUIRED_FUND_AMOUNT() %>
	
	<aui:button type="submit" value="Submit"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	
</aui:form>