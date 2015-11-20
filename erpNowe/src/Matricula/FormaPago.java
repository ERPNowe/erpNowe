/**
 * Clase FormaPago
 * @author curso14/7803
 * @version 1.0
 * @since 20/11/2015
 * <br>
 * <p> 
 * Esta clase corresponde a la gestion de forma de pagos
 * </p> 
 */

package Matricula;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class FormaPago {

	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	 static ConexionBaseDatos conexion = null;
	 static Scanner scanner = new Scanner(System.in);
	 
 public static void main(String[] args) {
	 // En caso de no tener contraseña pwd = ""
    conexion = new ConexionBaseDatos(bd, usuario, pwd);
    System.out.println(consultaFormaPago());
    
 }
 
 //-----------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------
 
 public static String consultaFormaPago(){
	 	ResultSet datos;
	    String campo1, campo2, resultado ="";
	    datos = conexion.getQuery("SELECT * FROM formapago;");
	    try {
	      while(datos.next()){//es el metodo que permite ir recorriendo los datos
	    	  campo1 = datos.getString("idFormaPago"); //podemos poner el nombre o un numero
	    	  campo2 = datos.getString("descripcion");
	    	  resultado = resultado +"\n"+ campo1 + "\t" + campo2; 
	      }
	    }
	    catch (SQLException e) { e.printStackTrace();
	   }
	    return resultado; 
 }
 
 //-----------------------------------------------------------------------------------

                
}
