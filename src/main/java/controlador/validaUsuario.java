/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Persona;

@WebServlet("/login")

public class validaUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        
        String jdbcUrl = "jdbc:mysql://localhost:3306/seguridad";
        String dbUsuario = "root";
        String dbContrasena = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUsuario, dbContrasena);

            
            String consulta = "SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h2>Bienvenido, " + usuario + "!</h2>");
                out.println("</body></html>");
                
                response.sendRedirect("inicio.jsp");
            } else {
                
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h2>Autenticación fallida. Por favor, verifica tu usuario y contraseña.</h2>");
                out.println("</body></html>");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
