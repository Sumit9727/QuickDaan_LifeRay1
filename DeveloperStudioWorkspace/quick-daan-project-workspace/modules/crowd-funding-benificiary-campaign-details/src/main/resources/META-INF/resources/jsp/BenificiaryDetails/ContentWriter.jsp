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

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

<%
List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.findBySTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0);
int counter = 1;
%>

<style>
.portlet-decorate .portlet-content{
    background-color: #f7f8f9;
    border: 1px solid #f1f2f5;
}
 .mayborderForm{
    background-color: #FFF;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 45px;
    border: 1px solid #7FBD2C;
    border-top: 3px solid #7fbd2c;
    border-right: 3px solid #7FBD2C;
    box-shadow: 0 0 10px 1px #7FBD2C;
}

</style>

<form class="mayborderForm" >
	<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>Project No.</th>
				<th>Title</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>	
			<%
			for(ProjectRegistration projectObj : projectRegistrationList){
			%>
			<portlet:renderURL var="ReviewerProjectDetails" windowState="normal" >
				<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/ReviewerProjectDetails.jsp" />
			</portlet:renderURL>
				<tr>
					<td><%= counter %></td>
					<td><%= projectObj.getTITLE() %></td>
						<% if(projectObj.getSTATUS()==1){%>
							<td>Waiting For Approval</td>
						<%}if(projectObj.getSTATUS()==0){%>
							<td>Waiting For Review</td>
						<% }if(projectObj.getSTATUS()==2){
							%>
							<td>Approved</td>
						<% }if(projectObj.getSTATUS()==3){ %>
							<td>Reject</td>
						<% } %>
					<td>
						<% if(projectObj.getSTATUS()==0){%>
							<aui:button type="Reviewer" value="Details" onClick="${ReviewerProjectDetails}"/>
						<% }if(projectObj.getSTATUS()==2){} %>
						
					</td>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>
</form>
 