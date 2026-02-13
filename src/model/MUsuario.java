/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import BASEDATOS.BDUsuario;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.Panels.*;
import javax.swing.table.*;
/**
 *
 * @author Farlo
 */
public class MUsuario {
    public MUsuario(){}
    static Connection conn=null;
    static Statement s=null;
    static ResultSet rs=null;
    String user,pass,cargo, nom;

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void mbd(DefaultTableModel modelo){
        try {
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            //ejecuta la conexion
            conn=BDUsuario.Enlace(conn);
            //ejecuta la consulta
            rs=BDUsuario.EnlEst(rs);
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
        conn=BDUsuario.Enlace(conn);
        String sqlinsertar="insert into USERS values (?,?,?,?,?)";
        PreparedStatement psta=conn.prepareStatement(sqlinsertar);
        psta.setString(1, cargo);
        psta.setString(2, nom);
        psta.setString(3, user);
        psta.setString(4, pass);
        psta.setString(5, "Inactivo");
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Cuenta creada correctamente");
    }
    
    public void change(JTable ta) throws SQLException{
        conn=BDUsuario.Enlace(conn);
        int f=ta.getSelectedRow();
        String v=ta.getValueAt(f, 2).toString();
        String sqlc ="UPDATE USERS SET ESTADO=? "+ " WHERE USUARIO=?";
        PreparedStatement psta=conn.prepareStatement(sqlc);
        psta.setString(1, "Activo");
        psta.setString(2, v);
        psta.execute();
        psta.close();
    }
    
    public void cambiar(String a) throws SQLException{
        conn=BDUsuario.Enlace(conn);
        String sqlca="UPDATE USERS SET CARGO=?,DATOS=?,USUARIO=?,CONTRASEÑA=?"+"WHERE USUARIO = ?";
        PreparedStatement psta=conn.prepareStatement(sqlca);
        psta.setString(1, cargo);
        psta.setString(2, nom);
        psta.setString(3, user);
        psta.setString(4, pass);
        psta.setString(5, a);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Cuenta modificada correctamente");
    }
    
    public void buscar(String b, String a, JTable modelo) throws SQLException{  
        conn=BDUsuario.Enlace(conn);
        int v=0,c=0;
        String Titulos[]={"CARGO","DATOS","USUARIO","CONTRASEÑA","ESTADO"};
        Statement st_con=conn.createStatement();
        rs=st_con.executeQuery("SELECT COUNT(*) FROM USERS WHERE "+b+" LIKE '"+a+"%'");
        if(rs.next()){
            v=rs.getInt(1);
        }
        String M_Datos[][]=new String [v][5];
        rs=st_con.executeQuery("SELECT * FROM USERS WHERE "+b+" LIKE '"+a+"%'");
        while (rs.next()){
            M_Datos[c][0]=rs.getString(Titulos[0]);
            M_Datos[c][1]=rs.getString(Titulos[1]);
            M_Datos[c][2]=rs.getString(Titulos[2]);
            M_Datos[c][3]=rs.getString(Titulos[3]);
            M_Datos[c][4]=rs.getString(Titulos[4]);
            c++;
        }
        DefaultTableModel dtm_datos= new DefaultTableModel(M_Datos, Titulos){};
        modelo.setModel(dtm_datos);
    }
    
    public void delete(JTable ta) throws SQLException{
        conn=BDUsuario.Enlace(conn);
        int f=ta.getSelectedRow();
        String v=ta.getValueAt(f, 2).toString();
        String v1=ta.getValueAt(f, 3).toString();
        String sqleliminar = "delete from USERS where USUARIO = ? AND CONTRASEÑA = ?";
        PreparedStatement psta=conn.prepareStatement(sqleliminar);
        psta.setString(1, v);
        psta.setString(2,v1);
        psta.execute();
        psta.close();
        JOptionPane.showMessageDialog(null, "Eliminado Correctamente del Sistema");
    }
}
