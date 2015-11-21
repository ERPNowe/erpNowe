package Matricula;

/**
 * 
 * @author Vanessa
 * <p> clase ventana, aun se esta modificando <p>
 *
 */

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

@SuppressWarnings("serial")
public class ventana extends JFrame {
	
	//creo el constructor del panel donde pongo todas sus propiedades//
	
		 public ventana() {
		    	//para ponerle el icono a la app
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
			    setIconImage(icon);
			    setSize(710,340); // Ancho*Alto
			    setTitle("Gestión Alumnos Nowe");
			    setLocationRelativeTo(null);
		        Panel p = new Panel(); //crear la clase panel como en marcoprincipal
				add(p); 
			    }

		 class Panel extends JPanel implements ActionListener{

			 JButton consultar, Consultaid,ConsultaGR,Presupuesto, limpiar,cerrar;
			 JTextArea textareaconsulta; 
			 JTextField textfield1, textfield2,textfield3;
			 JLabel label1,label2,label3;
			 JScrollPane scrollArea;
			 
			 public Panel() {
		    	 setLayout(null);
		    	 setSize(710,340);
		    	 setBackground(new Color(192,192,192));
		    	 scrollArea = new JScrollPane();
		    	
		    	 //creo los botones
		    	 consultar=new JButton("Listado");
		    	 consultar.setBounds(10,10,120,50); //Padding_Left, Padding_Top, Ancho, Alto
		         add(consultar);
		         consultar.addActionListener(this);
		         
		         Consultaid=new JButton("Consulta alumno");
		         Consultaid.setBounds(10,70,120,50);
		         add(Consultaid);
		         Consultaid.addActionListener(this);
		         
		         ConsultaGR=new JButton("Consulta GRUPO");
		         ConsultaGR.setBounds(10,130,120,50);
		         add(ConsultaGR);
		         ConsultaGR.addActionListener(this);
		         
		      /*   Presupuesto=new JButton("Presupuesto");
		         Presupuesto.setBounds(10,190,120,50);
		         add(Presupuesto);
		         Presupuesto.addActionListener(this);*/
		         
		         limpiar=new JButton("Limpiar");
		         limpiar.setBounds(140,250,100,25);
		         add(limpiar);
		         limpiar.addActionListener(this); 
		         
		         cerrar=new JButton("Cerrar");
		         cerrar.setBounds(470,250,100,25);
		         add(cerrar);
		         cerrar.addActionListener(this);
		         
		         
			 //pongo el textarea
		         textareaconsulta = new JTextArea();
		         //textareaconsulta.setBounds(140,10,430,230);
		         //add(textareaconsulta);
		         textareaconsulta.setBackground(new Color(224,224,224));
		         
		         scrollArea.setViewportView(textareaconsulta);
		         scrollArea.setBounds(140,10,430,230); //posiciona dentro de la ventana
		         add(scrollArea);
			 
			 
			 //pongo los texfileds y jlabel
 
		         
		         label1=new JLabel("idAlumno");
		         label1.setBounds(580,30,100,20);
		         add(label1);
		         
		         textfield1=new JTextField();
		         textfield1.setBounds(580,10,100,20);
		         add(textfield1);
		         textfield1.setBackground( new Color(224,224,224) );
		         
		         label1=new JLabel("idGrupo");
		         label1.setBounds(580,90,100,20);
		         add(label1);
		         
		         textfield2=new JTextField();
		         textfield2.setBounds(580,70,100,20);
		         add(textfield2);
		         textfield2.setBackground( new Color(224,224,224) );
		         
		      /*   label1=new JLabel("formaPago");
		         label1.setBounds(580,150,100,20);
		         add(label1);
		         
		         textfield3=new JTextField();
		         textfield3.setBounds(580,130,100,20);
		         add(textfield3);
		         textfield3.setBackground( new Color(224,224,224) );
		         
		         label1=new JLabel("promociones");
		         label1.setBounds(580,210,100,20);
		         add(label1);
		         
		         textfield3=new JTextField();
		         textfield3.setBounds(580,190,100,20);
		         add(textfield3);
		         textfield3.setBackground( new Color(224,224,224) );
		         
		         label1=new JLabel("pagado");
		         label1.setBounds(580,270,100,20);
		         add(label1);
		         
		         textfield3=new JTextField();
		         textfield3.setBounds(580,250,100,20);
		         add(textfield3);
		         textfield3.setBackground( new Color(224,224,224));*/
			 
			 }
		          //creo las acciones
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado==consultar) {
		            	 textareaconsulta.setText(Matricula.Consultar());}
		             
		             if (botonPulsado==Consultaid) {
		            	 textareaconsulta.setText(Matricula.Consultarid(textfield1.getText()));}
		             
		             if (botonPulsado==Presupuesto) {
			             textareaconsulta.setText(Matricula.crearPresupuesto());}
		            	 
		             if (botonPulsado==ConsultaGR) {
		            	 textareaconsulta.setText(Matricula.ConsultarGR(textfield2.getText()));}
		             
		             if (botonPulsado==limpiar) {
		            	 textfield1.setText("");
		            	 textfield2.setText("");
		            	 textfield3.setText("");
		            	 textareaconsulta.setText("");}
		             
		             if (botonPulsado==cerrar) {
		            	 principal.conexion.cerrarConexion();
		            	 textareaconsulta.setText("conexion cerrada");}
		            	 
		           }
		         }
}
