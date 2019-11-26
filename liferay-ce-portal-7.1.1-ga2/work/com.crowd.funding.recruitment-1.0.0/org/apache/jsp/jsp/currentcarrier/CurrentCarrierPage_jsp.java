package org.apache.jsp.jsp.currentcarrier;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.PositionRegistration;
import java.util.List;
import java.text.SimpleDateFormat;
import com.crowd.funding.database.service.PositionRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.PositionRegistration;
import java.util.List;

public final class CurrentCarrierPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(9);
    _jspx_dependants.add("/jsp/currentcarrier/init.jsp");
    _jspx_dependants.add("/META-INF/c.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet_2_0.tld");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet-ext.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
    _jspx_dependants.add("/jsp/currentcarrier/ActivePostPage.jsp");
    _jspx_dependants.add("/jsp/currentcarrier/InActivePostPage.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_actionURL_var_name;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_section;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_tabs_tabsValues_refresh_names;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_renderURL_windowState_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_onClick_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon$1menu;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_portlet_actionURL_var_name = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_section = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_tabs_tabsValues_refresh_names = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_renderURL_windowState_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_onClick_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon$1menu = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_portlet_actionURL_var_name.release();
    _jspx_tagPool_liferay$1ui_section.release();
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_liferay$1ui_tabs_tabsValues_refresh_names.release();
    _jspx_tagPool_portlet_renderURL_windowState_var.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
    _jspx_tagPool_aui_button_value_onClick_name_nobody.release();
    _jspx_tagPool_liferay$1ui_icon$1menu.release();
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
      out.write('\r');
      out.write('\n');
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
      out.write('\r');
      out.write('\n');
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_0 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_0.setParent(null);
      _jspx_th_portlet_renderURL_0.setVar("NewPostFormURL");
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
      java.lang.String NewPostFormURL = null;
      NewPostFormURL = (java.lang.String) _jspx_page_context.findAttribute("NewPostFormURL");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_aui_button_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      //  liferay-ui:tabs
      com.liferay.taglib.ui.TabsTag _jspx_th_liferay$1ui_tabs_0 = (com.liferay.taglib.ui.TabsTag) _jspx_tagPool_liferay$1ui_tabs_tabsValues_refresh_names.get(com.liferay.taglib.ui.TabsTag.class);
      _jspx_th_liferay$1ui_tabs_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_tabs_0.setParent(null);
      _jspx_th_liferay$1ui_tabs_0.setNames("Active Posts , InActive Posts");
      _jspx_th_liferay$1ui_tabs_0.setRefresh(false);
      _jspx_th_liferay$1ui_tabs_0.setTabsValues("Active Posts , InActive Posts");
      int _jspx_eval_liferay$1ui_tabs_0 = _jspx_th_liferay$1ui_tabs_0.doStartTag();
      if (_jspx_eval_liferay$1ui_tabs_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("    \r\n");
        out.write("    ");
        //  liferay-ui:section
        com.liferay.taglib.ui.SectionTag _jspx_th_liferay$1ui_section_0 = (com.liferay.taglib.ui.SectionTag) _jspx_tagPool_liferay$1ui_section.get(com.liferay.taglib.ui.SectionTag.class);
        _jspx_th_liferay$1ui_section_0.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_section_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_tabs_0);
        int _jspx_eval_liferay$1ui_section_0 = _jspx_th_liferay$1ui_section_0.doStartTag();
        if (_jspx_eval_liferay$1ui_section_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.String sectionParam = null;
          java.lang.String sectionName = null;
          java.lang.Boolean sectionSelected = null;
          java.lang.String sectionScroll = null;
          java.lang.String sectionRedirectParams = null;
          sectionParam = (java.lang.String) _jspx_page_context.findAttribute("sectionParam");
          sectionName = (java.lang.String) _jspx_page_context.findAttribute("sectionName");
          sectionSelected = (java.lang.Boolean) _jspx_page_context.findAttribute("sectionSelected");
          sectionScroll = (java.lang.String) _jspx_page_context.findAttribute("sectionScroll");
          sectionRedirectParams = (java.lang.String) _jspx_page_context.findAttribute("sectionRedirectParams");
          out.write("\r\n");
          out.write("         ");
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
          com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_2 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
          _jspx_th_liferay$1theme_defineObjects_2.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1theme_defineObjects_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          int _jspx_eval_liferay$1theme_defineObjects_2 = _jspx_th_liferay$1theme_defineObjects_2.doStartTag();
          if (_jspx_th_liferay$1theme_defineObjects_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_2);
            return;
          }
          _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_2);
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
          com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_2 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
          _jspx_th_portlet_defineObjects_2.setPageContext(_jspx_page_context);
          _jspx_th_portlet_defineObjects_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          int _jspx_eval_portlet_defineObjects_2 = _jspx_th_portlet_defineObjects_2.doStartTag();
          if (_jspx_th_portlet_defineObjects_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_2);
            return;
          }
          _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_2);
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
          //  liferay-theme:defineObjects
          com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_3 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
          _jspx_th_liferay$1theme_defineObjects_3.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1theme_defineObjects_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          int _jspx_eval_liferay$1theme_defineObjects_3 = _jspx_th_liferay$1theme_defineObjects_3.doStartTag();
          if (_jspx_th_liferay$1theme_defineObjects_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_3);
            return;
          }
          _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_3);
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
          com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_3 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
          _jspx_th_portlet_defineObjects_3.setPageContext(_jspx_page_context);
          _jspx_th_portlet_defineObjects_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          int _jspx_eval_portlet_defineObjects_3 = _jspx_th_portlet_defineObjects_3.doStartTag();
          if (_jspx_th_portlet_defineObjects_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_3);
            return;
          }
          _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_3);
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
          out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\">\r\n");
          out.write("  \r\n");
          out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"");
          out.print(request.getContextPath());
          out.write("/js/jquery-3.3.1.js\"></script>\r\n");
          out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"");
          out.print(request.getContextPath());
          out.write("/js/jquery.dataTables.min.js\"></script>\r\n");
          out.write("\r\n");
          out.write("<script type=\"text/javascript\">\r\n");
          out.write("$(document).ready(function() {\r\n");
          out.write("    $('#activetable').DataTable();\r\n");
          out.write("} );\r\n");
          out.write("</script>\r\n");
          //  portlet:defineObjects
          com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_4 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
          _jspx_th_portlet_defineObjects_4.setPageContext(_jspx_page_context);
          _jspx_th_portlet_defineObjects_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          int _jspx_eval_portlet_defineObjects_4 = _jspx_th_portlet_defineObjects_4.doStartTag();
          if (_jspx_th_portlet_defineObjects_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_4);
            return;
          }
          _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_4);
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

List<PositionRegistration> positionlist = null;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
positionlist = PositionRegistrationLocalServiceUtil.findBySTATUS(1);

          out.write("\r\n");
          out.write("<table id=\"activetable\" class=\"display\" style=\"width:100%\">\r\n");
          out.write("\t\t<thead>\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<th>POSITION_ID</th>\r\n");
          out.write("\t\t\t\t<th>POSITION_NAME</th>\r\n");
          out.write("\t\t\t\t<th>DATE</th>\r\n");
          out.write("\t\t\t\t<th>LOCATION</th>\r\n");
          out.write("\t\t\t\t<th>Action</th>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t</thead>\r\n");
          out.write("\t\t\t<tbody>\r\n");
          out.write("\t\t\t");
   
			for(PositionRegistration PositionObj : positionlist ) {
			
          out.write("\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t");
          //  portlet:renderURL
          com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_1 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
          _jspx_th_portlet_renderURL_1.setPageContext(_jspx_page_context);
          _jspx_th_portlet_renderURL_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          _jspx_th_portlet_renderURL_1.setVar("PositionRegistrationUrl");
          _jspx_th_portlet_renderURL_1.setWindowState("normal");
          int _jspx_eval_portlet_renderURL_1 = _jspx_th_portlet_renderURL_1.doStartTag();
          if (_jspx_eval_portlet_renderURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_1 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_1.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
            _jspx_th_portlet_param_1.setName("PositionId");
            _jspx_th_portlet_param_1.setValue( String.valueOf(PositionObj.getPOSITION_ID()) );
            int _jspx_eval_portlet_param_1 = _jspx_th_portlet_param_1.doStartTag();
            if (_jspx_th_portlet_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_1);
            out.write("\r\n");
            out.write("\t\t\t \t");
            if (_jspx_meth_portlet_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_1, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("\t\t\t  ");
          }
          if (_jspx_th_portlet_renderURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
            return;
          }
          _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
          java.lang.String PositionRegistrationUrl = null;
          PositionRegistrationUrl = (java.lang.String) _jspx_page_context.findAttribute("PositionRegistrationUrl");
          out.write("\r\n");
          out.write("\t\t\t  ");
          //  portlet:renderURL
          com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_2 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
          _jspx_th_portlet_renderURL_2.setPageContext(_jspx_page_context);
          _jspx_th_portlet_renderURL_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          _jspx_th_portlet_renderURL_2.setVar("EditPositionRegistrationUrl");
          _jspx_th_portlet_renderURL_2.setWindowState("normal");
          int _jspx_eval_portlet_renderURL_2 = _jspx_th_portlet_renderURL_2.doStartTag();
          if (_jspx_eval_portlet_renderURL_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_3 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_3.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_2);
            _jspx_th_portlet_param_3.setName("PositionId");
            _jspx_th_portlet_param_3.setValue( String.valueOf(PositionObj.getPOSITION_ID()) );
            int _jspx_eval_portlet_param_3 = _jspx_th_portlet_param_3.doStartTag();
            if (_jspx_th_portlet_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
            out.write("\r\n");
            out.write("\t\t\t \t");
            if (_jspx_meth_portlet_param_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_2, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("\t\t\t  ");
          }
          if (_jspx_th_portlet_renderURL_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_2);
            return;
          }
          _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_2);
          java.lang.String EditPositionRegistrationUrl = null;
          EditPositionRegistrationUrl = (java.lang.String) _jspx_page_context.findAttribute("EditPositionRegistrationUrl");
          out.write("\r\n");
          out.write("\t\t\t  ");
          //  portlet:actionURL
          com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_0 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
          _jspx_th_portlet_actionURL_0.setPageContext(_jspx_page_context);
          _jspx_th_portlet_actionURL_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
          _jspx_th_portlet_actionURL_0.setName("changeActiveToInactive");
          _jspx_th_portlet_actionURL_0.setVar("changeActiveToInactiveURL");
          int _jspx_eval_portlet_actionURL_0 = _jspx_th_portlet_actionURL_0.doStartTag();
          if (_jspx_eval_portlet_actionURL_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n");
            out.write("\t\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_5 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_5.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_0);
            _jspx_th_portlet_param_5.setName("PositionId");
            _jspx_th_portlet_param_5.setValue( String.valueOf(PositionObj.getPOSITION_ID()) );
            int _jspx_eval_portlet_param_5 = _jspx_th_portlet_param_5.doStartTag();
            if (_jspx_th_portlet_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
            out.write("\r\n");
            out.write("\t\t\t\t");
          }
          if (_jspx_th_portlet_actionURL_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
            return;
          }
          _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_0);
          java.lang.String changeActiveToInactiveURL = null;
          changeActiveToInactiveURL = (java.lang.String) _jspx_page_context.findAttribute("changeActiveToInactiveURL");
          out.write("\r\n");
          out.write("\t\t\t\t<td>");
          out.print( PositionObj.getPOSITION_ID() );
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td>");
          out.print( PositionObj.getPOSITION_NAME());
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td>");
          out.print( formatter.format(PositionObj.getDATE()) );
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td>");
          out.print( PositionObj.getLOCATION() );
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td><!-- ");
          if (_jspx_meth_aui_button_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_section_0, _jspx_page_context))
            return;
          out.write(" -->\r\n");
          out.write("\t\t\t\t ");
          if (_jspx_meth_liferay$1ui_icon$1menu_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_section_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t </td>\r\n");
          out.write("\t\t\t\t </tr>\r\n");
          out.write("\t\t\t");

			}
			
          out.write("\r\n");
          out.write("\t</tbody>\r\n");
          out.write("</table>");
          out.write("\r\n");
          out.write("    ");
        }
        if (_jspx_th_liferay$1ui_section_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_section.reuse(_jspx_th_liferay$1ui_section_0);
          return;
        }
        _jspx_tagPool_liferay$1ui_section.reuse(_jspx_th_liferay$1ui_section_0);
        out.write("\r\n");
        out.write("    ");
        //  liferay-ui:section
        com.liferay.taglib.ui.SectionTag _jspx_th_liferay$1ui_section_1 = (com.liferay.taglib.ui.SectionTag) _jspx_tagPool_liferay$1ui_section.get(com.liferay.taglib.ui.SectionTag.class);
        _jspx_th_liferay$1ui_section_1.setPageContext(_jspx_page_context);
        _jspx_th_liferay$1ui_section_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_tabs_0);
        int _jspx_eval_liferay$1ui_section_1 = _jspx_th_liferay$1ui_section_1.doStartTag();
        if (_jspx_eval_liferay$1ui_section_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          java.lang.String sectionParam = null;
          java.lang.String sectionName = null;
          java.lang.Boolean sectionSelected = null;
          java.lang.String sectionScroll = null;
          java.lang.String sectionRedirectParams = null;
          sectionParam = (java.lang.String) _jspx_page_context.findAttribute("sectionParam");
          sectionName = (java.lang.String) _jspx_page_context.findAttribute("sectionName");
          sectionSelected = (java.lang.Boolean) _jspx_page_context.findAttribute("sectionSelected");
          sectionScroll = (java.lang.String) _jspx_page_context.findAttribute("sectionScroll");
          sectionRedirectParams = (java.lang.String) _jspx_page_context.findAttribute("sectionRedirectParams");
          out.write("\r\n");
          out.write("         ");
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
          com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_4 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
          _jspx_th_liferay$1theme_defineObjects_4.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1theme_defineObjects_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
          int _jspx_eval_liferay$1theme_defineObjects_4 = _jspx_th_liferay$1theme_defineObjects_4.doStartTag();
          if (_jspx_th_liferay$1theme_defineObjects_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_4);
            return;
          }
          _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_4);
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
          com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_5 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
          _jspx_th_portlet_defineObjects_5.setPageContext(_jspx_page_context);
          _jspx_th_portlet_defineObjects_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
          int _jspx_eval_portlet_defineObjects_5 = _jspx_th_portlet_defineObjects_5.doStartTag();
          if (_jspx_th_portlet_defineObjects_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_5);
            return;
          }
          _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_5);
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
          //  liferay-theme:defineObjects
          com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_5 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
          _jspx_th_liferay$1theme_defineObjects_5.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1theme_defineObjects_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
          int _jspx_eval_liferay$1theme_defineObjects_5 = _jspx_th_liferay$1theme_defineObjects_5.doStartTag();
          if (_jspx_th_liferay$1theme_defineObjects_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_5);
            return;
          }
          _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_5);
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
          com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_6 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
          _jspx_th_portlet_defineObjects_6.setPageContext(_jspx_page_context);
          _jspx_th_portlet_defineObjects_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
          int _jspx_eval_portlet_defineObjects_6 = _jspx_th_portlet_defineObjects_6.doStartTag();
          if (_jspx_th_portlet_defineObjects_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_6);
            return;
          }
          _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_6);
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
          out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\">\r\n");
          out.write("  \r\n");
          out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"");
          out.print(request.getContextPath());
          out.write("/js/jquery-3.3.1.js\"></script>\r\n");
          out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"");
          out.print(request.getContextPath());
          out.write("/js/jquery.dataTables.min.js\"></script>\r\n");
          out.write("\r\n");
          out.write("<script type=\"text/javascript\">\r\n");
          out.write("$(document).ready(function() {\r\n");
          out.write("    $('#inactivetable').DataTable();\r\n");
          out.write("} );\r\n");
          out.write("</script>\r\n");
          out.write("\r\n");

List<PositionRegistration> positionlist = null;
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
positionlist = PositionRegistrationLocalServiceUtil.findBySTATUS(0);

          out.write("\r\n");
          out.write("<table id=\"inactivetable\" class=\"display\" style=\"width:100%\">\r\n");
          out.write("\t\t<thead>\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<th>POSITION_ID</th>\r\n");
          out.write("\t\t\t\t<th>POSITION_NAME</th>\r\n");
          out.write("\t\t\t\t<th>DATE</th>\r\n");
          out.write("\t\t\t\t<th>LOCATION</th>\r\n");
          out.write("\t\t\t\t<th>Action</th>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t</thead>\r\n");
          out.write("\t\t\t<tbody>\r\n");
          out.write("\t\t\t");
   
			for(PositionRegistration PositionObj : positionlist ) {
			
          out.write("\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t");
          //  portlet:renderURL
          com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_3 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
          _jspx_th_portlet_renderURL_3.setPageContext(_jspx_page_context);
          _jspx_th_portlet_renderURL_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
          _jspx_th_portlet_renderURL_3.setVar("PositionRegistrationUrl");
          _jspx_th_portlet_renderURL_3.setWindowState("normal");
          int _jspx_eval_portlet_renderURL_3 = _jspx_th_portlet_renderURL_3.doStartTag();
          if (_jspx_eval_portlet_renderURL_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n");
            out.write("\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_6 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_6.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_3);
            _jspx_th_portlet_param_6.setName("PositionId");
            _jspx_th_portlet_param_6.setValue( String.valueOf(PositionObj.getPOSITION_ID()) );
            int _jspx_eval_portlet_param_6 = _jspx_th_portlet_param_6.doStartTag();
            if (_jspx_th_portlet_param_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
            out.write("\r\n");
            out.write("\t\t\t \t");
            if (_jspx_meth_portlet_param_7((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_3, _jspx_page_context))
              return;
            out.write("\r\n");
            out.write("\t\t\t  ");
          }
          if (_jspx_th_portlet_renderURL_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_3);
            return;
          }
          _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_3);
          java.lang.String PositionRegistrationUrl = null;
          PositionRegistrationUrl = (java.lang.String) _jspx_page_context.findAttribute("PositionRegistrationUrl");
          out.write("\r\n");
          out.write("\t\t\t  ");
          //  portlet:actionURL
          com.liferay.taglib.portlet.ActionURLTag _jspx_th_portlet_actionURL_1 = (com.liferay.taglib.portlet.ActionURLTag) _jspx_tagPool_portlet_actionURL_var_name.get(com.liferay.taglib.portlet.ActionURLTag.class);
          _jspx_th_portlet_actionURL_1.setPageContext(_jspx_page_context);
          _jspx_th_portlet_actionURL_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
          _jspx_th_portlet_actionURL_1.setName("changeInActiveToActive");
          _jspx_th_portlet_actionURL_1.setVar("changeInActiveToActiveURL");
          int _jspx_eval_portlet_actionURL_1 = _jspx_th_portlet_actionURL_1.doStartTag();
          if (_jspx_eval_portlet_actionURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            out.write("\r\n");
            out.write("\t\t\t\t\t");
            //  portlet:param
            com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_8 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
            _jspx_th_portlet_param_8.setPageContext(_jspx_page_context);
            _jspx_th_portlet_param_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_actionURL_1);
            _jspx_th_portlet_param_8.setName("PositionId");
            _jspx_th_portlet_param_8.setValue( String.valueOf(PositionObj.getPOSITION_ID()) );
            int _jspx_eval_portlet_param_8 = _jspx_th_portlet_param_8.doStartTag();
            if (_jspx_th_portlet_param_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
              return;
            }
            _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
            out.write("\r\n");
            out.write("\t\t\t\t");
          }
          if (_jspx_th_portlet_actionURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_1);
            return;
          }
          _jspx_tagPool_portlet_actionURL_var_name.reuse(_jspx_th_portlet_actionURL_1);
          java.lang.String changeInActiveToActiveURL = null;
          changeInActiveToActiveURL = (java.lang.String) _jspx_page_context.findAttribute("changeInActiveToActiveURL");
          out.write("\r\n");
          out.write("\t\t\t\t<td>");
          out.print( PositionObj.getPOSITION_ID() );
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td>");
          out.print( PositionObj.getPOSITION_NAME());
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td>");
          out.print( formatter.format(PositionObj.getDATE()) );
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td>");
          out.print( PositionObj.getLOCATION() );
          out.write("</td>\r\n");
          out.write("\t\t\t\t <td><!-- ");
          if (_jspx_meth_aui_button_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_section_1, _jspx_page_context))
            return;
          out.write(" -->\r\n");
          out.write("\t\t\t\t ");
          if (_jspx_meth_liferay$1ui_icon$1menu_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_section_1, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t \r\n");
          out.write("\t\t\t\t </td>\r\n");
          out.write("\t\t\t\t </tr>\r\n");
          out.write("\t\t\t");

			}
			
          out.write("\r\n");
          out.write("\t</tbody>\r\n");
          out.write("</table>");
          out.write("\r\n");
          out.write("    ");
        }
        if (_jspx_th_liferay$1ui_section_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_liferay$1ui_section.reuse(_jspx_th_liferay$1ui_section_1);
          return;
        }
        _jspx_tagPool_liferay$1ui_section.reuse(_jspx_th_liferay$1ui_section_1);
        out.write('\r');
        out.write('\n');
      }
      if (_jspx_th_liferay$1ui_tabs_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1ui_tabs_tabsValues_refresh_names.reuse(_jspx_th_liferay$1ui_tabs_0);
        return;
      }
      _jspx_tagPool_liferay$1ui_tabs_tabsValues_refresh_names.reuse(_jspx_th_liferay$1ui_tabs_0);
      out.write("\r\n");
      out.write("\r\n");
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
    _jspx_th_portlet_param_0.setValue("/jsp/currentcarrier/NewPostForm.jsp");
    int _jspx_eval_portlet_param_0 = _jspx_th_portlet_param_0.doStartTag();
    if (_jspx_th_portlet_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_0);
    return false;
  }

  private boolean _jspx_meth_aui_button_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_onClick_name_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_0.setParent(null);
    _jspx_th_aui_button_0.setName("submit");
    _jspx_th_aui_button_0.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${NewPostFormURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_0.setValue("Add New Post");
    int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
    if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_onClick_name_nobody.reuse(_jspx_th_aui_button_0);
      return true;
    }
    _jspx_tagPool_aui_button_value_onClick_name_nobody.reuse(_jspx_th_aui_button_0);
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
    _jspx_th_portlet_param_2.setValue("/jsp/currentcarrier/ActivePostDetailPage.jsp");
    int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
    if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
    return false;
  }

  private boolean _jspx_meth_portlet_param_4(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_4 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_4.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_2);
    _jspx_th_portlet_param_4.setName("jspPage");
    _jspx_th_portlet_param_4.setValue("/jsp/currentcarrier/EditPostedForm.jsp");
    int _jspx_eval_portlet_param_4 = _jspx_th_portlet_param_4.doStartTag();
    if (_jspx_th_portlet_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
    return false;
  }

  private boolean _jspx_meth_aui_button_1(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_section_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_1 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_onClick_name_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_1.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
    _jspx_th_aui_button_1.setName("submit");
    _jspx_th_aui_button_1.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PositionRegistrationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_1.setValue("Details");
    int _jspx_eval_aui_button_1 = _jspx_th_aui_button_1.doStartTag();
    if (_jspx_th_aui_button_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_onClick_name_nobody.reuse(_jspx_th_aui_button_1);
      return true;
    }
    _jspx_tagPool_aui_button_value_onClick_name_nobody.reuse(_jspx_th_aui_button_1);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon$1menu_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_section_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon-menu
    com.liferay.taglib.ui.IconMenuTag _jspx_th_liferay$1ui_icon$1menu_0 = (com.liferay.taglib.ui.IconMenuTag) _jspx_tagPool_liferay$1ui_icon$1menu.get(com.liferay.taglib.ui.IconMenuTag.class);
    _jspx_th_liferay$1ui_icon$1menu_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon$1menu_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_0);
    int _jspx_eval_liferay$1ui_icon$1menu_0 = _jspx_th_liferay$1ui_icon$1menu_0.doStartTag();
    if (_jspx_eval_liferay$1ui_icon$1menu_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_liferay$1ui_icon$1menu_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_liferay$1ui_icon$1menu_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_liferay$1ui_icon$1menu_0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t \t");
        if (_jspx_meth_liferay$1ui_icon_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t \t\t");
        if (_jspx_meth_liferay$1ui_icon_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_liferay$1ui_icon_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_liferay$1ui_icon$1menu_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_liferay$1ui_icon$1menu_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_liferay$1ui_icon$1menu_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon$1menu.reuse(_jspx_th_liferay$1ui_icon$1menu_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon$1menu.reuse(_jspx_th_liferay$1ui_icon$1menu_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_0(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_0 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_0.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
    _jspx_th_liferay$1ui_icon_0.setImage("view");
    _jspx_th_liferay$1ui_icon_0.setMessage("Details");
    _jspx_th_liferay$1ui_icon_0.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PositionRegistrationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_0 = _jspx_th_liferay$1ui_icon_0.doStartTag();
    if (_jspx_th_liferay$1ui_icon_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_0);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_1(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_1 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
    _jspx_th_liferay$1ui_icon_1.setImage("edit");
    _jspx_th_liferay$1ui_icon_1.setMessage("Edit Position");
    _jspx_th_liferay$1ui_icon_1.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${EditPositionRegistrationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_1 = _jspx_th_liferay$1ui_icon_1.doStartTag();
    if (_jspx_th_liferay$1ui_icon_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_1);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_2(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_2 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_2.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
    _jspx_th_liferay$1ui_icon_2.setImage("edit");
    _jspx_th_liferay$1ui_icon_2.setMessage("Inactive Job");
    _jspx_th_liferay$1ui_icon_2.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${changeActiveToInactiveURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_2 = _jspx_th_liferay$1ui_icon_2.doStartTag();
    if (_jspx_th_liferay$1ui_icon_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
    return false;
  }

  private boolean _jspx_meth_portlet_param_7(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_7 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_7.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_3);
    _jspx_th_portlet_param_7.setName("jspPage");
    _jspx_th_portlet_param_7.setValue("/jsp/currentcarrier/InActivePostDetailPage.jsp");
    int _jspx_eval_portlet_param_7 = _jspx_th_portlet_param_7.doStartTag();
    if (_jspx_th_portlet_param_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
    return false;
  }

  private boolean _jspx_meth_aui_button_2(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_section_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:button
    com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_2 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_onClick_name_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
    _jspx_th_aui_button_2.setPageContext(_jspx_page_context);
    _jspx_th_aui_button_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
    _jspx_th_aui_button_2.setName("submit");
    _jspx_th_aui_button_2.setOnClick((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PositionRegistrationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_aui_button_2.setValue("Details");
    int _jspx_eval_aui_button_2 = _jspx_th_aui_button_2.doStartTag();
    if (_jspx_th_aui_button_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_button_value_onClick_name_nobody.reuse(_jspx_th_aui_button_2);
      return true;
    }
    _jspx_tagPool_aui_button_value_onClick_name_nobody.reuse(_jspx_th_aui_button_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon$1menu_1(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_section_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon-menu
    com.liferay.taglib.ui.IconMenuTag _jspx_th_liferay$1ui_icon$1menu_1 = (com.liferay.taglib.ui.IconMenuTag) _jspx_tagPool_liferay$1ui_icon$1menu.get(com.liferay.taglib.ui.IconMenuTag.class);
    _jspx_th_liferay$1ui_icon$1menu_1.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon$1menu_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_section_1);
    int _jspx_eval_liferay$1ui_icon$1menu_1 = _jspx_th_liferay$1ui_icon$1menu_1.doStartTag();
    if (_jspx_eval_liferay$1ui_icon$1menu_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_liferay$1ui_icon$1menu_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_liferay$1ui_icon$1menu_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_liferay$1ui_icon$1menu_1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t \t");
        if (_jspx_meth_liferay$1ui_icon_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t \t\t\r\n");
        out.write("\t\t\t\t\t\t\t\t");
        if (_jspx_meth_liferay$1ui_icon_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t \t\r\n");
        out.write("\t\t\t\t    ");
        int evalDoAfterBody = _jspx_th_liferay$1ui_icon$1menu_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_liferay$1ui_icon$1menu_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_liferay$1ui_icon$1menu_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon$1menu.reuse(_jspx_th_liferay$1ui_icon$1menu_1);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon$1menu.reuse(_jspx_th_liferay$1ui_icon$1menu_1);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_3(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_3 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_3.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
    _jspx_th_liferay$1ui_icon_3.setImage("view");
    _jspx_th_liferay$1ui_icon_3.setMessage("Details");
    _jspx_th_liferay$1ui_icon_3.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${PositionRegistrationUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_3 = _jspx_th_liferay$1ui_icon_3.doStartTag();
    if (_jspx_th_liferay$1ui_icon_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_3);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_3);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_4(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_4 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_4.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_1);
    _jspx_th_liferay$1ui_icon_4.setImage("edit");
    _jspx_th_liferay$1ui_icon_4.setMessage("Inactive Job");
    _jspx_th_liferay$1ui_icon_4.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${changeInActiveToActiveURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_4 = _jspx_th_liferay$1ui_icon_4.doStartTag();
    if (_jspx_th_liferay$1ui_icon_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_4);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_4);
    return false;
  }
}
