/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramiro
 */
public class Administradorbd {
    Connection conexion = null;
    Statement sentencia = null;
    private Object campo_id;
   
    public void crearLibro() throws SQLException
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            sentencia = conexion.createStatement();
            
            String SQL = "CREATE TABLE LIBRO" + 
                    "(ID       INT     PRIMARY KEY NOT NULL,"+ 
                    " TITULO   TEXT    NOT NULL," +
                    " AUTOR    TEXT    NOT NULL," +
                    " FECHA    INT)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
            System.exit(0);
               
        }
        
        System.out.println("Tabla LIBRO creada!");
        
    }

    public void insertarLibro(String[] datos) //int id, String nombre, int precio
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            String SQL = "INSERT INTO LIBRO (ID, TITULO, AUTOR, FECHA) " +
                    "VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"','"+datos[3]+"')";
                    //"VALUES ('"+id+"','"+nombre+"','"+precio+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados de forma correcta en la tabla LIBRO!");
        
    }
    
    public void actualizarLibro(String[] datos) //String[] datos //int id, String nombre, int precio
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            //UPDATE LIBRO SET TITULO = 'Don Quijote' WHERE ID=1;
            String SQL = "UPDATE LIBRO SET TITULO='"+datos[1]+"', AUTOR='"+datos[2]+"', FECHA='"+datos[3]+"' WHERE ID= '"+datos[0]+"' ; "; 
                   // "VALUES ('"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[0]+"')";
                    //"VALUES ('"+id+"','"+titulo+"','"+autor+"','"+fecha+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos actualizados de forma correcta en la tabla LIBRO!");
        
    }
    
    
    public void eliminarLibro(String[] datos) //String[] datos //int id, String nombre, int precio
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            //UPDATE LIBRO SET TITULO = 'Don Quijote' WHERE ID=1;
            String SQL = "DELETE FROM LIBRO WHERE ID= '"+datos[0]+"' ; "; 
                   // "VALUES ('"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[0]+"')";
                    //"VALUES ('"+id+"','"+titulo+"','"+autor+"','"+fecha+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos eliminados de forma correcta en la tabla LIBRO!");
        
    }
    
    public void mostrarLibro()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM LIBRO");
            
            while(resultado.next())
            {
                int id = resultado.getInt("ID");
                String titulo = resultado.getString("TITULO");
                String autor = resultado.getString("AUTOR");
                int fecha = resultado.getInt("FECHA");
                
                System.out.println("ID            : " + id +
                                   "\nTITULO      : " + titulo +
                                   "\nAUTOR       : " + autor +
                                   "\nFECHA       : " + fecha + "\n");  
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
             
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        }
    
    
    public void mostrarLibro2()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM LIBRO");
            
            while(resultado.next())
            {
                int id = resultado.getInt("ID");
                String titulo = resultado.getString("TITULO");
                String autor = resultado.getString("AUTOR");
                int fecha = resultado.getInt("FECHA");
                
                System.out.println("ID            : " + id +
                                   "\nTITULO      : " + titulo +
                                   "\nAUTOR       : " + autor +
                                   "\nFECHA       : " + fecha + "\n");  
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
             
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        }
    


    ///////////////////////////////////////////////////////////////////////////////
    
    public void crearLector() throws SQLException
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            sentencia = conexion.createStatement();
            
            String SQL = "CREATE TABLE LECTOR" + 
                    "(RUT       INT     PRIMARY KEY NOT NULL,"+ 
                    " NOMBRE    TEXT    NOT NULL," +
                    " APELLIDO  TEXT    NOT NULL," +
                    " EDAD      INT)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error: " + e.getMessage());
            System.exit(0);
               
        }
        
        System.out.println("Tabla LECTOR creada!");
        
    }

    public void insertarLector(String[] datos) //int id, String nombre, int precio
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            String SQL = "INSERT INTO LECTOR (RUT, NOMBRE, APELLIDO, EDAD) " +
                    "VALUES ('"+datos[0]+"','"+datos[1]+"','"+datos[2]+"','"+datos[3]+"')";
                    //"VALUES ('"+id+"','"+nombre+"','"+precio+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos ingresados de forma correcta en la tabla LECTOR!");
        
    }

    public void mostrarLector()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM LECTOR");
            
            while(resultado.next())
            {
                int rut = resultado.getInt("RUT");
                String nombre = resultado.getString("NOMBRE");
                String apellido = resultado.getString("APELLIDO");
                int edad = resultado.getInt("EDAD");
                
                System.out.println("RUT          : " + rut +
                                   "\nNOMBRE     : " + nombre +
                                   "\nAPELLIDO   : " + apellido +
                                   "\nEDAD       : " + edad + "\n");  
            }
            
            resultado.close();
            sentencia.close();
            conexion.close();
             
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
        }
        
        }
    
    public void actualizarLector(String[] datos) //String[] datos //int id, String nombre, int precio
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            //UPDATE LIBRO SET TITULO = 'Don Quijote' WHERE ID=1;
            String SQL = "UPDATE LECTOR SET NOMBRE='"+datos[1]+"', APELLIDO='"+datos[2]+"', EDAD='"+datos[3]+"' WHERE RUT= '"+datos[0]+"' ; "; 
                   // "VALUES ('"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[0]+"')";
                    //"VALUES ('"+id+"','"+titulo+"','"+autor+"','"+fecha+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos actualizados de forma correcta en la tabla LECTOR!");
        
    }
    
    public void eliminarLector(String[] datos) //String[] datos //int id, String nombre, int precio
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            conexion.setAutoCommit(false);
            
            sentencia = conexion.createStatement();
            //UPDATE LIBRO SET TITULO = 'Don Quijote' WHERE ID=1;
            String SQL = "DELETE FROM LECTOR WHERE RUT= '"+datos[0]+"' ; "; 
                   // "VALUES ('"+datos[1]+"','"+datos[2]+"','"+datos[3]+"','"+datos[0]+"')";
                    //"VALUES ('"+id+"','"+titulo+"','"+autor+"','"+fecha+"')";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.err.println("Error : " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos eliminados de forma correcta en la tabla LECTOR!");
        
    }
    
//    public static void main(String[] args) throws SQLException{
//        Administradorbd a = new Administradorbd();
//        a.crear();
//    }
    
}
