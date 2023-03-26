/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javasqlserver;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class Conexion {
    Connection conexion = null;
    
    String usuario = "samuel2";
    String contrasena = "123";
    String db = "dbPrueba";
    String ip = "localhost";
    String puerto = "1433";
    
    public Connection obtenerConexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String cadena = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+db+"";
                conexion = DriverManager.getConnection(cadena, usuario, contrasena);
                //JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
        return conexion;
    }
}
