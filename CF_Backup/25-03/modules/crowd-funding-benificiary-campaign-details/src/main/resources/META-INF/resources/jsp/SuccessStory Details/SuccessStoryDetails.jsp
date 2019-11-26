<%@page import="com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectAcknowledgementRegistration"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Collection"%>
<%@page import="com.crowd.funding.database.service.DonorRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DonorRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectFollowerRegistration"%>
<%@page import="com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectUpdateRegistration"%>
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

<liferay-theme:defineObjects />

<portlet:defineObjects />


<%
long projectID = Long.parseLong(renderRequest.getParameter("ProjectId"));
ProjectAcknowledgementRegistration acknowledgementRegistration = ProjectAcknowledgementRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);

ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

double totalDonatedAmt = 0;
double remainingAmt = 0;

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
float donatedAmount = 0;
for(FundRegistration fundAmtObj : fundAmtList){
	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
	remainingAmt = donatedAmount - totalDonatedAmt;
}

%>


<h1><center> <%= projectRegistration.getTITLE() %></center></h1>

<table>
	  <tr>
		    <portlet:resourceURL  var="imageResourceURL">
				<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
				<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(projectRegistration.getPROJECT_ID())  %>"/>
			</portlet:resourceURL>
		<td><center><img src="${imageResourceURL}" alt="Image" style="max-width: 50%;" /></center></td>
	  </tr>
  
  
	  <tr>
	    	<th>Story :<br><%= projectRegistration.getDESCRIPTION() %></th>
	  </tr>
  		<tr>
  			<td>
	  			<portlet:resourceURL  var="NormalProjectImageResourceURL">
					<portlet:param name="serverResourceCall" value="AcnowledgmentIDForProjectVideo"/>
					<portlet:param name="AcnowledgmentIDForProjectVideo" value="<%= String.valueOf(acknowledgementRegistration.getPROJECT_ID())  %>"/>
				</portlet:resourceURL>
				 <video autoplay id="myVideo" controls style="max-width: 50%;">
				  <source src="${NormalProjectImageResourceURL}" type="<%= acknowledgementRegistration.getVIDEO_TYPE() %>">
				</video>
			</td>
  		</tr>
	  <tr> 
		  <%
		  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
		  for(DocumentRegistration documentObj : documentList){
		  %>
			 <portlet:resourceURL  var="ProjectDocumentResourceURL">
				<portlet:param name="serverResourceCall" value="ProjectIDForDocument"/>
				<portlet:param name="ProjectDocumentID" value="<%= String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  %>"/>
			 </portlet:resourceURL>
			    <td><a href="${ProjectDocumentResourceURL}" alt="Document" /><%= documentObj.getDOCUMENT_NAME() %></td>
			  </tr>
  		 <% } %>
  
		  <tr>
		    	<td>Posted By : <%= userData.getFullName() %></td>
		  </tr>
		  <tr>
		    	<td>Required Fund Amount : <%= projectRegistration.getREQUIRED_FUND_AMOUNT() %></td>
		  </tr>
		  <tr>
		   		<td>Remaing Amount : <%= remainingAmt %></td>
		  </tr>
		  <tr>
		    	<td><div style="margin-left: 17px; width: 274px; margin-top: 17px; height: 27px;"><progress value=<%= donatedAmount %> max=<%= projectRegistration.getREQUIRED_FUND_AMOUNT() %>></progress></div></td>
		  </tr>
 
</table>

<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
				
				
<!-- <video autoplay id="myVideo" controls style="max-width: 50%;">
  <source src="/portal_content/TomJerry.mp4" type="video/mp4">
</video>

<iframe width="420" height="345" src="https://youtu.be/8jv8oxGiodE?autoplay=1">
</iframe> -->
