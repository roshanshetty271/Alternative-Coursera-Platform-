/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.StudentRole;

import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class PersonCatalog {
    
      ArrayList<PersonRoleModel> personlist ;
    
      public PersonCatalog (){
          
       personlist = new ArrayList();

    }

    public PersonRoleModel newPerson(String id) {

        PersonRoleModel p = new PersonRoleModel(id);
        personlist.add(p);
        return p;
    }

    public PersonRoleModel findPerson(String id) {

        for (PersonRoleModel p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
