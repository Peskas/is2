package diseno;

import estados.*;
import vista.Interfaz;
import vista.InterfazSenales;

public class AlarmaMVC {
	
	public static void main(String[] args) {
		AlarmaHogar alarma = new AlarmaHogar();
		Apagada estadoInicial = new Apagada();
		alarma.setEstado(estadoInicial);
		Interfaz vista = new Interfaz(alarma);
		InterfazSenales senales = new InterfazSenales(alarma); 
		senales.mostrar();
	}

}
