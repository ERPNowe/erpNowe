package pruebaproyecto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Articulo {

	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "bd1";
	 static ConexionBaseDatos conexion = null;
	 static Scanner scanner = new Scanner(System.in);
	 
 public static void main(String[] args) {
	 // En caso de no tener contraseña pwd = ""
    conexion = new ConexionBaseDatos(bd, usuario, pwd);
    ventanaArticulo ventana=new ventanaArticulo();
    ventana.setVisible(true);
    
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 public static String consultaArticulo(){
	 	ResultSet datos;
	    String campo1, campo2, campo3, resultado ="";
	    datos = conexion.getQuery("SELECT * FROM articulos;");
	    try {
	      while(datos.next()){//es el metodo que permite ir recorriendo los datos
	    	  campo1 = datos.getString("codigo"); //podemos poner el nombre o un numero
	    	  campo2 = datos.getString("descripcion");
	    	  campo3 = datos.getString("precio");
	    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2 + "\t" + campo3 ; 
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	    return resultado; 
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 public static String insertarArticulo(String descripcion, String precio){
	 boolean ok = false;
	 String resultado = null;
	 try {
			 ok = conexion.setQuery("INSERT INTO articulos(descripcion,precio)"
					+ " VALUES ('" + descripcion + "'," + precio + ")");
			 if (ok) 
				 resultado="Se insertó registro correctamente";
			 else 
				resultado ="No se pudo insertar";	 
		} 
	 
	 catch(Exception e){ e.printStackTrace(); }
	return resultado;
 }
 
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 
 public static String modificarArticulo(String descripcion, String precio){
	 
	 boolean ok = false;
	 String resultado = null;
	 
	 try{
		 ok = conexion.setQuery("UPDATE articulos set precio = "+precio+" where descripcion = '"+descripcion+"'");
		 if (ok) 
			 resultado="Se modificó registro correctamente";
		 else 
			 resultado="No se pudo modificar";	 
	 }
	 catch(Exception e){ e.printStackTrace(); }
	 return resultado;
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 public static String borrarArticulo(String valor){
	 
	 boolean ok = false;
	 String resultado = null;
	 
	 try{
		 ok = conexion.setQuery("DELETE FROM articulos WHERE codigo = '"+valor+"'");
		 if (ok) 
			 resultado="Se borró el registro correctamente";
		 else 
			resultado ="No se pudo borrar";	 
	 }
	 catch(Exception e){ e.printStackTrace(); }
	 return resultado;
 }
                
}
