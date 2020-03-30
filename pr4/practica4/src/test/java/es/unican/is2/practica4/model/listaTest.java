package es.unican.is2.practica4.model;


import org.junit.Assert;


import java.time.*;
import org.junit.*;

import es.unican.is2.practica4.ListaOrdenadaAcotada.*;

public class listaTest {


	@Test
	public void testCajaNegraInicial() {

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


		//// test lista correcta 


		list.add(emp0);
		list.add(emp1);
		list.add(emp2);

		Assert.assertTrue( "",  list.size()  == 3 );  // List size correcto ¿?

		Empleado emp00 = null ;
		Empleado emp11 = null ;
		Empleado emp22 = null ;


		try {
			emp00 = list.get(0);
			emp11 = list.get(1);
			emp22 = list.get(2);

		}catch (NullPointerException e) {
			Assert.fail("no se puede obtener"); // Error al obtener nombre del segundo elemento
		}

		try {
			Assert.assertTrue( "",  emp00.getNombre() == "Pedro" );  
			// Error nombre del primero  -->  GET esta sustitulliendo la primera posicion (indice  0)
			Assert.assertTrue( "",  emp11.getNombre() == "Juan" );
			Assert.assertTrue( "",  emp22.getNombre() == "Paca" );
		}catch (NullPointerException e) {
			Assert.fail("no se puede obtener"); // Error al obtener nombre del segundo elemento en adelante.
		}

		try {
			Assert.assertTrue( "",  emp00.getCategoria() == Categoria.OBRERO ); 
			Assert.assertTrue( "",  emp11.getCategoria() == Categoria.GESTOR ); 
			Assert.assertTrue( "",  emp22.getCategoria() == Categoria.DIRECTIVO ); 

		}catch (NullPointerException e) {
			Assert.fail("no se puede obtener"); // Error al obtener categoria del segundo elemento en adelante.
		}



		try {
			Assert.assertTrue( "",  emp00.getFechaContratacion().equals(d) );
			Assert.assertTrue( "",  emp11.getFechaContratacion().equals(d) );
			Assert.assertTrue( "",  emp22.getFechaContratacion().equals(d) );

		}catch (NullPointerException e) {
			Assert.fail("no se puede obtener");  // Error al obtener categoria del segundo elemento en adelante.
		}



		list.remove(0);

		Assert.assertTrue( "",  list.size()  == 2 );

		try {
			Assert.assertTrue( "",  list.get(0).getNombre() == "Juan" );
			Assert.assertTrue( "",  list.get(1).getNombre() == "Paca" );
		}catch (NullPointerException e) {
			Assert.fail("no se puede obtener");  //  no queda ningun elemento en la lista
		}

		list.clear();
		Assert.assertTrue( "",  list.size()  == 0 );




		//// test lista incorrecta 

		list.add(null);
		Assert.assertTrue( "",  list.size()  == 0 ); // Permite añadir nulos

		// crear lista negativo ,  crear lista null
		// get(negativo) ,get(null)
		// remove(negativo) ,remove(null)




		//// test tamaño maximo lista 

		list.clear();
		Assert.assertTrue( "",  list.size()  == 0 );

		for(int i= 0; i<100 ;i++) {
			list.add(emp00);
		}
		Assert.assertTrue( "",  list.size()  == 100 );



	}
}
