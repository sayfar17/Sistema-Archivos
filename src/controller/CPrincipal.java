/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MUsuario;
import model.MReporte;
import model.MBaseDatos;
import model.MLogin;
import model.MBaseDatos1;
import java.awt.event.*;
import javax.swing.*;
import view.*;
import view.Panels.*;

/**
 *
 * @author Farlo
 */
public class CPrincipal implements ActionListener{
    public final VPrincipal vista;
    public CPrincipal(VPrincipal vista){
        this.vista=vista;
        this.vista.btninicio.addActionListener(this);
        this.vista.btnbasedatos.addActionListener(this);
        this.vista.btnusuario.addActionListener(this);
        this.vista.btnreporte.addActionListener(this);
        this.vista.btnsalir.addActionListener(this);
        this.vista.btnx.addActionListener(this);
    }
    public void iniciar(){
        vista.setTitle("Principal");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.btnreporte.setVisible(false);
        new CPP(this.vista,new PanelPrincipal()).iniciar();
    }
    public void salir(){
        vista.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==vista.btninicio){
            try{
                new CPP(this.vista,new PanelPrincipal()).iniciar();
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
        else if(e.getSource()==vista.btnbasedatos){
            try{
                String[] op={"Judiciales","Nacimientos"};
                int x=JOptionPane.showOptionDialog(null,
                        "¿Que registro desea llenar?", "Tipo de Registro",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null,op,null);
                if(x==0){
                    new CBaseDatos(this.vista,new PBaseDatos(),new MBaseDatos()).iniciar();
                }
                else{
                    new CBaseDatos1(this.vista,new PBaseDatos1(),new MBaseDatos1()).iniciar();
                }
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
        else if(e.getSource()==vista.btnusuario){
            try{
                new CUsuario(this.vista,new PUsuario(),new MUsuario()).iniciar();
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
        else if(e.getSource()==vista.btnreporte){
            try{
                new CReporte(this.vista,new PReporte(), new MReporte()).iniciar();
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
        else if(e.getSource()==vista.btnsalir){
            try{
                salir();
                new CLogin(new VLogin(), new MLogin()).iniciar();
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
        else if(e.getSource()==vista.btnx){
            try{
                salir();
                System.exit(0);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
    }
}
