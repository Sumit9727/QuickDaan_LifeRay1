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
   <style>
 .a {
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
<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<div class ="a">
       <h1>Benificiary Details</h1>
       <br>
<aui:input name="addressline1" label="AddressLine1 : " style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " ><aui:validator name="required" /></aui:input>
<aui:input name="addressline2" label="AddressLine2 : "style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>

 <aui:input name="city" label="City : " style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
  <aui:input name="state" label="State : " style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
  <aui:input name="pincode" label="Pincode : " style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
 <aui:input name="Country" label="Country : " style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
 
<aui:input type="textarea" name="emergencyContact" label="Emergency Contact Details : " style="border-radius: 14px; background-color: white;width: 313px; margin-left: 189px; margin-top: -32px; height: 98px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="required" /></aui:input>
<aui:input name="emergencyContactNumber" label="Alternet Contact Number : " style="border-radius: 14px; background-color: white;width: 313px;margin-left: 189px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); "><aui:validator name="minLength">10</aui:validator></aui:input>

<aui:button type="submit" value="Next" style="color:black; background-color:green" ></aui:button>
<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</div>
</aui:form>