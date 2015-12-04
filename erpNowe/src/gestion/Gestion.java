package gestion;

import java.sql.ResultSet;
import java.sql.SQLException;


import matricula.VentanaMatricula;
import ventanaPrincipal.VentanaPrincipal;



public class Gestion {
	
	//static ResultSet datos = null;
	
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
	
	public static String consultarDetalle(int numfact,FacturasDetalle factDtll){
		
		
		ResultSet datos;
		datos = VentanaPrincipal.conexion.getQuery("select * from facturasdetalle where fk_idfactura=1" );
	    
	    try {
	    		    
	      while(datos.next()){
	    	  


	    	  	
	    	  }
	    	  
	      }
	
		catch(Exception e){ e.printStackTrace(); }
		return "S";
		
	}
	
	
	public static String insertar(Factura fact,FacturasDetalle factDtll){
		 
		boolean ok = false;
		 
		String resultado = null;
		 
		try {
				 ok = VentanaPrincipal.conexion.setQuery("INSERT INTO matricula (idMatricula,idAlumno, idGrupo,FormaPago,Desempleado,Promociones,Pagado)");
						//+ " VALUES ('" +idMatricula+"','"+ idAlumno + "','" + idGrupo + "','"+FormaPago+  "','"+Desempleado+ "','"+Promociones+ "','"+  Pagado +"')");
				 if (ok) 
					 resultado = "Se insertó la matricula correctamente";
				 else 
					resultado = "No se pudo insertar la matricula";	 
		} 
		 
		catch(Exception e){ e.printStackTrace(); }
		return resultado;
	}
	
	


}
