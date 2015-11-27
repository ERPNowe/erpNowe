package alumnos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import basedatos.ConexionBaseDatos;
import utilidades.Fecha;
import ventanaPrincipal.VentanaPrincipal;

public class Interesado {

//	private static String usuario = "root";
//	private static String pwd = "root";
//	private static String bd = "nowedb" + "";
//	static ConexionBaseDatos conexion = null;

//	public static void main(String[] args) {
//		VentanaPrincipal.conexion = new ConexionBaseDatos(bd, usuario, pwd);
//		MarcoAlumnos ne = new MarcoAlumnos();
//		ne.setVisible(true);
//	}
	
	public static ResultSet consultaAlumno(String dni) {
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM alumnos where DNI ='"+dni+"'");
		return datos;	
	}

	public static String consultaAlumnos() {
		ResultSet datos;
		String  campo1= null  , campo2 = null, campo3 = null, campo4 = null, campo5 = null, campo6 = null, campo7 = null,
				campo8 = null, campo9 = null, campo10 = null, campo11 = null, campo12 = null;
		String consulta = ("id \t Alumno \t Apellidos \t DNI \t Email \t Telefono \t Direccion \t CodigoPostal \t Municipio \t Provincia \t Pais \t FechaNacimiento\n \n ");
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM alumnos;");
		try {
			while (datos.next()) {
				campo1  = datos.getString("idAlumno");
				campo2  = datos.getString("Nombre");
				campo3  = datos.getString("Apellidos");
				campo4  = datos.getString("DNI");
				campo5  = datos.getString("Email");
				campo6  = datos.getString("Telefono");
				campo7  = datos.getString("Direccion");
				campo8  = datos.getString("CodigoPostal");
				campo9  = datos.getString("Municipio");
				campo10 = datos.getString("Provincia");
				campo11 = datos.getString("Pais");
				campo12 = datos.getString("FechaNacimiento");
				consulta += (campo1 + "\t" + campo2 + "\t" + campo3 + "\t" + campo4 + "\t" + campo5 + "\t" + campo6
							+ "\t" + campo7 + "\t" + campo8 + "\t" + campo9 + "\t" + campo10 + "\t" + campo11 + "\t"
						    + campo12 + "\n");
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
				"INSERT INTO alumnoInteresado  (cursoInteresado,Observaciones,idAlumno ) VALUES ('"
				+ curso + "','" + observaciones +"','" + idAlum +"')");
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