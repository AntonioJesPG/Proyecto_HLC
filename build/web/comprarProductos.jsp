<%-- 
    Document   : modificarProducto
    Created on : 10-dic-2020, 21:01:11
    Author     : Drakthon
--%>

<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Controlador.UsuarioControlador"%>
<%@page import="Controlador.ProductoControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Producto</title>
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
        <% if(session.getAttribute("mensaje")!=null){
                                out.println(session.getAttribute("mensaje"));
                                session.setAttribute("mensaje", "");
                            }  
            UsuarioControlador uCont = new UsuarioControlador();
            Usuario u = uCont.seleccionarUsuarioNombre((String)session.getAttribute("logueado"));
            out.println("<h1>Saldo : " + u.getSaldo() + "</h1>");
        %>
        <table class="table text-light font-weight-bold" border="1">
            <tr><th>Nombre</th><th>Código</th><th>Descripción</th><th>Precio</th><th></th></tr>
            
        <% 
            
            ProductoControlador uc = new ProductoControlador();
            List<Producto> productos = new ArrayList<Producto>();
            productos = uc.findAllProductos();
            for(Producto p : productos){
                out.println("<tr>");
                out.println("<td>" + p.getNombre()+ "</td>");
                out.println("<td>" + p.getCodigo()+ "</td>");
                out.println("<td>" + p.getDescripcion()+ "</td>");
                out.println("<td>" + p.getPrecio()+ "€</td>");
                out.println("<td><form action='sProductos' method='POST'><button class='btn-1' type='submit' name='comprar' value='" + p.getId() + "'>Comprar</button></form></td>");
                out.println("</tr>");
            }
            
        %>
            </table>
            </br>
            <a href="VistaUsuario.jsp"><button class="btn-1">Volver</button></a>
</html>
