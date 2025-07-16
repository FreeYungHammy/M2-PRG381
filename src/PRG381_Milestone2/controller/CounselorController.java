/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import PRG381_Milestone2.model.Counselor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author calvi
 */
public class CounselorController {
    
    private final Connection con;

    public CounselorController() {
        this.con = DBConnection.getConnection();
        createTable();
        insertDummyData();
    }
    
    private void createTable() {
        String sql = "CREATE TABLE Counselor (" +
                     "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                     "name VARCHAR(100), " +
                     "specialization VARCHAR(100), " +
                     "available VARCHAR(100))";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Counselor table created.");
        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Counselor table already exists.");
            } else {
                System.out.println("Error creating Counselor table: " + e.getMessage());
            }
        }
    }
    
    private void insertDummyData() {
        String sql = "SELECT COUNT(*) FROM Counselor";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            if (rs.getInt(1) == 0) {
                insertCounselor(new Counselor("Dr. Mbatha", "Family Therapy", "yes"));
                insertCounselor(new Counselor("Dr. Singh", "Career Counseling", "yes"));
                insertCounselor(new Counselor("Dr. Dlamini", "Mental Health", "no"));
                System.out.println("Dummy counselor data inserted.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting counselor dummy data: " + e.getMessage());
        }
    }
    
    public void addCoun(String name, String specialization, String available)
    {
        //validation 
        //creating counselor object
        
        Counselor newCounselor = new Counselor(name, specialization, available);
        insertCounselor(newCounselor);
        //adding to array update database at the end
    }
    
    public Counselor updateCoun(Counselor updatedCount, String name, String specialization, String available)
    {
        updatedCount.setName(name);
        updatedCount.setSpec(specialization);
        updatedCount.setAvailable(available); //drop down menu for true or false
    
        return updatedCount;
    }
    // insert Counselors into db 
     public void insertCounselor(Counselor c) {
        String sql = "INSERT INTO Counselor (name, specialization, available) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getSpec());
            stmt.setString(3, c.getAvailable());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting counselor: " + e.getMessage());
        }
    }
// return all counselors from DB
    public List<Counselor> getAllCounselors() {
        List<Counselor> list = new ArrayList<>();
        String sql = "SELECT * FROM Counselor";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String name = rs.getString("name");
                String spec = rs.getString("specialization");
                String avail = rs.getString("available");
                list.add(new Counselor(name, spec, avail));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving counselors: " + e.getMessage());
        }
        return list;
    }

}
