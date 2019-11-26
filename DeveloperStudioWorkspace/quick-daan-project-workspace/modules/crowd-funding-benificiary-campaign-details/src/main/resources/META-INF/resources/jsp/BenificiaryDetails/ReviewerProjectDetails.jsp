<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
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
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
%>

<portlet:actionURL name="editProjectContent" var="editProjectContentURL" />
<aui:form action="${editProjectContentURL}" method="post">
<div class="ProjectDetails">
<h1>Review Project Details</h1>
<hr>
<br>
<aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>
<aui:input cssClass="borderForm" name="title" label="Title"   value="<%= projectRegistration.getTITLE() %>"><aui:validator name="required" /></aui:input>

<strong>User Story</strong>
<br>
<liferay-ui:input-editor required="required" name="description" contents="<%= projectRegistration.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400"   resizable="true" ><aui:validator name="required" /></liferay-ui:input-editor>
<br>
	
	<strong>Campaign Fund Amount: </strong> <%= String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT()) %>
	<br>
	<br>
<div style="margin-left: 243px;"><aui:button type="submit" value="Submit" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; " onClick="window.history.back();" /></div>
</aui:form>
</div>


<!-- border-color= "black" -->
 