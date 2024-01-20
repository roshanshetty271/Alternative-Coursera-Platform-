/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseSchedule;

import Methods.Method;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import UserInterface.WorkAreas.StudentRole.StudentTranscript;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class CoursesLoad {

    String semester;
    ArrayList<SeatsAssignment> seatassignments;

    public ArrayList<SeatsAssignment> getSeatassignments() {
        return seatassignments;
    }

    public void setSeatassignments(ArrayList<SeatsAssignment> seatassignments) {
        this.seatassignments = seatassignments;
    }
     
    public String getSemester() {
        return semester;
    }
    
    public CoursesLoad(String s){
        seatassignments = new ArrayList<SeatsAssignment>();
        semester = s;
    }
    public SeatsAssignment newSeatAssignment(CoursesOffer co){
        
        Seats seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatsAssignment sa = seat.newSeatAssignment();
        sa.setSeat(seat);
        
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatsAssignment sa){
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
	
//	public Iterable<SeatAssignment> getSeatassignments() {
//       
//        return seatassignments; //To change body of generated methods, choose Tools | Templates.
//    }

    public double iterateSeatAssignments(){
        String grade= "";
        double gpa = 0.0;
        for(SeatsAssignment value1:seatassignments){
            System.out.println("The Course Name is: "+value1.getSeat().getCourseoffer().getCourse().getName());
            grade=value1.getGrade();
            switch(grade){
                case "A": 
                    gpa+=4.0;
                    break;
                case "A-": 
                    gpa+= 3.7;
                    break;
                case "B+": 
                    gpa+= 3.5;
                    break;
                case "B": 
                    gpa+= 3.3;
                    break;
                case "B-": 
                    gpa+= 3.0;
                    break;
                
                default: gpa = 0.0;
                
            }
            System.out.println("The Grade Received is: "+grade);
           // System.out.println("The Seats Assignment Size: "+seatassignments.size());
        }
        //check();
        return gpa/seatassignments.size();
    }
    
    //To display the Course Name and Course Grade in a table in UI
    public ArrayList getCourseInformation(){
        ArrayList courseGradeList = new ArrayList();
        for(SeatsAssignment value1:seatassignments){
            
            courseGradeList.add(value1.getSeat().getCourseoffer().getCourse().getName());
            
            courseGradeList.add(value1.getGrade());
        }
        System.out.println("Arraykist: "+courseGradeList.get(0));
        return courseGradeList;
        
        
    }
    
    //Transcript transcript;
  
}
