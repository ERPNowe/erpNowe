package cursos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * @author Alberto Ja�n
 * @since 18/11/2015
 * @version 1.0
*/
	public class Cursos {

		
	    
	 
	 
	
		
	 //-----------------------------------------------------------------------------------

		public static String Consultar(){
		 	ResultSet datos;
		    String campo1, campo2, campo3,campo4,campo5,campo6,campo7,campo8, resultado ="";
		    datos = Principalcursos.conexion.getQuery("SELECT * FROM cursos;");
		    try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  campo1 = datos.getString("idCurso"); //podemos poner el nombre o un numero
		    	  campo2 = datos.getString("CodigoCurso");
		    	  campo3 = datos.getString("Nombre");
		    	  campo4 = datos.getString("Categoria");
		    	  campo5 = datos.getString("Descripcion");
		    	  campo6 = datos.getString("Precio");
		    	  campo7 = datos.getString("Duracion");
		    	  campo8 = datos.getString("Privado");
		    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2 + "\t" + campo3
		    			  + "\t" + campo4 + "\t" + campo5 + "\t" + campo6 + "\t" + campo7 + "\t" + campo8 ; 
		      }
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		    return resultado; 
	 }
			
//--------------------------------------------------------------------------------------------------------------------------------------------	
		public static String Consultarip(int idCurso) {
			ResultSet datos;
		    String campo1, campo2, campo3,campo4,campo5,campo6,campo7,campo8, resultado ="";
		    datos = Principalcursos.conexion.getQuery("SELECT * FROM cursos where idCurso = '"+idCurso+"'");
		    try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  campo1 = datos.getString("idCurso"); //podemos poner el nombre o un numero
		    	  campo2 = datos.getString("CodigoCurso");
		    	  campo3 = datos.getString("Nombre");
		    	  campo4 = datos.getString("Categoria");
		    	  campo5 = datos.getString("Descripcion");
		    	  campo6 = datos.getString("Precio");
		    	  campo7 = datos.getString("Duracion");
		    	  campo8 = datos.getString("Privado");
		    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2 + "\t" + campo3
		    			  + "\t" + campo4 + "\t" + campo5 + "\t" + campo6 + "\t" + campo7 + "\t" + campo8 ; 
		      }
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		    return resultado; 
	 
		}

//----------------------------------------------------------------------------------------------------------------------------------	
	public static String Insertar(String codigoCurso,String nombre,String categoria, String descripcion,Float precio,int duracion,int privado
			 ){
		 boolean ok = false;
		 String resultado = null;
		 try {
				 ok = Principalcursos.conexion.setQuery("INSERT INTO cursos(CodigoCurso ,Nombre ,Categoria ,Descripcion ,Precio ,Duracion ,Privado)"
						+ " VALUES ('" + codigoCurso + "','" + nombre  + "','" 
				 		+ categoria + "','" +  descripcion + "','" +  precio + "','" +  duracion + "','" +  privado  + "' )");
				 if (ok) 
					 resultado="Se insert� registro correctamente";
				 else 
					resultado ="No se pudo insertar";	 
			} 
		 
		 catch(Exception e){ e.printStackTrace(); }
		return resultado;
		
	}
	//-------------------------------------------------------------------------------------------------------------------------
	
	public static String Modificar(int idcurso,String codigoCurso,String nombre,String categoria, String descripcion,Float precio,int duracion,int privado){
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = Principalcursos.conexion.setQuery("UPDATE cursos set CodigoCurso  = '"+codigoCurso+"' ,Nombre = '"+nombre+"' ,Categoria = '"
			 		 +categoria+ "',Descripcion = '"+descripcion+"',Precio = '"+precio+"',Duracion = '"+duracion+"',Privado = '"+privado+"'where idCurso = '"+idcurso+"'");
			 if (ok) 
				 resultado="Se modific� registro correctamente";
			 else 
				 resultado="No se pudo modificar";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	}
	
	//-------------------------------------------------------------------------------------
	
	public static String Eliminar(int idCursos){
		 
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = Principalcursos.conexion.setQuery("DELETE FROM cursos WHERE idCurso = '"+idCursos+"'");
			 if (ok) 
				 resultado="Se borr� el registro correctamente";
			 else 
				resultado ="No se pudo borrar";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
		
	}

	
	
		
	}
	

	
		
	
	
	