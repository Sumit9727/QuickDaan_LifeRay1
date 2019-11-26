<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>
<portlet:defineObjects />

<%
String ProjectId = renderRequest.getParameter("projectId");
%>

<portlet:actionURL name="feedbackRegistration" var="feedbackRegistrationURL" />

<aui:form action="${feedbackRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<div class="Feedback">
	<center><h1 style="color:#0077A2;">Feedback</h1></center><br>
	

	<aui:input class ="form-control" name="feedback" label="Feedback"></aui:input>
	<aui:button name="submit" type="submit" value="Submit" style="background-color: #0077A2;margin-left: 35%;" />
	</div>
	
</aui:form>