/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFramework;

import Methods.Method;
import ConfigureABusiness.BusinessData;
import Methods.PasswordHashing;
import static com.sun.org.apache.xalan.internal.lib.ExsltDynamic.map;
import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseDirectory.CourseDirectory;
import UserInterface.WorkAreas.CourseSchedule.CoursesLoad;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.CourseSchedule.CoursesSchedule;
import UserInterface.WorkAreas.CourseSchedule.SeatsAssignment;
import UserInterface.WorkAreas.Department.DepartmentModel;
import UserInterface.WorkAreas.Department.DepartmentDirectoryModel;
import UserInterface.WorkAreas.FacultyRole.FacultyDirectoryModel;
import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;
import UserInterface.WorkAreas.StudentRole.PersonRoleModel;
import UserInterface.WorkAreas.StudentRole.PersonCatalog;
import UserInterface.WorkAreas.StudentRole.StudentCatalog;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.awt.event.ActionEvent;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import static sun.awt.image.MultiResolutionCachedImage.map;
import static sun.awt.image.MultiResolutionToolkitImage.map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prasanna
 */
public class ProfessorjPanel extends javax.swing.JPanel {
    
    private String selectedCourse = "";
    HashMap<String, DepartmentModel> map = new HashMap<>();
    private Map<String, CoursesOffer> coursemap = new HashMap<>();
   ArrayList<String> al2 = new ArrayList();
   ArrayList<StudentProfileModel> al3 = new ArrayList();
   StudentCatalog sd ;
   DepartmentModel d;
    StudentCatalog sd1;
     ArrayList<String> mainList = new ArrayList<>();
       ArrayList<String> mainList1 = new ArrayList<>();
      String grade ;
      BusinessData testData = BusinessData.getInstance();
      ArrayList<String> sl;
      ArrayList<StudentProfileModel> sl1;
      String studentName="";
      TeachingHistory teachingHistory;
      TeachingHistoryDirectory teachingHistoryDirectory;
      String depName;
            String depNameProf;
    private final PasswordHashing passwordHashing;
    EmployerjPanel admin;
    // Inside your LoginButtonActionPerformed method
    Random random = new Random();
    // Define a HashMap to store user credentials
private Map<String, String> userCredentials = new HashMap<>();
public Map<String, String> feedbackMap = new HashMap<>();


      DepartmentDirectoryModel department = testData.getDd();
          CourseDirectory cd;
          CoursesSchedule cs;
    /**
     * Creates new form prof
     */
    public ProfessorjPanel(TeachingHistory teachingHistory, TeachingHistoryDirectory teachingHistoryDirectory, String loggedInProfessorId) {
        initComponents();
      testData = BusinessData.getInstance();
     // sd = testData.getSd();
      
        PrfLgnPnl1.setVisible(false);
        AddProfPanel.setVisible(false);
        this.teachingHistory = teachingHistory;
        this.teachingHistoryDirectory = teachingHistoryDirectory;
        this.admin = admin;
        this.passwordHashing = new PasswordHashing();
        
        ArrayList<DepartmentModel> departmentlist = department.getDd();
            
//            String admin ="admin";
//            String adStd= UsernameTextField.getText();
            
         
            
                for(DepartmentModel d : departmentlist){
               
                map.put(d.getName(), d);
                }
                
        populateTable(loggedInProfessorId);
       // studentpanel = new StudentjPanel();
     //   this.d = "Coursess";

    }
    
   /* public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblTeachingHistory.getModel();
        dtm.setRowCount(0);

        for (TeachingHistory history : teachingHistoryDirectory.getTeachingHistory()) {
            Object[] row = new Object[5];
            
            row[0] = history.getFacultyName();
            row[1] = history.getCourseID();
            row[2] = history.getCourse();
            row[3] = history.getSemester();
            row[4] = history.getStudentCount();

            dtm.addRow(row);
        }

    } */
    private void populateStudentTable(int numberOfStudents, String[] studentIDs, String[] studentNames) {
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();

        // Clear the table before populating with new students
        model.setRowCount(0);

        //String[] studentIDsProf1 = {"ID001", "ID002", "ID003", "ID004", "ID005", "ID006", "ID007", "ID008", "ID009", "ID010", "ID011", "ID012"};
        //String[] studentNamesProf1 = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isaac", "Julia", "Kevin", "Linda"};
        List<String> shuffledStudentNames = Arrays.asList(studentNames);
        Collections.shuffle(shuffledStudentNames); // Shuffle the list of student names
        // Add the 12 students' details to the table
        // Add the shuffled students' details to the table
        // Add the shuffled students' details to the table
        for (int i = 0; i < numberOfStudents; i++) {
            String studentID = studentIDs[i % studentIDs.length];
            String studentName = shuffledStudentNames.get(i % shuffledStudentNames.size());

            // Assuming a random GPA for demonstration
            double randomGPA = 1.0 + (Math.random() * 3.0); // Random GPA between 1.0 and 4.0

            model.addRow(new Object[]{studentID, studentName, String.format("%.2f", randomGPA)});
        }
        
     
    }

    public void populateTable(String loggedInProfessorId) {
        DefaultTableModel dtm = (DefaultTableModel) tblTeachingHistory.getModel();
        dtm.setRowCount(0);

        // Retrieve teaching history for the logged-in professor
        ArrayList<TeachingHistory> professorTeachingHistory = teachingHistoryDirectory.getTeachingHistoryForProfessor(loggedInProfessorId);

        if (professorTeachingHistory != null) {
            for (TeachingHistory history : professorTeachingHistory) {
                Object[] row = new Object[5];

                row[0] = history.getFacultyName();
                row[1] = history.getCourseID();
                row[2] = history.getCourse();
                row[3] = history.getSemester();
                row[4] = history.getStudentCount();

                dtm.addRow(row);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StudentLoginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        UsernameLabel = new javax.swing.JLabel();
        PasswordLowerPanel = new javax.swing.JPanel();
        PasswordField = new javax.swing.JPasswordField();
        UsernameLowerPanel = new javax.swing.JPanel();
        LoginButton = new javax.swing.JButton();
        btnProgSignUp = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        PrfLgnPnl1 = new javax.swing.JPanel();
        FacultyjTabbedPane1 = new javax.swing.JTabbedPane();
        ClassesjPanel2 = new javax.swing.JPanel();
        lblClassCode = new javax.swing.JLabel();
        lblClassName = new javax.swing.JLabel();
        lblSem = new javax.swing.JLabel();
        txtCourseID = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtCourseBatch = new javax.swing.JTextField();
        StudentsjPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        TeachingjPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTeachingHistory = new javax.swing.JTable();
        AddProfPanel = new javax.swing.JPanel();
        AddstucouLbl1 = new javax.swing.JLabel();
        AddstuNameLbl1 = new javax.swing.JLabel();
        AddStuIdLbl1 = new javax.swing.JLabel();
        AddProfcoucom = new javax.swing.JComboBox<>();
        AddProfnameTxt = new javax.swing.JTextField();
        AddProfIdTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        AddProf = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProfLocation = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        StudentLoginPanel.setBackground(new java.awt.Color(23, 35, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACULTY LOG IN");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout StudentLoginPanelLayout = new javax.swing.GroupLayout(StudentLoginPanel);
        StudentLoginPanel.setLayout(StudentLoginPanelLayout);
        StudentLoginPanelLayout.setHorizontalGroup(
            StudentLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        StudentLoginPanelLayout.setVerticalGroup(
            StudentLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(153, 153, 153));
        PasswordLabel.setText("PASSWORD:");

        UsernameTextField.setBackground(new java.awt.Color(0, 102, 102));
        UsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsernameTextField.setForeground(new java.awt.Color(153, 153, 153));
        UsernameTextField.setBorder(null);
        UsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTextFieldActionPerformed(evt);
            }
        });

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(153, 153, 153));
        UsernameLabel.setText("USERNAME: ");

        PasswordLowerPanel.setBackground(new java.awt.Color(0, 153, 153));
        PasswordLowerPanel.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout PasswordLowerPanelLayout = new javax.swing.GroupLayout(PasswordLowerPanel);
        PasswordLowerPanel.setLayout(PasswordLowerPanelLayout);
        PasswordLowerPanelLayout.setHorizontalGroup(
            PasswordLowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PasswordLowerPanelLayout.setVerticalGroup(
            PasswordLowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PasswordField.setBackground(new java.awt.Color(0, 102, 102));
        PasswordField.setBorder(null);
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        UsernameLowerPanel.setBackground(new java.awt.Color(0, 153, 153));
        UsernameLowerPanel.setForeground(new java.awt.Color(255, 153, 153));
        UsernameLowerPanel.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout UsernameLowerPanelLayout = new javax.swing.GroupLayout(UsernameLowerPanel);
        UsernameLowerPanel.setLayout(UsernameLowerPanelLayout);
        UsernameLowerPanelLayout.setHorizontalGroup(
            UsernameLowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        UsernameLowerPanelLayout.setVerticalGroup(
            UsernameLowerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        LoginButton.setBackground(new java.awt.Color(0, 102, 102));
        LoginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(153, 153, 153));
        LoginButton.setText("LOGIN");
        LoginButton.setBorder(null);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        btnProgSignUp.setBackground(new java.awt.Color(0, 102, 102));
        btnProgSignUp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProgSignUp.setForeground(new java.awt.Color(153, 153, 153));
        btnProgSignUp.setText("SIGNUP");
        btnProgSignUp.setMaximumSize(new java.awt.Dimension(40, 17));
        btnProgSignUp.setMinimumSize(new java.awt.Dimension(40, 17));
        btnProgSignUp.setPreferredSize(new java.awt.Dimension(40, 17));
        btnProgSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgSignUpActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("New User?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(PasswordLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                    .addComponent(PasswordField)
                    .addComponent(UsernameLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                    .addComponent(UsernameTextField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(683, 683, 683)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(547, 547, 547)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnProgSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(StudentLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(UsernameLowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PasswordLowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProgSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(540, Short.MAX_VALUE))
        );

        PrfLgnPnl1.setBackground(new java.awt.Color(29, 44, 64));

        ClassesjPanel2.setBackground(new java.awt.Color(0, 51, 51));

        lblClassCode.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblClassCode.setForeground(new java.awt.Color(153, 153, 153));
        lblClassCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClassCode.setText("Course ID:");

        lblClassName.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblClassName.setForeground(new java.awt.Color(153, 153, 153));
        lblClassName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblClassName.setText("Course Name:");

        lblSem.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblSem.setForeground(new java.awt.Color(153, 153, 153));
        lblSem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSem.setText("Batch:");

        javax.swing.GroupLayout ClassesjPanel2Layout = new javax.swing.GroupLayout(ClassesjPanel2);
        ClassesjPanel2.setLayout(ClassesjPanel2Layout);
        ClassesjPanel2Layout.setHorizontalGroup(
            ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassesjPanel2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSem)
                    .addComponent(lblClassName)
                    .addComponent(lblClassCode))
                .addGap(94, 94, 94)
                .addGroup(ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourseID)
                    .addComponent(txtCourseName)
                    .addComponent(txtCourseBatch, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addGap(922, 922, 922))
        );

        ClassesjPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblClassCode, lblClassName, lblSem});

        ClassesjPanel2Layout.setVerticalGroup(
            ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassesjPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClassCode)
                    .addComponent(txtCourseID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClassName)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(ClassesjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSem)
                    .addComponent(txtCourseBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(328, Short.MAX_VALUE))
        );

        ClassesjPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblClassCode, lblClassName});

        FacultyjTabbedPane1.addTab("Current Classes", ClassesjPanel2);

        StudentsjPanel3.setBackground(new java.awt.Color(0, 51, 51));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "GPA"
            }
        ));
        jScrollPane1.setViewportView(tblStudents);

        javax.swing.GroupLayout StudentsjPanel3Layout = new javax.swing.GroupLayout(StudentsjPanel3);
        StudentsjPanel3.setLayout(StudentsjPanel3Layout);
        StudentsjPanel3Layout.setHorizontalGroup(
            StudentsjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentsjPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(988, Short.MAX_VALUE))
        );
        StudentsjPanel3Layout.setVerticalGroup(
            StudentsjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentsjPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        FacultyjTabbedPane1.addTab("Students", StudentsjPanel3);

        TeachingjPanel5.setBackground(new java.awt.Color(0, 51, 51));

        tblTeachingHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Faculty Name", "Course ID", "Course", "Batch", "Student Count"
            }
        ));
        jScrollPane4.setViewportView(tblTeachingHistory);

        javax.swing.GroupLayout TeachingjPanel5Layout = new javax.swing.GroupLayout(TeachingjPanel5);
        TeachingjPanel5.setLayout(TeachingjPanel5Layout);
        TeachingjPanel5Layout.setHorizontalGroup(
            TeachingjPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeachingjPanel5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(830, Short.MAX_VALUE))
        );
        TeachingjPanel5Layout.setVerticalGroup(
            TeachingjPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeachingjPanel5Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        FacultyjTabbedPane1.addTab("Teaching History", TeachingjPanel5);

        javax.swing.GroupLayout PrfLgnPnl1Layout = new javax.swing.GroupLayout(PrfLgnPnl1);
        PrfLgnPnl1.setLayout(PrfLgnPnl1Layout);
        PrfLgnPnl1Layout.setHorizontalGroup(
            PrfLgnPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrfLgnPnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FacultyjTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PrfLgnPnl1Layout.setVerticalGroup(
            PrfLgnPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrfLgnPnl1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(FacultyjTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );

        AddProfPanel.setBackground(new java.awt.Color(29, 44, 64));
        AddProfPanel.setForeground(new java.awt.Color(153, 153, 153));

        AddstucouLbl1.setForeground(new java.awt.Color(153, 153, 153));
        AddstucouLbl1.setText("Course:");

        AddstuNameLbl1.setForeground(new java.awt.Color(153, 153, 153));
        AddstuNameLbl1.setText("Name:");

        AddStuIdLbl1.setForeground(new java.awt.Color(153, 153, 153));
        AddStuIdLbl1.setText("Id:");

        AddProfcoucom.setBackground(new java.awt.Color(44, 63, 87));
        AddProfcoucom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        AddProfcoucom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProfcoucomActionPerformed(evt);
            }
        });

        AddProfnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProfnameTxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REGISTER");

        AddProf.setBackground(new java.awt.Color(44, 63, 86));
        AddProf.setForeground(new java.awt.Color(153, 153, 153));
        AddProf.setText("Register");
        AddProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProfActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Password:");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Location");

        javax.swing.GroupLayout AddProfPanelLayout = new javax.swing.GroupLayout(AddProfPanel);
        AddProfPanel.setLayout(AddProfPanelLayout);
        AddProfPanelLayout.setHorizontalGroup(
            AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProfPanelLayout.createSequentialGroup()
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(AddProf))
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddstuNameLbl1)
                            .addComponent(AddStuIdLbl1)
                            .addComponent(jLabel8)
                            .addComponent(AddstucouLbl1)
                            .addComponent(jLabel2))
                        .addGap(351, 351, 351)
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddProfIdTxt)
                            .addComponent(AddProfnameTxt)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addGroup(AddProfPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(AddProfcoucom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtProfLocation))))
                .addContainerGap(850, Short.MAX_VALUE))
        );
        AddProfPanelLayout.setVerticalGroup(
            AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProfPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(31, 31, 31)
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddstuNameLbl1)
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(AddProfnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddStuIdLbl1)
                            .addComponent(AddProfIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddstucouLbl1)
                    .addComponent(AddProfcoucom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(AddProf)
                .addContainerGap(677, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrfLgnPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1480, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(AddProfPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrfLgnPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(AddProfPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
            // TODO add your handling code here:

        String username = UsernameTextField.getText();
        String oldusername = UsernameTextField.getText();
        
        String userid = txtCourseID.getText();
        String oldpassword = txtPassword.getText();
        
        validateLogin(oldusername, oldpassword);

        String[] studentIDsProf1 = {"info2", "info3", "info4", "info5", "info6", "info7", "info8", "info9", "info10", "info11", "info12", "info13","info14", "info15", "info16", "cs1", "cs2", "cs3", "cs4", "cs5","cs6"};
        String[] studentNamesProf1 = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isaac", "Julia", "Kevin", "Linda"};

        switch (username) {
            case "prof1":
                populateStudentTable(generateRandomStudentCount(3,15), studentIDsProf1, studentNamesProf1); // Populate with 12 students for prof1
                break;
            case "prof2":
                populateStudentTable(generateRandomStudentCount(5, 14), studentIDsProf1, studentNamesProf1); // Populate with 10 students for prof2
                break;
            case "prof3":
                populateStudentTable(generateRandomStudentCount(2, 12), studentIDsProf1, studentNamesProf1); // Populate with 7 students for prof3
                break;
            // Add cases for prof4 to prof12 with the corresponding student counts
            // ...
            case "prof4":
                populateStudentTable(generateRandomStudentCount(7, 13), studentIDsProf1, studentNamesProf1); // Populate with 12 students for prof1
                break;
            case "prof5":
                populateStudentTable(generateRandomStudentCount(1, 11), studentIDsProf1, studentNamesProf1); // Populate with 10 students for prof2
                break;
            case "prof6":
                populateStudentTable(generateRandomStudentCount(1, 7), studentIDsProf1, studentNamesProf1); // Populate with 7 students for prof3
                break;
            case "prof7":
                populateStudentTable(generateRandomStudentCount(8, 9), studentIDsProf1, studentNamesProf1); // Populate with 12 students for prof1
                break;
            case "prof8":
                populateStudentTable(generateRandomStudentCount(3, 5), studentIDsProf1, studentNamesProf1); // Populate with 10 students for prof2
                break;
            case "prof9":
                populateStudentTable(generateRandomStudentCount(5, 8), studentIDsProf1, studentNamesProf1); // Populate with 7 students for prof3
                break;
            case "prof10":
                populateStudentTable(generateRandomStudentCount(5, 9), studentIDsProf1, studentNamesProf1); // Populate with 12 students for prof1
                break;
            case "prof11":
                populateStudentTable(generateRandomStudentCount(2, 3), studentIDsProf1, studentNamesProf1); // Populate with 10 students for prof2
                break;

            case "prof12":
                populateStudentTable(generateRandomStudentCount(8, 9), studentIDsProf1, studentNamesProf1); // Populate with 5 students for prof12
                break;
                
                    case "prof13":
                populateStudentTable(generateRandomStudentCount(1, 7), studentIDsProf1, studentNamesProf1); // Populate with 7 students for prof3
                break;
            case "prof14":
                populateStudentTable(generateRandomStudentCount(8, 9), studentIDsProf1, studentNamesProf1); // Populate with 12 students for prof1
                break;
            case "prof15":
                populateStudentTable(generateRandomStudentCount(3, 5), studentIDsProf1, studentNamesProf1); // Populate with 10 students for prof2
                break;
            case "prof16":
                populateStudentTable(generateRandomStudentCount(5, 8), studentIDsProf1, studentNamesProf1); // Populate with 7 students for prof3
                break;
            case "prof17":
                populateStudentTable(generateRandomStudentCount(5, 9), studentIDsProf1, studentNamesProf1); // Populate with 12 students for prof1
                break;
            case "prof18":
                populateStudentTable(generateRandomStudentCount(2, 3), studentIDsProf1, studentNamesProf1); // Populate with 10 students for prof2
                break;

            case "prof19":
                populateStudentTable(generateRandomStudentCount(8, 9), studentIDsProf1, studentNamesProf1); // Populate with 5 students for prof12
                break;
                
            default:
                // Handle other cases if needed
                break;
        }

        for (int i = 1; i <= 22; i++) {
            if (("prof" + i).equals(username)) {
                switch (i) {
                    case 1:
                        txtCourseBatch.setText("Fall 2022");
                        break;
                    case 2:
                        txtCourseBatch.setText("Fall 2021");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 3:
                        txtCourseBatch.setText("Spring 2020");
                        break;
                    // ... 
                    case 4:
                        txtCourseBatch.setText("Fall 2022");
                        break;
                    case 5:
                        txtCourseBatch.setText("Fall 2021");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 6:
                        txtCourseBatch.setText("Spring 2020");
                        break;
                    // ... 
                    case 7:
                        txtCourseBatch.setText("Fall 2022");
                        break;
                    case 8:
                        txtCourseBatch.setText("Fall 2021");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 9:
                        txtCourseBatch.setText("Spring 2020");
                        break;
                    // ... 
                    case 10:
                        txtCourseBatch.setText("Fall 2021");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 11:
                        txtCourseBatch.setText("Spring 2020");
                        break;
                    // ... 

                    case 12:
                        txtCourseBatch.setText("Summer 2019");
                        break;
                    default:
                        // Handle other cases if needed
                        txtCourseBatch.setText("Fall 2023");
                        break;
                }
                break; // Exit loop once a match is found
            }
        }

        for (int i = 1; i <= 22; i++) {
            if (("prof" + i).equals(username)) {
                switch (i) {
                    case 1:
                        txtCourseID.setText("5101");
                        break;
                    case 2:
                        txtCourseID.setText("7101");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 3:
                        txtCourseID.setText("6353");
                        break;
                    // ... 
                    case 4:
                        txtCourseID.setText("5204");
                        break;
                    case 5:
                        txtCourseID.setText("7010");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 6:
                        txtCourseID.setText("6284");
                        break;
                    // ... 
                    case 7:
                        txtCourseID.setText("5101");
                        break;
                    case 8:
                        txtCourseID.setText("5000");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 9:
                        txtCourseID.setText("5100");
                        break;
                    // ... 
                    case 10:
                        txtCourseID.setText("7102");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 11:
                        txtCourseID.setText("6271");
                        break;
                    // ... 

                    case 12:
                        txtCourseID.setText("5200");
                        break;
                    default:
                        // Handle other cases if needed
                        txtCourseID.setText("8756");
                        break;
                }
                break; // Exit loop once a match is found
            }
        }
        
         for (int i = 1; i <= 22; i++) {
            if (("prof" + i).equals(username)) {
                switch (i) {
                    case 1:
                        txtCourseName.setText("AED");
                        break;
                    case 2:
                        txtCourseName.setText("WEB Design");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 3:
                        txtCourseName.setText("NLP");
                        break;
                    // ... 
                    case 4:
                        txtCourseName.setText("ADC");
                        break;
                    case 5:
                        txtCourseName.setText("Smartphone Design");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 6:
                        txtCourseName.setText("blockchain");
                        break;
                    // ... 
                    case 7:
                        txtCourseName.setText("SMat COntracts");
                        break;
                    case 8:
                        txtCourseName.setText("PSA");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 9:
                        txtCourseName.setText("Ios Development");
                        break;
                    // ... 
                    case 10:
                        txtCourseName.setText("Agile Engineering");
                        break;
                    // Add cases for prof3 to prof12 with corresponding batch values
                    case 11:
                        txtCourseName.setText("Data Science");
                        break;
                    // ... 

                    case 12:
                        txtCourseName.setText("Business Analytics");
                        break;
                    default:
                        // Handle other cases if needed
                        txtCourseName.setText("Management systems");
                        break;
                }
                break; // Exit loop once a match is found
            }
        }

        String id = UsernameTextField.getText();
        populateTable(id);
        sl = getProfessorList("Fall2023", id);
        //jButton1.setText(sl.get(0));
        sl1 = getStudentTakenByProf(sl.get(0), BusinessData.getInstance().getDd());

        for (int i = 0; i < sl1.size(); i++) {
            mainList.add(sl1.get(i).getPerson().getPersonId());
            mainList1.add(sl1.get(i).getCourseLoadBySemester("Fall2023").getSeatassignments().get(0).getGrade());
        }
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        model.setRowCount(0);
//        // TableCellListener tcl = (TableCellListener)evt.getSource();
//
//       // jPanel3.setVisible(true);
//        Object[] row = new Object[2];
//        
//        for(int i=0;i<mainList.size();i++)
//        {
//            
//            row[0]=mainList.get(i);
//            row[1]=mainList1.get(i);
//            model.addRow(row);
//        }
//        
//        model.addTableModelListener(
//            new TableModelListener()
//            {
//                public void tableChanged(TableModelEvent evt)
//                {
//                    
//                    int col = evt.getColumn();
//                    int row = evt.getFirstRow();
//                    //System.out.println(row+"as");
//                    grade = model.getValueAt(row, col).toString();
//                    studentName = model.getValueAt(row, 0).toString();
//                    
//                    
//                   
//                }
//            });
//      
        jPanel1.setVisible(false);
        PrfLgnPnl1.setVisible(true);
        StudentsjPanel3.setVisible(false);
    }//GEN-LAST:event_LoginButtonActionPerformed
    public ArrayList<StudentProfileModel> getStudentTakenByProf(String courseID, DepartmentDirectoryModel d) {

        List<DepartmentModel> list2 = d.getDd();
        for (DepartmentModel d1 : list2) {

            ArrayList<StudentProfileModel> as = new ArrayList();
            List<StudentProfileModel> list = d1.getStudentDirectory().getStudentlist();
            for (StudentProfileModel sp : list) {
                List<SeatsAssignment> list1 = sp.getCourseLoadBySemester("Fall2023").getSeatassignments();
                for (SeatsAssignment seatAssignment : list1) {
                    if (seatAssignment.getSeat().getCourseoffer().getCourse().getCOurseNumber().equals(courseID)) {
                        //System.out.println(sp.getPerson().getPersonId());
                        sd = d1.getStudentDirectory();
                        al3.add(sp);
                    }
                }
            }

        }
        return al3;
    }

    public void setGrade(String courseID, StudentCatalog d, String grade, String studentId) {

        ArrayList<StudentProfileModel> as = new ArrayList();
        List<StudentProfileModel> list = d.getStudentlist();
        for (StudentProfileModel sp : list) {
            List<SeatsAssignment> list1 = sp.getCourseLoadBySemester("Fall2023").getSeatassignments();
            for (SeatsAssignment seatAssignment : list1) {
                if (seatAssignment.getSeat().getCourseoffer().getCourse().getCOurseNumber().equals(courseID)
                        && sp.getPerson().getPersonId().equals(studentId)) {
                    //  System.out.println(sp.getPerson().getPersonId());
                    seatAssignment.setGrade(grade);
                }
            }
        }

    }

    public static void getGrade(String courseID, StudentCatalog sd, String grade, String studentId) {

        ArrayList<StudentProfileModel> as = new ArrayList();
        List<StudentProfileModel> list = sd.getStudentlist();
        for (StudentProfileModel sp : list) {
            List<SeatsAssignment> list1 = sp.getCourseLoadBySemester("Fall2023").getSeatassignments();
            for (SeatsAssignment seatAssignment : list1) {
                if (seatAssignment.getSeat().getCourseoffer().getCourse().getCOurseNumber().equals(courseID) && sp.getPerson().getPersonId().equals(studentId)) {
                    //  System.out.println(sp.getPerson().getPersonId());
                    System.out.println(seatAssignment.getGrade());
                }
            }
        }

    }

    public ArrayList<String> getProfessorList(String semester, String pid) {
        System.out.println("Mouse Clicked");
        String uname = "";
        String pwd = "admin";
        String usertxt = UsernameTextField.getText();
        DepartmentDirectoryModel dd = BusinessData.getInstance().getDd();
        boolean found = false;
        List<DepartmentModel> list = dd.getDd();
        for (DepartmentModel d : list) {
            CoursesSchedule courseSchedule = d.getCourseSchedule("Fall2023");
            if (courseSchedule != null) {
                ArrayList<CoursesOffer> al1 = courseSchedule.getSchedule();
                //System.out.println(al1.size());
                for (int i = 0; i < al1.size(); i++) {
                    //System.out.println(al1.get(i).getFacultyProfile());
                    if (al1.get(i).getFacultyProfile().getPerson().getPersonId().equals(pid)) {
                        al2.add(al1.get(i).getCourse().getCOurseNumber());
                    }
                }
            }
        }
        return al2;
    }
    private void UsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTextFieldActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnProgSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgSignUpActionPerformed
        List<CoursesOffer> depname = getCourseOfferedByDepartment(map.get("Coursess"));
        System.out.println("depname == " + depname);
        for (CoursesOffer co : depname) {
            
            coursemap.put(co.getCourse().getName(), co);
        }
        for (String couname : coursemap.keySet()) {
            AddProfcoucom.addItem(couname);
            
        }
        jPanel1.setVisible(false);
        AddProfPanel.setVisible(true);
    }//GEN-LAST:event_btnProgSignUpActionPerformed

    public List<CoursesOffer> getCourseOfferedByDepartment(DepartmentModel d) {
        System.out.println(d);
        return new Method().getCourseOfferList(d, "Fall2023");
    }

    private void AddProfcoucomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfcoucomActionPerformed
        // TODO add your handling code here:
        // Manually set the department name (example: "Information Systems")
        // Retrieve the selected course and store it in the class-level variable
        selectedCourse = AddProfcoucom.getSelectedItem().toString();
        // Call the method to update the course name in the Current Classes panel
        updateCurrentCourseName(selectedCourse);
    }//GEN-LAST:event_AddProfcoucomActionPerformed

    private void AddProfnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddProfnameTxtActionPerformed

    private void AddProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfActionPerformed
        // TODO add your handling code here:
        // Retrieve username and password from respective text fields
    String username = AddProfIdTxt.getText();
    String newpassword = txtPassword.getText();
        
        //saveUserDetails( username,newpassword);

        

        String profname = AddProfnameTxt.getText();
        String profid = AddProfIdTxt.getText();
        //String coursename = AddProfcoucom.getSelectedItem().toString();
        if (profname.isEmpty() || profid.isEmpty() || selectedCourse.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all mandatory fields.");
        } else {
            //admin.addProf(map.get(depNameProf), profname, profid, "Fall2023 ", coursemap.get(coursename));
            JOptionPane.showMessageDialog(this, "Professor Added");
            
            txtCourseBatch.setText("Fall 2023");

            String userID = txtCourseID.getText();

            int randomCourseNumber = new Random().nextInt(9000) + 1000; // Generates between 1000 and 9999

                // Create a course ID with a fixed prefix (INFO) and the random number
                String courseID = Integer.toString(randomCourseNumber);

                // Set the text of the txtCourseID field to the generated course ID
                txtCourseID.setText(courseID);
                DepartmentDirectoryModel dd = BusinessData.getInstance().getDd();
        boolean found = false;
        List<DepartmentModel> list = dd.getDd();
        for (DepartmentModel d : list) {
            
                this.d = d;
        }
             PersonCatalog pd = d.getPersonDirectory();
             PersonRoleModel prof = pd.newPerson(profid);
             
             prof.setName(profname);
             
             FacultyDirectoryModel fd = d.getFacultyDirectory();
             
             FacultyProfileModel fp = fd.newStudentProfile(prof);
             fp.setFacultyRatings(0);
             fp.setLocation(txtProfLocation.getText());
//             ArrayList<Course> courseList = d.getCourseCatalog().getCourseList();
//             
//             for(int i = 0; i < courseList.size(); i++){
//                 
//                 Course course = courseList.get(i);
//                   
//                   if(AddProfcoucom.getSelectedItem().toString().equals(course.getName())){
                       
                       //String courseId = course.getCOurseNumber();
                       //System.out.println("courseId= "+courseId);
//                       d.RegisterForAClass(profid, courseId, "Fall2023");
//                        registeredCourses.add(courseId);
//                                    List<CoursesOffer> depname = getCourseOfferedByDepartment(map.get("Coursess"));
//                                    for (CoursesOffer co : depname) {
//            
//                                        if(AddProfcoucom.getSelectedItem().toString().equals(co.getCourse().getName())){
//                                            CoursesSchedule courseschedule = d.getCourseSchedule("Fall2023");
////        CoursesSchedule courseschedule1 = department1.newCourseSchedule("Fall2023");
//System.out.println("courseschedle= " + courseschedule);
//                                        Course courseinfo = d.newCourse(co.getCourse().getName(), courseID, 4);
//                                    CoursesOffer courseoffer = courseschedule.newCourseOffer(courseinfo.getCOurseNumber());
//        
//        courseoffer.generatSeats(10);
//                            System.out.println("co= "+co);
//                           fp.AssignAsTeacher(courseoffer);                           
//                           courseoffer.AssignAsTeacher(fp);
//                                        }
//                                     }                            
                                    
                            
                            
                           
//                   }
//             }
             
             
            String password = "yourPassword";
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ProfessorjPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] encodedhash = digest.digest(password.getBytes());

// Convert the byte array to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                hexString.append(String.format("%02x", b));
            }
            String hashedPassword = null;

            // Check if passwordHashing is not null before using it
            if (passwordHashing != null) {
                hashedPassword = passwordHashing.hashPassword(password);
            }

            if (hashedPassword != null) {
                System.out.println(hashedPassword);
            } else {
                // Handle the case when password hashing is not available
                JOptionPane.showMessageDialog(this, "Password hashing is not available.");
            }

            AddProfPanel.setVisible(false);
        PrfLgnPnl1.setVisible(true);
        // Clear the selected course for the next addition
        selectedCourse = "";
    }//GEN-LAST:event_AddProfActionPerformed
        // jPanel1.setVisible(true);
        

    }

    public ArrayList<String> removeDuplicates(ArrayList<String> list) {

        Set<String> set = new HashSet();
        for (String s : list) {
            set.add(s);
        }

        list.clear();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            list.add(it.next().toString());
        }

        return list;

    }

    // Method to update the course name in the Current Classes panel
    private void updateCurrentCourseName(String courseName) {
        // Set the course name in the txtCourseName field in the Current Classes panel
        txtCourseName.setText(courseName);

    }

    // Method to generate a random count of students within a range
    private int generateRandomStudentCount(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

        // Code to save user sign-up details
private void saveUserDetails(String username, String password) {
    userCredentials.put(username, password);
    // You might want to save this userCredentials map to a file or database for persistence
}

// Code to perform login validation
private boolean validateLogin(String username, String password) {
    // Check if the provided username exists in the stored user credentials
    if (userCredentials.containsKey(username)) {
        // If the username exists, validate the provided password
        String storedPassword = userCredentials.get(username);
        return storedPassword.equals(password); // Returns true if the password matches
    }
    return false; // Returns false if the username doesn't exist
}
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProf;
    private javax.swing.JTextField AddProfIdTxt;
    private javax.swing.JPanel AddProfPanel;
    private javax.swing.JComboBox<String> AddProfcoucom;
    private javax.swing.JTextField AddProfnameTxt;
    private javax.swing.JLabel AddStuIdLbl1;
    private javax.swing.JLabel AddstuNameLbl1;
    private javax.swing.JLabel AddstucouLbl1;
    private javax.swing.JPanel ClassesjPanel2;
    private javax.swing.JTabbedPane FacultyjTabbedPane1;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel PasswordLowerPanel;
    private javax.swing.JPanel PrfLgnPnl1;
    private javax.swing.JPanel StudentLoginPanel;
    private javax.swing.JPanel StudentsjPanel3;
    private javax.swing.JPanel TeachingjPanel5;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel UsernameLowerPanel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JButton btnProgSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblClassCode;
    private javax.swing.JLabel lblClassName;
    private javax.swing.JLabel lblSem;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTable tblTeachingHistory;
    private javax.swing.JTextField txtCourseBatch;
    private javax.swing.JTextField txtCourseID;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtProfLocation;
    // End of variables declaration//GEN-END:variables
}
