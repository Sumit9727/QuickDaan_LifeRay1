<%@page import="com.crowd.funding.donor.controller.constants.DonorControllerPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/project_update/init.jsp" %>


<% 
long ProjectId = 101;
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
User userDetail = td.getUser();
List<Role> roles = RoleLocalServiceUtil.getUserRoles(userDetail.getUserId());

for (Role role : roles) {
	if (role.getName().equalsIgnoreCase(DonorControllerPortletKeys.CF_PROJECT_OWNER_ROLE))
	{ %>

<portlet:actionURL name="projectUpdateRegistration" var="projectUpdateRegistrationURL" />

<aui:form action="${projectUpdateRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<aui:input name="projectUpdate" type="textarea"  label="Project Update"></aui:input>
	<aui:button name="submit" type="submit" value="Submit Update" />
	
</aui:form>
<% }
}%>