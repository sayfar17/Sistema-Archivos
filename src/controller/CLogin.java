/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MCrearcuenta;
import model.MLogin;
import java.awt.Desktop;
import view.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author Farlo
 */
public class CLogin implements ActionListener{
    private final VLogin vista;
    private final MLogin modelo;
    public CLogin (VLogin vista, MLogin modelo){
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btnentrar.addActionListener(this);
        this.vista.btncrear.addActionListener(this);
        this.vista.btnsalir.addActionListener(this);
        this.vista.btnfb.addActionListener(this);
        this.vista.btntwr.addActionListener(this);
        this.vista.btnytb.addActionListener(this);
        
    }
    public void iniciar(){
        vista.setTitle("Login");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    private void cerrar(){
        vista.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vista.btnentrar){
            try{
                modelo.set_user(vista.txtuser.getText());
                modelo.set_pass(vista.txtpass.getText());
                if(modelo.estado()==true){
                    if(modelo.acceso()==true){                 
                        JOptionPane.showMessageDialog(null,"Bienvenido","Inicio de Sesión",JOptionPane.INFORMATION_MESSAGE);
                        VPrincipal v= new VPrincipal();
                        CPrincipal c= new CPrincipal(v);
                        v.nombreUser.setText("    "+modelo.get_user());
                        if(modelo.tipe()==2){
                            v.btnusuario.setEnabled(false);
                            v.btnreporte.setEnabled(false);
                        }
                        c.iniciar();
                        cerrar();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Datos erroneos (usuario/contraseña)","ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Su cuenta aún no ha sido aprobada por un administrador","ERROR",JOptionPane.WARNING_MESSAGE);
                } 
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
        else if(e.getSource()==vista.btncrear){
            new CCrearcuenta(new VCrearCuenta(), new MCrearcuenta()).iniciar();
            cerrar();
        }
        else if(e.getSource()==vista.btnfb){
            if(java.awt.Desktop.isDesktopSupported()){
                java.awt.Desktop desktop=java.awt.Desktop.getDesktop();
                if(desktop.isSupported(Desktop.Action.BROWSE)){
                    try{
                        desktop.browse(new java.net.URI("https://es-la.facebook.com/"));
                        
                    }
                    catch(URISyntaxException | IOException a){
                        JOptionPane.showMessageDialog(null, a);
                    }
                }
            }
        }
        else if(e.getSource()==vista.btntwr){
            if(java.awt.Desktop.isDesktopSupported()){
                java.awt.Desktop desktop=java.awt.Desktop.getDesktop();
                if(desktop.isSupported(Desktop.Action.BROWSE)){
                    try{
                        desktop.browse(new java.net.URI("https://twitter.com/"));
                        
                    }
                    catch(URISyntaxException | IOException a){
                        JOptionPane.showMessageDialog(null, a);
                    }
                }
            }
        }
        else if(e.getSource()==vista.btnytb){
            if(java.awt.Desktop.isDesktopSupported()){
                java.awt.Desktop desktop=java.awt.Desktop.getDesktop();
                if(desktop.isSupported(Desktop.Action.BROWSE)){
                    try{
                        desktop.browse(new java.net.URI("https://www.youtube.com/"));
                        
                    }
                    catch(URISyntaxException | IOException a){
                        JOptionPane.showMessageDialog(null, a);
                    }
                }
            }
        }
        else if(e.getSource()==vista.btnsalir){
            try{
                cerrar();
                System.exit(0);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }
    }
}
