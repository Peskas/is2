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
		// Comprobacion Aspecto :
		
		demo.button("btnCalcular").requireText("CALCULAR");
		demo.label("lblSueldo").requireText("SUELDO");
		demo.label("lblCategoria").requireText("Categor\u00EDa");
		demo.radioButton("btnBaja").requireText("Baja");
	
		// Valores Por defecto :
		
		demo.textBox("txtFechaContratacion").requireText("dd/mm/yyyy");
		demo.radioButton("btnBaja").requireNotSelected()  ;
		demo.textBox("txtSueldo").requireEmpty();
		//demo.textBox("txtSueldo").requireNotEditable() ;
		demo.comboBox("comboCategoria").requireSelection("DIRECTIVO");
		
		
		
		
		//  Prueba de saludo con nombre
		// Escribimos un nombre
		//demo.textBox("txtNombre").enterText("Patri");
		// Pulsamos el botón
		//demo.button("btnPulsar").click();		
		// Comprobamos la salida
		//demo.textBox("txtSaludo").requireText("¡Hola Patri!");
		
		// Prueba de saludo sin nombre
		//demo.textBox("txtNombre").setText("");
		//demo.button("btnPulsar").click();
		//demo.textBox("txtSaludo").requireText("¡Hola!");
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}

}
