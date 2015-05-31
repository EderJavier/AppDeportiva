/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva2;

/**
 *
 * @author Eder Javier
 */
public class Equipo {
    
    private String nombre;
    
    public Equipo( String nombreEquipo )
    {
        nombre = nombreEquipo;
    }
    
    public String darNombre( )
    {
        return nombre;
    }
    
    public String toString( )
    {
        return darNombre( );
    }
    
}
