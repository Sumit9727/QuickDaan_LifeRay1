<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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

float totalDonatedAmt = 0;
float remainingAmt = 0;
float processingFeesAmt = 0;
float paymentChargesAmt = 0;
float projectFeesAmt = 0;
float otherChargesAmt = 0;
float totalAmt = 0;
String categoryName = null;
long currentCategoryId = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
	remainingAmt = donatedAmt - totalDonatedAmt;
}

List<ProjectFeesRegistration> projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
if(projectFeesRegistration != null) {
	for(ProjectFeesRegistration feesObj : projectFeesRegistration) {
		if(feesObj.getEND_AMOUNT() == 0) {
			DynamicFeesRegistration dynamicCategoryDetails = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesObj.getCATEGORY_ID());
		
			currentCategoryId = feesObj.getPROJECT_FEES_ID();
			categoryName = dynamicCategoryDetails.getCATEGORY_NAME();
			processingFeesAmt = (dynamicCategoryDetails.getPROCESSING_FEES()*totalDonatedAmt)/100;
			projectFeesAmt = (dynamicCategoryDetails.getPROJECT_FEES()*totalDonatedAmt)/100;
			paymentChargesAmt = (dynamicCategoryDetails.getPAYMENT_GATEWAY_CHARGES()*totalDonatedAmt)/100;
			otherChargesAmt =  (dynamicCategoryDetails.getOTHER_CHARGES()*totalDonatedAmt)/100;
		}
	}
}

List<FundReleaseRegistration> totalFundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
float totalWithdrawAmt = 0; 
for(FundReleaseRegistration fundReleaseObj : totalFundReleaseList){
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getTOTAL_WITHDRAW_AMOUNT();
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getPROCESSING_FEES() + fundReleaseObj.getPROJECT_FEES() + fundReleaseObj.getPAYMENT_GATEWAY_CHARGES();
}
float remainingtAmt = totalDonatedAmt - totalWithdrawAmt;
totalAmt = totalDonatedAmt - (processingFeesAmt + projectFeesAmt + paymentChargesAmt + otherChargesAmt + totalWithdrawAmt);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<div class="RequestFundAmt" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;" >
<h1> <center style="color:#0077A2;"><%= projectRegistration.getTITLE() %></center></h1>
<portlet:actionURL name="requestFundWithdraw" var="requestFundWithdrawURL" />

<aui:form action="${requestFundWithdrawURL}" method="post">

<aui:input name="ProjectId" type="hidden" value="<%= projectRegistration.getPROJECT_ID() %>"></aui:input>
<aui:input name="totalAmt" type="hidden" value="<%= totalAmt %>"></aui:input>
<aui:input name="processingFeesAmt" type="hidden" value="<%= processingFeesAmt %>"></aui:input>
<aui:input name="projectFeesAmt" type="hidden" value="<%= projectFeesAmt %>"></aui:input>
<aui:input name="paymentChargesAmt" type="hidden" value="<%= paymentChargesAmt %>"></aui:input>
<aui:input name="currentCategoryId" type="hidden" value="<%= currentCategoryId %>"></aui:input>
	
<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Project Details</h3></b><br></div>
	<table cellpadding="15" border="1" style="background-color: #cccccc29; width: 628px;">
		  <tr>
			    <td>Required  Fund Amount :</td>
			    <td><%= String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT()) %></td>
		  </tr>
		  <tr>
			    <td>Received Fund Amount :</td>
			    <td><%= String.format("%.0f",totalDonatedAmt) %></td>
		  </tr>
		  <tr>
			    <td>Pre withdrawan Amount :</td>
			    <td><%= String.format("%.0f",totalWithdrawAmt)  %></td>
		  </tr>
		  <tr>
			    <td>Remaining Amount :</td>
			    <td><%= String.format("%.0f",remainingtAmt)  %></td>
		  </tr>
		 
	</table>
</div>
		
		<div style="background: #dcdcdc38;border: 1px solid #6c757d1a;border-bottom: 3px solid #6c757d1a;border-right: 3px solid #6c757d1a; border-radius: 8px;box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);padding: 22px;margin-top: 72px;">
	
			<div><b><h3 style="font-size: 1.2rem;padding: 2px;color: darkgreen;">Received Amount from Donor</h3></b><br></div>
			
				<%
				float totalCategoryAmtReceive = 0;
				float processingFees = 0;
				float projectFees = 0;
				float paymentGatewayCharges = 0;
				float totalReceivedAmt = 0;
				
				List<DynamicFeesRegistration> dynamicCategoryList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
				for(DynamicFeesRegistration dynamicCategoryDataObj : dynamicCategoryList){
					List<FundRegistration> fundRegistrationCategoryList = FundRegistrationLocalServiceUtil.findByDYNAMIC_PROJECT_CATEGORY_ID(projectRegistration.getPROJECT_ID(), dynamicCategoryDataObj.getCATEGORY_ID());
					for(FundRegistration fundRegistrationCategoryObj : fundRegistrationCategoryList){
						
						totalCategoryAmtReceive = totalCategoryAmtReceive + fundRegistrationCategoryObj.getDONATED_AMOUNT();
						processingFees = (totalCategoryAmtReceive * dynamicCategoryDataObj.getPROCESSING_FEES())/100;
						projectFees = (totalCategoryAmtReceive * dynamicCategoryDataObj.getPROJECT_FEES())/100;
						paymentGatewayCharges =(totalCategoryAmtReceive * dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES())/100;
						totalReceivedAmt = (totalCategoryAmtReceive - (processingFees + projectFees + paymentGatewayCharges));
					}
					%>
					<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
						<tr>
						    <td>Category Name</td>
						    <td>Received Amount</td>
						    <td>Processing Fees(<%= dynamicCategoryDataObj.getPROCESSING_FEES() %>)%</td>
						    <td>Project Fees(<%= dynamicCategoryDataObj.getPROJECT_FEES() %>)%</td>
						    <td>Payment Getway Charges(<%= dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES() %>)%</td>
						    <td>Total Received Fund Amount(including All charges)</td>
						</tr>
						<tr>
						    <td><%= dynamicCategoryDataObj.getCATEGORY_NAME() %></td>
						    <td><%= Math.floor(totalCategoryAmtReceive) %></td>
						    <td><%= Math.floor(processingFees) %></td>
						    <td><%= Math.floor(projectFees) %></td>
						    <td><%= Math.floor(paymentGatewayCharges) %></td>
						    <td><%= Math.floor(totalReceivedAmt) %></td>
						 </tr>
					</table>
					<br>
					<br>
					<%
					totalCategoryAmtReceive = 0;
					processingFees = 0;
					projectFees = 0;
					paymentGatewayCharges = 0;
					totalReceivedAmt = 0;
				}
				
			%>
			
			<br><br>
			
			<% 
				List<FundReleaseRegistration> fundReleaseRegistrationList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
				for(FundReleaseRegistration fundReleaseRegistration : fundReleaseRegistrationList){
					ProjectFeesRegistration releaseProjectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_FEES_ID(fundReleaseRegistration.getPROJECT_FEES_ID()); 
					DynamicFeesRegistration dynamicFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(releaseProjectFeesRegistration.getCATEGORY_ID());
					
					float totalRequestedAmt = fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT() + fundReleaseRegistration.getPROCESSING_FEES() + fundReleaseRegistration.getPROJECT_FEES() + fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES();
					if( Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == false){
						%>
							<strong style="color:#0077A2;">Release Fund Details</strong><br>
							<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
								  <tr>
								    <td>Release Date :</td>
								    <td><%= formatter.format(fundReleaseRegistration.getRELEASE_DATE()) %></td>
								  </tr>
								  <tr>
								  	<td>Requested Withdraw Amount : </td>
								  	<td><%= Math.floor(totalRequestedAmt) %></td>
								  </tr>
								  <tr>
								    <td>Processing Fees :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) %></td>
								 </tr>
								 <tr>
								    <td>Project Fees :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getPROJECT_FEES()) %></td>
								  </tr>
								   <tr>
								    <td>Payment Getway Charges :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) %></td>
								  </tr>
								   <tr>
								    <td>Total Fund Realase Amount(including All charges) :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) %></td>
								  </tr>
							</table>
						<%
					}
					if(Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == true){
						%>
							<strong style="color:#0077A2;">Requested Fund Withdraw Amount</strong>
							<table cellpadding="15" border="1" style="color: tomato; background-color: #cccccc29; width: 628px;">
								 <tr>
								    <td>Requested Date :</td>
								    <td><%= formatter.format(fundReleaseRegistration.getREQUEST_DATE()) %></td>
								  </tr>
								  <tr>
								  	<td>Requested Withdraw Amount : </td>
								  	<td><%= Math.floor(totalRequestedAmt) %></td>
								  </tr>
								  <tr>
								    <td>Processing Fees :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) %></td>
								 </tr>
								 <tr>
								    <td>Project Fees :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getPROJECT_FEES()) %></td>
								  </tr>
								   <tr>
								    <td>Payment Getway Charges :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) %></td>
								  </tr>
								   <tr>
								    <td>Total Fund Realase Amount(including All charges) :</td>
								    <td><%= Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) %></td>
								  </tr>
							</table>
						<%
					}
				} %>
		</div>
	
	<%
	if(projectRegistration.getREQUEST_STATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2){
		if(totalDonatedAmt <= projectRegistration.getREQUIRED_FUND_AMOUNT()){ %>
			<div>
				<aui:input name="btn" label="Continue Campaign and Request Fund Withdraw" type="radio" value="continue" ></aui:input>
				<aui:input name="btn" label="Stop Capaign and Request Fund Withdraw" type="radio" value="stop" ></aui:input>
				<aui:input name="btn" label="Stop Capaign without withdraw Fund" type="radio" value="delete" ></aui:input><br>
			</div>
		<%}%>
	   <aui:button type="submit" value="Request for Withdraw" style="border-radius:22px;background-color:#0077A2;color:white;margin-left: 205px;"/>
	<%} %>
	<aui:button type="cancel" value="cancel" style="border-radius:22px;" onClick="window.history.back();" />
 </aui:form>
 </div>
 
 

 
 
<%--  <%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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

float totalDonatedAmt = 0;
float remainingAmt = 0;
float processingFeesAmt = 0;
float paymentChargesAmt = 0;
float projectFeesAmt = 0;
float otherChargesAmt = 0;
float totalAmt = 0;
String categoryName = null;
long currentCategoryId = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
	remainingAmt = donatedAmt - totalDonatedAmt;
}

List<ProjectFeesRegistration> projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
if(projectFeesRegistration != null) {
	for(ProjectFeesRegistration feesObj : projectFeesRegistration) {
		if(feesObj.getEND_AMOUNT() == 0) {
			DynamicFeesRegistration dynamicCategoryDetails = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesObj.getCATEGORY_ID());
		
			currentCategoryId = feesObj.getPROJECT_FEES_ID();
			categoryName = dynamicCategoryDetails.getCATEGORY_NAME();
			processingFeesAmt = (dynamicCategoryDetails.getPROCESSING_FEES()*totalDonatedAmt)/100;
			projectFeesAmt = (dynamicCategoryDetails.getPROJECT_FEES()*totalDonatedAmt)/100;
			paymentChargesAmt = (dynamicCategoryDetails.getPAYMENT_GATEWAY_CHARGES()*totalDonatedAmt)/100;
			otherChargesAmt =  (dynamicCategoryDetails.getOTHER_CHARGES()*totalDonatedAmt)/100;
		}
	}
}

List<FundReleaseRegistration> totalFundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
float totalWithdrawAmt = 0; 
for(FundReleaseRegistration fundReleaseObj : totalFundReleaseList){
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getTOTAL_WITHDRAW_AMOUNT();
	totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getPROCESSING_FEES() + fundReleaseObj.getPROJECT_FEES() + fundReleaseObj.getPAYMENT_GATEWAY_CHARGES();
}
float remainingtAmt = totalDonatedAmt - totalWithdrawAmt;
totalAmt = totalDonatedAmt - (processingFeesAmt + projectFeesAmt + paymentChargesAmt + otherChargesAmt + totalWithdrawAmt);
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<div class="RequestFundAmt" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;" >
<h1> <center style="color:#0077A2;"><%= projectRegistration.getTITLE() %></center></h1>
<portlet:actionURL name="requestFundWithdraw" var="requestFundWithdrawURL" />

<aui:form action="${requestFundWithdrawURL}" method="post">

<aui:input name="ProjectId" type="hidden" value="<%= projectRegistration.getPROJECT_ID() %>"></aui:input>
<aui:input name="totalAmt" type="hidden" value="<%= totalAmt %>"></aui:input>
<aui:input name="processingFeesAmt" type="hidden" value="<%= processingFeesAmt %>"></aui:input>
<aui:input name="projectFeesAmt" type="hidden" value="<%= projectFeesAmt %>"></aui:input>
<aui:input name="paymentChargesAmt" type="hidden" value="<%= paymentChargesAmt %>"></aui:input>
<aui:input name="currentCategoryId" type="hidden" value="<%= currentCategoryId %>"></aui:input>
	
	<style>
	.body {
    margin: 0;
    font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
    font-size: 1rem;
    font-weight: 100;
    line-height: 1.5;
    color: #272833;
    text-align: left;
    background-color: #F1F2F5;
}
</style>
	
	<div>
	<div class="Pdetails"
	style="background: #dcdcdc38;
    border: 1px solid #6c757d1a;
    border-bottom: 3px solid #6c757d1a;
    border-right: 3px solid #6c757d1a;
    border-radius: 8px;
    box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);
    padding: 22px;
    margin-top: 72px;">
	<h3 style="color: brown;">Project Details</h3>
		<table cellpadding="15" border="1" style="background-color: #cccccc29; width: 628px;">
		  <tr>
		    <td>Required  Fund Amount :</td>
		    <td><%= String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT()) %></td>
		  </tr>
		  <tr>
		    <td>Received Fund Amount :</td>
		    <td><%= String.format("%.0f",totalDonatedAmt) %></td>
		  </tr>
		  <tr>
		    <td>Pre withdrawan Amount :</td>
		    <td><%= String.format("%.0f",totalWithdrawAmt)  %></td>
		  </tr>
		  <tr>
		    <td>Remaining Amount :</td>
		    <td><%= String.format("%.0f",remainingtAmt)  %></td>
		  </tr>
		 
		</table>
		</div>
		<br/>
		
		<div class="RAFD"
		style=" background: #dcdcdc38;
			    border: 1px solid #6c757d1a;
			    border-bottom: 3px solid #6c757d1a;
			    border-right: 3px solid #6c757d1a;
			    border-radius: 8px;
			    box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);
			    padding: 12px;
			    margin-top: 72px; ">
			    
		<h3  style="color: brown;">Received Amount from Donor </h3>
		<div class="body">
		<%
		float totalCategoryAmtReceive = 0;
		float processingFees = 0;
		float projectFees = 0;
		float paymentGatewayCharges = 0;
		float totalReceivedAmt = 0;
		
		List<DynamicFeesRegistration> dynamicCategoryList = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrations(0, DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistrationsCount());
		for(DynamicFeesRegistration dynamicCategoryDataObj : dynamicCategoryList){
			List<FundRegistration> fundRegistrationCategoryList = FundRegistrationLocalServiceUtil.findByCATEGORY_ID(dynamicCategoryDataObj.getCATEGORY_ID());
			for(FundRegistration fundRegistrationCategoryObj : fundRegistrationCategoryList){
				
				totalCategoryAmtReceive = totalCategoryAmtReceive + fundRegistrationCategoryObj.getDONATED_AMOUNT();
				processingFees = (totalCategoryAmtReceive * dynamicCategoryDataObj.getPROCESSING_FEES())/100;
				projectFees = (totalCategoryAmtReceive * dynamicCategoryDataObj.getPROJECT_FEES())/100;
				paymentGatewayCharges =(totalCategoryAmtReceive * dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES())/100;
				totalReceivedAmt = (totalCategoryAmtReceive - (processingFees + projectFees + paymentGatewayCharges));
			}
			%>
			<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
				<tr>
				    <td>Category Name</td>
				    <td>Received Amount</td>
				    <td>Processing Fees(<%= dynamicCategoryDataObj.getPROCESSING_FEES() %>)%</td>
				    <td>Project Fees(<%= dynamicCategoryDataObj.getPROJECT_FEES() %>)%</td>
				    <td>Payment Getway Charges(<%= dynamicCategoryDataObj.getPAYMENT_GATEWAY_CHARGES() %>)%</td>
				    <td>Total Received Fund Amount(including All charges)</td>
				</tr>
				<tr>
				    <td><%= dynamicCategoryDataObj.getCATEGORY_NAME() %></td>
				    <td><%= Math.floor(totalCategoryAmtReceive) %></td>
				    <td><%= Math.floor(processingFees) %></td>
				    <td><%= Math.floor(projectFees) %></td>
				    <td><%= Math.floor(paymentGatewayCharges) %></td>
				    <td><%= Math.floor(totalReceivedAmt) %></td>
				 </tr>
			</table>
			<br>
			<br>
			<%
			totalCategoryAmtReceive = 0;
			processingFees = 0;
			projectFees = 0;
			paymentGatewayCharges = 0;
			totalReceivedAmt = 0;
		}
		
	%>
	<br><br>
		<%
		List<FundReleaseRegistration> fundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
		for(FundReleaseRegistration fundReleaseRegistration : fundReleaseList){
			
			ProjectFeesRegistration releaseProjectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_FEES_ID(fundReleaseRegistration.getPROJECT_FEES_ID()); 
			DynamicFeesRegistration dynamicFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(releaseProjectFeesRegistration.getCATEGORY_ID());
			
			float totalRequestedAmt = fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT() + fundReleaseRegistration.getPROCESSING_FEES() + fundReleaseRegistration.getPROJECT_FEES() + fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES();
			if( Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == false){
				%>
					<h1>Release Fund Details</h1>
					<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
						  <tr>
						    <td>Release Date :</td>
						    <td><%= formatter.format(fundReleaseRegistration.getRELEASE_DATE()) %></td>
						  </tr>
						  <tr>
						  	<td>Requested Withdraw Amount : </td>
						  	<td><%= Math.floor(totalRequestedAmt) %></td>
						  </tr>
						  <tr>
						    <td>Processing Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) %></td>
						 </tr>
						 <tr>
						    <td>Project Fees:</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROJECT_FEES()) %></td>
						  </tr>
						   <tr>
						    <td>Payment Getway Charges :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) %></td>
						  </tr>
						   <tr>
						    <td>Total Fund Realase Amount(including All charges) :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) %></td>
						  </tr>
					</table>
				<%
			}
			if(Validator.isNull(fundReleaseRegistration.getRELEASE_DATE()) == true){
				%>
					<h1>Requested Fund Withdraw Amount </h1>
					<table cellpadding="15" border="1" style="color: tomato; background-color: #cccccc29; width: 628px;">
						 
						 <tr>
						    <td>Requested Date :</td>
						    <td><%= formatter.format(fundReleaseRegistration.getREQUEST_DATE()) %></td>
						  </tr>
						  <tr>
						  	<td>Requested Withdraw Amount : </td>
						  	<td><%= Math.floor(totalRequestedAmt) %></td>
						  </tr>
						  <tr>
						    <td>Processing Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROCESSING_FEES()) %></td>
						 </tr>
						 <tr>
						    <td>Project Fees :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPROJECT_FEES()) %></td>
						  </tr>
						   <tr>
						    <td>Payment Getway Charges :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getPAYMENT_GATEWAY_CHARGES()) %></td>
						  </tr>
						   <tr>
						    <td>Total Fund Realase Amount(including All charges) :</td>
						    <td><%= Math.floor(fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT()) %></td>
						  </tr>
					</table>
				<%
			}
		}
		%>
		</div>
	</div>
	</div>
	<br>
	<%
	if(projectRegistration.getREQUEST_STATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2){
		if(totalDonatedAmt <= projectRegistration.getREQUIRED_FUND_AMOUNT()){ %>
			<div style="background: #dcdcdc38;
					    border: 1px solid #6c757d1a;
					    border-bottom: 3px solid #6c757d1a;
					    border-right: 3px solid #6c757d1a;
					    border-radius: 8px;
					    box-shadow: 0 1px 26px 0 rgba(0, 0, 0, 0.32);
					    padding: 22px;
					    margin-top: 72px;">
				<aui:input name="btn" label="Continue Campaign and Request Fund Withdraw" type="radio" value="continue" ></aui:input>
				<aui:input name="btn" label="Stop Capaign and Request Fund Withdraw" type="radio" value="stop" ></aui:input>
				<aui:input name="btn" label="Stop Capaign without withdraw Fund" type="radio" value="delete" ></aui:input><br>
			</div>
		<%}%>
		<br>
		</br>
		
	   <aui:button type="submit" value="Request for Withdraw" style="border-radius:22px;background-color:#0077A2;color:white;margin-left: 205px;"/>
	<%} %>
	<aui:button type="cancel" value="cancel" style="border-radius:22px;" onClick="window.history.back();" />
 </aui:form>
 </div>
  --%>
 
 
 