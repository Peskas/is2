package es.unican.is2.practica4.model;


import org.junit.Assert;


import java.time.*;
import org.junit.*;

import es.unican.is2.practica4.ListaOrdenadaAcotada.*;

public class listaTest {

	@Test
	public void testCajaNegraConstructor() {



		// crear lista negativo ,  crear lista 0
		try {
			ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>(-10);
			Assert.fail("La lista permite crearse con numeros negativos como tamano");
		}catch (NegativeArraySizeException e) {
			// Success
		}

		// Lista tamaño 0
		try {
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
		} catch (CategoriaIncorrectaException e) {
		} catch (FechaIncorrectaException e) {} 

		/////////////////////////
		// Test lista correcta //
		/////////////////////////

		list.add(emp0);
		list.add(emp1);
		list.add(emp2);

		Assert.assertTrue( "Tamano incorrecto",  list.size()  == 3 );  // List size correcto ¿?

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

		try {
			Assert.assertTrue( "Nombre "+emp0get.getNombre()+" incorrecto",  emp0get.getNombre() == "Pedro");  
			// Error nombre del primero  -->  GET esta sustituyendo la primera posicion (indice 0)
			Assert.assertTrue( "Nombre incorrecto",  emp1get.getNombre() == "Juan" );
			Assert.assertTrue( "Nombre incorrecto",  emp2get.getNombre() == "Paca" );
		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener"); // Error al obtener nombre del segundo elemento en adelante.
		}

		try {
			Assert.assertTrue( "Categoria Incorrecta",  emp0get.getCategoria() == Categoria.OBRERO ); 
			Assert.assertTrue( "Categoria Incorrecta",  emp1get.getCategoria() == Categoria.GESTOR ); 
			Assert.assertTrue( "Categoria Incorrecta",  emp2get.getCategoria() == Categoria.DIRECTIVO ); 

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
			Assert.assertTrue( "Nombre incorrecto",  list.get(1).getNombre() == "Paca" );
		}catch (NullPointerException e) {
			Assert.fail("No se puede obtener");  //  No queda ningun elemento en la lista
		}

		list.clear();
		Assert.assertTrue( "Tamano incorrecto, el tamano de la lista deberia ser 0",  list.size()  == 0 );


		///////////////////////////
		// Test lista incorrecta //
		///////////////////////////

		// Permite añadir nulos
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
		} catch (NullPointerException e) {
		} catch (CategoriaIncorrectaException e) {
		} catch (FechaIncorrectaException e) {
		}
 
		// Crear lista con el constructor sin parametro
		ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>();
		System.out.println(list.size());
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


		// Añadir empleado a lista llena
		try {
			list2.add(emp);
		} catch (NullPointerException e) {
		} catch (IllegalStateException e) {
			// Success
		}


	}
}
