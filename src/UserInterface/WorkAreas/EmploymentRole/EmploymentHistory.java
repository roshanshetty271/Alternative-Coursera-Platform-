/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.EmploymentRole;

import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class EmploymentHistory {
    ArrayList<EmploymentModel> employments;
    public EmploymentHistory(){
        employments = new ArrayList();
    }
    
    public EmploymentModel newEmployment(String job){
        EmploymentModel ne = new EmploymentModel(job);
        employments.add(ne);
        return ne;
    }
    
}
