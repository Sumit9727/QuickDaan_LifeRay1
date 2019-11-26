package crowd.funding.newsletter.email.portlet;


import crowd.funding.newsletter.email.constants.NewsLetterEmailControllerPortletKeys;
import crowd.funding.newsletter.send.email.SendAttachmentInEmail;

import com.crowd.funding.database.model.NewsLetterRegistration;
import com.crowd.funding.database.model.SubscriptionRegistration;
import com.crowd.funding.database.service.NewsLetterRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.SubscriptionRegistrationLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-Intern
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AddContentNewsletter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/NewsLetterRegistration.jsp",
		"javax.portlet.name=AddContentNewsletter",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsLetterEmailControllerPortlet extends MVCPortlet {
	
	public void NewsletterSubscription(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			String email = actionRequest.getParameter("newsletter");
			
			long subscriptionId = 0;
			SubscriptionRegistration subscriptionRegistration = null;
			subscriptionId = CounterLocalServiceUtil.increment(SubscriptionRegistration.class.getName());
			subscriptionRegistration = SubscriptionRegistrationLocalServiceUtil.createSubscriptionRegistration(subscriptionId);
			
			subscriptionRegistration.setEMAIL(email);
			subscriptionRegistration.setSTATUS(NewsLetterEmailControllerPortletKeys.NEWS_LETTER_SUBSCRIPTION_STATUS_1);
			
			SubscriptionRegistrationLocalServiceUtil.addSubscriptionRegistration(subscriptionRegistration);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public void NewsletterRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		UploadPortletRequest portletRequest = null;
		portletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		
		String subject = actionRequest.getParameter("newslettertitle");
		String body = actionRequest.getParameter("newsletterdetail");
		File file =  portletRequest.getFile("file");
		
		String fileName = file.getName();
		
		InputStream inputStream = new FileInputStream(file);
		OutputBlob blobData = new OutputBlob(inputStream, file.length());
		
		long newsletterId = 0;
		NewsLetterRegistration letterRegistration = null;
		newsletterId = CounterLocalServiceUtil.increment(NewsLetterRegistration.class.getName());
		letterRegistration = NewsLetterRegistrationLocalServiceUtil.createNewsLetterRegistration(newsletterId);
		
		letterRegistration.setTITLE(subject);
		letterRegistration.setDETAILS(body);
		letterRegistration.setDATE(new Date());
		letterRegistration.setDOCUMENT(blobData);
		letterRegistration.setDOCUMENT_TYPE(MimeTypesUtil.getContentType(file));
		NewsLetterRegistrationLocalServiceUtil.addNewsLetterRegistration(letterRegistration);
		String path = file.getPath();
		String filepath = path.replace('\\', '/');
		
		
		List<SubscriptionRegistration>  subcriptionlist = SubscriptionRegistrationLocalServiceUtil.findBySTATUS(1);
		for(SubscriptionRegistration subscriptionObj : subcriptionlist)
		{
			String toemail = subscriptionObj.getEMAIL();
			
			SendAttachmentInEmail email = new SendAttachmentInEmail();
			email.sendEmail(toemail, subject, body, filepath);
		}
	}
}