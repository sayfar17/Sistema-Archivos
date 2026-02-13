/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MUsuario;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import view.Panels.*;
import view.*;

/**
 *
 * @author Farlo
 */
public class CUsuario implements ActionListener{
    public final VPrincipal v;
    public final PUsuario p;
    public final MUsuario m;
    DefaultTableModel t = new DefaultTableModel();
    public CUsuario(VPrincipal v, PUsuario p, MUsuario m){
        this.v=v;
        this.p=p;
        this.m=m;
        this.p.tabla.setModel(t);
        this.p.btnnuevo.addActionListener(this);
        this.p.btneditar.addActionListener(this);
        this.p.btnredit.addActionListener(this);
        this.p.btnbuscar.addActionListener(this);
        this.p.btnagregar.addActionListener(this);
        this.p.btneliminar.addActionListener(this);
        this.p.btnestado.addActionListener(this);
        this.p.btnsalir.addActionListener(this);
        this.p.txtbcar.addKeyListener(k);
        this.p.txtbest.addKeyListener(k);
        this.p.txtbuser.addKeyListener(k);
    }
    public void tabla(){
        m.mbd(t);
        p.btnagregar.setVisible(true);
        p.btnredit.setVisible(false);
        p.btneliminar.setVisible(false);
    }
    public void iniciar(){
        ShowJPanel(this.p);
        p.jPanel2.setVisible(false);
        p.pnltabla.setVisible(false);
        p.btnredit.setVisible(false);
        p.btneliminar.setVisible(false);
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
        if (e.getSource()==p.btnnuevo){  
            p.jPanel2.setVisible(true);
        }
        else if(e.getSource()==p.btnbuscar){
            p.pnltabla.setVisible(true);
            try{
               tabla();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnagregar){
            try{
                m.setCargo((String)(p.txtcargo.getSelectedItem()));
                m.setNom(p.txtnom.getText());
                m.setUser(p.txtuser.getText());
                m.setPass(p.txtcontra.getText());
                m.add();
                tabla();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btneditar){
            try{
                int f=p.tabla.getSelectedRow();
                m.setNom(p.tabla.getValueAt(f, 1).toString());
                m.setUser(p.tabla.getValueAt(f, 2).toString());
                m.setPass(p.tabla.getValueAt(f, 3).toString());
                p.btnredit.setVisible(true);
                p.btneliminar.setVisible(true);
                p.btnagregar.setVisible(false);
                p.txtnom.setText(m.getNom());
                p.txtuser.setText(m.getUser());
                p.txtcontra.setText(m.getPass());
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnredit){
            try{
                m.setCargo((String)(p.txtcargo.getSelectedItem()));
                m.setNom(p.txtnom.getText());
                m.setUser(p.txtuser.getText());
                m.setPass(p.txtcontra.getText());
                m.cambiar(p.tabla.getValueAt(p.tabla.getSelectedRow(), 2).toString());
                tabla();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnestado){
            try{
                m.change(p.tabla);
                tabla();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btneliminar){
            try{
                m.setCargo((String)(p.txtcargo.getSelectedItem()));
                m.setUser(p.txtuser.getText());
                m.setPass(p.txtcontra.getText());
                m.delete(p.tabla);
                tabla();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnsalir){
            ShowJPanel(new PanelPrincipal());
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
            if(e.getSource()==p.txtbcar){
                try {
                    m.buscar("CARGO",p.txtbcar.getText() , p.tabla);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(e.getSource()==p.txtbuser){
                try {
                    m.buscar("USUARIO",p.txtbuser.getText() , p.tabla);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(e.getSource()==p.txtbest){
                try {
                    m.buscar("ESTADO",p.txtbest.getText() , p.tabla);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
        
    }; 
}
