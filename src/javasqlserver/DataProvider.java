/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class DataProvider {
    
    static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    Conexion con = new Conexion();
    Connection connection = con.obtenerConexion();    
    
    public static void insertarUsuario(Connection conexion, Usuario usuario){
        
        String sql = "INSERT INTO usuarios VALUES(?,?,?)";
        
        try {
                PreparedStatement statement = conexion.prepareStatement(sql);
                statement.setString(1, usuario.usuario);
                statement.setString(2, usuario.nombre);
                statement.setString(3, usuario.correo);
                
                int registroAdd = statement.executeUpdate();
                
                System.out.flush(); 
                
                if (registroAdd > 0) {
                System.out.println("REGSITRO EXITOSO");
                //JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                //IngresarOpciones();
                //JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            IngresarOpciones();
        }
    }
    
    public static List<Usuario> obtenerUsuarios(Connection conexion){
        
        String sql = "SELECT * FROM usuarios;";
        
        try {
            
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listaUsuarios.add(
                        new Usuario(
                   rs.getString("usuario"),
                   rs.getString("usuario"),
                   rs.getString("usuario"))
                );                
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
            
            IngresarOpciones();
        }
        
        mostrarLista(listaUsuarios);
        
        return listaUsuarios;
    }
    
    public static void obtenerUsuario(Connection conexion, String user){
    
        String sql = "SELECT * FROM usuarios WHERE usuario='"+user+"'; ";
        
        try {
                Statement statement = conexion.createStatement();
                ResultSet rs = statement.executeQuery(sql);  
                
                while (rs.next()){
                    
                    System.out.println(
                            "Usuario: "+rs.getString("usuario")+
                            " , Nombre: "+rs.getString("nombre")+
                            " , Correo: "+rs.getString("correo")
                    );
                    
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
    public static void actualizarUsuario(Connection conexion, Usuario user){
        
        String sql = "UPDATE usuarios SET nombre=?, correo=? WHERE usuario=?;";
        
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, user.nombre);
           statement.setString(2, user.correo);
           statement.setString(3, user.usuario);
           
           int registroActualizado = statement.executeUpdate();
           
            if (registroActualizado > 0) {                 
                System.out.println("Se actualizo el registro exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            IngresarOpciones();
        }
        
    }
    
    public static void borrarUsuario(Connection conexion, String user){
        try {
                String sql = "DELETE FROM usuarios WHERE usuario=?;";
                
                PreparedStatement statement = conexion.prepareStatement(sql);
                statement.setString(1,user);
                
                int rowsDeleted = statement.executeUpdate();
                
                if (rowsDeleted > 0) {
                    
                    System.out.println("El registro se borro exitosamente");
                    //IngresarOpciones();
                    //JOptionPane.showMessageDialog(null, "El registro se borro exitosamente");
                }
                
        } catch (SQLException e) {
            e.printStackTrace();
            IngresarOpciones();
        }
    }
    
    public static void mostrarLista(List<Usuario> listaUsuarios){
        
        String cadena = "";
        
        for (Usuario usuario : listaUsuarios) {
            cadena = cadena+"Usuario: "+usuario.usuario+" , Nombre: "+usuario.nombre+" , Correo: "+usuario.correo+"\n";
        }
        
        System.out.println(cadena);
        IngresarOpciones();
    }
    
    public static int IngresarOpciones(){
        
        int option = 0;
        
            try {
                System.out.println("-------------------------------------");    
                System.out.println("");
                System.out.println("BIENVENIDO A SU SISTEMA CRUD JAVA");
                System.out.println("Opciones disponible");
                System.out.println("Insertar usuario: 1");
                System.out.println("Ver Usuario: 2");
                System.out.println("Lista usuarios: 3");
                System.out.println("Actualizar usuario: 4"); 
                System.out.println("Eliminar usuario: 5");
                System.out.println("Salir del sistema: 6");                
                System.out.println("-------------------------------------");    
        
                Scanner seleccion = new Scanner(System.in);

                option = seleccion.nextInt();
         
            } catch (Exception e) {
                System.err.println("Error: "+e);
            }  
            
            return option;
    }
}
