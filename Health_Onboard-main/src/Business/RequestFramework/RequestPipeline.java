/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.RequestFramework;

import java.util.ArrayList;

/**
 *
 * @author aayush
 * 
 */
public class RequestPipeline {
    
    
    
    private ArrayList<RequestFramework> requestFrameworkList;

    public RequestPipeline() {
        requestFrameworkList = new ArrayList<>();
    }

    public ArrayList<RequestFramework> getRequestList() {
        return requestFrameworkList;
    }

}
