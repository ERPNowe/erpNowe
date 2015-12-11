package cursos;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import alumnos.Calificaciones;
import utilidades.Fecha;
import ventanaPrincipal.VentanaPrincipal;

/**
 * @author Jesús Hernando,Alberto Jaén, Guillermo Priego
 * @since 20/11/2015
 * @version 1.0
*/
@SuppressWarnings("serial")
public class VentanaCursos extends JFrame {
	/**
	 * Consructor de la ventana
	 */
	
	public static JButton modificar;
	public static JButton borrar;
		 public VentanaCursos() {
		    
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    	setIconImage(icon);
			    setSize(900,550); 
			    setTitle("Gestión Cursos Nowe");
			    setLocationRelativeTo(null);
				addWindowListener(new FrameListener());
		        Panel p = new Panel();
				add(p); 
			    }

			/**
			 * @author Jesús Hernando,Alberto Jaén, Guillermo Priego
			 * @since 28/11/2015
			 * @version 1.0
			*/

			class FrameListener extends WindowAdapter
			{
			   public void windowClosing(WindowEvent e)
			  {
			   System.out.println("Cerrando la conexión...");
			   VentanaPrincipal.conexion.cerrarConexion();

			  }
		}
			
		 class Panel extends JPanel implements ActionListener{
			 JCheckBox privadobox;
			 JButton listar, insertar, limpiar, cerrar, consultar,editar;
			 JTextArea textareaconsulta,textarea5; 
			 JTextField textfield1, textfield2,textfield3,textfield4,textfield6,textfield7,textfield8;
			 JLabel label1,label2,label3,label4,label5,label6,label7,label8;
			 JScrollPane scrollArea;
			 private JTable tblcursos = null;
			 DefaultTableModel modelo = null;
			 JComboBox comboidCurso,combocategoria;
			 /**
			  * Constructor del panel
			  */
			 public Panel() {
		    	 setLayout(null);
		    	 setSize(710,320);
		    	 setBackground(new Color(192,192,192));
		    	 scrollArea = new JScrollPane();
		    	 
		    	 /**
		    	  * Creacion de los botones
		    	  */
		    	 editar = new JButton("editar");
					editar.setBounds(610,230,100,50);
					add(editar);
					editar.setEnabled(false);
					editar.addActionListener(this);

		         consultar=new JButton("Consultar");
		    	 consultar.setBounds(125,10,120,50); //Padding_Left, Padding_Top, Ancho, Alto
		         add(consultar);
		         consultar.addActionListener(this);
		         
		         
		         insertar=new JButton("Insertar");
		         insertar.setBounds(770,170,100,50);
		         add(insertar);
		         insertar.addActionListener(this);
		         
		         modificar=new JButton("Modificar");
		         modificar.setBounds(770,230,100,50);
		         add(modificar);
		         modificar.setEnabled(false);
		         modificar.addActionListener(this);
		         
		         borrar=new JButton("Eliminar");
		         borrar.setBounds(770,290,100,50);
		         add(borrar);
		         borrar.setEnabled(false);
		         borrar.addActionListener(this); 
		         
		         limpiar=new JButton("Limpiar");
		         limpiar.setBounds(610,170,100,25);
		         add(limpiar);
		         limpiar.addActionListener(this); 
		             
		         listar=new JButton("Listado");
		         listar.setBounds(10,145,100,50); 
		         add(listar);
		         listar.addActionListener(this);
		         
		     	/**
		     	 * @author Jesús Hernando,Alberto Jaén, Guillermo Priego
		     	 * @since 28/11/2015
		     	 * @version 1.0
		          * Creacion del TextArea con resultado
		          */
		       
		        
		          /**
		          * Creacion del panel scroll con tabla de cursos
		          */ 
		         String[] columnas = {"id", "Código", "Nombre", "Categoría", "Precio", "Duración", "Privado"};
		         tblcursos = new JTable();
		         modelo = new DefaultTableModel();
		         tblcursos.setBackground(new Color(224,224,224));
		         scrollArea.setViewportView(tblcursos);
		         scrollArea.setBounds(10,205,585,230); 
		         modelo.setColumnIdentifiers(columnas);
		         scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		         tblcursos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		         tblcursos.setFillsViewportHeight(true);        
		         
		         tblcursos.setModel(modelo);
		         tblcursos.getColumnModel().getColumn(0).setPreferredWidth(20);
		         tblcursos.getColumnModel().getColumn(1).setPreferredWidth(70);
		         tblcursos.getColumnModel().getColumn(2).setPreferredWidth(200);
		         tblcursos.getColumnModel().getColumn(3).setPreferredWidth(150);
		         tblcursos.getColumnModel().getColumn(4).setPreferredWidth(55);
		         tblcursos.getColumnModel().getColumn(5).setPreferredWidth(55);
		         tblcursos.getColumnModel().getColumn(6).setPreferredWidth(35);
		         add(scrollArea, BorderLayout.NORTH);
			 
		         /**
		          * Creacion de los TextFields y Labels
		          */
 
		         
		         label1=new JLabel("idCurso");
		         label1.setBounds(65,30,100,20);
		         add(label1);
		         
		         textfield1=new JTextField();
		         textfield1.setBounds(10,10,100,20);
		         add(textfield1);
		         textfield1.setBackground( new Color(224,224,224) );
		         
		         label2=new JLabel("Código Curso");
		         label2.setBounds(265,10,100,20);
		         add(label2);
		         
		         textfield2=new JTextField();
		         textfield2.setBounds(265,30,100,20);
		        add(textfield2);
		         textfield2.setBackground( new Color(224,224,224) );
		         
		         label3=new JLabel("Nombre");
		         label3.setBounds(380,10,100,20);
		         add(label3);
		         
		         textfield3=new JTextField();
		         textfield3.setBounds(380,30,100,20);
		         add(textfield3);
		         textfield3.setBackground( new Color(224,224,224) );
		         
		         label4=new JLabel("Categoria");
		         label4.setBounds(495,10,100,20);
		         add(label4);
		         
		        textfield4=new JTextField();
		         textfield4.setBounds(495,30,100,20);
		         add(textfield4);
		         textfield4.setBackground( new Color(224,224,224) );
		         
		         label5=new JLabel("Descripcion");
		         label5.setBounds(610,10,100,20);
		         add(label5);
		         
		         textarea5=new JTextArea();
		         textarea5.setBounds(610,30,260,120);
		         textarea5.setBackground( new Color(224,224,224) );
		         add(textarea5, BorderLayout.NORTH);
		         
		         label6=new JLabel("Precio");
		         label6.setBounds(265,65,100,20);
		         add(label6);
		         
		         textfield6=new JTextField();
		         textfield6.setBounds(265,85,100,20);
		         add(textfield6);
		         textfield6.setBackground( new Color(224,224,224) );
		         
		         label7=new JLabel("Duración");
		         label7.setBounds(380,65,100,20);
		         add(label7);
		         
		         textfield7=new JTextField();
		         textfield7.setBounds(380,85,100,20);
		         add(textfield7);
		         textfield7.setBackground( new Color(224,224,224) );
		         
		         label8=new JLabel("Privado");
		         label8.setBounds(495,65,100,20);
		         add(label8);
		         
		         privadobox = new JCheckBox();
		         privadobox.setBounds(495,85,20,20);
		         privadobox.setContentAreaFilled(false);
		         add(privadobox);
					if(Cursos.priv) privadobox.setSelected(true);		   
		     
		        comboidCurso=new JComboBox();
		     	comboidCurso.setBounds(265,30,100,20);
		     	try {
		     		cargarCombo();
		     	} catch (SQLException e) {
		     		e.printStackTrace();
		     	}
		     	comboidCurso.addActionListener(this);
		         add(comboidCurso);
		         
			 
			
			 combocategoria=new JComboBox();
		     	combocategoria.setBounds(495,30,100,20);
		     	try {
		     		cargarCombo1();
		     	} catch (SQLException e) {
		     		e.printStackTrace();
		     	}
		     	combocategoria.addActionListener(this);
		         add(combocategoria);
			 
			 
			 }
			 
			 @SuppressWarnings("unchecked")
			 void cargarCombo() throws SQLException {
			 	 String usuario = "root";
			 	 String pwd = "root";
			 	 String bd = "jdbc:mysql://localhost/nowedb";
			 	 
			 	 Connection conexion = DriverManager.getConnection(bd, usuario, pwd);
			 	 Statement sentenciaSql = conexion.createStatement();
			      ResultSet filas = sentenciaSql.executeQuery("Select CodigoCurso From cursos");
			      try {
			 			while(filas.next()){
			 				comboidCurso.addItem(filas.getString("CodigoCurso"));
			 			}
			 		} catch (SQLException ex) {
			 		
			 			ex.printStackTrace();
			 		}   		
			  }
			 
			 
			 void cargarCombo1() throws SQLException {
			 	 String usuario = "root";
			 	 String pwd = "root";
			 	 String bd = "jdbc:mysql://localhost/nowedb";
			 	 
			 	 Connection conexion = DriverManager.getConnection(bd, usuario, pwd);
			 	 Statement sentenciaSql = conexion.createStatement();
			      ResultSet filas = sentenciaSql.executeQuery("Select categoria From cursos");
			      try {
			 			while(filas.next()){
			 				combocategoria.addItem(filas.getString("Categoria"));
			 			}
			 		} catch (SQLException ex) {
			 		
			 			ex.printStackTrace();
			 		}   		
			  }
			 
			 /**
			  * Acciones de los botones al ser pulsados
			  */
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado==listar) {
		            	 clearCursos();
		            	 Cursos.Consultar(this);}
		             
		             
		             if (botonPulsado==consultar){
		            	clearCursos();
		            	editar.setEnabled(true);
		            	ResultSet filas;
		     			filas = Cursos.Consultarid(textfield1.getText(), this);
		     	        
		     			try {
		     				if (filas.next()){
		     					
		     					textfield2.setText(filas.getString("CodigoCurso"));
		     					textfield3.setText(filas.getString("Nombre"));
		     					textfield4.setText(filas.getString("Categoria"));
		     					textarea5.setText(filas.getString("Descripcion"));
		     					textfield6.setText(filas.getString("Precio"));
		     					textfield7.setText(filas.getString("Duracion"));
		     					privadobox.setText(filas.getString("Privado"));
		     					if (Cursos.numpriv.equals("1")){
		     						privadobox.setSelected(true);}
		     					else{
		     						privadobox.setSelected(false);
		     					}
		     					
		     				} else {
		     					JOptionPane.showMessageDialog(null, "no existe el registro");
		     				}
		     			} catch (SQLException e1) {
		     				e1.printStackTrace();
		     			}
		     		}
	
		             
		             if (botonPulsado==insertar) {
		            	 
		            	 String CodigoCurso1 = textfield2.getText();
		            	 String Nombre1 = textfield3.getText();
		            	 String Categoria1 = textfield4.getText();
		            	 String Descripcion1 = textarea5.getText();
		            	 String Precio1 = textfield6.getText();
		            	 float flprecio = Float.parseFloat(Precio1);
		            	 String Duracion1 = textfield7.getText();
		            	 int intduracion = Integer.parseInt(Duracion1);	 
		            	 boolean privado2 = privadobox.isSelected();
		            	 int privado1 = (privado2) ? 1 : 0;
		            	 JOptionPane.showMessageDialog(null, "El registro se insertó correctamente");
		            	 textareaconsulta.setText(Cursos.Insertar(CodigoCurso1,Nombre1,Categoria1,Descripcion1,flprecio,intduracion,privado1));
		            		
		             }
		             
		             if (botonPulsado==modificar) {
		            	 String idcurso1 = textfield1.getText();
		            	 int intidcurso = Integer.parseInt(idcurso1);
		            	 String CodigoCurso2 = (String)comboidCurso.getSelectedItem();
		            	 String Nombre2 = textfield3.getText();
		            	 String Categoria2 = (String)combocategoria.getSelectedItem();
		            	 String Descripcion2 = textarea5.getText();
		            	 String Precio2 = textfield6.getText();
		            	 float flprecio1 = Float.parseFloat(Precio2);
		            	 String Duracion2 = textfield7.getText();
		            	 int intduracion1 = Integer.parseInt(Duracion2);
		            	 boolean privado2 = privadobox.isSelected();
		            	 int privado1 = (privado2) ? 1 : 0; 
		            	 
		            	 JOptionPane.showMessageDialog(null, "El registro se modificó correctamente");
		            	 Cursos.Modificar(intidcurso,CodigoCurso2,Nombre2,Categoria2,Descripcion2,flprecio1,intduracion1,privado1);
		            	 
		             }

		          
		             if (botonPulsado==borrar) {
		            	 
		        			 String idCurso2 = textfield1.getText();
		        			 int intidCurso1 = Integer.parseInt(idCurso2);	 
			            	 JOptionPane.showMessageDialog(null, "El registro se eliminó correctamente");		 
		        			 Cursos.Eliminar( intidCurso1);
		             }
		        			 
		        	
		             if (botonPulsado==limpiar) {
		            	 textfield1.setText(""); 
		            	 textfield3.setText("");		            
		            	 textarea5.setText("");
		            	 textfield6.setText("");
		            	 textfield7.setText("");
		            	 remove(combocategoria);
							remove(comboidCurso);
		            	 combocategoria.setEnabled(false);
							comboidCurso.setEnabled(false);
							
							add(textfield2);
						add(textfield4);
						textfield4.setText(""); 
			            textfield2.setText("");
		            	 privadobox.setSelected(false);
		            	 clearCursos();
		            	 textareaconsulta.setText("");}
		             
		             if (botonPulsado==editar) {
						modificar.setEnabled(true);
						remove(textfield2);
						remove(textfield4);
						add(combocategoria);
						add(comboidCurso);
						combocategoria.setEnabled(true);
						comboidCurso.setEnabled(true);

					}
		           }
				/**
				 * @author Jesús Hernando
				 * @since 28/11/2015
				 * @version 1.0
				*/
			 private void clearCursos(){
			       for (int i = 0; i < tblcursos.getRowCount(); i++) {
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

		

