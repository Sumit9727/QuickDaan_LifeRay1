package org.apache.jsp.asset_005faddon_005fentry_005fselector;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.portal.kernel.servlet.taglib.ui.AssetAddonEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.taglib.aui.AUIUtil;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

public final class page_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/asset_addon_entry_selector/init.jsp");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1ui_message_key_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_script_use;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_icon_markupView_image_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_button_value_name_cssClass_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1ui_message_key_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_script_use = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_icon_markupView_image_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_button_value_name_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1ui_message_key_nobody.release();
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_aui_script_use.release();
    _jspx_tagPool_aui_icon_markupView_image_nobody.release();
    _jspx_tagPool_aui_button_value_name_cssClass_nobody.release();
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write('\n');
      out.write('\n');

List<AssetAddonEntry> assetAddonEntries = (List<AssetAddonEntry>)request.getAttribute(WebKeys.ASSET_ADDON_ENTRIES);
String hiddenInput = (String)request.getAttribute("liferay-asset:asset-addon-entry-selector:hiddenInput");
String id = GetterUtil.getString((String)request.getAttribute("liferay-asset:asset-addon-entry-selector:id"));
List<AssetAddonEntry> selectedAssetAddonEntries = (List<AssetAddonEntry>)request.getAttribute("liferay-asset:asset-addon-entry-selector:selectedAssetAddonEntries");
String title = GetterUtil.getString((String)request.getAttribute("liferay-asset:asset-addon-entry-selector:title"));

PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

String namespace = AUIUtil.getNamespace(portletRequest, portletResponse);

      out.write("\n");
      out.write("\n");
      out.write("<div class=\"lfr-asset-addon-entry-selector\" id=\"");
      out.print( namespace + id );
      out.write("assetAddonEntrySelector\">\n");
      out.write("\t");
      //  aui:input
      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
      _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_input_0.setParent(null);
      _jspx_th_aui_input_0.setName( hiddenInput );
      _jspx_th_aui_input_0.setType("hidden");
      _jspx_th_aui_input_0.setValue( ListUtil.toString(selectedAssetAddonEntries, "key") );
      int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
      if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
        return;
      }
      _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
      out.write("\n");
      out.write("\n");
      out.write("\t<ul class=\"list-inline list-unstyled row selected-entries\">\n");
      out.write("\n");
      out.write("\t\t");

		for (AssetAddonEntry assetAddonEntry : selectedAssetAddonEntries) {
		
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<li class=\"col-md-4 list-entry\" data-key=\"");
      out.print( assetAddonEntry.getKey() );
      out.write("\" data-label=\"");
      out.print( assetAddonEntry.getLabel(locale) );
      out.write("\">\n");
      out.write("\t\t\t\t<div class=\"card card-horizontal card-type-directory\">\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\n");
      out.write("\t\t\t\t\t\t<div class=\"card-row\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"autofit-col autofit-col-expand autofit-col-gutters\">\n");
      out.write("\t\t\t\t\t\t\t\t<section class=\"autofit-section\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3 class=\"card-title\" title=\"{label}\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"text-truncate-inline\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span class=\"text-truncate\">");
      out.print( assetAddonEntry.getLabel(locale) );
      out.write("</span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t\t\t</h3>\n");
      out.write("\t\t\t\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"autofit-col\">\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"remove-button\" href=\"javascript:;\">\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_aui_icon_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</li>\n");
      out.write("\n");
      out.write("\t\t");

		}
		
      out.write("\n");
      out.write("\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("\t<div class=\"button-holder\">\n");
      out.write("\t\t");
      //  aui:button
      com.liferay.taglib.aui.ButtonTag _jspx_th_aui_button_0 = (com.liferay.taglib.aui.ButtonTag) _jspx_tagPool_aui_button_value_name_cssClass_nobody.get(com.liferay.taglib.aui.ButtonTag.class);
      _jspx_th_aui_button_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_button_0.setParent(null);
      _jspx_th_aui_button_0.setCssClass("select-button");
      _jspx_th_aui_button_0.setName( id + "selectButton" );
      _jspx_th_aui_button_0.setValue("select");
      int _jspx_eval_aui_button_0 = _jspx_th_aui_button_0.doStartTag();
      if (_jspx_th_aui_button_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_button_value_name_cssClass_nobody.reuse(_jspx_th_aui_button_0);
        return;
      }
      _jspx_tagPool_aui_button_value_name_cssClass_nobody.reuse(_jspx_th_aui_button_0);
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\n");
      //  aui:script
      com.liferay.taglib.aui.ScriptTag _jspx_th_aui_script_0 = (com.liferay.taglib.aui.ScriptTag) _jspx_tagPool_aui_script_use.get(com.liferay.taglib.aui.ScriptTag.class);
      _jspx_th_aui_script_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_script_0.setParent(null);
      _jspx_th_aui_script_0.setUse("liferay-asset-addon-entry-selector");
      int _jspx_eval_aui_script_0 = _jspx_th_aui_script_0.doStartTag();
      if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_aui_script_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_aui_script_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("\tvar assetAddonEntries = [];\n");
          out.write("\n");
          out.write("\t");

	for (AssetAddonEntry assetAddonEntry : assetAddonEntries) {
	
          out.write("\n");
          out.write("\n");
          out.write("\t\tassetAddonEntries.push(\n");
          out.write("\t\t\t{\n");
          out.write("\t\t\t\ticon: '");
          out.print( assetAddonEntry.getIcon() );
          out.write("',\n");
          out.write("\t\t\t\tkey: '");
          out.print( assetAddonEntry.getKey() );
          out.write("',\n");
          out.write("\t\t\t\tlabel: '");
          out.print( assetAddonEntry.getLabel(locale) );
          out.write("'\n");
          out.write("\t\t\t}\n");
          out.write("\t\t);\n");
          out.write("\n");
          out.write("\t");

	}
	
          out.write("\n");
          out.write("\n");
          out.write("\tvar selectedAssetAddonEntries = [];\n");
          out.write("\n");
          out.write("\t");

	for (AssetAddonEntry assetAddonEntry : selectedAssetAddonEntries) {
	
          out.write("\n");
          out.write("\n");
          out.write("\t\tselectedAssetAddonEntries.push('");
          out.print( assetAddonEntry.getKey() );
          out.write("');\n");
          out.write("\n");
          out.write("\t");

	}
	
          out.write("\n");
          out.write("\n");
          out.write("\tvar assetAddonEntrySelector = new Liferay.AssetAddonEntrySelector(\n");
          out.write("\t\t{\n");
          out.write("\t\t\tassetAddonEntries: assetAddonEntries,\n");
          out.write("\t\t\tdialogTitle: '");
          //  liferay-ui:message
          com.liferay.taglib.ui.MessageTag _jspx_th_liferay$1ui_message_0 = (com.liferay.taglib.ui.MessageTag) _jspx_tagPool_liferay$1ui_message_key_nobody.get(com.liferay.taglib.ui.MessageTag.class);
          _jspx_th_liferay$1ui_message_0.setPageContext(_jspx_page_context);
          _jspx_th_liferay$1ui_message_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_aui_script_0);
          _jspx_th_liferay$1ui_message_0.setKey( title );
          int _jspx_eval_liferay$1ui_message_0 = _jspx_th_liferay$1ui_message_0.doStartTag();
          if (_jspx_th_liferay$1ui_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
            return;
          }
          _jspx_tagPool_liferay$1ui_message_key_nobody.reuse(_jspx_th_liferay$1ui_message_0);
          out.write("',\n");
          out.write("\t\t\trootNode: '#");
          out.print( namespace + id );
          out.write("assetAddonEntrySelector',\n");
          out.write("\t\t\tselectedAssetAddonEntries: selectedAssetAddonEntries\n");
          out.write("\t\t}\n");
          out.write("\t);\n");
          int evalDoAfterBody = _jspx_th_aui_script_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_aui_script_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
      }
      if (_jspx_th_aui_script_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_0);
        return;
      }
      _jspx_tagPool_aui_script_use.reuse(_jspx_th_aui_script_0);
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

  private boolean _jspx_meth_aui_icon_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  aui:icon
    com.liferay.taglib.aui.IconTag _jspx_th_aui_icon_0 = (com.liferay.taglib.aui.IconTag) _jspx_tagPool_aui_icon_markupView_image_nobody.get(com.liferay.taglib.aui.IconTag.class);
    _jspx_th_aui_icon_0.setPageContext(_jspx_page_context);
    _jspx_th_aui_icon_0.setParent(null);
    _jspx_th_aui_icon_0.setImage("times");
    _jspx_th_aui_icon_0.setMarkupView("lexicon");
    int _jspx_eval_aui_icon_0 = _jspx_th_aui_icon_0.doStartTag();
    if (_jspx_th_aui_icon_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_aui_icon_markupView_image_nobody.reuse(_jspx_th_aui_icon_0);
      return true;
    }
    _jspx_tagPool_aui_icon_markupView_image_nobody.reuse(_jspx_th_aui_icon_0);
    return false;
  }
}
