<%@page import="java.util.LinkedList"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
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
int counter = 1;
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
LinkedList<ProjectRegistration> reverse = new LinkedList<ProjectRegistration>();
for(int i=projectList.size()-1;i>=0;i--){
	reverse.add(projectList.get(i));
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
long projectId = 0;
%>



<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>



<form >
<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>Campaign Title</th>
				<th >Required Fund</th>
				<th>Creation Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			  <% for(ProjectRegistration projectObj: reverse){ %>
			  
			  <% projectId = projectObj.getPROJECT_ID();
			  %>
			  
			  <portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/CampaignDetails.jsp" />
			  </portlet:renderURL>
			  <portlet:renderURL var="ProjectUpdateURL" windowState="normal" >
					<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUpdate.jsp" />
			  </portlet:renderURL>
			  
			  <portlet:renderURL var="UploadAcknowledgementURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUploadAcknowledgement.jsp" />
			 </portlet:renderURL>
			 
			<portlet:renderURL var="ChangeProjectCategoryURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ChangeProjectCategory.jsp" />
			 </portlet:renderURL>			 
			 
			  <portlet:renderURL var="popupUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/MyCampaign/RequestFundAmt.jsp"/>
			  </portlet:renderURL>
			
		  
			<tr>
				<td><%= counter %></td>
				 <td><%= projectObj.getTITLE() %></td>
				 <td ><%=projectObj.getREQUIRED_FUND_AMOUNT() %></td>
				 <td><%= formatter.format(projectObj.getCREATION_DATE()) %></td>
				 
				  
				 <% if(projectObj.getSTATUS()==0){ %>
				 
					 <td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==1){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==2){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==3){ %>
					
					<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==4){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==5){ %>
				 
				 <td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT %></td>
					
				 <% }if(projectObj.getSTATUS()==6){ %>
				 
				 	<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6_TEXT %></td>
					 
				<% }if(projectObj.getSTATUS()==7){ %>
					
					<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_7_TEXT %></td>
				
				<% }if(projectObj.getSTATUS()==8){ %>
					
					<td><%= CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8_TEXT %></td>
				
				 <% } %>
				 <th>
				 	<liferay-ui:icon-menu>
					 	<liferay-ui:icon image="view" message="Details" url="${ProjectDetailURL}" />
					 	<liferay-ui:icon image="view" message="Change Project Category" url="${ChangeProjectCategoryURL}" />
					 	<% if(projectObj.getSTATUS()==2 || projectObj.getSTATUS()==4 || projectObj.getSTATUS()==6){ %>
					 		<liferay-ui:icon image="edit" message="Project Update" url="${ProjectUpdateURL}" /> 
					 	<% } %>		
					    <% if(projectObj.getSTATUS()==7){ %>
					    	<liferay-ui:icon image="edit" message="Upload Acknowledgement" url="${UploadAcknowledgementURL}" />
					    <% } %>
					    <% if(projectObj.getSTATUS() == 4 || projectObj.getSTATUS() == 2){ %>
					 	   
							<liferay-ui:icon image="edit" message="Request for Fund Withdraw" url="${popupUrl}" />
					    	
					    <% } %>
				    </liferay-ui:icon-menu>
				 </th>
				 
			</tr>
			<%
			projectId = 0;
			   counter++;
			%>
		<% } %>
	</tbody>
</table>
</form>
