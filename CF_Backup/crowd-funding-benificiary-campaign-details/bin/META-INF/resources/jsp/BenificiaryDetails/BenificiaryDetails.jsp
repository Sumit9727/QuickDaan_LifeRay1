<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
 
<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<aui:input name="addressline1" label="AddressLine1 : "></aui:input>
<aui:input name="addressline2" label="AddressLine2 : "></aui:input>

 <aui:input name="city" label="City : "></aui:input>
  <aui:input name="state" label="State : "></aui:input>
  <aui:input name="pincode" label="Pincode : "></aui:input>
 <aui:input name="Country" label="Country : "></aui:input>
 
<aui:input type="textarea" name="emergencyContact" label="Emergency Contact Details : "></aui:input>
<aui:input name="emergencyContactNumber" label="Alternet Contact Number : "></aui:input>

<aui:button type="submit" value="Next"></aui:button>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />

</aui:form>