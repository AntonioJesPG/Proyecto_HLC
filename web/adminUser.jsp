<%-- 
    Document   : AdmUser
    Created on : 08-dic-2020, 19:36:23
    Author     : Drakthon
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Controlador.UsuarioControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración de usuarios</title>
        <style>
            .bgg {
                background-color: #000000;
                color: white;
            }
            
            /* GENERAL BUTTON STYLING */
          button,
          button::after {
            -webkit-transition: all 0.3s;
                  -moz-transition: all 0.3s;
            -o-transition: all 0.3s;
                  transition: all 0.3s;
          }

          a{
              text-decoration: none;
          }
          
            h3{
              width: 400px;
            background: none;
            color: #fff;
            display: block;
            font-size: 1.6em;
            font-weight: bold;
            margin: 1em auto;
            padding: 2em 6em;
            position: relative;
            text-transform: uppercase;  
          }
          
          button {
            width: 100px;
            height : 50px;
            background: none;
            border: 3px solid #fff;
            border-radius: 5px;
            color: #fff;
            display: block;
            font-size: 1.6em;
            font-weight: bold;
            margin: 1em auto;
            padding: 2em 6em;
            position: relative;
            text-transform: uppercase;         
          }

          button::before,
          button::after {
            background: #fff;
            content: '';
            position: absolute;
            z-index: -1;
          }

          button:hover {
            color: #000000;
          }

          /* BUTTON 1 */
          .btn-1::after {
            height: 0;
            left: 0;
            top: 0;
            width: 100%;
          }

          .btn-1:hover:after {
            height: 100%;
          }
        </style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body class="bgg">
        <% if(session.getAttribute("usuarioModificado")!=null){
                                out.println(session.getAttribute("usuarioModificado"));
                                session.setAttribute("usuarioModificado", "");
                            }   
        %>
        <table class="table text-light font-weight-bold" border="1">
            <tr><th></th><th>Nombre</th><th>DNI</th><th>Dirección</th><th>Teléfono</th><th>Email</th><th>Saldo</th><th></th><th></th></tr>
            
        <% 
            UsuarioControlador uc = new UsuarioControlador();
            List<Usuario> usuarios = new ArrayList<Usuario>();
            usuarios = uc.findAllUsuarios();
            for(Usuario u : usuarios){
                if(u.getId() != 0){
                out.println("<tr>");
                out.println("<td>" + u.getId() + "</td>");
                out.println("<td>" + u.getNombre() + "</td>");
                out.println("<td>" + u.getDni()+ "</td>");
                out.println("<td>" + u.getDireccion()+ "</td>");
                out.println("<td>" + u.getTelefono()+ "</td>");
                out.println("<td>" + u.getEmail()+ "</td>");
                out.println("<td>" + u.getSaldo()+ "</td>");
                out.println("<td><form action='modificarUsuario.jsp' method='POST'><button class='btn-1' type='submit' name='modificar' value='" + u.getId() + "'>Modificar</button></form></td>");
                out.println("<td><form action='sUsuario' method='POST'><button class='btn-1' type='submit' name='eliminar' value='" + u.getId() + "'>Eliminar</button></form></td>");
                out.println("</tr>");
                }
            }
            
        %>
            </table>
            </br>
            <a href="VistaAdministrador.jsp"><button class='btn-1'>Volver</button></a>
    </body>
</html>
