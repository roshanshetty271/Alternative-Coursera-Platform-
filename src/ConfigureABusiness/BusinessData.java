/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfigureABusiness;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseDirectory.CourseDirectory;
import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import UserInterface.WorkAreas.CourseSchedule.SeatsAssignment;
import UserInterface.WorkAreas.Department.DepartmentModel;
import UserInterface.WorkAreas.Department.DepartmentDirectoryModel;
import UserInterface.WorkAreas.EmployerRole.EmployerDirectoryModel;
import UserInterface.WorkAreas.EmployerRole.EmployersModel;
import UserInterface.WorkAreas.FacultyRole.FacultyDirectoryModel;
import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;
import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.StudentRole.PersonCatalog;
import UserInterface.WorkAreas.StudentRole.StudentCatalog;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aayus
 */
public class BusinessData {

    static BusinessData testData;
    
    public  static BusinessData getInstance()
    {
        if(testData==null)
        {
            testData = new BusinessData();
        }
        
        return testData;
        
    }
    
    ArrayList<EmployersModel> emp = new ArrayList<>();
    EmployerDirectoryModel ed = new EmployerDirectoryModel();
    DepartmentDirectoryModel dd = new DepartmentDirectoryModel();

    

    StudentCatalog sd ;


    public  DepartmentDirectoryModel getDd() {
        return dd;
    }

    
    public EmployerDirectoryModel getED(){
        return ed;
    }

    public StudentCatalog getSd() {
        return sd;
    }

    
    

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
         
        
        
        
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
        em.setEmployerName("");
        emp.add(em);
        ed.setEmployers(emp);
        
        StudentProfileModel sp = sd.findStudent("01");
       // System.out.println("");
       
        
        
        
        
        
        
    }
    

     public void test2(){
        DepartmentModel department = new DepartmentModel("Coursess");
//        DepartmentModel department1 = new DepartmentModel("Computer Science");
        ArrayList<DepartmentModel> ad = new ArrayList<>();
        ad.add(department);
//        ad.add(department1);
        dd.setDd(ad);
        
        Course courseinfo1 = department.newCourse("App Eng", "5100", 4); 
        courseinfo1.setRating(10);
        Course courseinfo2 = department.newCourse("DSC", "5101", 4);
        courseinfo2.setRating(2);
        Course courseinfo3 = department.newCourse("Web Design", "6203", 4);
        courseinfo3.setRating(5);
        Course courseinfo4 = department.newCourse("DWBI", "7546", 4);
        courseinfo4.setRating(4);
        Course courseinfo5 = department.newCourse("Web Tools", "6100", 4); 
        courseinfo5.setRating(6);
        Course courseinfo6 = department.newCourse("Cloud", "7101", 4);
        courseinfo6.setRating(8);
        Course courseinfo7 = department.newCourse("DMDB", "6353", 4);
        courseinfo7.setRating(9);
        Course courseinfo8 = department.newCourse("ADSC", "7106", 4);
        courseinfo8.setRating(10);
        Course coursecsc1 = department.newCourse("PDP", "5010", 4);
        coursecsc1.setRating(7);
        Course coursecsc2 = department.newCourse("NLP", "5204", 4);
        coursecsc2.setRating(9);
        Course coursecsc3 = department.newCourse("AI", "7010", 4);
        coursecsc3.setRating(10);
        Course coursecsc4 = department.newCourse("Network", "6284", 4);
        coursecsc4.setRating(8);
        
        
        

        CoursesSchedule courseschedule = department.newCourseSchedule("Fall2023");
//        CoursesSchedule courseschedule1 = department1.newCourseSchedule("Fall2023");

        CoursesOffer courseoffer = courseschedule.newCourseOffer("5100");
        courseoffer.generatSeats(10);
        
        CoursesOffer courseoffer2 = courseschedule.newCourseOffer("5101");
        courseoffer2.generatSeats(10);
        
        CoursesOffer courseoffer3 = courseschedule.newCourseOffer("6203");
        courseoffer3.generatSeats(10);
        
        CoursesOffer courseoffer4 = courseschedule.newCourseOffer("7546");
        courseoffer4.generatSeats(10);
        
        CoursesOffer courseoffer5 = courseschedule.newCourseOffer("6100");
        courseoffer5.generatSeats(10);
        
        CoursesOffer courseoffer6 = courseschedule.newCourseOffer("7101");
        courseoffer6.generatSeats(10);
        
        CoursesOffer courseoffer7 = courseschedule.newCourseOffer("6353");
        courseoffer7.generatSeats(10);
        
        CoursesOffer courseoffer8 = courseschedule.newCourseOffer("7106");
        courseoffer8.generatSeats(10);
        CoursesOffer courseoffer1 = courseschedule.newCourseOffer("5010");
        courseoffer1.generatSeats(10);
        
        CoursesOffer courseoffer9 = courseschedule.newCourseOffer("6284");
        courseoffer9.generatSeats(10);
        
        CoursesOffer courseoffer10 = courseschedule.newCourseOffer("5204");
        courseoffer10.generatSeats(10);
        
        CoursesOffer courseoffer11 = courseschedule.newCourseOffer("7010");
        courseoffer11.generatSeats(10);


        
        PersonCatalog pd = department.getPersonDirectory();
      //  PersonCatalog pd1 = department1.getPersonDirectory();

        PersonRoleModel person =  pd.newPerson("info1");
        PersonRoleModel person1 = pd.newPerson("info2");
        PersonRoleModel person2 = pd.newPerson("info3");
        PersonRoleModel person3 = pd.newPerson("info4");
        PersonRoleModel person4 =  pd.newPerson("info5");
        PersonRoleModel person5 = pd.newPerson("info6");
        PersonRoleModel person6 = pd.newPerson("info7");
        PersonRoleModel person7 = pd.newPerson("info8");
        PersonRoleModel person8 =  pd.newPerson("info9");
        PersonRoleModel person9 = pd.newPerson("info10");
        PersonRoleModel person10 = pd.newPerson("info11");
        PersonRoleModel person11 = pd.newPerson("info12");
        PersonRoleModel person12 =  pd.newPerson("info13");
        PersonRoleModel person13 = pd.newPerson("info14");
        PersonRoleModel person14 = pd.newPerson("info15");
        PersonRoleModel person15 = pd.newPerson("info16");
        PersonRoleModel person16 =  pd.newPerson("cs1");
        PersonRoleModel person17 = pd.newPerson("cs2");
        PersonRoleModel person18 = pd.newPerson("cs3");
        PersonRoleModel person19 = pd.newPerson("cs4");
        PersonRoleModel person20 = pd.newPerson("cs5");
        PersonRoleModel person21 = pd.newPerson("cs6");
        PersonRoleModel person22 = pd.newPerson("cs7");
        PersonRoleModel person23 = pd.newPerson("cs8");
       
        
        person.setName("Aarav Patel");
        person1.setName("Jing Wu");
        person2.setName("Anika Desai");
        person3.setName("Emily Johnson");
        person4.setName("Carlos Martinez");
        person5.setName("Juan Rodriguez");
        person6.setName("Michael Smith");
        person7.setName("Mei Li");
        person8.setName("Xing Zhang");
        person9.setName("Priya Sharma");
        person10.setName("Wei Chen");
        person11.setName("Maria Garcia");
        person12.setName("Isabella Lopez");
        person13.setName("Rahul Singh");
        person14.setName("Tao Wang");
        person15.setName("David Davis");
        person16.setName("Olga Petrov");
        person17.setName("Andrei Kozlov");
        person18.setName("Dmitry Ivanov");
        person19.setName("Pedro Ramirez");
        person20.setName("Sarah Williams");
        person21.setName("Vikram Singh");
        person22.setName("Natalia Volkova");
        person23.setName("Arjun Kapoor");

        
        sd = department.getStudentDirectory();
//        StudentCatalog sd1 = department1.getStudentDirectory();

        StudentProfileModel student = sd.newStudentProfile(person);
        StudentProfileModel student1 = sd.newStudentProfile(person1);
        StudentProfileModel student2 = sd.newStudentProfile(person2);
        StudentProfileModel student3 = sd.newStudentProfile(person3);
        StudentProfileModel student4 = sd.newStudentProfile(person4);
        StudentProfileModel student5 = sd.newStudentProfile(person5);
        StudentProfileModel student6= sd.newStudentProfile(person6);
        StudentProfileModel student7 = sd.newStudentProfile(person7);
        StudentProfileModel student8= sd.newStudentProfile(person8);
        StudentProfileModel student9 = sd.newStudentProfile(person9);
        StudentProfileModel student10 = sd.newStudentProfile(person10);
        StudentProfileModel student11 = sd.newStudentProfile(person11);
        StudentProfileModel student12= sd.newStudentProfile(person12);
        StudentProfileModel student13= sd.newStudentProfile(person13);
        StudentProfileModel student14= sd.newStudentProfile(person14);
        StudentProfileModel student15= sd.newStudentProfile(person15);
        StudentProfileModel student16= sd.newStudentProfile(person16);
        StudentProfileModel student17= sd.newStudentProfile(person17);
        StudentProfileModel student18= sd.newStudentProfile(person18);
        StudentProfileModel student19 = sd.newStudentProfile(person19);
        StudentProfileModel student20 = sd.newStudentProfile(person20);
        StudentProfileModel student21 = sd.newStudentProfile(person21);
        StudentProfileModel student22 = sd.newStudentProfile(person22);
        StudentProfileModel student23 = sd.newStudentProfile(person23);
        
        CoursesLoad courseload = student.newCourseLoad("Fall2023"); 
        CoursesLoad courseload1 = student1.newCourseLoad("Fall2023"); 
        CoursesLoad courseload2 = student2.newCourseLoad("Fall2023"); 
        CoursesLoad courseload3 = student3.newCourseLoad("Fall2023");
        CoursesLoad courseload4 = student4.newCourseLoad("Fall2023");
        CoursesLoad courseload5 = student5.newCourseLoad("Fall2023");
        CoursesLoad courseload6 = student6.newCourseLoad("Fall2023");
        CoursesLoad courseload7 = student7.newCourseLoad("Fall2023");
        CoursesLoad courseload8 = student8.newCourseLoad("Fall2023");
        CoursesLoad courseload9 = student9.newCourseLoad("Fall2023");
        CoursesLoad courseload10 = student10.newCourseLoad("Fall2023");
        CoursesLoad courseload11 = student11.newCourseLoad("Fall2023");
        CoursesLoad courseload12= student12.newCourseLoad("Fall2023");
        CoursesLoad courseload13 = student13.newCourseLoad("Fall2023");
        CoursesLoad courseload14 = student14.newCourseLoad("Fall2023");
        CoursesLoad courseload15 = student15.newCourseLoad("Fall2023");
        CoursesLoad courseload16 = student16.newCourseLoad("Fall2023");
        CoursesLoad courseload17 = student17.newCourseLoad("Fall2023");
        CoursesLoad courseload18 = student18.newCourseLoad("Fall2023");
        CoursesLoad courseload19 = student19.newCourseLoad("Fall2023");
        CoursesLoad courseload20 = student20.newCourseLoad("Fall2023");
        CoursesLoad courseload21 = student21.newCourseLoad("Fall2023");
        CoursesLoad courseload22 = student22.newCourseLoad("Fall2023");
        CoursesLoad courseload23 = student23.newCourseLoad("Fall2023");
        
        FacultyDirectoryModel fd = department.getFacultyDirectory();
       
//        FacultyDirectoryModel fd1 = department1.getFacultyDirectory();

        
        PersonRoleModel prof1 = pd.newPerson("prof");
        PersonRoleModel prof2 = pd.newPerson("prof1");
        PersonRoleModel prof3 = pd.newPerson("prof2");
        PersonRoleModel prof4 = pd.newPerson("prof3");
        PersonRoleModel prof5 = pd.newPerson("prof4");
        PersonRoleModel prof6 = pd.newPerson("prof5");
        PersonRoleModel prof7 = pd.newPerson("prof6");
        PersonRoleModel prof8 = pd.newPerson("prof7");
        PersonRoleModel prof9 = pd.newPerson("prof8");
        PersonRoleModel prof10 = pd.newPerson("prof9");
        PersonRoleModel prof11 = pd.newPerson("prof10");
        PersonRoleModel prof12 = pd.newPerson("prof11");
        
        
        prof1.setName("Kal");
        prof2.setName("Robin");
        prof3.setName("Nicholas");
        prof4.setName("Yusuf");
        prof5.setName("Dino");
        prof6.setName("Andrei");
        prof7.setName("Amuthan");
        prof8.setName("Vishal");
        prof9.setName("Jessica");
        prof10.setName("Giusep");
        prof11.setName("Vasudev");
        prof12.setName("Ashish");

        
        
        FacultyProfileModel fp = fd.newStudentProfile(prof1);
        fp.setFacultyRatings(10);
        fp.setLocation("Europe");
        
        FacultyProfileModel fp1 = fd.newStudentProfile(prof2);
        fp1.setFacultyRatings(9);
        fp1.setLocation("India");
        
        FacultyProfileModel fp2 = fd.newStudentProfile(prof3);
        fp2.setFacultyRatings(1);
        fp2.setLocation("USA");
        
        FacultyProfileModel fp3 = fd.newStudentProfile(prof4);
        fp3.setFacultyRatings(7);
        fp3.setLocation("Brazil");
        
        FacultyProfileModel fp4 = fd.newStudentProfile(prof5);
        fp4.setFacultyRatings(4);
        fp4.setLocation("India");
        
        FacultyProfileModel fp5 = fd.newStudentProfile(prof6);
        fp5.setFacultyRatings(8);
        fp5.setLocation("Russia");

        FacultyProfileModel fp6 = fd.newStudentProfile(prof7);
        fp6.setFacultyRatings(5);
        fp6.setLocation("Mexico");
        
        FacultyProfileModel fp7 = fd.newStudentProfile(prof8);
        fp7.setFacultyRatings(9);
        fp7.setLocation("France");
        
        FacultyProfileModel fp8 = fd.newStudentProfile(prof9);
        fp8.setFacultyRatings(6);
        fp8.setLocation("USA");
        
        FacultyProfileModel fp9 = fd.newStudentProfile(prof10);
        fp9.setFacultyRatings(8);
        fp9.setLocation("Canada");
        
        FacultyProfileModel fp10 = fd.newStudentProfile(prof11);
        fp10.setFacultyRatings(10);
        fp10.setLocation("India");
        
        FacultyProfileModel fp11 = fd.newStudentProfile(prof12);
        fp11.setFacultyRatings(8);
        fp11.setLocation("Japan");
        

        
        
        courseoffer.AssignAsTeacher(fp);
        fp.AssignAsTeacher(courseoffer);
        
        courseoffer1.AssignAsTeacher(fp1);
        fp1.AssignAsTeacher(courseoffer1);

        courseoffer2.AssignAsTeacher(fp2);
        fp2.AssignAsTeacher(courseoffer2);

        courseoffer3.AssignAsTeacher(fp3);
        fp3.AssignAsTeacher(courseoffer3);

        courseoffer4.AssignAsTeacher(fp4);
        fp4.AssignAsTeacher(courseoffer4);

        courseoffer5.AssignAsTeacher(fp5);
        courseoffer6.AssignAsTeacher(fp6);
        courseoffer7.AssignAsTeacher(fp7);
        courseoffer8.AssignAsTeacher(fp8);
        courseoffer9.AssignAsTeacher(fp9);
        courseoffer10.AssignAsTeacher(fp10);
        courseoffer11.AssignAsTeacher(fp11);

        
        

        courseload.newSeatAssignment(courseoffer); //register student in class
        
//        courseload.getSeatassignments().
        courseload1.newSeatAssignment(courseoffer);
        courseload2.newSeatAssignment(courseoffer2); //register student in class
        courseload3.newSeatAssignment(courseoffer2);
        courseload4.newSeatAssignment(courseoffer3);
        courseload5.newSeatAssignment(courseoffer3);
        courseload6.newSeatAssignment(courseoffer4); //register student in class
        courseload7.newSeatAssignment(courseoffer4);
        courseload8.newSeatAssignment(courseoffer5);
        courseload9.newSeatAssignment(courseoffer5);
        courseload10.newSeatAssignment(courseoffer6); //register student in class
        courseload11.newSeatAssignment(courseoffer6);
        courseload12.newSeatAssignment(courseoffer7);
        courseload13.newSeatAssignment(courseoffer7);
        courseload14.newSeatAssignment(courseoffer8); //register student in class
        courseload15.newSeatAssignment(courseoffer8);
        courseload16.newSeatAssignment(courseoffer1);
        courseload17.newSeatAssignment(courseoffer1);
        courseload18.newSeatAssignment(courseoffer9);
        courseload19.newSeatAssignment(courseoffer9);
        courseload20.newSeatAssignment(courseoffer10); //register student in class
        courseload21.newSeatAssignment(courseoffer10);
        courseload22.newSeatAssignment(courseoffer11);
        courseload23.newSeatAssignment(courseoffer11);
        

        
        rankProfessorByDepartment(department);
        EmployerDirectoryModel ed = new EmployerDirectoryModel();
        ArrayList<EmployersModel> emp = new ArrayList<>();
        EmployersModel em = new EmployersModel();
        em.setEmployerName("Amazon");
        emp.add(em);
        ed.setEmployers(emp);
        
        StudentProfileModel sp = sd.findStudent("info1");
        sp.setIsAlumni(true);
        
        //AlumniDirectory ad = new AlumniDirectory();
        
    }
     
     
     
     
     //Alumni Growth Metric

     
        public void rankProfessorByDepartment(DepartmentModel d){
        
        ArrayList<FacultyProfileModel> fp = d.getFacultyDirectory().getTeacherlist();
        for(FacultyProfileModel f : fp)
            System.out.println("BEfore Sorted form "+ f.getFacultyRatings());
        Collections.sort(fp,new Comparator<FacultyProfileModel>() {
            @Override
            public int compare(FacultyProfileModel o1, FacultyProfileModel o2) {
               
                return o2.getFacultyRatings() - o1.getFacultyRatings();
            }
        } );
        for(FacultyProfileModel f : fp)
            System.out.println("Sorted form "+ f.getFacultyRatings());

                
        
    }
    
}
