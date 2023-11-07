<%-- 
    Document   : agregarAlertas
    Created on : 6/11/2023, 4:35:52 p. m.
    Author     : USER
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario nUsuario = (Usuario) session.getAttribute("user");
%>
<!DOCTYPE html>

<html>
    <head>
        <title>Añadir alertas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="estilazosAgregarAlerta.css" rel="stylesheet" type="text/css"/>
        <script src="recursos/validacion ingreso.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="container">
            <h1 class="titulo">Añadir alertas</h1>
            <form action="agregarAlerta" method="post"
                  onsubmit="return ValidarForma(this)">


                <section>
                    <h4 class="subtitles">Sector 1</h4>
                    <p>
                        comprende desde la estacion de buses hasta el semaforo del famisanar
                    </p>
                </section>
                <section> 
                    <h4 class="subtitles">Sector 2</h4>
                    <p>comprende desde famisanar hasta  el semaforo del colegio manuela Ayala</p>
                </section>
                <section>
                    <h4 class="subtitles">Sector 3</h4>
                    <p> comprende desde el semaforo del colegio manuela ayala hasta la universidad de cundinamarca</p>
                </section>
                <h3 class="subtitles" id="agregar">Ingresa tu alerta</h3>
                <table class="alertasTable">
                    <tr>
                        <td class="sugerencias" id="sug">
                            ¿En que sector ocurrio tu situacion?
                        </td>
                        <td class="sugerencias" id="sug">
                            <select name="sectores" class="default" id="raza">
                                <option value="">seleccionar</option>
                                <option value="sector 1">sector1</option>
                                <option value="sector 2">sector2</option>
                                <option value="sector 3">sector3</option>
                        </td>
                    </tr>
                    <tr>
                        <td class="sugerencias" id="sug">
                            ¿Que tipo de situacion experimentaste?          
                        </td>
                        <td class="sugerencias" id="sug">
                            <select name="peligro" class="default" id="raza">
                                <option value="">seleccionar</option>
                                <option value="robo">robo</option>
                                <option value="intimidacion">intimidacion</option>
                                <option value="secuestro">secuestro</option>
                        </td>
                    </tr>
                    <tr>
                        <td class="sugerencias" id="sug">
                            Fecha de ocurrencia del suceso:
                        </td>
                        <td>
                            <input type="date" name="fecha" class="default"> 
                        </td>
                    </tr>

                </table>
                Describe la situación que te ocurrió
                <section class="textoYBotones" >
                    <textarea name="mensaje" class="textarea" >
                    </textarea>
                    <br>
                    <section class="botones">
                       <!-- <form action="agregarAlerta" method="post">-->
                            <input type="hidden" id="id" name="idUser" value="<%= nUsuario.getId()%>">
                            <input type="hidden" id="id" name="nombreUser" value="<%=nUsuario.getNickName()%>">
                            <input type="hidden" id="id" name="contrasenaUser" value="<%=nUsuario.getContrasena()%>">
                            <input type="hidden" id="id" name="agregar" value="true">
                            <input type="hidden" id="id" name="eliminar" value="false">
                            <input type="hidden" id="id" name="mostrar" value="true">
                            <input type="hidden" id="id" name="enviarId" value="true">
                            <input type="submit" value="Publicar" class="button" id="reg1">
                        </form>
                        <form action="agregarAlerta" method="post">
                            <input type="hidden" id="id" name="nombreUser" value="<%=nUsuario.getNickName()%>">
                            <input type="hidden" id="id" name="contrasenaUser" value="<%=nUsuario.getContrasena()%>">
                            <input type="hidden" id="id" name="agregar" value="false">
                            <input type="hidden" id="id" name="eliminar" value="false">
                            <input type="hidden" id="id" name="mostrar" value="false">
                            <input type="hidden" id="id" name="enviarId" value="false">
                            <input type="hidden" id="id" name="idUser" value="<%=nUsuario.getId()%>">
                            <input type="submit" value="inicio" class="button" id="reg2">
                        </form>
                    </section>  
            </form>

        </div>
    </body>
</html>
