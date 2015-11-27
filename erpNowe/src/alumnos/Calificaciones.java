
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

	
	public int idAlumno;
	public String idModulo;
	public float notas;
	public boolean diplomaRecogido;
	public String observaciones;
	
	
	
	public Calificaciones(int idAlumno, String idModulo, float notas, boolean diplomaRecogido, String observaciones) {
		super();
		this.idAlumno = idAlumno;
		this.idModulo = idModulo;
		this.notas = notas;
		this.diplomaRecogido = diplomaRecogido;
		this.observaciones = observaciones;
	}
	 public static void main(String[] args) {
		VentanaCalificaciones ventana=new VentanaCalificaciones();
	    ventana.setVisible(true);
	}

	public int getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}



	public String getIdModulo() {
		return idModulo;
	}



	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}



	public float getNotas() {
		return notas;
	}



	public void setNotas(float notas) {
		this.notas = notas;
	}



	public boolean isDiplomaRecogido() {
		return diplomaRecogido;
	}



	public void setDiplomaRecogido(boolean diplomaRecogido) {
		this.diplomaRecogido = diplomaRecogido;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public static String Consultar(){
	 	ResultSet datos;
	    String campo1, campo2, campo3,campo4,campo5,resultado ="";
	    datos = VentanaPrincipal.conexion.getQuery("SELECT idAlumno,idModulo FROM alumnos,modulos;");
	    try {
	      while(datos.next()){//es el metodo que permite ir recorriendo los datos
	    	  campo1 = datos.getString("idCurso"); //podemos poner el nombre o un numero
	    	  campo2 = datos.getString("CodigoCurso");
	    	  campo3= datos.getString("Notas");
	    	  campo4= datos.getString("Recogido");
	    	  campo5= datos.getString("Observaciones");
	    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2 + "\t" + campo3
	    			  + "\t" + campo4 + "\t" + campo5 + "\t"  ; 
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	    return resultado; 
 }
	
	
}
