/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.UsuarioControlador;
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
@WebServlet(name = "sUsuario", urlPatterns = {"/sUsuario"})
public class sUsuario extends HttpServlet {

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
            HttpSession userSession = request.getSession();
            UsuarioControlador uc = new UsuarioControlador();
            
            if(request.getParameter("Modificar") != null){
                 if(request.getParameter("pass") != null && request.getParameter("direccion") != null && 
                         request.getParameter("telefono") != null && request.getParameter("email") != null){
                     if(!uc.comprobarUsuarioExistente(request.getParameter("usuario")) && !uc.comprobarDni(request.getParameter("dni"))){
                        int id = Integer.parseInt(request.getParameter("Modificar").trim());
                        
                        Usuario u = uc.seleccionarUsuario(id);
                        u.setContrasenia(request.getParameter("pass"));
                        u.setDireccion(request.getParameter("direccion"));
                        u.setTelefono(request.getParameter("telefono"));
                        u.setEmail(request.getParameter("email"));
                        
                        uc.modificarUsuario(u);
                        
                        if(userSession.getAttribute("logueado").equals("admin")){
                            response.sendRedirect("adminUser.jsp");
                            userSession.setAttribute("usuarioModificado", "Usuario modificado correctametne");
                        }
                        else{
                            response.sendRedirect("cuenta.jsp");
                            userSession.setAttribute("usuarioModificado", "Usuario modificado correctametne");
                        }
                        
                     }else{
                         userSession.setAttribute("datosIncorrectos", "El nombre de usuario o dni ya estan registrados");
                        response.sendRedirect("modificarUsuario.jsp");
                     }
                     
                 }else{
                     userSession.setAttribute("datosIncorrectos", "Ha de rellenar todos los campos");
                     response.sendRedirect("modificarUsuario.jsp");
                 }
                 
                 
            
        }
            
        if(request.getParameter("eliminar") != null){
            int id = Integer.parseInt(request.getParameter("eliminar").trim());
            Usuario u = uc.seleccionarUsuario(id);
            uc.eliminarUsuario(u);
            
            response.sendRedirect("adminUser.jsp");
            userSession.setAttribute("usuarioModificado", "Usuario eliminado correctamente");
        }
        
        if(request.getParameter("agregarSaldo") != null){
            if(request.getParameter("saldo") != null){
                Usuario u = uc.seleccionarUsuarioNombre(request.getParameter("nombreUsuario"));
                Float saldoAgregar = Float.parseFloat(request.getParameter("saldo").trim());
                u.setSaldo(u.getSaldo() + saldoAgregar);
                uc.modificarUsuario(u);
                
                response.sendRedirect("cuenta.jsp");
                userSession.setAttribute("mensaje", "Saldo agregado correctamente");
            }
            else{
                response.sendRedirect("cuenta.jsp");
                userSession.setAttribute("mensaje", "Ha de introducir la cantidad de saldo que desea añadir");
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
            Logger.getLogger(sUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
