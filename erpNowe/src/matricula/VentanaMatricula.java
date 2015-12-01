package matricula;

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
public class VentanaMatricula extends JFrame {
	
	public static JButton Insertar, Presupuesto,Modificar;
	public static JComboBox alumno, grupo, formaPago, desempleado, promociones, pagado;
	public static JTextField idMatricula;
	
	
	
		 public VentanaMatricula() {
		    	
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
			    setIconImage(icon);
			    setSize(780,455); 
			    setTitle("Gestión Matriculas Nowe");
			    setLocationRelativeTo(null);
		        Panel p = new Panel(); 
				add(p); 
			    }

		 class Panel extends JPanel implements ActionListener{

			 JButton consultar, Consultaid,ConsultaGR, limpiar,cerrar;
			 JTextArea textareaconsulta; 
			 JLabel label1,label2,label3, label4, label5, label6, label7;
			 JScrollPane scrollArea;
			 
			 public Panel() {
		    	 setLayout(null);
		    	 setSize(780,455);
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
		         scrollArea.setBounds(140,10,430,350); 
		         add(scrollArea);
 
		         label1=new JLabel("idAlumno");
		         label1.setBounds(580,30,100,20);
		         add(label1);
		         
		         alumno = new JComboBox();
		         alumno.setBounds(580,10,170,20);
		         add(alumno);
		         Matricula.menuAlumno();
		         alumno.setBackground( new Color(224,224,224) );
		         
		         
		         label2=new JLabel("idGrupo");
		         label2.setBounds(580,90,100,20);
		         add(label2);
		         
		         grupo = new JComboBox();
		         grupo.setBounds(580,70,170,20);
		         add(grupo);
		         Matricula.menuGrupo();
		         grupo.setBackground( new Color(224,224,224) );
		         
		         label3 = new JLabel("formaPago");
		         label3.setBounds(580,150,100,20);
		         add(label3);
		         
		         formaPago = new JComboBox();
		         formaPago.setBounds(580,130,170,20);
		         add(formaPago);
		         Matricula.menuFormaPago();
		         formaPago.setBackground( new Color(224,224,224) );
		         
		         label4=new JLabel("Desempleado");
		         label4.setBounds(580,210,100,20);
		         add(label4);
		         
		         desempleado = new JComboBox();
		         desempleado.setBounds(580,190,170,20);
		         add(desempleado);
		         desempleado.addItem("Desempleado");
		         desempleado.addItem("No Desempleado");
		         desempleado.setBackground( new Color(224,224,224) );
		         
		         label5=new JLabel("promociones");
		         label5.setBounds(580,270,100,20);
		         add(label5);
		         
		         promociones = new JComboBox();
		         promociones.setBounds(580,250,170,20);
		         add(promociones);
		         promociones.addItem("Desempleado");
		         promociones.addItem("Pago unico");
		         promociones.addItem("Desempleado + Pago Unico");
		         promociones.addItem("Ninguno");
		         promociones.setBackground( new Color(224,224,224) );
		         
		         label6=new JLabel("pagado");
		         label6.setBounds(580,330,100,20);
		         add(label6);
		         
		         pagado = new JComboBox();
		         pagado.setBounds(580,310,170,20);
		         add(pagado);
		         pagado.addItem("Si");
		         pagado.addItem("No");
		         pagado.setBackground( new Color(224,224,224) );
		         
		         label7=new JLabel("IdMatricula");
		         label7.setBounds(580,390,100,20);
		         add(label7);
		         
		         idMatricula = new JTextField();
		         idMatricula.setBounds(580,370,170,20);
		         add(idMatricula);
		         idMatricula.setBackground( new Color(224,224,224) );
		         
		         
			 }
		          
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado==consultar) {
		            	 textareaconsulta.setText(Matricula.Consultar());}
		             
		             if (botonPulsado==Consultaid) {
		            	 textareaconsulta.setText(Matricula.Consultarid((String)alumno.getSelectedItem()));}
		             
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
		            	 textareaconsulta.setText((Matricula.ConsultarGR(idGrupo)));}
		             
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
			             textareaconsulta.setText(Matricula.crearPresupuesto(grupo,promocion));
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
		            	 
		            	 textareaconsulta.setText(Matricula.insertar(Matricul,Alumno,grupo,formaPago,desemplead,promocion,pagad));
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
	            	 
	            	 textareaconsulta.setText(Matricula.modificar(Matricul,Alumno,grupo,formaPago,desemplead,promocion,pagad));
	            	 }
		             
		             if (botonPulsado==limpiar) {
		            	 textareaconsulta.setText("");}
		             
		             if (botonPulsado==cerrar) {
		            	 VentanaPrincipal.conexion.cerrarConexion();
		            	 textareaconsulta.setText("conexion cerrada");}
		            	 
		           }
		         }
}
