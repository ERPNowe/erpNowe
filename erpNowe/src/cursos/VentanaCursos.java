package cursos;


import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VentanaCursos extends JFrame {
	
	//creo el constructor del panel donde pongo todas sus propiedades//
	
		 public VentanaCursos() {
		    	//para ponerle el icono a la app
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    	setIconImage(icon);
			    setSize(900,370); // Ancho*Alto
			    setTitle("Gestión Cursos Nowe");
			    setLocationRelativeTo(null);
		        Panel p = new Panel(); //crear la clase panel como en marcoprincipal
				add(p); 
			    }

		 class Panel extends JPanel implements ActionListener{

			 JButton consultar, insertar, modificar,borrar, limpiar,cerrar,consultar1;
			 JTextArea textareaconsulta; 
			 JTextField textfield1, textfield2,textfield3,textfield4,textfield5,textfield6,textfield7,textfield8;
			 JLabel label1,label2,label3,label4,label5,label6,label7,label8;
			 JScrollPane scrollArea;
			 
			 public Panel() {
		    	 setLayout(null);
		    	 setSize(710,320);
		    	 setBackground(new Color(192,192,192));
		    	 scrollArea = new JScrollPane();
		    	 
		    	 //creo los botones
		    	 consultar=new JButton("Listado");
		    	 consultar.setBounds(10,10,100,50); //Padding_Left, Padding_Top, Ancho, Alto
		         add(consultar);
		         consultar.addActionListener(this);
		         
		         consultar1=new JButton("Consultar id");
		    	 consultar1.setBounds(10,250,120,50); //Padding_Left, Padding_Top, Ancho, Alto
		         add(consultar1);
		         consultar1.addActionListener(this);
		         
		         
		         insertar=new JButton("Insertar");
		         insertar.setBounds(10,70,100,50);
		         add(insertar);
		         insertar.addActionListener(this);
		         
		         modificar=new JButton("Modificar");
		         modificar.setBounds(10,130,100,50);
		         add(modificar);
		         modificar.addActionListener(this);
		         
		         borrar=new JButton("Eliminar");
		         borrar.setBounds(10,190,100,50);
		         add(borrar);
		         borrar.addActionListener(this); 
		         
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
		         //textareaconsulta.setBounds(120,10,450,230);
		         //add(textareaconsulta);
		         textareaconsulta.setBackground(new Color(224,224,224));
		         
		         scrollArea.setViewportView(textareaconsulta);
		         scrollArea.setBounds(120,10,450,230); //posiciona dentro de la ventana
		         add(scrollArea);
			 
			 //pongo los texfileds y jlabel
 
		         
		         label1=new JLabel("idCurso");
		         label1.setBounds(635,30,100,20);
		         add(label1);
		         
		         textfield1=new JTextField();
		         textfield1.setBounds(580,10,100,20);
		         add(textfield1);
		         textfield1.setBackground( new Color(224,224,224) );
		         
		         label2=new JLabel("CódigoCurso");
		         label2.setBounds(605,90,100,20);
		         add(label2);
		         
		         textfield2=new JTextField();
		         textfield2.setBounds(580,70,100,20);
		         add(textfield2);
		         textfield2.setBackground( new Color(224,224,224) );
		         
		         label3=new JLabel("Nombre");
		         label3.setBounds(635,150,100,20);
		         add(label3);
		         
		         textfield3=new JTextField();
		         textfield3.setBounds(580,130,100,20);
		         add(textfield3);
		         textfield3.setBackground( new Color(224,224,224) );
		         
		         label4=new JLabel("Categoria");
		         label4.setBounds(625,210,100,20);
		         add(label4);
		         
		         textfield4=new JTextField();
		         textfield4.setBounds(580,190,100,20);
		         add(textfield4);
		         textfield4.setBackground( new Color(224,224,224) );
		         
		         label5=new JLabel("Descripcion");
		         label5.setBounds(770,30,100,20);
		         add(label5);
		         
		         textfield5=new JTextField();
		         textfield5.setBounds(740,10,100,20);
		         add(textfield5);
		         textfield5.setBackground( new Color(224,224,224) );
		         
		         label6=new JLabel("Precio");
		         label6.setBounds(800,90,100,20);
		         add(label6);
		         
		         textfield6=new JTextField();
		         textfield6.setBounds(740,70,100,20);
		         add(textfield6);
		         textfield6.setBackground( new Color(224,224,224) );
		         
		         label7=new JLabel("Duración");
		         label7.setBounds(785,150,100,20);
		         add(label7);
		         
		         textfield7=new JTextField();
		         textfield7.setBounds(740,130,100,20);
		         add(textfield7);
		         textfield7.setBackground( new Color(224,224,224) );
		         
		         label8=new JLabel("Privado");
		         label8.setBounds(795,210,100,20);
		         add(label8);
		         
		         textfield8=new JTextField();
		         textfield8.setBounds(740,190,100,20);
		         add(textfield8);
		         textfield8.setBackground( new Color(224,224,224) );
		         
		         
			 
			 }
		          //creo las acciones
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado==consultar) {
		            	 textareaconsulta.setText(Cursos.Consultar());}
		             
		             
		             if (botonPulsado==consultar1){
		            	 String idcurso1 = textfield1.getText();
		            	 int intidcurso = Integer.parseInt(idcurso1);
		            	 
		            	 textareaconsulta.setText(Cursos.Consultarip(intidcurso));
		             }
		             //----------------------------------
		             if (botonPulsado==insertar) {
		            	 
		            	
		            	 String CodigoCurso1 = textfield2.getText();
		            	 String Nombre1 = textfield3.getText();
		            	 String Categoria1 = textfield4.getText();
		            	 String Descripcion1 = textfield5.getText();
		            	 String Precio1 = textfield6.getText();
		            	 float flprecio = Float.parseFloat(Precio1);
		            	 String Duracion1 = textfield7.getText();
		            	 int intduracion = Integer.parseInt(Duracion1);
		            	 String Privado1 = textfield8.getText();
		            	 int intprivado = Integer.parseInt(Privado1);
		            	 
		            	 textareaconsulta.setText(Cursos.Insertar(CodigoCurso1,Nombre1,Categoria1,Descripcion1,flprecio,intduracion,intprivado));}
		            	 
		             
		            
		             
		    		 
		             //------------------------------------------------------------------
		             if (botonPulsado==modificar) {
		            	 String idcurso1 = textfield1.getText();
		            	 int intidcurso = Integer.parseInt(idcurso1);
		            	 String CodigoCurso2 = textfield2.getText();
		            	 String Nombre2 = textfield3.getText();
		            	 String Categoria2 = textfield4.getText();
		            	 String Descripcion2 = textfield5.getText();
		            	 String Precio2 = textfield6.getText();
		            	 float flprecio1 = Float.parseFloat(Precio2);
		            	 String Duracion2 = textfield7.getText();
		            	 int intduracion1 = Integer.parseInt(Duracion2);
		            	 String Privado2 = textfield8.getText();
		            	 int intprivado1 = Integer.parseInt(Privado2); 
		            	 
		            	
		            	 textareaconsulta.setText(Cursos.Modificar(intidcurso,CodigoCurso2,Nombre2,Categoria2,Descripcion2,flprecio1,intduracion1,intprivado1));
		      
		             
		             }
		 
		             
		             
		             
		             //----------------------------------------------------------------------------------------------------------
		             if (botonPulsado==borrar) {
		            	 
		        			 String idCurso2 = textfield1.getText();
		        			 int intidCurso1 = Integer.parseInt(idCurso2);			 
		        			 textareaconsulta.setText(Cursos.Eliminar( intidCurso1));
		             }
		        			 
		        	//--------------------------------------------------------------------
		             if (botonPulsado==limpiar) {
		            	 textfield1.setText("");
		            	 textfield2.setText("");
		            	 textfield3.setText("");
		            	 textfield4.setText("");
		            	 textfield5.setText("");
		            	 textfield6.setText("");
		            	 textfield7.setText("");
		            	 textfield8.setText("");
		            	
		            	 textareaconsulta.setText("");}
		             
		             if (botonPulsado==cerrar) {
		            	 Cursos.conexion.cerrarConexion();
		            	 textareaconsulta.setText("conexion cerrada");}
		            	 
		           }
			 }}

		

