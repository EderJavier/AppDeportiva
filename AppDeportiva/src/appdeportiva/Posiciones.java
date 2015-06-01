/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Eder Javier
 */
public class Posiciones {
    
    private JTextArea txtTabla;
    
    public Posiciones(){
        
        txtTabla = new JTextArea(10,60);
        txtTabla.setEditable(false);
        txtTabla.setFont(new Font("Courier New", Font.PLAIN,12));
        txtTabla.setBackground(getBackground());
        getViewport().add(txtTabla);
        setBorder(new TitledBorder("TABLA DE POSICIONES"));
        
    }
    
}
