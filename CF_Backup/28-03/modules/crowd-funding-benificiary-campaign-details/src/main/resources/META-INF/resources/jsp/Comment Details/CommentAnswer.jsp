<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
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
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(commentRegistration.getPROJECT_ID());
UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectObj.getUSER_ID());
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<portlet:actionURL var="commentAnswerURL" name="commentAnswer"></portlet:actionURL>

<style>
<!--
.commentAnswer{
	border-top:3px solid #7FBD2C;
	border-right:3px solid #7FBD2C;
	border: 1px solid #7FBD2C;
    box-shadow: 0 0 10px 1px #7FBD2C;
    border-style: solid;
    border-color:white;
    margin-top: -4px;
    background-color:white;
    margin:40px; 
    padding: 50px;
    max-width: 600px;
    width:100%;
    margin-left: 25%;  
}
.boxField{
    border-radious:12px;
    background-clip: border-box;
    border-color: #7FBD2C;
    border-style: solid;
    border-width: 0.0625rem 0.0625rem 0.0625rem 0.0625rem;
    height: 2.5rem;
    min-width: 0;
    padding-bottom: 0.5rem;
    padding-top: 0.5rem;
    padding-left: 1rem;
    padding-right: 1rem;
    border-radius: 12px;
 	border-bottom:3px solid #7FBD2C;
    }
.label {
    color: #0077A2;
    font-size: 0.875rem;
    font-weight: 600;
    margin-bottom: 0.25rem;
    max-width: 100%;
    word-wrap: break-word;
}
.submit{
background-color:#0077A2;
border-radius: 22px;
color:white;
width: 108px;
height: 39px;
}

.reject{
background-color:#0077A2;
border-radius: 22px;
color:white;
width: 108px;
height: 39px;
}

.cancel{
border-radius: 22px;
}
    
-->
</style>

<portlet:actionURL var="commentRejectURL" name="commentReject">
	<portlet:param name="commentID" value="<%= String.valueOf(commentRegistration.getPROJECT_COMMENT_ID()) %>" />
	</portlet:actionURL>
	
<div class="commentAnswer" style="border-top:3px solid #7FBD2C;border-right:3px solid #7FBD2C;">
<CENTER><h1 style="color:#0077A2"> <%= projectObj.getTITLE() %> </h1></CENTER>

<style>
table, th, td {
  border: 1px solid black;
}
</style>
<table  style="width:100%">
<tr>
<td>Project Title :</td>
<td> <%= projectObj.getTITLE() %></td>
</tr>

<tr>
<td>Name :</td>
<td><%= userObj.getFULL_NAME() %></td>
</tr>

<tr>
<td>Date :</td>
<td> <%= formatter.format(commentRegistration.getCOMMENT_DATE()) %></td>
</tr>

<tr>
<td>Comment Details :</td>
<td> <%= commentRegistration.getCOMMENT() %></td>
</tr>


<% if(commentRegistration.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_0){ %>
<aui:form action="${commentAnswerURL}" method="post">
	<aui:input type="hidden" name="commentID" value="<%= commentRegistration.getPROJECT_COMMENT_ID() %>" />
			<tr>
				<td>Comment Answer
				</td>
				<td>
					<aui:input cssClass="boxField" name=" " type="textarea" style="height:100px;margin-top: 15px;margin-bottom: -10px;"></aui:input> 
				</td>
			</tr>
</aui:form>
</table></br>
			
		        <aui:button cssClass="submit" type="submit" value="Approve"style="margin-left:80px;"/>
				<aui:button cssClass="reject" type="submit" value="Reject" onClick="${commentRejectURL}"/>
						
<% }if(commentRegistration.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1){ %>
<th>Comment Replay : <%= commentRegistration.getANSWER() %></th></br>
<% }%>

<aui:button cssClass="cancel" type="cancel" value="cancel" onClick="window.history.back();"/>
</div>

