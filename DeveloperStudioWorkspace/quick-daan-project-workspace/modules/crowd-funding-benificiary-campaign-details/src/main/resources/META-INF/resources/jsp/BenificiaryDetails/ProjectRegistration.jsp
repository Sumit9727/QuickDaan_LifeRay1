<%-- <%@page import="com.liferay.portal.kernel.model.User"%>
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
	<input Class="Datepicker" type="text" id="datepicker" required="required"  name="<portlet:namespace/>enddate" label="Campaign End Date :" ></input>
	  <input type="date" id="datepicker" required="required"  name="<portlet:namespace/>enddate" label="Campaign End Date :" ></input> 
	<hr>
			
	<aui:input cssClass="borderForm" name="requiredFundAmt" label="Required Fund Amount  "  type="text"><aui:validator name="number" /><aui:validator name="numeric"/><aui:validator name="required"></aui:validator></aui:input>
					
	<div style="margin-left: 235px;"><aui:button type="submit" value="Next"  style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
	<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
	</div>
</aui:form>
	 --%>
	 
	 
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



	 <style>
	 .bordercity{
	 	border-radius: 9px;
	 	border: 1px solid #7FBD2C;
	 	border-bottom: 3px solid #7FBD2C;
	 	background-color:#e7e7ed;
	 	width: 704px;  
	 	margin-top: 1px;
	 	height: 43px;
	     background-color: whitesmoke;
	     
	     }
	     
	     strong {
	     color: #0077A2;
	     font-size: 13px;
	 }
	     .portlet-decorate .portlet-content {
	     background-color: #5d5d5d29;
	     border: 1px solid #E7E7ED;
	     border-radius: 0.5rem;
	     padding: 24px;
	 }
	     
	 </style>

	 <!-- <script>
	  $(document).ready(function(){
	 	    $("#inputTextBox4").keypress(function(event){
	 	        var inputValue = event.which;
	 	        // allow letters and whitespaces only.
	 	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	 	            event.preventDefault(); 
	 	        }
	 	    });
	 	});
	  </script>
	  -->
	  
<script type="text/javascript">
$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
    $('#txtDate').attr('min', maxDate);
});
</script>


	   
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
	 	
	 	<aui:input cssClass="borderForm" name="title" maxlength="100" label="Title  "  type="text">
	 	<aui:validator name="max">100</aui:validator><aui:validator name="required" /></aui:input>
	 	
	 	<%-- <aui:input cssClass="borderForm" name="title" label="Title"  maxlength="100" style="font-size:1rem">	
	 	<aui:validator name="required"/>
	 	<aui:validator name="alphanum"/>
	 	</aui:input> 
	 	 --%>
	 	<!-- <strong>Title</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	 	<br>
	 	<input Class="bordercity" id="inputTextBox4" required="required"  name="title"  maxlength="100" style="padding:5px;" >
	 	 </input>
	 	 <br>
	 	 <br> -->
	  
	 	<strong>User Story</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span><br>
	 	<liferay-ui:input-editor name="description" placeholder="Write you story here..." initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	 	<br>
	 	
	 	<strong>Campaign Document</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	 	<br>
	 	<div id="document-fields">
	 		<div class="lfr-form-row lfr-form-row-inline">
	 			<div class="row-fields" style="display: flex;">
	 				
	 				<input Class="DocumentName"fieldParam='documentName0' required="required" id='<portlet:namespace/>documentName0' placeholder="Document Name" name="<portlet:namespace/>documentName0" style="padding:5px;" type="text"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input fieldParam='documentFile0' required="required"  id='<portlet:namespace/>documentFile0' name="<portlet:namespace/>documentFile0" type="file" 
	                            accept=".pdf, .doc, .docx, .ppt, .pptx, .pps, .ppsx, .odt, .xls, .xlsx " />
	 			</div>
	 		</div>
	 	</div>
	 	
	 	<aui:form action="uploadAction" method="post" enctype="multipart/form-data" onsubmit="return validation(this)">
	 	
	  
	 	<%-- <strong>Video File</strong>
	 	<aui:input class="vidFile" name="Video File"  type="file" accept="video/*"></aui:input> --%>
	 	
	 	<strong>Video File</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	 	<p><label> <input type="file" name="videoFile"  accept="video/*"></label></p>
	 	</aui:form> 
	 	
	 	 <strong>EndDate  </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span><br>
	 	 <input type="date" id="txtDate" required="required"  name="<portlet:namespace/>enddate"  label=""
	 	style="width: 700px;
	     border-radius: 10px;
	     border-color: #7FBD2C;
	     border-bottom: 3px solid #7FBD2C;
	     height: 45px;
	     padding:1rem;
	     background-color: whitesmoke;
	     border-top:1px solid #7FBD2C;
	     border-left:1px solid #7FBD2C;" ><br></br>
	 	
	 	  </input>

	     <%-- <strong>Required Fund Amount </strong>
	 	<aui:input cssClass="borderForm" name="requiredFundAmt" label="" min="1">
	 	<aui:validator name="required"/>
	 	<aui:validator name="number"></aui:validator>
	 	</aui:input> --%>
	 		 
	 		 		
	 	<aui:input cssClass="borderForm" name="requiredFundAmt" min="1" max="100000000" label="Required Fund Amount"  type="number" >
	 	 <aui:validator name="required"/>
	 	 <%-- <aui:validator maxlength="8"/> --%>
	      </aui:input>	
	 		
	 					
	 	<div style="margin-left: 235px;"><aui:button type="submit" value="Next"  style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
	 	<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
	 	</div>
	 	</aui:form>
	 </div>
	 