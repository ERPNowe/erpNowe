package cursos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import basedatos.ConexionBaseDatos;

/** 
 * @author Victor Jimenez
 * @since 19/11/2015
 * @version 1.0
 */
	
	public class Modulos {
		private String idModulo, nombre;
		
		 private static String usuario = "root";
		 private static String pwd = "root";
		 private static String bd = "nowedb";
		 static ConexionBaseDatos conexion = null;
		 static Scanner scanner = new Scanner(System.in);

		public static void main(String[] args) {
			 conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
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
	 * Metodo para consultar todos los datos de la tabla modulos
	 * @return
	 */
	public static String consultar(){
		ResultSet datos;
	    String campo1, campo2, resultado ="";
	    datos = conexion.getQuery("SELECT * FROM modulos;");
	    try {
	      while(datos.next()){
	    	  campo1 = datos.getString("idModulo"); 
	    	  campo2 = datos.getString("nombre");
	    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2; 
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
	 * @return
	 */
	public static String insertar(String idModulo, String nombre){
		 boolean ok = false;
		 String resultado = null;
		 try {
				 ok = conexion.setQuery("INSERT INTO modulos(idModulo, Nombre)"
						+ " VALUES ('" + idModulo + "','" + nombre + "')");
				 if (ok) 
					 resultado = "Se insert� registro correctamente";
				 else 
					resultado = "No se pudo insertar";	 
			} 
		 
		 catch(Exception e){ e.printStackTrace(); }
		return resultado;
		
	}
	
	/**
	 * Metodo para modificar entradas de la base de datos
	 * @param idModulo
	 * @param nombre
	 * @return
	 */
	public static String modificar(String idModulo, String nombre){
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = conexion.setQuery("UPDATE modulos set Nombre = '"+ nombre
					 + "' where idModulo = '"+ idModulo +"'");
			 if (ok) 
				 resultado = "Se modific� registro correctamente";
			 else 
				 resultado = "No se pudo modificar";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	}
	/**
	 * Metodo para borrar registros de la base de datos
	 * @param idModulo
	 * @return
	 */
	public static String eliminar(String idModulo){
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = conexion.setQuery("DELETE FROM modulos WHERE idModulo = '"+ idModulo +"'");
			 if (ok) 
				 resultado = "Se borr� el registro correctamente";
			 else 
				resultado ="No se pudo borrar";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	 }	
}
	
	
		

