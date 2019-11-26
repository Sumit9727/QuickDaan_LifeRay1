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
--%>
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
	<img src="/portal_content/download.jpg" alt="img" class="avatar">
	<div style=" margin-left:202px; margin-top:-139px;"><aui:input name="image" type="file" label="Display Photo  "><aui:validator name="required"></aui:validator></aui:input></div>
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
	
	<aui:input cssClass="borderForm" name="age" label="Age  "   placeholder="Age"><aui:validator name="required" /><aui:validator name="number" /><aui:validator name="max">140</aui:validator></aui:input>
	 <aui:select cssClass="borderForm" name="Gender"   ><aui:validator name="required" /><aui:validator name="alpha"/>
		<aui:option value="Select" >Select</aui:option>
		<aui:option value="Mother" >Male</aui:option>
		<aui:option value="Father">Female</aui:option>
		<aui:option value="Parent">Others</aui:option>
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
