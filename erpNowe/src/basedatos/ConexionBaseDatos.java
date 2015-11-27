/**
 * Clase ConexionBaseDatos
 * @autor curso14/7803
 * @version 1.0
 * @since 18/11/2015
 * <br>
 * <p>
 * Esta clase se corresponde con los metodos principales 
 * de acceso y gestión a la base de datos mysql "nowedb"
 * </p>
 */

package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBaseDatos {

 static final String URL = "jdbc:mysql://localhost/";
 private Connection conexion = null;
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 public ConexionBaseDatos(String bd,
		 				  String usuario,
		 				  String pass) {
  try{
     Class.forName("com.mysql.jdbc.Driver");
     this.conexion = DriverManager.getConnection(URL + bd, usuario, pass);
     if(conexion != null)
     {
       System.out.println("Conexión a la base de datos " + URL + bd + " OK");
     }
   }
   catch(SQLException ex)
   {
      System.out.println("No se pudo conectar a la base de datos" + URL + bd);
   }
   catch(ClassNotFoundException ex)
   {
      System.out.println(ex);
   }
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 /** Consultas (executeQuery())*/
 public ResultSet getQuery(String query){
    Statement sentenciaSql = null; 
    ResultSet datos = null; 
    
    try{
      sentenciaSql = conexion.createStatement();
      datos = sentenciaSql.executeQuery(query);
    }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    return datos;
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 /**Insertar, Modificar, Borrar (executeUpdate())*/
 public boolean setQuery(String query){
    Statement sentenciaSql = null;
    boolean resultado = false; 
    try{   
      sentenciaSql = conexion.createStatement();
      int filas = sentenciaSql.executeUpdate(query);
      if(filas != 0) resultado = true;
      System.out.println("se han insertado/borrado "+filas+" fila/s.");
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return resultado;
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 /**Cerrar la conexion a la base de datos*/
 public void cerrarConexion(){
	 try {
		 conexion.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
 } 
}