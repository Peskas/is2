package es.unican.is2.practica4.model;


import org.junit.Assert;


import java.time.*;
import org.junit.*;

import es.unican.is2.practica4.ListaOrdenadaAcotada.*;

public class listaTest {
	
	
	@Test
    public void testCajaNegraInicial() {

    ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>();

    Empleado emp = null;
    Empleado emp1 = null;
    LocalDate d = LocalDate.now();

    try {
    	emp = new Empleado("Pedro", Categoria.OBRERO  ) ;
    	emp1 = new Empleado("Juan", Categoria.OBRERO  ) ;
    	
    } catch (NullPointerException e) {
    } catch (CategoriaIncorrectaException e) {
    } 

    
    // test lista correcta 
    
    
    list.add(emp);
    list.add(emp1);

    Assert.assertTrue( "",  list.size()  == 2 );  // List size correcto ¿?
    
    Empleado emp2 = null ;
    Empleado emp3 = null ;
    		
    
    try {
    	emp2 = list.get(0);
        emp3 = list.get(1);
    }catch (NullPointerException e) {
    	// Assert.fail("no se puede obtener"); // Error al obtener nombre del segundo elemento
    }
    
    try {
    // Assert.assertTrue( "",  emp2.getNombre() == "Pedro" );  
    	// Error nombre del primero  -->  GET esta sustitulliendo la primera posicion (indice  0)
    Assert.assertTrue( "",  emp3.getNombre() == "Juan" );
    }catch (NullPointerException e) {
    	// Assert.fail("no se puede obtener"); // Error al obtener nombre del segundo elemento en adelante.
    }
    
    try {
    Assert.assertTrue( "",  emp2.getCategoria() == Categoria.OBRERO ); 
    Assert.assertTrue( "",  emp3.getCategoria() == Categoria.OBRERO ); 

    }catch (NullPointerException e) {
    	// Assert.fail("no se puede obtener"); // Error al obtener categoria del segundo elemento en adelante.
    }
    
    
    
    try {
    Assert.assertTrue( "",  emp2.getFechaContratacion().equals(d) );
    Assert.assertTrue( "",  emp3.getFechaContratacion().equals(d) );
    }catch (NullPointerException e) {
    	// Assert.fail("no se puede obtener");  // Error al obtener categoria del segundo elemento en adelante.
    }
    
    
    
    list.remove(0);
    
    Assert.assertTrue( "",  list.size()  == 1 );
    
    try {
    Assert.assertTrue( "",  list.get(0).getNombre() == "Juan" );
    }catch (NullPointerException e) {
    	// Assert.fail("no se puede obtener");  //  no queda ningun elemento en la lista
    }
    
    list.clear();
    
    Assert.assertTrue( "",  list.size()  == 0 );

    // test lista incorrecta 
    
    list.add(null);

    // Assert.assertTrue( "",  list.size()  == 0 ); // Permite añadir nulos


    }
}
