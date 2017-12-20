package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
    
    // DEFINICIPON DE CONEXIÓN
    private static final String HOST_IP = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "practicauber";
    
    private static final String  USER = "root";
    private static final String PASSWORD = "thekinger";
    
    private static final String DB_CONNECTION = "jdbc:mariadb://" + HOST_IP + ":" + PORT + "/" + DATABASE;
    
    public Connection getDBConnection() {
        Connection dbConnection;
        try {
            Class.forName(DB_DRIVER);            
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            dbConnection  =  DriverManager.getConnection(DB_CONNECTION, USER, PASSWORD);
            return dbConnection;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
