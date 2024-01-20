/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author marve
 */
public class TeachingHistoryDirectory {

    private ArrayList<TeachingHistory> teachingHistory;
    private Map<String, ArrayList<TeachingHistory>> teachingHistoryMap;

    public TeachingHistoryDirectory() {
        teachingHistory = new ArrayList<>();

        teachingHistoryMap = new HashMap<>();

        /*   // Create teaching history for prof1
        ArrayList<TeachingHistory> prof1TeachingHistory = new ArrayList<>();

        TeachingHistory history1 = new TeachingHistory();
        history1.setFacultyName("Professor 1");
        history1.setCourseID("Course1");
        history1.setCourse("Subject1");
        history1.setSemester("Semester1");
        history1.setStudentCount("20");
        prof1TeachingHistory.add(history1);

        // Add more teaching history details for prof1
        TeachingHistory history2 = new TeachingHistory();
        history2.setFacultyName("Professor 1");
        history2.setCourseID("Course2");
        history2.setCourse("Subject2");
        history2.setSemester("Semester2");
        history2.setStudentCount("18");
        prof1TeachingHistory.add(history2);

        // Add more teaching history details for prof1
        TeachingHistory history3 = new TeachingHistory();
        history3.setFacultyName("Professor 1");
        history3.setCourseID("Course3");
        history3.setCourse("Subject3");
        history3.setSemester("Semester3");
        history3.setStudentCount("22");
        prof1TeachingHistory.add(history3);

        teachingHistoryMap.put("prof1", prof1TeachingHistory);
        
        TeachingHistory history4 = new TeachingHistory();
        history1.setFacultyName("Professor 2");
        history1.setCourseID("Course1");
        history1.setCourse("Subject1");
        history1.setSemester("Semester1");
        history1.setStudentCount("10");
        prof1TeachingHistory.add(history4);

        // Add more teaching history details for prof1
        TeachingHistory history5 = new TeachingHistory();
        history2.setFacultyName("Professor 2");
        history2.setCourseID("Course2");
        history2.setCourse("Subject2");
        history2.setSemester("Semester2");
        history2.setStudentCount("8");
        prof1TeachingHistory.add(history5);

        // Add more teaching history details for prof1
        TeachingHistory history6 = new TeachingHistory();
        history3.setFacultyName("Professor2");
        history3.setCourseID("Course3");
        history3.setCourse("Subject3");
        history3.setSemester("Semester3");
        history3.setStudentCount("17");
        prof1TeachingHistory.add(history6);

        teachingHistoryMap.put("prof2", prof1TeachingHistory); */
        String[] professorNames = {
            "Kal Bugrara",
            "Arulraj",
            "Jessica Fischer",
            "Nicholas Brown",
            "Debbie Stynes",
            "Vishal Chawla",
            "Michael Davis",
            "Linda White",
            "James Smith",
            "William Clark",
            "Olivia Johnson",
            "Sophia Martinez",
            "Smith Johnson"
        };

        String[] courseIDs = {
            "INFO5100",
            "INFO6150",
            "INFO5000",
            "INFO7120",
            "INFO1628",
            "INFO8271"
        };

        String[] courseNames = {
            "AED",
            "Web Designing",
            "Programming Fundamentals",
            "Advanced Web Development",
            "Application Engineering Design",
            "Software Programming"
        };

        String[] batch = {
            "Fall 2020",
            "Fall 2021",
            "Fall 2022",
            "Spring 2020",
            "Spring 2021",
            "Spring 2022",
            "Spring 2023"
        };
        Random random = new Random();

        for (int i = 0;
                i < professorNames.length;
                i++) {
            String professorKey = "prof" + (i + 1);
            ArrayList<TeachingHistory> professorTeachingHistory = new ArrayList<>();

            int numOfCourses = random.nextInt(5) + 1; // Randomly choose between 1 and 5 courses

            for (int j = 0; j < numOfCourses; j++) {
                int randomCourseIndex = random.nextInt(courseIDs.length);
                int randomBatchIndex = random.nextInt(batch.length);

                TeachingHistory history = new TeachingHistory();
                history.setFacultyName(professorNames[i]);
                history.setCourseID(courseIDs[randomCourseIndex]);
                history.setCourse(courseNames[randomCourseIndex]);

                history.setSemester(batch[randomBatchIndex]);

                // Ensure the student count is between 5 and 15
                int studentCount = random.nextInt(11) + 5; // Randomly choose between 5 and 15
                history.setStudentCount(String.valueOf(studentCount));

                professorTeachingHistory.add(history);
            }

            teachingHistoryMap.put(professorKey, professorTeachingHistory);
        }
        /*  TeachingHistory history1 = new TeachingHistory();
        history1.setFacultyName("Kal Bugrara");
        history1.setCourseID("INFO5100");
        history1.setCourse("Information Systems");
        history1.setSemester("Sem 2");
        history1.setStudentCount("17");
        
        teachingHistory.add(history1);
        
        TeachingHistory history2 = new TeachingHistory();
history2.setFacultyName("John Doe");
history2.setCourseID("CS2000");
history2.setCourse("Computer Science II");
history2.setSemester("Sem 1");
history2.setStudentCount("15");
teachingHistory.add(history2);

TeachingHistory history3 = new TeachingHistory();
history3.setFacultyName("Alice Smith");
history3.setCourseID("ENG1001");
history3.setCourse("English Composition");
history3.setSemester("Sem 2");
history3.setStudentCount("4");
teachingHistory.add(history3);

TeachingHistory history4 = new TeachingHistory();
history4.setFacultyName("Robert Johnson");
history4.setCourseID("MATH201");
history4.setCourse("Calculus I");
history4.setSemester("Sem 1");
history4.setStudentCount("6");
teachingHistory.add(history4);

TeachingHistory history5 = new TeachingHistory();
history5.setFacultyName("Emily Wilson");
history5.setCourseID("HIST300");
history5.setCourse("World History");
history5.setSemester("Sem 2");
history5.setStudentCount("8");
teachingHistory.add(history5);

TeachingHistory history6 = new TeachingHistory();
history6.setFacultyName("David Lee");
history6.setCourseID("PHYS101");
history6.setCourse("Physics Fundamentals");
history6.setSemester("Sem 1");
history6.setStudentCount("7");
teachingHistory.add(history6);

TeachingHistory history7 = new TeachingHistory();
history7.setFacultyName("Sarah Brown");
history7.setCourseID("CHEM200");
history7.setCourse("Chemistry Principles");
history7.setSemester("Sem 2");
history7.setStudentCount("8");
teachingHistory.add(history7);

TeachingHistory history8 = new TeachingHistory();
history8.setFacultyName("Michael Davis");
history8.setCourseID("ART150");
history8.setCourse("Introduction to Art");
history8.setSemester("Sem 1");
history8.setStudentCount("12");
teachingHistory.add(history8);

TeachingHistory history9 = new TeachingHistory();
history9.setFacultyName("Linda White");
history9.setCourseID("MUSIC300");
history9.setCourse("Music Theory");
history9.setSemester("Sem 2");
history9.setStudentCount("10");
teachingHistory.add(history9);

TeachingHistory history10 = new TeachingHistory();
history10.setFacultyName("James Smith");
history10.setCourseID("PSYCH200");
history10.setCourse("Psychology 101");
history10.setSemester("Sem 1");
history10.setStudentCount("5");
teachingHistory.add(history10);
         */
    }

    public ArrayList<TeachingHistory> getTeachingHistory() {
        return teachingHistory;
    }

    public void setTeachingHistory(ArrayList<TeachingHistory> teachingHistory) {
        this.teachingHistory = teachingHistory;
    }

    public ArrayList<TeachingHistory> getTeachingHistoryForProfessor(String professorId) {
        return teachingHistoryMap.get(professorId);
    }

}
