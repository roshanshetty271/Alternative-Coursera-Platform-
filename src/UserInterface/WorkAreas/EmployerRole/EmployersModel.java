/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.EmployerRole;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseDirectory.CourseDirectory;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import java.util.ArrayList;

/**
 *
 * @author marve
 */
public class EmployersModel  {
    
    String employerName;
    PersonRoleModel person;
   // ArrayList<CourseOffer> relevantcourseoffers;
    ArrayList<Course> relevantcourses;

    public ArrayList<Course> getRelevantcourses() {
        return relevantcourses;
    }

    public void setRelevantcourses(ArrayList<Course> relevantcourses) {
        this.relevantcourses = relevantcourses;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    
    public void test(){
        
         EmployerDirectoryModel ed = new UserInterface.WorkAreas.Example.UserInterfaceWorkAreaExample().getED();
         System.out.println("EDD "+ ed.getEmployers());
         
        
    }
    
    
    
}
