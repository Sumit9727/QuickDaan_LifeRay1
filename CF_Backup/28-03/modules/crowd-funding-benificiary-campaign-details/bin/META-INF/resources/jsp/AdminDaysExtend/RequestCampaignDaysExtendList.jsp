<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectExtentionRegistration"%>
<%@page import="java.util.List"%>
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
int counter = 1;
List<ProjectExtentionRegistration> projectExtendedList = ProjectExtentionRegistrationLocalServiceUtil.findBySTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_0);
LinkedList<ProjectExtentionRegistration> reverseList = new LinkedList<ProjectExtentionRegistration>();
for(int i=projectExtendedList.size()-1;i>=0;i--){
	reverseList.add(projectExtendedList.get(i));
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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
				<th>No.</th>
				<th>Campaign Title</th>
				<th>Creation Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for(ProjectExtentionRegistration extentionRegistration : reverseList){ 
				ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(extentionRegistration.getPROJECT_ID());
				%>
				 <portlet:renderURL var="ProjectExtendedDetailURL" windowState="normal" >
					<portlet:param name="ProjectExtendedId" value="<%= String.valueOf(extentionRegistration.getPROJECT_EXTENTION_ID()) %>" />
					<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistration.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/AdminDaysExtend/CampaignDaysDetails.jsp" />
			    </portlet:renderURL>
				<tr>
					 <td><%= counter %></td>
					 <td><%= projectRegistration.getTITLE() %></td>
					 <td><%= formatter.format(projectRegistration.getCREATION_DATE()) %></td>
					 <td><liferay-ui:icon image="edit" message="Details" url="${ProjectExtendedDetailURL}" /></td>
				 </tr>
			<% } %>
		</tbody>
	</table>
</form>
