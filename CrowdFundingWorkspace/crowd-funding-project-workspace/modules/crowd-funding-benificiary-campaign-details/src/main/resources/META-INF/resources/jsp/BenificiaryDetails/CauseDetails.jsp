 <%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>

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
.CauseDetails {
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

<script type="text/javascript">
$(function() {
	  $('#blank').click(function(){
	    $('#textValue').show();
	    $('#blank').hide();
	  });
	});
	
function myFunction() {
	document.getElementById("btn").style.color = "red";
	  document.getElementById("textValue").value = document.getElementById("btn").value;
	}
</script>
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

<%
String benificiaryID = renderRequest.getParameter("benificiaryID");
BenificiaryRegistration registration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(Long.parseLong(benificiaryID));
%>

<portlet:actionURL name="causeData" var="causeDataURL" />

<aui:form action="${causeDataURL}" method="post">

<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>
<div class ="CauseDetails" >
<h4>Cause Details </h4>
<hr>
<div>
 <aui:option selected="true" value=""></aui:option>
 <div class="inline1"><aui:input name="btn" label="Medical" checked="true" type="radio" value="Medical" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline1"><aui:input name="btn" label="Education"  type="radio" value="Education"  onclick="myFunction()"></aui:input></div>
<br>
 <div class="inline2"><aui:input name="btn" label="Community Development" type="radio" value="CommunityDevelopment" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline2"><aui:input name="btn" label="Women Empowerment" type="radio" value="WomenEmpowerment" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline3"><aui:input name="btn" label="Health and Hygiene" type="radio" value="HealthandHygiene" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline3"><aui:input name="btn" label="Senior Citizens" type="radio" value="SeniorCitizens" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline4"><aui:input name="btn" label="Disabilities" type="radio" value="Disabilities" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline4"><aui:input name="btn" label="Hunger" type="radio" value="Hunger" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline5"><aui:input name="btn" label="Environment" type="radio" value="Environment" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline5"><aui:input name="btn" label="Children Welfare" type="radio" value="ChildrenWelfare" onclick="myFunction()"></aui:input></div>
<br>
<div class="inline6"><aui:input name="btn" label="Sanitation" type="radio" value="Sanitation" onclick="myFunction()"></aui:input></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class="inline6"><aui:input name="btn" label="Animals" type="radio" value="Animals" onclick="myFunction()"></aui:input></div>
<br>

<br>
<br>
<aui:button type="submit" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;margin-left: 205px;"/>
</div>
</div>
</div>
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
<aui:script use="aui-base" >

    var rules = {
        <portlet:namespace/> contactMethode: {
         required: true
        }
    };
    
    var fieldStrings = {
        <portlet:namespace/> contactMethode: {
            required: '<liferay-ui:message key="com.liferay.content.error" />'
        }
    };
    
    var validator1 = new A.FormValidator({
        boundingBox: document.<portlet:namespace />fm,
        fieldStrings: fieldStrings,
        rules: rules
    });
    
</aui:script>

 