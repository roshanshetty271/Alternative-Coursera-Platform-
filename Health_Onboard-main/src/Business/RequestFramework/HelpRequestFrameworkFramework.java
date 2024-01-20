/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.RequestFramework;

import Business.Functions.GetHelp;

/**
 *
 * @author dhanush
 */
public class HelpRequestFrameworkFramework extends RequestFramework {
    
    private String reqId;
    private static int count = 000;
    private String comments;
    private GetHelp getHelp;
    private String requestOutcome;
   

    public HelpRequestFrameworkFramework()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("REQ");
        sb.append(count);
        reqId = sb.toString();
        count++;
    }
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReqId() {
        return reqId;
    }

    public void setNeedHelp(GetHelp getHelp) {
        this.getHelp = getHelp;
    }

    public GetHelp getHelp() {
        return getHelp;
    }

    public void setRequestOutcome(String requestOutcome) {
        this.requestOutcome = requestOutcome;
    }

    public String getRequestOutcome() {
        return requestOutcome;
    }


    
    @Override
    public String toString() {
        return getHelp().getHelp();
    }
    
    
}
