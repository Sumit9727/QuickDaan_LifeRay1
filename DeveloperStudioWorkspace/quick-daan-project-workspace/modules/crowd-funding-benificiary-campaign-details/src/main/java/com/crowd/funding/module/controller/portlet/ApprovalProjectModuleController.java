package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserFollowRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil;
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
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-008
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CrowdFundingDetails",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Campaign Approval",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.header-portlet-css=/CSS/main.css",
		"javax.portlet.init-param.view-template=/jsp/BenificiaryDetails/ApproveList.jsp",
		"javax.portlet.name=Campaign Approval",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class ApprovalProjectModuleController extends MVCPortlet {
	
	public void adminProjectContent(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
							/*CAMPAIGN APPROVAL*/
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			String mailSubject = "Quick Daan - Campaign Approved";
			String mailBody = "Dear User," + "\n\nYour Campaign " +
					projectRegistration.getTITLE() +" is Approved."+"\n\nYour Campaign is approved and posted under normal project service fees(Processing fees 6%, project fees 0%, gateway charges 2%) "
						+ "on your campaign required fund amount. You can change your category from MyCampaign page." +"\n\n\nThank You For Visiting Quick Daan.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());	
			
							/*	CAMPAIGN PRIORITY*/
			
			ProjectPriorityRegistration priorityRegistration = null;
			long priorityID = 0;
			priorityID = CounterLocalServiceUtil.increment(ProjectPriorityRegistration.class.getName());
			priorityRegistration = ProjectPriorityRegistrationLocalServiceUtil.createProjectPriorityRegistration(priorityID);
			
			priorityRegistration.setPROJECT_ID(projectRegistration.getPROJECT_ID());
			priorityRegistration.setPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_0);
			
			ProjectPriorityRegistrationLocalServiceUtil.addProjectPriorityRegistration(priorityRegistration);
			
							/*	USER FOLLOWER*/
			
			List<UserFollowRegistration> followerUserList = UserFollowRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			
			for(UserFollowRegistration followerObj : followerUserList) {
				
				try {
					ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
				
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("userId", followerObj.getFOLLOWER_USER_ID());
					jsonObject.put("senderName", userObj.getFULL_NAME());
					jsonObject.put("notificationText", " has started new Compaign, " + projectRegistration.getTITLE() + ".");
					
					UserNotificationEventLocalServiceUtil.addUserNotificationEvent(followerObj.getFOLLOWER_USER_ID(), SendNotificationToUserHandler.PORTLET_ID,
							(new java.util.Date()).getTime(), 10002, followerObj.getFOLLOWER_USER_ID(), jsonObject.toString(), false, serviceContext);
			
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void RejectDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
		
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			String commentData = actionRequest.getParameter("commentData");
			String noReason = actionRequest.getParameter("noReason");
			
			
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3);
			if(noReason.contains("on") == true) {
				projectRegistration.setCOMMENT("No Reason.");
			}else {
				projectRegistration.setCOMMENT(commentData);
			}
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			String mailSubject = "Quick Daan - Campaign Rejection";
			
			String mailBody = null;
			if(noReason.contains("on") == true) {
				mailBody = "Dear User," + "\n\nYour Campaign " +
					projectRegistration.getTITLE() +" is Rejected with no any reason."+"\n\n\nThank You For Visiting Quick Daan.";
			
			}
			else {
				mailBody = "Dear User," + "\n\nYour Campaign " +
						projectRegistration.getTITLE() +" is Rejected due to "+commentData+"."+"\n\n\nThank You For Visiting Quick Daan.";
				
			}

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			String serverResourceCall = ParamUtil.getString(resourceRequest, "serverResourceCall");
			
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForDocument")){
	        	 long documentID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectDocumentID"));
		            DocumentRegistration documentObj = DocumentRegistrationLocalServiceUtil.findByPROJECT_DOCUMENT_ID(documentID);
			        	    java.sql.Blob document = documentObj.getDOCUMENT();
			                byte[ ] documentData = document.getBytes(1,(int)document.length());
							resourceResponse.setContentType(documentObj.getDOCUMENT_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(documentData);
							o.flush();
							o.close();
	        }
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
