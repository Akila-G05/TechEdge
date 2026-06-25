/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.dialog;

import com.toedter.calendar.JMonthChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import lk.akila.techedge.connection.MySQL;
import lk.akila.techedge.pannel.AdminPaymentManagementPanel;
import raven.toast.Notifications;

/**
 *
 * @author Akila_Ya
 */
public class PaymentDialog extends javax.swing.JDialog {

    private Map<String, Integer> subjectMap;
    private static HashMap<String, Integer> studentMap;
//    public static int sId;
    
    public PaymentDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        subjectMap = new HashMap<>();
        loadSubject();
        loadClassType();
        
        jComboBox3.setEnabled(false);
        jComboBox2.setEnabled(false);
        studentMap = new HashMap<>();
        jButton4.setVisible(false);
    }

    private void loadSubject(){
        
        try {
            ResultSet rs =  MySQL.search("SELECT * FROM `subject`\n" +
            "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id`");
            
            Vector<String> v = new Vector<>();
            v.add("Select Subject");
            
            while(rs.next()){    
                v.add(rs.getString("name") + " / " + rs.getString("cat_name"));
                subjectMap.put(rs.getString("name"), rs.getInt("subno"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    private void loadClassType(){
        
        try {
            ResultSet rs =  MySQL.search("SELECT * FROM `p_status` ORDER BY `id` DESC");
            
            Vector<String> v = new Vector<>();
            
            while(rs.next()){    
                v.add(rs.getString("p_status"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox3.setModel(model);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Subject");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Register");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jMonthChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jMonthChooser1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Select Month");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Status");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Student");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Subject" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(219, 219, 219))
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(0, 344, Short.MAX_VALUE))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox3)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Add New Payment
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
         if(jComboBox1.getSelectedIndex() == 0){
            jComboBox2.setEnabled(false);
        }else{
            
            try {
                int sID = jComboBox1.getSelectedIndex();
                
                ResultSet rs = MySQL.search("SELECT * FROM `student`\n" +
                "INNER JOIN `subject` ON `student`.`subject_subno` = `subject`.`subno`\n" +
                "INNER JOIN `user` ON `student`.`user_id` = `user`.`id`\n" +
                "WHERE `subject`.`subno` = '"+sID+"'");
                
                Vector<String> v = new Vector<>();
                v.add("All Student");
                
                while(rs.next()){    
                    v.add(rs.getString("nic") + " - " + rs.getString("user.name"));
                    studentMap.put(rs.getString("nic"), rs.getInt("student.id"));
                }

                DefaultComboBoxModel model = new DefaultComboBoxModel(v);
                jComboBox2.setModel(model);
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

                jComboBox2.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int subId = jComboBox1.getSelectedIndex();
        int status = 2;
        
        String month;
        if(jMonthChooser1.getMonth()==0){
            month = "January";
        }else if(jMonthChooser1.getMonth()==1){
            month = "February";
        }else if(jMonthChooser1.getMonth()==2){
            month = "March";
        }else if(jMonthChooser1.getMonth()==3){
            month = "April";
        }else if(jMonthChooser1.getMonth()==4){
            month = "May";
        }else if(jMonthChooser1.getMonth()==5){
            month = "June";
        }else if(jMonthChooser1.getMonth()==6){
            month = "July";
        }else if(jMonthChooser1.getMonth()==7){
            month = "August";
        }else if(jMonthChooser1.getMonth()==8){
            month = "September";
        }else if(jMonthChooser1.getMonth()==9){
            month = "Octomber";
        }else if(jMonthChooser1.getMonth()==10){
            month = "November";
        }else{
            month = "December";
        }
        
        int stuId = jComboBox2.getSelectedIndex();
        int subID = jComboBox1.getSelectedIndex();
        
        if(stuId == 0){
            try {
                
                ResultSet rs = MySQL.search("SELECT * FROM `student`\n" +
                "INNER JOIN `subject` ON `student`.`subject_subno` = `subject`.`subno`\n" +
                "INNER JOIN `user` ON `student`.`user_id` = `user`.`id`\n" +
                "WHERE `subject`.`subno` = '"+subID+"'");
                
                int sCount = 0;
                
                while(rs.next()){
                    sCount++;
                    
                    MySQL.iud("INSERT INTO `payment` (`student_id`, `subject_subno`, `month`, `p_status_id`) "
                            + "VALUES('"+rs.getInt("student.id")+"', '"+subID+"', '"+month+"', '"+status+"')");

                }
        
                Notifications.getInstance().show
                    (Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, month + " month payment successfully scheduled");
                
                AdminPaymentManagementPanel.payPannel.loadPaymentTable();
                this.dispose();
                
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            
            String stuName = (String)jComboBox2.getSelectedItem();
            
            String[] split = stuName.split(" - ");
            String stuNic = split[0];
            
            int stuId2 = studentMap.get(stuNic);
            
            System.out.println(stuId2);
            
            MySQL.iud("INSERT INTO `payment` (`student_id`, `subject_subno`, `month`, `p_status_id`) "
                            + "VALUES('"+stuId2+"', '"+subID+"', '"+month+"', '"+status+"')");
//            
            Notifications.getInstance().show
                    (Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, month + " month payment successfully scheduled for " + stuName);
            
            AdminPaymentManagementPanel.payPannel.loadPaymentTable();
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    //Update payment
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int status = jComboBox3.getSelectedIndex();
        
        int sId = 0;
        
        if(status == 0){
            sId = 2;
        }else{
            sId = 1;
        }
        String paymentId = AdminPaymentManagementPanel.pId;
        
        MySQL.iud("UPDATE `payment` SET `p_status_id`='"+sId+"' WHERE `id`='"+paymentId+"'");
        
        Notifications.getInstance().show
                    (Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Payment Status successfully updated");
        
        AdminPaymentManagementPanel.payPannel.loadPaymentTable();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    public JButton getjButton4() {
        return jButton4;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public JComboBox<String> getjComboBox2() {
        return jComboBox2;
    }

    public JComboBox<String> getjComboBox3() {
        return jComboBox3;
    }

    public JMonthChooser getjMonthChooser1() {
        return jMonthChooser1;
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
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PaymentDialog dialog = new PaymentDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    // End of variables declaration//GEN-END:variables
}
