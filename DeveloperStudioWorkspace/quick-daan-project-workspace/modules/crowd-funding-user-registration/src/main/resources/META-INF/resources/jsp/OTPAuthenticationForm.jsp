<meta content="width=device-width, initial-scale=1" name="viewport" />
<%@ include file="/jsp/init.jsp" %>


<script type="text/javascript">
$(document).ready(function() {
    $("#formID").validate({
        rules : {
        	otpReceivingOption : {
                required : true                 
            }
        },
    });
});
</script>

<portlet:actionURL name="emailMobileRegistration" var="emailMobileRegistrationURL" />

<liferay-ui:error key="error-key" message="Your Email Address is already registered. Please login." />
<aui:form action="${emailMobileRegistrationURL}" method="post" id="formID">


<div class="OTPAuthentication" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<center><h1 style="color:#0077A2;">REGISTRATION FORM </h1> </center>

	
	<aui:input cssClass="boxborder" name="email" label="Email ID"   >
<aui:validator name="required" /><aui:validator name="Email" /> </aui:input>
    
	<aui:input cssClass="boxborder" name="mobileNo" label="Mobile No" >
<aui:validator name="required" /><aui:validator name="number" /></aui:input>
	
		
	  <aui:field-wrapper name="otpReceivingOption"  label="Please select your preferred option to receive the OTP "><br>
		
		<aui:input inlineLabel="left" inlineField="true" name="otpReceivingOption" id="otpReceivingOption" type="radio" value="1" label="Email" checked="true">
	    </aui:input>
	
		<aui:input inlineLabel="left" inlineField="true" name="otpReceivingOption" id="otpReceivingOption" type="radio" value="0"  label="Phone">
       </aui:input>
		
	    
	    </aui:field-wrapper>
	  <center><button type="submit" style="background-color:#0077A2;border-radius: 22px;color:white;width: 108px;height: 39px;">Send OTP</button></center>
</div>

</aui:form>






