package es.unican.is2.tienda;


/**
 * Vendedor de la tienda, con sus datos personales 
 * y datos de ventas y comisiones
 */
public abstract class Vendedor {
	
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	
	public Vendedor(String nombre, String id) { //WMC +1
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() { //WMC +1
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() { //WMC +1
		return id;
	}

	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() { //WMC +1
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {//WMC +1
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){//WMC +1
		t += importe;
	}
	
	
	@Override
	public boolean equals(Object obj) {//WMC +1
		if (!(obj instanceof Vendedor)) //WMC +1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.id.equals(id) && v.nombre.equals(nombre));
	}
	
	
}
