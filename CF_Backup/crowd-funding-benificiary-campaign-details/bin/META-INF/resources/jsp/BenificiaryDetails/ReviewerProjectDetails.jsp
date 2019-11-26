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

<aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>
<aui:input name="title" label="Title" value="<%= projectRegistration.getTITLE() %>"></aui:input>

User Story : 
<liferay-ui:input-editor name="description" contents="<%= projectRegistration.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	
<aui:input name="requiredAmt" disabled="disabled" label="Required Fund Amount" value="<%= projectRegistration.getREQUIRED_FUND_AMOUNT() %>"></aui:input>
<aui:button type="submit" value="Submit"></aui:button>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>

