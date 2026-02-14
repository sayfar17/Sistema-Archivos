/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BASEDATOS;

import java.sql.*;
import proyecto_lp.Config;

/**
 *
 * @author Farlo
 */
public class BDReporte {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;

    static String bd="MySql";
    static String host = Config.get("DB_HOST");
    static String login = Config.get("DB_USER");
    static String password= Config.get("DB_PASS");
    static String url="jdbc:mysql://"+host+":3306/archivos_db";
    public static Connection Enlace(Connection conn)throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
        rs=st.executeQuery("select * from REPORTES");
        return rs;
    }
}
