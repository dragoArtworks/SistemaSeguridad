package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/seguridad?useSSL=false&useTimezone=true&serverTimezone=UTC&allowpublicKeyRetrieval=true";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id, nombre,nickname,edad,password,email FROM usuarios";//sentencia sql
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.print("id:" + resultado.getInt("id"));
                System.out.print(" Nombre: " + resultado.getString("nombre"));
                System.out.print(" Nickname: " + resultado.getString("nickname"));
                System.out.print(" Edad: " + resultado.getString("edad"));
                System.out.print(" Contraseña: " + resultado.getString("password"));
                System.out.println(" Email: " + resultado.getString("email"));
                
            }
            //cerramos los elemnetos que abrimos mas arriba
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
