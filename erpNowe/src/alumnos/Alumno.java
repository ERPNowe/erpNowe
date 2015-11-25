package alumnos;

import java.sql.Date;

public class Alumno {
	
	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String DNI;
	private String email;
	private int telefono;
	private String direccion;
	private int codigoPostal;
	private String municipio;
	private String provincia;
	private String pais;
	private Date fechaNacimiento;
	
	
	public Alumno(int idAlumno, String nombre, String apellidos, String dNI, String email, int telefono,
			String direccion, int codigoPostal, String municipio, String provincia, String pais, Date fechaNacimiento) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.municipio = municipio;
		this.provincia = provincia;
		this.pais = pais;
		this.fechaNacimiento = fechaNacimiento;
	}
	



	public int getIdAlumno() {
		return idAlumno;
	}







	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}







	public String getNombre() {
		return nombre;
	}







	public void setNombre(String nombre) {
		this.nombre = nombre;
	}







	public String getApellidos() {
		return apellidos;
	}







	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}







	public String getDNI() {
		return DNI;
	}







	public void setDNI(String dNI) {
		DNI = dNI;
	}







	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public int getTelefono() {
		return telefono;
	}







	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}







	public String getDireccion() {
		return direccion;
	}







	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}







	public int getCodigoPostal() {
		return codigoPostal;
	}







	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}







	public String getMunicipio() {
		return municipio;
	}







	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}







	public String getProvincia() {
		return provincia;
	}







	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}







	public String getPais() {
		return pais;
	}







	public void setPais(String pais) {
		this.pais = pais;
	}







	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}







	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



public void insertar() {
	
	
}

public void modificar(){
	
	
}

public void consultar() {
	
	
}

public void eliminar(){
	
	
}

	

}
