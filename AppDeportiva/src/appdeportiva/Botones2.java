/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdeportiva;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Eder Javier
 */
public class Botones2 extends JPanel implements ActionListener{
    
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
    
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( OK.equals( comando ) )
        {
            dialogo.registrarPartido( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            dialogo.setVisible( false );
        }
    }
    
}
