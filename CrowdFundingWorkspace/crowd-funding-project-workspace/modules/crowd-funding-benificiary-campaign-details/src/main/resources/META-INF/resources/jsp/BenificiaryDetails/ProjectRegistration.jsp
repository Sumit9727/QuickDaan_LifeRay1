	 <%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
	 <%@page import="com.liferay.portal.kernel.util.WebKeys"%>
	 <%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
	 <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
	 <%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
	 <%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
	 <%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
	 <%@ include file="/init.jsp" %>
	 <%@page import="com.liferay.portal.kernel.model.User"%> 
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%> 
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



	 <style>
	 .endDate{
	 	style="width: 700px;
	     border-radius: 10px;
	     border-color: #7FBD2C;
	     border-bottom: 3px solid 7fbd2c00;
	     height: 45px;
	     padding:1rem;
	     background-color: whitesmoke;
	     border-top:1px solid 7fbd2c00;
	     border-left:1px solid 7fbd2c00;"
	 }
	 .bordercity{
	 	border-radius: 9px;
	 	border: 1px solid #7FBD2C;
	 	border-bottom: 3px solid #7FBD2C;
	 	background-color:#e7e7ed;
	 	width: 704px;  
	 	margin-top: 1px;
	 	height: 43px;
	     background-color: whitesmoke;
	     
	     }
	     
	     strong {
	     color: #0077A2;
	     font-size: 13px;
	 }
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
.ProjectRegistration {
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
    margin:auto;
}

/*code for footer ends*/
	     
	 </style>

	 <!-- <script>
	  $(document).ready(function(){
	 	    $("#inputTextBox4").keypress(function(event){
	 	        var inputValue = event.which;
	 	        // allow letters and whitespaces only.
	 	        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
	 	            event.preventDefault(); 
	 	        }
	 	    });
	 	});
	  </script>
	  -->
	  
<script type="text/javascript">
$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;
    $('#txtDate').attr('min', maxDate);
});
</script>


	   
	 <%
	 String benificiaryID = renderRequest.getParameter("benificiaryID"); 
	 ThemeDisplay themeDisplayUser = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
	 User  userDetail = themeDisplayUser.getUser();
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
			<a href="/web/crowd-funding/fund-raise-request">Start a Fundraisers</a> <a href="/web/quickdaan-home-page/home/#section4">How it works</a> <a href="">Find Fundraisers</a> <a href="/web/crowd-funding/campaigns">Donate now</a>
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
	 <portlet:actionURL name="ProjectRegistrationDetails" var="ProjectRegistrationDetailsURL" />

	 <aui:form action="${ProjectRegistrationDetailsURL}" method="post" enctype="multipart/form-data">
	 	<aui:input name="benificiaryID" value="<%= benificiaryID %>" type="hidden"></aui:input>
	 	<aui:input name="userID" value="<%= userDetail.getUserId() %>" type="hidden"></aui:input>
	 	<div class="ProjectRegistration">
	 	<h1>Project Registration</h1>
	 	<br>
	 	<hr>
	 	
	 	<aui:input cssClass="borderForm" name="title" maxlength="100" label="Title  "  type="text">
	 	<aui:validator name="max">100</aui:validator><aui:validator name="required" /></aui:input>

	 	<strong>User Story</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span><br>
	 	<liferay-ui:input-editor name="description" placeholder="Write you story here..." initMethod="initEditor" width="100" height="400" resizable="true" ></liferay-ui:input-editor>
	 	<br>
	 	
	 	<strong>Campaign Document</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	 	<br>
	 	<div id="document-fields">
	 		<div class="lfr-form-row lfr-form-row-inline">
	 			<div class="row-fields" style="display: flex;">
	 				
	 				<input Class="DocumentName"fieldParam='documentName0' required="required" id='<portlet:namespace/>documentName0' placeholder="Document Name" name="<portlet:namespace/>documentName0" style="padding:5px;" type="text"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <input fieldParam='documentFile0' required="required"  id='<portlet:namespace/>documentFile0' name="<portlet:namespace/>documentFile0" type="file" 
	                            accept=".pdf, .doc, .docx, .ppt, .pptx, .pps, .ppsx, .odt, .xls, .xlsx " />
	 			</div>
	 		</div>
	 	</div>
	 	
	 	<aui:form action="uploadAction" method="post" enctype="multipart/form-data" onsubmit="return validation(this)">
	 	
	  
	 	<strong>Video File</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	 	<p><label> <input type="file" name="videoFile"  accept="video/*"></label></p>
	 	</aui:form> 
	 	
	 	 <strong>EndDate  </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span><br>
	 	 <input  class="endDate" type="date" id="txtDate" required="required"  name="<portlet:namespace/>enddate"  label=""
	  style="width: 700px;
	     border-radius: 10px;
	     border-color: #7fbd2c00;
	     border-bottom: 1px solid #7fbd2c;
	     height: 45px;
	     padding:1rem;
	     background-color: whitesmoke;
	     border-top:1px solid #7fbd2c00;
	     border-left:1px solid #7fbd2c00;"><br></br>
	 	
	 	  </input>

	 		 		
	 	<aui:input cssClass="borderForm" name="requiredFundAmt" min="1" max="100000000" label="Required Fund Amount"  type="number" >
	 	 <aui:validator name="required"/>
	 	 <%-- <aui:validator maxlength="8"/> --%>
	      </aui:input>	
	 		
	 					
	 	<div style="margin-left: 235px;"><aui:button type="submit" value="Next"  style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
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
	 </div>
	 