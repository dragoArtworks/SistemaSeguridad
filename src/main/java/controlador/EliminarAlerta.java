/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import datos.AlertasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alerta;

/**
 *
 * @author USER
 */
@WebServlet("/eliminar")
public class EliminarAlerta extends HttpServlet{
    AlertasDAO nuAlertaDao= new AlertasDAO();
    
   @Override 
   protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
       PrintWriter out = response.getWriter();
       
       String id=request.getParameter("id");
       int id1=Integer.parseInt(id);
       Alerta nueAlerta=new Alerta(id1);
       nuAlertaDao.eliminar(nueAlerta);
       response.sendRedirect("mostrarAlertas.jsp");
       
   }
    
}
