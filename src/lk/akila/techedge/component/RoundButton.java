/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;

/**
 *
 * @author Akila_Ya
 */
public class RoundButton extends JButton{
    
    public RoundButton(){
        init();
    }
    
    private void init(){
        this.putClientProperty(FlatClientProperties.STYLE, "arc:999");
    }
}
