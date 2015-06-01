/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Eder Javier
 */
public class DialogoResultado {
    
    private AppDeportiva interfaz;
    private Equipos equipos;
    private Resultados resultados;
    private Botones2 botones2;
    
    public DialogoResultado(AppDeportiva ic, String[] nombreEquipos){
        
        super(ic, true);
        interfaz = ic;
        equipos = new Equipos(nombreEquipos);
        resultados = new Resultados();
        botones2 = new Botones2(this);
        setLayout(new BorderLayout());
        add(equipos, BorderLayout.NORTH);
        add(resultados, BorderLayout.CENTER);
        add(botones2, BorderLayout.SOUTH);
        settitle("REGISTRAR RESULTADO");
        setSize(230, 190);
    }
    
    public void limpiar(){
        equipos.limpiar();
        resultados.limpiar();
    }
    
    public void registrarPartido(){
        
        try{
            int goles1 = Integer.parseInt( resultados.darGolesEquipo1( ) );
            int goles2 = Integer.parseInt( resultados.darGolesEquipo2( ) );
            int equipo1 = equipos.darEquipo1( );
            int equipo2 = equipos.darEquipo2( );
            interfaz.registrarResultado( equipo1, equipo2, goles1, goles2 );
            setVisible( false );
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(interfaz, "INDIQUE EL NUMERO CORRECTO DE GOLES");
        }
    }
    
}
