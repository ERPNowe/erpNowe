/**
 * Clase Principal
 * @author curso14/7803
 * @version 1.0
 * @since 19/11/2015
 * <br>
 * <p> 
 * Desde aqui se prueba el funcionamiento de la pantalla principal del programa y su menú.
 * </p> 
 */

package ventanaPrincipal;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {

		VentanaPrincipal ventana = new VentanaPrincipal();		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

	}

}
