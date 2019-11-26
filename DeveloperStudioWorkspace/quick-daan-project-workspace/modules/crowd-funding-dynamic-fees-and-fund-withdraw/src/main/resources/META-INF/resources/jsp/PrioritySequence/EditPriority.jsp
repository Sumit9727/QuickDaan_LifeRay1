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
	System.out.println("Nirav :: ");
	ProjectPriorityRegistration projectPriority = ProjectPriorityRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
	ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectPriority.getPROJECT_ID());
	
%>

<portlet:actionURL name="editPrioritySequence" var="editPrioritySequenceURL" />
<style>
.EditPriority{
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

.update{
border-radius:22px;
color:white;
background-color: #0077A2;
margin-left: 170px;
}
</style>



<div class="EditPriority" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C" >
<center><h1 style="color:#0077A2;"> <%= projectRegistration.getTITLE() %> </h1></center></br>


<aui:form action="${editPrioritySequenceURL}" method="post">
	<aui:input name="projectID" value="<%= projectPriority.getPROJECT_ID() %>" type="hidden"></aui:input>
	
<style>
table, th, td {
  border: 1px solid black;
}
</style>

<table  style="width: 90%;margin-left: 30px;">

<tr>
	<td  style="width: 220px;text-align: center;">Set Priority Sequence</td>
	<td>
	<aui:select name=" " value="<%= projectPriority.getPRIORITY_SEQUANCE() %>" style="margin-top: 10px; margin-bottom:-15px;" >
		<% for(int i=0 ; i<=20; i++){%>
		<aui:option value="<%= i %>"><%= i %></aui:option>
		<% } %>
		</aui:select></td>
	</tr>
	</tbody>
	</table></br>
	 <aui:button cssClass="update" type="Update Sequance" value="Update"/>
	 <aui:button type="cancel" value="cancel" onClick="window.history.back();"style="border-radius:22px;"/></br>
		
</aui:form>
</br>
<div style="color: red;">note : If you want to remove campaign from featured then select priority sequance as 0. </div>
</div>