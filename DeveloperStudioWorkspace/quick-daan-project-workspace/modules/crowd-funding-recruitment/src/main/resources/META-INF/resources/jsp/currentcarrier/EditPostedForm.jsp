<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/jsp/currentcarrier/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:actionURL name="editPost" var="editPostURL">
</portlet:actionURL>
<%
long PositionId = ParamUtil.getLong(renderRequest,"PositionId");
PositionRegistration positionDetailObj = PositionRegistrationLocalServiceUtil.findByPOSITION_ID(PositionId);
%>
<aui:form action="${editPostURL}" method="post" >
	<aui:input type="hidden" value="<%=PositionId %>" name="PositionId" /> 
	<aui:input type="text" value="<%=positionDetailObj.getADVERTISMENT_NUM() %>" name="advertisementNumber" label="Advertisement Number"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getPOSITION_NAME() %>" name="positionName" label="Position Name"></aui:input>
	<aui:input type="textarea" value="<%=positionDetailObj.getDESCRIPTION() %>" name="description" label="Description"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getEXPERIENCE_LEVEL() %>" name="experienceLevel" label="Experience Level"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getSALARY() %>" name="salary" label="Salary"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getINDUSTRY_TYPE() %>" name="industryType" label="Industry Type"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getFUNCTIONAL_AREA() %>" name="functionalArea" label="Functional Area"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getROLE_CATEGORY() %>" name="rolecategory" label="Role Category"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getEMPLOYMENT_TYPE() %>" name="employmentType" label="Employment Type"></aui:input>
	<aui:input type="text" value="<%=positionDetailObj.getLOCATION() %>" name="location" label="Location"></aui:input>
	
	<aui:button name="submit" type="submit" value="submit" />
	
</aui:form>