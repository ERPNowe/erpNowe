package matricula;

import java.awt.BorderLayout;

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
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



import javax.swing.JTable;

import ventanaPrincipal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaMatricula extends JFrame {
	
	public static JButton Insertar, Presupuesto,Modificar;
	public static JComboBox alumno, grupo, formaPago, desempleado, promociones, pagado;
	public static JTextField idMatricula;
	
	
	
		 public VentanaMatricula() {
		    	
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
			    setIconImage(icon);
			    setSize(885,525); 
			    setTitle("Gestión Matriculas Nowe");
			    setLocationRelativeTo(null);
		        Panel p = new Panel(); 
				add(p); 
			    }

		 class Panel extends JPanel implements ActionListener{

			 JButton consultar, Consultaid,ConsultaGR, limpiar,cerrar;
			 JTextArea textareaconsulta, textarea2; 
			 JLabel label1,label2,label3, label4, label5, label6, label7, detalles;
			 JScrollPane scrollArea;
			 private JTable tblmatricula = null;
			 DefaultTableModel modelo = null;
			 
			 public Panel() {
		    	 setLayout(null);
		    	 setSize(885,525);
		    	 setBackground(new Color(192,192,192));
		    	 scrollArea = new JScrollPane();
		    	
		    	
		    	 consultar=new JButton("Listado");
		    	 consultar.setBounds(10,10,120,50); 
		         add(consultar);
		         consultar.addActionListener(this);
		         
		         Consultaid=new JButton("<html>Consulta<br>alumno</html>");
		         Consultaid.setBounds(10,70,120,50);
		         add(Consultaid);
		         Consultaid.addActionListener(this);
		         
		         ConsultaGR=new JButton("<html>Consulta<br>grupo</html>");
		         ConsultaGR.setBounds(10,130,120,50);
		         add(ConsultaGR);
		         ConsultaGR.addActionListener(this);
		         
		         Modificar=new JButton("Modificar");
		         Modificar.setBounds(10,190,120,50);
		         add(Modificar);
		         Modificar.setEnabled(false);
		         Modificar.addActionListener(this);
		         
		         Insertar=new JButton("Insertar");
		         Insertar.setBounds(10,250,120,50);
		         add(Insertar);
		         Insertar.setEnabled(false);
		         Insertar.addActionListener(this);
		         
		         Presupuesto=new JButton("Presupuesto");
		         Presupuesto.setBounds(10,310,120,50);
		         add(Presupuesto);
		         Presupuesto.setEnabled(false);
		         Presupuesto.addActionListener(this);
		         
		         limpiar=new JButton("Limpiar");
		         limpiar.setBounds(200,380,100,25);
		         add(limpiar);
		         limpiar.addActionListener(this); 
		         
		         cerrar=new JButton("Cerrar");
		         cerrar.setBounds(460,380,100,25);
		         add(cerrar);
		         cerrar.addActionListener(this);
		         
		         textareaconsulta = new JTextArea();
		         textareaconsulta.setBackground(new Color(224,224,224));
		         
		         detalles=new JLabel("Detalles");
		         detalles.setBounds(360,420,50,10);
		         add(detalles); 
		         
		         textarea2 = new JTextArea();
		         textarea2.setBackground(new Color(224,224,224));
		         textarea2.setBounds(140,440,520,20); 
		         add(textarea2);
 
		         /**
		          * Creacion del panel scroll con tabla de cursos
		          */ 
		         String[] columnas = {"idMatricula", "idlumno", "idGrupo", "F.Pago", "Desempleado", "Promociones", "Pagado"};
		         tblmatricula = new JTable();
		         modelo = new DefaultTableModel();
		         tblmatricula.setBackground(new Color(224,224,224));
		         scrollArea.setViewportView(tblmatricula);
		         scrollArea.setBounds(140,10,520,350); //posiciona dentro de la ventana
		         modelo.setColumnIdentifiers(columnas);
		         scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		         tblmatricula.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		         tblmatricula.setFillsViewportHeight(true);        
		         
		         tblmatricula.setModel(modelo);
		         tblmatricula.getColumnModel().getColumn(0).setPreferredWidth(55);
		         tblmatricula.getColumnModel().getColumn(1).setPreferredWidth(40);
		         tblmatricula.getColumnModel().getColumn(2).setPreferredWidth(40);
		         tblmatricula.getColumnModel().getColumn(3).setPreferredWidth(40);
		         tblmatricula.getColumnModel().getColumn(4).setPreferredWidth(100);
		         tblmatricula.getColumnModel().getColumn(5).setPreferredWidth(70);
		         tblmatricula.getColumnModel().getColumn(6).setPreferredWidth(55);
		         add(scrollArea, BorderLayout.NORTH);
			 
		         label1=new JLabel("idAlumno");
		         label1.setBounds(675,30,100,20);
		         add(label1);
		         
		         alumno = new JComboBox();
		         alumno.setBounds(675,10,170,20);
		         add(alumno);
		         Matricula.menuAlumno();
		         alumno.setBackground( new Color(224,224,224) );
		         
		         
		         label2=new JLabel("idGrupo");
		         label2.setBounds(675,90,100,20);
		         add(label2);
		         
		         grupo = new JComboBox();
		         grupo.setBounds(675,70,170,20);
		         add(grupo);
		         Matricula.menuGrupo();
		         grupo.setBackground( new Color(224,224,224) );
		         
		         label3 = new JLabel("formaPago");
		         label3.setBounds(675,150,100,20);
		         add(label3);
		         
		         formaPago = new JComboBox();
		         formaPago.setBounds(675,130,170,20);
		         add(formaPago);
		         Matricula.menuFormaPago();
		         formaPago.setBackground( new Color(224,224,224) );
		         
		         label4=new JLabel("Desempleado");
		         label4.setBounds(675,210,100,20);
		         add(label4);
		         
		         desempleado = new JComboBox();
		         desempleado.setBounds(675,190,170,20);
		         add(desempleado);
		         desempleado.addItem("Desempleado");
		         desempleado.addItem("No Desempleado");
		         desempleado.setBackground( new Color(224,224,224) );
		         
		         label5=new JLabel("promociones");
		         label5.setBounds(675,270,100,20);
		         add(label5);
		         
		         promociones = new JComboBox();
		         promociones.setBounds(675,250,170,20);
		         add(promociones);
		         promociones.addItem("Desempleado");
		         promociones.addItem("Pago unico");
		         promociones.addItem("Desempleado + Pago Unico");
		         promociones.addItem("Ninguno");
		         promociones.setBackground( new Color(224,224,224) );
		         
		         label6=new JLabel("pagado");
		         label6.setBounds(675,330,100,20);
		         add(label6);
		         
		         pagado = new JComboBox();
		         pagado.setBounds(675,310,170,20);
		         add(pagado);
		         pagado.addItem("Si");
		         pagado.addItem("No");
		         pagado.setBackground( new Color(224,224,224) );
		         
		         label7=new JLabel("IdMatricula");
		         label7.setBounds(675,390,100,20);
		         add(label7);
		         
		         idMatricula = new JTextField();
		         idMatricula.setBounds(675,370,170,20);
		         add(idMatricula);
		         idMatricula.setBackground( new Color(224,224,224) );
		         
		         
		         
			 }
		          
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado==consultar) {
		            	 clearmatricula();
		            	 Matricula.Consultar(this);
		            	 }
		             
		             if (botonPulsado==Consultaid) {
		            	 clearmatricula();
		            	 Matricula.Consultarid((String)alumno.getSelectedItem(),this);}
		             
		             if (botonPulsado==ConsultaGR) {
		            	 ResultSet datos = VentanaPrincipal.conexion.getQuery("SELECT idGrupo FROM grupos WHERE idOficial= '"+grupo.getSelectedItem()+"'");
		            	 String idGrupo = "";
							try {
								while(datos.next())
								idGrupo = datos.getString("idGrupo");
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
			            	 int grupo = Integer.parseInt(idGrupo);
			            clearmatricula();
		            	Matricula.ConsultarGR(idGrupo,this);}
		             
		             if (botonPulsado==Presupuesto) {
		            	 ResultSet datos = VentanaPrincipal.conexion.getQuery("SELECT idGrupo FROM grupos WHERE idOficial= '"+grupo.getSelectedItem()+"'");
		            	 String idGrupo = "";
						try {
							while(datos.next())
							idGrupo = datos.getString("idGrupo");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
		            	 int grupo = Integer.parseInt(idGrupo);
		            	 String promocion = (String) promociones.getSelectedItem(); 
		            	 textarea2.setText(Matricula.crearPresupuesto(grupo,promocion));
		            	 }
		            	 
		             if (botonPulsado==Insertar) {
		            	 String idAlumno = (String) alumno.getSelectedItem();
		            	 int Alumno = Integer.parseInt(idAlumno);
		            	 String Matricul = idMatricula.getText();
		            	
		            	 ResultSet datos = VentanaPrincipal.conexion.getQuery("SELECT idGrupo FROM grupos WHERE idOficial= '"+grupo.getSelectedItem()+"'");
		            	 String idGrupo = "";
						try {
							while(datos.next())
							idGrupo = datos.getString("idGrupo");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
		            	 int grupo = Integer.parseInt(idGrupo);
		            	 
		            	
		            	 ResultSet datos2 = VentanaPrincipal.conexion.getQuery("SELECT idFormaPago FROM formapago WHERE descripcion = '"+formaPago.getSelectedItem()+"'");
		            	 String idFormaPago = "";
							try {
								while(datos2.next())
									idFormaPago = datos2.getString("idFormaPago".toString());
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							int formaPago = Integer.parseInt(idFormaPago);	 
			            	 
			            	 
			            	int desemplead = 0; 
			             if(desempleado.getSelectedItem() == "Desempleado") {
			            	 desemplead = 1;
			             }else{
			            	 desemplead = 0;
			             } 	 
		            	 String promocion = (String) promociones.getSelectedItem(); 
			             
		            	 int pagad = 0; 
			             if(pagado.getSelectedItem() == "Si") {
			            	 pagad = 1;
			             }else{
			            	 pagad = 0;
			             } 	 
		            	 
			             textarea2.setText(Matricula.insertar(Matricul,Alumno,grupo,formaPago,desemplead,promocion,pagad));
		            	 }
		             
	            	 if (botonPulsado==Modificar) {
		             String idAlumno = (String) alumno.getSelectedItem();
	            	 int Alumno = Integer.parseInt(idAlumno);
	            	 
	            	 String Matricul = idMatricula.getText();
	            	
	            	 ResultSet datos = VentanaPrincipal.conexion.getQuery("SELECT idGrupo FROM grupos WHERE idOficial= '"+grupo.getSelectedItem()+"'");
	            	 String idGrupo = "";
					try {
						while(datos.next())
						idGrupo = datos.getString("idGrupo");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	            	 int grupo = Integer.parseInt(idGrupo);
	            	 
	            	
	            	 ResultSet datos2 = VentanaPrincipal.conexion.getQuery("SELECT idFormaPago FROM formapago WHERE descripcion = '"+formaPago.getSelectedItem()+"'");
	            	 String idFormaPago = "";
						try {
							while(datos2.next())
								idFormaPago = datos2.getString("idFormaPago".toString());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						int formaPago = Integer.parseInt(idFormaPago);	 
		            	 
		            	 
		            	int desemplead = 0; 
		             if(desempleado.getSelectedItem() == "Desempleado") {
		            	 desemplead = 1;
		             }else{
		            	 desemplead = 0;
		             } 	 
	            	 String promocion = (String) promociones.getSelectedItem(); 
		             
	            	 int pagad = 0; 
		             if(pagado.getSelectedItem() == "Si") {
		            	 pagad = 1;
		             }else{
		            	 pagad = 0;
		             } 	 
	            	 
		             textarea2.setText(Matricula.modificar(Matricul,Alumno,grupo,formaPago,desemplead,promocion,pagad));
	            	 }
		             
		             if (botonPulsado==limpiar) {
		            	 clearmatricula();
		            	 textarea2.setText("");
		            	 idMatricula.setText("");
		            	 }
		             
		             if (botonPulsado==cerrar) {
		            	 VentanaPrincipal.conexion.cerrarConexion();
		            	 textarea2.setText("conexion cerrada");}
		            	 
		           }
			 private void clearmatricula(){
			       for (int i = 0; i < tblmatricula.getRowCount(); i++) {
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
