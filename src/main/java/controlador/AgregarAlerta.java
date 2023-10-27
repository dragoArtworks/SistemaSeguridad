package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import modelo.Alerta;
import modelo.Persona;

@WebServlet("/agregarAlerta")
public class AgregarAlerta extends HttpServlet{
    private ArrayList<Alerta> alertas= new ArrayList<>();

    public AgregarAlerta() {
    }
   
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.sendRedirect("alertas.html");
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out =response.getWriter();
        
        
        response.sendRedirect("alertas.html");
    }
   
    
}
