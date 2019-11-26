
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundReleaseRegistration"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
<%@page import="com.crowd.funding.fund.withdraw.controller.PriceConversion"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="com.crowd.funding.database.model.FundAccountRegistration"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ImageRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
<%@page import="java.util.Collections"%>
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

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>

.a{
 border: 1px solid #7FBD2C;
 box-shadow: 0 0 10px 1px #7FBD2C;
 border-style: solid;
 border-color:white;
 margin-top: -4px;
 background-color:white;
 margin:40px; 
 padding: 50px;
 width: 520px;
 margin-left: 25%;
}
</style>
<% 
String projectID = renderRequest.getParameter("ProjectId");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

float totalDonatedAmt = 0;
float remainingAmt = 0;
long fundReleaseID = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
for(FundRegistration fundAmtObj : fundAmtList){
	float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
	totalDonatedAmt = totalDonatedAmt + donatedAmt;
}

List<FundReleaseRegistration> totalFundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
float totalWithdrawAmt = 0; 
for(FundReleaseRegistration fundReleaseObj : totalFundReleaseList){
	if(Validator.isNull(fundReleaseObj.getRELEASE_DATE()) == false){
		totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getTOTAL_WITHDRAW_AMOUNT();
		totalWithdrawAmt = totalWithdrawAmt + fundReleaseObj.getPROCESSING_FEES() + fundReleaseObj.getPROJECT_FEES() + fundReleaseObj.getPAYMENT_GATEWAY_CHARGES();
	}
	if(Validator.isNull(fundReleaseObj.getRELEASE_DATE()) == true){
		fundReleaseID = fundReleaseObj.getFUND_RELEASE_ID();
	}
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date currentDate = new Date();

%>

<portlet:actionURL name="approveFundRequestWithdraw" var="approveFundRequestWithdrawURL" >
	<portlet:param name="ProjectId" value="<%=String.valueOf(projectRegistration.getPROJECT_ID()) %>" />
	<portlet:param name="fundReleaseID" value="<%=String.valueOf(fundReleaseID) %>" />
</portlet:actionURL>

	
	<h1><center> <%= projectRegistration.getTITLE() %></center></h1>
	<br><br>
 
<h1 style="color: brown;">Project Details</h1>
<table cellpadding="15" border="1" style="color: darkgreen; background-color: #cccccc29; width: 628px;">
			<%
			remainingAmt = totalDonatedAmt - totalWithdrawAmt;
			%>
		  <tr>
		    <td>Required  Fund Amount :</td>
		    <td><%= String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT()) %></td>
		  </tr>
		  <tr>
		    <td>Received Fund Amount :</td>
		    <td><%= totalDonatedAmt %></td>
		  </tr>
		  <tr>
		    <td>Pre withdrawan Amount :</td>
		    <td><%= totalWithdrawAmt %></td>
		  </tr>
		  <tr>
		    <td>Remaining Amount :</td>
		    <td><%= remainingAmt %></td>
		  </tr>
		 
		</table>
		
		<br><br>
		<h2 style="color: brown;">Received Amount from Donor </h2>
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
		List<FundReleaseRegistration> fundReleaseList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
		for(FundReleaseRegistration fundReleaseRegistration : fundReleaseList){
			
			ProjectFeesRegistration projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_FEES_ID(fundReleaseRegistration.getPROJECT_FEES_ID()); 
			DynamicFeesRegistration dynamicFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(projectFeesRegistration.getCATEGORY_ID());
			
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
<br>   
<br>
<aui:button type="submit" value="Approve" id="" onClick="${approveFundRequestWithdrawURL}" style="background-color: #0077A2;margin-left: 35%; border-radius:22px;"/>
<aui:button type="cancel" value="cancel" onClick="window.history.back();"style="border-radius:22px;" />
