<%@page import="com.crowd.funding.admin.report.constants.CrowdFundingAdminReportPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/jsp/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="dropdownUrl" windowState="normal">
<portlet:param name="jspPage" value="/jsp/Report.jsp"/>
</portlet:renderURL> 

 <aui:form action="${dropdownUrl}" method="post">
		<aui:select label="Select by Status:"  name="selectStatus" >
			<aui:option value="" >--- Select Campaign Status---</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_2 %>" >Approved</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_1 %>">Waiting for Approval</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_0 %>" >New Posted</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_3 %>">Rejected</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_4 %>">Declined</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_5 %>">Completed</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_6 %>">Requested for Fund Withdraw(Waiting For Withdraw)</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_7 %>">Fund Released</aui:option>
        </aui:select> 
         <aui:select label="Select by Cause Details:"  name="selectCause" >
            <aui:option value="" >--- Select Cause Detail---</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_MEDICAL %>" >Medical</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_COMMUNITY_DEVELOPMENT %>">Community Development</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_HEALTH_AND_HYGIENE %>" >Health and Hygiene</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_DISABILITIES %>">Disabilities</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_EDUCATION %>">Education</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_FOOD %>">Food</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.CAUSE_DETAILS_RURAL_WORKS %>">Rural works</aui:option>
        </aui:select> 
       <aui:select label="Select by Beneficiery Category:"  name="selectBeneficieryCategory">
            <aui:option value="" >--- Select Benificiary Category---</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.BENIFICIERY_CATEGORY_MYSELF %>" >Myself</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.BENIFICIERY_CATEGORY_FRIEND %>">Friend</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.BENIFICIERY_CATEGORY_FAMILY %>" >Family</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.BENIFICIERY_CATEGORY_OTHERS %>">Others</aui:option>
        </aui:select>
        <aui:select label="Select by Withdraw:"  name="selectWithdrawType">
            <aui:option value="" >--- Select Withdraw Type---</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_0 %>" >Partially Withdraw Fund</aui:option>
            <aui:option value="<%= CrowdFundingAdminReportPortletKeys.STATUS_1 %>">Full Withdraw Fund</aui:option>   
        </aui:select>
        <label>Select by Campaign Date: </label>
        <input type="date" label="Select by Creation Date:" name="<portlet:namespace/>campaignStartDate"  min="2019-01-01"  max="2030-12-31" placeholder="Campaign Start Date"/> </BR></BR>
        <label>Select Between Campaign Date:</label><br><br>
        <label>Campaign From Date:   </label>
          <input type="date" name="<portlet:namespace/>campaigFromDate"  min="2019-01-01"  max="2030-12-31" placeholder="Campaign From Date"/> </BR></BR>
          <label>Campaign To Date: </label>
          <input type="date" name="<portlet:namespace/>campaignToDate"  min="2019-01-01"  max="2030-12-31" placeholder="Campaign To Date"/> </BR></BR>
        <aui:button type="submit" value="Submit"></aui:button>
</aui:form> 

