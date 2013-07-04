package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class results_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <title>SECK Results</title>\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("\t        body {\r\n");
      out.write("\t\t\t  padding-top: 40px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        </style>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-responsive.min.css\">\r\n");
      out.write("        \r\n");
      out.write("        <!-- User Defined CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!--[if lt IE 7]>\r\n");
      out.write("            <p class=\"chromeframe\">You are using an outdated browser. <a href=\"http://browsehappy.com/\">Upgrade your browser today</a> or <a href=\"http://www.google.com/chromeframe/?redirect=true\">install Google Chrome Frame</a> to better experience this site.</p>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("        \r\n");
      out.write("        <!-- Navbar begins -->\r\n");
      out.write("        <div class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("       \t\t<div class=\"navbar-inner\">\r\n");
      out.write("       \t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t        \t\t<a class=\"brand\" href=\"#\"><img src=\"img/logo.png\" /></a>\r\n");
      out.write("\t\t        \t<form class=\"navbar-search form-search\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-append\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"input-xxlarge search-query\" x-webkit-speech x-webkit-grammar=\"builtin:search\" placeholder=\"the term that was searched\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-inverse\"><i class=\"icon-search icon-white\"></i> Search</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("       \t</div>\r\n");
      out.write("       \t<!-- Navbar ends -->\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <!-- Search info begins -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("        \t<div class=\"row-fluid\">\r\n");
      out.write("        \t\t<div class=\"span-12 well\">\r\n");
      out.write("        \t\t\t\tPage 1 of 23476 documents matched for \"the term that was searched\"\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        \t\r\n");
      out.write("        \t<div class=\"row-fluid\">\r\n");
      out.write("        \t\t<div class=\"span-12 alert alert-error\">\r\n");
      out.write("        \t\t\t\tNo documents matched for \"the term that was searched\"!\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Search info ends -->\r\n");
      out.write("        \r\n");
      out.write("        <!-- Search results begin -->\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("        \t<ol>\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 1</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 85\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 2</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 75\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 3</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 65\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 4</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 55\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 5</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 45\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 6</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 35\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 7</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 25\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 8</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 15\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 9</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 5\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<li class=\"row-fluid\">\r\n");
      out.write("        \t\t\t<div class=\"offset1 span11\">\r\n");
      out.write("        \t\t\t\t<h3>\r\n");
      out.write("        \t\t\t\t\t<a href=\"#\">Result 10</a>\r\n");
      out.write("        \t\t\t\t\t<small>http://resulturl.com/example</small>\r\n");
      out.write("        \t\t\t\t</h3>\r\n");
      out.write("        \t\t\t\t<p>\r\n");
      out.write("        \t\t\t\t\tRelevancy score: 1\r\n");
      out.write("        \t\t\t\t</p>\r\n");
      out.write("        \t\t\t</div>\r\n");
      out.write("        \t\t</li>\r\n");
      out.write("        \t</ol>\r\n");
      out.write("        \t\r\n");
      out.write("        \t<div class=\"row-fluid\">\r\n");
      out.write("\t\t        <div class=\"pagination pagination-centered span12\">\r\n");
      out.write("\t\t\t\t  <ul>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">Prev</a></li>\r\n");
      out.write("\t\t\t\t    <li class=\"disabled\"><a href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">4</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">Next</a></li>\r\n");
      out.write("\t\t\t\t  </ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Search results end -->\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js\"></script>\r\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.8.2.min.js\"><\\/script>')</script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- User defined JS -->\r\n");
      out.write("        <script src=\"js/main.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
