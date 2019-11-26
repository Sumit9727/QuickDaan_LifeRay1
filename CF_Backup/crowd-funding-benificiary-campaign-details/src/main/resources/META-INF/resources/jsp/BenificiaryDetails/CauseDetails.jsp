<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>


</style>

<script type="text/javascript">
$(function() {
	  $('#blank').click(function(){
	    $('#textValue').show();
	    $('#blank').hide();
	  });
	});
	
function myFunction() {
	document.getElementById("btn").style.color = "red";
	  document.getElementById("textValue").value = document.getElementById("btn").value;
	}
</script>

<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="causeData" var="causeDataURL" />

<aui:form action="${causeDataURL}" method="post">

<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<h1>I am raising funds for a/an <u><div id="textValue"> __________<img src="/portal_content/arrow.png" alt="img"/></div></u> cause</h1>

<div>
<aui:input name="btn" label="Medical" type="radio" value="Medical" onclick="myFunction()"></aui:input>
<aui:input name="btn" label="Education" type="radio" value="Education" onclick="myFunction()"></aui:input><br>
<aui:input name="btn" label="Memorial" type="radio" value="Memorial" onclick="myFunction()"></aui:input>
<aui:input name="btn" label="Others" type="radio" value="Others" onclick="myFunction()"></aui:input>
</div>

<aui:button type="submit" value="Next"/>

</aui:form>


