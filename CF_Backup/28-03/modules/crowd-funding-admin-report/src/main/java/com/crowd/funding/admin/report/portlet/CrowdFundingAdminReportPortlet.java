package com.crowd.funding.admin.report.portlet;

import com.crowd.funding.admin.report.constants.CrowdFundingAdminReportPortletKeys;
import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

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
	
	public void Nirav(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		
		try {
			String selectCause = actionRequest.getParameter("selectCause");
			String selectBeneficieryCategory = actionRequest.getParameter("selectBeneficieryCategory");
			
			String selectStatus = actionRequest.getParameter("selectStatus");
			String campaignStartDate = actionRequest.getParameter("campaignStartDate");
			String selectWithdrawType = actionRequest.getParameter("selectWithdrawType");
			String campaignFromDate = actionRequest.getParameter("campaigFromDate");
			String campaignToDate = actionRequest.getParameter("campaignToDate");
			
			int counter = 2;
			List<BenificiaryRegistration> benificiaryList = null;
			List<ProjectRegistration> projectList = null;
			List<FundReleaseRegistration> fundList = null;
			
			
			if(((selectCause.isEmpty()== false) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== false) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== false) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== false) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== false && campaignToDate.isEmpty()== false) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== false && campaignToDate.isEmpty()== false) && (selectStatus.isEmpty()== true)) || ((selectCause.isEmpty()== true) && (selectBeneficieryCategory.isEmpty()== true) && (campaignStartDate.isEmpty()== true) && (selectWithdrawType.isEmpty()== true) && (campaignFromDate.isEmpty()== true && campaignToDate.isEmpty()== true) && (selectStatus.isEmpty()== false)))
			{
				counter = 0;
			}else {
				counter = 1;
			}
			System.out.println("Counter :::: " + counter);
			if(counter == 0) {
				if(selectStatus.isEmpty() == false){
						if(Integer.parseInt(selectStatus) == 6)
							projectList = ProjectRegistrationLocalServiceUtil.findByREQUEST_STATUS(2);
						else if(Integer.parseInt(selectStatus) == 7)
							projectList = ProjectRegistrationLocalServiceUtil.findByREQUEST_STATUS(3);
						else
							projectList = ProjectRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectStatus));
				}else if(selectCause.isEmpty() == false){
					benificiaryList = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_DETAILS(selectCause);
				}else if(selectBeneficieryCategory.isEmpty() == false){
					benificiaryList = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_CATEGORY(selectBeneficieryCategory);
				}else if(campaignStartDate.isEmpty() == false){
				 	projectList = ProjectRegistrationLocalServiceUtil.findByProjectCreationDate(campaignStartDate);	
				}else if((campaignFromDate.isEmpty() == false) && (campaignToDate.isEmpty() == false)){
				 	projectList = ProjectRegistrationLocalServiceUtil.findProjectBetweenCreationDateQuery(campaignFromDate, campaignToDate);	
				}else if(selectWithdrawType.isEmpty() == false){
					fundList = FundReleaseRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectWithdrawType));
				}
			}else if(counter == 1) {
				
			if(selectCause.isEmpty() == false && selectBeneficieryCategory.isEmpty() == false) {
				 benificiaryList = BenificiaryRegistrationLocalServiceUtil.findByCAUSE_BENIFICIARY_CATEGORY(selectCause, selectBeneficieryCategory);
				 
			}else if(selectCause.isEmpty() == false) {
				 benificiaryList =	BenificiaryRegistrationLocalServiceUtil.findByCAUSE_DETAILS(selectCause);
			}else if(selectBeneficieryCategory.isEmpty() == false) {
				 benificiaryList =	BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_CATEGORY(selectBeneficieryCategory);
			}else if(selectCause.isEmpty() == true && selectBeneficieryCategory.isEmpty() == true){
				System.out.println("Nirav");
				benificiaryList = null;
				
				
			}
			//System.out.println(benificiaryList.size());
			if(benificiaryList != null ) {
			if(selectStatus.isEmpty() == true && campaignStartDate.isEmpty() == true) {
				for(BenificiaryRegistration benificiaryObj : benificiaryList) {
					projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID(benificiaryObj.getBENIFICIARY_ID());
					System.out.println("nirav 4" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					System.out.println(projectList.size());
				}
			}else if(selectStatus.isEmpty() == false && campaignStartDate.isEmpty() == false) {
				for(BenificiaryRegistration benificiaryObj : benificiaryList) {
					projectList = ProjectRegistrationLocalServiceUtil.findprojectByBenificiaryIdStatusCreationDate(benificiaryObj.getBENIFICIARY_ID(), 
							Integer.parseInt(selectStatus), campaignStartDate);
					
					System.out.println("nirav 5" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					System.out.println(projectList.size());
				}
			}else if(selectStatus.isEmpty() == false) {
				for(BenificiaryRegistration benificiaryObj : benificiaryList) {
					projectList = ProjectRegistrationLocalServiceUtil.findByBENIFICIARY_ID_STATUS(benificiaryObj.getBENIFICIARY_ID(), Integer.parseInt(selectStatus));
					
					System.out.println("nirav 6" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					System.out.println(projectList.size());
				}
			}else if(campaignStartDate.isEmpty() == false) {
				for(BenificiaryRegistration benificiaryObj : benificiaryList) {
					projectList = ProjectRegistrationLocalServiceUtil.findprojectByBenificiaryIdCreationDate(benificiaryObj.getBENIFICIARY_ID(), campaignStartDate);
					System.out.println("nirav 7" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					System.out.println(projectList.size());
				}
			}
			}else {
				if(selectStatus.isEmpty() == false && campaignStartDate.isEmpty() == false) {
					//projectList = ProjectRegistrationLocalServiceUtil.fin
					System.out.println("nirav 1" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					if(selectWithdrawType.isEmpty() == false) {
						for(ProjectRegistration projectObj : projectList) {
							fundList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObj.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
							for(FundReleaseRegistration fundObj : fundList) {
								ProjectRegistration list = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
								System.out.println("nirav 10" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate + "," +selectWithdrawType);
								System.out.println(list);
							}
						}
					}
				}else if(selectStatus.isEmpty() == false) {
					projectList = ProjectRegistrationLocalServiceUtil.findBySTATUS(Integer.parseInt(selectStatus));
					System.out.println("nirav 2" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					System.out.println(projectList.size());
					if(selectWithdrawType.isEmpty() == false) {
						System.out.println("nirav 12" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate + "," +selectWithdrawType);
						for(ProjectRegistration projectObj : projectList) {
							System.out.println("nirav113::::" +projectObj.getPROJECT_ID());
							fundList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObj.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
							System.out.println("nirav112::::" +fundList.size());
							for(FundReleaseRegistration fundObj : fundList) {
								System.out.println("nirav111::::" +fundObj.getFUND_RELEASE_ID());
								ProjectRegistration list = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
								System.out.println("nirav 9" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate + "," +selectWithdrawType);
								System.out.println(list);
							}
						}
					}
				}else if(campaignStartDate.isEmpty() == false) {
					projectList = ProjectRegistrationLocalServiceUtil.findByProjectCreationDate(campaignStartDate);
					System.out.println("nirav 3" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate);
					System.out.println(projectList.size());
					if(selectWithdrawType.isEmpty() == false) {
						for(ProjectRegistration projectObj : projectList) {
							fundList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObj.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
							for(FundReleaseRegistration fundObj : fundList) {
								ProjectRegistration list = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
								System.out.println("nirav 11" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate + "," +selectWithdrawType);
								System.out.println(list);
							}
						}
					}
				}else
					System.out.println("List is empty");
			}
			if(projectList!= null) {
			if(selectWithdrawType.isEmpty() == false) {
				for(ProjectRegistration projectObj : projectList) {
					fundList = FundReleaseRegistrationLocalServiceUtil.findByPROJECT_ID_STATUS(projectObj.getPROJECT_ID(), Integer.parseInt(selectWithdrawType));
					for(FundReleaseRegistration fundObj : fundList) {
						ProjectRegistration list = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(fundObj.getPROJECT_ID());
						System.out.println("nirav 8" + selectCause + "," +selectBeneficieryCategory + "," + selectStatus +  "," +campaignStartDate + "," +selectWithdrawType);
						System.out.println(list);
					}
				}
			}
			
			}
		}else{
			projectList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0, CounterLocalServiceUtil.getCountersCount());
		} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}