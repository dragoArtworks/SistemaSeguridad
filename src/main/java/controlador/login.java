/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Persona;

@WebServlet("/login")
public class login extends HttpServlet {

    public login() {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
       // response.sendRedirect("inicio.html");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out =response.getWriter();
        
        //provisioanl para revisara los usuarios
        Persona nuevaPersona=new Persona("El", "waos", 1);
        String usuario= request.getParameter("usuario");
        String contrasena=request.getParameter("contrasena");
        
        
        response.sendRedirect("inicio.jsp");
    }
   
  
}
