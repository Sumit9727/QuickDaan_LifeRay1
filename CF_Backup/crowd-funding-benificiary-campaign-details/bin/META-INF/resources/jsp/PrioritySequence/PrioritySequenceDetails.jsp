<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />



<%
String projectID = renderRequest.getParameter("projectID");
ProjectPriorityRegistration projectPriority = ProjectPriorityRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectPriority.getPROJECT_ID());
%>

<portlet:actionURL name="prioritySequenceData" var="prioritySequenceDataURL" />
<aui:form action="${prioritySequenceDataURL}" method="post">
	<aui:input name="projectID" value="<%= projectPriority.getPROJECT_ID() %>" type="hidden"></aui:input>
	<table>
		<tbody>
			<tr>
				<th>Title : </th>
				<th><%= projectRegistration.getTITLE() %></th>
			</tr>
			<tr>
				<th>Project Featured Priority Sequence :</th>
				<th>
					<aui:select name="prioritySequence" >
						<% for(int i=1; i<=20; i++){%>
							<aui:option value="<%= i %>"><%= i %></aui:option>
						<% } %>
					</aui:select>
				</th>
			</tr>
			<tr>
				<th><aui:button type="submit" value="Submit" /></th>
				<th><aui:button type="cancel" value="cancel" onClick="window.history.back();" /></th>
			</tr>
		</tbody>
	</table>
</aui:form>
	