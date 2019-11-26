package com.crowd.funding.module.controller.constants;

import com.crowd.funding.database.model.ProjectRegistration;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component
public class QuartzSchedulerController extends BaseSchedulerEntryMessageListener {

	 private SchedulerEngineHelper _schedulerEngineHelper;
	 
	 @Reference(unbind="-")
	 public void setschedulerEngineHelper(SchedulerEngineHelper _schedulerEngineHelper) {
		 this._schedulerEngineHelper = _schedulerEngineHelper;
	 }
	 
	 
	 @Override
	 protected void doReceive(Message message) throws Exception {
	 // TODO Auto-generated method stub
		 List<ProjectRegistration> projectRegistrationList = ProjectRegistrationLocalServiceUtil.getProjectRegistrations(0, ProjectRegistrationLocalServiceUtil.getProjectRegistrationsCount());
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 Date currentDate = new Date(); 
		 for(ProjectRegistration projectRegistrationObj : projectRegistrationList ) {
			 int daysLeft = formatter.format(projectRegistrationObj.getEND_DATE()).compareTo(formatter.format(currentDate));
			 if(daysLeft <= 0) {
				 System.out.println("projectRegistration ID ::: "+projectRegistrationObj.getPROJECT_ID()); 
				System.out.println("Compaire Date    :::::  "+daysLeft);
				projectRegistrationObj.setREQUEST_STATUS(CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_5);
				ProjectRegistrationLocalServiceUtil.updateProjectRegistration(projectRegistrationObj);
				System.out.println("Status Change for date.");
				System.out.println("");
			 }
		 }
		
	 }
	 
	 @Activate
	 @Modified
	 protected void activate() {
		 schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(), 24, TimeUnit.HOUR)); //time interval for trigger
		 _schedulerEngineHelper.register(this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	 }

}