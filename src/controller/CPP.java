/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import view.Panels.*;
import view.*;
/**
 *
 * @author Farlo
 */
public class CPP implements MouseListener{
    public final PanelPrincipal vista;
    public final VPrincipal v;
    public CPP(VPrincipal vi, PanelPrincipal pa){
        this.vista=pa;
        this.v=vi;
        this.vista.pnlhistoria.addMouseListener(this);
        this.vista.pnlfuncion.addMouseListener(this);
        this.vista.pnlnotarios.addMouseListener(this);
        this.vista.pnlservicio.addMouseListener(this);
        this.vista.pnlnorma.addMouseListener(this);
    }
    public void iniciar(){
        ShowJPanel(this.vista);
    }
    public void ShowJPanel(JPanel p) {
        p.setSize(1260, 840);
        p.setLocation(0,0);
        v.PanelBase.removeAll();
        v.PanelBase.add(p, BorderLayout.CENTER);
        v.PanelBase.revalidate();
        v.PanelBase.repaint();
    }
    
    public void tamaño1(JPanel b){
        b.setSize((b.getWidth()+15),(b.getHeight()+10));
        b.setLocation(b.getX()-7,b.getY()-9);
        b.setBackground(new Color(248,250,255));
    }
    
    public void tamaño2(JPanel b){
        b.setSize((b.getWidth()-15),(b.getHeight()-10));
        b.setLocation(b.getX()+7,b.getY()+9);
        b.setBackground(Color.WHITE);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==vista.pnlhistoria){
            try{
                ShowJPanel(new PNuestraHistoria());
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlfuncion){
            try{
                ShowJPanel(new PNuestraFunciones());
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlnotarios){
            try{
                ShowJPanel(new PNotariosAntiguos());
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlnorma){
            try{
                ShowJPanel(new PNormasDirect());
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlservicio){
            try{
                ShowJPanel(new PNuestrosServ());
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==vista.pnlhistoria){
            try{
                tamaño1(vista.pnlhistoria);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlfuncion){
            try{
                tamaño1(vista.pnlfuncion);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlnotarios){
            try{
                tamaño1(vista.pnlnotarios);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlnorma){
            try{
                tamaño1(vista.pnlnorma);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlservicio){
            try{
                tamaño1(vista.pnlservicio);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==vista.pnlhistoria){
            try{
                tamaño2(vista.pnlhistoria);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlfuncion){
            try{
                tamaño2(vista.pnlfuncion);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlnotarios){
            try{
                tamaño2(vista.pnlnotarios);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlnorma){
            try{
                tamaño2(vista.pnlnorma);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
        else if(e.getSource()==vista.pnlservicio){
            try{
                tamaño2(vista.pnlservicio);
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);   
            }
        }
    }  
}
