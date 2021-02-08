<%-- 
    Document   : modificarUsuario
    Created on : 08-dic-2020, 19:56:14
    Author     : Drakthon
--%>

<%@page import="Modelo.Usuario"%>
<%@page import="Controlador.UsuarioControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
            * {
            box-sizing: border-box;
            }

            *:focus {
                    outline: none;
            }
            body {
            font-family: Arial;
            background-color: #000000;
            padding: 50px;
            }
            .login {
            margin: 20px auto;
            width: 300px;
            }
            .login-screen {
            background-color: #FFF;
            padding: 20px;
            border-radius: 5px
            }

            .app-title {
            text-align: center;
            color: #777;
            }

            .login-form {
            text-align: center;
            }
            .control-group {
            margin-bottom: 10px;
            }

            input {
            text-align: center;
            background-color: #ECF0F1;
            border: 2px solid #000000;
            border-radius: 3px;
            font-size: 16px;
            font-weight: 200;
            padding: 10px 0;
            width: 250px;
            transition: border .5s;
            }

            input:focus {
            border: 2px solid #3498DB;
            box-shadow: none;
            }

            .btn {
              border: 2px solid transparent;
              background: #000000;
              color: #fff;
              font-size: 16px;
              line-height: 25px;
              font-weight: bold;
              padding: 10px 0;
              text-decoration: none;
              text-shadow: none;
              border-radius: 3px;
              box-shadow: none;
              transition: 0.25s;
              display: block;
              width: 250px;
              margin: 0 auto;
            }

            .btn:hover {
              background: #fff;
              color: #000000;
              border: 3px solid #000000;
              border-radius: 5px;
            }

        </style>
    </head>
    <body>

     
        <div class="login">
		<div class="login-screen">
                    <form action="sUsuario" method="post" >
			<div class="app-title">
                            <h1>Modificar usuario</h1>
                            <%
                            int id = Integer.parseInt(request.getParameter("modificar"));
                            UsuarioControlador uc = new UsuarioControlador();
                            Usuario u = uc.seleccionarUsuario(id);
                            

                            if(session.getAttribute("datosIncorrectos")!=null){
                                out.println(session.getAttribute("datosIncorrectos"));
                                session.setAttribute("datosIncorrectos", "");
                            }            

                            %>

			</div>

			<div class="login-form">
				<div class="control-group">
                                    <label>Usuario<input type="text" class="login-field" name="usuario" placeholder="Usuario" value="<% out.println(u.getNombre()); %>" id="login-name" disabled>
				</div>

				<div class="control-group">
                                    <label>Contraseña </label><input type="password" class="login-field" value="<% out.println(u.getContrasenia()); %>" name="pass" placeholder="Contraseña" id="login-pass">
				</div>
                            
                                <div class="control-group">
                                    <label>DNI </label><input type="text" class="login-field" value="<% out.println(u.getDni()); %>" name="dni" placeholder="Dni" value="<% out.println(u.getDni()); %>" disabled>
				</div>
                            
                                <div class="control-group">
                                <label>Direccion </label><input type="text" class="login-field" value="<% out.println(u.getDireccion()); %>" name="direccion" placeholder="Dirección" >
				</div>
                            
                                <div class="control-group">
                                    <label>Teléfono </label><input type="text" class="login-field" value="<% out.println(u.getTelefono()); %>" name="telefono" placeholder="Teléfono" >
				</div>
                            
                                <div class="control-group">
                                    <label>Email </label><input type="text" class="login-field" value="<% out.println(u.getEmail()); %>" name="email" placeholder="Email" >
				</div>
                                    <button class="btn btn-primary btn-large btn-block" type="submit" name="Modificar" value="<% out.println(u.getId()); %>" >Modificar</button></p>
                                    <a class="btn btn-primary btn-large btn-block" href="<% if(session.getAttribute("logueado").equals("admin")){ out.println("adminUser.jsp"); } else { out.println("cuenta.jsp"); }%>">Volver</a>
			</div>
                    </form>
		</div>
	</div>
    </body>
</html>
