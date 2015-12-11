package cursos;

import java.sql.ResultSet;
import java.sql.SQLException;
import cursos.VentanaCursos.Panel;
import ventanaPrincipal.VentanaPrincipal;


/**
 * @author Jesús Hernando,Alberto Jaén, Guillermo Priego
 * @since 20/11/2015
 * @version 1.0
*/
	public class Cursos {
		static boolean priv = false;
		static String numpriv;
	    
		 public static void main(String[] args) {
			
		    VentanaCursos ventana=new VentanaCursos();
		    ventana.setVisible(true);
		}
		
		 /**
			 * Metodo para listar la tabla
			 * @return
			 */

		public static void Consultar(Panel panel){
		 	ResultSet datos;
		    String campo1, campo2, campo3,campo4,campo5,campo6,campo7,campo8, resultado ="";
		    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM cursos;");
		    try {
		      while(datos.next()){
		    	  campo1 = datos.getString("idCurso"); 
		    	  campo2 = datos.getString("CodigoCurso");
		    	  campo3 = datos.getString("Nombre");
		    	  campo4 = datos.getString("Categoria");
		    	  campo6 = datos.getString("Precio");
		    	  campo7 = datos.getString("Duracion");
		    	  campo8 = (datos.getString("Privado").equals("1")) ? "Si":"No";
	
		    	  panel.getModelo().addRow( new Object[] {campo1, campo2, campo3, campo4, campo6, campo7, campo8} );                
		      }
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
	 }
			
		/**
		 * Metodo para consultar todos los datos de la tabla cursos
		 * @return
		 */
		public static ResultSet Consultarid(String idCurso,Panel panel) {
			String campo1, campo2, campo3,campo4,campo5,campo6,campo7,campo8, resultado ="";
			ResultSet datos;
		    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM cursos where idCurso = '"+idCurso+"'");
		    try {
			      while(datos.next()){
			    	  campo1 = datos.getString("idCurso"); 
			    	  campo2 = datos.getString("CodigoCurso");
			    	  campo3 = datos.getString("Nombre");
			    	  campo4 = datos.getString("Categoria");

			    	  campo6 = datos.getString("Precio");
			    	  campo7 = datos.getString("Duracion");
			    	  campo8 = (datos.getString("Privado").equals("1")) ? "Si":"No";
			    	  numpriv = datos.getString("privado");
			    	  panel.getModelo().addRow( new Object[] {campo1, campo2, campo3, campo4, campo6, campo7, campo8} );                
			      }
			    }
			    catch (SQLException e) { e.printStackTrace();
			   }
		     VentanaCursos.borrar.setEnabled(true);
		     datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM cursos where idCurso = '"+idCurso+"'");
		      return datos;
		    }
		 

		/**
		 * Metodo para insertar un nuevo registro en la tabla
		 * @param idCursos
		 * @param codigoCurso, nombre, categoria, descripcion, precio , duracion , privado
		 * @return
		 */
	public static String Insertar(String codigoCurso,String nombre,String categoria, String descripcion,Float precio,int duracion,int privado
			 ){
		 boolean ok = false;
		 String resultado = null;
		 try {
				 ok = VentanaPrincipal.conexion.setQuery("INSERT INTO cursos(CodigoCurso ,Nombre ,Categoria ,Descripcion ,Precio ,Duracion ,Privado)"
						+ " VALUES ('" + codigoCurso + "','" + nombre  + "','" 
				 		+ categoria + "','" +  descripcion + "','" +  precio + "','" +  duracion + "','" +  privado  + "' )");
				 if (ok) 
					 resultado="Se insertó registro correctamente";
				 else 
					resultado ="No se pudo insertar";	 
			} 
		 catch(Exception e){ e.printStackTrace(); }
		return resultado;
		
	}
	/**
	 * Metodo para modificar entradas de la base de datos
	 * @param idCursos
	 * @param codigoCurso, nombre, categoria, descripcion, precio , duracion , privado
	 * @return
	 */
	
	public static String Modificar(int idcurso,String codigoCurso,String nombre,String categoria, String descripcion,Float precio,int duracion,int privado){
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = VentanaPrincipal.conexion.setQuery("UPDATE cursos set CodigoCurso  = '"+codigoCurso+"' ,Nombre = '"+nombre+"' ,Categoria = '"
			 		 +categoria+ "',Descripcion = '"+descripcion+"',Precio = '"+precio+"',Duracion = '"+duracion+"',Privado = '"+privado+"'where idCurso = '"+idcurso+"'");
			 if (ok) 
				 resultado="Se modificó registro correctamente";
			 else 
				 resultado="No se pudo modificar";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	}
	
	/**
	 * Metodo para borrar registros de la base de datos
	 * @param idCursos
	 * @return
	 */
	public static String Eliminar(int idCursos){
		 
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = VentanaPrincipal.conexion.setQuery("DELETE FROM cursos WHERE idCurso = '"+idCursos+"'");
			 if (ok) 
				 resultado="Se borró el registro correctamente";
			 else 
				resultado ="No se pudo borrar";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
		
	}	
	}
	
		
	
	
	