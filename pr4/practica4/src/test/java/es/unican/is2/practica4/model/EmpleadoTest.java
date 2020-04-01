package es.unican.is2.practica4.model;

import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.Empleado;

import org.junit.Assert;

import java.time.*;

import org.junit.*;

public class EmpleadoTest {

	private Empleado emp;
	
	// Fechas validas
	private LocalDate d;
	private LocalDate d3;
	private LocalDate d5;
	private LocalDate d6;
	private LocalDate d7;
	private LocalDate d10;
	private LocalDate d11;
	private LocalDate d15;
	private LocalDate d20;
	private LocalDate d21;
	private LocalDate d50;

	// Fecha posterior no valida
	private LocalDate d5post;


	// Inicializa las variables del tiempo respecto a hoy
	@Before
	public void setUp() {

		// Hoy
		d = LocalDate.now();

		// Date hace n anos
		d3 = d.minusYears(3);
		d5 = d.minusYears(5);
		d6 = d.minusYears(6);
		d7 = d.minusYears(7);
		d10 = d.minusYears(10);
		d11 = d.minusYears(11);
		d15 = d.minusYears(15);
		d20 = d.minusYears(20);
		d21 = d.minusYears(21);
		d50 = d.minusYears(50);

		// Date en n anos posterior
		d5post = d.plusYears(5);
	}

	
	
	// CAJA NEGRA //

	@Test
	public void testCajaNegraConstr() {

		// Constructores validos

		Empresa emp = new Empresa(100);
		
		Categoria categorias[] = {Categoria.OBRERO,Categoria.DIRECTIVO,Categoria.GESTOR};
		LocalDate arrayFechas[] = {d3,d5,d6,d7,d10,d11,d15,d20,d21,d50};
    
		try {
			
			// Crea un empleado correcto de cada caso. 
			for (int i=0; i<categorias.length; i++) {
				for (int j=0; j<arrayFechas.length; j++) {
					emp.empleadosList.add(new Empleado("Pedro", arrayFechas[j], categorias[i]));
				}
			}
			
		} catch (NullPointerException e) {
			Assert.fail("Datos nulos : NullPointerException");
		} catch (FechaIncorrectaException e) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}
		
		
		// Constructores no validos
		@SuppressWarnings("unused")
		Empleado empl;
		
		// Nombre null
		try {
			empl = new Empleado(null, Categoria.GESTOR, d, false) ;
			Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}


		// Categoria null
		try {
			empl = new Empleado("Pepe", null, d, false) ;
			Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}


		// Fecha null
		try {
			empl = new Empleado("Pepe", Categoria.GESTOR, null, false) ;
			Assert.fail( "No ha salido NullPointerException" );
		} 
		catch (NullPointerException e1) {
			// Success
		} 
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}

		
		// Fecha posterior a hoy
		try {
			empl = new Empleado("Pepe", Categoria.OBRERO, d5post, false) ;
			Assert.fail( "No ha salido FechaIncorrectaException" );
		} catch (NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}
		catch (FechaIncorrectaException e1) {
			// Success
		}
		
		
		// Baja null
		try {
			empl = new Empleado("Pepe", Categoria.GESTOR, d, null) ;
					Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		} catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}
	}



	// Sueldos brutos corresponden a los de tabla AVL
	@Test
	public void testCajaNegraMetodo() {
		
		LocalDate arrayFechas[] = {d,d3,d5,d6,d7,d10,d11,d15,d20,d21,d50};
		Categoria categorias[] = {Categoria.DIRECTIVO,Categoria.GESTOR,Categoria.OBRERO,Categoria.OBRERO,Categoria.GESTOR,Categoria.DIRECTIVO,Categoria.OBRERO,Categoria.GESTOR,Categoria.DIRECTIVO,Categoria.OBRERO,Categoria.GESTOR};
		double valoresEsperados[] = {1500.0, 900.0, 100.0, 150.0, 1250, 1550, 200, 1300, 1600, 300, 1400};
		boolean bajasEsperadas[] = {false,true,false,false,false,false,false,false,false,false,false,};
		for (int i=0; i<arrayFechas.length; i++) {
			try {
				emp = new Empleado("Pepe", categorias[i], arrayFechas[i], bajasEsperadas[i]) ;
				Assert.assertTrue("Valor"+i+" no esperado ", emp.sueldoBruto() == valoresEsperados[i]);
			} catch (DatoIncorrectoException e1) {
				Assert.fail("Error sueldo bruto : DatoIncorrectoException");
			} catch (FechaIncorrectaException e1) {
				Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
			} catch(NullPointerException e1) {
				Assert.fail("Datos nulos : NullPointerExecption");
			}
		}

	}





	// CAJA BLANCA //


	@Test
	// Cobertura completa del constructor de 4 params de empleados correctos.
	public void testCajaBlancaConstr() {
		
		Empresa emp = new Empresa(100);
		
		Categoria categorias[] = {Categoria.OBRERO,Categoria.DIRECTIVO,Categoria.GESTOR};
		LocalDate arrayFechas[] = {d3,d5,d6,d7,d10,d11,d15,d20,d21,d50};
		
		try {
			
			emp.empleadosList.add(new Empleado("Pedro", Categoria.OBRERO));
			emp.empleadosList.add(new Empleado("Pedro", Categoria.GESTOR));
			emp.empleadosList.add(new Empleado("Pedro", Categoria.DIRECTIVO));
			
			for (int i=0; i<categorias.length; i++) {
				for (int j=0; j<arrayFechas.length; j++) {
					emp.empleadosList.add(new Empleado("Pedro", categorias[i], arrayFechas[j], true));
				}
			}			
		
		} catch (NullPointerException e) {
			Assert.fail("Datos nulos : NullPointerException");
		} catch (FechaIncorrectaException e) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}
    
	}
    
    
	@Test
	public void testCajaBlancaMetodo() {
		
		// metodos get and set 
		
		try { 
			emp = new Empleado("Juan", Categoria.DIRECTIVO, d, false) ;
		} catch (NullPointerException e) {
		} catch (FechaIncorrectaException e) {
		}
		
		// Comprobamos valores iniciales
		Assert.assertTrue("", emp.getNombre() == "Juan");
		Assert.assertTrue("", emp.getCategoria().equals(Categoria.DIRECTIVO));
		Assert.assertTrue("", emp.getFechaContratacion().compareTo(d) == 0 );
		Assert.assertTrue("", emp.isBaja() == false);
		
		// Modificamos ( solo la baja ) y comprobamos de nuevo
		emp.darBaja(); 
		Assert.assertTrue("", emp.isBaja() == true);
		emp.darAlta();
		Assert.assertTrue("", emp.isBaja() == false);
	}

}
