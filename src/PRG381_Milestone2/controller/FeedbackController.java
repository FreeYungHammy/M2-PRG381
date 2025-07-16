/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import PRG381_Milestone2.model.Feedback;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author calvi
 */
public class FeedbackController {
    
    private final Connection con;
    
    public FeedbackController() {
        this.con = DBConnection.getConnection();
        createTable();
        insertDummyData();
    }
    // creating table for db if there isnt one already 
        private void createTable() {
        String sql = "CREATE TABLE Feedback (" +
                     "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, " +
                     "name VARCHAR(100), " +
                     "rating INT, " +
                     "comments VARCHAR(255))";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Feedback table created.");
        } catch (SQLException e) {
            if ("X0Y32".equals(e.getSQLState())) {
                System.out.println("Feedback table already exists.");
            } else {
                System.out.println("Error creating Feedback table: " + e.getMessage());
            }
        }
    }
        // adding dummy data for ease of manipulation 
    private void insertDummyData() {
        String sql = "SELECT COUNT(*) FROM Feedback";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            rs.next();
            if (rs.getInt(1) == 0) {
                insertFeedback(new Feedback("Calvin", 5, "Excellent service!"));
                insertFeedback(new Feedback("Danielle", 4, "Very helpful session."));
                insertFeedback(new Feedback("Alex", 3, "Could be more thorough."));
                System.out.println("Dummy feedback data inserted.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting dummy feedback: " + e.getMessage());
        }
    }
    
    public void feedSubmit(String name, int rating, String comments)
    {
        
        //validation
        //feedback object creation
        Feedback newFeedback = new Feedback(name, rating, comments);
       
        insertFeedback(newFeedback);
    }
    
    public Feedback updateFeed(Feedback changedFeed, String name, int rating, String comments)
    {
        
        //validation
        //changing objects values
        changedFeed.setName(name);
        changedFeed.setRating(rating);
        changedFeed.setComments(comments);
        
        return changedFeed;
    }
    // inserting feedback into db 
    public void insertFeedback(Feedback fb) {
        String sql = "INSERT INTO Feedback (name, rating, comments) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, fb.getName());
            stmt.setInt(2, fb.getRating());
            stmt.setString(3, fb.getComments());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting feedback: " + e.getMessage());
        }
    }
    // get all feedback from db 
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM Feedback";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String name = rs.getString("name");
                int rating = rs.getInt("rating");
                String comments = rs.getString("comments");
                feedbackList.add(new Feedback(name, rating, comments));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving feedback: " + e.getMessage());
        }
        return feedbackList;
    }
}
