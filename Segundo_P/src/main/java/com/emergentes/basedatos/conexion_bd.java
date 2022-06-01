package com.emergentes.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion_bd {

    protected Connection conn = null;

    public conexion_bd() {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bd_seminiarios","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("******************Connected*************************************************************************************************");  
        }
        catch(Exception e)
        {
            System.out.println("ERROR"+e);
        }
    }
    public Connection conectar ()
    {
        return conn;
    }
    
    public void desconectar (){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion_bd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
