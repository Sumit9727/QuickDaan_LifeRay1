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

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

<form class="mayborderForm" >
<table id="example" class="display" style="width:100%">
	<thead>
		<tr style="background-color: #c0c0c038; border:1px solid #ddd">
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
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<th><%= questionObj.getQUESTION() %></th>
					<th><aui:button type="Reviewer" value="Details" onClick="${QuestionDetailURL}" /></th>			
				</tr>
				<%
				counter++;
				%>

<%}
	}%>
</tbody>
</table>
</form>