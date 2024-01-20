/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.RequestFramework;

import Business.userAccount.Users;

import java.util.Date;

/**
 *
 * @author aayush
 */
public abstract class RequestFramework {
    
    private String reqMessage;
    private Users senderDetails;
    private Users receiverDetails;
    private String statusOfRequest;
    private Date requestDate;
    private Date resolveDate;
    
    public RequestFramework(){
        requestDate = new Date();
    }

    public String getReqMessage() {
        return reqMessage;
    }

    public void setReqMessage(String reqMessage) {
        this.reqMessage = reqMessage;
    }

    public Users getSenderDetails() {
        return senderDetails;
    }

    public void setSenderDetails(Users senderDetails) {
        this.senderDetails = senderDetails;
    }

    public Users getReceiverDetails() {
        return receiverDetails;
    }

    public void setReceiver(Users receiverDetails) {
        this.receiverDetails = receiverDetails;
    }

    public String getStatusOfRequest() {
        return statusOfRequest;
    }

    public void setStatus(String statusOfRequest) {
        this.statusOfRequest = statusOfRequest;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return this.reqMessage;
    }
    
}
