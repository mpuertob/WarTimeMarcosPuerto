package modelo;

import vista.info.FichaInfo;

public class Tablero {
	private Dimension dimension;
	// Como tambien puede ser un castillo, habrá que remodelar esto
	private Matriz<Coordenada, Casilla> casillas;

	public Tablero(Dimension dimension) {
		super();
		this.dimension = new Dimension(dimension.getAncho(),dimension.getAlto());
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
