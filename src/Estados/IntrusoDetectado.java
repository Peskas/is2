package Estados;
/**
 * @(#) IntrusoDetectado.java
 */

import Diseño.AlarmaHogar;

public class IntrusoDetectado extends EstadoAlarma
{
	public void entry( AlarmaHogar context )
	{
		context.numIntentos=0;
		context.intrusoDetectado=true;
	}
	
	public void doAction( Diseño.AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		
	}
	
	public void off( AlarmaHogar context )
	{
		
	}
	
	
}
