/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BASEDATOS.*;
import java.sql.*;

/**
 *
 * @author Farlo
 */
public class MLogin {
    static Connection conn=null;
    static ResultSet rs = null;
    public String user,contra;
    public boolean band;
    public MLogin(){
    }
    public void set_user(String val){
        this.user=val;
    }
    public String get_user(){
        return this.user;
    }
    public void set_pass(String val){
        this.contra=val;
    }
    public String get_pass(){
        return this.contra;
    }
    public boolean acceso() throws SQLException{
        conn=BDUsuario.Enlace(conn);
        String sqlacceso="select USUARIO, CONTRASEÑA from USERS where USUARIO = ? AND CONTRASEÑA = ? ";
        PreparedStatement psta=conn.prepareStatement(sqlacceso);
        psta.setString(1, user);
        psta.setString(2,contra);
        rs=psta.executeQuery();
        if(rs.next()){
            this.band=true;
        }
        else{
            this.band=false;
        }
        return this.band;
    }
    public int tipe() throws SQLException{
        conn=BDUsuario.Enlace(conn);
        ResultSet rs1=null;
        String s;
        String sqlcargo="select CARGO from USERS where USUARIO = ? AND CONTRASEÑA = ? ";
        PreparedStatement psta=conn.prepareStatement(sqlcargo);
        psta.setString(1, user);
        psta.setString(2,contra);
        rs1=psta.executeQuery();
        rs1.next();
        s=rs1.getString(1);
        return switch (s){
            case "Administrador"->1;
            case "Usuario"->2;
            default ->0;
        };
    }
    public boolean estado() throws SQLException{
        conn=BDUsuario.Enlace(conn);
        ResultSet rs1=null;
        String s;
        String sqlest="select ESTADO from USERS where USUARIO = ? AND CONTRASEÑA = ? ";
        PreparedStatement psta=conn.prepareStatement(sqlest);
        psta.setString(1, user);
        psta.setString(2,contra);
        rs1=psta.executeQuery();
        rs1.next();
        s=rs1.getString(1);
        if(s.equals("Activo")){
            return true;
        }
        else{
            return false;
        }
    }
}
