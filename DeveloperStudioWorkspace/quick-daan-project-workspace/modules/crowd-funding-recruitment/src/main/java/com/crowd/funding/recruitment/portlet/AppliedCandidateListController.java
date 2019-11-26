package com.crowd.funding.recruitment.portlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.crowd.funding.database.model.CandidateRegistration;
import com.crowd.funding.database.service.CandidateRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=Crowd Funding",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Applied Candidate Page",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/AppliedCandidateList/AppliedCandidateListPage.jsp",
			"javax.portlet.name=Applied Candidate Page", 
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AppliedCandidateListController extends MVCPortlet{
@Override
public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
	try {
        long CandidateId = ParamUtil.getLong(resourceRequest, "CandidateId");
        String fileName = "Document";
	    CandidateRegistration documentObj = CandidateRegistrationLocalServiceUtil.findByCANDIDATE_ID(CandidateId);
			
			 java.sql.Blob document = documentObj.getRESUME();
                byte[ ] documentData = document.getBytes(1,(int)document.length());
				resourceResponse.setContentType(documentObj.getRESUME_TYPE());
				OutputStream o = resourceResponse.getPortletOutputStream();
				o.write(documentData);
				o.flush();
				o.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
