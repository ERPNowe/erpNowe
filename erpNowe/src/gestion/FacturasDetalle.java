package gestion;

/**
 * @author  Marcos Lueje Alonso
 * @since 20/11/2015
 * @version 1.0
*/

public class FacturasDetalle {
	
	//private static idDetalleObj;
	
	private int idfacturasdetalle;
	private String codproducto;
	private String descproducto;
	private int cantidad;
	private float preciounidad =0.0F;
	private float importe =0.0F;
	private int fk_idfactura;
	
	/**
	 * Metodo constructor FacturasDetalle
	 * @param int idfacturasdetalle, String codproducto, String descproducto, int cantidad,
	 * @param float preciounidad, float importe, int fk_idfactura
	 * @return void
	 */
	
	
	public  FacturasDetalle(int idfacturasdetalle,
								String codproducto,
								String descproducto,
								int cantidad,
								float preciounidad,
								float importe,
								int fk_idfactura){
		
		this.idfacturasdetalle=idfacturasdetalle;
		this.codproducto=codproducto;
		this.descproducto=descproducto;
		this.cantidad=cantidad;
		this.preciounidad=preciounidad;
		this.importe= importe;
		this.fk_idfactura=fk_idfactura;
		
	}

	/**
	 * @return the idfacturasdetalle
	 */
	public int getIdfacturasdetalle() {
		return idfacturasdetalle;
	}

	/**
	 * @param idfacturasdetalle the idfacturasdetalle to set
	 */
	public void setIdfacturasdetalle(int idfacturasdetalle) {
		this.idfacturasdetalle = idfacturasdetalle;
	}

	/**
	 * @return the codproducto
	 */
	public String getCodproducto() {
		return codproducto;
	}

	/**
	 * @param codproducto the codproducto to set
	 */
	public void setCodproducto(String codproducto) {
		this.codproducto = codproducto;
	}

	/**
	 * @return the descproducto
	 */
	public String getDescproducto() {
		return descproducto;
	}

	/**
	 * @param descproducto the descproducto to set
	 */
	public void setDescproducto(String descproducto) {
		this.descproducto = descproducto;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the preciounidad
	 */
	public float getPreciounidad() {
		return preciounidad;
	}

	/**
	 * @param preciounidad the preciounidad to set
	 */
	public void setPreciounidad(float preciounidad) {
		this.preciounidad = preciounidad;
	}

	/**
	 * @return the importe
	 */
	public float getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	/**
	 * @return the fk_idfactura
	 */
	public int getFk_idfactura() {
		return fk_idfactura;
	}

	/**
	 * @param fk_idfactura the fk_idfactura to set
	 */
	public void setFk_idfactura(int fk_idfactura) {
		this.fk_idfactura = fk_idfactura;
	}
	
	
	

}
