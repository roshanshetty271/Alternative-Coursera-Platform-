/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.CourseSchedule;

import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseDirectory.CourseDirectory;
import java.util.ArrayList;

/**
 *
 * @author marve
 */
public class CoursesSchedule {

    CourseDirectory coursecatalog;

    ArrayList<CoursesOffer> schedule;

    public String getSemester() {
        return semester;
    }
    String semester;

        public CoursesSchedule(){
        
    }
        
    public ArrayList<CoursesOffer> getSchedule() {
        return schedule;
    }

    public CoursesSchedule(String s, CourseDirectory cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();

    }

    public CoursesOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        CoursesOffer co = new CoursesOffer(c);
        schedule.add(co);
        return co;
    }

    public CoursesOffer getCourseOfferByNumber(String n) {

        for (CoursesOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CoursesOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

//      public int calculateTotalLoss() {
//        int sum = 0;
//        for (CoursesOffer co : schedule) {
//

//            sum = sum + co.getTotalCourseLoss();


//            //sum = sum + co.getTotalCourseLoss();

//
//        }
//        return sum;
//    }
}

//            sum = sum + co.getTotalCourseLoss();
//
//        }
//        return sum;
   // }


