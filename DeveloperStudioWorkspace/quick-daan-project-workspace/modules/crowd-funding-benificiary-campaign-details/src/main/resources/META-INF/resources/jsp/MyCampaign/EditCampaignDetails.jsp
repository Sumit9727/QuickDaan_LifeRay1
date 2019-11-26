<%-- <%@page import="java.text.SimpleDateFormat"%>
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

<div class="EditCampaign" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<portlet:actionURL name="editProjectData" var="editProjectDataURL" />
<aui:form action="${editProjectDataURL}" method="post">
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	
	<div class="Ddate" style="text-align:right;"><strong1>Date: </strong1><%= formatter.format(editProjectDetails.getCREATION_DATE()) %></div><br><br>
	<strong1>Title : </strong1><%= editProjectDetails.getTITLE() %><br><br>
	<strong1>User Story: </strong1><br><br>
	<liferay-ui:input-editor name="description" contents="<%= editProjectDetails.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400"   resizable="true" ></liferay-ui:input-editor><br>
	<strong1>Required Amount :</strong1> <%= String.format("%.0f",editProjectDetails.getREQUIRED_FUND_AMOUNT()) %><br></br>
	
	<aui:button type="submit" value="Submit" style="border-radius:22px;background-color:#0077A2;color:white;margin-left: 255px;"></aui:button>
	<aui:button type="cancel" value="cancel" style="border-radius:22px;" onClick="window.history.back();" />
	
</aui:form>
</div> --%>


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

<div class="EditCampaign" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<portlet:actionURL name="editProjectData" var="editProjectDataURL" />
<aui:form action="${editProjectDataURL}" method="post">
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	
	<div class="Ddate" style="text-align:right;"><strong1>Date: </strong1><%= formatter.format(editProjectDetails.getCREATION_DATE()) %></div><br>
	<center><h1 style="color:#0077A2"><%= editProjectDetails.getTITLE() %></h1></center>
	<strong1>User Story: </strong1><br><br>
	<liferay-ui:input-editor name="description" contents="<%= editProjectDetails.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400"   resizable="true" ></liferay-ui:input-editor><br>
	<strong1>Required Amount :</strong1> <%= String.format("%.0f",editProjectDetails.getREQUIRED_FUND_AMOUNT()) %><br></br>
	
	<aui:button type="submit" value="Submit" style="border-radius:22px;background-color:#0077A2;color:white;margin-left: 255px;"></aui:button>
	<aui:button type="cancel" value="cancel" style="border-radius:22px;" onClick="window.history.back();" />
	
</aui:form>
</div>