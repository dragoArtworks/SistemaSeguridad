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
    private List<Usuario> usuarios= new ArrayList<>();
    AlertasDAO nuevaAlertaDAO = new AlertasDAO();
    UsuarioDAO nuevoUsuarioDAO = new UsuarioDAO();
    public AgregarAlerta() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
     HttpSession sesion = request.getSession();
     alertas = nuevaAlertaDAO.seleccionar();
     usuarios=nuevoUsuarioDAO.seleccionar();
     
     sesion.setAttribute("usuarios", usuarios);
     sesion.setAttribute("alertas", alertas);
     RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
     rd.forward(request, response);
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String eliminar=request.getParameter("eliminar");
        String id=request.getParameter("id");
        int id1=Integer.parseInt(id);
        
        
        if(eliminar.equals("true")){
            Alerta alertaeliminar=new Alerta(id1);
            nuevaAlertaDAO.eliminar(alertaeliminar);
            System.out.println("h\no\nl\na");
        }else{
        String mensaje = request.getParameter("mensaje");
        String fecha = request.getParameter("fecha");
        String lugarOcurrencia = request.getParameter("sectores");
        String peligro=request.getParameter("peligro");
        String usuario=request.getParameter("id_usuario");
        int usuarioId=Integer.parseInt(usuario);

        //insertar
        Alerta nueAlerta = new Alerta(mensaje, fecha, lugarOcurrencia, peligro, usuarioId);
        nuevaAlertaDAO.insertar(nueAlerta);
        }
        alertas = nuevaAlertaDAO.seleccionar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alertas", alertas);
        RequestDispatcher rd = request.getRequestDispatcher("mostrarAlertas.jsp");
        rd.forward(request, response);
        
    }

}
