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

	// CAJA NEGRA //
	
	@Test
	public void testEmpleadoValido() {

		// Constructores y sueldos validos

		try {
			e = new Empleado("Pepe", Categoria.DIRECTIVO, l, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1500.0);
		} catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l2, true) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 900.0);
		}  catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l3, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 100.0);

		}  catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l4, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 150.0);
		} catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}


		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l5, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1250.0);
		} catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}


		try {
			e = new Empleado("Pepe", Categoria.DIRECTIVO, l6, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1550.0);
		}  catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l7, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 200);
		}  catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l8, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1300);
		} catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.DIRECTIVO, l9, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1600);
		} catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l10, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 300);
		}  catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

		try {
			e = new Empleado("Pepe", Categoria.GESTOR, l11, false) ;
			Assert.assertTrue("Valor no esperado", e.sueldoBruto() == 1400);
		}  catch (DatoIncorrectoException e1) {
			Assert.fail("Error sueldo bruto : DatoIncorrectoException");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}catch(NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}

	}

	
	
	@Test
	public void testEmpleadoNoValido() {
		// Constructores no validos
		

		// nombre null
		try {
			e = new Empleado(null, Categoria.GESTOR, l, false) ;
			Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		} 
		catch (CategoriaIncorrectaException e) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");

		}
		
		

		// Categoria null
		try {
			e = new Empleado("Pepe", null, l, false) ;
			Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		} 
		catch (CategoriaIncorrectaException e) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");

		}
		

		// fecha null
		
		try {
			e = new Empleado("Pepe", Categoria.GESTOR, null, false) ;
			Assert.fail( "No ha salido NullPointerException" );
		} catch (NullPointerException e1) {
			// Success
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			
		}

		// Fecha posterior a hoy
		try {
			e = new Empleado("Pepe", Categoria.OBRERO, l12, false) ;
			Assert.fail( "No ha salido FechaIncorrectaException" );
		} catch (NullPointerException e1) {
			Assert.fail("Datos nulos : NullPointerExecption");
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			// Success
		}
	}


	
	
	
	// CAJA BLANCA //
	
	
	@Test 
	// Cobertura completa del constructor de empleados correctos.
	public void testCoberturaCorrecta() {

		Empresa emp = null ;

		try {
			emp = new Empresa();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatoIncorrectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CategoriaIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FechaIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		if(emp != null) {

			try {
				// Un empleado correcto de cada caso. 
				rellenaPlantilla(emp);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatoIncorrectoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CategoriaIncorrectaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FechaIncorrectaException e) {
				Assert.fail( "No ha sido posible crear la empresa" );
			}

		}else{
			Assert.fail( "No ha sido posible crear la empresa" );
		}
	}



	
	
	
	
	

	public void rellenaPlantilla(Empresa e) throws NullPointerException, DatoIncorrectoException, CategoriaIncorrectaException, FechaIncorrectaException {

		// Un Trabajador en cada situacion posible . 

		// Obrero , Contrato hoy , no baja
		e.empleadosList.add(new Empleado("Pedro", Categoria.OBRERO  ) );

		// Directivo , Contrato hoy , no baja
		e.empleadosList.add(new Empleado("Carlos", Categoria.DIRECTIVO  ) );

		// Gestor , Contrato hoy , no baja
		e.empleadosList.add(new Empleado("Juan", Categoria.GESTOR  ) );

		LocalDate date5 = LocalDate.parse("2014-01-01");

		// Obrero , Contrato +5 , no baja
		e.empleadosList.add(new Empleado("Maria", date5, Categoria.OBRERO  ) );

		// Directivo , Contrato +5 , no baja
		e.empleadosList.add(new Empleado("Lucia", date5,  Categoria.DIRECTIVO  ) );

		// Gestor , Contrato +5 , no baja
		e.empleadosList.add(new Empleado("Juana", date5, Categoria.GESTOR  ) );

		LocalDate date10 = LocalDate.parse("2009-01-01");

		// Obrero , Contrato +10 , no baja
		e.empleadosList.add(new Empleado("Manolo", date10, Categoria.OBRERO  ) );

		// Directivo , Contrato +10 , no baja
		e.empleadosList.add(new Empleado("Benito", date10,  Categoria.DIRECTIVO  ) );

		// Gestor , Contrato +10 , no baja
		e.empleadosList.add(new Empleado("Carlos", date10, Categoria.GESTOR  ) );

		LocalDate date20 = LocalDate.parse("1999-01-01");

		// Obrero , Contrato +20 , no baja
		e.empleadosList.add(new Empleado("Paquita", date20, Categoria.OBRERO  ) );

		// Directivo , Contrato +20 , no baja
		e.empleadosList.add(new Empleado("Axel", date20,  Categoria.DIRECTIVO  ) );

		// Gestor , Contrato +20 , no baja
		e.empleadosList.add(new Empleado("Zelda", date20, Categoria.GESTOR  ) );


		// De Baja


		// Obrero , Contrato hoy , baja
		e.empleadosList.add(new Empleado("Link" , Categoria.OBRERO , LocalDate.now(),true ) );

		// Directivo , Contrato hoy , baja
		e.empleadosList.add(new Empleado("Mario" , Categoria.DIRECTIVO , LocalDate.now(),true  ) );

		// Gestor , Contrato hoy , baja
		e.empleadosList.add(new Empleado("Luigi" ,Categoria.GESTOR ,  LocalDate.now(), true ) );

		// date +5

		// Obrero , Contrato +5 , baja
		e.empleadosList.add(new Empleado("Maria 2", Categoria.OBRERO , date5, true  ) );

		// Directivo , Contrato +5 , baja
		e.empleadosList.add(new Empleado("Lucia 2",  Categoria.DIRECTIVO  , date5, true ) );

		// Gestor , Contrato +5 , baja
		e.empleadosList.add(new Empleado("Juana 2",  Categoria.GESTOR  , date5, true  ) );

		// date +10

		// Obrero , Contrato +10 , baja
		e.empleadosList.add(new Empleado("Pedro 2",  Categoria.OBRERO , date10, true  ) );

		// Directivo , Contrato +10 , baja
		e.empleadosList.add(new Empleado("Carlos 2",  Categoria.DIRECTIVO , date10, true   ) );

		// Gestor , Contrato +10 , baja
		e.empleadosList.add(new Empleado("Juan 2", Categoria.GESTOR , date10, true  ) );

		// date +20

		// Obrero , Contrato +20 , baja
		e.empleadosList.add(new Empleado("Pedro 2" , Categoria.OBRERO , date20, true ) );

		// Directivo , Contrato +20 , baja
		e.empleadosList.add(new Empleado("Carlos 2", Categoria.DIRECTIVO , date20, true  ) );

		// Gestor , Contrato +20 , baja
		e.empleadosList.add(new Empleado("Juan 2",  Categoria.GESTOR , date20, true ) );
	}

}
