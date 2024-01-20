/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.RolesDirectory.PatientRole;
import Business.RolesDirectory.Roles;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class PatientOrg extends Org {
    
    public PatientOrg()
    {
        super(Org.Type.Patient.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new PatientRole());
        return roles;
    }
    
}
