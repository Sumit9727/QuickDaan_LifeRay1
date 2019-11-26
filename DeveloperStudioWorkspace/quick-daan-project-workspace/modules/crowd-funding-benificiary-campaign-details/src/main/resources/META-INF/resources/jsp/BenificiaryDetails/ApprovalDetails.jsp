<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.DocumentRegistration"%>
<%@page import="com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys"%>
<%@page import="com.crowd.funding.database.service.UserOTPRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserOTPRegistration"%>
<%@page import="com.crowd.funding.database.service.UserRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.UserRegistration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.BenificiaryRegistrationLocalService"%>
<%@page import="com.crowd.funding.database.model.BenificiaryRegistration"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<liferay-theme:defineObjects />

<portlet:defineObjects />


<style>

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: #474e5d;
  padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
 
/* The Close Button (x) */
.close {
  position: absolute;
  right: 35px;
  top: 15px;
  font-size: 40px;
  font-weight: bold;
  color: #f1f1f1;
}

.close:hover,
.close:focus {
  color: #f44336;
  cursor: pointer;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>


<%
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectObj = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
UserRegistration userRegistration = UserRegistrationLocalServiceUtil.findByUSER_ID(projectObj.getUSER_ID());
UserOTPRegistration otpRegistration = UserOTPRegistrationLocalServiceUtil.findByUSER_OTP_ID(userRegistration.getUSER_OTP_ID());
BenificiaryRegistration benificiaryRegistration = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectObj.getBENIFICIARY_ID());
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
%>

<portlet:actionURL var="adminProjectContentURL" name="adminProjectContent">
	<portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
</portlet:actionURL>

<portlet:actionURL name="RejectDetails" var="RejectDetailsURL" />
<aui:form action="${RejectDetailsURL}" method="post">

<aui:input name="projectID" type="hidden" value="<%= projectObj.getPROJECT_ID() %>"></aui:input>
<aui:input name="commentData" id="commentData" type="hidden" ></aui:input>
	

<div class="ApprovalDetails">
	
	<br>
	
	
	<div class="boxborder"> <strong><u><%= projectObj.getTITLE() %></u></strong></div>
	
		 <div class="boxborder3"><strong>Creation Date :</strong> <%= formatter.format(projectObj.getCREATION_DATE()) %><br>
<strong>End Date :</strong> <%= formatter.format(projectObj.getEND_DATE()) %><br></div>
	
	<br>
	 <div class ="boxborder1">
	 <span class="legend">Project Owner Details</span>
	 <br>
	  <strong>Poject Owner Name :</strong> <%= userRegistration.getFULL_NAME() %>
	  <br><br>
	 <strong>MailID :</strong> <%= otpRegistration.getMAIL()  %><br><br>
	  <strong>Mobile No. :</strong> <%= otpRegistration.getMOBILE_NO() %><br><br>
	</div>
	<br>
	<br>
	 <div class ="boxborder2">
	 <span class="legend1">Benificary Details/Campaign Details</span>
	 <br>
	 <% if(benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
	  <strong style="color:#0077A2;">Benificiary Name :</strong> <%= userRegistration.getFULL_NAME() %><br><br>
	  <% }if(!benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
	   <strong style="color:#0077A2;">Benificiary Name :</strong> <%= benificiaryRegistration.getBENIFICIARY_NAME() %><br><br>
	  <% } %>
	  
	  <% if(benificiaryRegistration.getBENIFICIARY_TYPE().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual) || benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
		 <strong>Age :</strong> <%= benificiaryRegistration.getAGE() %><br><br>
		 <strong>Gender :</strong> <%= benificiaryRegistration.getGENDER() %><br><br>
	 <% } %>

	 <strong style="color:#0077A2;">Benificiary Address :</strong><br> <%= benificiaryRegistration.getADDRESS_LINE1() %>,<%= benificiaryRegistration.getADDRESS_LINE2() %>,<br><%= benificiaryRegistration.getCITY() %>,<%= benificiaryRegistration.getSTATE() %>- <%= benificiaryRegistration.getPINCODE() %>,<br><%= benificiaryRegistration.getCOUNTRY() %><br><br>
	 <strong style="color:#0077A2;">Benificiary Phone No. :</strong> <%= benificiaryRegistration.getCONTACT_NO() %><br><br>
	
	 <strong style="color:#0077A2;">Emergency Contect Details :</strong> <%= benificiaryRegistration.getEMERGENCY_CONTACT_DETAILS() %><br>
	 <strong style="color:#0077A2;">Alternet Contect No. :</strong> <%= benificiaryRegistration.getALTERNATE_CONTACT_NO() %><br>
	 
	 <strong style="color:#0077A2;">Cause Details :</strong> <%= benificiaryRegistration.getCAUSE_DETAILS() %><br><br>
	 <strong style="color:#0077A2;">Benificiary Category :</strong> <%= benificiaryRegistration.getBENIFICIARY_CATEGORY() %><br><br>
	
	<% if(!benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Myself)){ %>
	 <strong style="color:#0077A2;">Benificiary Type :</strong> <%= benificiaryRegistration.getBENIFICIARY_TYPE() %><br><br>
	 <% } %>
	 
	 <% if(benificiaryRegistration.getBENIFICIARY_CATEGORY().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Category_Family) && benificiaryRegistration.getBENIFICIARY_TYPE().equalsIgnoreCase(CrowdFundingBenificiaryDetailsPortletKeys.Benificiary_Type_Individual)){ %>
	 <strong style="color:#0077A2;">Relation :</strong> <%= benificiaryRegistration.getRELATIONSHIP() %>(<%= benificiaryRegistration.getRELATIONSHIP_DETAILS() %>)<br><br>
	 <% } %>
	
	
	
	 
	
	 </div>
	 <br>
	  <div class ="boxborder2">
	   <span class="legend2">Project Details</span>
	   <br>
	 <strong>User Story : </strong><%= projectObj.getDESCRIPTION() %><br><br>

<strong>Document :</strong>
		
	 <%
	  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectObj.getPROJECT_ID());
	  for(DocumentRegistration documentObj : documentList){
	  %>
	  	
		 <portlet:resourceURL  var="ProjectDocumentResourceURL">
			<portlet:param name="serverResourceCall" value="ProjectIDForDocument"/>
			<portlet:param name="ProjectDocumentID" value="<%= String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  %>"/>
		 </portlet:resourceURL>
      <a href="${ProjectDocumentResourceURL}" alt="Document" style="color:black" /><%= documentObj.getDOCUMENT_NAME() %></a>
      <br>
      <br>

  	<% } %>
	
	 <strong>Campaign Fund Amount : </strong><%= String.format("%.0f",projectObj.getREQUIRED_FUND_AMOUNT()) %><br><br>
	 </div>
	 <br>
	 
	<%--  <portlet:renderURL var="popupUrl" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
		 <portlet:param name="projectID" value="<%= String.valueOf(projectObj.getPROJECT_ID()) %>" />
		 <portlet:param name="jspPage" value="/jsp/BenificiaryDetails/commentData.jsp"/>
	</portlet:renderURL> --%>
		
		

		<% if(projectObj.getSTATUS()==1){ %>
			<div><aui:button type="submit" value="Approve" onClick="${adminProjectContentURL}" style="background-color:#0077A2;color:white; border-radius: 100px;width: 100px; "/>
			<!-- <div id="popup_id">
				<b>Reject</b>
			</div> -->
			<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Reject</button>
			
			
			<div id="id01" class="modal">
			  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
			  <form class="modal-content" action="/action_page.php">
			    <div class="container">
			      <h1><%= projectObj.getTITLE() %></h1>
			      <p>Please fill this field for rejecting the Campaign.</p>
			      <hr>
			      <label for="reason"><b>Reason for Rejection :</b></label>
			      <input type="text" placeholder="Enter Reason : " name="<portlet:namespace/>commentData" required>
			
			      <label>
			        <input type="checkbox" checked="checked" name="<portlet:namespace/>noReason" style="margin-bottom:15px"> No Reason
			      </label>
			
			      <div class="clearfix">
			        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
			        <button type="submit" class="signupbtn" >Submit</button>
			      </div>
			    </div>
			  </form>
			</div>
			
			
			<%-- <aui:button type="submit" id="popup_id" value="Reject" style="background-color:#0077A2;color:white; border-radius: 100px;width: 100px; " /> --%>
		<% } %>
		
			<aui:button type="cancel" value="cancel"style="background-color:white;margin-top: 3px; margin-left: 4px;color:#0077A2;border-radius: 100px;width: 100px; "onClick="window.history.back();" /></div>
		</aui:form>
	</div>
 
 
