/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javasqlserver;

import java.util.ArrayList;
import javasqlserver.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class JavaSqlServer {

    static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    
    public static void main(String[] args) {
        
        Conexion con = new Conexion();
        Connection connection = con.obtenerConexion();
        DataProvider dP = new DataProvider();
        Usuario usuario;
        Scanner nomuser;
        Scanner nom;
        Scanner correo;
        String usuarioDig;
        String nomDig;
        String correoDig;
        
        try {           
        
        int option = dP.IngresarOpciones();
            
        while (option != 6) {
            switch (option) {
                case 1:
                    System.out.flush();
                    System.out.println("DIGITANDO NUEVO USUARIO");
                    System.out.println("Ingrese usuario: ");
                    nomuser = new Scanner(System.in);
                    usuarioDig = nomuser.next();
                    System.out.println("Ingrese nombre: ");
                    nom = new Scanner(System.in);
                    nomDig = nom.next();
                    System.out.println("Ingrese correo: ");
                    correo = new Scanner(System.in);
                    correoDig = correo.next();
                    usuario = new Usuario(usuarioDig, nomDig, correoDig);
                    dP.insertarUsuario(connection, usuario);
                    option = dP.IngresarOpciones();
                    break;
                case 2:
                    System.out.flush();
                    System.out.println("DETALLE DE USUARIO");
                    System.out.println("Ingrese usuario: ");
                    nomuser = new Scanner(System.in);
                    usuarioDig = nomuser.next();
                    dP.obtenerUsuario(connection, usuarioDig);
                    option = dP.IngresarOpciones();
                    break;
                case 3:
                    System.out.flush();
                    System.out.println("LISTA DE USUARIOS");
                    dP.obtenerUsuarios(connection);
                    option = dP.IngresarOpciones();
                    break;
                case 4:
                    System.out.flush();
                    System.out.println("ACTUALIZANDO USUARIO");
                    System.out.println("Ingrese usuario: ");
                    nomuser = new Scanner(System.in);
                    usuarioDig = nomuser.next();
                    System.out.println("Ingrese nombre: ");
                    nom = new Scanner(System.in);
                    nomDig = nom.next();
                    System.out.println("Ingrese correo: ");
                    correo = new Scanner(System.in);
                    correoDig = correo.next();
                    usuario = new Usuario(usuarioDig, nomDig, correoDig);
                    dP.actualizarUsuario(connection, usuario);
                    option = dP.IngresarOpciones();
                    break;
                case 5:
                    System.out.flush();
                    System.out.println("ELIMINANDO USUARIO");
                    System.out.println("Ingrese usuario: ");
                    nomuser = new Scanner(System.in);
                    usuarioDig = nomuser.next();
                    dP.borrarUsuario(connection,usuarioDig);
                    option = dP.IngresarOpciones();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    throw new AssertionError();
            }         
        }  
        } catch (Exception e) {
            System.err.println("Error: "+e);
        }     
        
    }   
    
    
}
