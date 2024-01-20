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
import ui.Chief.ChiefWorkArea;

/**
 *
 * @author roshan
 */
public class ChiefRole extends Roles{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Users users,
                                 Org organization, Enterprise enterprise, NetworkHelp business) {
        return new ChiefWorkArea(userProcessContainer, users, organization, business);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    
}
