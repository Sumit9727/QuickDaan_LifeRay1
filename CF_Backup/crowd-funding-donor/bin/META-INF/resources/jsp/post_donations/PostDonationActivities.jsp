<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/jsp/post_donations/init.jsp" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
long ProjectId = 101;
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
List<FundRegistration> fundList = FundRegistrationLocalServiceUtil.findByPROJECT_DONOR_USER_ID(ProjectId, td.getUserId());
if(fundList.size() > 0){
%>
			<% }%>
			
			<portlet:renderURL var="AskAQuestionURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/Q&A/AskQuestion.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${AskAQuestionURL}"  value="Question?"/>
			
			 <portlet:renderURL var="FeedbackURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/feedback/Feedback.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${FeedbackURL}"  value="Feedback"/>
			
			
			<portlet:actionURL name="updateRequestRegistration" var="updateRequestRegistrationURL" >
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
			</portlet:actionURL>
			<aui:button type="button" onClick="${updateRequestRegistrationURL}"  value="Ask for an Update"/>