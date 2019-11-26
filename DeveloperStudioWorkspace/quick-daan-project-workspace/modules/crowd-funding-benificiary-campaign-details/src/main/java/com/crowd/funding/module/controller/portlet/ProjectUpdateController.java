package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.model.FundAccountRegistration;
import com.crowd.funding.database.model.FundRegistration;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.model.ProjectAcknowledgementRegistration;
import com.crowd.funding.database.model.ProjectExtentionRegistration;
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
import com.crowd.funding.database.service.ProjectExtentionRegistrationLocalService;
import com.crowd.funding.database.service.ProjectExtentionRegistrationLocalServiceUtil;
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
import com.liferay.portal.kernel.util.Validator;
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
	        "com.liferay.portlet.header-portlet-css=/CSS/custom.css",
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
			
			long ProjectId = Long.parseLong(actionRequest.getParameter("ProjectId"));
			String btn = actionRequest.getParameter("btn");
			
			float processingFeesAmt = Float.parseFloat(actionRequest.getParameter("processingFeesAmt"));
			float projectFeesAmt = Float.parseFloat(actionRequest.getParameter("projectFeesAmt"));
			float paymentChargesAmt = Float.parseFloat(actionRequest.getParameter("paymentChargesAmt"));
			float totalAmt = Float.parseFloat(actionRequest.getParameter("totalAmt"));
			long currentCategoryId = Long.parseLong(actionRequest.getParameter("currentCategoryId"));
		
			float processingFees = 0;
			float projectFees = 0;
			float paymentGateWay = 0;
			float checkFeesAmt = 0;
			
			ProjectRegistration requestFundWithdrawProject = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			
			float totalDonatedAmt = 0;
			long categoryID = 0;
			List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			for(FundRegistration fundAmtObj : fundAmtList){
				categoryID = 0;
				DynamicFeesRegistration dynamicCategoryDetails = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(fundAmtObj.getCATEGORY_ID());
				float donatedAmt =  fundAmtObj.getDONATED_AMOUNT();
				processingFees = (donatedAmt*dynamicCategoryDetails.getPROCESSING_FEES())/100 + processingFees;
				projectFees = (donatedAmt*dynamicCategoryDetails.getPROJECT_FEES())/100 + projectFees;
				paymentGateWay = (donatedAmt*dynamicCategoryDetails.getPAYMENT_GATEWAY_CHARGES())/100 + paymentGateWay;
				checkFeesAmt = ((donatedAmt*dynamicCategoryDetails.getPROCESSING_FEES())/100) + ((donatedAmt*dynamicCategoryDetails.getPROJECT_FEES())/100) + ((donatedAmt*dynamicCategoryDetails.getPAYMENT_GATEWAY_CHARGES())/100) ;
				totalDonatedAmt = totalDonatedAmt + (donatedAmt - checkFeesAmt) ;
				categoryID = fundAmtObj.getCATEGORY_ID();
			} 
		    Date date = new Date();
			
			if(requestFundWithdrawProject.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_1) {
				requestFundWithdrawProject.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2);
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(requestFundWithdrawProject);
			}
			
			if(btn.equalsIgnoreCase("continue") == true) {
				
				long fundReleaseId = 0;
				FundReleaseRegistration fundReleaseRegistration = null;
				
				fundReleaseId = CounterLocalServiceUtil.increment(FundReleaseRegistration.class.getName());
				fundReleaseRegistration = FundReleaseRegistrationLocalServiceUtil.createFundReleaseRegistration(fundReleaseId);
				
				fundReleaseRegistration.setPROJECT_ID(ProjectId);
				fundReleaseRegistration.setCURRENCY("INR");
				fundReleaseRegistration.setREQUEST_DATE(date);
				if(requestFundWithdrawProject.getREQUIRED_FUND_AMOUNT() == totalDonatedAmt) {
					fundReleaseRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_FUND_WITHDRAW_STATUS_1);
				}else {
					fundReleaseRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_FUND_WITHDRAW_STATUS_0);
				}
				fundReleaseRegistration.setPROJECT_FEES_ID(currentCategoryId);
				fundReleaseRegistration.setTOTAL_WITHDRAW_AMOUNT(totalDonatedAmt);
				fundReleaseRegistration.setPROCESSING_FEES(processingFees);
				fundReleaseRegistration.setPROJECT_FEES(projectFees);
				fundReleaseRegistration.setPAYMENT_GATEWAY_CHARGES(paymentGateWay);
				FundReleaseRegistrationLocalServiceUtil.addFundReleaseRegistration(fundReleaseRegistration);
				
				ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
				projectRegistration.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2);
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
				
				UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(requestFundWithdrawProject.getUSER_ID());
				 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
				 String mailSubject = "Quick Daan - Withdrawn Fund";
				    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYou have withdrawn " +
				    		totalDonatedAmt +" sucessfully on your "+ requestFundWithdrawProject.getTITLE() +"Quick Daan portal." +"\n\n\nThank You For Visiting Crowd Funding.";

				CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
			}
			
			if(btn.equalsIgnoreCase("stop") == true) {

				long fundReleaseId = 0;
				FundReleaseRegistration fundReleaseRegistration = null;
				
				fundReleaseId = CounterLocalServiceUtil.increment(FundReleaseRegistration.class.getName());
				fundReleaseRegistration = FundReleaseRegistrationLocalServiceUtil.createFundReleaseRegistration(fundReleaseId);
				
				fundReleaseRegistration.setPROJECT_ID(ProjectId);
				fundReleaseRegistration.setCURRENCY("INR");
				fundReleaseRegistration.setREQUEST_DATE(date);
				fundReleaseRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_FUND_WITHDRAW_STATUS_0);
				fundReleaseRegistration.setTOTAL_WITHDRAW_AMOUNT(totalDonatedAmt);
				fundReleaseRegistration.setPROCESSING_FEES(processingFees);
				fundReleaseRegistration.setPROJECT_FEES(projectFees);
				fundReleaseRegistration.setPAYMENT_GATEWAY_CHARGES(paymentGateWay);
				
				FundReleaseRegistrationLocalServiceUtil.addFundReleaseRegistration(fundReleaseRegistration);
				
				requestFundWithdrawProject.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_7);
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(requestFundWithdrawProject);
			}
			
			if(btn.equalsIgnoreCase("delete") == true) {
				requestFundWithdrawProject.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_4);
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(requestFundWithdrawProject);
			}
		} catch (Exception e) {
		}
	}
	
	public void ExtendsCampaignDays(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			String enddate = actionRequest.getParameter("extendEndDate");
			java.util.Date extendEndDate =  sd.parse(enddate);
			Date currentDate = new Date();
			
			long projectId = Long.parseLong(actionRequest.getParameter("projectId"));
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2);
			projectRegistration.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_8);
			
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
			long extentionID = 0;
			ProjectExtentionRegistration projectExtentionRegistration = null;
			
			extentionID = CounterLocalServiceUtil.increment(ProjectExtentionRegistration.class.getName());
			projectExtentionRegistration = ProjectExtentionRegistrationLocalServiceUtil.createProjectExtentionRegistration(extentionID);
			
			projectExtentionRegistration.setPROJECT_ID(projectId);
			projectExtentionRegistration.setDATE(currentDate);
			projectExtentionRegistration.setEXTENTION_DATE(extendEndDate);
			projectExtentionRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_DAYS_EXTENDED_STATUS_0);
			
			ProjectExtentionRegistrationLocalServiceUtil.addProjectExtentionRegistration(projectExtentionRegistration);
			
		} catch (Exception e) {
		}
	}
	
	public void ChangeCategoryDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			long changeCategory = Long.parseLong(actionRequest.getParameter("changeCategory"));
			long projectID = Long.parseLong(actionRequest.getParameter("projectID"));
			ProjectRegistration projectRegistration = null;
			
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
				projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
				List<ProjectFeesRegistration> projectFeesRegistration = ProjectFeesRegistrationLocalServiceUtil.findByPROJECT_ID(projectID);
				if(projectFeesRegistration != null) {
					for(ProjectFeesRegistration feesObj : projectFeesRegistration) {
						if(feesObj.getEND_AMOUNT() == 0) {
							feesObj.setEND_AMOUNT(totalDonatedAmt);
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
				
				DynamicFeesRegistration dynamicFeesRegistration = DynamicFeesRegistrationLocalServiceUtil.findByCATEGORY_ID(changeCategory);
				
				 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(projectRegistration.getUSER_ID());
				 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
				 String mailSubject = "Quick Daan - Change Campaign Category";
				    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYour Category is changed to "+ dynamicFeesRegistration.getCATEGORY_NAME() +"(Processing Fees : "+ 
				    		dynamicFeesRegistration.getPROCESSING_FEES() +"% , Project Fees : "+ dynamicFeesRegistration.getPROJECT_FEES() +"% , Payment Gateway Charges : "+ dynamicFeesRegistration.getPAYMENT_GATEWAY_CHARGES() +"%) for the Campaign " +
				    		projectRegistration.getTITLE() +"" +".\n\n\nThank You For Visiting Quick Daan.";

				CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
			}
			
		} catch (Exception e) {
		}
	}
	
	public void editProjectData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
			
			String description = actionRequest.getParameter("description");
			long projectId = Long.parseLong(actionRequest.getParameter("projectId"));
			
			ProjectRegistration editProjectDetails = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(projectId);
			
			editProjectDetails.setDESCRIPTION(description);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(editProjectDetails);
			
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
			
			ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5);
			projectRegistration.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_10);
			ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistration);
			
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
