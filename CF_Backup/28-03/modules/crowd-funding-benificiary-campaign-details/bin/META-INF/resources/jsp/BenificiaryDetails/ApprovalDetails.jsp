 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
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
<style>

.Header{
box-shadow: 5px 5px 5px 0px #000000, inset 4px 4px 15px 0px #000000;
 border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 923px;
    margin-left: 119px;
 }
 
 h1, .h1 {
    font-size: 1.625rem;
    margin-left: 220px;
     color:#9c3353;
     text-shadow: 0px 1px 2px #000;
    margin-top: -22px;
    }
    
    .text-dark {
    color: #272834 !important;
    margin-left: -11px;
}
   
 </style>

<%
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectObj.getBENIFICIARY_ID());
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<portlet:actionURL name="adminProjectContent" var="adminProjectContentURL" />
<aui:form action="${adminProjectContentURL}" method="post">

<aui:input name="projectID" type="hidden" value="<%= projectObj.getPROJECT_ID() %>"></aui:input>
	
	<portlet:actionURL var="RejectDetailsURL" name="RejectDetails">
	<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
	</portlet:actionURL>
	<div class="Header">
	<h1>Newly Posted Campaign Details</h1>
	
	 <strong>Title :</strong> <%= projectObj.getTITLE() %><br><br>
	 <strong>Creation Date :</strong> <%= formatter.format(projectObj.getCREATION_DATE()) %><br><br>
	 <strong>End Date :</strong> <%= formatter.format(projectObj.getEND_DATE()) %><br><br>
	 <strong>Cause Details :</strong> <%= benificiaryRegistration.getCAUSE_DETAILS() %><br><br>
	 <strong>Benificiary Category :</strong> <%= benificiaryRegistration.getBENIFICIARY_CATEGORY() %><br><br>
	 <strong>Benificiary Type :</strong> <%= benificiaryRegistration.getBENIFICIARY_TYPE() %><br><br>
	 <strong>Benificiary Name :</strong> <%= benificiaryRegistration.getBENIFICIARY_NAME() %><br><br>
	 <strong>Gender :</strong> <%= benificiaryRegistration.getGENDER() %><br><br>
	 
	  <strong>Benificiary Phone No. :</strong> <%= benificiaryRegistration.getCONTACT_NO() %><br><br>
	 <strong>Benificiary Address :</strong> <%= benificiaryRegistration.getADDRESS_LINE1() %>, <%= benificiaryRegistration.getADDRESS_LINE2() %>,<br><%= benificiaryRegistration.getCITY() %>,<%= benificiaryRegistration.getSTATE() %><br>,<%= benificiaryRegistration.getCOUNTRY() %> - <%= benificiaryRegistration.getPINCODE() %><br>
	 <strong>Emergency Contect Details :</strong> <%= benificiaryRegistration.getEMERGENCY_CONTACT_DETAILS() %><br><br>
	 
	 
	 
	<strong>User Story : </strong><%= projectObj.getDESCRIPTION() %><br><br>
<%-- 	<strong>User Story : </strong><liferay-ui:input-editor name="description" contents="<%= projectObj.getDESCRIPTION() %>" initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor><br><br> --%>
	
	<strong>Campaign Fund Amount : </strong><%= projectObj.getREQUIRED_FUND_AMOUNT() %><br><br>
			
		<% if(projectObj.getSTATUS()==1){ %>
			<aui:button type="Approve" value="Approve" style="color:black; background-color:green;"/>
			<aui:button type="Reject" value="Reject" style="color:black; background-color:green;" onClick="${RejectDetailsURL}"/>
		<% } %>
		<aui:button type="cancel" value="cancel" onClick="window.history.back();" style="color:black; background-color:green;" />

</aui:form>
	</div>
 