package estados;
/**
 * @(#) EstadoAlarma.java
 */

import diseno.AlarmaHogar;
import timeController.TimedStateController;


public abstract class EstadoAlarma
{

	public TimedStateController timedStateController;

	public void entry( AlarmaHogar context ){}
	public void doAction( AlarmaHogar context ){}
	public void exit( AlarmaHogar context ){}

	public void alarmaOff( AlarmaHogar context ){}
	public void alarmaOn( AlarmaHogar context ){}
	public void intruso( AlarmaHogar context ){}
	public void off( AlarmaHogar context ){}
	
	public String getMensaje() {return "";}
	




}
