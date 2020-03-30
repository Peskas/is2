package es.unican.is2.practica4.model;

import es.unican.is2.practica4.ListaOrdenadaAcotada.*;


public class Empresa {

	ListaOrdenadaAcotada<Empleado> empleadosList ;

	public Empresa(){
		this.empleadosList = new ListaOrdenadaAcotada<Empleado>(); 
	}

	public ListaOrdenadaAcotada<Empleado> empleados(){
		return this.empleados();
	}

	public double costeNominas() throws DatoIncorrectoException, CategoriaIncorrectaException{

		double coste = 0; 
		for (int i = 0 ; i< this.empleados().size() ;i++ ){

			coste += this.empleados().get(i).sueldoBruto() ;
		}

		return coste ;
	}







}
