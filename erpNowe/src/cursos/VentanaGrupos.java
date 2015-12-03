package cursos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.TextArea;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cursos.Grupos;
import utilidades.Fecha;
import ventanaPrincipal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaGrupos extends JFrame {
	
	 public VentanaGrupos() {
			setSize(780,550);  
			Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
	    	setIconImage(icon);
			setTitle("Gestión Grupos Nowe");
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			
			Paneles p = new Paneles();
			add(p);
		}
		class FrameListener extends WindowAdapter
		{
		   public void windowClosing(WindowEvent e)
		  {
		   System.out.println("Cerrando la conexión...");
		   VentanaPrincipal.conexion.cerrarConexion();
		    System.exit(0);
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
 	private JTable tblcursos = null;
	DefaultTableModel modelo = null;
 
 @SuppressWarnings("rawtypes")
public Paneles()  {
	setLayout(null);
	scrollArea = new JScrollPane();
	setBackground(new Color(192,192,192));
	
	lbidGrupo = new JLabel("idGrupo ");
	lbidGrupo.setBounds(600,30,100,20);
	add(lbidGrupo);
	lbidAcademia = new JLabel("idAcademia ");
	lbidAcademia.setBounds(600,90,100,20);
	add(lbidAcademia);
	lbidOficial = new JLabel("idOficial ");
	lbidOficial.setBounds(600,150,100,20);
	add(lbidOficial);
	lbhorario = new JLabel("horario ");
	lbhorario.setBounds(600,210,100,20);
	add(lbhorario);
	lbfechaInicio = new JLabel("fecha inicio (dd/mm/aaaa)");
	lbfechaInicio.setBounds(600,270,100,20);
	add(lbfechaInicio);
	lbfechaFin = new JLabel("fecha fin (dd/mm/aaaa)");
	lbfechaFin.setBounds(600,330,100,20);
	add(lbfechaFin);
	lbaula = new JLabel("aula ");
	lbaula.setBounds(600,390,100,20);
	add(lbaula);
	lbidCurso = new JLabel("Id. Curso ");
	lbidCurso.setBounds(600,440,100,20);
	add(lbidCurso);
	lbcodCurso = new JLabel("Cod. Curso ");
	lbcodCurso.setBounds(600,500,100,20);
	add(lbcodCurso);
	
	cidGrupo = new JTextField();
	cidGrupo.setBounds(600,10,150,20);
	add(cidGrupo);
	cidAcademia = new JTextField();
	cidAcademia.setBounds(600,70,150,20);
	add(cidAcademia);
	cidOficial = new JTextField();
	cidOficial.setBounds(600,130,150,20);
	add(cidOficial);
	chorario = new JTextField();
	chorario.setBounds(600,190,150,20);
	add(chorario);
	cfechaInicio = new JTextField();
	cfechaInicio.setBounds(600,250,150,20);
	add(cfechaInicio);
	cfechaFin = new JTextField();
	cfechaFin.setBounds(600,310,150,20);
	add(cfechaFin);
	caula = new JTextField();
	caula.setBounds(600,370,150,20);
	add(caula);
	cidCurso = new JTextField();
	cidCurso.setBounds(600,420,150,20);
	add(cidCurso);
		
	comboidCurso=new JComboBox();
	comboidCurso.setBounds(600,480,150,20);
	try {
		cargarCombo();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	comboidCurso.addActionListener(this);
    add(comboidCurso);
        
	area = new TextArea();	
	scrollArea.setViewportView(area);	
	scrollArea.setBounds(140,380,430,350);
	add(scrollArea);
	
	btConsultar = new JButton("Consultar");
	btConsultar.setBounds(10,10,120,50);
	btConsultar.addActionListener(this);
	add(btConsultar);
	btInsertar = new JButton("Insertar");
	btInsertar.setBounds(10,70,120,50);
	btInsertar.addActionListener(this);
	add(btInsertar);		
	btModificar = new JButton("Modificar");
	btModificar.setBounds(10,130,120,50);
	btModificar.addActionListener(this);
	add(btModificar);
	
	btBorrar = new JButton("Limpiar");
	btBorrar.setBounds(10,190,120,50);
	btBorrar.addActionListener(this);
	add(btBorrar);
	
	btListado = new JButton("Listado");
	btListado.setBounds(10,250,120,50);
	btListado.addActionListener(this);
	add(btListado);
	
	/**
     * Creacion del panel scroll con tabla de cursos
     */ 
    String[] columnas = {"IdGrupo","idAcademia", "IdOficial", "Horario", "Fecha Inicio", "Fecha Fin", "Aula", "IdCurso"};
    tblcursos = new JTable();
    modelo = new DefaultTableModel();
    tblcursos.setBackground(new Color(224,224,224));
    scrollArea.setViewportView(tblcursos);
    scrollArea.setBounds(140,10,450,420); 
    modelo.setColumnIdentifiers(columnas);
    scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    tblcursos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    tblcursos.setFillsViewportHeight(true);        
    
    tblcursos.setModel(modelo);
    TableColumn col1 = tblcursos.getColumn("IdGrupo");
    col1.setPreferredWidth(20);
    TableColumn col2 = tblcursos.getColumn("idAcademia");
    col2.setPreferredWidth(70);
    TableColumn col3 = tblcursos.getColumn("IdOficial");
    col3.setPreferredWidth(55);
    TableColumn col4 = tblcursos.getColumn("Horario");
    col4.setPreferredWidth(55);
    TableColumn col5 = tblcursos.getColumn("Fecha Inicio");
    col5.setPreferredWidth(55);
    TableColumn col6 = tblcursos.getColumn("Fecha Fin");
    col6.setPreferredWidth(55);
    TableColumn col7 = tblcursos.getColumn("Aula");
    col7.setPreferredWidth(35);
    TableColumn col8 = tblcursos.getColumn("IdCurso");
    col8.setPreferredWidth(35);
    add(scrollArea, BorderLayout.NORTH);
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
			clearCursos();
			ResultSet filas;
			filas = Grupos.consultar(cidGrupo.getText(),this);
	        
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
					
					cfechaInicio.setText(Fecha.devolverFormatoBD(filas.getString("fechaInicio")));
					cfechaFin.setText(Fecha.devolverFormatoBD(filas.getString("fechaFin")));
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
								 
				clearCursos();
           	 	Grupos.listar(this);}
	
			if(botonPulsado == btInsertar){
				 
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

		 if(botonPulsado == btBorrar){
			 cidGrupo.setText("");
			 cidAcademia.setText("");
			 cidOficial.setText("");
			 chorario.setText("");
			 cfechaInicio.setText("");
			 cfechaFin.setText("");
			 caula.setText("");
			 cidCurso.setText("");	 
			 area.setText("");	 
		 }		 
		
 	}
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

