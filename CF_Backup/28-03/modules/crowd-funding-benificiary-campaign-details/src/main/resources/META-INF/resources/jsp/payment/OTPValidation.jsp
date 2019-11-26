<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/payment/init.jsp" %>
<portlet:defineObjects />

<portlet:actionURL name="otpAuthentication" var="otpAuthenticationURL" />

<liferay-ui:error key="error-key" message="Please Enter Correct OTP." />
<liferay-ui:error key="otp-expired-error-key" message="Entered OTP is Expired. Please Generate New OTP." />

<%
long mobileNo = Long.parseLong(renderRequest.getParameter("mobileNo"));
String ProjectId = renderRequest.getParameter("ProjectId");
%>  

<aui:form action="${otpAuthenticationURL}" method="post" >
<div class="OTPValidation" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<center><h1 style="color:#0077A2;">OTP VALIDATION</h1></center><br>
	
	<aui:input class ="form-control" type="hidden" name="mobileNo" value="<%= mobileNo  %>" />
	<aui:input class ="form-control" type="hidden" name="ProjectId" value="<%= ProjectId  %>" />
	
	<aui:input class ="form-control" type="text" name="emailOtp" label="Enter Your Email OTP" style="border-radius:12px; border-bottom:3px solid #7FBD2C;">
	<aui:validator name="required"/>
    <aui:validator name="digit"/>
    </aui:input>
	<aui:input class ="form-control" type="text" name="mobileOtp" label="Enter Your Phone OTP" style="border-radius:12px; border-bottom:3px solid #7FBD2C;"/>
	
	<aui:button type="submit" name="Submit OTP" value="Submit OTP" style="background-color: #0077A2; margin-left: 35%; border-radius:22px;" />
</div>
</aui:form>

		<portlet:actionURL name="reSendOtpRegistration" var="reSendOtpRegistrationURL" >
			<portlet:param name="mobileNo" value="<%= String.valueOf(mobileNo) %>" />
		</portlet:actionURL>
				<aui:button type="button" onClick="${reSendOtpRegistrationURL}"  value="Resend OTP"/>

		<portlet:renderURL var="ReEnterURL" windowState="normal">
			<portlet:param name="jspPage" value="/jsp/payment/DonorRegistrationForm.jsp" />
		</portlet:renderURL>
				<aui:button type="button" onClick="${ReEnterURL}"  value="Change Email/Mobile No"/>


 <script>
 function OTPLost() {
	  alert("Your OTP is Expired. Please Generate New OTP.");
	// Sets the new location of the current window.
	  window.location = "http://localhost:8080/web/crowd-funding";
	}
	setTimeout(OTPLost, 300000);
 </script>
 