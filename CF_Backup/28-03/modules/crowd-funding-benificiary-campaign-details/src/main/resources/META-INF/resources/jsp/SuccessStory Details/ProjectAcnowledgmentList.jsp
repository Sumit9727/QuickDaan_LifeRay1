<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectAcknowledgementRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
List<ProjectAcknowledgementRegistration> acknowledgementRegistrationList = ProjectAcknowledgementRegistrationLocalServiceUtil.getProjectAcknowledgementRegistrations(0,ProjectAcknowledgementRegistrationLocalServiceUtil.getProjectAcknowledgementRegistrationsCount());
LinkedList<ProjectAcknowledgementRegistration> reverse = new LinkedList<ProjectAcknowledgementRegistration>();
for(int i=acknowledgementRegistrationList.size()-1;i>=0;i--){
	reverse.add(acknowledgementRegistrationList.get(i));
}
int counter = 1;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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
				<th>No.</th>
				<th>Project Title</th>
				<th>Date</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(ProjectAcknowledgementRegistration acknowledgementObj : reverse){
					ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(acknowledgementObj.getPROJECT_ID());
			%>
				<tr>
					<td><%= counter %></td>
					<td><%= projectObj.getTITLE() %></td>
					<td><%= formatter.format(acknowledgementObj.getDATE()) %></td>
					 <portlet:renderURL var="AcknowledgementDetailsURL" windowState="normal">
						<portlet:param name="ProjectId" value="<%= String.valueOf(acknowledgementObj.getPROJECT_ID()) %>" />
					 	<portlet:param name="jspPage" value="/jsp/SuccessStory Details/SuccessStoryDetails.jsp"/>
					  </portlet:renderURL>
					<td><aui:button type="Details" value="Details" onClick="${AcknowledgementDetailsURL}"/></td>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>

</form>
