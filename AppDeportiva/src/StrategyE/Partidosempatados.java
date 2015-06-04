/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StrategyE;

/**
 *
 * @author EQUIPO
 */
public class Partidosempatados implements StrategyE {

    public static final int SIN_JUGAR = -1;
    public static final int INVALIDO = -2;
    private int maxEquipos;
    private int[][] tablaGoles;

    public int consul(int equipo) {
        int empatados = 0;
        for (int i = 0; i < maxEquipos; i++) {
            if (tablaGoles[ equipo][ i] != SIN_JUGAR && tablaGoles[ equipo][ i] != INVALIDO && tablaGoles[ equipo][ i] == tablaGoles[ i][ equipo]) {
                empatados++;
            }
        }
        return empatados;
    }
}
