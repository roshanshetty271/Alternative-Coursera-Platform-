/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFramework;

import ConfigureABusiness.BusinessData;
import Methods.Method;
import UserInterface.WorkAreas.CourseDirectory.Course;
import UserInterface.WorkAreas.CourseSchedule.CoursesOffer;
import UserInterface.WorkAreas.Department.DepartmentModel;
import UserInterface.WorkAreas.Department.DepartmentDirectoryModel;
import UserInterface.WorkAreas.Example.UserInterfaceWorkAreaExample;

import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;

import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author marve
 */
public class AdminjPanel extends javax.swing.JPanel {

    HashMap<String, DepartmentModel> map = new HashMap();
    BusinessData testData = BusinessData.getInstance();
    DepartmentDirectoryModel department = testData.getDd();
    ArrayList<DepartmentModel> departmentlist = department.getDd();
    HashMap<String, CoursesOffer> coursemap = new HashMap();
    String depName;
    String depNameProf;
     // courses;
    //CourseDirectory courseDirectory;

    /**
     * Creates new form univAdmin
     */
    public AdminjPanel() {
        initComponents();
        //testData.test2();
        UnvTbPane.setVisible(false);
        

        //this.courses = courses;
        //this.courseDirectory = courseDirectory;

        // Create a dataset for the ratings
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(5.0, "Ratings", "Professor 1");
        dataset.addValue(7.0, "Ratings", "Professor 2");
        dataset.addValue(4.0, "Ratings", "Professor 3");
        dataset.addValue(2.0, "Ratings", "Professor 4");
        dataset.addValue(5.0, "Ratings", "Professor 5");
        dataset.addValue(9.0, "Ratings", "Professor 6");
        dataset.addValue(2.0, "Ratings", "Professor 7");
        dataset.addValue(3.0, "Ratings", "Professor 8");
        dataset.addValue(6.0, "Ratings", "Professor 9");
        dataset.addValue(9.0, "Ratings", "Professor 10");
        // Add more ratings here

        // Create the chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Professor Ratings", // Chart title
                "Professors", // X-axis label
                "Rating", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Plot orientation
                true, // Show legend
                true, // Show tooltips
                false // Show URLs
        );
        
        CategoryPlot plot = barChart.getCategoryPlot();
        plot.getDomainAxis().setCategoryMargin(0.1);
        

     /*   // Assuming your JTabbedPane is named InUnvTabPane
       // int tabbedPaneIndex = 5; // Index of the 6th tab (0-based indexing)

// Get the panel at the specified tab index
      //  JPanel freeChartPanel = (JPanel) InUnvTabPane.getComponentAt(tabbedPaneIndex);

// Ensure the FreeChartjPanel is visible
        freeChartPanel.setVisible(true);

// Create a ChartPanel to display the chart
        ChartPanel chartPanel = new ChartPanel(barChart);

// Ensure the layout manager is set
        freeChartPanel.setLayout(new BorderLayout());

// Set the preferred size of the ChartPanel
        chartPanel.setPreferredSize(new Dimension(950, 300));

// Add the chartPanel to the FreeChartjPanel
        freeChartPanel.removeAll(); // Clear any existing components in the panel
        freeChartPanel.add(chartPanel, BorderLayout.WEST); // Add the chart to the center of the panel

// Revalidate and repaint the FreeChartjPanel to ensure the changes are visible
        freeChartPanel.revalidate();
        freeChartPanel.repaint();
*/
    } 

    public void populateTable() {
//        CrLstPnl.setVisible(false);
//        StdLstPnl.setVisible(false);
//        String selval = CrDptComboBox.getSelectedItem().toString();
        //jTextField1.setText(selval);

//        if(selval.equals("Information Systems"))
//        {
//            CrLstPnl.setVisible(true);
        DefaultTableModel modelCrName = (DefaultTableModel) CrNameTable.getModel();

        modelCrName.setRowCount(0);

        //System.out.println("Test "+ map.get("Information Systems"));
        List<CoursesOffer> co = getCourseOfferedByDepartment(map.get("Coursess"));

        for (int i = 0; i < co.size(); i++) {
            Object[] row = new Object[1];
            row[0] = co.get(i).getCourse().getName();
            modelCrName.addRow(row);

        }

        DefaultTableModel modelStdName = (DefaultTableModel) StdNameTable.getModel();
        modelStdName.setRowCount(0);

        //System.out.println("Test "+ map.get("Information Systems"));
        //List<CourseOffer> co = getCourseOfferedByDepartment(map.get("Information Systems"));
        List<StudentProfileModel> p = getStudentsByDepartmentName(map.get("Coursess"));
        for (int i = 0; i < p.size(); i++) //for(CoursesOffer c: co)
        {
            Object[] row = new Object[3];
            //row[0]=co.get(i).getCourse().getName().toString();
            row[0] = p.get(i).getPerson().getPersonId();
            row[1] = p.get(i).getPerson().getName();
            row[2] = p.get(i).getGpa();
            modelStdName.addRow(row);
        }

      /*  DefaultTableModel modelAyFkRk = (DefaultTableModel) AyFkRkTable.getModel();
        modelAyFkRk.setRowCount(0);

        ArrayList<FacultyProfileModel> frk = rankProfessorByDepartment(map.get("Coursess"));

        for (int i = 0; i < frk.size(); i++) {
            Object[] row = new Object[3];
            row[0] = frk.get(i).getFacultyRatings();
            row[1] = frk.get(i).getPerson().getName();
            row[2] = frk.get(i).getPerson().getPersonId();
            modelAyFkRk.addRow(row);

        } */

        //For Course Ranking of Information Systems
    /*    DefaultTableModel modelAyCrRk = (DefaultTableModel) AyCrRkTable.getModel();
        modelAyCrRk.setRowCount(0);

        ArrayList<Course> rco = rankCourseByDepartment(map.get("Coursess"));

        for (int i = 0; i < rco.size(); i++) {
            Object[] row = new Object[2];
            row[0] = rco.get(i).getRating();
            row[1] = rco.get(i).getName();
            modelAyCrRk.addRow(row);

        } */

        //Carrer SuccesMetric ranking for Information Systems
       // careerSuccesMetricRank(map.get("Coursess"));
        // System.out.println(csm);
        // CrScMtrxValLbl.setText(csm.toString());

        //ArrayList<Alumni> al = d.getAlumniDirectory().getAd();
        // CrMtrxTxtFld.setText(careerSuccesMetricRank);
     /*   ArrayList<Double> values = careerSuccesMetricRank(map.get("Coursess"));
        Double gpa = values.get(0);
        Double CGM = values.get(1);
        System.out.println(gpa + " " + CGM);
        StringBuilder sb = new StringBuilder();
        if (gpa < 8.4 && CGM > 5.0) {
            sb.append("Having a below average CGPA " + gpa + "doesnt affect the student's Industry Performance score " + CGM + "!!");
            System.out.println("Having a below average CGPA doesnt affect the student's Industry Performance!!");
        } //else if(gpa > 8.4 && CGM < 5.0){
        else {
            sb.append("Having a very good CGPA " + gpa + "doesnt guarantee Industry Success " + CGM + " !!");
        }
       // CsMTxtArea.setText(sb.toString());
*/
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
        UnvTbPane = new javax.swing.JPanel();
        InUnvTabPane = new javax.swing.JTabbedPane();
        ShwCrPnl = new javax.swing.JPanel();
        CrNameScrPnl = new javax.swing.JScrollPane();
        CrNameTable = new javax.swing.JTable();
        ShStdPnl = new javax.swing.JPanel();
        StdNameScrPnl = new javax.swing.JScrollPane();
        StdNameTable = new javax.swing.JTable();
        Addstupanel = new javax.swing.JPanel();
        AddstucouLbl = new javax.swing.JLabel();
        AddstuNameLbl = new javax.swing.JLabel();
        AddStuIdLbl = new javax.swing.JLabel();
        Addstucoucom = new javax.swing.JComboBox<>();
        AddstunameTxt = new javax.swing.JTextField();
        AddstuIdTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        AddStudent = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        AddProfPanel = new javax.swing.JPanel();
        AddstucouLbl1 = new javax.swing.JLabel();
        AddstuNameLbl1 = new javax.swing.JLabel();
        AddStuIdLbl1 = new javax.swing.JLabel();
        AddProfcoucom = new javax.swing.JComboBox<>();
        AddProfnameTxt = new javax.swing.JTextField();
        AddProfIdTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AddProf = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

        StudentLoginPanel.setBackground(new java.awt.Color(23, 35, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN LOG IN");
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
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("PASSWORD:");

        UsernameTextField.setBackground(new java.awt.Color(73, 163, 163));
        UsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsernameTextField.setBorder(null);
        UsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameTextFieldActionPerformed(evt);
            }
        });

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(255, 255, 255));
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

        PasswordField.setBackground(new java.awt.Color(73, 163, 163));
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

        LoginButton.setBackground(new java.awt.Color(73, 163, 163));
        LoginButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LoginButton.setText("LOGIN");
        LoginButton.setBorder(null);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(PasswordLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE)
                    .addComponent(PasswordField)
                    .addComponent(UsernameLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1297, Short.MAX_VALUE)
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
                .addGap(618, 618, 618)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(713, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(625, Short.MAX_VALUE))
        );

        InUnvTabPane.setBackground(new java.awt.Color(29, 44, 64));
        InUnvTabPane.setForeground(new java.awt.Color(153, 153, 153));
        InUnvTabPane.setPreferredSize(new java.awt.Dimension(1420, 1000));

        ShwCrPnl.setBackground(new java.awt.Color(0, 51, 51));
        ShwCrPnl.setForeground(new java.awt.Color(153, 153, 153));

        CrNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Course Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CrNameScrPnl.setViewportView(CrNameTable);

        javax.swing.GroupLayout ShwCrPnlLayout = new javax.swing.GroupLayout(ShwCrPnl);
        ShwCrPnl.setLayout(ShwCrPnlLayout);
        ShwCrPnlLayout.setHorizontalGroup(
            ShwCrPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShwCrPnlLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(CrNameScrPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(882, Short.MAX_VALUE))
        );
        ShwCrPnlLayout.setVerticalGroup(
            ShwCrPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShwCrPnlLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(CrNameScrPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(705, Short.MAX_VALUE))
        );

        InUnvTabPane.addTab("Course List", ShwCrPnl);

        ShStdPnl.setBackground(new java.awt.Color(0, 51, 51));

        StdNameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Student GPA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StdNameScrPnl.setViewportView(StdNameTable);

        javax.swing.GroupLayout ShStdPnlLayout = new javax.swing.GroupLayout(ShStdPnl);
        ShStdPnl.setLayout(ShStdPnlLayout);
        ShStdPnlLayout.setHorizontalGroup(
            ShStdPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShStdPnlLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(StdNameScrPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(839, Short.MAX_VALUE))
        );
        ShStdPnlLayout.setVerticalGroup(
            ShStdPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShStdPnlLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(StdNameScrPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(703, Short.MAX_VALUE))
        );

        InUnvTabPane.addTab("Student List", ShStdPnl);

        Addstupanel.setBackground(new java.awt.Color(0, 51, 51));

        AddstucouLbl.setForeground(new java.awt.Color(153, 153, 153));
        AddstucouLbl.setText("Course:");

        AddstuNameLbl.setForeground(new java.awt.Color(153, 153, 153));
        AddstuNameLbl.setText("Name:");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADD STUDENT");

        AddStudent.setBackground(new java.awt.Color(0, 102, 102));
        AddStudent.setForeground(new java.awt.Color(153, 153, 153));
        AddStudent.setText("Add");
        AddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Password:");

        javax.swing.GroupLayout AddstupanelLayout = new javax.swing.GroupLayout(Addstupanel);
        Addstupanel.setLayout(AddstupanelLayout);
        AddstupanelLayout.setHorizontalGroup(
            AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddstupanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddstuNameLbl)
                    .addComponent(AddStuIdLbl)
                    .addComponent(AddstucouLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(AddstuIdTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(AddstunameTxt))
                    .addComponent(Addstucoucom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(706, 706, 706))
            .addGroup(AddstupanelLayout.createSequentialGroup()
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(AddStudent))
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(432, 432, 432)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(699, Short.MAX_VALUE))
        );
        AddstupanelLayout.setVerticalGroup(
            AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddstupanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
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
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(AddstupanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(AddstupanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddstucouLbl)
                    .addComponent(Addstucoucom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(AddStudent)
                .addContainerGap(688, Short.MAX_VALUE))
        );

        InUnvTabPane.addTab("Add Student", Addstupanel);

        AddProfPanel.setBackground(new java.awt.Color(0, 51, 51));
        AddProfPanel.setForeground(new java.awt.Color(153, 153, 153));

        AddstucouLbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        AddstucouLbl1.setForeground(new java.awt.Color(153, 153, 153));
        AddstucouLbl1.setText("Course:");

        AddstuNameLbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        AddstuNameLbl1.setForeground(new java.awt.Color(153, 153, 153));
        AddstuNameLbl1.setText("Name:");

        AddStuIdLbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        AddStuIdLbl1.setForeground(new java.awt.Color(153, 153, 153));
        AddStuIdLbl1.setText("Id:");

        AddProfcoucom.setBackground(new java.awt.Color(0, 102, 102));
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ADD FACULTY");

        AddProf.setBackground(new java.awt.Color(0, 102, 102));
        AddProf.setForeground(new java.awt.Color(153, 153, 153));
        AddProf.setText("Add");
        AddProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProfActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Password:");

        javax.swing.GroupLayout AddProfPanelLayout = new javax.swing.GroupLayout(AddProfPanel);
        AddProfPanel.setLayout(AddProfPanelLayout);
        AddProfPanelLayout.setHorizontalGroup(
            AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProfPanelLayout.createSequentialGroup()
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(AddProf))
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddstuNameLbl1)
                            .addComponent(AddStuIdLbl1)
                            .addComponent(AddstucouLbl1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(348, 348, 348)
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddProfIdTxt)
                            .addComponent(AddProfnameTxt)
                            .addComponent(AddProfcoucom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
                .addContainerGap(800, Short.MAX_VALUE))
        );

        AddProfPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AddProfIdTxt, AddProfnameTxt, jTextField2});

        AddProfPanelLayout.setVerticalGroup(
            AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddProfPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddstuNameLbl1)
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(AddProfnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddStuIdLbl1)
                            .addComponent(AddProfIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddProfPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addGroup(AddProfPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddProfcoucom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddstucouLbl1))
                        .addGap(26, 26, 26)
                        .addComponent(AddProf))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(686, Short.MAX_VALUE))
        );

        AddProfPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AddProfIdTxt, AddProfnameTxt, jTextField2});

        InUnvTabPane.addTab("Add Faculty", AddProfPanel);

        javax.swing.GroupLayout UnvTbPaneLayout = new javax.swing.GroupLayout(UnvTbPane);
        UnvTbPane.setLayout(UnvTbPaneLayout);
        UnvTbPaneLayout.setHorizontalGroup(
            UnvTbPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InUnvTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1436, Short.MAX_VALUE)
        );
        UnvTbPaneLayout.setVerticalGroup(
            UnvTbPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InUnvTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1448, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(UnvTbPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(UnvTbPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameTextFieldActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        UnvTbPane.setVisible(false);

//            CrLstPnl.setVisible(false);
//            StdLstPnl.setVisible(false);
//            AyFcRkPnl.setVisible(false);
//            AyCrRkPnl.setVisible(false);
//            FcRkLbl.setVisible(false);
//            CrRkLbl.setVisible(false);
//            CsMScrPnl.setVisible(false);
//            CrScMtrxLbl.setVisible(false);
        ArrayList<DepartmentModel> departmentlist = department.getDd();

        String admin = "admin";
        String adStd = UsernameTextField.getText();

        if (adStd.equalsIgnoreCase(admin)) {
            //JOptionPane.showMessageDialog(this, "password ok");
            jPanel1.setVisible(false);
            UnvTbPane.setVisible(true);

            for (DepartmentModel d : departmentlist) {

                map.put(d.getName(), d);
            }

//                for (String name : map.keySet())  
//                    CrDptComboBox.addItem(name);
//                for (String name : map.keySet()) 
//                    StdDptComboBox.addItem(name);
//                for (String name : map.keySet())  
//                    AddStuDeptcb.addItem(name);
//                for (String name : map.keySet())  
//                   AddProfDeptcb1.addItem(name);
//                for (String name : map.keySet())  
//                   AyDptComboBox.addItem(name);
            populateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Enter Correct password");
            UnvTbPane.setVisible(false);
            jPanel1.setVisible(true);
        }

//            
//            
//            for(DepartmentModel d : departmentlist){
//               
//                map.put(d.getName(), d);
//            }
//
//            for (String name : map.keySet())  
//                   CrDptComboBox.addItem(name);
//            for (String name : map.keySet()) 
//                StdDptComboBox.addItem(name);
//            for (String name : map.keySet())  
//                   AddStuDeptcb.addItem(name);
//            for (String name : map.keySet())  
//                   AddProfDeptcb1.addItem(name);
//            for (String name : map.keySet())  
//                   AlmnDptComboBox.addItem(name);
//            for (String name : map.keySet())  
//                   AyDptComboBox.addItem(name);

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void AddProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfActionPerformed
        // TODO add your handling code here:
        String profname = AddProfnameTxt.getText();
        String profid = AddProfIdTxt.getText();
        String coursename = AddProfcoucom.getSelectedItem().toString();
        addProf(map.get(depNameProf), profname, profid, "Fall2023 ", coursemap.get(coursename));
        JOptionPane.showMessageDialog(this, "Professor Added");
    }//GEN-LAST:event_AddProfActionPerformed

    private void AddProfnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddProfnameTxtActionPerformed

    private void AddProfcoucomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProfcoucomActionPerformed
        // TODO add your handling code here:
        List<CoursesOffer> depname = getCourseOfferedByDepartment(map.get("Coursess"));
        for (CoursesOffer co : depname) {
            coursemap.put(co.getCourseNumber(), co);
        }
        for (String couname : coursemap.keySet())
        AddProfcoucom.addItem(couname);
    }//GEN-LAST:event_AddProfcoucomActionPerformed

    private void AddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentActionPerformed
        // TODO add your handling code here:
        //        depName = AddStuDeptcb.getSelectedItem().toString();
        String stuname = AddstunameTxt.getText();
        String stid = AddstuIdTxt.getText();
        String coursename = Addstucoucom.getSelectedItem().toString();
        addStudent(map.get("Coursess"), stuname, stid, "Fall2023 ", coursemap.get(coursename));
        JOptionPane.showMessageDialog(this, "Student Added");
        InUnvTabPane.setSelectedComponent(this.ShStdPnl);
    }//GEN-LAST:event_AddStudentActionPerformed

    private void AddstunameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddstunameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddstunameTxtActionPerformed

    private void AddstucoucomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddstucoucomActionPerformed
        // TODO add your handling code here:
        //String courseName =
        List<CoursesOffer> depname = getCourseOfferedByDepartment(map.get("Coursess"));
        System.out.println("==== " + depName);

        for (CoursesOffer co : depname) {
            coursemap.put(co.getCourseNumber(), co);
        }
        for (String couname : coursemap.keySet())
        Addstucoucom.addItem(couname);
    }//GEN-LAST:event_AddstucoucomActionPerformed

    public ArrayList<Course> rankCourseByDepartment(DepartmentModel d) {

        ArrayList<Course> course = d.getCourseCatalog().getCourseList();
        for (Course c : course) {
            System.out.println("BEfore Sorted form course" + c);
        }
        Collections.sort(course, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {

                return (o2.getRating()) - (o1.getRating());
            }
        });
        for (Course c : course) {
            System.out.println("Sorted form course" + c);
        }
        return course;

    }

    public ArrayList<FacultyProfileModel> rankProfessorByDepartment(DepartmentModel d) {

        ArrayList<FacultyProfileModel> fp = d.getFacultyDirectory().getTeacherlist();
        for (FacultyProfileModel f : fp) {
            System.out.println("BEfore Sorted form " + f);
        }
        Collections.sort(fp, new Comparator<FacultyProfileModel>() {
            @Override
            public int compare(FacultyProfileModel o1, FacultyProfileModel o2) {

                return o2.getFacultyRatings() - o1.getFacultyRatings();
            }
        });
        for (FacultyProfileModel f : fp) {
            System.out.println("Sorted form " + f);
        }

        return fp;

    }

    public ArrayList<Double> careerSuccesMetricRank(DepartmentModel d) {
        System.out.println(d.getName());
        ArrayList<Double> ald = new ArrayList<>();
        int size = d.getStudentDirectory().getStudentlist().size();
        int count = 0;
        double gpaCount = 0.0;
        double professionalGrowthCount = 0.0;
        Double res = 0.0;
        for (int i = 0; i < size; i++) {
            if (d.getStudentDirectory().getStudentlist().get(i).getIsAlumni()) {
                gpaCount += (d.getStudentDirectory().getStudentlist().get(i).getGpa()) * 2 + 2;
//                professionalGrowthCount += d.getStudentDirectory().getStudentlist().get(i).getAl().getCareerSuccess();
                count++;
            }
        }
        ald.add(gpaCount / count);
        ald.add(professionalGrowthCount / count);

        System.out.println("ALl GPA" + ald.get(0));
        System.out.println("ALl CGM" + ald.get(1));

        return ald;
    }

    public void getDepartmentList() {

//        ArrayList<Department> departmentlist = department.getDd();
        for (DepartmentModel d : departmentlist) {
            System.out.println(d.getName());
//            Method helper = new Method();
//            List<Course> course = helper.getCourseOffer(d, "Fall2023");
//            for(Course c : course)
//            {
//                System.out.println(c.getName());
//            }
//            List<Person> list = helper.getStudent(d);
//            for(PersonRoleModel p : list)
//            {
//                System.out.println(p.getPersonId());
//            }

            getCourseOfferedByDepartment(d);
        }

//        String d1 ="Information Systems";
//        String course ="app eng";
//       
//        for(DepartmentModel d : departmentlist)
//        {
//            //System.out.println(d.getName());
//            Method helper = new Method();
//            List<CourseOffer> course1 = helper.getCourseOfferList(d, "Fall2023");
//            for(CoursesOffer c : course1)
//            {
//                    if(c.getCourse().getName().equals(course))
//                    {
//                        helper.addStudent(d, "test", "1234", "Fall2023",c );
//                        
//                    }
//            }
//        }
//        for(DepartmentModel d : departmentlist)
//        {
//            System.out.println(d.getName());
//            Method helper = new Method();
//            List<Course> course2 = helper.getCourseOffer(d, "Fall2023");
//            for(Course c : course2)
//            {
//                System.out.println(c.getName());
//            }
//            List<Person> list = helper.getStudent(d);
//            for(PersonRoleModel p : list)
//            {
//                System.out.println(p.getPersonId());
//            }
//        }
        //  System.out.println("DD "+ uni.getDd().toString());
//        ArrayList<DepartmentDirectory> d = uni.getDd();
    }

    public List<StudentProfileModel> getStudentsByDepartmentName(DepartmentModel dpt) {
        Method helper = new Method();
        List<StudentProfileModel> p = helper.getStudent(dpt);
//            for(Course c : course)
//            {
//                System.out.println(c.getName());
//            }
//            List<Person> list = helper.getStudent(d);
//            for(PersonRoleModel p : list)
//            {
//                System.out.println(p.getPersonId());
//            }
        //  System.out.println("PP "+ p.get(0).getPersonId());
        return p;
    }

    public List<CoursesOffer> getCourseOfferedByDepartment(DepartmentModel d) {
        System.out.println("D== " + d);
        return new Method().getCourseOfferList(d, "Fall2023");
    }

    public void addStudent(DepartmentModel d, String sname, String sid, String sem, CoursesOffer co) {

        new Method().addStudent(d, sname, sid, sem, co);

    }
    // System.out.println("Std"+new Method().addStudent(d, "MM", "101", "2", co));

    public void addProf(DepartmentModel d, String profName, String pid, String sem, CoursesOffer co) {

        new Method().addProfessor(d, profName, pid, sem, co);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProf;
    private javax.swing.JTextField AddProfIdTxt;
    private javax.swing.JPanel AddProfPanel;
    private javax.swing.JComboBox<String> AddProfcoucom;
    private javax.swing.JTextField AddProfnameTxt;
    private javax.swing.JLabel AddStuIdLbl;
    private javax.swing.JLabel AddStuIdLbl1;
    private javax.swing.JButton AddStudent;
    private javax.swing.JTextField AddstuIdTxt;
    private javax.swing.JLabel AddstuNameLbl;
    private javax.swing.JLabel AddstuNameLbl1;
    private javax.swing.JLabel AddstucouLbl;
    private javax.swing.JLabel AddstucouLbl1;
    private javax.swing.JComboBox<String> Addstucoucom;
    private javax.swing.JTextField AddstunameTxt;
    private javax.swing.JPanel Addstupanel;
    private javax.swing.JScrollPane CrNameScrPnl;
    private javax.swing.JTable CrNameTable;
    private javax.swing.JTabbedPane InUnvTabPane;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel PasswordLowerPanel;
    private javax.swing.JPanel ShStdPnl;
    private javax.swing.JPanel ShwCrPnl;
    private javax.swing.JScrollPane StdNameScrPnl;
    private javax.swing.JTable StdNameTable;
    private javax.swing.JPanel StudentLoginPanel;
    private javax.swing.JPanel UnvTbPane;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel UsernameLowerPanel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
