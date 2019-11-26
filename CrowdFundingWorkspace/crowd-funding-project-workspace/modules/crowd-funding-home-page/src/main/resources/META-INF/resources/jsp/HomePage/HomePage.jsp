<%@page import="com.liferay.portal.kernel.model.User"%> 
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%> 
<%@ include file="/init.jsp" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />


<!DOCTYPE html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript">
</script><script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.6.0/slick.js">
</script><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<%@page import="crowd.funding.home.page.constants.CrowdFundingHomePagePortletKeys"%>
<%@page import="java.util.LinkedList"%>
<%@page	import="com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil"%>
<%@page	import="com.crowd.funding.database.model.ProjectExtentionRegistration"%>
<%@page	import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="java.util.spi.LocaleServiceProvider"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page	import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page	import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page	import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page	import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService"%>
<%@page	import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page	import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>

<head>
	<title>QuickDaan-Care For Everyone</title>
</head>
<style>
.section_3_content{
 background-image:url("/portal_content/emergencies.jpg") ;
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

	/* .testimotionals .card:hover .layer {
		top: 0;	
	} */

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

	/* .testimotionals .card:hover .layer {
		top: 0;
	}
 */
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
		background-color: darkgrey;
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

	<div class="section1 content">
     <img src="\portal_content\Banner_Image.jpg" class="bannerimg" style="width: 100%">
	</div>

	<div class="section2 content" style="height:700px;opacity: 1;width: 100%;transform: translate3d(0px, 0px, 0px);">

		<div class="text_fundraiser">
			<center>
				<p><b>FIND FUNDRAISERS</b></p>
			</center>
		</div>
        <section class="customer-logos1 slider">
		<div class="campaignpagelist" style="margin-top: -48px; margin-top: -7px;width: 1888px;">


	<div class="row">
		<%
			Set<Integer> hash_Set = new HashSet<Integer>();
			List<ProjectPriorityRegistration> projectList = ProjectPriorityRegistrationLocalServiceUtil
					.findByPRIORITY(CrowdFundingHomePagePortletKeys.Priority_1);

			for (ProjectPriorityRegistration priorityObj : projectList) {
				hash_Set.add(priorityObj.getPRIORITY_SEQUANCE());
			}
			Iterator value = hash_Set.iterator();
			while (value.hasNext()) {
				int prioritySquance = (Integer) value.next();

				ProjectPriorityRegistration sortedList = ProjectPriorityRegistrationLocalServiceUtil
						.findByPRIORITY_SEQUANCE(prioritySquance);

				ProjectRegistration featuredProjectObj = ProjectRegistrationLocalServiceUtil
						.findByPROJECT_ID(sortedList.getPROJECT_ID());
				UserRegistration userObj = UserRegistrationLocalServiceUtil
						.findByUSER_ID(featuredProjectObj.getUSER_ID());
				List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil
						.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());

				Date currentDate;
				Date endDate;
				int differenceInDays = 0;

				List<ProjectExtentionRegistration> extentionRegistrationList = ProjectExtentionRegistrationLocalServiceUtil
						.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());
				if (extentionRegistrationList.size() >= 0) {
					LinkedList<ProjectExtentionRegistration> reverseList = new LinkedList<ProjectExtentionRegistration>();
					for (int i = extentionRegistrationList.size() - 1; i >= 0; i--) {
						reverseList.add(extentionRegistrationList.get(i));
					}
					for (ProjectExtentionRegistration extentionRegistrationObj : reverseList) {
						currentDate = new Date();
						endDate = extentionRegistrationObj.getEXTENTION_DATE();
						differenceInDays = (int) ((endDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24))
								+ 1;
						break;
					}
				}
				if (extentionRegistrationList.size() == 0) {
					currentDate = new Date();
					endDate = featuredProjectObj.getEND_DATE();
					differenceInDays = (int) ((endDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24)) + 1;
				}

				List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil
						.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());

				float donatedAmount = 0;
				for (FundRegistration fundAmtObj : fundAmtList) {
					donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
				}
				if (differenceInDays >= 0) {
					if (featuredProjectObj.getSTATUS() == CrowdFundingHomePagePortletKeys.Project_STATUS_4
							&& featuredProjectObj.getREQUIRED_FUND_AMOUNT() == donatedAmount && featuredProjectObj
									.getSTATUS() == CrowdFundingHomePagePortletKeys.Project_STATUS_5) {
					}
					if (featuredProjectObj.getSTATUS() != CrowdFundingHomePagePortletKeys.Project_STATUS_4
							&& featuredProjectObj.getREQUIRED_FUND_AMOUNT() != donatedAmount && featuredProjectObj
									.getSTATUS() != CrowdFundingHomePagePortletKeys.Project_STATUS_5) {
						String normalDoubleValue = String.format("%.0f", donatedAmount);
		%>
		<portlet:resourceURL var="featuredProjectImageResourceURL">
			<portlet:param name="serverResourceCall"
				value="ProjectIDForProjectImage" />
			<portlet:param name="ProjectIDForProjectImage"
				value="<%=String.valueOf(featuredProjectObj.getPROJECT_ID())%>" />
		</portlet:resourceURL>
		<portlet:renderURL var="featuredProjectViewImages"
			windowState="normal">
			<portlet:param name="projectID"
				value="<%=String.valueOf(sortedList.getPROJECT_ID())%>" />
			<portlet:param name="jspPage"
				value="/jsp/HomePage/CampaignDetails.jsp" />
		</portlet:renderURL>
<%-- 
		<div class="column" style="padding: 23px;">
			<div class="card" style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); padding: 10px; width: 288px;">
				<div class="container" style="padding: 0 0 0 0px; height: 489px; text-align: center; width: 100%">
					<div>
						<a href="${featuredProjectViewImages}"> <img class="picture"
							src="${featuredProjectImageResourceURL}" alt="Image"
							style="height: 150px; width: 288px; margin-left: -10px; margin-top: -10px;" />
						</a>
					</div>
					<div style="padding-top: 17px;">
						<h5 style="color: black;"><%=donatedAmount%>
							raised
						</h5>
						<div>
							<progress style="width: 210px; height: 19px;"
								value=<%=donatedAmount%>
								max=<%=featuredProjectObj.getREQUIRED_FUND_AMOUNT()%>></progress>
						</div>
						<div>
							<div style="height: 96px;color: black;">
								<B style="font-size: small;"> <%=featuredProjectObj.getTITLE()%></B>
							</div>
						</div>
						<div>
							<hr>
							<div class="remainingDays">
								<center>
									<div style="color: black;"><%=differenceInDays%>
										days left |
										<%=donatedFundList.size()%>
										Supportes
									</div>
								</center>
							</div>
							<hr>
							<div>
								<div style="margin-top: %;color:black;">
									Posted By :
									<%=userObj.getFULL_NAME()%></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> 
 --%>


		<%
			}
				}

			}
		%>

		<!-- Non-Featured Project -->
		<%
			List<ProjectPriorityRegistration> priorityList = ProjectPriorityRegistrationLocalServiceUtil
					.findByPRIORITY(CrowdFundingHomePagePortletKeys.Priority_0);

			for (ProjectPriorityRegistration priorityObj : priorityList) {
				ProjectRegistration normalProjectObj = ProjectRegistrationLocalServiceUtil
						.findByPROJECT_ID(priorityObj.getPROJECT_ID());

				UserRegistration userObj = UserRegistrationLocalServiceUtil
						.findByUSER_ID(normalProjectObj.getUSER_ID());
				List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil
						.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());

				Date currentDate;
				Date endDate;
				int differenceInDays = 0;

				List<ProjectExtentionRegistration> extentionRegistrationList = ProjectExtentionRegistrationLocalServiceUtil
						.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());
				if (extentionRegistrationList.size() >= 0) {
					LinkedList<ProjectExtentionRegistration> reverseList = new LinkedList<ProjectExtentionRegistration>();
					for (int i = extentionRegistrationList.size() - 1; i >= 0; i--) {
						reverseList.add(extentionRegistrationList.get(i));
					}
					for (ProjectExtentionRegistration extentionRegistrationObj : reverseList) {
						currentDate = new Date();
						endDate = extentionRegistrationObj.getEXTENTION_DATE();
						differenceInDays = (int) ((endDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24))
								+ 1;
						break;
					}
				}
				if (extentionRegistrationList.size() == 0) {

					currentDate = new Date();
					endDate = normalProjectObj.getEND_DATE();
					differenceInDays = (int) ((endDate.getTime() - currentDate.getTime()) / (1000 * 60 * 60 * 24)) + 1;
				}
				List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil
						.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());
				float donatedAmount = 0;

				for (FundRegistration fundAmtObj : fundAmtList) {
					donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
				}

				if (differenceInDays >= 0) {
					if (normalProjectObj.getSTATUS() == CrowdFundingHomePagePortletKeys.Project_STATUS_4
							&& normalProjectObj.getREQUIRED_FUND_AMOUNT() == donatedAmount && normalProjectObj
									.getSTATUS() == CrowdFundingHomePagePortletKeys.Project_STATUS_5) {
					}
					if (normalProjectObj.getSTATUS() != CrowdFundingHomePagePortletKeys.Project_STATUS_4
							&& normalProjectObj.getREQUIRED_FUND_AMOUNT() != donatedAmount && normalProjectObj
									.getSTATUS() != CrowdFundingHomePagePortletKeys.Project_STATUS_5) {
		%>
		<portlet:resourceURL var="NormalProjectImageResourceURL">
			<portlet:param name="serverResourceCall"
				value="ProjectIDForProjectImage" />
			<portlet:param name="ProjectIDForProjectImage"
				value="<%=String.valueOf(normalProjectObj.getPROJECT_ID())%>" />
		</portlet:resourceURL>
		<portlet:renderURL var="NormalProjectViewImages" windowState="normal">
			<portlet:param name="projectID"
				value="<%=String.valueOf(priorityObj.getPROJECT_ID())%>" />
			<portlet:param name="jspPage"
				value="/jsp/HomePage/CampaignDetails.jsp" />
		</portlet:renderURL>

<%-- <div class="column" style="padding: 23px;">
			<!--  padding: 10px;  font-family: arial;  margin: auto;  max-width: 325px;  max-height: 500px;  color: #0077a2; -->
			<div class="card"
				style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); padding: 10px; width: 288px;">
				<div class="container"
					style="padding: 0 0 0 0px; height: 390px; text-align: center;">
					<div>
						<a href="${NormalProjectViewImages}"> <img class="picture"
							src="${NormalProjectImageResourceURL}" alt="Image"
							style="height: 150px; width: 288px; margin-left: -10px; margin-top: -10px;" />
						</a>
					</div>
					<div style="padding-top: 17px;">
						<h5 style="color: #0077A2;"><%=donatedAmount%>
							raised
						</h5>
						<div>
							<progress style="width: 238px; height: 19px;"
								value=<%=donatedAmount%>
								max=<%=normalProjectObj.getREQUIRED_FUND_AMOUNT()%>></progress>
						</div>

						<div>
							<div style="height: 96px;">
								<B style="font-size: small;"> <%=normalProjectObj.getTITLE()%></B>
							</div>
						</div>
						<div>
							<hr>
							<div class="remainingDays">
								<center>
									<div><%= differenceInDays %>
										days left |
										<%= donatedFundList.size() %>
										Supportes
									</div>
								</center>
							</div>
							<hr>
							<div>
								<div style="margin-top: -5%;">
									Posted By :
									<%= userObj.getFULL_NAME() %></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>  --%>
		<div class="container-fluid">
		         <div class="testimotionals content " style="float:center;">
                <div class="card" style="height:521px;width: 279px;">
                                <div class="layer">&nbsp;</div>

                                <div class="content1">
                                        <!-- <p style="color:white;font-size:1.5vw;font-family: georgia;height: 25px;width:100%;">Hunger</p> -->

                                        <div class="boxed"><a href="${NormalProjectViewImages}}"> <img class="picture"
                                                        src="${NormalProjectImageResourceURL}" alt="Image"
                                                        style="height: 191px; width: 278px; margin-left: -21px; margin-top: -20px;" />
                                                </a></div>

                                        <div class="details">
                                                <div class="para">
                                                        <p style="font-size:1.1vw;margin-top:10px; color:white;font-family: georgia;">
                                                                <div style="padding-top: 0px;">
                                                <h5 style="color: white;"><%=donatedAmount%>
                                                        raised
                                                </h5>
                                                <div>
                                                        <progress style="width: 238px; height: 19px;"
                                                                value=<%=donatedAmount%>
                                                                max=<%=normalProjectObj.getREQUIRED_FUND_AMOUNT()%>></progress>
                                                </div>
                                                <div style="width:200px;">
                                                        <div style="height: 69px;font-size: 16px;">
                                                                <B style="color: white;"> <%=normalProjectObj.getTITLE()%></B>
                                                        </div>
                                                </div>
                                                <div>
                                                        <hr>
                                                        <div class="remainingDays">
                                                                <center>
                                                                        <div style="color: white;"><%=differenceInDays%>
                                                                                days left |
                                                                                <%=donatedFundList.size()%>
                                                                                Supportes
                                                                        </div>
                                                                </center>
                                                        </div>
                                                        <hr>
                                                        <div>
                                                                <div style="margin-top: -5%;color:white;">
                                                                        Posted By :
                                                                        <%=userObj.getFULL_NAME()%></div>
                                                        </div>
                                                </div>
                                        </div>
                                                        </p>
                                                </div>
                                                <!--end of para-->
                                        </div>
                                        <!--end of details-->
                                </div>
                                <!--end of content-->
                        </div>
                        <!-- <center>
                                <p style="font-size:1vw;"><button accesskey="" style="border:1px solid #7FBD2C;margin-top:5px; border-radius:20px;background-color: #7FBD2C;color:black;width:50%;height:40px;font-family: georgia;">Donate now</button></p>
                        </center> -->
                        <!--end of card-->
                </div> 
                


		<% }
}
}
%>
	</div>
</div>
		
		
		</section>
		<br>
		<div>
			<center>
                    <p style="font-size:1vw;"><a href="/web/crowd-funding/campaigns" ><button accesskey="" style="border:1px solid #7FBD2C;margin-top:5px; border-radius:20px;background-color: #7FBD2C;color:black;width:17%;height:40px;font-family: georgia;color: white;font-size: large;">More Campaign</button></a></p>
           </center>
			<!-- <a href="/web/crowd-funding/campaigns" ><button style="float:center;"> More Campaign </button></a> -->
		</div>
	</div>
	<!--end of section 2-->
	

    
	<div class="section_3_content " id="grad2" style="height:525px;">
		<!--start of section3-->
		<br/>
		<CENTER><B style="font-size: 3vw;color:white;">PEOPLE SPEAK</B></CENTER>
		<div class="slideshow-container1">
			<div class="mySlides1 fade1">
			<div style="width:18%;height:40%;margin-left:180px;margin-top:160px;max-height:250px;">
			 <!-- <img class="trial" src="\portal_content\Education.jpg" /> --> </div>
				<div class="text_section2">" Thank you for helping me fulfill my dreams to go to school"</div>
			</div>
			<!--close of myslides1 fade1-->

			<div class="mySlides1 fade1" style="width:18%;height:40%; margin-left:180px;margin-top:160px;max-height:250px;"><!-- <img class="trial1" src="\portal_content\kid_hospital.jpg"  /> -->
				<div class="text_section2">" Thank you for helping me to get well soon"</div>
			</div>
			<!--close of myslides1 fade1-->

			<div class="mySlides1 fade1" style="width:18%;height:40%;margin-top:160px;max-height:250px;margin-left: 160px;margin-left: -28px;;"><!-- <img class="trial2" src="\portal_content\agri_draught.jpg"  /> -->
				<div class="text_section2">" Thank you for helping us to solve our agricultural issues"</div>
			</div>
			<!--close of myslides1 fade1--><a class="prev1" onclick="plusSlides1(-1)" style="color: #0077A2;"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="next1" onclick="plusSlides1(1)" style="color: #7FBD2C;"><span class="glyphicon glyphicon-chevron-right"></a>
		</div>
	</div>

	<div class="section4 content" id="section4">
	<h1 style="color:white;font-size:4vw;padding:0px;">HOW QUICKDAAN WORKS</h1>
	</div>
	<div class="section5 content" style="position: relative; left: 0; top: 0;"><img class="fishes" src="\portal_content\Timeline.png" style="width:100%; height:50%;" /></div>
	
	
<div class="content content" style="height:400px;">
<center>
<h1 style="height:100px;padding: 10px;color:#0077A2;font-size:4vw;">CAUSES YOU CAN SUPPORT</h1>
</center>

<div class="container ">
<section class="customer-logos slider">
<div class="slide"><img class="community" src="\portal_content\community welfare.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" />
<a href="" style="font-size:1.1vw;color:#0077A2;margin-left:20px;">Community Welfare</a></div>

<div class="slide"><img class="rural" src="\portal_content\Rural_Development.JPG" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size:1.1vw;color:#0077A2;margin-left:20px;">Rural Development</a></div>

<div class="slide"><img class="senior" src="\portal_content\senior-citizen.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;color:#0077A2;margin-left:35px;">Senior Citizens</a></div>

<div class="slide"><img class="animals" src="\portal_content\stray animals.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;color:#0077A2;margin-left:60px;">Animals</a></div>

<div class="slide"><img class="disability" src="\portal_content\inclusivity.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;margin-left:50px;color:#0077A2;margin-left:40px;">Disability</a></div>

<div class="slide"><img class="emergencies" src="\portal_content\emergencies.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;align-items: center;margin-left:40px;color:#0077A2;">Emergencies</a></div>

<div class="slide"><img class="welfare" src="\portal_content\community welfare.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;color:#0077A2;margin-left:20px;">Community Welfare</a></div>

<div class="slide"><img class="development" src="\portal_content\Rural_Development.JPG" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;color:#0077A2;margin-left:20px;">Rural Development</a></div>

<div class="slide"><img class="citizens" src="\portal_content\senior-citizen.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;color:#0077A2;margin-left:35px;">Senior Citizens</a></div>

<div class="slide"><img class="animals1" src="\portal_content\stray animals.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;margin-left:60px;color:#0077A2;">Animals</a></div>

<div class="slide"><img class="disability1" src="\portal_content\inclusivity.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;margin-left:50px;color:#0077A2;">Inclusivity</a></div>

<div class="slide"><img class="emergencies" src="\portal_content\emergencies.jpg" style="width:100%;height:200px;border-radius:100%;border:5px solid #0077A2;" /> <a href="" style="font-size: 1.1vw;margin-left:40px;color:#0077A2;">Emergencies</a></div>
</section>
</div><!--close of container-->
</div>
	
	
<div class="footer" style="background-color:#002a3a;"><!--start of footer-->
<div class="row">
<div class="column" style="font-size:1.2vw;color:white">
<a href="about_us.html" style="color:white;">About</a><br />
<a href="about_us.html" style="color:white;">Overview</a><br />
<a href="about_us.html" style="color:white;">Team</a><br />
<a href="PrivacyPolicy.html" style="color:white;">Privacy Policy</a><br />
<a href="Disclaimer.html" style="color:white;">Terms &amp; Conditions</a></div>

<div class="column" style="font-size:1.2vw;color:white">
<a href="Security.html" style="color:white;">Security</a><br />
<a href="#" style="color:white;">Fundraising Tips</a><br />
<a href="#" style="color:white;">Pricing</a><br />
<a href="#" style="color:white;">Fundraising FAQ's</a><br />
<a href="#" style="color:white;">Donate Now</a></div>

<div class="column" style="font-size:1.2vw;color:white"><a href="#" style="color:white;">Start a Fundraiser</a><br />
<a href="#" style="color:white;">ADDRESS</a><br />
&nbsp;
<p class="addressp" style="line-height:1px;font-size:1vw;">184 &amp; 185, EPIP Zone,</p>

<p class="addressp" style="line-height:1px;font-size:1vw;">Whitefield, Bengaluru,</p>

<p class="addressp" style="line-height:1px;font-size:1vw;">Karnataka 560066</p>
</div>

<div class="column" style="font-size:1.2vw;color:white"><a href="#" style="color:white;">CONTACT US</a><br />
&nbsp;
<p class="addressp" style="line-height:1px;font-size:1vw;">Phone: 080818 80033</p>

<p class="addressp" style="line-height:1px;font-size:1vw;">quickdaan@gmail.com</p>
</div>
</div>
</div>	
</body></html>


<script>
		
		var slideIndex1 = 1;
		showSlides1(slideIndex1);

		function plusSlides1(n) {
			showSlides1(slideIndex1 += n);
		}

		function currentSlide1(n) {
			showSlides1(slideIndex1 = n);
		}

		function showSlides1(n) {
			var i;
			var slides = document.getElementsByClassName("mySlides1");
			var dots = document.getElementsByClassName("dot");
			if (n > slides.length) {
				slideIndex1 = 1
			}
			if (n < 1) {
				slideIndex1 = slides.length
			}
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex1 - 1].style.display = "block";
			dots[slideIndex1 - 1].className += " active";
		}

	</script><!--last carousel set of 5 images-->
	
	
<script>
$(document).ready(function(){
  $('.customer-logos').slick({
    slidesToShow: 5,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    arrows: false,
    dots: false,
    pauseOnHover: false,
    responsive: [{
      breakpoint: 768,
      settings: {
        slidesToShow: 4
      }
    }, {
      breakpoint: 520,
      settings: {
        slidesToShow: 3
      }
    }]
  });
});
</script><!--start of sticky navbar script-->

<script>
$(document).ready(function(){
  $('.customer-logos1').slick({
    slidesToShow: 4,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
    arrows: false,
    dots: false,
    pauseOnHover: false,
    responsive: [{
      breakpoint: 768,
      settings: {
        slidesToShow: 4
      }
    }, {
      breakpoint: 520,
      settings: {
        slidesToShow: 3
      }
    }]
  });
});
</script><!--start of sticky navbar script-->

<script>
window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>