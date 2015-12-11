/**
 * Clase ventanaPrincipal
 * @author curso14/7803
 * @version 1.0
 * @since 19/11/2015
 * <br>
 * <p> 
 * Esta clase corresponde a la pantalla principal del programa y sus menús
 * </p> 
 */

package ventanaPrincipal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;
import alumnos.VentanaCalificaciones;
import alumnos.VentanaInteresado;
import cursos.VentanaCursos;
import cursos.VentanaGrupos;
import cursos.ventanaModulo;
import gestion.VentanaGestion;
import matricula.VentanaFormaPago;
import matricula.VentanaMatricula;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private JMenuBar barraMenu;
	private JMenu menuAlumnos, menuCursos, menuCalificacion, menuMatricula, menuGestion, menuAyuda, menuSalir;
	private JMenuItem matriculado, interesado, 
					  cursos, grupos, modulos, 
					  calificacion, 
					  matricula, formaPago,
					  consulta, modificacion,
					  ayuda, salir;
	
	public static String usuario = "root";
	public static String pwd = "root";
	public static String bd = "nowedb";
	public static basedatos.ConexionBaseDatos conexion = null;
	
		 
	public VentanaPrincipal () {		
				
		setLayout(null);
		Fondo fondo;
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(null);
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		setIconImage(icon);
        this.setTitle("Programa de Gestión Nowe");
        setSize(tamañoPantalla.width, tamañoPantalla.height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        fondo = new Fondo();
        add(fondo);
        
	
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		// Menú Alumnos
		menuAlumnos = new JMenu ("Alumnos");
		barraMenu.add(menuAlumnos);		
			    
		matriculado = new JMenuItem("Matriculado");
		matriculado.addActionListener(this);
		menuAlumnos.add(matriculado);
		
		interesado = new JMenuItem("Interesado");
		interesado.addActionListener(this);
		menuAlumnos.add(interesado);
		
		// Menú Cursos
		menuCursos = new JMenu ("Cursos");
		barraMenu.add(menuCursos);		
			    
		cursos = new JMenuItem("Cursos");
		cursos.addActionListener(this);
		menuCursos.add(cursos);
		
		grupos = new JMenuItem("Grupos");
		grupos.addActionListener(this);
		menuCursos.add(grupos);
		
		modulos = new JMenuItem("Módulos");
		modulos.addActionListener(this);
		menuCursos.add(modulos);		
		
		// Menú Calificación
		menuCalificacion = new JMenu ("Calificación");
		barraMenu.add(menuCalificacion);
		
		calificacion = new JMenuItem("Calificación");
		calificacion.addActionListener(this);
		menuCalificacion.add(calificacion);	
		
		// Menú Matricula
		menuMatricula = new JMenu ("Matrícula");
		barraMenu.add(menuMatricula);
		
		matricula = new JMenuItem("Matrícula");
		matricula.addActionListener(this);
		menuMatricula.add(matricula);	
		
		formaPago = new JMenuItem("Forma de Pago");
		formaPago.addActionListener(this);
		menuMatricula.add(formaPago);
		
		// Menú Gestión
		menuGestion = new JMenu ("Gestión");
		barraMenu.add(menuGestion);
		
		consulta = new JMenuItem("Consulta");
		consulta.addActionListener(this);
		menuGestion.add(consulta);	
		
		modificacion = new JMenuItem("Modificación");
		modificacion.addActionListener(this);
		menuGestion.add(modificacion);	
		
		// Menú Ayuda
		menuAyuda = new JMenu ("Ayuda");
		barraMenu.add(menuAyuda);
		
		ayuda = new JMenuItem("?");
		ayuda.addActionListener(this);
		menuAyuda.add(ayuda);
		
		// Menú Salir
		menuSalir = new JMenu ("Salir");
		barraMenu.add(menuSalir);
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		menuSalir.add(salir);}
	
	/**
	 * Acciones definidas para los distintos items de los menús
	 */
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== cursos) {
     
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
   		    VentanaCursos ventana=new VentanaCursos();
   		    ventana.setVisible(true);
   		   }
		if (e.getSource()== modulos){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			 ventanaModulo ventana = new ventanaModulo();
			 ventana.setVisible(true);   	
		}
		if (e.getSource()== interesado){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaInteresado ne = new VentanaInteresado();
			ne.setVisible(true);
		}
		if (e.getSource()== grupos){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaGrupos ne = new VentanaGrupos();
			ne.setVisible(true);
		}
		if (e.getSource()== matricula){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaMatricula ventana = new VentanaMatricula();
			ventana.setVisible(true);
		}
		if (e.getSource()== calificacion){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaCalificaciones ventana = new VentanaCalificaciones();
			ventana.setVisible(true);
		}
		if (e.getSource()== formaPago){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaFormaPago ventana = new VentanaFormaPago();
			ventana.setVisible(true);
		}
		if (e.getSource()== consulta){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaGestion ventana = new VentanaGestion('C');
			ventana.setVisible(true);
		}		
		if (e.getSource()== ayuda){	
			String cadena;
            File fichero = new File("file:///../doc/index.html");
            cadena = fichero.getAbsolutePath();            
            try{            	
				Runtime rt = Runtime.getRuntime();
				String[] callAndArgs = {"C:/WINDOWS/hh.exe",cadena};
				Process child = rt.exec(callAndArgs);				
			}catch(Exception eee){				
				System.out.println("UPS! Ha ocurrido un error");
			}			
		}		
		if (e.getSource()== salir){
			System.exit(0);			
		}
	}
}

