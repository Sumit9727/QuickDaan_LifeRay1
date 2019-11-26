<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>



<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
long projectID =Long.parseLong(renderRequest.getParameter("ProjectId"));
ProjectRegistration campaignDaysExtends = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
%>

<script>
  $(function() {
    $( "#datepicker" ).datepicker({
    	dateFormat:'dd/mm/yy',
    	changeMonth: true,
		changeYear: true,
		yearRange: "1970:2070",
		minDate: new Date()
    });
  });
 </script>
 
 <portlet:actionURL name="ExtendsCampaignDays" var="ExtendsCampaignDaysURL" />

<div class="AdminDaysExtend" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<center><h1 style="color:#0077A2;"><%= campaignDaysExtends.getTITLE() %></h1></center></br>
<aui:form action="${ExtendsCampaignDaysURL}" method="post" style="margin-left: 44px;">
<aui:input name="projectId" type="hidden" value="<%= projectID %>"></aui:input>
	Extend End Date :
	<input type="text" id="datepicker" name="<portlet:namespace/>extendEndDate" /></br>
	</br>
	
	<center><aui:button type="submit" value="Submit" style="border-radius:22px; background-color:#0077A2; color:white; margin-left:-170px;"></aui:button></center>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" style="border-radius:22px; margin-top:-69px; margin-left:190px;" />
</aui:form>

</div>
