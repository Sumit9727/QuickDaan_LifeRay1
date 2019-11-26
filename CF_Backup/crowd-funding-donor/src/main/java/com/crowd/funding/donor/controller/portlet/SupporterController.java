package com.crowd.funding.donor.controller.portlet;

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
	        "javax.portlet.display-name=Supporter",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/supporter/Supporter.jsp",
	        "javax.portlet.name=Supporter",
	        "javax.portlet.resource-bundle=content.Language",
	        "javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class SupporterController extends MVCPortlet {

}
