package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Registro</title>\n");
      out.write("        <style>\n");
      out.write("            * {\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            *:focus {\n");
      out.write("                    outline: none;\n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("            font-family: Arial;\n");
      out.write("            background-color: #000000;\n");
      out.write("            padding: 50px;\n");
      out.write("            }\n");
      out.write("            .login {\n");
      out.write("            margin: 20px auto;\n");
      out.write("            width: 300px;\n");
      out.write("            }\n");
      out.write("            .login-screen {\n");
      out.write("            background-color: #FFF;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .app-title {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #777;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .login-form {\n");
      out.write("            text-align: center;\n");
      out.write("            }\n");
      out.write("            .control-group {\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input {\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: #ECF0F1;\n");
      out.write("            border: 2px solid #000000;\n");
      out.write("            border-radius: 3px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            font-weight: 200;\n");
      out.write("            padding: 10px 0;\n");
      out.write("            width: 250px;\n");
      out.write("            transition: border .5s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input:focus {\n");
      out.write("            border: 2px solid #3498DB;\n");
      out.write("            box-shadow: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn {\n");
      out.write("              border: 2px solid transparent;\n");
      out.write("              background: #000000;\n");
      out.write("              color: #fff;\n");
      out.write("              font-size: 16px;\n");
      out.write("              line-height: 25px;\n");
      out.write("              font-weight: bold;\n");
      out.write("              padding: 10px 0;\n");
      out.write("              text-decoration: none;\n");
      out.write("              text-shadow: none;\n");
      out.write("              border-radius: 3px;\n");
      out.write("              box-shadow: none;\n");
      out.write("              transition: 0.25s;\n");
      out.write("              display: block;\n");
      out.write("              width: 250px;\n");
      out.write("              margin: 0 auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .btn:hover {\n");
      out.write("              background: #fff;\n");
      out.write("              color: #000000;\n");
      out.write("              border: 3px solid #000000;\n");
      out.write("              border-radius: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        if(session.getAttribute("datosIncorrectos")!=null){
            out.println(session.getAttribute("datosIncorrectos"));
            session.setAttribute("datosIncorrectos", "");
        }            
        
      out.write("\n");
      out.write("     \n");
      out.write("        <div class=\"login\">\n");
      out.write("\t\t<div class=\"login-screen\">\n");
      out.write("                    <form action=\"sRegistrar\" method=\"post\" >\n");
      out.write("\t\t\t<div class=\"app-title\">\n");
      out.write("                            <h1>Registro</h1>\n");
      out.write("                            ");

                            if(session.getAttribute("datosIncorrectos")!=null){
                                out.println(session.getAttribute("datosIncorrectos"));
                                session.setAttribute("datosIncorrectos", "");
                            }            
                            
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"login-form\">\n");
      out.write("\t\t\t\t<div class=\"control-group\">\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"login-field\" value=\"\" name=\"usuario\" placeholder=\"Usuario\" id=\"login-name\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"control-group\">\n");
      out.write("\t\t\t\t<input type=\"password\" class=\"login-field\" value=\"\" name=\"pass\" placeholder=\"Contraseña\" id=\"login-pass\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                            \n");
      out.write("                                <div class=\"control-group\">\n");
      out.write("                                    <input type=\"text\" class=\"login-field\" value=\"\" name=\"dni\" placeholder=\"Dni\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                            \n");
      out.write("                                <div class=\"control-group\">\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"login-field\" value=\"\" name=\"direccion\" placeholder=\"Dirección\" >\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                            \n");
      out.write("                                <div class=\"control-group\">\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"login-field\" value=\"\" name=\"telefono\" placeholder=\"Teléfono\" >\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                            \n");
      out.write("                                <div class=\"control-group\">\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"login-field\" value=\"\" name=\"email\" placeholder=\"Email\" >\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                                \n");
      out.write("                                <input class=\"btn btn-primary btn-large btn-block\" type=\"submit\" name=\"Registrarse\" value=\"Registrarse\"></p>\n");
      out.write("\t\t\t\t<a class=\"btn btn-primary btn-large btn-block\" href=\"logeo.jsp\">Volver</a>\n");
      out.write("\t\t\t</div>\n");
      out.write("                    </form>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("        \n");
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
