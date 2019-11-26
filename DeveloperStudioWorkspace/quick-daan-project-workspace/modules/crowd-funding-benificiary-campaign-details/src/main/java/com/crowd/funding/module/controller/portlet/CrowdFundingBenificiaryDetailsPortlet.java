package com.crowd.funding.module.controller.portlet;

import com.crowd.funding.database.exception.NoSuchBenificiaryRegistrationException;
import com.crowd.funding.database.exception.NoSuchUserRegistrationException;
import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.model.DynamicFeesRegistration;
import com.crowd.funding.database.model.ProjectFeesRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.model.UserOTPRegistration;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.DynamicFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectFeesRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.module.controller.constants.CrowdFundingMail;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Prakat-D-008
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CrowdFundingDetails",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Fundraiser",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.header-portlet-css=/CSS/main.css",
		"javax.portlet.init-param.view-template=/jsp/BenificiaryDetails/BenificiaryCategory.jsp",
		"javax.portlet.name=Fundraiser",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrowdFundingBenificiaryDetailsPortlet extends MVCPortlet {
	
	public void BenificiaryRelationMyself(ActionRequest actionRequest, ActionResponse actionResponse)
			 {
		try {
		ThemeDisplay td  =(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UserRegistration userData = UserRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
		UserOTPRegistration userOtpObj = UserOTPRegistrationLocalServiceUtil.fetchUserOTPRegistration(userData.getUSER_OTP_ID());
		
		String ageYear = actionRequest.getParameter("ageYear");
		String ageMonth = actionRequest.getParameter("ageMonth");
		String location = actionRequest.getParameter("location");
		String name = actionRequest.getParameter("name");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setBENIFICIARY_NAME(name);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		if(ageMonth.isEmpty() != true) {
			ageMonth = ageMonth + "Month";
			benificiaryRegistration.setAGE(ageMonth);
		}if(ageYear.isEmpty() != true) {
			ageYear = ageYear+"Year";
			benificiaryRegistration.setAGE(ageYear);
		}
	//	benificiaryRegistration.setAGE(age);
		benificiaryRegistration.setGENDER(userData.getGENDER());
		benificiaryRegistration.setCONTACT_NAME(userData.getFULL_NAME());
		benificiaryRegistration.setCONTACT_NO(userOtpObj.getMOBILE_NO());
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
	                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BenificiaryRelationGroup(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		String Group = actionRequest.getParameter("Group");
		
		String groupName = actionRequest.getParameter("groupName");
		int member = Integer.parseInt(actionRequest.getParameter("member"));
		String location = actionRequest.getParameter("location");
		String name = actionRequest.getParameter("name");
		long number = Long.parseLong(actionRequest.getParameter("number"));

		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		if(Group.equalsIgnoreCase("FriendGroup")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Friend);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Group);
			
		}else if(Group.equalsIgnoreCase("OtherGroup")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Other);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Group);
			
		}if(Group.equalsIgnoreCase("FamilyGroup")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Family);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Group);
			
		}
		benificiaryRegistration.setBENIFICIARY_NAME(groupName);
		benificiaryRegistration.setMEMBERS_NO(member);
		benificiaryRegistration.setCONTACT_NAME(name);
		benificiaryRegistration.setCONTACT_NO(number);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
	                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void BenificiaryRelationIndividual(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		String Individual = actionRequest.getParameter("Individual");
		
		String ageYear = actionRequest.getParameter("ageYear");
		String ageMonth = actionRequest.getParameter("ageMonth");
		
		String Gender = actionRequest.getParameter("Gender");
		String location = actionRequest.getParameter("location");
		String name = actionRequest.getParameter("name");
		long number = Long.parseLong(actionRequest.getParameter("number"));

		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		if(Individual.equalsIgnoreCase("FriendIndividual")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Friend);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual);
			
		}else if(Individual.equalsIgnoreCase("OtherIndividual")){
			
			benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Other);
			benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual);
			
		}
		
		if(ageMonth.isEmpty() == true) {
			benificiaryRegistration.setAGE(ageYear+" Year");
		}if(ageYear.isEmpty() == true) {
			benificiaryRegistration.setAGE(ageMonth+" Month");
		}
		//benificiaryRegistration.setAGE(age);
		benificiaryRegistration.setGENDER(Gender);
		benificiaryRegistration.setBENIFICIARY_NAME(name);
		benificiaryRegistration.setCONTACT_NO(number);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
	                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void BenificiaryRelationIndividualFamily(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("image");
		OutputBlob outputBlobDocuments=null;
		InputStream inputStream = new FileInputStream(file);
		outputBlobDocuments = new OutputBlob(inputStream, file.length());
		
		String location = actionRequest.getParameter("location");
		String Relationship = actionRequest.getParameter("Relationship");
		String RelationshipDetails = actionRequest.getParameter("RelationshipDetails");
		String ageYear = actionRequest.getParameter("ageYear");
		String ageMonth = actionRequest.getParameter("ageMonth");
		
		String Gender = actionRequest.getParameter("Gender");
		String name = actionRequest.getParameter("name");
		String contectName = actionRequest.getParameter("contectName");
		long number = Long.parseLong(actionRequest.getParameter("number"));
		
		BenificiaryRegistration benificiaryRegistration = null;
		long b_id = 0;
		
		b_id = CounterLocalServiceUtil.increment(BenificiaryRegistration.class.getName());
		benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.createBenificiaryRegistration(b_id);
		
		benificiaryRegistration.setBENIFICIARY_CATEGORY(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Family);
		benificiaryRegistration.setBENIFICIARY_TYPE(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual);
		if(ageMonth.isEmpty() == true) {
			benificiaryRegistration.setAGE(ageYear+" Year");
		}if(ageYear.isEmpty() == true) {
			benificiaryRegistration.setAGE(ageMonth+" Month");
		}
		//benificiaryRegistration.setAGE(age);
		benificiaryRegistration.setRELATIONSHIP(Relationship);
		benificiaryRegistration.setRELATIONSHIP_DETAILS(RelationshipDetails);
		benificiaryRegistration.setGENDER(Gender);
		benificiaryRegistration.setBENIFICIARY_NAME(name);
		benificiaryRegistration.setCONTACT_NAME(contectName);
		benificiaryRegistration.setCONTACT_NO(number);
		benificiaryRegistration.setLOCATION(location);
		benificiaryRegistration.setIMAGE(outputBlobDocuments);
		benificiaryRegistration.setIMAGE_TYPE(MimeTypesUtil.getContentType(file));
		
		BenificiaryRegistrationLocalServiceUtil.addBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/CauseDetails.jsp");
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
	                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void causeData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		try {
		long benificiaryID = Long.parseLong(actionRequest.getParameter("benificiaryID"));
		String btn = actionRequest.getParameter("btn");
		
		BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryID);
		
		benificiaryRegistration.setCAUSE_DETAILS(btn);
		
		BenificiaryRegistrationLocalServiceUtil.updateBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/BenificiaryDetails.jsp");
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
	                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void BenificiaryDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NoSuchBenificiaryRegistrationException {
		
		String addressline1 = actionRequest.getParameter("addressline1");
		String addressline2 = actionRequest.getParameter("addressline2");
		String Country = actionRequest.getParameter("Country");
		String state = actionRequest.getParameter("state");
		String city = actionRequest.getParameter("city");
		String emergencyContact = actionRequest.getParameter("emergencyContact");
		int pincode = Integer.parseInt(actionRequest.getParameter("pincode"));
		long emergencyContactNumber = Long.parseLong(actionRequest.getParameter("emergencyContactNumber"));
		long benificiaryID = Long.parseLong(actionRequest.getParameter("benificiaryID"));
		
		BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryID);
		
		benificiaryRegistration.setADDRESS_LINE1(addressline1);
		benificiaryRegistration.setADDRESS_LINE2(addressline2);
		benificiaryRegistration.setCOUNTRY(Country);
		benificiaryRegistration.setSTATE(state);
		benificiaryRegistration.setCITY(city);
		benificiaryRegistration.setPINCODE(pincode);
		benificiaryRegistration.setEMERGENCY_CONTACT_DETAILS(emergencyContact);
		benificiaryRegistration.setALTERNATE_CONTACT_NO(emergencyContactNumber);
		
		BenificiaryRegistrationLocalServiceUtil.updateBenificiaryRegistration(benificiaryRegistration);
		
		actionResponse.setRenderParameter("benificiaryID", String.valueOf(benificiaryRegistration.getBENIFICIARY_ID()));
		actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/ProjectRegistration.jsp");
		
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
	    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
	                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
	}
	
	public void ProjectRegistrationDetails(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		try {
			
			
			long userID = Long.parseLong(actionRequest.getParameter("userID"));
			long benificiaryID = Long.parseLong(actionRequest.getParameter("benificiaryID"));
			String title = actionRequest.getParameter("title");
			String description = actionRequest.getParameter("description");
			String requiredFundAmt = actionRequest.getParameter("requiredFundAmt");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			String enddate = actionRequest.getParameter("enddate");
			java.util.Date closeDate =  sd.parse(enddate);
		    Date date = new Date();
			
			/*------------------------------------------------- Project Registration --------------------------------------------------------------------------------------*/
			
	       
		        
			ProjectRegistration projectRegistration = null;
			long projectID = 0;
			
			projectID = CounterLocalServiceUtil.increment(ProjectRegistration.class.getName());
			projectRegistration = ProjectRegistrationLocalServiceUtil.createProjectRegistration(projectID);
			
			projectRegistration.setUSER_ID(userID);
			projectRegistration.setBENIFICIARY_ID(benificiaryID);
			projectRegistration.setTITLE(title);
			projectRegistration.setDESCRIPTION(description);
			
			UploadPortletRequest uploadRequestVideo = PortalUtil.getUploadPortletRequest(actionRequest);
			File videoFile = uploadRequestVideo.getFile("videoFile");
			if(videoFile.exists() == true) {
				OutputBlob outputBlobVideo=null;
				InputStream videoInputStream = new FileInputStream(videoFile);
				outputBlobVideo = new OutputBlob(videoInputStream, videoFile.length());    
					
				projectRegistration.setVIDEO(outputBlobVideo);
				projectRegistration.setVIDEO_TYPE(MimeTypesUtil.getContentType(videoFile));
			}
			
			projectRegistration.setREQUIRED_FUND_AMOUNT(Long.parseLong(requiredFundAmt));
			projectRegistration.setCREATION_DATE(date);
			projectRegistration.setEND_DATE(closeDate);
			projectRegistration.setSTATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0);
			projectRegistration.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0);
			
			ProjectRegistrationLocalServiceUtil.addProjectRegistration(projectRegistration);
			
			String documentRowlevelIndexes = actionRequest.getParameter("documentIndex");
	        String[] indexOfRowsDocument = documentRowlevelIndexes.split(",");
	        
			UploadPortletRequest uploadRequestDocument = PortalUtil.getUploadPortletRequest(actionRequest);
			File documentFile;
			OutputBlob outputBlobDocuments=null;
			InputStream inputStreamDocument;
			DocumentRegistration documentRegistration = null;
			long document_id=0;
			String documentName;
			
			 for(int i=0;i<indexOfRowsDocument.length;i++){
				 	documentName = actionRequest.getParameter("documentName"+indexOfRowsDocument[i].trim());
		        	documentFile = uploadRequestDocument.getFile("documentFile"+indexOfRowsDocument[i].trim());
		        	if(documentFile.exists()==true){
		        		inputStreamDocument = new FileInputStream(documentFile);
		        		outputBlobDocuments = new OutputBlob(inputStreamDocument, documentFile.length());
			    		
		        		document_id=CounterLocalServiceUtil.increment(DocumentRegistration.class.getName());
			    		documentRegistration=DocumentRegistrationLocalServiceUtil.createDocumentRegistration(document_id);
			    		
			    		documentRegistration.setPROJECT_ID(projectRegistration.getPROJECT_ID());
			    		documentRegistration.setDOCUMENT(outputBlobDocuments);
			    		documentRegistration.setDOCUMENT_TYPE(MimeTypesUtil.getContentType(documentFile));
			    		documentRegistration.setDOCUMENT_NAME(documentName);
			    		
			    		DocumentRegistrationLocalServiceUtil.addDocumentRegistration(documentRegistration);
		        	} 
		        }
			 		
			 ProjectFeesRegistration feesRegistration = null;
			 long projectFeesID = 0;
			 
			 projectFeesID = CounterLocalServiceUtil.increment(ProjectFeesRegistration.class.getName());
			 feesRegistration = ProjectFeesRegistrationLocalServiceUtil.createProjectFeesRegistration(projectFeesID);
			 
			 DynamicFeesRegistration dynamicFeesCategoryObj = DynamicFeesRegistrationLocalServiceUtil.getDynamicFeesRegistration(CrowdFundingBenificiaryDetailsPortletKeys.PROJECT_DYNAMIC_FEES_NORMAL_CATEGORY_1);
			 feesRegistration.setCATEGORY_ID(dynamicFeesCategoryObj.getCATEGORY_ID());
			 feesRegistration.setPROJECT_ID(projectID);
			 feesRegistration.setSTART_AMOUNT(CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_START_AMOUNT_0);
			 feesRegistration.setWITHDRAW_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.DEFAULT_PROJECT_FEES_WITHDRAW_STATUS_0);
			 feesRegistration.setDATE(date);
			 
			 ProjectFeesRegistrationLocalServiceUtil.addProjectFeesRegistration(feesRegistration);
			 
			 UserRegistration userDetailsObj = UserRegistrationLocalServiceUtil.findByUSER_ID(userID);
			 UserOTPRegistration userOtpDetailsObj = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userDetailsObj.getUSER_OTP_ID());
			 String mailSubject = "Quick Daan - Campaign Registaration";
			    String mailBody = "Dear " + userDetailsObj.getFULL_NAME() + ", \n\nYour campaign for " +
			    		title +" sucessfully registered on Quick Daan portal." +"\n\nWe will review your campaign details and once approve from admin will notify you." +"\n\n\nThank You For Visiting Quick Daan.";

			CrowdFundingMail.sendMail(mailSubject, mailBody, userOtpDetailsObj.getMAIL());
			
			
			actionResponse.setRenderParameter("projectID", String.valueOf(projectRegistration.getPROJECT_ID()));
			actionResponse.setRenderParameter("jspPage", "/jsp/BenificiaryDetails/ProjectSucessfully.jsp");
			
			PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		    LiferayPortletConfig liferayPortletConfig = (LiferayPortletConfig) portletConfig;
		    SessionMessages.add(actionRequest, liferayPortletConfig.getPortletId()
		                    + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}