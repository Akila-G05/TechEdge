/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.pannel;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.akila.techedge.connection.MySQL;
import lk.akila.techedge.dialog.PaymentDialog;
import lk.akila.techedge.gui.AdminDashboard;
import raven.toast.Notifications;

/**
 *
 * @author Akila_Ya
 */
public class AdminPaymentManagementPanel extends javax.swing.JPanel {

    private final AdminDashboard adminDashboard;
    public static AdminPaymentManagementPanel payPannel;
    private static String nic;
    public static String pId;
    private static HashMap<String, Integer> subjectMap2;
    private static String query = "";
    
    private static Logger logger;
    private static FileHandler handler;
    
    public AdminPaymentManagementPanel(AdminDashboard dashboard) {
        initComponents();             
        this.adminDashboard = dashboard;
        payPannel = this;
         logger();
        loadPaymentTable();
        jButton2.setVisible(false);
        subjectMap2 = new HashMap<>();
        loadSubject();
        
    }
    
    public void logger(){
        try {
            
            logger = Logger.getLogger(AdminPaymentManagementPanel.class.getName());
            handler = new FileHandler(AdminPaymentManagementPanel.class.getName() + ".log", true);
            handler.setFormatter(new SimpleFormatter());
            
            logger.addHandler(handler);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadSubject(){
        
        try {
            ResultSet rs =  MySQL.search("SELECT * FROM `subject` \n" +
                                                            "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id`");
            
            Vector<String> v = new Vector<>();
            v.add("Select Subject");
            
            while(rs.next()){
                v.add(rs.getString("name") + " / " + rs.getString("cat_name"));
                subjectMap2.put(rs.getString("name") + " / " + rs.getString("cat_name"), rs.getInt("subject.subno"));
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(v);
            jComboBox1.setModel(model);
            
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        
    }

    public void loadPaymentTable(){
        try {
            
            ResultSet rs = MySQL.search("SELECT * FROM `payment` \n" +
                                    "INNER JOIN `student` ON `payment`.`student_id` = `student`.`id`\n" +
                                    "INNER JOIN `subject` ON `payment`.`subject_subno` = `subject`.`subno`\n" +
                                    "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id` \n" +
                                    "INNER JOIN `teacher` ON `subject`.`subno` = `teacher`.`subject_subno`\n" +
                                    "INNER JOIN `user` ON `student`.`user_id` = `user`.`id` " + query + 
                                    "ORDER BY `payment`.`id` DESC");
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            while(rs.next()){       
                ResultSet rs2 = MySQL.search("SELECT * FROM `user` WHERE `id`='"+rs.getString("teacher.user_id")+"'");
                
                Vector<String> v = new Vector<>();
                v.add(rs.getString("payment.id"));
                v.add(rs.getString("subject.name") + " / " + rs.getString("cat_name"));
                v.add(rs.getString("user.name"));
                v.add(rs.getString("subject.price"));    
                v.add(rs.getString("month"));

                if(rs2.next()){
                    v.add(rs2.getString("name"));
                }
                
                if(rs.getInt("p_status_id") == 1){
                    v.add("PAYED");
                }else{
                    v.add("PENDING");
                }
                
                model.addRow(v);
                
            }
            
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        background1 = new lk.akila.techedge.component.Background();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        background2 = new lk.akila.techedge.component.Background();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton3.setText("Register Class");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(617, 441));

        background1.setForeground(new java.awt.Color(34, 36, 54));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Add Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/akila/techedge/img/bin (1).png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1))
                .addContainerGap())
        );

        background2.setForeground(new java.awt.Color(34, 36, 54));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/akila/techedge/img/paymentBig.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Payments");

        javax.swing.GroupLayout background2Layout = new javax.swing.GroupLayout(background2);
        background2.setLayout(background2Layout);
        background2Layout.setHorizontalGroup(
            background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        background2Layout.setVerticalGroup(
            background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(24, 24, 24))
        );

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Subject ", "Student ", "Payment", "Month", "Teacher", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
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
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(background2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(background1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PaymentDialog paymentDialog = new PaymentDialog(adminDashboard, true);
        paymentDialog.setLocationRelativeTo(adminDashboard);
        paymentDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        String pId = (String)jTable1.getValueAt(selectedRow, 0);

        int showConfirmDialog = JOptionPane.showConfirmDialog(this, "Would you like to delete this payment?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog==JOptionPane.YES_OPTION){
            
            MySQL.iud("DELETE FROM `payment` WHERE `id`='"+pId+"'");
            
            Notifications.getInstance().show
            (Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Payment successfully deleted");

            jButton2.setVisible(false);
            loadPaymentTable();
        }else{
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 1){
            jButton2.setVisible(true);
            jButton2.setFocusable(true);  
        }
        
        if(evt.getClickCount() == 2){
            jButton2.setVisible(false);
            jButton2.setFocusable(false);  
            
            int selectedRow = jTable1.getSelectedRow();
            pId = (String)jTable1.getValueAt(selectedRow, 0);
            String subject = (String)jTable1.getValueAt(selectedRow, 1);
            String studentName = (String)jTable1.getValueAt(selectedRow, 2);
            String month = (String)jTable1.getValueAt(selectedRow, 4);

            int month1;
            if(month == "January"){
                month1 = 0;
            }else if(month == "February"){
                month1 = 1;
            }else if(month == "March"){
                month1 = 2;
            }else if(month == "April"){
                month1 = 3;
            }else if(month == "May"){
                month1 = 4;
            }else if(month == "June"){
                month1 = 5;
            }else if(month == "July"){
                month1 = 6;
            }else if(month == "August"){
                month1 = 7;
            }else if(month == "September"){
                month1 = 8;
            }else if(month == "Octomber"){
                month1 = 9;
            }else if(month == "November"){
                month1 = 10;
            }else{
                month1 = 11;
            }
            
            try {
                 ResultSet rs = MySQL.search("SELECT * FROM `payment` \n" +
                                    "INNER JOIN `student` ON `payment`.`student_id` = `student`.`id`\n" +
                                    "INNER JOIN `subject` ON `payment`.`subject_subno` = `subject`.`subno`\n" +
                                    "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id` \n" +
                                    "INNER JOIN `user` ON `student`.`user_id` = `user`.`id`\n" +
                                    "WHERE `payment`.`id` = '"+pId+"' ORDER BY `payment`.`id` DESC");
                 
                 if(rs.next()){
                    nic = rs.getString("nic");
                 }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            
            String student = nic + " - " + studentName;
            
            PaymentDialog paymentDialog = new PaymentDialog(adminDashboard, true);
            paymentDialog.setLocationRelativeTo(adminDashboard);
            
            paymentDialog.getjComboBox1().setSelectedItem(subject);
            paymentDialog.getjComboBox2().setSelectedItem(student);
            paymentDialog.getjComboBox3().setSelectedIndex(0);
            paymentDialog.getjMonthChooser1().setMonth(month1);
            
            paymentDialog.getjComboBox1().setEnabled(false);
            paymentDialog.getjComboBox2().setEnabled(false);
            paymentDialog.getjComboBox3().setEnabled(true);
            paymentDialog.getjMonthChooser1().setEnabled(false);
            
            paymentDialog.getjButton3().setVisible(false);
            paymentDialog.getjButton4().setVisible(true);
            
            paymentDialog.setVisible(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String search = jTextField1.getText();
        String subject = (String)jComboBox1.getSelectedItem();
        
        if(!search.isEmpty()){
            query = "WHERE `user`.`name` LIKE  '%"+search+"%' ";
        }
        
        if(subject != "Select Subject"){
            int sid = subjectMap2.get(subject);
            query = "WHERE `user`.`name` LIKE  '%"+search+"%' AND `payment`.`subject_subno` = '"+sid+"'";    
        }
        
        loadPaymentTable();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String search = jTextField1.getText();
        String subject = (String)jComboBox1.getSelectedItem();
        
        if(!search.isEmpty()){
            query = "WHERE `user`.`name` LIKE  '%"+search+"%' ";
        }
        
        if(subject != "Select Subject"){
            int sid = subjectMap2.get(subject);
            query = "WHERE `user`.`name` LIKE  '%"+search+"%' AND `payment`.`subject_subno` = '"+sid+"'";    
        }
        
        loadPaymentTable();
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lk.akila.techedge.component.Background background1;
    private lk.akila.techedge.component.Background background2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
