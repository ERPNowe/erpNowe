package cursos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import cursos.ConexionBaseDatos;
import cursos.VentanaGrupos;
import utilidades.Fecha;
/**@author Eva
 * @version 1
 * @since 20151118
 */
public class Grupos extends ConexionBaseDatos{
	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	 static ConexionBaseDatos conexion = new ConexionBaseDatos(bd, usuario, pwd);
	
	public Grupos(String bd, String usuario, String pwd) {
		super(bd, usuario, pwd);
		}
	/** <p>Atributos </p>
	 */
	private static int idGrupo;//autoincremental, habrá que poner un idGrupo++ después de crear un grupo
	private String idAcademia;
	private String idOficial;
	private String horario;
	private Date fechaInicio;
	private Date fechaFin;
	private String aula;
	private int idCurso;
	/** <p>Getter y Setter de todos los atributos </p>
	 */
	public static int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getIdAcademia() {
		return idAcademia;
	}
	public void setIdAcademia(String idAcademia) {
		this.idAcademia = idAcademia;
	}
	public String getIdOficial() {
		return idOficial;
	}
	public void setIdOficial(String idOficial) {
		this.idOficial = idOficial;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	/** <p>Método para insertar nuevos grupos </p>
	 *@param<idAcademia, idOficial, horario, fechaInicio, fechaFin, aula, idCurso> 
	 */
	public static String insertar(String idAcademia,	String idOficial,	String horario,	String stfechaInicio,	String stfechaFin,String aula,
	int idCurso){
		boolean ok = false;
		String resultado = null;
		try {
				ok = conexion.setQuery("INSERT INTO grupos(idAcademia, idOficial, horario, fechaInicio, fechaFin, aula, idCurso)"
						+ " VALUES ('" + idAcademia+"','"+ idOficial+"','"+ horario+"','"+ stfechaInicio
						+"','"+ stfechaFin+"','"+ aula+"',"+ idCurso + ")");
				if(ok)
					resultado = "Se insertó el grupo";
					//System.out.println("Se insertó el registro");
				else
					resultado = "No se insertó el grupo";
					//System.out.println("No se insertó");
			} 
		catch(Exception e){ e.printStackTrace(); }
		return resultado;}
	/** <p>Método para modificar los datos de un grupo </p>
	 *@param<idAcademia, idOficial, horario, fechaInicio, fechaFin, aula, idCurso> 
	 */
	public static String modificar(int idGrupo,String idAcademia, String idOficial, String horario,	String stfechaInicio,	String stfechaFin,String aula,
			int idCurso){
		boolean ok = false;
		String resultado = null;
		try {
				ok = conexion.setQuery("UPDATE grupos SET idAcademia = '" + idAcademia +"',"
														+ "idOficial = '" + idOficial +"',"
														+ "horario = '" + horario +"',"
														+ "fechaInicio = '" + stfechaInicio +"',"
														+ "fechaFin = '" + stfechaFin +"',"
														+ "aula = '" + aula +"', "
														+ "idCurso = " + idCurso 
														+ " WHERE idGrupo = " + idGrupo+";");    
				if(ok)
					resultado = "Se modificó el grupo";
					//System.out.println("Se modificó");
				else
					resultado = "No se modificó el grupo";
					//System.out.println("No se modificó");
			} 
		catch(Exception e){ e.printStackTrace(); }
		return resultado;}
	
	/** <p>Método para eliminar un grupo </p>
	 *@param<idGrupo> 
	 */
	public static String eliminar(int idGrupo){
		boolean ok = false;
		String resultado = null;
		try {
				ok = conexion.setQuery("DELETE FROM grupos WHERE idGrupo = "+ idGrupo );
				if(ok)
					resultado = "Se borró el grupo";
				else
					resultado = "No se borró el grupo";
					} 
		catch(Exception e){ e.printStackTrace(); }	
	return resultado;}
	/** 
	 * <p>Método para consultar la información de un grupo </p>
	 * @return datos
	 */
	public static ResultSet consultar(String idGrupo){
		ResultSet datos;
		 datos = conexion.getQuery("SELECT * FROM grupos WHERE idGrupo =" + idGrupo );
		return datos;
	}
	
	public static String listar(){
		ResultSet datos;
		String campo1, campo2, campo3,campo4,campo5,campo6,campo7,campo8, resultado ="";
		 datos = conexion.getQuery("SELECT * FROM grupos");
		 try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  //resultado = "idGrupo\t"+"idAcademia\t"+"idOficial \t"+"horario\t"+"fechaInicio\t"+"fechaFin\t"+"aula\t"+"idCurso\t";
		    	  campo1 = datos.getString("idGrupo"); 
		    	  campo2 = datos.getString("idAcademia");
		    	  campo3 = datos.getString("idOficial");
		    	  campo4 = datos.getString("horario");
		    	  campo5 = datos.getString("fechaInicio");
		    	  campo6 = datos.getString("fechaFin");
		    	  campo7 = datos.getString("aula");
		    	  campo8 = datos.getString("idCurso");
		    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2 + "\t" + campo3
		    			  + "\t" + campo4 + "\t" + campo5 + "\t" + campo6 + "\t" + campo7 + "\t" + campo8 ; 
		      }
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		return resultado;
	}
		
}



