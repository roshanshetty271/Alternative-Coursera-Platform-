/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.FacultyRole;

import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;

/**
 *
 * @author prasanna
 */
public class FacultyAssignmentModel {
    
    CoursesOffer courseoffer;

    public CoursesOffer getCourseoffer() {
        return courseoffer;
    }
    FacultyProfileModel facultyprofile;
    public FacultyAssignmentModel(FacultyProfileModel fp, CoursesOffer co){
        courseoffer = co;
        facultyprofile = fp;
    }
    public FacultyProfileModel getFacultyProfile(){
        return facultyprofile;
    }
    
}
