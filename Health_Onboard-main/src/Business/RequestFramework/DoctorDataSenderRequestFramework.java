/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.RequestFramework;

import Business.sensors.VitalSigns;
import java.util.ArrayList;

/**
 *
 * @author roshan
 */
public class DoctorDataSenderRequestFramework extends RequestFramework {
    
    private String sendDataReqId;
    private static int count = 000;
    private ArrayList<VitalSigns> vitalSigns;
    private String medication;
    private String newMedication;
    private String reqOutcome;
   
    
     public DoctorDataSenderRequestFramework()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("00");
        sb.append(count);
        sendDataReqId = sb.toString();
        count++;
        vitalSigns = new ArrayList<>();
    }
    

    @Override
    public String toString() {
        
        return this.sendDataReqId;       
    }

    public ArrayList<VitalSigns> getVitalSignList() {
        return vitalSigns;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setNewMedication(String newMedication) {
        this.newMedication = newMedication;
    }

    public String getNewMedication() {
        return newMedication;
    }

    public void setReqOutcome(String reqOutcome) {
        this.reqOutcome = reqOutcome;
    }

    public String getReqResult() {
        return reqOutcome;
    }

    
}
