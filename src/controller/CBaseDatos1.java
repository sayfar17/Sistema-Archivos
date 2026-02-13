/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MBaseDatos1;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import model.*;
import view.Panels.*;
import view.VPrincipal;

/**
 *
 * @author Farlo
 */
public class CBaseDatos1 implements ActionListener{
    public final VPrincipal v;
    public final PBaseDatos1 p;
    public final MBaseDatos1 m;
    DefaultTableModel t = new DefaultTableModel();
    public CBaseDatos1(VPrincipal v, PBaseDatos1 p, MBaseDatos1 m){
        this.v=v;
        this.p=p;
        this.m=m;
        this.p.tabla.setModel(t);
        this.p.btnnuevo.addActionListener(this);
        this.p.btnbuscar.addActionListener(this);
        this.p.btnsalir.addActionListener(this);
        this.p.btnguardar.addActionListener(this);
        this.p.btnedit.addActionListener(this);
        this.p.btnmod.addActionListener(this);
        this.p.btneliminar.addActionListener(this);
        this.p.txtbdec.addKeyListener(k);
        this.p.txtbfol.addKeyListener(k);
        this.p.txtblib.addKeyListener(k);
        this.p.txtbnac.addKeyListener(k);
    }
    public void iniciar(){
        ShowJPanel(this.p);
        p.jPanel2.setVisible(false);
        p.jPanel3.setVisible(false);
        p.btnmod.setVisible(false);
        p.btneliminar.setVisible(false);
    }
    
    public void tabla(){
        m.mbd(t);
        p.btnmod.setVisible(false);
        p.btneliminar.setVisible(false);
        p.btnguardar.setVisible(true);
    }
    
    public void ShowJPanel(JPanel p) {
        p.setSize(1260, 840);
        p.setLocation(0,0);
        v.PanelBase.removeAll();
        v.PanelBase.add(p, BorderLayout.CENTER);
        v.PanelBase.revalidate();
        v.PanelBase.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==p.btnnuevo){
            p.jPanel3.setVisible(true);
        }
        else if(e.getSource()==p.btnbuscar){
            p.jPanel2.setVisible(true);
            try{
               tabla();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnsalir){
            ShowJPanel(new PanelPrincipal());
        }
        else if(e.getSource()==p.btnguardar){
            try {
                m.setLibro(p.txtlib.getText());
                m.setAño(p.txtaño.getText());
                m.setFolio(p.txtfol.getText());
                m.setDecla(p.txtdec.getText());
                m.setNacido(p.txtnom.getText());
                m.setObs(p.txtobs.getText());
                m.setMuni(p.txtmuni.getText());
                m.add();
                tabla();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnmod){
            try {
                m.setLibro(p.txtlib.getText());
                m.setAño(p.txtaño.getText());
                m.setFolio(p.txtfol.getText());
                m.setDecla(p.txtdec.getText());
                m.setNacido(p.txtnom.getText());
                m.setObs(p.txtobs.getText());
                m.setMuni(p.txtmuni.getText());
                m.setId((String) p.tabla.getValueAt(p.tabla.getSelectedRow(), 0));
                m.change();
                tabla();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }           
        }
        else if(e.getSource()==p.btnedit){
            int f=p.tabla.getSelectedRow();
            p.btnguardar.setVisible(false);
            p.btnmod.setVisible(true);
            p.btneliminar.setVisible(true);
            m.setLibro(p.tabla.getValueAt(f, 1).toString());
            m.setAño(p.tabla.getValueAt(f, 2).toString());
            m.setFolio(p.tabla.getValueAt(f, 3).toString());
            m.setDecla(p.tabla.getValueAt(f, 4).toString());
            m.setNacido(p.tabla.getValueAt(f, 5).toString());
            m.setObs(p.tabla.getValueAt(f, 6).toString());
            m.setMuni(p.tabla.getValueAt(f, 7).toString());
            p.txtaño.setText(m.getAño());
            p.txtlib.setText(m.getLibro());
            p.txtfol.setText(m.getFolio());
            p.txtdec.setText(m.getDecla());
            p.txtnom.setText(m.getNacido());
            p.txtobs.setText(m.getObs());
            p.txtmuni.setText(m.getMuni());
         }
        else if(e.getSource()==p.btneliminar){
            try {
                m.delete(p.tabla);
                tabla();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    KeyListener k = new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getSource()==p.txtblib){
                try {
                    m.buscar("N°_LIBRO",p.txtblib.getText() , p.tabla);
                } catch (SQLException ex) {
                    Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource()==p.txtbfol){
                try {
                    m.buscar("N°_FOLIO",p.txtbfol.getText() , p.tabla);
                } catch (SQLException ex) {
                    Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource()==p.txtbdec){
                try {
                    m.buscar("DECLARANTE",p.txtbdec.getText() , p.tabla);
                } catch (SQLException ex) {
                    Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource()==p.txtbnac){
                try {
                    m.buscar("NOMBRE_DEL_NACIDO",p.txtbnac.getText() , p.tabla);
                } catch (SQLException ex) {
                    Logger.getLogger(CUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    };
}
