/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseSchedule;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.FacultyRole.FacultyAssignmentModel;
import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;
import java.util.ArrayList;

/**
 *
 * @author aayus
 */
public class CoursesOffer {

    Course course;
    ArrayList<Seats> seatlist;

    FacultyAssignmentModel facultyassignment;
   
    public ArrayList<Seats> getSeatlist() {
        return seatlist;
    }
  	
    public Course getCourse() {
        return course;
    }
    public CoursesOffer(Course c) {
        course = c;
        seatlist = new ArrayList();
    }

   

    public void setCourse(Course course) {
        this.course = course;
    }
    public void AssignAsTeacher(FacultyProfileModel fp) {

        facultyassignment = new FacultyAssignmentModel(fp, this);
    }

    public FacultyProfileModel getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCOurseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seats(this, i));

        }

    }

    public Seats getEmptySeat() {

        for (Seats s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatsAssignment assignEmptySeat(CoursesLoad cl) {

        Seats seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatsAssignment sa = seat.newSeatAssignment(); //seat is already linked to course offer
        cl.registerStudent(sa);; //coures offer seat is now linked to student
        return sa;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seats s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }

}
