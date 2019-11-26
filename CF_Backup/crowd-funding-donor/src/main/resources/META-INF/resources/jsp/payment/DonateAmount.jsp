<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/payment/init.jsp" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<portlet:defineObjects />

<%
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
boolean signedIn = themeDisplayObj.isSignedIn();

String FundOtpId = renderRequest.getParameter("FundOtpId");

%>

<portlet:actionURL name="donationAmount" var="donationAmountURL" />


<aui:form action="${donationAmountURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= 101 %>"></aui:input>
	<aui:input name="FundOtpId" type="hidden" value="<%= FundOtpId %>"></aui:input>
	
	<%if(signedIn == true){ %>
	<aui:input label="Donate Anonymously" name="donateAnonymously" type="radio" value="Yes" />
	<% } %>
			
	<aui:select label="Currency" name="currency" >
		<aui:option label="INR" value="INR" />
		<aui:option label="US$" value="USD" />
	</aui:select>
	<aui:input name="amount" label="Amount"></aui:input>
	<aui:input name="message" label="Message for Benificiary"></aui:input>
	<aui:button name="submit" type="submit" value="Donate Now" />
	
</aui:form>