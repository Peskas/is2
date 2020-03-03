package Estados;
/**
 * @(#) EsperandoSalida.java
 */

import java.util.Scanner;

import Diseño.AlarmaHogar;
import TimeControler.TimedStateController;


public class EsperandoSalida extends EstadoAlarma  implements TimeControler.TimedState 
{
	
	private final int intervaloSalida = 30 * 1000;
	
	private Apagada estadoApagado;
	private Activada estadoActivada;
	

	
	// Metodos de estado
	
	public void entry( AlarmaHogar context )
	{
		
		System.out.println("ESTADO: Esperando Salida (30s).");
		timedStateController = new TimedStateController() ;
		timedStateController.startRelative(this, context, intervaloSalida) ;
	}
	
	public void doAction( AlarmaHogar context )
	{
		
	}
	
	public void exit( AlarmaHogar context )
	{
		timedStateController.cancel();
	}
	
	
	// metodos de señal en este estado

	public void alarmaOff( AlarmaHogar context )
	{
		estadoApagado = new Apagada();

		
		
		System.out.println("pasando a estado: Apagado");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);


			System.out.println("Introduzca contraseña: ");
			String txt = input.next();
			System.out.print(txt);
			context.setCodigoIntroducido(txt);

			if(context.getCodigoIntroducido().equals(context.getCodigoDesactivacion()) ){
				System.out.println("contraseña correcta");

				this.exit(context)  ;
				context.setEstado(estadoApagado)   ;  
				estadoApagado.entry(context)     ;
				estadoApagado.doAction(context);

			}else {
				System.out.println("Contraseña incorrecta");
			}

		
	}
	
	
	
	public void timeout(AlarmaHogar context) {
		estadoActivada = new Activada();
		
		this.exit(context);   
		context.setEstado(estadoActivada);
		context.pilotoAlarma.encender();
		estadoActivada.entry(context);   
		estadoActivada.doAction(context);   
		}
	
	
}
