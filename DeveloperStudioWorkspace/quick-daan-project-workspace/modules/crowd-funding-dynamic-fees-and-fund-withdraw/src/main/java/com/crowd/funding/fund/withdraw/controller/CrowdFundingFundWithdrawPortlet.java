package com.crowd.funding.fund.withdraw.controller;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.ProjectFeesRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.dynamic.fees.controller.constants.CrowdFundingDynamicFeesMgmtPortletKeys;
import com.crowd.funding.dynamic.fees.controller.constants.CrowdFundingMail;
import com.crowd.funding.dynamic.fees.controller.constants.SendAttachmentInEmail;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=Fund Request",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/FundRequestWithdraw/AdminFundRequestTab.jsp",
	        "javax.portlet.name=Fund Request",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class CrowdFundingFundWithdrawPortlet extends MVCPortlet {
	
	
	public void approveFundRequestWithdraw(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long ProjectId = Long.parseLong(actionRequest.getParameter("ProjectId"));
			long fundReleaseID = Long.parseLong(actionRequest.getParameter("fundReleaseID"));
			Date releaseDate = new Date();
			
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
			 User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());
			 if(projectRegistration.getREQUEST_STATUS() == CrowdFundingDynamicFeesMgmtPortletKeys.Project_REQUESTED_STATUS_2) {
				 projectRegistration.setREQUEST_STATUS(CrowdFundingDynamicFeesMgmtPortletKeys.Project_REQUESTED_STATUS_3);
			 }
			 if(projectRegistration.getREQUEST_STATUS() == CrowdFundingDynamicFeesMgmtPortletKeys.Project_REQUESTED_STATUS_7) {
				 projectRegistration.setSTATUS(CrowdFundingDynamicFeesMgmtPortletKeys.Project_STATUS_5);
				 projectRegistration.setREQUEST_STATUS(CrowdFundingDynamicFeesMgmtPortletKeys.Project_REQUESTED_STATUS_3);
				 
			 }
			
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);

			FundReleaseRegistration fundReleaseRegistration = FundReleaseRegistrationLocalServiceUtil.findByFUND_RELEASE_ID(fundReleaseID);
			fundReleaseRegistration.setRELEASE_DATE(releaseDate);
			FundReleaseRegistrationLocalServiceUtil.updateFundReleaseRegistration(fundReleaseRegistration);
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Quick Daan - Withdrawn Fund";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYou have withdrawn " +
			    		fundReleaseRegistration.getTOTAL_WITHDRAW_AMOUNT() +" sucessfully on your "+ projectRegistration.getTITLE() +"Quick Daan portal." +"\n\n\nThank You For Visiting Quick Daan.";
			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
		
		} catch (Exception e) {
		}
	}
	
	
}
