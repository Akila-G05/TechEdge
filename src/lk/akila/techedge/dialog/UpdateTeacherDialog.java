/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.dialog;

import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.akila.techedge.connection.MySQL;
import lk.akila.techedge.pannel.AdminTeacherManagementPanel;
import raven.toast.Notifications;

/**
 *
 * @author Akila_Ya
 */
public class UpdateTeacherDialog extends javax.swing.JDialog {

    public static Frame dashborad;
    public static HashMap<String, Integer> subjectMap;
    
    public UpdateTeacherDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dashborad = parent;
        subjectMap = new HashMap<>();
        
        loadSubject();
        loadSubjectTable();
    }

    public void loadSubject(){
        
        try {
            ResultSet rs =  MySQL.search("SELECT * FROM `subject` \n" +
                                                            "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id`\n" +
                                                            "WHERE `subno` NOT IN (SELECT `subject_subno` FROM `teacher`)");
            
            Vector<String> v = new Vector<>();
            v.add("Select Subject");
            
            while(rs.next()){
                v.add(rs.getString("name") + " / " + rs.getString("cat_name"));
                subjectMap.put(rs.getString("name") + " / " + rs.getString("cat_name"), rs.getInt("subject.subno"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void loadSubjectTable(){
        
        try {
            ResultSet rs =  MySQL.search("SELECT * FROM `teacher` \n" +
                                    "INNER JOIN `subject` ON `teacher`.`subject_subno` = `subject`.`subno`\n" +
                                    "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id`\n" +
                                    "WHERE `user_id` = '"+AdminTeacherManagementPanel.userVector.get(0)+"'");

            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            
            
            while(rs.next()){
                ResultSet rs2 =  MySQL.search("SELECT * FROM `student` WHERE `subject_subno` = '"+rs.getInt("subno")+"'");
                int count = 0;
                
                while(rs2.next()){
                    count++;
                }
                
                Vector<String> v = new Vector<>();
                v.add(rs.getString("teacher.id"));
                v.add(rs.getString("name") + " / " + rs.getString("cat_name"));
                v.add(String.valueOf(count));
                
                model.addRow(v);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select  Subject" }));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Subject", "Student Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Deactive");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        RegisterTeacherDialog tDialog = new RegisterTeacherDialog(dashborad, true);
        tDialog.setLocationRelativeTo(dashborad);
        
//        tDialog.getjButton4().setVisible(true);
//        tDialog.getjButton4().setVisible(false);
        
        tDialog.getjTextField12().setText(AdminTeacherManagementPanel.userVector.get(1));
        tDialog.getjTextField13().setText(AdminTeacherManagementPanel.userVector.get(3));
        tDialog.getjTextField14().setText(AdminTeacherManagementPanel.userVector.get(4));
        tDialog.getjTextField15().setText(AdminTeacherManagementPanel.userVector.get(2));
        tDialog.getjComboBox2().setSelectedItem(AdminTeacherManagementPanel.userVector.get(5));
        
        tDialog.getjButton4().setVisible(true);
        tDialog.getjButton3().setVisible(false);
        
        tDialog.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String subName = (String)jComboBox1.getSelectedItem();
        
        if(subName == "Select Subject"){
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Please Select Subject");
        }else{
            int subId = subjectMap.get(subName);
            
            MySQL.iud("INSERT INTO `teacher` (`user_id`, `subject_subno`) " +
                               "VALUES ('"+AdminTeacherManagementPanel.userVector.get(0)+"', '"+subId+"')");
            
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Subject Successfully Registerd to Teacher");
            loadSubject();
            loadSubjectTable();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            int selectedRow = jTable1.getSelectedRow();
            String teacherId = (String)jTable1.getValueAt(selectedRow, 0);
            String subject = (String)jTable1.getValueAt(selectedRow, 1);
            
            String[] split = subject.split(" / ");
            String subjectName = split[0];
            String subjectCat = split[1];

            int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Are you sure want to remove this subject from teacher? ", "Confirmation", JOptionPane.YES_NO_OPTION);

            if(showConfirmDialog==JOptionPane.YES_OPTION){
                
                try {
                    
                    ResultSet rs = MySQL.search("SELECT * FROM `payment` \n" +
                    "INNER JOIN `subject` ON `payment`.`subject_subno` = `subject`.`subno`\n" +
                    "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id`\n" +
                    "WHERE `name`='"+subjectName+"' AND `cat_name`='"+subjectCat+"' ");
                    
                    if(rs.next()){
                        Notifications.getInstance().show
                        (Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "This subject cannot be removed because there is a related payment. Delete the payments frist and try again");
                    }else{
                        MySQL.iud("DELETE FROM `teacher` WHERE `id`='"+teacherId+"'");

                        Notifications.getInstance().show
                        (Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Subject successfully removed");

                        loadSubject();
                        loadSubjectTable();
                        
                    }
                    
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                
            }else{

            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `user` WHERE `id`='"+AdminTeacherManagementPanel.userVector.get(0)+"'");
            
            if(rs.next()){
                if(rs.getInt("user_status_id") == 1){
                    MySQL.iud("UPDATE `user` SET `user_status_id`='2' WHERE `id`='"+AdminTeacherManagementPanel.userVector.get(0)+"'");
                    jButton6.setText("Activate");
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,rs.getString("name") +  " User Deactivated");
                }else{
                    MySQL.iud("UPDATE `user` SET `user_status_id`='1' WHERE `id`='"+AdminTeacherManagementPanel.userVector.get(0)+"'");
                    jButton6.setText("Deactivate");
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT,rs.getString("name") +  " User Activated");
                }
            }
            
            AdminTeacherManagementPanel.atmPannel.loadTeacherTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    public JButton getjButton6() {
        return jButton6;
    }

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
            java.util.logging.Logger.getLogger(UpdateTeacherDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTeacherDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTeacherDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTeacherDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateTeacherDialog dialog = new UpdateTeacherDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
