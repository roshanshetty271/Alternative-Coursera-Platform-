/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.RolesDirectory.ChiefRole;
import Business.RolesDirectory.Roles;
import java.util.ArrayList;
/**
 *
 * @author aayush
 */
public class ChiefOrg extends Org {
    
    public ChiefOrg()
    {
        super(Org.Type.Chief.getValue());
    }
    
     @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new ChiefRole());
        return roles;
    }
    
}
