<%@page import="com.crowd.funding.database.model.FundReleaseRegistration"%>
<%@page import="com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/jsp/init.jsp" %>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

 <portlet:renderURL var="FilteredReoprtURL" windowState="normal">
	<portlet:param name="jspPage" value="/jsp/FilteredReportOptions.jsp"/>
</portlet:renderURL>

<aui:button name="submit" onClick="${FilteredReoprtURL}" value="Filtered Report" /> </BR></BR></BR></BR>
<%
int counter = 1;
List<ProjectRegistration> projectList = null;
List<BenificiaryRegistration> benificiaryRegistrationList = null;
List<FundReleaseRegistration> fundWithdrawList = null;
ProjectRegistration	projectObj = null;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

String selectStatus = ParamUtil.getString(renderRequest, "selectStatus");
String selectCause = ParamUtil.getString(renderRequest, "selectCause");
String selectBeneficieryCategory = ParamUtil.getString(renderRequest, "selectBeneficieryCategory");
String selectWithdrawType = ParamUtil.getString(renderRequest, "selectWithdrawType");
String campaignStartDate = ParamUtil.getString(renderRequest, "campaignStartDate");
String campaignFromDate = ParamUtil.getString(renderRequest, "campaigFromDate");
String campaignToDate = ParamUtil.getString(renderRequest, "campaignToDate");


if(selectCause.isEmpty() == false && selectBeneficieryCategory.isEmpty() == false) {
	benificiaryRegistrationList = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_BENIFICIARY_CATEGORY(selectCause, selectBeneficieryCategory);
}

if(selectStatus.isEmpty() == false && campaignStartDate.isEmpty() == false) {
	for(BenificiaryRegistration benificiaryObj : benificiaryRegistrationList) {
		projectList = ProjectRegistrationLocalServiceUtil.findprojectByBenificiaryIdStatusCreationDate(benificiaryObj.getBENIFICIARY_ID(), 
				Integer.parseInt(selectStatus), campaignStartDate);
	}
}
if(selectStatus.isEmpty() == false) {
	for(BenificiaryRegistration benificiaryObj : benificiaryRegistrationList) {
		projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID_STATUS(benificiaryObj.getBENIFICIARY_ID(), Integer.parseInt(selectStatus));
	}
}
if(campaignStartDate.isEmpty() == false) {
	for(BenificiaryRegistration benificiaryObj : benificiaryRegistrationList) {
		projectList = ProjectRegistrationLocalServiceUtil.findprojectByBenificiaryIdCreationDate(benificiaryObj.getBENIFICIARY_ID(), campaignStartDate);
	}
}

if(selectWithdrawType.isEmpty() == false) {
	for(ProjectRegistration projectObject : projectList) {
		fundWithdrawList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObj.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
	}
}

System.out.println("Project List :::: " + projectList.size());
if(selectWithdrawType.isEmpty() == false)
System.out.println("Fund List :::: " + fundWithdrawList.size());




/* if(selectStatus.isEmpty() == false || selectCause.isEmpty() == false || selectBeneficieryCategory.isEmpty() == false || campaignStartDate.isEmpty() == false){
	
}else if(selectStatus.isEmpty() == false){
	if(Integer.parseInt(selectStatus) == 6)
		projectList = ProjectRegistrationLocalServiceUtil.findByREQUEST_STATUS(2);
	else if(Integer.parseInt(selectStatus) == 7)
		projectList = ProjectRegistrationLocalServiceUtil.findByREQUEST_STATUS(3);
	else
	projectList = ProjectRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectStatus));
}else if(selectCause.isEmpty() == false){
	benificiaryRegistrationList = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_DETAILS(selectCause);
}else if(selectBeneficieryCategory.isEmpty() == false){
	benificiaryRegistrationList = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_CATEGORY(selectBeneficieryCategory);
}else if(campaignStartDate.isEmpty() == false){
 	projectList = ProjectRegistrationLocalServiceUtil.findByProjectCreationDate(campaignStartDate);	
}else if((campaignFromDate.isEmpty() == false) && (campaignToDate.isEmpty() == false)){
 	projectList = ProjectRegistrationLocalServiceUtil.findProjectBetweenCreationDateQuery(campaignFromDate, campaignToDate);	
}else if(selectWithdrawType.isEmpty() == false){
	fundWithdrawList = FundReleaseRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectWithdrawType));
}else{
	projectList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0, CounterLocalServiceUtil.getCountersCount());
} */ 
%>
<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>No.</th>
				<th>Project Title</th>
				<th>Creation Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			<% if((selectCause.isEmpty() == false) || (selectBeneficieryCategory.isEmpty() == false)){
			for(BenificiaryRegistration benificiaryRegistrationCategoryObj : benificiaryRegistrationList ) {
				projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryRegistrationCategoryObj.getBENIFICIARY_ID());
			for(ProjectRegistration projectRegistrationObj : projectList ) {
			%>
			<tr>
			<portlet:renderURL var="projectDetailForBeneficieryUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistrationObj.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
			  </portlet:renderURL>
				<td><%= counter %></td>
				 <td><%= projectRegistrationObj.getTITLE()%></td>
				 <td><%= formatter.format(projectRegistrationObj.getCREATION_DATE()) %></td>
				 <td><%= projectRegistrationObj.getSTATUS() %></td>
				 <td><aui:button name="submit" onClick="${projectDetailForBeneficieryUrl}" value="Details" /></td>
				 </tr>
			<%
			   counter++;
			}
			}
			}
			else if(selectWithdrawType.isEmpty() == false){
				for(FundReleaseRegistration fundReleaseObj : fundWithdrawList ) {
					projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundReleaseObj.getPROJECT_ID());
				%>
				<tr>
				<portlet:renderURL var="projectDetailForWithdrawTypeUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
			  </portlet:renderURL>
					<td><%= counter %></td>
					 <td><%= projectObj.getTITLE()%></td>
					 <td><%= formatter.format(projectObj.getCREATION_DATE()) %></td>
					 <td><%= projectObj.getSTATUS() %></td>
					 <td><aui:button name="submit" onClick="${projectDetailForWithdrawTypeUrl}" value="Details" /></td>
					 </tr>
				<%
				   counter++;
				}
			}
				 else{
			for(ProjectRegistration projectRegistrationObj : projectList ) {
			%>
			<tr>
			<portlet:renderURL var="projectDetailForOthersUrl" windowState="normal">
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectRegistrationObj.getPROJECT_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/ProjectDetails.jsp"/>
			 	</portlet:renderURL>
				<td><%= counter %></td>
				 <td><%= projectRegistrationObj.getTITLE()%></td>
				 <td><%= formatter.format(projectRegistrationObj.getCREATION_DATE()) %></td>
				 <td><%= projectRegistrationObj.getSTATUS() %></td>
				 <td><aui:button name="submit" onClick="${projectDetailForOthersUrl}" value="Details" /></td>
				 </tr>
			<%
			   counter++;
		}
		}%>
	</tbody>
</table>
