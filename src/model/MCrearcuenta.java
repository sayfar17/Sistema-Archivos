/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import BASEDATOS.BDUsuario;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Farlo
 */
public class MCrearcuenta {
    static Connection conn=null;
    String user,pass,cargo,nomb;
    
    public MCrearcuenta(){
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }
    
    public void bdcrear() throws SQLException{
        conn=BDUsuario.Enlace(conn);
        String sqlinsertar="insert into USERS values (?,?,?,?,?)";
        PreparedStatement psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, cargo);
        psta.setString(2, nomb);
        psta.setString(3, user);
        psta.setString(4, pass);
        psta.setString(5, "Inactivo");
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Su cuenta será verificada/aprobada por un administrador");
    }
}
