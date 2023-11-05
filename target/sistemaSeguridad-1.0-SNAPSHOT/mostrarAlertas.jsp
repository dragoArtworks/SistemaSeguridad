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
                <h1 class="titulo">Sistema de Seguridad</h1>

            </div>

            <% if (alertas != null && !alertas.isEmpty()) {
                    for (Alerta alert : alertas) {
            %>
            <div class="separador">
                <ul>
                    <%
                        if (alert != null) {
                            for (Usuario user : usuarios) {
                                if (user.getId() == alert.getUsuarioId()) {
                    %>  
                    <h1 class="titulo"><%=user.getNickName()%> posteo : </h1>
                    <%
                                }
                            }
                        }
                    %>  
                    
                    <li><h4 class="descripcion">Sufrio <%= alert.getPeligro()%> en el <%=alert.getLugarOcurrencia()%></h4> </li>
                    <li><h4 class="descripcion"><%= alert.getMensaje()%> </h4> </li>
                    <li><h4 class="fecha">fecha de ocurrencia del suceso <%= alert.getFecha()%> </h4> </li>
                    <form action="agregarAlerta" method="post">
                        <li><input type="hidden" name="id" value="<%= alert.getId()%>"></li>
                        <li><input type="hidden" name="eliminar" value="true"></li>
                        <input type="submit" value="eliminar">
                    </form>
                </ul>
            </div>
            <!-- 
            
            <li><h4 class="descripcion">fecha:<%= alert.getLugarOcurrencia()%> </h4></li>
            -->
            <% }

            } else { %>
            <div class="separador">
                <h4 class="descripcion">No existen alertas todavia</h4>
            </div>
            <% }%>



            <section class="botones">
                <button class="button"><a href="inicio.jsp" class="enlaces" id="reg">inicio</a></button>
                <button class="button"><a href="agregarAlertas.html" class="enlaces" id="reg">agregar alertas</a></button><br><br>
            </section>

        </div>
    </body>
</html>
