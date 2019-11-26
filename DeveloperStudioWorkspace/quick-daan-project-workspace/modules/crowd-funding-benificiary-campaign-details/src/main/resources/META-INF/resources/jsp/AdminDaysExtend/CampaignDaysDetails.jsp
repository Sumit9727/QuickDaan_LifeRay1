<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectExtentionRegistration"%>
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

long ProjectExtendedId = Long.parseLong(renderRequest.getParameter("ProjectExtendedId"));
long ProjectId = Long.parseLong(renderRequest.getParameter("ProjectId"));

List<ProjectExtentionRegistration> extentionRegistrationDetailsList = ProjectExtentionRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
/* ProjectExtentionRegistration extentionRegistration = ProjectExtentionRegistrationLocalServiceUtil.fetchProjectExtentionRegistration(ProjectExtendedId);
 */

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

%>

<portlet:actionURL var="RejectExtendCapmaignDetailsURL" name="RejectExtendCapmaignDetails">
	<portlet:param name="ProjectExtendedId" value="<%= String.valueOf(ProjectExtendedId) %>" />
</portlet:actionURL>
<portlet:actionURL var="ApproveExtendCapmaignDetailsURL" name="ApproveExtendCapmaignDetails">
	<portlet:param name="ProjectExtendedId" value="<%= String.valueOf(ProjectExtendedId) %>" />
</portlet:actionURL>



<div class="AdminDaysExtend" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<center><h1 style="color:#0077A2;"><%= projectRegistration.getTITLE() %></h1></center></br>
<aui:form>

	<style>
table, th, td {
  border: 1px black;
}
</style>

			<table  style="width: 270px;margin-left: 95px;">
			<tr>
			<td><b>Project Creation Date</b></td>
			<td><b><%= formatter.format(projectRegistration.getCREATION_DATE()) %></b></td>
			</tr>
			 <% 	
			for(ProjectExtentionRegistration extentionRegistrationDetails : extentionRegistrationDetailsList){ 
				if(extentionRegistrationDetails.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_1){
			%>
				<tr>
					<td><b>Start Date</b> </td>
					<td><b><%= formatter.format(extentionRegistrationDetails.getDATE()) %></b></td>
				</tr>
				<tr>
					<td><b>End Date </b></td>
					<td><b><%= formatter.format(extentionRegistrationDetails.getEXTENTION_DATE()) %></b></td>
				</tr>
			<% 	}else if(extentionRegistrationDetails.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_1){%>
				<tr >
	  				<td colspan='2'><center><strong>Current Extended Date</strong></center></td>
	  			</tr>
				<tr>
					<td><b>Start Date </b> </td>
					<td><b><%= formatter.format(extentionRegistrationDetails.getDATE()) %></b></td>
				</tr>
				<tr>
					<td><b>End Date </b></td>
					<td><b><%= formatter.format(extentionRegistrationDetails.getEXTENTION_DATE()) %></b></td>
				</tr>
			<% }
			}%>
			
			</table>
	  			</br>
	  			</br>
	  		<aui:button type="submit" value="Approve" onClick="${ApproveExtendCapmaignDetailsURL}" style="background-color:#0077A2;border-radius:22px; margin-left: 100px;" ></aui:button>
	  		<aui:button type="submit" value="Reject"  onClick="${RejectExtendCapmaignDetailsURL}" style="background-color:#0077A2;border-radius:22px;"></aui:button>
			<aui:button type="cancel" value="cancel" onClick="window.history.back();" style="border-radius:22px;" />
 </aui:form>
</div>