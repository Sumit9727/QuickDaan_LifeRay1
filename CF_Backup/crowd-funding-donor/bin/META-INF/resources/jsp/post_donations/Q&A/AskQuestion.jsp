<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>


<portlet:actionURL name="askQuestionRegistration" var="askQuestionRegistrationURL" />
	

<aui:form action="${askQuestionRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= 101 %>"></aui:input>

	<aui:input name="askQuestion" label="Question"></aui:input>
	<aui:button name="submit" type="submit" value="Submit" />
	
</aui:form>