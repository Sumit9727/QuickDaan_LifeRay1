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

 <%--<style>
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
  --%>
  <style>
  
   .portlet-contentImg{
   margin-left:100px;
   margin-top:10px;
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
	
	<h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>   Myself   </U></a></div></h3>
	<hr>
	<div class="MyselfCategory">
	<h5>Myself</h5>
	<hr>
	
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<div style=" margin-left:202px; margin-top:-139px;"><aui:input  name="image" type="file" label="Display Photo  " style="margin-right: -9px;"><aui:validator name="required"></aui:validator></aui:input></div>
	<br>
	<br>
	<hr>
	
	<aui:input cssClass="borderForm" name="name:" label="Name  "  readonly="true"  value="<%= userData.getFULL_NAME() %>"><aui:validator name="required" /></aui:input>
	<aui:input  cssClass="borderForm" name="age" label="Age  "   placeholder="Age"><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="max">140</aui:validator></aui:input>
	 <aui:input  cssClass="borderForm" name="Gender" label="Gender  "  readonly="true" value="<%= userData.getGENDER() %>" ><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
	<aui:input cssClass="borderForm" name="location" label="Location  "   placeholder="Ex.Bangaluru"><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
	
	<div style="margin-left: 235px;"><aui:button type="submit"style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"value="Next" ></aui:button>
	<aui:button type="cancel" value="cancel"style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
	</div>
	
	
</aui:form>