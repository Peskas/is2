package es.unican.is2.practica4.ListaOrdenadaAcotada;

import es.unican.is2.listaOrdenadaAcotada.IListaAcotada;

public class ListaOrdenadaAcotada<E extends Comparable<E>> implements IListaAcotada<E> {

	public final static int MAX_POR_OMISION = 10;
	// El array
	private E[] lista;
	private int ultimo;

	/**
	 * Constructor al que se le pasa el tama�o maximo de la lista
	 * 
	 * @param max
	 */
	@SuppressWarnings("unchecked")
	public ListaOrdenadaAcotada(int max) {
		
		if(max == 0) {
			throw new NullPointerException();
		}else {
		
		lista = (E[]) new Comparable[max];
		ultimo = -1;
		}
	}

	/**
	 * Constructor que crea la lista con un tama�o igual a maxPorOmision
	 */
	public ListaOrdenadaAcotada() {
		this(MAX_POR_OMISION);
	}

	public E get(int indice) {
		
		if (indice > ultimo) {
			throw new IndexOutOfBoundsException();
		}else if(indice < 0) {
			throw new IndexOutOfBoundsException();
		}else {	
		return lista[indice];
		}
	}

	public void add(E elemento) {


		if(elemento != null) {

			// compruebo si cabe
			if (ultimo == lista.length - 1) {
				throw new IllegalStateException();
			}
			// busca el lugar donde debe insertarse
			int indice = 0;
			if (ultimo != -1) {

				while (indice <= ultimo && elemento.compareTo(lista[indice]) <= 0) {
					indice++;
				}
			}
			// desplaza elementos hacia adelante
			for (int i = ultimo; i > indice; i--) {
				lista[i + 1] = lista[i];
			}
			// a�ade el elemento
			lista[indice] = elemento;
			ultimo++;
		}
	}

	public E remove(int indice) {
		
		
		if (indice > ultimo) {
			throw new IndexOutOfBoundsException();
		}else if(indice < 0) {
			throw new IndexOutOfBoundsException();
		}else {
		E borrado = lista[indice];
		// desplaza elementos hacia atras
		for (int i = indice + 1; i <= ultimo; i++) {
			lista[i - 1] = lista[i];
		}
		// actualiza ultimo y retorna el elemento borrado
		ultimo--;
		return borrado;
		}
	}

	public int size() {
		return ultimo + 1;
	}

	public void clear() {
		ultimo = -1;

	}

}
