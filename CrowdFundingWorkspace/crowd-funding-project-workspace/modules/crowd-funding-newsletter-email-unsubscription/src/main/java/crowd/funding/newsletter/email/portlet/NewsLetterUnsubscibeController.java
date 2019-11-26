package crowd.funding.newsletter.email.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.crowd.funding.database.model.SubscriptionRegistration;
import com.crowd.funding.database.service.SubscriptionRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;


import crowd.funding.newsletter.email.constants.NewsLetterEmailControllerPortletKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=UnsubscribeNewsLetter",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/UnsubscribeMessage.jsp",
			"javax.portlet.name=UnsubscribeNewsLetter",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class NewsLetterUnsubscibeController extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)); 
			String email = httpRequest.getParameter("email");
			
			SubscriptionRegistration registration = SubscriptionRegistrationLocalServiceUtil.findByEMAIL(email);
			
			registration.setSTATUS(NewsLetterEmailControllerPortletKeys.NEWS_LETTER_SUBSCRIPTION_STATUS_0);
			SubscriptionRegistrationLocalServiceUtil.updateSubscriptionRegistration(registration);
			
			renderRequest.setAttribute("email",email);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

}
