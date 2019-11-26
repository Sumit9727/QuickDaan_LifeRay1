<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.FundRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.FundRegistration"%>
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

<style>
	.overlay {
  position: absolute;
    bottom: 22px;
    left: 22px;
    right: 0;
    background-color: white;
    overflow: hidden;
    width: 88%;
    height: 70px;

}
.overlay:hover{
	background-color:black;
	opacity:0.8;
}
.text {
  color: white;
  font-size: 13px;
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  text-align: center;
  color:orangered;
}
.text:hover{
	color:white;
}
</style>

								<!-- Featured Project -->
 <%
List<ProjectPriorityRegistration> featuredPriorityList = ProjectPriorityRegistrationLocalServiceUtil.findByPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_1);
	for(ProjectPriorityRegistration priorityObj : featuredPriorityList ){ 
		int sortList = priorityObj.getPRIORITY_SEQUANCE();
		ProjectPriorityRegistration sortedList = ProjectPriorityRegistrationLocalServiceUtil.findByPRIORITY_SEQUANCE(priorityObj.getPRIORITY_SEQUANCE());
		
		ProjectRegistration featuredProjectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(priorityObj.getPROJECT_ID());
		UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(featuredProjectObj.getUSER_ID());
		
		List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());
		float donatedAmount = 0;
		for(FundRegistration fundAmtObj : fundAmtList){
			donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
		}
	%>
	
				 	<portlet:resourceURL  var="featuredProjectImageResourceURL">
						<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
						<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(featuredProjectObj.getPROJECT_ID())  %>"/>
					</portlet:resourceURL>
					<portlet:renderURL var="featuredProjectViewImages" windowState="normal" >
						<portlet:param name="projectID" value="<%= String.valueOf(priorityObj.getPROJECT_ID()) %>" />
						<portlet:param name="jspPage" value="/jsp/Campaign Details/CampaignDetails.jsp" />
					</portlet:renderURL>
								
					<div  style="border:4px solid #d3d3d3; display: inline-block;position:relative;margin:0 auto;">
					<a href="${featuredProjectViewImages}">
						<img class="picture" src="${featuredProjectImageResourceURL}" alt="Image"  style="border:4px solid #d3d3d3;height:250px;width:300px; box-shadow: 2px 6px 18px black;padding:8px;margin:10px;"/>
					</a>
					
					<div style="margin-left: 17px; width: 274px; margin-top: 17px; height: 27px;">
					<progress value=<%= donatedAmount %> max=<%= featuredProjectObj.getREQUIRED_FUND_AMOUNT() %>></progress>
					<br>
					<br>
					
					<div>Campaign Name : <%= featuredProjectObj.getTITLE() %></div>
					<hr>
					<div style="margin-left: 45px;">Posted By : <%= userObj.getFULL_NAME() %></div></div></div>
	<% 
	}
	%> 
											<!-- Non-Featured Project -->
<%
List<ProjectPriorityRegistration> priorityList = ProjectPriorityRegistrationLocalServiceUtil.findByPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_0);

	for(ProjectPriorityRegistration priorityObj : priorityList ){ 
		
		ProjectRegistration normalProjectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(priorityObj.getPROJECT_ID());
		UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(normalProjectObj.getUSER_ID());
		
		List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());
		float donatedAmount = 0;
		for(FundRegistration fundAmtObj : fundAmtList){
			donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
		}
		
	%>
	
				 	<portlet:resourceURL  var="NormalProjectImageResourceURL">
						<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
						<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(normalProjectObj.getPROJECT_ID())  %>"/>
					</portlet:resourceURL>
					<portlet:renderURL var="NormalProjectViewImages" windowState="normal" >
						<portlet:param name="projectID" value="<%= String.valueOf(priorityObj.getPROJECT_ID()) %>" />
						<portlet:param name="jspPage" value="/jsp/Campaign Details/CampaignDetails.jsp" />
					</portlet:renderURL>
								
					<div  style="border:4px solid #d3d3d3; display: inline-block;position:relative;margin:0 auto;">
					<a href="${NormalProjectViewImages}">
						<img class="picture" src="${NormalProjectImageResourceURL}" alt="Image"  style="border:4px solid #d3d3d3;height:250px;width:300px; box-shadow: 2px 6px 18px black;padding:8px;margin:10px;"/>
					</a>
					
					<div style="margin-left: 17px; width: 274px; margin-top: 17px; height: 27px;">
					<progress value=<%= donatedAmount %> max=<%= normalProjectObj.getREQUIRED_FUND_AMOUNT() %>></progress>
					<br>
					<br>
					
					<div>Campaign Name : <%= normalProjectObj.getTITLE() %></div>
					<hr>
					<div style="margin-left: 45px;">Posted By : <%= userObj.getFULL_NAME() %></div></div></div>
	<% 
	}
	%>
	
