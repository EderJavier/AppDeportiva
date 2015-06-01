/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

/**
 *
 * @author Eder Javier
 */
public class Equipos extends JPanel{
    
    private JComboBox comboEquipo1;
    private JComboBox comboEquipo2;
    private JLabel etiquetaVs;
    
    public Equipos(String[] nombreEquipos){
        comboEquipo1 = new JComboBox(new DefaultComboBoxModel(nombreEquipos));
        comboEquipo2 = new JComboBox(new DefaultComboBoxModel(nombreEquipos));
        etiquetaVs = new JLabel("Vs");
        add(comboEquipo1);
        add(etiquetaVs);
        add(comboEquipo2);
        setBorder(new TitleBorder("Equipos"));
    }
    
    public int darEquipo1(){
        return comboEquipo1.getSelectedIndex();
    }
    
    public int darEquipo2(){
        return comboEquipo2.getSelectedIndex();
    }
    
    public void limpiar(){
        comboEquipo1.setSelectedIndex(0);
        comboEquipo2.setSelectedIndex(0);
    }
    
}
