package Estados;
/**
 * @(#) Apagada.java
 */

import Diseño.AlarmaHogar;

public class Apagada extends EstadoAlarma
{
	public void entry( AlarmaHogar context )
	{
		context.pilotoAlarma.apagar();
		context.intrusoDetectado = false ; 
	}
	
	public void doAction( AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		
	}
	
	public void alarmaOn( AlarmaHogar context )
	{
		
	}
	
	
}
