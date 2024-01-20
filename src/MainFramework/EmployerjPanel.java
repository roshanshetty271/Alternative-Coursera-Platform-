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
import UserInterface.WorkAreas.Employer.EmployerCatalog;
import UserInterface.WorkAreas.EmployerRole.EmployerDirectoryModel;
import UserInterface.WorkAreas.EmployerRole.EmployersModel;
import UserInterface.WorkAreas.FacultyRole.FacultyProfileModel;
import UserInterface.WorkAreas.StudentRole.StudentProfileModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author marve
 */
public class EmployerjPanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentLoginPanel
     */
    HashMap<String, DepartmentModel> map = new HashMap();
        // Declare selectedStudentID as a class-level variable
    private String selectedStudentID;

    BusinessData testData = BusinessData.getInstance();
    DepartmentDirectoryModel department = testData.getDd();
    ArrayList<DepartmentModel> departmentlist = department.getDd();
    HashMap<String, CoursesOffer> coursemap = new HashMap();
    String depName;
    String depNameProf;
    public Map<String, String> feedbackMap = new HashMap<>(); 
    // courses;
    //CourseDirectory courseDirectory;
    BusinessData td;

    public EmployerjPanel() {
        initComponents();
        td = BusinessData.getInstance();
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);

       /* // Create a dataset for the ratings
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

        // Assuming your JTabbedPane is named InUnvTabPane
        int tabbedPaneIndex = 1; // Index of the 6th tab (0-based indexing)

// Get the panel at the specified tab index
        JPanel freeChartPanel = (JPanel) jTabbedPane1.getComponentAt(tabbedPaneIndex);

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
        freeChartPanel.repaint(); */

    }
    
    // Method to store feedback against the student ID
private void storeFeedback(String studentID, String feedback) {
    // Store the feedback in a Map with the student ID as the key
    feedbackMap.put(studentID, feedback);
    // Optionally, you can trigger an update in the UI or any necessary action after storing the feedback
    // For example, refreshing the feedback table or showing a confirmation message
    // You can call a method to update the UI or perform any other necessary operation here.
}

    public void populateTable() {
//        CrLstPnl.setVisible(false);
//        StdLstPnl.setVisible(false);
//        String selval = CrDptComboBox.getSelectedItem().toString();
        //jTextField1.setText(selval);

//        if(selval.equals("Information Systems"))
//        {
//            CrLstPnl.setVisible(true);

// Inside your method or constructor
jTable1.getSelectionModel().addListSelectionListener(e -> {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        Object studentID = jTable1.getValueAt(selectedRow, 0); // Assuming ID is in the first column
        // Store the selected student ID in a variable for later use
        // This variable should be accessible when btnFeedback is clicked
        selectedStudentID = studentID.toString(); // selectedStudentID is a class variable
    }
});

btnFeedback.addActionListener(e -> {
    String feedback = txtFeedback.getText().trim(); // Retrieve the feedback from the txtFeedback field and trim any leading/trailing spaces
    try {
        if (selectedStudentID != null) {
            if (feedback.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide feedback before submitting.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (feedbackMap.containsKey(selectedStudentID)) {
                JOptionPane.showMessageDialog(this, "Feedback for this student already exists.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Store the feedback along with the selected student ID
                storeFeedback(selectedStudentID, feedback);
                feedbackMap.put(selectedStudentID, feedback);
                JOptionPane.showMessageDialog(this, "Feedback received successfully for Student ID: " + selectedStudentID, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student before providing feedback.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception ex) {
        // Handle any exceptions that might occur during the feedback storage process
        JOptionPane.showMessageDialog(this, "Failed to store feedback. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace(); // Print the stack trace for debugging purposes
    }
});





   DefaultTableModel modelStdName = (DefaultTableModel) jTable1.getModel();
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

        DefaultTableModel modelAyFkRk = (DefaultTableModel) AyFkRkTable.getModel();
        modelAyFkRk.setRowCount(0);

        ArrayList<FacultyProfileModel> frk = rankProfessorByDepartment(map.get("Coursess"));

        for (int i = 0; i < frk.size(); i++) {
            Object[] row = new Object[3];
            row[0] = frk.get(i).getFacultyRatings();
            row[1] = frk.get(i).getPerson().getName();
            row[2] = frk.get(i).getPerson().getPersonId();
            modelAyFkRk.addRow(row);

            // After populating the table, create the JFreeChart
            createChartFromTable(modelAyFkRk);

        }
        // Create a dataset for the ratings
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < modelAyFkRk.getRowCount(); i++) {
            String professorName = (String) modelAyFkRk.getValueAt(i, 1); // Assuming professor names are in the second column
            int rating = (int) modelAyFkRk.getValueAt(i, 0); // Assuming ratings are in the first column

            dataset.addValue(rating, "Ratings", professorName);
        }

        // Create a dataset for the ratings
        //DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //For Course Ranking of Information Systems
        DefaultTableModel modelAyCrRk = (DefaultTableModel) AyCrRkTable.getModel();
        modelAyCrRk.setRowCount(0);

        ArrayList<Course> rco = rankCourseByDepartment(map.get("Coursess"));

        for (int i = 0; i < rco.size(); i++) {
            Object[] row = new Object[2];
            row[0] = rco.get(i).getRating();
            row[1] = rco.get(i).getName();
            modelAyCrRk.addRow(row);

        }

        //Carrer SuccesMetric ranking for Information Systems
        careerSuccesMetricRank(map.get("Coursess"));
        // System.out.println(csm);
        // CrScMtrxValLbl.setText(csm.toString());

        //ArrayList<Alumni> al = d.getAlumniDirectory().getAd();
        // CrMtrxTxtFld.setText(careerSuccesMetricRank);
        ArrayList<Double> values = careerSuccesMetricRank(map.get("Coursess"));
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
        CsMTxtArea.setText(sb.toString());

    }

    private void createChartFromTable(DefaultTableModel model) {
        // Create the dataset for the ratings
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < model.getRowCount(); i++) {
            String professorName = (String) model.getValueAt(i, 1); // Assuming professor names are in the second column
            int rating = (int) model.getValueAt(i, 0); // Assuming ratings are in the first column

            dataset.addValue(rating, "Ratings", professorName);
        }

        // Create the JFreeChart
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
        plot.getDomainAxis().setCategoryMargin(0.09);

        // Assuming your JTabbedPane is named InUnvTabPane
        int tabbedPaneIndex = 1; // Index of the 6th tab (0-based indexing)

// Get the panel at the specified tab index
        JPanel freeChartPanel = (JPanel) jTabbedPane1.getComponentAt(tabbedPaneIndex);

// Ensure the FreeChartjPanel is visible
        freeChartPanel.setVisible(true);

// Create a ChartPanel to display the chart
        ChartPanel chartPanel = new ChartPanel(barChart);

// Ensure the layout manager is set
        freeChartPanel.setLayout(new BorderLayout());

// Set the preferred size of the ChartPanel
        chartPanel.setPreferredSize(new Dimension(1300, 390));

// Add the chartPanel to the FreeChartjPanel
        freeChartPanel.removeAll(); // Clear any existing components in the panel
        freeChartPanel.add(chartPanel, BorderLayout.NORTH); // Add the chart to the center of the panel

// Revalidate and repaint the FreeChartjPanel to ensure the changes are visible
        freeChartPanel.revalidate();
        freeChartPanel.repaint();

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
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ShAyPnl = new javax.swing.JPanel();
        AyCrRkScrlPnl = new javax.swing.JScrollPane();
        AyCrRkTable = new javax.swing.JTable();
        FcRkLbl = new javax.swing.JLabel();
        CrRkLbl = new javax.swing.JLabel();
        CrScMtrxLbl = new javax.swing.JLabel();
        CsMScrPnl = new javax.swing.JScrollPane();
        CsMTxtArea = new javax.swing.JTextArea();
        AyFkRkScrlPnl = new javax.swing.JScrollPane();
        AyFkRkTable = new javax.swing.JTable();
        FreeChartjPanel = new javax.swing.JPanel();
        EmployerFeedbackjPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFeedback = new javax.swing.JButton();
        txtFeedback = new javax.swing.JTextField();

        setBackground(new java.awt.Color(29, 44, 64));
        setPreferredSize(new java.awt.Dimension(0, 3));

        StudentLoginPanel.setBackground(new java.awt.Color(23, 35, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYER LOG IN");
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

        UsernameTextField.setBackground(new java.awt.Color(44, 63, 87));
        UsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UsernameTextField.setForeground(new java.awt.Color(153, 153, 153));
        UsernameTextField.setBorder(null);

        UsernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsernameLabel.setForeground(new java.awt.Color(153, 153, 153));
        UsernameLabel.setText("USERNAME: ");

        PasswordLowerPanel.setBackground(new java.awt.Color(255, 153, 153));
        PasswordLowerPanel.setMinimumSize(new java.awt.Dimension(0, 0));
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

        PasswordField.setBackground(new java.awt.Color(44, 63, 87));
        PasswordField.setBorder(null);
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });

        UsernameLowerPanel.setBackground(new java.awt.Color(255, 153, 153));
        UsernameLowerPanel.setForeground(new java.awt.Color(255, 153, 153));
        UsernameLowerPanel.setMinimumSize(new java.awt.Dimension(0, 0));
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

        LoginButton.setBackground(new java.awt.Color(44, 63, 87));
        LoginButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(153, 153, 153));
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(440, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(StudentLoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(116, 116, 116)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(PasswordLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(PasswordField)
                                .addComponent(UsernameLowerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addComponent(UsernameTextField)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(UsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 253, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
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
                    .addContainerGap(177, Short.MAX_VALUE)))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(1029, 476));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1029, 511));

        ShAyPnl.setBackground(new java.awt.Color(0, 51, 51));
        ShAyPnl.setForeground(new java.awt.Color(153, 153, 153));

        AyCrRkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Rating", "Course Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AyCrRkScrlPnl.setViewportView(AyCrRkTable);

        FcRkLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        FcRkLbl.setForeground(new java.awt.Color(153, 153, 153));
        FcRkLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FcRkLbl.setText("Faculty Rating");

        CrRkLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CrRkLbl.setForeground(new java.awt.Color(153, 153, 153));
        CrRkLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CrRkLbl.setText("Course Rating");

        CrScMtrxLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        CrScMtrxLbl.setForeground(new java.awt.Color(153, 153, 153));
        CrScMtrxLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CrScMtrxLbl.setText("Carrer Success Metrics");

        CsMTxtArea.setColumns(20);
        CsMTxtArea.setRows(5);
        CsMScrPnl.setViewportView(CsMTxtArea);

        AyFkRkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Faculty Rating", "Faculty Name", "Faculty ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AyFkRkScrlPnl.setViewportView(AyFkRkTable);

        javax.swing.GroupLayout ShAyPnlLayout = new javax.swing.GroupLayout(ShAyPnl);
        ShAyPnl.setLayout(ShAyPnlLayout);
        ShAyPnlLayout.setHorizontalGroup(
            ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShAyPnlLayout.createSequentialGroup()
                .addGroup(ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ShAyPnlLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ShAyPnlLayout.createSequentialGroup()
                                .addComponent(FcRkLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(CrRkLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ShAyPnlLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CsMScrPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ShAyPnlLayout.createSequentialGroup()
                                        .addComponent(AyFkRkScrlPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(AyCrRkScrlPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(ShAyPnlLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(CrScMtrxLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ShAyPnlLayout.setVerticalGroup(
            ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShAyPnlLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FcRkLbl)
                    .addComponent(CrRkLbl))
                .addGap(29, 29, 29)
                .addGroup(ShAyPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AyFkRkScrlPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AyCrRkScrlPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(CrScMtrxLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CsMScrPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Analysis", ShAyPnl);

        FreeChartjPanel.setPreferredSize(new java.awt.Dimension(1029, 476));

        javax.swing.GroupLayout FreeChartjPanelLayout = new javax.swing.GroupLayout(FreeChartjPanel);
        FreeChartjPanel.setLayout(FreeChartjPanelLayout);
        FreeChartjPanelLayout.setHorizontalGroup(
            FreeChartjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1318, Short.MAX_VALUE)
        );
        FreeChartjPanelLayout.setVerticalGroup(
            FreeChartjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Performance", FreeChartjPanel);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Student GPA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnFeedback.setText("Send Feedback");
        btnFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmployerFeedbackjPanelLayout = new javax.swing.GroupLayout(EmployerFeedbackjPanel);
        EmployerFeedbackjPanel.setLayout(EmployerFeedbackjPanelLayout);
        EmployerFeedbackjPanelLayout.setHorizontalGroup(
            EmployerFeedbackjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployerFeedbackjPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFeedback)
                .addContainerGap(565, Short.MAX_VALUE))
        );
        EmployerFeedbackjPanelLayout.setVerticalGroup(
            EmployerFeedbackjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployerFeedbackjPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(EmployerFeedbackjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFeedback)
                    .addComponent(txtFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employer Feedback", EmployerFeedbackjPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(252, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(252, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 379, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 40, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:

        // jPanel1.setVisible(false);
        // jPanel2.setVisible(true);
        ArrayList<DepartmentModel> departmentlist = department.getDd();

        String enteredPassword = new String(PasswordField.getPassword());
        String adminPassword = "admin";

        //  String admin = "admin";
        String adStd = UsernameTextField.getText();

        if (adminPassword.equals(enteredPassword)) {
            //JOptionPane.showMessageDialog(this, "password ok");
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);

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
            jPanel2.setVisible(false);
            jPanel1.setVisible(true);
        }

        /*    System.out.println("Login pressed");
        EmployerDirectoryModel ed = td.getED();
        DepartmentDirectoryModel dd = td.getDd(); */
        //     for(DepartmentD)
//        ArrayList<Employers> em = td.getED().getEmployers();
//        
//        
//        for(EmployersModel e : em){
//            e.getRelevantcourses().get(0).getName();
//        }
        //  getReleventCourses();

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void btnFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFeedbackActionPerformed
    /* public List<Course> getReleventCourses(){
        
       
        DepartmentModel dept = td.getDd().getDd().get(0);
        DepartmentModel dept1 = td.getDd().getDd().get(1);

        List<Course> res1 = dept.getCourseCatalog().getCourseList();
        List<Course> res2 = dept1.getCourseCatalog().getCourseList();
        List<Course> res = Stream.concat(res1.stream(), res2.stream()).collect(Collectors.toList());
        System.out.println("SS "+ res.get(0).getCOurseNumber());
        return res;
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AyCrRkScrlPnl;
    private javax.swing.JTable AyCrRkTable;
    private javax.swing.JScrollPane AyFkRkScrlPnl;
    private javax.swing.JTable AyFkRkTable;
    private javax.swing.JLabel CrRkLbl;
    private javax.swing.JLabel CrScMtrxLbl;
    private javax.swing.JScrollPane CsMScrPnl;
    private javax.swing.JTextArea CsMTxtArea;
    private javax.swing.JPanel EmployerFeedbackjPanel;
    private javax.swing.JLabel FcRkLbl;
    private javax.swing.JPanel FreeChartjPanel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPanel PasswordLowerPanel;
    private javax.swing.JPanel ShAyPnl;
    private javax.swing.JPanel StudentLoginPanel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JPanel UsernameLowerPanel;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JButton btnFeedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFeedback;
    // End of variables declaration//GEN-END:variables

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

}
