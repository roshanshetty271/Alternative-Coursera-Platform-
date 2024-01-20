/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.Organizations.Org.Type;
import java.util.ArrayList;

/**
 *
 * @author dhanush
 */
public class OrgCatalog {
    
    private ArrayList<Org> orgList;
    
    public OrgCatalog()
    {
      orgList = new ArrayList<>();
    }
    
    public Org addOrganizations(Type type)
    {
       Org org = null;
        if (type.getValue().equals(Type.Helper.getValue())){
            org = new HelperOrg();
            orgList.add(org);
        }
        else if (type.getValue().equals(Type.Patient.getValue())){
            org = new PatientOrg();
            orgList.add(org);
        }
        else if (type.getValue().equals(Type.Manager.getValue())){
            org = new ManagerOrg();
            orgList.add(org);
        }
//         else if (type.getValue().equals(Type.Sponsor.getValue())){
//            org = new SponsorOrg();
//            orgList.add(org);
//        }
//         else if (type.getValue().equals(Type.Transportation.getValue())){
//            org = new TransportationOrg();
//            orgList.add(org);
//        }
          else if (type.getValue().equals(Type.Chief.getValue())){
            org = new ChiefOrg();
            orgList.add(org);
        }
           else if (type.getValue().equals(Type.Doctor.getValue())){
            org = new DoctorOrg();
            orgList.add(org);
        }
        return org;
    }

    public ArrayList<Org> getOrganizationsList() {
        return orgList;
    }
    
    public void deleteOrganizations(Org org)
    {
      orgList.remove(org);
    }
    
}
