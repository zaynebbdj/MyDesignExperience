/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package designmyexperience;

import java.awt.Color;
import javax.swing.DefaultListModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author proza
 */
public class CustomerActivityPage extends javax.swing.JFrame {
    private User currentUser;
    private DefaultTableModel model;
    private int rowIndex;
    private HashMap<Integer, Integer> activityIdMap = new HashMap<>();
    
    /**
     * Creates new form ActivityPage
     */
    public CustomerActivityPage() {
        initComponents();
        UserMDE uD = new UserMDEImpl();
        currentUser = uD.getUser("Zaya369", "spaceX");
        init();
    }
    
    public CustomerActivityPage(User u) {
        this.currentUser = u;
        initComponents();
        init();
    }
    
    public void init() {
    pnlList.removeAll();
    pnlList.setLayout(new BoxLayout(pnlList, BoxLayout.Y_AXIS));

    ArrayList<Activity> activities = new ArrayList<>();
    try {
        String theme = cbTheme.getSelectedItem().toString();
        String feeString = cbFee.getSelectedItem().toString();
        ActivityMDE aMde = new ActivityMDEImpl();
        activities = aMde.getAllActivityThemeFee(theme, feeString);
        activityIdMap.clear();

        for (Activity a : activities) {
            String name = a.getName();
            System.out.println("Activité trouvée : " + name); // DEBUG

            JButton bouton = new JButton(name);
            
            // Ensure the button takes full width while maintaining a fixed height
            bouton.setPreferredSize(new Dimension(pnlList.getWidth(), 50));
            bouton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            bouton.setMinimumSize(new Dimension(pnlList.getWidth(), 50));
            bouton.setAlignmentX(Component.LEFT_ALIGNMENT); // Ensures proper alignment

            // ActionListener to open the activity page
            final Activity currentActivity = a;
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CustomerBookingActivityPage activityPage = new CustomerBookingActivityPage(currentUser, currentActivity);
                    activityPage.setVisible(true);
                    SwingUtilities.getWindowAncestor(bouton).dispose();

                }
            });

            pnlList.add(bouton);
            }

            // Adjust the panel's height dynamically based on the number of activities
            int panelHeight = activities.size() * 50;
            pnlList.setPreferredSize(new Dimension(pnlList.getWidth(), panelHeight));

            pnlList.revalidate();
            pnlList.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des activités.");
        }
    }
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> new CustomerActivityPage().setVisible(true));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTheme = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnValidFilter = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlList = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbFee = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("MyDesignExperience");

        jLabel2.setText("Theme :");

        cbTheme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "SPORT", "CINEMA", "CULTURE", "FOOD" }));
        cbTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbThemeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbThemeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbThemeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbThemeMouseReleased(evt);
            }
        });
        cbTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThemeActionPerformed(evt);
            }
        });

        btnHome.setText("Home Page");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnValidFilter.setBackground(new java.awt.Color(255, 102, 102));
        btnValidFilter.setText("Valid");
        btnValidFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidFilterActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logo.png"))); // NOI18N

        pnlList.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlList);

        jLabel5.setText("Fee : ");

        cbFee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "<10£", "[10£;20£]", "[20£;50£]", "[50£;100£]", ">100£" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(117, 117, 117))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46)
                                .addComponent(cbFee, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnValidFilter)))
                        .addGap(63, 63, 63)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnValidFilter)
                            .addComponent(jLabel5)
                            .addComponent(cbFee, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThemeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbThemeActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        MyLoginPage p = new MyLoginPage();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        CustomerHomePage c = new CustomerHomePage(currentUser);
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnValidFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidFilterActionPerformed
        // TODO add your handling code here:
        init();  
    }//GEN-LAST:event_btnValidFilterActionPerformed

    private void cbThemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbThemeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbThemeMouseClicked

    private void cbThemeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbThemeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbThemeMousePressed

    private void cbThemeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbThemeMouseReleased
        // TODO add your handling code here:
        init();
    }//GEN-LAST:event_cbThemeMouseReleased

    private void cbThemeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbThemeMouseExited
        // TODO add your handling code here:
        init();
    }//GEN-LAST:event_cbThemeMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnValidFilter;
    private javax.swing.JComboBox<String> cbFee;
    private javax.swing.JComboBox<String> cbTheme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlList;
    // End of variables declaration//GEN-END:variables
}
