package pruebasui;

import control.Juego;
import modelo.Dimension;
import vista.info.TableroUIInfo;

public class ParaUIConsumirTurnoPrueba extends UIConsumirTurnoPrueba {
	private ConsumirTurnoControllerPrueba consumirTurnoControllerPrueba;

	public ParaUIConsumirTurnoPrueba() {
		super();
		Dimension dimension = new Dimension(12,7);
		Juego juego = new Juego(dimension);
		consumirTurnoControllerPrueba = new ConsumirTurnoControllerPrueba(juego);
		crearTablero(juego);
		getTableroUI().actualizarTablero(getTableroUIInfo(juego));
	}

	public TableroUIInfo getTableroUIInfo(Juego juego) {
		return new TableroUIInfo(juego);
	}

}
