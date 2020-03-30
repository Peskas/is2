package es.unican.is2.practica4.model;

import java.time.*;

public class Empleado implements Comparable<Empleado>{

	private String nombre;
	private LocalDate fechaContratacion;
	private boolean baja;
	private Categoria categoria;


	public Empleado(String nombre, LocalDate fecha, Categoria cat) throws NullPointerException, CategoriaIncorrectaException, FechaIncorrectaException {
		this(nombre, cat, fecha, false);
	}

	public Empleado(String nombre, Categoria cat) throws NullPointerException, CategoriaIncorrectaException, FechaIncorrectaException { 
		this(nombre, cat, LocalDate.now(), false);
	}


	public Empleado(String nombre, Categoria cat ,  LocalDate fecha, Boolean baja ) throws NullPointerException, FechaIncorrectaException, CategoriaIncorrectaException{

		// Nombre
		if (nombre == null) {
			throw new NullPointerException() ;
		}else {
			this.nombre = nombre;
		}

		
		// Fecha
		if (fecha == null) {
			throw new NullPointerException() ;
		}else if( fecha.compareTo( LocalDate.now() ) > 0  ){
			throw new FechaIncorrectaException() ;
		}
		else {
			this.fechaContratacion = fecha; 
		}

		// Categoria
		if (cat == null) {
			throw new NullPointerException() ;
		} else {
			this.categoria = cat;
		}

		
		// Baja
		this.baja = baja;
	}



	public double sueldoBruto() throws DatoIncorrectoException, CategoriaIncorrectaException {

		// Sueldo base
		double sueldoBase = 0.0;

		switch( this.categoria ) {
		case DIRECTIVO :
			sueldoBase = 1500.0 ;
			break ;
		case GESTOR:
			sueldoBase = 1200.0 ;
			break;
		case OBRERO:
			sueldoBase = 100.0 ;
			break;
		default:
			throw new CategoriaIncorrectaException();
		}

		// Complemento antiguedad
		double complAntiguedad = 0;
		LocalDate fechaActual = LocalDate.now();
		Period period = Period.between(this.fechaContratacion , fechaActual);

		if( period.getYears() <= 5 ){

			complAntiguedad = 0.0 ;

		}else if( period.getYears() <= 10 ){

			complAntiguedad = 50.0 ;

		}else if(period.getYears() <=20 ){

			complAntiguedad = 100.0 ;

		}else if(period.getYears() > 20 ){

			complAntiguedad = 200.0 ;

		}

		double sueldoBruto = sueldoBase + complAntiguedad ;	
		double reduccionBaja = 25.0 ;

		if( this.baja ){
			sueldoBruto = sueldoBruto *  (1 - reduccionBaja/100) ;
		}

		return sueldoBruto;
	}


	public String getNombre() {
		return nombre;
	}
 
	public boolean isBaja() {
		return baja;
	}

	public void darAlta() {
		this.baja = false;
	}

	public void darBaja() {
		this.baja = true;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public int compareTo(Empleado arg0) {
		
		
		return 0;
	}
}
