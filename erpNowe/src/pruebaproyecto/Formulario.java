package pruebaproyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Formulario extends JPanel implements ActionListener {
	// private JPanel contentPane;
	private static JTextField tf1;
	private static JTextField tf2;
	private static JTextField tf3;
    private static JTextArea taRegistros;
    private JScrollPane scrollRegs;
	private static JLabel labelResultado;
	private JButton btnAlta, btnBorrar, btnModificar, btnConsultaPorCdigo, btnRegSiguiente, btnRegAnterior, btnListaRegs;
	private JLabel lblIngreseCdigoDe;

	public Formulario() {
		// contentPane = new JPanel();
		setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		setLayout(null);
		// setBounds(100, 100, 606, 405);

		JLabel lblDescripcinDelArtculo = new JLabel("Descripción del artículo:");
		lblDescripcinDelArtculo.setBounds(23, 38, 193, 14);
		this.add(lblDescripcinDelArtculo);

		tf1 = new JTextField();
		tf1.setBounds(247, 35, 193, 20);
		this.add(tf1);
		tf1.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(23, 74, 95, 14);
		this.add(lblPrecio);

		tf2 = new JTextField();
		tf2.setBounds(247, 71, 107, 20);
		this.add(tf2);
		tf2.setColumns(10);

		btnAlta = new JButton("Alta");
		btnAlta.setBounds(247, 118, 89, 23);
		this.add(btnAlta);
		btnAlta.addActionListener(this);

		labelResultado = new JLabel("resultado");
		labelResultado.setBounds(361, 122, 229, 14);
		labelResultado.setText("");
		this.add(labelResultado);

		btnRegSiguiente = new JButton(">>");//Siguiente
		btnRegSiguiente.setBounds(375, 176, 89, 23);
		this.add(btnRegSiguiente);
		btnRegSiguiente.addActionListener(this);

		btnRegAnterior = new JButton("<<");//Anterior
		btnRegAnterior.setBounds(475, 176, 89, 23);
		this.add(btnRegAnterior);
		btnRegAnterior.addActionListener(this);

		btnConsultaPorCdigo = new JButton("Consultar registro");
		btnConsultaPorCdigo.setBounds(247, 225, 177, 23);
		this.add(btnConsultaPorCdigo);
		btnConsultaPorCdigo.addActionListener(this);

		lblIngreseCdigoDe = new JLabel("Código de articulo a consultar:");
		lblIngreseCdigoDe.setBounds(23, 179, 243, 14);
		this.add(lblIngreseCdigoDe);

		tf3 = new JTextField();
		tf3.setBounds(247, 176, 86, 20);
		this.add(tf3);
		tf3.setColumns(10);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(475, 225, 89, 23);
		this.add(btnBorrar);
		btnBorrar.addActionListener(this);

		btnListaRegs = new JButton("Listar registros");
		btnListaRegs.setBounds(25, 225, 177, 23);
		this.add(btnListaRegs);
		btnListaRegs.addActionListener(this);
		
		taRegistros=new JTextArea("Código \tDescripción\t \tPrecio\n\n");
//		taRegistros.setBounds(25,300,400,300);
//        add(taRegistros);
        scrollRegs=new JScrollPane(taRegistros);    
        scrollRegs.setBounds(25,300,400,300);
        add(scrollRegs);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(21, 118, 179, 23);
		this.add(btnModificar);
		btnModificar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 Object botonPulsado = e.getSource();
	        if (botonPulsado==btnAlta) {
		// TODO Auto-generated method stub
		labelResultado.setText("");
//		if (Articulo.getConexion()==null) 
			Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
		Articulo.insertarArticulo();
		// Principal.conexion.cerrarConexion();
		labelResultado.setText("Se registraron los datos.");
		tf1.setText("");
		tf2.setText("");
	        }
	        if (botonPulsado==btnRegSiguiente){
				tf1.setText("");
				tf2.setText("");
				// if(tf3.getText() == null) tf3.setText("0");
				Integer siguiente = new Integer(tf3.getText()) + 1;
				tf3.setText(siguiente.toString());
//				if (Articulo.getConexion()==null) 
//					Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
				Articulo.consultaArticulo();

	        }
	        if (botonPulsado==btnRegAnterior){
				tf1.setText("");
				tf2.setText("");
				// if(tf3.getText() == null) tf3.setText("0");
				Integer anterior = new Integer(tf3.getText()) - 1;
				tf3.setText(anterior.toString());
//				if (Articulo.getConexion()==null) 
//					Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
				Articulo.consultaArticulo();

	        }
	        if (botonPulsado==btnConsultaPorCdigo){
				labelResultado.setText("");
				tf1.setText("");
				tf2.setText("");
//				if (Articulo.getConexion()==null) 
//					Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
				Articulo.consultaArticulo();
	        }
	        if (botonPulsado==btnBorrar){
				labelResultado.setText("");
//				if (Articulo.getConexion()==null) 
//					Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
				Articulo.borrarArticulo();
				// Principal.conexion.cerrarConexion();
				tf1.setText("");
				tf2.setText("");
	        }
	        if (botonPulsado==btnListaRegs){
				labelResultado.setText("");
				tf1.setText("");
				tf2.setText("");
//				if (Articulo.getConexion()==null) 
//					Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
				Articulo.listaArticulos();
	        }
	        if (botonPulsado==btnModificar){
				labelResultado.setText("");
//				if (Articulo.getConexion()==null) 
//					Articulo.setConexion(new ConexionBaseDatos(Articulo.getBd(), Articulo.getUsuario(), Articulo.getPwd()));
				Articulo.modificarArticulo();
	        }
	}

	public static JTextField getTf1() {
		return tf1;
	}

	public static void setTf1(JTextField tf1) {
		Formulario.tf1 = tf1;
	}

	public static JTextField getTf2() {
		return tf2;
	}

	public static void setTf2(JTextField tf2) {
		Formulario.tf2 = tf2;
	}

	public static JTextField getTf3() {
		return tf3;
	}

	public static void setTf3(JTextField tf3) {
		Formulario.tf3 = tf3;
	}

	public static JTextArea getTaRegistros() {
		return taRegistros;
	}

	public void setTaRegistros(JTextArea taRegistros) {
		this.taRegistros = taRegistros;
	}

	public static JLabel getLabelResultado() {
		return labelResultado;
	}

	public static void setLabelResultado(JLabel labelResultado) {
		Formulario.labelResultado = labelResultado;
	}

}
