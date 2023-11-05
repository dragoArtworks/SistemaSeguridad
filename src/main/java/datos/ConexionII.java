package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionII {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/seguridad?useSSL=false&useTimezone=true&serverTimezone=UTC&allowpublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORD="";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }
    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
    
}
