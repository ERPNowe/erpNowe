package Matricula;



/**
 * 
 * @author Vanessa
 * <p> clase temporal, se usa para 
 * realizar pruebas en la clase Matricula <p>
 *
 */

public class principal {

	 public static  basedatos.ConexionBaseDatos conexion = null;
	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	
	
	 public static void main(String[] args) {
		 // En caso de no tener contraseña pwd = ""
	   conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
	   ventana ventana=new ventana();
	   ventana.setVisible(true);
	   
	}

}
