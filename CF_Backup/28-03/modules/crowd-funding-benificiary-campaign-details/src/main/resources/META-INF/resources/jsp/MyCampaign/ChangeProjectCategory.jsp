<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
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

<liferay-ui:error key="error-key" message="Please Select atlist one Category."/>

<portlet:resourceURL var="serveResource">
	<portlet:param name="serverResourceCall" value="projectCategory"/>
</portlet:resourceURL>

<aui:script>

$("body").on("change",'select[id^="<portlet:namespace/>changedCategory"]',
		function() {
			changedCategory = $(this).find(':selected').val();
			$.ajax({
				dataType: 'json',
			    url:'<%= serveResource.toString() %>',
			    data :{'<portlet:namespace/>changedCategory' : changedCategory
		    	},
			    success: function(response){
			         console.log(response);
			       
			         var countriesList = response;
			         for(var i in countriesList){  
			        	var processingFees = countriesList[i].processingFees;
			        	var categoryName = countriesList[i].categoryName;
			        	var ProjectFees = countriesList[i].ProjectFees;
			        	var gatewayCharges = countriesList[i].gatewayCharges;
			        	
			        	document.getElementById('<portlet:namespace/>processingFees').value= processingFees  + ("%");
			         	document.getElementById('<portlet:namespace/>categoryName').value= categoryName;
			         	document.getElementById('<portlet:namespace/>ProjectFees').value= ProjectFees + ("%");
			        	document.getElementById('<portlet:namespace/>gatewayCharges').value= gatewayCharges + ("%");
			         }
			         
			    }
			});
	});

</aui:script>

<%
long projectID = Long.parseLong(renderRequest.getParameter("ProjectId"));
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectObj.getUSER_ID());
List<ProjectFeesRegistration> feesRegistrationList = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
long currentCategory = 0;
%>

<portlet:actionURL name="ChangeCategoryDetails" var="ChangeCategoryDetailsURL" />

<aui:form action="${ChangeCategoryDetailsURL}" method="post">

<aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>
<table class="table marginTopsmall"  >
<tbody>
  <tr >
    <th>Project Title : </th>
    <th><%= projectObj.getTITLE() %></th>
  </tr >
  <tr >
    <td>Name : </td>
    <td><%= userObj.getFULL_NAME() %></td>
  </tr>
  <tr>
	    <td></td>
	    <td></td>
	  </tr>
<%
for(ProjectFeesRegistration feesRegistrationObj : feesRegistrationList){
	DynamicFeesRegistration dynamicFeesObj = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesRegistrationObj.getCATEGORY_ID());
	%>
	 <% if(feesRegistrationObj.getEND_AMOUNT() != 0){ %>
		  <tr >
		    <td style=" border: 1px solid black;">Project Category : </td>
		    <td style=" border: 1px solid black;"><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
		  </tr  >
		   <tr>
		    <td style=" border: 1px solid black;">Start Amount : </td>
		    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
		  </tr>
		  <tr >
		    <td style=" border: 1px solid black;">End Amount :</td>
		    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
		  </tr>
	  <% }if(feesRegistrationObj.getEND_AMOUNT() == 0){
		  currentCategory = feesRegistrationObj.getCATEGORY_ID();
		  %>
	  		<tr >
	  			<td style=" border: 1px solid black;" colspan='3'><center><strong>Current Project Category</strong></center></td>
	  		</tr>
		  <tr >
		    <td style=" border: 1px solid black;">Project Category : </td>
		    <td style=" border: 1px solid black;"><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
		  </tr>
		  	<tr >
		    <td style=" border: 1px solid black;">Start Amount : </td>
		    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
		  </tr>
		  <tr >
		    <td style=" border: 1px solid black;">End Amount :</td>
		    <td style=" border: 1px solid black;"><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
		  </tr> 
		 <%--  <tr>
		    <td>Processing Fees(<%= dynamicFeesObj.getPROCESSING_FEES() %>%) : </td>
		    <td></td>
		  </tr>
		   <tr>
		    <td>Project Fees(<%= dynamicFeesObj.getPROJECT_FEES() %>%) : </td>
		    <td></td>
		  </tr>
		   <tr>
		    <td>Payment Gateway Charges(<%= dynamicFeesObj.getPAYMENT_GATEWAY_CHARGES() %>%) : </td>
		    <td></td>
		  </tr> --%>
	  <% } if(feesRegistrationObj.getEND_AMOUNT() >= 0){  %>
	  	<tr>
	    <td></td>
	    <td></td>
	  </tr>
	  <% } %>
	<%
}

%>

	<tr>
	    <td>Project CategoryName :</td>
	    <td>
	    	<aui:select id="changedCategory" name="changeCategory" label="">
			<aui:option >-------Select Category-------</aui:option>
			<% 
				List<DynamicFeesRegistration> dynamicFeesRegistrationList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
				for(DynamicFeesRegistration dynamicFeesRegistrationObj : dynamicFeesRegistrationList){
					if(dynamicFeesRegistrationObj.getCATEGORY_ID() != currentCategory){
			%>
				<aui:option value="<%= dynamicFeesRegistrationObj.getCATEGORY_ID() %>"><%= dynamicFeesRegistrationObj.getCATEGORY_NAME() %></aui:option>
			<% }} %>
	</aui:select>
	    </td>
    </tr>
    
	<tr>
	    <td>Category Details :</td>
	    <td>
	    	 <div id="categoryValue" >
			 	Category Name :<input name="<portlet:namespace/>categoryName" id="<portlet:namespace/>categoryName"/><br>
			 	Processing Fees :<input name="<portlet:namespace/>processingFees" id="<portlet:namespace/>processingFees"/>	<br>
			 	Project Fees :<input name="<portlet:namespace/>ProjectFees" id="<portlet:namespace/>ProjectFees"/>	<br>
			 	Payment Gateway Charges :<input name="<portlet:namespace/>gatewayCharges" id="<portlet:namespace/>gatewayCharges"/>	<br>
			 </div>
	    </td>
	  </tr>
	
	<tr>
	    <td><aui:button type="submit" value="Submit" ></aui:button></td>
	    <td><aui:button type="cancel" value="cancel" onClick="window.history.back();" /></td>
	  </tr>
	
	
	</tbody>
	</table>
</aui:form>
