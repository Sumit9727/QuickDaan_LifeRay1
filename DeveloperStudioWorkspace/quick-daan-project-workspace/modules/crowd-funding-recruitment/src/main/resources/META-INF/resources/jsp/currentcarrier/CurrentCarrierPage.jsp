<%@ include file="/jsp/currentcarrier/init.jsp" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:renderURL var="NewPostFormURL" windowState="normal">
	<portlet:param name="jspPage" value="/jsp/currentcarrier/NewPostForm.jsp"/>
</portlet:renderURL>

<aui:button name="submit" onClick="${NewPostFormURL}" value="Add New Post" />


<liferay-ui:tabs names="Active Posts , InActive Posts" refresh="false" tabsValues="Active Posts , InActive Posts">
    
    <liferay-ui:section>
         <%@ include file="/jsp/currentcarrier/ActivePostPage.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
         <%@ include file="/jsp/currentcarrier/InActivePostPage.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>

