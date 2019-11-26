<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
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

<portlet:defineObjects />

<portlet:renderURL var="sucess" windowState="normal" >
	<portlet:param name="jspPage" value="/jsp/BenificiaryDetails/BenificiaryCategory.jsp" />
</portlet:renderURL>

<%
 String projectID = renderRequest.getParameter("projectID"); 
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
%>
<div class="projectSucessfully">
<h6>Quick Daan</h6>
<hr>

<label style="font-size: 26px;">Your campaign name  <u><%= projectRegistration.getTITLE() %></u> for fund Amount INR. <u>
 <%= Math.round(projectRegistration.getREQUIRED_FUND_AMOUNT()) %></u>/- is successfully registered on Quick Daan.</label>


<br>
<br>
<center> <strong>We will review details. Wait till Approval.</strong></center>
<br>
<br>

<h8>
<strong>Note : Your Project is registered under normal project service fees(processing fees 6%, project fees 0%, payment gateway charges 2%) on your campaign required fund amount.
You can change your category from MyCampaign page. After approval from Quick Daan team. </strong>
</h8>
<br>
<br>
<center><aui:button type="submit" value="Finish"  style="background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"  onClick="${sucess}" /></center>
</div>