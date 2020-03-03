package Estados;
/**
 * @(#) MovDetectado.java
 */

import java.util.Scanner;

import Diseño.AlarmaHogar;
import TimeControler.TimedStateController;




public class MovDetectado extends EstadoAlarma implements TimeControler.TimedState 
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
		

		System.out.println("pasando a estado: Apagado");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);




			if(context.numIntentos > 3) {
				System.out.println("Bloqueado");
				
			}else {
				System.out.println("Introduzca contraseña: ");
				String txt = input.next();
				System.out.print(txt);
				context.setCodigoIntroducido(txt);
			}
				
			if(context.getCodigoIntroducido().equals(context.getCodigoDesactivacion())
					&& context.numIntentos <= 3 ){
				System.out.println("contraseña correcta");

				this.exit(context)  ;
				context.setEstado(estadoApagado)   ;  
				estadoApagado.entry(context)     ;
				estadoApagado.doAction(context);


			}else {
				context.numIntentos++;
				System.out.println("movimiento detectado, contraseña incorrecta, "+context.numIntentos+"/3 ");
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
