<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

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
	<aui:input name="title" label="Title : " type="text"></aui:input>
	User Story : 
	<liferay-ui:input-editor name="description" placeholder="Write you story here..." initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	
	Document : 
	<div id="document-fields">
		<div class="lfr-form-row lfr-form-row-inline">
			<div class="row-fields" style="display: flex;">
				Document name :
				<input fieldParam='documentName0' id='<portlet:namespace/>documentName0' placeholder="Document Name" name="<portlet:namespace/>documentName0" type="text"/>
				Document File :
				<input fieldParam='documentFile0' id='<portlet:namespace/>documentFile0' name="<portlet:namespace/>documentFile0" type="file" />
			</div>
		</div>
	</div>
				
				
	<aui:input name="requiredFundAmt" label="Required Fund Amount : " type="text"></aui:input>
					
	<aui:button type="submit" value="Next"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>
	