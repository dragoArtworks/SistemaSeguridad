package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import modelo.Persona;

@WebServlet("/agregarAlerta")
public class AgregarAlerta extends HttpServlet{

    public AgregarAlerta() {
    }
   
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.sendRedirect("alertas.html");
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out =response.getWriter();
        Persona nuevaPersona=new Persona("El", "waos", 1);
    }
   
    
}
