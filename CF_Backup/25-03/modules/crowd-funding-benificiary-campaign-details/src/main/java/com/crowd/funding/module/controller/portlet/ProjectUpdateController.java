package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.model.FundAccountRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectFeesRegistration;
import com.crowd.funding.database.model.ProjectFollowerRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.ProjectUpdateRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectAcknowledgementRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.crowd.funding.module.controller.constants.SendNotificationToUserHandler;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.LiferayPortlet;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-016
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=CrowdFundingDetails",
	        "com.liferay.portlet.instanceable=true",
	        "javax.portlet.display-name=My Campaigns",
	        "javax.portlet.init-param.template-path=/",
	        "javax.portlet.init-param.view-template=/jsp/MyCampaign/MyCampaign.jsp",
	        "javax.portlet.name=My Campaigns",
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
			updateRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.PROJECT_UPDATE_POST_STATUS_1);
			
			ProjectUpdateRegistrationLocalServiceUtil.addProjectUpdateRegistration(updateRegistration);
			
			
							/*CAMPAIGN FOLLOWER*/
			
			List<ProjectFollowerRegistration> followerlist = ProjectFollowerRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectId));
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectId));
			
			for(ProjectFollowerRegistration projectFollowerObj : followerlist) {
				
				try {
					
					ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
					
					
						JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("userId", projectFollowerObj.getUSER_ID());
						jsonObject.put("senderName", "Quick Daan Campaign");
						jsonObject.put("notificationText", projectRegistration.getTITLE() + " is Updated.");
						
						UserNotificationEventLocalServiceUtil.addUserNotificationEvent(projectFollowerObj.getUSER_ID(), SendNotificationToUserHandler.PORTLET_ID,
								(new java.util.Date()).getTime(), 10002, projectFollowerObj.getUSER_ID(), jsonObject.toString(), false, serviceContext);
				
					} catch (Exception e) {
					e.printStackTrace();
					}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void requestFundWithdraw(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			System.out.println("Withdraw Amount .1");
			long ProjectId = Long.parseLong(actionRequest.getParameter("ProjectId"));
			String btn = actionRequest.getParameter("btn");
			float totalAmt = Float.parseFloat(actionRequest.getParameter("totalAmt"));
			System.out.println("Withdraw Amount .2"+btn);
			
			ProjectRegistration requestFundWithdrawProject = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			
			if(requestFundWithdrawProject.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4) {
							
							requestFundWithdrawProject.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6);
							
							ProjectRegistrationLocalServiceUtil.updateProjectRegistration(requestFundWithdrawProject);
							
			}
			if(btn.equalsIgnoreCase("continue") == true) {
				float totalDonatedAmt = 0;
				float remainingAmt = 0;
				
				List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
				for(FundRegistration fundAmtObj : fundAmtList){
					float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
					totalDonatedAmt = totalDonatedAmt + donatedAmt;
					remainingAmt = donatedAmt - totalDonatedAmt;
				} 
				
				SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z");
			    Date date = new Date();
			        
				long fundReleaseId = 0;
				FundReleaseRegistration fundReleaseRegistration = null;
				
				fundReleaseId = CounterLocalServiceUtil.increment(FundReleaseRegistration.class.getName());
				fundReleaseRegistration = FundReleaseRegistrationLocalServiceUtil.createFundReleaseRegistration(fundReleaseId);
				
				fundReleaseRegistration.setPROJECT_ID(ProjectId);
				fundReleaseRegistration.setTOTAL_WITHDRAW_AMOUNT(totalAmt);
				fundReleaseRegistration.setCURRENCY("INR");
				fundReleaseRegistration.setRELEASE_DATE(date);
				
				FundReleaseRegistrationLocalServiceUtil.addFundReleaseRegistration(fundReleaseRegistration);
				
				UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(requestFundWithdrawProject.getUSER_ID());
				 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
				 String mailSubject = "Quick Daan - Withdrawn Fund";
				    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYou have withdrawn " +
				    		totalDonatedAmt +" sucessfully on your "+ requestFundWithdrawProject.getTITLE() +"Quick Daan portal." +"\n\n\nThank You For Visiting Crowd Funding.";

				CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
				
			}
			if(btn.equalsIgnoreCase("stop") == true) {
				
				requestFundWithdrawProject.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_6);
				
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(requestFundWithdrawProject);
				
			}
			if(btn.equalsIgnoreCase("delete") == true) {
				
				
				requestFundWithdrawProject.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_8);
				
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(requestFundWithdrawProject);
			}
			
						
		} catch (Exception e) {
		}
	}
	
	public void ChangeCategoryDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long changeCategory = Long.parseLong(actionRequest.getParameter("changeCategory"));
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			
			System.out.println("changeCategory :: "+changeCategory);
			System.out.println("projectID  ::: "+projectID);
			if(changeCategory == 0) {
				 SessionErrors.add(actionRequest, "error-key");
				 PortletConfig portletConfig =  (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				 SessionMessages.add(actionRequest, ((LiferayPortletConfig)portletConfig).getPortletId() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}else {
				ProjectFeesRegistration feesRegistration = null;
				
				long projectFeesID = 0;
				Date date = new Date();
				float startAmount = 0 ;
				float endAmount = 0;
				
				float totalDonatedAmt = 0;
				
				List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
				for(FundRegistration fundAmtObj : fundAmtList){
					float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
					totalDonatedAmt = totalDonatedAmt + donatedAmt;
				}
				ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
				List<ProjectFeesRegistration> projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
				if(projectFeesRegistration != null) {
					for(ProjectFeesRegistration feesObj : projectFeesRegistration) {
						if(feesObj.getEND_AMOUNT() == 0) {
							feesObj.setEND_AMOUNT(totalDonatedAmt);
							feesObj.setWITHDRAW_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_WITHDRAW_STATUS_1);
							ProjectFeesRegistrationLocalServiceUtil.updateProjectFeesRegistration(feesObj);
							startAmount = feesObj.getEND_AMOUNT();
							endAmount = totalDonatedAmt ;
						}
					}
				}
				else {
					startAmount = CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_START_AMOUNT_0;
					endAmount = CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_END_AMOUNT_0;
				}
				
				projectFeesID = CounterLocalServiceUtil.increment(ProjectFeesRegistration.class.getName());
				feesRegistration = ProjectFeesRegistrationLocalServiceUtil.createProjectFeesRegistration(projectFeesID);
				
				feesRegistration.setCATEGORY_ID(changeCategory);
				feesRegistration.setPROJECT_ID(projectID);
				feesRegistration.setDATE(date);
				feesRegistration.setSTART_AMOUNT(startAmount);
				feesRegistration.setEND_AMOUNT(CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_END_AMOUNT_0);
				feesRegistration.setWITHDRAW_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_WITHDRAW_STATUS_0);
				
				ProjectFeesRegistrationLocalServiceUtil.addProjectFeesRegistration(feesRegistration);
			}
			
		} catch (Exception e) {
		}
	}
	
	public void ProjectAcknowlegementDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long ProjectId = Long.parseLong(actionRequest.getParameter("ProjectID"));
			String description = actionRequest.getParameter("description");
			String documentName = actionRequest.getParameter("documentName");
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z");
		    Date date = new Date();
			
			UploadPortletRequest uploadRequestDocument = PortalUtil.getUploadPortletRequest(actionRequest);
			File documentFile = uploadRequestDocument.getFile("documentFile");
			OutputBlob outputBlobDocuments=null;
			InputStream inputStreamDocument;
			
			inputStreamDocument = new FileInputStream(documentFile);
			outputBlobDocuments = new OutputBlob(inputStreamDocument, documentFile.length());
			    		
			ProjectAcknowledgementRegistration acknowledgementRegistration = null;
			long AcknowlegementID = 0;
			
			UploadPortletRequest uploadRequestVideo = PortalUtil.getUploadPortletRequest(actionRequest);
			File videoFile = uploadRequestVideo.getFile("videoFile");
			OutputBlob outputBlobVideo=null;
			InputStream videoInputStream = new FileInputStream(videoFile);
			outputBlobVideo = new OutputBlob(videoInputStream, videoFile.length());
			
			AcknowlegementID = CounterLocalServiceUtil.increment(ProjectAcknowledgementRegistration.class.getName());
			acknowledgementRegistration = ProjectAcknowledgementRegistrationLocalServiceUtil.createProjectAcknowledgementRegistration(AcknowlegementID);
			
			acknowledgementRegistration.setPROJECT_ID(ProjectId);
			acknowledgementRegistration.setDETAILS(description);
			acknowledgementRegistration.setDATE(date);
			acknowledgementRegistration.setVIDEO(outputBlobVideo);
			acknowledgementRegistration.setVIDEO_TYPE(MimeTypesUtil.getContentType(videoFile));
			acknowledgementRegistration.setDOCUMENT(outputBlobDocuments);
			acknowledgementRegistration.setDOCUMENT_TYPE(MimeTypesUtil.getContentType(documentFile));
			acknowledgementRegistration.setDOCUMENT_NAME(documentName);
			
			ProjectAcknowledgementRegistrationLocalServiceUtil.addProjectAcknowledgementRegistration(acknowledgementRegistration);
			
		} catch (Exception e) {
		}
	}
	
	
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
			
			if(serverResourceCall.equalsIgnoreCase("projectCategory")){
				JSONArray projectJsonArray = JSONFactoryUtil.createJSONArray();
	        	 long categoryID = Long.parseLong(ParamUtil.getString(resourceRequest, "changedCategory"));
		           DynamicFeesRegistration feesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(categoryID);
		           if(feesRegistration!=null){
		        	   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						jsonObject.put("processingFees",String.valueOf(feesRegistration.getPROCESSING_FEES()));
						jsonObject.put("categoryName",feesRegistration.getCATEGORY_NAME());
						jsonObject.put("ProjectFees",String.valueOf(feesRegistration.getPROJECT_FEES()));
						jsonObject.put("gatewayCharges",String.valueOf(feesRegistration.getPAYMENT_GATEWAY_CHARGES()));
						projectJsonArray.put(jsonObject);
		           }
		           PrintWriter writer = resourceResponse.getWriter();
			        writer.write(projectJsonArray.toString());
			        writer.flush();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
