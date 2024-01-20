/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.sensors;

import java.util.ArrayList;

/**
 *
 * @author dhanush
 */
public class SensorsDevice {
    
    private String sensorName;
    private String sensorId;
    private HeartRateSensorMeasurements hRSensorMeasurements;
    private ArrayList<HeartRateSensorMeasurements> measurementList;
    
    public SensorsDevice()
    {
        this.hRSensorMeasurements = new HeartRateSensorMeasurements();
        measurementList= new ArrayList<>();
    }
    
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public HeartRateSensorMeasurements gethRSensorMeasurements() {
        return hRSensorMeasurements;
    }

    
    @Override
    public String toString() {
        return this.sensorName;
    }
    
}
