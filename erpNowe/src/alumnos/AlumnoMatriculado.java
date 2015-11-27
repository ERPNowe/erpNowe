/**
 * Clase AlumnoMatriculado
 * @autor curso14/7803
 * @version 1.0
 * @since 18/11/2015
 * <br>
 * <p>
 * Esta clase se corresponde con los metodos principales 
 * de acceso y gestión a la tabla Alumno Matriculado
 * </p>
 */

package alumnos;

import java.sql.Date;

public class AlumnoMatriculado extends Alumno {
	
private int idMatriculado;
private String grupoMatriculado;

public AlumnoMatriculado(int idAlumno, String nombre, String apellidos, String dNI, String email, int telefono,
		String direccion, int codigoPostal, String municipio, String provincia, String pais, Date fechaNacimiento, 
		int idMatriculado, String grupoMatriculado) {
	
	super(idAlumno, nombre, apellidos, dNI, email, telefono, direccion, codigoPostal, municipio, provincia, pais,
			fechaNacimiento);
	
	this.idMatriculado = idMatriculado;
	this.grupoMatriculado = grupoMatriculado;

}

public int getIdMatriculado() {
	return idMatriculado;
}

public void setIdMatriculado(int idMatriculado) {
	this.idMatriculado = idMatriculado;
}

public String getGrupoMatriculado() {
	return grupoMatriculado;
}

public void setGrupoMatriculado(String grupoMatriculado) {
	this.grupoMatriculado = grupoMatriculado;
}

public void obtenerNotas() {	
	
}	
	
}
