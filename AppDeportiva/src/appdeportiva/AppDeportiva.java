/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import appdeportiva2.Torneo;

/**
 *
 * @author Eder Javier
 */
public class AppDeportiva {
    
    private Torneo torneo;
    private Marcadores marcadores;
    private Posiciones posiciones;
    private Botones botones;
    private DialogoResultado dialogo;
    
    public AppDeportiva(){
    
    torneo = null;
    marcadores = new Marcadores();
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
