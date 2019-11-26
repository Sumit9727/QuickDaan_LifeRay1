package com.crowd.funding.dynamic.fees.controller.portlet;

import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.model.ProjectFeesRegistration;
import com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil;
import com.crowd.funding.dynamic.fees.controller.constants.CrowdFundingDynamicFeesMgmtPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
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
		"javax.portlet.display-name=Dynamic Fees",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/DynamicFeesMgmt/DynamicFeesMgmt.jsp",
		"javax.portlet.name=Dynamic Fees",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrowdFundingDynamicFeesManagement extends MVCPortlet {
	
	public void CreateCategoryDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			String categoryName = actionRequest.getParameter("categoryName");
			float processFees = Float.parseFloat(actionRequest.getParameter("processFees"));
			float projectFees = Float.parseFloat(actionRequest.getParameter("projectFees"));
			float paymentGateway = Float.parseFloat(actionRequest.getParameter("paymentGateway"));
			
			long categoryID = 0;
			DynamicFeesRegistration feesRegistration = null;
			categoryID = CounterLocalServiceUtil.increment(DynamicFeesRegistration.class.getName());
			feesRegistration = DynamicFeesRegistrationLocalServiceUtil.createDynamicFeesRegistration(categoryID);
			
			feesRegistration.setCATEGORY_NAME(categoryName);
			feesRegistration.setPROCESSING_FEES(processFees);
			feesRegistration.setPROJECT_FEES(projectFees);
			feesRegistration.setPAYMENT_GATEWAY_CHARGES(paymentGateway);
			
			DynamicFeesRegistrationLocalServiceUtil.addDynamicFeesRegistration(feesRegistration);
			
		} catch (Exception e) {
		}
	}
	
	public void deleteCategoryDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long dynamicFeesID = Long.parseLong(actionRequest.getParameter("dynamicFeesID"));
			int flag = 0;
			DynamicFeesRegistration deleteFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(dynamicFeesID);
			
			List<ProjectFeesRegistration> projectFeesList = ProjectFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(deleteFeesRegistration.getCATEGORY_ID());
			for(ProjectFeesRegistration projectFeesObj : projectFeesList) {
				if(projectFeesObj.getCATEGORY_ID() == dynamicFeesID) {
					flag = 1;
				}
			}
			
			if(flag == 0) {
				DynamicFeesRegistrationLocalServiceUtil.deleteDynamicFeesRegistration(deleteFeesRegistration);
			}else if(flag == 1) {
				actionResponse.setRenderParameter("dynamicFeesID", String.valueOf(dynamicFeesID));
				actionResponse.setRenderParameter("jspPage", "/jsp/DynamicFeesMgmt/DynamicFeesMgmt.jsp");
			}
			
		} catch (Exception e) {
		}
	}
}