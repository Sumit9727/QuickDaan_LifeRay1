package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.FeedbackRegistration;
import com.crowd.funding.database.model.FundOTPRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.QuestionRegistration;
import com.crowd.funding.database.model.UpdateRequesterRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FeedbackRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UpdateRequesterRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Crowd Funding Campaigns",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/Campaign Details/ListOFCampaign.jsp",
			"javax.portlet.name=Crowd Funding Campaigns",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class CampaignDataController extends MVCPortlet {
	
	
	public void emailMobileRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			String ProjectId = actionRequest.getParameter("projectId");
			String email = actionRequest.getParameter("email");
			String mobileNo = actionRequest.getParameter("mobileNo");
			
			Date date = new Date();
			
			long otpId = 0;
			FundOTPRegistration fundOTPRegistration = null;
			otpId = CounterLocalServiceUtil.increment(FundOTPRegistration.class.getName());
			fundOTPRegistration = FundOTPRegistrationLocalServiceUtil.createFundOTPRegistration(otpId);
			
			Random rnd = new Random();
		    int otpNumber = rnd.nextInt(999999);
		    
		    fundOTPRegistration.setMAIL_ADDRESS(email);
		    fundOTPRegistration.setMOBILE_NO(Long.parseLong(mobileNo));
		    fundOTPRegistration.setOTP(otpNumber);
		    fundOTPRegistration.setCREATION_DATE_TIME(date);
		    
		    FundOTPRegistrationLocalServiceUtil.addFundOTPRegistration(fundOTPRegistration);
		    
		    String mailSubject = "Crowd Funding - Registration OTP";
		    String mailBody = "Dear User," + "\n\nYour One Time Password is " +
		    		otpNumber +". It is valid for 5 minutes for Crowd Funding login for your account associated with Mobile Number "+ mobileNo +"\n\n\nThank You For Visiting Crowd Funding.";
		    
		    com.crowd.funding.module.controller.constants.CrowdFundingMail.sendMail(mailSubject, mailBody, email);
		    
		    actionResponse.setRenderParameter("ProjectId", ProjectId);
		    actionResponse.setRenderParameter("mobileNo", mobileNo);
		    actionResponse.setRenderParameter("jspPage", "/jsp/payment/OTPValidation.jsp");
		    
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void otpAuthentication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			String ProjectId = actionRequest.getParameter("ProjectId");
			String mobileNo = actionRequest.getParameter("mobileNo");
			String emailOtp = actionRequest.getParameter("emailOtp");
			String mobileOtp = actionRequest.getParameter("mobileOtp");
			
			int emailOtpStatus = 0, mobileOtpStatus = 0;
			
			FundOTPRegistration fundOtpObj = FundOTPRegistrationLocalServiceUtil.findByMOBILE_NO(Long.parseLong(mobileNo));
			
			if(fundOtpObj.getOTP() == 0) {
				SessionErrors.add(actionRequest, "otp-expired-error-key");
			}
			
			if(fundOtpObj.getOTP() == Integer.parseInt(emailOtp)) {
				emailOtpStatus = 1;
			}else {
				emailOtpStatus = 0;
			}
			
			if(fundOtpObj.getOTP() == Integer.parseInt(mobileOtp)) {
				mobileOtpStatus = 1;
			}else {
				mobileOtpStatus = 0;
			}
			
			if(emailOtpStatus == 1 && mobileOtpStatus == 1) {
				fundOtpObj.setMAIL_VERIFICATION(emailOtpStatus);
				fundOtpObj.setSMS_VERIFICATION(mobileOtpStatus);
				
				FundOTPRegistrationLocalServiceUtil.updateFundOTPRegistration(fundOtpObj);
				
				actionResponse.setRenderParameter("ProjectId", ProjectId);
				actionResponse.setRenderParameter("FundOtpId", String.valueOf(fundOtpObj.getFUND_OTP_ID()));
			    actionResponse.setRenderParameter("jspPage", "/jsp/payment/DonateAmount.jsp");
			}else {
				SessionErrors.add(actionRequest, "error-key");
			}
			

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void reSendOtpRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String mobileNo = ParamUtil.getString(actionRequest, "mobileNo");
			FundOTPRegistration fundOtpObj = FundOTPRegistrationLocalServiceUtil.findByMOBILE_NO(Long.parseLong(mobileNo));
			
			Random rnd = new Random();
		    int otpNumber = rnd.nextInt(999999);
		    
		    fundOtpObj.setOTP(otpNumber);
		    FundOTPRegistrationLocalServiceUtil.updateFundOTPRegistration(fundOtpObj);
		    
		    String mailSubject = "Crowd Funding - Registration OTP";
		    String mailBody = "Dear User," + "\n\nYour One Time Password is " +
		    		otpNumber +". It is valid for 5 minutes for Crowd Funding login for your account associated with Mobile Number "+ mobileNo +"\n\n\nThank You For Visiting Crowd Funding.";
		    
		    com.crowd.funding.module.controller.constants.CrowdFundingMail.sendMail(mailSubject, mailBody, fundOtpObj.getMAIL_ADDRESS());
		    
		    actionResponse.setRenderParameter("mobileNo", mobileNo);
		    actionResponse.setRenderParameter("jspPage", "/jsp/payment/OTPValidation.jsp");
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void donationAmount(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			ThemeDisplay themeDisplay  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long UserId = themeDisplay.getUserId();
			String donateAnonymously = null;
			
			Date date = new Date();
			
			if(UserId == 20103) 
				UserId = 0;
			
			String projectId = actionRequest.getParameter("projectId");
			String currency = actionRequest.getParameter("currency");
			String amount = actionRequest.getParameter("amount");
			String message = actionRequest.getParameter("message");
			String fundOtpId = actionRequest.getParameter("FundOtpId");
			
			donateAnonymously = actionRequest.getParameter("donateAnonymously");
			
			long fundId = 0;
			FundRegistration fundRegistration = null;
			fundId = CounterLocalServiceUtil.increment(FundRegistration.class.getName());
			fundRegistration = FundRegistrationLocalServiceUtil.createFundRegistration(fundId);
			
			if(fundOtpId.equalsIgnoreCase("null"))
				fundRegistration.setFUND_OTP_ID(CrowdFundingBenificiaryDetailsPortletKeys.VALUE_0);
			else
				fundRegistration.setFUND_OTP_ID(Long.parseLong(CrowdFundingBenificiaryDetailsPortletKeys.VALUE_NULL));
			
			fundRegistration.setCURRENCY(currency);
			fundRegistration.setPROJECT_ID(Long.parseLong(projectId));
			fundRegistration.setDONATED_AMOUNT(Float.parseFloat(amount));
			fundRegistration.setDONOR_USER_ID(UserId);
			
			if(donateAnonymously != null && UserId > 0)
				fundRegistration.setDONOR_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.DONATE_ANONYMOSULY_STATUS_0);
			if(donateAnonymously == null && UserId > 0)
				fundRegistration.setDONOR_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.DONATE_ANONYMOSULY_STATUS_1);
			if(donateAnonymously == null && UserId == 0)
				fundRegistration.setDONOR_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.DONATE_ANONYMOSULY_STATUS_0);
				
			fundRegistration.setCOMMENT(message);
			fundRegistration.setDONATED_DATE(date);
			
			FundRegistrationLocalServiceUtil.addFundRegistration(fundRegistration);
			
			
			float collectedFundAmount = 0;
			List<FundRegistration> fundRegistrationList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectId));
			ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectId));
			
			for(FundRegistration fundObj : fundRegistrationList) {
				collectedFundAmount = collectedFundAmount + fundObj.getDONATED_AMOUNT();
			}
			if(collectedFundAmount == projectObj.getREQUIRED_FUND_AMOUNT()) {
				projectObj.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.PROJECT_STATUS_REACHED_REQUIRED_FUND_4);
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectObj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void updateRequestRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long UserId = themeDisplay.getUserId();
			
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    Date date = new Date();
			
			long projectId = Long.parseLong(actionRequest.getParameter("projectId"));
			
			long updateRequestId = 0;
			UpdateRequesterRegistration updateRequesterRegistration = null;
			updateRequestId = CounterLocalServiceUtil.increment(UpdateRequesterRegistration.class.getName());
			updateRequesterRegistration = UpdateRequesterRegistrationLocalServiceUtil.createUpdateRequesterRegistration(updateRequestId);
			
			updateRequesterRegistration.setPROJECT_ID(projectId);
			updateRequesterRegistration.setUPDATE_REQUESTER_USER_ID(UserId);
			updateRequesterRegistration.setUPDATE_REQUEST_DATE(date);
			updateRequesterRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.UPDATE_REQUEST_POST_STATUS_1);
			
			UpdateRequesterRegistrationLocalServiceUtil.addUpdateRequesterRegistration(updateRequesterRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void askQuestionRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long UserId = themeDisplay.getUserId();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			String projectId = actionRequest.getParameter("projectId");
			String askQuestion = actionRequest.getParameter("askQuestion");
			
			long questionId = 0;
			QuestionRegistration questionRegistration = null;
			questionId = CounterLocalServiceUtil.increment(QuestionRegistration.class.getName());
			questionRegistration = QuestionRegistrationLocalServiceUtil.createQuestionRegistration(questionId);
			
			questionRegistration.setPROJECT_ID(Long.parseLong(projectId));
			questionRegistration.setQUESTION_REQUESTER_USER_ID(UserId);
			questionRegistration.setQUESTION(askQuestion);
			questionRegistration.setQUESTION_DATE(date);
			questionRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.QUESTION_POST_STATUS_1);
			
			QuestionRegistrationLocalServiceUtil.addQuestionRegistration(questionRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void feedbackRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			ThemeDisplay themeDisplay  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long UserId = themeDisplay.getUserId();
			
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		    Date date = new Date();
			
			String projectId = actionRequest.getParameter("projectId");
			String feedback = actionRequest.getParameter("feedback");
			
			long feedbackId = 0;
			FeedbackRegistration feedbackRegistration = null;
			feedbackId = CounterLocalServiceUtil.increment(FeedbackRegistration.class.getName());
			feedbackRegistration = FeedbackRegistrationLocalServiceUtil.createFeedbackRegistration(feedbackId);
			
			feedbackRegistration.setPROJECT_ID(Long.parseLong(projectId));
			feedbackRegistration.setDONOR_USER_ID(UserId);
			feedbackRegistration.setFEEDBACK(feedback);
			feedbackRegistration.setFEEDBACK_DATE(date);
			feedbackRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.FEEDBACK_POST_STATUS_1);
			
			FeedbackRegistrationLocalServiceUtil.addFeedbackRegistration(feedbackRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void commentDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
		String commentData = actionRequest.getParameter("commentData");
		SimpleDateFormat sd = new SimpleDateFormat(
	            "yyyy.MM.dd G HH:mm:ss z");
	    Date date = new Date();
	    
	    ThemeDisplay td  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    User currentuserData = td.getUser();
	    System.out.println("currentuserData : "+currentuserData);
	    CommentRegistration commentRegistration = null;
	    long commentID = 0;
	    
	    commentID = CounterLocalServiceUtil.increment(CommentRegistration.class.getName());
	    commentRegistration = CommentRegistrationLocalServiceUtil.createCommentRegistration(commentID);
	    
	    commentRegistration.setCOMMENT(commentData);
	    commentRegistration.setCOMMENT_DATE(date);
	    commentRegistration.setPROJECT_ID(projectID);
	    commentRegistration.setDONOR_USER_ID(currentuserData.getUserId());
	    commentRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Comment_Status_0);
	    
	    CommentRegistrationLocalServiceUtil.addCommentRegistration(commentRegistration);
		
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			String serverResourceCall = ParamUtil.getString(resourceRequest, "serverResourceCall");
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForImage")){
	        	 long photoImageGalleryID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectImage"));
		            List<ImageRegistration> imageList= ImageRegistrationLocalServiceUtil.findByPROJECT_ID(photoImageGalleryID);
		            System.out.println("imageList : "+imageList);
	           		for(ImageRegistration imageObj : imageList){
	           				System.out.println("imageList : "+imageObj.getPROJECT_IMAGE_ID());
			        	   java.sql.Blob image=imageObj.getIMAGE();
			                byte[ ] imgData = image.getBytes(1,(int)image.length());
							resourceResponse.setContentType(imageObj.getIMAGE_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
	           		}
	        }
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForDocument")){
	        	 long documentID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectDocumentID"));
		            DocumentRegistration documentObj = DocumentRegistrationLocalServiceUtil.findByPROJECT_DOCUMENT_ID(documentID);
	           			 //Photo photo=PhotoLocalServiceUtil.getPhoto(imageId);
			        	    java.sql.Blob document = documentObj.getDOCUMENT();
			                byte[ ] documentData = document.getBytes(1,(int)document.length());
							resourceResponse.setContentType(documentObj.getDOCUMENT_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(documentData);
							o.flush();
							o.close();
	        }
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForProjectImage")){
	        	 long photoImageGalleryID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectIDForProjectImage"));
		            ProjectRegistration imageList= ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(photoImageGalleryID);
		            BenificiaryRegistration benificaryImage = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(imageList.getBENIFICIARY_ID());
	           			 //Photo photo=PhotoLocalServiceUtil.getPhoto(imageId);
			        	   java.sql.Blob image=benificaryImage.getIMAGE();
			                byte[ ] imgData = image.getBytes(1,(int)image.length());
							resourceResponse.setContentType(benificaryImage.getIMAGE_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
