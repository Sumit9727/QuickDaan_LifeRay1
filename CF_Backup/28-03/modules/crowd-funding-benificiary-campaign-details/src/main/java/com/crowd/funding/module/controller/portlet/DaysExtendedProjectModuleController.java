package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.ProjectExtentionRegistration;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserFollowRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserFollowRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.crowd.funding.module.controller.constants.SendNotificationToUserHandler;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-008
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CrowdFundingDetails",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Campaign Days Extended",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.header-portlet-css=/CSS/custom.css",
		"javax.portlet.init-param.view-template=/jsp/AdminDaysExtend/AdminDaysExtendCampaignTab.jsp",
		"javax.portlet.name=Campaign Days Extended Details",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class DaysExtendedProjectModuleController extends MVCPortlet {
	
	public void ApproveExtendCapmaignDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long ProjectExtendedId = Long.parseLong(actionRequest.getParameter("ProjectExtendedId"));
			
			ProjectExtentionRegistration extentionRegistration = ProjectExtentionRegistrationLocalServiceUtil.fetchProjectExtentionRegistration(ProjectExtendedId);
			extentionRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_1);
			ProjectExtentionRegistrationLocalServiceUtil.updateProjectExtentionRegistration(extentionRegistration);
			
			ProjectRegistration  projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(extentionRegistration.getPROJECT_ID());
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2);
			projectRegistration.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_6);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Quick Daan - Campaign Days Extend";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYour campaign for " +
			    		projectRegistration.getTITLE() +" is now extended till "+extentionRegistration.getEXTENTION_DATE()+" on Quick Daan portal." +"\n\n\nThank You For Visiting Quick Daan.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void RejectExtendCapmaignDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
		
			long ProjectExtendedId = Long.parseLong(actionRequest.getParameter("ProjectExtendedId"));
			
			ProjectExtentionRegistration extentionRegistration = ProjectExtentionRegistrationLocalServiceUtil.fetchProjectExtentionRegistration(ProjectExtendedId);
			extentionRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_2);
			ProjectExtentionRegistrationLocalServiceUtil.updateProjectExtentionRegistration(extentionRegistration);
			
			ProjectRegistration  projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(extentionRegistration.getPROJECT_ID());
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3);
			projectRegistration.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_9);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Quick Daan - Campaign Days Extend";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYour campaign for " +
			    		projectRegistration.getTITLE() +" is rejected for extention. \n\n\nThank You For Visiting Quick Daan.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
