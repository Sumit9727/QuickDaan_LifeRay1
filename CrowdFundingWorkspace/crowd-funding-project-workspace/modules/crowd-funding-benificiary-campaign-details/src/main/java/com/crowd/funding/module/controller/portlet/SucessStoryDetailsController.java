package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Sucess Story",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/SuccessStory Details/ProjectAcnowledgmentList.jsp",
			"javax.portlet.name=Sucess Story",
			"com.liferay.portlet.header-portlet-css=/CSS/custom.css",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)


public class SucessStoryDetailsController extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			String serverResourceCall = ParamUtil.getString(resourceRequest, "serverResourceCall");
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForDocument")){
	        	 long documentID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectDocumentID"));
		            DocumentRegistration documentObj = DocumentRegistrationLocalServiceUtil.findByPROJECT_DOCUMENT_ID(documentID);
	           			 //Photo photo=PhotoLocalServiceUtil.getPhoto(imageId);
			        	    java.sql.Blob document = documentObj.getDOCUMENT();
			                byte[ ] documentData = document.getBytes(1,(int)document.length());
							resourceResponse.setContentType(documentObj.getDOCUMENT_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(documentData);
							o.flush();
							o.close();
	        }
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForProjectImage")){
	        	 long photoImageGalleryID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectIDForProjectImage"));
		            ProjectRegistration imageList= ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(photoImageGalleryID);
		            BenificiaryRegistration benificaryImage = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(imageList.getBENIFICIARY_ID());
	           			 //Photo photo=PhotoLocalServiceUtil.getPhoto(imageId);
			        	   java.sql.Blob image=benificaryImage.getIMAGE();
			                byte[ ] imgData = image.getBytes(1,(int)image.length());
							resourceResponse.setContentType(benificaryImage.getIMAGE_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
	        }
					
			if(serverResourceCall.equalsIgnoreCase("AcnowledgmentIDForProjectVideo")){
				
	        	 long projectId = Long.parseLong(ParamUtil.getString(resourceRequest, "AcnowledgmentIDForProjectVideo"));
		            ProjectAcknowledgementRegistration videoObj = ProjectAcknowledgementRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
	           			 //Photo photo=PhotoLocalServiceUtil.getPhoto(imageId);
			        	   java.sql.Blob video = videoObj.getVIDEO();
			                byte[ ] imgData = video.getBytes(1,(int)video.length());
							resourceResponse.setContentType(videoObj.getVIDEO_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
							
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
