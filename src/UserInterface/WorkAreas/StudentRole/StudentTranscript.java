/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.StudentRole;

import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.SeatsAssignment;
import java.util.HashMap;

/**
 *
 * @author marve
 */
public class StudentTranscript {
    
    
    HashMap<String, CoursesLoad> courseloadlist;
    
    CoursesLoad currentcourseload;
    Double gpa = 0.00;

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
    public StudentTranscript(){
        
        courseloadlist = new HashMap<String, CoursesLoad>();
        
    }
    public CoursesLoad getAllcourses(){
        return currentcourseload;
    }
    public CoursesLoad newCourseLoad(String sem){
        
        currentcourseload = new CoursesLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public CoursesLoad getCourseLoad(String sem)
    {
        return courseloadlist.get(sem);
    }
    
    public CoursesLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
        public CoursesLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }
	//CourseLoad courseload;
	public double calculateGpa(){
            double gpa=0.0;
            for(CoursesLoad value: courseloadlist.values()){
                System.out.println("The semester is "+ value.getSemester());
                
                gpa += value.iterateSeatAssignments();
//                if(grade.equals("M")){
//                    gpa=10;
//                }else{
//                    gpa=15;
//                }
            }
            //System.out.println("StudentTranscript Class: "+gpa);
            
            setGpa(gpa);
            return gpa;
        }
}
