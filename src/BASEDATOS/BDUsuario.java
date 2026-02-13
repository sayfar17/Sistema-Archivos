/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BASEDATOS;

import java.sql.*;

/**
 *
 * @author Farlo
 */
public class BDUsuario {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;

    static String bd="XE";
    static String login="BD_USUARIOS";
    static String password="12345";
    static String url="jdbc:oracle:thin:@localhost:1521:XE";
    public static Connection Enlace(Connection conn)throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection(url, login, password);
        }
           catch(ClassNotFoundException e )
        {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
    public static Statement sta(Statement st)throws SQLException {
    conn=Enlace(conn);
    st=conn.createStatement();
    return st;
    }
    public static ResultSet EnlEst(ResultSet rs)throws SQLException {
        st=sta(st);
        rs=st.executeQuery("select * from USERS");
        return rs;
    }
}
