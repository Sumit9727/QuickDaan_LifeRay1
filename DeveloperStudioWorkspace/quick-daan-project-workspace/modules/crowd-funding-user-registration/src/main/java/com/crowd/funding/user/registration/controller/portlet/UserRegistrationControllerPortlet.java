 package com.crowd.funding.user.registration.controller.portlet;

import com.crowd.funding.database.exception.NoSuchUserOTPRegistrationException;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.user.registration.controller.constants.CrowdFundingMail;
import com.crowd.funding.user.registration.controller.constants.UserRegistrationControllerPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
/*import com.crowd.funding.db.service.controller.model.UserRegistration;
import com.crowd.funding.db.service.controller.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.user.registration.controller.constants.UserRegistrationControllerPortletKeys;*/
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.persistence.UserUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=Crowd Funding",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=User Registration",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/OTPAuthenticationForm.jsp",
	        "javax.portlet.name=User Registration",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)


public class UserRegistrationControllerPortlet extends MVCPortlet {
	
	public void emailMobileRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String timerValue = "1";
			String email = actionRequest.getParameter("email");
			String mobileNo = actionRequest.getParameter("mobileNo");
			String otpReceivingOption = actionRequest.getParameter("otpReceivingOption");
			Date date = new Date();
			
			try {
				ThemeDisplay display = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				User userObj = UserLocalServiceUtil.fetchUserByEmailAddress(display.getCompanyId(), email);
				System.out.println("Mail Id is Exists ::::::  " + userObj.getEmailAddress().isEmpty());
				SessionErrors.add(actionRequest, "error-key");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setRenderParameter("jspPage", "/jsp/OTPAuthenticationForm.jsp");

			} catch (Exception e) {
				
				long otpId = 0;
				UserOTPRegistration otpRegistration = null;
				otpId = CounterLocalServiceUtil.increment(UserOTPRegistration.class.getName());
				otpRegistration = UserOTPRegistrationLocalServiceUtil.createUserOTPRegistration(otpId);
				
				Random rnd = new Random();
			    int otpNumber = rnd.nextInt(999999);
			    
			    otpRegistration.setMAIL(email);
			    otpRegistration.setMOBILE_NO(Long.parseLong(mobileNo));
			    otpRegistration.setOTP(otpNumber);
			    otpRegistration.setOTP_DEVICE(Integer.parseInt(otpReceivingOption));
			    otpRegistration.setCREATION_DATE_TIME(date);
			    
			    UserOTPRegistrationLocalServiceUtil.addUserOTPRegistration(otpRegistration);
			    
			    if(otpReceivingOption.equalsIgnoreCase(UserRegistrationControllerPortletKeys.OTP_DEVICE_MAIL_1)) {
			    String mailSubject = "Quick Daan - Registration OTP";
			    String mailBody = "Dear User," + "\n\nYour One Time Password is " +
			    		otpNumber +". It is valid for 2 minutes for Quick Daan login authentication for your account associated with Mobile Number "+ mobileNo +"\n\n\nThank You For Visiting Quick Daan.";
			    
			    CrowdFundingMail.sendMail(mailSubject, mailBody, email);
			    }else {
			    	/*SMS Integration Code*/
			    }
			    
			    SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			    actionResponse.setRenderParameter("timerValue", timerValue);
			    actionResponse.setRenderParameter("mobileNo", mobileNo);
			    actionResponse.setRenderParameter("otpReceivingOption", otpReceivingOption);
			    actionResponse.setRenderParameter("jspPage", "/jsp/OTPValidation.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void otpAuthentication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String mobileNo = actionRequest.getParameter("mobileNo");
			String emailOtp = actionRequest.getParameter("emailOtp");
			String mobileOtp = actionRequest.getParameter("mobileOtp");
			
			int otpStatus = 0;
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByMOBILE_NO(Long.parseLong(mobileNo));
			if(otpObj.getOTP() == UserRegistrationControllerPortletKeys.OTP_EXPIRED) {
				SessionErrors.add(actionRequest, "otp-expired-error-key");
			}
			
			if(String.valueOf(otpObj.getOTP()).equalsIgnoreCase(emailOtp) || String.valueOf(otpObj.getOTP()).equalsIgnoreCase(mobileOtp) ) {
				otpStatus = UserRegistrationControllerPortletKeys.OTP_VALUE_1;
			}else {
				otpStatus = UserRegistrationControllerPortletKeys.OTP_VALUE_0;
			}
			
			if(otpStatus == UserRegistrationControllerPortletKeys.OTP_VALUE_1) {
				otpObj.setOTP_VERIFICATION_STATUS(otpStatus);
				UserOTPRegistrationLocalServiceUtil.updateUserOTPRegistration(otpObj);
				actionResponse.setRenderParameter("UserOtpId", String.valueOf(otpObj.getUSER_OTP_ID()));
			    actionResponse.setRenderParameter("jspPage", "/jsp/UserRegistrationForm.jsp");
			}else {
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				SessionErrors.add(actionRequest, "error-key");
			    actionResponse.setRenderParameter("mobileNo", mobileNo);
			    actionResponse.setRenderParameter("otpReceivingOption", String.valueOf(otpObj.getOTP_DEVICE()));
				actionResponse.setRenderParameter("jspPage", "/jsp/OTPValidation.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reSendOtpRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String timerValue = "0";
			String mobileNo = ParamUtil.getString(actionRequest, "mobileNo");
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByMOBILE_NO(Long.parseLong(mobileNo));
			
			Random rnd = new Random();
		    int otpNumber = rnd.nextInt(999999);
		    
		    otpObj.setOTP(otpNumber);
		    UserOTPRegistrationLocalServiceUtil.updateUserOTPRegistration(otpObj);
		    
		    String mailSubject = "Quick Daan - Registration OTP";
		    String mailBody = "Dear User," + "\n\nYour One Time Password is " +
		    		otpNumber +". It is valid for 2 minutes for Quick Daan login for your account associated with Mobile Number "+ mobileNo +"\n\n\nThank You For Visiting Quick Daan.";
		    
		    CrowdFundingMail.sendMail(mailSubject, mailBody, otpObj.getMAIL());
		    
		    actionResponse.setRenderParameter("timerValue", timerValue);
		    actionResponse.setRenderParameter("mobileNo", mobileNo);
		    actionResponse.setRenderParameter("otpReceivingOption", String.valueOf(otpObj.getOTP_DEVICE()));
		    SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		    SessionMessages.add(actionRequest, "success");
		    actionResponse.setRenderParameter("jspPage", "/jsp/OTPValidation.jsp");
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void userRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			String firstName = actionRequest.getParameter("firstName");
			String lastName = actionRequest.getParameter("lastName");
			String UserOtpId = actionRequest.getParameter("UserOtpId");
			
			String fullname = null;
			fullname = firstName + " " + lastName;
			String password = actionRequest.getParameter("password");
			String gender = actionRequest.getParameter("gender");
			Date creationDate=java.util.Calendar.getInstance().getTime();
			
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(Long.parseLong(UserOtpId));
			
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			User quickDaanUser = UserLocalServiceUtil.addUser(0, PortalUtil.getDefaultCompanyId(), false, password, password, false, 
					firstName+"User", otpObj.getMAIL(), 0L, "", themeDisplay.getLocale(), firstName, "", lastName, 0, 0, false,
					10, 1, 1970, "", null, null, null, null, false, new ServiceContext());
			
			Role roleProjectOwner= RoleLocalServiceUtil.fetchRole(PortalUtil.getDefaultCompanyId(), UserRegistrationControllerPortletKeys.ROLE_CF_PROJECT_OWNER);
			UserLocalServiceUtil.addRoleUser(roleProjectOwner.getRoleId(), quickDaanUser.getUserId());
			UserLocalServiceUtil.updateUser(quickDaanUser);
			
		
			Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), UserRegistrationControllerPortletKeys.SITE_NAME_QUICKDAAN);
			UserUtil.addGroup(quickDaanUser.getUserId(), group);
			
			long UserId = quickDaanUser.getUserId();
			UserRegistration userRegistration = null;
			userRegistration = UserRegistrationLocalServiceUtil.createUserRegistration(UserId);
			
			userRegistration.setUSER_OTP_ID(Long.parseLong(UserOtpId));
			userRegistration.setFULL_NAME(fullname);
			userRegistration.setGENDER(gender);
			userRegistration.setCREATION_DATE(creationDate);
			
			UserRegistrationLocalServiceUtil.addUserRegistration(userRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			long mobileNo = ParamUtil.getLong(resourceRequest, "mobileNo");
			
			UserOTPRegistration otpObj = UserOTPRegistrationLocalServiceUtil.findByMOBILE_NO(mobileNo);
			
			otpObj.setOTP(UserRegistrationControllerPortletKeys.OTP_EXPIRED);
			UserOTPRegistrationLocalServiceUtil.updateUserOTPRegistration(otpObj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}