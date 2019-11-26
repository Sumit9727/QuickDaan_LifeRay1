 <%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
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


<%
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
User currentUserRole = td.getUser();
if((currentUserRole.getRoles().get(1).getName()).equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.PROJECT_cf_ADMIN_ROLE)){
	List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.findBySTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2);
	LinkedList<ProjectRegistration> reverse = new LinkedList<ProjectRegistration>();
	for(int i=projectRegistrationList.size()-1;i>=0;i--){
		reverse.add(projectRegistrationList.get(i));
	}


int counter = 1;
%>


<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

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

<form >
	<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>Project No.</th>
				<th>Title</th>
				<th>Status</th>
				<th>Requested Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(ProjectRegistration projectObj : reverse){
			%>
				<portlet:renderURL var="EndDateDetails" windowState="normal" >
					<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/AdminCampaignDetails/ApprovedCampaignDetails.jsp" />
				</portlet:renderURL>
				<tr>
					<td><%= counter %></td>
					<td><%= projectObj.getTITLE() %></td>
					 <% if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0){ %>
				 
					 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT %></td>
					
					 <% }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1){ %>
					 
					 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT %></td>
						
					 <% }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2){ %>
					 
					 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT %></td>
						
					 <% }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT %></td>
					
					<% }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4){ %>
					 
						 <td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT %></td>
						 
					<% }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){ %>
					 
					 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT %></td>
						
					 <% } %>
					 
					 <% if(projectObj.getREQUEST_STATUS()==CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0_TEXT %></td>
					 
					 <% } if(projectObj.getREQUEST_STATUS()==1){ %>
					 
					 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_1_TEXT %></td>
						
					 	
					 <% }if(projectObj.getREQUEST_STATUS()==2){ %>
					 
					 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2_TEXT %></td>
						 
					<% }if(projectObj.getREQUEST_STATUS()==3){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_3_TEXT %></td>
					
					<% }if(projectObj.getREQUEST_STATUS()==4){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_4_TEXT %></td>
					
					 <% }if(projectObj.getREQUEST_STATUS()==5){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_5_TEXT %></td>
					
					<% }if(projectObj.getREQUEST_STATUS()==6){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_6_TEXT %></td>
					
					 <% }if(projectObj.getREQUEST_STATUS()==7){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_7_TEXT %></td>
					
					 <% }if(projectObj.getREQUEST_STATUS()==8){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_8_TEXT %></td>
					
					 <% }if(projectObj.getREQUEST_STATUS()==9){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_9_TEXT %></td>
					
					 <% }if(projectObj.getREQUEST_STATUS()==10){ %>
						
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_10_TEXT %></td>
					
					 <% } %>
					
					<td>
						<aui:button type="Details" value="Details" onClick="${EndDateDetails}"/>
					</td>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>
</form>
 <% } %>