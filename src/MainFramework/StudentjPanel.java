/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFramework;

import ConfigureABusiness.BusinessData;
import Methods.Method;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import Methods.PasswordHashing;

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
import UserInterface.WorkAreas.StudentRole.StudentTranscript;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aayus
 */
public class StudentjPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentjPanel
     */
    HashMap<String, DepartmentModel> map = new HashMap();
    private Set<String> registeredCourses = new HashSet<>(); // Maintain a set to store registered courses
    String rating;
    String course;
    Map<String, String> map1 = new HashMap<>();
    BusinessData td;
    DepartmentModel d;
    StudentProfileModel sp;
    String profName;
    Course courses;
    CourseDirectory courseDirectory;
    CoursesOffer co;
    String depName;
    StudentCatalog sd;
    PasswordHashing passwordHashing;
    String depNameProf;
    AdminjPanel admin;
    CourseDirectory courseCatalog;
    HashMap<String, CoursesOffer> coursemap = new HashMap();
    private int selectedCheckBoxCount = 0;
    BusinessData testData = BusinessData.getInstance();
    DepartmentDirectoryModel department = testData.getDd();
     private boolean coursesMessageDisplayed = false;


    public StudentjPanel() {
        initComponents();

        td = BusinessData.getInstance();
        StdDspPnl.setVisible(false);
        Addstupanel.setVisible(false);
        jPanel8.setVisible(false);
        getCourseData();
        this.courses = courses;
        this.courseDirectory = courseDirectory;
        this.admin = admin;
        this.passwordHashing = new PasswordHashing();

        ArrayList<DepartmentModel> departmentlist = department.getDd();

        for (DepartmentModel dp : departmentlist) {

            map.put(dp.getName(), dp);
        }

        // td.test2();
        //StdDspPnl.setVisible(false);
        // RateProfPanel.setVisible(false);
    }

    public List<CoursesOffer> getCourseOfferedByDepartment(DepartmentModel d) {
        return new Method().getCourseOfferList(d, "Fall2023");
    }

    public void populateTable() {

        DefaultTableModel stdDltstbl = (DefaultTableModel) StdDtlTbl.getModel();
        stdDltstbl.setRowCount(0);

        ArrayList courseList = sp.getCurrentCourseLoad().getCourseInformation();
        System.out.println(courseList);

//        stdDltstbl.addRow(new Object[]{"", ""});

        for (int i = 0; i < courseList.size(); i++) {
            if (i % 2 == 0) {
                stdDltstbl.addRow(new Object[]{courseList.get(i), ""});
            } else {
                int rowCount = stdDltstbl.getRowCount();
                stdDltstbl.setValueAt(courseList.get(i), rowCount - 1, 1); // Add to the last row in column 2
            }
           
        }
//        sp.getTranscript().getGpa(); 
       // CGPAtxt.setText(sp.getTranscript().getGpa().toString());
        String gpaText = "";
if (sp != null && sp.getTranscript() != null && sp.getTranscript().getGpa() != null) {
    gpaText = sp.getTranscript().getGpa().toString();
}
CGPAtxt.setText(gpaText);
        

        DefaultTableModel dtm = (DefaultTableModel) tblRegisterCourses.getModel();
        dtm.setRowCount(0);

        List<CoursesOffer> co = getCourseOfferedByDepartment(d);

        for (int i = 0; i < co.size(); i++) {
            Object[] row = new Object[5];

            row[0] = co.get(i).getCourseNumber();
            row[1] = co.get(i).getCourse().getName();
            row[2] = co.get(i).getFacultyProfile().getPerson().getName();
            row[3] = co.get(i).getFacultyProfile().getLocation();
            row[4] = co.get(i).getFacultyProfile().getFacultyRatings();

            dtm.addRow(row);
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
        btnSignUp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        StdDspPnl = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRegisterCourses = new javax.swing.JTable();
        tbnRegister = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        StdDtjPanel = new javax.swing.JPanel();
        jStdDtlLb = new javax.swing.JLabel();
        StdDtlScrlPn = new javax.swing.JScrollPane();
        StdDtlTbl = new javax.swing.JTable();
        StdIDlbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CGPAtxt = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnGradYes = new javax.swing.JButton();
        jProgressBar3 = new javax.swing.JProgressBar();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jTextField5 = new javax.swing.JTextField();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jTextField6 = new javax.swing.JTextField();
        jCheckBox31 = new javax.swing.JCheckBox();
        jCheckBox32 = new javax.swing.JCheckBox();
        jCheckBox33 = new javax.swing.JCheckBox();
        jTextField7 = new javax.swing.JTextField();
        jCheckBox37 = new javax.swing.JCheckBox();
        jCheckBox38 = new javax.swing.JCheckBox();
        jCheckBox39 = new javax.swing.JCheckBox();
        jTextField8 = new javax.swing.JTextField();
        jCheckBox43 = new javax.swing.JCheckBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        Addstupanel = new javax.swing.JPanel();
        AddstucouLbl = new javax.swing.JLabel();
        AddstuNameLbl = new javax.swing.JLabel();
        AddStuIdLbl = new javax.swing.JLabel();
        Addstucoucom = new javax.swing.JComboBox<>();
        AddstunameTxt = new javax.swing.JTextField();
        AddstuIdTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AddStudent = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(29, 44, 64));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 3));

        StudentLoginPanel.setBackground(new java.awt.Color(23, 35, 51));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT LOG IN");
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
        UsernameTextField.setMaximumSize(new java.awt.Dimension(32767, 32767));
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
        PasswordField.setMaximumSize(new java.awt.Dimension(32767, 32767));
        PasswordField.setMinimumSize(new java.awt.Dimension(0, 0));
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

        btnSignUp.setBackground(new java.awt.Color(0, 102, 102));
        btnSignUp.setForeground(new java.awt.Color(153, 153, 153));
        btnSignUp.setText("SIGNUP");
        btnSignUp.setMaximumSize(new java.awt.Dimension(40, 17));
        btnSignUp.setMinimumSize(new java.awt.Dimension(40, 17));
        btnSignUp.setPreferredSize(new java.awt.Dimension(40, 17));
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("New User?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(PasswordLowerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(UsernameLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(653, 653, 653))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(StudentLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(UsernameLowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(PasswordLowerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        StdDspPnl.setBackground(new java.awt.Color(0, 51, 51));
        StdDspPnl.setPreferredSize(new java.awt.Dimension(0, 3));

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        tblRegisterCourses.setModel(new javax.swing.table.DefaultTableModel(
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
                "Course ID", "Course Name", "Professor", "Location", "Ratings"
            }
        ));
        jScrollPane3.setViewportView(tblRegisterCourses);

        tbnRegister.setText("Register");
        tbnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(tbnRegister)))
                .addContainerGap(521, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(tbnRegister)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register Courses", jPanel3);

        jPanel7.setBackground(new java.awt.Color(29, 44, 64));

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Courses", "Ratings"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jButton1))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(969, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(671, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1432, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Rate Course", jPanel4);

        StdDtjPanel.setBackground(new java.awt.Color(0, 51, 51));
        StdDtjPanel.setPreferredSize(new java.awt.Dimension(0, 3));

        jStdDtlLb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jStdDtlLb.setForeground(new java.awt.Color(153, 153, 153));
        jStdDtlLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jStdDtlLb.setText("TRANSCRIPT");

        StdDtlTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Name", "Course Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StdDtlScrlPn.setViewportView(StdDtlTbl);

        StdIDlbl.setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("CGPA");

        CGPAtxt.setEditable(false);
        CGPAtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CGPAtxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StdDtjPanelLayout = new javax.swing.GroupLayout(StdDtjPanel);
        StdDtjPanel.setLayout(StdDtjPanelLayout);
        StdDtjPanelLayout.setHorizontalGroup(
            StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StdDtjPanelLayout.createSequentialGroup()
                .addGroup(StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StdDtjPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(StdDtlScrlPn, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(StdDtjPanelLayout.createSequentialGroup()
                                    .addGap(104, 104, 104)
                                    .addComponent(StdIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(StdDtjPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(CGPAtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(StdDtjPanelLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStdDtlLb, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 878, Short.MAX_VALUE))
        );
        StdDtjPanelLayout.setVerticalGroup(
            StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StdDtjPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jStdDtlLb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(StdIDlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StdDtlScrlPn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(StdDtjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CGPAtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(649, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1444, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StdDtjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(StdDtjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Transcript & GPA", jPanel2);

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(900, 800));

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 912, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Do you want to declare Graduation?");

        btnGradYes.setBackground(new java.awt.Color(0, 102, 102));
        btnGradYes.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnGradYes.setText("DECLARE GRADUATION");
        btnGradYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGradYesActionPerformed(evt);
            }
        });

        jCheckBox1.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox1.setText("Have you completed all assignments?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox3.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox3.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox4.setText("Have you completed all labs?");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setText("Course 1");

        jTextField2.setBackground(new java.awt.Color(0, 102, 102));
        jTextField2.setText("Course 2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jCheckBox2.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox2.setText("Have you completed all assignments?");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox8.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox8.setText("Have you completed all labs?");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox9.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox9.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setText("Course 3");

        jCheckBox13.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox13.setText("Have you completed all assignments?");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        jCheckBox14.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox14.setText("Have you completed all labs?");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        jCheckBox15.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox15.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setText("Course 4");

        jCheckBox19.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox19.setText("Have you completed all assignments?");
        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });

        jCheckBox20.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox20.setText("Have you completed all labs?");
        jCheckBox20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox20ActionPerformed(evt);
            }
        });

        jCheckBox21.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox21.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox21ActionPerformed(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setText("Course 5");

        jCheckBox25.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox25.setText("Have you completed all assignments?");
        jCheckBox25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox25ActionPerformed(evt);
            }
        });

        jCheckBox26.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox26.setText("Have you completed all labs?");
        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });

        jCheckBox27.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox27.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox27ActionPerformed(evt);
            }
        });

        jTextField6.setBackground(new java.awt.Color(0, 102, 102));
        jTextField6.setText("Course 6");

        jCheckBox31.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox31.setText("Have you completed all assignments?");
        jCheckBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox31ActionPerformed(evt);
            }
        });

        jCheckBox32.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox32.setText("Have you completed all labs?");
        jCheckBox32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox32ActionPerformed(evt);
            }
        });

        jCheckBox33.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox33.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox33ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setText("Course 7");

        jCheckBox37.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox37.setText("Have you completed all assignments?");
        jCheckBox37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox37ActionPerformed(evt);
            }
        });

        jCheckBox38.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox38.setText("Have you completed all labs?");
        jCheckBox38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox38ActionPerformed(evt);
            }
        });

        jCheckBox39.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox39.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox39ActionPerformed(evt);
            }
        });

        jTextField8.setBackground(new java.awt.Color(0, 102, 102));
        jTextField8.setText("Course 8");

        jCheckBox43.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox43.setText("Have you completed all assignments?");
        jCheckBox43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox43ActionPerformed(evt);
            }
        });

        jCheckBox44.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox44.setText("Have you completed all labs?");
        jCheckBox44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox44ActionPerformed(evt);
            }
        });

        jCheckBox45.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox45.setText("Do you have a minimum of 3.2 CGPA?");
        jCheckBox45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox45ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox27)
                                    .addComponent(jCheckBox25)
                                    .addComponent(jCheckBox26))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox33, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jCheckBox32)
                                            .addComponent(jCheckBox31))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox39)
                                    .addComponent(jCheckBox37)
                                    .addComponent(jCheckBox38))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox44)
                                            .addComponent(jCheckBox45)))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBox43))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jCheckBox8)
                                    .addComponent(jCheckBox2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox15)
                                    .addComponent(jCheckBox14)
                                    .addComponent(jCheckBox13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox21)
                                    .addComponent(jCheckBox20)
                                    .addComponent(jCheckBox19))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(btnGradYes)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnGradYes))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jCheckBox4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox13)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox15)
                                    .addComponent(jCheckBox9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jCheckBox20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox21)))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox37)
                                    .addComponent(jCheckBox43))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox38)
                                    .addComponent(jCheckBox44))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox39)
                                    .addComponent(jCheckBox45)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox27))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBox31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox33)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Declare Graduation", jPanel5);

        javax.swing.GroupLayout StdDspPnlLayout = new javax.swing.GroupLayout(StdDspPnl);
        StdDspPnl.setLayout(StdDspPnlLayout);
        StdDspPnlLayout.setHorizontalGroup(
            StdDspPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StdDspPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1034, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
        );
        StdDspPnlLayout.setVerticalGroup(
            StdDspPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StdDspPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(448, Short.MAX_VALUE))
        );

        Addstupanel.setBackground(new java.awt.Color(0, 51, 51));

        AddstucouLbl.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        AddstucouLbl.setForeground(new java.awt.Color(153, 153, 153));
        AddstucouLbl.setText("Course:");

        AddstuNameLbl.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        AddstuNameLbl.setForeground(new java.awt.Color(153, 153, 153));
        AddstuNameLbl.setText("Name:");

        AddStuIdLbl.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        AddStuIdLbl.setForeground(new java.awt.Color(153, 153, 153));
        AddStuIdLbl.setText("Id:");

        Addstucoucom.setBackground(new java.awt.Color(0, 102, 102));
        Addstucoucom.setForeground(new java.awt.Color(153, 153, 153));
        Addstucoucom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        Addstucoucom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddstucoucomActionPerformed(evt);
            }
        });

        AddstunameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddstunameTxtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTER");

        AddStudent.setBackground(new java.awt.Color(0, 102, 102));
        AddStudent.setForeground(new java.awt.Color(153, 153, 153));
        AddStudent.setText("Register");
        AddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Password:");

        javax.swing.GroupLayout AddstupanelLayout = new javax.swing.GroupLayout(Addstupanel);
        Addstupanel.setLayout(AddstupanelLayout);
        AddstupanelLayout.setHorizontalGroup(
            AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddstupanelLayout.createSequentialGroup()
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddstuNameLbl)
                            .addComponent(AddStuIdLbl)
                            .addComponent(AddstucouLbl)))
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddStudent)))
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddstuIdTxt)
                    .addComponent(AddstunameTxt)
                    .addComponent(Addstucoucom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addGap(754, 754, 754))
        );
        AddstupanelLayout.setVerticalGroup(
            AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddstupanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(36, 36, 36)
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddstuNameLbl)
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addComponent(AddstunameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddStuIdLbl)
                            .addComponent(AddstuIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(AddstucouLbl))
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(Addstucoucom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(AddStudent)
                .addContainerGap(677, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StdDspPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Addstupanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(StdDspPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Addstupanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Mouse Clicked");
        String uname = "";
        String pwd = "admin";
        String usertxt = UsernameTextField.getText();
        DepartmentDirectoryModel dd = BusinessData.getInstance().getDd();
        boolean found = false;
        List<DepartmentModel> list = dd.getDd();
        for (DepartmentModel d : list) {
            StudentCatalog sd = d.getStudentDirectory();
            StudentProfileModel sp = sd.findStudent(usertxt);
            if (sp != null) {
                this.sp = sp;
                this.d = d;
                //            System.out.println(student);

                //StdIDlbl.setText(usertxt);
                //if((student!=null) && (jPwdTxtfld.getPassword().equals(pwd)))
                jPanel1.setVisible(false);
                //RateProfPanel.setVisible(false);
                //StdDspPnl.setVisible(true);
                //jPanel1.setVisible(false);
                //ListOfCoursesPnl.setVisible(true);

                ArrayList<CoursesLoad> cl1 = sp.getCurrentCourseLoad().getCourseInformation();
                //            System.out.println(student.studentPerformanceMetric());
                //            System.out.println(cl1);

                //DefaultTableModel model = (DefaultTableModel) StdDtlTbl.getModel();
                //model.setRowCount(0);
                for (int i = 0; i < cl1.size(); i++) {

                    Object[] row = new Object[2];
                    if (i % 2 == 0) {
                        row[0] = cl1.get(i);
                        row[1] = cl1.get(i + 1);
                        //model.addRow(row);
                    }
                }
                Double val1 = sp.studentPerformanceMetric();

                //GpaTxtfld.setText(val1.toString());
                Double val2 = sp.getCurrentCourseLoad().iterateSeatAssignments();
                // System.out.println(val2);
                //CGPAtxt.setText(val2.toString());
                found = true;
                populateTable();
                //CGPAtxt.setText(String.valueOf(sp.studentPerformanceMetric()));
                jPanel1.setVisible(false);
                StdDspPnl.setVisible(true);

            }

        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No Student Found");
        }

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void UsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTextFieldActionPerformed

    private void CGPAtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CGPAtxtActionPerformed
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_CGPAtxtActionPerformed

    private void btnGradYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGradYesActionPerformed
        // TODO add your handling code here:
        
        // Check if the number of registered courses is at least 8
            if (registeredCourses.size() >= 8) {
                // Allow the user to graduate - Enable graduation button
                btnGradYes.setEnabled(true);
            } else {
                // Disable the graduation button and prompt the user to register for 8 courses
                btnGradYes.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Please register for at least 8 courses to be eligible for graduation.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        //jPanel8.setVisible(true);
        //jPanel5.setVisible(false);
        // Check if all checkboxes are checked based on the progress bar value
        int totalCheckBoxes = 24; // Total number of checkboxes.
        int progressValue = (selectedCheckBoxCount * 100) / totalCheckBoxes;

        if (progressValue < 100) {
            JOptionPane.showMessageDialog(this, "Please complete all requirements before declaring graduation.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Congratulations for your Graduation!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            // Perform further actions if necessary for successful graduation declaration
        }
    }//GEN-LAST:event_btnGradYesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DepartmentDirectoryModel dd = BusinessData.getInstance().getDd();
        List<DepartmentModel> list = dd.getDd();
        List<Course> list1 = getReleventCourses();;

        Boolean flag = false;
        System.out.println("TT ");
        Iterator it = map1.entrySet().iterator();
        for (DepartmentModel d : list) {
            for (int i = 0; i < list1.size(); i++) {
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (d.getCourseCatalog().getCourseList().get(i).getName().equals(pair.getKey())) {
                        d.getCourseCatalog().getCourseList().get(i).setRating(Integer.parseInt(pair.getValue().toString()));
                        System.out.println("TT jkk");

                        it.remove();
                        flag = true;
                        System.out.println("Course Ratings: " + d.getCourseCatalog().getCourseList().get(i).getRating());
                        break;
                    }
                }
            }
        }

        if (flag)
            JOptionPane.showMessageDialog(this, "Your Rating has been Saved!");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnRegisterActionPerformed
        // TODO add your handling code here:
                                                   
         int selectedRow = tblRegisterCourses.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a course from the table first to register", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String courseId = (String) tblRegisterCourses.getValueAt(selectedRow, 0);

            if (registeredCourses.contains(courseId)) {
                JOptionPane.showMessageDialog(null, "You have already registered for this course!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                d.RegisterForAClass(sp.getPerson().getPersonId(), courseId, "Fall2023");
                registeredCourses.add(courseId); // Add the course to the registered set
                JOptionPane.showMessageDialog(null, "Course successfully registered!", "Information", JOptionPane.INFORMATION_MESSAGE);
                populateTable();

                // Check if 8 courses are selected only if the message has not been displayed yet
                if (!coursesMessageDisplayed && registeredCourses.size() < 8) {
                    int remainingCourses = 8 - registeredCourses.size();
                    JOptionPane.showMessageDialog(null, "Please register for at least " + remainingCourses + " more courses to be eligible for graduation.", "Warning", JOptionPane.WARNING_MESSAGE);
                    coursesMessageDisplayed = true; // Set the flag to true to indicate the message has been displayed
                }

                if (registeredCourses.size() == 8) {
                    btnGradYes.setEnabled(true);
                } else {
                    btnGradYes.setEnabled(false);
                }

                System.out.println("courseId = " + courseId);
                System.out.println("Metric== " + sp.studentPerformanceMetric());
            }
        }

    }//GEN-LAST:event_tbnRegisterActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        List<CoursesOffer> depname = getCourseOfferedByDepartment(map.get("Coursess"));
        System.out.println("depname == " + depname);
        for (CoursesOffer co : depname) {
            coursemap.put(co.getCourse().getName(), co);
        }
        for (String couname : coursemap.keySet()) {
            Addstucoucom.addItem(couname);
        }

        jPanel1.setVisible(false);
        Addstupanel.setVisible(true);

    }//GEN-LAST:event_btnSignUpActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        // When jCheckBox1 is clicked, update the progress bar based on the selected checkboxes.
        if (jCheckBox1.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox4.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox3.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox13.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox14.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox15.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox19.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void jCheckBox20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox20ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox20.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox20ActionPerformed

    private void jCheckBox21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox21ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox21.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox21ActionPerformed

    private void jCheckBox25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox25ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox25.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox25ActionPerformed

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox26.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jCheckBox27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox27ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox27.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox27ActionPerformed

    private void jCheckBox31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox31ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox31.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox31ActionPerformed

    private void jCheckBox32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox32ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox32.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox32ActionPerformed

    private void jCheckBox33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox33ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox33.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox33ActionPerformed

    private void jCheckBox37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox37ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox37.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox37ActionPerformed

    private void jCheckBox38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox38ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox38.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox38ActionPerformed

    private void jCheckBox39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox39ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox39.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox39ActionPerformed

    private void jCheckBox43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox43ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox43.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox43ActionPerformed

    private void jCheckBox44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox44ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox44.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox44ActionPerformed

    private void jCheckBox45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox45ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox45.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox45ActionPerformed

    private void AddstunameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddstunameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddstunameTxtActionPerformed

    private void AddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentActionPerformed
        // TODO add your handling code here:
       // populateTable();
       // CGPAtxt.setText(String.valueOf(sp.studentPerformanceMetric()));
        

        String stuname = AddstunameTxt.getText();
        String stid = AddstuIdTxt.getText();
        String usertxt = UsernameTextField.getText();
        // String coursename = Addstucoucom.getSelectedItem().toString();
          DepartmentDirectoryModel dd = BusinessData.getInstance().getDd();
        boolean found = false;
        List<DepartmentModel> list = dd.getDd();
        for (DepartmentModel d : list) {
            //StudentCatalog sd = d.getStudentDirectory();
            //StudentProfileModel sp = sd.findStudent(usertxt);
            //if (sp != null) {
                //this.sp = sp;
                this.d = d;
                //            System.out.println(student);

                //StdIDlbl.setText(usertxt);
                //if((student!=null) && (jPwdTxtfld.getPassword().equals(pwd)))
              //  jPanel1.setVisible(false);
                //RateProfPanel.setVisible(false);
                //StdDspPnl.setVisible(true);
                //jPanel1.setVisible(false);
                //ListOfCoursesPnl.setVisible(true);

                //ArrayList<CoursesLoad> cl1 = sp.getCurrentCourseLoad().getCourseInformation();
                //            System.out.println(student.studentPerformanceMetric());
                //            System.out.println(cl1);

                //DefaultTableModel model = (DefaultTableModel) StdDtlTbl.getModel();
                //model.setRowCount(0);
//                for (int i = 0; i < cl1.size(); i++) {
//
//                    Object[] row = new Object[2];
//                    if (i % 2 == 0) {
//                        row[0] = cl1.get(i);
//                        row[1] = cl1.get(i + 1);
//                        //model.addRow(row);
//                    }
//                }
//                Double val1 = sp.studentPerformanceMetric();
//
//                //GpaTxtfld.setText(val1.toString());
//                Double val2 = sp.getCurrentCourseLoad().iterateSeatAssignments();
                // System.out.println(val2);
                //CGPAtxt.setText(val2.toString());
//                found = true;
//                getCourseData()
//                CGPAtxt.setText(String.valueOf(sp.studentPerformanceMetric()));
               // jPanel1.setVisible(false);
              
           // }

        }
       
        if (stuname.isEmpty() || stid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all mandatory fields.");
        } else {
            // admin.addStudent(map.get("Coursess"), stuname, stid, "Fall2023 ", coursemap.get(coursename));
            JOptionPane.showMessageDialog(this, "Student Added");
            //  jTabbedPane1.setSelectedComponent(this.StdDspPnl);
                            
              PersonCatalog pd = d.getPersonDirectory();
              
              PersonRoleModel person = pd.newPerson(stid);
              
              person.setName(stuname);
                      
               sd = d.getStudentDirectory();
               
               StudentProfileModel student = sd.newStudentProfile(person);
               
               this.sp = student;
               CoursesLoad courseload = student.newCourseLoad("Fall2023");
               
               ArrayList<Course> courseList = d.getCourseCatalog().getCourseList();
               
               for(int i = 0; i < courseList.size(); i++){
                   
                   Course course = courseList.get(i);
                   
                   if(Addstucoucom.getSelectedItem().toString().equals(course.getName())){
                       
                       String courseId = course.getCOurseNumber();
                       d.RegisterForAClass(stid, courseId, "Fall2023");
                        registeredCourses.add(courseId);
                   }
               }
               
                                           


            String password = "admin";
            MessageDigest digest = null;
            try {
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(StudentjPanel.class.getName()).log(Level.SEVERE, null, ex);
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

//String hashedPassword = passwordHashing.hashPassword(password);//hexString.toString();

            populateTable();

               
             Addstupanel.setVisible(false);
                StdDspPnl.setVisible(true);
                jPanel1.setVisible(true);
            
    }//GEN-LAST:event_AddStudentActionPerformed
        // jPanel1.setVisible(false);
       // Addstupanel.setVisible(false);
        //StdDspPnl.setVisible(true);
    }

    private void AddstucoucomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddstucoucomActionPerformed
        // TODO add your handling code here:

//        System.out.println("==== " + d);
        /* List<CoursesOffer> depname = getCourseOfferedByDepartment(d);
        for (CoursesOffer co : depname) {
            admin.coursemap.put(co.getCourseNumber(), co);
        }
        for (String couname : admin.coursemap.keySet())
            Addstucoucom.addItem(couname); */
    }//GEN-LAST:event_AddstucoucomActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox9.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox8.isSelected()) {
            selectedCheckBoxCount++;
        } else {
            selectedCheckBoxCount--;
        }
        updateProgressBar();
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new BusinessData().test2();
                //new StdJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddStuIdLbl;
    private javax.swing.JButton AddStudent;
    private javax.swing.JTextField AddstuIdTxt;
    private javax.swing.JLabel AddstuNameLbl;
    private javax.swing.JLabel AddstucouLbl;
    private javax.swing.JComboBox<String> Addstucoucom;
    private javax.swing.JTextField AddstunameTxt;
    private javax.swing.JPanel Addstupanel;
    private javax.swing.JTextField CGPAtxt;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel PasswordLowerPanel;
    private javax.swing.JPanel StdDspPnl;
    private javax.swing.JPanel StdDtjPanel;
    private javax.swing.JScrollPane StdDtlScrlPn;
    private javax.swing.JTable StdDtlTbl;
    private javax.swing.JLabel StdIDlbl;
    private javax.swing.JPanel StudentLoginPanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel UsernameLowerPanel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JButton btnGradYes;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jStdDtlLb;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTable tblRegisterCourses;
    private javax.swing.JButton tbnRegister;
    // End of variables declaration//GEN-END:variables

    private void getCourseData() {

        {
            //JOptionPane.showMessageDialog(this, "password ok");
            JComboBox myComboBox = new JComboBox();
            for (int i = 1; i <= 10; i++) {
                myComboBox.addItem(i);
            }
            List<Course> list1;
            list1 = getReleventCourses();
            System.out.println(list1.size());
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            // TableCellListener tcl = (TableCellListener)evt.getSource();
            jTable1.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(myComboBox));
            // jPanel3.setVisible(true);
            Object[] row = new Object[list1.size()];
            jTable1.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(myComboBox));

            for (int i = 0; i < list1.size(); i++) {

                row[0] = list1.get(i).getName();
                model.addRow(row);
            }
            model.addTableModelListener(
                    new TableModelListener() {
                public void tableChanged(TableModelEvent evt) {

                    int col = evt.getColumn();
                    int row = evt.getFirstRow();
                    // System.out.println(row+"as");
                    // System.out.println(col+"as1");
                    rating = model.getValueAt(row, 1).toString();
                    course = model.getValueAt(row, 0).toString();
                    map1.put(course, rating);

                }
            });
//        jPanel2.setVisible(true);
//        jPanel1.setVisible(false);

        }

    }

    public List<Course> getReleventCourses() {

        DepartmentModel dept = BusinessData.getInstance().getDd().getDd().get(0);
        //Department dept1 = BusinessData.getInstance().getDd().getDd().get(1);

        List<Course> res = dept.getCourseCatalog().getCourseList();
        //List<Course> res2 = dept1.getCourseCatalog().getCourseList();
        //List<Course> res = Stream.concat(res1.stream(), res2.stream()).collect(Collectors.toList());
        System.out.println("SS " + res.get(0).getCOurseNumber());
        return res;
    }

    private int getProgressIncrement() {
        // You can adjust this value to control how much the progress bar moves.
        // For example, set it to 100 to move the progress bar by 100 units for each checkbox.
        return 4; // Adjust this value as needed.
    }

    private void updateProgressBar() {
        int totalCheckBoxes = 24; // Total number of checkboxes.
        int progressValue = (selectedCheckBoxCount * 100) / totalCheckBoxes;
        jProgressBar3.setValue(progressValue);
    }

}
