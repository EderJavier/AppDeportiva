/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Eder Javier
 */
public class Torneo {
    
    public static final int SIN_JUGAR = -1;
    public static final int INVALIDO = -2;
    private int maxEquipos;
    private int[][] tablaGoles;
    private Equipo[] equipo;
    
        
    public Torneo(File arch) throws Exception{
        Properties datos = cargarInfoTorneo(arch);
        inicializarEquipos(datos);
        inicializarMarcadores();
    }
    
    private Properties cargarInfoTorneo(File arch) throws Exception{
        Properties datos = new Properties();
        FileInputStream in = new FileInputStream(arch);
        try{
            datos.load(in);
            in.close();
        }
        catch(Exception e){
            throw new Exception("FORMATO DE ARCHIVO INVALIDO");
        }
        return datos;
    }
    
    private void inicializarEquipos(Properties datos){
        String strNumeroEquipos = datos.getProperty("torneo.equipos");
        maxEquipos = Integer.parseInt(strNumeroEquipos);
        
        equipo = new Equipo[maxEquipos];
        for(int i = 0; i < maxEquipos; i++){
            String nombreEquipo = datos.getProperty("torneo.nombre" + i);
            equipo[i] = new Equipo(nombreEquipo);
        }
    }
    
    private void inicializarMarcadores(){
        tablaGoles = new int [maxEquipos][maxEquipos];
        
        for(int i = 0; i < maxEquipos; i++){
            for(int j = 0; j < maxEquipos; j++){
                if(i != j)
                    tablaGoles[i][j] = SIN_JUGAR;
                else
                    tablaGoles[i][j] = INVALIDO;
            }
        }
    }
    
    public void registrarResultado(int eq1, int eq2, int gol1, int gol2) throws Exception{
        if(eq1 < 0 || eq1 >=maxEquipos || eq2 < 0 || eq2 >= maxEquipos){
            throw new Exception("SE HAN SELECCIONADO LOS EQUIPOS INCORRECTOS");
        }
        if(eq1 == eq2){
            throw new Exception("NO PUEDEN JUGAR LOS MISMOS EQUIPOS");
        }
        if(gol1 < 0 || gol2 < 0){
            throw new Exception("HAS INGRESADO UN MARCADOR INCORRECTO");
        }
        if(tablaGoles[eq1][eq2] != SIN_JUGAR || tablaGoles[eq2][eq1] != SIN_JUGAR){
            throw new Exception("ESTA PARTIDO YA FUE DISPUTADO");
        }
        tablaGoles[eq1][eq2] = gol1;
        tablaGoles[eq2][eq1] = gol2;
    }
    
    public int darGolesMarcados(int eq1, int eq2){
        return tablaGoles[eq1][eq2];
    }
    
    public int darNumeroEquipos(){
        return maxEquipos;
    }
    
    public Equipo darEquipo(int eq){
        return equipo[eq];
    }
    
    public int darPartidosGanados(int equipo){
        int ganados = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO && tablaGoles[ equipo ][ i ] > tablaGoles[ i ][ equipo ])
                ganados++;
        return ganados;
    }
    
    public int darPartidosPerdidos(int equipo){
        int perdidos = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO && tablaGoles[ equipo ][ i ] < tablaGoles[ i ][ equipo ])
                perdidos++;
        return perdidos;
    }
    
    public int darPartidosEmpatados(int equipo){
        int empatados = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO && tablaGoles[ equipo ][ i ] == tablaGoles[ i ][ equipo ])
                empatados++;
        return empatados;
    }
    
    public int darPartidosJugados(int equipo){
        int jugados = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO)
                jugados++;
        return jugados;
    }
    
    public int darGolesEnContra(int equipo){
        int golesEnContra = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO)
                golesEnContra += tablaGoles[i][equipo];
        return golesEnContra;
    }
    
    public int darGolesAFavor(int equipo){
        int golesAFavor = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO)
                golesAFavor += tablaGoles[equipo][i];
        return golesAFavor;
    }
    
    public int darTotalPuntos(int equipo){
        return 3 * darPartidosGanados(equipo)+ darPartidosEmpatados(equipo);
    }
    
}
