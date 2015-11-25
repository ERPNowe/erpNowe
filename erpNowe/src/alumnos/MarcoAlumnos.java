package alumnos;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MarcoAlumnos extends JFrame {

	// creo el constructor del panel donde pongo todas sus propiedades//

	public MarcoAlumnos() {
		// para ponerle el icono a la app
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logoApp.gif"));
		setIconImage(icon);
		setSize(900, 390); // Ancho*Alto
		setTitle("Gestión Alumnos Nowe");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Panel p = new Panel(); // crear la clase panel como en marcoprincipal
		add(p);
	}

	class Panel extends JPanel implements ActionListener {

		JButton consultar, insertar, modificar, borrar, limpiar, cerrar, listar;
		JTextArea textareaconsulta;
		JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6, textfield7, textfield8,textfield9, textfield10, textfield11,textfield12;
		JLabel label1, label2, label3;
		JScrollPane scrollArea;
		
		public Panel() {
			setLayout(null);
			setSize(900, 800);
			setBackground(new Color(192, 192, 192));
			setResizable(false);
			scrollArea = new JScrollPane();
			// creo los botones
			consultar = new JButton("Consulta");
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
			
			listar = new JButton("Listar");
			listar.setBounds(10, 250, 100, 50);
			add(listar);
			listar.addActionListener(this);

			limpiar = new JButton("Limpiar");
			limpiar.setBounds(120, 250, 100, 25);
			add(limpiar);
			limpiar.addActionListener(this);

			cerrar = new JButton("Cerrar");
			cerrar.setBounds(470, 250, 100, 25);
			add(cerrar);
			cerrar.addActionListener(this);

			textareaconsulta = new JTextArea();
			textareaconsulta.setBackground(new Color(224, 224, 224));
			textareaconsulta.setEditable(false);
			// pongo el textarea
			scrollArea.setViewportView(textareaconsulta);
			scrollArea.setBounds(120, 10, 450, 230); // posiciona dentro de la
														// ventana
			add(scrollArea);

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
			textfield12 = new JTextField();

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Object botonPulsado = e.getSource(); // podemos crearnos esta variable para preguntar luego por los botones

			if (botonPulsado == consultar) {
				

				if (textfield3.getText().equals("")) {
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
					textfield12.setText("");
					textareaconsulta.setText(Controlador.consultaAlumnos());
				}

				

			}
			

			if (botonPulsado == listar) {
			
			if (!textfield3.getText().equals("")) {
				String dni = textfield3.getText();
				ResultSet encontrado = Controlador.consultaAlumno(dni);

				try {
					if (!encontrado.next()) {
						textareaconsulta.setText("No se encuentra el Alumno");
					} else
						try {
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
							textfield12.setText(encontrado.getString("idAlumno"));
							textareaconsulta.setText("");
							modificar.setEnabled(true);
							borrar.setEnabled(true);

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}else {textareaconsulta.setText("Debes escribir un DNI");
			}
			}
			if (botonPulsado == insertar) {

				textareaconsulta.setText(Controlador.insertarAlumno(
						textfield1.getText(),
						textfield2.getText(),
						textfield3.getText(),
						textfield4.getText(), 
						Integer.parseInt(textfield5.getText()),
						textfield6.getText(),
						Integer.parseInt(textfield7.getText()),
						textfield8.getText(),
						textfield9.getText(), 
						textfield10.getText(),
						textfield11.getText()));
			}

			if (botonPulsado == modificar) {
				textareaconsulta.setText(Controlador.modificarAlumno(
						textfield1.getText(),
						textfield2.getText(),
						textfield3.getText(),
						textfield4.getText(),
						Integer.parseInt(textfield5.getText()),
						textfield6.getText(),
						Integer.parseInt(textfield7.getText()),
						textfield8.getText(),
						textfield9.getText(),
						textfield10.getText(),
						textfield11.getText(),
						textfield12.getText())

				);
			}

			if (botonPulsado == cerrar) {
				Controlador.conexion.cerrarConexion();
				textareaconsulta.setText("conexion cerrada");
			}

			if (botonPulsado == limpiar) {

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
				textfield12.setText("");
				textareaconsulta.setText("");
			}
			
			if (botonPulsado == borrar) {
				if (!textfield3.getText().equals("")) {

					textareaconsulta.setText(Controlador.borrarAlumno(textfield3.getText()));
				} else if (textfield3.getText().equals("")) {
					textareaconsulta.setText("Deves introducir el DNI de alumno que quieres borrar ");
				}

			}

		}

	}
}
