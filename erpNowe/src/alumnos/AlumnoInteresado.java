package alumnos;

import java.sql.Date;

public class AlumnoInteresado extends Alumno  {
	private char idInteresado;
	private String cursosInteresado;
	private String observaciones;
	//private int idAlumno; /*este atributo es heredadod de la clase padre Alumno*/
	public AlumnoInteresado(int idAlumno, String nombre, String apellidos, String dNI, String email, int telefono,
			String direccion, int codigoPostal, String municipio, String provincia, String pais, Date fechaNacimiento,
			char idInteresado,String cursosInteresado,String observaciones) {
		super(idAlumno, nombre, apellidos, dNI, email, telefono, direccion, codigoPostal, municipio, provincia, pais,
				fechaNacimiento);
		this.idInteresado =idInteresado;
		this.cursosInteresado=cursosInteresado;
		this.observaciones=observaciones;
		
		
	}
	
	
	public char getIdInteresado() {
		return idInteresado;
	}


	public void setIdInteresado(char idInteresado) {
		this.idInteresado = idInteresado;
	}


	public String getCursosInteresado() {
		return cursosInteresado;
	}


	public void setCursosInteresado(String cursosInteresado) {
		this.cursosInteresado = cursosInteresado;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public void pedirInformacion() {
		
		
	}
	

	public void visualizarCursos(){
		
		
		
	}
	
	public void solicitarPresupuesto(){
		
		
	}
}
