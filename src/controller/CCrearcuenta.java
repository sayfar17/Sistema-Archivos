/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.MCrearcuenta;
import model.MLogin;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.*;
/**
 *
 * @author Farlo
 */
public class CCrearcuenta implements ActionListener{
    private final VCrearCuenta vista;
    private final MCrearcuenta model;
    public CCrearcuenta(VCrearCuenta v, MCrearcuenta m){
        this.vista=v;
        this.model=m;
        this.vista.btncrear.addActionListener(this);
        this.vista.btncuenta.addActionListener(this);
        this.vista.btnsalir.addActionListener(this);
    }
    public void iniciar(){
        vista.setLocationRelativeTo(null);
        vista.setTitle("Crear Cuenta");
        vista.setVisible(true);
    }
    public void cerrar(){
        vista.dispose();
        new CLogin(new VLogin(), new MLogin()).iniciar();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btncrear){
            try {
                model.setCargo((String) vista.txtcargo.getSelectedItem());
                model.setNomb(vista.txtnombre.getText());
                model.setUser(vista.txtuser.getText());
                model.setPass(vista.txtpass.getText());
                model.bdcrear();
                cerrar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
        }
        else if(e.getSource()==vista.btncuenta){
            cerrar();
        }
        else if(e.getSource()==vista.btnsalir){
            System.exit(0);
        }
    }
}
