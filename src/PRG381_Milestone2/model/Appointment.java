/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.model;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author calvi
 */
public class Appointment {
    private String counselorName;
    private Date appDate;
    private String appTime;
    //appStatus should only be allowed to be changed via drop 
    
    public Appointment(String counselorName, Date appDate, String appTime)
    {
        this.counselorName = counselorName;
        this.appDate = appDate;
        this.appTime = appTime;
    }
    
    public Date getDate() {
        return appDate;
    }
    public void setDate(Date newDate) {
        this.appDate = newDate;
    }

    public String getTime() {
        return appTime;
    }
    public void setTime(String newTime) {
        this.appTime = newTime;
    }
    
    public String getCounName() {
        return counselorName;
    }
    public void setCounName(String newConName) {
        this.counselorName = newConName;
    }
    
    
}
