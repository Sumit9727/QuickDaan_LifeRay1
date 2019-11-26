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

<h1> This fundraiser will benefit for</h1>
<aui:form>

	<portlet:renderURL var="MyselfURL" windowState="normal">
		<portlet:param name="Myself" value="Myself" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/MyselfCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${MyselfURL}"  value="Myself"/>
	
	
	<br><br>My Family, <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="Individual" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/FamilyIndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}"  value="Individual"/>
	
	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FamilyGroup" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}"  value="Group"/>
	
	<br><br>My Friend, <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="FriendIndividual" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}"  value="Individual"/>
	
	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="FriendGroup" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}"  value="Group"/>
	
	<br><br>Other, <br>
	<portlet:renderURL var="IndividualURL" windowState="normal">
		<portlet:param name="Individual" value="OtherIndividual" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/IndividualCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${IndividualURL}"  value="Individual"/>
	
	<portlet:renderURL var="GroupURL" windowState="normal">
		<portlet:param name="Group" value="OtherGroup" />
		<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/GroupCategoryData.jsp" />
	</portlet:renderURL>
	<aui:button type="button" onClick="${GroupURL}"  value="Group"/>

</aui:form>
