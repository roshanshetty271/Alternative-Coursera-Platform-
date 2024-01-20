/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.userAccount;

import Business.Person.Person;
import Business.RolesDirectory.Roles;
import java.util.ArrayList;


/**
 *
 * @author prasanna
 */
public class UsersCatalog {
    
    private ArrayList<Users> usersList;
    
    public UsersCatalog()
    {
      usersList = new ArrayList<>();
    }

    public ArrayList<Users> getUserList() {
        return usersList;
    }
    
    public Users validateUser(String name, String pwd){
        for (Users u : usersList)
            if (u.getName().equals(name) && u.getPwd().equals(pwd)){
                return u;
            }
        return null;
    }
    
    public Users addUser(String name, String pwd, Person person, Roles role){
        Users users = new Users();
        users.setName(name);
        users.setPwd(pwd);
        users.setPerson(person);
        users.setRole(role);
        usersList.add(users);
        return users;
    }
    
    public boolean checkUniqueName(String name){
        boolean flag = true;
        for (Users u : usersList){
            if (u.getName().equals(name))
            {
              flag =  false;
            }
            else
            {
            flag =  true;
            }
        }
        return flag;
    }
    
    public void deleteUser(Users users)
    {
        usersList.remove(users);
    }
    
    
}
