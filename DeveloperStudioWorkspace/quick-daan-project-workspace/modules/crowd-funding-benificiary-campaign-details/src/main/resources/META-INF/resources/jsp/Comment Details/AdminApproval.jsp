<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.ProjectRegistration"%>
<%@page import="com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CommentRegistration"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
  
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

<style>
.portlet-decorate .portlet-content{
    background-color: #f7f8f9;
    border: 1px solid #f1f2f5;
}
 .mayborderForm{
    
    background-color: #FFF;
    border: 1px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 45px;
    border: 1px solid #7FBD2C;
    border-top: 3px solid #7fbd2c;
    border-right: 3px solid #7FBD2C;
    box-shadow: 0 0 10px 1px #7FBD2C;
}

</style>

<%
List<CommentRegistration> commentList = CommentRegistrationLocalServiceUtil.getCommentRegistrations(0, CommentRegistrationLocalServiceUtil.getCommentRegistrationsCount());

int counter = 1;
%>
<form class="mayborderForm">
	<table id="example" class="display" style="width:100%">
		<thead>
			<tr>
				<th>Comment No.</th>
				<th>Comment</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(CommentRegistration commentObj : commentList){
			%>
				<portlet:renderURL var="answerData" windowState="normal" >
					<portlet:param name="commentID" value="<%= String.valueOf(commentObj.getPROJECT_COMMENT_ID()) %>" />
					<portlet:param name="jspPage" value="/jsp/Comment Details/CommentAnswer.jsp" />
				</portlet:renderURL>
				
				<tr>
					<td><%= counter %></td>
					<td><%= commentObj.getCOMMENT() %></td>
					<td>
						<%if(commentObj.getSTATUS()==0){%>
							<aui:button type="Details" value="Details" onClick="${answerData}"/>
						<% }if(commentObj.getSTATUS()==1){} %>
					</td>
				</tr>
			<%
			counter++;
			}
			%>
		</tbody>
	</table>
</form>