/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.RequestFramework;

/**
 *
 * @author aayush
 */
public class SensorRequestFramework extends RequestFramework {
    
    private String reqSensorId;
    private static int count = 001;
    private String comments;
    private String sponsorshipRequestOutcome;
    
    
    public SensorRequestFramework()
    {
        
        StringBuffer sb = new StringBuffer();
        sb.append("SENSOR");
        sb.append(count);
        reqSensorId = sb.toString();
        count++;
    }

    public String getReqSensorId() {
        return reqSensorId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSponsorshipRequestOutcome() {
        return sponsorshipRequestOutcome;
    }

    public void setSponsorshipRequestOutcome(String requestOutcome) {
        this.sponsorshipRequestOutcome = requestOutcome;
    }

    @Override
    public String toString() {
        return this.reqSensorId;
    }
    
    
}
