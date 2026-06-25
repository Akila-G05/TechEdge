/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.pannel;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import lk.akila.techedge.connection.MySQL;
import lk.akila.techedge.gui.SignIn;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Akila_Ya
 */
public class StudentPaymentPanel extends javax.swing.JPanel {

    private static HashMap<String, String> teacherMap;
    private static String email;
    
    public StudentPaymentPanel() {
        initComponents();
        loadPayments();
        teacherMap = new HashMap<>();
    }

    private void loadPayments(){
        try {
            
            ResultSet rs = MySQL.search("SELECT * FROM `payment` \n" +
                                    "INNER JOIN `student` ON `payment`.`student_id` = `student`.`id`\n" +
                                    "INNER JOIN `subject` ON `payment`.`subject_subno` = `subject`.`subno`\n" +
                                    "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id` \n" +
                                    "INNER JOIN `teacher` ON `subject`.`subno` = `teacher`.`subject_subno`\n" +
                                    "INNER JOIN `user` ON `teacher`.`user_id` = `user`.`id`\n" +
                                    "WHERE `student`.`user_id`='"+SignIn.user_id+"' ORDER BY `payment`.`id` DESC");
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int count = 0;
            
            while(rs.next()){
                count++;
                
                Vector<String> v = new Vector<>();
                v.add(rs.getString("payment.id"));
                v.add(rs.getString("subject.name"));
                v.add(rs.getString("cat_name"));
                v.add(rs.getString("user.name"));
                v.add(rs.getString("subject.price"));
                v.add(rs.getString("month"));
                
                if(rs.getInt("p_status_id") == 1){
                    v.add("PAYED");
                }else{
                    v.add("PENDING");
                }
                
                model.addRow(v);
                
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        background1 = new lk.akila.techedge.component.Background();
        jLabel8 = new javax.swing.JLabel();
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

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Payments");

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
            .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(background1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
            .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(background1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                "#", "Subject ", "Subject Category", "Teacher ", "Payment", "Month", "Status"
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
                    .addComponent(jScrollPane1)
                    .addComponent(background2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(background1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            int selectedRow = jTable1.getSelectedRow();
            String status = (String)jTable1.getValueAt(selectedRow, 6);
            
            if(status == "PAYED"){
                String stuName = SignIn.name;
                String stuNo = String.valueOf(SignIn.user_id);
                String teacherName = (String)jTable1.getValueAt(selectedRow, 3);
                String paymentNo = (String)jTable1.getValueAt(selectedRow, 0);
                String subject = (String)jTable1.getValueAt(selectedRow, 1) +" / "+ (String)jTable1.getValueAt(selectedRow, 2);
                String month = (String)jTable1.getValueAt(selectedRow, 5);
                String payment = (String)jTable1.getValueAt(selectedRow, 4);
                              
                try {
                    ResultSet rs = MySQL.search("SELECT * FROM `user` WHERE `name` = '"+teacherName+"'");
                    
                    if(rs.next()){
                         email = rs.getString("email");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                
                try {
                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("Parameter1", month);
                    parameters.put("Parameter2", paymentNo);
                    parameters.put("Parameter3", subject);
                    parameters.put("Parameter4", payment);
                    parameters.put("Parameter5", payment);
                    parameters.put("Parameter6", teacherName);
                    parameters.put("Parameter7", email);
                    parameters.put("Parameter8", stuNo);
                    parameters.put("Parameter9", stuName);
                    
//                    System.out.println(stuNo);
                    JREmptyDataSource dataSource = new JREmptyDataSource();
                    InputStream stream = getClass().getResourceAsStream("/lk/akila/techedge/report/techedge.jasper");
                    String filePath = "src//lk//akila//techedge//report/techedge.jasper";
                    
                    JasperPrint print = JasperFillManager.fillReport(stream, parameters, dataSource);
                    JasperViewer.viewReport(print, false);
                    
                } catch (JRException e) {
                    throw new RuntimeException(e);
                }
            }
            
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lk.akila.techedge.component.Background background1;
    private lk.akila.techedge.component.Background background2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
