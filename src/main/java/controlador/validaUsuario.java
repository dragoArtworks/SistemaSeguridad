/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import datos.UsuarioDAO;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Persona;
import modelo.Usuario;

@WebServlet("/login")

public class validaUsuario extends HttpServlet {

    private List<Usuario> usuarios = new ArrayList<>();
    UsuarioDAO newUsuarioDAO = new UsuarioDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        Usuario newUsuario = new Usuario(contrasena, usuario) ;

        if (newUsuarioDAO.SeleccionarUser(newUsuario)!=null) {
            Usuario nuevoUsuario=newUsuarioDAO.SeleccionarUser(newUsuario);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("user", nuevoUsuario);
            RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("login.html");
            
        }
    }
}
