/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRG381_Milestone2.model;

/**
 *
 * @author calvi
 */
public class Feedback {
    private String name;
    private int rating;
    private String comments;
    
    public Feedback (String name, int rating, String comments)
    {
        this.name = name;
        this.rating = rating;
        this.comments = comments;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    public int getRating() 
    {
        return rating;
    }
    public void setRating(int newRating)
    {
        this.rating = newRating;
    }
    
    public String getComments()
    {
        return comments;
    }
    public void setComments(String newComments)
    {
        this.comments = newComments;
    }
}


