/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author calvi
 */
public class DBConnection {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:M2PRG381;create=true";
    
    Connection con;
    
    public DBConnection(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(JDBC_URL);
            System.out.println("Connection to Derby DB successful.");
            
        }catch(ClassNotFoundException ex){
            System.out.println("JDBC Driver not found: " + ex.getMessage());
        }catch (SQLException ex){
            System.out.println("Failed to connect to DB: " + ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}
