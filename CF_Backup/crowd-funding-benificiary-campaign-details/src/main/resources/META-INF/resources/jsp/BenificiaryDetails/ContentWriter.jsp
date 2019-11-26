<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
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
List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.findBySTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0);
int counter = 1;
%>

	<table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Project No.</th>
				<th>Title</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			<%
			for(ProjectRegistration projectObj : projectRegistrationList){
			%>
			<portlet:renderURL var="ReviewerProjectDetails" windowState="normal" >
				<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/ReviewerProjectDetails.jsp" />
			</portlet:renderURL>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
						<% if(projectObj.getSTATUS()==1){%>
							<th>Waiting For Approval</th>
						<%}if(projectObj.getSTATUS()==0){%>
							<th>Waiting For Review</th>
						<% }if(projectObj.getSTATUS()==2){
							%>
							<th>Approved</th>
						<% }if(projectObj.getSTATUS()==3){ %>
							<th>Reject</th>
						<% } %>
					<th>
						<% if(projectObj.getSTATUS()==0){%>
							<aui:button type="Reviewer" value="Details" onClick="${ReviewerProjectDetails}"/>
						<% }if(projectObj.getSTATUS()==2){} %>
						
					</th>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>
	
