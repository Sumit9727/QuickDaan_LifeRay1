<%@page import="java.util.Collections"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
String commentID = renderRequest.getParameter("commentID");
CommentRegistration commentRegistration = CommentRegistrationLocalServiceUtil.findByPROJECT_COMMENT_ID(Long.parseLong(commentID));
%>

<portlet:actionURL var="commentAnswerURL" name="commentAnswer"></portlet:actionURL>
<aui:form action="${commentAnswerURL}" method="post">
	<aui:input type="hidden" name="commentID" value="<%= commentRegistration.getPROJECT_COMMENT_ID() %>"></aui:input>
	<table>
		<tbody>
		<tr style="background-color: #c0c0c038; border:1px solid #ddd">
			<th>Comment Data : <%= commentRegistration.getCOMMENT() %></th>
			<th><aui:input name="answer" label="Comment Answer : " type="text"></aui:input> </th>
			<th><aui:button type="submit" value="Submit"  /></th>
			<th><aui:button type="cancel" value="cancel" onClick="window.history.back();" /></th>
		</tr>
		</tbody>
	</table>
</aui:form>