/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author prasanna
 */
public class Helpers extends Person{
 
    private String helperId;
    private static int order = 001;
    private String latitiude;
    private String longitude;
    private ArrayList<Reviews> reviewsList;
    
    
    public Helpers()
    {
        StringBuffer hp = new StringBuffer();
        hp.append("VOL");
        hp.append(order);
        helperId = hp.toString();
        order++;
        reviewsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.getName();
    }

  
    public String getHelperId() {
        return helperId;
    }

    public String getLatitiude() {
        return latitiude;
    }

    public void setLatitiude(String latitiude) {
        this.latitiude = latitiude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Reviews> getReviewList() {
        return reviewsList;
    }

   
    public Reviews addReview()
    {
        Reviews reviews = new Reviews();
        reviewsList.add(reviews);
        return reviews;
    }
    
}
