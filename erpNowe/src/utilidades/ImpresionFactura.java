package utilidades;

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
		  //número de factura que se saca de BD o se calcula 
		  String NUMERO = "Número:" + "2005/2222";
		  
		   
          Calendar fec = new GregorianCalendar();
          int año = fec.get(Calendar.YEAR);
          int mes = fec.get(Calendar.MONTH);
	      int dia = fec.get(Calendar.DAY_OF_MONTH);
	      String FECHATXT = "Fecha: " + dia + "/" + (mes+1) + "/" + año  ;
		  
		  
		  
		  try  {
		   
	      FileOutputStream archivo = new FileOutputStream("C:\\temp\\facturatmp.pdf");
	      Document documento = new Document();
	      
	      // Se asocia el documento al OutputStream y se indica que el espaciado entre
		  // lineas sera de 20. Esta llamada debe hacerse antes de abrir el docume
	      PdfWriter writer = PdfWriter.getInstance(documento, archivo);
	      
	        	      
	      documento.open();
	      
		  documento.add(new Paragraph(" "));
		  	      
	      try
	      {
	          Image foto = Image.getInstance("C:\\temp\\logoFactura.bmp");
	          foto.scaleToFit(100, 100);
	          foto.setAlignment(Chunk.ALIGN_LEFT);
	          documento.add(foto);
	      }
	      catch ( Exception e )
	      {
	          e.printStackTrace();
	      }
	      
	      
	      Chunk facturChunk = new Chunk(NUMERO,new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.WHITE));
	      facturChunk.setBackground(BaseColor.BLUE, 200f, 10f, 50f, 10f);	
	      
	      documento.add(facturChunk);
	      
	      documento.add(new Paragraph(" "));
	      
	      Chunk fechaChunk = new Chunk(FECHATXT,new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.WHITE));
	      fechaChunk.setBackground(BaseColor.BLUE, 200f, 10f, 50f, 10f);	      
	      documento.add(fechaChunk);
	      
	      documento.add(new Paragraph(" "));
	      
	      Paragraph datosClientetxt = new Paragraph("Datos del cliente:",
                  FontFactory.getFont("arial",   // fuente
                  15,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.CYAN)); // color
	      	     
	      datosClientetxt.setAlignment(Element.ALIGN_CENTER);
	      
	      documento.add(datosClientetxt);           
	      
	      
	      Paragraph nombreEmpresatxt = new Paragraph("Nombre de la empresa:" + "Marcos Lueje S.A.",
                  FontFactory.getFont("arial",   // fuente
                  12,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLACK)); // color
	      
	      nombreEmpresatxt.setAlignment(Element.ALIGN_CENTER);
	      
	      documento.add(nombreEmpresatxt);
	      
	      
	      Paragraph direcciontxt = new Paragraph("Dirección:" + "Antonio López 67",
                  FontFactory.getFont("arial",   // fuente
                  12,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLACK)); // color
	      
	      direcciontxt.setAlignment(Element.ALIGN_CENTER);
	      
	      documento.add(direcciontxt);
	      
	      Paragraph ciftxt = new Paragraph("C.I.F.:" + "10800136T",
                  FontFactory.getFont("arial",   // fuente
                  12,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLACK)); // color
	      
	      ciftxt.setAlignment(Element.ALIGN_CENTER);
	      
	      documento.add(ciftxt);	      
	      
	      
	      Paragraph personacontactotxt = new Paragraph("Persona de contacto:" + "Sonia Cuervo",
                  FontFactory.getFont("arial",   // fuente
                  12,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLACK)); // color
	      personacontactotxt.setAlignment(Element.ALIGN_CENTER);
	      documento.add(personacontactotxt);	      	      
	      
	      
	      Paragraph telefonoFaxtxt = new Paragraph("Teléfono/Fax:" + "985144095",
                  FontFactory.getFont("arial",   // fuente
                  12,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLACK)); // color
	      telefonoFaxtxt.setAlignment(Element.ALIGN_CENTER);
	      documento.add(telefonoFaxtxt);	 
	      
	      Paragraph correoElectronicoxtxt = new Paragraph("Correo electrónico::" + "mluejeal@gmial.com",
                  FontFactory.getFont("arial",   // fuente
                  12,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.BLACK)); // color
	      correoElectronicoxtxt.setAlignment(Element.ALIGN_CENTER);
	      documento.add(correoElectronicoxtxt);	
	      
	      documento.add(new Paragraph(" "));
	      documento.add(new Paragraph(" "));
	      
	      Paragraph datosTrabajotxt = new Paragraph("Datos del trabajo:",
                  FontFactory.getFont("arial",   // fuente
                  15,                            // tamaño
                  Font.ITALIC,                   // estilo
                  BaseColor.CYAN)); // color
	      	      
	      documento.add(datosTrabajotxt);  
	      
	      documento.add(new Paragraph(" "));
	      
	      
	      /*-----------------------------------------------------------*/
		    PdfPTable table = new PdfPTable(5);
		    table.setWidthPercentage(100);
		    table.setTotalWidth(90);
		    //Añadir CABECERA
		    PdfPCell cell = new PdfPCell(new Phrase("xxxxx"));
		    cell.setColspan(5);
		    cell.setBackgroundColor(BaseColor.GRAY);
		    table.addCell(cell);
		    //Añadir dos filas de celdas sin formato
		    
		    PdfPCell cellcodigo = new PdfPCell(new Phrase("Código"));
		    cellcodigo.setBackgroundColor(BaseColor.BLUE);		    
		    table.addCell(cellcodigo);
		    
		    PdfPCell celldescripcion = new PdfPCell(new Phrase("Descripción"));
		    celldescripcion.setBackgroundColor(BaseColor.BLUE);		    
		    table.addCell(celldescripcion);		    
		    
		    PdfPCell cellcant = new PdfPCell(new Phrase("Cant."));
		    cellcant.setBackgroundColor(BaseColor.BLUE);		    
		    table.addCell(cellcant);				    
		    
		    PdfPCell cellpreciou = new PdfPCell(new Phrase("Precio/u."));
		    cellpreciou.setBackgroundColor(BaseColor.BLUE);		    
		    table.addCell(cellpreciou);
		    
		    PdfPCell cellimporteeur = new PdfPCell(new Phrase("Importe (€)"));
		    cellimporteeur.setBackgroundColor(BaseColor.BLUE);		    
		    table.addCell(cellimporteeur);
	
	
	        for (int i=0; i < 10; i++){
	        	
			    table.addCell(i+".1");
			    table.addCell(i+".2");
			    table.addCell(i+".3");
			    table.addCell(i+".4");
			    table.addCell(i+".5");
	        	
	        }	    
		    

		    
		    
		
		    documento.add(table);
	    /*-----------------------------------------------------------*/
	      
	      
		  //--------------------------------------------------------
	        PdfContentByte cb = writer.getDirectContent();
	        BaseFont bf = BaseFont.createFont();
	        
	        cb.beginText();
	        cb.setFontAndSize(bf, 6);
	        cb.setTextMatrix(0, 1, -1, 0, 20, 50);
	        cb.showText(TEXTOLATERAL);
	        
	        //--------------------------------------------------------
	        	    		   
		   
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    documento.add(new Paragraph(" "));
		    
		      Paragraph texfinal = new Paragraph(TEXTOFINAL,
	                  FontFactory.getFont("arial",   // fuente
	                  9,                            // tamaño
	                  Font.ITALIC,                   // estilo
	                  BaseColor.BLACK)); // color
		      	      
		      documento.add(texfinal);   
	
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

 
