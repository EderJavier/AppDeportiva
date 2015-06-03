/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import appdeportiva2.Equipo;
import appdeportiva2.Torneo;
import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
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
    setSize(1200,700);
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
        
        JFileChooser fc = new JFileChooser("./data");
        fc.setDialogTitle("CARGAR ARCHIVO DE TORNEO");
        int resultado = fc.showOpenDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION){
            
            File archivoTorneo = fc.getSelectedFile();
            try{
                torneo = new Torneo(archivoTorneo);
                String[] nombreEquipos = new String[torneo.darNumeroEquipos()];
                for(int i = 0; i < torneo.darNumeroEquipos(); i++){
                    nombreEquipos[i] = torneo.darEquipo(i).toString();
                }
                dialogo = new DialogoResultado(this, nombreEquipos);
                marcadores.iniciarMarcadores(torneo);
                refrescar();
                botones.desactivarBotonCargar();
            }
            catch(Exception e){
                torneo = null;
                JOptionPane.showMessageDialog(this, "PROBLEMAS AL CARGAR TORNEO: \n" + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    private void refrescar(){
        
        marcadores.refrescar();
        ArrayList tablaPosiciones = new ArrayList();
        for(int i = 0; i < torneo.darNumeroEquipos(); i++){
            
            Equipo e = torneo.darEquipo(i);
            String[] calculosEquipo = new String[8];
            calculosEquipo[0] = e.darNombre();
            calculosEquipo[1] = "" + torneo.darTotalPuntos(i);
            calculosEquipo[2] = "" + torneo.darPartidosJugados(i);
            calculosEquipo[3] = "" + torneo.darPartidosGanados(i);
            calculosEquipo[4] = "" + torneo.darPartidosEmpatados(i);
            calculosEquipo[5] = "" + torneo.darPartidosPerdidos(i);
            calculosEquipo[6] = "" + torneo.darGolesAFavor(i);
            calculosEquipo[7] = "" + torneo.darGolesEnContra(i);
            tablaPosiciones.add(calculosEquipo);
        }
        
        posiciones.refrescar(tablaPosiciones);
    }
    
    public void reqFuncOpcion1(){
        
        if(torneo == null){
            JOptionPane.showMessageDialog(this, "DEBE PRIMERO CARGAR UN TORNEO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String resultado = torneo.metodo1();
            JOptionPane.showMessageDialog(this, resultado, "ERROR AL ORDENAR TABLA", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void reqFuncOpcion2(){
        
        if(torneo == null){
            JOptionPane.showMessageDialog(this, "DEBE PRIMERO CARGAR UN TORNEO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String resultado = torneo.metodo2();
            JOptionPane.showMessageDialog(this, resultado, "ERROR AL SALIR", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AppDeportiva ic = new AppDeportiva();
        ic.setVisible(true);
        
    }
    
}
