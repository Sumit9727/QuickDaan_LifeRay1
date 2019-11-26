<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="java.util.List"%>
<%@ include file="/jsp/supporter/init.jsp" %>

<%
long projectId = 101;
String donorName = null;
List<FundRegistration> fundList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
for(FundRegistration fundObj : fundList){
	
	if(fundObj.getDONOR_STATUS() == 0){
		donorName = "Anonymous User";
	}else{
		UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(fundObj.getDONOR_USER_ID());
		donorName = userObj.getFULL_NAME();
	} %>
	<label><%= donorName %></label> has donated INR <label><%= fundObj.getDONATED_AMOUNT() %></label>. <br>
	<label style="font-size: x-small;"><%= fundObj.getCOMMENT() %></label><br><br>
	
	<%
}
%>