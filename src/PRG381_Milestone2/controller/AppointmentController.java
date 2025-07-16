/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import PRG381_Milestone2.model.Appointment;
import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author calvi
 */
public class AppointmentController {
    
    private final Connection con;
    
    public AppointmentController(){
        this.con = DBConnection.getConnection();
        createTableIfNotExists();
        insertDummyData();
    }
    
    private void createTableIfNotExists(){
        String sql = "CREATE TABLE Appointment (" +
                "id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY , " +
                "counselor VARCHAR(100), " +
                "date DATE, " + 
                "time VARCHAR(20)" +
                ")";
        
        try(Statement stmt = con.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Appointment Table Created");
        } catch(SQLException e){
            if(e.getSQLState().equals("X0Y32")){
                System.out.println("Appointment table already exists.");
            } else {
              System.out.println("Error creating table: " + e.getMessage());
            }
        }
    }
    
    private void insertDummyData(){
        String sql = "SELECT COUNT(*) FROM Appointment";
        
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next() && rs.getInt(1) == 0) {
                System.out.println("Inserting dummy data...");

                insertAppointment(new Appointment("Dr. Smith", new Date(), "10:53"));
                insertAppointment(new Appointment("Dr. Adams", new Date(), "14:23"));
                insertAppointment(new Appointment("Dr. Ndlovu", new Date(), "13:43"));

                System.out.println("Dummy data inserted.");
            } else {
                System.out.println("Dummy data already present.");
            }
        } catch (SQLException e) {
        System.out.println("Error checking or inserting dummy data: " + e.getMessage());
        }
    }
    
    //use form input as method input
    public void bookAppointment(String counselor, Date date, String time)
    {
        
        //validation
        //-->then create appointment object
        Appointment newApp = new Appointment(counselor, date, time);

        //update list adn then maybe update database or only update database at end of operation
        insertAppointment(newApp);
    }
    
    public Appointment updateApp(Appointment appChanged, String counselor, Date date, String time)
    {
        //validation and error checks
        appChanged.setCounName(counselor);
        appChanged.setDate(date);
        appChanged.setTime(time);
        
        return appChanged;
    }
    
    public void insertAppointment(Appointment app){
        String sql = "INSERT INTO Appointment (counselor, date, time) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setString(1, app.getCounName());
            stmt.setDate(2, new java.sql.Date(app.getDate().getTime()));
            stmt.setString(3, app.getTime());
            
            stmt.executeUpdate();
            System.out.print("Appointment Inserted into database.");
        } catch (SQLException e){
            System.out.println("Error inserting into database");
        }
    }
    
    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM Appointment";
    
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String counselor = rs.getString("counselor");
                Date date = rs.getDate("date");
                String time = rs.getString("time"); 

                list.add(new Appointment(counselor, date, time));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving appointments: " + e.getMessage());
        }

        return list;
    }

}
