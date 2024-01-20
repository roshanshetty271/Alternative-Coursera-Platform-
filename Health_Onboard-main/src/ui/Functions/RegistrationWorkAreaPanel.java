package ui.Functions;

import Business.NetworkHelp;
import Business.Functions.NotificationText;
import Business.Functions.DateValidation;
import Business.Functions.MailValidation;
import Business.Functions.IntegerValidation;
import Business.Functions.PasswordValidation;
import Business.Functions.ContactValidation;
import Business.Functions.RegexValidation;
import Business.Functions.SysValidations;
import Business.Enterprises.Enterprise;
import Business.Enterprises.HealthHubEnterprise;
import Business.Enterprises.HospitalEnterprise;
import Business.Enterprises.UnivEnterprise;
import Business.Networks.Network;
import Business.Organizations.*;
import Business.Organizations.Org;
import Business.Person.Helpers;
import Business.Person.Patient;
import Business.Person.Person;
import Business.Person.PersonCatalog;
import Business.RequestFramework.ManagerRequestFrameworkFramework;
import Business.RolesDirectory.DoctorsRole;
import Business.RolesDirectory.PatientRole;
import Business.RolesDirectory.HelpersRole;
import Business.userAccount.Users;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author aayush
 */
public class RegistrationWorkAreaPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private PersonCatalog personCatalog;
    private NetworkHelp ecoSystem;
    private Enterprise enterprise;
    private Org org;
    
    /**
     * Creates new form RegistrationWorkAreaPanel
     */
    public RegistrationWorkAreaPanel(JPanel userProcessContainer, NetworkHelp ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       this.ecoSystem = ecoSystem;
       
       helpSeekerPane.setVisible(false);
         
        addInputVerifiers();
        
        populateCountryComboBox();
        volNetworkCombo.setVisible(false);
        volNetwork.setVisible(false);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        
        Color c1 = new Color(210,240,114);
         Color c2 = new Color(210,240,114);
     
        GradientPaint gp = new GradientPaint(w/4, 0, c2, w/4, h, c1);
        setOpaque( false );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        setOpaque( true );
    }
    
      private void addInputVerifiers() {
          
        InputVerifier stringValidation = new RegexValidation();
        firstNameField.setInputVerifier(stringValidation);
        lastNameField.setInputVerifier(stringValidation);
        addressField1.setInputVerifier(stringValidation);
        addressField2.setInputVerifier(stringValidation);
        townField.setInputVerifier(stringValidation);
        occupationField.setInputVerifier(stringValidation);
        addressField1.setInputVerifier(stringValidation);
        addressField2.setInputVerifier(stringValidation);
        userNameJTxtField.setInputVerifier(stringValidation);
        
        
        InputVerifier passwordValidation = new PasswordValidation();
        passwordField.setInputVerifier(passwordValidation);
        confirmPasswordField.setInputVerifier(passwordValidation);
        
        InputVerifier dobValidtion = new DateValidation();
        DobField.setInputVerifier(dobValidtion);
        
        InputVerifier numberValidation = new IntegerValidation();
        zipCodeField.setInputVerifier(numberValidation);
        
        InputVerifier emailValidtion = new MailValidation();
        emailIDField.setInputVerifier(emailValidtion);
     
         InputVerifier phnumberValidation = new ContactValidation();
        phoneNumberField.setInputVerifier(phnumberValidation);
      
    }
    
    private void populateCountryComboBox(){
        countryComboBox.removeAllItems();
         if(ecoSystem.getNetworkList().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Network does not exist! Please create new Network.");
         return;        
        }
        countryComboBox.addItem("Please select a country");
        String networkVal = "";   
        HashSet<String> hs = new HashSet();
           
        for(Network network : ecoSystem.getNetworkList()){
           if(!network.getCountry().equals(networkVal))
           {
               hs.add(network.getCountry());
           }
        }
        for(String s : hs)
        {
         countryComboBox.addItem(s);
        }
        }
    
         private void populateNetworkComboBox()
         {
        
        helpSeekerNetworkCombo.removeAllItems();
         if(ecoSystem.getNetworkList().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Network does not exist! Sorry for inconvenience.");
         return;        
        }
        helpSeekerNetworkCombo.addItem("Please select a Network");
           
        for(Network network : ecoSystem.getNetworkList()){
             helpSeekerNetworkCombo.addItem(network);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        addressField2 = new javax.swing.JTextField();
        DobField = new javax.swing.JFormattedTextField();
        addressField1 = new javax.swing.JTextField();
        emailID1 = new javax.swing.JLabel();
        town = new javax.swing.JLabel();
        emailIDField1 = new javax.swing.JTextField();
        townField = new javax.swing.JTextField();
        zipCode = new javax.swing.JLabel();
        zipCodeField = new javax.swing.JTextField();
        occupation = new javax.swing.JLabel();
        occupationField = new javax.swing.JTextField();
        emailID = new javax.swing.JLabel();
        emailIDField = new javax.swing.JTextField();
        firstName = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        createProfileButton = new javax.swing.JButton();
        LastName = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        address2 = new javax.swing.JLabel();
        dateOfBirth = new javax.swing.JLabel();
        address1 = new javax.swing.JLabel();
        isHelpSeeker = new javax.swing.JRadioButton();
        isHelper = new javax.swing.JRadioButton();
        helpSeekerPane = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        userNameJTxtField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        helpSeekerNw = new javax.swing.JLabel();
        helpSeekerNetworkCombo = new javax.swing.JComboBox();
        manageEnt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox();
        isDoctorRadioBtn = new javax.swing.JRadioButton();
        volNetwork = new javax.swing.JLabel();
        volNetworkCombo = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(0, 204, 255));

        emailID1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        emailID1.setText("Confirm Email Address:");

        town.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        town.setText("Town/City: ");

        zipCode.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        zipCode.setText("Zip Code:");

        occupation.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        occupation.setText("Occupation:");

        emailID.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        emailID.setText("Email Address:");

        firstName.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        firstName.setText("First Name:");

        phoneNumber.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        phoneNumber.setText("Phone Number:");

        phoneNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberFieldActionPerformed(evt);
            }
        });

        createProfileButton.setBackground(new java.awt.Color(0, 153, 153));
        createProfileButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        createProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        createProfileButton.setText("Register");
        createProfileButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProfileButtonActionPerformed(evt);
            }
        });

        LastName.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        LastName.setText("Last Name:");

        address2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        address2.setText("Address Line2 : ");

        dateOfBirth.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        dateOfBirth.setText("Date Of Birth");

        address1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        address1.setText("Address Line1 : ");

        buttonGroup1.add(isHelpSeeker);
        isHelpSeeker.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        isHelpSeeker.setText("I'm a Patient");
        isHelpSeeker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isHelpSeekerActionPerformed(evt);
            }
        });

        buttonGroup1.add(isHelper);
        isHelper.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        isHelper.setText("I am a Volunteer");
        isHelper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isHelperActionPerformed(evt);
            }
        });

        helpSeekerPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel7.setText("Create User Account:");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel2.setText("Username :");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setText("Password :");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setText("Confirm Password :");

        helpSeekerNw.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        helpSeekerNw.setText("City :");

        helpSeekerNetworkCombo.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        helpSeekerNetworkCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpSeekerNetworkComboActionPerformed(evt);
            }
        });

        helpSeekerPane.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(passwordField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(userNameJTxtField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(confirmPasswordField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(helpSeekerNw, javax.swing.JLayeredPane.DEFAULT_LAYER);
        helpSeekerPane.setLayer(helpSeekerNetworkCombo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout helpSeekerPaneLayout = new javax.swing.GroupLayout(helpSeekerPane);
        helpSeekerPane.setLayout(helpSeekerPaneLayout);
        helpSeekerPaneLayout.setHorizontalGroup(
            helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                        .addComponent(helpSeekerNw)
                        .addGap(24, 24, 24)
                        .addComponent(helpSeekerNetworkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpSeekerPaneLayout.createSequentialGroup()
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpSeekerPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(userNameJTxtField))
                .addGap(197, 197, 197))
        );
        helpSeekerPaneLayout.setVerticalGroup(
            helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helpSeekerPaneLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(40, 40, 40)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userNameJTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(helpSeekerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(helpSeekerNw)
                    .addComponent(helpSeekerNetworkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        manageEnt.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        manageEnt.setText("Start Your Journey With HealthHub");

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("Gender:");

        genderComboBox.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose gender", "Female", "Male", "Transgender", "Unknown" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel3.setText("Country:");

        countryComboBox.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel6.setText("State:");

        stateComboBox.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });

        buttonGroup1.add(isDoctorRadioBtn);
        isDoctorRadioBtn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        isDoctorRadioBtn.setText("I am a Doctor");
        isDoctorRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isDoctorRadioBtnActionPerformed(evt);
            }
        });

        volNetwork.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        volNetwork.setText(" City");

        volNetworkCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volNetworkComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(manageEnt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(createProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(isDoctorRadioBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isHelpSeeker)
                    .addComponent(isHelper))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(LastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel3))
                                        .addGap(80, 80, 80))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(volNetwork)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DobField)
                                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(volNetworkCombo, 0, 182, Short.MAX_VALUE)
                                            .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lastNameField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(546, 546, 546)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(town)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(townField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(phoneNumber)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(emailID, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailIDField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(address1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addressField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(address2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addressField2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(emailID1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailIDField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(zipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(zipCodeField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(occupation)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(occupationField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(409, 409, 409))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(helpSeekerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DobField, addressField1, addressField2, countryComboBox, emailIDField, emailIDField1, firstNameField, genderComboBox, lastNameField, occupationField, phoneNumberField, stateComboBox, townField, volNetworkCombo, zipCodeField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(manageEnt)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(isDoctorRadioBtn)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstName)
                                    .addComponent(isHelper))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LastName)
                                    .addComponent(isHelpSeeker)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateOfBirth))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(stateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(volNetwork)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(createProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(emailID)
                                            .addComponent(emailIDField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(emailID1)
                                            .addComponent(emailIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(volNetworkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(genderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address1)
                            .addComponent(addressField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(address2)
                            .addComponent(addressField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(town)
                            .addComponent(townField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(zipCode)
                            .addComponent(zipCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(occupation)
                            .addComponent(occupationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneNumber)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(helpSeekerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DobField, addressField1, addressField2, countryComboBox, emailIDField, emailIDField1, firstNameField, lastNameField, occupationField, stateComboBox, townField, volNetworkCombo, zipCodeField});

    }// </editor-fold>//GEN-END:initComponents

    private void createProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProfileButtonActionPerformed

        try
        {
         if(countryComboBox.getSelectedIndex()<1 || stateComboBox.getSelectedIndex()<1)
         {
        JOptionPane.showMessageDialog(null, "Please Enter valid data for country and state ","warning", JOptionPane.WARNING_MESSAGE);
              return;             
         }
         if(genderComboBox.getSelectedIndex()<1 )
         {
        JOptionPane.showMessageDialog(null, "Please Enter valid gender ","warning", JOptionPane.WARNING_MESSAGE);
              return;             
         }
         
         Date dateOfBirthVal = new SimpleDateFormat("MM/dd/yyyy").parse(DobField.getText()) ;
            // Calculate age using dob
            int age = SysValidations.ageCalculation(dateOfBirthVal);
            
            String phoneNumber = phoneNumberField.getText();
            String firstName =   firstNameField.getText();
            String lastName = lastNameField.getText();
            String address1 = addressField1.getText();
            String address2 = addressField2.getText();
            String town = townField.getText();
            String zipCode = zipCodeField.getText();
            String emailId = emailIDField.getText();
            String confirmEmail = emailIDField1.getText();
            String occupation = occupationField.getText();
            String gender = (String)genderComboBox.getSelectedItem();
            String country = (String)countryComboBox.getSelectedItem();
            String state = (String)stateComboBox.getSelectedItem();
            
            if(firstName != null && !firstName.isEmpty() &&
                lastName!= null && !lastName.isEmpty() &&
                address1!=null && !address1.isEmpty() &&
                    address2!=null && !address2.isEmpty() &&
                town!=null && !town.isEmpty() &&
                occupation!=null && !occupation.isEmpty() &&
                emailId!=null && !emailId.isEmpty() &&
                confirmEmail!=null && !confirmEmail.isEmpty() &&
                zipCode != null && !zipCode.isEmpty() &&
                gender!=null && !gender.isEmpty() && age > 0 && !phoneNumber.isEmpty()
                    &&  country!=null && !country.isEmpty() 
                    &&  state!=null && !state.isEmpty() 
           )
            {
                if(buttonGroup1.getSelection()==null)
                {
             JOptionPane.showMessageDialog(null, "Please select radio button to know if you are a Helper, a Doctor or need help ","warning", JOptionPane.WARNING_MESSAGE);
              return;       
                }

                if(!(confirmEmail.equals(emailId)))
                {
                    JOptionPane.showMessageDialog(null, "Email does not match. Please Enter valid email id","warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
          
                  Person person = null;
              if(isHelpSeeker.isSelected())
                {
                 if(passwordField.getPassword().length ==0 || confirmPasswordField.getPassword().length == 0 ||
                        userNameJTxtField.getText().trim().isEmpty() || helpSeekerNetworkCombo.getSelectedIndex()<1
                            )
                    {
                        JOptionPane.showMessageDialog(null, " Please Enter data in all fields","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
               
                 
                  if(helpSeekerNetworkCombo.getSelectedIndex()<1)
                    {
                    JOptionPane.showMessageDialog(null, "Please choose a closest city","warning", JOptionPane.WARNING_MESSAGE);
                    return;     
                    }
                  if(age<50 || age==0 || age > 120)
                  {
                 JOptionPane.showMessageDialog(null, "Your age does not qualify as help seeker","warning", JOptionPane.WARNING_MESSAGE);
                    return;      
                  }
                    String userName = userNameJTxtField.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    String confirmPassword =String.valueOf(confirmPasswordField.getPassword());
               
                    Network caseNw = (Network)helpSeekerNetworkCombo.getSelectedItem();
                      if(!(password.equals(confirmPassword)))
                    {
                        JOptionPane.showMessageDialog(null, "Password does not match, Please Enter valid a Password","warning", JOptionPane.WARNING_MESSAGE);
                        org.getPersonDirectory().getCustomerLsit().remove(person);
                        return;
                    }
                    
                    getEnterprise(caseNw);
                     if(enterprise == null)
                    {
                  JOptionPane.showMessageDialog(null, "Enterprise does not exist for the Network! "+caseNw.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                   return;      
                    } 
                    getOrganization("Patient", enterprise);
                    
                    if(org == null)
                    {
                  JOptionPane.showMessageDialog(null, "HelpSeeker Organization does not exist for the enterprise! "+ enterprise.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                   return;      
                    } 
                    
                    person = org.getPersonDirectory().addCustomer();
                    person.setPatient(true);
 
                    for(Enterprise e : caseNw.getEnterprisesDirectory().getEnterprisesList())
                    {
                     for(Users  user : e.getUserDirectory().getUserList())
                    {
                        if( user.getName().equals(userName))
                        {
                         JOptionPane.showMessageDialog(null, "Users Name already exist! Please Enter valid users name.","warning", JOptionPane.WARNING_MESSAGE);
                         return;  
                        }
                        else
                        {
                        for(Org o : e.getOrganizationsDirectory().getOrganizationsList())
                        {  
                         for(Users  user1 : o.getUserDirectory().getUserList())
                            {  
                            if( user1.getName().equals(userName))
                            {
                             JOptionPane.showMessageDialog(null, "Users Name already exist! Please Enter valid users name.","warning", JOptionPane.WARNING_MESSAGE);
                             return;  
                            }   
                            } 
                        }
                        }
                    }
                    }
                    if(!org.getUserDirectory().checkUniqueName(userName))
                    {
                        JOptionPane.showMessageDialog(null, "Users Name already exist! Please Enter valid users name.","warning", JOptionPane.WARNING_MESSAGE);
                        org.getPersonDirectory().getCustomerLsit().remove((Patient)person);
                        return;
                    }
                    // To get help seeker org
                    
                    Users users = org.getUserDirectory().addUser(userName, password, person, new PatientRole());
                    users.setPerson(person);
                   users.setNetwork((Network)caseNw);
                  
                    // Send Req to Supervisor for approval       
                    ManagerRequestFrameworkFramework request = new ManagerRequestFrameworkFramework();
                    request.setReqMessage(ManagerRequestFrameworkFramework.REQUEST_APPROVAL);
                    request.setSenderDetails(users);
                    request.setStatus(ManagerRequestFrameworkFramework.REQUEST_SENT);
                    request.setRequestDate(new Date());
                    
                   // For Supervisor  
                  for(Enterprise e : caseNw.getEnterprisesDirectory().getEnterprisesList())
                  {
                      if(e instanceof HealthHubEnterprise)
                      {
                       for(Org org : e.getOrganizationsDirectory().getOrganizationsList())
                       {
                      if (org instanceof ManagerOrg){
                                this.org = org;
                                this.personCatalog = org.getPersonDirectory();
                      }
                      }
                      
                      }
                  }
                  
                    if (org !=null){
                        org.getRequestPipeline().getRequestList().add(request);
                        users.getRequestPipeline().getRequestList().add(request);
                        users.setEnabled(false);
                    }
                }
                else if(isHelper.isSelected())
                {
                    if(age<10 || age==0 || age>45)
                  {
                 JOptionPane.showMessageDialog(null, "Your age does not q userlify as Helpers","warning", JOptionPane.WARNING_MESSAGE);
                    return;      
                  }
                    if(volNetworkCombo.getSelectedIndex()<1)
                    {
                    JOptionPane.showMessageDialog(null, "Please choose a closest city","warning", JOptionPane.WARNING_MESSAGE);
                    return;     
                    }
                     Network volnetwork = (Network)volNetworkCombo.getSelectedItem();
                    getEnterprise(volnetwork);
                    
                    if(enterprise ==null)
                    {
                   JOptionPane.showMessageDialog(null, "Enterprise does not exist for the Network! " + volnetwork.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                   return;      
                    }
                    getOrganization("Helpers", enterprise);
                  if(org ==null)
                    {
                   JOptionPane.showMessageDialog(null, "Helpers Organization does not exist for the enterprise! " + enterprise.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                   return;      
                    }
                  
                  person = org.getPersonDirectory().addHelper();
                  person.setHelper(true);
               
                   String userName = NotificationText.generateUserName(lastNameField.getText());
                    if(!org.getUserDirectory().checkUniqueName(userName))
                    {
                        userName = NotificationText.generateUserName(lastNameField.getText());
                    }
                    String password = NotificationText.generateUserPassword(firstNameField.getText());
                    String emailMsg = buildEmailTxtMsg(userName, password);
                    
                    boolean emailSent = NotificationText.sendMailNotification(emailMsg, emailIDField.getText(),userName, password);
                    if(!emailSent)
                    {
                    JOptionPane.showMessageDialog(null, "Please Enter a valid Email address! ","warning", JOptionPane.WARNING_MESSAGE);
                    org.getPersonDirectory().getHelperList().remove((Helpers)person);
                    return;         
                    }
                   
                    Users users = org.getUserDirectory().addUser(userName,password, person, new HelpersRole());
                    users.setPerson(person);
                    users.setNetwork(volnetwork);
                    
                    ManagerRequestFrameworkFramework request = new ManagerRequestFrameworkFramework();
                    request.setReqMessage(ManagerRequestFrameworkFramework.REQUEST_APPROVAL);
                    request.setSenderDetails(users);
                    request.setStatus(ManagerRequestFrameworkFramework.REQUEST_SENT);
                    request.setRequestDate(new Date());
                    
                   // For Supervisor  
                  for(Enterprise e : volnetwork.getEnterprisesDirectory().getEnterprisesList())
                  {
                      if(e instanceof HealthHubEnterprise)
                      {
                       for(Org org : e.getOrganizationsDirectory().getOrganizationsList())
                       {
                      if (org instanceof ManagerOrg){
                                this.org = org;
                                this.personCatalog = org.getPersonDirectory();
                      }
                      }
                      
                      }
                  }
                  
                    if (org !=null){
                        org.getRequestPipeline().getRequestList().add(request);
                        users.getRequestPipeline().getRequestList().add(request);
                        users.setEnabled(false);
                    }
                }
                if(isDoctorRadioBtn.isSelected() )
                {
                  if(age<20 || age==0)
                  {
                 JOptionPane.showMessageDialog(null, "Your age does not q userlify as Dcotor","warning", JOptionPane.WARNING_MESSAGE);
                    return;      
                  }
                     if(passwordField.getPassword().length ==0 || confirmPasswordField.getPassword().length == 0 ||
                        userNameJTxtField.getText().trim().isEmpty() || helpSeekerNetworkCombo.getSelectedIndex()<1
                           )
                    {
                        JOptionPane.showMessageDialog(null, " Please Enter data in all fields","warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                     String userName = userNameJTxtField.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    String confirmPassword =String.valueOf(confirmPasswordField.getPassword());
                   
                    Network docNw = (Network)helpSeekerNetworkCombo.getSelectedItem();
                    
                    
                     if(!(password.equals(confirmPassword)))
                    {
                        JOptionPane.showMessageDialog(null, "Password does not match. Please Enter valid Password","warning", JOptionPane.WARNING_MESSAGE);
                        org.getPersonDirectory().getPersonList().remove(person);
                        return;
                    }
                    
                    getEnterprise(docNw);
                    if(enterprise ==null)
                    {
                     JOptionPane.showMessageDialog(null, "Enterprise does not exist for the Network! "+docNw.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                     return;      
                    } 
                    getOrganization("Doctor", enterprise);
                    if(org ==null)
                    {
                     JOptionPane.showMessageDialog(null, "Doctor Organization does not exist for the enterprise! "+ enterprise.getName(),"warning", JOptionPane.WARNING_MESSAGE);
                     return;      
                    } 
                  person = org.getPersonDirectory().addPerson();
                   
                    for(Enterprise e : docNw.getEnterprisesDirectory().getEnterprisesList())
                    {
                     for(Users  user : e.getUserDirectory().getUserList())
                    {
                        if( user.getName().equals(userName))
                        {
                         JOptionPane.showMessageDialog(null, "Users Name already exists! Please Enter valid users name","warning", JOptionPane.WARNING_MESSAGE);
                         return;  
                        }
                        else
                        {
                        for(Org o : e.getOrganizationsDirectory().getOrganizationsList())
                        {  
                         for(Users  user1 : o.getUserDirectory().getUserList())
                            {  
                            if( user1.getName().equals(userName))
                            {
                             JOptionPane.showMessageDialog(null, "Users Name already exists! Please Enter valid users name","warning", JOptionPane.WARNING_MESSAGE);
                             return;  
                            }   
                            } 
                        }
                        }
                    }
                    }
                    if(!org.getUserDirectory().checkUniqueName(userName))
                    {
                        JOptionPane.showMessageDialog(null, "Users Name already exists! Please Enter valid users name","warning", JOptionPane.WARNING_MESSAGE);
                        org.getPersonDirectory().getPersonList().remove(person);
                        return;
                    }
                    // To get Doctor org
                    
                    Users users = org.getUserDirectory().addUser(userName, password, person, new DoctorsRole());
                    users.setPerson(person);
                    users.setNetwork(docNw);
                  
                // RequestFramework to Supervisor
                    ManagerRequestFrameworkFramework request = new ManagerRequestFrameworkFramework();
                    request.setReqMessage(ManagerRequestFrameworkFramework.REQUEST_APPROVAL);
                    request.setSenderDetails(users);
                    request.setStatus(ManagerRequestFrameworkFramework.REQUEST_SENT);
                    request.setRequestDate(new Date());
                    
                     // For Supervisor  
                  for(Enterprise e : docNw.getEnterprisesDirectory().getEnterprisesList())
                  {
                      if(e instanceof HealthHubEnterprise)
                      {
                       for(Org org : e.getOrganizationsDirectory().getOrganizationsList())
                       {
                      if (org instanceof ManagerOrg){
                                this.org = org;
                                this.personCatalog = org.getPersonDirectory();
                      }
                      }
                      
                      }
                  }
                     if (org !=null){
                        org.getRequestPipeline().getRequestList().add(request);
                        users.getRequestPipeline().getRequestList().add(request);
                       users.setEnabled(false);
                    }
                }
                
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setAddress2(address2);
                person.setAddress1(address1);
                person.setTown(town);
                person.setZipCode(zipCode);
                person.setOccupation(occupation);
                person.setEmailId(emailId);
                person.setDob(dateOfBirthVal);
                person.setPhoneNumber(phoneNumber);
                person.setGender(gender);
                person.setCountry(country);
                person.setState(state);
                person.setName();
                person.setAge(age);
                
               
                JOptionPane.showMessageDialog(null, "Your Profile has been created successfully", "success", JOptionPane.PLAIN_MESSAGE);
                resetFields();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please Enter valid data in all the fields");
            }
        }
        
        catch(NumberFormatException npe)
        {
            JOptionPane.showMessageDialog(null, "Please Enter valid Number ! ");
        return;
        }
        catch(ParseException npe)
        {
            JOptionPane.showMessageDialog(null, "Please Enter data in all the fields");
           return;
        }
        catch(NullPointerException e )
        {
        JOptionPane.showMessageDialog(null, "Organization does not exist! ");  
          return;
        }
        catch(Exception e )
        {
        JOptionPane.showMessageDialog(null, "Please Enter data in all the fields");  
          return;
        }
    }//GEN-LAST:event_createProfileButtonActionPerformed
    public void resetFields()
    {
     userNameJTxtField.setText("");
     passwordField.setText("");
     confirmPasswordField.setText("");
    firstNameField.setText("");
    lastNameField.setText("");
    DobField.setText("");
    addressField1.setText("");
    addressField2.setText("");
    townField.setText("");
    zipCodeField.setText("");
    occupationField.setText("");
    emailIDField.setText("");
    emailIDField1.setText("");
    phoneNumberField.setText("");
    isHelpSeeker.setSelected(false);
    isHelper.setSelected(false);
    isDoctorRadioBtn.setSelected(false);
     
    }
    
    public void getEnterprise(Network network)
    {
          try
                {
                 for (Network n : ecoSystem.getNetworkList())
                    {
                    if(n.getCity().equals(network.getCity()))
                    {  
                   for(Enterprise e : n.getEnterprisesDirectory().getEnterprisesList())
                      {
                           if(e instanceof UnivEnterprise && isHelper.isSelected())
                           {
                             this.enterprise = e;
                             network = n;
                            }
                           else if(e instanceof HealthHubEnterprise && isHelpSeeker.isSelected())
                           {
                             this.enterprise = e;
                              network = n;
                            }
                            else if(e instanceof HospitalEnterprise && isDoctorRadioBtn.isSelected())
                           {
                             this.enterprise = e;
                              network = n;
                           }
                      }
                    }
                    }
                }
                catch(Exception e)
                {
                 JOptionPane.showMessageDialog(null, "Please create Enterprise","warning", JOptionPane.WARNING_MESSAGE);
                    return;    
                }
    }
    
    public String buildEmailTxtMsg(String usrNm, String pwd)
    {
      StringBuilder emailMsgTxt = new StringBuilder();
        emailMsgTxt.append("Your account has been created and awaiting approval from Manager. Please find username and password to login into our application.");
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append("username : ".concat(usrNm));
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append("password : ".concat(pwd));
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append("Thank You,");
        emailMsgTxt.append(System.lineSeparator());
        emailMsgTxt.append(" HealthHub");
        
        return emailMsgTxt.toString();
    }
    
    public void getOrganization(String orgVal, Enterprise e){
     
        try
        {
     for (Org organization : e.getOrganizationsDirectory().getOrganizationsList()){
      
       if(orgVal.equals("Helpers") && organization instanceof HelperOrg)
        {
              this.org = organization;
              this.personCatalog = organization.getPersonDirectory();
        
        }     
     else if(orgVal.equals("Patient") && organization instanceof PatientOrg)
             {
               this.org = organization;
               this.personCatalog = organization.getPersonDirectory();
             }  
       
       else if(orgVal.equals("Doctor") && organization instanceof DoctorOrg)
             {
               this.org = organization;
               this.personCatalog = organization.getPersonDirectory();
             } 
             }
        }
        catch(Exception ex)
        {
         return;     
        }
    }
    

    private void isHelpSeekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isHelpSeekerActionPerformed

        helpSeekerPane.setVisible(true);
        volNetworkCombo.setVisible(false);
        volNetwork.setVisible(false);
        populateNetworkComboBox();
        
    }//GEN-LAST:event_isHelpSeekerActionPerformed
    
    
    private void populateVolNetworkComboBox()
         {
         volNetworkCombo.removeAllItems();
         if(ecoSystem.getNetworkList().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Network does not exist! Sorry for inconvenience.");
         return;        
        }
        volNetworkCombo.addItem("Please select a Network");
           
        for(Network network : ecoSystem.getNetworkList()){
             volNetworkCombo.addItem(network);
         }

        }
    
    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        
        stateComboBox.removeAllItems();
       
        
      if(countryComboBox.getSelectedIndex()>0)
      {
          stateComboBox.addItem("Please select a State");
         HashSet<String> hsstateVal = new HashSet<>();
        for (Network network : ecoSystem.getNetworkList())
        {
          if(network.getCountry().equals(countryComboBox.getSelectedItem()))
          {
           hsstateVal.add(network.getState());
          }
        }
        for(String s1 : hsstateVal)
        {
        stateComboBox.addItem(s1);
        }
       }
         
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed

    }//GEN-LAST:event_stateComboBoxActionPerformed

    private void helpSeekerNetworkComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpSeekerNetworkComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpSeekerNetworkComboActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void isDoctorRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isDoctorRadioBtnActionPerformed
       helpSeekerPane.setVisible(true);
       volNetworkCombo.setVisible(false);
        volNetwork.setVisible(false);
        populateNetworkComboBox();
    }//GEN-LAST:event_isDoctorRadioBtnActionPerformed

    private void phoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberFieldActionPerformed

    private void volNetworkComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volNetworkComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volNetworkComboActionPerformed

    private void isHelperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isHelperActionPerformed
        helpSeekerPane.setVisible(false);
        volNetworkCombo.setVisible(true);
        volNetwork.setVisible(true);
        populateVolNetworkComboBox();
    }//GEN-LAST:event_isHelperActionPerformed
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField DobField;
    private javax.swing.JLabel LastName;
    private javax.swing.JLabel address1;
    private javax.swing.JLabel address2;
    private javax.swing.JTextField addressField1;
    private javax.swing.JTextField addressField2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JComboBox countryComboBox;
    private javax.swing.JButton createProfileButton;
    private javax.swing.JLabel dateOfBirth;
    private javax.swing.JLabel emailID;
    private javax.swing.JLabel emailID1;
    private javax.swing.JTextField emailIDField;
    private javax.swing.JTextField emailIDField1;
    private javax.swing.JLabel firstName;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JComboBox genderComboBox;
    private javax.swing.JComboBox helpSeekerNetworkCombo;
    private javax.swing.JLabel helpSeekerNw;
    private javax.swing.JLayeredPane helpSeekerPane;
    private javax.swing.JRadioButton isDoctorRadioBtn;
    private javax.swing.JRadioButton isHelpSeeker;
    private javax.swing.JRadioButton isHelper;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel manageEnt;
    private javax.swing.JLabel occupation;
    private javax.swing.JTextField occupationField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JLabel town;
    private javax.swing.JTextField townField;
    private javax.swing.JTextField userNameJTxtField;
    private javax.swing.JLabel volNetwork;
    private javax.swing.JComboBox volNetworkCombo;
    private javax.swing.JLabel zipCode;
    private javax.swing.JTextField zipCodeField;
    // End of variables declaration//GEN-END:variables
}
