/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprises;

import java.util.ArrayList;

/**
 *
 * @author aayush
 *
 */
public class EnterpriseCatalog {
    
    private ArrayList<Enterprise> enterpriseList;
    
    public EnterpriseCatalog()
    {
        enterpriseList = new ArrayList<Enterprise>();
    }
    
    
    public Enterprise addEnterprises(String name, Enterprise.EnterprisesType type)
    {
      Enterprise enterprise = null;
      if(type == Enterprise.EnterprisesType. HealthHub)
      {
       enterprise = new HealthHubEnterprise(name);
       enterpriseList.add(enterprise);
      }
      else if (type == Enterprise.EnterprisesType.Ministry){
            enterprise = new MinistryEnterprise(name);
            enterpriseList.add(enterprise);
        }
//       else if (type == Enterprise.EnterprisesType.Charity){
//            enterprise = new NGOEnterprise(name);
//            enterpriseList.add(enterprise);
//        }
        else  if(type == Enterprise.EnterprisesType.University)
        {
         enterprise = new UnivEnterprise(name);
         enterpriseList.add(enterprise);
        }
      else  if(type == Enterprise.EnterprisesType.Hospital)
        {
         enterprise = new HospitalEnterprise(name);
         enterpriseList.add(enterprise);
        }

      return enterprise;
    }

    public ArrayList<Enterprise> getEnterprisesList() {
        return enterpriseList;
    }
    
    public void deleteEnterprise(Enterprise enterprise)
    {
        enterpriseList.remove(enterprise);
    }
}
