/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import datos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Persona;
import modelo.Usuario;

@WebServlet("/registrar")
public class registrar extends HttpServlet{
    UsuarioDAO nuevoUsuarioDAO=new UsuarioDAO();
    private List<Usuario> usuarios =null;
    

    public registrar() {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter out =response.getWriter();
        
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String edad=request.getParameter("edad");///jnhlkñl
        int edadI=Integer.parseInt(edad);
        String correo=request.getParameter("correo");
        String usuario=request.getParameter("usuario");
        String contrasena=request.getParameter("contrasena");
        Usuario nueUsuario= new Usuario(usuario, correo, contrasena, nombre, apellido, edadI);
        nuevoUsuarioDAO.insertar(nueUsuario);
        usuarios=nuevoUsuarioDAO.seleccionar();
        //usuarios.add(nueUsuario);
        
        response.sendRedirect("login.html");
//       HttpSession sesion =request.getSession();
//       sesion.setAttribute("usuarios", usuarios);
//       RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
//       rd.forward(request, response);
    }
}
