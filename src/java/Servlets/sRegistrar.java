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
@WebServlet(name = "sRegistrar", urlPatterns = {"/sRegistrar"})
public class sRegistrar extends HttpServlet {

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
            
             if(request.getParameter("Registrarse") != null){
                 if(request.getParameter("usuario") != "" && request.getParameter("pass") != "" && 
                         request.getParameter("dni") != "" && request.getParameter("direccion") != "" && 
                         request.getParameter("telefono") != "" && request.getParameter("email") != ""){
                     if(!uc.comprobarUsuarioExistente(request.getParameter("usuario")) && !uc.comprobarDni(request.getParameter("dni"))){
                        int id = uc.contarUsuarios();
                        String usuario = request.getParameter("usuario");
                        String pass = request.getParameter("pass");
                        String dni = request.getParameter("dni");
                        String direccion = request.getParameter("direccion");
                        String telefono = request.getParameter("telefono");
                        String email = request.getParameter("email");
                        float saldo = 0;
                        
                        Usuario u = new Usuario(id,usuario,pass,direccion,telefono,dni,email,saldo);
                        uc.insertarUsuario(u);
                        
                        response.sendRedirect("logeo.jsp");
                        userSession.setAttribute("usuarioCreado", "Usuario creado correctametne");
                        
                        
                     }else{
                         userSession.setAttribute("datosIncorrectos", "El nombre de usuario o dni ya estan registrados");
                        response.sendRedirect("registro.jsp");
                     }
                     
                 }else{
                     userSession.setAttribute("datosIncorrectos", "Ha de rellenar todos los campos");
                     response.sendRedirect("registro.jsp");
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
            Logger.getLogger(sRegistrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(sRegistrar.class.getName()).log(Level.SEVERE, null, ex);
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
