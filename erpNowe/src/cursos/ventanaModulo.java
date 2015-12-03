package cursos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ventanaPrincipal.VentanaPrincipal;

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
	public static JButton modificar;
	public static JButton borrar;
	public static JComboBox combo1;
	
	public ventanaModulo() {
	    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    setIconImage(icon);
		    setSize(930,400); 
		    setTitle("Gestión Modulos Nowe");
		    setLocationRelativeTo(null);
	        Panel p = new Panel(); 
			add(p); 
		    }

	 class Panel extends JPanel implements ActionListener{

		 JButton consultar,listado, insertar, limpiar,cerrar;
		 JTextArea textareaconsulta; 
		 JTextField textfield1, textfield2, textfield3;
		 JLabel label1, label2, label3, label4;
		 JScrollPane scrollArea;
		 private JTable tblmodulos = null;
		 DefaultTableModel modelo = null;
		 
		 /**
		  * Constructor del panel
		  */
		 public Panel() {
	    	 setLayout(null);
	    	 setSize(930,400);
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
	         modificar.setEnabled(false);
	         modificar.addActionListener(this);
	         
	         borrar =new JButton("Eliminar");
	         borrar.setBounds(10,250,100,50);
	         add(borrar);
	         borrar.setEnabled(false);
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
	         label4 = new JLabel("Detalles");
	         label4.setBounds(400,300,100,20);
	         add(label4);
	         
	         textareaconsulta = new JTextArea();
	         textareaconsulta.setBounds(120,325,630,20);
	         add(textareaconsulta);
	         textareaconsulta.setBackground(new Color(224,224,224));
		 
	         /**
	          * Creacion de los TextFields y Labels
	          */
	         label1 = new JLabel("idModulo");
	         label1.setBounds(780,30,100,20);
	         add(label1);
	         
	         combo1 = new JComboBox();
	         combo1.setBounds(780,10,100,20);
	         Modulos.menu();
	         add(combo1);
	         
	         label2 = new JLabel("Nombre");
	         label2.setBounds(780,90,100,20);
	         add(label2);
	         
	         textfield2 = new JTextField();
	         textfield2.setBounds(780,70,100,20);
	         add(textfield2);
	         textfield2.setBackground( new Color(224,224,224) );
	         
	         label3 = new JLabel("idModulo insertar");
	         label3.setBounds(780,150,130,20);
	         add(label3);
	         
	         textfield3 = new JTextField();
	         textfield3.setBounds(780,130,100,20);
	         add(textfield3);
	         textfield3.setBackground( new Color(224,224,224) );
	         
	         
	         String[] columnas = {"idModulo", "Nombre"};
	         tblmodulos = new JTable();
	         modelo = new DefaultTableModel();
	         tblmodulos.setBackground(new Color(224,224,224));
	         scrollArea.setViewportView(tblmodulos);
	         scrollArea.setBounds(120, 10, 630, 230); //posiciona dentro de la ventana
	         modelo.setColumnIdentifiers(columnas);
	         scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	         tblmodulos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	         tblmodulos.setFillsViewportHeight(true);        
	         
	         tblmodulos.setModel(modelo);
	         tblmodulos.getColumnModel().getColumn(0).setPreferredWidth(60);
	         tblmodulos.getColumnModel().getColumn(1).setPreferredWidth(570);
	         add(scrollArea, BorderLayout.NORTH);
	        
	         
	         /**
	          * Creacion del panel scroll
	          */
	         
			 /*scrollArea.setViewportView(textareaconsulta);
			 scrollArea.setBounds(120, 10, 630, 230); 
			 add(scrollArea);*/
		 }
		 /**
		  * Acciones de los botones al ser pulsados
		  */
		 public void actionPerformed(ActionEvent e) {
	         	Object botonPulsado = e.getSource();
	         	
	             if (botonPulsado == consultar) {
	            	 clearModulo();
	            	 Modulos.consultar((String)combo1.getSelectedItem(),this);
	            	 //textareaconsulta.setText(Modulos.consultar((String)combo1.getSelectedItem()));
	            	 }
	             
	             if (botonPulsado == listado) {
	            	 clearModulo();
	            	 Modulos.listar(this);
	            	 //textareaconsulta.setText(Modulos.listar());
	            	 }
	             
	             if (botonPulsado == insertar) {
	            	 textareaconsulta.setText(Modulos.insertar(textfield3.getText(), textfield2.getText()));}
	             	
	             if (botonPulsado == modificar) {
	            	 textareaconsulta.setText(Modulos.modificar(textfield1.getText(), textfield2.getText()));}
	            	 
	             if (botonPulsado == borrar) {
	            	 textareaconsulta.setText(Modulos.eliminar((String)combo1.getSelectedItem()));}
	             
	             if (botonPulsado == limpiar) {
	            	 textfield1.setText("");
	            	 textfield2.setText("");
	            	 textareaconsulta.setText("");}
	             
	             if (botonPulsado == cerrar) {
	            	 VentanaPrincipal.conexion.cerrarConexion();
	            	 textareaconsulta.setText("conexion cerrada");}
	             }
	           
	             private void clearModulo(){
				       for (int i = 0; i < tblmodulos.getRowCount(); i++) {
				           modelo.removeRow(i);
				           i-=1;
				       }
				   }
				 public DefaultTableModel getModelo() {
					 return modelo;
				 }
				 public void setModelo(DefaultTableModel modelo) {
					 this.modelo = modelo;
				 }
		
	         }
}
