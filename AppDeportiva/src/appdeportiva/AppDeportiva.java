/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import appdeportiva2.Torneo;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Eder Javier
 */
public class AppDeportiva extends JFrame{
    
    private Torneo torneo;
    private Marcadores marcadores;
    private Posiciones posiciones;
    private Botones botones;
    private DialogoResultado dialogo;
    
    public AppDeportiva(){
    
    torneo = null;
    marcadores = new Marcadores();
    botones = new Botones(this);
    posiciones = new Posiciones();
    add(marcadores,BorderLayout.CENTER);
    add(posiciones,BorderLayout.EAST);
    add(botones,BorderLayout.SOUTH);
    setSize(820,230);
    setTitle("TABLA DE RESULTADOS");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
