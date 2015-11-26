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
	
	/**
	 * Metodo constructor Factura
	 * @param int idfactura, int anofactura, int facturascont, float totfactura, String fechafact, String nomempresa,
	 * @param String direccempresa, String cifempresa, String personacontacto, String telffaxempresa, float baseimponible,
	 * @param String formaPago
	 * @return void
	 */
	
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

	
	
	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	} 	
	public void setAnoFactura(int anofactura) {
		this.anofactura = anofactura;
	} 
	public void setFacturasCont(int facturascont) {
		this.facturascont = facturascont;
	}
	public void setTotFactura(float totfactura) {
		this.totfactura = totfactura;
	}	
	public void setFechafact(String fechafact) {
		this.fechafact = fechafact;
	}
	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}	
	public void setDireccempresa(String direccempresa) {
		this.direccempresa = direccempresa;
	}
	public void setCifempresa(String cifempresa) {
		this.cifempresa = cifempresa;
	}	
	public void setPersonacontacto(String personacontacto) {
		this.personacontacto = personacontacto;
	}
	public void setTelffaxempresa(String telffaxempresa) {
		this.telffaxempresa = telffaxempresa;
	}	
	public void setBaseimponible(Float baseimponible) {
		this.baseimponible = baseimponible;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	
	
	public int getIdfactura(int idfactura) {
		return this.idfactura;
	} 	
	public int getAnoFactura(int anofactura) {
		return this.anofactura;
	} 
	public int getFacturasCont(int facturascont) {
		return this.facturascont;
	}
	public float getTotFactura(float totfactura) {
		return this.totfactura;
	}	
	public String getFechafact(String fechafact) {
		return this.fechafact;
	}
	public String getNomempresa(String nomempresa) {
		return this.nomempresa;
	}	
	public String getDireccempresa(String direccempresa) {
		return this.direccempresa;
	}
	public String getCifempresa(String cifempresa) {
		return this.cifempresa;
	}	
	public String getPersonacontacto(String personacontacto) {
		return this.personacontacto;
	}
	public String getTelffaxempresa(String telffaxempresa) {
		return this.telffaxempresa;
	}	
	public Float getBaseimponible(Float baseimponible) {
		return this.baseimponible;
	}
	public String getFormaPago(String formaPago) {
		return this.formaPago;
	}
	
	
	/**
	 * Metodo para ......
	 * @param .., ...., 
	 * @return
	 */
	
}
