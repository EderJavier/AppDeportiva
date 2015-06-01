/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Eder Javier
 */
public class Botones extends JPanel implements ActionListener{
    
    private static final String CARGAR_EQUIPOS = "CARGAR_EQUIPOS";
    private static final String REGISTRAR_RESULTADO = "REGISTRAR_RESULTADO";
    private static final String ORDENAR_TABLA = "ORDENAR_TABLA";
    private static final String SALIR = "SALIR";
    private AppDeportiva ventana;
    private JButton botonCargarEquipos;
    private JButton botonRegistrarResultado;
    private JButton botonOpcion1;
    private JButton botonOpcion2;
    
    
    public Botones(AppDeportiva ic){
        
        ventana = ic;
        botonCargarEquipos = new JButton("CARGAR EQUIPOS");
        botonCargarEquipos.setActionCommand(CARGAR_EQUIPOS);
        botonCargarEquipos.addActionListener(this);
        botonRegistrarResultado = new JButton("REGISTRAR PARTIDO");
        botonRegistrarResultado.setActionCommand(REGISTRAR_RESULTADO);
        botonRegistrarResultado.addActionListener(this);
        botonOpcion1 = new JButton("ORDENAR TABLA");
        botonOpcion1.setActionCommand(ORDENAR_TABLA);
        botonOpcion1.addActionListener(this);
        botonOpcion2 = new JButton("SALIR");
        botonOpcion2.setActionCommand(SALIR);
        botonOpcion2.addActionListener(this);
        
        
        add(botonCargarEquipos);
        add(botonRegistrarResultado);
        add( botonOpcion1 );
        add( botonOpcion2 );
        
    }
    
    public void actionPerformed(ActionEvent evento){
        
        String comando = evento.getActionCommand();
        if(REGISTRAR_RESULTADO.equals(comando)){
            ventana.mostrarDialogoResultado();
        }
        else if(CARGAR_EQUIPOS.equals(comando)){
            ventana.cargarEquipos();
        }
        else if(ORDENAR_TABLA.equals(comando)){
            ventana.reqFuncOpcion1();
        }
        else if(SALIR.equals(comando)){
            ventana.reqFuncOpcion2();
        }
    }
    
    public void desactivarBotonCargar(){
        
        botonCargarEquipos.setEnabled(false);
    }
    
}
