<%@page import="java.util.List"%>
<%@page
	import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page
	import="com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil"%>
<%@page import="com.crowd.funding.database.model.CategoryRegistration"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<style>
.full{
	background-color: #0077A2;
}

.portlet-content {
    background-color: #0077A2;
    border: -28px solid #E7E7ED;
    border-radius: 0.5rem;
    padding: 24px;
}
.btn-primary.btn-default {
    color: #FFF;
    background-color: #7FBD2C;
    border-color: #0B5FFF;
    box-shadow: none;
}
.{
background-color
:red
;


background-image
:linear-gradient



(
to



right
,
#7FBD2C
,
#0077A2



}
</style>
<div class="full">

	<center>
		<div class="every">
			<p>
				<%-- <b><liferay-ui:message key="myloginportlet_MyLogin.caption"/></b> --%>
				<b style="font-size: 30px; color: white;"><liferay-ui:message
						key="Log In" /></b>
			</p>
			<img src="/portal_content/loginUser.png" alt="Avatar"
				style="vertical-align: middle; width: 150px; height: 150px; border-radius: 50%;" />
			<c:choose>
				<c:when test="<%=themeDisplay.isSignedIn()%>">

					<%
						String signedInAs = HtmlUtil.escape(user.getFullName());

								if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
									String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

									signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">"
											+ signedInAs + "</a>";
								}
					%>

					<liferay-ui:message arguments="<%=signedInAs%>"
						key="you-are-signed-in-as-x" translateArguments="<%=false%>" />
				</c:when>
				<c:otherwise>

					<%
						String redirect = ParamUtil.getString(request, "redirect");
					%>

					<portlet:actionURL name="/login/login" var="loginURL">
						<portlet:param name="mvcRenderCommandName" value="/login/login" />
					</portlet:actionURL>

					<aui:form action="<%=loginURL%>" autocomplete='on'
						cssClass="sign-in-form" method="post" name="loginForm">

						<aui:input name="saveLastPath" type="hidden" value="<%=false%>" />
						<aui:input name="redirect" type="hidden" value="<%=redirect%>" />

						<aui:input autoFocus="true" cssClass="clearable" label=""
							placeholder="Enter Username" name="login" type="text" value=""
							style="width: 23%;">
							<aui:validator name="required" />
						</aui:input>

						<aui:input name="password" label="" placeholder="Enter password"
							type="password" style="width: 23%;">
							<aui:validator name="required" />
						</aui:input>

						<a
							href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fforgot_password"
							class="forgot-link" style="color: white;">Forgot your
							password?</a>
						<!-- <a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="forgot-link" style=" color: #337ab7;">Create Account</a> -->
						<a href="/web/customelogin/registration" class="forgot-link"
							style="color: white;">Create Account</a>
						<aui:button-row>
							<aui:button cssClass="btn-lg" type="submit" value="Log-in" />
						</aui:button-row>

					</aui:form>
				</c:otherwise>
			</c:choose>
		</div>
	</center>
</div>
