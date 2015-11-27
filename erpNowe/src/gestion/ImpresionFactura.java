package gestion;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class ImpresionFactura {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] a3d) throws FileNotFoundException, DocumentException
	   {
		   
		  final String TEXTOFINAL = "Puede realizar el pago por transferencia bancaria a la cuenta ES86 2038 1927 88 6000173219,a nombre de NOWE CREATIVE FORMACIÓN Y DISEÑO, S,L. - C/ Melilla 5.";
		  final String TEXTOLATERAL ="NOWE CREATIVE FORMACIÓN Y DISEÑO S.L. CIF: B86250784 . Registro mercantil de Madrid. Tomo 29028. Libro 0. Folio 64. Sección 8. Hoja M522749. Inscripción 1";
		  final int TOTALLINEASTABLA=3;
		  //número de factura que se saca de BD o se calcula 
		  
		  
		   

		  
	      
	      Factura facturaimp = new Factura(	1,//int idfactura, 
	    		  							2015,//int anofactura, 
	    		  							1,//int facturascont, 
	    		  							100,//float totfactura, 
	    		  							"10/11/2015",//String fechafact, 
	    		  							"Casa S.A.",//String nomempresa,
	    		  							"Antonio López 99",//String direccempresa, 
	    		  							"A1234579",//String cifempresa, 
	    		  							"Marcos Alonso",//String personacontacto, 
	    		  							"98514414545",//String telffaxempresa, 
	    		  							928,//float baseimponible,
	    		  							"En Efectivo",//String formaPago
	    		  							"juia@gajkl.es"
	    		  							);
	      
	      
	      int  lienasfactura =2;
	      
	      FacturasDetalle[] facturaimpDetalle = new FacturasDetalle[lienasfactura];
	      
	      FacturasDetalle   facturaimpDetalleVal =  new FacturasDetalle(1,//int idfacturasdetalle,
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
	      
	      facturaimpDetalle[0]=facturaimpDetalleVal;
	      facturaimpDetalle[1]=facturaimpDetalleVal2;
	      
	          
	      String NUMERO =  facturaimp.getAnoFactura() + "/" + facturaimp.getFacturasCont();
	     
	      
          Calendar fec = new GregorianCalendar();
          int año = fec.get(Calendar.YEAR);
          int mes = fec.get(Calendar.MONTH);
	      int dia = fec.get(Calendar.DAY_OF_MONTH);
	      String FECHATXT = dia + "/" + (mes+1) + "/" + año  ;                   
		  
		  
		  try  {
		   
	      FileOutputStream archivo = new FileOutputStream("C:\\temp\\facturatmp.pdf");
	      Document documento = new Document();
	     
	      // Se asocia el documento al OutputStream y se indica que el espaciado entre
		  // lineas sera de 20. Esta llamada debe hacerse antes de abrir el docume
	      PdfWriter writer = PdfWriter.getInstance(documento, archivo);
	      
	        	      
	      documento.open();
	     
		  	      
	      try
	      {
	          Image foto = Image.getInstance("C:\\temp\\cabfact.png");
	          foto.scaleToFit(600, 600);
	          foto.setAbsolutePosition(0, 700);
	          foto.setAlignment(Chunk.ALIGN_LEFT);	 
	          documento.add(foto);
	      }
	      catch ( Exception e )
	      {
	          e.printStackTrace();
	      }
	      
	      
	      try
	      {
	          Image foto = Image.getInstance("C:\\temp\\piepagina.png");
	          foto.scaleToFit(600, 600);
	          foto.setAbsolutePosition(0, 0);
	          foto.setAlignment(Chunk.ALIGN_LEFT);	 
	          documento.add(foto);
	      }
	      catch ( Exception e )
	      {
	          e.printStackTrace();
	      }
	      
	      try
	      {
	          Image foto = Image.getInstance("C:\\temp\\totales.png");
	          foto.scaleToFit(500, 500);
	          foto.setAbsolutePosition(50, 120);
	          foto.setAlignment(Chunk.ALIGN_LEFT);	 
	          documento.add(foto);
	      }
	      catch ( Exception e )
	      {
	          e.printStackTrace();
	      }
	      	      
	      
	  
	      
	      
    		//--------------------------------------------------------
	        PdfContentByte cb = writer.getDirectContent();
	        BaseFont bf = BaseFont.createFont(); 
	        
	        //-------------------------------------------------------	
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(495, 769);
	        cb.setFontAndSize(bf, 8);
	        cb.showText(NUMERO);
	        cb.endText();
	        cb.restoreState();
	        
	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(495, 755);
	        cb.setFontAndSize(bf, 8);
	        cb.showText(FECHATXT);
	        cb.endText();
	        cb.restoreState();
	        //--------------------------------------------------------

	        
	  
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(120, 700);
	        cb.setFontAndSize(bf, 17);
	        cb.showText("Datos del cliente:");
	        cb.endText();
	        cb.restoreState();

	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(130, 675);
	        cb.setFontAndSize(bf, 12);
	        cb.showText("Nombre de la empresa:    " + facturaimp.getNomempresa());
	        cb.endText();
	        cb.restoreState();
          
	        
	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(130, 655);
	        cb.setFontAndSize(bf, 12);
	        cb.showText("Dirección:               " + facturaimp.getDireccempresa());	        
	        cb.endText();
	        cb.restoreState();
	        
	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(130, 635);
	        cb.setFontAndSize(bf, 12);
	        cb.showText("C.I.F. :                 " + facturaimp.getCifempresa());	        
	        cb.endText();
	        cb.restoreState();	  
	        
	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(130, 615);
	        cb.setFontAndSize(bf, 12);
	        cb.showText("Persona de contacto :     " + facturaimp.getPersonacontacto());	        
	        cb.endText();
	        cb.restoreState();	        
	      
	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(130, 595);
	        cb.setFontAndSize(bf, 12);
	        cb.showText("Teléfono/Fax :           " + facturaimp.getTelffaxempresa());	        
	        cb.endText();
	        cb.restoreState();	
	        
	        
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(130, 575);
	        cb.setFontAndSize(bf, 12);
	        cb.showText("Correo electrónico :     " + facturaimp.getTelffaxempresa());	        
	        cb.endText();
	        cb.restoreState();		        
	        
	        
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        
	        
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        documento.add(new Paragraph(" "));
	        
	      
	      Paragraph datosTrabajotxt = new Paragraph("Datos del trabajo:",
                  FontFactory.getFont("arial",   // fuente
                  15,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLUE)); // color
	      	      
	      documento.add(datosTrabajotxt);  
	      
	      documento.add(new Paragraph(" "));
	      
	      
	      /*-----------------------------------------------------------*/
		    PdfPTable table = new PdfPTable(5);
		    table.setWidthPercentage(100);
		    table.setTotalWidth(90);
		    
		    float[] columnWidths = new float[] {10f, 40f, 6f, 13f,13f};
            table.setWidths(columnWidths);
		    
		    //Añadir CABECERA
		    //PdfPCell cell = new PdfPCell(new Phrase("xxxxx"));
		    //cell.setColspan(5);
		    //cell.setBackgroundColor(BaseColor.GRAY);
		    //table.addCell(cell);
		    //Añadir dos filas de celdas sin formato
		    
		      
		    
		    PdfPCell cellcodigo = new PdfPCell(new Phrase("Código"));
		    cellcodigo.setBackgroundColor(BaseColor.GRAY);		    
		    table.addCell(cellcodigo);
		    
		    PdfPCell celldescripcion = new PdfPCell(new Phrase("Descripción"));
		    celldescripcion.setBackgroundColor(BaseColor.GRAY);		    
		    table.addCell(celldescripcion);		    
		    
		    PdfPCell cellcant = new PdfPCell(new Phrase("Cant."));
		    cellcant.setBackgroundColor(BaseColor.GRAY);		    
		    table.addCell(cellcant);				    
		    
		    PdfPCell cellpreciou = new PdfPCell(new Phrase("Precio/u."));
		    cellpreciou.setBackgroundColor(BaseColor.GRAY);		    
		    table.addCell(cellpreciou);
		    
		    PdfPCell cellimporteeur = new PdfPCell(new Phrase("Importe (€)"));
		    cellimporteeur.setBackgroundColor(BaseColor.GRAY);		    
		    table.addCell(cellimporteeur);
	
		    Font font = new Font(FontFamily.COURIER, 10, Font.ITALIC);
		    
	        for (int i=0; i <= lienasfactura -1; i++){
	        	
        	
			    //table.addCell(facturaimpDetalle[i].getCodproducto());
			    
			    Paragraph para1 = new Paragraph(facturaimpDetalle[i].getCodproducto() , font );
		        PdfPCell cell1 = new PdfPCell();		        
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.addElement(para1);
		        cell1.setBorderWidthTop(0);
		        cell1.setBorderWidthBottom(0);
		        cell1.setBorderWidthLeft(1);
		        cell1.setBorderWidthRight(0);		        	        
		        table.addCell(cell1);			    
			    
			    
			    //table.addCell(facturaimpDetalle[i].getDescproducto());
			    
			    Paragraph para2 = new Paragraph(facturaimpDetalle[i].getDescproducto() , font );
		        PdfPCell cell2 = new PdfPCell();		        
		        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell2.addElement(para2);
		        cell2.setBorderWidthTop(0);
		        cell2.setBorderWidthBottom(0);
		        cell2.setBorderWidthLeft(1);
		        cell2.setBorderWidthRight(0);
		        	        
		        table.addCell(cell2);
			    
			    
		      //table.addCell( Integer.toString(facturaimpDetalle[i].getCantidad()) );

			    Paragraph para3 = new Paragraph(Integer.toString(facturaimpDetalle[i].getCantidad()) , font );
		        PdfPCell cell3 = new PdfPCell();		        
		        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell3.addElement(para3);
		        cell3.setBorderWidthTop(0);
		        cell3.setBorderWidthBottom(0);
		        cell3.setBorderWidthLeft(1);
		        cell3.setBorderWidthRight(0);		        		        
		        table.addCell(cell3);
		        
		        //table.addCell( Float.toString(  facturaimpDetalle[i].getPreciounidad()));

			    Paragraph para4 = new Paragraph(Float.toString(  facturaimpDetalle[i].getPreciounidad()) , font );
		        PdfPCell cell4 = new PdfPCell();		        
		        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell4.addElement(para4);
		        cell4.setBorderWidthTop(0);
		        cell4.setBorderWidthBottom(0);
		        cell4.setBorderWidthLeft(1);
		        cell4.setBorderWidthRight(0);		        		        
		        table.addCell(cell4);
			    
			    
			    
			    
			    //table.addCell( Float.toString(  facturaimpDetalle[i].getImporte()));
			    
			    
			    Paragraph para5 = new Paragraph(  Float.toString(  facturaimpDetalle[i].getImporte())  , font );
		        PdfPCell cell5 = new PdfPCell();		        
		        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell5.addElement(para5);
		        cell5.setBorderWidthTop(0);
		        cell5.setBorderWidthBottom(0);
		        cell5.setBorderWidthLeft(1);
		        cell5.setBorderWidthRight(1);		        		        
		        table.addCell(cell5);			    
	        	
	        }	    
		    
	        
	       
	        
	        
	        for (int i=0; i <= (TOTALLINEASTABLA - lienasfactura) ; i++){
	        	
			    //table.addCell(facturaimpDetalle[i].getCodproducto());
		        Paragraph vacio = new Paragraph(  " "  , font );
		        PdfPCell cellvacia = new PdfPCell();
				        		        
	        	cellvacia.addElement(vacio);
	        	cellvacia.setBorderWidthTop(0);
	        	cellvacia.setBorderWidthBottom(0);
	        	cellvacia.setBorderWidthLeft(1);
	        	cellvacia.setBorderWidthRight(0);		        	        
		        table.addCell(cellvacia);			    
			    
			    
			    //table.addCell(facturaimpDetalle[i].getDescproducto());
			    

		        
	
		        cellvacia.addElement(vacio);
		        cellvacia.setBorderWidthTop(0);
		        cellvacia.setBorderWidthBottom(0);
		        cellvacia.setBorderWidthLeft(1);
		        cellvacia.setBorderWidthRight(0);
		        	        
		        table.addCell(cellvacia);
			    

		        cellvacia.addElement(vacio);
		        cellvacia.setBorderWidthTop(0);
		        cellvacia.setBorderWidthBottom(0);
		        cellvacia.setBorderWidthLeft(1);
		        cellvacia.setBorderWidthRight(0);		        		        
		        table.addCell(cellvacia);
		        


		        cellvacia.addElement(vacio);
		        cellvacia.setBorderWidthTop(0);
		        cellvacia.setBorderWidthBottom(0);
		        cellvacia.setBorderWidthLeft(1);
		        cellvacia.setBorderWidthRight(0);		        		        
		        table.addCell(cellvacia);
			    

			        
		        cellvacia.addElement(vacio);
		        cellvacia.setBorderWidthTop(0);
		        cellvacia.setBorderWidthBottom(0);
		        cellvacia.setBorderWidthLeft(1);
		        cellvacia.setBorderWidthRight(1);		        		        
		        table.addCell(cellvacia);			 
	        	
	        }
		    
	        
	        
		    //table.addCell(facturaimpDetalle[i].getCodproducto());
	        Paragraph vacio = new Paragraph(  " "  , font );
	        PdfPCell cellvacia = new PdfPCell();
			        		        
        	cellvacia.addElement(vacio);
        	cellvacia.setBorderWidthTop(0);
        	cellvacia.setBorderWidthBottom(1);
        	cellvacia.setBorderWidthLeft(1);
        	cellvacia.setBorderWidthRight(0);		        	        
	        table.addCell(cellvacia);			    
		    
		    
		    //table.addCell(facturaimpDetalle[i].getDescproducto());
		    

	        

	        cellvacia.addElement(vacio);
	        cellvacia.setBorderWidthTop(0);
	        cellvacia.setBorderWidthBottom(1);
	        cellvacia.setBorderWidthLeft(1);
	        cellvacia.setBorderWidthRight(0);
	        	        
	        table.addCell(cellvacia);
		    

	        cellvacia.addElement(vacio);
	        cellvacia.setBorderWidthTop(0);
	        cellvacia.setBorderWidthBottom(1);
	        cellvacia.setBorderWidthLeft(1);
	        cellvacia.setBorderWidthRight(0);		        		        
	        table.addCell(cellvacia);
	        


	        cellvacia.addElement(vacio);
	        cellvacia.setBorderWidthTop(0);
	        cellvacia.setBorderWidthBottom(1);
	        cellvacia.setBorderWidthLeft(1);
	        cellvacia.setBorderWidthRight(0);		        		        
	        table.addCell(cellvacia);
		    

		        
	        cellvacia.addElement(vacio);
	        cellvacia.setBorderWidthTop(0);
	        cellvacia.setBorderWidthBottom(1);
	        cellvacia.setBorderWidthLeft(1);
	        cellvacia.setBorderWidthRight(1);		        		        
	        table.addCell(cellvacia);	
		    
		
		    documento.add(table);
		    
	    /*------------Fomra de pago-------------------*/
	          
		    //cb.roundRectangle(35f, 140f, 150f, 70f, 20f);
		    //cb.stroke();
		    
	        cb.saveState();
	        cb.beginText();
	        cb.moveText(70, 155);
	        cb.setFontAndSize(bf, 12);
	        cb.showText(facturaimp.getFormaPago());
	        cb.endText();
	        cb.restoreState();
	        
	      /*------------Fomra de pago-------------------*/	        
	        
	  
		    
		
	      
		  //--------------------------------------------------------
	      //  PdfContentByte cb = writer.getDirectContent();
	      //  BaseFont bf = BaseFont.createFont();
	        
	        cb.beginText();
	        cb.setFontAndSize(bf, 6);
	        cb.setTextMatrix(0, 1, -1, 0, 20, 50);
	        cb.showText(TEXTOLATERAL);
	        
	        //--------------------------------------------------------
	        	    		   
		   
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    
		     // Paragraph texfinal = new Paragraph(TEXTOFINAL,
		    //         FontFactory.getFont("arial",   // fuente
		    //         7,                            // tamaño
		    //         Font.ITALIC,                   // estilo
		    //         BaseColor.BLACK)); // color
		      	      
		    //  documento.add(texfinal);   
	
		  cb.endText();
		  documento.close(); 
		  System.out.print( documento.isOpen());
		  
		  
	      
	   }
	   catch (Exception ex) 
	   {
	    System.out.println(ex.toString());
	   }
	   
	   }
	


	   
}


 
