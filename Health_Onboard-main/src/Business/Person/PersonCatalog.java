/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author roshan
 */
public class PersonCatalog {
    
    private ArrayList<Helpers> helpersList;
    private ArrayList<Patient> customerList;
    private ArrayList<Person> personList;
    
    public PersonCatalog()
    {
          helpersList = new ArrayList<>();
          customerList = new ArrayList<>();
          personList = new ArrayList<>();
    }
      
      public Helpers addHelper()
    {
        Helpers helpers = new Helpers();
        helpersList.add(helpers);
        return helpers;
    }
    
    public void removeHelper(Helpers helpers)
    {
      helpersList.remove(helpers);
    }
    
    public Patient addCustomer()
    {
        Patient customer = new Patient();
        customerList.add(customer);
        return customer;
    }
    
    public void removeCustomer(Patient customer)
    {
        customerList.remove(customer);
    }
    

    public ArrayList<Patient> getCustomerLsit() {
        return customerList;
    }

    public ArrayList<Helpers> getHelperList() {
        return helpersList;
    }


      public Person addPerson()
    {
        Person person = new Person();
       personList.add(person);
        return person;
    }
    
    public void removePerson(Person person)
    {
        personList.remove(person);
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
}
