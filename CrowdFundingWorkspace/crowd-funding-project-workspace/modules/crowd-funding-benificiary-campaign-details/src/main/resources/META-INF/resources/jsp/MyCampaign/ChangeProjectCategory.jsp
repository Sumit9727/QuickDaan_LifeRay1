<%-- <%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
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
BenificiaryRegistration benificiaryDetails = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectObj.getBENIFICIARY_ID());
UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectObj.getUSER_ID());
List<ProjectFeesRegistration> feesRegistrationList = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
long currentCategory = 0;
%>


<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
</style>

<portlet:actionURL name="ChangeCategoryDetails" var="ChangeCategoryDetailsURL" />

<aui:form action="${ChangeCategoryDetailsURL}" method="post">

<aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>
<table >
	<tbody>
	  <tr >
	    <th>Project Title : </th>
	    <th><%= projectObj.getTITLE() %></th>
	  </tr >
	  <tr >
	    <td>Name(Benificiary Name) : </td>
	    <td><%= benificiaryDetails.getBENIFICIARY_NAME() %></td>
	  </tr>
	  <tr >
	    <td>Relation : </td>
	    <td><%= benificiaryDetails.getBENIFICIARY_CATEGORY() %>(<%= benificiaryDetails.getBENIFICIARY_TYPE() %>)</td>
	  </tr>
	  <tr>
	    <td></td>
	    <td></td>
	  </tr>
	  <tr>
	  	<table>
	  		<tbody>
				<%
					for(ProjectFeesRegistration feesRegistrationObj : feesRegistrationList){
						DynamicFeesRegistration dynamicFeesObj = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesRegistrationObj.getCATEGORY_ID());
						%>
						 <% if(feesRegistrationObj.getEND_AMOUNT() != 0){ %>
							  <tr >
							    <td >Project Category : </td>
							    <td ><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
							  </tr  >
							   <tr>
							    <td >Start Amount : </td>
							    <td ><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
							  </tr>
							  <tr >
							    <td >End Amount :</td>
							    <td ><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
							  </tr>
						  <% }if(feesRegistrationObj.getEND_AMOUNT() == 0){
							  currentCategory = feesRegistrationObj.getCATEGORY_ID();
							  %>
						  		<tr >
						  			<td colspan='3'><center><strong>Current Project Category</strong></center></td>
						  		</tr>
							  <tr >
							    <td >Project Category : </td>
							    <td ><%= dynamicFeesObj.getCATEGORY_NAME() %> </td>
							  </tr>
							  	<tr >
							    <td >Start Amount : </td>
							    <td ><%= feesRegistrationObj.getSTART_AMOUNT() %> </td>
							  </tr>
							  <tr >
							    <td >End Amount :</td>
							    <td ><%= feesRegistrationObj.getEND_AMOUNT() %> </td>
							  </tr> 
							  <tr>
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
							  </tr>
						  <% } if(feesRegistrationObj.getEND_AMOUNT() >= 0){  %>
						  	<tr>
						    <td></td>
						    <td></td>
						  </tr>
						  <% } %>
						<%
					}
					
					%>
	  		</tbody>
	  	</table>
	  </tr>
		<tr>
		    <td>Project CategoryName :</td>
		    <td>
		    	<aui:select id="changedCategory" name="changeCategory" label="">
				<aui:option>-------Select Category-------</aui:option>
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
 --%>
 
 <%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
 <%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
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
 BenificiaryRegistration benificiaryDetails = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectObj.getBENIFICIARY_ID());
 UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectObj.getUSER_ID());
 String BenificiaryName = null;
 if(benificiaryDetails.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){
	 BenificiaryName = userObj.getFULL_NAME();
 }else{
	 BenificiaryName = benificiaryDetails.getBENIFICIARY_NAME();
 }
 
 List<ProjectFeesRegistration> feesRegistrationList = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
 long currentCategory = 0;
 int i = 1;
 %>


 <portlet:actionURL name="ChangeCategoryDetails" var="ChangeCategoryDetailsURL" />

 <aui:form action="${ChangeCategoryDetailsURL}" method="post">

 <aui:input name="projectID" value="<%= projectID %>" type="hidden"></aui:input>

 <style>

 .inline1{
 display:inline-block;
 }
 .inline2{
 margin-left: 322px;
 }
 .inline3{
 display:inline-block;
 }

 .changepc{
 border-top:3px solid #7FBD2C;
 border-right:3px solid #7FBD2C;

 }

 .abc{
    background: #dcdcdc38;
     border: 1px solid #6c757d1a;
     border-bottom: 3px solid #6c757d1a;
     border-right: 3px solid #6c757d1a;
     border-radius: 8px;
     box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);
     padding: 22px;
     margin-top: 72px;
     }
   
   .def{
   background: #dcdcdc38;
     border: 1px solid #6c757d1a;
     border-bottom: 3px solid #6c757d1a;
     border-right: 3px solid #6c757d1a;
     border-radius: 8px;
     box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);
     padding: 22px;
     margin-top: 47px;
   
   }
   
   table, th, td {
   border: 1px solid black;
   border-collapse: collapse;
 }
 th, td {
   padding: 15px;
   text-align: left;
 }
 </style>


 <div class="ChangePC"
 style="border: 1px solid #7FBD2C;
  box-shadow: 0 0 10px 1px #7FBD2C;
  border-style: solid;
  border-color:white;
  margin-top: -4px;
  background-color:white;
  margin:40px; 
  padding: 50px;
  width:813px;
  margin-left: 15%;">
  
  <center><h1 style="color:#0077A2;"> <%= projectObj.getTITLE() %></h1></center><br>
  
  
   <font style="color:#0077A2">Name(Benificiary Name) : </font>
   <%= BenificiaryName %></br>
   <font style="color:#0077A2">Relation : </font>
   <%= benificiaryDetails.getBENIFICIARY_CATEGORY() %>(<%= benificiaryDetails.getBENIFICIARY_TYPE() %>)     
   	 
<div class="def">
	<table style="border:1px solid black;">
 		<tbody>
			 <%
			 for(ProjectFeesRegistration feesRegistrationObj : feesRegistrationList){
				
			 	DynamicFeesRegistration dynamicFeesObj = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesRegistrationObj.getCATEGORY_ID());
			 	%>
			 	 <% if(feesRegistrationList.size() > i){%>
			 		  
			 		  <tr>
				 		  <td style="border:1px solid black;padding: 15px;"> Project Category :<input type="text" value="<%= dynamicFeesObj.getCATEGORY_NAME() %>" disabled></td>
				 		  <td style="border:1px solid black;padding: 15px;"> Start Amount :<input type="text" value="<%= feesRegistrationObj.getSTART_AMOUNT() %>" disabled></td>
				 		  <td style="border:1px solid black;padding: 15px;"> End Amount :<input type="text" value="<%= feesRegistrationObj.getEND_AMOUNT() %>" disabled></td>
			 		   </tr>
			 		   
			 	  <% }if(feesRegistrationList.size() <= i){
			 		  currentCategory = feesRegistrationObj.getCATEGORY_ID();
			 		  %>
			 	  
			 	  	    <tr>
			 	  	    	<td colspan='3'><center><h3 style="color:#0077A2;">Current Project Category</h3></center></td>
			 	  	    </tr>
		                 <tr>
			               <td style="border:1px solid black;padding: 15px;"> Project Category</br>
			               <input type="text"  value="<%= dynamicFeesObj.getCATEGORY_NAME() %>"style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; padding: 5px; margin-bottom: 10px; background-color: white;" disabled></td>
			
			
			                <td style="border:1px solid black;padding: 15px;">Start Amount</br>
				  		    <input type="text" value="<%= feesRegistrationObj.getSTART_AMOUNT() %>"style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; padding: 5px; margin-bottom: 10px; background-color: white;" disabled></td>
			                 
			                 
				  			<td style="border:1px solid black;padding: 15px;">End Amount</br>
					  		<input type="text" value="<%= feesRegistrationObj.getEND_AMOUNT() %>" style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; padding: 5px; margin-bottom: 10px; background-color: white;" disabled></td>
			            </tr>
			 	  <% } if(feesRegistrationObj.getEND_AMOUNT() >= 0){  %>
			 	  	
			 	  	
			 	  <% } %>
			 	<%
			 	i++;
			 }
			 %>
 	   </tbody>
    </table>
</div>
   <div  class="abc">	
 	    <font color="#0077A2">Change Project Category</font>
 	    	<aui:select id="changedCategory" name="changeCategory" label="" style="width:398px;border-radius:12px;margin-left:189px; margin-top:-30px;">
 				<aui:option >-------Select Category-------</aui:option>
 				<% 
 					List<DynamicFeesRegistration> dynamicFeesRegistrationList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
 					for(DynamicFeesRegistration dynamicFeesRegistrationObj : dynamicFeesRegistrationList){
 						if(dynamicFeesRegistrationObj.getCATEGORY_ID() != currentCategory){
 				%>
 					<aui:option value="<%= dynamicFeesRegistrationObj.getCATEGORY_ID() %>"><%= dynamicFeesRegistrationObj.getCATEGORY_NAME() %></aui:option>
 				<% }} %>
 			</aui:select>

     
 	     <font color="#0077A2" style="font-size: x-large;">Category Details</font></br>
 		</br>
 	    	 <div id="categoryValue" >
 			 	<font color="#0077A2">Category Name</font>
 			 	<input name="<portlet:namespace/>categoryName" id="<portlet:namespace/>categoryName" style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; margin-bottom: 10px; width:400px; margin-left:84px; padding: 7px; background-color: white;" disabled></br>
                    
 			 	<font color="#0077A2">Processing Fees</font>
 			 	<input name="<portlet:namespace/>processingFees" id="<portlet:namespace/>processingFees" style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; margin-bottom: 10px; width:400px; margin-left:84px; padding: 7px; background-color: white;" disabled></br>
 			 	
 			 	<font color="#0077A2">Project Fees</font>
 			 	<input name="<portlet:namespace/>ProjectFees" id="<portlet:namespace/>ProjectFees" style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; margin-bottom: 10px; width:400px; margin-left: 112px; padding: 7px; background-color: white;" disabled></br>
 			 	
 			 	<font color="#0077A2">Payment Gateway Charges</font>
 			 	<input name="<portlet:namespace/>gatewayCharges" id="<portlet:namespace/>gatewayCharges"/style="border: 1px solid #7FBD2C; border-bottom: 3px solid #7FBD2C; border-radius: 12px; margin-bottom: 10px; width:400px; margin-left: 10px; padding: 7px; background-color: white;" disabled></br>
 			 </div>
 	  </div>
 	   <br>
 	   <br>
          <aui:button type="submit" value="Submit" style="background-color:#0077A2; color:white;border-radius:22px;margin-left: 235px;"></aui:button>
 	     <aui:button type="cancel" value="cancel" style="border-radius:22px;" onClick="window.history.back();" />
    </div>
 </aui:form>

 
 