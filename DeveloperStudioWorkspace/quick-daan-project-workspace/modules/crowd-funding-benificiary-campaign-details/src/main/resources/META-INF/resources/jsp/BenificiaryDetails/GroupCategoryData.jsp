<%-- <%@ include file="/init.jsp" %>

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


<style>
  
   .portlet-contentImg{
   margin-left:100px;
   margin-top:10px;
}

.switch1 {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch1 input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider1 {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider1:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider1 {
  background-color: #2196F3;
}

input:focus + .slider1 {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider1:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider1.round {
  border-radius: 34px;
}

.slider1.round:before {
  border-radius: 50%;
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
</aui:form> --%>



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

 <style>
.bordercity{
	border-radius: 9px;
	border: 1px solid #7FBD2C;
	border-bottom: 3px solid #7FBD2C;
	background-color:#e7e7ed
	height: 43px;
	width: 704px;  
	margin-top: 1px;
	height: 43px;
    background-color: whitesmoke;
    
    
    
    strong {
    color: #0077A2;
    font-size: 13px;
}
</style>

<style>
   .portlet-decorate .portlet-content {
    background-color: #5d5d5d29;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 24px;
   
    
</style>


<script>
 $(document).ready(function(){
	    $("#inputTextBox10").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});
 
 
 
 $(document).ready(function(){
	    $("#inputTextBox11").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});
 
 
 
 $(document).ready(function(){
	    $("#inputTextBox12").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});
 function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();

	        reader.onload = function (e) {
	            $('#blah')
	                .attr('src', e.target.result)
	                .width(150)
	                .height(200);
	        };

	        reader.readAsDataURL(input.files[0]);
	    }
	}
</script>




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
	<img src="/portal_content/download.jpg" alt="img" id ="blah" class="avatar">
		<div style=" margin-left:202px; margin-top:-139px;">
		<aui:input  name="image" type="file" accept="image/*" label="Display Photo : " onchange="readURL(this);" style="margin-right: -9px;"><aui:validator name="required"></aui:validator></aui:input></div>
	<br>
	<br>
	<hr>
	
	
	<%-- <aui:input  cssClass="borderForm"  name="groupName" pattern="[a-zA-Z\s]+" label="Group Name  " >
	<aui:validator name="required" /><aui:validator name="" />
	</aui:input> --%>
	
	<strong>Group Name</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox10" required="required"  name="groupName"  maxlength="100" style="padding:5px;" >
	 </input>
	 <br>
	 <br>
	
	
	
	
	<aui:input  cssClass="borderForm" name="member" label="No. of members" maxlength="4">
	<aui:validator name="required" />
	<aui:validator name="number"/>
	<aui:validator name="min">1</aui:validator>
	<aui:validator name="max">1000</aui:validator>
	</aui:input>
	
	<%-- <aui:input  cssClass="borderForm" name="location" label="Location  "  placeholder="Ex.Bangaluru">
	<aui:validator name="required" />
	</aui:input> --%>
	
	<strong>Location</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox11" required="required"  name="location"  maxlength="100" style="padding:5px;" >
	 </input>
	 <br>
	 <br>
	
	
	
	<hr><div><strong>Contact details</strong></div><br>
	
	<%-- <aui:input  cssClass="borderForm" name="name" label="Name " pattern="[a-zA-Z\s]+"  >
	<aui:validator name="required" />
	<aui:validator name="alpha"/>
	</aui:input> --%>
	
	<strong>Name</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox12" required="required"  name="Name"  maxlength="100" style="padding:5px;" >
	 </input>
	 <br>
	 <br>
	
	
	<aui:input  cssClass="borderForm" name="number" label="Mobile Number " onkeypress="phoneno()" minlength="10" maxlength="10" pattern="[0-9]{1}[0-9]{9}" title="Format:Minimum of 10 number is required"  >
	<aui:validator name="required" />
	<aui:validator name="number" />
	</aui:input>
	
	<div style="margin-left: 235px;"><aui:button type="submit"style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"value="Next" ></aui:button>
	
	<aui:button type="cancel" value="cancel"style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" />
	</div></div></div></div></div></div>
</div>
</aui:form>
