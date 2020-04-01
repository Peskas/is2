package es.unican.is2.practica4.model;


import org.junit.Assert;


import java.time.*;
import org.junit.*;

import es.unican.is2.practica4.ListaOrdenadaAcotada.*;

public class listaTest {

	@SuppressWarnings("unused")
	
	@Test
	public void testCajaNegraConstructor() {
		
		// Crear lista de tamano negativo
		try {
			ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>(-10);
			Assert.fail("La lista permite crearse con numeros negativos como tamano");
		}catch (NegativeArraySizeException e) {
			// Success
		}

		// Crear lista tamano 0
		try{
			ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>(0);
			Assert.fail("La lista permite crearse con tamano 0");
		}catch (NullPointerException e) {
			// Success
		}
	}

	@Test
	public void testCajaNegraMetodos() {

		ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>(100);

		Empleado emp0 = null;
		Empleado emp1 = null;
		Empleado emp2 = null;
		LocalDate d = LocalDate.now();

		try {
			emp0 = new Empleado("Pedro", Categoria.OBRERO  ) ;
			emp1 = new Empleado("Juan", Categoria.GESTOR  ) ;
			emp2 = new Empleado("Paca", Categoria.DIRECTIVO  ) ;


		} catch (NullPointerException e) {
		} catch (FechaIncorrectaException e) {} 

		/////////////////////////
		// Test lista correcta //
		/////////////////////////

		list.add(emp0);
		list.add(emp1);
		list.add(emp2);

		Assert.assertTrue( "Tamano incorrecto",  list.size()  == 3 ); 
		
		
		Empleado emp0get = null ;
		Empleado emp1get = null ;
		Empleado emp2get = null ;
		try {
			emp0get = list.get(0);
			emp1get = list.get(1);
			emp2get = list.get(2);

		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener"); // Error al obtener el segundo elemento en adelante
		}

		
		// nombres y cargos cambiados de la version inicial para que cumpla con la funcion "compare to"
		 
		try { 
			// Error nombre del primero  -->  add esta sustituyendo la primera posicion (indice 0)
			Assert.assertTrue( "Nombre "+emp0get.getNombre()+" incorrecto",  emp0get.getNombre() == "Paca");  
			Assert.assertTrue( "Nombre incorrecto",  emp1get.getNombre() == "Juan" );
			Assert.assertTrue( "Nombre incorrecto",  emp2get.getNombre() == "Pedro" );
		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener"); // Error al obtener nombre del segundo elemento en adelante.
		}

		try {
			Assert.assertTrue( "Categoria Incorrecta",  emp0get.getCategoria() == Categoria.DIRECTIVO ); 
			Assert.assertTrue( "Categoria Incorrecta",  emp1get.getCategoria() == Categoria.GESTOR ); 
			Assert.assertTrue( "Categoria Incorrecta",  emp2get.getCategoria() == Categoria.OBRERO ); 

		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener"); // Error al obtener categoria del segundo elemento en adelante.
		}


		try {
			Assert.assertTrue( "Fecha incorrecta",  emp0get.getFechaContratacion().equals(d) );
			Assert.assertTrue( "Fecha incorrecta",  emp1get.getFechaContratacion().equals(d) );
			Assert.assertTrue( "Fecha incorrecta",  emp2get.getFechaContratacion().equals(d) );

		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener");  // Error al obtener categoria del segundo elemento en adelante.
		}

		list.remove(0);
		Assert.assertTrue( "Tamano incorrecto, el tamano de la lista deberia ser 2",  list.size()  == 2 );

		try {
			Assert.assertTrue( "Nombre incorrecto",  list.get(0).getNombre() == "Juan" );
			Assert.assertTrue( "Nombre incorrecto",  list.get(1).getNombre() == "Pedro" );
		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener");  //  No queda ningun elemento en la lista
		}

		list.clear();
		Assert.assertTrue( "Tamano incorrecto, el tamano de la lista deberia ser 0",  list.size()  == 0 );


		///////////////////////////
		// Test lista incorrecta //
		///////////////////////////

		// Permite anadir nulos
		list.add(null);
		Assert.assertTrue( "Tamano incorrecto",  list.size()  == 0 );

		// Numero por parametro negativo
		try {
			list.get(-1);
			Assert.fail("La lista permite acceder a una posicion negativa");
		}catch (IndexOutOfBoundsException e) {
			// Success
		}

		// Numero por parametro mayor o igual que lista.size()
		try {
			list.get(100);
			Assert.fail("La lista permite acceder a una posicion mayor que el tamano de la lista");
		}catch (IndexOutOfBoundsException e) {
			// Success
		}

		// Numero por parametro negativo
		try {
			list.remove(-1);
			Assert.fail("La lista permite borrar a una posicion negativa");
		}catch (IndexOutOfBoundsException e) {
			// Success
		}

		// Numero por parametro mayor o igual que lista.size()
		try {
			list.remove(100);
			Assert.fail("La lista permite borrar a una posicion mayor que el tamano de la lista");
		}catch (IndexOutOfBoundsException e) {
			// Success
		}


		// Test anadir ultima posicion

		list.clear();
		Assert.assertTrue( "Tamano incorrecto",  list.size()  == 0 );

		for(int i= 0; i<100 ;i++) {
			list.add(emp0get);
		}
		Assert.assertTrue( "Tamano incorrecto",  list.size()  == 100 );
	}




	@Test
	public void testCajaBlanca() {

		
		Empleado emp = null;

		try {
			emp = new Empleado("Pepe",Categoria.OBRERO) ;
		} catch (NullPointerException e) {}
		catch (FechaIncorrectaException e) {}
 
		// Crear lista con el constructor sin parametro
		ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>();
		for(int i= 0; i<10 ;i++) {
			try {
				list.add(emp);
			} catch (NullPointerException e) {} 
		}
		Assert.assertTrue("",list.size() == 10);

		// Crear lista con 100 elementos
		ListaOrdenadaAcotada<Empleado> list2 = new ListaOrdenadaAcotada<Empleado>(100);
		for(int i= 0; i<100 ;i++) {
			try {
				list2.add(emp);
			} catch (NullPointerException e) {}
		}


		// Anadir empleado a lista llena
		try {
			list2.add(emp);
		} catch (NullPointerException e) {
		} catch (IllegalStateException e) {
			// Success
		}
		
		
		
		// test Orden Correcto
		
		
		ListaOrdenadaAcotada<Empleado> listOrder = new ListaOrdenadaAcotada<Empleado>();

		Empleado emp1 = null;
		Empleado emp2 = null;
		Empleado emp3 = null;
		Empleado emp4 = null;
		Empleado emp5 = null;
		Empleado emp6 = null;

		try {
			emp1 = new Empleado("A..D",Categoria.DIRECTIVO) ;
			emp2 = new Empleado("B..D",Categoria.DIRECTIVO) ;
			
			emp3 = new Empleado("A..G",Categoria.GESTOR) ;
			emp4 = new Empleado("B..G",Categoria.GESTOR) ;
			
			emp5 = new Empleado("A..O",Categoria.OBRERO) ;
			emp6 = new Empleado("B..O",Categoria.OBRERO) ;
			
		} catch (NullPointerException e) {}
		catch (FechaIncorrectaException e) {}
		
		// introducir a desorden
		listOrder.add(emp2);
		listOrder.add(emp4);
		listOrder.add(emp1);
		listOrder.add(emp5);
		listOrder.add(emp3);
		listOrder.add(emp6);
		
		// comprobar orden 
		Assert.assertTrue(" Orden incorrecto ",listOrder.get(0).equals(emp1));
		Assert.assertTrue(" Orden incorrecto ",listOrder.get(1).equals(emp2));
		Assert.assertTrue(" Orden incorrecto ",listOrder.get(2).equals(emp3));
		Assert.assertTrue(" Orden incorrecto ",listOrder.get(3).equals(emp4));
		Assert.assertTrue(" Orden incorrecto ",listOrder.get(4).equals(emp5));
		Assert.assertTrue(" Orden incorrecto ",listOrder.get(5).equals(emp6));

	}
}
