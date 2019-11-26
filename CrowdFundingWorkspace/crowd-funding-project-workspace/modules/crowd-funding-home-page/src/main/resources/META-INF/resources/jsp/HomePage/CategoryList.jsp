<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@ include file="/init.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet"	href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	

<style>

.portlet-decorate .portlet-content{
    background-color: #f7f8f9;
    border: 1px solid #f1f2f5;
}

.mayborderForm {
    background-color: #5d5d5d29;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 24px;
}
</style>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
String CategoryId = renderRequest.getParameter("CategoryId");
CategoryRegistration categoryRegistration = CategoryRegistrationLocalServiceUtil.fetchCategoryRegistration(Long.parseLong(CategoryId));
System.out.println(CategoryId);
System.out.println(categoryRegistration);
List<BenificiaryRegistration> benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_DETAILS(String.valueOf(categoryRegistration.getCATEGORY_ID()));
System.out.println(benificiaryRegistration);
%>
<% 
if(benificiaryRegistration.isEmpty() == true){
	%>
	In <%= categoryRegistration.getCATEGORY_NAME() %> no any Campaigns are registered on this Category.
	<% 
}else{
for(BenificiaryRegistration registration : benificiaryRegistration){
	List<ProjectRegistration> projectRegistration = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID(registration.getBENIFICIARY_ID());
	for(ProjectRegistration registrationObj : projectRegistration ){
%>
<%= registrationObj.getTITLE() %>
<%	}}} %>