/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.StudentRole;

import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.EmploymentRole.EmploymentHistory;

/**
 *
 * @author aayus
 */
public class StudentProfileModel {

    PersonRoleModel person;
    StudentTranscript transcript;
    Boolean isAlumni = false;

    public Boolean getIsAlumni() {
        return isAlumni;
    }

    public void setIsAlumni(Boolean isAlumni) {
        this.isAlumni = isAlumni;
    }
    
    public StudentTranscript getTranscript() {
        return transcript;
    }

    public PersonRoleModel getPerson() {
        return person;
    }
    
    
    public double getGpa(){
        return transcript.calculateGpa();
    }

    public StudentProfileModel(PersonRoleModel p) {

        person = p;
        transcript = new StudentTranscript();
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    public CoursesLoad getallTranscript(){
        return transcript.getAllcourses();
    }

    public CoursesLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CoursesLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CoursesLoad newCourseLoad(String s){
        
        return transcript.newCourseLoad(s);
    }
	//CourseLoad courseload;
	public double studentPerformanceMetric(){
        
        double gpa = transcript.calculateGpa();
        
        double calcGPGA = (gpa * 2 ) + 2;
        System.out.println("Inside SPM: "+calcGPGA);
        //courseload.check();
        return calcGPGA;
    }   
        //call this function when Professor updates the grade
//        public void checkStudentIsAlumni(){
//            
//        }

}
