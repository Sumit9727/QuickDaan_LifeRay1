<%@ include file="/jsp/init.jsp" %>

<style>

.newsletter{
 border: 1px solid #cecece;
 box-shadow: 0 0 10px 1px #d3d3d3;
 border-style: solid;
 border-color:white;
 margin-top: -4px;
 background-color:white;
 margin:40px; 
 padding: 50px;
 width: 520px;
 margin-left: 25%;
}
.form-control {
    
    border-color: black;
}   
</style>

			<portlet:renderURL var="popupUrl" windowState="normal">
			 	<portlet:param name="jspPage" value="/jsp/NewsLetterDetails.jsp"/>
			  </portlet:renderURL>

<portlet:actionURL name="NewsletterRegistration" var="NewsletterRegistrationURL" />

 <aui:form action="${popupUrl}" method="post" enctype="multipart/form-data">
 
    <div class ="newsletter">
    <CENTER><h2> <label style="font-size: 1.375rem; color: #9c3353;"> POST NEW NEWSLETTER </label></h2></CENTER>
    <br>
    
	<aui:input name="newslettertitle"  label="Title:" placeholder="Enter Title " type="text" 
	style="width: 381px; border-radius: 14px; margin-left: 15%; box-shadow: 0 0 10px 1px #d3d3d3; border-color:black; margin-top:-31px; background-color: white;" >
		<aui:validator name="required"/>
	</aui:input>

	<aui:input name="newsletterdetail" label="Detail:"type="textarea" 
	style="width: 381px; border-radius: 14px; margin-left: 15%; box-shadow: 0 0 10px 1px #d3d3d3; margin-top: -34px; background-color:white ; height:105px; margine-bottom:0px;">
	<aui:validator name="required"/>
	</aui:input>
	<aui:input name="file" label="Attachment" type="file" style="margin-left: 86px; margin-top: -26px;"></aui:input> 
	
	<CENTER>
		<aui:button name="Submit" type="Submit" value="Submit" style="border-style:solid ;background-color:greenyellow" />
		<aui:button type="cancel" value="cancel" onClick="window.history.back();" />
	</CENTER>
	</div>
	
</aui:form>
