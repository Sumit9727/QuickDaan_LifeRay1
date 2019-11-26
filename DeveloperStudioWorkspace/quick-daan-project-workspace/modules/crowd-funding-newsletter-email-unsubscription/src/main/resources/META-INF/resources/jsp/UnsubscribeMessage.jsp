<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ include file="/jsp/init.jsp" %>
<portlet:defineObjects />

<%
String email = (String) renderRequest.getAttribute("email");
%>

You have chosen to not to receive newsletter communication from us,
Your email <%= email %> now unsubscribed.