package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Usuario;
import Controlador.UsuarioControlador;

public final class cuenta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Mi cuenta</title>\n");
      out.write("            <style>\n");
      out.write("            body {\n");
      out.write("                background:  #000000;\n");
      out.write("                font-size: 62.5%;\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          .container {\n");
      out.write("            padding: 2em;\n");
      out.write("            margin-top: 5%;\n");
      out.write("          }\n");
      out.write("\n");
      out.write("\n");
      out.write("          a{\n");
      out.write("              text-decoration: none;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          .contenedor {\n");
      out.write("            width:400px;\n");
      out.write("            background: none;\n");
      out.write("            border: 3px solid #fff;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            color: #fff;\n");
      out.write("            display: block;\n");
      out.write("            font-size: 1.6em;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin: 1em auto;\n");
      out.write("            padding: 2em 6em;\n");
      out.write("            position: relative;\n");
      out.write("            text-transform: uppercase;         \n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          /* GENERAL BUTTON STYLING */\n");
      out.write("          button,\n");
      out.write("          button::after {\n");
      out.write("            -webkit-transition: all 0.3s;\n");
      out.write("                  -moz-transition: all 0.3s;\n");
      out.write("            -o-transition: all 0.3s;\n");
      out.write("                  transition: all 0.3s;\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          a{\n");
      out.write("              text-decoration: none;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("          button {\n");
      out.write("            width: 400px;\n");
      out.write("            height : 100px;\n");
      out.write("            background: none;\n");
      out.write("            border: 3px solid #fff;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            color: #fff;\n");
      out.write("            display: block;\n");
      out.write("            font-size: 1.6em;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin: 1em auto;\n");
      out.write("            padding: 2em 6em;\n");
      out.write("            position: relative;\n");
      out.write("            text-transform: uppercase;         \n");
      out.write("          }\n");
      out.write("\n");
      out.write("          button::before,\n");
      out.write("          button::after {\n");
      out.write("            background: #fff;\n");
      out.write("            content: '';\n");
      out.write("            position: absolute;\n");
      out.write("            z-index: -1;\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          button:hover {\n");
      out.write("            color: #000000;\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          /* BUTTON 1 */\n");
      out.write("          .btn-1::after {\n");
      out.write("            height: 0;\n");
      out.write("            left: 0;\n");
      out.write("            top: 0;\n");
      out.write("            width: 100%;\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          .btn-1:hover:after {\n");
      out.write("            height: 100%;\n");
      out.write("          }\n");
      out.write("          </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <div class=\"contenedor\">\n");
      out.write("        ");
 
            String nombre = (String) session.getAttribute("logueado");
            UsuarioControlador uc = new UsuarioControlador();
            Usuario u = uc.seleccionarUsuarioNombre(nombre);
            
            out.println("<label>Nombre : " + u.getNombre()+ "</label></p>");
            out.println("<label>Dni : " + u.getDni()+ "</label></p>");
            out.println("<label>Dirección : " + u.getDireccion()+ "</label></p>");
            out.println("<label>Teléfono : " + u.getTelefono()+ "</label></p>");
            out.println("<label>Email : " + u.getEmail()+ "</label></p>");
            out.println("</div>");
            out.println("<form action='modificarUsuario.jsp' method='POST'><button class='btn-1' type='submit' name='modificar' value='" + u.getId() + "'>Modificar</button></form>");
            out.println("<a href='VistaUsuario.jsp'><button class='btn-1'>Volver</button></a>");
        
      out.write("\n");
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
