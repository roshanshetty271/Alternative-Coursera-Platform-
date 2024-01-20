/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.RolesDirectory.DoctorsRole;
import Business.RolesDirectory.Roles;
import java.util.ArrayList;

/**
 *
 * @author roshan
 */

public class DoctorOrg extends Org {
    
    public DoctorOrg()
    {
        super(Org.Type.Doctor.getValue());
    }
    
      @Override
        public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new DoctorsRole());
        return roles;
    }
    
}