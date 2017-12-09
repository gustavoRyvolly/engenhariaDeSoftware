
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;






public class Conex {
    
    private static String url = "jdbc:postgresql://localhost:5432/restaurante";
    private static String driver = "org.postgresql.Driver";
    private static String user = "postgres";
    private static String senha = "root";
        
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName(driver);
            con = (Connection)DriverManager.getConnection(url, user, senha);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro ao conectar com banco de dados: "+ ex);
        }
       return con;
    }
    
    
    
    
}
