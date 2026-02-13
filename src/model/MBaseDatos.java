/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BASEDATOS.BDBaseDatos;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Farlo
 */

public class MBaseDatos {
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    String exp,caja,año,dmndd,dmndt,juez,mat,obs;
    String busa,buse,busdd,busdt;

    public MBaseDatos(){
    }
    
    public String getBusa() {
        return busa;
    }

    public void setBusa(String busa) {
        this.busa = busa;
    }

    public String getBuse() {
        return buse;
    }

    public void setBuse(String buse) {
        this.buse = buse;
    }

    public String getBusdd() {
        return busdd;
    }

    public void setBusdd(String busdd) {
        this.busdd = busdd;
    }

    public String getBusdt() {
        return busdt;
    }

    public void setBusdt(String busdt) {
        this.busdt = busdt;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getDmndd() {
        return dmndd;
    }

    public void setDmndd(String dmndd) {
        this.dmndd = dmndd;
    }

    public String getDmndt() {
        return dmndt;
    }

    public void setDmndt(String dmndt) {
        this.dmndt = dmndt;
    }

    public String getJuez() {
        return juez;
    }

    public void setJuez(String juez) {
        this.juez = juez;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    public void mbd(DefaultTableModel modelo){
        try {
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            //ejecuta la conexion
            conn=BDBaseDatos.Enlace(conn);
            //ejecuta la consulta
            rs=BDBaseDatos.EnlEst(rs);
            //volcamos los resultados de rs a rsmetadata
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las columnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
            }
            rs.close();
            //conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void insertar() throws SQLException{
        conn=BDBaseDatos.Enlace(conn);
        String sqlinsertar="insert into ARCHIVOS_JUDICIALES values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, String.valueOf((int)(Math.random()*100000+100)));
        psta.setString(2, exp);
        psta.setString(3, dmndd);
        psta.setString(4, dmndt);
        psta.setString(5, juez);
        psta.setString(6, mat);
        psta.setString(7, obs);
        psta.setString(8, año);
        psta.setString(9, caja);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Registro Guardado satisfactoriamente");
    }
    public void change(JTable ta) throws SQLException{
        conn=BDBaseDatos.Enlace(conn);
        int f=ta.getSelectedRow();
        String v=ta.getValueAt(f, 0).toString();
        String sqlc ="UPDATE ARCHIVOS_JUDICIALES SET NÚMERO_EXPEDIENTE=?,DEMANDADO=?,DEMANDANTE=?,JUEZ=?,MATERIA=?,OBSERVACIONES=?,AÑO=?,\"N°_CAJA\"=?"
                + " WHERE ID=?";
        PreparedStatement psta=conn.prepareStatement(sqlc);
        psta.setString(1, exp);
        psta.setString(2, dmndd);
        psta.setString(3, dmndt);
        psta.setString(4, juez);
        psta.setString(5, mat);
        psta.setString(6, obs);
        psta.setString(7, año);
        psta.setString(8, caja);
        psta.setString(9, v);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null,"Modificado Correctamente");
    }
    public void buscar(String b, String a, JTable modelo) throws SQLException{  
        conn=BDBaseDatos.Enlace(conn);
        int v=0,c=0;
        String Titulos[]={"ID","NÚMERO_EXPEDIENTE","DEMANDADO","DEMANDANTE","JUEZ","MATERIA","OBSERVACIONES","AÑO","N°_CAJA"};
        Statement st_con=conn.createStatement();
        rs=st_con.executeQuery("SELECT COUNT(*) FROM ARCHIVOS_JUDICIALES WHERE "+b+" LIKE '"+a+"%'");
        if(rs.next()){
            v=rs.getInt(1);
        }
        String M_Datos[][]=new String [v][9];
        rs=st_con.executeQuery("SELECT * FROM ARCHIVOS_JUDICIALES WHERE "+b+" LIKE '"+a+"%'");
        while (rs.next()){
            M_Datos[c][0]=rs.getString(Titulos[0]);
            M_Datos[c][1]=rs.getString(Titulos[1]);
            M_Datos[c][2]=rs.getString(Titulos[2]);
            M_Datos[c][3]=rs.getString(Titulos[3]);
            M_Datos[c][4]=rs.getString(Titulos[4]);
            M_Datos[c][5]=rs.getString(Titulos[5]);
            M_Datos[c][6]=rs.getString(Titulos[6]);
            M_Datos[c][7]=rs.getString(Titulos[7]);
            M_Datos[c][8]=rs.getString(Titulos[8]);
            c++;
        }
        DefaultTableModel dtm_datos= new DefaultTableModel(M_Datos, Titulos){};
        modelo.setModel(dtm_datos);
    }
    public void delete(JTable ta) throws SQLException{
        conn=BDBaseDatos.Enlace(conn);
        int f=ta.getSelectedRow();
        String v=ta.getValueAt(f, 0).toString();
        String sqleliminar = "delete from ARCHIVOS_JUDICIALES where ID = ?";
        PreparedStatement psta=conn.prepareStatement(sqleliminar);
        psta.setString(1, v);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente del Sistema");
    }
}
