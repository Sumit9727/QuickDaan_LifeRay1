<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="crowd.funding.home.page.constants.CrowdFundingHomePagePortletKeys"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Collection"%>
<%@page import="com.crowd.funding.database.service.DonorRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DonorRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFollowerRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectUpdateRegistration"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="com.crowd.funding.database.model.FundAccountRegistration"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ImageRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
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

<liferay-theme:defineObjects />

<portlet:defineObjects />


<% 
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

float donatedAmount = 0;
List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());

for(FundRegistration fundAmtObj : fundAmtList){
	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}
double donatedAmountInPercentage = (donatedAmount*100)/projectRegistration.getREQUIRED_FUND_AMOUNT();

%>
								<!-- ---------CSS Start--------- -->

<style>
	
	h1{
		text-align: center;
		font-size: 1.6em;
        font-weight: 600;
    color: #5d5d5d;
   
}

.container{
	width: 100%;

}

.card-body {
    box-shadow: 1px 2px 10px 0 #d8d8d8;
    border-radius: 2px;
   
}
.card-body-new {
    box-shadow: 1px 2px 10px 0 #d8d8d8;
    border-radius: 2px;
    padding: 5%;
   
}

.payment-options {
    font-size: 12px;
    color: #999999;
    margin-top: 5px;
    margin-bottom: 0px;
}

.seperater {
    margin: 10px 0px;
    font-size: 10px;
}

.seperater span {
    display: inline-block;
    width: 60px;
    border: 1px solid #d0d0d0;
    height: 1px;
    margin: 3px 10px;
}

.btn-primary {
    color: #fff;
    background-color: #b91141;
    border-color: #b91141;
}



  .btn-success:hover, .btn-success:active, .btn-success:focus {
  color: #fff !important;
  background-color: #a20f39 !important;
  border-color: #a20f39 !important;
}

.well{
	
	box-shadow: 0px 1px 5px #888888;
	height: 68px;
}

.well-lg{
box-shadow: 0px 1px 5px #888888;
	height: auto;
	padding: 2%;
}

.btn-facebook {
	color: #fff;
	background-color: #4C67A1;
  }
.btn-facebook:hover {
	color: #fff;
	background-color: #405D9B;
}
.btn-facebook:focus {
	color: #fff;
}

.btn-twitter{
	font-size:24px;background: #55ACEE;display: inline-block;
    margin-bottom: 0;
    font-weight: normal;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    background-image: none;
    border: 1px solid transparent;
    white-space: nowrap;
    padding: 6px 12px;
    font-size: 20px;
    line-height: 1.7;
    border-radius: 4px;
    color: white;
        height: 48px;
    margin-top: 9px;
}

@import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic);
blockquote{
  font-size: 1.1em;
  margin:50px auto;
  font-family:Open Sans;
  font-style:italic;
  color: #555555;
  padding:1.2em 30px 1.2em 75px;
  border-left:8px solid #b91141 ;
  line-height:1.6;
  position: relative;
  background:#EDEDED;
  width: 100%;
}

blockquote::before{
  font-family:Arial;
  content: "\201C";
  color:#78C0A8;
  font-size:4em;
  position: absolute;
  left: 10px;
  top:-10px;
}

blockquote::after{
  content: '';
}

blockquote span{
  display:block;
  color:#333333;
  font-style: normal;
  font-weight: bold;
  margin-top:1em;
}

</style>

<style>
	.tab {
		border: 0px;
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  width: 100%;
      border-bottom: 2px solid #b91141;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
  width: 50%

}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {

  display: ;
  padding: 6px 12px;
  -webkit-animation: fadeEffect 1s;
  animation: fadeEffect 1s;
  width: 100%;
}

/* Fade in tabs */
@-webkit-keyframes fadeEffect {
  from {opacity: 0;}
  to {opacity: 1;}
}

@keyframes fadeEffect {
  from {opacity: 0;}
  to {opacity: 1;}
}


.progress-bar1 {
  position: relative;
  height: 100px;
  width: 100px;
  margin:0 auto;
}
 
.progress-bar1 div {
  position: absolute;
  height: 100px;
  width: 100px;
  border-radius: 50%;
}
 
.progress-bar1 div span {
  position: absolute;
  font-family: Arial;
  font-size: 22px;
  line-height: 75px;
  height: 75px;
  width: 75px;
  left: 12.5px;
  top: 12.5px;
  text-align: center;
  border-radius: 50%;
  background-color: white;
}
 
.progress-bar1 .background { background-color: #b3cef6; }
 
.progress-bar1 .rotate {
  clip: rect(0 50px 100px 0);
  background-color: #4b86db;
}
 
.progress-bar1 .left {
  clip: rect(0 50px 100px 0);
  opacity: 1;
  background-color: #b3cef6;
}
 
.progress-bar1 .right {
  clip: rect(0 50px 100px 0);
  transform: rotate(180deg);
  opacity: 0;
  background-color: #4b86db;
}
 
@keyframes
toggle {  0% {
 opacity: 0;
}
 100% {
 opacity: 1;
}
}  


.campaign-no-overlay .campaign-owner-details {
    padding: 10px;
    background-color: #ecedee;
    margin-top: 30px;
    font-size: 10px;
    border-radius: 2px;
}
/* forms */

.customPagination, .paginacaoCursor{
    
      padding: 5px 8px;
      color: #fff;
      background: #b91141;
      cursor: pointer;
    }
</style>

<style>
.container1 {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
  
}

.container1::after {
  content: "";
  clear: both;
  display: table;
}

.container1 img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container1 img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-left {
  float: left;
  color: #999;
}

.time-right {
  float: right;
  color: #999;
}
</style>

									<!-- ---------End of CSS--------- -->

										<!-- CAMPAIGN TITLE -->
<style>
.container1 {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
  
}

.container1::after {
  content: "";
  clear: both;
  display: table;
}

.container1 img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container1 img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-left {
  float: left;
  color: #999;
}

.time-right {
  float: right;
  color: #999;
}
</style>
<style>
.section_3_content{
 background-image:url("/portal_content/cAUVERY.jpeg") ;
  background-color: #cccccc;
}
/*code for navigation bar*/
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

	input::-webkit-search-decoration,
	input::-webkit-search-cancel-button {
		display: none;
	}


	input[type=search] {

		margin-top: 2px;
		background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
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
/*end of navigation bar css*/
	
	/*cards & Testimonals css*/
	.testimotionals {
		width: 20%;
		display: inline-block;
		margin-left: 50px;
		margin-top: 50px margin-left:100px;
	}


	.testimotionals .card {
		position: relative;
		overflow: hidden;
		width: 100%;
		height: 535px;
		margin: 0 auto;
		background: #0077A2;
		padding: 20px;
		text-align: center;
		/*	box-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/
	}

	.testimotionals .card .layer {
		/*z-index: 1;*/
		position: absolute;
		top: calc(100% - 2px);
		height: 100%;
		width: 100%;
		left: 0;
		background: linear-gradient(to left, #7FBD2c, #7FBD2c);
		transition: 0.5s;

	}

	.testimotionals .card .content1 {
		/*	z-index: 2;*/
		position: relative;
	}

	.testimotionals .card:hover .layer {
		top: 0;
	}

	.testimotionals .card .content1 p {
		font-size: 14px;
		line-height: 24px;
		color: #fff;
		margin-top: -3px;

	}

	.testimotionals .card .content1 .image {
		width: 100px;
		height: 100px;
		margin: 0 auto;
		border-radius: 50%;
		overflow: hidden;
		border: 4px solid white;
		box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);

	}

	.testimotionals .card .conte nt .details h2 {
		font-size: 18px;
		color: white;
	}

	.testimotionals .card .content1 .details h2 span {
		font-size: 18px;
		color: purple;
		transition: 0.5s;
	}

	.testimotionals .card:hover .content1 .details h2 span {
		color: white;
		position: relative;
		margin-top: 7px;
	}

	.para {
		height: 110px;
	}

	.boxed {
		background-color: black;
		width: 100%;
		height: 190px;
		margin-bottom: px;
		margin-top: -8px;
	}
/*end of cards & testimanals css*/
	
/*css for text_fundraiser*/	
	.text_fundraiser {
		color: #0077A2;
		font-size: 4vw;
	}
/*end of text_fundraiser*/
	
/*code for section3 */	
	.slideshow-container {
		max-width: 1000px;
		position: relative;
		margin: auto;
		height: 420px;
	}
	
	.text {
		color: #f2f2f2;
		font-size: 15px;
		padding: 8px 12px;
		position: absolute;
		bottom: 8px;
		width: 100%;
		text-align: center;
	}

	/* The dots/bullets/indicators */
	.dot {
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active {
		background-color: #717171;
	}

	/* Fading animation */
	.fade {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {
		.text {
			font-size: 11px
		}
	}

	/*section 2 css*/

	.slideshow-container1 {
		max-width: 100%;
		position: relative;
		margin: auto;
	}

	/* Next & previous buttons */
	.prev1,
	.next1 {
		margin-left: 100px;
		cursor: pointer;
		position: absolute;
		top: 50%;
		width: auto;
		padding: 16px;
		margin-top: -22px;
		color: black;
		font-weight: bold;
		font-size: 18px;
		transition: 0.6s ease;
		border-radius: 0 3px 3px 0;
		user-select: none;
	}

	/* Position the "next button" to the right */
	.next1 {
		right: 0;
		border-radius: 3px 0 0 3px;
		margin-right: 100px;
	}

	/* On hover, add a black background color with a little bit see-through */
	.prev:hover1,
	.next:hover1 {
		background-color: rgba(0, 0, 0, 0.8);
	}

	/* Caption text */

	.text_section2 {
		width: auto;
		height: 0px;
		font-family: comic sans MS;
		color: black;
		font-size: 15px;
		padding: 0px 32px;
		position: absolute;
		bottom: 0px;
		text-align: center;
		font-size: 2.5vw;
		margin-left: 102px;
		margin-bottom: 0px;
	}

	/* Number text (1/3 etc) */
	.numbertext1 {
		color: #f2f2f2;
		font-size: 12px;
		padding: 8px 12px;
		position: absolute;
		top: 0;
	}

	/* The dots/bullets/indicators */
	.dot1 {
		cursor: pointer;
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active1,
	.dot:hover1 {
		background-color: #717171;
	}

	/* Fading animation */
	.fade1 {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {

		.prev,
		.next,
		.text {
			font-size: 11px
		}
	}

	/*section 2 css end*/

	/*section3(1) css*/

	.section3(1) {
		height: 550px;
		width: 100%;
	}

	/*section3(1) css end*/

	.text_fundraiser {
		color: #0077A2;
		font-size: 4vw;
	}

/*end of section3 css*/	
	
	/*css of liferay */
	body {
		font-family: Verdana, sans-serif;
	}

	.mySlides {
		display: none;
	}

	img {
		vertical-align: middle;
	}

	/*body css*/
	.home_body {
		width: 100%;
		margin-top: -155px;
	}

	/*header css*/
	/*.v1 {
			border-left: 3px solid #0077A2;
			height: 60px;
			margin-left:267px;
			margin-top: -67px;
		}
*/
	.b_text {
		padding: 2px;
		font-family: georgia;
		font-size: 3vw;
		float: left;
		/*padding:50px;*/
		/*margin-top: -50px;
			margin-left: 364px;*/
	}

	/*code for search icon*/
	@import 'https://fonts.googleapis.com/css?family=Catamaran';

	html,
	body {
		width: 100%;
		height: 100%;
		margin: 0;
		padding: 0;
		font-family: 'Catamaran', sans-serif;
	}

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

	/*------------------------------------------------------------------------------------------------------------*/
	/*closing of nav bar content*/

	/*start of section2 css*/
	/* Slideshow container */
	.slideshow-container {
		max-width: 1000px;
		position: relative;
		margin: auto;
		height: 420px;
	}

	/* Caption text */
	.text {
		color: #f2f2f2;
		font-size: 15px;
		padding: 8px 12px;
		position: absolute;
		bottom: 8px;
		width: 100%;
		text-align: center;
	}

	/* The dots/bullets/indicators */
	.dot {
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active {
		background-color: #717171;
	}

	/* Fading animation */
	.fade {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {
		.text {
			font-size: 11px
		}
	}

	/*section 2 css*/

	.slideshow-container1 {
		max-width: 100%;
		position: relative;
		margin: auto;
	}

	/* Next & previous buttons */
	.prev1,
	.next1 {
		margin-left: 100px;
		cursor: pointer;
		position: absolute;
		top: 50%;
		width: auto;
		padding: 16px;
		margin-top: -22px;
		color: black;
		font-weight: bold;
		font-size: 50px;
		transition: 0.6s ease;
		border-radius: 0 3px 3px 0;
		user-select: none;
	}

	/* Position the "next button" to the right */
	.next1 {
		right: 0;
		border-radius: 3px 0 0 3px;
		margin-right: 100px;
	}

	/* On hover, add a black background color with a little bit see-through */
	.prev:hover1,
	.next:hover1 {
		background-color: rgba(0, 0, 0, 0.8);
	}

	/* Caption text */

	.text_section2 {
    width: auto;
    height: auto;
    font-family: comic sans MS;
    color: black;
    font-size: 15px;
    padding: 0px 80px;
    position: absolute;
    bottom: 0px;
    text-align: center;
    font-size: 2.5vw;
    margin-left: 111px;
    margin-bottom: -46px;
}

	/* Number text (1/3 etc) */
	.numbertext1 {
		color: #f2f2f2;
		font-size: 12px;
		padding: 8px 12px;
		position: absolute;
		top: 0;
	}

	/* The dots/bullets/indicators */
	.dot1 {
		cursor: pointer;
		height: 15px;
		width: 15px;
		margin: 0 2px;
		background-color: #bbb;
		border-radius: 50%;
		display: inline-block;
		transition: background-color 0.6s ease;
	}

	.active1,
	.dot:hover1 {
		background-color: #717171;
	}

	/* Fading animation */
	.fade1 {
		-webkit-animation-name: fade;
		-webkit-animation-duration: 1.5s;
		animation-name: fade;
		animation-duration: 1.5s;
	}

	@-webkit-keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	@keyframes fade1 {
		from {
			opacity: .4
		}

		to {
			opacity: 1
		}
	}

	/* On smaller screens, decrease text size */
	@media only screen and (max-width: 300px) {

		.prev,
		.next,
		.text {
			font-size: 11px
		}
	}

	/*section 2 css end*/

	/*section3(1) css*/

	.section3(1) {
		height: 550px;
		width: 100%;
	}

	/*section3(1) css end*/

	.text_fundraiser {
		color: #0077A2;
		font-size: 4vw;
	}

	/*CARDS CSS*/
	.testimotionals {
		width: 20%;
		display: inline-block;
		margin-left: 50px;
		margin-top: 50px margin-left:100px;
	}


	.testimotionals .card {
		position: relative;
		overflow: hidden;
		width: 400%;
		height: 350px;
		margin: 0 auto;
		background: #0077A2;
		padding: 20px;
		text-align: center;
		/*	box-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/
	}

	.testimotionals .card .layer {
		/*z-index: 1;*/
		position: absolute;
		top: calc(100% - 2px);
		height: 100%;
		width: 100%;
		left: 0;
		background: linear-gradient(to left, #7FBD2c, #7FBD2c);
		transition: 0.5s;

	}

	.testimotionals .card .content1 {
		/*	z-index: 2;*/
		position: relative;
	}

	.testimotionals .card:hover .layer {
		top: 0;
	}

	.testimotionals .card .content1 p {
		font-size: 14px;
		line-height: 24px;
		color: #fff;
		margin-top: -3px;

	}

	.testimotionals .card .content1 .image {
		width: 100px;
		height: 100px;
		margin: 0 auto;
		border-radius: 50%;
		overflow: hidden;
		border: 4px solid white;
		box-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);

	}

	.testimotionals .card .conte nt .details h2 {
		font-size: 18px;
		color: white;
	}

	.testimotionals .card .content1 .details h2 span {
		font-size: 18px;
		color: purple;
		transition: 0.5s;
	}

	.testimotionals .card:hover .content1 .details h2 span {
		color: white;
		position: relative;
		margin-top: 7px;
	}

	.para {
		height: 110px;
	}

	.boxed {
		background-color: black;
		width: 100%;
		height: 190px;
		margin-bottom: px;
		margin-top: -8px;
	}

	/*END OF CARDS CSS*/


	/*section4 css*/
	.section4 {
		height: auto;
		width: 100%;
		text-align: center;
		background-color: #0077A2;
	}

	/*end of section4 css*/

	/*section5 css*/

	.fishes {

		position: relative;
		top: -10px;
		left: 0;
		width: 100%;
	}

	/*start of class tag image with text*/
	.tag {

		float: Center;

		position: absolute;

		left: 50px;

		top: 50px;

		background-color: green;

	}

	/*end*/
	.fish {
		position: absolute;
		top: -18px;
		width: 100%;
	}


	.section5 .content {
		position: absolute;
		bottom: 0;
		background: white;
		/* Fallback color */
		/* background: rgba(0, 0, 0, 0.2);*/
		/* Black background with 0.2 opacity */
		color: #f1f1f1;
		width: 100%;
		padding: 60px;
	}
	}

	/*end of section 5 css*/

	/*start of end carousel set 5 images*/
	.slick-slide {
		margin: 0px 20px;
	}

	.slick-slide img {
		width: 100%;
	}

	.slick-slider {
		position: relative;
		display: block;
		box-sizing: border-box;
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
		-webkit-touch-callout: none;
		-khtml-user-select: none;
		-ms-touch-action: pan-y;
		touch-action: pan-y;
		-webkit-tap-highlight-color: transparent;
	}

	.slick-list {
		position: relative;
		display: block;
		overflow: hidden;
		margin: 0;
		padding: 0;
	}

	.slick-list:focus {
		outline: none;
	}

	.slick-list.dragging {
		cursor: pointer;
		cursor: hand;
	}

	.slick-slider .slick-track,
	.slick-slider .slick-list {
		-webkit-transform: translate3d(0, 0, 0);
		-moz-transform: translate3d(0, 0, 0);
		-ms-transform: translate3d(0, 0, 0);
		-o-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
	}

	.slick-track {
		position: relative;
		top: 0;
		left: 0;
		display: block;
	}

	.slick-track:before,
	.slick-track:after {
		display: table;
		content: '';
	}

	.slick-track:after {
		clear: both;
	}

	.slick-loading .slick-track {
		visibility: hidden;
	}

	.slick-slide {
		display: none;
		float: left;
		height: 100%;
		min-height: 1px;
	}

	[dir='rtl'] .slick-slide {
		float: right;
	}

	.slick-slide img {
		display: block;
	}

	.slick-slide.slick-loading img {
		display: none;
	}

	.slick-slide.dragging img {
		pointer-events: none;
	}

	.slick-initialized .slick-slide {
		display: block;
	}

	.slick-loading .slick-slide {
		visibility: hidden;
	}

	.slick-vertical .slick-slide {
		display: block;
		height: auto;
		border: 1px solid transparent;
	}

	.slick-arrow.slick-hidden {
		display: none;
	}


	/*start of end carousel set 5 images*/


	/*start of submenunavbar*/

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

	/*end of submenunavbar*/

	/*search icon css*/
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

	input::-webkit-search-decoration,
	input::-webkit-search-cancel-button {
		display: none;
	}


	input[type=search] {

		margin-top: 2px;
		background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
		border-bottom: solid 1px #ccc;
		border-top: solid 1px #ccc;
		border-left: solid 1px #ccc;
		border-right: solid 1px #ccc;
		padding: 9px 0px 9px 0px;
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
		width: 6%;
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

	/*code u may delete*/
	a {
		color: white;
		text-decoration: none;
	}

	a:hover {
		color: #7FBD2C;
	}

	h1 {
		font: 1.7em;
		line-height: 110%;
		color: #000;
	}

	p {
		margin: 0 0 20px;
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
	.row{
		    margin-bottom: -24px;
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

	/*code for footer ends*/
	#grad2 {
		height: 500px;
		/* For browsers that do not support gradients */
		/* Standard syntax (must be last) */
	}

	/*sticked navbar css*/
	/*.content {
  padding: 16px;
}*/

	.sticky {
		position: fixed;
		top:0px;
		width: 100%;
		z-index: 1;
	}

	.sticky+.content {
		padding-top: 60px;
	}

	/*images responsiveness*/
	@media only screen and (max-width:100%) {

		.fishes,
		.fish,
			{
			height: auto;
		}
	}

	@media only screen and (max-width:100%) {

		.community,
		.rural,
		.senior,
		.animals,
		.disability,
		.emergrncies,
		.welfare,
		.development,
		.citizens,
		.animals1,
		.disability1,
		.emergencies1 {
			height: auto;
		}
	}


	@media only screen and (max-width:100%) {

		.trial,
		.trial1,
		.trial2,
		.logoimg,
		.bannerimg,
			{
			height: auto;
		}
	}
	.logoimg{
		    margin-top: 25px;
	}

	/*end of images responsiveness*/
	/*css of liferay code ends*/

	/*code for carousel offffffffffffffffffffffffffffffffffffffff 5 */
	.slick-slide {
    margin: 0px 20px;
}

.slick-slide img {
    width: 70%;
}

.slick-slider
{
    position: relative;

    display: block;
    box-sizing: border-box;

    -webkit-user-select: none;
       -moz-user-select: none;
        -ms-user-select: none;
            user-select: none;

    -webkit-touch-callout: none;
    -khtml-user-select: none;
    -ms-touch-action: pan-y;
        touch-action: pan-y;
    -webkit-tap-highlight-color: transparent;
}

.slick-list
{
    position: relative;

    display: block;
    overflow: hidden;

    margin: 0;
    padding: 0;
}
.slick-list:focus
{
    outline: none;
}
.slick-list.dragging
{
    cursor: pointer;
    cursor: hand;
}

.slick-slider .slick-track,
.slick-slider .slick-list
{
    -webkit-transform: translate3d(0, 0, 0);
       -moz-transform: translate3d(0, 0, 0);
        -ms-transform: translate3d(0, 0, 0);
         -o-transform: translate3d(0, 0, 0);
            transform: translate3d(0, 0, 0);
}

.slick-track
{
    position: relative;
    top: 0;
    left: 0;

    display: block;
}
.slick-track:before,
.slick-track:after
{
    display: table;

    content: '';
}
.slick-track:after
{
    clear: both;
}
.slick-loading .slick-track
{
    visibility: hidden;
}

.slick-slide
{
    display: none;
    float: left;

    height: 100%;
    min-height: 1px;
}
[dir='rtl'] .slick-slide
{
    float: right;
}
.slick-slide img
{
    display: block;
}
.slick-slide.slick-loading img
{
    display: none;
}
.slick-slide.dragging img
{
    pointer-events: none;
}
.slick-initialized .slick-slide
{
    display: block;
}
.slick-loading .slick-slide
{
    visibility: hidden;
}
.slick-vertical .slick-slide
{
    display: block;

    height: auto;

    border: 1px solid transparent;
}
.slick-arrow.slick-hidden {
    display: none;
}

.portlet-decorate .portlet-content{
    background-color: #FFF;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 0px;
	margin-top: -125px;
}


.portlet-layout .portlet-header {
    margin-bottom: 3rem;
    visibility: hidden;
    margin-top: -47px;
}

.container::after, .row::after {
	content: "";
	clear: both;
	display: table;
}

.remainingDays {
	margin-bottom: -4%;
	margin-top: -4%;
	color: #b91141;
}

.campaignpagelist {
	/* background-image: url("/portal_content/beckgroundimg2.jpg"); */
	background-repeat: no-repeat;
	padding-top: 24px;
}
</style>
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
<div class="container">
<h1 class="campaign-title"><%= projectRegistration.getTITLE() %></h1>
<br><br>
											<!-- Slideshow -->

	<div style="box-shadow: 1px 2px 65px 0 #d8d8d8;border-radius: 2px;width: 64%; margin-left: 18%;">
	<div style="max-width:400px; margin-left:3%;padding: 1em;">
	<div class="mySlides" style="height:452px;width:603px;">
						<portlet:resourceURL  var="imageResourceURL">
				<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
				<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(projectRegistration.getPROJECT_ID())  %>"/>
			</portlet:resourceURL>
	<%-- <img src="${imageResourceURL}" alt="Image" /> --%>
			<img src="${imageResourceURL}" alt="Image" style="width: 684px;height: 476px;margin-left:-10px;"/>
				
	</div>
	<div class="mySlides" style="height: 452px;width: 603px;">
    <h4 style="text-align: center;">Update</h4>
	</div>

	<div class="mySlides" style="height: 452px;width: 603px;">
    <h3 style="color: #b91141">Rs.<%= donatedAmount %>  </h3>
   
  										 <!--  progress bar -->
   
    <div class="progress">
	</div><br>
    <p style="color:#5d5d5d">raised of Rs.<%= projectRegistration.getREQUIRED_FUND_AMOUNT() %>  goal</p>
 	</div>
	<br>
	</div>
	</div>
	<br>
										<!-- end of slideshow -->

<div class="well">&nbsp&nbsp<a href="https://www.facebook.com/sharer/sharer.php?s=100&p[url]=http://127.0.0.1:8080/web/crowd-funding/campaing-details?p_p_id=CampaignDetails_INSTANCE_VPb8QZWCoDrF&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_jspPage=%2Fjsp%2FCampaign%20Details%2FCampaignDetails.jsp&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_projectID=101&p[images][0]=&p[title]=8-Year-Old With 100% Damaged Liver Has Few Hours Left For A Transplant&p[summary]=dzcdvsdvsddssdsdfsdfsdfsdf!" target="_blank" onclick="window.open(this.href,'targetWindow','toolbar=no,location=0,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=250'); return false"><button style="width:33%; margin-top:10px;" type="button" class="btn btn-facebook btn-lg"><i class="fa fa-facebook fa-2"></i> Share on Facebook</button></a>&nbsp&nbsp<a href="http://twitter.com/share?&url=http://127.0.0.1:8080/web/crowd-funding/campaing-details?p_p_id=CampaignDetails_INSTANCE_VPb8QZWCoDrF&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_jspPage=%2Fjsp%2FCampaign%20Details%2FCampaignDetails.jsp&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_projectID=101" class="twitter-share-button" data-show-count="false" onclick="window.open(this.href,'targetWindow','toolbar=no,location=0,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=250'); return false"><button class="btn-twitter"style="width:33%;">Share on Twitter<i class="fa fa-twitter"></i></button></a></div>
 <br><br>
 
 											<!-- CAMPAIGN DETAILS -->

<div class="row">
<div class="col-md-8" >
<div class="tab">
<button class="tablinks" onclick="openCity(event, 'Story')">Story</button>
<button class="tablinks" onclick="openCity(event, 'Update')">Update</button>
</div>

<div id="Story" class="tabcontent">
  <h3>Story</h3><br>
  <p><%= projectRegistration.getDESCRIPTION() %></p>
  <% if(projectRegistration.getVIDEO_TYPE().isEmpty() == false){ %>
	 <portlet:resourceURL  var="ProjectVideoResourceURL">
		<portlet:param name="serverResourceCall" value="ProjectIDForProjectVideo"/>
		<portlet:param name="ProjectIDForProjectVideo" value="<%= String.valueOf(projectRegistration.getPROJECT_ID())  %>"/>
	</portlet:resourceURL>
	
		 <video autoplay id="myVideo" controls style="max-width: 50%;">
			  <source src="${ProjectVideoResourceURL}" type="<%= projectRegistration.getVIDEO_TYPE() %>">
		</video>
	<% } %>
			
  <div>
  <h4>Supporting documents: </h4>
    <%
					  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					  for(DocumentRegistration documentObj : documentList){
					  %>
						 <portlet:resourceURL  var="ProjectDocumentResourceURL">
							<portlet:param name="serverResourceCall" value="ProjectIDForDocument"/>
							<portlet:param name="ProjectDocumentID" value="<%= String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  %>"/>
						 </portlet:resourceURL>
				    <a href="${ProjectDocumentResourceURL}" alt="Document" /><%= documentObj.getDOCUMENT_NAME() %></a>
		
				  	<% } %>
  
 </div><br>
 <div>
<p class="bank-account__title voffset-down2">You can also do a bank transfer to the below mentioned account setup for this fundraising campaign:</p>
	<p>Account number: 8080811062668</p>
	<p>Account name: Nagarjan</p>
	<p>IFSC code: YESB0CMSNOC</p>
</div>
<br>
											<!--  campaign owner details -->

<div class="campaign-owner-details campaign-section clearfix">
<p>Posted By : <%= userData.getFullName() %></p>
</div>


<div class="card-body-new">		
				
	    			
							<!-- AFTER DONATE OPTIONS -->
<%
long ProjectId = Long.parseLong(projectID);
//ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<FundRegistration> fundList = FundRegistrationLocalServiceUtil.findByPROJECT_DONOR_USER_ID(projectRegistration.getPROJECT_ID(), themeDisplayObj.getUserId());
if(fundList.size() > 0){
%>

			<portlet:renderURL var="AskAQuestionURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/Q&A/AskQuestion.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${AskAQuestionURL}"  value="Ask Question?"/>
			
			 <portlet:renderURL var="FeedbackURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/feedback/Feedback.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${FeedbackURL}"  value="Feedback"/>
			
			<portlet:actionURL name="updateRequestRegistration" var="updateRequestRegistrationURL" >
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
			</portlet:actionURL>
			<aui:button type="button" onClick="${updateRequestRegistrationURL}"  value="Ask for an Update"/>
			
<%} %>
							
							<!-- DONATE OPTION FOR USER -->
							
<%
//boolean signedIn = themeDisplayObj.isSignedIn();
String FundOtpId = renderRequest.getParameter("FundOtpId");
	if(signedIn == false){
%>
				<portlet:renderURL var="DonateRegistrationURL" windowState="normal">
					<portlet:param name="ProjectId" value="<%=String.valueOf(ProjectId) %>" />
					<portlet:param name="jspPage" value="/jsp/payment/DonorRegistrationForm.jsp" />
				</portlet:renderURL>
				<%if(donatedAmount <= projectRegistration.getREQUIRED_FUND_AMOUNT()){%>
					<aui:button type="button" onClick="${DonateRegistrationURL}"  value="I Want to Contribute"/>
				<% }  if(donatedAmount >= projectRegistration.getREQUIRED_FUND_AMOUNT()){%>
	      		  		<img alt="Thank You Img" src="/portal_content/Thank-You-with-Hands.jpg" style="width: 233px;margin-top: 42px;margin-left: 63px;">
	      		  <% } %>
	      		  
		<%}else{ %>

				<portlet:actionURL name="donationAmount" var="donationAmountURL" />
					
				<form action="${donationAmountURL}" method="post" >
		
			          <input name="<portlet:namespace/>projectId" type="hidden" value="<%= projectID %>">
			          <input  name="<portlet:namespace/>FundOtpId" type="hidden" value="<%= FundOtpId %>">
		        
		            <%if(signedIn == true){
			            	if(donatedAmount <= projectRegistration.getREQUIRED_FUND_AMOUNT()){%>
				           		 <aui:input label="Donate Anonymously" name="donateAnonymously" type="radio" value="Yes" />
				            <% } 
			            		}if(donatedAmount <= projectRegistration.getREQUIRED_FUND_AMOUNT()){ %>
				            <br>
				            <div class="row" style="margin-left: .1em;">
			              		<select class="form-control" name="<portlet:namespace/>currency" style="padding-right:0; padding-left:12px; width:6em; ">
			                            <option value="USD">USD $</option>
			                            <option selected value="INR">INR &#8377;</option>
			                    </select>
			                        
			              		&nbsp<input name="<portlet:namespace/>amount" type="text" class="form-control manual-payment payment-amt"  style="width:179px;"> 
				            </div>
				            <br>
				            <aui:input name="message" label="Message for Benificiary"></aui:input><br>
				            <input type="submit" name="commit" value="Donate now" style="width: 45%;margin-left: 10em" class="btn btn-primary btn-block text-bold btn-success" >
		      		  <% } if(donatedAmount >= projectRegistration.getREQUIRED_FUND_AMOUNT()){%>
		      		  		<img alt="Thank You Img" src="/portal_content/Thank-You-with-Hands.jpg" style="width: 233px;margin-top: 42px;margin-left: 63px;">
		      		  <% } %>
		      </form>
	<%} %>
</div>
</div>
		
		<!--  CAMPAIGN UPDATE TAB -->


<div id="Update" class="tabcontent">
<% 
List<ProjectUpdateRegistration> projectUpdateList = ProjectUpdateRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
int counter = 1;
for(ProjectUpdateRegistration projectUpdateObj : projectUpdateList){
%>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= projectUpdateObj.getUPDATE_DETAILS() %></p>
 	 <span class="time-left"><%= projectUpdateObj.getUPDATE_DATE() %></span>
</div>

<% } %>
</div>
<hr>
</div>

										<!-- side column start -->

	<div class="col-md-4" style="border-left: 1px solid #5d5d5d; solid" >
	<h4 style="color: #5d5d5d;">Donate</h4>
	<hr>
	
              <br>
  <p class="payment-options" data-for-currency="inr" style="margin-left: 3em;" >Payment options: Online, cheque pickups</p>
  <div class="seperater col-sm-12 text-center"><span></span>OR<span></span></div>
  <img style="margin-left:1.5em;" src="/portal_content/c.png">
  <br><br>
  
  
  <div> <p style="color: #E91E63;margin-left: 5.1em;font-size: 21px;"> RS.<%= String.format("%.0f",donatedAmount) %> Raised</p></div>
  <div class="progress-bar1" data-percent="<%= Math.floor(donatedAmountInPercentage) %>" data-duration="1000" data-color="#ccc,#b91141"></div>
  <br>
  <div> <p style="color:#5d5d5d; margin-left: 1em; " >Raised From Total Goal of INR. <%= String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT())  %></p></div>
  <br><hr>
  <h5 style="color: #0077A2;"><i class="fa fa-group" style="color:#0077A2; font-size: 25px;"></i>&nbsp&nbspCampaign Supporters</h5><hr>
				<%
					String donorName = null;
					List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					
					for(FundRegistration fundObj : donatedFundList){
						if(fundObj.getDONOR_STATUS() == 0){
							donorName = "Anonymous Donor";
						}else{
							if(fundObj.getDONOR_USER_ID() == 0){
								DonorRegistration donorObj = DonorRegistrationLocalServiceUtil.findByDONOR_ID(fundObj.getDONOR_ID());
								donorName = donorObj.getNAME();
							}else{
								UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(fundObj.getDONOR_USER_ID());
								donorName = userObj.getFULL_NAME();
							}
						} %>
						<ul class="paginationList list-group">   
					 <li class="listItem list-group-item" style="border: none;">	<label style="color: #01bfbd" ><%= donorName %></label> has donated <i class="fa fa-inr" style="color:#b91141 "></i> <label style="color:#b91141 "><%=  String.format("%.0f",fundObj.getDONATED_AMOUNT()) %> &#8377; </label><br>
						<label style="font-size: small;"><%= fundObj.getCOMMENT() %></label><hr style="width: 65%"></li> </ul>
						<%
					}
				%>
				<div style="margin-left: 6em;" id="pagination-container1"> 
				 <p class='paginacaoCursor' id="beforePagination"><</p>
            <p class='paginacaoCursor' id="afterPagination">></p> </div>    
				<br>
				<hr>
				</div>	
				</div>
				</div>
				</div>
				<br><br>


												<!--------JS------- -->

										<!-- script for circular progress bar -->

<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script>
;
(function ($) {
	$.fn.loading = function () {
		var DEFAULTS = {
			backgroundColor: '#b3cef6',
			progressColor: '#4b86db',
			percent: 75,
			duration: 2000
		};	
		
		$(this).each(function () {
			var $target  = $(this);

			var opts = {
			backgroundColor: $target.data('color') ? $target.data('color').split(',')[0] : DEFAULTS.backgroundColor,
			progressColor: $target.data('color') ? $target.data('color').split(',')[1] : DEFAULTS.progressColor,
			percent: $target.data('percent') ? $target.data('percent') : DEFAULTS.percent,
			duration: $target.data('duration') ? $target.data('duration') : DEFAULTS.duration
			};
			// console.log(opts);
	
			$target.append('<div class="background"></div><div class="rotate"></div><div class="left"></div><div class="right"></div><div class=""><span>' + opts.percent + '%</span></div>');
	
			$target.find('.background').css('background-color', opts.backgroundColor);
			$target.find('.left').css('background-color', opts.backgroundColor);
			$target.find('.rotate').css('background-color', opts.progressColor);
			$target.find('.right').css('background-color', opts.progressColor);
	
			var $rotate = $target.find('.rotate');
			setTimeout(function () {	
				$rotate.css({
					'transition': 'transform ' + opts.duration + 'ms linear',
					'transform': 'rotate(' + opts.percent * 3.6 + 'deg)'
				});
			},1);		

			if (opts.percent > 50) {
				var animationRight = 'toggle ' + (opts.duration / opts.percent * 50) + 'ms step-end';
				var animationLeft = 'toggle ' + (opts.duration / opts.percent * 50) + 'ms step-start';  
				$target.find('.right').css({
					animation: animationRight,
					opacity: 1
				});
				$target.find('.left').css({
					animation: animationLeft,
					opacity: 0
				});
			} 
		});
	}
})(jQuery);

</script>

<script>
$(".progress-bar1").loading();
     
</script>
											<!-- script for tab  -->
<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
											<!-- script for carousel -->
<script>
var slideIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none"; 
  }
  slideIndex++;
  if (slideIndex > x.length) {slideIndex = 1} 
  x[slideIndex-1].style.display = "block"; 
  setTimeout(carousel, 5000); 
}
</script>
 <div id="fb-root"></div>
 												<!-- script for fb -->
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = 'https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.2&appId=1990258291089302&autoLogAppEvents=1';
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

												<!-- Script for pagination -->
<script>
$(document).ready(function(){

	  var HZperPage = 3,//number of results per page
	     HZwrapper = 'paginationList',//wrapper class
	     HZlines   = 'listItem',//items class
	     HZpaginationId ='pagination-container1',//id of pagination container
	     HZpaginationArrowsClass = 'paginacaoCursor',//set the class of pagi
	     HZpaginationColorDefault =  '#b91141',//default color for the pagination numbers
	     HZpaginationColorActive = '#01bfbd', //color when page is clicked
	     HZpaginationCustomClass = 'customPagination'; //custom class for styling the pagination (css)

	  function paginationShow(){if($("#"+HZpaginationId).children().length>8){var a=$(".activePagination").attr("data-valor");if(a>=4){var i=parseInt(a)-3,o=parseInt(a)+2;$(".paginacaoValor").hide(),exibir2=$(".paginacaoValor").slice(i,o).show()}else $(".paginacaoValor").hide(),exibir2=$(".paginacaoValor").slice(0,5).show()}}paginationShow(),$("#beforePagination").hide(),$("."+HZlines).hide();for(var tamanhotabela=$("."+HZwrapper).children().length,porPagina=HZperPage,paginas=Math.ceil(tamanhotabela/porPagina),i=1;i<=paginas;)$("#"+HZpaginationId).append("<p class='paginacaoValor "+HZpaginationCustomClass+"' data-valor="+i+">"+i+"</p>"),i++,$(".paginacaoValor").hide(),exibir2=$(".paginacaoValor").slice(0,5).show();$(".paginacaoValor:eq(0)").css("background",""+HZpaginationColorActive).addClass("activePagination");var exibir=$("."+HZlines).slice(0,porPagina).show();$(".paginacaoValor").on("click",function(){$(".paginacaoValor").css("background",""+HZpaginationColorDefault).removeClass("activePagination"),$(this).css("background",""+HZpaginationColorActive).addClass("activePagination");var a=$(this).attr("data-valor"),i=a*porPagina,o=i-porPagina;$("."+HZlines).hide(),exibir=$("."+HZlines).slice(o,i).show(),"1"===a?$("#beforePagination").hide():$("#beforePagination").show(),a===""+$(".paginacaoValor:last").attr("data-valor")?$("#afterPagination").hide():$("#afterPagination").show(),paginationShow()}),$(".paginacaoValor").last().after($("#afterPagination")),$("#beforePagination").on("click",function(){var a=$(".activePagination").attr("data-valor"),i=parseInt(a)-1;$("[data-valor="+i+"]").click(),paginationShow()}),$("#afterPagination").on("click",function(){var a=$(".activePagination").attr("data-valor"),i=parseInt(a)+1;$("[data-valor="+i+"]").click(),paginationShow()}),$(".paginacaoValor").css("float","left"),$("."+HZpaginationArrowsClass).css("float","left");
	})
</script>

										<!-- ---------End of JS------------ -->





												<!-- CAMPAIGN COMMENT -->

<%-- <label><B>CAMPAIGN COMMENT</B></label>	<BR>
<%
List<CommentRegistration> commentList = CommentRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(ProjectId, CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1);
for(CommentRegistration commentObj : commentList){
	User CurrentUserData = UserLocalServiceUtil.fetchUser(commentObj.getDONOR_USER_ID());
%>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getCOMMENT() %></p>
 	 <span class="time-left"><%= commentObj.getCOMMENT_DATE() %> | <%= CurrentUserData.getFullName() %></span>
</div>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getANSWER() %></p>
 	 <span class="time-right"><%= commentObj.getCOMMENT_DATE() %> | <%= CurrentUserData.getFullName() %></span>
</div>
<% } %>

<portlet:actionURL var="commentDetailsURL" name="commentDetails"></portlet:actionURL>

<aui:form action="${commentDetailsURL}" method="post" >
	<aui:input type="hidden" name="projectID" value="<%= ProjectId %>"></aui:input>
	<aui:input name="commentData" type="textarea" label=" "/>
	<aui:button type="submit" value="Submit"  />
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form> --%>

					<!-- CAMPAIGN FOLLOWER -->
<portlet:actionURL name="projectFollowerRegistration" var="projectFollowerRegistrationURL" />					
<portlet:actionURL name="projectUnFollowRegistration" var="projectUnFollowRegistrationURL" />	
				
<%
if(signedIn == true){ 
List<ProjectFollowerRegistration> projectfollwerList = ProjectFollowerRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
boolean userFollowerStatus = false;

		for(ProjectFollowerRegistration followerObj : projectfollwerList){
			if(followerObj.getUSER_ID() == themeDisplayObj.getUserId() && followerObj.getSTATUS() == CrowdFundingHomePagePortletKeys.CAMPAIGN_FOLLOWER_STATUS_1 )
				userFollowerStatus = true;
		}
		
			if(userFollowerStatus == false){ %>
				<aui:form action="${projectFollowerRegistrationURL}" method="post" >
					<aui:input name="projectId" type="hidden" value="<%= projectID %>"></aui:input>
						<aui:button name="submit" type="submit" value="Follow Campaign" />
				</aui:form> 

		<% }else{%>
				<aui:form action="${projectUnFollowRegistrationURL}" method="post" >
						<aui:input name="projectId" type="hidden" value="<%= projectID %>"></aui:input>
						<aui:input name="userId" type="hidden" value="<%= themeDisplayObj.getUserId() %>"></aui:input>
							<aui:button name="submit" type="submit" value="Unfollow Campaign" />
				</aui:form> 
	
		<% 		
			}
		} %>
