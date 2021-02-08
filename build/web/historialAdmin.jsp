<%-- 
    Document   : historial
    Created on : 09-dic-2020, 0:41:12
    Author     : Drakthon
--%>

<%@page import="Modelo.Compra"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.CompraControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra de productos</title>
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
        <% if(session.getAttribute("usuarioModificado")!=null){
                                out.println(session.getAttribute("usuarioModificado"));
                                session.setAttribute("usuarioModificado", "");
                            }   
        %>
        <table class="table text-light font-weight-bold" border="1">
            <tr><th></th><th>Producto</th><th>Comprador</th><th>Precio</th></tr>
            
        <% 
            
            CompraControlador uc = new CompraControlador();
            List<Compra> compras = new ArrayList<Compra>();
            compras = uc.findAllCompras();
            for(Compra c : compras){
                out.println("<tr>");
                out.println("<td>" + c.getId() + "</td>");
                out.println("<td>" + c.getNombreProducto() + "</td>");
                out.println("<td>" + c.getNombreComprador()+ "</td>");
                out.println("<td>" + c.getPrecio()+ "€</td>");
                out.println("</tr>");
            }
            
        %>
            </table>
            </br>
            <a href="VistaAdministrador.jsp"><button class="btn-1">Volver</button></a>
    </body>
</html>
