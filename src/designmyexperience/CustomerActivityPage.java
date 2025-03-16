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
    public void init(){
        tableActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Fee", "Address", "duration"
            }
        ));
        tableViewActivity();
    }
    public void tableViewActivity(){
        getActivityValue();
        model = (DefaultTableModel) tableActivity.getModel();
        tableActivity.setRowHeight(30);
        tableActivity.setShowGrid(true);
        tableActivity.setGridColor(Color.black);
        tableActivity.setBackground(Color.white);  
    }
    public void getActivityValue(){
        ArrayList<Activity> activities = new ArrayList<Activity>();
        try{
            String theme = cbTheme.getSelectedItem().toString();
            ActivityMDE aMde = new ActivityMDEImpl();
            activities = aMde.getAllActivityTheme(theme);
            
            DefaultTableModel model = (DefaultTableModel) tableActivity.getModel();
            Object[] row;
            activityIdMap.clear();
            
            for (int i =0; i < activities.size(); i++){
                Activity a = activities.get(i);
                activityIdMap.put(i, a.getActivityId());
                row = new Object[5];
                row[0] = a.getName();
                row[1] = a.getDescription();
                row[2] = a.getFee();
                row[3] = a.getAddress();
                row[4] = a.getDuration();
                
                model.addRow(row);
            }
            
        }catch(Exception e){
        
        }
    
    }

    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(OwnerListActivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerListActivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerListActivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerListActivityPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerActivityPage().setVisible(true);
            }
        });
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
        btnLogOut = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableActivity = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSeeActivity = new javax.swing.JButton();
        btnValidFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("MyDesignExperience");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
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

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnHome.setText("Home Page");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        tableActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Fee", "Addess", "Duration"
            }
        ));
        tableActivity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableActivityMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableActivity);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSeeActivity.setText("See Activity details");
        btnSeeActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeActivityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnSeeActivity)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSeeActivity)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnValidFilter.setText("Valid");
        btnValidFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnValidFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(btnHome)
                        .addGap(62, 62, 62)
                        .addComponent(btnLogOut)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTheme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut)
                    .addComponent(btnHome)
                    .addComponent(btnValidFilter))
                .addGap(119, 119, 119)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tableActivityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableActivityMouseClicked
        // TODO add your handling code here:
        model = (DefaultTableModel) tableActivity.getModel();
        rowIndex = tableActivity.getSelectedRow();
    }//GEN-LAST:event_tableActivityMouseClicked

    private void btnSeeActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeActivityActionPerformed
        // TODO add your handling code here:
        System.out.println(rowIndex);
        /*for (Map.Entry<Integer, Integer> entry : activityIdMap.entrySet()){
                System.out.println("Row Index: "+ entry.getKey() + ", Activity ID: "+ entry.getValue());
        }*/
        if (rowIndex != -1 && activityIdMap.containsKey(rowIndex)) {
            System.out.println("opening choosen activity");
            // ActivityChoosen Page opening
            ActivityMDE aMde = new ActivityMDEImpl();
            Activity a = aMde.getActivity(activityIdMap.get(rowIndex));
            CustomerActivityChoosenPage c = new CustomerActivityChoosenPage(currentUser, a);
            c.setVisible(true);
            this.dispose();
        } 
    }//GEN-LAST:event_btnSeeActivityActionPerformed

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
    private javax.swing.JButton btnSeeActivity;
    private javax.swing.JButton btnValidFilter;
    private javax.swing.JComboBox<String> cbTheme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableActivity;
    // End of variables declaration//GEN-END:variables
}
