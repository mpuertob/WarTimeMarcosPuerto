package control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import modelo.Coordenada;

class ConsumirTurnoControllerTest {

	@Test
	void validarCoordenada() {
		Coordenada coordenadaMia = new Coordenada(2, 2);
		Coordenada[] coordenadas = { new Coordenada(1, 1), new Coordenada(1, 2), new Coordenada(1, 3),
				new Coordenada(2, 1), new Coordenada(2, 3), new Coordenada(3, 1), new Coordenada(3, 2),
				new Coordenada(3, 3), new Coordenada(0, 0) };
		boolean[] resultados = { true, true, true, true, true, true, true, true, false };
		for (int i = 0; i < resultados.length; i++) {
			// Poner a publico la visibilidad del metodo
			// assertEquals(resultados[i],
			// ConsumirTurnoController.validarCoordenada(coordenadaMia, coordenadas[i], 1));
		}
	}

}
