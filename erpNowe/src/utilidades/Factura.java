package utilidades;

/**
 * @author  Marcos Lueje Alonso
 * @since 20/11/2015
 * @version 1.0
*/

public class Factura {

	private int idfactura;
	private int anofactura;
	private int facturascont;
	private float totfactura = 0.0F;
	private String fechafact;
	private String nomempresa;
	private String direccempresa;
	private String cifempresa;
	private String personacontacto;
	private String telffaxempresa;
	private float baseimponible = 0.0F;
	private String formaPago;
	
	
	public void Factura(int idfactura,
						int anofactura,
						int facturascont,
						float totfactura,
						String fechafact,
						String nomempresa,
						String direccempresa,
						String cifempresa,
						String personacontacto,
						String telffaxempresa,
						float baseimponible,
						String formaPago
						){
		this.idfactura = idfactura ;
		this.anofactura =anofactura ;
		this.facturascont =facturascont ;
		this.totfactura = totfactura;
		this.fechafact = fechafact;
		this.nomempresa = nomempresa;
		this.direccempresa =direccempresa ;
		this.cifempresa = cifempresa;
		this.personacontacto = personacontacto;
		this.telffaxempresa =telffaxempresa;
		this.baseimponible = baseimponible;
		this.formaPago = formaPago;
	}
	
	
	
	
	/**
	 * Metodo para modificar entradas de la base de datos
	 * @param idCursos
	 * @param codigoCurso, nombre, categoria, descripcion, precio , duracion , privado
	 * @return
	 */
	
}
