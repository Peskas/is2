package es.unican.is2.practica4.model;

import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.Empleado;

import org.junit.Assert;

import java.time.*;

import org.junit.*;

public class EmpleadoTest {
	
	private Empleado e;
	private LocalDate l;
	private LocalDate l2;
	private LocalDate l3;
	private LocalDate l4;
	private LocalDate l5;
	private LocalDate l6;
	private LocalDate l7;
	private LocalDate l8;
	private LocalDate l9;
	private LocalDate l10;
	private LocalDate l11;
	
	private LocalDate l12;
	
	
	@Before
	public void setUp() {
		l = LocalDate.now();
		l2 = l.minusYears(3);
		l3 = l.minusYears(5);
		l4 = l.minusYears(6);
		l5 = l.minusYears(7);
		l6 = l.minusYears(10);
		l7 = l.minusYears(11);
		l8 = l.minusYears(15);
		l9 = l.minusYears(20);
		l10 = l.minusYears(21);
		l11 = l.minusYears(50);
		
		l12 = l.plusYears(5);
	}
	
	@Test
	public void testEmpleadoValido() {
		
		// Clases validas
		try {
			e = new Empleado("Pepe", Categoria.DIRECTIVO, l, false) ;
			Assert.assertTrue("MAL", e.sueldoBruto() == 1500.0);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l2, true) ;
			Assert.assertTrue("MAL", e.sueldoBruto() == 1500.0);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l3, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 100);
			
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l4, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto(), == 150);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l5, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1250);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.DIRECTIVO, l6, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto(), == 1550);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l7, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 200);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l8, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1300);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.DIRECTIVO, l9, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1600);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l10, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 300);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l11, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1400);
		} catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
	}
	
	@Test
	public void testEmpleadoNoValido() {
		// Clases no validas
		try {
			e = new Empleado("Pepe", null, l, false) ;
			e.sueldoBruto();
			Assert.assertTrue("No ha salido NullPointer", true);
		} catch (NullPointerException e1) {}
		catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		/*
		e = new Empleado("Pepe", Categoria.CLIENTE, l, false) ;
		try {
			e.sueldoBruto();
		} catch (CategoriaIncorrectaException e1) {
			
		}*/
		
		try {
			e = new Empleado("Pepe", Categoria.GESTOR, null, false) ;
			e.sueldoBruto();
			Assert.fail( "My method didn't throw when I expected it to" );
		} catch (NullPointerException e1) {}
		catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
		
		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l12, false) ;
			e.sueldoBruto();
			Assert.fail( "My method didn't throw when I expected it to" );
		} catch (NullPointerException e1) {}
		catch (DatoIncorrectoException e1) {}
		catch (CategoriaIncorrectaException e1) {}
		catch (FechaIncorrectaException e1) {}
	}

}
