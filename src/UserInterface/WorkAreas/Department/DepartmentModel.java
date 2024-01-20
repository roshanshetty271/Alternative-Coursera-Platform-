/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.Department;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseDirectory.CourseDirectory;
import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import UserInterface.WorkAreas.FacultyRole.FacultyDirectoryModel;
import UserInterface.WorkAreas.StudentRole.PersonCatalog;
import UserInterface.WorkAreas.StudentRole.StudentCatalog;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.util.HashMap;

/**
 *
 * @author aayus
 */
public class DepartmentModel {

    String name;

    public String getName() {
        return name;
    }
    CourseDirectory coursecatalog;
    PersonCatalog persondirectory;
    StudentCatalog studentdirectory;
    FacultyDirectoryModel facultydirectory;
    //EmployerDirectory employerdirectory;


    HashMap<String, CoursesSchedule> mastercoursecatalog;

    public DepartmentModel(String n) {
        name = n;
        mastercoursecatalog = new HashMap<String, CoursesSchedule>();
        coursecatalog = new CourseDirectory(this);
        studentdirectory = new StudentCatalog(this); //pass the department object so it stays linked to it
        persondirectory = new PersonCatalog();
        facultydirectory = new FacultyDirectoryModel(this);
    }

    public PersonCatalog getPersonDirectory() {

        return persondirectory;

    }
     public FacultyDirectoryModel getFacultyDirectory() {

        return facultydirectory;

    }

    public StudentCatalog getStudentDirectory() {
    return studentdirectory;
    }

    public CoursesSchedule newCourseSchedule(String semester) {

        CoursesSchedule cs = new CoursesSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CoursesSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseDirectory getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {

        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CoursesSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfileModel sp = studentdirectory.findStudent(studentid);

        CoursesLoad cl = sp.getCurrentCourseLoad();

        CoursesSchedule cs = mastercoursecatalog.get(semester);

        CoursesOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
}
