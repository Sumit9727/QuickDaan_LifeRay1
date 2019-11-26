<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.PositionRegistration"%>
<%@ include file="/jsp/currentcarrier/init.jsp" %>
<%@page import="java.util.List"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#inactivetable').DataTable();
} );
</script>

<%
List<PositionRegistration> positionlist = null;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
positionlist = PositionRegistrationLocalServiceUtil.findBySTATUS(0);
%>
<table id="inactivetable" class="display" style="width:100%">
		<thead>
			<tr>
				<th>POSITION_ID</th>
				<th>POSITION_NAME</th>
				<th>DATE</th>
				<th>LOCATION</th>
				<th>Action</th>
			</tr>
		</thead>
			<tbody>
			<%   
			for(PositionRegistration PositionObj : positionlist ) {
			%>
			<tr>
			<portlet:renderURL var="PositionRegistrationUrl" windowState="normal">
				<portlet:param name="PositionId" value="<%= String.valueOf(PositionObj.getPOSITION_ID()) %>" />
			 	<portlet:param name="jspPage" value="/jsp/currentcarrier/InActivePostDetailPage.jsp"/>
			  </portlet:renderURL>
			  <portlet:actionURL name="changeInActiveToActive" var="changeInActiveToActiveURL">
					<portlet:param name="PositionId" value="<%= String.valueOf(PositionObj.getPOSITION_ID()) %>" />
				</portlet:actionURL>
				<td><%= PositionObj.getPOSITION_ID() %></td>
				 <td><%= PositionObj.getPOSITION_NAME()%></td>
				 <td><%= formatter.format(PositionObj.getDATE()) %></td>
				 <td><%= PositionObj.getLOCATION() %></td>
				 <td><!-- <aui:button name="submit" onClick="${PositionRegistrationUrl}" value="Details" /> -->
				 <liferay-ui:icon-menu>
					 	<liferay-ui:icon image="view" message="Details" url="${PositionRegistrationUrl}" />
						 		
								<liferay-ui:icon image="edit" message="Inactive Job" url="${changeInActiveToActiveURL}"/>
					 	
				    </liferay-ui:icon-menu>
				 
				 </td>
				 </tr>
			<%
			}
			%>
	</tbody>
</table>