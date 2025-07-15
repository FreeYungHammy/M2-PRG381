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
public class Counselor {
    
    private String name;
    private String specialization;
    private boolean available;
    
    public Counselor(String name, String specialization, boolean available)
    {
        this.name = name;
        this.specialization = specialization;
        this.available = available;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getSpec() {
        return specialization;
    }
    public void setSpec(String newSpec) {
        this.specialization = newSpec;
    }
    
    public boolean getAvailable() {
        return available;
    }
    public void setAvailable(boolean newAvailable) {
        this.available = newAvailable;
    }
}
