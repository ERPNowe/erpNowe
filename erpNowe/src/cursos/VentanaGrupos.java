package cursos;

import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import cursos.Grupos;
import utilidades.Fecha;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class VentanaGrupos extends JFrame {
	
	 public VentanaGrupos() {
			setSize(1200,800);  
			Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
	    	setIconImage(icon);
			setTitle("Ventana Grupos");
			//setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
			Paneles p = new Paneles();
			add(p);
		}
}

@SuppressWarnings("serial")
class Paneles extends JPanel implements ActionListener{
		 
	JLabel lbidGrupo, lbidAcademia, lbidOficial, lbhorario, lbfechaInicio, lbfechaFin,lbaula,lbidCurso,lbcodCurso;
 	JTextField cidGrupo,cidAcademia,cidOficial,chorario,cfechaInicio,cfechaFin,caula,cidCurso;
 	JButton btConsultar, btInsertar,btModificar,btBorrar,btListado;
 	TextArea area;
 	JScrollPane scrollArea;
 	JComboBox comboidCurso;
 
 @SuppressWarnings("rawtypes")
public Paneles()  {
	setLayout(null);
	scrollArea = new JScrollPane();
	
	lbidGrupo = new JLabel("idGrupo: ");
	lbidGrupo.setBounds(50, 20, 100, 30);
	add(lbidGrupo);
	lbidAcademia = new JLabel("idAcademia: ");
	lbidAcademia.setBounds(50, 60, 100, 30);
	add(lbidAcademia);
	lbidOficial = new JLabel("idOficial: ");
	lbidOficial.setBounds(50, 100, 100, 30);
	add(lbidOficial);
	lbhorario = new JLabel("horario: ");
	lbhorario.setBounds(50, 140, 100, 30);
	add(lbhorario);
	lbfechaInicio = new JLabel("fecha inicio: ");
	lbfechaInicio.setBounds(50, 180, 100, 30);
	add(lbfechaInicio);
	lbfechaFin = new JLabel("fecha fin: ");
	lbfechaFin.setBounds(50, 220, 100, 30);
	add(lbfechaFin);
	lbaula = new JLabel("aula: ");
	lbaula.setBounds(50, 260, 100, 30);
	add(lbaula);
	lbidCurso = new JLabel("Id. Curso: ");
	lbidCurso.setBounds(50, 300, 100, 30);
	add(lbidCurso);
	lbcodCurso = new JLabel("Cod. Curso: ");
	lbcodCurso.setBounds(50, 340, 100, 30);
	add(lbcodCurso);
	
	cidGrupo = new JTextField();
	cidGrupo.setBounds(130, 20, 60, 30);
	add(cidGrupo);
	cidAcademia = new JTextField();
	cidAcademia.setBounds(130, 60, 100, 30);
	add(cidAcademia);
	cidOficial = new JTextField();
	cidOficial.setBounds(130, 100, 100, 30);
	add(cidOficial);
	chorario = new JTextField();
	chorario.setBounds(130, 140, 200, 30);
	add(chorario);
	cfechaInicio = new JTextField();
	cfechaInicio.setBounds(130, 180, 200, 30);
	add(cfechaInicio);
	cfechaFin = new JTextField();
	cfechaFin.setBounds(130, 220, 200, 30);
	add(cfechaFin);
	caula = new JTextField();
	caula.setBounds(130, 260, 200, 30);
	add(caula);
	cidCurso = new JTextField();
	cidCurso.setBounds(130, 300, 200, 30);
	add(cidCurso);
		
	comboidCurso=new JComboBox();
	comboidCurso.setBounds(130, 340, 200, 30);
	try {
		cargarCombo();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	comboidCurso.addActionListener(this);
    add(comboidCurso);
        
		
	area = new TextArea();	
	scrollArea.setViewportView(area);	
	scrollArea.setBounds(20,500,1000,200);
	add(scrollArea);
	
	btConsultar = new JButton("Consultar");
	btConsultar.setBounds(50,380,100,30);
	btConsultar.addActionListener(this);
	add(btConsultar);
	btInsertar = new JButton("Insertar");
	btInsertar.setBounds(150,380,100,30);
	btInsertar.addActionListener(this);
	add(btInsertar);		
	btModificar = new JButton("Modificar");
	btModificar.setBounds(50,420,100,30);
	btModificar.addActionListener(this);
	add(btModificar);
	/*Está desactivado el botón de borrado porque al contener claves foráneas da error al intentar borrar*/
	btBorrar = new JButton("Borrar");
	btBorrar.setBounds(150,420,100,30);
	btBorrar.addActionListener(this);
	add(btBorrar);
	//btBorrar.setVisible(false);
	
	btListado = new JButton("Listado");
	btListado.setBounds(50,460,100,30);
	btListado.addActionListener(this);
	add(btListado);
	
 }
 
 @SuppressWarnings("unchecked")
void cargarCombo() throws SQLException {
	 String usuario = "root";
	 String pwd = "root";
	 String bd = "jdbc:mysql://localhost/nowedb";
	 
	 Connection conexion = DriverManager.getConnection(bd, usuario, pwd);
	 Statement sentenciaSql = conexion.createStatement();
     ResultSet filas = sentenciaSql.executeQuery("Select codigoCurso From cursos");
     try {
			while(filas.next()){
				comboidCurso.addItem(filas.getString("codigoCurso"));
			}
		} catch (SQLException ex) {
		
			ex.printStackTrace();
		}   		
 }
 
 @Override
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if(botonPulsado == btConsultar){
			ResultSet filas;
			filas = Grupos.consultar(cidGrupo.getText());
	        
			try {
				if (filas.next()){
					area.setText("idGrupo"+"\t"+"\t"+
							"idAcademia"+"\t"+
							"idOficial"+"\t"+"\t"+
							"horario"+"\t"+"\t"+
							"fechaInicio"+"\t"+"\t"+
							"fechaFin"+"\t"+"\t"+"\t"+
							"aula"+"\t"+"\t"+
							"idCurso"+"\n"+
							filas.getString("idGrupo")+"\t"+"\t"+
							filas.getString("idAcademia")+"\t"+"\t"+
							filas.getString("idOficial")+"\t"+"\t"+
							filas.getString("horario")+"\t"+
							Fecha.devolverFormatoBD(filas.getString("fechaInicio"))+"\t"+"\t"+
							Fecha.devolverFormatoBD(filas.getString("fechaFin"))+"\t"+"\t"+
							filas.getString("aula")+"\t"+"\t"+
							filas.getString("idCurso")+"\n");
					cidAcademia.setText(filas.getString("idAcademia"));
					cidOficial.setText(filas.getString("idOficial"));
					chorario.setText(filas.getString("horario"));
					/*String stfechaInicio = Fecha.darFormatoBD(cfechaInicio.getText());
			 String stfechaFin = Fecha.darFormatoBD(cfechaFin.getText());
					 * */
					cfechaInicio.setText(filas.getString("fechaInicio"));
					cfechaFin.setText(filas.getString("fechaFin"));
					caula.setText(filas.getString("aula"));
					cidCurso.setText(filas.getString("idCurso"));
					
				} else {
					JOptionPane.showMessageDialog(null, "no existe el registro");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
			if(botonPulsado == btListado){
				
				 area.setText(Grupos.listar());}
				
	
			if(botonPulsado == btInsertar){
				 
				 
				 //String stidGrupo = cidGrupo.getText();
				 String stidAcademia = cidAcademia.getText();
				 String stidOficial = cidOficial.getText();
				 String sthorario = chorario.getText();
				 String stfechaInicio = Fecha.darFormatoBD(cfechaInicio.getText());
				 String stfechaFin = Fecha.darFormatoBD(cfechaFin.getText());
				 String staula = caula.getText();
				 String stidCurso = (String) cidCurso.getText();
				 int intidCurso = Integer.parseInt(stidCurso);
				 Grupos.insertar( stidAcademia,stidOficial, sthorario, stfechaInicio, stfechaFin, staula,
								intidCurso);	 
				 }
		 
		 
		 if(botonPulsado == btModificar){
			 String stidGrupo = cidGrupo.getText();
			 int intidGrupo = Integer.parseInt(stidGrupo);
			 String stidAcademia = cidAcademia.getText();
			 String stidOficial = cidOficial.getText();
			 String sthorario = chorario.getText();
			 String stfechaInicio = Fecha.darFormatoBD(cfechaInicio.getText());
			 String stfechaFin = Fecha.darFormatoBD(cfechaFin.getText());
			 String staula = caula.getText();
			 String stidCurso = (String) cidCurso.getText();
			 int intidCurso = Integer.parseInt(stidCurso);
			 Grupos.modificar( intidGrupo, stidAcademia,stidOficial, sthorario,stfechaInicio,stfechaFin, staula,
								intidCurso);
			 }
/*Está desactivado el botón de borrado porque al contener claves foráneas da error al intentar borrar*/
		 if(botonPulsado == btBorrar){
			 String idGrupo = cidGrupo.getText();
			 int intidGrupo = Integer.parseInt(idGrupo);			 
			 area.setText(Grupos.eliminar( intidGrupo));	 
		 }
 	}

}

