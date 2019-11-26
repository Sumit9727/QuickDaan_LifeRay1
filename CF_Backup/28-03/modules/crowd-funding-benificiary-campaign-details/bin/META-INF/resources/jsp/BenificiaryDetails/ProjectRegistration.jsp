<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/init.jsp" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
 <script>
  $(function() {
    $( "#datepicker" ).datepicker({
    	dateFormat:'dd/mm/yy',
    	changeMonth: true,
		changeYear: true,
		yearRange: "1970:2070",
		minDate: new Date()
    });
  });
 </script>
<%-- <style>
.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 806px;
    margin-left: 161px;
 }
      h1{
      color:#9c3353;
     margin-left: 304px;
     }
 </style>
 --%>
 <aui:script use="liferay-auto-fields">
 var counting=1;
 		 var autoFields= new Liferay.AutoFields(
 	        {
 	            contentBox: '#document-fields',
 	            fieldIndexes: '<portlet:namespace />documentIndex'
 	           
 	        });
 		 autoFields.on("clone", function(newField) {
 			 counting = counting+1;
 			 clearFieldData(counting);
 				
         });
 		 autoFields.render();
</aui:script>
  
<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
ThemeDisplay themeDisplayUser = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
User  userDetail = themeDisplayUser.getUser();
%>

<portlet:actionURL name="ProjectRegistrationDetails" var="ProjectRegistrationDetailsURL" />

<aui:form action="${ProjectRegistrationDetailsURL}" method="post" enctype="multipart/form-data">
	<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>
	<aui:input name="userID" value="<%= userDetail.getUserId() %>" type="hidden"></aui:input>
	<div class="ProjectRegistration">
	<h1>Project Registration</h1>
	<br>
	<hr>
	<aui:input cssClass="borderForm" name="title" label="Title  "  type="text"><aui:validator name="required" /></aui:input>
	
	<strong>User Story</strong><br>
	<liferay-ui:input-editor name="description"   placeholder="Write you story here..." initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	<br>
	
	<strong>Campaign Document</strong>
	<br>
	<div id="document-fields">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				<input Class="DocumentName"fieldParam='documentName0' required="required" id='<portlet:namespace/>documentName0' placeholder="Document Name" name="<portlet:namespace/>documentName0"  type="text"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input fieldParam='documentFile0' required="required"  id='<portlet:namespace/>documentFile0' name="<portlet:namespace/>documentFile0" type="file" />
			</div>
		</div>
	</div>
	
	
	<aui:input name="videoFile" type="file"></aui:input>
	<hr>
	 <strong>End Date  </strong>
	<input Class="Datepicker"type="text" id="datepicker" required="required"  name="<portlet:namespace/>enddate" label="Campaign End Date :" ></input>
	<hr>
			
	<aui:input cssClass="borderForm" name="requiredFundAmt" label="Required Fund Amount  "  type="text"><aui:validator name="number" /><aui:validator name="numeric"/><aui:validator name="required"></aui:validator></aui:input>
					
	<div style="margin-left: 235px;"><aui:button type="submit" value="Next"  style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
	<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
	</div>
</aui:form>
	