<%-- 
    Document   : VistaAdministrador
    Created on : 30-oct-2020, 11:26:57
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrar</title>
<style>
            body {
                background:  #000000;
                font-size: 62.5%;
          }

          .container {
            padding: 2em;
            margin-top: 5%;
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
            width: 400px;
            height : 150px;
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
        <div class="container">
            <% if(session.getAttribute("mensaje")!=null){
                    out.println("<h3>" + session.getAttribute("mensaje") + "</h3>");
                    session.setAttribute("mensaje", "");
                }  %>
            <a href="adminUser.jsp"><button class="btn-1">Administrar usuarios</button></a>
            <a href="adminProducto.jsp"><button class="btn-1">Administrar productos</button></a>
            <a href="historialAdmin.jsp"><button class="btn-1">Historial ventas</button></a>
            <a href="logeo.jsp"><button class="btn-1">Cerrar sesión</button></a>
        </div>
    </body>
</html>
