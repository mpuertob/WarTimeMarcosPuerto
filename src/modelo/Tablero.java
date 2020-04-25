package modelo;

import vista.info.FichaInfo;

public class Tablero {
	private DimensionesTablero dimension;
	// Como tambien puede ser un castillo, habrá que remodelar esto
	private Matriz<Coordenada, Casilla> casillas;

	public Tablero(DimensionesTablero dimension) {
		super();
		this.dimension = new DimensionesTablero(dimension.getAncho(),dimension.getAlto());
		casillas = new Matriz<Coordenada, Casilla>(dimension);
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas.getElement(coordenada);
	}

	public void insertar(Batallon batallon,Coordenada coordenada) {
		casillas.insertElement(coordenada, batallon);
	}
	public void insertar(Casilla casilla,Coordenada coordenada) {
		casillas.insertElement(coordenada, casilla);
	}
}
