package Business;

import Business.Functions.GetHelp;
import Business.Networks.Network;
import Business.Organizations.Org;
import Business.RolesDirectory.Roles;
import Business.RolesDirectory.SysAdmin;
import java.util.ArrayList;

/**
 *
 * @author aayush
 */
public class NetworkHelp extends Org {
    
 private ArrayList<Network> networkList;
   private static NetworkHelp environment;
   private ArrayList<GetHelp> getHelpList;
    
   public NetworkHelp()
   {
       super(null);
       networkList = new ArrayList<>();
       getHelpList = new ArrayList<>();
      
   }
   
   public static NetworkHelp getInstance()
   {
    if(environment == null)
    {
      environment = new NetworkHelp();
    }
    return environment;
   }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
   
    public Network addNetwork()
    {
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    public boolean checkUniqueName(String username)
    {
      if (!getUserDirectory().checkUniqueName(username)) {
        return false;
      }
      return true;
    }
   
    public void deleteNetwork(Network network)
    {
        networkList.remove(network);
    }
   
   
    public ArrayList<Roles> getSupportedRoles() {
        ArrayList<Roles> rolesList = new ArrayList<>();
        rolesList.add(new SysAdmin());
        return rolesList;
    }
   
    public GetHelp addHelp()
    {
        GetHelp getHelp = new GetHelp();
        getHelpList.add(getHelp);
        return getHelp;
    }
    
    public void deleteHelp(GetHelp getHelp)
    {
        getHelpList.remove(getHelp);
    }

    public ArrayList<GetHelp> getHelpList() {
        return getHelpList;
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
