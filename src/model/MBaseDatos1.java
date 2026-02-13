/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BASEDATOS.BDBaseDatos1;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Farlo
 */
public class MBaseDatos1 {
    public MBaseDatos1(){}
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    String id,libro,año,folio,muni,decla,nacido,obs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getMuni() {
        return muni;
    }

    public void setMuni(String muni) {
        this.muni = muni;
    }

    public String getDecla() {
        return decla;
    }

    public void setDecla(String decla) {
        this.decla = decla;
    }

    public String getNacido() {
        return nacido;
    }

    public void setNacido(String nacido) {
        this.nacido = nacido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void mbd(DefaultTableModel modelo) {
        try {
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            //ejecuta la conexion
            conn=BDBaseDatos1.Enlace(conn);
            //ejecuta la consulta
            rs=BDBaseDatos1.EnlEst(rs);
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
    
    public void add() throws SQLException{
        conn=BDBaseDatos1.Enlace(conn);
        String sqlinsertar="insert into NACIMIENTOS values (?,?,?,?,?,?,?,?)";
        PreparedStatement psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, String.valueOf((int)(Math.random()*100+1)));
        psta.setString(2, libro);
        psta.setString(3, año);
        psta.setString(4, folio);
        psta.setString(5, decla);
        psta.setString(6, nacido);
        psta.setString(7, obs);
        psta.setString(8, muni);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Partida registrada correctamente en el sistema");
    }
    
    public void change() throws SQLException{
        conn=BDBaseDatos1.Enlace(conn);
        String sqlc ="UPDATE NACIMIENTOS SET \"N°_LIBRO\"=?,AÑO_DE_ACTA_DE_NACIMIENTO=?,\"N°_FOLIO\"=?,DECLARANTE=?,NOMBRE_DEL_NACIDO=?,OBSERVACIONES=?,MUNICIPALIDAD=?"
                + " WHERE ID_LIBRO=?";
        PreparedStatement psta=conn.prepareStatement(sqlc);
        psta.setString(1, libro);
        psta.setString(2, año);
        psta.setString(3, folio);
        psta.setString(4, decla);
        psta.setString(5, nacido);
        psta.setString(6, obs);
        psta.setString(7, muni);
        psta.setString(8, id);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null,"Modificado Correctamente");
    }
    
    public void buscar(String b, String a, JTable modelo) throws SQLException{  
        conn=BDBaseDatos1.Enlace(conn);
        int v=0,c=0;
        String Titulos[]={"ID_LIBRO","N°_LIBRO","AÑO_DE_ACTA_DE_NACIMIENTO","N°_FOLIO","DECLARANTE","NOMBRE_DEL_NACIDO","OBSERVACIONES","MUNICIPALIDAD","FECHA"};
        Statement st_con=conn.createStatement();
        rs=st_con.executeQuery("SELECT COUNT(*) FROM NACIMIENTOS WHERE \""+b+"\" LIKE '"+a+"%'");
        if(rs.next()){
            v=rs.getInt(1);
        }
        String M_Datos[][]=new String [v][9];
        rs=st_con.executeQuery("SELECT * FROM NACIMIENTOS WHERE \""+b+"\" LIKE '"+a+"%'");
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
        conn=BDBaseDatos1.Enlace(conn);
        int f=ta.getSelectedRow();
        String v=ta.getValueAt(f, 0).toString();
        String v1=ta.getValueAt(f, 5).toString();
        String sqleliminar = "delete from NACIMIENTOS where ID_LIBRO = ? AND NOMBRE_DEL_NACIDO = ?";
        PreparedStatement psta=conn.prepareStatement(sqleliminar);
        psta.setString(1, v);
        psta.setString(2,v1);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente del Sistema");
    }
    
    
}
