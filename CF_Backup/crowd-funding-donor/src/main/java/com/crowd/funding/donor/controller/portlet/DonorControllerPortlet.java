package com.crowd.funding.donor.controller.portlet;

import com.crowd.funding.database.model.FundOTPRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.service.FundOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.donor.controller.constants.CrowdFundingMail;
import com.crowd.funding.donor.controller.constants.DonorControllerPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=Crowd Funding",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=Donor",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/payment/init.jsp",
	        "javax.portlet.name=Donor",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class DonorControllerPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		renderResponse.setContentType(renderRequest.getResponseContentType());
		
		ThemeDisplay themeDisplayObj = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean signedIn = themeDisplayObj.isSignedIn();
		String url = null;
		if(signedIn == true){
				url = "/jsp/payment/DonateAmount.jsp";
				getPortletContext().getRequestDispatcher(url).include(renderRequest, renderResponse);
		}else {
			url="/jsp/payment/DonateAnonymousOptions.jsp";
			getPortletContext().getRequestDispatcher(url).include(renderRequest, renderResponse);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	public void emailMobileRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
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
		    
		    CrowdFundingMail.sendMail(mailSubject, mailBody, email);
		    
		    actionResponse.setRenderParameter("mobileNo", mobileNo);
		    actionResponse.setRenderParameter("jspPage", "/jsp/payment/OTPValidation.jsp");
		    
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void otpAuthentication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
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
		    
		    CrowdFundingMail.sendMail(mailSubject, mailBody, fundOtpObj.getMAIL_ADDRESS());
		    
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
			
			if(fundOtpId.length() > 0)
				fundRegistration.setFUND_OTP_ID(Long.parseLong(fundOtpId));
			
			fundRegistration.setCURRENCY(currency);
			fundRegistration.setPROJECT_ID(Long.parseLong(projectId));
			fundRegistration.setDONATED_AMOUNT(Float.parseFloat(amount));
			fundRegistration.setDONOR_USER_ID(UserId);
			
			if(donateAnonymously != null && UserId > 0)
				fundRegistration.setDONOR_STATUS(DonorControllerPortletKeys.DONATE_ANONYMOSULY_STATUS_0);
			if(donateAnonymously == null && UserId > 0)
				fundRegistration.setDONOR_STATUS(DonorControllerPortletKeys.DONATE_ANONYMOSULY_STATUS_1);
			if(donateAnonymously == null && UserId == 0)
				fundRegistration.setDONOR_STATUS(DonorControllerPortletKeys.DONATE_ANONYMOSULY_STATUS_0);
				
			fundRegistration.setCOMMENT(message);
			fundRegistration.setDONATED_DATE(date);
			
			FundRegistrationLocalServiceUtil.addFundRegistration(fundRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}