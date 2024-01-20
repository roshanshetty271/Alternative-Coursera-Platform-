/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.Example;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import UserInterface.WorkAreas.CourseSchedule.SeatsAssignment;
import UserInterface.WorkAreas.CourseDirectory.CourseDirectory;
import UserInterface.WorkAreas.Department.DepartmentModel;
import UserInterface.WorkAreas.Department.DepartmentDirectoryModel;
import UserInterface.WorkAreas.FacultyRole.FacultyAssignmentModel;
import UserInterface.WorkAreas.FacultyRole.FacultyDirectoryModel;
import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;
import UserInterface.WorkAreas.EmployerRole.EmployerDirectoryModel;
import UserInterface.WorkAreas.EmployerRole.EmployersModel;
import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.StudentRole.PersonCatalog;
import UserInterface.WorkAreas.StudentRole.StudentCatalog;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import UserInterface.WorkAreas.StudentRole.StudentTranscript;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marve
 */
public class UserInterfaceWorkAreaExample {

    ArrayList<EmployersModel> emp = new ArrayList<>();
    static EmployerDirectoryModel ed = new EmployerDirectoryModel();
    static DepartmentDirectoryModel dd = new DepartmentDirectoryModel();
    

    public  DepartmentDirectoryModel getDd() {
        return dd;
    }

    public EmployerDirectoryModel getED(){
        return ed;
    }

    /**
     * @param args the command line arguments
     */
    static StudentCatalog sd ;
    public static void main(String[] args) {
        // TODO code application logic here
        DepartmentModel department = new DepartmentModel("Coursess");
         PersonCatalog pd = department.getPersonDirectory();
         FacultyDirectoryModel fd = department.getFacultyDirectory();
        PersonRoleModel person1 = pd.newPerson("123456");
        FacultyProfileModel fp = fd.newStudentProfile(person1);
        
        
        Course course = department.newCourse("app eng", "info 5100", 4);
        Course course1 = department.newCourse("dmdd", "info 6100", 5);
         
        CourseDirectory cc = new CourseDirectory(department);
        ArrayList<Course> ac = new ArrayList();
        ac.add(course);
        ac.add(course1);
        cc.setCourselist(ac);
        
        
        CoursesSchedule courseschedule = department.newCourseSchedule("Fall2023");

        CoursesOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
        courseoffer.AssignAsTeacher(fp);
        courseoffer.generatSeats(10);
        
        
        PersonRoleModel person = pd.newPerson("0112303");
         sd = department.getStudentDirectory();
        StudentProfileModel student = sd.newStudentProfile(person);
        CoursesLoad courseload = student.newCourseLoad("Fall2023"); 
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
        SeatsAssignment sa = new SeatsAssignment();
        sa.assignGradeToStudent("A");
        
        int total = department.calculateRevenuesBySemester("Fall2023");
        System.out.println("Total: " + total);
        ArrayList<CoursesOffer> al1 = courseschedule.getSchedule();
        System.out.println(al1.size());
         ArrayList<String> al2 = new ArrayList();
        for(int i=0 ; i < al1.size(); i++){
            //System.out.println(al1.get(i).getFacultyProfile());
            if(al1.get(i).getFacultyProfile().getPerson().getPersonId().equals("123456")){
                al2.add(al1.get(i).getCourse().getCOurseNumber());
            }
        }
        new UserInterfaceWorkAreaExample().getStudentTakenByProf(al2.get(0), sd);
        System.out.println("Total: 1" + courseoffer.getFacultyProfile().getPerson().getPersonId());
        
        
        //
        System.out.println("Test 1");
        System.out.println(sd.findStudent("0112303").getCourseLoadBySemester("Fall2023"));
        
        CoursesLoad cd = sd.findStudent("0112303").getCourseLoadBySemester("Fall2023");
        //cd.newSeatAssignment(courseoffer)

       
        ArrayList<EmployersModel> emp = new ArrayList<>();
        EmployersModel em = new EmployersModel();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
        
        StudentProfileModel sp = sd.findStudent("0112303");
       // System.out.println("");
        
        
        
        
        
    }
public void getStudentTakenByProf(String courseID, StudentCatalog sd){
        
        ArrayList<StudentProfileModel> as = new ArrayList();
        List<StudentProfileModel> list = sd.getStudentlist();
        for(StudentProfileModel sp : list)
        {
            List<SeatsAssignment> list1 = sp.getCourseLoadBySemester("Fall2023").getSeatassignments();
            for(SeatsAssignment seatAssignment : list1)
            {
                if(seatAssignment.getSeat().getCourseoffer().getCourse().getCOurseNumber().equals(courseID))
                {
                    System.out.println(sp.getPerson().getPersonId());
                }
            }
        }
     
        
    }

    public void test1(){
        System.out.println("TEST 1");
        DepartmentModel department = new DepartmentModel("Coursess");

        Course course = department.newCourse("app eng", "info 5100", 4);

        CoursesSchedule courseschedule = department.newCourseSchedule("Fall2023");

        CoursesOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        
        courseoffer.generatSeats(10);
        
        PersonCatalog pd = department.getPersonDirectory();
        PersonRoleModel person = pd.newPerson("01");
        PersonRoleModel person1 = pd.newPerson("07");
        StudentCatalog sd = department.getStudentDirectory();
        StudentProfileModel student = sd.newStudentProfile(person);
        StudentProfileModel student1 = sd.newStudentProfile(person1);        
        CoursesLoad courseload = student.newCourseLoad("Fall2023");
        CoursesLoad courseload1 = student1.newCourseLoad("Fall2021");
//        
        courseload.newSeatAssignment(courseoffer); //register student in class
         
        
        EmployerDirectoryModel ed = new EmployerDirectoryModel();
        ArrayList<EmployersModel> emp = new ArrayList<>();
        EmployersModel em = new EmployersModel();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
       
        StudentProfileModel sp = sd.findStudent("01");
       // System.out.println("");
        
        StudentProfileModel sp1 = sd.findStudent("07");
       // System.out.println("");
        //Alumni al = new Alumni();
        
        
        
        
        
    }
    

     public void test2(){
        DepartmentModel department = new DepartmentModel("Coursess");
//        DepartmentModel department1 = new DepartmentModel("Computer Science");
        ArrayList<DepartmentModel> ad = new ArrayList<>();
        ad.add(department);
//        ad.add(department1);
        dd.setDd(ad);
        
        Course course = department.newCourse("app eng", "info 5100", 4);        
        Course course1 = department.newCourse("PDP", "cs 5010", 4);

        CoursesSchedule courseschedule = department.newCourseSchedule("Fall2023");
        CoursesSchedule courseschedule1 = department.newCourseSchedule("Fall2023");

        CoursesOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        courseoffer.generatSeats(10);
        
        CoursesOffer courseoffer1 = courseschedule1.newCourseOffer("cs 5010");
        courseoffer1.generatSeats(10);
        
        PersonCatalog pd = department.getPersonDirectory();
        PersonRoleModel person =  pd.newPerson("info1");
        PersonRoleModel person1 = pd.newPerson("info2");
        PersonRoleModel person2 = pd.newPerson("cs1");
        PersonRoleModel person3 = pd.newPerson("cs2");
        
        StudentCatalog sd = department.getStudentDirectory();
        StudentCatalog sd1 = department.getStudentDirectory();

        StudentProfileModel student = sd.newStudentProfile(person);
        StudentProfileModel student1 = sd.newStudentProfile(person1);
        
        StudentProfileModel student2 = sd1.newStudentProfile(person2);
        StudentProfileModel student3 = sd1.newStudentProfile(person3);
        
        CoursesLoad courseload = student.newCourseLoad("Fall2023"); 
        CoursesLoad courseload1 = student1.newCourseLoad("Fall2023"); 
        CoursesLoad courseload2 = student2.newCourseLoad("Fall2023"); 
        CoursesLoad courseload3 = student3.newCourseLoad("Fall2023"); 

        courseload.newSeatAssignment(courseoffer); //register student in class
        courseload1.newSeatAssignment(courseoffer);
        courseload2.newSeatAssignment(courseoffer1);
        courseload3.newSeatAssignment(courseoffer1);

             
    }
     
     
     
     
     //Alumni Growth Metric
     public void calculateAGM(){
        
        
      
                 
     }
     
     
     public void addStudentToAlumni(){
        EmployersModel em = new EmployersModel();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
       
        StudentProfileModel sp = sd.findStudent("0112303");
        StudentProfileModel sp1 = sd.findStudent("0112304");

       // System.out.println("");
        
        
        
        
     }
     
     


}
