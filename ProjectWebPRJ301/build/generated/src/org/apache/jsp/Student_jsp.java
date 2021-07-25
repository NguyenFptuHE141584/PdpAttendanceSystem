package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Student_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"css.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"headercontain\">\n");
      out.write("                <h1>PDP University Academic Portal</h1>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"infor\">\n");
      out.write("            <div class=\"home\">\n");
      out.write("                <a href=\"\">Home</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"infor_name\">\n");
      out.write("                <a href=\"UserDetail\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                <a href=\"Logout\">Logout</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <main>\n");
      out.write("            <div class=\"main_contain\">\n");
      out.write("                <div class=\"main_left\">\n");
      out.write("                    <h1>News</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"main_right\">\n");
      out.write("                    <h1>Academic Information</h1>\n");
      out.write("                    <div class=\"main_right_contain\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"\">View weekly timetable</a></li>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <li><a href=\"\">view attedance</a></li>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <li><a href=\"\">Report</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <br/>\n");
      out.write("            <b>Mọi góp ý, thắc mắc xin liên hệ: </b>\n");
      out.write("            <span style=\"color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;\">Phòng dịch vụ sinh viên</span>: Email: <a href=\"mailto:dichvusinhvien@fe.edu.vn\">dichvusinhvien@pdp.edu.vn</a>.\n");
      out.write("            Điện thoại: <span class=\"style1\"style=\"color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;\">0945298989</span>\n");
      out.write("            <br />\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
