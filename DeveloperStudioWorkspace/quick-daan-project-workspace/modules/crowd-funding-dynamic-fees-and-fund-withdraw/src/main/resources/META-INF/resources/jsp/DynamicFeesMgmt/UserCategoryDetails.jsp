<%@page import="com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DynamicFeesRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFeesRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<%
long ProjectID = 901;
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectID);
List<ProjectFeesRegistration> feesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());

for(ProjectFeesRegistration feesRegistrationObj : feesRegistration){
	DynamicFeesRegistration dynamicObj = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(feesRegistrationObj.getCATEGORY_ID());
}
%>

Title : <%= projectRegistration.getTITLE() %>


