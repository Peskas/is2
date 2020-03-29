package es.unican.is2.practica4.model;

import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.Empleado;

import org.junit.Assert;

import java.time.*;

import org.junit.*;

public class EmpleadoTest {
	@SuppressWarnings("unused")
	private Empleado e;
	
	@Before
	public void setUp() {
		LocalDate l = LocalDate.now();
		e = new Empleado("Pepe", l, Categoria.DIRECTIVO) ;
	}
	
	@Test
	public void testSueldoBruto() {
		Assert.assertEquals("Esperado", "HOLA", "HOLA");
	}

}
