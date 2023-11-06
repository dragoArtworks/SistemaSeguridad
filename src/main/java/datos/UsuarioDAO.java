package datos;

import static datos.ConexionII.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

public class UsuarioDAO {

    public static final String JDBC_SELECT = "SELECT id,nombre,apellido,nickname,edad, password,email FROM usuario ";
    public static final String JDBC_SELECT_USUARIO="SELECT id, nombre, password FROM usuario WHERE nombre=? AND password =?";
    public static final String JDBC_INSERT = "INSERT INTO usuario(nombre,apellido,nickname,edad,password,email) VALUES(?,?,?,?,?,?)";
    public static final String JDBC_UPDATE = "UPDATE usuario SET nombre=?,apellido=?, nickname=?,edad=?,password=?,email=? WHERE id=?";
    public static final String JDBC_DELETE = "DELETE FROM usuario WHERE id=?";

    public List<Usuario> seleccionar() {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Usuario nuevoUsuario = null;

        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(JDBC_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String nickname = rs.getString("nickname");
                int edad = rs.getInt("edad");
                String contrasena = rs.getString("password");
                String correo = rs.getString("email");
                nuevoUsuario = new Usuario(id, nickname, correo, contrasena, nombre, apellido, edad);
                usuarios.add(nuevoUsuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return usuarios;
    }
    public Usuario SeleccionarUser(Usuario usuario){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        Usuario nuevoUsuario = null;
        
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(JDBC_SELECT_USUARIO);
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getContrasena());
            //int registros=stmt.executeUpdate();
            rs=stmt.executeQuery(); 
            if (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String contrasena = rs.getString("password");
                nuevoUsuario=new Usuario(contrasena, nombre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return nuevoUsuario;
    }
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(JDBC_INSERT);

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getNickName());
            stmt.setInt(4, usuario.getEdad());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getCorreo());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(JDBC_INSERT);
            stmt.setInt(7, usuario.getId());
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getNickName());
            stmt.setInt(4, usuario.getEdad());
            stmt.setString(5, usuario.getContrasena());
            stmt.setString(6, usuario.getCorreo());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(JDBC_DELETE);

            stmt.setInt(1, usuario.getId());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

}
