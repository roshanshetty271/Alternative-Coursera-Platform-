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

import ui.Doctor.DoctorWorkArea;
/**
 *
 * @author roshan
 */
public class DoctorsRole extends Roles{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Users users,
                                 Org organization, Enterprise enterprise, NetworkHelp business) {
        return new DoctorWorkArea(userProcessContainer, users);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName();
    } 
    
}
