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
<div class ="CauseDetails" >
<h4>Cause Details </h4>
<hr>
<div>
 <aui:option selected="true" value=""></aui:option>
 <div class="inline1"><aui:input name="btn" label="Medical" checked="true" type="radio" value="Medical" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline1"><aui:input name="btn" label="Education"  type="radio" value="Education"  onclick="myFunction()"></aui:input></div>
<br>
 <div class="inline2"><aui:input name="btn" label="Community Development" type="radio" value="CommunityDevelopment" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline2"><aui:input name="btn" label="Women's Empowerment" type="radio" value="WomenEmpowerment" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline3"><aui:input name="btn" label="Health and Hygiene" type="radio" value="HealthandHygiene" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline3"><aui:input name="btn" label="Senior Citizens" type="radio" value="SeniorCitizens" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline4"><aui:input name="btn" label="Disabilities" type="radio" value="Disabilities" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline4"><aui:input name="btn" label="Hunger" type="radio" value="Hunger" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline5"><aui:input name="btn" label="Environment" type="radio" value="Environment" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline5"><aui:input name="btn" label="Children Welfare" type="radio" value="ChildrenWelfare" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline6"><aui:input name="btn" label="Sanitation" type="radio" value="Sanitation" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline6"><aui:input name="btn" label="Animals" type="radio" value="Animals" onclick="myFunction()"></aui:input></div>
<br>

<br>
<br>
<aui:button type="submit" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;margin-left: 205px;"/>
</div>
</div>
</div>
</div>
</aui:form>
<aui:script use="aui-base" >

    var rules = {
        <portlet:namespace/> contactMethode: {
         required: true
        }
    };
    
    var fieldStrings = {
        <portlet:namespace/> contactMethode: {
            required: '<liferay-ui:message key="com.liferay.content.error" />'
        }
    };
    
    var validator1 = new A.FormValidator({
        boundingBox: document.<portlet:namespace />fm,
        fieldStrings: fieldStrings,
        rules: rules
    });
    
</aui:script>

 