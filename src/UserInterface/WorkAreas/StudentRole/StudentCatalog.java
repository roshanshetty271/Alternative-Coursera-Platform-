/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.StudentRole;

import UserInterface.WorkAreas.Department.DepartmentModel;
import java.util.ArrayList;

/**
 *
 * @author aayus
 */
public class StudentCatalog {

    DepartmentModel department;

    public DepartmentModel getDepartment() {
        return department;
    }
    ArrayList<StudentProfileModel> studentlist;

     public StudentCatalog() {
   
    }
    
    public StudentCatalog(DepartmentModel d) {

        department = d;
        studentlist = new ArrayList();

    }

    public StudentProfileModel newStudentProfile(PersonRoleModel p) {

        StudentProfileModel sp = new StudentProfileModel(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfileModel findStudent(String id) {

        for (StudentProfileModel sp : studentlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }

    public ArrayList<StudentProfileModel> getStudentlist() {
        return studentlist;
    }

    public void setStudentlist(ArrayList<StudentProfileModel> studentlist) {
        this.studentlist = studentlist;
    }
    
}
