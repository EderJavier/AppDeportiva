/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Eder Javier
 */
public class Resultados extends JPanel{
    
    private JLabel etiquetaGuion;
    private JTextField txtGoles1;
    private JTextField txtGoles2;

    public Resultados() {
        
        etiquetaGuion = new JLabel("-");
        txtGoles1 = new JTextField(2);
        txtGoles2 = new JTextField(2);
        add(txtGoles1);
        add(etiquetaGuion);
        add(txtGoles2);
        setBorder(new TitledBorder("RESULTADOS"));
        
    }
    
    public String darGolesEquipo1(){
        return txtGoles1.getText();
    }
    
    public String darGolesEquipo2(){
        return txtGoles2.getText();
    }
    
    public void limpiar(){
        
        txtGoles1.setText("");
        txtGoles2.setText("");
    }
    
}
