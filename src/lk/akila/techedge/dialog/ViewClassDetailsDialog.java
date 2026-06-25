/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import lk.akila.techedge.connection.MySQL;

/**
 *
 * @author Akila_Ya
 */
public class ViewClassDetailsDialog extends javax.swing.JDialog {

    private static String c_id; 
    
    public ViewClassDetailsDialog(java.awt.Frame parent, String class_id,boolean modal) {
        super(parent, modal);
        initComponents();
        this.c_id = class_id;
        loadDetails();
    }

    private void loadDetails(){
         try {
             ResultSet rs =  MySQL.search("SELECT * FROM `class` WHERE `classno`='"+c_id+"'");
            
             if(rs.next()){
                jTextArea1.setText(rs.getString("details"));
             } 
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
