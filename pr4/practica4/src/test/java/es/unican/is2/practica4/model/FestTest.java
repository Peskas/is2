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
	public void GUItest() { 
		
		/// Comprobacion Aspecto :
		
		demo.button("btnCalcular").requireText("CALCULAR");
		demo.label("lblSueldo").requireText("SUELDO");
		demo.label("lblCategoria").requireText("Categor\u00EDa");
		demo.radioButton("btnBaja").requireText("Baja");
	
		/// Valores Por defecto :
		
		demo.textBox("txtFechaContratacion").requireText("dd/mm/yyyy");
		demo.radioButton("btnBaja").requireNotSelected()  ;
		demo.textBox("txtSueldo").requireEmpty();
		demo.comboBox("comboCategoria").requireSelection("DIRECTIVO");
		
		
	
		/// Valor Sueldo Correcto
	
		// Salario base por categoria 
		
		demo.textBox("txtFechaContratacion").setText("01/01/2020");
		demo.comboBox("comboCategoria").selectItem("DIRECTIVO");
		demo.radioButton("btnBaja").uncheck()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("1500.0") ;
			
		
		demo.textBox("txtFechaContratacion").setText("01/01/2020");
		demo.comboBox("comboCategoria").selectItem("GESTOR");
		demo.radioButton("btnBaja").uncheck()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("1200.0") ;
		
		
		demo.textBox("txtFechaContratacion").setText("01/01/2020");
		demo.comboBox("comboCategoria").selectItem("OBRERO");
		demo.radioButton("btnBaja").uncheck()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("100.0") ;
		
		
		// Complemento por antiguedad 
		
		demo.textBox("txtFechaContratacion").setText("01/01/2014");
		demo.comboBox("comboCategoria").selectItem("OBRERO");
		demo.radioButton("btnBaja").uncheck()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("150.0") ;
		
		demo.textBox("txtFechaContratacion").setText("01/01/2009");
		demo.comboBox("comboCategoria").selectItem("OBRERO");
		demo.radioButton("btnBaja").uncheck()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("200.0") ;
		
		demo.textBox("txtFechaContratacion").setText("01/01/1999");
		demo.comboBox("comboCategoria").selectItem("OBRERO");
		demo.radioButton("btnBaja").uncheck()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("300.0") ;
		
		
		// Descuento por baja
		
		demo.textBox("txtFechaContratacion").setText("01/01/2020");
		demo.comboBox("comboCategoria").selectItem("OBRERO");
		demo.radioButton("btnBaja").check()  ;
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("75.0") ;
		
		
		
		
		// Sleep para visualizar como se realiza el test
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}

}
