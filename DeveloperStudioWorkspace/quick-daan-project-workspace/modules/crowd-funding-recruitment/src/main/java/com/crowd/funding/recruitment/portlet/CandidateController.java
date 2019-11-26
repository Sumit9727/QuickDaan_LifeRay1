package com.crowd.funding.recruitment.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import org.osgi.service.component.annotations.Component;
import com.crowd.funding.database.model.CandidateRegistration;
import com.crowd.funding.database.service.CandidateRegistrationLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import com.crowd.funding.recruitment.constants.CrowdFundingRecruitmentPortletKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=Crowd Funding",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Candidate Page",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/candidate/CurrentOpeningPage.jsp",
			"javax.portlet.name=Candidate Page", 
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class CandidateController extends MVCPortlet{
	
	public void applyForNewJob(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		UploadPortletRequest portletRequest = null;
		portletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String PositionId = actionRequest.getParameter("PositionId");
		String candidateName = actionRequest.getParameter("candidateName");
		String candidateEmail = actionRequest.getParameter("candidateEmail");
		String mobileNumber = actionRequest.getParameter("mobileNumber");
		String currentLocation = actionRequest.getParameter("currentLocation");
		String experience = actionRequest.getParameter("experience");
		File file =  portletRequest.getFile("resume");
		Date date = new Date();
		
		long candidateId = 0;

		CandidateRegistration candidateRegistrationObj = null;
		candidateId = CounterLocalServiceUtil.increment(CandidateRegistration.class.getName());
		candidateRegistrationObj = CandidateRegistrationLocalServiceUtil.createCandidateRegistration(candidateId);
		
		candidateRegistrationObj.setPOSITION_ID(Long.parseLong(PositionId));
		candidateRegistrationObj.setNAME(candidateName);
		candidateRegistrationObj.setEMAIL(candidateEmail);
		candidateRegistrationObj.setMOBILE_NO(Long.parseLong(mobileNumber));
		candidateRegistrationObj.setCURRENT_LOCATION(currentLocation);
		candidateRegistrationObj.setEXPERIENCE(experience);
		 if(file != null && file.length() > 0){
				OutputBlob outputBlobDocuments=null;
				InputStream inputStream = new FileInputStream(file);
				outputBlobDocuments = new OutputBlob(inputStream, file.length());
				candidateRegistrationObj.setRESUME_TYPE(MimeTypesUtil.getContentType(file));
				candidateRegistrationObj.setRESUME(outputBlobDocuments);
			 }
		candidateRegistrationObj.setDATE(date);
		candidateRegistrationObj.setSTATUS(CrowdFundingRecruitmentPortletKeys.ACTIVE_STATUS);

		CandidateRegistrationLocalServiceUtil.addCandidateRegistration(candidateRegistrationObj);
		 
		 
	}

}
