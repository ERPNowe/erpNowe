package matricula;

import java.sql.ResultSet;
import java.sql.SQLException;

import basedatos.ConexionBaseDatos;
import ventanaPrincipal.VentanaPrincipal;


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
	
	 
	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	 //public static ConexionBaseDatos conexion = null;
	 static ResultSet filas = null;
	
	 public static void main(String[] args) {
	   //conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
	   VentanaMatricula ventana = new VentanaMatricula();
	   ventana.setVisible(true);

	}
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
	
	public static void menuAlumno(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT idAlumno FROM alumnos ORDER BY idAlumno");
		try {
			while(filas.next()){
				VentanaMatricula.alumno.addItem(filas.getString("idAlumno"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	public static void menuGrupo(){
		filas = VentanaPrincipal.conexion.getQuery("Select g.idOficial from cursos c, grupos g where c.idCurso = g.idCurso");
		try {
			while(filas.next()){
				VentanaMatricula.grupo.addItem(filas.getString("idOficial"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	public static void menuFormaPago(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT descripcion FROM formapago");
		try {
			while(filas.next()){
				VentanaMatricula.formaPago.addItem(filas.getString("descripcion"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}

	public static void menuPromociones(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT promociones FROM matricula");
		try {
			while(filas.next()){
				VentanaMatricula.promociones.addItem(filas.getString("promociones"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	public static void menuPagado(){
		filas = VentanaPrincipal.conexion.getQuery("SELECT pagado FROM matricula");
		try {
			while(filas.next()){
				VentanaMatricula.pagado.addItem(filas.getString("pagado"));
			}
		}
		catch (SQLException e) {e.printStackTrace();
		}
	}
	/**
	 * metodo crearPresupuesto
	 * Crea un presupuesto teniendo en cuenta el precio del curso y la promoción
	 * @param idGrupo
	 * @param promociones
	 * @return el precio final a pagar por el alumno
	 */
	
	public static String crearPresupuesto(int idGrupo, String promociones){
		ResultSet datos, datos1, datos2;
		
			String Precio = null;
			int idCurso = 0;
		    datos1 = VentanaPrincipal.conexion.getQuery("SELECT idCurso  FROM grupos where idGrupo =" +idGrupo);	  
		    try {
			      while(datos1.next()){
			    	  idCurso = datos1.getInt("idCurso");} 
			      }
			      catch (SQLException e1) {
						e1.printStackTrace();
					}	
		    
		    datos2 = VentanaPrincipal.conexion.getQuery("SELECT Precio FROM cursos where idCurso =" +idCurso);
		    try {
			      while(datos2.next()){
			    	  Precio = datos2.getString("Precio");
			      }
			      }
			      catch (SQLException e1) {
						e1.printStackTrace();
					}	
		    		
			    float Precio1 = Float.valueOf(Precio); 
				float resultado;
				switch(promociones){
		    	  case "Desempleado":
		    		 resultado = (Precio1 - (Precio1 * 0.20F));
		    		  break;
		    	  case "Pago Unico":
		    		  resultado = (Precio1 - (Precio1 * 0.05F));
		    		  break;
		    	  case "Desempleado + Pago Unico":
		    		  resultado = (Precio1 - (Precio1 * 0.25F));
		    		  break;
		    	  default: 
		    		  resultado = Precio1;
		    		  break; 
		    	  }
				return "Su presupuesto es: " + resultado;
	}
	
/**

 * Metodo ConsultarID
 * Consulta las matriculas del alumno que hemos indicado
 * @param idAlumno
 * @return el resultado de la consulta
 */

	public static String Consultarid(String idAlumno){
		ResultSet datos;
	    String idMatricula, idAlumno1, idGrupo, FormaPago, desempleado,promociones, Pagado,resultado ="";
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM matricula where idAlumno =" + idAlumno);
	    try {
	      while(datos.next()){
	    	  idMatricula = datos.getString("idMatricula");
	    	  idAlumno1 = datos.getString("idAlumno"); 
	    	  idGrupo = datos.getString("idGrupo");
	    	  FormaPago = datos.getString("FormaPago");
	    	  desempleado = datos.getString("desempleado");
	    	  promociones = datos.getString("promociones");
	    	  Pagado = datos.getString("Pagado");
	    	  
	    	  if (Integer.parseInt(Pagado) == 1)
	    		  Pagado = "Pagado";
	    	  else Pagado = "No Pagado";
	    	  
	    	  if (Integer.parseInt(desempleado) == 1)
	    		  desempleado = "Desempleado";
	    	  else
	    		  desempleado = "No Desempleado";
	    	  
	    	  switch(promociones){
	    	  case "Desempleado":
	    		  promociones = "20";
	    		  break;
	    	  case "Pago Unico":
	    		  promociones = "5";
	    		  break;
	    	  case "Desempleado + Pago Unico":
	    		  promociones = "25";
	    		  break;
	    	  default: 
	    		  promociones = "0";
	    		  break; 
	    	  }
	    	  resultado = resultado +"\n" + "Matricula: " +idMatricula+ "\n" + "Alumno: "+idAlumno1 + "\n" 
	    	    	  +"Grupo: " + idGrupo + "\n"
	    	    	  +"forma de pago: " + FormaPago + "\n"
	    	    	  + desempleado + "\n"
	    	    	  +"promocion: "+ promociones + "%\n"
	    	    	  + Pagado + "\n"; 
	      }
	      VentanaMatricula.Insertar.setEnabled(true);
	      VentanaMatricula.Presupuesto.setEnabled(true);
	      VentanaMatricula.Modificar.setEnabled(true);
	      
	      
	    }
	    catch (SQLException e) { e.printStackTrace();
	    }
	    
	    return resultado; }
	
	/**

	 * Metodo ConsultarGR
	 * Consulta las matriculas del grupo que hemos indicado
	 * @param idGrupo
	 * @return el resultado de la consulta
	 */

		public static String ConsultarGR(String idGrupo){
			ResultSet datos;
			 String idMatricula,idAlumno, idGrupo1, FormaPago, desempleado,promociones, Pagado,resultado ="";
		    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM matricula where idGrupo =" + idGrupo);
		    try {
		      while(datos.next()){
		    	  idMatricula = datos.getString("idMatricula");
		    	  idAlumno = datos.getString("idAlumno"); 
		    	  idGrupo1 = datos.getString("idGrupo");
		    	  FormaPago = datos.getString("FormaPago");
		    	  desempleado = datos.getString("desempleado");
		    	  promociones = datos.getString("promociones");
		    	  Pagado = datos.getString("Pagado");
		    	  
		    	  if (Integer.parseInt(Pagado) == 1)
		    		  Pagado = "Pagado";
		    	  else Pagado = "No Pagado";
		    	  
		    	  if (Integer.parseInt(desempleado) == 1)
		    		  desempleado = "Desempleado";
		    	  else
		    		  desempleado = "No Desempleado";
		    	  
		    	  switch(promociones){
		    	  case "Desempleado":
		    		  promociones = "20";
		    		  break;
		    	  case "Pago Unico":
		    		  promociones = "5";
		    		  break;
		    	  case "Desempleado + Pago Unico":
		    		  promociones = "25";
		    		  break;
		    	  default: 
		    		  promociones = "0";
		    		  break; 
		    	  }
		    	  resultado = resultado +"\n" + "Matricula: " +idMatricula+ "\n" + "Alumno: "+idAlumno + "\n" 
		    	    	  +"Grupo: " + idGrupo1 + "\n"
		    	    	  +"forma de pago: " + FormaPago + "\n"
		    	    	  + desempleado + "\n"
		    	    	  +"promocion: "+ promociones + "%\n"
		    	    	  + Pagado + "\n"; 
		      }
		      VentanaMatricula.Insertar.setEnabled(true);
		      VentanaMatricula.Presupuesto.setEnabled(true);
		      VentanaMatricula.Modificar.setEnabled(true);
		    }
		    catch (SQLException e) { e.printStackTrace();
		    }
		    return resultado; }
		
	
	/**
	 * Metodo Consultar
	 * Consulta toda la tabla matricula
	 * @param idMatricula
	 * @param idAlumno
	 * @param idGrupo1
	 * @param FormaPago
	 * @param desempleado
	 * @param promociones
	 * @param Pagado
	 * @return el resultado de la consulta
	 */

		public static String Consultar(){
			ResultSet datos;
			 String idMatricula, idAlumno1, idGrupo1, FormaPago, desempleado,promociones, Pagado,resultado ="";
		    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM matricula");
		    try {
		      while(datos.next()){
		    	  idMatricula = datos.getString("idMatricula");
		    	  idAlumno1 = datos.getString("idAlumno"); 
		    	  idGrupo1 = datos.getString("idGrupo");
		    	  FormaPago = datos.getString("FormaPago");
		    	  desempleado = datos.getString("desempleado");
		    	  promociones = datos.getString("promociones");
		    	  Pagado = datos.getString("Pagado");
		    	  
		    	  if (Integer.parseInt(Pagado) == 1)
		    		  Pagado = "Pagado";
		    	  else Pagado = "No Pagado";
		    	  
		    	  if (Integer.parseInt(desempleado) == 1)
		    		  desempleado = "Desempleado";
		    	  else
		    		  desempleado = "No Desempleado";
		    	  
		    	  switch(promociones){
		    	  case "Desempleado":
		    		  promociones = "20";
		    		  break;
		    	  case "Pago Unico":
		    		  promociones = "5";
		    		  break;
		    	  case "Desempleado + Pago Unico":
		    		  promociones = "25";
		    		  break;
		    	  default: 
		    		  promociones = "0";
		    		  break; 
		    	  }
		    		
		    	  resultado = resultado +"\n" + "Matricula: " +idMatricula+ "\n" + "Alumno: "+idAlumno1 + "\n" 
		    	    	  +"Grupo: " + idGrupo1 + "\n"
		    	    	  +"forma de pago: " + FormaPago + "\n"
		    	    	  + desempleado + "\n"
		    	    	  +"promocion: "+ promociones + "%\n"
		    	    	  + Pagado + "\n"; 
		      }
		      VentanaMatricula.Insertar.setEnabled(true);
		      VentanaMatricula.Presupuesto.setEnabled(true);
		      VentanaMatricula.Modificar.setEnabled(true);
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		    return resultado; }
	
		/**
		 * Metodo para insertar un nuevo registro en la tabla
		 * @param idAlumno
		 * @param idGrupo
		 * @param FormaPago
		 * @param Desempleado
		 * @param Promociones
		 * @param Pagado
		 * @return resultado (si se puede o no insertar)
		 */
		public static String insertar(String idMatricula,
										int idAlumno, 
										int idGrupo, 
										int FormaPago,
										int Desempleado,
										String Promociones,
										int Pagado){
			 boolean ok = false;
			 String resultado = null;
			 try {
					 ok = VentanaPrincipal.conexion.setQuery("INSERT INTO matricula (idMatricula,idAlumno, idGrupo,FormaPago,Desempleado,Promociones,Pagado)"
							+ " VALUES ('" +idMatricula+"','"+ idAlumno + "','" + idGrupo + "','"+FormaPago+  "','"+Desempleado+ "','"+Promociones+ "','"+  Pagado +"')");
					 if (ok) 
						 resultado = "Se insertó la matricula correctamente";
					 else 
						resultado = "No se pudo insertar la matricula";	 
				} 
			 
			 catch(Exception e){ e.printStackTrace(); }
			return resultado;
			
		}
		
		/**
		 * metodo modificar
		 * Modifica las matriculas existentes en la tabla
		 * @param idMatricula
		 * @param idAlumno
		 * @param idGrupo
		 * @param FormaPago
		 * @param Desempleado
		 * @param Promociones
		 * @param Pagado
		 * @return resultado (si se puede o no modificar)
		 */
		 
		public static String modificar(String idMatricula, 
				int idAlumno, 
				int idGrupo, 
				int FormaPago,
				int Desempleado,
				String Promociones,
				int Pagado){
			
			 boolean ok = false;
			 String resultado = null;
			 
			 try{
				 ok = VentanaPrincipal.conexion.setQuery("UPDATE matricula set idAlumno = '"+idAlumno+"',idGrupo = '"+ idGrupo
						 + "',FormaPago = '"+FormaPago +"', Desempleado = '"+Desempleado +"',Promociones = '"+Promociones +"',Pagado = '"+Pagado +"' where idMatricula= '"+idMatricula+"'");
				 if (ok) 
					 resultado = "Se modificó la matricula correctamente";
				 else 
					 resultado = "No se pudo modificar la matricula";	 
			 }
			 catch(Exception e){ e.printStackTrace(); }
			 return resultado;
		}
}