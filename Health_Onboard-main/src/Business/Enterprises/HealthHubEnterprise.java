/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprises;

import Business.RolesDirectory.Roles;
import java.util.ArrayList;

/**
 *
 * @author aayush
 */
public class HealthHubEnterprise extends Enterprise {
    
    @Override
    public ArrayList<Roles> getSupportedRole() {
    return null;
    }
    
    public HealthHubEnterprise(String name)
    {
     super(name, Enterprise.EnterprisesType. HealthHub);
    }
    
}
