package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<html>\n");
      out.write("<body>\n");
      out.write("<h1>SECK</h1>\n");
      out.write("\n");
      out.write("Search Engine Construction Kit (SECK) Demo page.  Below are the various web applications\n");
      out.write("demoing the tools and technologies used for making SECK.\n");
      out.write("\n");
      out.write("<h2>Obligatory \"Hello, World!\" Application</h2> \n");
      out.write("\n");
      out.write("<form action=\"/servlet/hello\" method=\"get\">\n");
      out.write("  <input type=\"text\" name=\"query\">\n");
      out.write("  <input type=\"submit\" value=\"Submit\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<!--<h2>Simple Search Desktop Search (SSDS)</h2> \n");
      out.write("\n");
      out.write("<form action=\"/servlet/simple-search\" method=\"get\">\n");
      out.write("  <input type=\"text\" name=\"search\" value=\"search item\">\n");
      out.write("  <input type=\"submit\" value=\"Submit\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<h2>Restlet Guestbook Demo</h2>\n");
      out.write("\n");
      out.write("<a href=\"/rest/helloworld\">Restlet Guestbook Demo</a>\n");
      out.write("\n");
      out.write("<h2>JSTL Demo </h2>\n");
      out.write("\n");
      out.write("<a href=\"/jstl.jsp\">Simple JSTL page</a> [currently broken]-->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}