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


<style>
.PrioritySequenceDetails{
 border-top:3px solid #7FBD2C;
 border-right:3px solid #7FBD2C;
 border: 1px solid #7FBD2C;
 box-shadow: 0 0 10px 1px #7FBD2C;
 border-style: solid;
 border-color:white;
 margin-top: -4px;
 background-color:white;
 margin:40px; 
 padding: 50px;
 width: 600px;
 margin-left: 25%;
}

.submit{
border-radius:22px;
color:white;
background-color: #0077A2;
margin-left: 170px;
}
.cancel{
border-radius:22px;
}

</style>


<%
String projectID = renderRequest.getParameter("projectID");
ProjectPriorityRegistration projectPriority = ProjectPriorityRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectPriority.getPROJECT_ID());
%>

<portlet:actionURL name="prioritySequenceData" var="prioritySequenceDataURL" />
<aui:form action="${prioritySequenceDataURL}" method="post">
	<aui:input name="projectID" value="<%= projectPriority.getPROJECT_ID() %>" type="hidden"></aui:input>
	

 <div class="PrioritySequenceDetails" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<center><h1 style="color:#0077A2;"> <%= projectRegistration.getTITLE() %> </h1></center></br>

<style>
table, th, td {
  border: 1px solid black;
}
</style>

<table  style="width: 90%;margin-left: 30px;">
	<tr>
		<td style="width: 255px;text-align: center;">Project Featured Priority Sequence</td>
		<td>
		<aui:select name="prioritySequence" style="margin-top: 10px; margin-bottom: -15px;">
	    <% for(int i=1; i<=20; i++){%>
		<aui:option value="<%= i %>"><%= i %></aui:option>
		<% } %>
		</aui:select>
		</td>
	</tr>
</table>
</br>
			
				<th><aui:button cssClass="submit" type="submit" value="Submit" /></th>
				<th><aui:button cssClass="cancel" type="cancel" value="cancel" onClick="window.history.back();" style="border-radius:22px;" /></th></div>	
</aui:form>
	</div>