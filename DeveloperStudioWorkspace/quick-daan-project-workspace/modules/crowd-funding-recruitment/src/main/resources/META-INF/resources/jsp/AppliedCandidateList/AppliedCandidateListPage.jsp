<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.service.CandidateRegistrationLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.model.CandidateRegistration"%>
<%@ include file="/jsp/AppliedCandidateList/init.jsp" %>
<%@page import="java.util.List"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#activetable').DataTable();
} );
</script>
<portlet:defineObjects />

<%
int counter = 1;
List<CandidateRegistration> candidatelist = null;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
candidatelist = CandidateRegistrationLocalServiceUtil.getCandidateRegistrations(0, CounterLocalServiceUtil.getCountersCount());
%>
<table id="activetable" class="display" style="width:100%">
		<thead>
			<tr>
				<th>CANDIDATE NUMBER</th>
				<th>POSITION_NAME</th>
				<th>CANDIDATE NAME</th>
				<th>DATE OF APPLIED</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			<%   
			for(CandidateRegistration candidateRegistrationObj : candidatelist ) {
				PositionRegistration positionObj = PositionRegistrationLocalServiceUtil.findByPOSITION_ID(candidateRegistrationObj.getPOSITION_ID());
				
			%>
			<tr>
			<portlet:renderURL var="PositionRegistrationUrl" windowState="normal">
				<portlet:param name="CandidateId" value="<%= String.valueOf(candidateRegistrationObj.getCANDIDATE_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/AppliedCandidateList/CandidateDetailsPage.jsp"/>
			  </portlet:renderURL>
			  <td><%= counter %></td>
				<td><%= positionObj.getPOSITION_NAME() %></td>
				 <td><%= candidateRegistrationObj.getNAME() %></td>
				 <td><%= formatter.format(candidateRegistrationObj.getDATE()) %></td>
				 <td> <aui:button name="submit" onClick="${PositionRegistrationUrl}" value="Details" /> </td>
				 </tr>
			<%
			}
			%>
	</tbody>
</table>