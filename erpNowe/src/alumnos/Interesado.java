/**
 * Clase Calificaciones
 * @author curso14/7803
 * @version 1.0
 * @since 26/11/2015
 * <br>
 * <p>
 *
 * </p>
 */

package alumnos;

import java.sql.ResultSet;
import java.sql.SQLException;
import ventanaPrincipal.VentanaPrincipal;

public class Interesado {
	
	public static ResultSet consultaAlumno(String dni) {
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM alumnos where DNI ='"+dni+"'");
		return datos;	
	}

	public static String consultaAlumnos() {
		ResultSet datos;
		String  idAlumno= null  , nombre = null, apellidos = null, dni = null, email = null, telefono = null, direccion = null,
				codigoPostal = null, municipio = null, provincia = null, pais = null, fNacimiento = null;
		String consulta = ("id \t Alumno \t Apellidos \t DNI \t Email \t Telefono \t Direccion \t CodigoPostal \t Municipio \t Provincia \t Pais \t FechaNacimiento\n \n ");
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM alumnos;");
		try {
			while (datos.next()) {
				idAlumno 		= datos.getString("idAlumno");
				nombre  		= datos.getString("Nombre");
				apellidos  		= datos.getString("Apellidos");
				dni  			= datos.getString("DNI");
				email  			= datos.getString("Email");
				telefono  		= datos.getString("Telefono");
				direccion  		= datos.getString("Direccion");
				codigoPostal  	= datos.getString("CodigoPostal");
				municipio 		= datos.getString("Municipio");
				provincia 		= datos.getString("Provincia");
				pais 			= datos.getString("Pais");
				fNacimiento 	= datos.getString("FechaNacimiento");
				consulta = (idAlumno + "\t" + nombre + "\t" + apellidos + "\t" + dni + "\t" + email + "\t" + telefono
							+ "\t" + direccion + "\t" + codigoPostal + "\t" + municipio + "\t" + provincia + "\t" + pais + "\t"
						    + fNacimiento + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consulta;
	}

	public static String insertarAlumno(
			String nombre,
			String apellidos,
			String dNI,
			String email,
			String telefono,
			String direccion,
			String codigoPostal,
			String municipio,
			String provincia,
			String pais,
			String fechaNacimiento,
			String curso,
			String observaciones)
	{
		    String resultado = null;
		    boolean ok,ok2 = false;
		    
		try {
			
			if(fechaNacimiento.equals("0")){
				ok = VentanaPrincipal.conexion.setQuery(
						"INSERT INTO alumnos  ( Nombre,Apellidos, DNI,Email,Telefono ,Direccion,CodigoPostal,Municipio ,Provincia ,Pais ) VALUES ('"
								+ nombre + "','" + apellidos + "','" + dNI + "', '" + email + "', '" + telefono + "', '"
								+ direccion + "', '" + codigoPostal + "', '" + municipio + "', '" + provincia + "', '" + pais
								+ "')");
			
			}else {
				ok = VentanaPrincipal.conexion.setQuery(
						"INSERT INTO alumnos  ( Nombre,Apellidos, DNI,Email,Telefono ,Direccion,CodigoPostal,Municipio ,Provincia ,Pais, FechaNacimiento) VALUES ('"
								+ nombre + "','" + apellidos + "','" + dNI + "', '" + email + "', '" + telefono + "', '"
								+ direccion + "', '" + codigoPostal + "', '" + municipio + "', '" + provincia + "', '" + pais
								+ "', " + fechaNacimiento + ")");
				ResultSet datos;		
				datos = VentanaPrincipal.conexion.getQuery("SELECT max(idAlumno) FROM alumnos");
				String  idAlum =datos.getString("idAlumno");
				
				ok2 = VentanaPrincipal.conexion.setQuery(
				"INSERT INTO alumnoInteresado  (cursosInteresado,Observaciones,idAlumno ) VALUES ('"
				+ curso + "','" + observaciones +"'," + idAlum +")");
			}
			
			
			if (ok && ok2)
				resultado = "Se inserto correctamente";
			else
				resultado = "Error";		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;

	}

	public static String modificarAlumno(String Nombre,
			String Apellidos,
			String DNI,
			String Email,
			int Telefono,
			String Direccion,
			int CodigoPostal,
			String Municipio,
			String Provincia,
			String Pais, 
			String FechaNacimiento,
			String idAlumno) {
		
		String resultado="";
		boolean ok = false;
		
		try {
			ok = VentanaPrincipal.conexion.setQuery(
					
					"UPDATE  alumnos SET  Nombre = '"+Nombre+"',Apellidos= '" + Apellidos + "' , DNI = '" + DNI + "',Email = '" + Email + "',Telefono= " + Telefono + " ,Direccion ='" + Direccion + "',CodigoPostal =" + CodigoPostal + ",Municipio='" + Municipio + "' ,Provincia='" + Provincia + "' ,Pais='" + Pais + "', FechaNacimiento='" + FechaNacimiento +"' where idAlumno = '"+idAlumno+"' " );
			
			
			if (ok)
				resultado = "Se Modifico correctamente";

			else
				resultado = "Error";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado	;
	}
	
	public static String borrarAlumno(String dni) {
		
		String resultado="";
		boolean ok = false;
		
		try {
			ok = VentanaPrincipal.conexion.setQuery("delete from alumnos where DNI='"+dni+"'");
			
			
			if (ok)
				resultado = "Se Borro correctamente";

			else
				resultado = "No existe un alumno con este DNI";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	

		
	

}