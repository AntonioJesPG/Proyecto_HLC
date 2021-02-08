/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.CompraControlador;
import Controlador.ProductoControlador;
import Controlador.UsuarioControlador;
import Modelo.Compra;
import Modelo.Producto;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Drakthon
 */
@WebServlet(name = "sProductos", urlPatterns = {"/sProductos"})
public class sProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ProductoControlador pc = new ProductoControlador();
            CompraControlador cc = new CompraControlador();
            UsuarioControlador uc = new UsuarioControlador();
            HttpSession userSession = request.getSession();
            
            if(request.getParameter("comprar") != null){
                Producto p = pc.seleccionarProducto(Integer.parseInt(request.getParameter("comprar").trim()));
                Usuario u = uc.seleccionarUsuarioNombre((String)userSession.getAttribute("logueado"));
                int id = cc.contarCompras();
                
                if(u.getSaldo() - p.getPrecio() >= 0){
                    u.setSaldo(u.getSaldo() - p.getPrecio());
                    Compra c = new Compra(id,p.getNombre(),u.getNombre(), p.getPrecio());

                    uc.modificarUsuario(u);
                    cc.insertarCompra(c);
                    pc.eliminarProducto(p);

                    response.sendRedirect("comprarProductos.jsp");
                    userSession.setAttribute("mensaje", "Compra realizada correctamente");
                }
                else{
                    response.sendRedirect("comprarProductos.jsp");
                    userSession.setAttribute("mensaje", "No dispone de suficiente saldo");
                }
            }
            
            if(request.getParameter("vender") != null){
                
                if(request.getParameter("pNombre")!= "" && request.getParameter("precio")!= "" ){
                    int id = pc.findLastProducto().getId()+1;
                    String nombre = request.getParameter("pNombre");
                    String codigo = pc.generarCodigo();
                    String descripcion = request.getParameter("descripcion");
                    float precio = Float.parseFloat(request.getParameter("precio").trim());
                    Producto p = new Producto(id,nombre,codigo,descripcion,precio);

                    Usuario u = uc.seleccionarUsuarioNombre((String)userSession.getAttribute("logueado"));
                    u.setSaldo(u.getSaldo() + precio);
                    pc.insertarProducto(p);
                    
                    if(userSession.getAttribute("logueado").equals("admin")){
                        response.sendRedirect("adminProducto.jsp");
                        userSession.setAttribute("mensaje", "Producto agregado correctamente");
                    }
                    else{
                        uc.modificarUsuario(u);


                        response.sendRedirect("VistaUsuario.jsp");
                        userSession.setAttribute("mensaje", "Producto vendido correctamente");
                    }
                }else{
                    response.sendRedirect("venderProducto.jsp");
                    userSession.setAttribute("mensaje", "Ha de rellenar los campos");
                }
                
            }
            
            if(request.getParameter("eliminar") != null){
            int id = Integer.parseInt(request.getParameter("eliminar").trim());
            Producto p = pc.seleccionarProducto(id);
            pc.eliminarProducto(p);
            
            response.sendRedirect("adminProducto.jsp");
            userSession.setAttribute("mensaje", "Producto eliminado correctamente");
        }
            
            if(request.getParameter("modificar") != null){
                if(request.getParameter("pNombre") != null && request.getParameter("precio") != null && 
                         request.getParameter("descripcion") != null){
                        int id = Integer.parseInt(request.getParameter("modificar").trim());
                        
                        Producto p = pc.seleccionarProducto(id);
                        p.setNombre(request.getParameter("pNombre"));
                        p.setPrecio(Float.parseFloat(request.getParameter("precio").trim()));
                        p.setDescripcion(request.getParameter("descripcion"));
                        
                        pc.modificarProducto(p);
                        
                        response.sendRedirect("adminProducto.jsp");
                        userSession.setAttribute("mensaje", "Producto modificado correctamente");
                        
                        
                     }
                     else{
                     userSession.setAttribute("mensaje", "Ha de rellenar todos los campos");
                     response.sendRedirect("modificarProducto.jsp");
                 }
            
            }
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(sProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
