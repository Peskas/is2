package es.unican.es.practica3.timeController;

import es.unican.es.practica3.controlador.AlarmaHogar;


public interface TimedState {
	

	public void timeout(AlarmaHogar context);
	
	
}
