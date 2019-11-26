package com.crowd.funding.recruitment.portlet;

import com.crowd.funding.recruitment.constants.CrowdFundingRecruitmentPortletKeys;

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
			"javax.portlet.display-name=Career Page",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/currentcarrier/CurrentCarrierPage.jsp",
			"javax.portlet.name=Carrier Page", 
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrowdFundingRecruitmentPortlet extends MVCPortlet {
}