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
   <%-- <style>
 a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
      width: 572px;
          margin-left: 298px;
}

 h1{
         color:#9c3353;
         margin-left: 186px;
        }
</style>
--%>
<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<div class ="BenificiaryDetails">
       <h1>Benificiary Details</h1>
       <br>
       <hr>
<aui:input cssClass="borderForm" name="addressline1" label="AddressLine1  "  ><aui:validator name="required" /></aui:input>
<aui:input cssClass="borderForm" name="addressline2" label="AddressLine2  "><aui:validator name="required" /></aui:input>

 <aui:input cssClass="borderForm" name="city" label="City  " ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
  <aui:input cssClass="borderForm" name="state" label="State  " ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
  <aui:input cssClass="borderForm" name="pincode" label="Pincode  " ><aui:validator name="required" /><aui:validator name="maxLength">6</aui:validator></aui:input>
 <aui:input cssClass="borderForm" name="Country" label="Country  " ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
 
<aui:input type="textarea" cssClass="borderForm" name="emergencyContact" label="Emergency Contact Details  "><aui:validator name="required" /></aui:input>
<aui:input cssClass="borderForm" name="emergencyContactNumber" label="Alternet Contact Number  " ><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="maxLength">10</aui:validator></aui:input>

<div style="margin-left: 235px;"><aui:button type="submit" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;" ></aui:button>
<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
</div>
</aui:form>