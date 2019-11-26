<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@ include file="/jsp/candidate/init.jsp" %>
<%@page import="java.util.List"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
Current Openings
<liferay-theme:defineObjects />

<portlet:defineObjects />
<style>
 .float-left{
  float: left;
  width: 300px;
  height: 300px;
  margin: 10px;
 
 }
 .portlet-decorate .portlet-content {
   height: 710px;  
  
}
a {
    color: #0B5FFF;
    }
 .d{
    margin-left: 21px;
     font-size: 14px;
     }
    
   i.custom {
         
         color: black;
         }
</style>

<%
List<PositionRegistration> positionlist = PositionRegistrationLocalServiceUtil.getPositionRegistrations(0, CounterLocalServiceUtil.getCountersCount());

for(PositionRegistration positionObj : positionlist){
	%>
	<portlet:renderURL var="PositionRegistrationUrl" windowState="normal">
				<portlet:param name="PositionId" value="<%= String.valueOf(positionObj.getPOSITION_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/candidate/CurrentProjectFullDetails.jsp"/>
			  </portlet:renderURL>
	<div class="a">
						<div class="float-left">
                   
						<div class ="e">
						
						<div  style="  box-shadow: 0 0 10px 1px #d3d3d3; border: 1px solid #cecece; border-style: solid; display: inline-block;">
							<div><center><B><%= positionObj.getPOSITION_NAME() %></B></center>
							</div>
							<hr>
							<div>
							<i class='fas fa-briefcase custom'></i> <%= positionObj.getEXPERIENCE_LEVEL() %> years<br>
							<i class="fa fa-inr custom"></i> <%= positionObj.getSALARY() %> Per annual<br>
							<i class="fa fa-map-marker custom"></i> <%= positionObj.getLOCATION() %><br>
							</div>
					        <div>
							 Job Description: <br><%= positionObj.getDESCRIPTION() %> 
							</div>
							<hr>
							<div style="float:right;"><aui:button name="submit" onClick="${PositionRegistrationUrl}" value="Read More" />
							</div>
							
						</div>
						</div>
						</div>
					</div>
	<%
}
%>