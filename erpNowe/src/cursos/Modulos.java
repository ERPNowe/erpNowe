/** 
 * Clase Modulos
 * @author Victor
 * @since 19/11/2015
 * @version 1.0
 * <br>
 * <p>
 * Esta clase se corresponde con los metodos principales 
 * de acceso y gesti�n de la tabla modulo de la base de datos mysql "nowedb"
 * </p>
 */

package cursos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import basedatos.ConexionBaseDatos;
import ventanaPrincipal.VentanaPrincipal;


	
	public class Modulos {
		private String idModulo, nombre;
		
		 private static String usuario = "root";
		 private static String pwd = "root";
		 private static String bd = "nowedb";
		 static ResultSet filas = null;
		 //static ConexionBaseDatos conexion = null;
		 //static Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) {
			 //conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			 ventanaModulo ventana = new ventanaModulo();
			 ventana.setVisible(true);   
		}
		
	/**
	 * Constructor parametrizado	
	 * @param idModulo
	 * @param nombre
	 */
	public  Modulos(String idModulo, String nombre){
		this.idModulo = idModulo;
		this.nombre = nombre;
	}
	/**
	 * Getter de idModulo
	 * @return
	 */
	public String getIdModulo() {
		return idModulo;
	}

	/**
	 * Setter de idModulo
	 * @param idModulo
	 */
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * getter de nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo para cargar en el combo los IdModulo
	 */
	public static void menu(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT idModulo FROM modulos");
		 try {
		      while(filas.next()){
		    	  ventanaModulo.combo1.addItem(filas.getString("idModulo"));
		      }	
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		
	}
	
	/**
	 * Metodo para consultar todos los datos de la tabla modulos
	 * @param idModulo
	 * @return la consulta completa
	 */
	 
	public static String consultar(String idModulo){
		ResultSet datos;
	    String idMo, nombre, resultado ="";
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM modulos WHERE idModulo = '"+idModulo+"'");
	    try {
	      while(datos.next()){
	    	  idMo = datos.getString("idModulo"); 
	    	  nombre = datos.getString("nombre");
	    	  resultado = idMo + "\t" + nombre;  
	      }
	      ventanaModulo.modificar.setEnabled(true);
		     ventanaModulo.borrar.setEnabled(true);
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	    return resultado; 
	}
	
	/**
	 * Metodo para listar la tabla
	 * @return el listado completo de la tabla
	 */
	public static String listar(){
		ResultSet datos;
	    String idModulo, nombre, resultado ="";
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM modulos");
	    try {
	      while(datos.next()){
	    	  idModulo = datos.getString("idModulo"); 
	    	  nombre = datos.getString("nombre");
	    	  resultado = resultado +"\n"+ idModulo + "\t" + nombre; 
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	    return resultado; 
	}
	
	/**
	 * Metodo para insertar un nuevo registro en la tabla
	 * @param idModulo
	 * @param nombre
	 * @return se se puede o no insertar el nuevo registro
	 */
	public static String insertar(String idModulo, String nombre){
		 boolean ok = false;
		 String resultado = null;
		 try {
				 ok = VentanaPrincipal.conexion.setQuery("INSERT INTO modulos(idModulo, Nombre)"
						+ " VALUES ('" + idModulo + "','" + nombre + "')");
				 if (ok) 
					 resultado = "Se insert� el nuevo modulo correctamente";
				 else 
					resultado = "No se pudo insertar nuevo modulo";	 
			} 
		 
		 catch(Exception e){ e.printStackTrace(); }
		return resultado;
		
	}
	
	/**
	 * Metodo para modificar entradas de la base de datos
	 * @param idModulo
	 * @param nombre
	 * @return si se puede o no modificar el registro
	 */
	public static String modificar(String idModulo, String nombre){
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = VentanaPrincipal.conexion.setQuery("UPDATE modulos set Nombre = '"+ nombre
					 + "' where idModulo = '"+ idModulo +"'");
			 if (ok) 
				 resultado = "Se modific� el modulo correctamente";
			 else 
				 resultado = "No se pudo modificar el modulo";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	}
	/**
	 * Metodo para borrar registros de la base de datos
	 * @param idModulo
	 * @return si se puede o no borrar el registro
	 */
	public static String eliminar(String idModulo){
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = VentanaPrincipal.conexion.setQuery("DELETE FROM modulos WHERE idModulo = '"+ idModulo +"'");
			 if (ok) 
				 resultado = "Se borr� el modulo correctamente";
			 else 
				resultado ="No se pudo borrar el modulo";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	 }	
}
	
	
		

