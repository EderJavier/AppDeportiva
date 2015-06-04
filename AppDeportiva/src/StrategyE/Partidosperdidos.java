/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StrategyE;

import static javaapplication2.Campeonato.INVALIDO;
import static javaapplication2.Campeonato.SIN_JUGAR;

/**
 *
 * @author EQUIPO
 */
public class Partidosperdidos implements StrategyE {

    private int maxEquipos;
    private int[][] tablaGoles;

    public int consul(int equipo) {
        int perdidos = 0;
        for (int i = 0; i < maxEquipos; i++) {
            if (tablaGoles[ equipo][ i] != SIN_JUGAR && tablaGoles[ equipo][ i] != INVALIDO && tablaGoles[ equipo][ i] < tablaGoles[ i][ equipo]) {
                perdidos++;
            }
        }
        return perdidos;
    }
}
