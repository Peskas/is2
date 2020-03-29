package es.unican.is2.practica4.model;

import java.time.LocalDate;

public class mainPrueba {

	public static void main(String[] args) {
		LocalDate l = LocalDate.now().plusDays(5);
		try {
			Empleado e = new Empleado( "Juan", l, Categoria.GESTOR);
		} catch (NullPointerException e) {
			
			e.printStackTrace();
		} catch (DatoIncorrectoException e) {
			
			e.printStackTrace();
		} catch (CategoriaIncorrectaException e) {
			
			e.printStackTrace();
		} catch (FechaIncorrectaException e) {
			
			e.printStackTrace();
		}

	}

}
