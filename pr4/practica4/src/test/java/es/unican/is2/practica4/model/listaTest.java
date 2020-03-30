package es.unican.is2.practica4.model;


import org.junit.Assert;

import java.time.*;

import org.junit.*;

import es.unican.is2.listaOrdenadaAcotada.*;
import es.unican.is2.practica4.*;

public class listaTest {
	
	
	@Test
    public void testCajaNegra() {

    ListaOrdenadaAcotada<Empleado> list = new ListaOrdenadaAcotada<Empleado>();

    Empleado emp = null;

    try {
        emp = new Empleado("Pedro", Categoria.OBRERO  ) ;
    } catch (NullPointerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (CategoriaIncorrectaException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 

    list.add(emp);




    }
}
