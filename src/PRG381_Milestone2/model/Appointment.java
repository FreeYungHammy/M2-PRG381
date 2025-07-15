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
    private LocalTime appTime;
    private String appStatus;
    //appStatus should only be allowed to be changed via drop 
    
    public Appointment(String counselorName, Date appDate, LocalTime appTime, String appStatus)
    {
        this.counselorName = counselorName;
        this.appDate = appDate;
        this.appTime = appTime;
        this.appStatus = appStatus;
    }
    
    public Date getDate() {
        return appDate;
    }
    public void setDate(Date newDate) {
        this.appDate = newDate;
    }

    public LocalTime getTime() {
        return appTime;
    }
    public void setTime(LocalTime newTime) {
        this.appTime = newTime;
    }
    
    public String getCounName() {
        return counselorName;
    }
    public void setCounName(String newConName) {
        this.counselorName = newConName;
    }
    
    public String getStatus() {
        return appStatus;
    }
    public void setStatus(String updateStatus) {
        this.appStatus = updateStatus;
    }
    
}
