package pruebasui;

import control.Juego;
import modelo.Coordenada;

public class ConsumirTurnoControllerPrueba {
	private Juego juego;

	public ConsumirTurnoControllerPrueba(Juego juego) {
		super();
		this.juego = juego;
		colocarBatallones();
	}

	private void colocarBatallones() {
		int posicionesX[]= {1,2,3,1,3,4};
		int posicionesY[]= {5,4,5,6,6,7};
		for (int i = 0; i < posicionesY.length; i++) {
			juego.localizarBatallon(new Coordenada(posicionesX[i], posicionesY[i]));
		}
		
	}
	

}
