/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StrategyE;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javaapplication2.Empatado;
import javaapplication2.Equipo;
import javaapplication2.Ganado;
import javaapplication2.Partido;
import javaapplication2.Perdido;

/**
 *
 * @author EQUIPO
 */
public class Consultador {

//    public void consulta(Partido p,int equipo) {
//        StrategyE strategy = null;
//        strategy.consul(equipo);
    //  System.out.println(String.format("Cadena [%s] consulta a [%s]", new Object[]{equipo, resultado}));
//    }
    public static final int SIN_JUGAR = -1;
    public static final int INVALIDO = -2;
    private int maxEquipos;
    private int[][] tablaGoles;
    private Equipo[] equipos;

    public Consultador(File arch) throws Exception {
        Properties datos = cargarInfoCampeonato(arch);
        inicializarEquipos(datos);
        inicializarTablaGoles();
    }

    private Properties cargarInfoCampeonato(File arch) throws Exception {
        Properties datos = new Properties();
        FileInputStream in = new FileInputStream(arch);
        try {
            datos.load(in);
            in.close();
        } catch (Exception e) {
            throw new Exception("Formato inválido");
        }
        return datos;
    }

    private void inicializarEquipos(Properties datos) {
        String strNumeroEquipos = datos.getProperty("campeonato.equipos");
        maxEquipos = Integer.parseInt(strNumeroEquipos);
        // Crea el arreglo de equipos, reservando el espacio definido en la propiedad "campeonato.equipos"
        equipos = new Equipo[maxEquipos];
        // Lee el nombre de cada equipo de la respectiva propiedad y crea el objeto que lo representa
        for (int i = 0; i < maxEquipos; i++) {
            String nombreEquipo = datos.getProperty("campeonato.nombre" + i);
            equipos[ i] = new Equipo(nombreEquipo);
        }
    }

    private void inicializarTablaGoles() {
        // Crea la matriz que contiene la tabla de goles
        tablaGoles = new int[maxEquipos][maxEquipos];
        // Inicializa todos los marcadores, dejando en la diagonal una marca especial
        for (int i = 0; i < maxEquipos; i++) {
            for (int j = 0; j < maxEquipos; j++) {
                if (i != j) {
                    tablaGoles[ i][ j] = SIN_JUGAR;
                } else {
                    tablaGoles[ i][ j] = INVALIDO;
                }
            }
        }
    }
    
    public void registrarResultado(int eq1, int eq2, int gol1, int gol2) throws Exception {
        if (eq1 < 0 || eq1 >= maxEquipos || eq2 < 0 || eq2 >= maxEquipos) {
            throw new Exception("Equipos incorrectos");
        }
        if (eq1 == eq2) {
            throw new Exception("Son el mismo equipo");
        }
        if (gol1 < 0 || gol2 < 0) {
            throw new Exception("Número de goles inválido");
        }
        if (tablaGoles[ eq1][ eq2] != SIN_JUGAR || tablaGoles[ eq2][ eq1] != SIN_JUGAR) {
            throw new Exception("Partido ya jugado");
        }
        tablaGoles[ eq1][ eq2] = gol1;
        tablaGoles[ eq2][ eq1] = gol2;
    }
    
    public int darGolesMarcados(int eq1, int eq2) {
        return tablaGoles[ eq1][ eq2];
    }

    /**
     * Retorna el número de equipos del campeonato.
     *
     * @return número de equipos del campeonato.
     */
    public int darNumeroEquipos() {
        return maxEquipos;
    }

    /**
     * Retorna el equipo cuyo número se pasa como parámetro.
     *
     * @param eq Número del equipo. eq es un número de equipo válido.
     * @return el equipo cuyo número se pasa como parámetro.
     */
    public Equipo darEquipo(int eq) {
        return equipos[ eq];
    }
    
        public int darPartidosGanados(int equipo){
        int ganados = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO && tablaGoles[ equipo ][ i ] > tablaGoles[ i ][ equipo ])
                ganados++;
        return ganados;
    }
    
//    public int darPartidosPerdidos(int equipo){
//        int perdidos = 0;
//        for(int i = 0; i < maxEquipos; i++)
//            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO && tablaGoles[ equipo ][ i ] < tablaGoles[ i ][ equipo ])
//                perdidos++;
//        return perdidos;
//    }
    
    public int darPartidosEmpatados(int equipo){
        int empatados = 0;
        for(int i = 0; i < maxEquipos; i++)
            if(tablaGoles[ equipo ][ i ] != SIN_JUGAR && tablaGoles[ equipo ][ i ] != INVALIDO && tablaGoles[ equipo ][ i ] == tablaGoles[ i ][ equipo ])
                empatados++;
        return empatados;
    }
    
    public int darPartidosPerdidos(int equipo) {
        int perdidos = 0;
        for (int i = 0; i < maxEquipos; i++) {
            if (tablaGoles[ equipo][ i] != SIN_JUGAR && tablaGoles[ equipo][ i] != INVALIDO && tablaGoles[ equipo][ i] < tablaGoles[ i][ equipo]) {
                perdidos++;
            }
        }
        return perdidos;
    }

    public int consulta(Partido p, int equipo) {
        StrategyE strategy = null;
        if (p instanceof Ganado) {
            strategy = new Partidosganados();
        } else if (p instanceof Empatado) {
            strategy = new Partidosempatados();
        }else if (p instanceof Perdido) {
            strategy = new Partidosperdidos();
        }
        return strategy.consul(equipo);
    }
    
    public int darPartidosJugados(int equipo) {
        int jugados = 0;
        for (int i = 0; i < maxEquipos; i++) {
            if (tablaGoles[ equipo][ i] != SIN_JUGAR && tablaGoles[ equipo][ i] != INVALIDO) {
                jugados++;
            }
        }
        return jugados;
    }

    /**
     * @param equipo Número del equipo. equipo es un número válido.
     * @return número de goles en contra. número >= 0.
     */
    public int darGolesEnContra(int equipo) {
        int golesEnContra = 0;
        for (int i = 0; i < maxEquipos; i++) {
            if (tablaGoles[ equipo][ i] != SIN_JUGAR && tablaGoles[ equipo][ i] != INVALIDO) {
                golesEnContra += tablaGoles[ i][ equipo];
            }
        }
        return golesEnContra;
    }

    /**
     * @param equipo Número del equipo. equipo es un número válido.
     * @return número de goles a favor. número >= 0.
     */
    public int darGolesAFavor(int equipo) {
        int golesAFavor = 0;
        for (int i = 0; i < maxEquipos; i++) {
            if (tablaGoles[ equipo][ i] != SIN_JUGAR && tablaGoles[ equipo][ i] != INVALIDO) {
                golesAFavor += tablaGoles[ equipo][ i];
            }
        }
        return golesAFavor;
    }

    /**
     * Retorna el número total de puntos que tiene un equipo.
     *
     * @param equipo número del equipo. equipo es un número válido.
     * @return número total de puntos en el campeonato que tiene el equipo.
//     * número >= 0.
//     */
    public int darTotalPuntos(int equipo) {
//        Consultador cons = null;
//        Ganado g = new Ganado();
//        Empatado e = new Empatado();
//        cons.consulta(g, equipo);
////
//          return 3 * cons.consulta(g, equipo) + cons.consulta(e, equipo);
        return 3 * darPartidosGanados(equipo) + darPartidosEmpatados(equipo);
//        return 0;
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------
    /**
     * Es el punto de extensión 1
     *
     * @return Respuesta 1
     */
    public String metodo1() {
        return "Respuesta 1";
    }

    /**
     * Es el punto de extensión 2
     *
     * @return Respuesta 2
     */
    public String metodo2() {
        return "Respuesta 2";
    }
}
