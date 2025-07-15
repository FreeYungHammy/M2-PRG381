/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.controller;

import PRG381_Milestone2.model.Feedback;

/**
 *
 * @author calvi
 */
public class FeedbackController {
    public void feedSubmit(String name, int rating, String comments)
    {
        
        //validation
        //feedback object creation
        Feedback newFeedback = new Feedback(name, rating, comments);
        
        //update array
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
}
