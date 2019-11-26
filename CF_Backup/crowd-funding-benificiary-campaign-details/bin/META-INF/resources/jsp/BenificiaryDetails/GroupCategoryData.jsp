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

<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>

<portlet:actionURL name="BenificiaryRelationGroup" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">

	<center><h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}">__________<img src="/portal_content/arrow.png" alt="img"/></a></div></h3></center>
	<hr>
	
	<%
	String Group = renderRequest.getParameter("Group");
	if(Group.equalsIgnoreCase("FriendGroup")){
	%>
		<h1><center>Group Friend</center></h1>
	<%
	}else if(Group.equalsIgnoreCase("OtherGroup")){
	%>
		<h1><center>Group Other</center></h1>
	<%
	}if(Group.equalsIgnoreCase("FamilyGroup")){
	%>
		<h1><center>Group Family</center></h1>
	<%
	}
	%>
	
	
	<aui:input name="Group" type="hidden" value="<%= Group %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<input name="<portlet:namespace/>image" type="file" label="Display Photo : "></input>
	<hr>
	
	<aui:input name="groupName" label="Group Name : "></aui:input>
	<aui:input name="member" label="No. of member : "></aui:input>
	<aui:input name="location" label="Location : " placeholder="Ex.Bangaluru"></aui:input>
	
	<hr><div>Contact details</div><br>
	<aui:input name="name" label="Name : "></aui:input>
	<aui:input name="number" label="Mobile Number : "></aui:input>
	
	<aui:button type="submit" value="Next"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	
</aui:form>