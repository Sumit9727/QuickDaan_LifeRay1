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

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script>
  $(function() {
    $( "#enddate" ).datepicker({
    	dateFormat:'dd/mm/yy',
    	changeMonth: true,
		changeYear: true,
		yearRange: "1970:2070"
    });
    
  });
  
 </script>

<%
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
%>

<portlet:actionURL name="adminProjectContent" var="adminProjectContentURL" />
<aui:form action="${adminProjectContentURL}" method="post">

<aui:input name="projectID" type="hidden" value="<%= projectObj.getPROJECT_ID() %>"></aui:input>
	
	<portlet:actionURL var="RejectDetailsURL" name="RejectDetails">
	<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
	</portlet:actionURL>
		
		Title : <%= projectObj.getTITLE() %><br><br>
		
		User Story : <liferay-ui:input-editor name="description" contents="<%= projectObj.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor><br><br>
			
		End Date : <input name="<portlet:namespace/>enddate" id="enddate" label="End Date :"></input><br><br>
		<aui:button type="Approve" value="Approve" />
		<aui:button type="Reject" value="Reject" onClick="${RejectDetailsURL}"/>
		<aui:button type="cancel" value="cancel" onClick="window.history.back();" />

</aui:form>
	
