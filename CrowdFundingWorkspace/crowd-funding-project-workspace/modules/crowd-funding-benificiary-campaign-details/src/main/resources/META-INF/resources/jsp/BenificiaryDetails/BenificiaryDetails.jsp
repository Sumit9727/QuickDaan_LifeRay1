<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@ include file="/init.jsp" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

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
}
    /* this is for nav bar  */
.topnav {
	width: 100%;
	overflow: hidden;
	background-color: #0077A2;
	border-bottom: 5px solid white;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 25px;
	text-decoration: none;
	font-size: 1.2vw;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

.topnav {
	overflow: hidden;
}

.dropdown1 {
	float: left;
	overflow: hidden;
}

.dropdown1 .dropbtn1 {
	font-size: 1.2vw;
	border: none;
	outline: none;
	color: white;
	padding: 14px 19px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown-content1 {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content1 a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content1 a:hover {
	background-color: #ddd;
}

.dropdown1:hover .dropdown-content1 {
	display: block;
}

#demo-2 input[type=search] {
	width: 15px;
	padding-left: 10px;
	color: transparent;
	cursor: pointer;
}

#demo-2 input[type=search]:hover {
	background-color: #fff;
}

#demo-2 input[type=search]:focus {
	padding: 10px 30px;
	width: 130px;
	padding-left: 32px;
	color: #000;
	background-color: #fff;
	cursor: auto;
}

#demo-2 input:-moz-placeholder {
	color: transparent;
}

#demo-2 input::-webkit-input-placeholder {
	color: transparent;
}

input {
	outline: none;
}

input[type=search] {
	-webkit-appearance: textfield;
	-webkit-box-sizing: content-box;
	font-family: inherit;
	font-size: 100%;
}

input::-webkit-search-decoration, input::-webkit-search-cancel-button {
	display: none;
}

input[type=search] {
	margin-top: 2px;
	background: #ededed
		url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png)
		no-repeat 9px center;
	border-bottom: solid 1px #ccc;
	border-top: solid 1px #ccc;
	border-left: solid 1px #ccc;
	border-right: solid 1px #ccc;
	padding: 15px 0px 9px 0px;
	width: 43px;
	-webkit-border-radius: 10em;
	-moz-border-radius: 10em;
	border-radius: 10em;
	-webkit-transition: all .5s;
	-moz-transition: all .5s;
	transition: all .5s;
}

input[type=search]:focus {
	padding: 10px 30px;
	width: 30%;
	background-color: #fff;
	border-color: #66CC75;
	-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
	-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);
	box-shadow: 0 0 5px rgba(109, 207, 246, .5);
}

input:-moz-placeholder {
	color: #999;
}

input::-webkit-input-placeholder {
	color: #999;
}

/*end of nav bar  */
.portlet-decorate .portlet-content {
    background-color: #FFF;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
     padding: 0px;
}
.control-menu-level-1 {
    background-color: #30313F;
    color: #869CAD;
    visibility: hidden;
}
.portlet-decorate .portlet {
    margin-bottom: 24px;
    margin-top: -74px;
}
/*code for footer*/
.column {
	float: left;
	width: 25%;
	padding: 45px;
	height: auto;
	text-align: justify;
	/* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

.addressp {
	color: white;
	font-size: 1.2vw;
}
}
.BenificiaryDetails {
    border: 1px solid white;
    box-shadow: 0 0 10px 1px white;
    border-style: solid;
    border-color: white;
    margin-top: -4px;
    background-color: white;
    margin: 40px;
    padding: 50px;
    width: 813px;
    margin-left: 15%;
    border-top: 3px solid white;
    border-right: 3px solid white;
        margin: auto;
    
}
/*code for footer ends*/
    
    
</style>


<script>
 $(document).ready(function(){
	    $("#inputTextBox1").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});
 
 
 $(document).ready(function(){
	    $("#inputTextBox2").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});

 
 
 $(document).ready(function(){
	    $("#inputTextBox3").keypress(function(event){
	        var inputValue = event.which;
	        // allow letters and whitespaces only.
	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	            event.preventDefault(); 
	        }
	    });
	});

 
 
 
</script> 


<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>
<% List<CategoryRegistration> categoryRegistration = CategoryRegistrationLocalServiceUtil.getCategoryRegistrations(0, CounterLocalServiceUtil.getCountersCount()); %>
<html>
	<body>
	<div class="header">
		<a href="/web/quickdaan-home-page/home"><img src="\portal_content\QuickDaan_Logo.png" class="logoimg" style="width: 50%"></a>
		<div class="topnav" id="navbar">
			<div class="dropdown1"><button class="dropbtn1">Categories <i class="fa fa-caret-down"></i></button>
				
				<div class="dropdown-content1"><a href="#">Community Welfare</a> <a href="#">Rural Development</a> <a href="#">Inclusivity</a> <a href="#">Environmental Sustainability</a> <a href="#">Education</a> <a href="#">Emergencies</a> <a href="#">Medical</a> <a href="#">Animals</a> <a href="#">Children</a> <a href="#">Sports</a> <a href="#">Senior Citizens</a> <a href="#">Women</a> <a href="#">Social Entrepreneurship</a> <a href="#">Others</a></div> 
				<div class="dropdown-content1">
				 <% for(CategoryRegistration categoryDetails : categoryRegistration){
					%>
					<portlet:renderURL var="CategoryURL" windowState="normal">
						<portlet:param name="CategoryId" value="<%= String.valueOf(categoryDetails.getCATEGORY_ID()) %>" />
						<portlet:param name="jspPage"value="/jsp/HomePage/CategoryList.jsp" />
					</portlet:renderURL>
					
					<a href="${CategoryURL}"><%= categoryDetails.getCATEGORY_NAME() %></a>
					
					
					<%	} %>
					</div>
			</div>
			<a href="/web/crowd-funding/fund-raise-request">Start a Fundraisers</a> <a href="#section4">How it works</a> <a href="">Find Fundraisers</a> <a href="/web/crowd-funding/campaigns">Donate now</a>
			<% 
			ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			boolean signedIn = themeDisplayObj.isSignedIn();
			System.out.println("here "+signedIn);
			if(signedIn==false){
			%>
			<a href="/web/customelogin" style="background: #7FBD2C;float:right">LOGIN</a>
			 <a href="/web/customelogin/registration" style="background: #7FBD2C;float:right">SIGNUP</a>
			<%
			}else{
			%>
				<a href="/web/crowd-funding/campaign">My Campaign</a>
				<% User userDetails = themeDisplayObj.getUser();
				if(userDetails.getUserId() == 36035){
					%>
					<a href="/web/crowd-funding/campaign-approval">Admin</a>
					<%
				}
				%>
				<a href="/c/portal/logout" style="background: #7FBD2C;float:right">LOGOUT</a>
			<%
			}
			%>
			<input type="search" />
		</div>
	</div>
<portlet:actionURL name="BenificiaryDetails" var="BenificiaryDetailsURL" />

<aui:form action="${BenificiaryDetailsURL}" method="post" enctype="multipart/form-data">
<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>

<div class ="BenificiaryDetails">
       <h1>Benificiary Details</h1>
       <br>
       <hr>
       
<aui:input cssClass="borderForm" name="addressline1" label="AddressLine1"  >
<aui:validator name="required" />
</aui:input>

<aui:input cssClass="borderForm" name="addressline2" label="AddressLine2">
<aui:validator name="required" />
</aui:input>

 <strong>City</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<aui:input cssClass="borderForm" id="inputTextBox1" label="" required="required"  name="city" style="padding: 5px;"  >
</aui:input>

  <strong>State </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<aui:input cssClass="borderForm" id="inputTextBox2" required="reSquired"  name="state" label="" style="padding: 5px;"></aui:input>

  <aui:input cssClass="borderForm" name="pincode" label="Pincode " onkeypress="pincode()" minlength="6" maxlength="6" pattern="^\d{6}$" title="Format: Minium of 6 numbers is required">
  <aui:validator name="required"/>
  <aui:validator name="number"/>
  </aui:input>
 
  <strong>Country </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<aui:input  cssClass="borderForm" id="inputTextBox3" required="required"  name="Country" label="" style="padding: 5px;" >
	</aui:input>
 
 
 
<aui:input type="textarea" cssClass="borderForm" name="emergencyContact" label="Emergency Contact Details" >
<aui:validator name="required" /></aui:input>

<aui:input cssClass="borderForm" name="emergencyContactNumber" label="Alternet Contact Number:" onkeypress="phoneno()" minlength="10" maxlength="10" pattern="[0-9]{1}[0-9]{9}" title="Format:Minimum of 10 number is required">
<aui:validator name="required"/>
<aui:validator name="minLength" />
<aui:validator name="number"></aui:validator>
</aui:input>

<div style="margin-left: 235px;"><aui:button type="submit" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;" ></aui:button>

<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
</div>
		<div class="footer" style="background-color: #002a3a;">
		<!--start of footer-->
		<div class="row">
			<div class="column" style="font-size: 1.2vw; color: white">
				<a href="about_us.html" style="color: white;">About</a><br /> <a
					href="about_us.html" style="color: white;">Overview</a><br /> <a
					href="about_us.html" style="color: white;">Team</a><br /> <a
					href="PrivacyPolicy.html" style="color: white;">Privacy Policy</a><br />
				<a href="Disclaimer.html" style="color: white;">Terms &amp;
					Conditions</a>
			</div>

			<div class="column" style="font-size: 1.2vw; color: white">
				<a href="Security.html" style="color: white;">Security</a><br /> <a
					href="#" style="color: white;">Fundraising Tips</a><br /> <a
					href="#" style="color: white;">Pricing</a><br /> <a href="#"
					style="color: white;">Fundraising FAQ's</a><br /> <a href="#"
					style="color: white;">Donate Now</a>
			</div>

			<div class="column" style="font-size: 1.2vw; color: white">
				<a href="#" style="color: white;">Start a Fundraiser</a><br /> <a
					href="#" style="color: white;">ADDRESS</a><br /> &nbsp;
				<p class="addressp" style="line-height: 1px; font-size: 1vw;">184
					&amp; 185, EPIP Zone,</p>

				<p class="addressp" style="line-height: 1px; font-size: 1vw;">Whitefield,
					Bengaluru,</p>

				<p class="addressp" style="line-height: 1px; font-size: 1vw;">Karnataka
					560066</p>
			</div>

			<div class="column" style="font-size: 1.2vw; color: white">
				<a href="#" style="color: white;">CONTACT US</a><br /> &nbsp;
				<p class="addressp" style="line-height: 1px; font-size: 1vw;">Phone:
					080818 80033</p>

				<p class="addressp" style="line-height: 1px; font-size: 1vw;">quickdaan@gmail.com</p>
			</div>
		</div>
	</div>
</aui:form>