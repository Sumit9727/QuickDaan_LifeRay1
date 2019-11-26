<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>
<portlet:defineObjects />

<%
String ProjectId = renderRequest.getParameter("projectId");
%>

<portlet:actionURL name="askQuestionRegistration" var="askQuestionRegistrationURL" />
	
<aui:form action="${askQuestionRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<div class="AskQuestion">
    <center><h1 style="color:#0077A2;"> ASK QUESTION</h1></center><br>
	<aui:input  class ="form-control" name="askQuestion" label="Question"></aui:input>
	<aui:button name="submit" type="submit" value="Submit" style="background-color: #0077A2;margin-left: 35%;"  />
	</div>
</aui:form>