package org.apache.jsp.jsp.Campaign_0020Details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.CategoryRegistration;
import java.util.stream.Collectors;
import java.util.Collection;
import com.crowd.funding.database.service.DonorRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.DonorRegistration;
import com.crowd.funding.database.service.ProjectFollowerRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ProjectFollowerRegistration;
import com.crowd.funding.database.service.ProjectUpdateRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ProjectUpdateRegistration;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.crowd.funding.database.service.CommentRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.FundAccountRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.CommentRegistration;
import com.crowd.funding.database.model.FundAccountRegistration;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.FundRegistration;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.crowd.funding.database.service.BenificiaryRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.BenificiaryRegistration;
import com.crowd.funding.database.service.DocumentRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.DocumentRegistration;
import com.crowd.funding.database.service.ImageRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ImageRegistration;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.UserRegistration;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalServiceUtil;
import com.crowd.funding.database.service.ProjectPriorityRegistrationLocalService;
import com.crowd.funding.database.model.ProjectPriorityRegistration;
import java.util.Collections;
import com.liferay.portal.kernel.util.ListUtil;
import java.util.List;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ProjectRegistration;

public final class CampaignDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_namespace_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_onClick_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_name_label_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_renderURL_windowState_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_method_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_resourceURL_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_actionURL_var_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_namespace_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_onClick_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_name_label_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_renderURL_windowState_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_form_method_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_resourceURL_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_actionURL_var_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_actionURL_var_name.release();
    _jspx_tagPool_portlet_namespace_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_label_nobody.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_aui_button_value_type_onClick_nobody.release();
    _jspx_tagPool_aui_input_name_label_nobody.release();
    _jspx_tagPool_portlet_renderURL_windowState_var.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_aui_button_value_type_name_nobody.release();
    _jspx_tagPool_aui_form_method_action.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_portlet_resourceURL_var.release();
    _jspx_tagPool_portlet_actionURL_var_name_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_0 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay$1theme_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_0 = _jspx_th_liferay$1theme_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
      com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay = null;
      com.liferay.portal.kernel.model.Company company = null;
      com.liferay.portal.kernel.model.Account account = null;
      com.liferay.portal.kernel.model.User user = null;
      com.liferay.portal.kernel.model.User realUser = null;
      com.liferay.portal.kernel.model.Contact contact = null;
      com.liferay.portal.kernel.model.Layout layout = null;
      java.util.List layouts = null;
      java.lang.Long plid = null;
      com.liferay.portal.kernel.model.LayoutTypePortlet layoutTypePortlet = null;
      java.lang.Long scopeGroupId = null;
      com.liferay.portal.kernel.security.permission.PermissionChecker permissionChecker = null;
      java.util.Locale locale = null;
      java.util.TimeZone timeZone = null;
      com.liferay.portal.kernel.model.Theme theme = null;
      com.liferay.portal.kernel.model.ColorScheme colorScheme = null;
      com.liferay.portal.kernel.theme.PortletDisplay portletDisplay = null;
      java.lang.Long portletGroupId = null;
      themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.kernel.model.Company) _jspx_page_context.findAttribute("company");
      account = (com.liferay.portal.kernel.model.Account) _jspx_page_context.findAttribute("account");
      user = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.kernel.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.kernel.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.kernel.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.kernel.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.kernel.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.kernel.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.kernel.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write("\r\n");
      out.write("\r\n");
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_0 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_defineObjects_0.setParent(null);
      int _jspx_eval_portlet_defineObjects_0 = _jspx_th_portlet_defineObjects_0.doStartTag();
      if (_jspx_th_portlet_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
        return;
      }
      _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
      javax.portlet.ActionRequest actionRequest = null;
      javax.portlet.ActionResponse actionResponse = null;
      javax.portlet.EventRequest eventRequest = null;
      javax.portlet.EventResponse eventResponse = null;
      com.liferay.portal.kernel.portlet.LiferayPortletRequest liferayPortletRequest = null;
      com.liferay.portal.kernel.portlet.LiferayPortletResponse liferayPortletResponse = null;
      javax.portlet.PortletConfig portletConfig = null;
      java.lang.String portletName = null;
      javax.portlet.PortletPreferences portletPreferences = null;
      java.util.Map portletPreferencesValues = null;
      javax.portlet.PortletSession portletSession = null;
      java.util.Map portletSessionScope = null;
      javax.portlet.RenderRequest renderRequest = null;
      javax.portlet.RenderResponse renderResponse = null;
      javax.portlet.ResourceRequest resourceRequest = null;
      javax.portlet.ResourceResponse resourceResponse = null;
      actionRequest = (javax.portlet.ActionRequest) _jspx_page_context.findAttribute("actionRequest");
      actionResponse = (javax.portlet.ActionResponse) _jspx_page_context.findAttribute("actionResponse");
      eventRequest = (javax.portlet.EventRequest) _jspx_page_context.findAttribute("eventRequest");
      eventResponse = (javax.portlet.EventResponse) _jspx_page_context.findAttribute("eventResponse");
      liferayPortletRequest = (com.liferay.portal.kernel.portlet.LiferayPortletRequest) _jspx_page_context.findAttribute("liferayPortletRequest");
      liferayPortletResponse = (com.liferay.portal.kernel.portlet.LiferayPortletResponse) _jspx_page_context.findAttribute("liferayPortletResponse");
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      portletName = (java.lang.String) _jspx_page_context.findAttribute("portletName");
      portletPreferences = (javax.portlet.PortletPreferences) _jspx_page_context.findAttribute("portletPreferences");
      portletPreferencesValues = (java.util.Map) _jspx_page_context.findAttribute("portletPreferencesValues");
      portletSession = (javax.portlet.PortletSession) _jspx_page_context.findAttribute("portletSession");
      portletSessionScope = (java.util.Map) _jspx_page_context.findAttribute("portletSessionScope");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
      resourceRequest = (javax.portlet.ResourceRequest) _jspx_page_context.findAttribute("resourceRequest");
      resourceResponse = (javax.portlet.ResourceResponse) _jspx_page_context.findAttribute("resourceResponse");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_1 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay$1theme_defineObjects_1.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_1.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_1 = _jspx_th_liferay$1theme_defineObjects_1.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_1);
        return;
      }
      _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_1);
      themeDisplay = (com.liferay.portal.kernel.theme.ThemeDisplay) _jspx_page_context.findAttribute("themeDisplay");
      company = (com.liferay.portal.kernel.model.Company) _jspx_page_context.findAttribute("company");
      account = (com.liferay.portal.kernel.model.Account) _jspx_page_context.findAttribute("account");
      user = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("user");
      realUser = (com.liferay.portal.kernel.model.User) _jspx_page_context.findAttribute("realUser");
      contact = (com.liferay.portal.kernel.model.Contact) _jspx_page_context.findAttribute("contact");
      layout = (com.liferay.portal.kernel.model.Layout) _jspx_page_context.findAttribute("layout");
      layouts = (java.util.List) _jspx_page_context.findAttribute("layouts");
      plid = (java.lang.Long) _jspx_page_context.findAttribute("plid");
      layoutTypePortlet = (com.liferay.portal.kernel.model.LayoutTypePortlet) _jspx_page_context.findAttribute("layoutTypePortlet");
      scopeGroupId = (java.lang.Long) _jspx_page_context.findAttribute("scopeGroupId");
      permissionChecker = (com.liferay.portal.kernel.security.permission.PermissionChecker) _jspx_page_context.findAttribute("permissionChecker");
      locale = (java.util.Locale) _jspx_page_context.findAttribute("locale");
      timeZone = (java.util.TimeZone) _jspx_page_context.findAttribute("timeZone");
      theme = (com.liferay.portal.kernel.model.Theme) _jspx_page_context.findAttribute("theme");
      colorScheme = (com.liferay.portal.kernel.model.ColorScheme) _jspx_page_context.findAttribute("colorScheme");
      portletDisplay = (com.liferay.portal.kernel.theme.PortletDisplay) _jspx_page_context.findAttribute("portletDisplay");
      portletGroupId = (java.lang.Long) _jspx_page_context.findAttribute("portletGroupId");
      out.write("\r\n");
      out.write("\r\n");
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_1 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_defineObjects_1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_defineObjects_1.setParent(null);
      int _jspx_eval_portlet_defineObjects_1 = _jspx_th_portlet_defineObjects_1.doStartTag();
      if (_jspx_th_portlet_defineObjects_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_1);
        return;
      }
      _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_1);
      actionRequest = (javax.portlet.ActionRequest) _jspx_page_context.findAttribute("actionRequest");
      actionResponse = (javax.portlet.ActionResponse) _jspx_page_context.findAttribute("actionResponse");
      eventRequest = (javax.portlet.EventRequest) _jspx_page_context.findAttribute("eventRequest");
      eventResponse = (javax.portlet.EventResponse) _jspx_page_context.findAttribute("eventResponse");
      liferayPortletRequest = (com.liferay.portal.kernel.portlet.LiferayPortletRequest) _jspx_page_context.findAttribute("liferayPortletRequest");
      liferayPortletResponse = (com.liferay.portal.kernel.portlet.LiferayPortletResponse) _jspx_page_context.findAttribute("liferayPortletResponse");
      portletConfig = (javax.portlet.PortletConfig) _jspx_page_context.findAttribute("portletConfig");
      portletName = (java.lang.String) _jspx_page_context.findAttribute("portletName");
      portletPreferences = (javax.portlet.PortletPreferences) _jspx_page_context.findAttribute("portletPreferences");
      portletPreferencesValues = (java.util.Map) _jspx_page_context.findAttribute("portletPreferencesValues");
      portletSession = (javax.portlet.PortletSession) _jspx_page_context.findAttribute("portletSession");
      portletSessionScope = (java.util.Map) _jspx_page_context.findAttribute("portletSessionScope");
      renderRequest = (javax.portlet.RenderRequest) _jspx_page_context.findAttribute("renderRequest");
      renderResponse = (javax.portlet.RenderResponse) _jspx_page_context.findAttribute("renderResponse");
      resourceRequest = (javax.portlet.ResourceRequest) _jspx_page_context.findAttribute("resourceRequest");
      resourceResponse = (javax.portlet.ResourceResponse) _jspx_page_context.findAttribute("resourceResponse");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
String projectID = renderRequest.getParameter("projectID");
ProjectRegistration projectRegistration = ProjectRegistrationLocalServiceUtil.findByPROJECT_ID(Long.parseLong(projectID));
BenificiaryRegistration benificiaryObj = BenificiaryRegistrationLocalServiceUtil.findByBENIFICIARY_ID(projectRegistration.getBENIFICIARY_ID());
User userData = UserLocalServiceUtil.fetchUser(projectRegistration.getUSER_ID());

float donatedAmount = 0;
List<FundRegistration> fundAmtList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());

for(FundRegistration fundAmtObj : fundAmtList){
	donatedAmount = donatedAmount + fundAmtObj.getDONATED_AMOUNT();
}
double donatedAmountInPercentage = (donatedAmount*100)/projectRegistration.getREQUIRED_FUND_AMOUNT();


      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- ---------CSS Start--------- -->\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t\r\n");
      out.write("\th1{\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tfont-size: 1.6em;\r\n");
      out.write("        font-weight: 600;\r\n");
      out.write("    color: #5d5d5d;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container{\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".card-body {\r\n");
      out.write("    box-shadow: 1px 2px 10px 0 #d8d8d8;\r\n");
      out.write("    border-radius: 2px;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write(".card-body-new {\r\n");
      out.write("    box-shadow: 1px 2px 10px 0 #d8d8d8;\r\n");
      out.write("    border-radius: 2px;\r\n");
      out.write("    padding: 5%;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".payment-options {\r\n");
      out.write("    font-size: 12px;\r\n");
      out.write("    color: #999999;\r\n");
      out.write("    margin-top: 5px;\r\n");
      out.write("    margin-bottom: 0px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".seperater {\r\n");
      out.write("    margin: 10px 0px;\r\n");
      out.write("    font-size: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".seperater span {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    width: 60px;\r\n");
      out.write("    border: 1px solid #d0d0d0;\r\n");
      out.write("    height: 1px;\r\n");
      out.write("    margin: 3px 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-primary {\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    background-color: #b91141;\r\n");
      out.write("    border-color: #b91141;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  .btn-success:hover, .btn-success:active, .btn-success:focus {\r\n");
      out.write("  color: #fff !important;\r\n");
      out.write("  background-color: #a20f39 !important;\r\n");
      out.write("  border-color: #a20f39 !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".well{\r\n");
      out.write("\t\r\n");
      out.write("\tbox-shadow: 0px 1px 5px #888888;\r\n");
      out.write("\theight: 68px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".well-lg{\r\n");
      out.write("box-shadow: 0px 1px 5px #888888;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tpadding: 2%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-facebook {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tbackground-color: #4C67A1;\r\n");
      out.write("  }\r\n");
      out.write(".btn-facebook:hover {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tbackground-color: #405D9B;\r\n");
      out.write("}\r\n");
      out.write(".btn-facebook:focus {\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".btn-twitter{\r\n");
      out.write("\tfont-size:24px;background: #55ACEE;display: inline-block;\r\n");
      out.write("    margin-bottom: 0;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    vertical-align: middle;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    background-image: none;\r\n");
      out.write("    border: 1px solid transparent;\r\n");
      out.write("    white-space: nowrap;\r\n");
      out.write("    padding: 6px 12px;\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("    line-height: 1.7;\r\n");
      out.write("    border-radius: 4px;\r\n");
      out.write("    color: white;\r\n");
      out.write("        height: 48px;\r\n");
      out.write("    margin-top: 9px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@import url(https://fonts.googleapis.com/css?family=Open+Sans:400italic);\r\n");
      out.write("blockquote{\r\n");
      out.write("  font-size: 1.1em;\r\n");
      out.write("  margin:50px auto;\r\n");
      out.write("  font-family:Open Sans;\r\n");
      out.write("  font-style:italic;\r\n");
      out.write("  color: #555555;\r\n");
      out.write("  padding:1.2em 30px 1.2em 75px;\r\n");
      out.write("  border-left:8px solid #b91141 ;\r\n");
      out.write("  line-height:1.6;\r\n");
      out.write("  position: relative;\r\n");
      out.write("  background:#EDEDED;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("blockquote::before{\r\n");
      out.write("  font-family:Arial;\r\n");
      out.write("  content: \"\\201C\";\r\n");
      out.write("  color:#78C0A8;\r\n");
      out.write("  font-size:4em;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  left: 10px;\r\n");
      out.write("  top:-10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("blockquote::after{\r\n");
      out.write("  content: '';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("blockquote span{\r\n");
      out.write("  display:block;\r\n");
      out.write("  color:#333333;\r\n");
      out.write("  font-style: normal;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  margin-top:1em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t.tab {\r\n");
      out.write("\t\tborder: 0px;\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("  border: 1px solid #ccc;\r\n");
      out.write("  background-color: #f1f1f1;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("      border-bottom: 2px solid #b91141;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Style the buttons inside the tab */\r\n");
      out.write(".tab button {\r\n");
      out.write("  background-color: inherit;\r\n");
      out.write("  float: left;\r\n");
      out.write("  border: none;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  padding: 14px 16px;\r\n");
      out.write("  transition: 0.3s;\r\n");
      out.write("  font-size: 17px;\r\n");
      out.write("  width: 50%\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Change background color of buttons on hover */\r\n");
      out.write(".tab button:hover {\r\n");
      out.write("  background-color: #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Create an active/current tablink class */\r\n");
      out.write(".tab button.active {\r\n");
      out.write("  background-color: #ccc;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Style the tab content */\r\n");
      out.write(".tabcontent {\r\n");
      out.write("\r\n");
      out.write("  display: ;\r\n");
      out.write("  padding: 6px 12px;\r\n");
      out.write("  -webkit-animation: fadeEffect 1s;\r\n");
      out.write("  animation: fadeEffect 1s;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Fade in tabs */\r\n");
      out.write("@-webkit-keyframes fadeEffect {\r\n");
      out.write("  from {opacity: 0;}\r\n");
      out.write("  to {opacity: 1;}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes fadeEffect {\r\n");
      out.write("  from {opacity: 0;}\r\n");
      out.write("  to {opacity: 1;}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".progress-bar1 {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  height: 100px;\r\n");
      out.write("  width: 100px;\r\n");
      out.write("  margin:0 auto;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write(".progress-bar1 div {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  height: 100px;\r\n");
      out.write("  width: 100px;\r\n");
      out.write("  border-radius: 50%;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write(".progress-bar1 div span {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  font-family: Arial;\r\n");
      out.write("  font-size: 22px;\r\n");
      out.write("  line-height: 75px;\r\n");
      out.write("  height: 75px;\r\n");
      out.write("  width: 75px;\r\n");
      out.write("  left: 12.5px;\r\n");
      out.write("  top: 12.5px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  border-radius: 50%;\r\n");
      out.write("  background-color: white;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write(".progress-bar1 .background { background-color: #b3cef6; }\r\n");
      out.write(" \r\n");
      out.write(".progress-bar1 .rotate {\r\n");
      out.write("  clip: rect(0 50px 100px 0);\r\n");
      out.write("  background-color: #4b86db;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write(".progress-bar1 .left {\r\n");
      out.write("  clip: rect(0 50px 100px 0);\r\n");
      out.write("  opacity: 1;\r\n");
      out.write("  background-color: #b3cef6;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write(".progress-bar1 .right {\r\n");
      out.write("  clip: rect(0 50px 100px 0);\r\n");
      out.write("  transform: rotate(180deg);\r\n");
      out.write("  opacity: 0;\r\n");
      out.write("  background-color: #4b86db;\r\n");
      out.write("}\r\n");
      out.write(" \r\n");
      out.write("@keyframes\r\n");
      out.write("toggle {  0% {\r\n");
      out.write(" opacity: 0;\r\n");
      out.write("}\r\n");
      out.write(" 100% {\r\n");
      out.write(" opacity: 1;\r\n");
      out.write("}\r\n");
      out.write("}  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".campaign-no-overlay .campaign-owner-details {\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    background-color: #ecedee;\r\n");
      out.write("    margin-top: 30px;\r\n");
      out.write("    font-size: 10px;\r\n");
      out.write("    border-radius: 2px;\r\n");
      out.write("}\r\n");
      out.write("/* forms */\r\n");
      out.write("\r\n");
      out.write(".customPagination, .paginacaoCursor{\r\n");
      out.write("    \r\n");
      out.write("      padding: 5px 8px;\r\n");
      out.write("      color: #fff;\r\n");
      out.write("      background: #b91141;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write(".container1 {\r\n");
      out.write("  border: 2px solid #dedede;\r\n");
      out.write("  background-color: #f1f1f1;\r\n");
      out.write("  border-radius: 5px;\r\n");
      out.write("  padding: 10px;\r\n");
      out.write("  margin: 10px 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".darker {\r\n");
      out.write("  border-color: #ccc;\r\n");
      out.write("  background-color: #ddd;\r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container1::after {\r\n");
      out.write("  content: \"\";\r\n");
      out.write("  clear: both;\r\n");
      out.write("  display: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container1 img {\r\n");
      out.write("  float: left;\r\n");
      out.write("  max-width: 60px;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  margin-right: 20px;\r\n");
      out.write("  border-radius: 50%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container1 img.right {\r\n");
      out.write("  float: right;\r\n");
      out.write("  margin-left: 20px;\r\n");
      out.write("  margin-right:0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".time-left {\r\n");
      out.write("  float: left;\r\n");
      out.write("  color: #999;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".time-right {\r\n");
      out.write("  float: right;\r\n");
      out.write("  color: #999;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write(".section_3_content{\r\n");
      out.write(" background-image:url(\"/portal_content/cAUVERY.jpeg\") ;\r\n");
      out.write("  background-color: #cccccc;\r\n");
      out.write("}\r\n");
      out.write("/*code for navigation bar*/\r\n");
      out.write("\t.topnav {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\tbackground-color: #0077A2;\r\n");
      out.write("\t\tborder-bottom: 5px solid white;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav a {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\tcolor: #f2f2f2;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tpadding: 14px 25px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tfont-size: 1.2vw;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav a:hover {\r\n");
      out.write("\t\tbackground-color: #ddd;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav a.active {\r\n");
      out.write("\t\tbackground-color: #4CAF50;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.topnav {\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown1 {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown1 .dropbtn1 {\r\n");
      out.write("\t\tfont-size: 1.2vw;\r\n");
      out.write("\t\tborder: none;\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\tpadding: 14px 19px;\r\n");
      out.write("\t\tbackground-color: inherit;\r\n");
      out.write("\t\tfont-family: inherit;\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t.dropdown-content1 {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbackground-color: #f9f9f9;\r\n");
      out.write("\t\tmin-width: 160px;\r\n");
      out.write("\t\tbox-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);\r\n");
      out.write("\t\tz-index: 1;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown-content1 a {\r\n");
      out.write("\t\tfloat: none;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t\tpadding: 12px 16px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown-content1 a:hover {\r\n");
      out.write("\t\tbackground-color: #ddd;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown1:hover .dropdown-content1 {\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#demo-2 input[type=search] {\r\n");
      out.write("\t\twidth: 15px;\r\n");
      out.write("\t\tpadding-left: 10px;\r\n");
      out.write("\t\tcolor: transparent;\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input[type=search]:hover {\r\n");
      out.write("\t\tbackground-color: #fff;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input[type=search]:focus {\r\n");
      out.write("\t\tpadding: 10px 30px;\r\n");
      out.write("\t\twidth: 130px;\r\n");
      out.write("\t\tpadding-left: 32px;\r\n");
      out.write("\t\tcolor: #000;\r\n");
      out.write("\t\tbackground-color: #fff;\r\n");
      out.write("\t\tcursor: auto;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input:-moz-placeholder {\r\n");
      out.write("\t\tcolor: transparent;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input::-webkit-input-placeholder {\r\n");
      out.write("\t\tcolor: transparent;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput {\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput[type=search] {\r\n");
      out.write("\t\t-webkit-appearance: textfield;\r\n");
      out.write("\t\t-webkit-box-sizing: content-box;\r\n");
      out.write("\t\tfont-family: inherit;\r\n");
      out.write("\t\tfont-size: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput::-webkit-search-decoration,\r\n");
      out.write("\tinput::-webkit-search-cancel-button {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tinput[type=search] {\r\n");
      out.write("\r\n");
      out.write("\t\tmargin-top: 2px;\r\n");
      out.write("\t\tbackground: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;\r\n");
      out.write("\t\tborder-bottom: solid 1px #ccc;\r\n");
      out.write("\t\tborder-top: solid 1px #ccc;\r\n");
      out.write("\t\tborder-left: solid 1px #ccc;\r\n");
      out.write("\t\tborder-right: solid 1px #ccc;\r\n");
      out.write("\t\tpadding: 15px 0px 9px 0px;\r\n");
      out.write("\t\twidth: 43px;\r\n");
      out.write("\r\n");
      out.write("\t\t-webkit-border-radius: 10em;\r\n");
      out.write("\t\t-moz-border-radius: 10em;\r\n");
      out.write("\t\tborder-radius: 10em;\r\n");
      out.write("\r\n");
      out.write("\t\t-webkit-transition: all .5s;\r\n");
      out.write("\t\t-moz-transition: all .5s;\r\n");
      out.write("\t\ttransition: all .5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput[type=search]:focus {\r\n");
      out.write("\t\tpadding: 10px 30px;\r\n");
      out.write("\t\twidth: 30%;\r\n");
      out.write("\t\tbackground-color: #fff;\r\n");
      out.write("\t\tborder-color: #66CC75;\r\n");
      out.write("\r\n");
      out.write("\t\t-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t\t-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t\tbox-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tinput:-moz-placeholder {\r\n");
      out.write("\t\tcolor: #999;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput::-webkit-input-placeholder {\r\n");
      out.write("\t\tcolor: #999;\r\n");
      out.write("\t}\r\n");
      out.write("/*end of navigation bar css*/\r\n");
      out.write("\t\r\n");
      out.write("\t/*cards & Testimonals css*/\r\n");
      out.write("\t.testimotionals {\r\n");
      out.write("\t\twidth: 20%;\r\n");
      out.write("\t\tdisplay: inline-block;\r\n");
      out.write("\t\tmargin-left: 50px;\r\n");
      out.write("\t\tmargin-top: 50px margin-left:100px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card {\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 535px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t\tbackground: #0077A2;\r\n");
      out.write("\t\tpadding: 20px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\t/*\tbox-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .layer {\r\n");
      out.write("\t\t/*z-index: 1;*/\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: calc(100% - 2px);\r\n");
      out.write("\t\theight: 100%;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\tleft: 0;\r\n");
      out.write("\t\tbackground: linear-gradient(to left, #7FBD2c, #7FBD2c);\r\n");
      out.write("\t\ttransition: 0.5s;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 {\r\n");
      out.write("\t\t/*\tz-index: 2;*/\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card:hover .layer {\r\n");
      out.write("\t\ttop: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 p {\r\n");
      out.write("\t\tfont-size: 14px;\r\n");
      out.write("\t\tline-height: 24px;\r\n");
      out.write("\t\tcolor: #fff;\r\n");
      out.write("\t\tmargin-top: -3px;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 .image {\r\n");
      out.write("\t\twidth: 100px;\r\n");
      out.write("\t\theight: 100px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t\tborder-radius: 50%;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\tborder: 4px solid white;\r\n");
      out.write("\t\tbox-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .conte nt .details h2 {\r\n");
      out.write("\t\tfont-size: 18px;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 .details h2 span {\r\n");
      out.write("\t\tfont-size: 18px;\r\n");
      out.write("\t\tcolor: purple;\r\n");
      out.write("\t\ttransition: 0.5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card:hover .content1 .details h2 span {\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tmargin-top: 7px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.para {\r\n");
      out.write("\t\theight: 110px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.boxed {\r\n");
      out.write("\t\tbackground-color: black;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 190px;\r\n");
      out.write("\t\tmargin-bottom: px;\r\n");
      out.write("\t\tmargin-top: -8px;\r\n");
      out.write("\t}\r\n");
      out.write("/*end of cards & testimanals css*/\r\n");
      out.write("\t\r\n");
      out.write("/*css for text_fundraiser*/\t\r\n");
      out.write("\t.text_fundraiser {\r\n");
      out.write("\t\tcolor: #0077A2;\r\n");
      out.write("\t\tfont-size: 4vw;\r\n");
      out.write("\t}\r\n");
      out.write("/*end of text_fundraiser*/\r\n");
      out.write("\t\r\n");
      out.write("/*code for section3 */\t\r\n");
      out.write("\t.slideshow-container {\r\n");
      out.write("\t\tmax-width: 1000px;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t\theight: 420px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.text {\r\n");
      out.write("\t\tcolor: #f2f2f2;\r\n");
      out.write("\t\tfont-size: 15px;\r\n");
      out.write("\t\tpadding: 8px 12px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 8px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* The dots/bullets/indicators */\r\n");
      out.write("\t.dot {\r\n");
      out.write("\t\theight: 15px;\r\n");
      out.write("\t\twidth: 15px;\r\n");
      out.write("\t\tmargin: 0 2px;\r\n");
      out.write("\t\tbackground-color: #bbb;\r\n");
      out.write("\t\tborder-radius: 50%;\r\n");
      out.write("\t\tdisplay: inline-block;\r\n");
      out.write("\t\ttransition: background-color 0.6s ease;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.active {\r\n");
      out.write("\t\tbackground-color: #717171;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Fading animation */\r\n");
      out.write("\t.fade {\r\n");
      out.write("\t\t-webkit-animation-name: fade;\r\n");
      out.write("\t\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\t\tanimation-name: fade;\r\n");
      out.write("\t\tanimation-duration: 1.5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@-webkit-keyframes fade {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@keyframes fade {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* On smaller screens, decrease text size */\r\n");
      out.write("\t@media only screen and (max-width: 300px) {\r\n");
      out.write("\t\t.text {\r\n");
      out.write("\t\t\tfont-size: 11px\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*section 2 css*/\r\n");
      out.write("\r\n");
      out.write("\t.slideshow-container1 {\r\n");
      out.write("\t\tmax-width: 100%;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Next & previous buttons */\r\n");
      out.write("\t.prev1,\r\n");
      out.write("\t.next1 {\r\n");
      out.write("\t\tmargin-left: 100px;\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 50%;\r\n");
      out.write("\t\twidth: auto;\r\n");
      out.write("\t\tpadding: 16px;\r\n");
      out.write("\t\tmargin-top: -22px;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t\tfont-weight: bold;\r\n");
      out.write("\t\tfont-size: 18px;\r\n");
      out.write("\t\ttransition: 0.6s ease;\r\n");
      out.write("\t\tborder-radius: 0 3px 3px 0;\r\n");
      out.write("\t\tuser-select: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Position the \"next button\" to the right */\r\n");
      out.write("\t.next1 {\r\n");
      out.write("\t\tright: 0;\r\n");
      out.write("\t\tborder-radius: 3px 0 0 3px;\r\n");
      out.write("\t\tmargin-right: 100px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* On hover, add a black background color with a little bit see-through */\r\n");
      out.write("\t.prev:hover1,\r\n");
      out.write("\t.next:hover1 {\r\n");
      out.write("\t\tbackground-color: rgba(0, 0, 0, 0.8);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Caption text */\r\n");
      out.write("\r\n");
      out.write("\t.text_section2 {\r\n");
      out.write("\t\twidth: auto;\r\n");
      out.write("\t\theight: 0px;\r\n");
      out.write("\t\tfont-family: comic sans MS;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t\tfont-size: 15px;\r\n");
      out.write("\t\tpadding: 0px 32px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 0px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tfont-size: 2.5vw;\r\n");
      out.write("\t\tmargin-left: 102px;\r\n");
      out.write("\t\tmargin-bottom: 0px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Number text (1/3 etc) */\r\n");
      out.write("\t.numbertext1 {\r\n");
      out.write("\t\tcolor: #f2f2f2;\r\n");
      out.write("\t\tfont-size: 12px;\r\n");
      out.write("\t\tpadding: 8px 12px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* The dots/bullets/indicators */\r\n");
      out.write("\t.dot1 {\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t\theight: 15px;\r\n");
      out.write("\t\twidth: 15px;\r\n");
      out.write("\t\tmargin: 0 2px;\r\n");
      out.write("\t\tbackground-color: #bbb;\r\n");
      out.write("\t\tborder-radius: 50%;\r\n");
      out.write("\t\tdisplay: inline-block;\r\n");
      out.write("\t\ttransition: background-color 0.6s ease;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.active1,\r\n");
      out.write("\t.dot:hover1 {\r\n");
      out.write("\t\tbackground-color: #717171;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Fading animation */\r\n");
      out.write("\t.fade1 {\r\n");
      out.write("\t\t-webkit-animation-name: fade;\r\n");
      out.write("\t\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\t\tanimation-name: fade;\r\n");
      out.write("\t\tanimation-duration: 1.5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@-webkit-keyframes fade1 {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@keyframes fade1 {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* On smaller screens, decrease text size */\r\n");
      out.write("\t@media only screen and (max-width: 300px) {\r\n");
      out.write("\r\n");
      out.write("\t\t.prev,\r\n");
      out.write("\t\t.next,\r\n");
      out.write("\t\t.text {\r\n");
      out.write("\t\t\tfont-size: 11px\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*section 2 css end*/\r\n");
      out.write("\r\n");
      out.write("\t/*section3(1) css*/\r\n");
      out.write("\r\n");
      out.write("\t.section3(1) {\r\n");
      out.write("\t\theight: 550px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*section3(1) css end*/\r\n");
      out.write("\r\n");
      out.write("\t.text_fundraiser {\r\n");
      out.write("\t\tcolor: #0077A2;\r\n");
      out.write("\t\tfont-size: 4vw;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("/*end of section3 css*/\t\r\n");
      out.write("\t\r\n");
      out.write("\t/*css of liferay */\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tfont-family: Verdana, sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.mySlides {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\timg {\r\n");
      out.write("\t\tvertical-align: middle;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*body css*/\r\n");
      out.write("\t.home_body {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\tmargin-top: -155px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*header css*/\r\n");
      out.write("\t/*.v1 {\r\n");
      out.write("\t\t\tborder-left: 3px solid #0077A2;\r\n");
      out.write("\t\t\theight: 60px;\r\n");
      out.write("\t\t\tmargin-left:267px;\r\n");
      out.write("\t\t\tmargin-top: -67px;\r\n");
      out.write("\t\t}\r\n");
      out.write("*/\r\n");
      out.write("\t.b_text {\r\n");
      out.write("\t\tpadding: 2px;\r\n");
      out.write("\t\tfont-family: georgia;\r\n");
      out.write("\t\tfont-size: 3vw;\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\t/*padding:50px;*/\r\n");
      out.write("\t\t/*margin-top: -50px;\r\n");
      out.write("\t\t\tmargin-left: 364px;*/\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*code for search icon*/\r\n");
      out.write("\t@import 'https://fonts.googleapis.com/css?family=Catamaran';\r\n");
      out.write("\r\n");
      out.write("\thtml,\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 100%;\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t\tfont-family: 'Catamaran', sans-serif;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\tbackground-color: #0077A2;\r\n");
      out.write("\t\tborder-bottom: 5px solid white;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav a {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\tcolor: #f2f2f2;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tpadding: 14px 25px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tfont-size: 1.2vw;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav a:hover {\r\n");
      out.write("\t\tbackground-color: #ddd;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.topnav a.active {\r\n");
      out.write("\t\tbackground-color: #4CAF50;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*------------------------------------------------------------------------------------------------------------*/\r\n");
      out.write("\t/*closing of nav bar content*/\r\n");
      out.write("\r\n");
      out.write("\t/*start of section2 css*/\r\n");
      out.write("\t/* Slideshow container */\r\n");
      out.write("\t.slideshow-container {\r\n");
      out.write("\t\tmax-width: 1000px;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t\theight: 420px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Caption text */\r\n");
      out.write("\t.text {\r\n");
      out.write("\t\tcolor: #f2f2f2;\r\n");
      out.write("\t\tfont-size: 15px;\r\n");
      out.write("\t\tpadding: 8px 12px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 8px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* The dots/bullets/indicators */\r\n");
      out.write("\t.dot {\r\n");
      out.write("\t\theight: 15px;\r\n");
      out.write("\t\twidth: 15px;\r\n");
      out.write("\t\tmargin: 0 2px;\r\n");
      out.write("\t\tbackground-color: #bbb;\r\n");
      out.write("\t\tborder-radius: 50%;\r\n");
      out.write("\t\tdisplay: inline-block;\r\n");
      out.write("\t\ttransition: background-color 0.6s ease;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.active {\r\n");
      out.write("\t\tbackground-color: #717171;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Fading animation */\r\n");
      out.write("\t.fade {\r\n");
      out.write("\t\t-webkit-animation-name: fade;\r\n");
      out.write("\t\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\t\tanimation-name: fade;\r\n");
      out.write("\t\tanimation-duration: 1.5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@-webkit-keyframes fade {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@keyframes fade {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* On smaller screens, decrease text size */\r\n");
      out.write("\t@media only screen and (max-width: 300px) {\r\n");
      out.write("\t\t.text {\r\n");
      out.write("\t\t\tfont-size: 11px\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*section 2 css*/\r\n");
      out.write("\r\n");
      out.write("\t.slideshow-container1 {\r\n");
      out.write("\t\tmax-width: 100%;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tmargin: auto;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Next & previous buttons */\r\n");
      out.write("\t.prev1,\r\n");
      out.write("\t.next1 {\r\n");
      out.write("\t\tmargin-left: 100px;\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 50%;\r\n");
      out.write("\t\twidth: auto;\r\n");
      out.write("\t\tpadding: 16px;\r\n");
      out.write("\t\tmargin-top: -22px;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t\tfont-weight: bold;\r\n");
      out.write("\t\tfont-size: 50px;\r\n");
      out.write("\t\ttransition: 0.6s ease;\r\n");
      out.write("\t\tborder-radius: 0 3px 3px 0;\r\n");
      out.write("\t\tuser-select: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Position the \"next button\" to the right */\r\n");
      out.write("\t.next1 {\r\n");
      out.write("\t\tright: 0;\r\n");
      out.write("\t\tborder-radius: 3px 0 0 3px;\r\n");
      out.write("\t\tmargin-right: 100px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* On hover, add a black background color with a little bit see-through */\r\n");
      out.write("\t.prev:hover1,\r\n");
      out.write("\t.next:hover1 {\r\n");
      out.write("\t\tbackground-color: rgba(0, 0, 0, 0.8);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Caption text */\r\n");
      out.write("\r\n");
      out.write("\t.text_section2 {\r\n");
      out.write("    width: auto;\r\n");
      out.write("    height: auto;\r\n");
      out.write("    font-family: comic sans MS;\r\n");
      out.write("    color: black;\r\n");
      out.write("    font-size: 15px;\r\n");
      out.write("    padding: 0px 80px;\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    bottom: 0px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-size: 2.5vw;\r\n");
      out.write("    margin-left: 111px;\r\n");
      out.write("    margin-bottom: -46px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t/* Number text (1/3 etc) */\r\n");
      out.write("\t.numbertext1 {\r\n");
      out.write("\t\tcolor: #f2f2f2;\r\n");
      out.write("\t\tfont-size: 12px;\r\n");
      out.write("\t\tpadding: 8px 12px;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* The dots/bullets/indicators */\r\n");
      out.write("\t.dot1 {\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t\theight: 15px;\r\n");
      out.write("\t\twidth: 15px;\r\n");
      out.write("\t\tmargin: 0 2px;\r\n");
      out.write("\t\tbackground-color: #bbb;\r\n");
      out.write("\t\tborder-radius: 50%;\r\n");
      out.write("\t\tdisplay: inline-block;\r\n");
      out.write("\t\ttransition: background-color 0.6s ease;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.active1,\r\n");
      out.write("\t.dot:hover1 {\r\n");
      out.write("\t\tbackground-color: #717171;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Fading animation */\r\n");
      out.write("\t.fade1 {\r\n");
      out.write("\t\t-webkit-animation-name: fade;\r\n");
      out.write("\t\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\t\tanimation-name: fade;\r\n");
      out.write("\t\tanimation-duration: 1.5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@-webkit-keyframes fade1 {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@keyframes fade1 {\r\n");
      out.write("\t\tfrom {\r\n");
      out.write("\t\t\topacity: .4\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tto {\r\n");
      out.write("\t\t\topacity: 1\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* On smaller screens, decrease text size */\r\n");
      out.write("\t@media only screen and (max-width: 300px) {\r\n");
      out.write("\r\n");
      out.write("\t\t.prev,\r\n");
      out.write("\t\t.next,\r\n");
      out.write("\t\t.text {\r\n");
      out.write("\t\t\tfont-size: 11px\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*section 2 css end*/\r\n");
      out.write("\r\n");
      out.write("\t/*section3(1) css*/\r\n");
      out.write("\r\n");
      out.write("\t.section3(1) {\r\n");
      out.write("\t\theight: 550px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*section3(1) css end*/\r\n");
      out.write("\r\n");
      out.write("\t.text_fundraiser {\r\n");
      out.write("\t\tcolor: #0077A2;\r\n");
      out.write("\t\tfont-size: 4vw;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*CARDS CSS*/\r\n");
      out.write("\t.testimotionals {\r\n");
      out.write("\t\twidth: 20%;\r\n");
      out.write("\t\tdisplay: inline-block;\r\n");
      out.write("\t\tmargin-left: 50px;\r\n");
      out.write("\t\tmargin-top: 50px margin-left:100px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card {\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\twidth: 400%;\r\n");
      out.write("\t\theight: 350px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t\tbackground: #0077A2;\r\n");
      out.write("\t\tpadding: 20px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\t/*\tbox-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .layer {\r\n");
      out.write("\t\t/*z-index: 1;*/\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: calc(100% - 2px);\r\n");
      out.write("\t\theight: 100%;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\tleft: 0;\r\n");
      out.write("\t\tbackground: linear-gradient(to left, #7FBD2c, #7FBD2c);\r\n");
      out.write("\t\ttransition: 0.5s;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 {\r\n");
      out.write("\t\t/*\tz-index: 2;*/\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card:hover .layer {\r\n");
      out.write("\t\ttop: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 p {\r\n");
      out.write("\t\tfont-size: 14px;\r\n");
      out.write("\t\tline-height: 24px;\r\n");
      out.write("\t\tcolor: #fff;\r\n");
      out.write("\t\tmargin-top: -3px;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 .image {\r\n");
      out.write("\t\twidth: 100px;\r\n");
      out.write("\t\theight: 100px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t\tborder-radius: 50%;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\tborder: 4px solid white;\r\n");
      out.write("\t\tbox-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .conte nt .details h2 {\r\n");
      out.write("\t\tfont-size: 18px;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card .content1 .details h2 span {\r\n");
      out.write("\t\tfont-size: 18px;\r\n");
      out.write("\t\tcolor: purple;\r\n");
      out.write("\t\ttransition: 0.5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.testimotionals .card:hover .content1 .details h2 span {\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tmargin-top: 7px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.para {\r\n");
      out.write("\t\theight: 110px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.boxed {\r\n");
      out.write("\t\tbackground-color: black;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 190px;\r\n");
      out.write("\t\tmargin-bottom: px;\r\n");
      out.write("\t\tmargin-top: -8px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*END OF CARDS CSS*/\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t/*section4 css*/\r\n");
      out.write("\t.section4 {\r\n");
      out.write("\t\theight: auto;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tbackground-color: #0077A2;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*end of section4 css*/\r\n");
      out.write("\r\n");
      out.write("\t/*section5 css*/\r\n");
      out.write("\r\n");
      out.write("\t.fishes {\r\n");
      out.write("\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\ttop: -10px;\r\n");
      out.write("\t\tleft: 0;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*start of class tag image with text*/\r\n");
      out.write("\t.tag {\r\n");
      out.write("\r\n");
      out.write("\t\tfloat: Center;\r\n");
      out.write("\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\r\n");
      out.write("\t\tleft: 50px;\r\n");
      out.write("\r\n");
      out.write("\t\ttop: 50px;\r\n");
      out.write("\r\n");
      out.write("\t\tbackground-color: green;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*end*/\r\n");
      out.write("\t.fish {\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\ttop: -18px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t.section5 .content {\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbottom: 0;\r\n");
      out.write("\t\tbackground: white;\r\n");
      out.write("\t\t/* Fallback color */\r\n");
      out.write("\t\t/* background: rgba(0, 0, 0, 0.2);*/\r\n");
      out.write("\t\t/* Black background with 0.2 opacity */\r\n");
      out.write("\t\tcolor: #f1f1f1;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\tpadding: 60px;\r\n");
      out.write("\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*end of section 5 css*/\r\n");
      out.write("\r\n");
      out.write("\t/*start of end carousel set 5 images*/\r\n");
      out.write("\t.slick-slide {\r\n");
      out.write("\t\tmargin: 0px 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slide img {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slider {\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\tbox-sizing: border-box;\r\n");
      out.write("\t\t-webkit-user-select: none;\r\n");
      out.write("\t\t-moz-user-select: none;\r\n");
      out.write("\t\t-ms-user-select: none;\r\n");
      out.write("\t\tuser-select: none;\r\n");
      out.write("\t\t-webkit-touch-callout: none;\r\n");
      out.write("\t\t-khtml-user-select: none;\r\n");
      out.write("\t\t-ms-touch-action: pan-y;\r\n");
      out.write("\t\ttouch-action: pan-y;\r\n");
      out.write("\t\t-webkit-tap-highlight-color: transparent;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-list {\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-list:focus {\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-list.dragging {\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t\tcursor: hand;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slider .slick-track,\r\n");
      out.write("\t.slick-slider .slick-list {\r\n");
      out.write("\t\t-webkit-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t\t-moz-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t\t-ms-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t\t-o-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t\ttransform: translate3d(0, 0, 0);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-track {\r\n");
      out.write("\t\tposition: relative;\r\n");
      out.write("\t\ttop: 0;\r\n");
      out.write("\t\tleft: 0;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-track:before,\r\n");
      out.write("\t.slick-track:after {\r\n");
      out.write("\t\tdisplay: table;\r\n");
      out.write("\t\tcontent: '';\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-track:after {\r\n");
      out.write("\t\tclear: both;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-loading .slick-track {\r\n");
      out.write("\t\tvisibility: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slide {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\theight: 100%;\r\n");
      out.write("\t\tmin-height: 1px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t[dir='rtl'] .slick-slide {\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slide img {\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slide.slick-loading img {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-slide.dragging img {\r\n");
      out.write("\t\tpointer-events: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-initialized .slick-slide {\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-loading .slick-slide {\r\n");
      out.write("\t\tvisibility: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-vertical .slick-slide {\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\theight: auto;\r\n");
      out.write("\t\tborder: 1px solid transparent;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.slick-arrow.slick-hidden {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t/*start of end carousel set 5 images*/\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t/*start of submenunavbar*/\r\n");
      out.write("\r\n");
      out.write("\t.topnav {\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown1 {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\toverflow: hidden;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown1 .dropbtn1 {\r\n");
      out.write("\t\tfont-size: 1.2vw;\r\n");
      out.write("\t\tborder: none;\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\tpadding: 14px 19px;\r\n");
      out.write("\t\tbackground-color: inherit;\r\n");
      out.write("\t\tfont-family: inherit;\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t.dropdown-content1 {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t\tposition: absolute;\r\n");
      out.write("\t\tbackground-color: #f9f9f9;\r\n");
      out.write("\t\tmin-width: 160px;\r\n");
      out.write("\t\tbox-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);\r\n");
      out.write("\t\tz-index: 1;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown-content1 a {\r\n");
      out.write("\t\tfloat: none;\r\n");
      out.write("\t\tcolor: black;\r\n");
      out.write("\t\tpadding: 12px 16px;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown-content1 a:hover {\r\n");
      out.write("\t\tbackground-color: #ddd;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.dropdown1:hover .dropdown-content1 {\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*end of submenunavbar*/\r\n");
      out.write("\r\n");
      out.write("\t/*search icon css*/\r\n");
      out.write("\t#demo-2 input[type=search] {\r\n");
      out.write("\t\twidth: 15px;\r\n");
      out.write("\t\tpadding-left: 10px;\r\n");
      out.write("\t\tcolor: transparent;\r\n");
      out.write("\t\tcursor: pointer;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input[type=search]:hover {\r\n");
      out.write("\t\tbackground-color: #fff;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input[type=search]:focus {\r\n");
      out.write("\t\tpadding: 10px 30px;\r\n");
      out.write("\t\twidth: 130px;\r\n");
      out.write("\t\tpadding-left: 32px;\r\n");
      out.write("\t\tcolor: #000;\r\n");
      out.write("\t\tbackground-color: #fff;\r\n");
      out.write("\t\tcursor: auto;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input:-moz-placeholder {\r\n");
      out.write("\t\tcolor: transparent;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#demo-2 input::-webkit-input-placeholder {\r\n");
      out.write("\t\tcolor: transparent;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput {\r\n");
      out.write("\t\toutline: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput[type=search] {\r\n");
      out.write("\t\t-webkit-appearance: textfield;\r\n");
      out.write("\t\t-webkit-box-sizing: content-box;\r\n");
      out.write("\t\tfont-family: inherit;\r\n");
      out.write("\t\tfont-size: 100%;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput::-webkit-search-decoration,\r\n");
      out.write("\tinput::-webkit-search-cancel-button {\r\n");
      out.write("\t\tdisplay: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tinput[type=search] {\r\n");
      out.write("\r\n");
      out.write("\t\tmargin-top: 2px;\r\n");
      out.write("\t\tbackground: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;\r\n");
      out.write("\t\tborder-bottom: solid 1px #ccc;\r\n");
      out.write("\t\tborder-top: solid 1px #ccc;\r\n");
      out.write("\t\tborder-left: solid 1px #ccc;\r\n");
      out.write("\t\tborder-right: solid 1px #ccc;\r\n");
      out.write("\t\tpadding: 9px 0px 9px 0px;\r\n");
      out.write("\t\twidth: 43px;\r\n");
      out.write("\r\n");
      out.write("\t\t-webkit-border-radius: 10em;\r\n");
      out.write("\t\t-moz-border-radius: 10em;\r\n");
      out.write("\t\tborder-radius: 10em;\r\n");
      out.write("\r\n");
      out.write("\t\t-webkit-transition: all .5s;\r\n");
      out.write("\t\t-moz-transition: all .5s;\r\n");
      out.write("\t\ttransition: all .5s;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput[type=search]:focus {\r\n");
      out.write("\t\tpadding: 10px 30px;\r\n");
      out.write("\t\twidth: 6%;\r\n");
      out.write("\t\tbackground-color: #fff;\r\n");
      out.write("\t\tborder-color: #66CC75;\r\n");
      out.write("\r\n");
      out.write("\t\t-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t\t-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t\tbox-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tinput:-moz-placeholder {\r\n");
      out.write("\t\tcolor: #999;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tinput::-webkit-input-placeholder {\r\n");
      out.write("\t\tcolor: #999;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*code u may delete*/\r\n");
      out.write("\ta {\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\ta:hover {\r\n");
      out.write("\t\tcolor: #7FBD2C;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\th1 {\r\n");
      out.write("\t\tfont: 1.7em;\r\n");
      out.write("\t\tline-height: 110%;\r\n");
      out.write("\t\tcolor: #000;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tp {\r\n");
      out.write("\t\tmargin: 0 0 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*code for footer*/\r\n");
      out.write("\t.column {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\twidth: 25%;\r\n");
      out.write("\t\tpadding: 45px;\r\n");
      out.write("\t\theight: auto;\r\n");
      out.write("\t\ttext-align: justify;\r\n");
      out.write("\t\t/* Should be removed. Only for demonstration */\r\n");
      out.write("\t}\r\n");
      out.write("\t.row{\r\n");
      out.write("\t\t    margin-bottom: -24px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/* Clear floats after the columns */\r\n");
      out.write("\t.row:after {\r\n");
      out.write("\t\tcontent: \"\";\r\n");
      out.write("\t\tdisplay: table;\r\n");
      out.write("\t\tclear: both;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.addressp {\r\n");
      out.write("\t\tcolor: white;\r\n");
      out.write("\t\tfont-size: 1.2vw;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*code for footer ends*/\r\n");
      out.write("\t#grad2 {\r\n");
      out.write("\t\theight: 500px;\r\n");
      out.write("\t\t/* For browsers that do not support gradients */\r\n");
      out.write("\t\t/* Standard syntax (must be last) */\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*sticked navbar css*/\r\n");
      out.write("\t/*.content {\r\n");
      out.write("  padding: 16px;\r\n");
      out.write("}*/\r\n");
      out.write("\r\n");
      out.write("\t.sticky {\r\n");
      out.write("\t\tposition: fixed;\r\n");
      out.write("\t\ttop:0px;\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\tz-index: 1;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.sticky+.content {\r\n");
      out.write("\t\tpadding-top: 60px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*images responsiveness*/\r\n");
      out.write("\t@media only screen and (max-width:100%) {\r\n");
      out.write("\r\n");
      out.write("\t\t.fishes,\r\n");
      out.write("\t\t.fish,\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\theight: auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t@media only screen and (max-width:100%) {\r\n");
      out.write("\r\n");
      out.write("\t\t.community,\r\n");
      out.write("\t\t.rural,\r\n");
      out.write("\t\t.senior,\r\n");
      out.write("\t\t.animals,\r\n");
      out.write("\t\t.disability,\r\n");
      out.write("\t\t.emergrncies,\r\n");
      out.write("\t\t.welfare,\r\n");
      out.write("\t\t.development,\r\n");
      out.write("\t\t.citizens,\r\n");
      out.write("\t\t.animals1,\r\n");
      out.write("\t\t.disability1,\r\n");
      out.write("\t\t.emergencies1 {\r\n");
      out.write("\t\t\theight: auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t@media only screen and (max-width:100%) {\r\n");
      out.write("\r\n");
      out.write("\t\t.trial,\r\n");
      out.write("\t\t.trial1,\r\n");
      out.write("\t\t.trial2,\r\n");
      out.write("\t\t.logoimg,\r\n");
      out.write("\t\t.bannerimg,\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\theight: auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t.logoimg{\r\n");
      out.write("\t\t    margin-top: 25px;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t/*end of images responsiveness*/\r\n");
      out.write("\t/*css of liferay code ends*/\r\n");
      out.write("\r\n");
      out.write("\t/*code for carousel offffffffffffffffffffffffffffffffffffffff 5 */\r\n");
      out.write("\t.slick-slide {\r\n");
      out.write("    margin: 0px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide img {\r\n");
      out.write("    width: 70%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slider\r\n");
      out.write("{\r\n");
      out.write("    position: relative;\r\n");
      out.write("\r\n");
      out.write("    display: block;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("\r\n");
      out.write("    -webkit-user-select: none;\r\n");
      out.write("       -moz-user-select: none;\r\n");
      out.write("        -ms-user-select: none;\r\n");
      out.write("            user-select: none;\r\n");
      out.write("\r\n");
      out.write("    -webkit-touch-callout: none;\r\n");
      out.write("    -khtml-user-select: none;\r\n");
      out.write("    -ms-touch-action: pan-y;\r\n");
      out.write("        touch-action: pan-y;\r\n");
      out.write("    -webkit-tap-highlight-color: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list\r\n");
      out.write("{\r\n");
      out.write("    position: relative;\r\n");
      out.write("\r\n");
      out.write("    display: block;\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write(".slick-list:focus\r\n");
      out.write("{\r\n");
      out.write("    outline: none;\r\n");
      out.write("}\r\n");
      out.write(".slick-list.dragging\r\n");
      out.write("{\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    cursor: hand;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slider .slick-track,\r\n");
      out.write(".slick-slider .slick-list\r\n");
      out.write("{\r\n");
      out.write("    -webkit-transform: translate3d(0, 0, 0);\r\n");
      out.write("       -moz-transform: translate3d(0, 0, 0);\r\n");
      out.write("        -ms-transform: translate3d(0, 0, 0);\r\n");
      out.write("         -o-transform: translate3d(0, 0, 0);\r\n");
      out.write("            transform: translate3d(0, 0, 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track\r\n");
      out.write("{\r\n");
      out.write("    position: relative;\r\n");
      out.write("    top: 0;\r\n");
      out.write("    left: 0;\r\n");
      out.write("\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write(".slick-track:before,\r\n");
      out.write(".slick-track:after\r\n");
      out.write("{\r\n");
      out.write("    display: table;\r\n");
      out.write("\r\n");
      out.write("    content: '';\r\n");
      out.write("}\r\n");
      out.write(".slick-track:after\r\n");
      out.write("{\r\n");
      out.write("    clear: both;\r\n");
      out.write("}\r\n");
      out.write(".slick-loading .slick-track\r\n");
      out.write("{\r\n");
      out.write("    visibility: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide\r\n");
      out.write("{\r\n");
      out.write("    display: none;\r\n");
      out.write("    float: left;\r\n");
      out.write("\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    min-height: 1px;\r\n");
      out.write("}\r\n");
      out.write("[dir='rtl'] .slick-slide\r\n");
      out.write("{\r\n");
      out.write("    float: right;\r\n");
      out.write("}\r\n");
      out.write(".slick-slide img\r\n");
      out.write("{\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write(".slick-slide.slick-loading img\r\n");
      out.write("{\r\n");
      out.write("    display: none;\r\n");
      out.write("}\r\n");
      out.write(".slick-slide.dragging img\r\n");
      out.write("{\r\n");
      out.write("    pointer-events: none;\r\n");
      out.write("}\r\n");
      out.write(".slick-initialized .slick-slide\r\n");
      out.write("{\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write(".slick-loading .slick-slide\r\n");
      out.write("{\r\n");
      out.write("    visibility: hidden;\r\n");
      out.write("}\r\n");
      out.write(".slick-vertical .slick-slide\r\n");
      out.write("{\r\n");
      out.write("    display: block;\r\n");
      out.write("\r\n");
      out.write("    height: auto;\r\n");
      out.write("\r\n");
      out.write("    border: 1px solid transparent;\r\n");
      out.write("}\r\n");
      out.write(".slick-arrow.slick-hidden {\r\n");
      out.write("    display: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".portlet-decorate .portlet-content{\r\n");
      out.write("    background-color: #FFF;\r\n");
      out.write("    border: 1px solid #E7E7ED;\r\n");
      out.write("    border-radius: 0.5rem;\r\n");
      out.write("    padding: 0px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".portlet-layout .portlet-header {\r\n");
      out.write("    margin-bottom: 3rem;\r\n");
      out.write("    visibility: hidden;\r\n");
      out.write("    margin-top: -47px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container::after, .row::after {\r\n");
      out.write("\tcontent: \"\";\r\n");
      out.write("\tclear: both;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".remainingDays {\r\n");
      out.write("\tmargin-bottom: -4%;\r\n");
      out.write("\tmargin-top: -4%;\r\n");
      out.write("\tcolor: #b91141;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".campaignpagelist {\r\n");
      out.write("\t/* background-image: url(\"/portal_content/beckgroundimg2.jpg\"); */\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tpadding-top: 24px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
 List<CategoryRegistration> categoryRegistration = CategoryRegistrationLocalServiceUtil.getCategoryRegistrations(0, CounterLocalServiceUtil.getCountersCount()); 
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<a href=\"/web/quickdaan-home-page/home\"><img src=\"\\portal_content\\QuickDaan_Logo.png\" class=\"logoimg\" style=\"width: 50%\"></a>\r\n");
      out.write("\t\t<div class=\"topnav\" id=\"navbar\">\r\n");
      out.write("\t\t\t<div class=\"dropdown1\"><button class=\"dropbtn1\">Categories <i class=\"fa fa-caret-down\"></i></button>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content1\"><a href=\"#\">Community Welfare</a> <a href=\"#\">Rural Development</a> <a href=\"#\">Inclusivity</a> <a href=\"#\">Environmental Sustainability</a> <a href=\"#\">Education</a> <a href=\"#\">Emergencies</a> <a href=\"#\">Medical</a> <a href=\"#\">Animals</a> <a href=\"#\">Children</a> <a href=\"#\">Sports</a> <a href=\"#\">Senior Citizens</a> <a href=\"#\">Women</a> <a href=\"#\">Social Entrepreneurship</a> <a href=\"#\">Others</a></div> \r\n");
      out.write("\t\t\t\t<div class=\"dropdown-content1\">\r\n");
      out.write("\t\t\t\t ");
 for(CategoryRegistration categoryDetails : categoryRegistration){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_0 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_0.setParent(null);
      _jspx_th_portlet_renderURL_0.setVar("CategoryURL");
      _jspx_th_portlet_renderURL_0.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_0 = _jspx_th_portlet_renderURL_0.doStartTag();
      if (_jspx_eval_portlet_renderURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
        _jspx_th_portlet_param_0.setName("CategoryId");
        _jspx_th_portlet_param_0.setValue( String.valueOf(categoryDetails.getCATEGORY_ID()) );
        int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
        if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_portlet_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t\t\t");
      }
      if (_jspx_th_portlet_renderURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_0);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_0);
      java.lang.String CategoryURL = null;
      CategoryURL = (java.lang.String) _jspx_page_context.findAttribute("CategoryURL");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${CategoryURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.print( categoryDetails.getCATEGORY_NAME() );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
	} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<a href=\"/web/crowd-funding/fund-raise-request\">Start a Fundraisers</a> <a href=\"#section4\">How it works</a> <a href=\"\">Find Fundraisers</a> <a href=\"/web/crowd-funding/campaigns\">Donate now</a>\r\n");
      out.write("\t\t\t");
 
			ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			boolean signedIn = themeDisplayObj.isSignedIn();
			System.out.println("here "+signedIn);
			if(signedIn==false){
			
      out.write("\r\n");
      out.write("\t\t\t<a href=\"/web/customelogin\" style=\"background: #7FBD2C;float:right\">LOGIN</a>\r\n");
      out.write("\t\t\t <a href=\"/web/customelogin/registration\" style=\"background: #7FBD2C;float:right\">SIGNUP</a>\r\n");
      out.write("\t\t\t");

			}else{
			
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/web/crowd-funding/campaign\">My Campaign</a>\r\n");
      out.write("\t\t\t\t");
 User userDetails = themeDisplayObj.getUser();
				if(userDetails.getUserId() == 36035){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"/web/crowd-funding/campaign-approval\">Admin</a>\r\n");
      out.write("\t\t\t\t\t");

				}
				
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/c/portal/logout\" style=\"background: #7FBD2C;float:right\">LOGOUT</a>\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\t<input type=\"search\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- ---------End of CSS--------- -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- CAMPAIGN TITLE -->\r\n");
      out.write("<br/>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<h1 class=\"campaign-title\">");
      out.print( projectRegistration.getTITLE() );
      out.write("</h1>\r\n");
      out.write("<br><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- Slideshow -->\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"box-shadow: 1px 2px 65px 0 #d8d8d8;border-radius: 2px;width: 64%; margin-left: 18%;\">\r\n");
      out.write("\t<div style=\"max-width:400px; margin-left:3%;padding: 1em;\">\r\n");
      out.write("\t<div class=\"mySlides\" style=\"height:452px;width:603px;\">\r\n");
      out.write("\t\t\t\t\t\t");
      //  portlet:resourceURL
      com.liferay.taglib.portlet.ResourceURLTag _jspx_th_portlet_resourceURL_0 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_portlet_resourceURL_var.get(com.liferay.taglib.portlet.ResourceURLTag.class);
      _jspx_th_portlet_resourceURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_resourceURL_0.setParent(null);
      _jspx_th_portlet_resourceURL_0.setVar("imageResourceURL");
      int _jspx_eval_portlet_resourceURL_0 = _jspx_th_portlet_resourceURL_0.doStartTag();
      if (_jspx_eval_portlet_resourceURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_portlet_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_resourceURL_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_3 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_3.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_0);
        _jspx_th_portlet_param_3.setName("ProjectIDForProjectImage");
        _jspx_th_portlet_param_3.setValue( String.valueOf(projectRegistration.getPROJECT_ID())  );
        int _jspx_eval_portlet_param_3 = _jspx_th_portlet_param_3.doStartTag();
        if (_jspx_th_portlet_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
        out.write("\r\n");
        out.write("\t\t\t");
      }
      if (_jspx_th_portlet_resourceURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_resourceURL_var.reuse(_jspx_th_portlet_resourceURL_0);
        return;
      }
      _jspx_tagPool_portlet_resourceURL_var.reuse(_jspx_th_portlet_resourceURL_0);
      java.lang.String imageResourceURL = null;
      imageResourceURL = (java.lang.String) _jspx_page_context.findAttribute("imageResourceURL");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imageResourceURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"Image\" style=\"width: 684px;height: 476px;margin-left:-10px;\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"mySlides\" style=\"height: 452px;width: 603px;\">\r\n");
      out.write("    <h4 style=\"text-align: center;\">Update</h4>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"mySlides\" style=\"height: 452px;width: 603px;\">\r\n");
      out.write("    <h3 style=\"color: #b91141\">Rs.");
      out.print( donatedAmount );
      out.write("  </h3>\r\n");
      out.write("   \r\n");
      out.write("  \t\t\t\t\t\t\t\t\t\t <!--  progress bar -->\r\n");
      out.write("   \r\n");
      out.write("    <div class=\"progress\">\r\n");
      out.write("\t</div><br>\r\n");
      out.write("    <p style=\"color:#5d5d5d\">raised of Rs.");
      out.print( projectRegistration.getREQUIRED_FUND_AMOUNT() );
      out.write("  goal</p>\r\n");
      out.write(" \t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- end of slideshow -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"well\">&nbsp&nbsp<a href=\"https://www.facebook.com/sharer/sharer.php?s=100&p[url]=http://127.0.0.1:8080/web/crowd-funding/campaing-details?p_p_id=CampaignDetails_INSTANCE_VPb8QZWCoDrF&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_jspPage=%2Fjsp%2FCampaign%20Details%2FCampaignDetails.jsp&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_projectID=101&p[images][0]=&p[title]=8-Year-Old With 100% Damaged Liver Has Few Hours Left For A Transplant&p[summary]=dzcdvsdvsddssdsdfsdfsdfsdf!\" target=\"_blank\" onclick=\"window.open(this.href,'targetWindow','toolbar=no,location=0,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=250'); return false\"><button style=\"width:33%; margin-top:10px;\" type=\"button\" class=\"btn btn-facebook btn-lg\"><i class=\"fa fa-facebook fa-2\"></i> Share on Facebook</button></a>&nbsp&nbsp<a href=\"http://twitter.com/share?&url=http://127.0.0.1:8080/web/crowd-funding/campaing-details?p_p_id=CampaignDetails_INSTANCE_VPb8QZWCoDrF&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_jspPage=%2Fjsp%2FCampaign%20Details%2FCampaignDetails.jsp&_CampaignDetails_INSTANCE_VPb8QZWCoDrF_projectID=101\" class=\"twitter-share-button\" data-show-count=\"false\" onclick=\"window.open(this.href,'targetWindow','toolbar=no,location=0,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=250'); return false\"><button class=\"btn-twitter\"style=\"width:33%;\">Share on Twitter<i class=\"fa fa-twitter\"></i></button></a></div>\r\n");
      out.write(" <br><br>\r\n");
      out.write(" \r\n");
      out.write(" \t\t\t\t\t\t\t\t\t\t\t<!-- CAMPAIGN DETAILS -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("<div class=\"col-md-8\" >\r\n");
      out.write("<div class=\"tab\">\r\n");
      out.write("<button class=\"tablinks\" onclick=\"openCity(event, 'Story')\">Story</button>\r\n");
      out.write("<button class=\"tablinks\" onclick=\"openCity(event, 'Update')\">Update</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"Story\" class=\"tabcontent\">\r\n");
      out.write("  <h3>Story</h3><br>\r\n");
      out.write("  <p>");
      out.print( projectRegistration.getDESCRIPTION() );
      out.write("</p>\r\n");
      out.write("  ");
 if(projectRegistration.getVIDEO_TYPE().isEmpty() == false){ 
      out.write("\r\n");
      out.write("\t ");
      //  portlet:resourceURL
      com.liferay.taglib.portlet.ResourceURLTag _jspx_th_portlet_resourceURL_1 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_portlet_resourceURL_var.get(com.liferay.taglib.portlet.ResourceURLTag.class);
      _jspx_th_portlet_resourceURL_1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_resourceURL_1.setParent(null);
      _jspx_th_portlet_resourceURL_1.setVar("ProjectVideoResourceURL");
      int _jspx_eval_portlet_resourceURL_1 = _jspx_th_portlet_resourceURL_1.doStartTag();
      if (_jspx_eval_portlet_resourceURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t");
        if (_jspx_meth_portlet_param_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_resourceURL_1, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_5 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_5.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_1);
        _jspx_th_portlet_param_5.setName("ProjectIDForProjectVideo");
        _jspx_th_portlet_param_5.setValue( String.valueOf(projectRegistration.getPROJECT_ID())  );
        int _jspx_eval_portlet_param_5 = _jspx_th_portlet_param_5.doStartTag();
        if (_jspx_th_portlet_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
        out.write("\r\n");
        out.write("\t");
      }
      if (_jspx_th_portlet_resourceURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_resourceURL_var.reuse(_jspx_th_portlet_resourceURL_1);
        return;
      }
      _jspx_tagPool_portlet_resourceURL_var.reuse(_jspx_th_portlet_resourceURL_1);
      java.lang.String ProjectVideoResourceURL = null;
      ProjectVideoResourceURL = (java.lang.String) _jspx_page_context.findAttribute("ProjectVideoResourceURL");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t <video autoplay id=\"myVideo\" controls style=\"max-width: 50%;\">\r\n");
      out.write("\t\t\t  <source src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ProjectVideoResourceURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" type=\"");
      out.print( projectRegistration.getVIDEO_TYPE() );
      out.write("\">\r\n");
      out.write("\t\t</video>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("  <div>\r\n");
      out.write("  <h4>Supporting documents: </h4>\r\n");
      out.write("    ");

					  List<DocumentRegistration> documentList = DocumentRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					  for(DocumentRegistration documentObj : documentList){
					  
      out.write("\r\n");
      out.write("\t\t\t\t\t\t ");
      //  portlet:resourceURL
      com.liferay.taglib.portlet.ResourceURLTag _jspx_th_portlet_resourceURL_2 = (com.liferay.taglib.portlet.ResourceURLTag) _jspx_tagPool_portlet_resourceURL_var.get(com.liferay.taglib.portlet.ResourceURLTag.class);
      _jspx_th_portlet_resourceURL_2.setPageContext(_jspx_page_context);
      _jspx_th_portlet_resourceURL_2.setParent(null);
      _jspx_th_portlet_resourceURL_2.setVar("ProjectDocumentResourceURL");
      int _jspx_eval_portlet_resourceURL_2 = _jspx_th_portlet_resourceURL_2.doStartTag();
      if (_jspx_eval_portlet_resourceURL_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_portlet_param_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_resourceURL_2, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_7 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_7.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_2);
        _jspx_th_portlet_param_7.setName("ProjectDocumentID");
        _jspx_th_portlet_param_7.setValue( String.valueOf(documentObj.getPROJECT_DOCUMENT_ID())  );
        int _jspx_eval_portlet_param_7 = _jspx_th_portlet_param_7.doStartTag();
        if (_jspx_th_portlet_param_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
        out.write("\r\n");
        out.write("\t\t\t\t\t\t ");
      }
      if (_jspx_th_portlet_resourceURL_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_resourceURL_var.reuse(_jspx_th_portlet_resourceURL_2);
        return;
      }
      _jspx_tagPool_portlet_resourceURL_var.reuse(_jspx_th_portlet_resourceURL_2);
      java.lang.String ProjectDocumentResourceURL = null;
      ProjectDocumentResourceURL = (java.lang.String) _jspx_page_context.findAttribute("ProjectDocumentResourceURL");
      out.write("\r\n");
      out.write("\t\t\t\t    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ProjectDocumentResourceURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"Document\" />");
      out.print( documentObj.getDOCUMENT_NAME() );
      out.write("</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t  \t");
 } 
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" </div><br>\r\n");
      out.write(" <div>\r\n");
      out.write("<p class=\"bank-account__title voffset-down2\">You can also do a bank transfer to the below mentioned account setup for this fundraising campaign:</p>\r\n");
      out.write("\t<p>Account number: 8080811062668</p>\r\n");
      out.write("\t<p>Account name: Nagarjan</p>\r\n");
      out.write("\t<p>IFSC code: YESB0CMSNOC</p>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!--  campaign owner details -->\r\n");
      out.write("\r\n");
      out.write("<div class=\"campaign-owner-details campaign-section clearfix\">\r\n");
      out.write("<p>Posted By : ");
      out.print( userData.getFullName() );
      out.write("</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"card-body-new\">\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t    \t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<!-- AFTER DONATE OPTIONS -->\r\n");

long ProjectId = Long.parseLong(projectID);
//ThemeDisplay themeDisplayObj = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
List<FundRegistration> fundList = FundRegistrationLocalServiceUtil.findByPROJECT_DONOR_USER_ID(projectRegistration.getPROJECT_ID(), themeDisplayObj.getUserId());
if(fundList.size() > 0){

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_1 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_1.setParent(null);
      _jspx_th_portlet_renderURL_1.setVar("AskAQuestionURL");
      _jspx_th_portlet_renderURL_1.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_1 = _jspx_th_portlet_renderURL_1.doStartTag();
      if (_jspx_eval_portlet_renderURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_8 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_8.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
        _jspx_th_portlet_param_8.setName("projectId");
        _jspx_th_portlet_param_8.setValue(String.valueOf(ProjectId) );
        int _jspx_eval_portlet_param_8 = _jspx_th_portlet_param_8.doStartTag();
        if (_jspx_th_portlet_param_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_portlet_param_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_1, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t");
      }
      if (_jspx_th_portlet_renderURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
      java.lang.String AskAQuestionURL = null;
      AskAQuestionURL = (java.lang.String) _jspx_page_context.findAttribute("AskAQuestionURL");
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_aui_button_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_2 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_2.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_2.setParent(null);
      _jspx_th_portlet_renderURL_2.setVar("FeedbackURL");
      _jspx_th_portlet_renderURL_2.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_2 = _jspx_th_portlet_renderURL_2.doStartTag();
      if (_jspx_eval_portlet_renderURL_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_10 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_10.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_2);
        _jspx_th_portlet_param_10.setName("projectId");
        _jspx_th_portlet_param_10.setValue(String.valueOf(ProjectId) );
        int _jspx_eval_portlet_param_10 = _jspx_th_portlet_param_10.doStartTag();
        if (_jspx_th_portlet_param_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_10);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_10);
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_portlet_param_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_2, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t");
      }
      if (_jspx_th_portlet_renderURL_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_2);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_2);
      java.lang.String FeedbackURL = null;
      FeedbackURL = (java.lang.String) _jspx_page_context.findAttribute("FeedbackURL");
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_aui_button_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_0.setParent(null);
      _jspx_th_portlet_actionURL_0.setName("updateRequestRegistration");
      _jspx_th_portlet_actionURL_0.setVar("updateRequestRegistrationURL");
      int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
      if (_jspx_eval_portlet_actionURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_12 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_12.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
        _jspx_th_portlet_param_12.setName("projectId");
        _jspx_th_portlet_param_12.setValue(String.valueOf(ProjectId) );
        int _jspx_eval_portlet_param_12 = _jspx_th_portlet_param_12.doStartTag();
        if (_jspx_th_portlet_param_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_12);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_12);
        out.write("\r\n");
        out.write("\t\t\t");
      }
      if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
      java.lang.String updateRequestRegistrationURL = null;
      updateRequestRegistrationURL = (java.lang.String) _jspx_page_context.findAttribute("updateRequestRegistrationURL");
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_aui_button_2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\r\n");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<!-- DONATE OPTION FOR USER -->\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");

//boolean signedIn = themeDisplayObj.isSignedIn();
String FundOtpId = renderRequest.getParameter("FundOtpId");
	if(signedIn == false){

      out.write("\r\n");
      out.write("\t\t\t\t");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_3 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_3.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_3.setParent(null);
      _jspx_th_portlet_renderURL_3.setVar("DonateRegistrationURL");
      _jspx_th_portlet_renderURL_3.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_3 = _jspx_th_portlet_renderURL_3.doStartTag();
      if (_jspx_eval_portlet_renderURL_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_13 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_13.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_3);
        _jspx_th_portlet_param_13.setName("ProjectId");
        _jspx_th_portlet_param_13.setValue(String.valueOf(ProjectId) );
        int _jspx_eval_portlet_param_13 = _jspx_th_portlet_param_13.doStartTag();
        if (_jspx_th_portlet_param_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_13);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_13);
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_portlet_param_14((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_3, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t\t");
      }
      if (_jspx_th_portlet_renderURL_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_3);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_3);
      java.lang.String DonateRegistrationURL = null;
      DonateRegistrationURL = (java.lang.String) _jspx_page_context.findAttribute("DonateRegistrationURL");
      out.write("\r\n");
      out.write("\t\t\t\t");
if(donatedAmount <= projectRegistration.getREQUIRED_FUND_AMOUNT()){
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_aui_button_3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t");
 }  if(donatedAmount >= projectRegistration.getREQUIRED_FUND_AMOUNT()){
      out.write("\r\n");
      out.write("\t      \t\t  \t\t<img alt=\"Thank You Img\" src=\"/portal_content/Thank-You-with-Hands.jpg\" style=\"width: 233px;margin-top: 42px;margin-left: 63px;\">\r\n");
      out.write("\t      \t\t  ");
 } 
      out.write("\r\n");
      out.write("\t      \t\t  \r\n");
      out.write("\t\t");
}else{ 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_1 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name_nobody.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_1.setParent(null);
      _jspx_th_portlet_actionURL_1.setName("donationAmount");
      _jspx_th_portlet_actionURL_1.setVar("donationAmountURL");
      int _jspx_eval_portlet_actionURL_1 = _jspx_th_portlet_actionURL_1.doStartTag();
      if (_jspx_th_portlet_actionURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_1);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_1);
      java.lang.String donationAmountURL = null;
      donationAmountURL = (java.lang.String) _jspx_page_context.findAttribute("donationAmountURL");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${donationAmountURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" method=\"post\" >\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t          <input name=\"");
      if (_jspx_meth_portlet_namespace_0(_jspx_page_context))
        return;
      out.write("projectId\" type=\"hidden\" value=\"");
      out.print( projectID );
      out.write("\">\r\n");
      out.write("\t\t\t          <input  name=\"");
      if (_jspx_meth_portlet_namespace_1(_jspx_page_context))
        return;
      out.write("FundOtpId\" type=\"hidden\" value=\"");
      out.print( FundOtpId );
      out.write("\">\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t            ");
if(signedIn == true){
			            	if(donatedAmount <= projectRegistration.getREQUIRED_FUND_AMOUNT()){
      out.write("\r\n");
      out.write("\t\t\t\t           \t\t ");
      if (_jspx_meth_aui_input_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t            ");
 } 
			            		}if(donatedAmount <= projectRegistration.getREQUIRED_FUND_AMOUNT()){ 
      out.write("\r\n");
      out.write("\t\t\t\t            <br>\r\n");
      out.write("\t\t\t\t            <div class=\"row\" style=\"margin-left: .1em;\">\r\n");
      out.write("\t\t\t              \t\t<select class=\"form-control\" name=\"");
      if (_jspx_meth_portlet_namespace_2(_jspx_page_context))
        return;
      out.write("currency\" style=\"padding-right:0; padding-left:12px; width:6em; \">\r\n");
      out.write("\t\t\t                            <option value=\"USD\">USD $</option>\r\n");
      out.write("\t\t\t                            <option selected value=\"INR\">INR &#8377;</option>\r\n");
      out.write("\t\t\t                    </select>\r\n");
      out.write("\t\t\t                        \r\n");
      out.write("\t\t\t              \t\t&nbsp<input name=\"");
      if (_jspx_meth_portlet_namespace_3(_jspx_page_context))
        return;
      out.write("amount\" type=\"text\" class=\"form-control manual-payment payment-amt\"  style=\"width:179px;\"> \r\n");
      out.write("\t\t\t\t            </div>\r\n");
      out.write("\t\t\t\t            <br>\r\n");
      out.write("\t\t\t\t            ");
      if (_jspx_meth_aui_input_1(_jspx_page_context))
        return;
      out.write("<br>\r\n");
      out.write("\t\t\t\t            <input type=\"submit\" name=\"commit\" value=\"Donate now\" style=\"width: 45%;margin-left: 10em\" class=\"btn btn-primary btn-block text-bold btn-success\" >\r\n");
      out.write("\t\t      \t\t  ");
 } if(donatedAmount >= projectRegistration.getREQUIRED_FUND_AMOUNT()){
      out.write("\r\n");
      out.write("\t\t      \t\t  \t\t<img alt=\"Thank You Img\" src=\"/portal_content/Thank-You-with-Hands.jpg\" style=\"width: 233px;margin-top: 42px;margin-left: 63px;\">\r\n");
      out.write("\t\t      \t\t  ");
 } 
      out.write("\r\n");
      out.write("\t\t      </form>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--  CAMPAIGN UPDATE TAB -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"Update\" class=\"tabcontent\">\r\n");
 
List<ProjectUpdateRegistration> projectUpdateList = ProjectUpdateRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
int counter = 1;
for(ProjectUpdateRegistration projectUpdateObj : projectUpdateList){

      out.write("\r\n");
      out.write("<div class=\"container1 darker\" style=\"width: 722px; background-color: whitesmoke;\">\r\n");
      out.write("\t<p>");
      out.print( projectUpdateObj.getUPDATE_DETAILS() );
      out.write("</p>\r\n");
      out.write(" \t <span class=\"time-left\">");
      out.print( projectUpdateObj.getUPDATE_DATE() );
      out.write("</span>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<hr>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- side column start -->\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"col-md-4\" style=\"border-left: 1px solid #5d5d5d; solid\" >\r\n");
      out.write("\t<h4 style=\"color: #5d5d5d;\">Donate</h4>\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\r\n");
      out.write("              <br>\r\n");
      out.write("  <p class=\"payment-options\" data-for-currency=\"inr\" style=\"margin-left: 3em;\" >Payment options: Online, cheque pickups</p>\r\n");
      out.write("  <div class=\"seperater col-sm-12 text-center\"><span></span>OR<span></span></div>\r\n");
      out.write("  <img style=\"margin-left:1.5em;\" src=\"/portal_content/c.png\">\r\n");
      out.write("  <br><br>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  <div> <p style=\"color: #E91E63;margin-left: 5.1em;font-size: 21px;\"> RS.");
      out.print( String.format("%.0f",donatedAmount) );
      out.write(" Raised</p></div>\r\n");
      out.write("  <div class=\"progress-bar1\" data-percent=\"");
      out.print( Math.floor(donatedAmountInPercentage) );
      out.write("\" data-duration=\"1000\" data-color=\"#ccc,#b91141\"></div>\r\n");
      out.write("  <br>\r\n");
      out.write("  <div> <p style=\"color:#5d5d5d; margin-left: 1em; \" >Raised From Total Goal of INR. ");
      out.print( String.format("%.0f",projectRegistration.getREQUIRED_FUND_AMOUNT())  );
      out.write("</p></div>\r\n");
      out.write("  <br><hr>\r\n");
      out.write("  <h5 style=\"color: #0077A2;\"><i class=\"fa fa-group\" style=\"color:#0077A2; font-size: 25px;\"></i>&nbsp&nbspCampaign Supporters</h5><hr>\r\n");
      out.write("\t\t\t\t");

					String donorName = null;
					List<FundRegistration> donatedFundList = FundRegistrationLocalServiceUtil.findByPROJECT_ID(projectRegistration.getPROJECT_ID());
					
					for(FundRegistration fundObj : donatedFundList){
						if(fundObj.getDONOR_STATUS() == 0){
							donorName = "Anonymous Donor";
						}else{
							if(fundObj.getDONOR_USER_ID() == 0){
								DonorRegistration donorObj = DonorRegistrationLocalServiceUtil.findByDONOR_ID(fundObj.getDONOR_ID());
								donorName = donorObj.getNAME();
							}else{
								UserRegistration userObj = UserRegistrationLocalServiceUtil.findByUSER_ID(fundObj.getDONOR_USER_ID());
								donorName = userObj.getFULL_NAME();
							}
						} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"paginationList list-group\">   \r\n");
      out.write("\t\t\t\t\t <li class=\"listItem list-group-item\" style=\"border: none;\">\t<label style=\"color: #01bfbd\" >");
      out.print( donorName );
      out.write("</label> has donated <i class=\"fa fa-inr\" style=\"color:#b91141 \"></i> <label style=\"color:#b91141 \">");
      out.print(  String.format("%.0f",fundObj.getDONATED_AMOUNT()) );
      out.write(" &#8377; </label><br>\r\n");
      out.write("\t\t\t\t\t\t<label style=\"font-size: small;\">");
      out.print( fundObj.getCOMMENT() );
      out.write("</label><hr style=\"width: 65%\"></li> </ul>\r\n");
      out.write("\t\t\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t<div style=\"margin-left: 6em;\" id=\"pagination-container1\"> \r\n");
      out.write("\t\t\t\t <p class='paginacaoCursor' id=\"beforePagination\"><</p>\r\n");
      out.write("            <p class='paginacaoCursor' id=\"afterPagination\">></p> </div>    \r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<!--------JS------- -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- script for circular progress bar -->\r\n");
      out.write("\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.3.1.min.js\" integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write(";\r\n");
      out.write("(function ($) {\r\n");
      out.write("\t$.fn.loading = function () {\r\n");
      out.write("\t\tvar DEFAULTS = {\r\n");
      out.write("\t\t\tbackgroundColor: '#b3cef6',\r\n");
      out.write("\t\t\tprogressColor: '#4b86db',\r\n");
      out.write("\t\t\tpercent: 75,\r\n");
      out.write("\t\t\tduration: 2000\r\n");
      out.write("\t\t};\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(this).each(function () {\r\n");
      out.write("\t\t\tvar $target  = $(this);\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar opts = {\r\n");
      out.write("\t\t\tbackgroundColor: $target.data('color') ? $target.data('color').split(',')[0] : DEFAULTS.backgroundColor,\r\n");
      out.write("\t\t\tprogressColor: $target.data('color') ? $target.data('color').split(',')[1] : DEFAULTS.progressColor,\r\n");
      out.write("\t\t\tpercent: $target.data('percent') ? $target.data('percent') : DEFAULTS.percent,\r\n");
      out.write("\t\t\tduration: $target.data('duration') ? $target.data('duration') : DEFAULTS.duration\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t// console.log(opts);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t$target.append('<div class=\"background\"></div><div class=\"rotate\"></div><div class=\"left\"></div><div class=\"right\"></div><div class=\"\"><span>' + opts.percent + '%</span></div>');\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t$target.find('.background').css('background-color', opts.backgroundColor);\r\n");
      out.write("\t\t\t$target.find('.left').css('background-color', opts.backgroundColor);\r\n");
      out.write("\t\t\t$target.find('.rotate').css('background-color', opts.progressColor);\r\n");
      out.write("\t\t\t$target.find('.right').css('background-color', opts.progressColor);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tvar $rotate = $target.find('.rotate');\r\n");
      out.write("\t\t\tsetTimeout(function () {\t\r\n");
      out.write("\t\t\t\t$rotate.css({\r\n");
      out.write("\t\t\t\t\t'transition': 'transform ' + opts.duration + 'ms linear',\r\n");
      out.write("\t\t\t\t\t'transform': 'rotate(' + opts.percent * 3.6 + 'deg)'\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t},1);\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (opts.percent > 50) {\r\n");
      out.write("\t\t\t\tvar animationRight = 'toggle ' + (opts.duration / opts.percent * 50) + 'ms step-end';\r\n");
      out.write("\t\t\t\tvar animationLeft = 'toggle ' + (opts.duration / opts.percent * 50) + 'ms step-start';  \r\n");
      out.write("\t\t\t\t$target.find('.right').css({\r\n");
      out.write("\t\t\t\t\tanimation: animationRight,\r\n");
      out.write("\t\t\t\t\topacity: 1\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$target.find('.left').css({\r\n");
      out.write("\t\t\t\t\tanimation: animationLeft,\r\n");
      out.write("\t\t\t\t\topacity: 0\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("})(jQuery);\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(\".progress-bar1\").loading();\r\n");
      out.write("     \r\n");
      out.write("</script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- script for tab  -->\r\n");
      out.write("<script>\r\n");
      out.write("function openCity(evt, cityName) {\r\n");
      out.write("  var i, tabcontent, tablinks;\r\n");
      out.write("  tabcontent = document.getElementsByClassName(\"tabcontent\");\r\n");
      out.write("  for (i = 0; i < tabcontent.length; i++) {\r\n");
      out.write("    tabcontent[i].style.display = \"none\";\r\n");
      out.write("  }\r\n");
      out.write("  tablinks = document.getElementsByClassName(\"tablinks\");\r\n");
      out.write("  for (i = 0; i < tablinks.length; i++) {\r\n");
      out.write("    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\r\n");
      out.write("  }\r\n");
      out.write("  document.getElementById(cityName).style.display = \"block\";\r\n");
      out.write("  evt.currentTarget.className += \" active\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- script for carousel -->\r\n");
      out.write("<script>\r\n");
      out.write("var slideIndex = 0;\r\n");
      out.write("carousel();\r\n");
      out.write("\r\n");
      out.write("function carousel() {\r\n");
      out.write("  var i;\r\n");
      out.write("  var x = document.getElementsByClassName(\"mySlides\");\r\n");
      out.write("  for (i = 0; i < x.length; i++) {\r\n");
      out.write("    x[i].style.display = \"none\"; \r\n");
      out.write("  }\r\n");
      out.write("  slideIndex++;\r\n");
      out.write("  if (slideIndex > x.length) {slideIndex = 1} \r\n");
      out.write("  x[slideIndex-1].style.display = \"block\"; \r\n");
      out.write("  setTimeout(carousel, 5000); \r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write(" <div id=\"fb-root\"></div>\r\n");
      out.write(" \t\t\t\t\t\t\t\t\t\t\t\t<!-- script for fb -->\r\n");
      out.write("<script>(function(d, s, id) {\r\n");
      out.write("  var js, fjs = d.getElementsByTagName(s)[0];\r\n");
      out.write("  if (d.getElementById(id)) return;\r\n");
      out.write("  js = d.createElement(s); js.id = id;\r\n");
      out.write("  js.src = 'https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v3.2&appId=1990258291089302&autoLogAppEvents=1';\r\n");
      out.write("  fjs.parentNode.insertBefore(js, fjs);\r\n");
      out.write("}(document, 'script', 'facebook-jssdk'));\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<!-- Script for pagination -->\r\n");
      out.write("<script>\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\r\n");
      out.write("\t  var HZperPage = 3,//number of results per page\r\n");
      out.write("\t     HZwrapper = 'paginationList',//wrapper class\r\n");
      out.write("\t     HZlines   = 'listItem',//items class\r\n");
      out.write("\t     HZpaginationId ='pagination-container1',//id of pagination container\r\n");
      out.write("\t     HZpaginationArrowsClass = 'paginacaoCursor',//set the class of pagi\r\n");
      out.write("\t     HZpaginationColorDefault =  '#b91141',//default color for the pagination numbers\r\n");
      out.write("\t     HZpaginationColorActive = '#01bfbd', //color when page is clicked\r\n");
      out.write("\t     HZpaginationCustomClass = 'customPagination'; //custom class for styling the pagination (css)\r\n");
      out.write("\r\n");
      out.write("\t  function paginationShow(){if($(\"#\"+HZpaginationId).children().length>8){var a=$(\".activePagination\").attr(\"data-valor\");if(a>=4){var i=parseInt(a)-3,o=parseInt(a)+2;$(\".paginacaoValor\").hide(),exibir2=$(\".paginacaoValor\").slice(i,o).show()}else $(\".paginacaoValor\").hide(),exibir2=$(\".paginacaoValor\").slice(0,5).show()}}paginationShow(),$(\"#beforePagination\").hide(),$(\".\"+HZlines).hide();for(var tamanhotabela=$(\".\"+HZwrapper).children().length,porPagina=HZperPage,paginas=Math.ceil(tamanhotabela/porPagina),i=1;i<=paginas;)$(\"#\"+HZpaginationId).append(\"<p class='paginacaoValor \"+HZpaginationCustomClass+\"' data-valor=\"+i+\">\"+i+\"</p>\"),i++,$(\".paginacaoValor\").hide(),exibir2=$(\".paginacaoValor\").slice(0,5).show();$(\".paginacaoValor:eq(0)\").css(\"background\",\"\"+HZpaginationColorActive).addClass(\"activePagination\");var exibir=$(\".\"+HZlines).slice(0,porPagina).show();$(\".paginacaoValor\").on(\"click\",function(){$(\".paginacaoValor\").css(\"background\",\"\"+HZpaginationColorDefault).removeClass(\"activePagination\"),$(this).css(\"background\",\"\"+HZpaginationColorActive).addClass(\"activePagination\");var a=$(this).attr(\"data-valor\"),i=a*porPagina,o=i-porPagina;$(\".\"+HZlines).hide(),exibir=$(\".\"+HZlines).slice(o,i).show(),\"1\"===a?$(\"#beforePagination\").hide():$(\"#beforePagination\").show(),a===\"\"+$(\".paginacaoValor:last\").attr(\"data-valor\")?$(\"#afterPagination\").hide():$(\"#afterPagination\").show(),paginationShow()}),$(\".paginacaoValor\").last().after($(\"#afterPagination\")),$(\"#beforePagination\").on(\"click\",function(){var a=$(\".activePagination\").attr(\"data-valor\"),i=parseInt(a)-1;$(\"[data-valor=\"+i+\"]\").click(),paginationShow()}),$(\"#afterPagination\").on(\"click\",function(){var a=$(\".activePagination\").attr(\"data-valor\"),i=parseInt(a)+1;$(\"[data-valor=\"+i+\"]\").click(),paginationShow()}),$(\".paginacaoValor\").css(\"float\",\"left\"),$(\".\"+HZpaginationArrowsClass).css(\"float\",\"left\");\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- ---------End of JS------------ -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<!-- CAMPAIGN COMMENT -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- CAMPAIGN FOLLOWER -->\r\n");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_2 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name_nobody.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_2.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_2.setParent(null);
      _jspx_th_portlet_actionURL_2.setName("projectFollowerRegistration");
      _jspx_th_portlet_actionURL_2.setVar("projectFollowerRegistrationURL");
      int _jspx_eval_portlet_actionURL_2 = _jspx_th_portlet_actionURL_2.doStartTag();
      if (_jspx_th_portlet_actionURL_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_2);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_2);
      java.lang.String projectFollowerRegistrationURL = null;
      projectFollowerRegistrationURL = (java.lang.String) _jspx_page_context.findAttribute("projectFollowerRegistrationURL");
      out.write("\t\t\t\t\t\r\n");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_3 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name_nobody.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_3.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_3.setParent(null);
      _jspx_th_portlet_actionURL_3.setName("projectUnFollowRegistration");
      _jspx_th_portlet_actionURL_3.setVar("projectUnFollowRegistrationURL");
      int _jspx_eval_portlet_actionURL_3 = _jspx_th_portlet_actionURL_3.doStartTag();
      if (_jspx_th_portlet_actionURL_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_3);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_3);
      java.lang.String projectUnFollowRegistrationURL = null;
      projectUnFollowRegistrationURL = (java.lang.String) _jspx_page_context.findAttribute("projectUnFollowRegistrationURL");
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");

if(signedIn == true){ 
List<ProjectFollowerRegistration> projectfollwerList = ProjectFollowerRegistrationLocalServiceUtil.findByPROJECT_ID(ProjectId);
boolean userFollowerStatus = false;

		for(ProjectFollowerRegistration followerObj : projectfollwerList){
			if(followerObj.getUSER_ID() == themeDisplayObj.getUserId() && followerObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.CAMPAIGN_FOLLOWER_STATUS_1 )
				userFollowerStatus = true;
		}
		
			if(userFollowerStatus == false){ 
      out.write("\r\n");
      out.write("\t\t\t\t");
      //  aui:form
      com.liferay.taglib.aui.FormTag _jspx_th_aui_form_0 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_method_action.get(com.liferay.taglib.aui.FormTag.class);
      _jspx_th_aui_form_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_form_0.setParent(null);
      _jspx_th_aui_form_0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectFollowerRegistrationURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      _jspx_th_aui_form_0.setMethod("post");
      int _jspx_eval_aui_form_0 = _jspx_th_aui_form_0.doStartTag();
      if (_jspx_eval_aui_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_2.setName("projectId");
        _jspx_th_aui_input_2.setType("hidden");
        _jspx_th_aui_input_2.setValue( projectID );
        int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
        if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_2);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_2);
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        if (_jspx_meth_aui_button_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t\t");
      }
      if (_jspx_th_aui_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_form_method_action.reuse(_jspx_th_aui_form_0);
        return;
      }
      _jspx_tagPool_aui_form_method_action.reuse(_jspx_th_aui_form_0);
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\t\t");
 }else{
      out.write("\r\n");
      out.write("\t\t\t\t");
      //  aui:form
      com.liferay.taglib.aui.FormTag _jspx_th_aui_form_1 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_method_action.get(com.liferay.taglib.aui.FormTag.class);
      _jspx_th_aui_form_1.setPageContext(_jspx_page_context);
      _jspx_th_aui_form_1.setParent(null);
      _jspx_th_aui_form_1.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${projectUnFollowRegistrationURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      _jspx_th_aui_form_1.setMethod("post");
      int _jspx_eval_aui_form_1 = _jspx_th_aui_form_1.doStartTag();
      if (_jspx_eval_aui_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_1);
        _jspx_th_aui_input_3.setName("projectId");
        _jspx_th_aui_input_3.setType("hidden");
        _jspx_th_aui_input_3.setValue( projectID );
        int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
        if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_3);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_3);
        out.write("\r\n");
        out.write("\t\t\t\t\t\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_4 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_4.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_1);
        _jspx_th_aui_input_4.setName("userId");
        _jspx_th_aui_input_4.setType("hidden");
        _jspx_th_aui_input_4.setValue( themeDisplayObj.getUserId() );
        int _jspx_eval_aui_input_4 = _jspx_th_aui_input_4.doStartTag();
        if (_jspx_th_aui_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_4);
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_aui_button_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_1, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t\t");
      }
      if (_jspx_th_aui_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_form_method_action.reuse(_jspx_th_aui_form_1);
        return;
      }
      _jspx_tagPool_aui_form_method_action.reuse(_jspx_th_aui_form_1);
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("\t\t");
 		
			}
		} 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"footer\" style=\"background-color:#002a3a;\"><!--start of footer-->\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("<div class=\"column\" style=\"font-size:1.2vw;color:white\">\r\n");
      out.write("<a href=\"about_us.html\" style=\"color:white;\">About</a><br />\r\n");
      out.write("<a href=\"about_us.html\" style=\"color:white;\">Overview</a><br />\r\n");
      out.write("<a href=\"about_us.html\" style=\"color:white;\">Team</a><br />\r\n");
      out.write("<a href=\"PrivacyPolicy.html\" style=\"color:white;\">Privacy Policy</a><br />\r\n");
      out.write("<a href=\"Disclaimer.html\" style=\"color:white;\">Terms &amp; Conditions</a></div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"column\" style=\"font-size:1.2vw;color:white\">\r\n");
      out.write("<a href=\"Security.html\" style=\"color:white;\">Security</a><br />\r\n");
      out.write("<a href=\"#\" style=\"color:white;\">Fundraising Tips</a><br />\r\n");
      out.write("<a href=\"#\" style=\"color:white;\">Pricing</a><br />\r\n");
      out.write("<a href=\"#\" style=\"color:white;\">Fundraising FAQ's</a><br />\r\n");
      out.write("<a href=\"#\" style=\"color:white;\">Donate Now</a></div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"column\" style=\"font-size:1.2vw;color:white\"><a href=\"#\" style=\"color:white;\">Start a Fundraiser</a><br />\r\n");
      out.write("<a href=\"#\" style=\"color:white;\">ADDRESS</a><br />\r\n");
      out.write("&nbsp;\r\n");
      out.write("<p class=\"addressp\" style=\"line-height:1px;font-size:1vw;\">184 &amp; 185, EPIP Zone,</p>\r\n");
      out.write("\r\n");
      out.write("<p class=\"addressp\" style=\"line-height:1px;font-size:1vw;\">Whitefield, Bengaluru,</p>\r\n");
      out.write("\r\n");
      out.write("<p class=\"addressp\" style=\"line-height:1px;font-size:1vw;\">Karnataka 560066</p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"column\" style=\"font-size:1.2vw;color:white\"><a href=\"#\" style=\"color:white;\">CONTACT US</a><br />\r\n");
      out.write("&nbsp;\r\n");
      out.write("<p class=\"addressp\" style=\"line-height:1px;font-size:1vw;\">Phone: 080818 80033</p>\r\n");
      out.write("\r\n");
      out.write("<p class=\"addressp\" style=\"line-height:1px;font-size:1vw;\">quickdaan@gmail.com</p>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\t\r\n");
      out.write("</body></html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_portlet_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
    _jspx_th_portlet_param_1.setName("jspPage");
    _jspx_th_portlet_param_1.setValue("/jsp/HomePage/CategoryList.jsp");
    int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
    if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
    return false;
  }

  private boolean _jspx_meth_portlet_param_2(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_resourceURL_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_2 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_0);
    _jspx_th_portlet_param_2.setName("serverResourceCall");
    _jspx_th_portlet_param_2.setValue("ProjectIDForProjectImage");
    int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
    if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
    return false;
  }

  private boolean _jspx_meth_portlet_param_4(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_resourceURL_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_4 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_1);
    _jspx_th_portlet_param_4.setName("serverResourceCall");
    _jspx_th_portlet_param_4.setValue("ProjectIDForProjectVideo");
    int _jspx_eval_portlet_param_4 = _jspx_th_portlet_param_4.doStartTag();
    if (_jspx_th_portlet_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
    return false;
  }

  private boolean _jspx_meth_portlet_param_6(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_resourceURL_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_6 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_6.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_resourceURL_2);
    _jspx_th_portlet_param_6.setName("serverResourceCall");
    _jspx_th_portlet_param_6.setValue("ProjectIDForDocument");
    int _jspx_eval_portlet_param_6 = _jspx_th_portlet_param_6.doStartTag();
    if (_jspx_th_portlet_param_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
    return false;
  }

  private boolean _jspx_meth_portlet_param_9(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_9 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_9.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
    _jspx_th_portlet_param_9.setName("jspPage");
    _jspx_th_portlet_param_9.setValue("/jsp/post_donations/Q&A/AskQuestion.jsp");
    int _jspx_eval_portlet_param_9 = _jspx_th_portlet_param_9.doStartTag();
    if (_jspx_th_portlet_param_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_9);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_9);
    return false;
  }

  private boolean _jspx_meth_aui_button_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_0.setParent(null);
    _jspx_th_aui_button_0.setType("button");
    _jspx_th_aui_button_0.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${AskAQuestionURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_0.setValue("Ask Question?");
    int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
    if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_0);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_0);
    return false;
  }

  private boolean _jspx_meth_portlet_param_11(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_11 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_11.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_2);
    _jspx_th_portlet_param_11.setName("jspPage");
    _jspx_th_portlet_param_11.setValue("/jsp/post_donations/feedback/Feedback.jsp");
    int _jspx_eval_portlet_param_11 = _jspx_th_portlet_param_11.doStartTag();
    if (_jspx_th_portlet_param_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_11);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_11);
    return false;
  }

  private boolean _jspx_meth_aui_button_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_1.setParent(null);
    _jspx_th_aui_button_1.setType("button");
    _jspx_th_aui_button_1.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${FeedbackURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_1.setValue("Feedback");
    int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
    if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_1);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_1);
    return false;
  }

  private boolean _jspx_meth_aui_button_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_2 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_2.setParent(null);
    _jspx_th_aui_button_2.setType("button");
    _jspx_th_aui_button_2.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${updateRequestRegistrationURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_2.setValue("Ask for an Update");
    int _jspx_eval_aui_button_2 = _jspx_th_aui_button_2.doStartTag();
    if (_jspx_th_aui_button_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_2);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_2);
    return false;
  }

  private boolean _jspx_meth_portlet_param_14(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_14 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_14.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_3);
    _jspx_th_portlet_param_14.setName("jspPage");
    _jspx_th_portlet_param_14.setValue("/jsp/payment/DonorRegistrationForm.jsp");
    int _jspx_eval_portlet_param_14 = _jspx_th_portlet_param_14.doStartTag();
    if (_jspx_th_portlet_param_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_14);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_14);
    return false;
  }

  private boolean _jspx_meth_aui_button_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_3 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_3.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_3.setParent(null);
    _jspx_th_aui_button_3.setType("button");
    _jspx_th_aui_button_3.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${DonateRegistrationURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_3.setValue("I Want to Contribute");
    int _jspx_eval_aui_button_3 = _jspx_th_aui_button_3.doStartTag();
    if (_jspx_th_aui_button_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_3);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_onClick_nobody.reuse(_jspx_th_aui_button_3);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_0 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_0.setParent(null);
    int _jspx_eval_portlet_namespace_0 = _jspx_th_portlet_namespace_0.doStartTag();
    if (_jspx_th_portlet_namespace_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_1 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_1.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_1.setParent(null);
    int _jspx_eval_portlet_namespace_1 = _jspx_th_portlet_namespace_1.doStartTag();
    if (_jspx_th_portlet_namespace_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_1);
    return false;
  }

  private boolean _jspx_meth_aui_input_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_0.setParent(null);
    _jspx_th_aui_input_0.setLabel("Donate Anonymously");
    _jspx_th_aui_input_0.setName("donateAnonymously");
    _jspx_th_aui_input_0.setType("radio");
    _jspx_th_aui_input_0.setValue(new String("Yes"));
    int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
    if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_0);
      return true;
    }
    _jspx_tagPool_aui_input_value_type_name_label_nobody.reuse(_jspx_th_aui_input_0);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_2 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_2.setParent(null);
    int _jspx_eval_portlet_namespace_2 = _jspx_th_portlet_namespace_2.doStartTag();
    if (_jspx_th_portlet_namespace_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_2);
    return false;
  }

  private boolean _jspx_meth_portlet_namespace_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:namespace
    com.liferay.taglib.portlet.NamespaceTag _jspx_th_portlet_namespace_3 = (com.liferay.taglib.portlet.NamespaceTag) _jspx_tagPool_portlet_namespace_nobody.get(com.liferay.taglib.portlet.NamespaceTag.class);
    _jspx_th_portlet_namespace_3.setPageContext(_jspx_page_context);
    _jspx_th_portlet_namespace_3.setParent(null);
    int _jspx_eval_portlet_namespace_3 = _jspx_th_portlet_namespace_3.doStartTag();
    if (_jspx_th_portlet_namespace_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
      return true;
    }
    _jspx_tagPool_portlet_namespace_nobody.reuse(_jspx_th_portlet_namespace_3);
    return false;
  }

  private boolean _jspx_meth_aui_input_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_name_label_nobody.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_1.setParent(null);
    _jspx_th_aui_input_1.setName("message");
    _jspx_th_aui_input_1.setLabel("Message for Benificiary");
    int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
    if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_name_label_nobody.reuse(_jspx_th_aui_input_1);
      return true;
    }
    _jspx_tagPool_aui_input_name_label_nobody.reuse(_jspx_th_aui_input_1);
    return false;
  }

  private boolean _jspx_meth_aui_button_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_4 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_name_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_4.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_button_4.setName("submit");
    _jspx_th_aui_button_4.setType("submit");
    _jspx_th_aui_button_4.setValue("Follow Campaign");
    int _jspx_eval_aui_button_4 = _jspx_th_aui_button_4.doStartTag();
    if (_jspx_th_aui_button_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_name_nobody.reuse(_jspx_th_aui_button_4);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_name_nobody.reuse(_jspx_th_aui_button_4);
    return false;
  }

  private boolean _jspx_meth_aui_button_5(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_5 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_name_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_5.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_1);
    _jspx_th_aui_button_5.setName("submit");
    _jspx_th_aui_button_5.setType("submit");
    _jspx_th_aui_button_5.setValue("Unfollow Campaign");
    int _jspx_eval_aui_button_5 = _jspx_th_aui_button_5.doStartTag();
    if (_jspx_th_aui_button_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_name_nobody.reuse(_jspx_th_aui_button_5);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_name_nobody.reuse(_jspx_th_aui_button_5);
    return false;
  }
}
