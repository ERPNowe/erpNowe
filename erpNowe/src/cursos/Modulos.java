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
import ventanaPrincipal.VentanaPrincipal;
import cursos.ventanaModulo.Panel;



	
	public class Modulos {
		private String idModulo, nombre;
		
		 private static String usuario = "root";
		 private static String pwd = "root";
		 private static String bd = "nowedb";
		 
		

		public static void main(String[] args) {
			 
			 ventanaModulo ventana = new ventanaModulo();
			 ventana.setVisible(true);   
		}
	
	/**
	 * Metodo para consultar todos los datos de la tabla modulos
	 * @param panel
	 * @return la consulta completa
	 */
	 
	public static void consultar(String idModulo, Panel panel){
		ResultSet datos;
	    String idMo = null, nombre = null;
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM modulos WHERE idModulo = '"+idModulo+"'");
	    try {
	      while(datos.next()){
	    	  idMo = datos.getString("idModulo"); 
	    	  nombre = datos.getString("nombre");  
	      
	      ventanaModulo.modificar.setEnabled(true);
		  ventanaModulo.borrar.setEnabled(true);
		  panel.getModelo().addRow( new Object[] {idMo, nombre} );
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }  
	}
	
	/**
	 * Metodo para listar la tabla
	 * @param panel 
	 * @return el listado completo de la tabla
	 */
	public static void listar(Panel panel){
		ResultSet datos;
	    String idModulo = null, nombre = null;
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM modulos");
	    try {
	      while(datos.next()){
	    	  idModulo = datos.getString("idModulo"); 
	    	  nombre = datos.getString("nombre");
	      
	      ventanaModulo.modificar.setEnabled(true);
		  ventanaModulo.borrar.setEnabled(true);
	      panel.getModelo().addRow( new Object[] {idModulo, nombre} ); 
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	 
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
	/**
	 * Metodo para cargar en el combo los IdModulo
	 */
	public static void menu(){
		ResultSet filas = null;
		filas = VentanaPrincipal.conexion.getQuery("SELECT idModulo FROM modulos");
		 try {
		      while(filas.next()){
		    	  ventanaModulo.combo1.addItem(filas.getString("idModulo"));
		      }	
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		
	}
}
	
	
		

