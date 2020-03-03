package Estados;
/**
 * @(#) EstadoAlarma.java
 */

import Diseño.AlarmaHogar;
import TimeControler.TimedStateController;

public abstract class EstadoAlarma
{
	private Apagada estadoApagado;
	
	private EsperandoSalida estadoEsperandoSalida;
	
	private IntrusoDetectado estadoIntrusoDetectado;
	
	public TimedStateController timedStateController;

	
	public void alarmaOff( AlarmaHogar context )
	{
		if(context.getCodigoIntroducido().equals(context.getCodigoDesactivacion())
				&& context.numIntentos <= 3 ){
			
			this.exit(context)  ;
			context.setEstado(estadoApagado)   ;  
			estadoApagado.entry(context)     ;
			estadoApagado.doAction(context);
			
		}else if(context.intrusoDetectado == true){
			context.numIntentos++;
		}

	}
	
	public void alarmaOn( AlarmaHogar context )
	{
		this.exit(context)  ;
		context.setEstado(estadoEsperandoSalida)   ;  
		
		//Acciones asociadas a la transición  
		context.pilotoAlarma.parpadear();
		
		estadoEsperandoSalida.entry(context)     ;
		estadoEsperandoSalida.doAction(context);
	}
	
	public void intruso( AlarmaHogar context )
	{
		this.exit(context)  ;
		context.setEstado(estadoIntrusoDetectado)   ;  
		estadoIntrusoDetectado.entry(context)     ;
		estadoIntrusoDetectado.doAction(context);
	}
	
	public void off( AlarmaHogar context )
	{
		this.exit(context)  ;
		context.setEstado(estadoApagado)   ;  
		estadoApagado.entry(context)     ;
		estadoApagado.doAction(context);
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
