/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

//import Business.RolesDirectory.HealthHubControllerRole;
import Business.RolesDirectory.Roles;
import Business.RolesDirectory.ManagersRole;
import java.util.ArrayList;

/**
 *
 * @author dhanush
 */
public class ManagerOrg extends Org {
    
    public ManagerOrg()
    {
        super(Org.Type.Manager.getValue());
    }
    
     @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new ManagersRole());
//        roles.add(new HealthHubControllerRole());
        return roles;
    }
    
}
