
package Business.RolesDirectory;

import Business.NetworkHelp;
import Business.Enterprises.Enterprise;
import Business.Organizations.Org;
import Business.userAccount.Users;

import javax.swing.JPanel;
/**
 *
 * @author aayush
 */
public abstract class Roles {
     public enum RoleType{
        Administrator("Administrator"),
        Helper("Helpers"),
        Manager("Manager"),
        Patient("Patient"),
        Driver("Driver"),
        Chief("Chief"),
         HealthHubController(" HealthHub Controller"),
        Doctor("Doctor"),
        Sponsor("Sponsor");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            Users account, 
            Org organization,
            Enterprise enterprise,
            NetworkHelp ecoSystem);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
}
