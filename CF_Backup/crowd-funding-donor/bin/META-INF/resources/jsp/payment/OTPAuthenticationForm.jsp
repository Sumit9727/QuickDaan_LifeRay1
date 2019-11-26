<%@ include file="/jsp/payment/init.jsp" %>

<portlet:actionURL name="emailMobileRegistration" var="emailMobileRegistrationURL" />


<aui:form action="${emailMobileRegistrationURL}" method="post" >
	
	<aui:input name="email" label="Email ID" />
	<aui:input name="mobileNo" label="Mobile No." />
	
	<button type="submit" >Send OTP</button>
</aui:form>

