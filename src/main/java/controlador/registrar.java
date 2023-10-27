/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;

@WebServlet("/registrar")
public class registrar {
    private ArrayList<Persona> usuarios =new ArrayList<>();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out =response.getWriter();
        
        
        
        
        
    }
}
