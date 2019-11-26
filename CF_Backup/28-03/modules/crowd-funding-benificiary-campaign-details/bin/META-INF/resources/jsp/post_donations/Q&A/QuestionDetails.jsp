<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserOTPRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.QuestionRegistration"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/jsp/post_donations/init.jsp" %>
<portlet:defineObjects />
   <style>
               .QuestionDetails{
              border: 1px solid #7FBD2C;
 box-shadow: 0 0 10px 1px #7FBD2C;
 border-style: solid;
 border-color:white;
 margin-top: -4px;
 background-color:white;
 margin:40px; 
 padding: 50px;
 width: 520px;
 margin-left: 30%;
  border-top:3px solid #7FBD2C;
   border-right:3px solid #7FBD2C;
			   }
               </style>
<%
long questionId = Long.parseLong(renderRequest.getParameter("QuestionId"));

QuestionRegistration questionObj = QuestionRegistrationLocalServiceUtil.findByPROJECT_QUESTION_ID(questionId);
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(questionObj.getPROJECT_ID());
UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(questionObj.getQUESTION_REQUESTER_USER_ID());
UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userObj.getUSER_OTP_ID());
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%> 

            <div Class="QuestionDetails">
			<table class="table table-striped table-bordered table-hover marginTopsmall";/>
					<tbody>
						<tr> 
							<th>Campaign Title </th>
							<td><%= projectObj.getTITLE() %></td>
						</tr>
						<tr>
							<th>Asked Question </th>
							<td><%= questionObj.getQUESTION() %></td>
						</tr>
						<tr>
							<th>Date of Question </th>
							<td><%= formatter.format(questionObj.getQUESTION_DATE()) %></td>
						</tr>
						<tr>
							<th>Requester Mail Id </th>
							<td><%= otpObj.getMAIL()%></td>
						</tr>
					</tbody>
				</table>
				</br>
				<aui:button type="cancel" value="cancel"style="border-radius:22px;background-color: #0077A2;margin-left: 35%;color: white" onClick="window.history.back();" />
             </div>