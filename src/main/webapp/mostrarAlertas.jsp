<%-- 
    Document   : mostrarAlertas
    Created on : 27/10/2023, 10:26:50 a. m.
    Author     : USER
--%>
<%@page import="modelo.Alerta"%>
<%@page import="modelo.Usuario"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Usuario> usuarios = (ArrayList<Usuario>) session.getAttribute("usuarios");
    ArrayList<Alerta> alertas = (ArrayList<Alerta>) session.getAttribute("alertas");
    Usuario nUsuario = (Usuario) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilazosSeguridad.css" rel="stylesheet" type="text/css"/>
        <title>Alertas</title>
    </head>
    <body>
        <div class="container">

            <div class="header">
                <h2 class="titulo">bienvenido <%= nUsuario.getNickName()%></h2>

            </div>

            <% if (alertas != null && !alertas.isEmpty()) {
                    for (Alerta alert : alertas) {
            %>
            <div class="separador">
                <ul>
                    <%
                        int id = 0;
                        if (alert != null) {
                            for (Usuario user : usuarios) {
                                if (user.getId() == alert.getUsuarioId()) {
                                
                    %> 
                    <h1 class="titulo"><%=user.getNickName()%> posteo : </h1>
                    <%
                                    id = user.getId();
                                }
                            }
                        }
                    %>  

                    <li><h4 class="descripcion">Sufrio <%= alert.getPeligro()%> en el <%=alert.getLugarOcurrencia()%></h4> </li>
                    <li><h3 class="mensaje"><%= alert.getMensaje()%> </h3> </li>
                    <li><h4 class="fecha">fecha de ocurrencia del suceso <%= alert.getFecha()%> </h4> </li>
                        <%if (nUsuario.getId() == id) {%>
                    <form action="agregarAlerta" method="post">
                        <li><input type="hidden" name="idUser" value="<%= id%>"></li>
                        <li><input type="hidden" name="id" value="<%= alert.getId()%>"></li>
                        <li><input type="hidden" id="id" name="agregar" value="false"></li>
                        <li><input type="hidden" id="id" name="eliminar" value="true"></li>
                        <li><input type="hidden" id="id" name="mostrar" value="false"></li>
                        <li><input type="hidden" id="id" name="enviarId" value="true"></li>
                        <input type="submit" value="eliminar">
                    </form>
                    <%}

                    %>
                </ul>
            </div>
            <% }

            } else { %>
            <div class="separador">
                <h4 class="descripcion">No existen alertas todavia</h4>
            </div>
            <% }%>



            <section class="botones">
                <form  action="agregarAlerta" method="post" >
                    <input type="hidden" id="id" name="idUser" value="<%=nUsuario.getId()%>">
                    <input type="hidden" id="id" name="nombreUser" value="<%=nUsuario.getNickName()%>">
                    <input type="hidden" id="id" name="contrasenaUser" value="<%=nUsuario.getContrasena()%>">
                    <input type="hidden" id="id" name="agregar" value="false">
                    <input type="hidden" id="id" name="eliminar" value="false">
                    <input type="hidden" id="id" name="mostrar" value="false">
                    <input type="hidden" id="id" name="enviarId" value="true">
                    <input type="submit" value="crear alertas" class="button" id="reg1">
                </form>
                <form action="agregarAlerta" method="post">
                    <input type="hidden" id="id" name="idUser" value="<%=nUsuario.getId()%>">
                    <input type="hidden" id="id" name="nombreUser" value="<%=nUsuario.getNickName()%>">
                    <input type="hidden" id="id" name="contrasenaUser" value="<%=nUsuario.getContrasena()%>">
                    <input type="hidden" id="id" name="agregar" value="false">
                    <input type="hidden" id="id" name="eliminar" value="false">
                    <input type="hidden" id="id" name="mostrar" value="false">
                    <input type="hidden" id="id" name="enviarId" value="false">
                    <input type="submit" value="inicio" class="button" id="reg2">
                </form>

            </section>

        </div>
    </body>
</html>
