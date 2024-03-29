package com.crowd.funding.admin.report.portlet;

import com.crowd.funding.admin.report.constants.CrowdFundingAdminReportPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=Crowd Funding",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Crowd Funding Report",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/Report.jsp",
			"javax.portlet.name=Crowd Funding Report",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrowdFundingAdminReportPortlet extends MVCPortlet {
}