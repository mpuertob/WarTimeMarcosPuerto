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

	public void moverBatallon(JPanel panelBatallon, JPanel destino) {
		// Obtenemos la casilla que quiero mover
		Tablero tablero = juego.getTablero();
		Coordenada coordenada = Utiles.getCoordenada(panelBatallon.getName());
		Casilla casilla = tablero.getCasilla(coordenada);
		if (casilla != null) {
			Ejercito ejercitoActual = juego.getEjercitoActual();
			Batallon batallon = (Batallon) casilla;
			Tipo tipoBatallon = batallon.getTipo();
			int numeroCasillas = tipoBatallon.getNumeroCasillas();
			// Obtenemos la casilla a donde quiero mover
			Coordenada coordenadaInsertar = Utiles.getCoordenada(destino.getName());
			Casilla casillaDos = tablero.getCasilla(coordenadaInsertar);
			boolean isCastillo = casilla instanceof FichaCastillo;
			boolean coordenadaCorrecta = validarCoordenada(coordenada, coordenadaInsertar, numeroCasillas);
			boolean isEnSuMitad = tablero.isEnSuMitad(ejercitoActual, coordenadaInsertar);
			boolean cumpleRequisitos = casillaDos == null && !isCastillo && coordenadaCorrecta && isEnSuMitad;
			if (cumpleRequisitos) {
				moverYpasarTurno(tablero, casilla, coordenadaInsertar);
			}
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
