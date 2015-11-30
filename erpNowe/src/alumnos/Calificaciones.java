
/**
 * Clase Calificaciones
 * @author Adolfo
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

//	private static String usuario = "root";
//	private static String pwd = "root";
//	private static String bd = "nowedb" + "";
	//static VentanaPrincipal.conexionBaseDatos VentanaPrincipal.conexion = null;
	static boolean diploma = false;
	static String Obs;
	static String N;

	public static void main(String[] args) {
//		VentanaPrincipal.conexion = new VentanaPrincipal.conexionBaseDatos(bd, usuario, pwd);
		VentanaCalificaciones ventana=new VentanaCalificaciones();
		ventana.setVisible(true);
	}

	/**
	 * Metodo de consultas en un solo boton.
	 */

	public static String Consultar(){
		ResultSet datos;
		String dni, codAlumno, codModulo, nota,diplomaR,anotaciones,resultado ="";
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno ORDER BY a.DNI;");
		try {
			while(datos.next()){
				codAlumno = datos.getString("idAlumno");

				dni = datos.getString("DNI");
				codModulo = datos.getString("idModulo");
				nota= datos.getString("Notas");
				diplomaR= datos.getString("DiplomaRecogido");
				anotaciones= datos.getString("Observaciones");
				resultado = resultado +"\n"+ codAlumno + "\t"+ dni + "\t" + codModulo + "\t" + nota
						+ "\t" + diplomaR + "\t" + anotaciones + "\t"  ;	   
			}
		}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return resultado; 
	}

	public static String Consultar1(String alumno){
		ResultSet datos;
		String dni,codAlumno, codModulo, nota,diplomaR,anotaciones,resultado ="";
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno AND c.idAlumno ='"+alumno+"' ORDER BY a.DNI;");
		//datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM calificaciones where idAlumno ='"+idAlumno+"';");
		try {
			while(datos.next()){//es el metodo que permite ir recorriendo los datos
				codAlumno = datos.getString("idAlumno"); //podemos poner el nombre o un numero
				dni = datos.getString("DNI");
				codModulo = datos.getString("idModulo");
				nota= datos.getString("Notas");
				diplomaR= datos.getString("DiplomaRecogido");
				anotaciones= datos.getString("Observaciones");
				resultado = resultado +"\n"+ codAlumno + "\t" + dni + "\t" + codModulo + "\t" + nota
						+ "\t" + diplomaR + "\t" + anotaciones + "\t"  ; 
			}
		}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return resultado; 
	}

	public static String Consultar2(String idModulo) {
		ResultSet datos;
		String dni,codAlumno, codModulo, nota,diplomaR,anotaciones,resultado ="";
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno AND c.idModulo ='"+idModulo+"' ORDER BY a.DNI;");

		try {
			while(datos.next()){//es el metodo que permite ir recorriendo los datos
				codAlumno = datos.getString("idAlumno"); //podemos poner el nombre o un numero
				dni = datos.getString("DNI");
				codModulo = datos.getString("idModulo");
				nota= datos.getString("Notas");
				diplomaR= datos.getString("DiplomaRecogido");
				anotaciones= datos.getString("Observaciones");
				resultado = resultado +"\n"+ codAlumno + "\t" + dni + "\t" + codModulo + "\t" + nota
						+ "\t" + diplomaR + "\t" + anotaciones + "\t"  ;  
			}
		}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return resultado; 
	}	

	public static String Consultar3(String alumno,String idModulo){
		ResultSet datos;
		String dni,codAlumno, codModulo, nota,diplomaR,anotaciones,resultado ="";
		//  datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM calificaciones where idAlumno ='"+alumno+"' AND idModulo ='"+idModulo+"';");
		datos = VentanaPrincipal.conexion.getQuery("SELECT a.DNI,c.* FROM alumnos a,calificaciones c WHERE a.idAlumno = c.idAlumno AND C.idAlumno ='"+alumno+"'  AND c.idModulo ='"+idModulo+"' ORDER BY a.DNI;");

		try {
			while(datos.next()){//es el metodo que permite ir recorriendo los datos
				codAlumno = datos.getString("idAlumno"); //podemos poner el nombre o un numero
				dni = datos.getString("DNI");
				codModulo = datos.getString("idModulo");
				nota= datos.getString("Notas");
				diplomaR= datos.getString("DiplomaRecogido");
				anotaciones= datos.getString("Observaciones");
				resultado = resultado +"\n"+ codAlumno + "\t" + dni + "\t" + codModulo + "\t" + nota
						+ "\t" + diplomaR + "\t" + anotaciones + "\t"  ;  
				if(diplomaR.equals("1")) diploma = true;
				Obs = anotaciones;
				N = nota;
			}
		}
		catch (SQLException e) { 
			e.printStackTrace();
		}
		return resultado; 
	}

	//---------------------------------------------------------------------	
	public static String ModificarCalificaciones(
			String idAlumno,
			String idModulo,
			String nota,
			String observaciones,
			boolean recibido
			) {
		int dRecibido = (recibido)? 1:0;
		int nota2=Integer.parseInt(nota);
		String resultado="";
		boolean ok = false;



		try {
			ok= VentanaPrincipal.conexion.setQuery("UPDATE  calificaciones SET Notas = '"+nota2+"' Observaciones = '"+observaciones+"', diplomaRecogido = '" +dRecibido +"' WHERE idAlumno = '"+idAlumno+"'AND idModulo = '"+idModulo+"' ");

			if (ok)
				resultado = "Se Modifico correctamente";

			else
				resultado = "Error";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
