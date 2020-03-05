package es.unican.is2.practica4.model;

import java.time.*;

public class Empleado {
	
	private String nombre;
	private LocalDate fechaContratacion;
	private boolean baja;
	private Categoria categoria;

	
	public Empleado(String nombre, LocalDate fecha, Categoria cat){
		this.nombre = nombre;
		this.fechaContratacion = fecha; //LocalDate.now();
		this.categoria = cat;
		this.baja = false;
	}
	
	public double sueldoBruto() throws DatoIncorrectoException {
		double sueldoBruto = 0;
		if(sueldoBruto > 0) {
			
		} else {
			throw new DatoIncorrectoException(Double.toString(sueldoBruto));
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
