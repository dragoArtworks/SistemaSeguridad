<%-- 
    Document   : inicio
    Created on : 27/10/2023, 10:46:53 a. m.
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilazosLogin.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/validacion ingreso.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
        <form action="login" method="post"
          onsubmit="return ValidarForma(this)">
            <table class="login" width="500">
                <thead>
                    <tr>
                        <th class="titulo"> login</th> <!-- titulo -->
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="sugerencias" id="sug">Usuario/correo</td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" id="id" name="usuario">
                        </td>
                    </tr>
                    <tr>
                        <td class="sugerencias" id="sug">contraseña</td>
                    </tr>
                    <tr>
                        <td> 
                            <input type="password" id="id" minlength="8" name="contrasena"> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="url" class="enlaces" id="contraseña" >olvidaste tu contraseña??</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="login" class="button" id="login">
                        </td>
                    </tr>  
                </tbody>
            </table>
            <section>
                No tienes cuenta??
                <a href="registrar.html" class="enlaces" id="reg">registrate</a>
            </section>

            </form>
        </div>
    </body>
</html>
