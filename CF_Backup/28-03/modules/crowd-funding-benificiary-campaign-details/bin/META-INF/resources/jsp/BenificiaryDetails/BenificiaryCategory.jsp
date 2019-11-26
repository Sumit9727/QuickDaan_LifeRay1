<%@ include file="/init.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<%-- <style>
 .Benificary Category {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 40px;
    background-color:white;
    width: 550px;
    margin-left: 298px;
}
 h1, .h1 {
 font-size: 120%;
    margin-left: 431px;
    color:#333333;
    }
    .text-dark {
    color: #272834 !important;
    margin-left: -12px;
}
</style>
--%>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<liferay-theme:defineObjects />

<portlet:defineObjects />

<div>
<h3>This fundraiser will benefit for</h3>
<br>
<hr>
<aui:form>
<div class="BenificaryCategory">
        <portlet:renderURL var="MyselfURL" windowState="normal">
		<portlet:param name="Myself" value="myself" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/MyselfCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm1" type="button"  onClick="${MyselfURL}" value="Myself" /> 
	
	<br>

	<br><strong>My Family, </strong> <small>family and closest relatives</small><br>
	
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="Individual" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/FamilyIndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm2" type="button" onClick="${IndividualURL}" value="Individual" />

	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FamilyGroup" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm2" type="button" onClick="${GroupURL}" value="Group" />

	<br>
	<br><strong>My Friends, </strong><small>classmates, colleagues and people I know </small><br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="FriendIndividual" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm2"  type="button" onClick="${IndividualURL}" value="Individual"/>

	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FriendGroup" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm2"  type="button" onClick="${GroupURL}" value="Group" />

	<br>
	<br><strong>Other, </strong><small>(anyone/anything)</small> <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="OtherIndividual" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm2"  type="button" onClick="${IndividualURL}" value="Individual" />

	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="OtherGroup" />
		<portlet:param name="jspPage"
			value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button cssClass="borderForm2"  type="button" onClick="${GroupURL}" value="Group" />

</aui:form>

</div>
 