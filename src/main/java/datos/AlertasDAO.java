
package datos;

import static datos.ConexionII.*;
import java.sql.*;
import java.util.*;
import modelo.Alerta;

public class AlertasDAO {
    private final String JDBC_SELECT=" SELECT id,mensaje,fecha,lugar_ocurrencia,peligro,id_usuario FROM alertas1 ";
    private final String JDBC_INSERT=" INSERT INTO alertas1(mensaje,fecha,lugar_ocurrencia,peligro, id_usuario) VALUES(?,?,?,?,?)";
    private final String JDBC_UPDATE="UPDATE alertas1 SET mensaje=?,fecha=?,lugar_ocurrencia=? peligro=? WHERE ID=?" ;
    private final String JDBC_DELETE="DELETE WHERE id=?";
    
    public List<Alerta> seleccionar(){
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement stmt=null;
        Alerta nuevaAlerta=null;
        List<Alerta> alertas=new ArrayList<>();
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(JDBC_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()) {                
                int id=rs.getInt("id");
                String mensaje=rs.getString("mensaje");
                String fecha=rs.getString("fecha");
                String lugar=rs.getString("lugar_ocurrencia");
                String peligro=rs.getString("peligro");
                int usuarioId=rs.getInt("id_usuario");
                nuevaAlerta=new Alerta(id, mensaje, fecha, lugar, peligro, usuarioId);
                alertas.add(nuevaAlerta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return alertas;
    }
    
    public int insertar(Alerta alerta){
        Connection conn=null;
        PreparedStatement stmt=null;
        
        int registros=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(JDBC_INSERT);
            stmt.setString(1, alerta.getMensaje());
            stmt.setString(2,alerta.getFecha());
            stmt.setString(3,alerta.getLugarOcurrencia());
            stmt.setString(4,alerta.getPeligro());
            stmt.setInt(5,alerta.getUsuarioId());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    public int actualizar(Alerta alerta){
        Connection conn=null;
        PreparedStatement stmt=null;
        int registros=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(JDBC_UPDATE);
            stmt.setString(1, alerta.getMensaje());
            stmt.setString(2,alerta.getFecha());
            stmt.setString(3,alerta.getLugarOcurrencia());
            stmt.setString(4,alerta.getPeligro());
            stmt.setInt(5,alerta.getId());
            registros=stmt.executeUpdate();
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
    
    public int eliminar(Alerta alerta){
        Connection conn=null;
        PreparedStatement stmt=null;
        
        int registros=0;
        try {
            conn=getConnection();
            stmt=conn.prepareStatement(JDBC_DELETE);
            stmt.setInt(1,alerta.getUsuarioId());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
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
