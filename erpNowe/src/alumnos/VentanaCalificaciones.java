
/**
 * 
 * @author Adolfo
 * @version 1.0
 * @since 26/11/2015
 * <br>
 * <p>
 * Esta clase se corresponde con la ventana de la clase
 * Calificaciones
 * </p>
 *
 */


package alumnos;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cursos.Cursos;

import ventanaPrincipal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaCalificaciones extends JFrame{

	
	public VentanaCalificaciones(){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logoApp.gif"));
	    setIconImage(icon);
	    setSize(745,440); // Ancho*Alto
	    setTitle("Gesti�n Calificaciones");
	    setLocationRelativeTo(null);
	    Panel c = new Panel(); //crear la clase panel como en marcoprincipal
		add(c);
		
	} 
	    class Panel extends JPanel implements ActionListener{
	    	
			 JButton insertar,consultar,borrar,modificar,limpiar,cerrar;
			 JCheckBox recogido;
			 JTextArea textareaconsulta,textareaObservaciones; 
			 JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6;
			 JLabel label1,label2,label3, label4, label5;
			 JScrollPane scrollArea1,scrollArea2;
			 
			 public Panel(){
				 setLayout(null);
				 setSize(555,390);
				 setBackground(new Color(192,192,192));
				 scrollArea1 = new JScrollPane();
				 scrollArea2 = new JScrollPane();
				 
				 //botones
				 
				 consultar=new JButton("Consultar");
		    	 consultar.setBounds(10,10,120,50); //Padding_Left, Padding_Top, Ancho, Alto
		         add(consultar);
		         consultar.addActionListener(this);
		         
		         insertar=new JButton("Insertar");
		         insertar.setBounds(10,10+60,120,50);
		         add(insertar);
		         insertar.addActionListener(this);
		         
		         modificar=new JButton("Modificar");
		         modificar.setBounds(10,10+120,120,50);
		         add(modificar);
		         modificar.addActionListener(this);
		         
		         borrar=new JButton("Borrar");
		         borrar.setBounds(10,10+180,120,50);
		         add(borrar);
		         borrar.addActionListener(this);
			 
		         limpiar=new JButton("Limpiar");
		         limpiar.setBounds(150,250,100,25);
		         add(limpiar);
		         limpiar.addActionListener(this); 
		         
		         cerrar=new JButton("Cerrar");
		         cerrar.setBounds(500,250,100,25);
		         add(cerrar);
		         cerrar.addActionListener(this);
		         
		         
		         //cajas de dialogo
		         
		         textfield1=new JTextField();
		         textfield1.setBounds(620,10,100,20);
		         add(textfield1);
		         textfield1.setBackground( new Color(224,224,224) );
		         
		         label1=new JLabel("idAlumno"); //Padding_Left, Padding_Top, Ancho, Alto
		         label1.setBounds(665,30,100,20);
		         add(label1);
		         
		         textfield2=new JTextField();
		         textfield2.setBounds(620,60,100,20);
		         add(textfield2);
		         textfield2.setBackground( new Color(224,224,224) );
		         
		         label2=new JLabel("idModulo"); //Padding_Left, Padding_Top, Ancho, Alto
		         label2.setBounds(665,80,100,20);
		         add(label2);
		         
		         textfield3=new JTextField();
		         textfield3.setBounds(620,110,100,20);
		         add(textfield3);
		         textfield3.setBackground( new Color(224,224,224) );
		         
		         label3=new JLabel("Nota"); //Padding_Left, Padding_Top, Ancho, Alto
		         label3.setBounds(690,130,100,20);
		         add(label3);
		            
		         //area de resultados
		         
		         textareaconsulta = new JTextArea();	 
		         textareaconsulta.setBackground(new Color(224,224,224));
		         
		         scrollArea1.setViewportView(textareaconsulta);
		         scrollArea1.setBounds(150,10,450,230); //posiciona dentro de la ventana
		         add(scrollArea1);
		         
		         //Ventana de Observaciones
		         
		         label3=new JLabel("Observaciones"); //Padding_Left, Padding_Top, Ancho, Alto
		         label3.setBounds(330,270,100,20);
		         add(label3);
		         
		         textareaObservaciones = new JTextArea();	 
		         textareaObservaciones.setBackground(new Color(224,224,224));
		         
		         scrollArea2.setViewportView(textareaObservaciones);
		         scrollArea2.setBounds(150,290,450,100); //posiciona dentro de la ventana
		         add(scrollArea2);
	
		         
		         recogido = new JCheckBox();
		         recogido.setBounds(615,175,20,20);
		         recogido.setContentAreaFilled(false);
		         add(recogido);
		         
		         label3=new JLabel("Diploma"); //Padding_Left, Padding_Top, Ancho, Alto
		         label3.setBounds(620,155,100,20);
		         add(label3);
		         label3=new JLabel("Entregado"); //Padding_Left, Padding_Top, Ancho, Alto
		         label3.setBounds(635,175,100,20);
		         add(label3);
			 } 
			 
			@Override
			 public void actionPerformed(ActionEvent e) {
	         	Object botonPulsado = e.getSource();
	         	
	             if (botonPulsado==consultar) {
	            	 textareaconsulta.setText(Calificaciones.Consultar());}
	             /*	    
	             if (botonPulsado==insertar) {
	            	 textareaconsulta.setText(Calificaciones.Insertar());}
	             
	             if (botonPulsado==modificar) {
	            	 textareaconsulta.setText(Calificaciones.Modificar());}
	             
	             if (botonPulsado==borrar) {
	            	 textareaconsulta.setText(Calificaciones.Borrar());}*/
	    	
	    }
	    
	}
	
	
		

}