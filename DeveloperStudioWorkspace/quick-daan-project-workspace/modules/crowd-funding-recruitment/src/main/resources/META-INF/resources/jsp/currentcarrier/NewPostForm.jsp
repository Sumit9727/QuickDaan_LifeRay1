<%@ include file="/jsp/currentcarrier/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:actionURL name="addNewPost" var="addNewPostURL">
</portlet:actionURL>

<aui:form action="${addNewPostURL}" method="post" >
	<aui:input type="text" name="advertisementNumber" label="Advertisement Number"></aui:input>
	<aui:input type="text" name="positionName" label="Position Name"></aui:input>
	<aui:input type="textarea" name="description" label="Description"></aui:input>
	<aui:input type="text" name="experienceLevel" label="Experience Level"></aui:input>
	<aui:input type="text" name="salary" label="Salary"></aui:input>
	<aui:input type="text" name="industryType" label="Industry Type"></aui:input>
	<aui:input type="text" name="functionalArea" label="Functional Area"></aui:input>
	<aui:input type="text" name="rolecategory" label="Role Category"></aui:input>
	<aui:input type="text" name="employmentType" label="Employment Type"></aui:input>
	<aui:input type="text" name="location" label="Location"></aui:input>
	
	<aui:button name="submit" type="submit" value="submit" />
	
</aui:form>