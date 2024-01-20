package Business.Functions;

/**
 *
 * @author prasanna
 */

import java.util.ArrayList;
public class GetHelp {
    private String help;
    private String timetaken;
    private String serviceType;
    private String helpId;
    
    private String newHelp;
    
    private ArrayList<String> otherHelpList;
    
    private static int counter = 01;
    
    public GetHelp()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("HELP");
        sb.append(counter);
        helpId = sb.toString();
        counter++;   
    }
    
     public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return this.helpId;
    }
    

    public ArrayList<String> getOtherHelpList() {
        return otherHelpList;
    }

    public String getNewHelp() {
        return newHelp;
    }

    public void setNewHelp(String newHelp) {
        this.newHelp = newHelp;
    }

    public String getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(String timetaken) {
        this.timetaken = timetaken;
    }
    
}
