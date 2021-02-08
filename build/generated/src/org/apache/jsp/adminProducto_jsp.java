package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Producto;
import Controlador.ProductoControlador;
import java.util.ArrayList;
import java.util.List;
import Modelo.Usuario;
import Controlador.UsuarioControlador;

public final class adminProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Administración de usuarios</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 if(session.getAttribute("usuarioModificado")!=null){
                                out.println(session.getAttribute("usuarioModificado"));
                                session.setAttribute("usuarioModificado", "");
                            }   
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr><th></th><th>Nombre</th><th>Código</th><th>Descripción</th><th>Precio</th><th></th><th></th></tr>\n");
      out.write("            \n");
      out.write("        ");
 
            
            ProductoControlador uc = new ProductoControlador();
            List<Producto> productos = new ArrayList<Producto>();
            productos = uc.findAllProductos();
            for(Producto p : productos){
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre()+ "</td>");
                out.println("<td>" + p.getCodigo()+ "</td>");
                out.println("<td>" + p.getDescripcion()+ "</td>");
                out.println("<td>" + p.getPrecio()+ "€</td>");
                out.println("<td><form action='modificarUsuario.jsp' method='POST'><button type='submit' name='modificar' value='" + p.getId() + "'>Modificar</button></form></td>");
                out.println("<td><form action='sUsuario' method='POST'><button type='submit' name='eliminar' value='" + p.getId() + "'>Eliminar</button></form></td>");
                out.println("</tr>");
                }
            
            
        
      out.write("\n");
      out.write("            </table>\n");
      out.write("            ");
 
                out.println("<td><form action='venderProducto.jsp' method='POST'><button type='submit' name='modificar' value=''>Agregar Producto</button></form></td>");
            
      out.write("\n");
      out.write("                </br>\n");
      out.write("            <a href=\"VistaAdministrador.jsp\"><button>Volver</button></a>\n");
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
