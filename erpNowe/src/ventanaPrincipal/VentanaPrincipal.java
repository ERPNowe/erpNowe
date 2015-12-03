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
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import alumnos.VentanaCalificaciones;
//import alumnos.VentanaInteresado;
import cursos.VentanaCursos;
import cursos.VentanaGrupos;
import cursos.ventanaModulo;
import matricula.VentanaFormaPago;
import matricula.VentanaMatricula;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private JMenuBar barraMenu;
	private JMenu menuAlumnos, menuCursos, menuCalificacion, menuMatricula, menuAyuda, menuSalir;
	private JMenuItem matriculado, interesado, cursos, grupos, modulos, calificacion, matricula, formaPago, ayuda, salir;
	
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
		
		menuAlumnos = new JMenu ("Alumnos");
		barraMenu.add(menuAlumnos);		
			    
		matriculado = new JMenuItem("Matriculado");
		matriculado.addActionListener(this);
		menuAlumnos.add(matriculado);
		
		interesado = new JMenuItem("Interesado");
		interesado.addActionListener(this);
		menuAlumnos.add(interesado);
		
		
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
		
		
		
		menuCalificacion = new JMenu ("Calificación");
		barraMenu.add(menuCalificacion);
		
		calificacion = new JMenuItem("Calificación");
		calificacion.addActionListener(this);
		menuCalificacion.add(calificacion);	
		
		
		menuMatricula = new JMenu ("Matrícula");
		barraMenu.add(menuMatricula);
		
		matricula = new JMenuItem("Matrícula");
		matricula.addActionListener(this);
		menuMatricula.add(matricula);	
		
		formaPago = new JMenuItem("Forma de Pago");
		formaPago.addActionListener(this);
		menuMatricula.add(formaPago);		
		
		
		menuAyuda = new JMenu ("Ayuda");
		barraMenu.add(menuAyuda);
		
		ayuda = new JMenuItem("?");
		ayuda.addActionListener(this);
		menuAyuda.add(ayuda);
		
		menuSalir = new JMenu ("Salir");
		barraMenu.add(menuSalir);
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		menuSalir.add(salir);}
	
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
		/*if (e.getSource()== interesado){
			conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
			VentanaInteresado ne = new VentanaInteresado();
			ne.setVisible(true);
		}*/
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
		
		if (e.getSource()== salir){
			System.exit(0);			
		}
	}
}

