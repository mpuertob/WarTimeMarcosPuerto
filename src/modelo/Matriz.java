package modelo;

import java.util.HashMap;

public class Matriz<K, E> {
	// vamos a hacer una matriz bidireccional
	private Dimension dimension;
	HashMap<K, E> elements = new HashMap<K, E>();
	HashMap<E, K> reverse = new HashMap<E, K>();

	public Matriz(Dimension dimension) {
		super();
		this.dimension = dimension;
	}

	public E insertElement(K coordinate, E element) {
		E put = elements.put(coordinate, element);
		reverse.put(element, coordinate);
		return put;
	}

	public E getElement(K coord) {
		return elements.get(coord);
	}

	public K getClave(E element) {
		return reverse.get(element);
	}

	// las clases parametrizadas no permiten la sobrecarga de tipos parametrizados
//	public boolean contiene(E e) {
//		return getClave(e)!=null;
//	}
//
//	public boolean contiene(K k) {
//		return getElement(k)!=null;
//	}
	public boolean contieneElemento(E e) {
		return getClave(e) != null;
	}

	public boolean contieneClave(K k) {
		return getElement(k) != null;
	}

}
