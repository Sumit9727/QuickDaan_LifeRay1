package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
		"javax.portlet.display-name=Campaign Approval",
		"javax.portlet.init-param.template-path=/",
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
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			
			
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			try {
				
				String enddate = actionRequest.getParameter("enddate");
			
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date =  formatter.parse(enddate);
				projectRegistration.setEND_DATE(date);
			
			} catch (Exception e) {
				
			}
			
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			ProjectPriorityRegistration priorityRegistration = null;
			long priorityID = 0;
			
			System.out.println("1");
			priorityID = CounterLocalServiceUtil.increment(ProjectPriorityRegistration.class.getName());
			priorityRegistration = ProjectPriorityRegistrationLocalServiceUtil.createProjectPriorityRegistration(priorityID);
			
			System.out.println("2");
			
			priorityRegistration.setPROJECT_ID(projectRegistration.getPROJECT_ID());
			priorityRegistration.setPRIORITY(CrowdFundingBenificiaryDetailsPortletKeys.Priority_0);
			
			ProjectPriorityRegistrationLocalServiceUtil.addProjectPriorityRegistration(priorityRegistration);
			System.out.println("3");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void RejectDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
		
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
