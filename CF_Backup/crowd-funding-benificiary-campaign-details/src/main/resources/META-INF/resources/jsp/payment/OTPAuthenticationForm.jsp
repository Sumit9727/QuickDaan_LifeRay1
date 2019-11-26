<%@ include file="/jsp/payment/init.jsp" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<portlet:defineObjects />


<%
String ProjectId = renderRequest.getParameter("ProjectId");
System.out.println("ProjectId ::: " + ProjectId);
%>

<portlet:actionURL name="emailMobileRegistration" var="emailMobileRegistrationURL" />

<aui:form action="${emailMobileRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<aui:input name="email" label="Email ID" />
	<aui:input name="mobileNo" label="Mobile No." />
	
	<button type="submit" >Send OTP</button>
</aui:form>

