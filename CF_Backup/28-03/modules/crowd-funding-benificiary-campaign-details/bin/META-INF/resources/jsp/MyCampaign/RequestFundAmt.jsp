<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundReleaseRegistration"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
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



<liferay-theme:defineObjects />

<portlet:defineObjects />


<% 
long ProjectId = Long.parseLong(renderRequest.getParameter("ProjectId"));
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
double totalDonatedAmt = 0;
double remainingAmt = 0;
double processingFees = 0;
double paymentCharges = 0;
double projectFees = 0;
double otherCharges = 0;
double totalAmt = 0;
List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	double donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
	remainingAmt = donatedAmt - totalDonatedAmt;
}

List<ProjectFeesRegistration> projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
if(projectFeesRegistration != null) {
	for(ProjectFeesRegistration feesObj : projectFeesRegistration) {
		if(feesObj.getEND_AMOUNT() == 0) {
			DynamicFeesRegistration dynamicCategoryDetails = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesObj.getCATEGORY_ID());
			
			processingFees = (dynamicCategoryDetails.getPROCESSING_FEES()*totalDonatedAmt)/100;
			projectFees = (dynamicCategoryDetails.getPROJECT_FEES()*totalDonatedAmt)/100;
			paymentCharges = (dynamicCategoryDetails.getPAYMENT_GATEWAY_CHARGES()*totalDonatedAmt)/100;
			otherCharges =  (dynamicCategoryDetails.getOTHER_CHARGES()*totalDonatedAmt)/100;
		}
	}
}




List<FundReleaseRegistration> fundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
float totalWithdrawAmt = 0; 
for(FundReleaseRegistration fundReleaseObj : fundReleaseList){
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getTOTAL_WITHDRAW_AMOUNT();
}
totalAmt = totalDonatedAmt - (processingFees + projectFees + paymentCharges + otherCharges + totalWithdrawAmt);
%>


<h1> <%= projectRegistration.getTITLE() %></h1>
<portlet:actionURL name="requestFundWithdraw" var="requestFundWithdrawURL" />

<aui:form action="${requestFundWithdrawURL}" method="post">

<aui:input name="ProjectId" type="hidden" value="<%= projectRegistration.getPROJECT_ID() %>"></aui:input>
<aui:input name="totalAmt" type="hidden" value="<%= totalAmt %>"></aui:input>
	<div>
		<table >
		  <tr>
		    <td>Requested Fund Amount :</td>
		    <td><%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></td>
		  </tr>
		  <tr>
		    <td>Received Fund Amount :</td>
		    <td><%= totalDonatedAmt %></td>
		  </tr>
		  <tr>
		    <td>Total withdrawal Amount :</td>
		    <td><%= totalWithdrawAmt %></td>
		  </tr>
		   <tr>
		    <td>Processing Fees :</td>
		    <td><%= Math.floor(processingFees) %></td>
		  </tr>
		   <tr>
		    <td>Project Fees :</td>
		    <td><%= Math.floor(projectFees) %></td>
		  </tr>
		   <tr>
		    <td>Payment Getway Charges :</td>
		    <td><%= Math.floor(paymentCharges) %></td>
		  </tr>
		   <tr>
		    <td>Other Charges :</td>
		    <td><%= Math.floor(otherCharges) %></td>
		  </tr>
		   <tr>
		    <td>Total Amount :</td>
		    <td><%= Math.floor(totalAmt) %></td>
		  </tr>
		</table>
	</div>
	
	<% if(totalDonatedAmt != projectRegistration.getREQUIRED_FUND_AMOUNT()){ %>
		<div>
			<aui:input name="btn" label="Continue Campaign and Request Fund Withdraw" type="radio" value="continue" ></aui:input>
			<aui:input name="btn" label="Stop Capaign and Request Fund Withdraw" type="radio" value="stop" ></aui:input>
			<aui:input name="btn" label="Stop Capaign without withdraw Fund" type="radio" value="delete" ></aui:input><br>
		</div>
	<% } %>
	
	<aui:button type="submit" value="Request for Withdraw"/>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
 </aui:form>
 
 
 
