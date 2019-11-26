<%@page import="com.crowd.funding.user.registration.controller.constants.UserRegistrationControllerPortletKeys"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/init.jsp" %>
<portlet:defineObjects />

<liferay-ui:success key="success" message="Your OTP has been successfully sent, Please Enter OTP."/>
<liferay-ui:error key="error-key" message="Please Enter Correct OTP." />
<liferay-ui:error key="otp-expired-error-key" message="Entered OTP is Expired. Please Generate New OTP." />

<%
long mobileNo = Long.parseLong(renderRequest.getParameter("mobileNo"));
String otpReceivingOption =  renderRequest.getParameter("otpReceivingOption");
int timer = Integer.parseInt(renderRequest.getParameter("timerValue"));
%>  

<portlet:resourceURL var="serveResource" />
<portlet:actionURL name="otpAuthentication" var="otpAuthenticationURL" />
	
<div class="OTPValidation "style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<aui:form action="${otpAuthenticationURL}" method="post" >
	
   <center><h1 style="color:#0077A2;"> OTP VALIDATION FORM </h1> </center>
   
   <% if(timer == 1){%>
		<h2><div id="timer"style="font-weight:bold;">2:00</div></h2>
   <% 
   }else{%>
   		<h2><div id="timerRedirect" style="font-weight:bold; margin-left: 1%;">2:00</div></h2> 
   <%} %>
	
	
	<aui:input type="hidden" id="mobileNo" name="mobileNo" value="<%= mobileNo  %>" />
	<% if(otpReceivingOption.equalsIgnoreCase(UserRegistrationControllerPortletKeys.OTP_DEVICE_PHONE_0)){ %>
		<aui:input cssClass="boxborder"  type="text" name="mobileOtp" label="Enter Your Phone OTP"  >
		<aui:validator name="required"/>
        <aui:validator name="digit"/>	
        </aui:input>
	<%}else{ %>
		<aui:input cssClass="boxborder"  type="text" name="emailOtp" id="nirav" label="Enter Your Email OTP" >
		<aui:validator name="required"/>
        <aui:validator name="digit"/>	
        </aui:input>
	<%} %>
	<center>
	<aui:button type="submit"  name="Submit OTP" onClick="<portlet:namespace/>validate()"value="Submit OTP" style="background-color:#0077A2;border-radius: 22px;width: 108px;height: 39px; color:white;"/>
	</br>
	</br>
	</center>
	
  	<liferay-portlet:actionURL name="reSendOtpRegistration" var="reSendOtpRegistrationURL">
		<portlet:param name="mobileNo" value="<%= String.valueOf(mobileNo) %>" />
	</liferay-portlet:actionURL>
	
	<aui:button type="button" onClick="${reSendOtpRegistrationURL}"  value="Resend OTP"/>

	<portlet:renderURL var="ReEnterURL" windowState="normal">
		<portlet:param name="jspPage" value="/jsp/OTPAuthenticationForm.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${ReEnterURL}"  value="Change Email/Mobile No"/>
	
</aui:form>
</div>



<script type="text/javascript">
 
var timeoutHandle;
function countdown(minutes) {
    var seconds = 60;
    var mins = minutes
    function tick() {
        var counter = document.getElementById("timer");
        var current_minutes = mins-1
        seconds--;
        counter.innerHTML =  current_minutes.toString() + ":" + (seconds < 10 ? "0" : "") + String(seconds);
        
        if((current_minutes == 0) && (seconds == 0)){
        	alert("Your OTP is Expired. Please Generate New OTP.");
        	window.location = "http://localhost:8080/web/crowd-funding/login";
	        	$(document).ready(function() {
	    			var mobileNoValue = $('#mobileNo').val();
	    			$.ajax({
	    			dataType: 'json',
	    		    url:'${serveResource.toString()}',
	    		    data: {'<portlet:namespace/>mobileNo':mobileNoValue},                
	    		    success: function(response){
	    		        console.log(response);
	    		      }
	    		    });
	    	});
        }
        
        if( seconds > 0 ) {
            timeoutHandle=setTimeout(tick, 1000);
        } else {
            if(mins > 1){
               setTimeout(function () {
            	   countdown(mins - 1); 
            	 }, 1000);
            }
        }
    }
    tick();
}
countdown(2);

</script>

<script type="text/javascript">
 
var timeoutHandle;
function countdownRedirect(minutes) {
    var seconds = 60;
    var mins = minutes
    function tick() {
        var counter = document.getElementById("timerRedirect");
        var current_minutes = mins-1
        seconds--;
        counter.innerHTML =  current_minutes.toString() + ":" + (seconds < 10 ? "0" : "") + String(seconds);
        
        if((current_minutes == 0) && (seconds == 0)){
        	alert("Your OTP is Expired. Please Generate New OTP.");
        	window.location = "http://localhost:8080/web/crowd-funding/login";
	        	$(document).ready(function() {
	    			var mobileNoValue = $('#mobileNo').val();
	    			$.ajax({
	    			dataType: 'json',
	    		    url:'${serveResource.toString()}',
	    		    data: {'<portlet:namespace/>mobileNo':mobileNoValue},                
	    		    success: function(response){
	    		        console.log(response);
	    		      }
	    		    });
	    	});
        }
        
        if( seconds > 0 ) {
            timeoutHandle=setTimeout(tick, 1000);
        } else {
            if(mins > 1){
               setTimeout(function () {
            	   countdownRedirect(mins - 1); 
            	 }, 1000);
            }
        }
    }
    tick();
}
countdownRedirect(2);

</script>


