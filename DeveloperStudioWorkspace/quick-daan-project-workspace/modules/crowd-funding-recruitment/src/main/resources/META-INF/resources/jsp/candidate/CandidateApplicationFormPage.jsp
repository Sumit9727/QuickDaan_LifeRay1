<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/jsp/candidate/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:actionURL name="applyForNewJob" var="applyForNewJobURL">
</portlet:actionURL>
<%
long PositionId = ParamUtil.getLong(renderRequest,"PositionId");
PositionRegistration positionDetailObj = PositionRegistrationLocalServiceUtil.findByPOSITION_ID(PositionId);
%>
<aui:form action="${applyForNewJobURL}" method="post" enctype="multipart/form-data">
	<aui:input type="hidden" value="<%=PositionId %>" name="PositionId" />
	<aui:input type="text" name="candidateName" label="Candidate Name"></aui:input>
	<aui:input type="email" name="candidateEmail" label="Email"></aui:input>
	<aui:input type="number" name="mobileNumber" label="Mobile Number"></aui:input>
	<aui:input type="text" name="currentLocation" label="Currenet Location"></aui:input>
	<aui:input type="text" name="experience" label="Experience"></aui:input>
	<aui:input type="file" name="resume" label="Upload Resume"></aui:input>
	
	<aui:button name="submit" type="submit" value="submit" />
	
</aui:form>