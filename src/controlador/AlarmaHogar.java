/**
 * @(#) AlarmaHogar.java
 */

package controlador;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import modelo.EstadoAlarma;

public class AlarmaHogar
{
	
	private EstadoAlarma stateActual;
	
	private String msg = " ";  
	private String codigoDesactivacion = "1234";
	private String codigoIntroducido= "xxxx";
	public int numIntentos;
	public Piloto pilotoAlarma = new Piloto();
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	
	public void notificarCentralita( )
	{
		
	}
	
	public void desactivarSensores( )
	{
		System.out.println("Sensores Desactivados");
	}
	
	public void activarSensores( )
	{
		System.out.println("Sensores Activados");
	}
	
	public void setEstado( EstadoAlarma state )
	{
		EstadoAlarma ant = this.stateActual;
		this.stateActual = state; 
		changeSupport.firePropertyChange("estado",ant,stateActual);
	}
	
	public EstadoAlarma getEstado( )
	{
		return this.stateActual; 
	}
	
	public void alarmaOff( )
	{
		stateActual.alarmaOff(this);
	}
	
	public void intruso( )
	{		
		stateActual.intruso(this);
	}
	
	public void off( )
	{
		stateActual.off(this);
	}
	
	public void alarmaOn( )
	{
		stateActual.alarmaOn(this);
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void addPropertyChangeListener (PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}
	
	
}
