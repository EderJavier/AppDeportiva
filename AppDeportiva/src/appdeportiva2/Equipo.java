/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package appdeportiva2;

/**
 *
 * @author sala4
 */
public class Equipo
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es el nombre del equipo
     */
    private String nombre;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye una nueva instancia de un equipo
     * @param nombreEquipo Es el nombre del equipo. nombreEquipo != null
     */
    public Equipo( String nombreEquipo )
    {
        nombre = nombreEquipo;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Retorna el nombre del equipo
     * @return nombre
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna una representación como cadena de caracteres del equipo
     * @return nombre
     */
    public String toString( )
    {
        return darNombre( );
    }
}
