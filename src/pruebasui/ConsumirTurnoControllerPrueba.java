package pruebasui;

import javax.swing.JPanel;

import control.Juego;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import utiles.Utiles;
import vista.FichaBatallon;
import vista.FichaCastillo;

public class ConsumirTurnoControllerPrueba {
	private Juego juego;
	private JPanel panel;

	public ConsumirTurnoControllerPrueba(Juego juego) {
		super();
		this.juego = juego;
		colocarBatallones();
	}

	private void colocarBatallones() {
		int posicionesX[] = { 1, 2, 3, 1, 3, 4 };
		int posicionesY[] = { 5, 4, 5, 6, 6, 7 };
		for (int i = 0; i < posicionesY.length; i++) {
			juego.localizarBatallon(new Coordenada(posicionesX[i], posicionesY[i]));
		}

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
		// Si la casilla a la que quiero mover est� vac�a
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
	public Tablero getTablero() {
		return juego.getTablero();
	}
}
