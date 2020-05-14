package control;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Ejercito;
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
		if (casillaDos == null) {
			//Si la casilla esta vacia mueve, sino confronta
			Ejercito ejercitoActual = juego.getEjercitoActual();
			Batallon batallon = (Batallon) casilla;
			Tipo tipoBatallon = batallon.getTipo();
			int numeroCasillas = tipoBatallon.getNumeroCasillas();
			boolean isCastillo = casilla instanceof FichaCastillo;
			boolean coordenadaCorrecta = validarCoordenada(coordenadaOrigen, coordenadaDestino, numeroCasillas);
			boolean isEnSuMitad = tablero.isEnSuMitad(ejercitoActual, coordenadaDestino);
			boolean cumpleRequisitos = casillaDos == null && !isCastillo && coordenadaCorrecta && isEnSuMitad;
			if (cumpleRequisitos) {
				moverYpasarTurno(tablero, casilla, coordenadaDestino);
			}
		} else if (casilla instanceof FichaBatallon && casillaDos instanceof FichaBatallon) {
			confrontarBatallon();
		}
	}

	public void confrontarBatallon() {
		// TODO falta hacerlo entero
		System.out.println("Vamos a pelearnos");
	}

	private void moverYpasarTurno(Tablero tablero, Casilla casilla, Coordenada coordenadaInsertar) {
		tablero.borrar(casilla);
		tablero.insertar(casilla, coordenadaInsertar);
		getJuego().siguienteTurno();
	}

	private boolean validarCoordenada(Coordenada coordenada, Coordenada coordenadaInsertar, int numeroCasillas) {
		int xOrigen = coordenada.getX();
		int yOrigen = coordenada.getY();
		boolean respuesta = false;
		for (int i = xOrigen - numeroCasillas; i <= xOrigen + numeroCasillas; i++) {
			for (int j = yOrigen - numeroCasillas; j <= yOrigen + numeroCasillas; j++) {
				Coordenada nuevaCoordenada = new Coordenada(i, j);
				if (nuevaCoordenada.equals(coordenadaInsertar)) {
					respuesta = true;
				}
			}
		}
		return respuesta;
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