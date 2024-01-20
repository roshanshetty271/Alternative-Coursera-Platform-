/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseSchedule;

/**
 *
 * @author aayus
 */
public class Seats {
    
    Boolean occupied; 
    int number;
    SeatsAssignment seatassignment;

    public SeatsAssignment getSeatassignment() {
        return seatassignment;
    }
    CoursesOffer courseoffer;
	
	public CoursesOffer getCourseoffer() {
        return courseoffer;
    }
	
    public Seats (CoursesOffer co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        
    }

    public int getNumber() {
        return number;
    }
    
    public Boolean isOccupied(){
        return occupied;

    }
    public SeatsAssignment newSeatAssignment(){
        
        seatassignment = new SeatsAssignment(); //links seatassignment to seat
        seatassignment.setSeat(this);
		occupied = true;   
        return seatassignment;
    }
    
    
}
