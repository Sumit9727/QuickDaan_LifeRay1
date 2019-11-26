 <%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
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
.avatar {
  vertical-align: middle;
  width: 200px;
  height: 200px;
  border-radius: 50%;
}
.addimage {
  width: 50px;
  height: 50px;
  margin-left: -88px;
  margin-top: 50px;
  
}
</style>


<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
	

</script>

<%
String Myself = renderRequest.getParameter("Myself");
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

UserRegistration userData = UserRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
%>

<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>
				

<portlet:actionURL name="BenificiaryRelationMyself" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">
	
	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>   Myself   </U><img src="/portal_content/arrow.png" alt="img"/></a></div></h3></center>
	<hr>
	
	<h1><center>Myself</center></h1>
	
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<input name="<portlet:namespace/>image" type="file" label="Display Photo : "></input>
	<hr>
	
	<aui:input name="name" label="Name : " value="<%= userData.getFULL_NAME() %>"></aui:input>
	<aui:input name="age" label="Age : " placeholder="Age"></aui:input>
	 <aui:input name="Gender" label="Name : " value="<%= userData.getGENDER() %>" />
	<aui:input name="location" label="Location : " placeholder="Ex.Bangaluru"></aui:input>
	
	<aui:button type="submit" value="Next"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	
</aui:form>