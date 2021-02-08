<%-- 
    Document   : logueo
    Created on : 30-oct-2020, 11:07:47
    Author     : alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
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
                    <form action="sRegistrar" method="post" >
			<div class="app-title">
                            <h1>Registro</h1>
                            <%
                            if(session.getAttribute("datosIncorrectos")!=null){
                                out.println(session.getAttribute("datosIncorrectos"));
                                session.setAttribute("datosIncorrectos", "");
                            }            
                            %>

			</div>

			<div class="login-form">
				<div class="control-group">
				<input type="text" class="login-field" value="" name="usuario" placeholder="Usuario" id="login-name">
				</div>

				<div class="control-group">
				<input type="password" class="login-field" value="" name="pass" placeholder="Contraseña" id="login-pass">
				</div>
                            
                                <div class="control-group">
                                    <input type="text" class="login-field" value="" name="dni" placeholder="Dni">
				</div>
                            
                                <div class="control-group">
				<input type="text" class="login-field" value="" name="direccion" placeholder="Dirección" >
				</div>
                            
                                <div class="control-group">
				<input type="text" class="login-field" value="" name="telefono" placeholder="Teléfono" >
				</div>
                            
                                <div class="control-group">
				<input type="text" class="login-field" value="" name="email" placeholder="Email" >
				</div>
                                
                                <input class="btn btn-primary btn-large btn-block" type="submit" name="Registrarse" value="Registrarse"></p>
				<a class="btn btn-primary btn-large btn-block" href="logeo.jsp">Volver</a>
			</div>
                    </form>
		</div>
	</div>
        
    </body>
</html>
