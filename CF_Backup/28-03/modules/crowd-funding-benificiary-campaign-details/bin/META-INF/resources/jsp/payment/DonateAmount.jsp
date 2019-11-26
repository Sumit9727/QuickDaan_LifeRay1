<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/payment/init.jsp" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<portlet:defineObjects />

<%
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
boolean signedIn = themeDisplayObj.isSignedIn();

String ProjectId = renderRequest.getParameter("ProjectId");
String DonorId = renderRequest.getParameter("DonorId");
long donorRegistrationId = 0;
if(DonorId == null)
	donorRegistrationId = 0;
else
	donorRegistrationId = Long.parseLong(DonorId);

%>

<portlet:actionURL name="donationAmount" var="donationAmountURL" />

<aui:form action="${donationAmountURL}" method="post" >
	
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<aui:input name="FundOtpId" type="hidden" value="<%= donorRegistrationId %>"></aui:input>
	
	<div class=" DonateAmount">
	<CENTER><h1 style="color:#0077A2;">DONATE AMOUNT</h1></CENTER><br>
	
	<aui:input class ="form-control" label="Donate Anonymously" name="donateAnonymously" type="radio" value="Yes" />
	<aui:select  class ="form-control" label="Currency" name="currency" >
		<aui:option label="INR" value="INR" />
		<aui:option label="US$" value="USD" />
	</aui:select>
	<aui:input  class ="form-control" name="amount" label="Amount" style="border-radius:12px; border-bottom:3px solid #7FBD2C;" ></aui:input>
	
	<aui:input  class ="form-control" name="message" label="Message for Benificiary" style="border-radius:12px; border-bottom:3px solid #7FBD2C;"></aui:input>
	
	<aui:button name="submit" type="submit" value="Donate Now" style="background-color: #0077A2;margin-left: 35%; border-radius:22px;"/>
	</div>
</aui:form>