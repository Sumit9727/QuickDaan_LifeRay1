package com.crowd.funding.donor.controller.portlet;

import com.crowd.funding.database.model.ProjectUpdateRegistration;
import com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil;
import com.crowd.funding.donor.controller.constants.DonorControllerPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
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
	        "javax.portlet.display-name=Project Update",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/project_update/ProjectUpdate.jsp",
	        "javax.portlet.name=Project Update",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user,cf_PROJECT_OWNER"
		},
		service = Portlet.class
	)

public class ProjectUpdateController extends MVCPortlet {
	
	public void projectUpdateRegistration(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			Date date = new Date();
			
			String projectId = actionRequest.getParameter("projectId");
			String projectUpdate = actionRequest.getParameter("projectUpdate");
			
			long projectUpdateId = 0;
			ProjectUpdateRegistration updateRegistration = null;
			projectUpdateId = CounterLocalServiceUtil.increment(ProjectUpdateRegistration.class.getName());
			updateRegistration = ProjectUpdateRegistrationLocalServiceUtil.createProjectUpdateRegistration(projectUpdateId);
			
			updateRegistration.setPROJECT_ID(Long.parseLong(projectId));
			updateRegistration.setUPDATE_DETAILS(projectUpdate);
			updateRegistration.setUPDATE_DATE(date);
			updateRegistration.setSTATUS(DonorControllerPortletKeys.PROJECT_UPDATE_POST_STATUS_1);
			
			ProjectUpdateRegistrationLocalServiceUtil.addProjectUpdateRegistration(updateRegistration);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
