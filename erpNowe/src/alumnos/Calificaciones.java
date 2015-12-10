
/**
 * Clase Calificaciones
 * @author Adolfo y Guillermo
 * @version 1.0
 * @since 26/11/2015
 * <br>
 * <p>
 * Esta clase se corresponde con los atributos y
 *  los metodos de la clase Calificaciones
 * </p>
 */



package alumnos;

import java.sql.ResultSet;
import java.sql.SQLException;
import alumnos.VentanaCalificaciones;
import ventanaPrincipal.VentanaPrincipal;

public class Calificaciones {

	static boolean diploma = false;
	static String Obs;
	static String N;
	static int dRecibido;
	static String dni, codAlumno, codModulo, nota,diplomaR,anotaciones,resultado ="";
	public static ResultSet datos;
	public static void main(String[] args) {

		VentanaCalificaciones ventana=new VentanaCalificaciones();
		ventana.setVisible(true);
	}

	/**
	 * Metodo de consultas en un solo boton.
	 */

	public static ResultSet Consultar(){
		ResultSet datos;

		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno ORDER BY a.DNI;");

		return datos; 
	}

	public static ResultSet Consultar1(String alumno){
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno AND c.idAlumno ='"+alumno+"' ORDER BY a.DNI;");
		return datos; 
	}

	public static ResultSet Consultar2(String idModulo) {
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno AND c.idModulo ='"+idModulo+"' ORDER BY a.DNI;");
		return datos; 
	}	

	public static ResultSet Consultar3(String alumno,String idModulo){
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno AND C.idAlumno ='"+alumno+"'  AND c.idModulo ='"+idModulo+"' ORDER BY a.DNI;");
		return datos; 
	}
	/**
	 * Metodo para modificar registros de la base de datos
	 * @param idAlumno,idModulo,nota,recibido,observaciones
	 * @return
	 */
	//---------------------------------------------------------------------	
	public static String ModificarCalificaciones(
			String idAlumno,
			String idModulo,
			float nota,
			boolean recibido,
			String observaciones
			) {

		int dRecibido = (recibido)? 1:0;
		boolean ok = false;
		try {
			ok= VentanaPrincipal.conexion.setQuery("UPDATE  calificaciones SET Notas = '"+nota+"', diplomaRecogido = '" +dRecibido +"', Observaciones = '"+observaciones+"'  WHERE idAlumno = '"+idAlumno+"'AND idModulo = '"+idModulo+"' ");

			if (ok)
				resultado = "Avisos: Se Modifico correctamente";

			else
				resultado = "Avisos: Error";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
