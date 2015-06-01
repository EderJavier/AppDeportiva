/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import javax.swing.JButton;

/**
 *
 * @author Eder Javier
 */
public class Botones2 {
    
    private static final String OK = "OK";
    private static final String CANCELAR = "CANCELAR";
    private DialogoResultado dialogo;
    private JButton botonOk;
    private JButton botonCancelar;
    
    public Botones2(DialogoResultado dr){
        
        dialogo = dr;
        botonOk = new JButton("OK");
        botonOk.setActionCommand(OK);
        botonOk.addActionListener(this);
        botonCancelar = new JButton("CANCELAR");
        botonCancelar.setActionCommand(CANCELAR);
        botonCancelar.addActionListener(this);
        add(botonOk);
        add(botonCancelar);
    }
    
    public void
    
}
