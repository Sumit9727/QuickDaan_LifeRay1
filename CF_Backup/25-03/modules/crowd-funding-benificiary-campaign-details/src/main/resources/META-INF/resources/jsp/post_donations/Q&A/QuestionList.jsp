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

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(themeDisplayObj.getUserId());
int counter = 1;
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
				<th>Question</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(ProjectRegistration projectObj : projectList){
				List<QuestionRegistration> questionList = QuestionRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
				for(QuestionRegistration questionObj : questionList){
			%>
						<portlet:renderURL var="QuestionDetailURL" windowState="normal" >
							<portlet:param name="QuestionId" value="<%= String.valueOf(questionObj.getPROJECT_QUESTION_ID()) %>" />
							<portlet:param name="jspPage" value="/jsp/post_donations/Q&A/QuestionDetails.jsp" />
						</portlet:renderURL>
							<tr>
								<td><%= counter %></td>
								<td><%= projectObj.getTITLE() %></td>
								<td><%= questionObj.getQUESTION() %></td>
								<td><aui:button type="Reviewer" value="Details" onClick="${QuestionDetailURL}" /></td>			
							</tr>
							<%
							counter++;
							%>
			
			<%}
				}%>
		</tbody>
	</table>
</form>