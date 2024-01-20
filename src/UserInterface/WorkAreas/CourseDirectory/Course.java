/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseDirectory;

/**
 *
 * @author aayus
 */
public class Course {
    String number;
    String name;
    
    int rating=0;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
//    int courseRatings;

    int courseRatings;
//
//    public int getCourseRatings() {
//        return courseRatings;
//    }
//
//    public void setCourseRatings(int courseRatings) {
//        this.courseRatings = courseRatings;
//    }
	public String getName() {
        return name;
    }
    int credits;
    int price = 1500; //per credit hour
    public Course(String n, String numb, int ch){
        name = n;
        number = numb;
        credits = ch;
        
        
    }
    public String getCOurseNumber(){
        return number;
    }
    
    public int getCoursePrice(){
        return price*credits;
        
    }
}
