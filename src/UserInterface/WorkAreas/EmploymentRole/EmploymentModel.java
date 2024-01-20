/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WorkAreas.EmploymentRole;

import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.Employer.EmployerFeedbackProfile;
import java.util.ArrayList;

/**
 *
 * @author marve
 */
public class EmploymentModel {
    ArrayList<CoursesOffer> relevantcourseoffers;
    int weight;
    String quality;
    String job;
    EmploymentModel nextemplyment;  //next job so they are in a sequence 
    
    EmployerFeedbackProfile employer;
    public EmploymentModel(String j){
        
        ArrayList relevantcourseoffers = new ArrayList();
        
    }

}
