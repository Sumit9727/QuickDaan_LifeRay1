package com.crowd.funding.donor.controller.portlet;

import com.crowd.funding.database.model.FeedbackRegistration;
import com.crowd.funding.database.model.QuestionRegistration;
import com.crowd.funding.database.model.UpdateRequesterRegistration;
import com.crowd.funding.database.service.FeedbackRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UpdateRequesterRegistrationLocalServiceUtil;
import com.crowd.funding.donor.controller.constants.DonorControllerPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
			"com.liferay.portlet.display-category=Crowd Funding",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=Post Donations",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/post_donations/PostDonationActivities.jsp",
	        "javax.portlet.name=Post Donations",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class PostDonationActivityController extends MVCPortlet {
	
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
			questionRegistration.setSTATUS(DonorControllerPortletKeys.QUESTION_POST_STATUS_1);
			
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
			feedbackRegistration.setSTATUS(DonorControllerPortletKeys.FEEDBACK_POST_STATUS_1);
			
			FeedbackRegistrationLocalServiceUtil.addFeedbackRegistration(feedbackRegistration);
			
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
			updateRequesterRegistration.setSTATUS(DonorControllerPortletKeys.UPDATE_REQUEST_POST_STATUS_1);
			
			UpdateRequesterRegistrationLocalServiceUtil.addUpdateRequesterRegistration(updateRequesterRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
