package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanrooijen
 */
public class DbConnection {
    
    private String db;
    private String user;
    private String password;
    
    private Connection con = null;
    
    public DbConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            
            db = "jdbc:mysql://localhost:3306/Course_Administration";
            user = "root";
            password = "";
            
            con = DriverManager.getConnection(db, user, password);

        }
        catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());    
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {
        return con;
    }
}