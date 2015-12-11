/**
 * Clase Calificaciones
 * @author curso14/7803
 * @version 1.0
 * @since 26/11/2015
 * <br>
 * <p>
 * 
 * </p>
 */

package alumnos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import ventanaPrincipal.VentanaPrincipal;


@SuppressWarnings("serial")
public class VentanaInteresado extends JFrame {

	
	// creo el constructor del panel donde pongo todas sus propiedades//

	
	public VentanaInteresado() {
		// para ponerle el icono a la app
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logoApp.gif"));
		setIconImage(icon);
		setSize(855, 410); // Ancho*Alto
		setTitle("Gestión Alumnos Nowe");
		setLocationRelativeTo(null);		
		Panel p = new Panel(); // crear la clase panel como en marcoprincipal
		add(p);
	
		
	}
	
	

	class Panel extends JPanel implements ActionListener {

		JButton consultar, insertar, modificar, borrar, limpiar, cerrar, listar;
		JTextArea textareaconsulta;
		JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6, textfield7, textfield8,textfield9, textfield10, textfield11,textfield13;
		String textfield12=null;
		JLabel label1, label2, label3,avisos,label4;
		JScrollPane scrollArea;
		JComboBox select;
		private JTable tblalumnos, tblalumnos2 = null;
		DefaultTableModel modelo,modelo2 = null;
		int var = 1;
		
		
		public Panel() {
			setLayout(null);
			setSize(900, 800);
			setBackground(new Color(192, 192, 192));
			setResizable(false);
			scrollArea = new JScrollPane();
			// creo los botones
			consultar = new JButton("<html>Listar<br>todos</html>");
			consultar.setBounds(10, 10, 100, 50); // Padding_Left, Padding_Top,Ancho, Alto
			add(consultar);
			consultar.addActionListener(this);

			insertar = new JButton("Insertar");
			insertar.setBounds(10, 70, 100, 50);
			add(insertar);
			insertar.addActionListener(this);

			modificar = new JButton("Modificar");
			modificar.setBounds(10, 130, 100, 50);
			add(modificar);
			modificar.setEnabled(false);
			modificar.addActionListener(this);

			borrar = new JButton("Eliminar");
			borrar.setBounds(10, 190, 100, 50);
			add(borrar);
			borrar.setEnabled(false);
			borrar.addActionListener(this);
			
			listar = new JButton("<html>Buscar<br>Alumno</html>");
			listar.setBounds(10, 250, 100, 50);
			add(listar);
			listar.addActionListener(this);

//			limpiar = new JButton("Limpiar");
//			limpiar.setBounds(120, 250, 100, 25);
//			add(limpiar);
//			limpiar.addActionListener(this);

			cerrar = new JButton("Cerrar");
			cerrar.setBounds(470, 250, 100, 25);
			add(cerrar);
			cerrar.addActionListener(this);
			
			
			textareaconsulta = new JTextArea();
			textareaconsulta.setBackground(new Color(224, 224, 224));
			textareaconsulta.setEditable(false);
			
			// pongo el textarea
			
//			scrollArea.setViewportView(textareaconsulta);
//			scrollArea.setBounds(120, 10, 450, 230); // posiciona dentro de la ventana
//			add(scrollArea);
			
			 String[] columnas = {"IdAlumno","Nombre", "Apellidos", "DNI", "Email", "Telefono", "Direccion", "Codigo Postal", "Municipio","Provincia", "Pais","Fecha Nacimiento"};
			    tblalumnos = new JTable();
			    modelo = new DefaultTableModel();
			    tblalumnos.setBackground(new Color(224,224,224));
			    scrollArea.setViewportView(tblalumnos); // -- > así se ve que la tabla está bien insertada, pero no los datos recogidos en la BD
			    										//		al poner (textareaconsulta) no sale la tabla, pero se ven todos los datos como anteriormente
			    scrollArea.setBounds(120,10,450,230);   // -- > posiciona dentro de la ventana
			    modelo.setColumnIdentifiers(columnas);
			    scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			    scrollArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED ); 
			    tblalumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			    tblalumnos.setFillsViewportHeight(true);        
			    tblalumnos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			    tblalumnos.setModel(modelo);
			    
			    TableColumn col1 = tblalumnos.getColumn("IdAlumno");
			    col1.setPreferredWidth(100);
			    TableColumn col2 = tblalumnos.getColumn("Nombre");
			    col2.setPreferredWidth(70);
			    TableColumn col3 = tblalumnos.getColumn("Apellidos");
			    col3.setPreferredWidth(55);
			    TableColumn col4 = tblalumnos.getColumn("DNI");
			    col4.setPreferredWidth(55);
			    TableColumn col5 = tblalumnos.getColumn("Email");
			    col5.setPreferredWidth(55);
			    TableColumn col6 = tblalumnos.getColumn("Telefono");
			    col6.setPreferredWidth(55);
			    TableColumn col7 = tblalumnos.getColumn("Direccion");
			    col7.setPreferredWidth(70);
			    TableColumn col8 = tblalumnos.getColumn("Codigo Postal");
			    col8.setPreferredWidth(35);
			    TableColumn col9 = tblalumnos.getColumn("Municipio");
			    col9.setPreferredWidth(55);
			    TableColumn col10 = tblalumnos.getColumn("Provincia");
			    col10.setPreferredWidth(55);
			    TableColumn col11 = tblalumnos.getColumn("Pais");
			    col11.setPreferredWidth(35);
			    TableColumn col12 = tblalumnos.getColumn("Fecha Nacimiento");
			    col12.setPreferredWidth(35);
			    
			    add(scrollArea, BorderLayout.NORTH);
			    
			    
//			    tabla 2
			    
			    String[] columnas2 = {"Interesado"};
			    modelo2 = new DefaultTableModel();		   
			    modelo2.setColumnIdentifiers(columnas2);

			// pongo los texfileds y jlabel

			    
			label1 = new JLabel("Nombre");
			label1.setBounds(635, 30, 100, 20);
			add(label1);

			textfield1 = new JTextField();
			textfield1.setBounds(580, 10, 100, 20);
			add(textfield1);
			textfield1.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Apellidos");
			label1.setBounds(625, 80, 100, 20);
			add(label1);

			textfield2 = new JTextField();
			textfield2.setBounds(580, 60, 100, 20);
			add(textfield2);
			textfield2.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("DNI");
			label1.setBounds(655, 130, 100, 20);
			add(label1);

			textfield3 = new JTextField();
			textfield3.setBounds(580, 110, 100, 20);
			add(textfield3);
			textfield3.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Email");
			label1.setBounds(645, 180, 100, 20);
			add(label1);

			textfield4 = new JTextField();
			textfield4.setBounds(580, 160, 100, 20);
			add(textfield4);
			textfield4.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Telefono");
			label1.setBounds(630, 230, 100, 20);
			add(label1);

			textfield5 = new JTextField();
			textfield5.setBounds(580, 210, 100, 20);
			add(textfield5);
			textfield5.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Direccion");
			label1.setBounds(625, 280, 100, 20);
			add(label1);

			textfield6 = new JTextField();
			textfield6.setBounds(580, 260, 100, 20);
			add(textfield6);
			textfield6.setBackground(new Color(224, 224, 224));
			;

			label1 = new JLabel("Código Postal");
			label1.setBounds(760, 30, 100, 20);
			add(label1);

			textfield7 = new JTextField();
			textfield7.setBounds(740, 10, 100, 20);
			add(textfield7);
			textfield7.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Municipio");
			label1.setBounds(780, 80, 100, 20);
			add(label1);

			textfield8 = new JTextField();
			textfield8.setBounds(740, 60, 100, 20);
			add(textfield8);
			textfield8.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Provincia");
			label1.setBounds(785, 130, 100, 20);
			add(label1);

			textfield9 = new JTextField();
			textfield9.setBounds(740, 110, 100, 20);
			add(textfield9);
			textfield9.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Pais");
			label1.setBounds(810, 180, 100, 20);
			add(label1);

			textfield10 = new JTextField();
			textfield10.setBounds(740, 160, 100, 20);
			add(textfield10);
			textfield10.setBackground(new Color(224, 224, 224));

			label1 = new JLabel("Fecha Nacimiento");
			label1.setBounds(740, 230, 120, 20);
			add(label1);

			textfield11 = new JTextField();
			textfield11.setBounds(740, 210, 100, 20);
			add(textfield11);
			textfield11.setBackground(new Color(224, 224, 224));
			
			select = new JComboBox ();
			select.setBounds(740, 260, 100, 20);
			select.addItem("");
			select.addActionListener(this);
			add(select);
			
			label1 = new JLabel("Curso");
			label1.setBounds(805, 280, 120, 20);
			add(label1);
			
			
			label1 = new JLabel("Observaciones");
			label1.setBounds(755, 350, 120, 20);
			add(label1);
			
			avisos = new JLabel("");
			avisos.setBounds(120, 320, 500, 25);
			add(avisos);

			textfield13 = new JTextField();
			textfield13.setBounds(580, 310, 260, 40);
			add(textfield13);
			textfield13.setBackground(new Color(224, 224, 224));			
		}
		
		@SuppressWarnings("unchecked")
		public void CargarCursos(String alumno) {
			ResultSet datos;		
			datos = VentanaPrincipal.conexion.getQuery("select distinct areaDeInteres from areadeinteres where areadeinteres != all  (SELECT cursosInteresado FROM nowedb.alumnointeresado where idalumno='"+alumno+"')");
			try {
				while (datos.next())
					 select.addItem(datos.getString("areaDeInteres"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		

		

		@Override
		public void actionPerformed(ActionEvent e) {
			Object botonPulsado = e.getSource(); // podemos crearnos esta variable para preguntar luego por los botones
			boolean telefonoValido = true;
			boolean cpValido = true;
			boolean cDni = true;
			
			
	if (botonPulsado == consultar) {
		
		avisos.setText("");
					String  campo1= null  , campo2 = null, campo3 = null, campo4 = null, campo5 = null, campo6 = null, campo7 = null,
							campo8 = null, campo9 = null, campo10 = null, campo11 = null, campo12 = null;
					ResultSet datos;
					modificar.setEnabled(false);
					borrar.setEnabled(false);
					
					textfield1.setText("");
					textfield2.setText("");
					textfield3.setText("");
					textfield4.setText("");
					textfield5.setText("");
					textfield6.setText("");
					textfield7.setText("");
					textfield8.setText("");
					textfield9.setText("");
					textfield10.setText("");
					textfield11.setText("");
					
					 datos=Interesado.consultaAlumnos();
					try {
						clearAlumnos2();
						while (datos.next()) {
							campo1  = datos.getString("idAlumno");
							campo2  = datos.getString("Nombre");
							campo3  = datos.getString("Apellidos");
							campo4  = datos.getString("DNI");
							campo5  = datos.getString("Email");
							campo6  = datos.getString("Telefono");
							campo7  = datos.getString("Direccion");
							campo8  = datos.getString("CodigoPostal");
							campo9  = datos.getString("Municipio");
							campo10 = datos.getString("Provincia");
							campo11 = datos.getString("Pais");
							campo12 = datos.getString("FechaNacimiento");
							

							tblalumnos.setModel(modelo);
							getModelo().addRow( new Object[] {campo1,campo2,campo3,campo4,campo5,campo6,campo7,campo8,campo9,campo10,campo11,campo12});
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
					
					}   


			

			if (botonPulsado == listar) {
				clearAlumnos();
				avisos.setText("");
			if (!textfield3.getText().equals("")) {
				String dni = textfield3.getText();
				String  campo1,campo2= "";
				ResultSet encontrado = Interesado.consultaAlumno(dni);
				ResultSet datos,datos2;
				try {
					if (!encontrado.next()) {
						avisos.setText("No se encuentra el Alumno");
						
					} else
						try {
							modificar.setEnabled(true);
							borrar.setEnabled(true);
							
							
							
							textfield1.setText(encontrado.getString("Nombre"));
							textfield2.setText(encontrado.getString("Apellidos"));
							textfield3.setText(encontrado.getString("DNI"));
							textfield4.setText(encontrado.getString("Email"));
							textfield5.setText(encontrado.getString("Telefono"));
							textfield6.setText(encontrado.getString("Direccion"));
							textfield7.setText(encontrado.getString("CodigoPostal"));
							textfield8.setText(encontrado.getString("Municipio"));
							textfield9.setText(encontrado.getString("Provincia"));
							textfield10.setText(encontrado.getString("Pais"));
							textfield11.setText(encontrado.getString("FechaNacimiento"));
							textfield12=(encontrado.getString("idAlumno"));
							CargarCursos(encontrado.getString("idAlumno"));
							try {
								
								tblalumnos.setModel(modelo2);
							    TableColumn col13 = tblalumnos.getColumn("Interesado");
							    col13.setPreferredWidth(450);
							   
								
								datos = VentanaPrincipal.conexion.getQuery("SELECT cursosInteresado FROM alumnoInteresado WHERE idAlumno = '"+encontrado.getString("idAlumno")+"' ");
						     	datos2 = VentanaPrincipal.conexion.getQuery("SELECT Nombre  FROM cursos c join grupos g on c.idCurso=g.idCurso join matricula m on g.idGrupo= m.idGrupo where idAlumno='"+encontrado.getString("idAlumno")+"' ");
						     	
							
								
								String campoVacio="Matriculados";
								while (datos.next() ) {
									campo1 = datos.getString("cursosInteresado"); 
									
									getModelo2().addRow( new Object[]{campo1});
								}
								
								getModelo2().addRow( new Object[]{""});
								getModelo2().addRow( new Object[]{"                                                                "+campoVacio});
								
								
									
							    while (datos2.next()) {
								campo2 = datos2.getString("Nombre");
									getModelo2().addRow( new Object[] {campo2});
								}
								
								
								
								
								
							} catch (Exception e2) {
								
							}
							
//							avisos.setText(campo1);
							

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}else {avisos.setText("Debes escribir un DNI");
			}
			}
			if (botonPulsado == insertar) {
				avisos.setText("");
				String tel = textfield5.getText();
				String cp = textfield7.getText();
				String fec = textfield11.getText();
				if(tel.equals("")) tel = "0";
				if(cp.equals("")) cp = "0";
				if(fec.equals("")) fec = "0";
				
				String cursosInteresado = (String) select.getSelectedItem();
			
				if(!textfield3.getText().equals("")){
					avisos.setText("");
		    	try {
		    		Integer.parseInt(tel);
		    	} catch (NumberFormatException nfe){
		    		avisos.setText("Telefono no válido.");
		    		telefonoValido = false;
		    	}
		    	try {
		    		Integer.parseInt(cp);		    		
		    	} catch (NumberFormatException nfe){
		    		avisos.setText("CP no válido.");
		    		cpValido = false;
		    	}}else 	  {
		    		
		    			
		    		avisos.setText("debes introducir al menos un DNI.");
		    		cDni = false;
		    		
		    	}
		    	
		    	
		    	if(cpValido && telefonoValido && cDni )
		    		    avisos.setText(avisos.getText() + "\n" + Interesado.insertarAlumno(
						textfield1.getText(),
						textfield2.getText(),
						textfield3.getText(),
						textfield4.getText(), 
						tel,
						textfield6.getText(),
						cp,
						textfield8.getText(),
						textfield9.getText(), 
						textfield10.getText(),
						fec,
						cursosInteresado,
						textfield13.getText()
						
						) );
						
			}

			if (botonPulsado == modificar) {
				avisos.setText("");
				String tel = textfield5.getText();
				String cp = textfield7.getText();
				String fec = textfield11.getText();
				if(tel.equals("")) tel = "0";
				if(cp.equals("")) cp = "0";
				if(fec.equals("")) fec = "0";
				
				try {
		    		Integer.parseInt(tel);
		    	} catch (NumberFormatException nfe){
		    		avisos.setText("Telefono no válido.");
		    		telefonoValido = false;
		    	}
		    	try {
		    		Integer.parseInt(cp);		    		
		    	} catch (NumberFormatException nfe){
		    		avisos.setText( "CP no válido.");
		    		cpValido = false;
		    	}
		    	if(cpValido && telefonoValido)
				avisos.setText(Interesado.modificarAlumno(
						textfield1.getText(),
						textfield2.getText(),
						textfield3.getText(),
						textfield4.getText(),
						tel,
						textfield6.getText(),
						cp,
						textfield8.getText(),
						textfield9.getText(),
						textfield10.getText(),
						fec,
						textfield12)

				);
			}

			if (botonPulsado == cerrar) {
				avisos.setText("");
				VentanaPrincipal.conexion.cerrarConexion();
				avisos.setText("conexion cerrada");
			}

			if (botonPulsado == limpiar) {
				avisos.setText("");
				modificar.setEnabled(false);
				borrar.setEnabled(false);
				textfield1.setText("");
				textfield2.setText("");
				textfield3.setText("");
				textfield4.setText("");
				textfield5.setText("");
				textfield6.setText("");
				textfield7.setText("");
				textfield8.setText("");
				textfield9.setText("");
				textfield10.setText("");
				textfield11.setText("");
				if(var==1){
				clearAlumnos();
				}else if(var==2){
				clearAlumnos2();
				};
				avisos.setText("");
			}
			
			if (botonPulsado == borrar) {
				avisos.setText("");
				if (!textfield3.getText().equals("")) {

					avisos.setText(Interesado.borrarAlumno(textfield3.getText()));
				} else if (textfield3.getText().equals("")) {
					avisos.setText("Debes introducir el DNI de alumno que quieres borrar ");
				}

			}
			
			

		}

		private void clearAlumnos(){
		     for (int i = 0; i < tblalumnos.getRowCount(); i++) {
		         modelo.removeRow(i);
		         i-=1;
		     }
		 }
		public DefaultTableModel getModelo() {
			 return modelo;
		}

		public void setModelo(DefaultTableModel modelo) {
			 this.modelo = modelo;
			 var=1;;
		}
		
		
		private void clearAlumnos2(){
		     for (int i = 0; i < tblalumnos.getRowCount(); i++) {
		         modelo2.removeRow(i);
		         i-=1;
		     }
		 }
		public DefaultTableModel getModelo2() {
			 return modelo2;
		}

		public void setModelo2(DefaultTableModel modelo2) {
			 this.modelo2 = modelo2;
			 var=2;
		}
		
		
		
		

	}
	
	
}

