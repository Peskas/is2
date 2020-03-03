/**
 * @(#) AlarmaHogar.java
 */

package Diseño;

import Estados.EstadoAlarma;

public class AlarmaHogar
{
	
	
	private String codigoDesactivacion;
	
	private String codigoIntroducido;
	
	public int numIntentos;
	
	public boolean intrusoDetectado = false ; 
	
	
	
	public Piloto pilotoAlarma;
	
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

	public String getCodigoIntroducido() {
		return codigoIntroducido;
	}

	public void setCodigoIntroducido(String codigoIntroducido) {
		this.codigoIntroducido = codigoIntroducido;
	}

	public String getCodigoDesactivacion() {
		return codigoDesactivacion;
	}

	public void setCodigoDesactivacion(String codigoDesactivacion) {
		this.codigoDesactivacion = codigoDesactivacion;
	}
	
	
}
