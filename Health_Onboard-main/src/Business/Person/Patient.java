/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Person;

import Business.sensors.HeartRateSensorMeasurements;
import Business.sensors.SensorsDevice;
import Business.sensors.VitalSigns;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author aayush
 */
public class Patient extends Person {
    
    private String caseId;
    private static int count = 001;
    private boolean shareVital = false;
    private boolean hasSensor = false;
    private boolean hasCardiacProb = false;
    private boolean getAlerts = false;
    private ArrayList<VitalSigns> vitalSignsList;
    private ArrayList<String> vitalSignTrackList;
    private boolean sendDataToDoctor = false;
    private SensorsDevice sensorsDevice;
    
    
    public Patient()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("CUST");
        sb.append(count);
        caseId = sb.toString();
        count++;
        vitalSignsList = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return this.getName();
    }

    public SensorsDevice getSensorDevice() {
        return sensorsDevice;
    }

  
    public String getHelpSeekerId() {
        return caseId;
    }
    private VitalSigns vitalSigns = null;
    
    private volatile boolean stop = false;
    private int counter = 0;
  
 
    public void addVitalSign(){
        counter =0;
        System.out.println("counter"+counter);
       HeartRateSensorMeasurements hRSensorMeasurements  = new HeartRateSensorMeasurements();
        hRSensorMeasurements.start();
        System.out.println("counter"+counter);
       Timer timer =  new Timer(true);
       TimerTask addtask = new TimerTask () {
      
            @Override
            public void run () {
             while(counter<5)
             {
           ArrayList<VitalSigns> list = hRSensorMeasurements.generateVitalSign(vitalSignTrackList, vitalSignsList);
               counter ++;   
               
               System.out.println(">list>> "+list.toString());
                vitalSignsList = list;
             }
             if (counter >= 5) {
                stop=true;
                timer.cancel();
                timer.purge();
                this.cancel();
                
                return;
                
                }
          hRSensorMeasurements.requestStop();
            }
        };
      timer.schedule(addtask, 5000);  
      if(counter >= 5)
      {
          addtask.cancel();
      }
      
       
  }
  
  
    public void removeVitalSign(VitalSigns vitalSigns)
    {
        vitalSignsList.remove(vitalSigns);
    }
    
    public ArrayList<VitalSigns> getPatientVitalSignHistory() {
        return vitalSignsList;
    }

   
     public String patientCondition(int age, VitalSigns patientVitalSigns)
    {
    
       float respiratoryRateValue;
       int heartRateValue ;
       int systolicBloodpressureValue ;
       float weightInPoundsValue; 
       String patientCondition = null;
      
           respiratoryRateValue = patientVitalSigns.getRespiratoryRate();
           heartRateValue = patientVitalSigns.getHeartRate();
           systolicBloodpressureValue = patientVitalSigns.getSystolicBloodpressure();
           weightInPoundsValue = patientVitalSigns.getWeightInPounds();
           
       if( age >=1 && age <=3 )
       {
           if(respiratoryRateValue >= 20 && respiratoryRateValue <=30 && 
                   heartRateValue >= 80 && heartRateValue <= 130 &&
                   systolicBloodpressureValue >= 80 && systolicBloodpressureValue <= 110 &&
                   weightInPoundsValue >= 22 && weightInPoundsValue <= 31)
           {
              patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
       }
       else if( age >= 4 && age <= 5 )
       {
           if(respiratoryRateValue >= 20 && respiratoryRateValue <= 30 && 
                   heartRateValue >= 80 && heartRateValue <= 120 &&
                   systolicBloodpressureValue >= 80 && systolicBloodpressureValue <= 110 &&
                   weightInPoundsValue >= 31 && weightInPoundsValue <= 40)
           {
             patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
           
       }
       else if( age >= 6 && age <= 12 )
       {
           if(respiratoryRateValue >= 20 && respiratoryRateValue <= 30 && 
                   heartRateValue >= 70 && heartRateValue <= 110 &&
                   systolicBloodpressureValue >= 80 && systolicBloodpressureValue <= 120 &&
                   weightInPoundsValue >= 41 && weightInPoundsValue <= 92)
           {
             patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
       }
       else if ( age >= 13)
       {
           if(respiratoryRateValue >= 12 && respiratoryRateValue <= 20 && 
                   heartRateValue >= 55 && heartRateValue <= 105 &&
                   systolicBloodpressureValue >= 110 && systolicBloodpressureValue <= 120 &&
                   weightInPoundsValue > 110)
           {
             patientCondition = "NORMAL";
           }
            else
            {
               patientCondition = "ABNORMAL";
            }
           
       }
      
        return patientCondition;   
    }

    public void setVitalSignTrackList(ArrayList<String> vitalSignTrackList) {
        this.vitalSignTrackList = new ArrayList<>();
        this.vitalSignTrackList = vitalSignTrackList;
    }

  public ArrayList<String> getVitalSignTrackList() {
        return vitalSignTrackList;
    }

    public ArrayList<VitalSigns> getVitalSignList() {
        return vitalSignsList;
    }

    public boolean isShareVital() {
        return shareVital;
    }

    public void setShareVital(boolean shareVital) {
        this.shareVital = shareVital;
    }

    public boolean isHasSensor() {
        return hasSensor;
    }

    public void setHasSensor(boolean hasSensor) {
        this.hasSensor = hasSensor;
    }

    public boolean isGetAlerts() {
        return getAlerts;
    }

    public void setGetAlerts(boolean getAlerts) {
        this.getAlerts = getAlerts;
    }

    public boolean isHasCardiacProb() {
        return hasCardiacProb;
    }

    public void setHasCardiacProb(boolean hasCardiacProb) {
        this.hasCardiacProb = hasCardiacProb;
    }

    public boolean isSendDataToDoctor() {
        return sendDataToDoctor;
    }

    public void setSendDataToDoctor(boolean sendDataToDoctor) {
        this.sendDataToDoctor = sendDataToDoctor;
    }
    
}
