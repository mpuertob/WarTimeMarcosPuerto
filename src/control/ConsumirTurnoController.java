package control;

import javax.swing.JPanel;

import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vista.FichaBatallon;

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

		// Obtenemos la casilla a donde quiero mover
		Coordenada coordenadaInsertar = Utiles.getCoordenada(destino.getName());
		Casilla casillaDos = tablero.getCasilla(coordenadaInsertar);
		boolean isCastillo = casilla instanceof FichaBatallon;
		// Si la casilla a la que quiero mover está vacía
		// y si la casilla que quiero mover no es un castillo
		if (casillaDos == null && !isCastillo) {
			tablero.borrar(casilla);
			tablero.insertar(casilla, coordenadaInsertar);
		}
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
