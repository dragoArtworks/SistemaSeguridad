<%-- 
    Document   : inicio
    Created on : 27/10/2023, 10:46:53 a. m.
    Author     : USER
--%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Usuario nUsuario = (Usuario) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="estilazosSeguridad.css">
        <title>Inicio</title>
    </head>

    <body>

        <div class="container">
            <header>
                <section class="botones">
                    <form action="agregarAlerta" method="post" >
                        <input type="hidden" id="id" name="idUser" value="<%=nUsuario.getId()%>">
                        <input type="hidden" id="id" name="nombreUser" value="<%=nUsuario.getNickName()%>">
                        <input type="hidden" id="id" name="contrasenaUser" value="<%=nUsuario.getContrasena()%>">
                        <input type="hidden" id="id" name="agregar" value="false">
                        <input type="hidden" id="id" name="eliminar" value="false">
                        <input type="hidden" id="id" name="mostrar" value="false">
                        <input type="hidden" id="id" name="enviarId" value="true">
                        <input type="submit" value="crear alertas" class="button" id="reg">
                    </form>
                    <form action="agregarAlerta"  method="post" >
                        <input type="hidden" id="id" name="idUser" value="<%=nUsuario.getId()%>">
                        <input type="hidden" id="id" name="nombreUser" value="<%=nUsuario.getNickName()%>">
                        <input type="hidden" id="id" name="contrasenaUser" value="<%=nUsuario.getContrasena()%>">
                        <input type="hidden" id="id" name="agregar" value="false">
                        <input type="hidden" id="id" name="eliminar" value="false">
                        <input type="hidden" id="id" name="mostrar" value="true">
                        <input type="hidden" id="id" name="enviarId" value="true">
                        <input type="submit" value="ver alertas" class="button" id="reg">
                    </form>
                </section>
            </header>
            <div class="header">
                <h1 class="titulo">Sistema de Seguridad</h1>
            </div>

            <div class="button-container">
                <h1 class="subtitulos">Bienvenido</h1>
                <section>
                    <p>
                        En "Seguridad Urbana", estamos creado un sistema dedicado a brindar a la comunidad 
                        una herrmienta para mejorar la seguridad en las calle 15.Querido estudiantes
                        nuestra misión es brindarte la posibilidad de ser un agente activo en la protección de tu entorno, permitiéndote crear un entorno más seguro
                        para ti y tus compañeros.
                    <p/>
                    <h3 class="subtitulos">¿Qué puedes hacer en "Seguridad Urbana"?</h3>
                    <h4 class="subtitles">Crear un Usuario</h4> 
                    <p>
                        Comienza tu viaje de seguridad registrándote en nuestra plataforma de manera
                        rápida y sencilla. Una vez registrado, tendrás acceso a todas las funciones disponibles.
                    <p/>
                    <h4 class="subtitles">Consultar Alertas</h4>
                    <p>
                        Mantente informado sobre lo que está sucediendo en tu comunidad. Nuestra 
                        plataforma te proporciona acceso a una base de datos de alertas generadas por otros usuarios. 
                        Estas alertas pueden incluir situaciones como hurtos, intimidación o cualquier evento de riesgo
                        en las calles cercanas a ti.
                    <p/>
                    <h4 class="subtitles">Ingresar tus propias Alertas</h4> 
                    <p>
                        ¿Has presenciado o experimentado una situación de riesgo en tu área? Con 
                        "Seguridad Urbana", puedes contribuir a la seguridad de tu comunidad compartiendo alertas en 
                        tiempo real. Describe la situación detalladamente para que otros usuarios estén al tanto y puedan
                        tomar medidas adecuadas.
                    </p>
                    <br/>
                    <h3 class="question">¿Que deseas hacer?</h3>
                </section>

            </div>

        </div>
    </body>
</html>

