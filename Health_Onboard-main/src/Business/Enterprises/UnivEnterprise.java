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
public class UnivEnterprise extends Enterprise {
    
     public UnivEnterprise(String name) {
        super(name, EnterprisesType.University);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        return null;
    }
    
}
