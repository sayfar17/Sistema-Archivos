/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.MReporte;
import view.*;
import view.Panels.*;
/**
 *
 * @author Farlo
 */
public class CReporte implements ActionListener{
    public final VPrincipal v;
    public final PReporte p;
    public final MReporte m;
    DefaultTableModel t = new DefaultTableModel();
    public CReporte(VPrincipal v, PReporte p, MReporte m){
        this.v=v;
        this.p=p;
        this.m=m;
        this.p.tablarep.setModel(t);
        this.p.btneliminar.addActionListener(this);
        this.p.btnguardar.addActionListener(this);
        this.p.btnbuscar.addActionListener(this);
        this.p.btnnuevo.addActionListener(this);
        this.p.btnguardar.addActionListener(this);
        this.p.btnsalir.addActionListener(this);
        this.p.jPanel1.setVisible(false);
        this.p.jPanel2.setVisible(false);
    }
    public void iniciar(){
        ShowJPanel(this.p);
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
            try{
                p.jPanel2.setVisible(true);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnbuscar){
            p.jPanel1.setVisible(true);
            try{
                m.mbd(t);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        else if(e.getSource()==p.btnguardar){
            
        }
        else if(e.getSource()==p.btneliminar){
            
        }
        else if(e.getSource()==p.btnsalir){
            ShowJPanel(new PanelPrincipal());
        }
    }
    
}
