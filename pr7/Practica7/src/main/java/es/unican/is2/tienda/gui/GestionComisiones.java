package es.unican.is2.tienda.gui;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import es.unican.is2.tienda.Tienda;
import es.unican.is2.tienda.Vendedor;
import fundamentos.Menu;
import fundamentos.Lectura;
import fundamentos.Mensaje;

/**
 * Gesti�n de las comisiones de vendedores de una tienda
 * 
 * @author MP
 * @version feb-13
 */
public class GestionComisiones {

	final static int NUEVA_VENTA = 0, VENDEDOR_DEL_MES = 1, VENDEDORES = 2;
	
	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) {
		// opciones del menu

		// variables auxiliares
		String dni;
		Lectura lect;

		List<Vendedor> vendedores;
		// Rename-field
		List<Vendedor> empleadosMes;
		String msj;

		// crea la tienda
		Tienda tienda = new Tienda("datosTienda.txt");

		// crea la ventana de menu
		Menu menu = new Menu("Comisiones tienda");
		menu.insertaOpcion("A�adir venta", NUEVA_VENTA);
		menu.insertaOpcion("Vendedor del mes", VENDEDOR_DEL_MES);
		menu.insertaOpcion("Vendedores por ventas", VENDEDORES);
		int opcion;

		// lazo de espera de comandos del usuario
		while (true) {
			opcion = menu.leeOpcion();

			// Extract-method
			escogeOpcion(tienda, opcion);
		}
	}

	public static void escogeOpcion(Tienda tienda, int opcion) {
		String dni;
		Lectura lect;
		List<Vendedor> vendedores;
		List<Vendedor> empleadosMes;
		String msj;
		// realiza las acciones dependiendo de la opcion elegida
		switch (opcion) {
		
		case NUEVA_VENTA:
			lect = new Lectura("Datos Venta");
			lect.creaEntrada("DNI Vendedor", "");
			lect.creaEntrada("Importe", "");
			lect.esperaYCierra();
			dni = lect.leeString("DNI Vendedor");
			double importe = lect.leeDouble("Importe");
			try {
				if (!tienda.anhadeVenta(dni, importe)) {
					mensaje("ERROR", "El vendedor no existe");
				}
			} catch (IOException e) {
				mensaje("ERROR", "No se pudo guardar el cambio");
			}
			break;

		case VENDEDOR_DEL_MES:

			vendedores = tienda.vendedores();
			
			// Extract-method
			empleadosMes = getEmpleadosMaxVentas(vendedores);

			msj = "";
			for (Vendedor vn : empleadosMes) {
				msj += vn.getNombre() + "\n";
			}
			mensaje("VENDEDORES DEL MES", msj);
			break;

		case VENDEDORES:

			vendedores = tienda.vendedores();
			System.out.println(vendedores.size());
			Collections.sort(vendedores, new Comparator<Vendedor>() {
				public int compare(Vendedor o1, Vendedor o2) {
					if (o1.getTotalVentas()>o2.getTotalVentas())
						return -1;
					else if (o1.getTotalVentas()<o2.getTotalVentas())
						return 1;
					return 0;
				}			
			});
			msj = "";
			for (Vendedor vn : vendedores) {
				msj += vn.getNombre() + " " + vn.getId() + "\n";
			}
			mensaje("VENDEDORES", msj);
			break;
		}
	}

	public static List<Vendedor> getEmpleadosMaxVentas(List<Vendedor> vendedores) {
		List<Vendedor> resultado;
		resultado = new LinkedList<Vendedor>();
		double maxVentas = 0.0;
		for (Vendedor v : vendedores) {
			if (v.getTotalVentas() > maxVentas) {
				maxVentas = v.getTotalVentas();
				resultado.clear();
				resultado.add(v);
			} else if (v.getTotalVentas() == maxVentas) {
				resultado.add(v);
			}
		}
		return resultado;
	}

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * 
	 * @param titulo
	 *            titulo de la ventana
	 * @param txt
	 *            texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) {
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);

	}

}
