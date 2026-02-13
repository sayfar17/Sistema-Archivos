/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import BASEDATOS.BDReporte;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Farlo
 */
public class MReporte {
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    String exp,caja,año,dmndd,dmndt,juez,mat,obs;
    public MReporte(){
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
            conn=BDReporte.Enlace(conn);
            //ejecuta la consulta
            rs=BDReporte.EnlEst(rs);
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
}
