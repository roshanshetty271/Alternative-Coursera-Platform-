/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.FacultyRole;

import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.Department.DepartmentModel;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class FacultyDirectoryModel {

    DepartmentModel department;
    ArrayList<FacultyProfileModel> teacherlist;

    public ArrayList<FacultyProfileModel> getTeacherlist() {
        return teacherlist;
    }

    public FacultyDirectoryModel(DepartmentModel d) {

        department = d;
        teacherlist = new ArrayList();

    }

    public FacultyProfileModel newStudentProfile(PersonRoleModel p) {

        FacultyProfileModel sp = new FacultyProfileModel(p);
        teacherlist.add(sp);
        return sp;
    }

    public FacultyProfileModel findTeachingFaculty(String id) {

        for (FacultyProfileModel sp : teacherlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
