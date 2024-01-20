/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.Test1;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import UserInterface.WorkAreas.CourseSchedule.Seats;
import UserInterface.WorkAreas.CourseSchedule.SeatsAssignment;
import UserInterface.WorkAreas.Department.DepartmentModel;
import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.StudentRole.PersonCatalog;
import UserInterface.WorkAreas.StudentRole.StudentCatalog;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.util.Arrays;

/**
 *
 * @author marve
 */
public class Test1 {
    
    public static void main(String args[]){
        
        // TODO code application logic here
        DepartmentModel department = new DepartmentModel("Coursess");
        Course course = department.newCourse("AED", "info 5100", 4);
        CoursesSchedule courseschedule = department.newCourseSchedule("Fall2023");
        CoursesOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        CoursesOffer courseoffer1 = courseschedule.newCourseOffer("PSA 6205");
        courseoffer.generatSeats(10);
        
        PersonCatalog pd = department.getPersonDirectory();
        PersonRoleModel person = pd.newPerson("1");
        StudentCatalog sd = department.getStudentDirectory();
        StudentProfileModel student = sd.newStudentProfile(person);
        CoursesLoad courseload = student.newCourseLoad("Fall2023"); 
//        
        courseload.newSeatAssignment(courseoffer).assignGradeToStudent("A"); //register student in class
      //  courseload.newSeatAssignment(courseoffer1).assignGradeToStudent("A");
        
        SeatsAssignment sa = new SeatsAssignment();
        sa.assignGradeToStudent("A");
        
//        
        int total = department.calculateRevenuesBySemester("Fall2023");
        System.out.println("Total: " + total);
        
        
        //
        System.out.println("Test 1");
       // System.out.println(sd.findStudent("0112303").getCourseLoadBySemester("Fall2023"));
        
        CoursesLoad cd = sd.findStudent("1").getCourseLoadBySemester("Fall2023");
        //System.out.println("cd "+ cd.getSeatassignments().get(0));
        //SeatAssignment sa1 = cd.getSeatassignments().get(0);
      //  System.out.println("SA "+cd.getSeatassignments().get(0).getGrade());
            System.out.println("SA ");
            
        
    }
    
}
