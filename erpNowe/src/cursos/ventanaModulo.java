package cursos;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** 
 * @author Victor Jimenez
 * @since 19/11/2015
 * @version 1.0
 */

@SuppressWarnings("serial")
public class ventanaModulo extends JFrame {
	/**
	 * Consructor de la ventana
	 */
	 public ventanaModulo() {
	    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    setIconImage(icon);
		    setSize(900,400); 
		    setTitle("Gesti�n Alumnos Nowe");
		    setLocationRelativeTo(null);
	        Panel p = new Panel(); 
			add(p); 
		    }

	 class Panel extends JPanel implements ActionListener{

		 JButton consultar,listado, insertar, modificar,borrar, limpiar,cerrar;
		 JTextArea textareaconsulta; 
		 JTextField textfield1, textfield2;
		 JLabel label1,label2;
		 JScrollPane scrollArea;
			
		 
		 /**
		  * Constructor del panel
		  */
		 public Panel() {
	    	 setLayout(null);
	    	 setSize(900,400);
	    	 setBackground(new Color(192,192,192));
	    	 scrollArea = new JScrollPane();
	    	 /**
	    	  * Creacion de los botones
	    	  */
	    	 consultar = new JButton("Consultar");
	    	 consultar.setBounds(10,10,100,50);
	         add(consultar);
	         consultar.addActionListener(this);
	         
	         listado = new JButton("Listado");
	         listado.setBounds(10,70,100,50);
	         add(listado);
	         listado.addActionListener(this);
	         
	         insertar = new JButton("Insertar");
	         insertar.setBounds(10,130,100,50);
	         add(insertar);
	         insertar.addActionListener(this);
	         
	         modificar = new JButton("Modificar");
	         modificar.setBounds(10,190,100,50);
	         add(modificar);
	         modificar.addActionListener(this);
	         
	         borrar =new JButton("Eliminar");
	         borrar.setBounds(10,250,100,50);
	         add(borrar);
	         borrar.addActionListener(this); 
	         
	         limpiar = new JButton("Limpiar");
	         limpiar.setBounds(120,250,100,25);
	         add(limpiar);
	         limpiar.addActionListener(this); 
	         
	         cerrar = new JButton("Cerrar");
	         cerrar.setBounds(270,250,100,25);
	         add(cerrar);
	         cerrar.addActionListener(this);
	         
	         
	         /**
	          * Creacion del TextArea
	          */
	         textareaconsulta = new JTextArea();
	         //textareaconsulta.setBounds(120,10,630,230);
	         //add(textareaconsulta);
	         textareaconsulta.setBackground(new Color(224,224,224));
		 
		 
	         /**
	          * Creacion de los TextFields y Labels
	          */
	         label1 = new JLabel("idModulo");
	         label1.setBounds(800,30,100,20);
	         add(label1);
	         
	         textfield1 = new JTextField();
	         textfield1.setBounds(780,10,100,20);
	         add(textfield1);
	         textfield1.setBackground( new Color(224,224,224) );
	         
	         label2 = new JLabel("Nombre");
	         label2.setBounds(800,90,100,20);
	         add(label2);
	         
	         textfield2 = new JTextField();
	         textfield2.setBounds(780,70,100,20);
	         add(textfield2);
	         textfield2.setBackground( new Color(224,224,224) );
	         /**
	          * Creacion del panel scroll
	          */
	         
			 scrollArea.setViewportView(textareaconsulta);
			 scrollArea.setBounds(120, 10, 630, 230); 
			 add(scrollArea);
		 }
		 /**
		  * Acciones de los botones al ser pulsados
		  */
		 public void actionPerformed(ActionEvent e) {
	         	Object botonPulsado = e.getSource();
	         	
	             if (botonPulsado == consultar) {
	            	 textareaconsulta.setText(Modulos.consultar(textfield1.getText()));}
	             
	             if (botonPulsado == listado) {
	            	 textareaconsulta.setText(Modulos.listar());}
	             
	             if (botonPulsado == insertar) {
	            	 textareaconsulta.setText(Modulos.insertar(textfield1.getText(), textfield2.getText()));}
	             
	             if (botonPulsado == modificar) {
	            	 textareaconsulta.setText(Modulos.modificar(textfield1.getText(), textfield2.getText()));}
	            	 
	             if (botonPulsado == borrar) {
	            	 textareaconsulta.setText(Modulos.eliminar(textfield1.getText()));}
	             
	             if (botonPulsado == limpiar) {
	            	 textfield1.setText("");
	            	 textfield2.setText("");
	            	 textareaconsulta.setText("");}
	             
	             if (botonPulsado == cerrar) {
	            	 Modulos.conexion.cerrarConexion();
	            	 textareaconsulta.setText("conexion cerrada");}
	           }
	         }
}