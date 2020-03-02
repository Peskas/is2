package Estados;
/**
 * @(#) EstadoAlarma.java
 */

import Diseño.AlarmaHogar;

public abstract class EstadoAlarma
{
	private Apagada estadoApagado;
	
	private EsperandoSalida estadoEsperandoSalida;
	
	private Activada estadoActivada;
	
	private MovDetectado estadoMovDetectado;
	
	private IntrusoDetectado estadoIntrusoDetectado;
	
	public void alarmaOff( AlarmaHogar context )
	{
		
	}
	
	public void alarmaOn( AlarmaHogar context )
	{
		
	}
	
	public void intruso( AlarmaHogar context )
	{
		
	}
	
	public void off( AlarmaHogar context )
	{
		
	}
	
	public void entry( AlarmaHogar context )
	{
		
	}
	
	public void doAction( AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		
	}
	
	
}
