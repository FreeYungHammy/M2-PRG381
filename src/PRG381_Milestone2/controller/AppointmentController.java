/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import PRG381_Milestone2.model.Appointment;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author calvi
 */
public class AppointmentController {
    
    //use form input as method input
    public void bookAppointment(String counselor, Date date, LocalTime time)
    {
        
        //validation
        //-->then create appointment object
        Appointment newApp = new Appointment(counselor, date, time, "upcoming");

        //update list adn then maybe update database or only update database at end of operation
        
    }
    
    public Appointment updateApp(Appointment appChanged, String counselor, Date date, LocalTime time)
    {
        //validation and error checks
        appChanged.setCounName(counselor);
        appChanged.setDate(date);
        appChanged.setTime(time);
        
        return appChanged;
    }
}
