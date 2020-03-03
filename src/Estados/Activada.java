package Estados;
/**
 * @(#) Activada.java
 */

import java.util.Scanner;

import Diseño.AlarmaHogar;

public class Activada extends EstadoAlarma
{
	
	private Apagada estadoApagado;
	private MovDetectado estadoMovDetectado;
	
	public void entry( AlarmaHogar context )
	{
		System.out.println("ESTADO: Activado.");
		context.activarSensores();
	}

	public void doAction( AlarmaHogar context )
	{

	}

	public void exit( AlarmaHogar context )
	{
		System.out.println("EXIT ESTADO: Activado.");
	}

	
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
	
	public void intruso( AlarmaHogar context )
	{
		System.out.println("pasando a estado: Intruso detectado");
		estadoMovDetectado = new MovDetectado();

		this.exit(context)  ;
		context.setEstado(estadoMovDetectado)   ;  
		estadoMovDetectado.entry(context)     ;
		estadoMovDetectado.doAction(context);
	}
	
}
