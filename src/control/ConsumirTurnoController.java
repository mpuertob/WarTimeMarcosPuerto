package control;

import javax.swing.JPanel;

import modelo.Batallon;
import modelo.Casilla;
import modelo.Coordenada;
import modelo.Tablero;
import modelo.Tipo;
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
		Batallon batallon = (Batallon) casilla;
		Tipo tipoBatallon = batallon.getTipo();
		int numeroCasillas = tipoBatallon.getNumeroCasillas();
		// Obtenemos la casilla a donde quiero mover
		Coordenada coordenadaInsertar = Utiles.getCoordenada(destino.getName());
		Casilla casillaDos = tablero.getCasilla(coordenadaInsertar);
		boolean isCastillo = casilla instanceof FichaBatallon;
		boolean coordenadaCorrecta = validarCoordenada(coordenada, coordenadaInsertar, numeroCasillas);
		// Si la casilla a la que quiero mover está vacía
		// y si la casilla que quiero mover no es un castillo
		if (casillaDos == null && !isCastillo&&coordenadaCorrecta) {
			tablero.borrar(casilla);
			tablero.insertar(casilla, coordenadaInsertar);
		}
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
