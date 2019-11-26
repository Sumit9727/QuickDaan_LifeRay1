<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<liferay-theme:defineObjects />

<portlet:defineObjects />



<%
long projectID = Long.parseLong(renderRequest.getParameter("projectID"));
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
%>

<portlet:actionURL name="RejectDetails" var="RejectDetailsURL" />
<aui:form action="${RejectDetailsURL}" method="post">

	<h2><%= projectRegistration.getTITLE() %></h2>
	<aui:input name="projectID" type="hidden" value="<%= projectID %>"></aui:input>
	<aui:input name="commentData" type="textarea"></aui:input>
	
	<aui:button type="submit" value="Approve"style="background-color:#0077A2;color:white; border-radius: 100px;width: 100px; "/>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	
</aui:form>
