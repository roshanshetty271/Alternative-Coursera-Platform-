/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.RolesDirectory.AdminRole;
import Business.RolesDirectory.Roles;
import java.util.ArrayList;

/**
 *
 * @author aayush
 */
public class AdminOrg extends Org {
    
    public AdminOrg() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
    
}
