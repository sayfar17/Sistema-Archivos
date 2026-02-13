/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.MBaseDatos;
import view.Panels.*;
import view.*;
/**
 *
 * @author Farlo
 */
public class CBaseDatos implements ActionListener{
    public final PBaseDatos p;
    public final VPrincipal vi;
    public final MBaseDatos m;
    DefaultTableModel t = new DefaultTableModel();
    public CBaseDatos(VPrincipal vi, PBaseDatos p, MBaseDatos m){
        this.vi=vi;
        this.p=p;
        this.m=m;
        this.p.tablarep.setModel(t);
        this.p.txtbaño.addKeyListener(k);
        this.p.txtbnexp.addKeyListener(k);
        this.p.txtbdmndd.addKeyListener(k);
        this.p.txtbdmndnt.addKeyListener(k);
        this.p.btneliminar.addActionListener(this);
        this.p.btnbuscar.addActionListener(this);
        this.p.btnnuevo.addActionListener(this);
        this.p.btnguardar.addActionListener(this);
        this.p.btnedit.addActionListener(this);
        this.p.btnmod.addActionListener(this);
        this.p.btnsalir.addActionListener(this);
    }
    public void iniciar(){
        ShowJPanel(this.p);
        p.jPanel1.setVisible(false);
        p.jPanel2.setVisible(false);
        p.btnmod.setVisible(false);
        p.btneliminar.setVisible(false);
    }
    public void ShowJPanel(JPanel p) {
        p.setSize(1260, 840);
        p.setLocation(0,0);
        vi.PanelBase.removeAll();
        vi.PanelBase.add(p, BorderLayout.CENTER);
        vi.PanelBase.revalidate();
        vi.PanelBase.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==p.btnnuevo){
            try{
                p.jPanel2.setVisible(true);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnbuscar){
            try{
                p.jPanel1.setVisible(true);
                m.mbd(t);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
         else if(e.getSource()==p.btnguardar){
            try {
                m.setAño(p.txtaño.getText());
                m.setCaja(p.txtcaja.getText());
                m.setDmndd(p.txtdmndd.getText());
                m.setDmndt(p.txtdmndt.getText());
                m.setExp(p.txtexp.getText());
                m.setJuez(p.txtjuez.getText());
                m.setMat(p.txtmateria.getText());
                m.setObs(p.txtobs.getText());
                m.insertar();
                m.mbd(t);
                p.txtaño.setText("");
                p.txtcaja.setText("");
                p.txtdmndd.setText("");
                p.txtdmndt.setText("");
                p.txtexp.setText("");
                p.txtjuez.setText("");
                p.txtmateria.setText("");
                p.txtmateria.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
        }
        else if(e.getSource()==p.btnmod){
            m.setAño(p.txtaño.getText());
            m.setCaja(p.txtcaja.getText());
            m.setDmndd(p.txtdmndd.getText());
            m.setDmndt(p.txtdmndt.getText());
            m.setExp(p.txtexp.getText());
            m.setJuez(p.txtjuez.getText());
            m.setMat(p.txtmateria.getText());
            m.setObs(p.txtobs.getText());
            try {
                m.change(p.tablarep);
                m.mbd(t);
                p.txtaño.setText("");
                p.txtcaja.setText("");
                p.txtdmndd.setText("");
                p.txtdmndt.setText("");
                p.txtexp.setText("");
                p.txtjuez.setText("");
                p.txtmateria.setText("");
                p.txtobs.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }           
        }
        else if(e.getSource()==p.btnedit){
            int f=p.tablarep.getSelectedRow();
            p.btnguardar.setVisible(false);
            p.btnmod.setVisible(true);
            p.btneliminar.setVisible(true);
            m.setAño(p.tablarep.getValueAt(f, 7).toString());
            m.setExp(p.tablarep.getValueAt(f, 1).toString());
            m.setDmndd(p.tablarep.getValueAt(f, 2).toString());
            m.setDmndt(p.tablarep.getValueAt(f, 3).toString());
            m.setJuez(p.tablarep.getValueAt(f, 4).toString());
            m.setMat(p.tablarep.getValueAt(f, 5).toString());
            m.setObs(p.tablarep.getValueAt(f, 6).toString());
            m.setCaja(p.tablarep.getValueAt(f, 8).toString());
            p.txtaño.setText(m.getAño());
            p.txtexp.setText(m.getExp());
            p.txtdmndd.setText(m.getDmndd());
            p.txtdmndt.setText(m.getDmndt());
            p.txtjuez.setText(m.getJuez());
            p.txtmateria.setText(m.getMat());
            p.txtobs.setText(m.getObs());
            p.txtcaja.setText(m.getCaja());
         }
        else if(e.getSource()==p.btneliminar){
            try {
                m.delete(p.tablarep);
                m.mbd(t);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnsalir){
            ShowJPanel(new PanelPrincipal());
        }
    }
    //Para la busqueda de datos en la tabla
    KeyListener k= new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource()==p.txtbaño){
                try {
                    m.buscar("AÑO",p.txtbaño.getText(),p.tablarep);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(e.getSource()==p.txtbnexp){
                try {
                    m.buscar("NÚMERO_EXPEDIENTE",p.txtbnexp.getText(),p.tablarep);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(e.getSource()==p.txtbdmndd){
                try {
                    m.buscar("DEMANDADO",p.txtbdmndd.getText(),p.tablarep);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(e.getSource()==p.txtbdmndnt){
                try {
                    m.buscar("DEMANDANTE",p.txtbdmndnt.getText(),p.tablarep);
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    };
}
