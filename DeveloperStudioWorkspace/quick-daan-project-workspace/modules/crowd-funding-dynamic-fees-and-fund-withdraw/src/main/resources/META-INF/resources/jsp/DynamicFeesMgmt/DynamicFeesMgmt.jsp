<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.LinkedList"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="java.util.List"%>
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

<liferay-ui:error key="error-key" message="This Category is already in used."/>

<portlet:renderURL var="addCategory" windowState="normal">
	<portlet:param name="jspPage" value="/jsp/DynamicFeesMgmt/AddNewCategory.jsp"/>
</portlet:renderURL>

	<aui:button-row>
	    <aui:button value="Add New Category" onClick="${addCategory}"></aui:button>
	</aui:button-row>

<%
int counter = 1;
List<DynamicFeesRegistration> feesList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
LinkedList<DynamicFeesRegistration> reverse = new LinkedList<DynamicFeesRegistration>();
for(int i=feesList.size()-1;i>=0;i--){
	reverse.add(feesList.get(i));
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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
				<th>No</th>
				<th>Category Name</th>
				<th>Category Details</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for(DynamicFeesRegistration dynamicFeesObj : reverse){	%>
				<tr>
					<td><%= counter %></td>
					<td><%= dynamicFeesObj.getCATEGORY_NAME() %></td>
					<td>(Processing Fees:<%= dynamicFeesObj.getPROCESSING_FEES() %>% , Project Fees:<%= dynamicFeesObj.getPROJECT_FEES() %>% , Payment Gateway Charges: <%= dynamicFeesObj.getPAYMENT_GATEWAY_CHARGES()%>%)</td>
					
					<portlet:actionURL var="deleteCategoryDetailsURL" name="deleteCategoryDetails">
						<portlet:param name="dynamicFeesID" value="<%= String.valueOf(dynamicFeesObj.getCATEGORY_ID()) %>" />
					</portlet:actionURL>
					
					<td><aui:button type="Delete" value="Delete" onClick="${deleteCategoryDetailsURL}"/></td>
				</tr>	
			<%
				counter++;
				}
			%>
		</tbody>
	</table>
</form>
<%-- <liferay-ui:search-container delta="4" deltaConfigurable="<%= true %>" emptyResultsMessage="NO RECORDS FOUND" iteratorURL="<%= renderResponse.createRenderURL() %>" total="<%= reverse.size() %>">
		<liferay-ui:search-container-results results="<%=ListUtil.subList(reverse,searchContainer.getStart(),searchContainer.getEnd()) %>"/> 
 		<liferay-ui:search-container-row   className="com.crowd.funding.database.model.DynamicFeesRegistration"  modelVar="dynamicFeesObj">
        
		 <liferay-ui:search-container-column-text name="No" value="<%= String.valueOf(counter) %>" />
         <liferay-ui:search-container-column-text name="Category Name" value="<%= dynamicFeesObj.getCATEGORY_NAME() %>" />
           
			<portlet:actionURL var="deleteCategoryDetailsURL" name="deleteCategoryDetails">
				<portlet:param name="dynamicFeesID" value="<%= String.valueOf(dynamicFeesObj.getCATEGORY_ID()) %>" />
			</portlet:actionURL>
         <liferay-ui:search-container-column-text name="Action" >
         		<aui:button value="Delete" onClick="${deleteCategoryDetailsURL}" />			
         </liferay-ui:search-container-column-text> 
         
         <% counter++ ; %>
   </liferay-ui:search-container-row>
<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>  --%>


