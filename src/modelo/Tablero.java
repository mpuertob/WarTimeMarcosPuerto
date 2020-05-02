package modelo;

import vista.info.FichaInfo;

public class Tablero {
	private Dimension dimension;
	// Como tambien puede ser un castillo, habrá que remodelar esto
	private Matriz<Coordenada, Casilla> casillas;

	public Tablero(Dimension dimension) {
		super();
		this.dimension = new Dimension(dimension.getAncho(), dimension.getAncho());
		casillas = new Matriz<Coordenada, Casilla>(dimension);
	}

	public int getAncho() {
		return dimension.getAncho();
	}

	public int getAlto() {
		return dimension.getAlto();
	}

	public Casilla getCasilla(Coordenada coordenada) {
		return casillas.getElement(coordenada);
	}

	public boolean insertar(Casilla casilla, Coordenada coordenada) {
		boolean response = false;
		if (!casillas.contieneElemento(casilla) && !casillas.contieneClave(coordenada)) {
			casillas.insertElement(coordenada, casilla);
			response=true;
		}
		return response;
	}
	
}
