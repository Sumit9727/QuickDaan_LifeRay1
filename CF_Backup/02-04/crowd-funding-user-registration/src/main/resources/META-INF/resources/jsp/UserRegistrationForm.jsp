<%-- <%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/init.jsp" %>
<portlet:defineObjects />

<%
/* long UserOtpId = Long.parseLong(renderRequest.getParameter("UserOtpId")); */
long UserOtpId = 0;
%> 

<portlet:actionURL name="userRegistration" var="userRegistrationURL">
</portlet:actionURL>contactNo

<aui:form action="${userRegistrationURL}" method="post" >
	
	<aui:input name="UserOtpId" type="hidden" value="<%= UserOtpId %>" />
	<aui:input name="firstName" label="First Name" />
	<aui:input name="lastName" label="Last Name" />
	<aui:input type="password" name="password" label="Password" />
	<aui:select label="Gender" name="gender" >
		<aui:option label="Male" value="Male" />
		<aui:option label="Female" value="Female" />
	</aui:select>
	
	<aui:button name="submit" type="submit" value="submit" />
	
</aui:form> --%>

<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/init.jsp" %>
<portlet:defineObjects />


<%
long UserOtpId = Long.parseLong(renderRequest.getParameter("UserOtpId")); 
%> 

<portlet:actionURL name="userRegistration" var="userRegistrationURL">
</portlet:actionURL>

<aui:form action="${userRegistrationURL}" method="post" >

<div class="UserRegistration"style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<center><h1 style="color:#0077A2">USER REGISTRATION </h1></center><br>

	
	<aui:input name="UserOtpId" type="hidden" value="<%= UserOtpId %>" />
	
	<aui:input cssClass="boxborder" name="firstName" label="First Name" style="border-bottom:3px solid #7FBD2C;" >
	<aui:validator name="required"/>
    <aui:validator name="alpha"/>
    </aui:input>
   
	<aui:input cssClass="boxborder" name="lastName" label="Last Name" style="border-bottom:3px solid #7FBD2C;" >
    <aui:validator name="required"/>
    <aui:validator name="alpha"/>	
    </aui:input>

	<aui:input cssClass="boxborder"  type="password" name="password" label="Password" style="border-bottom:3px solid #7FBD2C;" >
	<aui:validator name="required"/>
    <aui:validator name="alphanum"/>	
    </aui:input>
	
	
	<aui:select cssClass="boxborder"  label="Gender" name="gender" style="border-bottom:3px solid #7FBD2C;" > 
		<aui:option label="Male" value="Male" style="margin-left: 86px; margin-top: -26px;"/>
		<aui:option label="Female" value="Female" style="margin-left: 86px; margin-top: -26px;"/>
	</aui:select>
	
	<center><aui:button name="submit" type="submit" value="submit" style="background-color:#0077A2;border-radius: 22px;color:white;width: 108px;height: 39px;"/></center>
	</div>
</aui:form>