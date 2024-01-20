/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.Department;

import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import java.lang.*;
import java.util.HashMap;
/**
 *
 * @author marve
 */
public class CalendarModel {
    
    HashMap<String, CoursesSchedule> mastercatalog; 
    
    public CalendarModel(){
    mastercatalog = new HashMap<String, CoursesSchedule>();    
    }
    
    public void addCourseSchedule(String semester, CoursesSchedule cs){
        
        mastercatalog.put(semester, cs);
        
    }
    
    
    
}
