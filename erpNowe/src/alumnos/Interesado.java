package alumnos;

import java.sql.ResultSet;
import java.sql.SQLException;
import ventanaPrincipal.VentanaPrincipal;
import alumnos.VentanaInteresado;
public class Interesado {

	/**
	 * consulta de alumno 
	 * @param dni
	 * @return  el alumno que corresponde a ese DNI
	 */
	
	public static ResultSet consultaAlumno(String dni) {
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM alumnos join alumnointeresado on alumnos.idAlumno = alumnointeresado.idAlumno where DNI ='"+dni+"'");
		return datos;	
	
	}
	
	
	/**
	 * Consulta tabla alumnos
	 * @return toda la tabla de alumnos 
	 */
	

	public static ResultSet consultaAlumnos() {
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM alumnos;");
		
		return datos;
	}
	
	
	/**
	 * Insertar alumno
	 * @param nombre
	 * @param apellidos
	 * @param dNI
	 * @param email
	 * @param telefono
	 * @param direccion
	 * @param codigoPostal
	 * @param municipio
	 * @param provincia
	 * @param pais
	 * @param fechaNacimiento
	 * @param areaDeInteres
	 * @param observaciones
	 * @return Si no existe se inserta en la tabla alumnos sus datos y el curso interesado
	 * si existe solo añade a la tabla alumno interesado el curso por el que se interesa 
	 */

	
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
			String areaDeInteres,
			String observaciones) {
			String resultado = null;
			boolean ok, ok2 = false;
			
		ResultSet datos;
		
		datos = VentanaPrincipal.conexion.getQuery("SELECT idAlumno FROM alumnos where DNI ='" + dNI + "'");
		try {
			if (!datos.next()) {// si no existe el alumno doble insercion
				
				// VentanaInteresado().CargarCursos(datos.getString("idAlumno"));

				try {

					if (fechaNacimiento.equals("0")) { // si no se ingresa ninguna fecha 
						ok = VentanaPrincipal.conexion.setQuery(
								"INSERT INTO alumnos  ( Nombre,Apellidos, DNI,Email,Telefono ,Direccion,CodigoPostal,Municipio ,Provincia ,Pais ) VALUES ('"
										+ nombre + "','" + apellidos + "','" + dNI + "', '" + email + "', '" + telefono
										+ "', '" + direccion + "', '" + codigoPostal + "', '" + municipio + "', '"
										+ provincia + "', '" + pais + "')");
						ResultSet datos2;
						datos2 = VentanaPrincipal.conexion.getQuery("SELECT max(idAlumno) AS b FROM alumnos");
						datos2.next();
						int idAlum = Integer.parseInt(datos2.getString("b"));

						ok2 = VentanaPrincipal.conexion.setQuery(
								"INSERT INTO alumnoInteresado ( cursosInteresado,idAlumno,Observaciones )VALUES('"
										+ areaDeInteres + "','" + idAlum + "','" + observaciones + "')");

					} else { //si se ingresa un fecha 

						ok = VentanaPrincipal.conexion.setQuery(
								"INSERT INTO alumnos  ( Nombre,Apellidos, DNI,Email,Telefono ,Direccion,CodigoPostal,Municipio ,Provincia ,Pais, FechaNacimiento) VALUES ('"
										+ nombre + "','" + apellidos + "','" + dNI + "', '" + email + "', '" + telefono
										+ "', '" + direccion + "', '" + codigoPostal + "', '" + municipio + "', '"
										+ provincia + "', '" + pais + "', " + fechaNacimiento + ")");
						ResultSet datos2;
						datos2 = VentanaPrincipal.conexion.getQuery("SELECT max(idAlumno) AS b FROM alumnos");
						datos2.next();
						String idAlum = datos2.getString("b");

						ok2 = VentanaPrincipal.conexion.setQuery(
								"INSERT INTO alumnoInteresado ( cursosInteresado,idAlumno,Observaciones )VALUES('"
										+ areaDeInteres + "','" + idAlum + "','" + observaciones + "')");
					}
					
					if (ok && ok2) {// si son correctas las dos inserciones 
					
						
						resultado = "Se inserto correctamente ";
					} else {
						resultado = "No se pudo insertar el nuevo alumno.";
					}

				} catch (Exception e) {
					System.out.println("no existe el alumno");
					e.printStackTrace();

				}
			} else { // Si existe el alumno una insercion

				ResultSet datos2;

				datos2 = VentanaPrincipal.conexion.getQuery("SELECT idAlumno FROM alumnos WHERE DNI = '" + dNI + "'");
				datos2.next();
				String idAlum = datos2.getString("idAlumno");
				System.out.println(idAlum);

				ok2 = VentanaPrincipal.conexion
						.setQuery("INSERT INTO alumnoInteresado ( cursosInteresado,idAlumno,Observaciones )VALUES('"
								+ areaDeInteres + "'," + idAlum + ",'" + observaciones + "')");
				if (ok2)
					resultado = "Se ha añadido un nuevo curso a este alumno  ";
				else
					resultado = "No se ha añadido un nuevo curso a este alumno";
			}
		} catch (SQLException e) {
			System.out.println("existe el alumno");
			e.printStackTrace();
		}

		return resultado;

	}
	
	/**
	 * Modificar alumno
	 * @param Nombre
	 * @param Apellidos
	 * @param DNI
	 * @param Email
	 * @param Telefono
	 * @param Direccion
	 * @param CodigoPostal
	 * @param Municipio
	 * @param Provincia
	 * @param Pais
	 * @param FechaNacimiento
	 * @param idAlumno
	 * @return el aviso si ha sido modificado
	 */

	public static String modificarAlumno(
			String Nombre,
			String Apellidos,
			String DNI,
			String Email,
			String Telefono,
			String Direccion,
			String CodigoPostal,
			String Municipio,
			String Provincia,
			String Pais, 
			String FechaNacimiento,
			String idAlumno) {
		
			String resultado="";
			boolean ok = false;
		
		try {
			
			if(FechaNacimiento.equals("0")){
			ok = VentanaPrincipal.conexion.setQuery(
					
					"UPDATE  alumnos SET  Nombre = '"+Nombre+"',Apellidos= '" + Apellidos + "' , DNI = '" + DNI + "',Email = '" + Email + "',Telefono= " + Telefono + " ,Direccion ='" + Direccion + "',CodigoPostal =" + CodigoPostal + ",Municipio='" + Municipio + "' ,Provincia='" + Provincia + "' ,Pais='" + Pais + "' where idAlumno = '"+idAlumno+"' " );
			
			}else 
				
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