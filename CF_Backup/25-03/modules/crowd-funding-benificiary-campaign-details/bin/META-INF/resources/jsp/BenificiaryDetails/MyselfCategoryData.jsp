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
.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
 width: 572px;
    margin-left: 298px;
 }
 
     .control-label{
display: inline-block;

 }
    h1{
         color:#9c3353;
         margin-left: 209px;
        }
        
        .text-dark {
    color: #272834 !important;
    margin-left: -12px;
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
	
	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>   Myself   </U></a></div></h3></center>
	<hr>
	<div class="a">
	<h1>Myself</h1>
	
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<aui:input name="image" type="file" label="Display Photo : " style="margin-right: -9px;"><aui:validator name="required"></aui:validator></aui:input>
	<hr>
	
	<aui:input name="name:" label="Name : " style="border-radius: 14px; background-color: white;width: 349px; margin-left: 91px; margin-top: -32px; height: 29px; color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " value="<%= userData.getFULL_NAME() %>"><aui:validator name="required" /></aui:input>
	<aui:input name="age" label="Age : "  style="border-radius: 14px; background-color: white; margin-top: -32px; height: 29px; margin-left: 91px; width: 349px;  color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " placeholder="Age"><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="max">140</aui:validator></aui:input>
	 <aui:input name="Gender" label="Gender : "  style="border-radius: 14px; background-color: white; height: 29px;  margin-top: -32px; width: 349px; margin-left: 91px;   color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " value="<%= userData.getGENDER() %>" ><aui:validator name="required" /></aui:input>
	<aui:input name="location" label="Location : "  style="border-radius: 14px; background-color: white; height: 29px;   margin-top: -32px; width: 349px;margin-left: 91px;  color:black; box-shadow: 0 0 7px rgba(31,156,51,.32549); " placeholder="Ex.Bangaluru"><aui:validator name="required" /></aui:input>
	
	<aui:button type="submit" value="Next" style="color:black; background-color:green"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	</div>
	
	
</aui:form>