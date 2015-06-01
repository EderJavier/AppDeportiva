/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Eder Javier
 */
public class Botones extends JPanel implements ActionListener{
    
    private static final String CARGAR_EQUIPOS = "CARGAR_EQUIPOS";
    private static final String REGISTRAR_RESULTADO = "REGISTRAR_RESULTADO";
    private AppDeportiva ventana;
    private JButton botonCargarEquipos;
    private JButton botonRegistrarResultado;
    
    
    public Botones(AppDeportiva ic){
        
        ventana = ic;
        botonCargarEquipos = new JButton("CARGAR EQUIPOS");
        botonCargarEquipos.setActionCommand(CARGAR_EQUIPOS);
        botonCargarEquipos.addActionListener(this);
        botonRegistrarResultado = new JButton("REGISTRAR PARTIDO");
        botonRegistrarResultado.setActionCommand(REGISTRAR_RESULTADO);
        botonRegistrarResultado.addActionListener(this);
        
        
        add(botonCargarEquipos);
        add(botonRegistrarResultado);
        
    }
    
    public void actionPerformed(ActionEvent evento){
        
        String comando = evento.getActionCommand();
        if(REGISTRAR_RESULTADO.equals(comando)){
            ventana.mostrarDialogoResultado();
        }
        else if(CARGAR_EQUIPOS.equals(comando)){
            ventana.cargarEquipos();
        }
    }
    
    public void desactivarBotonCargar(){
        
        botonCargarEquipos.setEnabled(false);
    }
    
}
