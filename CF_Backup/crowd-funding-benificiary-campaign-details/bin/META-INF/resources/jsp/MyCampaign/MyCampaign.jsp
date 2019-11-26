<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
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

<%
int counter = 1;
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
%>
 
 <liferay-ui:search-container delta="10" deltaConfigurable="<%= true %>" emptyResultsMessage="NO RECORDS FOUND" iteratorURL="<%= renderResponse.createRenderURL() %>" total="<%= projectList.size() %>">
		<liferay-ui:search-container-results results="<%=ListUtil.subList(projectList,searchContainer.getStart(),searchContainer.getEnd()) %>"/> 
 			<liferay-ui:search-container-row   className="com.crowd.funding.database.model.ProjectRegistration"   modelVar="projectObj">
         <liferay-ui:search-container-column-text name="No" value="<%= String.valueOf(counter) %>" />
         <liferay-ui:search-container-column-text name="Campaign Title" property="TITLE" />
         <liferay-ui:search-container-column-text name="Campaign Start Date" property="REQUIRED_FUND_AMOUNT" />
         <liferay-ui:search-container-column-text name="Fund Amount" property="CREATION_DATE" />
         	<portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/CampaignDetails.jsp" />
			</portlet:renderURL>
			<portlet:renderURL var="ProjectUpdateURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUpdate.jsp" />
			</portlet:renderURL>
         <liferay-ui:search-container-column-text name="Action" >
         			<aui:button value="Details" onClick="${ProjectDetailURL}" /></th>			
					<aui:button value="Project Update" onClick="${ProjectUpdateURL}" />
         </liferay-ui:search-container-column-text> 
         
         <% counter++ ; %>
   </liferay-ui:search-container-row>
<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container> 



	<%-- <table class="table marginTopsmall">
		<tbody>
			<tr style="background-color: #c0c0c038; border:1px solid #ddd">
				<th>Campaign  No.</th>
				<th>Campaign Title</th>
				<th>Fund Amount</th>
				<th>Action</th>
			</tr>
<%
for(ProjectRegistration projectObj : projectList){
%>
			<portlet:renderURL var="ProjectDetailURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/CampaignDetails.jsp" />
			</portlet:renderURL>
			<portlet:renderURL var="ProjectUpdateURL" windowState="normal" >
				<portlet:param name="ProjectId" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
				<portlet:param name="jspPage" value="/jsp/MyCampaign/ProjectUpdate.jsp" />
			</portlet:renderURL>
				<tr>
					<th><%= counter %></th>
					<th><%= projectObj.getTITLE() %></th>
					<th><%= projectObj.getREQUIRED_FUND_AMOUNT() %></th>
					<th><aui:button value="Details" onClick="${ProjectDetailURL}" /></th>			
					<th><aui:button value="Project Update" onClick="${ProjectUpdateURL}" /></th>			
				</tr>
				<%
				counter++;
				%>

<%
	}%>
 --%>