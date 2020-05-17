package control;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Rango;
import modelo.Tablero;
import modelo.Tipo;
import utiles.Utiles;
import vista.FichaBatallon;
import vista.FichaCastillo;

public class ConsumirTurnoController {
	private Juego juego;
	private JPanel panel;

	public ConsumirTurnoController(Juego juego) {
		this.juego = juego;
	}

	public void moverBatallon(Coordenada coordenadaOrigen, Coordenada coordenadaDestino) {
		// Obtenemos la casilla que quiero mover
		Tablero tablero = juego.getTablero();
		Casilla casilla = tablero.getCasilla(coordenadaOrigen);
		Casilla casillaDos = tablero.getCasilla(coordenadaDestino);
		boolean isVacia = (casillaDos == null);
		// Si la casilla esta vacia mueve, sino confronta
		if (isVacia) {
			Ejercito ejercitoActual = juego.getEjercitoActual();
			Batallon batallon = (Batallon) casilla;
			Tipo tipoBatallon = batallon.getTipo();
			Rango rangoMovilidad = tipoBatallon.getMovilidad();
			boolean isCastillo = casilla instanceof FichaCastillo;
			boolean coordenadaCorrecta = validarCoordenada(coordenadaOrigen, coordenadaDestino, rangoMovilidad);
			boolean isEnSuMitad = tablero.isEnSuMitad(ejercitoActual, coordenadaDestino);
			boolean cumpleRequisitos = !isCastillo && coordenadaCorrecta && isEnSuMitad;
			if (cumpleRequisitos) {
				moverYpasarTurno(tablero, casilla, coordenadaDestino);
			}
		} else {
			confrontarBatallon(coordenadaOrigen, coordenadaDestino);
		}

	}

	public void confrontarBatallon(Coordenada coordenadaOrigen, Coordenada coordenadaDestino) {
		Tablero tablero = juego.getTablero();
		Casilla casilla = tablero.getCasilla(coordenadaOrigen);
		Batallon batallon = (Batallon) casilla;
		Tipo tipoBatallon = batallon.getTipo();
		Rango rangoAtaque = tipoBatallon.getAtaque();
		boolean isEnSuMitad = tablero.isEnSuMitad(juego.getEjercitoActual(), coordenadaDestino);
		boolean coordenadaCorrecta = validarCoordenada(coordenadaOrigen, coordenadaDestino, rangoAtaque);
		if (!isEnSuMitad && coordenadaCorrecta) {
			System.out.println("Vamos a pelearnos, iniciamos la guerra");
			getJuego().siguienteTurno();
			this.panel = null;
		}
	}

	private void moverYpasarTurno(Tablero tablero, Casilla casilla, Coordenada coordenadaInsertar) {
		tablero.borrar(casilla);
		tablero.insertar(casilla, coordenadaInsertar);
		getJuego().siguienteTurno();
		this.panel = null;
	}

	private boolean validarCoordenada(Coordenada origen, Coordenada destino, Rango rango) {
		int xOrigen = origen.getX();
		int yOrigen = origen.getY();
		boolean respuesta = false;
		int rangoMaximo = rango.getMaximo();
		for (int i = xOrigen - rangoMaximo; i <= xOrigen + rangoMaximo; i++) {
			for (int j = yOrigen - rangoMaximo; j <= yOrigen + rangoMaximo; j++) {
				Coordenada nuevaCoordenada = new Coordenada(i, j);
				if (nuevaCoordenada.equals(destino) && calculaDistancia(origen, destino) == rangoMaximo) {
					respuesta = true;
				}
			}
		}
		return respuesta;
	}

	public static int calculaDistancia(Coordenada origen, Coordenada destino) {
		int xOrigen = origen.getX();
		int yOrigen = origen.getY();
		int xDestino = xOrigen - destino.getX();
		int yDestino = yOrigen - destino.getY();
		int distancia = (int) Math.sqrt(xDestino * xDestino + yDestino * yDestino);
		return distancia;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Juego getJuego() {
		return juego;
	}
}
