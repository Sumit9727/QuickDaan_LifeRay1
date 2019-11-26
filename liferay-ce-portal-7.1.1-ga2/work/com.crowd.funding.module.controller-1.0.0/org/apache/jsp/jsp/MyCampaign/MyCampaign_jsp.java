package org.apache.jsp.jsp.MyCampaign;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.crowd.funding.database.model.CategoryRegistration;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.crowd.funding.database.service.CategoryRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.CategoryRegistration;
import com.crowd.funding.database.service.FundReleaseRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.FundReleaseRegistration;
import com.crowd.funding.database.service.FundRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.FundRegistration;
import java.util.LinkedList;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.ArrayUtil;
import java.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.crowd.funding.module.controller.constants.CrowdFundingBenificiaryDetailsPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.crowd.funding.database.service.UserRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.UserRegistration;
import com.liferay.portal.kernel.util.ListUtil;
import java.util.List;
import com.crowd.funding.database.service.ProjectRegistrationLocalServiceUtil;
import com.crowd.funding.database.model.ProjectRegistration;

public final class MyCampaign_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_renderURL_windowState_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_icon$1menu;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_renderURL_windowState_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1ui_icon$1menu = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.release();
    _jspx_tagPool_portlet_param_value_name_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_portlet_renderURL_windowState_var.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
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
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\">\r\n");
      out.write("  \r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\r\n");
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

int counter = 1;
ThemeDisplay td  =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
List<ProjectRegistration> projectList = ProjectRegistrationLocalServiceUtil.findByUSER_ID(td.getUserId());
LinkedList<ProjectRegistration> reverse = new LinkedList<ProjectRegistration>();
for(int i=projectList.size()-1;i>=0;i--){
	reverse.add(projectList.get(i));
}

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
long projectId = 0;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("    $('#example').DataTable();\r\n");
      out.write("} );\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".portlet-decorate .portlet-content{\r\n");
      out.write("    background-color: #f7f8f9;\r\n");
      out.write("    border: 1px solid #f1f2f5;\r\n");
      out.write("}\r\n");
      out.write(" .mayborderForm{\r\n");
      out.write("    background-color: #FFF;\r\n");
      out.write("    border: 1px solid #E7E7ED;\r\n");
      out.write("    border-radius: 0.5rem;\r\n");
      out.write("    padding: 45px;\r\n");
      out.write("    border: 1px solid #7FBD2C;\r\n");
      out.write("    border-top: 3px solid #7fbd2c;\r\n");
      out.write("    border-right: 3px solid #7FBD2C;\r\n");
      out.write("    box-shadow: 0 0 10px 1px #7FBD2C;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".portlet-decorate .portlet-content{\r\n");
      out.write("    background-color: #f7f8f9;\r\n");
      out.write("    border: 1px solid #f1f2f5;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".mayborderForm {\r\n");
      out.write("    background-color: #5d5d5d29;\r\n");
      out.write("    border: 1px solid #E7E7ED;\r\n");
      out.write("    border-radius: 0.5rem;\r\n");
      out.write("    padding: 24px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>QuickDaan-Care For Everyone</title>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("/*code for navigation bar*/\r\n");
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
      out.write("/*end of navigation bar css*/\r\n");
      out.write("\r\n");
      out.write("/*cards & Testimonals css*/\r\n");
      out.write(".testimotionals {\r\n");
      out.write("\twidth: 20%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tmargin-left: 50px;\r\n");
      out.write("\tmargin-top: 50px margin-left:100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 535px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tbackground: #0077A2;\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\t/*\tbox-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .layer {\r\n");
      out.write("\t/*z-index: 1;*/\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(100% - 2px);\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tbackground: linear-gradient(to left, #7FBD2c, #7FBD2c);\r\n");
      out.write("\ttransition: 0.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 {\r\n");
      out.write("\t/*\tz-index: 2;*/\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card:hover .layer {\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 p {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tline-height: 24px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tmargin-top: -3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 .image {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tborder-radius: 50%;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tborder: 4px solid white;\r\n");
      out.write("\tbox-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .conte nt .details h2 {\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 .details h2 span {\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\tcolor: purple;\r\n");
      out.write("\ttransition: 0.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card:hover .content1 .details h2 span {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin-top: 7px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".para {\r\n");
      out.write("\theight: 110px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".boxed {\r\n");
      out.write("\tbackground-color: black;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 190px;\r\n");
      out.write("\tmargin-bottom: px;\r\n");
      out.write("\tmargin-top: -8px;\r\n");
      out.write("}\r\n");
      out.write("/*end of cards & testimanals css*/\r\n");
      out.write("\r\n");
      out.write("/*css for text_fundraiser*/\r\n");
      out.write(".text_fundraiser {\r\n");
      out.write("\tcolor: #0077A2;\r\n");
      out.write("\tfont-size: 4vw;\r\n");
      out.write("}\r\n");
      out.write("/*end of text_fundraiser*/\r\n");
      out.write("\r\n");
      out.write("/*code for section3 */\r\n");
      out.write(".slideshow-container {\r\n");
      out.write("\tmax-width: 1000px;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\theight: 420px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".text {\r\n");
      out.write("\tcolor: #f2f2f2;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tpadding: 8px 12px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 8px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The dots/bullets/indicators */\r\n");
      out.write(".dot {\r\n");
      out.write("\theight: 15px;\r\n");
      out.write("\twidth: 15px;\r\n");
      out.write("\tmargin: 0 2px;\r\n");
      out.write("\tbackground-color: #bbb;\r\n");
      out.write("\tborder-radius: 50%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttransition: background-color 0.6s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active {\r\n");
      out.write("\tbackground-color: #717171;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Fading animation */\r\n");
      out.write(".fade {\r\n");
      out.write("\t-webkit-animation-name: fade;\r\n");
      out.write("\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\tanimation-name: fade;\r\n");
      out.write("\tanimation-duration: 1.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@\r\n");
      out.write("-webkit-keyframes fade {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("@\r\n");
      out.write("keyframes fade {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* On smaller screens, decrease text size */\r\n");
      out.write("@media only screen and (max-width: 300px) {\r\n");
      out.write("\t.text {\r\n");
      out.write("\t\tfont-size: 11px\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section 2 css*/\r\n");
      out.write(".slideshow-container1 {\r\n");
      out.write("\tmax-width: 100%;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Next & previous buttons */\r\n");
      out.write(".prev1, .next1 {\r\n");
      out.write("\tmargin-left: 100px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 50%;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\tpadding: 16px;\r\n");
      out.write("\tmargin-top: -22px;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\ttransition: 0.6s ease;\r\n");
      out.write("\tborder-radius: 0 3px 3px 0;\r\n");
      out.write("\tuser-select: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Position the \"next button\" to the right */\r\n");
      out.write(".next1 {\r\n");
      out.write("\tright: 0;\r\n");
      out.write("\tborder-radius: 3px 0 0 3px;\r\n");
      out.write("\tmargin-right: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* On hover, add a black background color with a little bit see-through */\r\n");
      out.write(".prev:hover1, .next:hover1 {\r\n");
      out.write("\tbackground-color: rgba(0, 0, 0, 0.8);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Caption text */\r\n");
      out.write(".text_section2 {\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tfont-family: comic sans MS;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tpadding: 0px 32px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 0px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 2.5vw;\r\n");
      out.write("\tmargin-left: 360px;\r\n");
      out.write("\tmargin-bottom: 60px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Number text (1/3 etc) */\r\n");
      out.write(".numbertext1 {\r\n");
      out.write("\tcolor: #f2f2f2;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tpadding: 8px 12px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The dots/bullets/indicators */\r\n");
      out.write(".dot1 {\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\theight: 15px;\r\n");
      out.write("\twidth: 15px;\r\n");
      out.write("\tmargin: 0 2px;\r\n");
      out.write("\tbackground-color: #bbb;\r\n");
      out.write("\tborder-radius: 50%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttransition: background-color 0.6s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active1, .dot:hover1 {\r\n");
      out.write("\tbackground-color: #717171;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Fading animation */\r\n");
      out.write(".fade1 {\r\n");
      out.write("\t-webkit-animation-name: fade;\r\n");
      out.write("\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\tanimation-name: fade;\r\n");
      out.write("\tanimation-duration: 1.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@\r\n");
      out.write("-webkit-keyframes fade1 {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("@\r\n");
      out.write("keyframes fade1 {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* On smaller screens, decrease text size */\r\n");
      out.write("@media only screen and (max-width: 300px) {\r\n");
      out.write("\t.prev, .next, .text {\r\n");
      out.write("\t\tfont-size: 11px\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section 2 css end*/\r\n");
      out.write("\r\n");
      out.write("/*section3(1) css*/\r\n");
      out.write(".section3\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("(1)\r\n");
      out.write("{\r\n");
      out.write("height\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(":\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("550\r\n");
      out.write("px\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(";\r\n");
      out.write("width\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(":\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section3(1) css end*/\r\n");
      out.write(".text_fundraiser {\r\n");
      out.write("\tcolor: #0077A2;\r\n");
      out.write("\tfont-size: 4vw;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*end of section3 css*/\r\n");
      out.write("\r\n");
      out.write("/*css of liferay */\r\n");
      out.write("body {\r\n");
      out.write("\tfont-family: Verdana, sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".mySlides {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("img {\r\n");
      out.write("\tvertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*body css*/\r\n");
      out.write(".home_body {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tmargin-top: -155px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*header css*/\r\n");
      out.write("/*.v1 {\r\n");
      out.write("\t\t\tborder-left: 3px solid #0077A2;\r\n");
      out.write("\t\t\theight: 60px;\r\n");
      out.write("\t\t\tmargin-left:267px;\r\n");
      out.write("\t\t\tmargin-top: -67px;\r\n");
      out.write("\t\t}\r\n");
      out.write("*/\r\n");
      out.write(".b_text {\r\n");
      out.write("\tpadding: 2px;\r\n");
      out.write("\tfont-family: georgia;\r\n");
      out.write("\tfont-size: 3vw;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\t/*padding:50px;*/\r\n");
      out.write("\t/*margin-top: -50px;\r\n");
      out.write("\t\t\tmargin-left: 364px;*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*code for search icon*/\r\n");
      out.write("@import 'https://fonts.googleapis.com/css?family=Catamaran';\r\n");
      out.write("\r\n");
      out.write("html, body {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tfont-family: 'Catamaran', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
      out.write("/*------------------------------------------------------------------------------------------------------------*/\r\n");
      out.write("/*closing of nav bar content*/\r\n");
      out.write("\r\n");
      out.write("/*start of section2 css*/\r\n");
      out.write("/* Slideshow container */\r\n");
      out.write(".slideshow-container {\r\n");
      out.write("\tmax-width: 1000px;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\theight: 420px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Caption text */\r\n");
      out.write(".text {\r\n");
      out.write("\tcolor: #f2f2f2;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tpadding: 8px 12px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 8px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The dots/bullets/indicators */\r\n");
      out.write(".dot {\r\n");
      out.write("\theight: 15px;\r\n");
      out.write("\twidth: 15px;\r\n");
      out.write("\tmargin: 0 2px;\r\n");
      out.write("\tbackground-color: #bbb;\r\n");
      out.write("\tborder-radius: 50%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttransition: background-color 0.6s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active {\r\n");
      out.write("\tbackground-color: #717171;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Fading animation */\r\n");
      out.write(".fade {\r\n");
      out.write("\t-webkit-animation-name: fade;\r\n");
      out.write("\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\tanimation-name: fade;\r\n");
      out.write("\tanimation-duration: 1.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@\r\n");
      out.write("-webkit-keyframes fade {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("@\r\n");
      out.write("keyframes fade {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* On smaller screens, decrease text size */\r\n");
      out.write("@media only screen and (max-width: 300px) {\r\n");
      out.write("\t.text {\r\n");
      out.write("\t\tfont-size: 11px\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section 2 css*/\r\n");
      out.write(".slideshow-container1 {\r\n");
      out.write("\tmax-width: 100%;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Next & previous buttons */\r\n");
      out.write(".prev1, .next1 {\r\n");
      out.write("\tmargin-left: 100px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 50%;\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\tpadding: 16px;\r\n");
      out.write("\tmargin-top: -22px;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tfont-size: 50px;\r\n");
      out.write("\ttransition: 0.6s ease;\r\n");
      out.write("\tborder-radius: 0 3px 3px 0;\r\n");
      out.write("\tuser-select: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Position the \"next button\" to the right */\r\n");
      out.write(".next1 {\r\n");
      out.write("\tright: 0;\r\n");
      out.write("\tborder-radius: 3px 0 0 3px;\r\n");
      out.write("\tmargin-right: 100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* On hover, add a black background color with a little bit see-through */\r\n");
      out.write(".prev:hover1, .next:hover1 {\r\n");
      out.write("\tbackground-color: rgba(0, 0, 0, 0.8);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Caption text */\r\n");
      out.write(".text_section2 {\r\n");
      out.write("\twidth: auto;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tfont-family: comic sans MS;\r\n");
      out.write("\tcolor: black;\r\n");
      out.write("\tfont-size: 15px;\r\n");
      out.write("\tpadding: 0px 80px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 0px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tfont-size: 2.5vw;\r\n");
      out.write("\tmargin-left: 360px;\r\n");
      out.write("\tmargin-bottom: 60px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Number text (1/3 etc) */\r\n");
      out.write(".numbertext1 {\r\n");
      out.write("\tcolor: #f2f2f2;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tpadding: 8px 12px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* The dots/bullets/indicators */\r\n");
      out.write(".dot1 {\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\theight: 15px;\r\n");
      out.write("\twidth: 15px;\r\n");
      out.write("\tmargin: 0 2px;\r\n");
      out.write("\tbackground-color: #bbb;\r\n");
      out.write("\tborder-radius: 50%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\ttransition: background-color 0.6s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active1, .dot:hover1 {\r\n");
      out.write("\tbackground-color: #717171;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Fading animation */\r\n");
      out.write(".fade1 {\r\n");
      out.write("\t-webkit-animation-name: fade;\r\n");
      out.write("\t-webkit-animation-duration: 1.5s;\r\n");
      out.write("\tanimation-name: fade;\r\n");
      out.write("\tanimation-duration: 1.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@\r\n");
      out.write("-webkit-keyframes fade1 {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("@\r\n");
      out.write("keyframes fade1 {from { opacity:.4\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("to {\r\n");
      out.write("\topacity: 1\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* On smaller screens, decrease text size */\r\n");
      out.write("@media only screen and (max-width: 300px) {\r\n");
      out.write("\t.prev, .next, .text {\r\n");
      out.write("\t\tfont-size: 11px\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section 2 css end*/\r\n");
      out.write("\r\n");
      out.write("/*section3(1) css*/\r\n");
      out.write(".section3\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("(1)\r\n");
      out.write("{\r\n");
      out.write("height\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(":\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("550\r\n");
      out.write("px\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(";\r\n");
      out.write("width\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(":\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*section3(1) css end*/\r\n");
      out.write(".text_fundraiser {\r\n");
      out.write("\tcolor: #0077A2;\r\n");
      out.write("\tfont-size: 4vw;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*CARDS CSS*/\r\n");
      out.write(".testimotionals {\r\n");
      out.write("\twidth: 20%;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tmargin-left: 50px;\r\n");
      out.write("\tmargin-top: 50px margin-left:100px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 350px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tbackground: #0077A2;\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\t/*\tbox-shadow: 0 10px 40px rgba(0, 0, 0, .5)*/\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .layer {\r\n");
      out.write("\t/*z-index: 1;*/\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: calc(100% - 2px);\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tbackground: linear-gradient(to left, #7FBD2c, #7FBD2c);\r\n");
      out.write("\ttransition: 0.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 {\r\n");
      out.write("\t/*\tz-index: 2;*/\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card:hover .layer {\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 p {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tline-height: 24px;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("\tmargin-top: -3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 .image {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tborder-radius: 50%;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tborder: 4px solid white;\r\n");
      out.write("\tbox-shadow: 0 10px 40px rgba(0, 0, 0, 0.5);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .conte nt .details h2 {\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card .content1 .details h2 span {\r\n");
      out.write("\tfont-size: 18px;\r\n");
      out.write("\tcolor: purple;\r\n");
      out.write("\ttransition: 0.5s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".testimotionals .card:hover .content1 .details h2 span {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tmargin-top: 7px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".para {\r\n");
      out.write("\theight: 110px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".boxed {\r\n");
      out.write("\tbackground-color: black;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 190px;\r\n");
      out.write("\tmargin-bottom: px;\r\n");
      out.write("\tmargin-top: -8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*END OF CARDS CSS*/\r\n");
      out.write("\r\n");
      out.write("/*section4 css*/\r\n");
      out.write(".section4 {\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tbackground-color: #0077A2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*end of section4 css*/\r\n");
      out.write("\r\n");
      out.write("/*section5 css*/\r\n");
      out.write(".fishes {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\ttop: -10px;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*start of class tag image with text*/\r\n");
      out.write(".tag {\r\n");
      out.write("\tfloat: Center;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tleft: 50px;\r\n");
      out.write("\ttop: 50px;\r\n");
      out.write("\tbackground-color: green;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*end*/\r\n");
      out.write(".fish {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: -18px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".section5 .content {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tbottom: 0;\r\n");
      out.write("\tbackground: white;\r\n");
      out.write("\t/* Fallback color */\r\n");
      out.write("\t/* background: rgba(0, 0, 0, 0.2);*/\r\n");
      out.write("\t/* Black background with 0.2 opacity */\r\n");
      out.write("\tcolor: #f1f1f1;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tpadding: 60px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*end of section 5 css*/\r\n");
      out.write("\r\n");
      out.write("/*start of end carousel set 5 images*/\r\n");
      out.write(".slick-slide {\r\n");
      out.write("\tmargin: 0px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide img {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slider {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tbox-sizing: border-box;\r\n");
      out.write("\t-webkit-user-select: none;\r\n");
      out.write("\t-moz-user-select: none;\r\n");
      out.write("\t-ms-user-select: none;\r\n");
      out.write("\tuser-select: none;\r\n");
      out.write("\t-webkit-touch-callout: none;\r\n");
      out.write("\t-khtml-user-select: none;\r\n");
      out.write("\t-ms-touch-action: pan-y;\r\n");
      out.write("\ttouch-action: pan-y;\r\n");
      out.write("\t-webkit-tap-highlight-color: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list:focus {\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list.dragging {\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tcursor: hand;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slider .slick-track, .slick-slider .slick-list {\r\n");
      out.write("\t-webkit-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t-moz-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t-ms-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t-o-transform: translate3d(0, 0, 0);\r\n");
      out.write("\ttransform: translate3d(0, 0, 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track:before, .slick-track:after {\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("\tcontent: '';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track:after {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-loading .slick-track {\r\n");
      out.write("\tvisibility: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmin-height: 1px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("[dir='rtl'] .slick-slide {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide img {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide.slick-loading img {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide.dragging img {\r\n");
      out.write("\tpointer-events: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-initialized .slick-slide {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-loading .slick-slide {\r\n");
      out.write("\tvisibility: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-vertical .slick-slide {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tborder: 1px solid transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-arrow.slick-hidden {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*start of end carousel set 5 images*/\r\n");
      out.write("\r\n");
      out.write("/*start of submenunavbar*/\r\n");
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
      out.write("/*end of submenunavbar*/\r\n");
      out.write("\r\n");
      out.write("/*search icon css*/\r\n");
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
      out.write("\tpadding: 9px 0px 9px 0px;\r\n");
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
      out.write("/*code u may delete*/\r\n");
      out.write("a {\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("\tcolor: #7FBD2C;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("\tfont: 1.7em;\r\n");
      out.write("\tline-height: 110%;\r\n");
      out.write("\tcolor: #000;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("\tmargin: 0 0 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
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
      out.write("#grad2 {\r\n");
      out.write("\theight: 500px;\r\n");
      out.write("\tbackground-color: red;\r\n");
      out.write("\t/* For browsers that do not support gradients */\r\n");
      out.write("\tbackground-image: linear-gradient(to right, #7FBD2C, #0077A2);\r\n");
      out.write("\t/* Standard syntax (must be last) */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*sticked navbar css*/\r\n");
      out.write("/*.content {\r\n");
      out.write("  padding: 16px;\r\n");
      out.write("}*/\r\n");
      out.write(".sticky {\r\n");
      out.write("\tposition: fixed;\r\n");
      out.write("\ttop: 0px;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".sticky+.content {\r\n");
      out.write("\tpadding-top: 60px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*images responsiveness*/\r\n");
      out.write("@media only screen and (max-width:100%) {\r\n");
      out.write("\t.fishes\r\n");
      out.write("\t,\r\n");
      out.write("\t.fish\r\n");
      out.write("\t,\r\n");
      out.write("\t{\r\n");
      out.write("\theight:auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("@media only screen and (max-width:100%) {\r\n");
      out.write("\t.community, .rural, .senior, .animals, .disability, .emergrncies,\r\n");
      out.write("\t\t.welfare, .development, .citizens, .animals1, .disability1,\r\n");
      out.write("\t\t.emergencies1 {\r\n");
      out.write("\t\theight: auto;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media only screen and (max-width:100%) {\r\n");
      out.write("\t.trial\r\n");
      out.write("\t,\r\n");
      out.write("\t.trial1\r\n");
      out.write("\t,\r\n");
      out.write("\t.trial2\r\n");
      out.write("\t,\r\n");
      out.write("\t.logoimg\r\n");
      out.write("\t,\r\n");
      out.write("\t.bannerimg\r\n");
      out.write("\t,\r\n");
      out.write("\t{\r\n");
      out.write("\theight\t:auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*end of images responsiveness*/\r\n");
      out.write("/*css of liferay code ends*/\r\n");
      out.write("\r\n");
      out.write("/*code for carousel offffffffffffffffffffffffffffffffffffffff 5 */\r\n");
      out.write(".slick-slide {\r\n");
      out.write("\tmargin: 0px 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide img {\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slider {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tbox-sizing: border-box;\r\n");
      out.write("\t-webkit-user-select: none;\r\n");
      out.write("\t-moz-user-select: none;\r\n");
      out.write("\t-ms-user-select: none;\r\n");
      out.write("\tuser-select: none;\r\n");
      out.write("\t-webkit-touch-callout: none;\r\n");
      out.write("\t-khtml-user-select: none;\r\n");
      out.write("\t-ms-touch-action: pan-y;\r\n");
      out.write("\ttouch-action: pan-y;\r\n");
      out.write("\t-webkit-tap-highlight-color: transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list:focus {\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-list.dragging {\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("\tcursor: hand;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slider .slick-track, .slick-slider .slick-list {\r\n");
      out.write("\t-webkit-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t-moz-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t-ms-transform: translate3d(0, 0, 0);\r\n");
      out.write("\t-o-transform: translate3d(0, 0, 0);\r\n");
      out.write("\ttransform: translate3d(0, 0, 0);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track {\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track:before, .slick-track:after {\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("\tcontent: '';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-track:after {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-loading .slick-track {\r\n");
      out.write("\tvisibility: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmin-height: 1px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("[dir='rtl'] .slick-slide {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide img {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide.slick-loading img {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-slide.dragging img {\r\n");
      out.write("\tpointer-events: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-initialized .slick-slide {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-loading .slick-slide {\r\n");
      out.write("\tvisibility: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-vertical .slick-slide {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tborder: 1px solid transparent;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".slick-arrow.slick-hidden {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write(".portlet-decorate .portlet-content {\r\n");
      out.write("    background-color: #FFF;\r\n");
      out.write("    border: 1px solid #E7E7ED;\r\n");
      out.write("    border-radius: 0.5rem;\r\n");
      out.write("     padding: 0px;\r\n");
      out.write("     margin-top: 60px;\r\n");
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
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${CategoryURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.print( categoryDetails.getCATEGORY_NAME() );
      out.write("</a>\r\n");
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
      out.write("\t\t\t\t<a href=\"/c/portal/logout\" style=\"background: #7FBD2C;float:right\">LOGOUT</a>\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\t<input type=\"search\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("<form class=\"mayborderForm\" >\r\n");
      out.write("<table id=\"example\" class=\"display\" style=\"width:100%\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>No.</th>\r\n");
      out.write("\t\t\t\t<th>Campaign Title</th>\r\n");
      out.write("\t\t\t\t<th >Required Fund</th>\r\n");
      out.write("\t\t\t\t<th>Creation Date</th>\r\n");
      out.write("\t\t\t\t<th>Status</th>\r\n");
      out.write("\t\t\t\t<th>Requested Status</th>\r\n");
      out.write("\t\t\t\t<th>Action</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t  ");
 for(ProjectRegistration projectObj: reverse){ 
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  ");
 projectId = projectObj.getPROJECT_ID();
			 	 String normalDoubleValue = String.format("%.0f",projectObj.getREQUIRED_FUND_AMOUNT());
			  
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_1 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_1.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_1.setParent(null);
      _jspx_th_portlet_renderURL_1.setVar("ProjectDetailURL");
      _jspx_th_portlet_renderURL_1.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_1 = _jspx_th_portlet_renderURL_1.doStartTag();
      if (_jspx_eval_portlet_renderURL_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_2 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_2.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
        _jspx_th_portlet_param_2.setName("ProjectId");
        _jspx_th_portlet_param_2.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_2 = _jspx_th_portlet_param_2.doStartTag();
        if (_jspx_th_portlet_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_2);
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_portlet_param_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_1, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t  ");
      }
      if (_jspx_th_portlet_renderURL_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_1);
      java.lang.String ProjectDetailURL = null;
      ProjectDetailURL = (java.lang.String) _jspx_page_context.findAttribute("ProjectDetailURL");
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t   ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_2 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_2.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_2.setParent(null);
      _jspx_th_portlet_renderURL_2.setVar("EditCampaignURL");
      _jspx_th_portlet_renderURL_2.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_2 = _jspx_th_portlet_renderURL_2.doStartTag();
      if (_jspx_eval_portlet_renderURL_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_4 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_4.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_2);
        _jspx_th_portlet_param_4.setName("ProjectId");
        _jspx_th_portlet_param_4.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_4 = _jspx_th_portlet_param_4.doStartTag();
        if (_jspx_th_portlet_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_4);
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        if (_jspx_meth_portlet_param_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_2, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t  ");
      }
      if (_jspx_th_portlet_renderURL_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_2);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_2);
      java.lang.String EditCampaignURL = null;
      EditCampaignURL = (java.lang.String) _jspx_page_context.findAttribute("EditCampaignURL");
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_3 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_3.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_3.setParent(null);
      _jspx_th_portlet_renderURL_3.setVar("ProjectUpdateURL");
      _jspx_th_portlet_renderURL_3.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_3 = _jspx_th_portlet_renderURL_3.doStartTag();
      if (_jspx_eval_portlet_renderURL_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_6 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_6.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_3);
        _jspx_th_portlet_param_6.setName("ProjectId");
        _jspx_th_portlet_param_6.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_6 = _jspx_th_portlet_param_6.doStartTag();
        if (_jspx_th_portlet_param_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_6);
        out.write("\r\n");
        out.write("\t\t\t\t\t");
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
      java.lang.String ProjectUpdateURL = null;
      ProjectUpdateURL = (java.lang.String) _jspx_page_context.findAttribute("ProjectUpdateURL");
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_4 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_4.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_4.setParent(null);
      _jspx_th_portlet_renderURL_4.setVar("UploadAcknowledgementURL");
      _jspx_th_portlet_renderURL_4.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_4 = _jspx_th_portlet_renderURL_4.doStartTag();
      if (_jspx_eval_portlet_renderURL_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_8 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_8.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_4);
        _jspx_th_portlet_param_8.setName("ProjectId");
        _jspx_th_portlet_param_8.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_8 = _jspx_th_portlet_param_8.doStartTag();
        if (_jspx_th_portlet_param_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_8);
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_portlet_param_9((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_4, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t ");
      }
      if (_jspx_th_portlet_renderURL_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_4);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_4);
      java.lang.String UploadAcknowledgementURL = null;
      UploadAcknowledgementURL = (java.lang.String) _jspx_page_context.findAttribute("UploadAcknowledgementURL");
      out.write("\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_5 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_5.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_5.setParent(null);
      _jspx_th_portlet_renderURL_5.setVar("ChangeProjectCategoryURL");
      _jspx_th_portlet_renderURL_5.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_5 = _jspx_th_portlet_renderURL_5.doStartTag();
      if (_jspx_eval_portlet_renderURL_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_10 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_10.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_5);
        _jspx_th_portlet_param_10.setName("ProjectId");
        _jspx_th_portlet_param_10.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_10 = _jspx_th_portlet_param_10.doStartTag();
        if (_jspx_th_portlet_param_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_10);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_10);
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_portlet_param_11((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_5, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t ");
      }
      if (_jspx_th_portlet_renderURL_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_5);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_5);
      java.lang.String ChangeProjectCategoryURL = null;
      ChangeProjectCategoryURL = (java.lang.String) _jspx_page_context.findAttribute("ChangeProjectCategoryURL");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t  ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_6 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_6.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_6.setParent(null);
      _jspx_th_portlet_renderURL_6.setVar("popupUrl");
      _jspx_th_portlet_renderURL_6.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_6 = _jspx_th_portlet_renderURL_6.doStartTag();
      if (_jspx_eval_portlet_renderURL_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_12 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_12.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_6);
        _jspx_th_portlet_param_12.setName("ProjectId");
        _jspx_th_portlet_param_12.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_12 = _jspx_th_portlet_param_12.doStartTag();
        if (_jspx_th_portlet_param_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_12);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_12);
        out.write("\r\n");
        out.write("\t\t\t \t");
        if (_jspx_meth_portlet_param_13((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_6, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t  ");
      }
      if (_jspx_th_portlet_renderURL_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_6);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_6);
      java.lang.String popupUrl = null;
      popupUrl = (java.lang.String) _jspx_page_context.findAttribute("popupUrl");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t  ");
      //  portlet:renderURL
      com.liferay.taglib.portlet.RenderURLTag _jspx_th_portlet_renderURL_7 = (com.liferay.taglib.portlet.RenderURLTag) _jspx_tagPool_portlet_renderURL_windowState_var.get(com.liferay.taglib.portlet.RenderURLTag.class);
      _jspx_th_portlet_renderURL_7.setPageContext(_jspx_page_context);
      _jspx_th_portlet_renderURL_7.setParent(null);
      _jspx_th_portlet_renderURL_7.setVar("DaysExtendeDetailsURL");
      _jspx_th_portlet_renderURL_7.setWindowState("normal");
      int _jspx_eval_portlet_renderURL_7 = _jspx_th_portlet_renderURL_7.doStartTag();
      if (_jspx_eval_portlet_renderURL_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        out.write("\r\n");
        out.write("\t\t\t\t");
        //  portlet:param
        com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_14 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
        _jspx_th_portlet_param_14.setPageContext(_jspx_page_context);
        _jspx_th_portlet_param_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_7);
        _jspx_th_portlet_param_14.setName("ProjectId");
        _jspx_th_portlet_param_14.setValue( String.valueOf(projectObj.getPROJECT_ID()) );
        int _jspx_eval_portlet_param_14 = _jspx_th_portlet_param_14.doStartTag();
        if (_jspx_th_portlet_param_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_14);
          return;
        }
        _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_14);
        out.write("\r\n");
        out.write("\t\t\t \t");
        if (_jspx_meth_portlet_param_15((javax.servlet.jsp.tagext.JspTag) _jspx_th_portlet_renderURL_7, _jspx_page_context))
          return;
        out.write("\r\n");
        out.write("\t\t\t  ");
      }
      if (_jspx_th_portlet_renderURL_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_7);
        return;
      }
      _jspx_tagPool_portlet_renderURL_windowState_var.reuse(_jspx_th_portlet_renderURL_7);
      java.lang.String DaysExtendeDetailsURL = null;
      DaysExtendeDetailsURL = (java.lang.String) _jspx_page_context.findAttribute("DaysExtendeDetailsURL");
      out.write("\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print( counter );
      out.write("</td>\r\n");
      out.write("\t\t\t\t <td>");
      out.print( projectObj.getTITLE() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t <td >");
      out.print( normalDoubleValue );
      out.write("</td>\r\n");
      out.write("\t\t\t\t <td>");
      out.print( formatter.format(projectObj.getCREATION_DATE()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t ");
 if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t\t <td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_0_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_1_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_3_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t\t <td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_4_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getSTATUS()== CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5_TEXT );
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t ");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t ");
 if(projectObj.getREQUEST_STATUS()==CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t ");
 } if(projectObj.getREQUEST_STATUS()==1){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_1_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t \t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getREQUEST_STATUS()==2){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getREQUEST_STATUS()==3){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_3_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getREQUEST_STATUS()==4){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_4_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getREQUEST_STATUS()==5){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_5_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getREQUEST_STATUS()==6){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_6_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getREQUEST_STATUS()==7){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_7_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t ");
 }if(projectObj.getREQUEST_STATUS()==8){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_8_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getREQUEST_STATUS()==9){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_9_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 }if(projectObj.getREQUEST_STATUS()==10){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print( CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_10_TEXT );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t <th>\r\n");
      out.write("\t\t\t\t \t");
      //  liferay-ui:icon-menu
      com.liferay.taglib.ui.IconMenuTag _jspx_th_liferay$1ui_icon$1menu_0 = (com.liferay.taglib.ui.IconMenuTag) _jspx_tagPool_liferay$1ui_icon$1menu.get(com.liferay.taglib.ui.IconMenuTag.class);
      _jspx_th_liferay$1ui_icon$1menu_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1ui_icon$1menu_0.setParent(null);
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
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t \t");
 if(projectObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_2){ 
					 		
					 		if(projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_1 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_3 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_6){ 
          out.write("\r\n");
          out.write("\t\t\t\t\t \t\t\t");
          if (_jspx_meth_liferay$1ui_icon_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
            return;
          out.write(" \r\n");
          out.write("\t\t\t\t\t \t\t\t");
          if (_jspx_meth_liferay$1ui_icon_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t \t\t\t\r\n");
          out.write("\t\t\t\t\t \t\t");
 } if(projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_0 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_1 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_2 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_5 || projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_3){ 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_liferay$1ui_icon_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t");
 } if(projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_5){ 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          if (_jspx_meth_liferay$1ui_icon_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
 } 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t");
 } 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
 if(projectObj.getSTATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_STATUS_5){ 
							if(projectObj.getREQUEST_STATUS() == CrowdFundingBenificiaryDetailsPortletKeys.Project_REQUESTED_STATUS_3){ 
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_liferay$1ui_icon_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_liferay$1ui_icon$1menu_0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
 	} 
						  } 
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
        return;
      }
      _jspx_tagPool_liferay$1ui_icon$1menu.reuse(_jspx_th_liferay$1ui_icon$1menu_0);
      out.write("\r\n");
      out.write("\t\t\t\t </th>\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

			projectId = 0;
			   counter++;
			
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<div class=\"footer\" style=\"background-color:#002a3a;\"><!--start of footer-->\r\n");
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

  private boolean _jspx_meth_portlet_param_3(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_3 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_3.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_1);
    _jspx_th_portlet_param_3.setName("jspPage");
    _jspx_th_portlet_param_3.setValue("/jsp/MyCampaign/CampaignDetails.jsp");
    int _jspx_eval_portlet_param_3 = _jspx_th_portlet_param_3.doStartTag();
    if (_jspx_th_portlet_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_3);
    return false;
  }

  private boolean _jspx_meth_portlet_param_5(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_5 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_5.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_2);
    _jspx_th_portlet_param_5.setName("jspPage");
    _jspx_th_portlet_param_5.setValue("/jsp/MyCampaign/EditCampaignDetails.jsp");
    int _jspx_eval_portlet_param_5 = _jspx_th_portlet_param_5.doStartTag();
    if (_jspx_th_portlet_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_5);
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
    _jspx_th_portlet_param_7.setValue("/jsp/MyCampaign/ProjectUpdate.jsp");
    int _jspx_eval_portlet_param_7 = _jspx_th_portlet_param_7.doStartTag();
    if (_jspx_th_portlet_param_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_7);
    return false;
  }

  private boolean _jspx_meth_portlet_param_9(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_4, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_9 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_9.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_4);
    _jspx_th_portlet_param_9.setName("jspPage");
    _jspx_th_portlet_param_9.setValue("/jsp/MyCampaign/ProjectUploadAcknowledgement.jsp");
    int _jspx_eval_portlet_param_9 = _jspx_th_portlet_param_9.doStartTag();
    if (_jspx_th_portlet_param_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_9);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_9);
    return false;
  }

  private boolean _jspx_meth_portlet_param_11(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_5, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_11 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_11.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_5);
    _jspx_th_portlet_param_11.setName("jspPage");
    _jspx_th_portlet_param_11.setValue("/jsp/MyCampaign/ChangeProjectCategory.jsp");
    int _jspx_eval_portlet_param_11 = _jspx_th_portlet_param_11.doStartTag();
    if (_jspx_th_portlet_param_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_11);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_11);
    return false;
  }

  private boolean _jspx_meth_portlet_param_13(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_6, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_13 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_13.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_6);
    _jspx_th_portlet_param_13.setName("jspPage");
    _jspx_th_portlet_param_13.setValue("/jsp/MyCampaign/RequestFundAmt.jsp");
    int _jspx_eval_portlet_param_13 = _jspx_th_portlet_param_13.doStartTag();
    if (_jspx_th_portlet_param_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_13);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_13);
    return false;
  }

  private boolean _jspx_meth_portlet_param_15(javax.servlet.jsp.tagext.JspTag _jspx_th_portlet_renderURL_7, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  portlet:param
    com.liferay.taglib.util.ParamTag _jspx_th_portlet_param_15 = (com.liferay.taglib.util.ParamTag) _jspx_tagPool_portlet_param_value_name_nobody.get(com.liferay.taglib.util.ParamTag.class);
    _jspx_th_portlet_param_15.setPageContext(_jspx_page_context);
    _jspx_th_portlet_param_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_portlet_renderURL_7);
    _jspx_th_portlet_param_15.setName("jspPage");
    _jspx_th_portlet_param_15.setValue("/jsp/MyCampaign/CampaignDateOver.jsp");
    int _jspx_eval_portlet_param_15 = _jspx_th_portlet_param_15.doStartTag();
    if (_jspx_th_portlet_param_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_15);
      return true;
    }
    _jspx_tagPool_portlet_param_value_name_nobody.reuse(_jspx_th_portlet_param_15);
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
    _jspx_th_liferay$1ui_icon_0.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ProjectDetailURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
    _jspx_th_liferay$1ui_icon_1.setMessage("Project Update");
    _jspx_th_liferay$1ui_icon_1.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ProjectUpdateURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
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
    _jspx_th_liferay$1ui_icon_2.setMessage("Edit Campaign");
    _jspx_th_liferay$1ui_icon_2.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${EditCampaignURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_2 = _jspx_th_liferay$1ui_icon_2.doStartTag();
    if (_jspx_th_liferay$1ui_icon_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_2);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_3(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_3 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_3.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
    _jspx_th_liferay$1ui_icon_3.setImage("edit");
    _jspx_th_liferay$1ui_icon_3.setMessage("Request for Fund Withdraw");
    _jspx_th_liferay$1ui_icon_3.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${popupUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_3 = _jspx_th_liferay$1ui_icon_3.doStartTag();
    if (_jspx_th_liferay$1ui_icon_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_3);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_3);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_4(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_4 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_4.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
    _jspx_th_liferay$1ui_icon_4.setImage("edit");
    _jspx_th_liferay$1ui_icon_4.setMessage("Request for Days Extende");
    _jspx_th_liferay$1ui_icon_4.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${DaysExtendeDetailsURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_4 = _jspx_th_liferay$1ui_icon_4.doStartTag();
    if (_jspx_th_liferay$1ui_icon_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_4);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_4);
    return false;
  }

  private boolean _jspx_meth_liferay$1ui_icon_5(javax.servlet.jsp.tagext.JspTag _jspx_th_liferay$1ui_icon$1menu_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  liferay-ui:icon
    com.liferay.taglib.ui.IconTag _jspx_th_liferay$1ui_icon_5 = (com.liferay.taglib.ui.IconTag) _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.get(com.liferay.taglib.ui.IconTag.class);
    _jspx_th_liferay$1ui_icon_5.setPageContext(_jspx_page_context);
    _jspx_th_liferay$1ui_icon_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_liferay$1ui_icon$1menu_0);
    _jspx_th_liferay$1ui_icon_5.setImage("edit");
    _jspx_th_liferay$1ui_icon_5.setMessage("Upload Acknowledgement");
    _jspx_th_liferay$1ui_icon_5.setUrl((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${UploadAcknowledgementURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_liferay$1ui_icon_5 = _jspx_th_liferay$1ui_icon_5.doStartTag();
    if (_jspx_th_liferay$1ui_icon_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_5);
      return true;
    }
    _jspx_tagPool_liferay$1ui_icon_url_message_image_nobody.reuse(_jspx_th_liferay$1ui_icon_5);
    return false;
  }
}
