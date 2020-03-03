package Estados;
/**
 * @(#) MovDetectado.java
 */

import Diseño.AlarmaHogar;




public class MovDetectado extends EstadoAlarma implements TimeControler.TimedState 
{
	private final int intervaloDesactivacion = 10 * 1000;
	private MovDetectado estadoMovDetectado;
	
	
	public void entry( AlarmaHogar context )
	{
		timedStateController.startRelative(this, context, intervaloDesactivacion) ;

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
		context.setEstado(estadoMovDetectado);
		estadoMovDetectado.entry(context);   
		estadoMovDetectado.doAction(context);   
		}
	
}
