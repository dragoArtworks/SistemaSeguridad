package Test;

import datos.UsuarioDAO;
import java.util.*;
import javax.swing.JOptionPane;

import modelo.Usuario;

public class TestManejoUsuarios {

   
    public static void main(String[] args) {
        
         UsuarioDAO nuevoUsuarioDAO=new UsuarioDAO();
        
        //nuevoUsuarioDAO.insertar(insertar());
        //nuevoUsuarioDAO.actualizar(actualizar());
        
        //eliminar
        Usuario neUsuario=new Usuario(2);
        nuevoUsuarioDAO.eliminar(neUsuario);
        
        List<Usuario> usuarios=nuevoUsuarioDAO.seleccionar();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
    public static Usuario insertar(){
        Usuario usuario= null;
        String nombre;
        String nickName;
        String correo;
        String contrasena;
        String apellido;
        int edad;
        
       
        nickName=JOptionPane.showInputDialog(null, "Digite su nickname");
        nombre=JOptionPane.showInputDialog("ingresa el nombre");
        apellido=JOptionPane.showInputDialog("ingresa el apellido");
        correo=JOptionPane.showInputDialog(null, "ingrese su correo");
        contrasena=JOptionPane.showInputDialog("ingrese la contraseña");
        edad=Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad"));
        
        usuario=new Usuario(nickName, correo, contrasena, nombre, apellido, edad);
        
        return usuario;
    }
    public static Usuario actualizar(){
        Usuario usuario= null;
        int id;
        String nombre;
        String nickName;
        String correo;
        String contrasena;
        String apellido;
        int edad;
        
        id=Integer.parseInt(JOptionPane.showInputDialog("Digite su nickname"));
        nickName=JOptionPane.showInputDialog(null, "Digite su nickname");
        nombre=JOptionPane.showInputDialog("ingresa el nombre");
        apellido=JOptionPane.showInputDialog("ingresa el apellido");
        correo=JOptionPane.showInputDialog(null, "ingrese su correo");
        contrasena=JOptionPane.showInputDialog("ingrese la contraseña");
        edad=Integer.parseInt(JOptionPane.showInputDialog("ingrese la edad"));
        
        usuario=new Usuario(nickName, correo, contrasena, nombre, apellido, edad);
        
        return usuario;
    }
    
}
