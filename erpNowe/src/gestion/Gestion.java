package gestion;

import java.sql.ResultSet;
import gestion.VentanaGestion.Panel;
import ventanaPrincipal.VentanaPrincipal;



public class Gestion {
	
	
	public Gestion(){
		super();
	}
	
	
	public static String consultar(Factura fact){
		
	
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("select * from facturas" );
	    
	    try {
	    		    
	      while(datos.next()){
	    	  
	    	  fact.setIdfactura(Integer.parseInt(datos.getString("idfactura") ) );
	    	  fact.setAnoFactura(     (Integer.parseInt(datos.getString("anofactura"))   ) ) ;
	    	  fact.setFacturasCont(   (Integer.parseInt(datos.getString("facturascont")) ) );
	    	  fact.setTotFactura(     (Float.parseFloat(datos.getString("totfactura")) ) );
	    	  fact.setFechafact(   datos.getString("fechafact")   );
	    	  fact.setNomempresa(datos.getString("nomempresa") );
	    	  fact.setDireccempresa(datos.getString("direccempresa") );
	    	  fact.setCifempresa(datos.getString("cifempresa") );
	    	  fact.setPersonacontacto(datos.getString("personacontacto") );
	    	  fact.setTelffaxempresa(datos.getString("telffaxempresa") );
	    	  fact.setEmailempresa(datos.getString("emailempresa") );	    	  
	    	  fact.setBaseimponible( (Float.parseFloat(datos.getString("baseimponible")) ));
	    	  fact.setFormaPago(datos.getString("formaPago") );;

	    	  	
	    	  }
	    	  
	      }
	
		catch(Exception e){ e.printStackTrace(); }
		return "S";
		
	}
	
	public static String consultarDetalle(int numfact,FacturasDetalle[] factDtll,Panel panel){
		
		
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("select codproducto,descproducto,cantidad,preciounidad,importe from facturasdetalle where fk_idfactura="+ numfact);
	    int i = 0;
	    try {
	    		    
	      while(datos.next()){
	    	  factDtll[i].setCodproducto("codproducto"); 
	    	  factDtll[i].setDescproducto("descproducto");
	    	  factDtll[i].setCantidad(Integer.parseInt("cantidad"));
	    	  factDtll[i].setPreciounidad(Float.parseFloat("preciounidad"));
	    	  factDtll[i].setImporte(Float.parseFloat("importe"));
	    	  panel.getModelo().addRow(new Object[] {factDtll[i].getCodproducto(),
	    			  								factDtll[i].getDescproducto(),
	    			  								factDtll[i].getCantidad(),
	    			  								factDtll[i].getPreciounidad(),
	    			  								factDtll[i].getImporte()});
	    	  i++;
	    	  	
	    	  
	    	  }
	    	  
	      }
	
		catch(Exception e){ e.printStackTrace(); }
		return "S";
		
	}
	
	
	public static String insertar(Factura fact,FacturasDetalle[] factDtll){
		 
		boolean okf = false;
		boolean okdf = false;
		int  lienasfactura =2;
	      
	      FacturasDetalle[] facturaimpDetalle = new FacturasDetalle[lienasfactura];
	      
	/*      FacturasDetalle   facturaimpDetalleVal =  new FacturasDetalle(1,//int idfacturasdetalle,
																		"F3432C5",//String codproducto,
																		"curso Java",//String descproducto,
																		2,//int cantidad,
																		8,//float preciounidad,
																		99,//float importe,
																		1//int fk_idfactura
																		);
	      
	      FacturasDetalle   facturaimpDetalleVal2 =  new FacturasDetalle(2,//int idfacturasdetalle,
					"F999C5",//String codproducto,
					"curso joomla",//String descproducto,
					1,//int cantidad,
					333,//float preciounidad,
					88,//float importe,
					1//int fk_idfactura
					);
	      
	      factDtll[0]=facturaimpDetalleVal;
	      factDtll[1]=facturaimpDetalleVal2;*/
	      
		//System.out.println(factDtll[0].getCodproducto());
		String resultado = null;
		/*Insertar los campos de factura, con el objeto fact llamo a los métodos de los atributos */
		try {
				 okf = VentanaPrincipal.conexion.setQuery("INSERT INTO facturas "
				 		+ "( anofactura, facturascont, totfactura, fechafact, nomempresa, direccempresa, cifempresa, personacontacto, telffaxempresa, baseimponible, formaPago, emailempresa) "
				 		+ "VALUES ("+ fact.getAnoFactura()+","+ fact.getFacturasCont() +","+ fact.getTotFactura() + ",'"+ fact.getFechafact()+"','"+ fact.getNomempresa() +"','"+ fact.getDireccempresa() +"', '"
				 		+ fact.getCifempresa()+"','"+ fact.getPersonacontacto()+"','"+ fact.getTelffaxempresa()+"',"+ fact.getBaseimponible()+",'"+ fact.getFormaPago()+"','"+ fact.getEmailempresa()+"');");
				 if (okf)
					 resultado = "Se insertó la factura correctamente";
				 else 
					resultado = "No se pudo insertar la factura";	 
		} 
		 
		catch(Exception e){ e.printStackTrace(); }
		
		
		/*Insertar los campos de detallefactura, con el objeto factDtll llamo a los métodos de los atributos */
		try {
			for(int i = 0;i < factDtll.length; i++){
			 okdf = VentanaPrincipal.conexion.setQuery("INSERT INTO facturasdetalle (	codproducto,descproducto,"
			 		+ " cantidad,preciounidad,importe,fk_idfactura) "
			 		+ "VALUES (factDtll[i].getCodproducto()  ,factDtll[i].getDescproducto(),"
			 		+ "factDtll[i].getCantidad(),factDtll[i].getPreciounidad(),factDtll[i].getImporte(),factDtll[i].getFk_idfactura() );");
			 if (okdf) 
				 resultado = "Se insertaron los detalles de la factura correctamente";
			 else 
				resultado = "No se pudieron insertar los detalles de factura";	 }
	} 
	 
	catch(Exception e){ e.printStackTrace(); }
		return resultado;
	}
	
	


}
