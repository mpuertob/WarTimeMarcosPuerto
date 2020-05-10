package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.Controller;
import control.Juego;
import modelo.Dimension;
import modelo.Especialidad;
import vista.info.EspecificacionSoldadosInfo;

class PobladorControllerTest {

	@Test
	void testPoblarBatallon() {
		Dimension dimension = new Dimension(6,12);
		Juego juego = new Juego(dimension);
		Controller controller = new Controller(juego);
		Especialidad especialidades[] = { Especialidad.arco, Especialidad.ballesta };
		int mitad = 5;
		ArrayList<EspecificacionSoldadosInfo> lista = new ArrayList<EspecificacionSoldadosInfo>();
		for (int i = 0; i < especialidades.length; i++) {
			lista.add(new EspecificacionSoldadosInfo(especialidades[i].toString(), mitad));
		}
		controller.poblarBatallon(lista);
		int max = 10;
		assertEquals(max, controller.getJuego().getEjercitos().get(juego.getIdEjercitoActual()).getBatallonActual()
				.getCantidadSoldados());
	}

	// si fuera programacion defensiva

	@Test
	void testPoblarBatallonDos() {
		Dimension dimension = new Dimension(6,12);
		Juego juego = new Juego(dimension);
		Controller controller = new Controller(juego);
		Especialidad especialidades[] = { Especialidad.arco, Especialidad.ballesta };
		int fraccion = 4;
		ArrayList<EspecificacionSoldadosInfo> lista = new ArrayList<EspecificacionSoldadosInfo>();
		for (int i = 0; i < especialidades.length; i++) {
			lista.add(new EspecificacionSoldadosInfo(especialidades[i].toString(), fraccion));
		}
		int max = 10;
		lista.add(new EspecificacionSoldadosInfo(Especialidad.espada.toString(), max - fraccion * 2));
		controller.poblarBatallon(lista);
		assertEquals(fraccion * 2, controller.getJuego().getEjercitos().get(juego.getIdEjercitoActual())
				.getBatallonActual().getCantidadSoldados());
	}

}
