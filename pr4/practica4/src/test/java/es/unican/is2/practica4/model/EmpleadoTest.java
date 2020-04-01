package es.unican.is2.practica4.model;

import es.unican.is2.practica4.model.Categoria;
import es.unican.is2.practica4.model.Empleado;

import org.junit.Assert;

import java.time.*;

import org.junit.*;

public class EmpleadoTest {

	private Empleado emp;
	private LocalDate d;
	private LocalDate d5;
	private LocalDate d7;
	private LocalDate d10;
	private LocalDate d15;
	private LocalDate d20;
	private LocalDate d50;

	private LocalDate d5post;


	// Inicializa las variables del tiempo respecto a hoy

	@Before
	public void setUp() {

		// Hoy
		d = LocalDate.now();

		// Date hace n anos
		d5 = d.minusYears(5);
		d7 = d.minusYears(7);
		d10 = d.minusYears(10);
		d15 = d.minusYears(15);
		d20 = d.minusYears(20);
		d50 = d.minusYears(50);

		// Date en n anos posterior
		d5post = d.plusYears(5);
	}


	// CAJA NEGRA //

	// Constructores no validos
	@Test
	public void testCajaNegraConstr() {


		// Nombre null
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

		// Categoria Incorrecta
		
		//try {
		//	emp = new Empleado("Pepe", ?? , d, false) ;
		//	Assert.fail("No ha salido CategoriaIncorrectaException");
		//} catch (NullPointerException e1) {
		//	Assert.fail("Datos nulos : NullPointerExecption");
		//}
		//catch (FechaIncorrectaException e1) {
		//	Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
		//} 
		//catch (CategoriaIncorrectaException emp) {
		//	// Success
		//}


		// Fecha null
		try {
			emp = new Empleado("Pepe", Categoria.GESTOR, null, false) ;
			Assert.fail( "No ha salido NullPointerException" );
		} 
		catch (NullPointerException e1) {
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d5post, false) ;
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1125.0);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d10, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1162.5);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1200.0);

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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d50, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1700.0);
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
			emp = new Empleado("Pepe", Categoria.DIRECTIVO, d50, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1275.0);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d, false) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1200.0);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d7, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 937.5);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d15, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 975);
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
			emp = new Empleado("Pepe", Categoria.GESTOR, d50, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1050.0);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d5, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 75.0);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d7, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 112.5);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d15, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 150.0);
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
			emp = new Empleado("Pepe", Categoria.OBRERO, d50, true) ;
			Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 225.0);
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

	//@Test
	//// Cobertura completa del metodo sueldoBruto()
	//public void testCajaBlancaMetodo() {
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
    //
	//	try {
	//		emp = new Empleado("Pepe", Categoria.DIRECTIVO, d20, false) ;
	//		Assert.assertTrue("Valor no esperado", emp.sueldoBruto() == 1600);
	//	} catch (DatoIncorrectoException e1) {
	//		Assert.fail("Error sueldo bruto : DatoIncorrectoException");
	//	}
	//	catch (CategoriaIncorrectaException e1) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
	//	}
	//	catch (FechaIncorrectaException e1) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}catch(NullPointerException e1) {
	//		Assert.fail("Datos nulos : NullPointerExecption");
	//	}
	//}


	//@Test
	//// Cobertura completa del constructor de empleados correctos.
	//public void testCajaBlancaConstr() {
    //
	//	Empresa emp = null ;
    //
	//	emp = new Empresa(100);
    //
    //
	//	try {
	//		// Crea un empleado correcto de cada caso. 
	//		// Obrero , Contrato hoy , no baja
	//		emp.empleadosList.add(new Empleado("Pedro", Categoria.OBRERO  ) );
    //
	//		// Directivo , Contrato hoy , no baja
	//		emp.empleadosList.add(new Empleado("Carlos", Categoria.DIRECTIVO  ) );
    //
	//		// Gestor , Contrato hoy , no baja
	//		emp.empleadosList.add(new Empleado("Juan", Categoria.GESTOR  ) );
    //
	//		// Obrero , Contrato +5 , no baja
	//		emp.empleadosList.add(new Empleado("Maria", d5, Categoria.OBRERO  ) );
    //
	//		// Directivo , Contrato +5 , no baja
	//		emp.empleadosList.add(new Empleado("Lucia", d5,  Categoria.DIRECTIVO  ) );
    //
	//		// Gestor , Contrato +5 , no baja
	//		emp.empleadosList.add(new Empleado("Juana", d5, Categoria.GESTOR  ) );
    //
	//		// Obrero , Contrato +10 , no baja
	//		emp.empleadosList.add(new Empleado("Manolo", d10, Categoria.OBRERO  ) );
    //
	//		// Directivo , Contrato +10 , no baja
	//		emp.empleadosList.add(new Empleado("Benito", d10,  Categoria.DIRECTIVO  ) );
    //
	//		// Gestor , Contrato +10 , no baja
	//		emp.empleadosList.add(new Empleado("Carlos", d10, Categoria.GESTOR  ) );
    //
	//		// Obrero , Contrato +20 , no baja
	//		emp.empleadosList.add(new Empleado("Paquita", d20, Categoria.OBRERO  ) );
    //
	//		// Directivo , Contrato +20 , no baja
	//		emp.empleadosList.add(new Empleado("Axel", d20,  Categoria.DIRECTIVO  ) );
    //
	//		// Gestor , Contrato +20 , no baja
	//		emp.empleadosList.add(new Empleado("Zelda", d20, Categoria.GESTOR  ) );
    //
    //
	//		// De Baja
    //
    //
	//		// Obrero , Contrato hoy , baja
	//		emp.empleadosList.add(new Empleado("Link" , Categoria.OBRERO , d,true ) );
    //
	//		// Directivo , Contrato hoy , baja
	//		emp.empleadosList.add(new Empleado("Mario" , Categoria.DIRECTIVO , d,true  ) );
    //
	//		// Gestor , Contrato hoy , baja
	//		emp.empleadosList.add(new Empleado("Luigi" ,Categoria.GESTOR ,  d, true ) );
    //
	//		// date +5
    //
	//		// Obrero , Contrato +5 , baja
	//		emp.empleadosList.add(new Empleado("Maria 2", Categoria.OBRERO , d5, true  ) );
    //
	//		// Directivo , Contrato +5 , baja
	//		emp.empleadosList.add(new Empleado("Lucia 2",  Categoria.DIRECTIVO  , d5, true ) );
    //
	//		// Gestor , Contrato +5 , baja
	//		emp.empleadosList.add(new Empleado("Juana 2",  Categoria.GESTOR  , d5, true  ) );
    //
	//		// date +10
    //
	//		// Obrero , Contrato +10 , baja
	//		emp.empleadosList.add(new Empleado("Pedro 2",  Categoria.OBRERO , d10, true  ) );
    //
	//		// Directivo , Contrato +10 , baja
	//		emp.empleadosList.add(new Empleado("Carlos 2",  Categoria.DIRECTIVO , d10, true   ) );
    //
	//		// Gestor , Contrato +10 , baja
	//		emp.empleadosList.add(new Empleado("Juan 2", Categoria.GESTOR , d10, true  ) );
    //
	//		// date +20
    //
	//		// Obrero , Contrato +20 , baja
	//		emp.empleadosList.add(new Empleado("Pedro 2" , Categoria.OBRERO , d20, true ) );
    //
	//		// Directivo , Contrato +20 , baja
	//		emp.empleadosList.add(new Empleado("Carlos 2", Categoria.DIRECTIVO , d20, true  ) );
    //
	//		// Gestor , Contrato +20 , baja
	//		emp.empleadosList.add(new Empleado("Juan 2",  Categoria.GESTOR , d20, true ) );
	//	} catch (NullPointerException e) {
	//		Assert.faisl("Datos nulos : NullPointerExecption");
	//	} catch (CategoriaIncorrectaException e) {
	//		Assert.fail("Error categoria no definida : CategoriaIncorrectaException");
    //
	//	} catch (FechaIncorrectaException e) {
	//		Assert.fail("Fecha posterior a hoy : FechaIncorrectaException");
	//	}
    //
	//}
}
