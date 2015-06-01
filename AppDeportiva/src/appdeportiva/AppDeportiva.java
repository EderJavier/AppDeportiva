/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import appdeportiva2.Torneo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    
    public void mostrarDialogoResultado(){
        
        if(torneo == null){
            JOptionPane.showMessageDialog(this,"DEBE PRIMERO CARGAR UN TORNEO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            dialogo.limpiar();
            dialogo.setVisible(true);
        }
    }
    
    public void registrarResultado(int equipo1, int equipo2, int goles1, int goles2){
        
        if(torneo != null){
            try{
                torneo.registrarResultado(equipo1, equipo2, goles1, goles2);
                refrescar();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
    
    public void cargarEquipos(){
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
