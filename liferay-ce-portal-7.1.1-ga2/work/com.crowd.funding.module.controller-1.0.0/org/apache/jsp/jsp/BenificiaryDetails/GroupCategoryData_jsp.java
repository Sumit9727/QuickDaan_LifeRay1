package org.apache.jsp.jsp.BenificiaryDetails;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.CategoryRegistration;

public final class GroupCategoryData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(7);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/META-INF/c.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet_2_0.tld");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet-ext.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_type_style_onchange_name_label_accept;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_validator_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_name_maxlength_label_id_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_title_pattern_onkeypress_name_minlength_maxlength_label_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_name_maxlength_label_cssClass;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_validator_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_renderURL_windowState_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_style_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_form_method_enctype_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_type_style_onClick_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_input_type_style_onchange_name_label_accept = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_validator_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_name_maxlength_label_id_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_title_pattern_onkeypress_name_minlength_maxlength_label_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_name_maxlength_label_cssClass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_validator_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_renderURL_windowState_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_style_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_actionURL_var_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_form_method_enctype_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_input_type_style_onchange_name_label_accept.release();
    _jspx_tagPool_aui_validator_name_nobody.release();
    _jspx_tagPool_aui_input_name_maxlength_label_id_cssClass.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.release();
    _jspx_tagPool_aui_input_title_pattern_onkeypress_name_minlength_maxlength_label_cssClass.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_aui_input_name_maxlength_label_cssClass.release();
    _jspx_tagPool_aui_validator_name.release();
    _jspx_tagPool_portlet_renderURL_windowState_var.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_button_value_type_style_nobody.release();
    _jspx_tagPool_portlet_actionURL_var_name_nobody.release();
    _jspx_tagPool_aui_form_method_enctype_action.release();
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody.release();
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
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-1.10.2.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.10.4/jquery-ui.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css\">\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
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
      out.write(" <style>\r\n");
      out.write(".bordercity{\r\n");
      out.write(" background-clip: border-box;\r\n");
      out.write("\tborder-radius: 9px;\r\n");
      out.write("\tborder: 1px solid  6c757d9e;\r\n");
      out.write("\tborder-bottom: 1px solid #7FBD2C;\r\n");
      out.write("\tbackground-color:#e7e7ed;\r\n");
      out.write("\theight: 43px;\r\n");
      out.write("\twidth: 704px;  \r\n");
      out.write("\tmargin-top: 1px;\r\n");
      out.write("\theight: 43px;\r\n");
      out.write("    background-color: whitesmoke;\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("   /*  strong {\r\n");
      out.write("    color: #0077A2;\r\n");
      out.write("    font-size: 13px; */\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("   .portlet-decorate .portlet-content {\r\n");
      out.write("    background-color: #5d5d5d29;\r\n");
      out.write("    border: 1px solid #E7E7ED;\r\n");
      out.write("    border-radius: 0.5rem;\r\n");
      out.write("    padding: 24px;\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write("/* this is for nav bar  */\r\n");
      out.write(".topnav {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tbackground-color: #0077A2;\r\n");
      out.write("\tborder-bottom: 5px solid white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".topnav a {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tcolor: #f2f2f2;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tpadding: 14px 25px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tfont-size: 1.2vw;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".topnav a:hover {\r\n");
      out.write("\tbackground-color: #ddd;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".topnav a.active {\r\n");
      out.write("\tbackground-color: #4CAF50;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".topnav {\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown1 {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown1 .dropbtn1 {\r\n");
      out.write("\tfont-size: 1.2vw;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tpadding: 14px 19px;\r\n");
      out.write("\tbackground-color: inherit;\r\n");
      out.write("\tfont-family: inherit;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-content1 {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbackground-color: #f9f9f9;\r\n");
      out.write("\tmin-width: 160px;\r\n");
      out.write("\tbox-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-content1 a {\r\n");
      out.write("\tfloat: none;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tpadding: 12px 16px;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-content1 a:hover {\r\n");
      out.write("\tbackground-color: #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown1:hover .dropdown-content1 {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#demo-2 input[type=search] {\r\n");
      out.write("\twidth: 15px;\r\n");
      out.write("\tpadding-left: 10px;\r\n");
      out.write("\tcolor: transparent;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#demo-2 input[type=search]:hover {\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#demo-2 input[type=search]:focus {\r\n");
      out.write("\tpadding: 10px 30px;\r\n");
      out.write("\twidth: 130px;\r\n");
      out.write("\tpadding-left: 32px;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("\tcursor: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#demo-2 input:-moz-placeholder {\r\n");
      out.write("\tcolor: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#demo-2 input::-webkit-input-placeholder {\r\n");
      out.write("\tcolor: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=search] {\r\n");
      out.write("\t-webkit-appearance: textfield;\r\n");
      out.write("\t-webkit-box-sizing: content-box;\r\n");
      out.write("\tfont-family: inherit;\r\n");
      out.write("\tfont-size: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input::-webkit-search-decoration, input::-webkit-search-cancel-button {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=search] {\r\n");
      out.write("\tmargin-top: 2px;\r\n");
      out.write("\tbackground: #ededed\r\n");
      out.write("\t\turl(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png)\r\n");
      out.write("\t\tno-repeat 9px center;\r\n");
      out.write("\tborder-bottom: solid 1px #ccc;\r\n");
      out.write("\tborder-top: solid 1px #ccc;\r\n");
      out.write("\tborder-left: solid 1px #ccc;\r\n");
      out.write("\tborder-right: solid 1px #ccc;\r\n");
      out.write("\tpadding: 15px 0px 9px 0px;\r\n");
      out.write("\twidth: 43px;\r\n");
      out.write("\t-webkit-border-radius: 10em;\r\n");
      out.write("\t-moz-border-radius: 10em;\r\n");
      out.write("\tborder-radius: 10em;\r\n");
      out.write("\t-webkit-transition: all .5s;\r\n");
      out.write("\t-moz-transition: all .5s;\r\n");
      out.write("\ttransition: all .5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=search]:focus {\r\n");
      out.write("\tpadding: 10px 30px;\r\n");
      out.write("\twidth: 30%;\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("\tborder-color: #66CC75;\r\n");
      out.write("\t-webkit-box-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\t-moz-box-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("\tbox-shadow: 0 0 5px rgba(109, 207, 246, .5);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input:-moz-placeholder {\r\n");
      out.write("\tcolor: #999;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input::-webkit-input-placeholder {\r\n");
      out.write("\tcolor: #999;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*end of nav bar  */\r\n");
      out.write(".portlet-decorate .portlet-content {\r\n");
      out.write("    background-color: #FFF;\r\n");
      out.write("    border: 1px solid #E7E7ED;\r\n");
      out.write("    border-radius: 0.5rem;\r\n");
      out.write("     padding: 0px;\r\n");
      out.write("}\r\n");
      out.write(".control-menu-level-1 {\r\n");
      out.write("    background-color: #30313F;\r\n");
      out.write("    color: #869CAD;\r\n");
      out.write("    visibility: hidden;\r\n");
      out.write("}\r\n");
      out.write(".portlet-decorate .portlet {\r\n");
      out.write("    margin-bottom: 24px;\r\n");
      out.write("    margin-top: -74px;\r\n");
      out.write("}\r\n");
      out.write("/*code for footer*/\r\n");
      out.write(".column {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 25%;\r\n");
      out.write("\tpadding: 45px;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\ttext-align: justify;\r\n");
      out.write("\t/* Should be removed. Only for demonstration */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Clear floats after the columns */\r\n");
      out.write(".row:after {\r\n");
      out.write("\tcontent: \"\";\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("\tclear: both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".addressp {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tfont-size: 1.2vw;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*code for footer ends*/\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write(" $(document).ready(function(){\r\n");
      out.write("\t    $(\"#inputTextBox10\").keypress(function(event){\r\n");
      out.write("\t        var inputValue = event.which;\r\n");
      out.write("\t        // allow letters and whitespaces only.\r\n");
      out.write("\t        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { \r\n");
      out.write("\t            event.preventDefault(); \r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t});\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" $(document).ready(function(){\r\n");
      out.write("\t    $(\"#inputTextBox11\").keypress(function(event){\r\n");
      out.write("\t        var inputValue = event.which;\r\n");
      out.write("\t        // allow letters and whitespaces only.\r\n");
      out.write("\t        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { \r\n");
      out.write("\t            event.preventDefault(); \r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t});\r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" $(document).ready(function(){\r\n");
      out.write("\t    $(\"#inputTextBox12\").keypress(function(event){\r\n");
      out.write("\t        var inputValue = event.which;\r\n");
      out.write("\t        // allow letters and whitespaces only.\r\n");
      out.write("\t        if(!(inputValue >= 65 && inputValue <= 120) && (inputValue != 32 && inputValue != 0)) { \r\n");
      out.write("\t            event.preventDefault(); \r\n");
      out.write("\t        }\r\n");
      out.write("\t    });\r\n");
      out.write("\t});\r\n");
      out.write(" function readURL(input) {\r\n");
      out.write("\t    if (input.files && input.files[0]) {\r\n");
      out.write("\t        var reader = new FileReader();\r\n");
      out.write("\r\n");
      out.write("\t        reader.onload = function (e) {\r\n");
      out.write("\t            $('#blah')\r\n");
      out.write("\t                .attr('src', e.target.result)\r\n");
      out.write("\t                .width(150)\r\n");
      out.write("\t                .height(200);\r\n");
      out.write("\t        };\r\n");
      out.write("\r\n");
      out.write("\t        reader.readAsDataURL(input.files[0]);\r\n");
      out.write("\t    }\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("\t  $('#colors').click(function(){\r\n");
      out.write("\t    $('#' + $(this).val()).show();\r\n");
      out.write("\t  });\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_0 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_0.setParent(null);
      _jspx_th_portlet_renderURL_0.setVar("ViewImages");
      _jspx_th_portlet_renderURL_0.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_0 = _jspx_th_portlet_renderURL_0.doStartTag();
      if (_jspx_eval_portlet_renderURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t");
        if (_jspx_meth_portlet_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_0, _jspx_page_context))
          return;
        out.write('\r');
        out.write('\n');
      }
      if (_jspx_th_portlet_renderURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_0);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_0);
      java.lang.String ViewImages = null;
      ViewImages = (java.lang.String) _jspx_page_context.findAttribute("ViewImages");
      out.write("\r\n");
      out.write("\r\n");
      //  portlet:actionURL
      com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name_nobody.get(com.liferay.taglib.portlet.ActionURLTag.class);
      _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_actionURL_0.setParent(null);
      _jspx_th_portlet_actionURL_0.setName("BenificiaryRelationGroup");
      _jspx_th_portlet_actionURL_0.setVar("BenificiaryRelationURL");
      int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
      if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_0);
        return;
      }
      _jspx_tagPool_portlet_actionURL_var_name_nobody.reuse(_jspx_th_portlet_actionURL_0);
      java.lang.String BenificiaryRelationURL = null;
      BenificiaryRelationURL = (java.lang.String) _jspx_page_context.findAttribute("BenificiaryRelationURL");
      out.write('\r');
      out.write('\n');
      //  aui:form
      com.liferay.taglib.aui.FormTag _jspx_th_aui_form_0 = (com.liferay.taglib.aui.FormTag) _jspx_tagPool_aui_form_method_enctype_action.get(com.liferay.taglib.aui.FormTag.class);
      _jspx_th_aui_form_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_form_0.setParent(null);
      _jspx_th_aui_form_0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${BenificiaryRelationURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      _jspx_th_aui_form_0.setMethod("post");
      _jspx_th_aui_form_0.setDynamicAttribute(null, "enctype", new String("multipart/form-data"));
      int _jspx_eval_aui_form_0 = _jspx_th_aui_form_0.doStartTag();
      if (_jspx_eval_aui_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write('\r');
        out.write('\n');
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
        com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_1 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
        _jspx_th_portlet_renderURL_1.setPageContext(_jspx_page_context);
        _jspx_th_portlet_renderURL_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_portlet_renderURL_1.setVar("CategoryURL");
        _jspx_th_portlet_renderURL_1.setWindowState("normal");
        int _jspx_eval_portlet_renderURL_1 = _jspx_th_portlet_renderURL_1.doStartTag();
        if (_jspx_eval_portlet_renderURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          //  portlet:param
          com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
          _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
          _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
          _jspx_th_portlet_param_1.setName("CategoryId");
          _jspx_th_portlet_param_1.setValue( String.valueOf(categoryDetails.getCATEGORY_ID()) );
          int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
          if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
            return;
          }
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_portlet_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t");
        }
        if (_jspx_th_portlet_renderURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
          return;
        }
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
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
        out.write("\t\t\t<a href=\"/web/crowd-funding/fund-raise-request\">Start a Fundraisers</a> <a href=\"/web/quickdaan-home-page/home/#section4\">How it works</a> <a href=\"\">Find Fundraisers</a> <a href=\"/web/crowd-funding/campaigns\">Donate now</a>\r\n");
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
        out.write("\t");
 String Group = renderRequest.getParameter("Group"); 
        out.write("\r\n");
        out.write("\t\r\n");
        out.write("\t");
        out.write("\r\n");
        out.write("\t");

	if(Group.equalsIgnoreCase("FriendGroup")){
	
        out.write("\r\n");
        out.write("\t<div>\r\n");
        out.write("     <div class =\"GroupFriend\">\r\n");
        out.write("\t\t<h1>Group Friend</h1>\r\n");
        out.write("\t");

	}else if(Group.equalsIgnoreCase("OtherGroup")){
	
        out.write("\r\n");
        out.write("\t<div>\r\n");
        out.write("\t <div class =\"GroupOther\">\r\n");
        out.write("\t\t<h1>Group Other</h1>\r\n");
        out.write("\t\t<hr>\r\n");
        out.write("\t");

	}if(Group.equalsIgnoreCase("FamilyGroup")){
	
        out.write("\r\n");
        out.write("\t<div>\r\n");
        out.write("\t <div class =\"GroupFamily\">\r\n");
        out.write("\t\t<h1>Group Family</h1>\r\n");
        out.write("\t\t<hr>\r\n");
        out.write("\t");

	}
	
        out.write("\r\n");
        out.write("\t\r\n");
        out.write("\t\r\n");
        out.write("\t");
        //  aui:input
        com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
        _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
        _jspx_th_aui_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
        _jspx_th_aui_input_0.setName("Group");
        _jspx_th_aui_input_0.setType("hidden");
        _jspx_th_aui_input_0.setValue( Group );
        int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
        if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
          return;
        }
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
        out.write("\r\n");
        out.write("\t<img src=\"/portal_content/download.jpg\" alt=\"img\" id =\"blah\" class=\"avatar\">\r\n");
        out.write("\t\t<div style=\" margin-left:202px; margin-top:-139px;\">\r\n");
        out.write("\t\t");
        if (_jspx_meth_aui_input_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("</div>\r\n");
        out.write("\t<br>\r\n");
        out.write("\t<br>\r\n");
        out.write("\t<hr>\r\n");
        out.write("\t\r\n");
        out.write("\t<strong>Group Name</strong><span style=\"color:#e20c0c;font-size: 0.875rem;\">*</span>\r\n");
        out.write("\t<br>\r\n");
        out.write("\t");
        if (_jspx_meth_aui_input_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t <br>\r\n");
        out.write("\t <br>\r\n");
        out.write("\t\r\n");
        out.write("\t");
        if (_jspx_meth_aui_input_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\r\n");
        out.write("\t\r\n");
        out.write("\t<strong>Location</strong><span style=\"color:#e20c0c;font-size: 0.875rem;\">*</span>\r\n");
        out.write("\t<br>\r\n");
        out.write("\t");
        if (_jspx_meth_aui_input_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t <br>\r\n");
        out.write("\t <br>\r\n");
        out.write("\t\r\n");
        out.write("\t<hr><div><strong>Contact details</strong></div><br>\r\n");
        out.write("\t\t\r\n");
        out.write("\t<strong>Name</strong><span style=\"color:#e20c0c;font-size: 0.875rem;\">*</span>\r\n");
        out.write("\t<br>\r\n");
        out.write("\t");
        if (_jspx_meth_aui_input_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t <br>\r\n");
        out.write("\t <br>\r\n");
        out.write("\t\r\n");
        out.write("\t\r\n");
        out.write("\t");
        if (_jspx_meth_aui_input_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\r\n");
        out.write("\t<div style=\"margin-left: 235px;\">");
        if (_jspx_meth_aui_button_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\r\n");
        out.write("\t");
        if (_jspx_meth_aui_button_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_form_0, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t</div></div></div></div></div></div>\r\n");
        out.write("</div>\r\n");
        out.write("\t\t<div class=\"footer\" style=\"background-color: #002a3a;\">\r\n");
        out.write("\t\t<!--start of footer-->\r\n");
        out.write("\t\t<div class=\"row\">\r\n");
        out.write("\t\t\t<div class=\"column\" style=\"font-size: 1.2vw; color: white\">\r\n");
        out.write("\t\t\t\t<a href=\"about_us.html\" style=\"color: white;\">About</a><br /> <a\r\n");
        out.write("\t\t\t\t\thref=\"about_us.html\" style=\"color: white;\">Overview</a><br /> <a\r\n");
        out.write("\t\t\t\t\thref=\"about_us.html\" style=\"color: white;\">Team</a><br /> <a\r\n");
        out.write("\t\t\t\t\thref=\"PrivacyPolicy.html\" style=\"color: white;\">Privacy Policy</a><br />\r\n");
        out.write("\t\t\t\t<a href=\"Disclaimer.html\" style=\"color: white;\">Terms &amp;\r\n");
        out.write("\t\t\t\t\tConditions</a>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\r\n");
        out.write("\t\t\t<div class=\"column\" style=\"font-size: 1.2vw; color: white\">\r\n");
        out.write("\t\t\t\t<a href=\"Security.html\" style=\"color: white;\">Security</a><br /> <a\r\n");
        out.write("\t\t\t\t\thref=\"#\" style=\"color: white;\">Fundraising Tips</a><br /> <a\r\n");
        out.write("\t\t\t\t\thref=\"#\" style=\"color: white;\">Pricing</a><br /> <a href=\"#\"\r\n");
        out.write("\t\t\t\t\tstyle=\"color: white;\">Fundraising FAQ's</a><br /> <a href=\"#\"\r\n");
        out.write("\t\t\t\t\tstyle=\"color: white;\">Donate Now</a>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\r\n");
        out.write("\t\t\t<div class=\"column\" style=\"font-size: 1.2vw; color: white\">\r\n");
        out.write("\t\t\t\t<a href=\"#\" style=\"color: white;\">Start a Fundraiser</a><br /> <a\r\n");
        out.write("\t\t\t\t\thref=\"#\" style=\"color: white;\">ADDRESS</a><br /> &nbsp;\r\n");
        out.write("\t\t\t\t<p class=\"addressp\" style=\"line-height: 1px; font-size: 1vw;\">184\r\n");
        out.write("\t\t\t\t\t&amp; 185, EPIP Zone,</p>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<p class=\"addressp\" style=\"line-height: 1px; font-size: 1vw;\">Whitefield,\r\n");
        out.write("\t\t\t\t\tBengaluru,</p>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<p class=\"addressp\" style=\"line-height: 1px; font-size: 1vw;\">Karnataka\r\n");
        out.write("\t\t\t\t\t560066</p>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\r\n");
        out.write("\t\t\t<div class=\"column\" style=\"font-size: 1.2vw; color: white\">\r\n");
        out.write("\t\t\t\t<a href=\"#\" style=\"color: white;\">CONTACT US</a><br /> &nbsp;\r\n");
        out.write("\t\t\t\t<p class=\"addressp\" style=\"line-height: 1px; font-size: 1vw;\">Phone:\r\n");
        out.write("\t\t\t\t\t080818 80033</p>\r\n");
        out.write("\r\n");
        out.write("\t\t\t\t<p class=\"addressp\" style=\"line-height: 1px; font-size: 1vw;\">quickdaan@gmail.com</p>\r\n");
        out.write("\t\t\t</div>\r\n");
        out.write("\t\t</div>\r\n");
        out.write("\t</div>\r\n");
      }
      if (_jspx_th_aui_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_form_method_enctype_action.reuse(_jspx_th_aui_form_0);
        return;
      }
      _jspx_tagPool_aui_form_method_enctype_action.reuse(_jspx_th_aui_form_0);
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_portlet_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_0 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_0.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_0);
    _jspx_th_portlet_param_0.setName("jspPage");
    _jspx_th_portlet_param_0.setValue("/jsp/BenificiaryDetails/BenificiaryCategory.jsp");
    int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
    if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
    return false;
  }

  private boolean _jspx_meth_portlet_param_2(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_2 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_2.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
    _jspx_th_portlet_param_2.setName("jspPage");
    _jspx_th_portlet_param_2.setValue("/jsp/HomePage/CategoryList.jsp");
    int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
    if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
    return false;
  }

  private boolean _jspx_meth_aui_input_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_type_style_onchange_name_label_accept.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_1.setName("image");
    _jspx_th_aui_input_1.setType("file");
    _jspx_th_aui_input_1.setDynamicAttribute(null, "accept", new String("image/*"));
    _jspx_th_aui_input_1.setLabel("Display Photo : ");
    _jspx_th_aui_input_1.setDynamicAttribute(null, "onchange", new String("readURL(this);"));
    _jspx_th_aui_input_1.setDynamicAttribute(null, "style", new String("margin-right: -9px;"));
    int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
    if (_jspx_eval_aui_input_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_meth_aui_validator_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_1, _jspx_page_context))
        return true;
    }
    if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_type_style_onchange_name_label_accept.reuse(_jspx_th_aui_input_1);
      return true;
    }
    _jspx_tagPool_aui_input_type_style_onchange_name_label_accept.reuse(_jspx_th_aui_input_1);
    return false;
  }

  private boolean _jspx_meth_aui_validator_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_0 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_1);
    _jspx_th_aui_validator_0.setName("required");
    int _jspx_eval_aui_validator_0 = _jspx_th_aui_validator_0.doStartTag();
    if (_jspx_th_aui_validator_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_0);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_0);
    return false;
  }

  private boolean _jspx_meth_aui_input_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_name_maxlength_label_id_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_2.setCssClass("borderForm");
    _jspx_th_aui_input_2.setId("inputTextBox10");
    _jspx_th_aui_input_2.setLabel("");
    _jspx_th_aui_input_2.setName("groupName");
    _jspx_th_aui_input_2.setDynamicAttribute(null, "maxlength", new String("100"));
    int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
    if (_jspx_eval_aui_input_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t ");
    }
    if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_name_maxlength_label_id_cssClass.reuse(_jspx_th_aui_input_2);
      return true;
    }
    _jspx_tagPool_aui_input_name_maxlength_label_id_cssClass.reuse(_jspx_th_aui_input_2);
    return false;
  }

  private boolean _jspx_meth_aui_input_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_name_maxlength_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_3.setCssClass("borderForm");
    _jspx_th_aui_input_3.setName("member");
    _jspx_th_aui_input_3.setLabel("No. of members");
    _jspx_th_aui_input_3.setDynamicAttribute(null, "maxlength", new String("4"));
    int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
    if (_jspx_eval_aui_input_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_3, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_name_maxlength_label_cssClass.reuse(_jspx_th_aui_input_3);
      return true;
    }
    _jspx_tagPool_aui_input_name_maxlength_label_cssClass.reuse(_jspx_th_aui_input_3);
    return false;
  }

  private boolean _jspx_meth_aui_validator_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_1 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_1.setName("required");
    int _jspx_eval_aui_validator_1 = _jspx_th_aui_validator_1.doStartTag();
    if (_jspx_th_aui_validator_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_1);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_1);
    return false;
  }

  private boolean _jspx_meth_aui_validator_2(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_2 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_2.setName("number");
    int _jspx_eval_aui_validator_2 = _jspx_th_aui_validator_2.doStartTag();
    if (_jspx_th_aui_validator_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_2);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_2);
    return false;
  }

  private boolean _jspx_meth_aui_validator_3(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_3 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_3.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_3.setName("min");
    int _jspx_eval_aui_validator_3 = _jspx_th_aui_validator_3.doStartTag();
    if (_jspx_eval_aui_validator_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_validator_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_validator_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_validator_3.doInitBody();
      }
      do {
        out.write('1');
        int evalDoAfterBody = _jspx_th_aui_validator_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_aui_validator_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_aui_validator_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_3);
      return true;
    }
    _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_3);
    return false;
  }

  private boolean _jspx_meth_aui_validator_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_4 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_4.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_3);
    _jspx_th_aui_validator_4.setName("max");
    int _jspx_eval_aui_validator_4 = _jspx_th_aui_validator_4.doStartTag();
    if (_jspx_eval_aui_validator_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_aui_validator_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_aui_validator_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_aui_validator_4.doInitBody();
      }
      do {
        out.write("1000");
        int evalDoAfterBody = _jspx_th_aui_validator_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_aui_validator_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_aui_validator_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_4);
      return true;
    }
    _jspx_tagPool_aui_validator_name.reuse(_jspx_th_aui_validator_4);
    return false;
  }

  private boolean _jspx_meth_aui_input_4(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_4 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_4.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_4.setCssClass("borderForm");
    _jspx_th_aui_input_4.setId("inputTextBox11");
    _jspx_th_aui_input_4.setRequired(false);
    _jspx_th_aui_input_4.setLabel("");
    _jspx_th_aui_input_4.setName("location");
    _jspx_th_aui_input_4.setDynamicAttribute(null, "maxlength", new String("100"));
    _jspx_th_aui_input_4.setDynamicAttribute(null, "style", new String("padding:5px;"));
    int _jspx_eval_aui_input_4 = _jspx_th_aui_input_4.doStartTag();
    if (_jspx_eval_aui_input_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.reuse(_jspx_th_aui_input_4);
      return true;
    }
    _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.reuse(_jspx_th_aui_input_4);
    return false;
  }

  private boolean _jspx_meth_aui_input_5(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_5 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_5.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_5.setCssClass("borderForm");
    _jspx_th_aui_input_5.setId("inputTextBox12");
    _jspx_th_aui_input_5.setRequired(false);
    _jspx_th_aui_input_5.setLabel("");
    _jspx_th_aui_input_5.setName("Name");
    _jspx_th_aui_input_5.setDynamicAttribute(null, "maxlength", new String("100"));
    _jspx_th_aui_input_5.setDynamicAttribute(null, "style", new String("padding:5px;"));
    int _jspx_eval_aui_input_5 = _jspx_th_aui_input_5.doStartTag();
    if (_jspx_eval_aui_input_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.reuse(_jspx_th_aui_input_5);
      return true;
    }
    _jspx_tagPool_aui_input_style_required_name_maxlength_label_id_cssClass.reuse(_jspx_th_aui_input_5);
    return false;
  }

  private boolean _jspx_meth_aui_input_6(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:input
    com.liferay.taglib.aui.InputTag _jspx_th_aui_input_6 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_title_pattern_onkeypress_name_minlength_maxlength_label_cssClass.get(com.liferay.taglib.aui.InputTag.class);
    _jspx_th_aui_input_6.setPageContext(_jspx_page_context);
    _jspx_th_aui_input_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_input_6.setCssClass("borderForm");
    _jspx_th_aui_input_6.setName("number");
    _jspx_th_aui_input_6.setLabel("Mobile Number ");
    _jspx_th_aui_input_6.setDynamicAttribute(null, "onkeypress", new String("phoneno()"));
    _jspx_th_aui_input_6.setDynamicAttribute(null, "minlength", new String("10"));
    _jspx_th_aui_input_6.setDynamicAttribute(null, "maxlength", new String("10"));
    _jspx_th_aui_input_6.setDynamicAttribute(null, "pattern", new String("[0-9]{1}[0-9]{9}"));
    _jspx_th_aui_input_6.setTitle("Format:Minimum of 10 number is required");
    int _jspx_eval_aui_input_6 = _jspx_th_aui_input_6.doStartTag();
    if (_jspx_eval_aui_input_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_6, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_aui_validator_6((javax.servlet.jsp.tagext.JspTag) _jspx_th_aui_input_6, _jspx_page_context))
        return true;
      out.write("\r\n");
      out.write("\t");
    }
    if (_jspx_th_aui_input_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_input_title_pattern_onkeypress_name_minlength_maxlength_label_cssClass.reuse(_jspx_th_aui_input_6);
      return true;
    }
    _jspx_tagPool_aui_input_title_pattern_onkeypress_name_minlength_maxlength_label_cssClass.reuse(_jspx_th_aui_input_6);
    return false;
  }

  private boolean _jspx_meth_aui_validator_5(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_5 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_5.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_6);
    _jspx_th_aui_validator_5.setName("required");
    int _jspx_eval_aui_validator_5 = _jspx_th_aui_validator_5.doStartTag();
    if (_jspx_th_aui_validator_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_5);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_5);
    return false;
  }

  private boolean _jspx_meth_aui_validator_6(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_input_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:validator
    com.liferay.taglib.aui.ValidatorTagImpl _jspx_th_aui_validator_6 = (com.liferay.taglib.aui.ValidatorTagImpl) _jspx_tagPool_aui_validator_name_nobody.get(com.liferay.taglib.aui.ValidatorTagImpl.class);
    _jspx_th_aui_validator_6.setPageContext(_jspx_page_context);
    _jspx_th_aui_validator_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_input_6);
    _jspx_th_aui_validator_6.setName("number");
    int _jspx_eval_aui_validator_6 = _jspx_th_aui_validator_6.doStartTag();
    if (_jspx_th_aui_validator_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_6);
      return true;
    }
    _jspx_tagPool_aui_validator_name_nobody.reuse(_jspx_th_aui_validator_6);
    return false;
  }

  private boolean _jspx_meth_aui_button_0(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_style_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_button_0.setType("submit");
    _jspx_th_aui_button_0.setDynamicAttribute(null, "style", new String("background-color:#0077A2;color:white;border-radius: 100px;width: 100px;"));
    _jspx_th_aui_button_0.setValue("Next");
    int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
    if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_style_nobody.reuse(_jspx_th_aui_button_0);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_style_nobody.reuse(_jspx_th_aui_button_0);
    return false;
  }

  private boolean _jspx_meth_aui_button_1(javax.servlet.jsp.tagext.JspTag _jspx_th_aui_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_type_style_onClick_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_form_0);
    _jspx_th_aui_button_1.setType("cancel");
    _jspx_th_aui_button_1.setValue("cancel");
    _jspx_th_aui_button_1.setDynamicAttribute(null, "style", new String("background-color:white; color:#0077A2;border-radius: 100px;width: 100px; "));
    _jspx_th_aui_button_1.setOnClick("window.history.back();");
    int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
    if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_type_style_onClick_nobody.reuse(_jspx_th_aui_button_1);
      return true;
    }
    _jspx_tagPool_aui_button_value_type_style_onClick_nobody.reuse(_jspx_th_aui_button_1);
    return false;
  }
}
