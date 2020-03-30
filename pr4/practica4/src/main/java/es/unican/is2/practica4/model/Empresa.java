package es.unican.is2.practica4.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Empresa {

	ArrayList<Empleado> empleadosList ;

	public Empresa(){
		this.empleadosList = new ArrayList<Empleado>(); 
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







}
