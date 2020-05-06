package es.unican.is2.tienda;


public class VendedorEnPlantilla extends Vendedor { // DIT +1
	
	private TipoVendedor tipo;
	
	/**
	 * Retorna un nuevo vendedor en plantilla del tipo que se indica
	 * @param nombre
	 * @param dni
	 * @param tipo
	 */
	public VendedorEnPlantilla(String nombre, String dni, TipoVendedor tipo) { // WMC +1
		super(nombre, dni); // CBO +1
		this.tipo = tipo;
	}
	
	public TipoVendedor tipo() { // WMC +1
		return tipo;
	}
}
