/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.Employer;

import UserInterface.WorkAreas.Department.DepartmentModel;
import java.util.ArrayList;

/**
 *
 * @author aayus
 */
public class EmployerCatalog {

    DepartmentModel department;
    ArrayList<EmployerFeedbackProfile> employerlist;

    public EmployerCatalog(DepartmentModel d) {

        department = d;
        employerlist = new ArrayList();

    }

    public EmployerFeedbackProfile newEmployerProfile(String n) {

        EmployerFeedbackProfile sp = new EmployerFeedbackProfile(n);
        employerlist.add(sp);
        return sp;
    }

    public EmployerFeedbackProfile findTeachingFaculty(String id) {

        for (EmployerFeedbackProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
