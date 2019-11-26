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

<portlet:defineObjects />

<%
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(20139);
int counter = 1;
%>

<table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Campaign  No.</th>
				<th>Campaign Title</th>
				<th>Update Requester</th>
				<th>Request Date</th>
			</tr>
<%
for(ProjectRegistration projectObj : projectList){
	List<UpdateRequesterRegistration> updateRequestList = UpdateRequesterRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	for(UpdateRequesterRegistration updateObj : updateRequestList){
		UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(updateObj.getUPDATE_REQUESTER_USER_ID());
%>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<th><%= userObj.getFULL_NAME() %></th>
					<th><%= updateObj.getUPDATE_REQUEST_DATE() %></th>			
				</tr>
				<%
				counter++;
				%>

<%}
	}%>
