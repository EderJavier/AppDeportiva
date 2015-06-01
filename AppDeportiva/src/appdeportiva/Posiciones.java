/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Eder Javier
 */
public class Posiciones extends JScrollPane{
    
    private JTextArea txtTabla;
    
    public Posiciones(){
        
        txtTabla = new JTextArea(10,60);
        txtTabla.setEditable(false);
        txtTabla.setFont(new Font("Courier New", Font.PLAIN,14));
        txtTabla.setBackground(getBackground());
        getViewport().add(txtTabla);
        setBorder(new TitledBorder("TABLA DE POSICIONES"));
        
    }
    
    public void refrescar( ArrayList tabla )
    {
        txtTabla.setText( "" );
        String mensaje = "   Nombre del Equipo  Pts PJ  PG  PE  PP  GF  GC \n\n";
        for( int i = 0; i < tabla.size( ); i++ )
        {
            String[] datos = ( String[] )tabla.get( i );
            mensaje += cambiarTamanio( datos[ 0 ], 20 ) + cambiarTamanio( datos[ 1 ], 3 ) + cambiarTamanio( datos[ 2 ], 3 ) + cambiarTamanio( datos[ 3 ], 3 ) + cambiarTamanio( datos[ 4 ], 3 ) + cambiarTamanio( datos[ 5 ], 3 )
                    + cambiarTamanio( datos[ 6 ], 3 ) + cambiarTamanio( datos[ 7 ], 3 ) + "\n";
        }
        txtTabla.setText( mensaje );
    }
    
    private String cambiarTamanio( String cadena, int tamano )
    {
        if( cadena.length( ) >= tamano )
            return cadena.substring( 0, tamano );
        else
        {
            String prefijo = "";
            for( int numFaltantes = tamano - cadena.length( ); numFaltantes > 0; numFaltantes-- )
            {
                prefijo += " ";
            }
            return prefijo + cadena + " ";
        }
    }
    
}
