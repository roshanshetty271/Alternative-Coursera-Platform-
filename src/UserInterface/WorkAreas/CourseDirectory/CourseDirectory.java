/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseDirectory;

import UserInterface.WorkAreas.Department.DepartmentModel;
import java.util.ArrayList;

/**
 *
 * @author marve
 */
public class CourseDirectory {
    DepartmentModel department;
    String lastupdated;
    ArrayList<Course> courselist; 

    public void setCourselist(ArrayList<Course> courselist) {
        this.courselist = courselist;
    }
    
    
    
    public CourseDirectory(DepartmentModel d){
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course(n, nm, cr);
        courselist.add(c);
        return c;
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }

}
