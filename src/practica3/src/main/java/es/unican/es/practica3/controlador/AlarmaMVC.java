package es.unican.es.practica3.controlador;

import es.unican.es.practica3.modelo.*;
import es.unican.es.practica3.vista.*;

public class AlarmaMVC {
	
	public static void main(String[] args) {
		AlarmaHogar alarma = new AlarmaHogar();
		Apagada estadoInicial = new Apagada();
		alarma.setEstado(estadoInicial);
		@SuppressWarnings("unused")
		Interfaz vista = new Interfaz(alarma);
		InterfazSenales senales = new InterfazSenales(alarma); 
		senales.mostrar();
	}

}
