package estados;
/**
 * @(#) Apagada.java
 */

import diseno.AlarmaHogar;

public class Apagada extends EstadoAlarma
{
	private EsperandoSalida estadoEsperandoSalida;


	
	public void entry( AlarmaHogar context )
	{
		System.out.println("ESTADO: Apagado.");
		context.pilotoAlarma.apagar();
		context.desactivarSensores();
	}
	
	public void doAction( AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		
	}
	
	public void alarmaOn( AlarmaHogar context )
	{
		System.out.println("pasando a estado: Esperando salida");

		estadoEsperandoSalida = new EsperandoSalida();

		this.exit(context)  ;
		context.setEstado(estadoEsperandoSalida)   ;  

		//Acciones asociadas a la transición  
		context.pilotoAlarma.parpadear();

		estadoEsperandoSalida.entry(context)     ;
		estadoEsperandoSalida.doAction(context);
	}
	
	
}
