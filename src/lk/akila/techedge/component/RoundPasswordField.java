/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPasswordField;

/**
 *
 * @author Akila_Ya
 */
public class RoundPasswordField extends JPasswordField{
    
    public RoundPasswordField(){
        init();
    }
    
    private void init(){
        this.putClientProperty(FlatClientProperties.STYLE, "arc:999; margin:0, 10, 0, 10");
    }
    
}
