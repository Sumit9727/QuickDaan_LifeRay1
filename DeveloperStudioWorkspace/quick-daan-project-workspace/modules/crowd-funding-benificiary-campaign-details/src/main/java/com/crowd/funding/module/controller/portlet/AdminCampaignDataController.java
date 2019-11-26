package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.DonorRegistration;
import com.crowd.funding.database.model.FeedbackRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectFollowerRegistration;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.QuestionRegistration;
import com.crowd.funding.database.model.UpdateRequesterRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DonorRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FeedbackRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.QuestionRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UpdateRequesterRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.SendNotificationToUserHandler;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Admin Campaigns Full Details",
			"javax.portlet.init-param.template-path=/",
			"com.liferay.portlet.header-portlet-css=/CSS/custom.css",
			"javax.portlet.init-param.view-template=/jsp/AdminCampaignDetails/AdminCampaignList.jsp",
			"javax.portlet.name=Admin Campaigns Full Details",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class AdminCampaignDataController extends MVCPortlet {
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			String serverResourceCall = ParamUtil.getString(resourceRequest, "serverResourceCall");
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForImage")){
	        	 long photoImageGalleryID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectImage"));
		            List<ImageRegistration> imageList= ImageRegistrationLocalServiceUtil.findByPROJECT_ID(photoImageGalleryID);
	           		for(ImageRegistration imageObj : imageList){
			        	   java.sql.Blob image=imageObj.getIMAGE();
			                byte[ ] imgData = image.getBytes(1,(int)image.length());
							resourceResponse.setContentType(imageObj.getIMAGE_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
	           		}
	        }
			
			if(serverResourceCall.equalsIgnoreCase("acknowledgementIDForDocument")){
	        	 long acknowledgementID = Long.parseLong(ParamUtil.getString(resourceRequest, "acknowledgementDocumentID"));
		            ProjectAcknowledgementRegistration acknowledgementIDObj = ProjectAcknowledgementRegistrationLocalServiceUtil.fetchProjectAcknowledgementRegistration(acknowledgementID);
			        	    java.sql.Blob document = acknowledgementIDObj.getDOCUMENT();
			                byte[ ] documentData = document.getBytes(1,(int)document.length());
							resourceResponse.setContentType(acknowledgementIDObj.getDOCUMENT_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(documentData);
							o.flush();
							o.close();
	        }
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForDocument")){
	        	 long documentID = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectDocumentID"));
		            DocumentRegistration documentObj = DocumentRegistrationLocalServiceUtil.findByPROJECT_DOCUMENT_ID(documentID);
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
			        	   java.sql.Blob image=benificaryImage.getIMAGE();
			                byte[ ] imgData = image.getBytes(1,(int)image.length());
							resourceResponse.setContentType(benificaryImage.getIMAGE_TYPE());
							OutputStream o = resourceResponse.getPortletOutputStream();
							o.write(imgData);
							o.flush();
							o.close();
	        }
			
			if(serverResourceCall.equalsIgnoreCase("ProjectIDForProjectVideo")){
				
	        	 long projectId = Long.parseLong(ParamUtil.getString(resourceRequest, "ProjectIDForProjectVideo"));
		            ProjectRegistration videoObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
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
