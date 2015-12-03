/**
 * Clase FormaPago
 * @author Victor y Vanessa
 * @version 1.0
 * @since 20/11/2015
 * <br>
 * <p> 
 * Esta clase corresponde a la gestion de forma de pagos
 * </p> 
 */

package matricula;


import java.sql.ResultSet;
import java.sql.SQLException;
import ventanaPrincipal.VentanaPrincipal;
import matricula.VentanaFormaPago.Panel;


public class FormaPago {

	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	 //static ConexionBaseDatos conexion = null;
	 //static Scanner scanner = new Scanner(System.in);
	 
 public static void main(String[] args) {
	 // En caso de no tener contraseña pwd = ""
    //conexion = new ConexionBaseDatos(bd, usuario, pwd);
    //System.out.println(consultaFormaPago());
	 VentanaFormaPago ventana = new VentanaFormaPago();
	  ventana.setVisible(true);
 }
 
 /**
  * metodo para consultar las formas de pago
  * @return la consulta
  */
 public static void listado(Panel panel){
	 	ResultSet datos;
	    String id, descripcion, resultado ="";
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM formapago");
	    try {
	      while(datos.next()){
	    	  id = datos.getString("idFormaPago"); 
	    	  descripcion = datos.getString("descripcion");
	    	  resultado = resultado +"\n"+ id + "\t" + descripcion; 
	      
	      VentanaFormaPago.modificar.setEnabled(true);
	      VentanaFormaPago.insertar.setEnabled(true);
	      VentanaFormaPago.borrar.setEnabled(true);
	      panel.getModelo().addRow( new Object[] {id, descripcion} );
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	    
 }
 /**
  * metodo para consultar una forma de pago, dependiendo del id
  * @param idFormaPago
  * @return la consulta
  */
 public static void consultar(String idFormaPago, matricula.VentanaFormaPago.Panel panel){
	 
	 	ResultSet datos;
	    String id, descripcion, resultado ="";
	    datos = VentanaPrincipal.conexion.getQuery("SELECT * FROM formapago WHERE idFormaPago = '"+idFormaPago+"'");
	    try {
	      while(datos.next()){//es el metodo que permite ir recorriendo los datos
	    	  id = datos.getString("idFormaPago"); //podemos poner el nombre o un numero
	    	  descripcion = datos.getString("descripcion");
	    	  resultado = resultado +"\n"+ id + "\t" + descripcion; 
	    	  VentanaFormaPago.modificar.setEnabled(true);
		      VentanaFormaPago.insertar.setEnabled(true);
		      VentanaFormaPago.borrar.setEnabled(true);
		      panel.getModelo().addRow( new Object[] {id, descripcion} );
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();}
	    
}
 /**
  * metodo para modificar una forma de pago
  * @param idFormaPago
  * @param descripcion
  * @return si se ha hecho o no la modificacion
  */
 public static String modificar(String idFormaPago, String descripcion ){
		
		 boolean ok = false;
		 String resultado = null;
		 
		 try{
			 ok = VentanaPrincipal.conexion.setQuery("UPDATE formapago set idFormaPago = '"+idFormaPago+"',descripcion = '"+descripcion+"' where idFormaPago = '"+idFormaPago+"'");
			 if (ok) 
				 resultado = "Se modificó la forma de pago correctamente";
			 else 
				 resultado = "No se pudo modificar la forma de pago";	 
		 }
		 catch(Exception e){ e.printStackTrace(); }
		 return resultado;
	}
 /**
  * metodo para insertar una nueva forma de pago
  * @param idFormaPago
  * @param descripcion
  * @return si se ha podido insertar o no
  */
 public static String insertar(String idFormaPago, String descripcion ){
		
	 boolean ok = false;
	 String resultado = null;
	 
	 try{
		 ok = VentanaPrincipal.conexion.setQuery("INSERT formapago VALUES ('"+idFormaPago+"','"+descripcion+"')");
		 if (ok) 
			 resultado = "Se inserto la forma de pago correctamente";
		 else 
			 resultado = "No se pudo insertar la forma de pago";	 
	 }
	 catch(Exception e){ e.printStackTrace(); }
	 return resultado;
} 
 /**
  * metodo para borrar una forma de pago
  * @param idFormaPago
  * @return si se ha podido borrar o no
  */
 public static String borrar(String idFormaPago){
		
	 boolean ok = false;
	 String resultado = null;
	 
	 try{
		 ok = VentanaPrincipal.conexion.setQuery("DELETE from formapago WHERE idFormaPago = '"+idFormaPago+"'");
		 if (ok) 
			 resultado = "Se borro la forma de pago correctamente";
		 else 
			 resultado = "No se pudo borrar la forma de pago";	 
	 }
	 catch(Exception e){ e.printStackTrace(); }
	 return resultado;
} 
 

} 

                

