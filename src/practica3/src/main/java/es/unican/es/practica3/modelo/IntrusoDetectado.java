package es.unican.es.practica3.modelo;
/**
 * @(#) IntrusoDetectado.java
 */

import es.unican.es.practica3.controlador.AlarmaHogar;

public class IntrusoDetectado extends EstadoAlarma
{
	private Apagada estadoApagado;

	
	public void entry( AlarmaHogar context )
	{
		System.out.println("ESTADO: intruso detectado.");
		
	}
	
	public void doAction( AlarmaHogar context )
	{
		// Avisar a centralita del intruso
	}
	
	public void exit( AlarmaHogar context )
	{
		
	}
	
	public void off( AlarmaHogar context )
	{
		System.out.println("pasando a estado: Apagado (OFF)");
		estadoApagado = new Apagada();
		this.exit(context)  ;
		context.setEstado(estadoApagado)   ;  
		estadoApagado.entry(context)     ;
		estadoApagado.doAction(context);
	}

	
}
