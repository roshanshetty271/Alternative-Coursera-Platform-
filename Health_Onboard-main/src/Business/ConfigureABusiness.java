package Business;

import Business.Functions.GetHelp;
import Business.Enterprises.Enterprise;
import Business.Networks.Network;
import Business.Organizations.Org;
import Business.Person.Person;
import Business.RolesDirectory.AdminRole;
//import Business.RolesDirectory.HealthHubControllerRole;
import Business.RolesDirectory.ChiefRole;
import Business.RolesDirectory.DoctorsRole;
import Business.RolesDirectory.HelpersRole;
import Business.RolesDirectory.ManagersRole;
import Business.RolesDirectory.SysAdmin;
import Business.userAccount.Users;

/**
 *
 * @author prasanna
 */
public class ConfigureABusiness {

    public static NetworkHelp configuration() {
        NetworkHelp system = NetworkHelp.getInstance();
        Person person = system.getPersonDirectory().addPerson();
        person.setFirstName("Sys");
        person.setLastName("Admin");
        person.setName();

        Users  user = system.getUserDirectory().addUser("sysadmin", "sysadmin", person, new SysAdmin());
         user.setEnabled(true);

        GetHelp getHelp = system.addHelp();
        getHelp.setHelp("Snow Shovel");
        getHelp.setHelp("Grass Cutting");
        getHelp.setHelp("Gardening");
        getHelp.setHelp("Grocery Shopping");

        Network network = system.addNetwork();

        network.setCountry("United States");
        network.setState("Massachusetts");
        network.setCity("Boston");

        // University    
        Enterprise enterprise = network.getEnterprisesDirectory().addEnterprises("NortheasternUniversity", Enterprise.EnterprisesType.University);
        person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("Univeristy Admin");
        person.setName();
        Users account = enterprise.getUserDirectory().addUser("uniAdmin", "uniAdmin", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Helper);
        Org org = enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Helper);
        person = org.getPersonDirectory().addPerson();

        person.setFirstName("Volunteer");
        person.setLastName("Helper");
        person.setName();

        account = org.getUserDirectory().addUser("helper", "helper", person, new HelpersRole());
        account.setNetwork(network);
        account.setEnabled(true);

        // HealthHub
        enterprise = network.getEnterprisesDirectory().addEnterprises("Boston HealthHub", Enterprise.EnterprisesType. HealthHub);
        person = enterprise.getPersonDirectory().addPerson();
        person.setLastName(" HealthHub Admin");
        person.setName();
        account = enterprise.getUserDirectory().addUser("bhh", "bhh", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Patient);
        org = enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Manager);
        person = org.getPersonDirectory().addPerson();

        person.setFirstName("Supervisor");
        person.setLastName("Boston");
        person.setName();

        account = org.getUserDirectory().addUser("bsup", "bsup", person, new ManagersRole());
        account.setNetwork(network);
        account.setEnabled(true);

        // Manager
        person = org.getPersonDirectory().addPerson();

        person.setFirstName("Manager");
        person.setLastName("Boston");
        person.setName();

        account = org.getUserDirectory().addUser("bman", "bman", person, new ManagersRole());
        account.setNetwork(network);
        account.setEnabled(true);

        // Charity
//        enterprise = Network.getEnterprisesDirectory().addEnterprises("Charity", Enterprise.EnterprisesType.Charity);
//        person = enterprise.getPersonDirectory().addPerson();
//        person.setLastName("charity Admin");
//        person.setName();
//        account = enterprise.getUserDirectory().addUser("bno", "bno", person, new AdminRole());
//        account.setEnabled(true);
//        account.setNetwork(Network);
//        org = enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Sponsor);
//        person = org.getPersonDirectory().addPerson();
//
//        person.setFirstName("Donor");
//        person.setLastName("Boston");
//        person.setName();
//
//        account = org.getUserDirectory().addUser("bdon", "bdon", person, new SponsorsRole());
//        account.setNetwork(Network);
//        account.setEnabled(true);
//
        // Hospital
        enterprise = network.getEnterprisesDirectory().addEnterprises("Hospital", Enterprise.EnterprisesType.Hospital);
        person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("hospital Admin");
        person.setName();
        account = enterprise.getUserDirectory().addUser("bho", "bho", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        org = enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Doctor);
        person = org.getPersonDirectory().addPerson();

        person.setFirstName("Doctor");
        person.setLastName("Boston");
        person.setName();

        account = org.getUserDirectory().addUser("bdoc", "bdoc", person, new DoctorsRole());
        account.setNetwork(network);
        account.setEnabled(true);

        // Ministry
        enterprise = network.getEnterprisesDirectory().addEnterprises("Govt", Enterprise.EnterprisesType.Ministry);
        person = enterprise.getPersonDirectory().addPerson();
        person.setLastName("Ministry Admin Admin");
        person.setName();
        account = enterprise.getUserDirectory().addUser("bgt", "bgt", person, new AdminRole());
        account.setEnabled(true);
        account.setNetwork(network);
        org = enterprise.getOrganizationsDirectory().addOrganizations(Org.Type.Chief);
        person = org.getPersonDirectory().addPerson();

        person.setFirstName("mayor");
        person.setLastName("Boston");
        person.setName();

        account = org.getUserDirectory().addUser("bmay", "bmay", person, new ChiefRole());
        account.setNetwork(network);
        account.setEnabled(true);

        return system;
    }
}
