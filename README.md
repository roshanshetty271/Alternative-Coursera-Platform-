[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/eEf93O-z)


# Alternative Coursera Platform

The Alternative Coursera Platform is a revolutionary decentralized educational system that aims to empower both educators and learners by shifting the focus from traditional institutions to individual professors. This README provides comprehensive information about the project, its features, installation, usage, and how to contribute.

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [System Requirements](#system-requirements)
4. [Installation](#installation)
5. [Usage](#usage)
6. [Contributing](#contributing)

## 1. Overview

The Alternative Coursera Platform is designed to address the limitations of traditional educational systems by creating a decentralized, professor-centric learning environment. Professors have full autonomy to create and manage courses while students have the freedom to select from a global network of educational offerings. Key features of the platform include:

- **Professor-Centric Learning:** Professors can independently create and manage courses, allowing them to share their expertise directly with students.

- **Global Course Selection:** Students can choose courses from a diverse range of educators worldwide, providing them with a broader perspective and access to specialized knowledge.

- **Reputation System:** The platform includes a reputation index, helping students make informed decisions by considering professor ratings and course reviews.

- **Degree Evaluation:** Streamlining graduation requirements, the platform offers a certification authority to ensure students meet the necessary criteria for degree completion.

## 2. Features

### 2.1. Professor Management

- Professors can sign up and manage their course catalog.
- Full autonomy to schedule courses and specify course details.
- Easy-to-use interface for adding, modifying, or deleting courses.

### 2.2. Student Registration and Learning

- Students can sign up and create their transcripts.
- Browsing feature to discover courses based on professors, topics, regions, languages, and more.
- Course registration and progress tracking.

### 2.3. Reputation System

- A reputation index helps students assess the quality and credibility of professors and their courses.
- Course reviews and ratings from students provide valuable insights.

### 2.4. Graduation and Certification

- Simplified graduation requirements ensure students are on track to earn their degrees.
- A certification authority reviews transcripts to confirm eligibility for graduation.

## 3. System Requirements

To set up and run the Alternative Coursera Platform, you will need the following components:

- **Java** (version X.X)
- **Database System** (e.g., MySQL, PostgreSQL)
- **Web Server** (e.g., Apache Tomcat)
- [List any other dependencies or libraries]

## 4. Installation

To install and deploy the platform, follow these steps:

  Clone the repository to your local machine:

  Install any necessary dependencies. For example, use Maven:

bash
Copy code
mvn install
Configure the database by updating the application.properties file with your database connection details.

Deploy the application to your chosen web server (e.g., Tomcat).

Sign up as either a professor or student.

Professors can create, manage, and offer courses.

Students can browse available courses and register.

Keep track of your progress and check your eligibility for graduation.

Contributing
We welcome contributions to the Alternative Coursera Platform. If you'd like to contribute, please follow these steps:

Fork the repository.

Create a new branch for your feature or bug fix:

bash
Copy code
git checkout -b feature/your-feature-name
Implement your changes and commit them.

Push your changes to your fork:

bash
Copy code
git push origin 
Create a pull request to the main repository.

![DIAG3](https://github.com/aed5100/assignment-3-team-rap/assets/144941047/a5554ca5-0f39-4688-93dc-b4f582898843)

![UI1](https://github.com/aed5100/assignment-3-team-rap/assets/144941047/57fd7550-55a8-4749-a79c-9f4c3bb886b5)

![UI2](https://github.com/aed5100/assignment-3-team-rap/assets/144941047/210bdb30-e394-4358-a147-4f866e78623e)

![UI3](https://github.com/aed5100/assignment-3-team-rap/assets/144941047/0d12196c-a5da-4858-88d2-af668ea82517)

![DIAG1](https://github.com/aed5100/assignment-3-team-rap/assets/144941047/6f5836f4-d06e-497b-98c3-51188efd03b5)

![DIAG2](https://github.com/aed5100/assignment-3-team-rap/assets/144941047/ab29bdfb-2e95-41da-9390-3eaf3dc63a23)



















                                          Project Report: Design and Implementation of an Alternative Coursera Platform

1. Introduction
Project Overview
The "Design and Implementation of an Alternative Coursera Platform" project aims to create a decentralized, professor-centric educational platform that provides accessible and affordable education to a global audience. This project seeks to revolutionize the traditional educational model by putting professors at the forefront of the learning experience.
Objectives
The primary objectives of the project include:
	•	Develop a decentralized platform for professors to offer courses independently.
	•	Enable students to choose courses from a global network of professors.
	•	Implement a reputation system to guide students in selecting courses.
	•	Streamline graduation requirements and certification.

3. System Design
Architecture Diagram
The architecture of the alternative Coursera platform differs significantly from the traditional university model. In our decentralized model, professors operate independently, and students can freely choose their courses from a global pool of educators. A universal student directory and certification authority play key roles in ensuring students meet graduation requirements.

Class Diagram
The class diagram illustrates the modifications made to the traditional university model to support the decentralized, professor-centric platform. Additional methods and attributes are introduced to handle user registration, course management, and reputation systems.

4. Use Cases
Use Case 1: System Startup
Description: The system initializes with essential configurations, including a universal student directory and a certification authority to determine students' readiness to graduate.
Use Case 2: Professor Registration and Course Management
Description: Professors sign up to the service and manage their course catalog, including course creation and scheduling.

5. System Implementation
Technical Details
The project is implemented using [mention the technology stack], with the primary programming language being [mention language]. The platform's architecture is designed to support scalability and robust data management.

6. Functional Components
Student Directory
The universal student directory stores information about all registered students, enabling seamless course registration and degree evaluation.
Professor Course Management
Professors can independently manage their courses, specifying topics, schedules, and regions where their courses are available.
[Continue to describe other functional components]

7. Testing and Quality Assurance
Test Cases
A comprehensive set of test cases was developed to evaluate the platform's functionality and ensure that it meets the specified requirements.

8. Challenges and Solutions
Challenge: Scalability
Solution: We implemented a distributed architecture to accommodate a large number of professors and students worldwide.
Challenge: Data Security
Solution: Robust encryption and access control mechanisms were implemented to protect user data.

9. Conclusion
Summary
In conclusion, the "Alternative Coursera Platform" project successfully achieved its objectives, presenting a decentralized, professor-centric educational model that empowers both educators and learners.
Alignment with Objectives
This project aligns with the objective of increasing education accessibility and affordability while emphasizing the role of professors in the learning process.
10. Recommendations
Future Enhancements
We recommend exploring further enhancements, such as incorporating AI for personalized course recommendations and expanding support for multiple languages.
Accessibility and Affordability
To make education more accessible and affordable, the platform should continue to offer low-cost or free courses while expanding scholarship programs.
11. Prospects
Impact on Education
Digital educational platforms like the one developed in this project have the potential to reshape the education landscape by providing quality education to a global audience.
12. Appendices

Code snippet for calculating CGPA (Cumulative Grade Point Average):

	•	public double CalculateGPA(){          double aggregateGrade =0.0;          int counter=0;          for(CourseLoad cl: this.courseloadlist.values()){              for(SeatAssignment sa: cl.getSeatassignments()){                  aggregateGrade += sa.Grade;                  counter++;             }         }          return aggregateGrade/counter;     }

Code snippet for password hashing:

public class PasswordHashing {
    public String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * encodedhash.length);

            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; // Handle the exception appropriately
        }
    }

}
    

Code snippet for course directory:

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
    int courseRatings;
    public String getName() {
        return name;
    }
   }

Scope
This project encompasses the design and implementation of the entire educational platform, including user registration, course management, and degree evaluation.





 















