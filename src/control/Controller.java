package control;

import java.util.LinkedList;
import java.util.List;

import modelo.Batallon;
import modelo.Coordenada;
import modelo.Ejercito;
import modelo.Soldado;
import vista.info.EspecificacionSoldadosInfo;

public class Controller {
	private Juego juego;

	public Controller(Juego juego) {
		super();
		this.juego = juego;
	}

	public Juego getJuego() {
		return juego;
	}

	public boolean localizar(Coordenada coordenada) {
		return juego.localizarBatallon(coordenada);
	}

	public void poblarBatallon(List<EspecificacionSoldadosInfo> especificacion) {
		assert especificacion != null;
		int idEjercitoActual = juego.getIdEjercitoActual();
		Ejercito ejercitoActual = getEjercitos().get(idEjercitoActual);
		Batallon batallon = ejercitoActual.getBatallonActual();
		for (EspecificacionSoldadosInfo especificacionSoldadosInfo : especificacion) {
			for (int i = 0; i < especificacionSoldadosInfo.getCantidad(); i++) {
				batallon.alistarSoldado(new Soldado(especificacionSoldadosInfo.getEspecialidad()));
			}
		}

	}

	public LinkedList<Ejercito> getEjercitos() {
		return juego.getEjercitos();
	}

}
