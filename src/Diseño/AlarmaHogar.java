/**
 * @(#) AlarmaHogar.java
 */

package Diseño;

import Estados.EstadoAlarma;

public class AlarmaHogar
{
	private final int intervaloSalida = 30;
	
	private final int intervaloDesactivacion = 10 ;
	
	private String codigoDesactivacion;
	
	private Piloto piloto;
	
	private Piloto pilotoAlarma;
	
	private EstadoAlarma state;
	
	
	
	public void notificarCentralita( )
	{
		
	}
	
	public void desactivarSensores( )
	{
		
	}
	
	public void activarSensores( )
	{
		
	}
	
	public void setEstado( EstadoAlarma state )
	{
		this.state = state; 
	}
	
	public void alarmaOff( )
	{
		
	}
	
	public void intruso( )
	{
		
	}
	
	public void off( )
	{
		
	}
	
	public void alarmaOn( )
	{
		
	}
	
	
}
