package ui.Helper;

import Business.Person.Reviews;
import Business.Person.Helpers;
import Business.userAccount.Users;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prasanna
 */
public class ViewTestimonialJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Users usersAccount;
    /**
     * Creates new form ViewTestimonialJPanel
     */
    public ViewTestimonialJPanel(JPanel userProcessContainer, Users usersAccount) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.usersAccount = usersAccount;
        
        populateTestimonialsDynamically();
        populateTestimonialTable();
        viewTestimonialField.setVisible(false);
        testimonialHeadingLabel.setVisible(false);
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
    
    public void populateTestimonialsDynamically()
    {
        testimonialJPanel.removeAll();
        testimonialJPanel.revalidate();
       Helpers helpers = (Helpers) usersAccount.getPerson();
       JTextArea textArea;
       JTextField txtField;
       int count = 0;
       int pos = 0;
           
        for(Reviews reviews : helpers.getReviewList())
        {
            if(count<5)
            {
            
            txtField = new JTextField(reviews.getDate()+"Written By "+ reviews.getWriterName());
            txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            txtField.setEditable(false);
            txtField.setVisible(true);
            textArea = new JTextArea(reviews.getReviewTxt());
            textArea.setEditable(false);
            textArea.setVisible(true);
            count++;
             
            testimonialJPanel.setLayout(new GridLayout(10, 1,10,10));
            
            testimonialJPanel.add(txtField,pos);
            testimonialJPanel.add(textArea,++pos);
            ++pos;
            }
        }
        testimonialJPanel.revalidate();
        testimonialJPanel.setVisible(true);
       
    }
    
    public void populateTestimonialTable()
    {
     DefaultTableModel dtm = (DefaultTableModel)testimonialListJTable.getModel();
        dtm.setRowCount(0);
        
        Helpers helpers = (Helpers) usersAccount.getPerson();
        for(Reviews reviews : helpers.getReviewList())
        {
         Object[] rowData = new Object[5];
           rowData[0] = reviews;
           rowData[1] = reviews.getWriterName();
           
           dtm.addRow(rowData);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        testimonialListJTable = new javax.swing.JTable();
        manageEnt = new javax.swing.JLabel();
        manageEnt1 = new javax.swing.JLabel();
        testimonialJPanel = new javax.swing.JPanel();
        viewTestiBtn = new javax.swing.JButton();
        testimonialHeadingLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTestimonialField = new javax.swing.JTextArea();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 255, 102));

        testimonialListJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Testimonial Id", "Written By"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(testimonialListJTable);

        manageEnt.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        manageEnt.setText("View Reviews");

        manageEnt1.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        manageEnt1.setText("Health Hub");

        testimonialJPanel.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout testimonialJPanelLayout = new javax.swing.GroupLayout(testimonialJPanel);
        testimonialJPanel.setLayout(testimonialJPanelLayout);
        testimonialJPanelLayout.setHorizontalGroup(
            testimonialJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );
        testimonialJPanelLayout.setVerticalGroup(
            testimonialJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        viewTestiBtn.setBackground(new java.awt.Color(0, 153, 255));
        viewTestiBtn.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        viewTestiBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewTestiBtn.setText("View Testimonial");
        viewTestiBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewTestiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTestiBtnActionPerformed(evt);
            }
        });

        testimonialHeadingLabel.setText("jLabel1");

        viewTestimonialField.setEditable(false);
        viewTestimonialField.setColumns(20);
        viewTestimonialField.setRows(5);
        jScrollPane1.setViewportView(viewTestimonialField);

        backJButton.setBackground(new java.awt.Color(0, 153, 255));
        backJButton.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testimonialHeadingLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewTestiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(testimonialJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageEnt1)
                .addGap(304, 304, 304))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(manageEnt)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewTestiBtn)
                .addGap(28, 28, 28)
                .addComponent(testimonialHeadingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageEnt1)
                    .addComponent(backJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(testimonialJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewTestiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTestiBtnActionPerformed
        int selectedRow = testimonialListJTable.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(this, "Please select a row", "warning", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
         Reviews reviews = (Reviews)testimonialListJTable.getValueAt(selectedRow, 0);
         
         testimonialHeadingLabel.setText(reviews.getDate() + " written by "+ reviews.getWriterName() );
         viewTestimonialField.setText(reviews.getReviewTxt());
         testimonialHeadingLabel.setVisible(true);
         viewTestimonialField.setVisible(true);
        
    }//GEN-LAST:event_viewTestiBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel manageEnt;
    private javax.swing.JLabel manageEnt1;
    private javax.swing.JLabel testimonialHeadingLabel;
    private javax.swing.JPanel testimonialJPanel;
    private javax.swing.JTable testimonialListJTable;
    private javax.swing.JButton viewTestiBtn;
    private javax.swing.JTextArea viewTestimonialField;
    // End of variables declaration//GEN-END:variables
}