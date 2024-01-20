
package ui.SystemAdmin;

import Business.NetworkHelp;
import Business.Enterprises.Enterprise;
import Business.Networks.Network;
import Business.Organizations.Org;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author prasanna
 */
public class SysAdminWorkArea extends javax.swing.JPanel {

    JPanel userProcessContainer;
    NetworkHelp system;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public SysAdminWorkArea(JPanel userProcessContainer, NetworkHelp system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

//        populatenetworkJTree();
//        setBackground(new Color(153,197,85));
      
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
//        Color c2 = Color.white;
     
        GradientPaint gp = new GradientPaint(w/4, 0, c2, w/4, h, c1);
        setOpaque( false );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        setOpaque( true );
    }

    public void populatenetworkJTree() {
        
//        DefaultTreeModel model = (DefaultTreeModel) networkJTree.getModel();
        ArrayList<Network> networkList = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Org> orgList;
        Network network;
        Enterprise enterprise;
        Org org;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Network");
//        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
//        root.removeAllChildren();
//        root.insert(networks, 0);

        
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
       
         DefaultMutableTreeNode cityNode;
      
        
       for (int i = 0; i < networkList.size(); i++) {
            
            network = networkList.get(i);
            cityNode = new DefaultMutableTreeNode(network.getCity());
            networks.insert(cityNode, i);
            
        
            enterpriseList = network.getEnterprisesDirectory().getEnterprisesList();

            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                cityNode.insert(enterpriseNode, j);

                orgList = enterprise.getOrganizationsDirectory().getOrganizationsList();
                for (int k = 0; k < orgList.size(); k++) {
                    org = orgList.get(k);
                    organizationNode = new DefaultMutableTreeNode(org.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
          
        }

//        model.reload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        manageNetworkJButton = new javax.swing.JButton();
        manageAdminJButton = new javax.swing.JButton();
        manageEnterpriseJButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        helpOfferedButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 0));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        manageNetworkJButton.setBackground(new java.awt.Color(0, 153, 255));
        manageNetworkJButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        manageNetworkJButton.setText("Manage Network");
        manageNetworkJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButtonActionPerformed(evt);
            }
        });

        manageAdminJButton.setBackground(new java.awt.Color(0, 153, 255));
        manageAdminJButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        manageAdminJButton.setText("Manage Enterprise Admin");
        manageAdminJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAdminJButtonActionPerformed(evt);
            }
        });

        manageEnterpriseJButton.setBackground(new java.awt.Color(0, 153, 255));
        manageEnterpriseJButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        manageEnterpriseJButton.setText("Manage Enterprise");
        manageEnterpriseJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        manageEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseJButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans", 1, 36)); // NOI18N
        jLabel7.setText("System Admin Work Area");

        helpOfferedButton.setBackground(new java.awt.Color(0, 153, 255));
        helpOfferedButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        helpOfferedButton.setText("Create GetHelp Offered ");
        helpOfferedButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        helpOfferedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpOfferedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(helpOfferedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageAdminJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageNetworkJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageEnterpriseJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageEnterpriseJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpOfferedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageAdminJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageNetworkJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(185, 185, 185))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void manageEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseJButtonActionPerformed

        ManageEnterprises manageEnterpriseJPanel = new ManageEnterprises(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseJButtonActionPerformed

    private void manageAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAdminJButtonActionPerformed
        // TODO add your handling code here:
        ManageEnterpriseAdmin manageEnterpriseAdmin = new ManageEnterpriseAdmin(userProcessContainer, system);
        userProcessContainer.add("manageEnterpriseAdmin", manageEnterpriseAdmin);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageAdminJButtonActionPerformed

    private void manageNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButtonActionPerformed
        ManageNetwork manageNetworkJPanel = new ManageNetwork(userProcessContainer, system);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButtonActionPerformed

    private void helpOfferedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpOfferedButtonActionPerformed
        CreateHelpJPanel createHelpJPanel = new CreateHelpJPanel(userProcessContainer, system);
        userProcessContainer.add("CreateHelpJPanel", createHelpJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_helpOfferedButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton helpOfferedButton;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton manageAdminJButton;
    private javax.swing.JButton manageEnterpriseJButton;
    private javax.swing.JButton manageNetworkJButton;
    // End of variables declaration//GEN-END:variables
}