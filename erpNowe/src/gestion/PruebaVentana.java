package gestion;



import java.io.FileNotFoundException;



import com.itextpdf.text.DocumentException;

import gestion.ImpresionFactura;

public class PruebaVentana {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {

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
	
	

}
