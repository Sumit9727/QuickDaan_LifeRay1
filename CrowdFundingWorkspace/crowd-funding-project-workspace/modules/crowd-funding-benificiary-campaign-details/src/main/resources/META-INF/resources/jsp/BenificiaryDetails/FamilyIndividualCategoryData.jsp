<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@ include file="/init.jsp" %>

<%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.a {
	box-shadow: 0 0 10px 1px #d3d3d3;
	border: 1px solid #cecece;
	border-style: solid;
	padding: 40px;
	background-color: white;
	width: 550px;
	margin-left: 298px;
	padding: 11px;
}

h1 {
	color: #9c3353;
}

.text-dark {
	color: #272834 !important;
	margin-left: -12px;
}
</style>



<style>
.portlet-contentImg {
	margin-left: 100px;
	margin-top: 10px;
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

input:checked+.slider1 {
	background-color: #2196F3;
}

input:focus+.slider1 {
	box-shadow: 0 0 1px #2196F3;
}

input:checked+.slider1:before {
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
.IndividualFamily {
    box-shadow: white 0px 0px 10px 1px;
    background-color: white;
    width: 813px;
    border-width: 3px 3px 1px 1px;
    border-image: initial;
    border-style: solid;
    border-color: white;
    margin: 40px 40px 40px 15%;
    padding: 50px;
    border-top: 3px solid white;
    border-right: 3px solid white;
        margin: auto;
    
}

/*code for footer ends*/
</style>


<script type="text/javascript">
	var country_arr = new Array("Parents", "Sibling", "GrandParent",
			"GrandChild", "Child", "Spouse");

	var s_a = new Array();
	s_a[0] = "";
	s_a[1] = "Father|Mother|Parent";
	s_a[2] = "Brother|Sister|Cousin";
	s_a[3] = "GrandFather|GrandMother";
	s_a[4] = "GrandSon|GrandDaughter";
	s_a[5] = "Son|Daughter";
	s_a[6] = "";

	function print_country(country) {
		//given the id of the <select> tag as function argument, it inserts <option> tags
		var option_str = document.getElementById(country);
		option_str.length = 0;
		option_str.options[0] = new Option('Select Category', '');
		option_str.selectedIndex = 0;
		for (var i = 0; i < country_arr.length; i++) {
			option_str.options[option_str.length] = new Option(country_arr[i],
					country_arr[i]);
		}
	}

	function print_state(state, selectedIndex) {
		var option_str = document.getElementById(state);
		option_str.length = 0; // Fixed by Julian Woods
		option_str.options[0] = new Option('Select Relation', '');
		option_str.selectedIndex = 0;
		var state_arr = s_a[selectedIndex].split("|");
		for (var i = 0; i < state_arr.length; i++) {
			option_str.options[option_str.length] = new Option(state_arr[i],
					state_arr[i]);
		}
	}
</script>

<script type="text/javascript">
	$(function() {
		$('#colors').click(function() {
			$('#' + $(this).val()).show();
		});
	});

	function myFunction() {
		// Get the checkbox
		var checkBox = document.getElementById("myCheck");
		// Get the output text
		var text1 = document.getElementById("text1");
		var text2 = document.getElementById("text2");

		// If the checkbox is checked, display the output text
		if (checkBox.checked == true) {
			text1.style.display = "none";
			text2.style.display = "block";
		} else {
			text1.style.display = "block";
			text2.style.display = "none";
		}
	}

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result).width(150).height(200);
			};

			reader.readAsDataURL(input.files[0]);
		}
	}
</script>

<%
	String Individual = renderRequest.getParameter("Individual");
%>


<portlet:renderURL var="ViewImages" windowState="normal">
	<portlet:param name="jspPage"
		value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>


<portlet:actionURL name="BenificiaryRelationIndividualFamily"
	var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post"
	enctype="multipart/form-data">

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

	<%-- <h3>
		<div id="red" class="colors red">
			This fundraiser will benefit <a href="${ViewImages}"><U>Individual
					Family</U></a>
		</div>
	</h3> --%>
	

	<div class="IndividualFamily">
	<h1>Individual</h1>
		<hr>

		<aui:input name="Individual" type="hidden" value="<%=Individual%>"></aui:input>
		<img src="/portal_content/download.jpg" alt="img" id="blah"
			class="avatar">
		<div style="margin-left: 202px; margin-top: -139px;">
			<aui:input name="image" type="file" accept="image/*"
				onchange="readURL(this);" label="Display Photo  ">
				<aui:validator name="required"></aui:validator>
			</aui:input>
		</div>
		<br> <br>
		<hr>
		<aui:input cssClass="borderForm" name="name" label="Name  "
			placeholder="Name">
			<aui:validator name="required" />
		</aui:input>

		<strong>Relation Category </strong> <br> <select
			onchange="print_state('state',this.selectedIndex);" id="country"
			required="required" Class="borderForm3"
			name="<portlet:namespace/>Relationship"></select> <br /> <br /> <strong>Relation
			Type </strong> <select name="<portlet:namespace/>RelationshipDetails"
			id="state" Class="borderForm3" required="required"></select><br /> <br />
		<script language="javascript">
			print_country("country");
		</script>

		<strong>If Benificiary Age is less than 1 : </strong> <label
			class="switch1"> <input type="checkbox" id="myCheck"
			onclick="myFunction()"></input> <span class="slider1 round"></span>
		</label>

		<div id="text1">
			<strong>Benificiary Age Year : </strong>
			<aui:select cssClass="borderForm" name="ageYear" label="">
				<%
					for (int i = 1; i <= 100; i++) {
				%>
				<aui:option value="<%=i%>"><%=i%></aui:option>
				<%
					}
				%>
			</aui:select>
		</div>

		<div id="text2" style="display: none">
			<strong>Benificiary Age Month :</strong>
			<aui:select cssClass="borderForm" name="ageMonth" label="">
				<%
					for (int i = 1; i <= 12; i++) {
				%>
				<aui:option value="<%=i%>"><%=i%></aui:option>
				<%
					}
				%>
			</aui:select>
		</div>

		<aui:select cssClass="borderForm" name="Gender">
			<aui:validator name="required" />
			<aui:validator name="alpha" />
			<aui:option value="Male">Male</aui:option>
			<aui:option value="Female">Female</aui:option>
			<aui:option value="Others">Others</aui:option>
		</aui:select>
		<aui:input cssClass="borderForm" name="location" label="Location "
			placeholder="Ex.Bangaluru">
			<aui:validator name="required" />
			<aui:validator name="alpha" />
		</aui:input>

		<hr>
		<div>
			<strong>Contact details</strong>
		</div>
		<br>
		<aui:input cssClass="borderForm" name="contectName" label="Name  ">
			<aui:validator name="required" />
		</aui:input>
		<aui:input cssClass="borderForm" name="number" label="Mobile Number  ">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="maxLength">10</aui:validator>
		</aui:input>

		<div style="margin-left: 235px;">
			<aui:button type="submit" onsubmit="return validateForm()"
				value="Next"
				style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
			<aui:button type="cancel" value="cancel"
				style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "
				onClick="window.history.back();" />
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
