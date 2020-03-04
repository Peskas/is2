package modelo;
/**
 * @(#) EsperandoSalida.java
 */



import controlador.AlarmaHogar;
import timeController.TimedStateController;


public class EsperandoSalida extends EstadoAlarma  implements timeController.TimedState 
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
	
	
	// metodos de senal en este estado

	public void alarmaOff( AlarmaHogar context )
	{
		estadoApagado = new Apagada();

		System.out.println("Pasando a estado: Apagado");
		System.out.println("Introduzca contrasena: ");
	
		if(context.getCodigoIntroducido().equals(context.getCodigoDesactivacion()) ){
			System.out.println("contrasena correcta");
			context.setMsg("La contrasena es correcta!");
			this.exit(context)  ;
			context.setEstado(estadoApagado)   ;  
			estadoApagado.entry(context)     ;
			estadoApagado.doAction(context);
	
		}else {
			System.out.println("Contrasena incorrecta");
			context.setMsg("La contrasena es incorrecta!");
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
