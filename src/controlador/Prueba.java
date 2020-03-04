package controlador;

import modelo.*;



public class Prueba {

	public static void main(String[] args) throws InterruptedException {
		
		AlarmaHogar alarma = new AlarmaHogar();
		
		System.out.println("Iniciando..");
		
		
		Activada estadoInicial = new Activada();
		alarma.setEstado(estadoInicial);
		//System.out.println(alarma.getCodigoDesactivacion());
		alarma.alarmaOff();
		
		System.out.println("-------------");
		Thread.sleep(5000);
		
		alarma.alarmaOn();
		
		Thread.sleep(5000);
		alarma.alarmaOff();

		
		System.out.println("-------------");
		Thread.sleep(40000);
		System.out.println("-------------");

		alarma.intruso();
		
				
		System.out.println("-------------");
		Thread.sleep(1000);
		
		alarma.alarmaOff();
		
		
		Thread.sleep(40000);
		System.out.println("-------------");
		alarma.off();
	}

}
