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
    
    public Equipo[] equipo;
    
    public Torneo(File arch) throws Exception{
        Properties datos = cargarInfoTorneo(arch);
        incializarEquipos(datos);
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
    
    
    
}
