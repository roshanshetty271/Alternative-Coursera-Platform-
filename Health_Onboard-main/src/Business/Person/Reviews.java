/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

/**
 *
 * @author aayush
 */
public class Reviews {
    
    private static int order=0;
    private int reviewID;
    private String reviewTxt;
    private String writerName;
    private String date;
    
    public Reviews()
    {
        order++;
       reviewID = order;
    }

    public int getReviewID() {
        return reviewID;
    }


    public String getReviewTxt() {
        return reviewTxt;
    }

    public void setReviewTxt(String reviewTxt) {
        this.reviewTxt = reviewTxt;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.valueOf(this.reviewID);
    }
    
}
