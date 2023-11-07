package controlador;

import datos.AlertasDAO;
import datos.UsuarioDAO;
import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Alerta;
import modelo.Usuario;

@WebServlet("/agregarAlerta")
public class AgregarAlerta extends HttpServlet {

    private List<Alerta> alertas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    AlertasDAO nuevaAlertaDAO = new AlertasDAO();
    UsuarioDAO nuevoUsuarioDAO = new UsuarioDAO();

    public AgregarAlerta() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        HttpSession sesion = request.getSession();
//        String agregar = request.getParameter("agregar");
//        if (agregar.equals("true")) {
//            String idUsuarioActual = request.getParameter("id");
//            int idUsuarioActual1 = Integer.parseInt(idUsuarioActual);
//            Usuario nusuario = new Usuario(idUsuarioActual1);
//            sesion.setAttribute("user", nusuario);
//
//            RequestDispatcher rd = request.getRequestDispatcher("agregarAlertas.jsp");
//            rd.forward(request, response);
//
//        } else {
//            alertas = nuevaAlertaDAO.seleccionar();
//            usuarios = nuevoUsuarioDAO.seleccionar();
//            String idUsuarioActual = request.getParameter("idUser");
//            int idUsuarioActual1 = Integer.parseInt(idUsuarioActual);
//            String nombreUser = request.getParameter("nombreUser");
//            String contrasenaUser = request.getParameter("contrasenaUser");
//
//            Usuario nusuario = new Usuario(idUsuarioActual1, contrasenaUser, nombreUser);
//            sesion.setAttribute("user", nusuario);
//            sesion.setAttribute("usuarios", usuarios);
//            sesion.setAttribute("alertas", alertas);
//            RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
//            rd.forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String eliminar = request.getParameter("eliminar");
        String agregar = request.getParameter("agregar");
        String mostrar = request.getParameter("mostrar");
        String enviarUsuario = request.getParameter("enviarId");
        //id de usuario
        String id = request.getParameter("idUser");
        int id1 = Integer.parseInt(id);
        String nombreUser = request.getParameter("nombreUser");
        String contrasenaUser = request.getParameter("contrasenaUser");
        
        HttpSession sesion = request.getSession();
        //inicio.jsp>>mostrarAlertas.jsp
        //mostrar las alertas
        //ENVIAMOS:ID USUARIO,lista usuarios, lista alertas
       
        if (agregar.equals("false") && eliminar.equals("false") && mostrar.equals("true") && enviarUsuario.equals("true")) {
            alertas = nuevaAlertaDAO.seleccionar();
            usuarios = nuevoUsuarioDAO.seleccionar();
            
//            String nombreUser = request.getParameter("nombreUser");
//            String contrasenaUser = request.getParameter("contrasenaUser");
            
            Usuario nusuario = new Usuario(contrasenaUser, id1, nombreUser);
            sesion.setAttribute("user", nusuario);
            sesion.setAttribute("usuarios", usuarios);
            sesion.setAttribute("alertas", alertas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
            rd.forward(request, response);

            //mostrarAlertas.jsp>>agregarAlertas.jsp  
            //se redirige para agregar alertas
            //ENVIAMOS:ID USUARIO
        } else if (agregar.equals("false") && eliminar.equals("false") && mostrar.equals("false") && enviarUsuario.equals("true")) {
             Usuario nusuario = new Usuario(contrasenaUser, id1, nombreUser);
            
            sesion.setAttribute("user", nusuario);
            RequestDispatcher rd = request.getRequestDispatcher("agregarAlertas.jsp");
            rd.forward(request, response);

            //agregarAlertas.jsp>>mostrarAlertas.jsp
            //se envia el formulario
            //agrega alertas
            //ENVIAMOS:ID USUARIO,lista usuarios, lista alertas
        } else if (agregar.equals("true") && eliminar.equals("false") && mostrar.equals("true") && enviarUsuario.equals("true")) {
            String mensaje = request.getParameter("mensaje");
            String fecha = request.getParameter("fecha");
            String lugarOcurrencia = request.getParameter("sectores");
            String peligro = request.getParameter("peligro");
            Usuario nusuario = new Usuario(contrasenaUser, id1, nombreUser);
            
            
            //insertar
            Alerta nueAlerta = new Alerta(mensaje, fecha, lugarOcurrencia, peligro,id1);
            nuevaAlertaDAO.insertar(nueAlerta);
            alertas =nuevaAlertaDAO.seleccionar();
            usuarios=nuevoUsuarioDAO.seleccionar();
            sesion.setAttribute("user", nusuario);
            sesion.setAttribute("usuarios", usuarios);
            sesion.setAttribute("alertas", alertas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
            rd.forward(request, response);

            //Eliminar una alerta 
        } else if (agregar.equals("false") && eliminar.equals("true") && mostrar.equals("false") && enviarUsuario.equals("true")) {
            String idAlerta=request.getParameter("id");
            int idAlert=Integer.parseInt(idAlerta);
            
            Alerta alertaeliminar = new Alerta(idAlert);
            nuevaAlertaDAO.eliminar(alertaeliminar);
            alertas=nuevaAlertaDAO.seleccionar();
             Usuario nusuario = new Usuario(contrasenaUser, id1, nombreUser);
            sesion.setAttribute("user", nusuario);
            sesion.setAttribute("alertas", alertas);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
            rd.forward(request, response);
            //enviar id_Usuario
        } else {
             Usuario nusuario = new Usuario(contrasenaUser, id1, nombreUser);
            sesion.setAttribute("user", nusuario);
            RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
            rd.forward(request, response);
        }

    }

}
