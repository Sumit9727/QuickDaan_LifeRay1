<%@page import="java.util.Collections"%>
<%@page import="com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectUpdateRegistration"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/jsp/MyCampaign/init.jsp" %>
<portlet:defineObjects />

<% 
long ProjectId = Long.parseLong(renderRequest.getParameter("ProjectId"));
List<ProjectUpdateRegistration> projectUpdateList = ProjectUpdateRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);

Collections.reverse(projectUpdateList);
int counter = 1;
%>

<style>
.a {
 box-shadow: 0 0 10px 1px #d3d3d3;
    border: 1px solid #cecece;
    border-style: solid;
    padding: 18px;
    background-color: gainsboro;
 width: 1120px;
    margin-left: 35px;
 }
 
 .form-control {
 background-color: white;
 border-radius: 21px;
 }
 
 label {
    color: black;
    font-size: 20px;
    font-weight: 600;
    }
    .h3{
     color:#9c3353;
    }
    
    h1{
    margin-left: 140px;
     color:#9c3353;
    }
    .sheet-text {
    color:#9c3353;
   
    }
    .sheet{
    border-radius: 21px;
    }
 </style>
 <div class="a">
 <h1><center>Project Update</center></h1>
 <liferay-ui:search-container delta="10" deltaConfigurable="<%= true %>" emptyResultsMessage="NO RECORDS FOUND" iteratorURL="<%= renderResponse.createRenderURL() %>" total="<%= projectUpdateList.size() %>">
		<liferay-ui:search-container-results results="<%=ListUtil.subList(projectUpdateList,searchContainer.getStart(),searchContainer.getEnd()) %>"/> 
 			<liferay-ui:search-container-row   className="com.crowd.funding.database.model.ProjectUpdateRegistration"   modelVar="projectUpdateObj">
         <liferay-ui:search-container-column-text name="No" value="<%= String.valueOf(counter) %>" />
         <liferay-ui:search-container-column-text name="Update Details" property="UPDATE_DETAILS" />
         <liferay-ui:search-container-column-text name="Date" property="UPDATE_DATE" />
         <% counter++ ; %>
   </liferay-ui:search-container-row>
<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>


<br><H3> Add More Update </H3><br>

<portlet:actionURL name="projectUpdateRegistration" var="projectUpdateRegistrationURL" />

<aui:form action="${projectUpdateRegistrationURL}" method="post" >
	
	<aui:input name="projectId" type="hidden" value="<%= ProjectId %>"></aui:input>
	<aui:input name="projectUpdate" type="textarea"  label="Project Update"></aui:input>
	
	<aui:button name="submit" type="submit" value="Submit Update" />
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>
</div>

