package es.unican.is2.tienda;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TiendaTest {
	
	
	private static Tienda tienda;
	private static Vendedor sutJunior;
	private static Vendedor sutSenior;


	@Test
	public void test() {
		tienda = new Tienda("datosTienda.txt"); 
		sutJunior = new VendedorEnPlantilla("Ana", "1", TipoVendedor.JUNIOR);
		sutSenior = new VendedorEnPlantilla("Pepe", "2", TipoVendedor.SENIOR);
		
		try {
			tienda.anhadeVendedor(sutJunior);
			tienda.anhadeVendedor(sutSenior);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
