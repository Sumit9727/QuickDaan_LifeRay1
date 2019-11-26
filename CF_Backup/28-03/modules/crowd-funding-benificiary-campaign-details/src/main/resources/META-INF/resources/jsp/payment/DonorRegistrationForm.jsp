<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<portlet:defineObjects />


<%
String ProjectId = renderRequest.getParameter("ProjectId");
System.out.println("ProjectId ::: " + ProjectId);
%>

<portlet:actionURL name="emailMobileRegistration" var="emailMobileRegistrationURL" />

<aui:form action="${emailMobileRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>" />
	
	<div class="DonorRegistrationForm" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
	<center><h1 style="color:#0077A2;"> DONOR REGISTRATION FORM</h1></center><br>
	
	    <aui:input  class ="form-control" name="name" label="Full Name" style="border-radius:12px; border-bottom:3px solid #7FBD2C;">
	    <aui:validator name="required"/>
        <aui:validator name="alpha"/>
        </aui:input>
        
		<aui:input class ="form-control" name="address" label="Address" style="border-radius:12px; border-bottom:3px solid #7FBD2C;" >
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
        </aui:input>
        
		<aui:input class ="form-control" name="city" label="City/District" style="border-radius:12px;border-bottom:3px solid #7FBD2C;">
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
        </aui:input>
		
		<aui:input class ="form-control" name="state" label="State/Province" style="border-radius:12px;border-bottom:3px solid #7FBD2C;">
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
        </aui:input>
		
		<aui:input class ="form-control" name="pincode" label="Pincode"style="border-radius:12px;border-bottom:3px solid #7FBD2C;">
		<aui:validator name="required"/>
		<aui:validator name="maxLength">6</aui:validator>
		<aui:validator name="digit"/>
        </aui:input>
		
		<aui:input class ="form-control" name="country" label="Country" style="border-radius:12px;border-bottom:3px solid #7FBD2C;">
		<aui:validator name="required"/>
		<aui:validator name="alpha"/>
        </aui:input>
        
		<aui:input class ="form-control" name="email" label="Email ID" style="border-radius:12px;border-bottom:3px solid #7FBD2C;" >
		<aui:validator name="required"/>
		<aui:validator name="email"/>
        </aui:input>
        
		<aui:input class ="form-control" name="mobileNo" label="Mobile No." style="border-radius:12px;border-bottom:3px solid #7FBD2C;" >
		<aui:validator name="required"/>
		<aui:validator name="digit "/>
        </aui:input>
	
	<button type="submit" style="background-color: #0077A2;margin-left: 35%; border-radius:22px" >Send OTP</button>
	</div>
</aui:form>

