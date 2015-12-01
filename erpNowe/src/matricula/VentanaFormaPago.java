package matricula;

/**
 * @author Vanessa y Victor
 */

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ventanaPrincipal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaFormaPago extends JFrame {
	
	
	
		public static JButton  modificar = null;
		public static JButton insertar = null;
		public static JButton borrar = null;

		public VentanaFormaPago() {
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
			    setIconImage(icon);
			    setSize(780,455); 
			    setTitle("Gesti�n Formas de Pago Nowe");
			    setLocationRelativeTo(null);
		        Panel p = new Panel(); 
				add(p); 
			    }

		 class Panel extends JPanel implements ActionListener{

			 JButton listar, consultar,limpiar,cerrar;
			 JTextArea textareaconsulta; 
			 JLabel label1,label2;
			 JScrollPane scrollArea;
			 JTextField textfield1, textfield2;
			 
			 public Panel() {
		    	 setLayout(null);
		    	 setSize(780,455);
		    	 setBackground(new Color(192,192,192));
		    	 scrollArea = new JScrollPane();
		    	
		    	 listar=new JButton("Listado");
		    	 listar.setBounds(10,10,120,50); 
		         add(listar);
		         listar.addActionListener(this);
		         
		         consultar=new JButton("Consultar");
		         consultar.setBounds(10,70,120,50);
		         add(consultar);
		         consultar.addActionListener(this);
		         
		         modificar=new JButton("Modificar");
		         modificar.setBounds(10,130,120,50);
		         add(modificar);
		         modificar.setEnabled(false);
		         modificar.addActionListener(this);
		         
		         insertar=new JButton("Insertar");
		         insertar.setBounds(10,190,120,50);
		         add(insertar);
		         insertar.setEnabled(false);
		         insertar.addActionListener(this);
		         
		         borrar=new JButton("Borrar");
		         borrar.setBounds(10,250,120,50);
		         add(borrar);
		         borrar.setEnabled(false);
		         borrar.addActionListener(this);
		         
		         limpiar=new JButton("Limpiar");
		         limpiar.setBounds(140,380,100,25);
		         add(limpiar);
		         limpiar.addActionListener(this); 
		         
		         cerrar=new JButton("Cerrar");
		         cerrar.setBounds(460,380,100,25);
		         add(cerrar);
		         cerrar.addActionListener(this);
		         
		         textareaconsulta = new JTextArea();
		         textareaconsulta.setBackground(new Color(224,224,224));
		         
		         scrollArea.setViewportView(textareaconsulta);
		         scrollArea.setBounds(140,10,430,350); //posiciona dentro de la ventana
		         add(scrollArea);
			 
		         label1=new JLabel("idFormaPago");
		         label1.setBounds(580,30,100,20);
		         add(label1);
		         
		         textfield1 = new JTextField();
		         textfield1.setBounds(580,10,170,20);
		         add(textfield1);
		         textfield1.setBackground( new Color(224,224,224) );
		         
		         
		         label2=new JLabel("Descripci�n");
		         label2.setBounds(580,90,100,20);
		         add(label2);
		         
		         textfield2 = new JTextField();
		         textfield2.setBounds(580,70,170,20);
		         add(textfield2);
		         textfield2.setBackground( new Color(224,224,224) ); 
			 }
		          
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado == listar) {
		            	 textareaconsulta.setText(FormaPago.listado());}
		             
		             if (botonPulsado == consultar) {
		            	 textareaconsulta.setText(FormaPago.consultar(textfield1.getText()));}
		             
		             if (botonPulsado == modificar) {
		            	 textareaconsulta.setText(FormaPago.modificar(textfield1.getText(),textfield2.getText()));}
		             
		             if (botonPulsado == insertar) {
		            	 textareaconsulta.setText(FormaPago.insertar(textfield1.getText(),textfield2.getText()));}
		             
		             if (botonPulsado == borrar) {
		            	 textareaconsulta.setText(FormaPago.borrar(textfield1.getText()));}
		            	 
		             if (botonPulsado==limpiar) {
		            	 textareaconsulta.setText("");}
		             
		             if (botonPulsado==cerrar) {
		            	 VentanaPrincipal.conexion.cerrarConexion();
		            	 textareaconsulta.setText("conexion cerrada");}
		            	 
		           }
		         }
}
