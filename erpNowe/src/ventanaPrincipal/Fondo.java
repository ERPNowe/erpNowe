/**
 * Clase Fondo
 * @author curso14/7803
 * @version 1.0
 * @since 19/11/2015
 * <br>
 * <p> 
 * Esta clase corresponde a la creación del fondo para la pantalla principal.
 * </p> 
 */

package ventanaPrincipal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class Fondo extends JDesktopPane  {
	
	private Image imagen;
	
	public Fondo() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(null); 
	    this.setToolTipText("ERP Nowe");
	    this.setBounds(0, 0, screenSize.width, screenSize.height);
	    
	    try {
	        imagen = ImageIO.read(getClass().getResource("/img/fondo_ventana_principal.png"));
	   }
	  catch (IOException e) {
	    e.printStackTrace();
	   }

	}
	
	public void paintComponent(Graphics g){
		  
	   
	   Toolkit t = Toolkit.getDefaultToolkit();
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    
	   g.drawImage(imagen, 0, 0,screenSize.width, screenSize.height, null);
	   setOpaque(false);
	   
	   super.paintComponent(g);
	 }
	

}
