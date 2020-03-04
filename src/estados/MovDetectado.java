package estados;
/**
 * @(#) MovDetectado.java
 */


import diseno.AlarmaHogar;
import timeController.TimedStateController;


public class MovDetectado extends EstadoAlarma implements timeController.TimedState 
{
	private final int intervaloDesactivacion = 10 * 1000;
	private Apagada estadoApagado;
	private IntrusoDetectado estadoIntrusoDetectado;
	
	public void entry( AlarmaHogar context )
	{
		System.out.println("ESTADO: Mov detectado.");
		context.numIntentos=0;

		
		System.out.println("10s para desactivar");
		timedStateController = new TimedStateController();
		timedStateController.startRelative(this, context, intervaloDesactivacion) ;
	}
	
	public void doAction( AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		timedStateController.cancel();
	}
	

	public void alarmaOff( AlarmaHogar context )
	{
		estadoApagado = new Apagada();
		
		System.out.println("Pasando a estado: Apagado");
		System.out.println("Introduzca contrasena: ");

		if(context.numIntentos > 3) {
			System.out.println("Bloqueado");
			context.setMsg("Maximo numero de intentos permitidos");
			
		}else if(context.getCodigoIntroducido().equals(context.getCodigoDesactivacion())
				&& context.numIntentos < 3 ){
			System.out.println("Contrasena correcta");
			context.setMsg("La contrasena es correcta!");
			this.exit(context);
			context.setEstado(estadoApagado);
			estadoApagado.entry(context);
			estadoApagado.doAction(context);
			
		} else {
			context.numIntentos++;
			context.setMsg("Intento"+context.numIntentos+"/3 ");
			System.out.println("Contrasena incorrecta, "+context.numIntentos+"/3 ");
		}

	}
	
	
	public void timeout(AlarmaHogar context) {
		estadoIntrusoDetectado = new IntrusoDetectado();
		this.exit(context);   
		context.setEstado(estadoIntrusoDetectado);
		estadoIntrusoDetectado.entry(context);   
		estadoIntrusoDetectado.doAction(context);   
		}
}
