/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organizations;

import Business.Person.PersonCatalog;
import Business.RolesDirectory.Roles;
import Business.userAccount.UsersCatalog;
import Business.RequestFramework.RequestPipeline;
import java.util.ArrayList;

/**
 *
 * @author dhanush
 */
public abstract class Org {
    
    private String name;
    private UsersCatalog usersCatalog;
    private PersonCatalog personCatalog;
    private RequestPipeline requestPipeline;
    private int orgId;
    private static int counter = 000;

    public Org(String name) {
    this.name = name;
    usersCatalog = new UsersCatalog();
    personCatalog = new PersonCatalog();
    requestPipeline = new RequestPipeline();
    counter++;
    orgId = counter;
    }
    
    public enum Type
    {
     Admin("Admin"),
     Helper("Helpers Organization"),
     Patient("Patient Organization"),
     Manager("Manager Organization"),
     Chief("Chief Organization"),
     Doctor("Doctor Organization");
     
     private String value;
     
     private Type(String value)
     {
         this.value = value;
     }

        public String getValue() {
            return value;
        }
    }

    public PersonCatalog getPersonDirectory() {
        return personCatalog;
    }

    public UsersCatalog getUserDirectory() {
        return usersCatalog;
    }

    public RequestPipeline getRequestPipeline() {
        return requestPipeline;
    }

    public String getName() {
        return name;
    }
    
     public abstract ArrayList<Roles> getSupportedRole();

    public int getOrgId() {
        return orgId;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
