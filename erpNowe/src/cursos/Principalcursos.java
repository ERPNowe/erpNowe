package cursos;

import java.util.Scanner;

public class Principalcursos {
	 private static String usuario = "root";
	 private static String pwd = "root";
	 private static String bd = "nowedb";
	 static basedatos.ConexionBaseDatos conexion = null;
	 static Scanner scanner = new Scanner(System.in);
	 
 public static void main(String[] args) {
	 // En caso de no tener contraseña pwd = ""
    conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
    VentanaCursos ventana=new VentanaCursos();
    ventana.setVisible(true);
}}
