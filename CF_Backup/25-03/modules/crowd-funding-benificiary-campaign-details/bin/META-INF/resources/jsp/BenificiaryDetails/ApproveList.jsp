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
List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0,ProjectRegistrationLocalServiceUtil.getProjectRegistrationsCount());
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


<form >
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
			for(ProjectRegistration projectObj : reverse){
			%>
				<portlet:renderURL var="EndDateDetails" windowState="normal" >
					<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/ApprovalDetails.jsp" />
				</portlet:renderURL>
				<tr>
					<td><%= counter %></td>
					<td><%= projectObj.getTITLE() %></td>
					<% if(projectObj.getSTATUS()==1){%>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT %></td>
					<%}if(projectObj.getSTATUS()==0){%>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT %></td>
					<% }if(projectObj.getSTATUS()==2){%>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT %></td>
					<% }if(projectObj.getSTATUS()==3){ %>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT %></td>
					<% }if(projectObj.getSTATUS()==4){ %>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT %></td>
					<% }if(projectObj.getSTATUS()==5){ %>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT %></td>
					<% }if(projectObj.getSTATUS()==6){ %>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6_TEXT %></td>
					<% }if(projectObj.getSTATUS()==7){ %>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_7_TEXT %></td>
					<% }if(projectObj.getSTATUS()==8){ %>
						<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8_TEXT %></td>
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
 