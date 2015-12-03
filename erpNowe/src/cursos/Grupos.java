package cursos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
/**
 * importar librer�as creadas por usuario*/
import cursos.VentanaGrupos;
import cursos.VentanaGrupos.Paneles;
import cursos.VentanaCursos.Panel;
import utilidades.Fecha;
import ventanaPrincipal.VentanaPrincipal;
/**@author Eva
 * @version 1
 * @since 20151118
 */
public class Grupos {
	 /*private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	 static ConexionBaseDatos conexion = new ConexionBaseDatos(bd, usuario, pwd);*/
	public static void main(String[] args) {
		 
	    VentanaGrupos ventana=new VentanaGrupos();
	    ventana.setVisible(true);
	}
	
	/** <p>Atributos </p>
	 */
	private static int idGrupo;//autoincremental, habr� que poner un idGrupo++ despu�s de crear un grupo
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
	/** <p>M�todo para insertar nuevos grupos </p>
	 *@param<idAcademia, idOficial, horario, fechaInicio, fechaFin, aula, idCurso> 
	 */
	public static String insertar(String idAcademia,	String idOficial,	String horario,	String stfechaInicio,	String stfechaFin,String aula,
	int idCurso){
		/*antes de insertar hay que comprobar que el formato de la fecha sea correcto. Si ya est� en formato aaaa/mm/dd 
		 * no se cambia*/
		boolean ok = false;
		String resultado = null;
		try {
				ok = VentanaPrincipal.conexion.setQuery("INSERT INTO grupos(idAcademia, idOficial, horario, fechaInicio, fechaFin, aula, idCurso)"
						+ " VALUES ('" + idAcademia+"','"+ idOficial+"','"+ horario+"','"+ stfechaInicio
						+"','"+ stfechaFin+"','"+ aula+"',"+ idCurso + ")");
				if(ok){
					//resultado = "Se insert� el grupo";
					//System.out.println("Se insert� el registro");
				JOptionPane.showMessageDialog(null, "Se insert� el registro ");	}
				else
					//resultado = "No se insert� el grupo";
				JOptionPane.showMessageDialog(null, "No se insert� el registro ");
					//System.out.println("No se insert�");
			} 
		catch(Exception e){ e.printStackTrace(); }
		return resultado;}
	/** <p>M�todo para modificar los datos de un grupo </p>
	 *@param<idAcademia, idOficial, horario, fechaInicio, fechaFin, aula, idCurso> 
	 */
	public static String modificar(int idGrupo,String idAcademia, String idOficial, String horario,	String stfechaInicio,	String stfechaFin,String aula,
			int idCurso){
		boolean ok = false;
		String resultado = null;
		try {
				ok = VentanaPrincipal.conexion.setQuery("UPDATE grupos SET idAcademia = '" + idAcademia +"',"
														+ "idOficial = '" + idOficial +"',"
														+ "horario = '" + horario +"',"
														+ "fechaInicio = '" + stfechaInicio +"',"
														+ "fechaFin = '" + stfechaFin +"',"
														+ "aula = '" + aula +"', "
														+ "idCurso = " + idCurso 
														+ " WHERE idGrupo = " + idGrupo+";");    
				if(ok)
					JOptionPane.showMessageDialog(null, "Se modific� el registro ");
					//resultado = "Se modific� el grupo";
					//System.out.println("Se modific�");
				else
					JOptionPane.showMessageDialog(null, "No se modific� el registro ");
					//resultado = "No se modific� el grupo";
					//System.out.println("No se modific�");
			} 
		catch(Exception e){ e.printStackTrace(); }
		return resultado;}
	
	/** <p>M�todo para eliminar un grupo </p>
	 *@param<idGrupo> 
	 */
	public static String eliminar(int idGrupo){
		boolean ok = false;
		String resultado = null;
		try {
				ok = VentanaPrincipal.conexion.setQuery("DELETE FROM grupos WHERE idGrupo = "+ idGrupo );
				if(ok)
					JOptionPane.showMessageDialog(null, "Se borr� el registro ");
					//resultado = "Se borr� el grupo";
				else
					JOptionPane.showMessageDialog(null, "No se borr� el registro ");
					//resultado = "No se borr� el grupo";
					} 
		catch(Exception e){ e.printStackTrace(); }	
	return resultado;}
	/** 
	 * <p>M�todo para consultar la informaci�n de un grupo </p>
	 * @return datos
	 */
	public static ResultSet consultar(String idGrupo,Paneles paneles){
		ResultSet datos;
		String cidGrupo, cidAcademia, cidOficial,chorario,cfecInicio,cfecFin,caula,cidCurso, resultado ="";
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM grupos WHERE idGrupo =" + idGrupo );
		 try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  //resultado = "idGrupo\t"+"idAcademia\t"+"idOficial \t"+"horario\t"+"fechaInicio\t"+"fechaFin\t"+"aula\t"+"idCurso\t";
		    	  cidGrupo = datos.getString("idGrupo"); 
		    	  cidAcademia = datos.getString("idAcademia");
		    	  cidOficial = datos.getString("idOficial");
		    	  chorario = datos.getString("horario");
		    	  cfecInicio = datos.getString("fechaInicio");
		    	  cfecFin = datos.getString("fechaFin");
		    	  caula = datos.getString("aula");
		    	  cidCurso = datos.getString("idCurso");
		    	  //resultado = resultado +"\n"+ cidGrupo + "\t" + cidAcademia + "\t" + cidOficial
		    		//	  + "\t" + chorario + "\t" + cfecInicio + "\t" + cfecFin + "\t" + caula + "\t" + cidCurso ; 
		    	  paneles.getModelo().addRow( new Object[] {cidGrupo, cidAcademia, cidOficial,chorario,cfecInicio,cfecFin,caula,cidCurso});
		 }}
		      catch (SQLException e) { e.printStackTrace();
			   }
		datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM grupos WHERE idGrupo =" + idGrupo );
		return datos;}
		
		
		
		
	
	
	public static String listar(Paneles paneles){
		ResultSet datos;
		String cidGrupo, cidAcademia, cidOficial,chorario,cfecInicio,cfecFin,caula,cidCurso, resultado ="";
		 datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM grupos");
		 try {
		      while(datos.next()){//es el metodo que permite ir recorriendo los datos
		    	  //resultado = "idGrupo\t"+"idAcademia\t"+"idOficial \t"+"horario\t"+"fechaInicio\t"+"fechaFin\t"+"aula\t"+"idCurso\t";
		    	  cidGrupo = datos.getString("idGrupo"); 
		    	  cidAcademia = datos.getString("idAcademia");
		    	  cidOficial = datos.getString("idOficial");
		    	  chorario = datos.getString("horario");
		    	  cfecInicio = datos.getString("fechaInicio");
		    	  cfecFin = datos.getString("fechaFin");
		    	  caula = datos.getString("aula");
		    	  cidCurso = datos.getString("idCurso");
		    	  //resultado = resultado +"\n"+ cidGrupo + "\t" + cidAcademia + "\t" + cidOficial
		    		//	  + "\t" + chorario + "\t" + cfecInicio + "\t" + cfecFin + "\t" + caula + "\t" + cidCurso ; 
		    	  paneles.getModelo().addRow( new Object[] {cidGrupo, cidAcademia, cidOficial,chorario,cfecInicio,cfecFin,caula,cidCurso});} 
		      
		    }
		    catch (SQLException e) { e.printStackTrace();
		   }
		return resultado;
	}
		
}



