/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.RolesDirectory.Roles;
import Business.RolesDirectory.HelpersRole;
import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class HelperOrg extends Org {
    
    public HelperOrg()
    {
        super(Org.Type.Helper.getValue());
    }
    
      @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new HelpersRole());
        return roles;
    }
}
