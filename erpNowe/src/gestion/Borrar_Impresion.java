package gestion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Impresion {
	
	   public static void main(String[] a3d) throws FileNotFoundException, DocumentException
	   {
		   
		   
		   
		  try  {
		   
	      FileOutputStream archivo = new FileOutputStream("C:\\temp\\hola.pdf");
	      Document documento = new Document();
	      PdfWriter.getInstance(documento, archivo);
	      
	      // Se asocia el documento al OutputStream y se indica que el espaciado entre
		  // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
		  PdfWriter.getInstance(documento,archivo).setInitialLeading(20);
	      
	      
	      documento.open();
	      
	      try
	      {
	          Image foto = Image.getInstance("C:\\temp\\logonowe.gif");
	          foto.scaleToFit(100, 100);
	          foto.setAlignment(Chunk.ALIGN_MIDDLE);
	          documento.add(foto);
	      }
	      catch ( Exception e )
	      {
	          e.printStackTrace();
	      }
	      
	      
	      

	      PdfPTable tabla = new PdfPTable(3);
	      for (int i = 0; i < 15; i++)
	      {
	          tabla.addCell("celda " + i);
	      }
	      documento.add(tabla);
	      

	      Paragraph parrafo2 = new Paragraph("nuestro segundo Texto");
	      parrafo2.setAlignment(1);//el 1 es para centrar
	      documento.add(parrafo2);
	      
	      //si queremos un salto de linea una opción es agregar un párrafo que tenga al menos un espacio.

	      documento.add(new Paragraph(" "));
	      
	      
	     // Para una tabla hacemos lo siguiente:

	    	  PdfPTable tabla4 = new PdfPTable(3);
	    	      //el numero indica la cantidad de Columnas
	    	  tabla4.addCell("celda1");
	    	  tabla4.addCell("celda2");
	    	  tabla4.addCell("celda3");
	    	  tabla4.addCell("celda4");
	    	  tabla4.addCell("celda5");
	    	  tabla4.addCell("celda6");
	    	      // esto nos crea una tabla de 3 Columnas por 2 Filas
	    	  documento.add(tabla4);
	    	// Para una tabla hacemos lo siguiente:
	    	  
	    	  
	    	     // esto nos crea una tabla de 3 Columnas por dos Filas
	    	    documento.add(tabla);
	    	    documento.add(new Paragraph(" "));
	    	    PdfPTable tabla2 = new PdfPTable(3);
	    	    PdfPCell celda = new PdfPCell(
	    	                       new Paragraph("celda \nmodificada")
	    	                                 );
	    	    celda.setColspan(2);
	    	   //cantidad de columnas que ocupa esta celda
	    	    celda.setRowspan(2);
	    	   //cantidad de filas que ocupa esta celda
	    	    tabla2.addCell(celda);
	    	    tabla2.addCell("celda5");
	    	    tabla2.addCell("celda6");
	    	    tabla2.addCell("celda7");
	    	    tabla2.addCell("celda8");
	    	    tabla2.addCell("celda9");
	    	    documento.add(tabla2);
	      
	      

	      documento.add(new Paragraph("Hola Mundo!purue"));
	      documento.add(new Paragraph("SoloInformaticaYAlgoMas.blogspot.com"));
	      
	      documento.add(new Paragraph("Esto es el primer párrafo, normalito"));
	      
	      documento.add(new Paragraph("Este es el segundo y tiene una fuente rara",
	                      FontFactory.getFont("arial",   // fuente
	                      22,                            // tamaño
	                      Font.ITALIC,                   // estilo
	                      BaseColor.CYAN)));             // color
	      
	      
	      documento.close();

	    
	      // Se abre el documento.
	      //documento.open();
	      
	   }
	   catch (Exception ex) 
	   {
	    System.out.println(ex.toString());
	   }
	   
	   }
	   
	   
	   
}

 
