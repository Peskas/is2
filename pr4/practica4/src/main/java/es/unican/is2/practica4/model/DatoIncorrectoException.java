package es.unican.is2.practica4.model;

public class DatoIncorrectoException extends Exception { 
	private static final long serialVersionUID = 1L;

	public DatoIncorrectoException(String errorMessage) {
        super(errorMessage);
    }
}