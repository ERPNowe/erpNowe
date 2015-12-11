package gestion;

import java.awt.BorderLayout;

/**
 * 
 * @author Marcos Lueje Alonso
 * <p> clase ¡ <p>
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
import java.io.FileNotFoundException;

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

import com.itextpdf.text.DocumentException;

import gestion.Gestion;
import gestion.VentanaGestion.Panel;


import javax.swing.JTable;

import ventanaPrincipal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaGestion extends JFrame{
	
	
	public static JButton consulta, generarFactura,guardarFactura,gmprimir,anadirLinea,limpiar,cerrar,modificar;
	public static JComboBox formaDePago;
	public static JLabel lformaDePago;
	public static JTextField numFactura,fechaFactura,nombreEmpresa,direccionEmpresa,cifEempresa,personaContacto,telefonoEmpresa,emailEmpresa;
	public static JLabel lnumFactura,lfechaFactura,lnombreEmpresa,ldireccionEmpresa,lcifEempresa,lpersonaContacto,ltelefonoEmpresa,lemailEmpresa;
	public static JTextField codigo,descripcion,cantidad,preciounidad,importe;
	public static JLabel lcodigo,ldescripcion,lcantidad,lpreciounidad,limporte,detalles;
	public static JTextField bi,iva,total;
	public static JLabel  lbi,liva,ltotal;
	public static JTextArea resultado;
	public char modoVentana='C';
	
	public Factura fact = new Factura (
			0,//int idfactura,
			0,//int anofactura,
			0,//int facturascont,
			0.0F,//float totfactura,
			"",//String fechafact,
			"",//String nomempresa,
			"",//String direccempresa,
			"",//String cifempresa,
			"",//String personacontacto,
			"",//String telffaxempresa,
			0.0F,//float baseimponible,
			"",//String formaPago,
			""//String emailempresa
			);
	
	public FacturasDetalle[] factDtll = new FacturasDetalle[10] ;
	
	
		 public VentanaGestion(char modoVentana) {
		    	
		    	Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/logo_nowe.gif"));
		    			   
			    setIconImage(icon);
			    setSize(885,725); 
			    setTitle("Gestión de Facturas Nowe");
			    setLocationRelativeTo(null);
		        Panel p = new Panel(); 
				add(p); 
				this.modoVentana=modoVentana;	
				prepararVentana("C");
			    }

		 /**
		 * @return the modoVentana
		 */
		public char getModoVentana() {
			return modoVentana;
		}

		/**
		 * @param modoVentana the modoVentana to set
		 */
		public void setModoVentana(char modoVentana) {
			this.modoVentana = modoVentana;
		}
		
		
		


					
		class Panel extends JPanel implements ActionListener{


			 JScrollPane scrollArea;
			 private JTable tblgestion = null;
			 DefaultTableModel modelo = null;
			 
			 public Panel() {
				 
		    	 setLayout(null);
		    	 setSize(885,525);
		    	 setBackground(new Color(192,192,192));
		    	 scrollArea = new JScrollPane();
		    	
		    	
		    	 consulta=new JButton("Consultar");
		    	 consulta.setBounds(10,10,120,50); 
		         add(consulta);
		         consulta.addActionListener(this);
		         
		         generarFactura=new JButton("<html>Generar<br>Factura</html>");
		         generarFactura.setBounds(10,70,120,50);
		         add(generarFactura);
		         generarFactura.addActionListener(this);
		         
		         guardarFactura=new JButton("<html>Grabar<br>Factura</html>");
		         guardarFactura.setBounds(10,130,120,50);
		         add(guardarFactura);
		         guardarFactura.addActionListener(this);
		         
		         gmprimir=new JButton("Imprimir");
		         gmprimir.setBounds(10,190,120,50);
		         add(gmprimir);
		         gmprimir.addActionListener(this);
		         
		         anadirLinea=new JButton("<html>Añadir<br>línea</html>");
		         anadirLinea.setBounds(10,250,120,50);
		         add(anadirLinea);
		         anadirLinea.addActionListener(this);
		         
		         
		         modificar=new JButton("<html>Modificar</html>");
		         modificar.setBounds(10,310,120,50);
		         add(modificar);
		         modificar.addActionListener(this);
		         		         
		         limpiar=new JButton("Limpiar");
		         limpiar.setBounds(310,580,100,25);
		         add(limpiar);
		         limpiar.addActionListener(this); 
		         
		         cerrar=new JButton("Cerrar Conexión BD");
		         cerrar.setBounds(570,580,150,25);
		         add(cerrar);
		         cerrar.addActionListener(this);
		         
		         
		         lnumFactura=new JLabel("Número de Factura");
		         lnumFactura.setBounds(150,10,120,20);
		         add(lnumFactura);		         
		         
		         numFactura = new JTextField();
		         numFactura.setBounds(150,30,120,20);
		         add(numFactura);
		         
		         lfechaFactura=new JLabel("Fecha");
		         lfechaFactura.setBounds(290,10,120,20);
		         add(lfechaFactura);		         
		         
		         fechaFactura = new JTextField();
		         fechaFactura.setBounds(290,30,120,20);
		         add(fechaFactura);	
		         
		         lnombreEmpresa=new JLabel("Nombre empresa");
		         lnombreEmpresa.setBounds(430,10,120,20);
		         add(lnombreEmpresa);		         
		         
		         nombreEmpresa = new JTextField();
		         nombreEmpresa.setBounds(430,30,420,20);
		         add(nombreEmpresa);
		         
		         
		         ldireccionEmpresa=new JLabel("Dirección empresa");
		         ldireccionEmpresa.setBounds(150,50,120,20);
		         add(ldireccionEmpresa);		         
		         
		         direccionEmpresa = new JTextField();
		         direccionEmpresa.setBounds(150,70,420,20);
		         add(direccionEmpresa);		
		         
		         
		         lcifEempresa=new JLabel("CIF empresa");
		         lcifEempresa.setBounds(590,50,120,20);
		         add(lcifEempresa);		         
		         
		         cifEempresa = new JTextField();
		         cifEempresa.setBounds(590,70,120,20);
		         add(cifEempresa);	
		         
		         
		         ltelefonoEmpresa=new JLabel("Teléfono");
		         ltelefonoEmpresa.setBounds(730,50,120,20);
		         add(ltelefonoEmpresa);		         
		         
		         telefonoEmpresa = new JTextField();
		         telefonoEmpresa.setBounds(730,70,120,20);
		         add(telefonoEmpresa);		
		         
		         
		         lpersonaContacto=new JLabel("Persona de contacto");
		         lpersonaContacto.setBounds(150,90,120,20);
		         add(lpersonaContacto);		         
		         
		         personaContacto = new JTextField();
		         personaContacto.setBounds(150,110,420,20);
		         add(personaContacto);	
		         
		         
		         lemailEmpresa=new JLabel("Email");
		         lemailEmpresa.setBounds(590,90,120,20);
		         add(lemailEmpresa);		         
		         
		         emailEmpresa = new JTextField();
		         emailEmpresa.setBounds(590,110,263,20);
		         add(emailEmpresa);			         
		         
		         
		         
		         detalles=new JLabel("Detalles");
		         detalles.setBounds(450,630,50,10);
		         add(detalles); 
		         
		         
		         
		         resultado = new JTextArea();
		         resultado.setBackground(new Color(224,224,224));
		         resultado.setBounds(150,650,690,20); 
		         add(resultado);

		                
		         lcodigo=new JLabel("Código");
		         lcodigo.setBounds(150,160,120,20);
		         add(lcodigo);		         
		         
		         codigo = new JTextField();
		         codigo.setBounds(150,180,110,20);
		         add(codigo);	
		         
		         ldescripcion=new JLabel("Descripción");
		         ldescripcion.setBounds(260,160,120,20);
		         add(ldescripcion);		         
		         
		         descripcion = new JTextField();
		         descripcion.setBounds(260,180,360,20);
		         add(descripcion);		         
		         
		         
		         
		         lcantidad=new JLabel("Cantidad");
		         lcantidad.setBounds(620,160,120,20);
		         add(lcantidad);		         
		         
		         cantidad = new JTextField();
		         cantidad.setBounds(620,180,75,20);
		         add(cantidad);	
		         
		         lpreciounidad=new JLabel("Precio/u");
		         lpreciounidad.setBounds(695,160,120,20);
		         add(lpreciounidad);		         
		         
		         preciounidad = new JTextField();
		         preciounidad.setBounds(695,180,75,20);
		         add(preciounidad);			         
		         
		         
		         limporte=new JLabel("Importe");
		         limporte.setBounds(770,160,120,20);
		         add(limporte);		         
		         
		         importe = new JTextField();
		         importe.setBounds(770,180,77,20);
		         add(importe);	
		         
		         
		             
		         String[] columnas = {"Código", "Descripción", "Cantidad", "Precio/u", "Importe"};
		         tblgestion = new JTable();
		         modelo = new DefaultTableModel();
		         tblgestion.setBackground(new Color(224,224,224));
		         scrollArea.setViewportView(tblgestion);
		         scrollArea.setBounds(150,220,700,270); //posiciona dentro de la ventana
		         modelo.setColumnIdentifiers(columnas);
		         scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		         tblgestion.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		         tblgestion.setFillsViewportHeight(true);        
		         
		         tblgestion.setModel(modelo);
		         tblgestion.getColumnModel().getColumn(0).setPreferredWidth(50);
		         tblgestion.getColumnModel().getColumn(1).setPreferredWidth(300);
		         tblgestion.getColumnModel().getColumn(2).setPreferredWidth(10);
		         tblgestion.getColumnModel().getColumn(3).setPreferredWidth(10);
		         tblgestion.getColumnModel().getColumn(4).setPreferredWidth(10);
		         add(scrollArea, BorderLayout.NORTH);
		         
		         
		         
		         lformaDePago=new JLabel("Forma de Pago");
		         lformaDePago.setBounds(150,510,120,20);
		         add(lformaDePago);		         
		         
		         formaDePago = new JComboBox(); 
		         formaDePago.setBounds(150,530,200,20);
		         add(formaDePago);	
		         
		         
		         lbi=new JLabel("Base Imponible");
		         lbi.setBounds(370,510,120,20);
		         add(lbi);		         
		         
		         bi = new JTextField();
		         bi.setBounds(370,530,130,20);
		         add(bi);	
		         

		         liva=new JLabel("IVA");
		         liva.setBounds(520,510,120,20);
		         add(liva);		         
		         
		         iva = new JTextField();
		         iva.setBounds(520,530,130,20);
		         add(iva);	
		         
		         ltotal=new JLabel("Total");
		         ltotal.setBounds(670,510,120,20);
		         add(ltotal);		         
		         
		         total = new JTextField();
		         total.setBounds(670,530,130,20);
		         add(total);			         
		         
		         
	
		         
			 }
			 

		          
			 public void actionPerformed(ActionEvent e) {
		         	Object botonPulsado = e.getSource();
		         	
		             if (botonPulsado==consulta) {		
	
		            	 prepararVentana("C");
		            	 
		            	 Gestion.consultar(fact);

		            	 //Gestion.consultarDetalle(fact.getIdfactura(),factDtll, this);
		            	 
		            	 rellenarDatos();
		            	 
		            	 }
		             
		             
		             if (botonPulsado==modificar) {
		            	 prepararVentana("M");}
		             
		             
		             if (botonPulsado==limpiar) {
		            	 limpiarVentana();}
		             
		             if (botonPulsado==cerrar) {
		            	 
		            	
		            	 VentanaPrincipal.conexion.cerrarConexion();
		            	 resultado.setText("conexion cerrada");
		            	 
		             }
		            	 
		             
		             if (botonPulsado==gmprimir) {
		            	 
			            ///////////////////////////////////	
		                try {
							imprime();
						} catch (FileNotFoundException | DocumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	 
		             }
		             
		           }
		
			 public DefaultTableModel getModelo() {
				 return modelo;
			 }
			 public void setModelo(DefaultTableModel modelo) {
				 this.modelo = modelo;
			 }
			 
			 
		         }
		
		public void imprime() throws FileNotFoundException, DocumentException{
			 //VentanaGestion ventana = new VentanaGestion('G');
			 //ventana.setVisible(true);

			Factura facturaimp = new Factura(1, // int idfactura,
					2015, // int anofactura,
					1, // int facturascont,
					100, // float totfactura,
					"10/11/2015", // String fechafact,
					"Casa S.A.", // String nomempresa,
					"Antonio López 99", // String direccempresa,
					"A1234579", // String cifempresa,
					"Marcos Alonso", // String personacontacto,
					"98514414545", // String telffaxempresa,
					928, // float baseimponible,
					"En Efectivo", // String formaPago
					"juia@gajkl.es"// email
			);

			int lienasfactura = 2;

			FacturasDetalle[] facturaimpDetalle = new FacturasDetalle[lienasfactura];

			FacturasDetalle facturaimpDetalleVal = new FacturasDetalle(//1, // int
																			// idfacturasdetalle,
					"F3432C5", // String codproducto,
					"curso Java", // String descproducto,
					2, // int cantidad,
					8, // float preciounidad,
					99
			);

			FacturasDetalle facturaimpDetalleVal2 = new FacturasDetalle(//2, // int
																			// idfacturasdetalle,
					"F999C5", // String codproducto,
					"curso joomla", // String descproducto,
					1, // int cantidad,
					333, // float preciounidad,
					88
			);

			facturaimpDetalle[0] = facturaimpDetalleVal;
			facturaimpDetalle[1] = facturaimpDetalleVal2;
			
			
			
		  
			
			
						

			ImpresionFactura imp = new ImpresionFactura();
			imp.imprimir(facturaimp,facturaimpDetalle);
		}
		
		///////////////////////
		
		 public  void prepararVentana(String modoVentanta){
			 
			 if (modoVentanta.equals("C") ){
				 					 
				guardarFactura.setEnabled(false);	
				generarFactura.setEnabled(false);
				anadirLinea.setEnabled(false);	
				
				
				codigo.setVisible(false);				
				descripcion.setVisible(false);
				cantidad.setVisible(false);
				preciounidad.setVisible(false);
				importe.setVisible(false);				
				
				
				lcodigo.setVisible(false);
				ldescripcion.setVisible(false);
				lcantidad.setVisible(false);
				lpreciounidad.setVisible(false);
				limporte.setVisible(false);
				
				
				 
				 		 
			 }
			 if (modoVentanta.equals("G")){
				
					guardarFactura.setEnabled(true);	
					generarFactura.setEnabled(true);
				 
			 }
			 
			 if (modoVentanta.equals("M")){					

				 
				    guardarFactura.setEnabled(true);
				 
					codigo.setVisible(true);				
					descripcion.setVisible(true);
					cantidad.setVisible(true);
					preciounidad.setVisible(true);
					importe.setVisible(true);				
					
					
					lcodigo.setVisible(true);
					ldescripcion.setVisible(true);
					lcantidad.setVisible(true);
					lpreciounidad.setVisible(true);
					limporte.setVisible(true);
				 
			 }
			 
		 }
		 
		 public  void rellenarDatos(){
			 
			 numFactura.setText(  Integer.toString(fact.getIdfactura()) );
			 fechaFactura.setText( fact.getFechafact());
			 nombreEmpresa.setText(fact.getNomempresa());
			 direccionEmpresa.setText(fact.getDireccempresa());
			 cifEempresa.setText(fact.getCifempresa());
			 personaContacto.setText(fact.getPersonacontacto());
			 telefonoEmpresa.setText(fact.getTelffaxempresa());
			 emailEmpresa.setText(fact.getEmailempresa());
			 
			
			 
			 
		 }
		 	 
		 
		 public  void limpiarVentana(){
			 
			 numFactura.setText("");
			 fechaFactura.setText("");
			 nombreEmpresa.setText("");
			 direccionEmpresa.setText("");
			 cifEempresa.setText("");
			 personaContacto.setText("");
			 telefonoEmpresa.setText("");
			 emailEmpresa.setText("");
			 
			 
			 
		 }
}

