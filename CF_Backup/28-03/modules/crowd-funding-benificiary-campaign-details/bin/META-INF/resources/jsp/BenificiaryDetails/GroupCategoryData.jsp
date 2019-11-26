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
<%-- 
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
    width: 550px;
    margin-left: 298px;
    padding: 11px;
   
}

.b {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 550px;
    margin-left: 298px;
    padding: 11px;
 
}
.c {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 550px;
    margin-left: 298px;
    padding: 11px;
   
}
    
    h1{
         color:#9c3353;
        }
        .text-dark {
    color: #272834 !important;
    margin-left: -12px;
}
</style>
--%>
<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
	    $('#' + $(this).val()).show();
	  });
	});
</script>

<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>

<portlet:actionURL name="BenificiaryRelationGroup" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">

	<% String Group = renderRequest.getParameter("Group"); %>
	
	<h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U><%= Group %></U></a></div></h3>
	<hr>
	
	<%
	if(Group.equalsIgnoreCase("FriendGroup")){
	%>
	<div>
     <div class ="GroupFriend">
		<h1>Group Friend</h1>
	<%
	}else if(Group.equalsIgnoreCase("OtherGroup")){
	%>
	<div>
	 <div class ="GroupOther">
		<h1>Group Other</h1>
		<hr>
	<%
	}if(Group.equalsIgnoreCase("FamilyGroup")){
	%>
	<div>
	 <div class ="GroupFamily">
		<h1>Group Family</h1>
		<hr>
	<%
	}
	%>
	
	
	<aui:input name="Group" type="hidden" value="<%= Group %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
		<div style=" margin-left:202px; margin-top:-139px;"><aui:input  name="image" type="file" label="Display Photo : " style="margin-right: -9px;"><aui:validator name="required"></aui:validator></aui:input></div>
	<br>
	<br>
	<hr>
	
	
	<aui:input  cssClass="borderForm" name="groupName" label="Group Name  " ><aui:validator name="required" /></aui:input>
	<aui:input  cssClass="borderForm" name="member" label="No. of member  " ><aui:validator name="number" /><aui:validator name="numeric"/><aui:validator name="required"></aui:validator></aui:input>
	<aui:input  cssClass="borderForm" name="location" label="Location  "   placeholder="Ex.Bangaluru"><aui:validator name="required" /></aui:input>
	
	<hr><div><strong>Contact details</strong></div><br>
	<aui:input  cssClass="borderForm" name="name" label="Name " ><aui:validator name="required" /></aui:input>
	<aui:input  cssClass="borderForm" name="number" label="Mobile Number  "  ><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="maxLength">10</aui:validator></aui:input>
	
	<div style="margin-left: 235px;"><aui:button type="submit"style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"value="Next" ></aui:button>
	<aui:button type="cancel" value="cancel"style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" />
	</div></div></div></div></div></div>
</aui:form>