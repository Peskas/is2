package es.unican.is2.practica4.model;

import java.time.*;

public class Empleado {
	
	private String nombre;
	private LocalDate fechaContratacion;
	private boolean baja;
	private Categoria categoria;

	
	public Empleado(String nombre, LocalDate fecha, Categoria cat) throws DatoIncorrectoException, CategoriaIncorrectaException , NullPointerException {
		
		
		this.nombre = nombre;
		this.fechaContratacion = fecha; 
		this.categoria = cat;
		this.baja = false;
	}
	
	public Empleado(String nombre, Categoria cat){ 
		this.nombre = nombre;
		this.fechaContratacion = LocalDate.now();
		this.categoria = cat;
		this.baja = false;
	}
	
	public Empleado(String nombre, Categoria cat ,  LocalDate fecha, Boolean baja ){
		this.nombre = nombre;
		this.fechaContratacion = fecha;
		this.categoria = cat;
		this.baja = baja;
	}
	
	
	
	public double sueldoBruto() throws DatoIncorrectoException, CategoriaIncorrectaException {
		
		double sueldoBase = 0.0;
		
		switch( this.categoria ) {
		case DIRECTIVO :
			sueldoBase = 1500.0 ;
			break ;
		case GESTOR:
			sueldoBase = 1500.0 ;
			break;
		case OBRERO:
			sueldoBase = 1500.0 ;
			break;
		default:
			throw new CategoriaIncorrectaException();
		}
		
		double complAntiguedad = 0;
		LocalDate fechaActual = LocalDate.now();
		Period period = Period.between(this.fechaContratacion , fechaActual); 
		
		if( period.getYears() <= 5 ){
			
			complAntiguedad = 0.0 ; 
			
		}else if( period.getYears() > 5 ){
			
			complAntiguedad = 50.0 ;
			
		}else if(period.getYears() > 10 ){
			
			complAntiguedad = 100.0 ;
			
		}else if(period.getYears() > 20 ){
			
			complAntiguedad = 200.0 ;
			
		} // else default ¿?
			
		double sueldoBruto = sueldoBase + complAntiguedad ;	
		double reduccionBaja = 25.0 ;
		
		if( this.baja ){
			sueldoBruto = sueldoBruto *  (1 - reduccionBaja) ;
		}
			
		return sueldoBruto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean isBaja() {
		return baja;
	}
	
	public boolean darDeAlta() {
		boolean dadoAlta = false;
		return dadoAlta;
	}
	
	public boolean darBaja() {
		boolean dadoBaja = false;
		return dadoBaja;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}
}
