package es.unican.is2.practica4.model;

import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.Empleado;

import org.junit.Assert;

import java.time.*;

import org.junit.*;

public class EmpleadoTest {

	private Empleado emp;
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

	private LocalDate l12;

	
	// Inicializa las variables del tiempo
	@Before
	public void setUp() {
		d = LocalDate.now();
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

		l12 = d.plusYears(5);
	}

	// CAJA NEGRA //
	
	
	@Test
	public void testCajaNegraConstr() {
		// Constructores no validos


		// nombre null
		try {
			emp = new Empleado(null, Categoria.GESTOR, d, false) ;
			Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		} 
		catch (CategoriaIncorrectaException emp) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");

		}



		// Categoria null
		try {
			emp = new Empleado("Pepe", null, d, false) ;
			Assert.fail("No ha salido NullPointerException");
		} catch (NullPointerException e1) {
			// Success
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		} 
		catch (CategoriaIncorrectaException emp) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");

		}


		// fecha null

		try {
			emp = new Empleado("Pepe", Categoria.GESTOR, null, false) ;
			Assert.fail( "No ha salido NullPointerException" );
		} catch (NullPointerException e1) {
			// Success
		}
		catch (CategoriaIncorrectaException e1) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
		}
		catch (FechaIncorrectaException e1) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}

		// Fecha posterior a hoy
		try {
			emp = new Empleado("Pepe", Categoria.OBRERO, l12, false) ;
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
	
	// Sueldos brutos corresponden a los de tabla AVL
	@Test
	public void testCajaNegraMetodo() {

		try {
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1500.0);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d3, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 900.0);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d5, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 100.0);

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
			emp = new Empleado("Pepe", Categoria.OBRERO, d6, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 150.0);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d7, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1250.0);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d10, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1550.0);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d11, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 200);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d15, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1300);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d21, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 300);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d50, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1400);
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




	// CAJA BLANCA //

	@Test
	// Cobertura completa del metodo sueldoBruto()
	public void testCajaBlancaMetodo() {
		try {
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
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
	}
	

	@Test
	// Cobertura completa del constructor de empleados correctos.
	public void testCajaBlancaConstr() {

		Empresa emp = null ;

		emp = new Empresa();


		try {
			// Crea un empleado correcto de cada caso. 
			// Obrero , Contrato hoy , no baja
			emp.empleadosList.add(new Empleado("Pedro", Categoria.OBRERO  ) );

			// Directivo , Contrato hoy , no baja
			emp.empleadosList.add(new Empleado("Carlos", Categoria.DIRECTIVO  ) );

			// Gestor , Contrato hoy , no baja
			emp.empleadosList.add(new Empleado("Juan", Categoria.GESTOR  ) );

			// Obrero , Contrato +5 , no baja
			emp.empleadosList.add(new Empleado("Maria", d5, Categoria.OBRERO  ) );

			// Directivo , Contrato +5 , no baja
			emp.empleadosList.add(new Empleado("Lucia", d5,  Categoria.DIRECTIVO  ) );

			// Gestor , Contrato +5 , no baja
			emp.empleadosList.add(new Empleado("Juana", d5, Categoria.GESTOR  ) );

			LocalDate d10 = LocalDate.parse("2009-01-01");

			// Obrero , Contrato +10 , no baja
			emp.empleadosList.add(new Empleado("Manolo", d10, Categoria.OBRERO  ) );

			// Directivo , Contrato +10 , no baja
			emp.empleadosList.add(new Empleado("Benito", d10,  Categoria.DIRECTIVO  ) );

			// Gestor , Contrato +10 , no baja
			emp.empleadosList.add(new Empleado("Carlos", d10, Categoria.GESTOR  ) );

			// Obrero , Contrato +20 , no baja
			emp.empleadosList.add(new Empleado("Paquita", d20, Categoria.OBRERO  ) );

			// Directivo , Contrato +20 , no baja
			emp.empleadosList.add(new Empleado("Axel", d20,  Categoria.DIRECTIVO  ) );

			// Gestor , Contrato +20 , no baja
			emp.empleadosList.add(new Empleado("Zelda", d20, Categoria.GESTOR  ) );


			// De Baja


			// Obrero , Contrato hoy , baja
			emp.empleadosList.add(new Empleado("Link" , Categoria.OBRERO , LocalDate.now(),true ) );

			// Directivo , Contrato hoy , baja
			emp.empleadosList.add(new Empleado("Mario" , Categoria.DIRECTIVO , LocalDate.now(),true  ) );

			// Gestor , Contrato hoy , baja
			emp.empleadosList.add(new Empleado("Luigi" ,Categoria.GESTOR ,  LocalDate.now(), true ) );

			// date +5

			// Obrero , Contrato +5 , baja
			emp.empleadosList.add(new Empleado("Maria 2", Categoria.OBRERO , d5, true  ) );

			// Directivo , Contrato +5 , baja
			emp.empleadosList.add(new Empleado("Lucia 2",  Categoria.DIRECTIVO  , d5, true ) );

			// Gestor , Contrato +5 , baja
			emp.empleadosList.add(new Empleado("Juana 2",  Categoria.GESTOR  , d5, true  ) );

			// date +10

			// Obrero , Contrato +10 , baja
			emp.empleadosList.add(new Empleado("Pedro 2",  Categoria.OBRERO , d10, true  ) );

			// Directivo , Contrato +10 , baja
			emp.empleadosList.add(new Empleado("Carlos 2",  Categoria.DIRECTIVO , d10, true   ) );

			// Gestor , Contrato +10 , baja
			emp.empleadosList.add(new Empleado("Juan 2", Categoria.GESTOR , d10, true  ) );

			// date +20

			// Obrero , Contrato +20 , baja
			emp.empleadosList.add(new Empleado("Pedro 2" , Categoria.OBRERO , d20, true ) );

			// Directivo , Contrato +20 , baja
			emp.empleadosList.add(new Empleado("Carlos 2", Categoria.DIRECTIVO , d20, true  ) );

			// Gestor , Contrato +20 , baja
			emp.empleadosList.add(new Empleado("Juan 2",  Categoria.GESTOR , d20, true ) );
		} catch (NullPointerException e) {
			Assert.fail("Datos nulos : NullPointerExecption");
		} catch (CategoriaIncorrectaException e) {
			Assert.fail("Error categoria no definida : CategoriaIncorrectaException");

		} catch (FechaIncorrectaException e) {
			Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		}
		
	}
}
