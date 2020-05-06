package es.unican.is2.tienda;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa una tienda con un conjunto de vendedores y que permite
 * llevar la gesti�n de las ventas realizadas y las comisiones asignadas a cada
 * vendedor. Los datos de la tienda se almacenan en un fichero de texto
 * que se pasa como par�metro al crear la tienda
 */
public class Tienda {

	private static final Locale Idioma = Locale.ENGLISH;
	private static final double COMPLEMENTO_SENIOR = 0.01;
	private static final double COMPLEMENTO_JUNIOR = 0.005;
	private LinkedList<Vendedor> lista = new LinkedList<Vendedor>(); // CBO +1 (Vendedor)
	TiendaData data = new TiendaData();

	/**
	 * Crea la tienda cargando los datos desde el fichero indicado
	 * 
	 * @param datos Path absoluto del fichero de datos
	 */
	public Tienda(String datos) { // WMC +1 
		this.data.datos = datos;
	}

	/**
	 * A�ade un nuevo vendedor a la tienda
	 * 
	 * @param nuevoVendedor
	 * @return true si el vendedor se ha anhadido 
	 *         false si ya hab�a un vendedor con el mismo id
	 */
	public boolean anhade(Vendedor nuevoVendedor) throws IOException { //WMC +1
		Vendedor v = buscaVendedor(nuevoVendedor.getId());
		if (v != null) { // WMC +1 //CCog +1
			return false;
		}
		lista.add(nuevoVendedor);
		vuelcaDatos();
		return true;
	}

	/**
	 * Elimina el vendedor cuyo dni se pasa como par�metro
	 * 
	 * @param id
	 * @return true si se elimina el vendedor 
	 *         false si no existe ning�n vendedor con el id indicado
	 */
	public boolean eliminaVendedor(String id) throws IOException {// WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) {// WMC +1 //CCog +1
			return false;
		}
		lista.remove(v);
		vuelcaDatos();
		return true;
	}

	/**
	 * A�ade una venta a un vendedor
	 * 
	 * @param id
	 *            Id del vendedor
	 * @param importe
	 *            Importe de la venta
	 * @return true si se a�ade la venta false si no se encuentra el vendedor
	 */
	public boolean anhadeVenta(String id, double importe) throws IOException {// WMC +1
		Vendedor v = buscaVendedor(id);
		if (v == null) {// WMC +1 //CCog +1
			return false;
		}
		double importeFinal = importe;
		if (v instanceof VendedorEnPlantilla) {// WMC +1 //CCog +1
			importeFinal += importeFinal *  sumaComplemento(v);
		}
		v.anhade(importeFinal);
		vuelcaDatos();
		return true;
	}

	private double sumaComplemento(Vendedor v) { // WMC +1 
		double complemento = 0.0 ; 
		switch (((Vendedor) v).tipo()) {// WMC +2 //CCog +1 // CBO +1(tipoVendedor)
		case JUNIOR:
			complemento = COMPLEMENTO_JUNIOR;
			break;
		case SENIOR:
			complemento = COMPLEMENTO_SENIOR;
			break;
		}
		return complemento;
	}

	/**
	 * Retorna el vendedor con el id indicado
	 * 
	 * @param id
	 *            Id del vendedor
	 * @return vendedor con ese id o null si no existe ninguno
	 */
	public Vendedor buscaVendedor(String id) { // WMC +1

		lista = (LinkedList<Vendedor>) vendedores();

		for (Vendedor v : lista) { // WMC +1 //CCog +1
			if (v.getId().equals(id)) { // WMC +1 { //CCog +2
				return v;
			}
		}
		return null;
	}

	/**
	 * Retorna la lista de vendedores actuales de la tienda
	 * 
	 * @return La lista de vendedores
	 */
	public List<Vendedor> vendedores() { // WMC +1
		lista = new LinkedList<Vendedor>();

		Scanner in = null;
		try {
			// abre el fichero
			in = new Scanner(new FileReader(data.datos));
			// configura el formato de n�meros
			in.useLocale(Idioma);
			data.nombre = in.nextLine();
			data.direccion = in.nextLine();
			in.next();
			Vendedor ven = null;
			// lee los vendedores senior
			while (in.hasNext() && !in.next().equals("Junior")) { // WMC +2 //CCog +1

				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, TipoVendedor.SENIOR); //CBO +1 (vendedorEnPlantilla)
				ven.setT(totalVentas);
				lista.add(ven);
			}
			// lee los vendedores junior
			while (in.hasNext() && !in.next().equals("Pr�cticas")) { // WMC +2//CCog +1
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPlantilla(nombre, idIn, TipoVendedor.JUNIOR);
				ven.setT(totalVentas);
				lista.add(ven);
			}
			while (in.hasNext()) {// WMC +1 //CCog +1
				in.next();
				String nombre = in.next();
				in.next();
				String idIn = in.next();
				in.next();
				double totalVentas = in.nextDouble();
				ven = new VendedorEnPracticas(nombre, idIn); //CBO +1 (vendedorEnPracticas)
				ven.setT(totalVentas);
				lista.add(ven);
			}
		} catch (FileNotFoundException e) {

		} finally {
			if (in != null) {// WMC +1 //CCog +1
				in.close();
			}
		} // try

		return lista;

	}

	/**
	 * M�todo que genera el fichero datosTienda.txt con los datos actualizados de
	 * los vendedores
	 */
	private void vuelcaDatos() throws IOException { // WMC +1
		PrintWriter out = null;
		List<Vendedor> senior = new LinkedList<Vendedor>();
		List<Vendedor> junior = new LinkedList<Vendedor>();
		List<Vendedor> practicas = new LinkedList<Vendedor>();

		for (Vendedor v : lista) { // WMC +1 //CCog +1
			if (v instanceof VendedorEnPracticas) { // WMC +1 //CCog +2 
				practicas.add(v);
			} else if (v instanceof VendedorEnPlantilla && 
					v.tipo().equals(TipoVendedor.JUNIOR) ) { // WMC +2 //CCog +2

				junior.add(v);
			}
			else {
				senior.add(v);
			}
		}

	try {

		out = new PrintWriter(new FileWriter(data.datos));

		out.println(data.nombre);
		out.println(data.direccion);
		out.println();
		out.println("    Senior");
		for (Vendedor v1 : senior) // WMC +1 //CCog +1
			out.println("      Nombre: " + v1.getNombre() + "   Id: " + v1.getId() + "   TotalVentasMes: "
					+ v1.getTotalVentas());
		out.println();
		out.println("    Junior");
		for (Vendedor v2 : junior) // WMC +1 //CCog +1
			out.println("      Nombre: " + v2.getNombre() + "   Id: " + v2.getId() + "   TotalVentasMes: "
					+ v2.getTotalVentas());
		out.println();
		out.println("    Pr�cticas");
		for (Vendedor v3 : practicas) // WMC +1 //CCog +1
			out.println("      Nombre: " + v3.getNombre() + "   Id: " + v3.getId() + "   TotalVentasMes: "
					+ v3.getTotalVentas());

	} finally {
		if (out != null) // WMC +1 //CCog +1
			out.close();
	}
}

}
