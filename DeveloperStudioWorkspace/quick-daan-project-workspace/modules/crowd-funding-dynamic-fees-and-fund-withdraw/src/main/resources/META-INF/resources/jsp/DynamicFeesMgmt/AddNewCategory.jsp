<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<style>
.AddNewCategory{
 border: 1px solid #7FBD2C;
 box-shadow: 0 0 10px 1px #7FBD2C;
 border-style: solid;
 border-color:white;
 margin-top: -4px;
 background-color:white;
 margin:40px; 
 padding: 50px;
 width: 520px;
 margin-left: 25%
}

.box{
border-color: #7FBD2C; 
border-radius:12px; 
border-bottom:3px solid #7FBD2C;
}
</style>				

<div class="AddNewCategory">
<center><h1 style="color:#0077A2;">DYNAMIC FEE REGISTRATION</h1></center></br>

<portlet:actionURL name="CreateCategoryDetails" var="CreateCategoryDetailsURL" />
<aui:form action="${CreateCategoryDetailsURL}" method="post">

	<aui:input cssClass="box" type="text" name="categoryName" label="Category Name">
	<aui:validator name="required"/>
    <aui:validator name="alpha" errorMessage="Enter only charaters."/>
	</aui:input>
	
	<aui:input cssClass="box" pattern="^100(\.0{1,2})?$" type="number" name="processFees" label="Processing Fees(%)">
	<aui:validator name="required" errorMessage="Enter only one point"/>
    <aui:validator name="digit"/>    
    <aui:validator name="range">[0,100]</aui:validator>
	</aui:input>
	
	<aui:input cssClass="box" pattern="^100(\.0{1,2})?$" type="number" name="projectFees" label="Project Fees(%)">
	<aui:validator name="required" errorMessage="Enter only one point"/>
    <aui:validator name="digit"/>
    <aui:validator name="range">[0,100]</aui:validator>
	</aui:input>
	
	<aui:input cssClass="box" pattern="^100(\.0{1,2})?$" type="number" name="paymentGateway" label="Payment Gateway(%)">
	<aui:validator name="required" errorMessage="Enter only one point"/>
    <aui:validator name="digit "/>
    <aui:validator name="range">[0,100]</aui:validator>
	</aui:input>
	
	<aui:button type="submit" value="Submit"style="background-color: #0077A2;margin-left: 35%; border-radius:22px"></aui:button>
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" style="border-radius:22px;"/>

</aui:form>
</div>