/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.pannel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import lk.akila.techedge.connection.MySQL;
import lk.akila.techedge.dialog.ClassDialog;
import lk.akila.techedge.gui.SignIn;
import lk.akila.techedge.gui.TeacherDashboard;

/**
 *
 * @author Akila_Ya
 */
public class TeacherClassesPanel extends javax.swing.JPanel {

    private final TeacherDashboard teacherDashboard;
    public static TeacherClassesPanel classPanel;
    
    public static String classId;
    
    public TeacherClassesPanel(TeacherDashboard dashboard) {
        initComponents();
        this.teacherDashboard = dashboard;
        classPanel = this;
        loadClassTable();
    }

    public void loadClassTable(){
        
        try {
            
            ResultSet rs = MySQL.search("SELECT * FROM `class`\n" +
                                    "INNER JOIN `class_type` ON `class`.`class_type_id` = `class_type`.`id` \n" +
                                    "INNER JOIN `subject` ON `class`.`subject_subno` = `subject`.`subno`\n" +
                                    "INNER JOIN `subject_cat` ON `subject`.`subject_cat_id` = `subject_cat`.`id`\n" +
                                    "INNER JOIN `teacher` ON `subject`.`subno` = `teacher`.`subject_subno`\n" +
                                    "WHERE `user_id` = '"+SignIn.user_id+"' ORDER BY `date` DESC");
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            while(rs.next()){
                Vector<String> v = new Vector();
                v.add(rs.getString("classno"));
                v.add(rs.getString("subject.name") + " / " + rs.getString("cat_name"));
                v.add(rs.getString("class.name"));
                v.add(rs.getString("date"));
                v.add(rs.getString("s_time"));
                v.add(rs.getString("e_time"));
                v.add(rs.getString("c_type"));
                
                model.addRow(v);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new lk.akila.techedge.component.Background();
        jLabel8 = new javax.swing.JLabel();
        background2 = new lk.akila.techedge.component.Background();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(617, 441));

        background1.setForeground(new java.awt.Color(34, 36, 54));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Class Schedule");

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/akila/techedge/img/ClassesBig.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Classes");

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton1.setText("Register Class");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout background2Layout = new javax.swing.GroupLayout(background2);
        background2.setLayout(background2Layout);
        background2Layout.setHorizontalGroup(
            background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        background2Layout.setVerticalGroup(
            background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, background2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(background2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Subject ", "Name", "Date", "StartTime", "EndTime", "Class Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //open jDialog for Insert
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ClassDialog classDialog = new ClassDialog(teacherDashboard, true);
        classDialog.setLocationRelativeTo(teacherDashboard);
        classDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //open jDialog for update
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){      
            int selectedRow = jTable1.getSelectedRow();
            
            String id = (String)jTable1.getValueAt(selectedRow, 0);
            String subject = (String)jTable1.getValueAt(selectedRow, 1);
            String cNAme = (String)jTable1.getValueAt(selectedRow, 2);
            String date = (String)jTable1.getValueAt(selectedRow, 3);
            String sTime = (String)jTable1.getValueAt(selectedRow, 4);
            String eTime = (String)jTable1.getValueAt(selectedRow, 5);
            String cType = (String)jTable1.getValueAt(selectedRow, 6);
                        
            Time startTime = Time.valueOf(sTime);
            Time endTime = Time.valueOf(eTime);          
            
            ClassDialog cd = new ClassDialog(teacherDashboard, true);
            cd.setLocationRelativeTo(teacherDashboard);
            classId = id;
            
            cd.getjComboBox1().setSelectedItem(subject);
            cd.getjComboBox2().setSelectedItem(cType);
            cd.getjTextField12().setText(cNAme);
            
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date formatDate = dateFormat.parse(date);
                
                cd.getjDateChooser1().setDate(formatDate);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            
            cd.getjSpinner1().setValue(startTime);
            cd.getjSpinner1().setValue(endTime);
            
            try {
                ResultSet rs = MySQL.search("SELECT * FROM `class` WHERE `classno` = '"+id+"'");
                
                if(rs.next()){
                    String details = rs.getString("details");
                     cd.getjTextArea1().setText(details);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
           
            cd.getjButton3().setEnabled(false);
            
            cd.setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lk.akila.techedge.component.Background background1;
    private lk.akila.techedge.component.Background background2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
