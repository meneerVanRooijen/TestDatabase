package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vanrooijen
 */
public class Student {
    
    private Integer id = 0;
    private String name = "";
    
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private DbConnection dbConnection = null;
    private Connection connection =  null;
    
    public Student() {
        dbConnection = new DbConnection();
        connection = dbConnection.getConnection();        
    }
    
    public void readStudent() {
        try {
            String query = "SELECT * FROM Student WHERE Id = ?";
            
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);

            ResultSet rs;
            rs = preparedStmt.executeQuery();
            rs.next();
            setName(rs.getString("Name"));
            
        }
        catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void updateStudent() {
        try {
            String query = "UPDATE Student SET Name = ? WHERE id = ?";
            
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt   (2, id);

            preparedStmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
 
    public void addStudent() {
        try {
            String query = "INSERT INTO Student (Id, Name) VALUES (?, ?)";
            
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt     (1, id);
            preparedStmt.setString  (2, name);
            
            preparedStmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteStudent() {
        try {
            String query = "DELETE FROM Student WHERE Id = ?";
            
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            
            preparedStmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}