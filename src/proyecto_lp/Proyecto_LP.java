/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_lp;
import model.MLogin;
import view.*;
import controller.*;
import javax.swing.*;

/**
 *
 * @author Farlo
 */
public class Proyecto_LP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        VLogin v= new VLogin();
        MLogin m= new MLogin();
        CLogin c= new CLogin(v,m);
        c.iniciar();
    }
}