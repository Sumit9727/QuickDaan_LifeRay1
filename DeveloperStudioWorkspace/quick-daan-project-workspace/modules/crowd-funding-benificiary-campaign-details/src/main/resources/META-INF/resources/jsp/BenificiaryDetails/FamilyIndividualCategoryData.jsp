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
var country_arr = new Array("Parents", "Sibling", "GrandParent","GrandChild","Child","Spouse" );

var s_a = new Array();
s_a[0]="";
s_a[1]="Father|Mother|Parent";
s_a[2]="Brother|Sister|Cousin";
s_a[3]="GrandFather|GrandMother";
s_a[4]="GrandSon|GrandDaughter";
s_a[5]="Son|Daughter";
s_a[6]="";

function print_country(country){
    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(country);
    option_str.length=0;
    option_str.options[0] = new Option('Select Category','');
    option_str.selectedIndex = 0;
    for (var i=0; i<country_arr.length; i++) {
    option_str.options[option_str.length] = new Option(country_arr[i],country_arr[i]);
    }
}

function print_state(state, selectedIndex){
    var option_str = document.getElementById(state);
    option_str.length=0;    // Fixed by Julian Woods
    option_str.options[0] = new Option('Select Relation','');
    option_str.selectedIndex = 0;
    var state_arr = s_a[selectedIndex].split("|");
    for (var i=0; i<state_arr.length; i++) {
    option_str.options[option_str.length] = new Option(state_arr[i],state_arr[i]);
    }
}
</script>

<script type="text/javascript">
$(function() {
	  $('#colors').click(function(){
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
	  if (checkBox.checked == true){
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

<%
String Individual = renderRequest.getParameter("Individual");
%>


<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>


<portlet:actionURL name="BenificiaryRelationIndividualFamily" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">


	
	<h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>Individual Family</U></a></div></h3>
	<hr>

<div class ="IndividualFamily">
	<h1>Individual Family</h1>
	<hr>
	
	<aui:input name="Individual"  type="hidden" value="<%= Individual %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" id ="blah" class="avatar">
	<div style=" margin-left:202px; margin-top:-139px;">
	<aui:input name="image" type="file" accept="image/*" onchange="readURL(this);" label="Display Photo  ">
	<aui:validator name="required"></aui:validator></aui:input></div>
	<br>
	<br>
	<hr>
	<aui:input cssClass="borderForm" name="name" label="Name  "  placeholder="Name" ><aui:validator name="required" /></aui:input>
	
	<strong>Relation Category </strong>
	<br>
	<select onchange="print_state('state',this.selectedIndex);" id="country" required="required"
	  Class="borderForm3"name ="<portlet:namespace/>Relationship"></select>
	<br/><br/>
	
	<strong>Relation Type </strong>
	<select name="<portlet:namespace/>RelationshipDetails" id ="state"  Class="borderForm3" required="required"></select><br/><br/>
	<script language="javascript">print_country("country");</script>
	
	<strong>If Benificiary Age is less than 1 : </strong>
	<label class="switch1">
	  <input type="checkbox" id="myCheck" onclick="myFunction()" ></input>
	  <span class="slider1 round"></span>
	</label>
	
	<div id="text1" >
		<strong>Benificiary Age Year : </strong> 
		<aui:select cssClass="borderForm" name="ageYear" label="">
			<% for(int i=1; i<=100; i++){ %>
				<aui:option value="<%= i %>" ><%= i %></aui:option>
			<% } %>
		</aui:select>
	</div>
	
	<div id="text2" style="display:none">
	<strong>Benificiary Age Month :</strong>
		<aui:select cssClass="borderForm" name="ageMonth" label="">
			<% for(int i=1; i<=12; i++){ %>
				<aui:option value="<%= i %>" ><%= i %></aui:option>
			<% } %>
		</aui:select>
	</div>
	
	 <aui:select cssClass="borderForm" name="Gender"   ><aui:validator name="required" /><aui:validator name="alpha"/>
		<aui:option value="Male" >Male</aui:option>
		<aui:option value="Female">Female</aui:option>
		<aui:option value="Others">Others</aui:option>
	</aui:select>
	<aui:input cssClass="borderForm" name="location" label="Location "  placeholder="Ex.Bangaluru"><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
	
	<hr>
	<div><strong>Contact details</strong></div><br>
	<aui:input cssClass="borderForm" name="contectName" label="Name  "   ><aui:validator name="required" /></aui:input>
	<aui:input cssClass="borderForm" name="number" label="Mobile Number  " ><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="maxLength">10</aui:validator></aui:input>
	
	<div style="margin-left: 235px;"><aui:button type="submit" onsubmit="return validateForm()" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
	<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; " onClick="window.history.back();" /></div>
	</div>
</aui:form>

 
<%--  
 
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

<script type="text/javascript">
var country_arr = new Array("Parents", "Sibling", "GrandParent","GrandChild","Child","Spouse" );

var s_a = new Array();
s_a[0]="";
s_a[1]="Father|Mother|Parent";
s_a[2]="Brother|Sister|Cousin";
s_a[3]="GrandFather|GrandMother";
s_a[4]="GrandSon|GrandDaughter";
s_a[5]="Son|Daughter";
s_a[6]="";

function print_country(country){
    //given the id of the <select> tag as function argument, it inserts <option> tags
    var option_str = document.getElementById(country);
    option_str.length=0;
    option_str.options[0] = new Option('Select Category','');
    option_str.selectedIndex = 0;
    for (var i=0; i<country_arr.length; i++) {
    option_str.options[option_str.length] = new Option(country_arr[i],country_arr[i]);
    }
}

function print_state(state, selectedIndex){
    var option_str = document.getElementById(state);
    option_str.length=0;    // Fixed by Julian Woods
    option_str.options[0] = new Option('Select Relation','');
    option_str.selectedIndex = 0;
    var state_arr = s_a[selectedIndex].split("|");
    for (var i=0; i<state_arr.length; i++) {
    option_str.options[option_str.length] = new Option(state_arr[i],state_arr[i]);
    }
}
</script>

<<script type="text/javascript">

$(function() {
	  $('#colors').click(function(){
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
	  if (checkBox.checked == true){
	    text1.style.display = "none";
	    text2.style.display = "block";
	  } else {
	    text1.style.display = "block";
	    text2.style.display = "none";
	  }
	}
	
$(document).ready(function(){
    $("#inputTextBox5").keypress(function(event){
        var inputValue = event.which;
        // allow letters and whitespaces only.
        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
            event.preventDefault(); 
        }
    });
});


$(document).ready(function(){
    $("#inputTextBox6").keypress(function(event){
        var inputValue = event.which;
        // allow letters and whitespaces only.
        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { 
            event.preventDefault(); 
        }
    });
});

$(document).ready(function(){
    $("#inputTextBox7").keypress(function(event){
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

.portlet-decorate .portlet-content {
    background-color: #5d5d5d29;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 24px;
}
   
</style>


<%
String Individual = renderRequest.getParameter("Individual");
%>


<portlet:renderURL var="ViewImages" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>


<portlet:actionURL name="BenificiaryRelationIndividualFamily" var="BenificiaryRelationURL" />
<aui:form action="${BenificiaryRelationURL}" method="post" enctype="multipart/form-data">


	
	<h3><div id="red" class="colors red"> This fundraiser will benefit <a href="${ViewImages}"><U>Individual Family</U></a></div></h3>
	<hr>

<div class ="IndividualFamily">
	<h1>Individual Family</h1>
	<hr>
	
	<aui:input name="Individual"  type="hidden" value="<%= Individual %>"></aui:input>
	<img src="/portal_content/download.jpg" alt="img" id ="blah" class="avatar">
	<div style=" margin-left:202px; margin-top:-139px;">
	<aui:input name="image" type="file" accept="image/*" onchange="readURL(this);" label="Display Photo  ">
	<aui:validator name="required"></aui:validator></aui:input></div>
	<br>
	<br>
	<hr>
	
	<strong>Name  </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox5" required="required"  name="name" style="padding: 5px;"   >
	 </input>
	 <br>
	 <br>
 
	
	
	<aui:input cssClass="borderForm" name="name" label="Name  "  placeholder="Name" >
	<aui:validator name="required" />
	<aui:validator name="alpha"/>
	</aui:input>
	
	<strong>Relation Category </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<select onchange="print_state('state',this.selectedIndex);" id="country" required="required"
	  Class="borderForm3"name ="<portlet:namespace/>Relationship"></select>
	<br/><br/>
	
	<strong>Relation Type </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<select name="<portlet:namespace/>RelationshipDetails" id ="state"  Class="borderForm3" required="required"></select><br/><br/>
	<script language="javascript">print_country("country");</script>
	
	
	<div>
	<strong>If Benificiary Age is less than 1 </strong>
	<label class="switch1">
	  <input type="checkbox" id="myCheck" onclick="myFunction()" ></input>
	  <span class="slider1 round"></span>
	</label>
	</div>
	
	
	<div id="text1" >
		<strong>Select Age Year : </strong> 
		<aui:select cssClass="borderForm" name="ageYear" label="">
			<h3>Select Year</h3>
			<% for(int i=1; i<=100; i++){ %>
				<aui:option value="<%= i %>" ><%= i %></aui:option>
			<% } %>
		</aui:select>
	</div>
	
	<div id="text2" style="display:none">
	<strong>Select Age Month :</strong>
		<aui:select cssClass="borderForm" name="ageMonth" label="">
			<h3>Select Month</h3>
			<% for(int i=1; i<=12; i++){ %>
				<aui:option value="<%= i %>" ><%= i %></aui:option>
			<% } %>
		</aui:select>
	</div>
	
	 <aui:select cssClass="borderForm" name="Gender"   ><aui:validator name="required" /><aui:validator name="alpha"/>
		<aui:option value="Select" >Select</aui:option>
		<aui:option value="Male" >Male</aui:option>
		<aui:option value="Female">Female</aui:option>
		<aui:option value="Others">Others</aui:option>
	</aui:select>
	
	<strong>location</strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox6" required="required"  name="location" style="padding: 5px;"   >
	 </input>
	 <br>
	 <br>
	
	<aui:input cssClass="borderForm" name="location" label="Location "  placeholder="Ex.Bangaluru"><aui:validator name="required" /><aui:validator name="alpha"/></aui:input>
	
	<hr>
	<div><strong>Contact details</strong></div><br>
	
	<aui:input cssClass="borderForm" name="contectName" label="Name  "   >
	<aui:validator name="required" />
	<aui:validator name="alpha"/>
	</aui:input>
	
	<strong>Name </strong><span style="color:#e20c0c;font-size: 0.875rem;">*</span>
	<br>
	<input Class="bordercity" id="inputTextBox7" required="required"  name="name" style="padding: 5px;"   >
	 </input>
	 <br>
	 <br>
	
	
	
	<aui:input cssClass="borderForm" name="number" label="Mobile Number  " onkeypress="phoneno()" minlength="10" maxlength="10" pattern="[0-9]{1}[0-9]{9}" title="Format:Minimum of 10 number is required" >
	<aui:validator name="required"/>
	<aui:validator name="minLength" />
    <aui:validator name="number"/>
    </aui:input>
	
	<div style="margin-left: 235px;"><aui:button type="submit" onsubmit="return validateForm()" value="Next" style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"></aui:button>
	<aui:button type="cancel" value="cancel" style="background-color:white; color:#0077A2;border-radius: 100px;width: 100px; " onClick="window.history.back();" /></div>
	</div>
	</aui:form> --%>