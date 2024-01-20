/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseSchedule;

/**
 *
 * @author aayus
 */
public class SeatsAssignment {

  Seats seat;

    public void setSeat(Seats seat) {
        this.seat = seat;
    }

    public Seats getSeat() {
        return seat;
    }
    CoursesLoad courseload;
    String grade="B+";
     public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public SeatsAssignment(CoursesLoad cl, Seats s,String g){
        seat = s;
        courseload = cl;
        grade=g;
    }
        public SeatsAssignment(){

    }
    public void assignSeatToStudent(CoursesLoad cl){
        courseload = cl;
    }
    
    public void assignGradeToStudent(String g){
        grade = g;
    }
    
}
