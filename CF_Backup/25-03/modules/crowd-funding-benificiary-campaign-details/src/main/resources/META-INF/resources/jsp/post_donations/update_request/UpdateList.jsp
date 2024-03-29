<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserOTPRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.UpdateRequesterRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UpdateRequesterRegistration"%>
<%@page import="com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.QuestionRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<portlet:defineObjects />

<%
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(themeDisplayObj.getUserId());
int counter = 1;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

<form>
	<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>Campaign  No.</th>
				<th>Campaign Title</th>
				<th>Update Requester</th>
				<th>Request Date</th>
			</tr>
			</thead>
			<tbody>
				<%
				for(ProjectRegistration projectObj : projectList){
					List<UpdateRequesterRegistration> updateRequestList = UpdateRequesterRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
					for(UpdateRequesterRegistration updateObj : updateRequestList){
						UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(updateObj.getUPDATE_REQUESTER_USER_ID());
				%>
								<tr>
									<td><%= counter %></td>
									<td><%= projectObj.getTITLE() %></td>
									<td><%= userObj.getFULL_NAME() %></td>
									<td><%= formatter.format(updateObj.getUPDATE_REQUEST_DATE()) %></td>			
								</tr>
								<%
								counter++;
								%>
				<%}
					}%>
		</tbody>
	</table>
</form>