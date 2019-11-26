 <%@page import="java.util.LinkedList"%>
<%@page import="com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectExtentionRegistration"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="java.util.spi.LocaleServiceProvider"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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

.container::after, .row::after {
  content: "";
  clear: both;
  display: table;
}

.remainingDays{
margin-bottom: -4%;
margin-top: -4%;
color: #b91141;
}

</style>

<!-- Featured Project -->
<div class="row" style="background-color: #a9a9a926;">
<%

Set<Integer> hash_Set = new HashSet<Integer>();
List<ProjectPriorityRegistration> projectList = ProjectPriorityRegistrationLocalServiceUtil.findByPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_1);

for(ProjectPriorityRegistration priorityObj : projectList){
hash_Set.add(priorityObj.getPRIORITY_SEQUANCE());
}
Iterator value = hash_Set.iterator(); 
while (value.hasNext()) { 
int prioritySquance = (Integer) value.next();

ProjectPriorityRegistration sortedList = ProjectPriorityRegistrationLocalServiceUtil.findByPRIORITY_SEQUANCE(prioritySquance);

ProjectRegistration featuredProjectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(sortedList.getPROJECT_ID());
UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(featuredProjectObj.getUSER_ID());
List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());

Date currentDate;
Date endDate;
int differenceInDays = 0 ;

List<ProjectExtentionRegistration> extentionRegistrationList = ProjectExtentionRegistrationLocalServiceUtil.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());
if(extentionRegistrationList.size() >= 0){
LinkedList<ProjectExtentionRegistration> reverseList = new LinkedList<ProjectExtentionRegistration>();
for(int i=extentionRegistrationList.size()-1;i>=0;i--){
reverseList.add(extentionRegistrationList.get(i));
}
for(ProjectExtentionRegistration extentionRegistrationObj :reverseList){
currentDate = new Date();
endDate = extentionRegistrationObj.getEXTENTION_DATE();
differenceInDays = (int) ((endDate.getTime() - currentDate.getTime())/(1000*60*60*24)) + 1;
break;
}
}
if(extentionRegistrationList.size() == 0){
currentDate = new Date();
endDate = featuredProjectObj.getEND_DATE();
differenceInDays = (int) ((endDate.getTime() - currentDate.getTime())/(1000*60*60*24)) + 1;
}

List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(featuredProjectObj.getPROJECT_ID());

float donatedAmount = 0;
for(FundRegistration fundAmtObj : fundAmtList){
donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}
if(differenceInDays >= 0 ){
if(featuredProjectObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4 && featuredProjectObj.getREQUIRED_FUND_AMOUNT() == donatedAmount && featuredProjectObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){
}
if(featuredProjectObj.getSTATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4 && featuredProjectObj.getREQUIRED_FUND_AMOUNT() != donatedAmount && featuredProjectObj.getSTATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){
String normalDoubleValue = String.format("%.0f",donatedAmount);
%>
<portlet:resourceURL var="featuredProjectImageResourceURL">
<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(featuredProjectObj.getPROJECT_ID()) %>"/>
</portlet:resourceURL>
<portlet:renderURL var="featuredProjectViewImages" windowState="normal" >
<portlet:param name="projectID" value="<%= String.valueOf(sortedList.getPROJECT_ID()) %>" />
<portlet:param name="jspPage" value="/jsp/Campaign Details/CampaignDetails.jsp" />
</portlet:renderURL>

<div class="column" style="padding: 23px;">
<!--  padding: 10px;  font-family: arial;  margin: auto;  max-width: 325px;  max-height: 500px;  color: #0077a2; -->
	<div class="card" style=" box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);padding: 10px;width: 309px; ">		
			<div class="container" style="padding: 0 0 0 0px; height: 489px; text-align: center;">
				<div >
					<a href="${featuredProjectViewImages}">
						<img class="picture" src="${featuredProjectImageResourceURL}" alt="Image" style="height:250px;width: 307px;margin-left: -10px;margin-top: -10px;"/>
					</a>
				</div>
				<div style="padding-top: 17px;">
					<h5 style="color: #0077A2;"><%= donatedAmount %> raised</h5>
					<div>
						<progress style="width: 238px;height: 19px;" value=<%= donatedAmount %> max=<%= featuredProjectObj.getREQUIRED_FUND_AMOUNT() %>></progress>
					</div>
					<div  >
						<div style="height: 96px;"><B> <%= featuredProjectObj.getTITLE() %></B></div>
					</div>
					<div >
						<hr>
						<div class ="remainingDays">
							<center><div><%= differenceInDays %> days left | <%= donatedFundList.size() %> Supportes</div></center>
						</div>
						<hr>
						<div >
							<div style="margin-top: -5%; ">Posted By : <%= userObj.getFULL_NAME() %></div>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>

<% } }

}%>

<!-- Non-Featured Project -->
<%
List<ProjectPriorityRegistration> priorityList = ProjectPriorityRegistrationLocalServiceUtil.findByPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_0);

for(ProjectPriorityRegistration priorityObj : priorityList ){ 
ProjectRegistration normalProjectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(priorityObj.getPROJECT_ID());

UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(normalProjectObj.getUSER_ID());
List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());

Date currentDate;
Date endDate;
int differenceInDays = 0;

List<ProjectExtentionRegistration> extentionRegistrationList = ProjectExtentionRegistrationLocalServiceUtil.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());
if(extentionRegistrationList.size() >= 0){
LinkedList<ProjectExtentionRegistration> reverseList = new LinkedList<ProjectExtentionRegistration>();
for(int i=extentionRegistrationList.size()-1;i>=0;i--){
reverseList.add(extentionRegistrationList.get(i));
}
for(ProjectExtentionRegistration extentionRegistrationObj :reverseList){
currentDate = new Date();
endDate = extentionRegistrationObj.getEXTENTION_DATE();
differenceInDays = (int) ((endDate.getTime() - currentDate.getTime())/(1000*60*60*24)) + 1;
break;
}
}
if(extentionRegistrationList.size() == 0){

currentDate = new Date();
endDate = normalProjectObj.getEND_DATE();
differenceInDays = (int) ((endDate.getTime() - currentDate.getTime())/(1000*60*60*24)) + 1;
}
List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(normalProjectObj.getPROJECT_ID());
float donatedAmount = 0;

for(FundRegistration fundAmtObj : fundAmtList){
donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}

if(differenceInDays >= 0 ){
if(normalProjectObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4 && normalProjectObj.getREQUIRED_FUND_AMOUNT() == donatedAmount && normalProjectObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){
}
if(normalProjectObj.getSTATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4 && normalProjectObj.getREQUIRED_FUND_AMOUNT() != donatedAmount && normalProjectObj.getSTATUS() != CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){
%>
<portlet:resourceURL var="NormalProjectImageResourceURL">
<portlet:param name="serverResourceCall" value="ProjectIDForProjectImage"/>
<portlet:param name="ProjectIDForProjectImage" value="<%= String.valueOf(normalProjectObj.getPROJECT_ID()) %>"/>
</portlet:resourceURL>
<portlet:renderURL var="NormalProjectViewImages" windowState="normal" >
<portlet:param name="projectID" value="<%= String.valueOf(priorityObj.getPROJECT_ID()) %>" />
<portlet:param name="jspPage" value="/jsp/Campaign Details/CampaignDetails.jsp" />
</portlet:renderURL>

<div class="column" style="padding: 23px;">
<!--  padding: 10px;  font-family: arial;  margin: auto;  max-width: 325px;  max-height: 500px;  color: #0077a2; -->
	<div class="card" style=" box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);padding: 10px;width: 309px; ">		
		<div class="container" style="padding: 0 0 0 0px; height: 489px; text-align: center;">
			<div>
				<a href="${NormalProjectViewImages}">
					<img class="picture" src="${NormalProjectImageResourceURL}" alt="Image" style="height:250px;width: 307px;margin-left: -10px;margin-top: -10px;" />
				</a>
			</div>
			<div style="padding-top: 17px;">
				<h5 style="color: #0077A2;"><%= donatedAmount %> raised</h5>
				<div >
					<progress style="width: 238px;height: 19px;" value=<%= donatedAmount %> max=<%= normalProjectObj.getREQUIRED_FUND_AMOUNT() %>></progress>
				</div>
				
				<div >
					<div style="height: 96px;"><B> <%= normalProjectObj.getTITLE() %></B></div>
				</div>
				<div >
					<hr>
					<div class ="remainingDays">
						<center><div><%= differenceInDays %> days left | <%= donatedFundList.size() %> Supportes</div></center>
					</div>
					<hr>
					<div >
						<div style="margin-top: -5%; ">Posted By : <%= userObj.getFULL_NAME() %></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<% }
}
}
%>
</div>
