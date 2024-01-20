/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.userAccount;

import Business.Networks.Network;
import Business.Person.Person;
import Business.RolesDirectory.Roles;
import Business.RequestFramework.RequestPipeline;

/**
 *
 * @author aayush
 */
public class Users {
    
    private String name;
    private String pwd;
    private Person person; 
    private Roles role;
    private RequestPipeline requestPipeline;
    private boolean enabled = true;
    private Network network;
   
    public Users() {
        requestPipeline = new RequestPipeline();
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public RequestPipeline getRequestPipeline() {
        return requestPipeline;
    }

    public void setRequestPipeline(RequestPipeline requestPipeline) {
        this.requestPipeline = requestPipeline;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Network getNetwork() {
        return network;
    }

}
