/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprises;

import Business.RolesDirectory.Roles;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class HospitalEnterprise extends Enterprise {
 
      
     public HospitalEnterprise(String name) {
        super(name, EnterprisesType.Hospital);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        return null;
    }
    
}
