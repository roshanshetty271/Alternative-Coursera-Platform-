/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprises;

import Business.Organizations.Org;
import Business.Organizations.OrgCatalog;

/**
 *
 * @author prasanna
 */
public abstract class Enterprise extends Org {
    
    
    private String enterpriseId;
    private static int order = 1;
    private OrgCatalog orgCatalog;
    private EnterprisesType enterprisesType;
    
    public Enterprise(String enterprisesName, EnterprisesType enterprisesType)
    {
        super(enterprisesName);
        this.enterprisesType = enterprisesType;
        orgCatalog = new OrgCatalog();
        StringBuffer en = new StringBuffer();
        en.append("ENT");
        en.append(order);
        enterpriseId = en.toString();
        order++;
    }
    
    public enum EnterprisesType{
        
       University("University"),
        HealthHub(" HealthHub"),
       Ministry("Ministry"),
       Hospital("Hospital");
    
       
       private String value;
       
       private EnterprisesType(String value)
       {
         this.value = value;  
       }

        public String getValue() {
            return value;
        }
    }

    public OrgCatalog getOrganizationsDirectory() {
        return orgCatalog;
    }

    public EnterprisesType getEnterprisesType() {
        return enterprisesType;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
    
}
