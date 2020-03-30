package es.unican.is2.practica4.model;


import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.practica4.gui.EmpleadosGUI;



public class FestTest {
	
	private FrameFixture demo;

	@Before
	public void setUp() {
		EmpleadosGUI gui = new EmpleadosGUI();
		demo = new FrameFixture(gui);
		gui.setVisible(true);	
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		// Comprobamos que la interfaz tiene el aspecto deseado
		demo.button("btnPulsar").requireText("¡Pulsa!");
		
		//  Prueba de saludo con nombre
		// Escribimos un nombre
		demo.textBox("txtNombre").enterText("Patri");
		// Pulsamos el botón
		demo.button("btnPulsar").click();		
		// Comprobamos la salida
		demo.textBox("txtSaludo").requireText("¡Hola Patri!");
		
		// Prueba de saludo sin nombre
		demo.textBox("txtNombre").setText("");
		demo.button("btnPulsar").click();
		demo.textBox("txtSaludo").requireText("¡Hola!");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
