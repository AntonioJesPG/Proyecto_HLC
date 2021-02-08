<%-- 
    Document   : cuenta
    Created on : 08-dic-2020, 20:53:25
    Author     : Drakthon
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Controlador.UsuarioControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi cuenta</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <style>
            body {
                background:  #000000;
                font-size: 62.5%;
          }

          .container {
            padding: 2em;
            margin-top: 5%;
          }


          a{
              text-decoration: none;
          }
          
          .contenedor {
            width:400px;
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
          
          button {
            width: 400px;
            height : 100px;
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
    </head>
    <body>
        <%             if(session.getAttribute("mensaje")!=null){
                    out.println(session.getAttribute("mensaje"));
                    session.setAttribute("mensaje", "");
                }  %>
        <div class="container">
        <div class="contenedor">
        <% 
            
            String nombre = (String) session.getAttribute("logueado");
            UsuarioControlador uc = new UsuarioControlador();
            Usuario u = uc.seleccionarUsuarioNombre(nombre);
            
            out.println("<label>Nombre : " + u.getNombre()+ "</label></p>");
            out.println("<label>Dni : " + u.getDni()+ "</label></p>");
            out.println("<label>Dirección : " + u.getDireccion()+ "</label></p>");
            out.println("<label>Teléfono : " + u.getTelefono()+ "</label></p>");
            out.println("<label>Email : " + u.getEmail()+ "</label></p>");
            out.println("<label>Saldo : " + u.getSaldo() + "</label></p>");
            out.println("<form action='sUsuario' method='POST'><input type='hidden' name='nombreUsuario' value='" + u.getNombre() + "'><input type='number' name='saldo' min='1' value='0'><input type='submit' name='agregarSaldo' value='Agregar Saldo'></form>");
            out.println("</div>");
            out.println("<form action='modificarUsuario.jsp' method='POST'><button class='btn-1' type='submit' name='modificar' value='" + u.getId() + "'>Modificar</button></form>");
            out.println("<a href='VistaUsuario.jsp'><button class='btn-1'>Volver</button></a>");
        %>
        </div>
    </body>
</html>
