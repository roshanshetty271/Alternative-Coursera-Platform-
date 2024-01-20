/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.FacultyRole;

import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class FacultyProfileModel {

    PersonRoleModel person;
    ArrayList <FacultyAssignmentModel> facultyassignments;
    int facultyRatings;
    String location;
    
    public int getFacultyRatings() {
        return facultyRatings;
    }

    public void setFacultyRatings(int facultyRatings) {
        this.facultyRatings = facultyRatings;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<FacultyAssignmentModel> getFacultyassignments() {
        return facultyassignments;
    }

    public FacultyProfileModel(PersonRoleModel p) {

        person = p;
        facultyassignments = new ArrayList();
    }

    public PersonRoleModel getPerson() {
        return person;
    }

    public FacultyAssignmentModel AssignAsTeacher(CoursesOffer co){
        
        FacultyAssignmentModel fa = new FacultyAssignmentModel(this, co);
        facultyassignments.add(fa);
        
        return fa;
    }
    
    public FacultyProfileModel getCourseOffer(String courseid){
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    
    
}
