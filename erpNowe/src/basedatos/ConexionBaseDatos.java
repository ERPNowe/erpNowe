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
 private Connection conn = null;
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 public ConexionBaseDatos(String bd,
		 				  String usuario,
		 				  String pwd) {
  try{
     Class.forName("com.mysql.jdbc.Driver");
     this.conn = DriverManager.getConnection(URL + bd, usuario, pwd);
     if(conn != null)
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
    Statement sentenciaSql = null; //para crear el objeto que te pirmite hacer la sentencia
    ResultSet datos = null; //recoge los datos de la select
    
    
    try{
      sentenciaSql = conn.createStatement();//crear un objeto de tipo Statement para la conexion a la bd
      datos = sentenciaSql.executeQuery(query); //ejecuto la sentencia y se lo paso a datos
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
    boolean resultado = false; //lo utilizamos para saber si se ha podido ejecutar 
    try{   
      sentenciaSql = conn.createStatement();
      int filas = sentenciaSql.executeUpdate(query);
      if(filas != 0) resultado = true;
      System.out.println("se han insertado/borrado "+filas+" fila/s.");// Encontró una fila
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return resultado;
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 /**Cerrar la base de datos*/
 public void cerrarConexion(){
	 try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
 } 
}