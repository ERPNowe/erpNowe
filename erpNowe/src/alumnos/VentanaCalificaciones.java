
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import ventanaPrincipal.VentanaPrincipal;


public class VentanaCalificaciones extends JFrame{


	public VentanaCalificaciones(){
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logoApp.gif"));
		setIconImage(icon);
		setSize(745,440);
		setTitle("Gestión Calificaciones Nowe");
		setLocationRelativeTo(null);
		Panel c = new Panel();
		add(c);

	} 
	class Panel extends JPanel implements ActionListener{

		JButton insertar,consultar,borrar,modificar,limpiar,cerrar;
		JCheckBox recogido;
		JTextArea textareaconsulta,textareaObservaciones; 
		JTextField textfield1, textfield2, textfield3, textfield4, textfield5, textfield6;
		JLabel label1,label2,label3, label4, label5,avisos;
		JScrollPane scrollArea1,scrollArea2;
		DefaultTableModel model = null;
		JTable table= null;
		

		public Panel(){
			setLayout(null);
			setSize(555,390);
			setBackground(new Color(192,192,192));
			scrollArea1 = new JScrollPane();
			scrollArea2 = new JScrollPane();

			consultar=new JButton("Consultar");
			consultar.setBounds(10,10,120,50);
			add(consultar);
			consultar.addActionListener(this);

			modificar=new JButton("Modificar");
			modificar.setBounds(10,10+60,120,50);
			add(modificar);
			modificar.setEnabled(false);
			modificar.addActionListener(this);
			
			limpiar=new JButton("Limpiar");
			limpiar.setBounds(150,250,100,25);
			add(limpiar);
			limpiar.addActionListener(this); 

			cerrar=new JButton("Cerrar");
			cerrar.setBounds(500,250,100,25);
			add(cerrar);
			cerrar.addActionListener(this);

			textfield1=new JTextField();
			textfield1.setBounds(620,10,100,20);
			add(textfield1);
			textfield1.setBackground( new Color(224,224,224) );

			label1=new JLabel("idAlumno");
			label1.setBounds(665,30,100,20);
			add(label1);

			textfield2=new JTextField();
			textfield2.setBounds(620,60,100,20);
			add(textfield2);
			textfield2.setBackground( new Color(224,224,224) );

			label2=new JLabel("idModulo");
			label2.setBounds(665,80,100,20);
			add(label2);

			textfield3=new JTextField();
			textfield3.setBounds(620,110,100,20);
			add(textfield3);
			textfield3.setBackground( new Color(224,224,224) );

			label3=new JLabel("Nota");
			label3.setBounds(690,130,100,20);
			add(label3);
			
			textareaconsulta = new JTextArea();
			textareaconsulta.setBackground(new Color(224, 224, 224));
			textareaconsulta.setEditable(false);
			String[] columnas = {"DNI", "idAlumno","idModulo","Nota","Diploma","Observaciones"};
		    table = new JTable();
		    model = new DefaultTableModel(){
		    	public boolean isCellEditable(int row,int column){
		    	    return false;
		    	  }
		    };
		    table.setBackground(new Color(224,224,224));
		    scrollArea1.setViewportView(table); 
		    scrollArea1.setBounds(150,10,450,210);
		    model.setColumnIdentifiers(columnas);
		    scrollArea1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		    scrollArea1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED ); 
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table.setFillsViewportHeight(true);        
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		    table.setModel(model);
		    
			
		    TableColumn col1 = table.getColumn("DNI");
		    col1.setPreferredWidth(100);
		    TableColumn col2 = table.getColumn("idAlumno");
		    col2.setPreferredWidth(70);
		    TableColumn col3 = table.getColumn("idModulo");
		    col3.setPreferredWidth(55);
		    TableColumn col4 = table.getColumn("Nota");
		    col4.setPreferredWidth(55);
		    TableColumn col5 = table.getColumn("Diploma");
		    col5.setPreferredWidth(55);
		    TableColumn col6 = table.getColumn("Observaciones");
		    col6.setPreferredWidth(112);
			
		    add(scrollArea1, BorderLayout.NORTH);
			

			label3=new JLabel("Observaciones");
			label3.setBounds(330,270,100,20);
			add(label3);

			textareaObservaciones = new JTextArea();	 
			textareaObservaciones.setBackground(new Color(224,224,224));

			scrollArea2.setViewportView(textareaObservaciones);
			scrollArea2.setBounds(150,290,450,100);
			add(scrollArea2);


			recogido = new JCheckBox();
			recogido.setBounds(615,175,20,20);
			recogido.setContentAreaFilled(false);
			add(recogido);
			if(Calificaciones.diploma) recogido.setSelected(true);

			label3=new JLabel("Diploma");
			label3.setBounds(620,155,100,20);
			add(label3);
			label3=new JLabel("Entregado");
			label3.setBounds(635,175,100,20);
			add(label3);
		
			avisos=new JLabel("Avisos:");
			avisos.setBounds(150,225,250,20);
			add(avisos);
		
		} 


		/**
		 * Acciones de los botones al ser pulsados
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object botonPulsado = e.getSource();
			if (botonPulsado == consultar && (textfield1.getText().equals("")  && textfield2.getText().equals(""))){
				clearCalificaciones();
				ResultSet datos;
				String  campo1= null  , campo2 = null, campo3 = null, campo4 = null, campo5 = null, campo6 = null;
				
				datos=Calificaciones.Consultar();
				try {
					while (datos.next()) {
						campo1  = datos.getString("DNI");
						campo2  = datos.getString("idAlumno");
						campo3  = datos.getString("idModulo");
						campo4  = datos.getString("Notas");
						campo5  = datos.getString("DiplomaRecogido");
						campo6  = datos.getString("Observaciones");
				model.addRow( new Object[] {campo1,campo2,campo3,campo4,campo5,campo6});
				textareaObservaciones.setText("");
				recogido.setSelected(false);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				}   
			else if (botonPulsado == consultar && (!textfield1.getText().equals("") && textfield2.getText().equals(""))){
				clearCalificaciones();
				ResultSet datos;
				String  campo1= null  , campo2 = null, campo3 = null, campo4 = null, campo5 = null, campo6 = null;
				
				datos=Calificaciones.Consultar1((textfield1.getText()));
				try {
					while (datos.next()) {
						campo1  = datos.getString("DNI");
						campo2  = datos.getString("idAlumno");
						campo3  = datos.getString("idModulo");
						campo4  = datos.getString("Notas");
						campo5  = datos.getString("DiplomaRecogido");
						campo6  = datos.getString("Observaciones");
				model.addRow( new Object[] {campo1,campo2,campo3,campo4,campo5,campo6});
				textareaObservaciones.setText("");
				recogido.setSelected(false);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
			}
			else if (botonPulsado == consultar && (textfield1.getText().equals("") && !textfield2.getText().equals(""))){
				clearCalificaciones();
				ResultSet datos;
				String  campo1= null  , campo2 = null, campo3 = null, campo4 = null, campo5 = null, campo6 = null;
				
				datos=Calificaciones.Consultar2((textfield2.getText()));
				try {
					while (datos.next()) {
						campo1  = datos.getString("DNI");
						campo2  = datos.getString("idAlumno");
						campo3  = datos.getString("idModulo");
						campo4  = datos.getString("Notas");
						campo5  = datos.getString("DiplomaRecogido");
						campo6  = datos.getString("Observaciones");
				model.addRow( new Object[] {campo1,campo2,campo3,campo4,campo5,campo6});
				textareaObservaciones.setText("");
				recogido.setSelected(false);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
			}
			else if (botonPulsado == consultar &&(!textfield1.getText().equals("") && !textfield2.getText().equals(""))){
				clearCalificaciones();
				ResultSet datos;
				String  campo1= null  , campo2 = null, campo3 = null, campo4 = null, campo5 = null, campo6 = null;
				
				datos=Calificaciones.Consultar3(textfield1.getText(),(textfield2.getText()));
				try {
					while(datos.next()){//es el metodo que permite ir recorriendo los datos
						campo1  = datos.getString("DNI");
						campo2  = datos.getString("idAlumno");
						campo3  = datos.getString("idModulo");
						campo4  = datos.getString("Notas");
						campo5  = datos.getString("DiplomaRecogido");
						campo6  = datos.getString("Observaciones");
						model.addRow( new Object[] {campo1,campo2,campo3,campo4,campo5,campo6});
						modificar.setEnabled(true);
						if(campo5.equals("1")){
     			    		
								recogido.setSelected(true);
 			    	  }
 			    	  else {
			    		  
 			    		 recogido.setSelected(false);

 			    	  }
						Calificaciones.Obs = campo6;
						Calificaciones.N = campo4;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if(Calificaciones.diploma) recogido.setSelected(true);
				textfield3.setText(Calificaciones.N);
				textareaObservaciones.setText(Calificaciones.Obs);
			}
			
			if (botonPulsado == modificar){

				avisos.setText(Calificaciones.ModificarCalificaciones(
						textfield1.getText(),
						textfield2.getText(),
						Float.parseFloat(textfield3.getText()),
						recogido.isSelected(),
						textareaObservaciones.getText()));
				if (Calificaciones.dRecibido == 0)
					Calificaciones.diploma = false;
			}

			if (botonPulsado == cerrar) {
				VentanaPrincipal.conexion.cerrarConexion();
				avisos.setText("Avisos: Conexion cerrada");
			}

			if (botonPulsado == limpiar) {

				textfield1.setText("");
				textfield2.setText("");
				textfield3.setText("");
				clearCalificaciones();
				textareaObservaciones.setText("");
				recogido.setSelected(false);
				modificar.setEnabled(false);
			
			}
		}
		private void clearCalificaciones(){
		       for (int i = 0; i < table.getRowCount(); i++) {
		           model.removeRow(i);
		           i-=1;
		       }
		}
		public DefaultTableModel getModel() {
			return model;
		}


		public void setModel(DefaultTableModel model) {
			this.model = model;
		}
		
	}
}
