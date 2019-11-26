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

<aui:form>
	<table>
		<tbody>
			<tr >
	  			<td colspan='2'><center><strong><%= projectRegistration.getTITLE() %></strong></center></td>
	  		</tr>
			<tr>
				<td>Project Creation Date</td>
				<td><%= formatter.format(projectRegistration.getCREATION_DATE()) %></td>
			</tr>
			<% 	
			for(ProjectExtentionRegistration extentionRegistrationDetails : extentionRegistrationDetailsList){ 
				if(extentionRegistrationDetails.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_1){
			%>
				<tr>
					<td>Start Date </td>
					<td><%= formatter.format(extentionRegistrationDetails.getDATE()) %></td>
				</tr>
				<tr>
					<td>End Date </td>
					<td><%= formatter.format(extentionRegistrationDetails.getEXTENTION_DATE()) %></td>
				</tr>
			<% 	}else if(extentionRegistrationDetails.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_1){%>
				<tr >
	  				<td colspan='2'><center><strong>Current Extended Date</strong></center></td>
	  			</tr>
				<tr>
					<td>Start Date </td>
					<td><%= formatter.format(extentionRegistrationDetails.getDATE()) %></td>
				</tr>
				<tr>
					<td>End Date </td>
					<td><%= formatter.format(extentionRegistrationDetails.getEXTENTION_DATE()) %></td>
				</tr>
			<% }
			}%>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr >
	  			<td colspan='2'>
	  				<aui:button type="submit" value="Approve" onClick="${ApproveExtendCapmaignDetailsURL}" ></aui:button>
	  				<aui:button type="submit" value="Reject"  onClick="${RejectExtendCapmaignDetailsURL}"></aui:button>
					<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	  			</td>
	  		</tr>
		</tbody>
	</table>
</aui:form>