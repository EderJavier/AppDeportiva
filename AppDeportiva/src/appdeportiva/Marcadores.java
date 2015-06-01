/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import appdeportiva2.Torneo;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Eder Javier
 */
public class Marcadores extends JPanel {
    
    private Torneo torneo;
    private int numeroEquipos;
    private final Font fuenteNegrita;
    private JLabel[][] tablaEtiquetasGoles;
    
    public Marcadores(){
        
        torneo = null;
        numeroEquipos = 0;
        fuenteNegrita = new Font("Arial", Font.BOLD, 11);
        setBorder(new TitledBorder("TABLA DE GOLES"));
    }
    
    public void iniciarMarcadores(Torneo pTorneo){
        
        torneo = pTorneo;
        numeroEquipos = torneo.darNumeroEquipos();
        setLayout(new GridLayout(numeroEquipos + 1, numeroEquipos + 1));
        tablaEtiquetasGoles = new JLabel[numeroEquipos + 1][numeroEquipos + 1];
        
        for(int i = 0; i < numeroEquipos + 1; i++){
            for(int j = 0; j < numeroEquipos + 1; j++){
                if(i == 0 && j == 0)
                    tablaEtiquetasGoles[0][0] = new JLabel("");
                else if(i == 0){
                    tablaEtiquetasGoles[0][j] = new JLabel(torneo.darEquipo(j - 1).darNombre() + " ");
                }
                else if(j == 0){
                    tablaEtiquetasGoles[i][0] = new JLabel(torneo.darEquipo(i - 1).darNombre() + " ");
                }
                else if(i == j){
                    tablaEtiquetasGoles[i][i] = new JLabel("X");
                }
                else{
                    tablaEtiquetasGoles[i][j] = new JLabel("-");
                }
                tablaEtiquetasGoles[i][j].setFont(fuenteNegrita);
                tablaEtiquetasGoles[i][j].setHorizontalAlignment(JLabel.CENTER);
                add(tablaEtiquetasGoles[i][j]);
            }
        }
        validate();
    }
    
    public void refrescar(){
        
        if(torneo == null)
            return;
        
        for(int i = 0; i < numeroEquipos; i++){
            for(int j = 0; j < numeroEquipos; j++){
                
                int resultado = torneo.darGolesMarcados(i, j);
                if(i != j && resultado != torneo.SIN_JUGAR){
                    tablaEtiquetasGoles[i + 1][j + 1].setText("" + resultado);
                }
            }
        }
    }
    
}
