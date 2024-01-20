/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import UserInterface.WorkAreas.CourseSchedule.SeatsAssignment;
import UserInterface.WorkAreas.Department.DepartmentModel;
import UserInterface.WorkAreas.EmployerRole.EmployerDirectoryModel;
import UserInterface.WorkAreas.EmployerRole.EmployersModel;
import UserInterface.WorkAreas.FacultyRole.FacultyAssignmentModel;
import UserInterface.WorkAreas.FacultyRole.FacultyDirectoryModel;
import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;
import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.StudentRole.PersonCatalog;
import UserInterface.WorkAreas.StudentRole.StudentCatalog;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author marve
 */
public class Method {
    
    public List<Course> getCourseOffer(DepartmentModel d , String semester)
    {
        CoursesSchedule courseSchedule = d.getCourseSchedule(semester);
        List<CoursesOffer> courseOffer = courseSchedule.getSchedule();
        List<Course> course = new ArrayList();
        for(CoursesOffer co : courseOffer)
        {
            course.add(co.getCourse());
        }
        return course;
    }
    
    public List<CoursesOffer> getCourseOfferList(DepartmentModel d , String semester)
    {
        CoursesSchedule courseSchedule = d.getCourseSchedule(semester);
        List<CoursesOffer> courseOffer = courseSchedule.getSchedule();
        
        return courseOffer;
    }
    
    public List<StudentProfileModel> getStudent(DepartmentModel d)
    {
        List<StudentProfileModel> profile = d.getStudentDirectory().getStudentlist();
        List<StudentProfileModel> list = new ArrayList();
        for(StudentProfileModel studentProfile : profile)
        {
            if(!studentProfile.getIsAlumni())
                list.add(studentProfile);
        }
        return list;
        
       
        
    }

    
     public void addStudentToAlumni(StudentProfileModel sp){
        EmployersModel em = new EmployersModel();
        em.setEmployerName("");
//        emp.add(em);
//        ed.setEmployers(emp);
       
        sp.setIsAlumni(true);
        
       // ad.setAd(alu);
       
    //    System.out.println("AS "+ ad.getAd().size());
     }
        
    public void addStudent(DepartmentModel d , String studentName , String studentId , String semester , CoursesOffer co)
    {
        //CourseSchedule courseschedule = d.getCourseSchedule(semester);
        StudentCatalog sd = d.getStudentDirectory();
        PersonCatalog pd = d.getPersonDirectory();
        PersonRoleModel person =  pd.newPerson(studentId);
        person.setName(studentName);
         
        StudentProfileModel student = sd.newStudentProfile(person);
        
        
        CoursesLoad courseload = student.newCourseLoad("Fall2023"); 
  
        courseload.newSeatAssignment(co);
        
    }
    
    public void addProfessor(DepartmentModel d , String professorName , String professorId , String semester , CoursesOffer co)
    {
        //CourseSchedule courseschedule = d.getCourseSchedule(semester);
        PersonCatalog pd = d.getPersonDirectory();
        FacultyDirectoryModel fd = d.getFacultyDirectory();
        PersonRoleModel person1 = pd.newPerson(professorId);
        FacultyProfileModel fp = fd.newStudentProfile(person1);
        co.AssignAsTeacher(fp);
        
    }
    
    
    
    
   
    
    public List<String> getProfessors(DepartmentModel d , StudentProfileModel sp)
    {
        List<SeatsAssignment> courseId = sp.getCurrentCourseLoad().getSeatassignments();
        List <String> list = new ArrayList();
        List<String> result = new ArrayList();
        for(SeatsAssignment s : courseId)
        {
            list.add(s.getSeat().getCourseoffer().getCourse().getCOurseNumber());
        }
        FacultyDirectoryModel f = d.getFacultyDirectory();
        List<FacultyProfileModel> facultyProfile = f.getTeacherlist();
        for(FacultyProfileModel f1 : facultyProfile)
        {
            List<FacultyAssignmentModel> facultyAssignment = f1.getFacultyassignments();
            for(FacultyAssignmentModel f2 : facultyAssignment)
            {
            if(list.contains(f2.getCourseoffer().getCourseNumber()))
                    {
                        result.add(f2.getFacultyProfile().getPerson().getPersonId());
                    }
            }
            
        }
        
       return result; 
    }


//    public List<FacultyProfile> getProfessors(StudentProfileModel sp)
//    {
//        
//    }
//  public void checkAlumniRequiements(StudentProfileModel sp){
//       //sp.getTranscript().getCourseLoadBySemester("Fall2023").getCourseInformation();
//       int creditsTotal = 0;
//       for(SeatsAssignment value1:seatassignments){
//         creditsTotal += value1.getSeat().getCourseoffer().getCourse().getCoursePrice();
//       }
//        System.out.println("The Number of Credits is :"+creditsTotal);
//        if(creditsTotal >= 4){
//            //Call Function which Sribalaji which would add for Alumni
//            new Method().addStudentToAlumni(sp);
//        }
//        
//    }

    
}
