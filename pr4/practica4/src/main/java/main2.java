import es.unican.is2.practica4.model.CategoriaIncorrectaException;
import es.unican.is2.practica4.model.DatoIncorrectoException;
import es.unican.is2.practica4.model.Empresa;
import es.unican.is2.practica4.model.FechaIncorrectaException;

public class main2 {

	public static void main(String[] args) {
		
		Empresa emp = null ;
		try {
			emp = new Empresa();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatoIncorrectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CategoriaIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FechaIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		double nominas = 0;
		try {
			nominas = emp.costeNominas();
		} catch (DatoIncorrectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CategoriaIncorrectaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("nominas: ");
		System.out.println(nominas);

	}

}
