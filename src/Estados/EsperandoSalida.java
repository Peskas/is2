package Estados;
/**
 * @(#) EsperandoSalida.java
 */

import Diseño.AlarmaHogar;

public class EsperandoSalida extends EstadoAlarma  implements TimeControler.TimedState 
{
	
	private final int intervaloSalida = 30 * 1000;
	
	private Activada estadoActivada;
	
	public void entry( AlarmaHogar context )
	{
		
		timedStateController.startRelative(this, context, intervaloSalida) ;
	}
	
	public void doAction( AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		
	}
	
	public void alarmaOff( AlarmaHogar context )
	{
		
	}
	
	public void timeout(AlarmaHogar context) {
		this.exit(context);   
		context.setEstado(estadoActivada);
		estadoActivada.entry(context);   
		estadoActivada.doAction(context);   
		}
	
	
}
