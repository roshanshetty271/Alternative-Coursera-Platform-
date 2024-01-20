/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.RolesDirectory;

import Business.NetworkHelp;
import Business.Enterprises.Enterprise;
import Business.Organizations.Org;
import Business.userAccount.Users;
import javax.swing.JPanel;
import ui.SystemAdmin.SysAdminWorkArea;

/**
 *
 * @author prasanna
 */
public class SysAdmin extends Roles{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Users users, Org organization, Enterprise enterprise, NetworkHelp system) {
        return new SysAdminWorkArea(userProcessContainer, system);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    
}
