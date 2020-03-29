package es.unican.is2.practica4.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Empresa {

	ArrayList<Empleado> empleadosList ;

	public Empresa() throws NullPointerException, DatoIncorrectoException, CategoriaIncorrectaException, FechaIncorrectaException{
		this.empleadosList = new ArrayList<Empleado>();
		
		rellenaPlantilla();
	}

	
	
	
	public ArrayList<Empleado> empleados(){
		return this.empleados();
	}

	public double costeNominas() throws DatoIncorrectoException, CategoriaIncorrectaException{

		double coste = 0; 

		Iterator<Empleado> it = this.empleadosList.iterator();

		while(it.hasNext() ){

			coste += it.next().sueldoBruto() ;
		}

		return coste ;
	}


	private void rellenaPlantilla() throws NullPointerException, DatoIncorrectoException, CategoriaIncorrectaException, FechaIncorrectaException {


		// Obrero , Contrato hoy , no baja
		this.empleadosList.add(new Empleado("Pedro", Categoria.OBRERO  ) );

		// Directivo , Contrato hoy , no baja
		this.empleadosList.add(new Empleado("Carlos", Categoria.DIRECTIVO  ) );

		// Gestor , Contrato hoy , no baja
		this.empleadosList.add(new Empleado("Juan", Categoria.GESTOR  ) );

		LocalDate date5 = LocalDate.parse("2014-01-01");

		// Obrero , Contrato +5 , no baja
		this.empleadosList.add(new Empleado("Maria", date5, Categoria.OBRERO  ) );

		// Directivo , Contrato +5 , no baja
		this.empleadosList.add(new Empleado("Lucia", date5,  Categoria.DIRECTIVO  ) );

		// Gestor , Contrato +5 , no baja
		this.empleadosList.add(new Empleado("Juana", date5, Categoria.GESTOR  ) );

		LocalDate date10 = LocalDate.parse("2009-01-01");

		// Obrero , Contrato +10 , no baja
		this.empleadosList.add(new Empleado("Manolo", date10, Categoria.OBRERO  ) );

		// Directivo , Contrato +10 , no baja
		this.empleadosList.add(new Empleado("Benito", date10,  Categoria.DIRECTIVO  ) );

		// Gestor , Contrato +10 , no baja
		this.empleadosList.add(new Empleado("Carlos", date10, Categoria.GESTOR  ) );

		LocalDate date20 = LocalDate.parse("1999-01-01");

		// Obrero , Contrato +20 , no baja
		this.empleadosList.add(new Empleado("Paquita", date20, Categoria.OBRERO  ) );

		// Directivo , Contrato +20 , no baja
		this.empleadosList.add(new Empleado("Axel", date20,  Categoria.DIRECTIVO  ) );

		// Gestor , Contrato +20 , no baja
		this.empleadosList.add(new Empleado("Zelda", date20, Categoria.GESTOR  ) );

		
		// De Baja
		
		
		// Obrero , Contrato hoy , baja
		this.empleadosList.add(new Empleado("Link" , Categoria.OBRERO , LocalDate.now(),true ) );

		// Directivo , Contrato hoy , baja
		this.empleadosList.add(new Empleado("Mario" , Categoria.DIRECTIVO , LocalDate.now(),true  ) );

		// Gestor , Contrato hoy , baja
		this.empleadosList.add(new Empleado("Luigi" ,Categoria.GESTOR ,  LocalDate.now(), true ) );

		// date +5
		
		// Obrero , Contrato +5 , baja
		this.empleadosList.add(new Empleado("Maria 2", Categoria.OBRERO , date5, true  ) );

		// Directivo , Contrato +5 , baja
		this.empleadosList.add(new Empleado("Lucia 2",  Categoria.DIRECTIVO  , date5, true ) );

		// Gestor , Contrato +5 , baja
		this.empleadosList.add(new Empleado("Juana 2",  Categoria.GESTOR  , date5, true  ) );

		// date +10

		// Obrero , Contrato +10 , baja
		this.empleadosList.add(new Empleado("Pedro 2",  Categoria.OBRERO , date10, true  ) );

		// Directivo , Contrato +10 , baja
		this.empleadosList.add(new Empleado("Carlos 2",  Categoria.DIRECTIVO , date10, true   ) );

		// Gestor , Contrato +10 , baja
		this.empleadosList.add(new Empleado("Juan 2", Categoria.GESTOR , date10, true  ) );

		// date +20

		// Obrero , Contrato +20 , baja
		this.empleadosList.add(new Empleado("Pedro 2" , Categoria.OBRERO , date20, true ) );

		// Directivo , Contrato +20 , baja
		this.empleadosList.add(new Empleado("Carlos 2", Categoria.DIRECTIVO , date20, true  ) );

		// Gestor , Contrato +20 , baja
		this.empleadosList.add(new Empleado("Juan 2",  Categoria.GESTOR , date20, true ) );





	}




}
