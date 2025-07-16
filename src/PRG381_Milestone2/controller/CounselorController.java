/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import PRG381_Milestone2.model.Counselor;

/**
 *
 * @author calvi
 */
public class CounselorController {
    public void addCoun(String name, String specialization, String available)
    {
        //validation 
        //creating counselor object
        
        Counselor newCounselor = new Counselor(name, specialization, available);
        
        //adding to array update database at the end
    }
    
    public Counselor updateCoun(Counselor updatedCount, String name, String specialization, String available)
    {
        updatedCount.setName(name);
        updatedCount.setSpec(specialization);
        updatedCount.setAvailable(available); //drop down menu for true or false
    
        return updatedCount;
    }
    
}
