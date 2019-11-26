package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(6);
    _jspx_dependants.add("/META-INF/c.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet_2_0.tld");
    _jspx_dependants.add("/META-INF/liferay-aui.tld");
    _jspx_dependants.add("/META-INF/liferay-portlet-ext.tld");
    _jspx_dependants.add("/META-INF/liferay-theme.tld");
    _jspx_dependants.add("/META-INF/liferay-ui.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
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
      out.write("<link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("<script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    <!--<link rel=\"stylesheet\" href=\"user.css\">-->\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            margin-top: 100px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("            color: #3AADA1;\r\n");
      out.write("        }\r\n");
      out.write(".nav>li>a:focus, .nav>li>a:hover {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    background-color: #bf221d;\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <center>\r\n");
      out.write("                        <h2><b>User Management</b></h2>\r\n");
      out.write("                    </center>\r\n");
      out.write("                    <br /><br />\r\n");
      out.write("                    <div class=\"panel panel-default\">\r\n");
      out.write("                        <div class=\"panel-heading\">\r\n");
      out.write("                            <h4><b>Manage User</b></h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            <div class=\"col-sm-1\"></div>\r\n");
      out.write("                            <div class=\"col-sm-5\">\r\n");
      out.write("                                <form>\r\n");
      out.write("\r\n");
      out.write("                                    <!--<div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"customer_name\">Customer Name</label>:\r\n");
      out.write("                                        <select class=\"form-control\" id=\"customer_name\">\r\n");
      out.write("                                            <option>Select</option>\r\n");
      out.write("                                            <option>2</option>\r\n");
      out.write("                                            <option>3</option>\r\n");
      out.write("                                            <option>4</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>-->\r\n");
      out.write("\r\n");
      out.write("                                    <!--<div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"facility_name\">Facility Name</label>:\r\n");
      out.write("                                        <select class=\"form-control\" id=\"facility_name\">\r\n");
      out.write("                                            <option>Select</option>\r\n");
      out.write("                                            <option>2</option>\r\n");
      out.write("                                            <option>3</option>\r\n");
      out.write("                                            <option>4</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>-->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"full_name\">Full Name</label>:\r\n");
      out.write("                                        <input type=\"name\" class=\"form-control\" id=\"full_name\" placeholder=\"Enter Full Name\" name=\"first_name\" onblur=\"validateEmail(this);\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"role\">Role</label>:\r\n");
      out.write("                                        <select class=\"form-control\" id=\"role\">\r\n");
      out.write("                                            <option>Select</option>\r\n");
      out.write("                                            <option>Admin</option>\r\n");
      out.write("                                            <option>Manager</option>\r\n");
      out.write("                                        </select>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"email\">Email</label>:\r\n");
      out.write("                                        <input type=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Enter Email\" name=\"email\" onblur=\"validateEmail(this);\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </form>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-5\">\r\n");
      out.write("\r\n");
      out.write("                                <form>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"user_name\">Username</label>:\r\n");
      out.write("                                        <input type=\"name\" class=\"form-control\" id=\"user_name\" placeholder=\"Enter User Name\" name=\"user_name\" onblur=\"validateEmail(this);\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"password\">Password</label>:\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter Password\" name=\"password\" onblur=\"validateEmail(this);\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                  \r\n");
      out.write("                                    <!-- <div class=\"checkbox\">\r\n");
      out.write("                                        <label><input type=\"checkbox\" value=\"\"><b>Active</b></label>\r\n");
      out.write("                                    </div>-->\r\n");
      out.write("                                    <div class=\"form-group\">\r\n");
      out.write("                                        <label for=\"phone\">Phone Number</label>:\r\n");
      out.write("                                        <input type=\"phone\" class=\"form-control\" id=\"phone\" placeholder=\"Enter Phone Number\" name=\"phone\" onblur=\"validateEmail(this);\" required>\r\n");
      out.write("                                    </div>\r\n");
      out.write("\r\n");
      out.write("                                </form>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-1\"></div>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"panel-footer\">\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-sm-12\">\r\n");
      out.write("                                    <div class=\"col-sm-8\"></div>\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-lg btn-primary\"><span class=\"glyphicon glyphicon-floppy-saved\"></span>&nbsp;Save</button>\r\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-lg btn-danger\"><span class=\"\tglyphicon glyphicon-remove\"></span>&nbsp;Cancel</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("       ");
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
}
