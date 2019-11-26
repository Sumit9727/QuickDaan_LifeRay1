<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="com.crowd.funding.database.model.FundAccountRegistration"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ImageRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.ProjectPriorityRegistration"%>
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


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    
<liferay-theme:defineObjects />

<portlet:defineObjects />
<style>


.container1 {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
  
}

.container1::after {
  content: "";
  clear: both;
  display: table;
}

.container1 img {
  float: left;
  max-width: 60px;
  width: 100%;
  margin-right: 20px;
  border-radius: 50%;
}

.container1 img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-left {
  float: left;
  color: #999;
}

.time-right {
  float: right;
  color: #999;
}
</style>

<% 
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

float donatedAmount = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());

for(FundRegistration fundAmtObj : fundAmtList){
	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}

float donatedAmountInPercentage = (donatedAmount*100)/projectRegistration.getREQUIRED_FUND_AMOUNT();

/* int daysLeft = (int) ((projectRegistration.getEND_DATE().getTime() - projectRegistration.getCREATION_DATE().getTime())/(1000*60*60*24)); */
%>
						<!-- CAMPAIGN DETAILS -->

				<table>
				  <tr>
					    <portlet:resourceURL  var="imageResourceURL">
							<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
							<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(projectRegistration.getPROJECT_ID())  %>"/>
						</portlet:resourceURL>
					<td>Benificiary Photo :</td>
					<td><img src="${imageResourceURL}" alt="Image" /></td>
				  </tr>
				  
				  <tr>
				    	<th>Title : <%= projectRegistration.getTITLE() %></th>
				  </tr>
				  <tr>
				    	<th>Story :<br><%= projectRegistration.getDESCRIPTION() %></th>
				  </tr>
				  
				  <tr> 
				  <td>Project Document :<br></td>
					  <%
					  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					  for(DocumentRegistration documentObj : documentList){
					  %>
						 <portlet:resourceURL  var="ProjectDocumentResourceURL">
							<portlet:param name="serverResourceCall" value="ProjectIDForDocument"/>
							<portlet:param name="ProjectDocumentID" value="<%= String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  %>"/>
						 </portlet:resourceURL>
				    <td><a href="${ProjectDocumentResourceURL}" alt="Document" />Document</td>
				  </tr>
				  	<% } %>
				  
				  <tr>
				    	<td>Posted By : <%= userData.getFullName() %></td>
				  </tr>
				  <tr>
				    	<td>Required Fund Amount : <%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></td>
				  </tr>
				  <tr>
				   		<td>Total Received Amount : <%= donatedAmount %></td>
				  </tr>
				  <tr>
				    	<td><div style="margin-left: 17px; margin-top: 17px; height: 27px;">
				    			<label><%= donatedAmountInPercentage %></label>
				    			<progress value=<%= donatedAmount %> max=<%= projectRegistration.getREQUIRED_FUND_AMOUNT() %> ></progress>
				    	</div> 
				    	</td>
				  </tr>
				 
				</table>

					<!-- DONATE OPTION FOR NOT LOGGED IN USER -->
<%
long ProjectId = Long.parseLong(projectID);
ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<FundRegistration> fundList = FundRegistrationLocalServiceUtil.findByPROJECT_DONOR_USER_ID(ProjectId, themeDisplayObj.getUserId());
if(fundList.size() > 0){
%>

			<portlet:renderURL var="AskAQuestionURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/Q&A/AskQuestion.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${AskAQuestionURL}"  value="Ask Question?"/>
			
			 <portlet:renderURL var="FeedbackURL" windowState="normal">
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
				<portlet:param name="jspPage" value="/jsp/post_donations/feedback/Feedback.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${FeedbackURL}"  value="Feedback"/>
			
			<portlet:actionURL name="updateRequestRegistration" var="updateRequestRegistrationURL" >
				<portlet:param name="projectId" value="<%=String.valueOf(ProjectId) %>" />
			</portlet:actionURL>
			<aui:button type="button" onClick="${updateRequestRegistrationURL}"  value="Ask for an Update"/>
			
<%} %>


					<!-- DONATE OPTION FOR LOGGED IN USER -->
<%
boolean signedIn = themeDisplayObj.isSignedIn();
String FundOtpId = renderRequest.getParameter("FundOtpId");
	if(signedIn == false){
%>

			<portlet:renderURL var="DonateUsingEmailMobileURL" windowState="normal">
				<portlet:param name="ProjectId" value="<%= projectID %>" />
				<portlet:param name="jspPage" value="/jsp/payment/OTPAuthenticationForm.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${DonateUsingEmailMobileURL}"  value="Donate Using Email/Mobile"/>
			
			 <portlet:renderURL var="DonateAnonymouslyURL" windowState="normal">
			 	<portlet:param name="ProjectId" value="<%= projectID %>" />
				<portlet:param name="jspPage" value="/jsp/payment/DonateAmount.jsp" />
			</portlet:renderURL>
			<aui:button type="button" onClick="${DonateAnonymouslyURL}"  value="Donate Anonymously"/>

		<%}else{ %>

			<%-- <portlet:actionURL name="donationAmount" var="donationAmountURL" />
			
			<aui:form action="${donationAmountURL}" method="post" >
				
				<aui:input name="projectId" type="hidden" value="<%= projectID %>"></aui:input>
				<aui:input name="FundOtpId" type="hidden" value="<%= FundOtpId %>"></aui:input>
				
				<%if(signedIn == true){ %>
				<aui:input label="Donate Anonymously" name="donateAnonymously" type="radio" value="Yes" />
				<% } %>
						
				<aui:select label="Currency" name="currency" >
					<aui:option label="INR" value="INR" />
					<aui:option label="US$" value="USD" />
				</aui:select>
				<aui:input name="amount" label="Amount"></aui:input>
				<aui:input name="message" label="Message for Benificiary"></aui:input>
				<aui:button name="submit" type="submit" value="Donate Now" />
				
			</aui:form> --%>
			
			<portlet:actionURL name="donationAmount" var="donationAmountURL" />
			
			<form action="${donationAmountURL}" method="post" >

					<input name="<portlet:namespace/>projectId" type="hidden" value="<%= projectID %>">
					<input  name="<portlet:namespace/>FundOtpId" type="hidden" value="<%= FundOtpId %>">
				
						<%if(signedIn == true){ %>
						
						<aui:input label="Donate Anonymously" name="donateAnonymously" type="radio" value="Yes" />
						<% } %>
						<br>
				
						<div class="row" style="margin-left: .1em;">
							<select class="form-control" name="<portlet:namespace/>currency" style="padding-right:0; padding-left:5px; width:4em; ">
                      			<option value="usd">US $</option>
                      			<option selected value="inr">Rs.</option>
                   			</select>
                   			
              &nbsp<input name="<portlet:namespace/>amount" type="text" class="form-control manual-payment payment-amt"  style="width:179px;"> </div>
              <br>
              
              <aui:input name="message" label="Message for Benificiary"></aui:input><br>
              <input type="submit" name="commit" value="Donate now" style="width: 45%;margin-left: 12em" class="btn btn-primary btn-block text-bold btn-success" >
				
			</form>
	<%} %>

	
				<!-- CAMPAIGN COMMENT -->


<%
List<CommentRegistration> commentList = CommentRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(ProjectId, CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_1);
for(CommentRegistration commentObj : commentList){
	User CurrentUserData = UserLocalServiceUtil.fetchUser(commentObj.getDONOR_USER_ID());
%>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getCOMMENT() %></p>
 	 <span class="time-left"><%= commentObj.getCOMMENT_DATE() %> | <%= CurrentUserData.getFullName() %></span>
</div>
<div class="container1 darker" style="width: 722px; background-color: whitesmoke;">
	<p><%= commentObj.getANSWER() %></p>
 	 <span class="time-right"><%= commentObj.getCOMMENT_DATE() %> | <%= CurrentUserData.getFullName() %></span>
</div>
<% } %>

<portlet:actionURL var="commentDetailsURL" name="commentDetails"></portlet:actionURL>

<aui:form action="${commentDetailsURL}" method="post" >
	<aui:input type="hidden" name="projectID" value="<%= ProjectId %>"></aui:input>
	<aui:input name="commentData" type="textarea" label="Comments :"/>
	<aui:button type="submit" value="Submit"  />
	<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
</aui:form>
