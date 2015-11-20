package Matricula;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase Matricula
 * @author Vanessa
 * @version 1.0
 * @since 18/11/2015
 * <br>
 * <p>
 * Esta clase se corresponde con los atributos y
 *  los metodos de la clase matricula
 * </p>
 */

/**
 *  definir los atributos miembros de la clase
 *
 */
public class Matricula {

	private int idAlumno;
	private int idGrupo;
	private String formaPago;
	private String promociones;
	private int pagado;
	
/**
 * sobrecarga de constructotes constructor parametrizado
 */

	public Matricula(int idAlumno, int idGrupo, String formaPago, String promociones, int pagado) {
		this.idAlumno = idAlumno;
		this.idGrupo = idGrupo;
		this.formaPago = formaPago;
		this.promociones = promociones;
		this.pagado = pagado;
	}

	
	public int getIdAlumno() {
		return idAlumno;
	}
	
	public int getIdGrupo() {
		return idGrupo;
	}
	
	public String getFormaPago() {
		return formaPago;
	}
	
	public String getPromociones() {
		return promociones;
	}
	
	public int getPagado() {
		return pagado;
	}
	
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}


	public void setPromociones(String promociones) {
		this.promociones = promociones;
	}


	public void setPagado(int pagado) {
		this.pagado = pagado;
	}
	
/**
 *  Metodo crearPresupuesto, aun en proceso, ****NO TERMINADO****
 */
	
	public static String crearPresupuesto(){
		
		float presupuesto= 1000.0F;
		float descsitulabo = 20.00F;
		float desctipopago = 5.0F;
		float presupuestoFinal = presupuesto;
		String tipoCurso;
		String situacionLaboral;
		String tipoPago;
		String resultado;
		
		//esto se borrar�, es solo para comprobar los casos
		tipoCurso = "privado";
		situacionLaboral = "desempleado";
		tipoPago = "PagoUnico";
		
		if (tipoCurso == "publico"){
			presupuestoFinal = 0;
		}
		else {
			if (situacionLaboral == "desempleado"){
				presupuestoFinal = presupuesto - ((presupuesto*descsitulabo)/100);
				if (tipoPago == "PagoUnico"){
					presupuestoFinal = presupuesto - ((presupuesto*(descsitulabo + desctipopago))/100);
				}
				
			}else {
				if (tipoPago == "PagoUnico"){
				presupuestoFinal = presupuesto - ((presupuesto * desctipopago)/100);}
			}
		}
		resultado = "el presupuesto sin descuento es = " + presupuesto+ "\n" +" y el presupuesto "
				     + " final que te queda con descuento = " + presupuestoFinal;
		
		return resultado;
						
	}//fin del metodo crearPresupuesto
	
/**

 * Metodo ConsultarID
 * Consulta las matriculas del alumno que hemos indicado
 * @return el resultado de la consulta
 */

	public static String Consultarid(String idAlumno){
		ResultSet datos;
	    String campo1, campo2, campo3, campo4,campo5, resultado ="";
	    datos = principal.conexion.getQuery("SELECT * FROM matricula where idAlumno =" + idAlumno);
	    try {
	      while(datos.next()){//es el metodo que permite ir recorriendo los datos
	    	  campo1 = datos.getString("idAlumno"); //podemos poner el nombre o un numero
	    	  campo2 = datos.getString("idGrupo");
	    	  campo3 = datos.getString("FormaPago");
	    	  campo4 = datos.getString("Promociones");
	    	  campo5 = datos.getString("Pagado");
	    	  
	    	  if (campo5=="1")
	    		  campo5="Pagado";
	    	  else campo5="No Pagado";
	    	  
	    	  resultado = resultado +"\n"+"Alumno: "+campo1 + "\n" 
	    	  +"Grupo: " + campo2 + "\n"
	    	  +"forma de pago: " + campo3 + "\n"
	    	  + campo4 + "\n"
	    	  + campo5 + "\n"+ "\n"; 
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	    }
	    return resultado; }
	
	/**

	 * Metodo ConsultarGR
	 * Consulta las matriculas del grupo que hemos indicado
	 * @return el resultado de la consulta
	 */

		public static String ConsultarGR(String idGrupo){
			ResultSet datos;
		    String campo1, campo2, campo3, campo4,campo5, resultado ="";
		    datos = principal.conexion.getQuery("SELECT * FROM matricula where idGrupo =" + idGrupo);
		    try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  campo1 = datos.getString("idAlumno"); //podemos poner el nombre o un numero
		    	  campo2 = datos.getString("idGrupo");
		    	  campo3 = datos.getString("FormaPago");
		    	  campo4 = datos.getString("Promociones");
		    	  campo5 = datos.getString("Pagado");
		    	  
		    	  //este if lo pongo para que no se vea solo un numero en la consulta, si no, pagado o no pagado
		    	  if (campo5=="1")
		    		  campo5="Pagado";
		    	  else campo5="No Pagado";
		    	  
		    	  resultado = resultado +"\n"+"Alumno: "+campo1 + "\n" 
		    	  +"Grupo: " + campo2 + "\n"
		    	  +"forma de pago: " + campo3 + "\n"
		    	  + campo4 + "\n"
		    	  + campo5 + "\n"+ "\n"; 
		      }
		    }
		    catch (SQLException e) { e.printStackTrace();
		    }
		    return resultado; }
		
	
	/**
	 * Metodo Consultar
	 * Consulta toda la tabla matricula
	 * @return el resultado de la consulta
	 */

		public static String Consultar(){
			ResultSet datos;
		    String campo1, campo2, campo3, campo4,campo5, resultado ="";
		    datos = principal.conexion.getQuery("SELECT * FROM matricula");
		    try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  campo1 = datos.getString("idAlumno"); //podemos poner el nombre o un numero
		    	  campo2 = datos.getString("idGrupo");
		    	  campo3 = datos.getString("FormaPago");
		    	  campo4 = datos.getString("Promociones");
		    	  campo5 = datos.getString("Pagado");
		    	  
		    	  if (campo5=="1")
		    		  campo5="Pagado";
		    	  else campo5="No Pagado";
		    	  
		    	  resultado = resultado +"\n"+"Alumno: "+campo1 + "\n" 
		    	    	  +"Grupo: " + campo2 + "\n"
		    	    	  +"forma de pago: " + campo3 + "\n"
		    	    	  + campo4 + "\n"
		    	    	  + campo5 + "\n"+ "\n"; 
		      }
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		    return resultado; }
	

	
}