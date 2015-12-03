package gestion;

import java.sql.ResultSet;
import java.sql.SQLException;

import gestion.VentanaGestion.Panel;
import matricula.VentanaMatricula;
import ventanaPrincipal.VentanaPrincipal;



public class Gestion {
	
	//static ResultSet datos = null;
	
	public Gestion(Panel panel){
		super();
	}
	
	
	public static String consultar(Factura fact,FacturasDetalle factDtll){
		
	
		ResultSet datos;
	    //String idMatricula, idAlumno1, idGrupo, FormaPago, desempleado,promociones, Pagado,resultado ="";
		  // String usuario = "root";
		  // String pwd = "";
		  // String bd = "nowedb";
		  // basedatos.ConexionBaseDatos conexion = null;
		//conexion = new basedatos.ConexionBaseDatos(bd, usuario, pwd);
		//System.out.print(conexion);
		datos = VentanaPrincipal.conexion.getQuery("select idfactura from facturas" );
	    
	    try {
	    		    
	      while(datos.next()){
	    	  
	    	  fact.setIdfactura(Integer.parseInt(datos.getString("idfactura") ) );
	    	  	
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
